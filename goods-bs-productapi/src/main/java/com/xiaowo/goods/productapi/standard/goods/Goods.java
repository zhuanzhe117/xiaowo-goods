package com.xiaowo.goods.productapi.standard.goods;
import java.io.Serializable;
import java.util.List;

/**
 * 商品标品
 * Created by Hannah on 7-2-28.
 */
public class Goods extends Goods_Sku implements Serializable {

//	@ApiModelProperty(value="老商品ID",required=true)
//	private String oldGoodsId;

    private List<Goods_Sku> skus;

	public List<Goods_Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Goods_Sku> skus) {
		this.skus = skus;
	}

//	public String getOldGoodsId() {
//		return oldGoodsId;
//	}

//	public void setOldGoodsId(String oldGoodsId) {
//		this.oldGoodsId = oldGoodsId;
//	}

	@Override
	public String toString() {
		return "Goods{" +
				"skus=" + skus +
				'}';
	}
}
