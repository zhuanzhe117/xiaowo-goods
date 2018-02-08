package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;
import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
import com.xiaowo.goods.basicapi.brand.pojo.BrandPojo;
import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import com.xiaowo.goods.basicapi.showcategory.pojo.ShowCategoryPojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品标品sku
 * Created by Hannah on 17-2-28.
 */
public class Goods_Sku implements Serializable{

    @ApiModelProperty(value="商品ID",required=false)
    private String goodsId;
    
    @ApiModelProperty(value="商品名称",required=false)
    private String goodsName;

    @ApiModelProperty(value="商品名称查询因子",required=false)
    private List<String> goodsNameFactor;

    @ApiModelProperty(value="sku名称",required=true)
    private String skuName;

    @ApiModelProperty(value="sku名称查询因子",required=true)
    private List<String> skuNameFactor;

    @ApiModelProperty(value="skuID",required=false)
    private String skuId;

    @ApiModelProperty(value="区域",required=true)
    private String saleAreas;

    @ApiModelProperty(value="业态",required=true)
    private BizTypePojo bizType;

    @ApiModelProperty(value="分类",required=true)
    private CategoryPojo category;
    
//    @ApiModelProperty(value="佣金业务",required=true)
//    private CommissionBusinessSubdivide commissionBusinessSubdivide;

//    @ApiModelProperty(value = "违规下架操作日志",required = false)
//    private OperateLog operateLog;

    @ApiModelProperty(value="结佣模式[1:成本价,2:固定比例,3:固定金额]",required=true)
    private String chargeType;
    
    @ApiModelProperty(value="佣金业务选择[1:取供应商佣金设置;2:取商品佣金设置]",required=false)
    private int commissionBusinessType;
    
    @ApiModelProperty(value="商品货号",required=true)
    private String goodsNo;
    
    @ApiModelProperty(value="商品类型[1:虚拟,2:实物]",required=true)
    private String goodsType;

    @ApiModelProperty(value="是否需要发货[1:需要发货,0:不需发货]",required=true)
    private String sendOrNot;

    @ApiModelProperty(value="是否需要展示[1:需要展示,0:不需展示]",required=true)
    private String showOrNot;
    
    @ApiModelProperty(value="是否需要预约[1:非预约,2:预约]",required=true)
    private String goodAppointment;

    @ApiModelProperty(value="属性信息",required=true)
    private List<Prop> props;

    @ApiModelProperty(value="商品图片",required=true)
    private List<GoodsPic> pics;

    @ApiModelProperty(value="图文介绍",required=true)
    private List<Introduce> introduce;

    @ApiModelProperty(value="展示分类",required=true)
    private List<ShowCategoryPojo> showCategories;

    @ApiModelProperty(value="合作模式",required=true)
    private String cooperateMode;
    
//    @ApiModelProperty(value="供应商信息",required=true)
//    private Provider provider;
//
//    @ApiModelProperty(value="发票信息",required=true)
//    private Invoice invoice;

    @ApiModelProperty(value="品牌信息",required=true)
    private BrandPojo brand;

    @ApiModelProperty(value="上下架设置[1:立即上架,2:定时上架,3:放入仓库]",required=true)
    private int publishType;
    
    @ApiModelProperty(value="发布时间",required=false)
    private String publishTime;

    @ApiModelProperty(value="上下架时间",required=false)
    private Date upDownShelfTime;

    @ApiModelProperty(value="seo关键字",required=true)
    private String seoKeyWord;
    
    @ApiModelProperty(value="seo描述",required=true)
    private String seoDescription;
    
    @ApiModelProperty(value="支付方式[1:全额,2:分期,3:定金]",required=true)
    private int paymentMode;
    
    @ApiModelProperty(value="定金金额",required=false)
    private String paymentDeposit;
    
    @ApiModelProperty(value="商品重量",required=false)
    private String goodsWeight;
    
    @ApiModelProperty(value="商品体积",required=false)
    private String goodsVolume;
    
//    @ApiModelProperty(value="运费模板",required=true)
//    private FreightTemplate freightTemplate;

    @ApiModelProperty(value="sku的规格组合",required=true)
    private List<Spec> specs;

    @ApiModelProperty(value="库存",required=true)
    private long stock;

    @ApiModelProperty(value="预警库存",required=true)
    private long warnStock;

    @ApiModelProperty(value="库存单位（如件、个等）",required=true)
    private String stockUnit;

    @ApiModelProperty(value="成本价",required=true)
    private BigDecimal costPrice;

    @ApiModelProperty(value="售价",required=true)
    private BigDecimal sellPrice;

    @ApiModelProperty(value="原价",required=true)
    private BigDecimal originalPrice;

    @ApiModelProperty(value="合作商skuId",required=false)
    private String partnerSkuId;
    
    @ApiModelProperty(value="共享商品信息[1:是;2:否]",required=false)
    private String shareGoodsInfo;
    
    @ApiModelProperty(value="sku状态(删除、未删除)",required=true)
    private int state;

    @ApiModelProperty(value="状态（有效、无效）",required=true)
    private int status;

    @ApiModelProperty(value="审核状态[-1:审核未通过,0:审核中,1:审核通过]",required=true)
    private String checkStatus;

    @ApiModelProperty(value="售卖状态(1.待上架 2.已上架 3.已下架 4.违规下架)",required=true)
    private int salesState;

    @ApiModelProperty(value="发布人Id",required=true)
    private String publisherId;

    @ApiModelProperty(value="发布人姓名",required=true)
    private String publisherName;

    @ApiModelProperty(value="更新时间",required=true)
    private Date updateTime = new Date();

    @ApiModelProperty(value="创建时间",required=true)
    private Date createTime = new Date();

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<String> getGoodsNameFactor() {
        return goodsNameFactor;
    }

    public void setGoodsNameFactor(List<String> goodsNameFactor) {
        this.goodsNameFactor = goodsNameFactor;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public List<String> getSkuNameFactor() {
        return skuNameFactor;
    }

    public void setSkuNameFactor(List<String> skuNameFactor) {
        this.skuNameFactor = skuNameFactor;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSaleAreas() {
        return saleAreas;
    }

    public void setSaleAreas(String saleAreas) {
        this.saleAreas = saleAreas;
    }

    public BizTypePojo getBizType() {
        return bizType;
    }

    public void setBizType(BizTypePojo bizType) {
        this.bizType = bizType;
    }

    public CategoryPojo getCategory() {
        return category;
    }

    public void setCategory(CategoryPojo category) {
        this.category = category;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getCommissionBusinessType() {
        return commissionBusinessType;
    }

    public void setCommissionBusinessType(int commissionBusinessType) {
        this.commissionBusinessType = commissionBusinessType;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getSendOrNot() {
        return sendOrNot;
    }

    public void setSendOrNot(String sendOrNot) {
        this.sendOrNot = sendOrNot;
    }

    public String getShowOrNot() {
        return showOrNot;
    }

    public void setShowOrNot(String showOrNot) {
        this.showOrNot = showOrNot;
    }

    public String getGoodAppointment() {
        return goodAppointment;
    }

    public void setGoodAppointment(String goodAppointment) {
        this.goodAppointment = goodAppointment;
    }

    public String getCooperateMode() {
        return cooperateMode;
    }

    public void setCooperateMode(String cooperateMode) {
        this.cooperateMode = cooperateMode;
    }

    public BrandPojo getBrand() {
        return brand;
    }

    public void setBrand(BrandPojo brand) {
        this.brand = brand;
    }

    public int getPublishType() {
        return publishType;
    }

    public void setPublishType(int publishType) {
        this.publishType = publishType;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Date getUpDownShelfTime() {
        return upDownShelfTime;
    }

    public void setUpDownShelfTime(Date upDownShelfTime) {
        this.upDownShelfTime = upDownShelfTime;
    }

    public String getSeoKeyWord() {
        return seoKeyWord;
    }

    public void setSeoKeyWord(String seoKeyWord) {
        this.seoKeyWord = seoKeyWord;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public int getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(int paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentDeposit() {
        return paymentDeposit;
    }

    public void setPaymentDeposit(String paymentDeposit) {
        this.paymentDeposit = paymentDeposit;
    }

    public String getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(String goodsVolume) {
        this.goodsVolume = goodsVolume;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(long warnStock) {
        this.warnStock = warnStock;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPartnerSkuId() {
        return partnerSkuId;
    }

    public void setPartnerSkuId(String partnerSkuId) {
        this.partnerSkuId = partnerSkuId;
    }

    public String getShareGoodsInfo() {
        return shareGoodsInfo;
    }

    public void setShareGoodsInfo(String shareGoodsInfo) {
        this.shareGoodsInfo = shareGoodsInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getSalesState() {
        return salesState;
    }

    public void setSalesState(int salesState) {
        this.salesState = salesState;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Prop> getProps() {
        return props;
    }

    public void setProps(List<Prop> props) {
        this.props = props;
    }

    public List<GoodsPic> getPics() {
        return pics;
    }

    public void setPics(List<GoodsPic> pics) {
        this.pics = pics;
    }

    public List<Introduce> getIntroduce() {
        return introduce;
    }

    public void setIntroduce(List<Introduce> introduce) {
        this.introduce = introduce;
    }

    public List<ShowCategoryPojo> getShowCategories() {
        return showCategories;
    }

    public void setShowCategories(List<ShowCategoryPojo> showCategories) {
        this.showCategories = showCategories;
    }
}
