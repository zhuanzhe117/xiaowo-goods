package com.xiaowo.goods.basic.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.xiaowo.common.exception.ErrorCode;
import com.xiaowo.common.response.ResponseUtil;
import com.xiaowo.goods.basic.service.BizTypeService;
import com.xiaowo.goods.basicapi.biztype.pojo.BizTypePojo;
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
 * 描 述：业态服务接口
 * ========================================================
 */
@Path("/bizType/1.0")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/bizType/1.0",description = "业态服务接口",produces = MediaType.APPLICATION_JSON,position = 1)
public class BizTypeResource {
    private static Logger logger = LoggerFactory.getLogger(BizTypeResource.class);

    @Autowired
    private BizTypeService bizTypeService;

    @POST
    @Path("/addBizType")
    @ApiOperation(value = "新增业态接口", httpMethod = "POST", notes = "新增业态接口", position = 1)
    public Response addBizType(@ApiParam(value = "业态名称", required = true) @QueryParam("bizName") String bizName) {
        try {
            this.bizTypeService.insertBizType(bizName);
        } catch (Exception e) {
            logger.error("新增业态异常", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(true);
    }

    @POST
    @Path("/deleteBizType/{id}")
    @ApiOperation(value = "删除业态接口", httpMethod = "POST", notes = "删除业态接口", position = 2)
    public Response deleteBizType(@ApiParam(value = "业态ID", required = true) @PathParam(value = "id") long id) {
        String message;
        try {
            message = this.bizTypeService.deleteBizTypeById(id);
        } catch (Exception e) {
            logger.error("删除业态异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "删除业态异常");
        }
        return ResponseUtil.getOkResponse(message);
    }

    @POST
    @Path("/updateBizType")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "更新业态接口", httpMethod = "POST", notes = "更新业态接口", position = 3)
    public Response updateBizType(String bizName) {
        try {
            this.bizTypeService.updateBizType(bizName);
        } catch (Exception e) {
            logger.error("更新业态异常", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(true);
    }

    @GET
    @Path("/getBizTypeById/{id}")
    @ApiOperation(value = "根据业态ID查询业态信息", httpMethod = "GET", notes = "根据业态ID查询业态信息", position = 4)
    public Response getBizTypeById(@ApiParam(value = "业态ID", required = true) @PathParam("id") long id) {
        BizTypePojo bizTypePojo;
        try {
            bizTypePojo = this.bizTypeService.getBizTypeById(id);
        } catch (Exception e) {
            logger.error("根据业态ID查询业态信息异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据ID查询业态信息异常");
        }
        return ResponseUtil.getOkResponse(bizTypePojo);
    }

    @GET
    @Path("/getBizTypeByCategoryId")
    @ApiOperation(value = "根据分类ID查询业态信息", httpMethod = "GET", notes = "根据分类ID查询业态信息", position = 5)
    public Response getBizTypeByCategoryId(@ApiParam(value = "分类ID", required = true) @QueryParam("categoryId") long categoryId) {
        BizTypePojo bizTypePojo = null;
        try {
            bizTypePojo = this.bizTypeService.getBizTypeByCategoryId(categoryId);
        } catch (Exception e) {
            logger.error("根据分类ID查询业态信息异常", e);
            return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR.value(), "根据分类ID查询业态信息异常");
        }
        return ResponseUtil.getOkResponse(bizTypePojo);
    }
}
