package com.example.seckill;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class SeckillDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisScript<Boolean> script;

    @Test
    void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //占位,如果key不存在才可以设置成功
        Boolean isLock = valueOperations.setIfAbsent("k1", "v1");
        //如果占位成功,进行正常操作
        if (isLock) {
            valueOperations.set("name", "xxxx");
            String name = (String) valueOperations.get("name");
            log.info("name=" + name);
            Integer.parseInt("xxxx");
            //操作结束,删除锁
            redisTemplate.delete("k1");
        } else {
            log.info("有线程再使用,请稍后再试");
        }

    }

    @Test
    public void testLock2() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //占位,如果key不存在才可以设置成功
        //给锁添加一个过期时间,防止应用在运行过程中抛出异常导致锁无法正常释放
        Boolean isLock = valueOperations.setIfAbsent("k1", "v1", 5, TimeUnit.SECONDS);
        //如果占位成功,进行正常操作
        if (isLock) {
            valueOperations.set("name", "xxxx");
            String name = (String) valueOperations.get("name");
            log.info("name=" + name);
            Integer.parseInt("xxxx");
            //操作结束,删除锁
            redisTemplate.delete("k1");
        } else {
            log.info("有线程再使用,请稍后再试");
        }
    }

    @Test
    public void testLock03() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String value = UUID.randomUUID().toString();
        //给锁添加一个过期时间,防止应用在运行过程中抛出异常导致锁无法正常释放
        Boolean isLock = valueOperations.setIfAbsent("k1", value, 120, TimeUnit.SECONDS);
        if (isLock) {
            valueOperations.set("name","xxxx");
            String name = (String) valueOperations.get("name");
            log.info("name="+name);
            log.info("k1="+valueOperations.get("k1"));
            //释放锁
            Boolean result = (Boolean) redisTemplate.execute(script, Collections.singletonList("k1"), value);
            log.info(result.toString());
        }else {
            //有人占位,停止/暂缓 操作
            log.info("有线程使用请稍后");
        }


    }


}
