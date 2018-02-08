package com.xiaowo.goods.basicapi.category.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类实体
 * ========================================================
 */
public class CategoryPojo implements Serializable {
    private static final long serialVersionUID = -6874355404537038860L;
    /**
     *分类id
     */
    private long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 父类id
     */
    private long pid;
    /**
     * 业态id
     */
    private long bizId;
    /**
     * 分类级别
     */
    private int level;
    /**
     * 状态(1有效，0无效)
     */
    private int state;
    /**
     * 分类各父级包括本级字符串，形如 1_2_3_
     */
    private String strLevel;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

    @ApiModelProperty(value = "京东协议价格上调比例（京东商品价格乘以该比例加上京东商品价格等于最终的销售价格，如：10%，请填写1.1。必须大于等于1）", required = true)
    private double upScale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStrLevel() {
        return strLevel;
    }

    public void setStrLevel(String strLevel) {
        this.strLevel = strLevel;
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

    public double getUpScale() {
        return upScale;
    }

    public void setUpScale(double upScale) {
        this.upScale = upScale;
    }
}
