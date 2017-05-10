package com.xiaowo.goods.basicapi.showcategory.pojo;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：展示分类实体
 * ========================================================
 */
public class ShowCategoryPojo implements Serializable {

    private static final long serialVersionUID = 8977478394298263950L;
    /**
     * 展示类目ID
     */
    private long id;
    /**
     * 展示类目名称
     */
    private String showCategoryName;
    /**
     * 展示类目上级类目ID
     */
    private long pid;
    /**
     * 展示分类等级
     */
    private int level;
    /**
     * 保存本级和所有上级的id 如 1_2_3_
     */
    private String strLevel;
    /**
     * 业态id
     * */
    private Long bizId;
    /**
     * 状态
     */
    private int state;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 分类图片
     */
    private String logo;

    /**
     * 推荐文字
     */
    private String recommContent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShowCategoryName() {
        return showCategoryName;
    }

    public void setShowCategoryName(String showCategoryName) {
        this.showCategoryName = showCategoryName;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getStrLevel() {
        return strLevel;
    }

    public void setStrLevel(String strLevel) {
        this.strLevel = strLevel;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRecommContent() {
        return recommContent;
    }

    public void setRecommContent(String recommContent) {
        this.recommContent = recommContent;
    }
}
