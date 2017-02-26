package com.redis1;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * Redis keys实例
 * @author dell
 *
 */
public class RedisKeys {
	public static void main(String[] args) {
		//连接redis本地服务
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("redis本地服务连接成功！");
		/*Redis Bgsave 命令用于在后台异步保存当前数据库的数据到磁盘。
          BGSAVE 命令执行之后立即返回 OK ，然后 Redis fork 出一个新子进程，
                       原来的 Redis 进程(父进程)继续处理客户端请求，而子进程则负责将数据保存到磁盘，然后退出。
        */
		System.out.println(jedis.bgsave());
		//Redis Echo 命令用于打印给定的字符串。
		System.out.println(jedis.echo("redis"));
		//Redis Flushall 命令用于清空整个 Redis 服务器的数据(删除所有数据库的所有 key )。
		System.out.println(jedis.flushAll());
		//Redis Flushdb 命令用于清空当前数据库中的所有 key。
		System.out.println(jedis.flushDB());
		/*
		 Redis Ping 命令使用客户端向 Redis 服务器发送一个 PING ，如果服务器运作正常的话，会返回一个 PONG 。
                     通常用于测试与服务器的连接是否仍然生效，或者用于测量延迟值。
		 */
		System.out.println(jedis.ping());
		//Redis Info 命令以一种易于理解和阅读的格式，返回关于 Redis 服务器的各种信息和统计数值。
		System.out.println("\ninfo----->"+jedis.info());
		//Redis RANDOMKEY 命令从当前数据库中随机返回一个 key 。
		System.out.println(jedis.randomKey());
		//Redis Save 命令执行一个同步保存操作，将当前 Redis 实例的所有数据快照(snapshot)以 RDB 文件的形式保存到硬盘。
		System.out.println(jedis.save());
		//Redis Unwatch 命令用于取消 WATCH 命令对所有 key 的监视。
		System.out.println(jedis.unwatch());
		/*
		  Redis Multi 命令用于标记一个事务块的开始。
                      事务块内的多条命令会按照先后顺序被放进一个队列当中，最后由 EXEC 命令原子性(atomic)地执行。
         */
		 
		System.out.println(jedis.multi());
		/*Redis Quit 命令用于关闭与当前客户端与redis服务的连接。
		一旦所有等待中的回复(如果有的话)顺利写入到客户端，连接就会被关闭。*/
		System.out.println(jedis.quit());
	}

}
