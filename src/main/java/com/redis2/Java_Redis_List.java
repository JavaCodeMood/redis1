package com.redis2;

import redis.clients.jedis.Jedis;

/**
 * redis 操作list
 * @author dell
 *
 */
public class Java_Redis_List {

	public static void main(String[] args) {
		//连接本地redis服务器
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("本地redis服务器连接成功！");
		
		//开始前先移除所有的内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		//先向key java framework中存放三天数据
		//lpush方法表示从列表的头部插入
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "springMVC");
		jedis.lpush("java framework", "springBoot");
		//再取出所有数据jedis,lrange是按范围取出
		//第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));
		
		//删除
		jedis.del("java framework");
		//rpush方法表示从列表的尾部插入
		jedis.rpush("java framework", "springData");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
		

	}

}
