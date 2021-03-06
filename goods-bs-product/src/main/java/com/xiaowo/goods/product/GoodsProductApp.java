package com.xiaowo.goods.product;

import com.xiaowo.common.swagger.SwaggerConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/* =======================================================
 * 小窝
 * 日 期：9/20/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：商品标品服务启动类
 * ========================================================
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaowo"})
@ServletComponentScan(basePackages = "com.xiaowo")
public class GoodsProductApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(GoodsProductApp.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        SwaggerConfigurer.initSwagger("小窝-商品后台：标品模块Service","小窝-商品后台：标品模块Service接口");
    }
}
