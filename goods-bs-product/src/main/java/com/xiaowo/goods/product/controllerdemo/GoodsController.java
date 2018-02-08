package com.xiaowo.goods.product.controllerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这是个controller的Demo，使用Spring的注解，和Resource Demo是一样的效果
 * Created by 谷海燕 on 2017/2/27.
 */
@RestController
@RequestMapping("/goodsController")
public class GoodsController {
    @Autowired
    MongoTemplate mongoTemplate;
    @RequestMapping("/getGoodsId")
    public String getGoodsId(){
        Goods goods =mongoTemplate.findOne(new Query(Criteria.where("goodsName").is("卡菲纳实木床")),Goods.class,"goods");
        return goods.getGoodsId();
    }
}
