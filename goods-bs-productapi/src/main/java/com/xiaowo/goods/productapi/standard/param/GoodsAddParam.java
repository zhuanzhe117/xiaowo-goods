package com.xiaowo.goods.productapi.standard.param;

import com.xiaowo.goods.productapi.standard.goods.Goods;
import com.xiaowo.goods.productapi.standard.goods.Goods_Sku;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 谷海燕 on 2017/3/17.
 */
public class GoodsAddParam implements Serializable {
    private List<Goods_Sku> goodsSkus;

    private Goods goods;

    public List<Goods_Sku> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<Goods_Sku> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

}
