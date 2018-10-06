package com.hong.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 3hhws
 * @since 2018-06-07
 * @version 1.0
 * @description 生成32位或者16位的MD5加密的字符串
 * 
 */
public class MD5Utils {
	// 字符映射
	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// MD5转换后的字节转换成16进制的字符串（32个字符）
	public static String MD5To32Char(String mds) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(mds.getBytes());
		String s;
		// 用字节表示就是 16 个字节
		char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
		// 所以表示成 16 进制需要 32 个字符
		int k = 0; // 存储str下标值
		for (int i = 0; i < 16; i++) {
			// 转换成 16 进制字符的转换
			byte byte0 = md5[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
			// >>> 为逻辑右移，除符号位外右移四位    10011010--->00001001
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		s = new String(str); // 换后的结果转换为字符串
		return s;
	}

	// MD5转换后的字节转换成16进制的字符串（16个字符）
	public static String MD5To16Char(String mds) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(mds.getBytes());
		String s;
		// 用字节表示就是 8 个字节，截断前后4个字节
		char str[] = new char[16];
		int k = 0;
		for (int i = 4; i < 12; i++) {

			byte byte0 = md5[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];

			str[k++] = hexDigits[byte0 & 0xf];
		}
		s = new String(str);
		return s;
	}
}
