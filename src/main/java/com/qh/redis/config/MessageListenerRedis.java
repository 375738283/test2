package com.qh.redis.config;

import java.util.concurrent.CountDownLatch;

import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.qh.common.config.Constant;
import com.qh.common.utils.R;
import com.qh.redis.RedisConstants;
import com.qh.redis.service.RedisMsg;
import com.qh.redis.service.RedisUtil;


/**
 * @ClassName MessageListener
 * @Description 消息监听
 * @Date 2017年11月10日 下午5:53:26
 * @version 1.0.0
 * @param <M>
 */
public class MessageListenerRedis implements MessageListener{

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageListenerRedis.class);

	private CountDownLatch latch;
	
	/**
	 * @Description T
	 * @param latch
	 */
	public MessageListenerRedis(CountDownLatch latch) {
		this.latch = latch;
	}
	

	@Override
	public void onMessage(Message message, byte[] pattern) {
		String channel = new String(message.getChannel());
		String msgKey = new String(message.getBody());
		msgKey = msgKey.replaceAll("\"", "");
		int index = msgKey.indexOf(RedisConstants.link_symbol);
		if(index <= 0){
			return;
		}
		String merchNo = msgKey.substring(0,index);
    	String orderNo = msgKey.substring(index+1);
		logger.info("MessageListenerRedis"+ ":" + channel + ":" + merchNo + ":" + orderNo);
		
		latch.countDown();
	}

}
