package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by ghy on 17-6-21.
 */
public class Sku implements Serializable {

    @ApiModelProperty(value = "skuId", required = true)
    private String skuId;

    @ApiModelProperty(value = "sku名称", required = true)
    private String skuName;

    @ApiModelProperty(value = "SKU排序", required = true)
    private Integer sort;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
