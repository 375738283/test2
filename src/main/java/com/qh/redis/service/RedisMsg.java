package com.qh.redis.service;

import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.qh.redis.RedisConstants;

/**
 * @ClassName RedisMsg
 * @Description redis消息传送
 * @Date 2017年11月17日 下午3:20:16
 * @version 1.0.0
 */
public class RedisMsg {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RedisMsg.class);
	
	private static RedisTemplate<String, Object> redisTemplate;
	
	
	/**
	 * @Description 订单 回调通知
	 * @param order
	 */
	public static void orderNotifyMsg(String merchNo, String orderNo) {
		logger.info("redisMsg：订单 回调通知 - " + merchNo + RedisConstants.link_symbol + orderNo);
		//redisTemplate.convertAndSend(RedisConstants.channel_order_notify, merchNo + RedisConstants.link_symbol + orderNo);
	}
	
	
	
	public static RedisTemplate<String, Object> getRedisTemplate(){
		return redisTemplate;
	}
	public static void setRedisTemplate(RedisTemplate<String, Object> template) {
		redisTemplate = template;
	}
}
