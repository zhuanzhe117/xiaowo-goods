package com.xiaowo.goods.basicapi.brand.param;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：10/10/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：新增品牌实体入参
 * ========================================================
 */
public class BrandInsertParam implements Serializable {
    private static final long serialVersionUID = -3221761738489344494L;

    @ApiModelProperty(value="品牌名称",required=true)
    private String brandName;

    @ApiModelProperty(value="品牌图片",required=true)
    private String brandLogo;

    @ApiModelProperty(value="品牌首字母",required=true)
    private String firstLetter;

    @ApiModelProperty(value="分类ID，以逗号(,)分割",required=true)
    private String categoryIds;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }
}
