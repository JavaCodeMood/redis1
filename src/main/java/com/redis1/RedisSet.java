package com.redis1;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Redis set��������
 * @author dell
 *
 */
public class RedisSet {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		//set����������redis���ݿ��������������
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		jedis.set("k3", "v3");
		//get�������ڻ�ȡĳ��������Ӧ��ֵ
		System.out.println(jedis.get("k3"));
		//del��������ɾ��ĳ��������Ӧ��ֵ
		System.out.println(jedis.del("k1"));
		//getSet�����û���ȡĳ��������Ӧ��ֵ���������ڣ�����null�������ڣ����ض�Ӧ��ֵ
		System.out.println(jedis.getSet("k4", "v4"));
		/*getrange(key, startOffset, endOffset)�������ڻ�ȡ������key���ַ��������ַ���
		 �ַ����Ľ�ȡ��Χ��start��end����ƫ��������
		*/
		System.out.println(jedis.getrange("k2", 1, -1));
		//lpop���������Ƴ��������б�ĵ�һ��Ԫ��
		System.out.println(jedis.lpop("k1"));
		//rpop���������Ƴ��������б�����һ��Ԫ��
		System.out.println(jedis.rpop("k5"));
		//���ؼ��ϵĳ���
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());

	}

}
