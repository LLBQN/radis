package com.llbqn.springdata.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *   方便redis客户端看信息  不配置(默认的Key序列化器为x    ：JdkSerializationRedisSerializer)这个也可以，
 *   但是使用默认的Key序列化器：看起来不舒服-前面有序列号像乱码一样而已
 */

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    //@Bean :创建的RedisTemplate实例对象，并将其交给Spring容器管理
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        //默认的Key序列化器为：JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setConnectionFactory(connectionFactory);


        return redisTemplate;
    }
}
