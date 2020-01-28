package com.qh.redis;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: RedisConstants
 * @Description: 常用的常量
 * @date 2017年10月25日 下午9:11:21
 */
public class RedisConstants {
	/** JEDIS默认槽 **/
	public static final int  MASTER_REDIS_INDEX = 0;
	
	/** JEDIS 哨兵默认槽 **/
	public static final int  SENTINEL_REDIS_INDEX = 1;
	
    /** 默认超时时间（毫秒）  */  
    public static final long DEFAULT_TIME_OUT = 1000; 
    
    /***连接符**/
	public static final String link_symbol = "_";
	
    
    /***后台用户lock*******/
    public static final String lock_user = "lock_user_";
	
	/***key split****/
	public static final String key_split_symbol = "&";
    
    /***用户缓存**/
    public static final String cache_user = "user_";
    
    /***配置缓存**/
    public static final String cache_config = "cfg_";
    
    /***父类配置缓存**/
    public static final String cache_config_parent = "cfg_p_";
    
    /***数据字典缓存**/
    public static final String cache_dict_parent = "dict_p_";
    
    /***广告合作企业**/
    public static final String ad_partnership = "ad_partnership";
    

    /****市场信息**/
    public static final String ad_market="ad_market";
   
    /****广告信息**/
    public static final String ad_advertisement="ad_advertisement";
    
    
    
    /****app产品信息**/
    public static final String ad_product="ad_product"; 
    
    
    
    /****user**/
    public static final String yunxing_user="yunxing_user"; 
    
    public static final String yunxing_message="yunxing_message"; 
    
    
    
    /***事件通知间隔时间  5 分钟****/
    public static final int keyevent_5 = 5;
    
    /***事件通知间隔时间  10 分钟****/
    public static final int keyevent_10 = 1;
    
    /***事件通知间隔时间  20 分钟****/
    public static final int keyevent_20 = 2;
    
    /***事件通知间隔时间  25 分钟****/
    public static final int keyevent_30 = 3;
    
    /***事件通知间隔时间  40 分钟****/
    public static final int keyevent_40 =4;
    
    /***事件通知间隔时间  80 分钟****/
    public static final int keyevent_80 = 80;
    
    /***事件通知间隔时间  160 分钟****/
    public static final int keyevent_160 =160;
    
    /***事件通知间隔时间  320 分钟****/
    public static final int keyevent_320 = 320;
    
    /***订单有效时长***/
    public static final int keyevent_order_time=5;
    
    public static final Map<Integer,Integer> evtMinuteMap = new HashMap<>();

    public static final Map<Integer,Integer> autoSyncMinuteMap = new HashMap<>();
    
    static{
    	evtMinuteMap.put(keyevent_10, keyevent_20);
    	evtMinuteMap.put(keyevent_20, keyevent_30);
    	evtMinuteMap.put(keyevent_30, keyevent_40);
    	evtMinuteMap.put(keyevent_40, 0);
    	/*evtMinuteMap.put(keyevent_80, keyevent_160);
    	evtMinuteMap.put(keyevent_160, keyevent_320);*/
    	//evtMinuteMap.put(keyevent_80, 0);
    	
    	autoSyncMinuteMap.put(keyevent_order_time, 0);
    	//autoSyncMinuteMap.put(keyevent_10, keyevent_25);
    	//autoSyncMinuteMap.put(keyevent_25, 0);
    }
    
    
    
    
    
    /***和道轮询index key****/
    public static final String hd_polling_index = "hd_polling_index";
   
    
}
