package com.xiaowo.goods.basicapi.category.param;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：添加分类时传入参数实体
 * ========================================================
 */
public class CategoryInsertParam implements Serializable {


    private static final long serialVersionUID = -6394025420307568399L;

    @ApiModelProperty(value = "分类id",required = true)
    private long categoryId;

    @ApiModelProperty(value = "分类名称",required = true)
    private String categoryName;

    @ApiModelProperty(value = "业态id",required = true)
    private long bizId;

    @ApiModelProperty(value = "一级分类id")
    private int pid1;

    @ApiModelProperty(value = "二级分类id")
    private int pid2;

    @ApiModelProperty(value = "三级分类id")
    private int pid3;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    public int getPid1() {
        return pid1;
    }

    public void setPid1(int pid1) {
        this.pid1 = pid1;
    }

    public int getPid2() {
        return pid2;
    }

    public void setPid2(int pid2) {
        this.pid2 = pid2;
    }

    public int getPid3() {
        return pid3;
    }

    public void setPid3(int pid3) {
        this.pid3 = pid3;
    }
}
