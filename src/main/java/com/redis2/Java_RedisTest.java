package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * Redis����
 * @author dell
 *
 */
public class Java_RedisTest {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//����redis������
		jedis = new Jedis("127.0.0.1",6379);
		//Ȩ����֤
		//jedis.auth("admin");
	}
	
	@Test
	public void test() throws InterruptedException{
		//jedis����
	    //ע�⣬�˴���rpush��lpush��List�Ĳ�������һ��˫���������ӱ��������ģ�  
        jedis.del("a");   //��������ݣ��ڼ������ݽ��в���
        jedis.rpush("a", "1");
        jedis.rpush("a", "6");
        jedis.rpush("a", "4");
        jedis.rpush("a", "2");
        jedis.rpush("a", "5");
        jedis.rpush("a", "3");
        //����ǰ
        System.out.println("����ǰ��"+jedis.lrange("a", 0, -1));
        //����
        System.out.println("����"+jedis.sort("a"));
		//�����
        System.out.println("�����"+jedis.lrange("a", 0, -1));
	}
}
