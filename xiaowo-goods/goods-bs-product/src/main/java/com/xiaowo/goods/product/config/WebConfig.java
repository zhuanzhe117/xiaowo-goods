package com.xiaowo.goods.product.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/* =======================================================
 * 小窝
 * 日 期：9/22/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：通用配置类，相当于web.xml文件吧
 * ========================================================
 */
@Configuration
public class WebConfig implements EnvironmentAware {

    //解析application.yml文件
    private RelaxedPropertyResolver propertyResolver;

    /**
     * 解决中文内容编码问题，统一用UTF-8
     * @return
     */
    @Bean
    public Filter characterEncodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
    //MongoDB相关
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        ServerAddress serverAddress = new ServerAddress(propertyResolver.getProperty("spring.data.mongodb.host"),
                Integer.parseInt(propertyResolver.getProperty("spring.data.mongodb.port")));
        MongoClientOptions.Builder builder = MongoClientOptions.builder().socketKeepAlive(true)       // 是否保持长链接
                .connectTimeout(5000)   // 链接超时时间
                .socketTimeout(50000)    // read数据超时时间
                .connectionsPerHost(30) // 每个地址最大请求数
                .threadsAllowedToBlockForConnectionMultiplier(50) // 一个socket最大的等待请求数
                .writeConcern(WriteConcern.UNACKNOWLEDGED);

        return new SimpleMongoDbFactory(
                new MongoClient(serverAddress, builder.build()),
                propertyResolver.getProperty("spring.data.mongodb.dbname"));
    }

    //MongoDB相关
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
    @Override
    public void setEnvironment(Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment);
    }
}
