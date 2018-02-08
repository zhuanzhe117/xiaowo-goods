package com.xiaowo.goods.basicapi.util;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：9/14/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：通用类-分页实体
 * ========================================================
 */
public class Pagination implements Serializable {
    private static final long serialVersionUID = 8212293320602386666L;
    @ApiModelProperty(value="数据列表",required=true)
    private List<?> data;

    @ApiModelProperty(value="当前页",required=true)
    private int pageNo = 1;

    @ApiModelProperty(value="总条数",required=true)
    private long totalCount;

    @ApiModelProperty(value="总页数",required=true)
    private int totalPage;

    @ApiModelProperty(value="每页条数",required=true)
    private int pageSize = 10;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
