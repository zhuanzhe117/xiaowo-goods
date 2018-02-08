package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ghy on 17-3-18.
 */
public class Sku_Group implements Serializable {

    @ApiModelProperty(value = "规格组合", required = true)
    private List<Spec> specs;

    @ApiModelProperty(value = "优先展示规则[1:价格最低,2:人工排序]", required = true)
    private String mainRole;

    @ApiModelProperty(value = "商品组合sku组", required = true)
    private List<Sku> skus;

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

}
