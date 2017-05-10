package com.xiaowo.goods.basic.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.xiaowo.common.exception.ErrorCode;
import com.xiaowo.common.response.ResponseUtil;
import com.xiaowo.goods.basic.service.CategoryService;
import com.xiaowo.goods.basicapi.category.json.CategoryJson;
import com.xiaowo.goods.basicapi.category.param.CategoryInsertParam;
import com.xiaowo.goods.basicapi.category.param.CategoryListParam;
import com.xiaowo.goods.basicapi.category.param.CategoryUpdateUpScaleParam;
import com.xiaowo.goods.basicapi.category.pojo.CategoryPojo;
import com.xiaowo.goods.basicapi.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/* =======================================================
 * 小窝
 * 日 期：9/30/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：分类服务接口
 * ========================================================
 */
@Path("/category/1.0")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/category/1.0",description = "分类服务接口")
public class CategoryResource {
    private static Logger logger = LoggerFactory.getLogger(CategoryResource.class);

    @Autowired
    private CategoryService categoryService;

    @POST
    @Path("/addCategory")
    @ApiOperation(value = "新增分类接口", httpMethod = "POST", notes = "新增分类接口", position = 1)
    public Response addCategory(CategoryInsertParam categoryInsertParam) {
        try {
            categoryService.insertCategory(categoryInsertParam);
        } catch (Exception e) {
            logger.error("新增分类异常", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(true);
    }

    @POST
    @Path("/deleteCategory")
    @ApiOperation(value = "删除分类接口", httpMethod = "POST", notes = "删除分类接口", position = 2)
    public Response deleteCategory(@ApiParam(value = "分类ID", required = true) @QueryParam("categoryId") long categoryId) {
        String result = null;
        try {
            result = this.categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            logger.error("删除分类异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "删除分类异常");
        }
        return ResponseUtil.getOkResponse(result);
    }

    @POST
    @Path("/updateCategory")
    @ApiOperation(value = "更新分类接口", httpMethod = "POST", notes = "更新分类接口", position = 3)
    public Response updateCategory(CategoryInsertParam param) {
        try {
            this.categoryService.updateCategory(param);
        } catch (Exception e) {
            logger.error("更新分类异常", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(true);
    }

    @POST
    @Path("/getCategoryList")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据业态查询分类列表或查询全部分类列表接口", httpMethod = "POST", notes = "根据业态查询分类列表或查询全部分类列表接口", position = 2)
    public Response getCategoryList(CategoryListParam categoryListParam) {
        Pagination page = null;
        try {
            page = this.categoryService.getCategoryList(categoryListParam);
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "查询分类列表异常");
        }
        return ResponseUtil.getOkResponse(page);
    }

    @POST
    @Path("/getCategoryListByName")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "根据分类名称模糊搜索分类列表接口", httpMethod = "POST", notes = "根据分类名称模糊搜索分类列表接口", position = 7)
    public Response getCategoryListByName(CategoryListParam param) {
        Pagination page;
        try {
            page = this.categoryService.getCategoryListByName(param);
        } catch (Exception e) {
            logger.error("根据分类名称模糊搜索分类列表异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据分类名称模糊搜索分类列表异常");
        }
        return ResponseUtil.getOkResponse(page);
    }

    @GET
    @Path("/{categoryId}")
    @ApiOperation(value = "查询分类详情", httpMethod = "GET", notes = "查询分类详情", position = 3)
    public Response getCategoryDetail(@ApiParam(value = "分类ID", required = true) @PathParam("categoryId") long categoryId) {
        CategoryPojo categoryPojo = null;
        try {
            categoryPojo = this.categoryService.getCategoryById(categoryId);
        } catch (Exception e) {
            logger.error("查询分类详情异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "查询分类详情异常");
        }
        return ResponseUtil.getOkResponse(categoryPojo);
    }

    @POST
    @Path("/updateUpScale")
    @ApiOperation(value = "更新京东商品价格上调比例", httpMethod = "POST", notes = "更新京东商品价格上调比例", position = 4)
    public Response updateUpScale(CategoryUpdateUpScaleParam categoryUpdateUpScaleParam) {
        try {
            this.categoryService.updateUpScale(categoryUpdateUpScaleParam.getUpScale(),categoryUpdateUpScaleParam.getId());
        } catch (Exception e) {
            logger.error("更新分类异常", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(true);
    }

    @GET
    @Path("/getCategoryByPid")
    @ApiOperation(value = "根据pid查询分类接口", httpMethod = "GET", notes = "根据pid查询分类接口", position = 6)
    public Response getCategoryByPid(@ApiParam(value = "分类ID", required = true) @QueryParam("pid") long pid) {
        List<CategoryJson> categoryJsons = null;
        try {
            categoryJsons = this.categoryService.getCategoryByPid(pid);
        } catch (Exception e) {
            logger.error("查询分类异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "查询分类异常");
        }
        return ResponseUtil.getOkResponse(categoryJsons);
    }

    /**
     * 查询该分类 以及所有子分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GET
    @Path("/getCategoryAndChildsById")
    @ApiOperation(value = "【对外接口：营销中心】根据id查询该分类 以及所有子分类接口", httpMethod = "GET", notes = "【对外接口：营销中心】根据id查询该分类 以及所有子分类接口", position = 7)
    public Response getCategoryAndChildsById(@ApiParam(value = "分类ID", required = true) @QueryParam(value = "id") long id) {
        List<CategoryJson> categoryJsons = null;
        try {
            categoryJsons = this.categoryService.getCategoryAndChildsById(id);
        } catch (Exception e) {
            logger.error("根据id查询该分类 以及所有子分类接口异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据id查询该分类 以及所有子分类接口异常");
        }
        return ResponseUtil.getOkResponse(categoryJsons);
    }

    @GET
    @Path("/getCategoryByBizId")
    @ApiOperation(value = "【对外接口：营销中心】根据业态查询 一级分类接口", httpMethod = "GET", notes = "【对外接口：营销中心】根据业态查询 一级分类接口", position = 8)
    public Response getCategoryByBizId(@ApiParam(value = "业态ID", required = true) @QueryParam(value = "id") long id) throws Exception {
        List<CategoryJson> categoryJsons = null;
        try {
            categoryJsons = this.categoryService.getCategoryByBizId(id);
        } catch (Exception e) {
            logger.error("根据业态查询 一级分类接口异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据业态查询 一级分类接口异常");
        }
        return ResponseUtil.getOkResponse(categoryJsons);
    }

    @GET
    @Path("/getAllCategoryByBizId")
    @ApiOperation(value = "根据业态查询所有分类接口", httpMethod = "GET", notes = "根据业态查询所有分类接口", position = 9)
    public Response getAllCategoryByBizId(@ApiParam(value = "业态ID", required = true) @QueryParam(value = "bizId") long bizId) throws Exception {
        List<CategoryPojo> categoryPojos;
        try {
            categoryPojos = this.categoryService.getAllCategoryByBizId(bizId);
        } catch (Exception e) {
            logger.error("根据业态查询所有分类接口异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据业态查询所有分类接口异常");
        }
        return ResponseUtil.getOkResponse(categoryPojos);
    }

}
