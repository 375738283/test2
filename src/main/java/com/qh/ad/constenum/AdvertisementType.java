package com.qh.ad.constenum;

import java.util.HashMap;
import java.util.Map;
/**
 * 广告类型
 * @author my
 *
 */
public enum AdvertisementType {
	show(0),//展示类型
	download(1),//下载类型
	demo(2);//试玩类型

	
	/****支付订单状态描述****/
	private static final Map<Integer,String> descMap = new HashMap<>(3);
	static{
		descMap.put(show.id(), "展示类型");
		descMap.put(download.id(), "下载类型");
		descMap.put(demo.id(), "试玩类型");
	}
	
	private int id;
	
	private AdvertisementType(int id){
		this.id = id;
	}

	public static Map<Integer, String> desc() {
		return descMap;
	}

	/**
	 * @return
	 */
	public int id() {
		return this.id;
	}
}
