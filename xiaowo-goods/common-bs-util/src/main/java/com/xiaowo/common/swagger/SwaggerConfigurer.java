package com.xiaowo.common.swagger;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jersey.JerseyApiReader;
import com.wordnik.swagger.model.ApiInfo;
import com.wordnik.swagger.reader.ClassReaders;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/* =======================================================
 * 小窝
 * 日 期：9/21/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：swagger封装类
 * ========================================================
 */
public class SwaggerConfigurer extends WebMvcConfigurerAdapter{
    public SwaggerConfigurer() {
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/**"}).addResourceLocations(new String[]{"classpath:/static/", "classpath:/templates/", "classpath:/META-INF/resources/webjars/"});
        super.addResourceHandlers(registry);
    }

    public static void initSwagger(String title, String description) {
        SwaggerConfig config = ConfigFactory.config();
        config.setBasePath("/v1");
        config.setApiVersion("1.0.0");
        config.setApiInfo(new ApiInfo(title, "<a href=\"/api\">" + description + "</a>", (String)null, (String)null, (String)null, (String)null));
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new JerseyApiReader());
    }
}
