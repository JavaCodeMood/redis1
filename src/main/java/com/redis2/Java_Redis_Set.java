package com.redis2;

import redis.clients.jedis.Jedis;

public class Java_Redis_Set {
	public static void main(String[] args) {
		//���ӱ���redis������
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("redis���������ӳɹ���");
		
		//���
		jedis.sadd("cupSize", "A�ֱ�");
		jedis.sadd("cupSize", "B�ֱ�");
		jedis.sadd("cupSize", "C�ֱ�");
		jedis.sadd("cupSize", "D�ֱ�");
		jedis.sadd("cupSize", "E�ֱ�");
		jedis.sadd("cupSize", "F�ֱ�");
		/*Redis Srem ���������Ƴ������е�һ��������ԱԪ�أ������ڵĳ�ԱԪ�ػᱻ���ԡ�
                      �� key ���Ǽ������ͣ�����һ������
        */
		jedis.srem("cupSize", "F�ֱ�");
		//Redis Smembers ����ؼ����е����еĳ�Ա�� �����ڵļ��� key ����Ϊ�ռ��ϡ�
		System.out.println(jedis.smembers("cupSize"));
		//Redis Sismember �����жϳ�ԱԪ���Ƿ��Ǽ��ϵĳ�Ա�� �ж�F�ֱ��Ƿ���cupSize���ϵ�Ԫ��
		System.out.println(jedis.sismember("cupSize", "F�ֱ�"));
		//Redis Srandmember �������ڷ��ؼ����е�һ�����Ԫ�ء�
		System.out.println(jedis.srandmember("cupSize"));
		//Redis Scard ����ؼ�����Ԫ�ص�������
		System.out.println(jedis.scard("cupSize"));
	}

}
