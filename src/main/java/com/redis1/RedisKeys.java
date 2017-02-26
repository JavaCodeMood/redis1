package com.redis1;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * Redis keysʵ��
 * @author dell
 *
 */
public class RedisKeys {
	public static void main(String[] args) {
		//����redis���ط���
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis���ط������ӳɹ���");
		/*Redis Bgsave ���������ں�̨�첽���浱ǰ���ݿ�����ݵ����̡�
          BGSAVE ����ִ��֮���������� OK ��Ȼ�� Redis fork ��һ�����ӽ��̣�
                       ԭ���� Redis ����(������)��������ͻ������󣬶��ӽ����������ݱ��浽���̣�Ȼ���˳���
        */
		System.out.println(jedis.bgsave());
		//Redis Echo �������ڴ�ӡ�������ַ�����
		System.out.println(jedis.echo("redis"));
		//Redis Flushall ��������������� Redis ������������(ɾ���������ݿ������ key )��
		System.out.println(jedis.flushAll());
		//Redis Flushdb ����������յ�ǰ���ݿ��е����� key��
		System.out.println(jedis.flushDB());
		/*
		 Redis Ping ����ʹ�ÿͻ����� Redis ����������һ�� PING ��������������������Ļ����᷵��һ�� PONG ��
                     ͨ�����ڲ�����������������Ƿ���Ȼ��Ч���������ڲ����ӳ�ֵ��
		 */
		System.out.println(jedis.ping());
		//Redis Info ������һ�����������Ķ��ĸ�ʽ�����ع��� Redis �������ĸ�����Ϣ��ͳ����ֵ��
		System.out.println("\ninfo----->"+jedis.info());
		//Redis RANDOMKEY ����ӵ�ǰ���ݿ����������һ�� key ��
		System.out.println(jedis.randomKey());
		//Redis Save ����ִ��һ��ͬ���������������ǰ Redis ʵ�����������ݿ���(snapshot)�� RDB �ļ�����ʽ���浽Ӳ�̡�
		System.out.println(jedis.save());
		//Redis Unwatch ��������ȡ�� WATCH ��������� key �ļ��ӡ�
		System.out.println(jedis.unwatch());
		/*
		  Redis Multi �������ڱ��һ�������Ŀ�ʼ��
                      ������ڵĶ�������ᰴ���Ⱥ�˳�򱻷Ž�һ�����е��У������ EXEC ����ԭ����(atomic)��ִ�С�
         */
		 
		System.out.println(jedis.multi());
		/*Redis Quit �������ڹر��뵱ǰ�ͻ�����redis��������ӡ�
		һ�����еȴ��еĻظ�(����еĻ�)˳��д�뵽�ͻ��ˣ����Ӿͻᱻ�رա�*/
		System.out.println(jedis.quit());
	}

}
