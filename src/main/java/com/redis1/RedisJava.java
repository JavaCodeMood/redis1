package com.redis1;

import redis.clients.jedis.Jedis;

/**
 * Javaʹ��redis
 * @author dell
 *
 */
public class RedisJava {

	public static void main(String[] args) {
		//���ӱ��ص�redis����
		Jedis jedis = new Jedis("localhost");
		System.out.println("redis���ط������ӳɹ���");
		
		//�鿴����ʾ������
		System.out.println("Server is running:" +jedis.ping());

	}

}
