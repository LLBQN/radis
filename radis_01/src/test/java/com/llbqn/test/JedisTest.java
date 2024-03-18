package com.llbqn.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 使用Jedis操作Redis数据库
 */
public class JedisTest {

    @Test
    public void testRedis(){

        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);

        //2.执行具体操作
        jedis.set("username","zhangsan");

        String value = jedis.get("username");
        System.out.println(value);

        //jedis.del("username");

        jedis.hset("myhash","addr","wuhan");

        String hvalue = jedis.hget("myhash", "addr");
        System.out.println(hvalue);

        Set<String> keys = jedis.keys("*");
        for(String key : keys){
            System.out.println(key);
        }

        //3.关闭连接
        jedis.close();

    }
}
