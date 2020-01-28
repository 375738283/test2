package com.qh.system.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

import com.qh.ad.dao.PartnershipDao;
import com.qh.common.dao.DictDao;
import com.qh.common.domain.DictDO;
import com.qh.redis.service.RedisUtil;
import com.qh.system.dao.ConfigDao;
import com.qh.system.domain.ConfigDO;
/**
 * @ClassName SysConfig
 * @Description 系统相关配置
 * @Date 2017年11月6日 下午12:01:19
 * @version 1.0.0
 */
@Configuration
@Order(2)
public class SysConfig {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SysConfig.class);
	
	@Autowired
	private ConfigDao configDao;
	@Autowired
	private DictDao dictDao;
	
	
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@PostConstruct
	public void init(){
		logger.info("=======初始化系统参数========");
		/**系统参数***/
		List<ConfigDO> configs = configDao.list(null);
		for (ConfigDO configDO : configs) {
			RedisUtil.syncConfig(configDO, false);
		}
		/****数据字典****/
//		List<DictDO>  dicts=dictDao.list(null);
//		for (DictDO dictDO : dicts) {
//			RedisUtil.syncDict(dictDO, false);
//		}
//		
	}

}
