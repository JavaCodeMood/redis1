package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * Redis排序
 * @author dell
 *
 */
public class Java_RedisTest {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//连接redis服务器
		jedis = new Jedis("127.0.0.1",6379);
		//权限认证
		//jedis.auth("admin");
	}
	
	@Test
	public void test() throws InterruptedException{
		//jedis排序
	    //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）  
        jedis.del("a");   //先清除数据，在加入数据进行测试
        jedis.rpush("a", "1");
        jedis.rpush("a", "6");
        jedis.rpush("a", "4");
        jedis.rpush("a", "2");
        jedis.rpush("a", "5");
        jedis.rpush("a", "3");
        //排序前
        System.out.println("排序前："+jedis.lrange("a", 0, -1));
        //排序
        System.out.println("排序："+jedis.sort("a"));
		//排序后
        System.out.println("排序后："+jedis.lrange("a", 0, -1));
	}
}
