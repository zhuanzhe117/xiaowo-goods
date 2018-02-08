package com.xiaowo.goods.basicapi.spec.pojo;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/* =======================================================
 * 小窝
 * 日 期：9/19/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：规格值实体
 * ========================================================
 */
public class SpecValuePojo implements Serializable {
    private static final long serialVersionUID = -3113003056992143203L;

    @ApiModelProperty(value = "id",required = true)
    private long id;

    @ApiModelProperty(value = "规格值",required = true)
    private String optionValue;

    @ApiModelProperty(value = "排序",required = true)
    private int sort;

    @ApiModelProperty(value = "规格id",required = true)
    private long specId;


}
