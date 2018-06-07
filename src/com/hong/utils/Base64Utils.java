package com.hong.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
/**
 * 
 * @author 3hhws
 * @version 1.0
 * @description ͼƬBase64ת�������Ĺ��߰�
 */
public class Base64Utils {
	/**
	 * @Description: ��base64�����ַ���ת��ΪͼƬ
	 * @Author: 3hhws
	 * @CreateTime: 2018-05-29
	 * @param imgStr base64�����ַ���
	 * @param path ͼƬ·��-���嵽�ļ�
	 * @return ͼƬ
	*/
	public static boolean generateImage(String imgStr, String path) {
	if (imgStr == null)
		return false;
	Decoder decoder =Base64.getDecoder();
	try {
	// ����
	
	byte[] b = decoder.decode(imgStr);
	// ��������
	for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {
				b[i] += 256;
		}
	}
	OutputStream out = new FileOutputStream(path);
	out.write(b);
	out.flush();
	out.close();
	return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
  }
	
	/**
	 * @Description: ����ͼƬ��ַת��Ϊbase64�����ַ���
	 * @Author: 3hhws
	 * @CreateTime: 2018-05-29
	 * @return Base64�ַ���
	 */
	public static String getImageStr(String imgPath) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgPath);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // ����
	    Encoder encoder = Base64.getEncoder();
	    return encoder.encodeToString(data);
	}
}
