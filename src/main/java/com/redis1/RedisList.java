package com.redis1;

import java.util.List;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

/**
 * redis list��������
 * 
 * @author dell
 *
 */
public class RedisList {

	public static void main(String[] args) {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("redis���ط������ӳɹ���");
		/*
		 * lpush ��ʾ��list��ͷ������Ԫ�� rpush ��ʾ��list��β������Ԫ�� linsert ���б��ĳ��Ԫ��ǰ���ߺ����Ԫ��
		 * index ��ʾ�б���indexλ�õ�Ԫ�� llen �����б�ĳ��� lpop list 0 -1
		 * ��ʾ��mylist�б��ͷ����ʼɾ������Ԫ�� rpop list 0 -1 ��ʾ��mylist�б��β����ʼɾ������Ԫ�� lrange
		 * list 0 -1 //ʹ��lrangeȡ��Ԫ�� 0��ʾ��ͷ����һ��Ԫ�أ�-1��ʾ��β����һ��Ԫ��ȡ����lrange mylist 0
		 * -1 ��ʾȡ��mylist�е���������
		 */
		// �洢���ݵ��б���
		jedis.lpush("SQL", "Redis");
		jedis.lpush("SQL", "Mongodb");
		jedis.lpush("SQL", "Mysql");
		jedis.linsert("SQL", BinaryClient.LIST_POSITION.BEFORE, "MySql", "java");
		jedis.rpush("SQL", "SqlServer");
		jedis.rpush("SQL", "Oracle");

		jedis.linsert("SQL", BinaryClient.LIST_POSITION.BEFORE, "MySql", "java");
		// Redis Lpushx ��һ������ֵ���뵽�Ѵ��ڵ��б�ͷ�����б�����ʱ������Ч��
		System.out.println(jedis.lpushx("SQL", "Redis1"));
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("SQL", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}

		// ����б�ĳ���
		System.out.println("redis�б���Ϊ��" + jedis.llen("SQL"));
		// ɾ���б��е�Ԫ��
		jedis.del("SQL");
		System.out.println("ɾ����redis�б�");
		// ����б�ĳ���
		System.out.println("redis�б���Ϊ��" + jedis.llen("SQL"));
		// �б��±��0��ʼ
		System.out.println("redis�б��±�Ϊ5��Ԫ���ǣ�" + jedis.lindex("SQL", 5));
		/*
		 * Redis Ltrim ��һ���б�����޼�(trim)������˵�����б�ֻ����ָ�������ڵ�Ԫ�أ�����ָ������֮�ڵ�Ԫ�ض�����ɾ���� �±� 0
		 * ��ʾ�б�ĵ�һ��Ԫ�أ��� 1 ��ʾ�б�ĵڶ���Ԫ�أ��Դ����ơ� ��Ҳ����ʹ�ø����±꣬�� -1 ��ʾ�б�����һ��Ԫ�أ� -2
		 * ��ʾ�б�ĵ����ڶ���Ԫ�أ��Դ����ơ�
		 */
		System.out.println(jedis.ltrim("SQL", 0, 4));

	}

}
