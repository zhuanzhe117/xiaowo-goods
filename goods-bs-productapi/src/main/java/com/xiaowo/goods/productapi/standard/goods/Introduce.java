package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 图文介绍
 */
public class Introduce implements Serializable {

	@ApiModelProperty(value="图文介绍名称id", required=true)
	private String introduceNameId;
	
	@ApiModelProperty(value="图文介绍名称值", required=true)
	private String introduceNameValue;
	
	@ApiModelProperty(value="商品图片key值", required=false)
    private String introduceKey;
	
	@ApiModelProperty(value="包装清单App端",required=true)
    private String contentAPP;

    @ApiModelProperty(value="详情内容PC端",required=true)
    private String contentPC;
    
    @ApiModelProperty(value="排序规则", required=false)
    private int sort;

	public String getIntroduceNameId() {
		return introduceNameId;
	}

	public void setIntroduceNameId(String introduceNameId) {
		this.introduceNameId = introduceNameId;
	}

	public String getIntroduceNameValue() {
		return introduceNameValue;
	}

	public void setIntroduceNameValue(String introduceNameValue) {
		this.introduceNameValue = introduceNameValue;
	}

	public String getIntroduceKey() {
		return introduceKey;
	}

	public void setIntroduceKey(String introduceKey) {
		this.introduceKey = introduceKey;
	}

	public String getContentAPP() {
		return contentAPP;
	}

	public void setContentAPP(String contentAPP) {
		this.contentAPP = contentAPP;
	}

	public String getContentPC() {
		return contentPC;
	}

	public void setContentPC(String contentPC) {
		this.contentPC = contentPC;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}