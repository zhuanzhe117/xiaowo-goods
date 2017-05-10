package com.xiaowo.goods.basicapi.biztype.pojo;

import java.io.Serializable;
import java.util.Date;

/* =======================================================
 * 小窝
 * 日 期：9/28/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：业态实体（八大业态：家电，家具，家装，家政，新房，二手房，租房,旅行，医疗。。。）
 * ========================================================
 */
public class BizTypePojo implements Serializable {

    private static final long serialVersionUID = -7669969520504481252L;
    /**
     * 业态id
     */
    private long id;
    /**
     *业态名称
     */
    private String bizName;
    /**
     *状态
     */
    private int state;
    /**
     *更新时间
     */
    private Date updateTime;
    /**
     *添加时间
     */
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
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
