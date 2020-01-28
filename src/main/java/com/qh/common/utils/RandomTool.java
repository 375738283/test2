package com.qh.common.utils;

import java.text.NumberFormat;
import java.util.Random;
import java.util.UUID;

public class RandomTool {
	
	public static String generatorSix(){
		 Random rm = new Random();  
	     // 获得随机数  
		 double pross = (1 + rm.nextDouble()) * Math.pow(10, 6);  
		 // 将获得的获得随机数转化为字符串  
		 String fixLenthString = String.valueOf(pross);  
		 // 返回固定的长度的随机数  
		 return fixLenthString.substring(1, 7);
	}
	
	

	/** 
	 * 随机指定范围内N个不重复的数 
	 * 在初始化的无重复待选数组中随机产生一个数放入结果中， 
	 * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换 
	 * 然后从len-2里随机产生下一个随机数，如此类推 
	 * @param max  指定范围最大值 
	 * @param min  指定范围最小值 
	 * @param n  随机数个数 
	 * @return int[] 随机数结果集 
	 */  
	public static int[] randomArray(int min,int max,int n){  
	    int len = max-min+1;  
	    
	    if(max < min || n > len){  
	        return null;  
	    }  
	    //初始化给定范围的待选数组  
	    int[] source = new int[len];  
	       for (int i = min; i < min+len; i++){  
	        source[i-min] = i;  
	       } 
	       int[] result = new int[n];  
	       Random rd = new Random();  
	       int index = 0;  
	       for (int i = 0; i < result.length; i++) {  
	        //待选数组0到(len-2)随机一个下标  
	           index = Math.abs(rd.nextInt() % len--);  
	           //将随机到的数放入结果集  
	           result[i] = source[index];  
	           //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换  
	           source[index] = source[len];  
	       }  
	       return result;  
	}  
	
	
	public static void main(String[] args){
//		System.out.println(generatorSix());
//		System.out.println(Math.round( Math.random() * 100));
		for (int i=0;i<10000;i++) {
			System.out.println(random(6));
		}
		
		
	}
	/**
	 * 随机length位数数字
	 * @param length
	 * @return
	 */
	public static String random(int length) {  
    	Random r = new Random();
    	int max=10;
    	for (int i = 0; i < length; i++) {
    		max=max*10;
		}
    	int rd=	r.nextInt(max);
        // 得到一个NumberFormat的实例  
        NumberFormat nf = NumberFormat.getInstance();  
        // 设置是否使用分组  
        nf.setGroupingUsed(false);  
        // 设置最大整数位数  
        nf.setMaximumIntegerDigits(length);  
        // 设置最小整数位数  
        nf.setMinimumIntegerDigits(length);   
        return nf.format(rd);
    }
	
	/**
	 * 获取随机数 包含min,不包含max
	 * @return
	 */
	public static int getRandomNum(int min, int max){
		int m = max - min;
		Random r = new Random();
		int n = r.nextInt();
		n = Math.abs(n);
		n = n%m + min;
		return n;
	}
	
	
	public static String orderId() {
		return System.currentTimeMillis()+random(9);
	}
	
	

	
	public static String getUUID(){
		String s = UUID.randomUUID().toString();
		return s.replaceAll("-", "");
	}
}
