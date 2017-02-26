package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisUtilTest {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//连接redis服务器
		jedis = new Jedis("127.0.0.1",6379);
		//权限认证
		jedis.auth("admin");
	}
	
	@Test
	public void RedisUtilTest(){
		RedisUtil.getJedis().set("newname", "卧虎藏龙");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}

	

}
