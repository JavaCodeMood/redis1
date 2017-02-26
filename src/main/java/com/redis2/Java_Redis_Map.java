package com.redis2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * redis����map
 * @author dell
 *
 */
public class Java_Redis_Map {
	public static void main(String[] args) {
		//���ӱ���redis������
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println("redis���������ӳɹ���");
		
		//�������
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "����");
		map.put("age", "20");
		map.put("height", "175cm");
		map.put("cupSize", "C�ֱ�");
		jedis.hmset("user",map);
		//ȡ��user�е�name��ִ�н��:[minxr]-->ע������һ�����͵�List  
		//��һ�������Ǵ���redis��map�����key����������Ƿ���map�еĶ����key�������key���Ը�������ǿɱ����  

		List<String> rsmap = jedis.hmget("user", "name","age","height","cupSize");
		System.out.println(rsmap);
		
		//ɾ��map�е�ĳ����ֵ
		jedis.hdel("user", "height");
		System.out.println(jedis.hmget("user", "height")); //��Ϊɾ���ˣ����з��ص���null
		 System.out.println(jedis.hlen("user")); //����keyΪuser�ļ��д�ŵ�ֵ�ĸ���2 
		 System.out.println(jedis.exists("user"));//�Ƿ����keyΪuser�ļ�¼ ����true  
		 System.out.println(jedis.hkeys("user"));//����map�����е�����key  
		 System.out.println(jedis.hvals("user"));//����map�����е�����value 

		 Iterator<String> iter = jedis.hkeys("user").iterator();
		 while(iter.hasNext()){
			 String key = iter.next();
			 System.out.println(key+":"+jedis.hmget("user", "key"));
		 }
	}

}
