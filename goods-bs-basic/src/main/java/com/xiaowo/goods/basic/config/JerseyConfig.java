package com.xiaowo.goods.basic.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/* =======================================================
 * 小窝
 * 日 期：10/2/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：resoure下面的接口自动注册类
 * ========================================================
 */
@Configuration
// 本服务的URI前缀，由统一分配，请勿擅自修改
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // 注册异常处理类和swagger相关Provider
        packages("com.xiaowo.exception.handler", "com.wordnik.swagger.jersey.listing");
        // 注册Resource，约定为上级目录resource下
        String packageName = JerseyConfig.class.getPackage().getName();
        // 所有resource自动扫描，不需要再依次手动添加
        packages(packageName.substring(0, packageName.lastIndexOf(".")) + ".resource");
    }
}
