package com.xiaowo.goods.product.resource;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by 谷海燕 on 2017/3/3.
 */
@Path("/goodsSku")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/goodsSku",description = "标品服务接口",produces = MediaType.APPLICATION_JSON,position = 1)
public class GoodsSkuResource {
}
