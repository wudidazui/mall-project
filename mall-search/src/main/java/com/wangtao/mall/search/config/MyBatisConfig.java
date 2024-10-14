package com.wangtao.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger API文档相关配置
 */
@Configuration
@MapperScan({"com.wangtao.mall.mapper","com.wangtao.mall.search.dao"})
public class MyBatisConfig {
}
