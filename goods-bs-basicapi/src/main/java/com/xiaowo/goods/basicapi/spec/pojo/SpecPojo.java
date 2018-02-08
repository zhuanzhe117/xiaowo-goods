package com.xiaowo.goods.basicapi.spec.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：规格实体
 * ========================================================
 */
public class SpecPojo implements Serializable {
    private static final long serialVersionUID = 611845569823552713L;

    @ApiModelProperty(value = "id",required = true)
    private long id;

    @ApiModelProperty(value = "规格名称",required = true)
    private String specName;

    @ApiModelProperty(value = "状态，1-可用，0-删除",required = true)
    private int state;

    @ApiModelProperty(value="创建时间",required=true)
    private Date createTime;

    @ApiModelProperty(value="更新时间",required=true)
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
