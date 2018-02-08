package com.xiaowo.goods.basicapi.category.json;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类出参实体
 * ========================================================
 */
public class CategoryJson implements Serializable {
    private static final long serialVersionUID = -7443367669797011542L;

    @ApiModelProperty(value = "分类id", required = true)
    private long id;

    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;

    @ApiModelProperty(value = "父类id", required = true)
    private long pid;

    @ApiModelProperty(value = "业态id", required = true)
    private long bizId;

    @ApiModelProperty(value = "业态名称", required = true)
    private String bizName;

    @ApiModelProperty(value = "分类级别", required = true)
    private int level;

    @ApiModelProperty(value = "各父类id字符串", required = true)
    private String strLevel;

    @ApiModelProperty(value = "分类是否有子节点", required = true)
    private boolean isParent;

    @ApiModelProperty(value = "分类是否已被关联", required = true)
    private boolean checked = false;

    @ApiModelProperty(value = "分类是否可选", required = true)
    private boolean noCheck = false;

    @ApiModelProperty(value = "节点是否打开", required = true)
    private boolean open = false;

    @ApiModelProperty(value = "京东协议价格上调比例（京东商品价格乘以该比例加上京东商品价格等于最终的销售价格，如：10%，请填写1.1。必须大于等于1）", required = true)
    private double upScale;

    public double getUpScale() {
        return upScale;
    }

    public void setUpScale(double upScale) {
        this.upScale = upScale;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

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

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getStrLevel() {
        return strLevel;
    }

    public void setStrLevel(String strLevel) {
        this.strLevel = strLevel;
    }

    public boolean isNoCheck() {
        return noCheck;
    }

    public void setNoCheck(boolean noCheck) {
        this.noCheck = noCheck;
    }
}
