package com.xiaowo.goods.basicapi.prop.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：属性值实体
 * ========================================================
 */
public class PropValuePojo implements Serializable{
    private static final long serialVersionUID = -532153186659154569L;

    @ApiModelProperty(value="ID",required=true)
    private long id;

    @ApiModelProperty(value="排序字段",required=true)
    private int sort;

    @ApiModelProperty(value="属性值",required=true)
    private String value;

    @ApiModelProperty(value="属性ID",required=true)
    private long propId;
}
