package com.redis1;

import redis.clients.jedis.Jedis;

/**
 * Redis String��������
 * @author dell
 *
 */
public class RedisString {

	public static void main(String[] args) {
		//���ӱ���redis����
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis�������ӳɹ���");
		
		//����redis�ַ�������
		jedis.set("type", "string");
		//��ȡ�洢�����ݲ����
		System.out.println("redis�洢��ֵΪ��"+jedis.get("type"));

	}

}
