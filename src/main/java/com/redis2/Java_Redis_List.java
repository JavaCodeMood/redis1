package com.redis2;

import redis.clients.jedis.Jedis;

/**
 * redis ����list
 * @author dell
 *
 */
public class Java_Redis_List {

	public static void main(String[] args) {
		//���ӱ���redis������
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("����redis���������ӳɹ���");
		
		//��ʼǰ���Ƴ����е�����
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		//����key java framework�д����������
		//lpush������ʾ���б��ͷ������
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "springMVC");
		jedis.lpush("java framework", "springBoot");
		//��ȡ����������jedis,lrange�ǰ���Χȡ��
		//��һ����key���ڶ�������ʼλ�ã��������ǽ���λ�ã�jedis.llen��ȡ���� -1��ʾȡ������
		System.out.println(jedis.lrange("java framework", 0, -1));
		
		//ɾ��
		jedis.del("java framework");
		//rpush������ʾ���б��β������
		jedis.rpush("java framework", "springData");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
		

	}

}
