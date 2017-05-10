package com.xiaowo.goods.product.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/* =======================================================
 * 小窝
 * 日 期：9/22/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：Mybatis数据源配置
 * ========================================================
 */
@Configuration
public class MyBatisDataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"spring.dataSource.");
    }

    @Bean(name = "writeDataSource")
    @Primary
    public DataSource writeDataSource(){
        HikariConfig datasource = new HikariConfig();
        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
        datasource.setJdbcUrl(propertyResolver.getProperty("writeConfig.url"));
        datasource.setUsername(propertyResolver.getProperty("writeConfig.username"));
        datasource.setPassword(propertyResolver.getProperty("writeConfig.password"));
        datasource.setAutoCommit(false);
        return new HikariDataSource(datasource);
    }

    @Bean(name = "readDataSource")
    public DataSource readDataSource(){
        HikariConfig datasource = new HikariConfig();
        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
        datasource.setJdbcUrl(propertyResolver.getProperty("readConfig.url"));
        datasource.setUsername(propertyResolver.getProperty("readConfig.username"));
        datasource.setPassword(propertyResolver.getProperty("readConfig.password"));
        return new HikariDataSource(datasource);
    }
}
