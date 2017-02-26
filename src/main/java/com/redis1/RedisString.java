package com.redis1;

import redis.clients.jedis.Jedis;

/**
 * Redis String数据类型
 * @author dell
 *
 */
public class RedisString {

	public static void main(String[] args) {
		//连接本地redis服务
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis服务连接成功！");
		
		//设置redis字符串数据
		jedis.set("type", "string");
		//获取存储的数据并输出
		System.out.println("redis存储的值为："+jedis.get("type"));

	}

}
