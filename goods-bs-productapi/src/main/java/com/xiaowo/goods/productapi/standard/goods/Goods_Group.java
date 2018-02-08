package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;
import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import com.xiaowo.goods.basicapi.showcategory.pojo.ShowCategoryPojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ghy on 17-3-18.
 */

public class Goods_Group implements Serializable {

    @ApiModelProperty(value = "商品组合ID", required = true)
    private String goodsGroupId;

    @ApiModelProperty(value = "商品组合名称", required = true)
    private String goodsGroupName;

    @ApiModelProperty(value = "分类", required = true)
    private CategoryPojo category;

    @ApiModelProperty(value="业态",required=true)
    private BizTypePojo bizType;

    @ApiModelProperty(value = "sku_group", required = true)
    private List<Sku_Group> sku_groups;

    @ApiModelProperty(value = "展示分类", required = true)
    private List<ShowCategoryPojo> showCategories;

    @ApiModelProperty(value = "[0:无效,1:有效]", required = true)
    private String status;

    @ApiModelProperty(value = "[0:删除,1:未删除]", required = true)
    private String state;

    @ApiModelProperty(value = "发布人Id", required = true)
    private String publisherId;

    @ApiModelProperty(value = "发布人姓名", required = true)
    private String publisherName;

    @ApiModelProperty(value = "规格组合", required = true)
    private List<Spec> specs;

    @ApiModelProperty(value = "发布时间", required = true)
    private Date publishTime;

    @ApiModelProperty(value = "更新时间", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    public CategoryPojo getCategory() {
        return category;
    }

    public void setCategory(CategoryPojo category) {
        this.category = category;
    }

    public void setBizType(BizTypePojo bizType) {
        this.bizType = bizType;
    }

    public List<ShowCategoryPojo> getShowCategories() {
        return showCategories;
    }

    public void setShowCategories(List<ShowCategoryPojo> showCategories) {
        this.showCategories = showCategories;
    }

    public String getGoodsGroupId() {
        return goodsGroupId;
    }

    public void setGoodsGroupId(String goodsGroupId) {
        this.goodsGroupId = goodsGroupId;
    }

    public String getGoodsGroupName() {
        return goodsGroupName;
    }

    public void setGoodsGroupName(String goodsGroupName) {
        this.goodsGroupName = goodsGroupName;
    }

    public List<Sku_Group> getSku_groups() {
        return sku_groups;
    }

    public void setSku_groups(List<Sku_Group> sku_groups) {
        this.sku_groups = sku_groups;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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
}
