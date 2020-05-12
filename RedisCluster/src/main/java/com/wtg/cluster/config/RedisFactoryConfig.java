package com.wtg.cluster.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisFactoryConfig {
	 
	@Autowired
	private Environment env;
	
	@Bean
	public RedisConnectionFactory clusterLettuceConnectionFactory() {
		 Map<String, Object> source = new HashMap<String, Object>();
	     source.put("spring.redis.cluster.nodes", env.getProperty("spring.redis.cluster.nodes"));
	     RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
	     return new LettuceConnectionFactory(redisClusterConfiguration);
	}
}
