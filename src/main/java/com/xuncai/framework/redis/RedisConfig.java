package com.xuncai.framework.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory connectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //解决配置序列化
        redisTemplate.setConnectionFactory(connectionFactory);
        //1.解决Key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //2.解决value序列化
       redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        return redisTemplate;
    }
}
