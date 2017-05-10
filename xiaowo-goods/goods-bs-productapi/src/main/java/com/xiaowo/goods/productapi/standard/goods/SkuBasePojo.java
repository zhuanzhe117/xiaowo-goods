package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ghy on 17-3-18.
 */
public class SkuBasePojo implements Serializable {

    private static final long serialVersionUID = 66437403552765151L;

    @ApiModelProperty(value="skuID",required=true)
    private String skuId;

    @ApiModelProperty(value="商品ID",required=true)
    private String goodsId;

    @ApiModelProperty(value="库存",required=true)
    private long stock;

    @ApiModelProperty(value="预警库存",required=true)
    private long warnStock;

    @ApiModelProperty(value="库存单位（如件、个等）",required=true)
    private String stockUnit;

    @ApiModelProperty(value="成本价",required=true)
    private BigDecimal costPrice;

    @ApiModelProperty(value="售价",required=true)
    private BigDecimal sellPrice;

    @ApiModelProperty(value="原价",required=true)
    private BigDecimal originalPrice;

    @ApiModelProperty(value="售出数量",required=true)
    private long salesNumber;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(long warnStock) {
        this.warnStock = warnStock;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public long getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(long salesNumber) {
        this.salesNumber = salesNumber;
    }
}
