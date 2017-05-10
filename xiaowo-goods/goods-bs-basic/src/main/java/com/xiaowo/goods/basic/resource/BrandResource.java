package com.xiaowo.goods.basic.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.xiaowo.common.exception.ErrorCode;
import com.xiaowo.common.response.ResponseUtil;
import com.xiaowo.goods.basic.service.BrandService;
import com.xiaowo.goods.basicapi.brand.param.BrandInsertParam;
import com.xiaowo.goods.basicapi.brand.param.BrandListParam;
import com.xiaowo.goods.basicapi.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/* =======================================================
 * 小窝
 * 日 期：10/9/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：品牌服务接口
 * ========================================================
 */
@Path("/brand/1.0")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/brand/1.0", description = "品牌服务接口", produces = MediaType.APPLICATION_JSON,position = 4)
public class BrandResource {

	private static Logger logger = LoggerFactory.getLogger(BrandResource.class);

	@Autowired
	private BrandService brandService;

	@POST
	@Path("/addBrand")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "新增品牌服务接口", httpMethod = "POST", notes = "新增品牌服务接口", position = 1)
	public Response addBrand(BrandInsertParam brandInsertParam) {
		try {
			this.brandService.insertBrand(brandInsertParam);
		} catch (Exception e) {
			logger.error("新增品牌服务异常", e);
			return ResponseUtil.getOkResponse(false);
		}
		return ResponseUtil.getOkResponse(true);
	}

	@POST
	@Path("/deleteBrand")
	@ApiOperation(value = "删除品牌服务接口", httpMethod = "POST", notes = "删除品牌服务接口", position = 2)
	public Response delBrand(@ApiParam(value = "品牌ID", required = true) @QueryParam("brandId") long brandId) {
		String message = null;
		try {
			message = this.brandService.deleteByBrandId(brandId);
		} catch (Exception e) {
			logger.error("删除品牌服务异常", e);
			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "删除品牌服务异常");
		}
		return ResponseUtil.getOkResponse(message);
	}

	@POST
	@Path("/updateBrand")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "修改品牌服务接口", httpMethod = "POST", notes = "修改品牌服务接口", position = 3)
	public Response updateBrand(BrandInsertParam param) {
		try {
			this.brandService.updateBrand(param);
		} catch (Exception e) {
			logger.error("修改品牌服务异常", e);
			return ResponseUtil.getOkResponse(false);
		}
		return ResponseUtil.getOkResponse(true);
	}

//	@POST
//	@Path("/getBrandList")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@ApiOperation(value = "查询品牌列表接口", httpMethod = "POST", notes = "查询品牌列表接口", position = 4)
//	public Response getBrandList(BrandListParam brandListParam){
//		Pagination page = null;
//		try {
//			page = this.brandService.getBrandList(brandListParam);
//		} catch (Exception e){
//			logger.error("查询品牌列表异常", e);
//			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "查询品牌列表异常");
//		}
//		return ResponseUtil.getOkResponse(page);
//	}

//	@GET
//	@Path("/detail")
//	@ApiOperation(value = "查询单个品牌服务接口", httpMethod = "GET", notes = "查询单个品牌服务接口", position = 5)
//	public Response getBrandById(@ApiParam(value = "品牌ID", required = true) @QueryParam("brandId") long brandId) {
//		BrandDetailJson brandDetailJson = null;
//		try {
//			brandDetailJson = this.brandService.getBrandById(brandId);
//		} catch (Exception e) {
//			logger.error("查询单个品牌服务异常", e);
//			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "查询单个品牌服务异常");
//		}
//		return ResponseUtil.getOkResponse(brandDetailJson);
//	}

//	@GET
//	@Path("/getEditCategorys")
//	@ApiOperation(value = "根据品牌ID查询相关联的分类", httpMethod = "GET", notes = "根据品牌ID查询相关联的分类", position = 6)
//	public Response getEditCategorys(@ApiParam(value = "父分类ID", required = true) @QueryParam("pid") long pid,
//											@ApiParam(value = "品牌ID", required = true) @QueryParam("brandId") long brandId){
//		List<CategoryJson> categoryJsons;
//		try {
//			categoryJsons = this.brandService.getEditCategorys(pid, brandId);
//		} catch (Exception e) {
//			logger.error("根据品牌ID查询相关联的分类异常", e);
//			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据品牌ID查询相关联的分类异常");
//		}
//		return ResponseUtil.getOkResponse(categoryJsons);
//	}
//
//	@GET
//	@Path("/getBrandsByCategoryId")
//	@ApiOperation(value = "根据分类ID查询所有品牌", httpMethod = "GET", notes = "根据分类ID查询所有品牌", position = 7)
//	public Response getBrandsByCategoryId(@ApiParam(value = "分类ID", required = true) @QueryParam("categoryId") long categoryId){
//		List<BrandListJson> brandListJsons;
//		try {
//			brandListJsons = this.brandService.getBrandsByCategoryId(categoryId);
//		} catch (Exception e) {
//			logger.error("根据分类ID查询所有品牌异常", e);
//			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据分类ID查询所有品牌异常");
//		}
//		return ResponseUtil.getOkResponse(brandListJsons);
//	}
//
//	@GET
//	@Path("/getBrandsByName")
//	@ApiOperation(value = "根据品牌名称模糊查询品牌", httpMethod = "GET", notes = "根据品牌名称模糊查询品牌", position = 8)
//	public Response getbrandsByName(@ApiParam(value = "品牌名称", required = true) @QueryParam("brandName") String brandName){
//		List<BrandListJson> brandListJsons;
//		try {
//			brandListJsons = this.brandService.getBrandsByName(brandName);
//		} catch (Exception e) {
//			logger.error("根据品牌名称模糊查询品牌异常", e);
//			return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据品牌名称模糊查询品牌异常");
//		}
//		return ResponseUtil.getOkResponse(brandListJsons);
//	}
}

