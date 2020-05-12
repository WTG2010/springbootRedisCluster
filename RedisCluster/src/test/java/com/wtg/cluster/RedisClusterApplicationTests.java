package com.wtg.cluster;


import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterApplicationTests {
	
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	@Test
	public void contextLoads() {
		
		redisTemplate.opsForValue().set("dog", "pingping");
		System.out.println(redisTemplate.opsForValue().get("dog"));
		
	}

}
