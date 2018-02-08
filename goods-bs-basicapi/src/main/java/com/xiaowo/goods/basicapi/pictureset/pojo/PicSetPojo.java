package com.xiaowo.goods.basicapi.pictureset.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：图片集实体
 * ========================================================
 */
public class PicSetPojo implements Serializable {
    private static final long serialVersionUID = 3936795742194790421L;

    @ApiModelProperty(value="id",required=true)
    private long id;

    @ApiModelProperty(value="图片集名称",required=true)
    private String name;

    @ApiModelProperty(value="",required=true)
    private String picKey;

    @ApiModelProperty(value="排序",required=true)
    private int sort;

    @ApiModelProperty(value="状态，1-可用，0-删除",required=true)
    private int state;

    @ApiModelProperty(value="更新时间",required=true)
    private Date updateTime;

    @ApiModelProperty(value="创建时间",required=true)
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
}
