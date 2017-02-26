package com.redis;

import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;

/**
 * 连接redis服务器、保存读取concurrentMap对象、保存读取set对象和保存读取Queue对象
 * @author dell
 *
 */
public class RedisExample {
	public static void main(String[] args) {
		//初始化
		Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("127.0.0.1:6379");
		Redisson redisson = Redisson.create(config);
		System.out.println("redis连接成功！");
		
		//1.测试concurrentMap,put方法的时候就会同步到redis中
		ConcurrentMap<String,Object> map = redisson.getMap("FirstMap");
		map.put("liuhefei", "男");
		map.put("xuyi","女");
		map.put("yuyun","女");
		
		ConcurrentMap resultMap =redisson.getMap("FirstMap");
		System.out.println("resultMap=" + resultMap.keySet());
		
		//2.测试set集合
		Set mySet = redisson.getSet("MySet");
		mySet.add("霜花似雪");
		mySet.add("美女");
		mySet.add("帅哥");
		
		Set resultSet = redisson.getSet("MySet");
		Iterator<String> it = resultSet.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.print(str+" ");
		}
		System.out.println("\n resultSet=" + resultSet.iterator());
		System.out.println("resultSet=" + resultSet.size());
		
		//3。测试Queue队列
		Queue myQueue = redisson.getQueue("FirstQueue");
		myQueue.add("北京");
		myQueue.add("shanghai");
		myQueue.add("kunming");
		myQueue.peek();
		myQueue.poll();
		
		Queue resultQueue = redisson.getQueue("FirstQueue");
		System.out.println("resultQueue= " + resultQueue);
		
		//Redis Flushall 命令用于清空整个 Redis 服务器的数据(删除所有数据库的所有 key )。 
		
		
		//关闭连接
		redisson.shutdown();
		
	}

}
