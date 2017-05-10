package com.xiaowo.goods.basicapi.proptype.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：属性类型实体
 * ========================================================
 */
public class PropTypePojo implements Serializable {
    private static final long serialVersionUID = -3848166067453038265L;

    @ApiModelProperty(value = "id",required = true)
    private long id;

    @ApiModelProperty(value = "属性类型名称",required = true)
    private String name;

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
