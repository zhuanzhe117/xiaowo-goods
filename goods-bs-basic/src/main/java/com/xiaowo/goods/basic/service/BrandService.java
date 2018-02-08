package com.xiaowo.goods.basic.service;

import com.xiaowo.goods.basic.mapper.read.IBrandReadMapper;
import com.xiaowo.goods.basic.mapper.write.IBrandWriteMapper;
import com.xiaowo.goods.basicapi.brand.param.BrandInsertParam;
import com.xiaowo.goods.basicapi.brand.param.BrandListParam;
import com.xiaowo.goods.basicapi.brand.pojo.BrandPojo;
import com.xiaowo.goods.basicapi.category.json.CategoryJson;
import com.xiaowo.goods.basicapi.util.Constant;
import com.xiaowo.goods.basicapi.util.PageUtil;
import com.xiaowo.goods.basicapi.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：品牌业务逻辑
 * ========================================================
 */
@Service
public class BrandService {

    private static Logger log = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    private IBrandWriteMapper brandWriteMapper;

    @Autowired
    private IBrandReadMapper brandReadMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增品牌
     *
     * @param brandInsertParam
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBrand(BrandInsertParam brandInsertParam) throws Exception {
        BrandPojo brandPojo = new BrandPojo();
        BeanUtils.copyProperties(brandInsertParam, brandPojo);
        brandPojo.setState(1);
        brandPojo.setCreateTime(new Date());
        brandPojo.setUpdateTime(new Date());
        this.brandWriteMapper.insertBrand(brandPojo);
        long brandId = brandPojo.getId();
        if (brandId > 0) {
            // 保存品牌和展示分类的关联关系
            String categoryIds = brandInsertParam.getCategoryIds();
            insertCategoryBrand(categoryIds, brandId);
        }
        log.debug("新增品牌成功");
    }



    /**
     * 根据品牌ID查询相关联的分类ID
     *
     * @param brandId
     * @return
     * @throws Exception
     */
    public List<Long> getCategoryIdsByBrandId(long brandId) throws Exception {
        return this.brandReadMapper.getCategoryIdsByBrandId(brandId);
    }



    /**
     * 删除品牌
     *
     * @param brandId
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public String deleteByBrandId(long brandId) throws Exception {
        String message = "品牌删除成功";
        Query query = new Query();
        query.addCriteria(Criteria.where("brand.brandId").is(brandId));
        // 判断是否有商品和品牌关联
        long goodsCount=mongoTemplate.count(query, Constant.MongoTable.GOODS.toString());
        if(goodsCount>0){
            message="该品牌已经有关联信息，不能删除";
            return message;
        }
        // 判断是否有sku和品牌关联
        long skuCount=mongoTemplate.count(query, Constant.MongoTable.GOODS_SKU.toString());
        if(skuCount>0){
            message="该品牌已经有关联信息，不能删除";
            return message;
        }

        this.brandWriteMapper.deleteCategoryBrandByBrandId(brandId);
        this.brandWriteMapper.deleteBrandById(brandId);
        return message;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateBrand(BrandInsertParam param) throws Exception {
        // 先更新品牌信息
        BrandPojo brandPojo = new BrandPojo();
        BeanUtils.copyProperties(param, brandPojo);
        brandPojo.setUpdateTime(new Date());
        this.brandWriteMapper.updateBrand(brandPojo);

        //再更新品牌、分类的关联信息
        long brandId = brandPojo.getId();
        this.brandWriteMapper.deleteCategoryBrandByBrandId(brandId); // 删除旧的关联ID

        // 保存品牌和展示类目的关联关系
        String categoryIds = param.getCategoryIds();
        insertCategoryBrand(categoryIds, brandId);
    }

    /**
     * 获取编辑页面的分类
     *
     * @param pid
     * @param brandId
     * @return
     * @throws Exception
     */
    public List<CategoryJson> getEditCategorys(long pid, long brandId) throws Exception {
        List<CategoryJson> categoryJsons = this.categoryService.getCategoryByPid(pid);
        List<Long> categoryIds = this.getCategoryIdsByBrandId(brandId);
        if (null != categoryIds && categoryIds.size() > 0) {
            List<CategoryJson> childCategorys = new ArrayList<CategoryJson>();
            if (null != categoryJsons && categoryJsons.size() > 0) {
                for (CategoryJson categoryJson : categoryJsons) {
                    getChildCategory(categoryIds, categoryJson, childCategorys);
                }
                categoryJsons.addAll(childCategorys);
            }

        }
        return categoryJsons;
    }

    /**
     * 递归查找所有的子分类
     *
     * @param categoryIds    品牌关联的所有分类ID
     * @param categoryJson
     * @param childCategorys 保存所有要一次性展开的
     */
    public void getChildCategory(List<Long> categoryIds, CategoryJson categoryJson, List<CategoryJson> childCategorys) throws Exception {
        // 所有后代分类的ID
        List<Long> childCategoryIds = this.brandReadMapper.getClildCategoryIdsByCategoryId(categoryJson.getId());
        // 删除当前分类
        if(childCategoryIds.contains(categoryJson.getId())) childCategoryIds.remove(categoryJson.getId());

        if(categoryIds.contains(categoryJson.getId())){ // 当前分类已选
            categoryJson.setChecked(true);
            for(Long childId : childCategoryIds){
                // 后代分类已选
                if(categoryIds.contains(childId)){
                    categoryJson.setOpen(true);
                    // 如果当前节点状态为打开，则继续寻找下级节点
                    getCategoryChilds(categoryJson.getId(), categoryIds, childCategorys);
                    break;
                }
            }
        } else { // 当前分类未选
            for(Long childId : childCategoryIds){
                // 后代分类已选
                if(categoryIds.contains(childId)){
                    categoryJson.setOpen(true);
                    // 如果当前节点状态为打开，则继续寻找下级节点
                    getCategoryChilds(categoryJson.getId(), categoryIds, childCategorys);
                    break;
                }
            }
        }
    }

    public void getCategoryChilds(long categoryId, List<Long> categoryIds, List<CategoryJson> childCategorys) throws Exception{
        List<CategoryJson> jsons = this.categoryService.getCategoryByPid(categoryId);
        if(null != jsons && jsons.size() > 0){
            childCategorys.addAll(jsons);
            for(CategoryJson json : jsons){
                getChildCategory(categoryIds, json, childCategorys);
            }
        }
    }

    /**
     * 插入分类和品牌的关联信息
     *
     * @param categoryIds
     * @param brandId
     * @throws Exception
     */
    private void insertCategoryBrand(String categoryIds, long brandId) throws Exception {
        if (null != categoryIds && !"".equals(categoryIds)) {
            String[] ids = categoryIds.split(",");
            // 使用Set进行ID排重
            Set<Long> idSet = new HashSet<Long>();
            for (String idStr : ids) {
                if (!"".equals(idStr)) {
                    long categoryId = Long.parseLong(idStr);
                    // 查询此分类下的所有后代分类
                    List<Long> childIds = this.brandReadMapper.getClildCategoryIdsByCategoryId(categoryId);
                    if (null != childIds && childIds.size() > 0) {
                        idSet.addAll(childIds);
                    }
                }
            }
            for (long categoryId : idSet) {
                this.brandWriteMapper.insertCategoryBrand(categoryId, brandId);
            }
        }
    }
}
