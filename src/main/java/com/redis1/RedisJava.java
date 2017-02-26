package com.redis1;

import redis.clients.jedis.Jedis;

/**
 * Java使用redis
 * @author dell
 *
 */
public class RedisJava {

	public static void main(String[] args) {
		//连接本地的redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("redis本地服务连接成功！");
		
		//查看服务示范运行
		System.out.println("Server is running:" +jedis.ping());

	}

}
