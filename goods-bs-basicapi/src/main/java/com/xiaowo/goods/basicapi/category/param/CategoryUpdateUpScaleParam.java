package com.xiaowo.goods.basicapi.category.param;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：京东商品价格上调修改实体
 * ========================================================
 */
public class CategoryUpdateUpScaleParam implements Serializable {
    private static final long serialVersionUID = 2048088644980355885L;

    @ApiModelProperty(value = "分类id", required = true)
    private long id;

    @ApiModelProperty(value = "京东商品价格上调协议", required = true)
    private double upScale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getUpScale() {
        return upScale;
    }

    public void setUpScale(double upScale) {
        this.upScale = upScale;
    }
}
