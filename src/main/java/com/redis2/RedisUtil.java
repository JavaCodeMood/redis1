package com.redis2;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	//redis������ip
	private static String ADDR = "127.0.0.1";
	//redis�Ķ˿�
	private static int PORT = 6379;
	//��������
	private static String AUTH = "cell";
	//�������ӵ������Ĭ��Ϊ8
	//�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
    private static int MAX_ACTIVE = 1024;
    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��redisʵ����Ĭ��ֵҲ��8
    private static int MAX_IDLE = 200;
    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
    private static long MAX_WAIT = 1000;
    private static int TIMEOUT = 1000;
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õ�
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;
    
    //��ʼ��redis���ӳ�
    static{
    	try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			//jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    //��ȡJedisʵ��
    public synchronized static Jedis getJedis(){
    	try {
			if(jedisPool != null){
				Jedis resource = jedisPool.getResource();
				return resource;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    //�ͷ�jedis��Դ
    public static void returnResource(final Jedis jedis){
    	if(jedis != null){
    		jedisPool.returnResource(jedis);
    	}
    }

}
