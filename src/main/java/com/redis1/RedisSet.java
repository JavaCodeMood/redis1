package com.redis1;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Redis set数据类型
 * @author dell
 *
 */
public class RedisSet {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		//set方法用于向redis数据库中添加设置数据
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		jedis.set("k3", "v3");
		//get方法用于获取某个键所对应的值
		System.out.println(jedis.get("k3"));
		//del方法用于删除某个键所对应的值
		System.out.println(jedis.del("k1"));
		//getSet方法用户获取某个键所对应的值，键不存在，返回null；键存在，返回对应的值
		System.out.println(jedis.getSet("k4", "v4"));
		/*getrange(key, startOffset, endOffset)方法用于获取存在在key中字符串的子字符串
		 字符串的截取范围由start和end两个偏移量决定
		*/
		System.out.println(jedis.getrange("k2", 1, -1));
		//lpop方法用于移除并返回列表的第一个元素
		System.out.println(jedis.lpop("k1"));
		//rpop方法用于移除并返回列表的最后一个元素
		System.out.println(jedis.rpop("k5"));
		//返回集合的长度
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());

	}

}
