package com.xiaowo.goods.product.resource;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.xiaowo.common.response.ResponseUtil;
import com.xiaowo.goods.product.controllerdemo.Goods;
import com.xiaowo.goods.product.service.GoodsService;
import com.xiaowo.goods.productapi.standard.param.GoodsAddParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by 谷海燕 on 2017/2/27.
 */
@Path("/goods")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/goods",description = "标品服务接口",produces = MediaType.APPLICATION_JSON,position = 1)
public class GoodsResource {

    private static final Logger logger = LoggerFactory.getLogger(GoodsResource.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    GoodsService goodsService;

    //这也是一个demo，和spring上面那个controlled是同样的效果
    @GET
    @Path("/getGoods")
    @ApiOperation(value = "demo接口", httpMethod = "GET", notes = "demo接口", position = 1)
    public Response getGoods(){
        Goods goods =mongoTemplate.findOne(new Query(Criteria.where("goodsName").is("卡菲纳实木床")),Goods.class,"goods");
        return Response.ok(goods).type( MediaType.APPLICATION_JSON).build();
    }
    @POST
    @Path("/addGoods")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "发布商品接口", httpMethod = "POST", notes = "发布商品接口", position = 1)
    public Response addGoods(GoodsAddParam goodsAddParam) {
        Boolean flag;
        try {
            goodsService.addProduct(goodsAddParam);
            flag = true;
        } catch (Exception e) {
            logger.error("新增商品服务异常!", e);
            return ResponseUtil.getOkResponse(false);
        }
        return ResponseUtil.getOkResponse(flag);
    }


}
