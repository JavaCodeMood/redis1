package com.redis1;

import java.util.List;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

/**
 * redis list数据类型
 * 
 * @author dell
 *
 */
public class RedisList {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		System.out.println("redis本地服务连接成功！");
		/*
		 * lpush 表示从list的头部插入元素 rpush 表示从list的尾部插入元素 linsert 在列表的某个元素前或者后插入元素
		 * index 表示列表中index位置的元素 llen 返回列表的长度 lpop list 0 -1
		 * 表示从mylist列表的头部开始删除所有元素 rpop list 0 -1 表示从mylist列表的尾部开始删除所有元素 lrange
		 * list 0 -1 //使用lrange取出元素 0表示从头部第一个元素，-1表示从尾部第一个元素取出，lrange mylist 0
		 * -1 表示取出mylist中的所有数据
		 */
		// 存储数据到列表中
		jedis.lpush("SQL", "Redis");
		jedis.lpush("SQL", "Mongodb");
		jedis.lpush("SQL", "Mysql");
		jedis.linsert("SQL", BinaryClient.LIST_POSITION.BEFORE, "MySql", "java");
		jedis.rpush("SQL", "SqlServer");
		jedis.rpush("SQL", "Oracle");

		jedis.linsert("SQL", BinaryClient.LIST_POSITION.BEFORE, "MySql", "java");
		// Redis Lpushx 将一个或多个值插入到已存在的列表头部，列表不存在时操作无效。
		System.out.println(jedis.lpushx("SQL", "Redis1"));
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("SQL", 0, -1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}

		// 获得列表的长度
		System.out.println("redis列表长度为：" + jedis.llen("SQL"));
		// 删除列表中的元素
		jedis.del("SQL");
		System.out.println("删除了redis列表！");
		// 获得列表的长度
		System.out.println("redis列表长度为：" + jedis.llen("SQL"));
		// 列表下标从0开始
		System.out.println("redis列表下标为5的元素是：" + jedis.lindex("SQL", 5));
		/*
		 * Redis Ltrim 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。 下标 0
		 * 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2
		 * 表示列表的倒数第二个元素，以此类推。
		 */
		System.out.println(jedis.ltrim("SQL", 0, 4));

	}

}
