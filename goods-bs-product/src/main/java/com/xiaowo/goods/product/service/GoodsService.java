package com.xiaowo.goods.product.service;

import com.xiaowo.common.generateno.GenerateNoUtil;
//import com.xiaowo.common.participle.ParticipleUtil;
import com.xiaowo.goods.basicapi.showcategory.pojo.ShowCategoryPojo;
import com.xiaowo.goods.basicapi.util.Constant;
import com.xiaowo.goods.product.mapper.write.IGoodsSkuWriteMapper;
import com.xiaowo.goods.productapi.standard.goods.*;
import com.xiaowo.goods.productapi.standard.param.GoodsAddParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 谷海燕 on 2017/3/3.
 */
@Service("goodsService")
public class GoodsService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    GenerateNoUtil generateNoUtil;
    @Autowired
    IGoodsSkuWriteMapper iGoodsSkuWriteMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addProduct(GoodsAddParam goodsAddParam) throws Exception {
        Date date = new Date();

        // 保存商品信息
        Goods goods = goodsAddParam.getGoods();
        String goodsId = generateNoUtil.generateMaxNo(Constant.MongoKey.GOODS.toString());
        //设置商品状态
        goods.setState(1);
        goods.setGoodsId(goodsId);
        /** 分词 保存 goodsName*/
        String goodsName = goods.getGoodsName();
//        if (!StringUtils.isEmpty(goodsName)){
//            List<String> nameList = ParticipleUtil.participleStr(goodsName);
//            if (nameList.size() > 0){
//                goods.setGoodsNameFactor(nameList);
//            }else {
//                nameList = new ArrayList<>();
//                nameList.add(goodsName);
//                goods.setGoodsNameFactor(nameList);
//            }
//        }
        /*String _id = null;
        if (goodsAddParam.getSaleAreas().size() > 0){
            List<SaleArea> areasList = goodsAddParam.getSaleAreas();
            Long[] areaIdArr = new Long[goodsAddParam.getSaleAreas().size()];
            for (int i = 0; i < areasList.size(); i++){
                areaIdArr[i] = areasList.get(i).getAreaId();
            }
            Arrays.sort(areaIdArr);
            String str = "";
            for (Long  areaId : areaIdArr){
                str += areaId+"|";
            }
            _id = DigestUtils.md5Hex(str);
            Query query = new Query(Criteria.where("_id").is(_id));
            SaleAreas saleAreas = mongoTemplate.findOne(query, SaleAreas.class,Constant.MongoTable.GOODS_SKU_SALEAREAS.toString());
            if (null == saleAreas){
                saleAreas = new SaleAreas(_id,areasList);
                mongoTemplate.save(saleAreas, Constant.MongoTable.GOODS_SKU_SALEAREAS.toString());
            }
        }*/
        // 保存sku信息
        List<Goods_Sku> goodsSkus = goodsAddParam.getGoodsSkus();
//        List<Sku_Goods> skus = new ArrayList<Sku_Goods>();
        boolean needCronJon = false; // 标识是否需要添加定时上架任务
        String executionTime = "";
        boolean isSetGoods = false;
        for (Goods_Sku sku : goodsSkus) {
            String skuId = generateNoUtil.generateMaxNo(Constant.MongoKey.GOODS_SKU.toString());
            sku.setGoodsId(goodsId);
            sku.setGoodsName(goods.getGoodsName());
            sku.setSkuNameFactor(goods.getGoodsNameFactor());
            sku.setSkuId(skuId);
//            sku.setSaleAreas(_id);
            sku.setState(1);
//			sku.setStatus(1);
            sku.setCheckStatus("0");
            //固定比例
            if("2".equals(sku.getChargeType())){
                BigDecimal costPrice = sku.getCostPrice();
                sku.setCostPrice(costPrice.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP));
            }


            if(1 == sku.getPublishType()){ // 立即上架
                sku.setSalesState(2); // 上架状态
            }else if(2 == sku.getPublishType()){ // 定时上架
                sku.setSalesState(1); // 待上架状态
                // 添加定时上架任务
                if(!needCronJon){
                    needCronJon = true;
                    executionTime = sku.getPublishTime();
                }
            }else if(3 == sku.getPublishType()){ // 放入仓库
                sku.setSalesState(1);
            }

            sku.setPublisherId(goods.getPublisherId());
            sku.setPublisherName(goods.getPublisherName());

            //TODO 针对商品图片、属性、图文介绍 按照升序排列
            List<Prop> props = sku.getProps();
            List<GoodsPic> pics = sku.getPics();
            List<Introduce> introduces = sku.getIntroduce();
            if(props != null && props.size() > 0 ) props.sort((a,b) -> a.getSort()-b.getSort());
            if(pics != null && pics.size() > 0) pics.sort((a,b) -> a.getSort()-b.getSort());
            if(introduces != null && introduces.size() > 0) introduces.sort((a,b) -> a.getSort()-b.getSort());
            sku.setProps(props);
            sku.setPics(pics);
            sku.setIntroduce(introduces);
            // 移除掉属性设置 商品图片 品牌信息
            if (goods.getShareGoodsInfo().equals("1")) {
                // 移除掉sku中属性设置 商品图片 品牌信息，将其添加到商品中
                if(!isSetGoods){
                    goods.setProps(sku.getProps());
                    goods.setPics(sku.getPics());
                    goods.setIntroduce(sku.getIntroduce());
                    isSetGoods = true;
                }
                sku.setProps(null);
                sku.setPics(null);
                sku.setIntroduce(null);
            }
            // 如果合作模式是购销,就去掉发票类型
//            if("1".equals(sku.getCooperateMode())){
//                sku.setInvoice(null);
//            }
//            Sku_Goods skuGoods = new Sku_Goods();
//            skuGoods.setSkuId(skuId);
//            skus.add(skuGoods);

            //发送my消息
//            jyGoodsMQ.sendGoodsMq("standard", "sku", skuId);

            // 保存SKU的库存和价格等信息
            SkuBasePojo skuBasePojo = new SkuBasePojo();
            BeanUtils.copyProperties(sku, skuBasePojo);
            skuBasePojo.setGoodsId(goodsId);
            this.iGoodsSkuWriteMapper.insertSkuBase(skuBasePojo);
        }
        goods.setSkus(goodsSkus);
        this.mongoTemplate.save(goods, Constant.MongoTable.GOODS.toString());
        /*if(needCronJon && !"".equals(executionTime)){
            CronJob job = new CronJob();
            String cronJobId=generateNoUtils.generateMaxNo(Constant.MongoKey.CRON_JOB.toString());
            job.setCronJobId(cronJobId);
            job.setStatus(1);
            job.setCreateTime(date);
            job.setGoodsId(goodsId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date d = sdf.parse(executionTime);
            job.setExecutionTime(d);
            mongoTemplate.save(job, Constant.MongoTable.CRON_JOB.toString());
        }*/

        //发送my消息
//        jyGoodsMQ.sendGoodsMq("standard", "goods", goodsId);

        // 保存sku后将商品的SKU信息进行更新
//		Query query = new Query();
//		query.addCriteria(Criteria.where("goodsId").is(goodsId));
//		Update update = new Update();
//		update.set("skus", skus);
//		this.mongoTemplate.updateFirst(query, update, Constant.MongoTable.GOODS.toString());

        // 保存商品组合信息
        Goods_Group goodsGroup = new Goods_Group();
        String groupId = generateNoUtil.generateMaxNo(Constant.MongoKey.GOODS_GROUP.toString());
        // 设置组合基础属性
        goodsGroup.setGoodsGroupId(groupId);
        goodsGroup.setGoodsGroupName(goods.getGoodsName());
        goodsGroup.setCategory(goods.getCategory());
        goodsGroup.setBizType(goods.getBizType());
        goodsGroup.setState("1");
        // 如果商品为不展示,则自动生成的组合自动设置为无效,否则就是有效
        if("0".equals(goods.getSkus().get(0).getShowOrNot())){
            goodsGroup.setStatus("0");
        }else{
            goodsGroup.setStatus("1");
        }

        goodsGroup.setPublisherId(goods.getPublisherId());
        goodsGroup.setPublisherName(goods.getPublisherName());
        List<Spec> specs = goods.getSpecs();
        goodsGroup.setSpecs(specs != null && specs.size() > 0 ? specs : new ArrayList<>());
        goodsGroup.setShowCategories(goodsSkus != null && goodsSkus.size() > 0 ? goodsSkus.get(0).getShowCategories()
                : new ArrayList<ShowCategoryPojo>());
        goodsGroup.setPublishTime(date);
        goodsGroup.setUpdateTime(date);
        goodsGroup.setCreateTime(date);
        // 设置组合SKU以及组合SKU关联的商品SKU信息
        List<Sku_Group> sku_groups = new ArrayList<Sku_Group>();
        for (Goods_Sku sku : goodsSkus) {
            Sku_Group sku_group = new Sku_Group();
            List<Sku> groupSkus = new ArrayList<>();
            Sku s = new Sku();
            s.setSkuId(sku.getSkuId());
            s.setSkuName(sku.getSkuName());
            groupSkus.add(s);
            sku_group.setSkus(groupSkus);
            // 默认为价格最低排序
            sku_group.setMainRole("1");
            sku_group.setSpecs(sku.getSpecs());
            sku_groups.add(sku_group);
        }
        goodsGroup.setSku_groups(sku_groups);
        //发送my消息
//        jyGoodsMQ.sendGoodsMq("standard", "group", groupId);
        this.mongoTemplate.save(goodsGroup, Constant.MongoTable.GOODS_GROUP.toString());
    }
}
