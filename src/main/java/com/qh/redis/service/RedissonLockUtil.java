package com.qh.redis.service;

import org.redisson.api.RLock;

import com.qh.redis.RedisConstants;

public class RedissonLockUtil {
	
    private static RedissonLocker redissLock;
    
    public static void setLocker(RedissonLocker locker) {
        redissLock = locker;
    }
    
    public static RLock getLock(String lockKey){
		return redissLock.getLock(lockKey);
	}
    
    public static RLock getUserLock(String lockKey){
		return redissLock.getLock(RedisConstants.lock_user + lockKey);
	}
    
}