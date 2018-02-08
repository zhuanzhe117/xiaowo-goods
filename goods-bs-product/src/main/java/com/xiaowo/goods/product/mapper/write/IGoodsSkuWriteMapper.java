package com.xiaowo.goods.product.mapper.write;

import com.xiaowo.goods.productapi.standard.goods.SkuBasePojo;

/**
 * Created by 谷海燕 on 2017/3/18.
 */
public interface IGoodsSkuWriteMapper extends BaseWriteMapper {
    /**
     * 新增SKU信息
     *
     * @return
     * @throws Exception
     */
    void insertSkuBase(SkuBasePojo skuBasePojo);

//    int updateSkuBaseById(@Param("skuId") String skuId, @Param("salesNumber") Long salesNumber);
//
//    void updatePriceBySkuId(String skuId, BigDecimal sellPrice);
//
//    void updateSkuBase(SkuBasePojo skuBasePojo);

    /**
     * 修复佣金比例临时
     *
     * @param skuId
     * @param costPrice
     */
//    void updateCostPrice(@Param("skuId") String skuId, @Param("costPrice") BigDecimal costPrice);

    /**
     * 更新原价
     * @param skuId
     * @param originalPrice
     */
//    void updateOriginalPricePriceBySkuId(String skuId, BigDecimal originalPrice);
}
