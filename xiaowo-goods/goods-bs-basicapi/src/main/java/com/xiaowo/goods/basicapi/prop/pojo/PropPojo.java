package com.xiaowo.goods.basicapi.prop.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：属性实体
 * ========================================================
 */
public class PropPojo implements Serializable {
    private static final long serialVersionUID = 8590075618203570303L;

    @ApiModelProperty(value="ID",required=true)
    private long id;

    @ApiModelProperty(value="属性参数名称",required=true)
    private String name;

    @ApiModelProperty(value="属性key值",required=true)
    private String propKey;

    @ApiModelProperty(value="属性排序",required=true)
    private int sort;

    @ApiModelProperty(value="属性类型,1-多选项,2-下拉选项,3-文本",required=true)
    private int propType;

    @ApiModelProperty(value="属性类型ID",required=true)
    private long typeId;

    @ApiModelProperty(value="状态，1-有效，0-无效",required=true)
    private int status;

    @ApiModelProperty(value="状态，1-可用，0-删除",required=true)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getPropType() {
        return propType;
    }

    public void setPropType(int propType) {
        this.propType = propType;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
