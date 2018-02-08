package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by ghy on 17-3-18.
 */
public class Pic implements Serializable{

	@ApiModelProperty(value="图片Id",required=true)
    private String picId;

    @ApiModelProperty(value="是否为主图",required=true)
    private int sort;

    @ApiModelProperty(value="图片描述",required=true)
    private String description;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
