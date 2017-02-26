package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * Java中使用Jedis操作Redis 
 * @author dell
 *
 */
public class Java_Jedis_Redis {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//连接redis服务器
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//权限认证
		jedis.auth("admin");
	}
	
	/**
	 * redis存储字符串
	 */
	@Test
	public void testString(){
		//添加数据  set方法设置值，get方法取出值
		jedis.set("cupSize", "B罩杯");//向key-->cupsize中放入value-->B
	    System.out.println("美女的胸是"+jedis.get("cupSize"));  //执行结果：B罩杯
	    
	    jedis.append("name", "姗姗");  //拼接
	    System.out.println("这个美女叫："+jedis.get("name"));
	    
	    jedis.del("name");  //删除某个键
	    System.out.println(jedis.get("name"));
	    
	    //设置多个键值对
	    jedis.mset("name","姗姗","age","20","cupSize","B罩杯","address","北京");
	    jedis.incr("age");  //进行加1操作
	    System.out.println("美女："+jedis.get("name")+","+jedis.get("age")+"岁,"+"胸是"+jedis.get("cupSize")+"居住地："+jedis.get("address")); 
	}
	
	/*public static void main(String[] args) {
		//Java_Jedis_Redis redis = new Java_Jedis_Redis();
		//redis.testString();
		
		//连接redis服务器
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		//添加数据  set方法设置值，get方法取出值
		jedis.set("cupSize", "B罩杯");//向key-->cupsize中放入value-->B
	    System.out.println("美女的胸是"+jedis.get("cupSize"));  //执行结果：B罩杯
			    
		jedis.append("name", "姗姗");  //拼接
	    System.out.println("这个美女叫："+jedis.get("name"));
			    
	    jedis.del("name");  //删除某个键
	    System.out.println(jedis.get("name"));
			    
	    //设置多个键值对
		jedis.mset("name","姗姗","age","20","cupSize","B罩杯","address","北京");
		jedis.incr("age");  //进行加1操作
		System.out.println("美女："+jedis.get("name")+","+jedis.get("age")+"岁,"+"胸是"+jedis.get("cupSize")+",居住地："+jedis.get("address")); 
	}*/

}
