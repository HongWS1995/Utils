package com.hong.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 3hhws
 * @since 2018-06-07
 * @version 1.0
 * @description ����32λ����16λ��MD5���ܵ��ַ���
 * 
 */
public class MD5Utils {
	// �ַ�ӳ��
	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// MD5ת������ֽ�ת����16���Ƶ��ַ�����32���ַ���
	public static String MD5To32Char(String mds) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(mds.getBytes());
		String s;
		// ���ֽڱ�ʾ���� 16 ���ֽ�
		char str[] = new char[16 * 2]; // ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ���
		// ���Ա�ʾ�� 16 ������Ҫ 32 ���ַ�
		int k = 0; // �洢str�±�ֵ
		for (int i = 0; i < 16; i++) {
			// ת���� 16 �����ַ���ת��
			byte byte0 = md5[i]; // ȡ�� i ���ֽ�
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // ȡ�ֽ��и� 4 λ������ת��,
			// >>> Ϊ�߼����ƣ�������λ��������λ    10011010--->00001001
			str[k++] = hexDigits[byte0 & 0xf]; // ȡ�ֽ��е� 4 λ������ת��
		}
		s = new String(str); // ����Ľ��ת��Ϊ�ַ���
		return s;
	}

	// MD5ת������ֽ�ת����16���Ƶ��ַ�����16���ַ���
	public static String MD5To16Char(String mds) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(mds.getBytes());
		String s;
		// ���ֽڱ�ʾ���� 8 ���ֽڣ��ض�ǰ��4���ֽ�
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
