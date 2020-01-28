package com.qh.common.utils;


import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 加密类
 * 
 * @Title: Des.java
 * @date 2015年12月19日
 */
public class DesUtil {

	private static String PASSWORD_CRYPT_KEY = "cS(96@%1";

	// private final static String DES = "DES";
	// private static final byte[] desKey;
	// 解密数据
	public static String decrypt(String message, String key) throws Exception {

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return decode(new String(retByte));
	}

	public static byte[] encryptBt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return cipher.doFinal(message.getBytes("UTF-8"));
	}

	// 加密
	public static String encrypt(String value, String key) {
		String result = "";
		try {
			value = java.net.URLEncoder.encode(value, "utf-8");
			result = toHexString(encryptBt(value, key)).toUpperCase();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
		return result;
	}

	public static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

	public static String decode(String s) {
		String ret = "";
		try {
			ret = java.net.URLDecoder.decode(s, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	// 解密数据
	public static String decrypt(String message) {
		String msg = null;
		try {
			msg = decrypt(message, PASSWORD_CRYPT_KEY);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return msg;
	}

	// 加密
	public static String encrypt(String value) {
		return encrypt(value, PASSWORD_CRYPT_KEY);
	}

	public static void main(String[] args) throws Exception {
		String value = "1024xxsdfasdfsadf";
		System.out.println("加密数据:" + value);
		System.out.println("密码为:" + PASSWORD_CRYPT_KEY);
		String a = encrypt(value);
		System.out.println("加密后的数据为:" + a);
		String s = decrypt(a);
		System.out.println("解密后的数据为:" + s);
	}
}
