package com.xiaowo.goods.product.config;

import com.xiaowo.goods.product.mapper.read.BaseReadMapper;
import com.xiaowo.goods.product.mapper.write.BaseWriteMapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* =======================================================
 * 小窝
 * 日 期：9/22/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：mapper接口扫描配置类
 * ========================================================
 */
@Configuration
@AutoConfigureAfter({MyBatisSessionFactoryConfig.class})
public class MyBatisMapperScannerConfig {

    private static Logger logger = LoggerFactory.getLogger(MyBatisMapperScannerConfig.class);

    @Bean(name = "readMapperScannerConfigurer")
    public MapperScannerConfigurer readMapperScannerConfigurer(){
        logger.info("Database Read Scanner File ......");
        MapperScannerConfigurer readMapperScannerConfigurer = new MapperScannerConfigurer();
        readMapperScannerConfigurer.setSqlSessionFactoryBeanName("readSqlSessionFactory");
        readMapperScannerConfigurer.setBasePackage(BaseReadMapper.class.getPackage().getName());
        readMapperScannerConfigurer.setMarkerInterface(BaseReadMapper.class);
        return readMapperScannerConfigurer;
    }

    @Bean(name = "writeMapperScannerConfigurer")
    public MapperScannerConfigurer writeMapperScannerConfigurer(){
        logger.info("Database Write Scanner File ......");
        MapperScannerConfigurer writeMapperScannerConfigurer = new MapperScannerConfigurer();
        writeMapperScannerConfigurer.setSqlSessionFactoryBeanName("writeSqlSessionFactory");
        writeMapperScannerConfigurer.setBasePackage(BaseWriteMapper.class.getPackage().getName());
        writeMapperScannerConfigurer.setMarkerInterface(BaseWriteMapper.class);
        return writeMapperScannerConfigurer;
    }
}
