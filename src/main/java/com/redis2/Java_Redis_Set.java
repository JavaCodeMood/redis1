package com.redis2;

import redis.clients.jedis.Jedis;

public class Java_Redis_Set {
	public static void main(String[] args) {
		//连接本地redis服务器
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("redis服务器连接成功！");
		
		//添加
		jedis.sadd("cupSize", "A罩杯");
		jedis.sadd("cupSize", "B罩杯");
		jedis.sadd("cupSize", "C罩杯");
		jedis.sadd("cupSize", "D罩杯");
		jedis.sadd("cupSize", "E罩杯");
		jedis.sadd("cupSize", "F罩杯");
		/*Redis Srem 命令用于移除集合中的一个或多个成员元素，不存在的成员元素会被忽略。
                      当 key 不是集合类型，返回一个错误。
        */
		jedis.srem("cupSize", "F罩杯");
		//Redis Smembers 命令返回集合中的所有的成员。 不存在的集合 key 被视为空集合。
		System.out.println(jedis.smembers("cupSize"));
		//Redis Sismember 命令判断成员元素是否是集合的成员。 判断F罩杯是否是cupSize集合的元素
		System.out.println(jedis.sismember("cupSize", "F罩杯"));
		//Redis Srandmember 命令用于返回集合中的一个随机元素。
		System.out.println(jedis.srandmember("cupSize"));
		//Redis Scard 命令返回集合中元素的数量。
		System.out.println(jedis.scard("cupSize"));
	}

}
