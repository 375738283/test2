package com.qh.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class BeanMapperUtil {
	
	/**
	 * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
	 */
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	/**
	 * 基于Dozer转换对象的类型.
	 * @param sourceObject
	 * @param destObjectclazz
	 * @return
	 */
	public static <T> T map(Object sourceObject, Class<T> destObjectclazz) {
		return ((sourceObject == null) ? null : dozer.map(sourceObject, destObjectclazz));
	}

	
	public static <T, S> List<T> mapList(Collection<S> sourceList, Class<T> destObjectclazz) {
		if (sourceList == null) {
			return null;
		}
		List<T> destinationList = new ArrayList<T>();
		for (Iterator<S> it = sourceList.iterator(); it.hasNext();) {
			destinationList.add(map(it.next(), destObjectclazz));
		}
		return destinationList;
	}
	
	/**
	 * 基于Dozer将对象A的值拷贝到对象B中.
	 */
	public static void copy(Object source, Object destinationObject) {
	    dozer.map(source, destinationObject);
	}
	
}