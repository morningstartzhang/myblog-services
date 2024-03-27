package com.lovesh.utils;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class RedisUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public Boolean expire(final String key, final long time){
        try {
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (final Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 根据键获取值
    public Object get(final String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    // 将<key, value>键值对存入redis
    public Boolean set(final String ket, final Object value){
        try{
            redisTemplate.opsForValue().set(ket, value);
            return true;
        }catch (final Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 将键值对存入value并设置过期时间
    public Boolean set(final String key, final Object value, final long time){
        try{
            if(time > 0){
                redisTemplate.opsForValue().set(key, value,time, TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        }catch (final Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 删除键
    public Boolean delete(final String key){
        try {
            redisTemplate.opsForValue().getAndDelete(key);
            return true;
        }catch (final Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
