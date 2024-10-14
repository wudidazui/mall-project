package com.wangtao.mall.security.config;

import com.wangtao.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@EnableCaching
public class RedisConfig extends BaseRedisConfig {
}
