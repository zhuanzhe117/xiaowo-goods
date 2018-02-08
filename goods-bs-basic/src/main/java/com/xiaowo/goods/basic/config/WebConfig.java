package com.xiaowo.goods.basic.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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

    @Override
    public void setEnvironment(Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment);
    }
}
