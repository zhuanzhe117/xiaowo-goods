package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by 谷海燕 on 17-3-18.
 */
public class Spec implements Serializable {

    private static final long serialVersionUID = -608205618157775412L;
    @ApiModelProperty(value = "规格Id", required = true)
    private Long specId;

    @ApiModelProperty(value = "规格名称", required = true)
    private String specName;

    @ApiModelProperty(value = "规格值ID", required = true)
    private Long specValueId;

    @ApiModelProperty(value = "规格值名称", required = true)
    private String specValueName;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Long getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(Long specValueId) {
        this.specValueId = specValueId;
    }

    public String getSpecValueName() {
        return specValueName;
    }

    public void setSpecValueName(String specValueName) {
        this.specValueName = specValueName;
    }
}
