/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：商品图片服务接口
 * ========================================================
 */
package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：业态服务接口
 * ========================================================
 */
public class GoodsPic implements Serializable {

	@ApiModelProperty(value="商品图片名称id", required=true)
	private String picNameId;
	
	@ApiModelProperty(value="商品图片名称值", required=true)
	private String picNameValue;
	
	@ApiModelProperty(value="商品图片key值", required=false)
    private String picKey;
	
	@ApiModelProperty(value="上传的商品图片", required=false)
	private List<Pic> pics;
	
	@ApiModelProperty(value="排序规则", required=false)
    private int sort;

	public String getPicNameId() {
		return picNameId;
	}

	public void setPicNameId(String picNameId) {
		this.picNameId = picNameId;
	}

	public String getPicNameValue() {
		return picNameValue;
	}

	public void setPicNameValue(String picNameValue) {
		this.picNameValue = picNameValue;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public List<Pic> getPics() {
		return pics;
	}

	public void setPics(List<Pic> pics) {
		this.pics = pics;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}