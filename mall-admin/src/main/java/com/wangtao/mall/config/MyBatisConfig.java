package com.wangtao.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.wangtao.mall.mapper","com.wangtao.mall.dao"})
public class MyBatisConfig {
}
