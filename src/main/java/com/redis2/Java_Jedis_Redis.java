package com.redis2;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * Java��ʹ��Jedis����Redis 
 * @author dell
 *
 */
public class Java_Jedis_Redis {
	private Jedis jedis;
	
	@Before
	public void setup(){
		//����redis������
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//Ȩ����֤
		jedis.auth("admin");
	}
	
	/**
	 * redis�洢�ַ���
	 */
	@Test
	public void testString(){
		//�������  set��������ֵ��get����ȡ��ֵ
		jedis.set("cupSize", "B�ֱ�");//��key-->cupsize�з���value-->B
	    System.out.println("��Ů������"+jedis.get("cupSize"));  //ִ�н����B�ֱ�
	    
	    jedis.append("name", "��");  //ƴ��
	    System.out.println("�����Ů�У�"+jedis.get("name"));
	    
	    jedis.del("name");  //ɾ��ĳ����
	    System.out.println(jedis.get("name"));
	    
	    //���ö����ֵ��
	    jedis.mset("name","��","age","20","cupSize","B�ֱ�","address","����");
	    jedis.incr("age");  //���м�1����
	    System.out.println("��Ů��"+jedis.get("name")+","+jedis.get("age")+"��,"+"����"+jedis.get("cupSize")+"��ס�أ�"+jedis.get("address")); 
	}
	
	/*public static void main(String[] args) {
		//Java_Jedis_Redis redis = new Java_Jedis_Redis();
		//redis.testString();
		
		//����redis������
		Jedis jedis = new Jedis("127.0.0.1",6379);
		
		//�������  set��������ֵ��get����ȡ��ֵ
		jedis.set("cupSize", "B�ֱ�");//��key-->cupsize�з���value-->B
	    System.out.println("��Ů������"+jedis.get("cupSize"));  //ִ�н����B�ֱ�
			    
		jedis.append("name", "��");  //ƴ��
	    System.out.println("�����Ů�У�"+jedis.get("name"));
			    
	    jedis.del("name");  //ɾ��ĳ����
	    System.out.println(jedis.get("name"));
			    
	    //���ö����ֵ��
		jedis.mset("name","��","age","20","cupSize","B�ֱ�","address","����");
		jedis.incr("age");  //���м�1����
		System.out.println("��Ů��"+jedis.get("name")+","+jedis.get("age")+"��,"+"����"+jedis.get("cupSize")+",��ס�أ�"+jedis.get("address")); 
	}*/

}
