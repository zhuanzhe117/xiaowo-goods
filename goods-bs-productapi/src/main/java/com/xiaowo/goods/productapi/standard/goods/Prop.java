package com.xiaowo.goods.productapi.standard.goods;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by 谷海燕 on 2017/3/18.
*/
 public class Prop implements Serializable{

	@ApiModelProperty(value="属性Id",required=true)
    private String propId;

    @ApiModelProperty(value="属性名称",required=true)
    private String propName;

    @ApiModelProperty(value="属性key值", required=false)
    private String propKey;
    
    @ApiModelProperty(value="属性值id",required=true)
    private String propValueId;
    
    @ApiModelProperty(value="属性值名称",required=true)
    private String propValueName;
    
    @ApiModelProperty(value="类型[1-多选项,2-下拉选项,3-文本]", required=false)
    private int type;
    
    @ApiModelProperty(value="排序规则", required=false)
    private int sort;

	public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropKey() {
		return propKey;
	}

	public void setPropKey(String propKey) {
		this.propKey = propKey;
	}

	public String getPropValueId() {
		return propValueId;
	}

	public void setPropValueId(String propValueId) {
		this.propValueId = propValueId;
	}

	public String getPropValueName() {
		return propValueName;
	}

	public void setPropValueName(String propValueName) {
		this.propValueName = propValueName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}