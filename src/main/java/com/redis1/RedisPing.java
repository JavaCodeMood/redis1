package com.redis1;

import redis.clients.jedis.Jedis;

/**
 * Java����redis����,���Ƿ�����
 * @author dell
 *
 */
public class RedisPing {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println(jedis.ping());
	}

}
