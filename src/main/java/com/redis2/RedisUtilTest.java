package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisUtilTest {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//����redis������
		jedis = new Jedis("127.0.0.1",6379);
		//Ȩ����֤
		jedis.auth("admin");
	}
	
	@Test
	public void RedisUtilTest(){
		RedisUtil.getJedis().set("newname", "�Ի�����");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}

	

}
