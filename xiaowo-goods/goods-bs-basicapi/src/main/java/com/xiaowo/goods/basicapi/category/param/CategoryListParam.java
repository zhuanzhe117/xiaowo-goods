package com.xiaowo.goods.basicapi.category.param;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public class CategoryListParam implements Serializable {
    @ApiModelProperty(value = "业态id",required = false)
    private long bizId;

    @ApiModelProperty(value = "分类名称",required = false)
    private String categoryName;

    @ApiModelProperty(value = "当前页",required = true)
    private int pageNo;

    @ApiModelProperty(value = "每页条数",required = true)
    private int pageSize;

    @ApiModelProperty(value="查询从第几条开始，客户端忽略此参数",required=false)
    private int currentCount;

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }
}
