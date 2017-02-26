package com.redis2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * redis操作map
 * @author dell
 *
 */
public class Java_Redis_Map {
	public static void main(String[] args) {
		//连接本地redis服务器
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("redis服务器连接成功！");
		
		//添加数据
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "如梦");
		map.put("age", "20");
		map.put("height", "175cm");
		map.put("cupSize", "C罩杯");
		jedis.hmset("user",map);
		//取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
		//第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数  

		List<String> rsmap = jedis.hmget("user", "name","age","height","cupSize");
		System.out.println(rsmap);
		
		//删除map中的某个键值
		jedis.hdel("user", "height");
		System.out.println(jedis.hmget("user", "height")); //因为删除了，所有返回的是null
		 System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2 
		 System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
		 System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
		 System.out.println(jedis.hvals("user"));//返回map对象中的所有value 

		 Iterator<String> iter = jedis.hkeys("user").iterator();
		 while(iter.hasNext()){
			 String key = iter.next();
			 System.out.println(key+":"+jedis.hmget("user", "key"));
		 }
	}

}
