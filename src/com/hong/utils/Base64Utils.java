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
 * @description 图片Base64转码与解码的工具包
 */
public class Base64Utils {
	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author: 3hhws
	 * @CreateTime: 2018-05-29
	 * @param imgStr base64编码字符串
	 * @param path 图片路径-具体到文件
	 * @return 图片
	*/
	public static boolean generateImage(String imgStr, String path) {
	if (imgStr == null)
		return false;
	Decoder decoder =Base64.getDecoder();
	try {
	// 解密
	
	byte[] b = decoder.decode(imgStr);
	// 处理数据
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
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 3hhws
	 * @CreateTime: 2018-05-29
	 * @return Base64字符串
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
	    // 加密
	    Encoder encoder = Base64.getEncoder();
	    return encoder.encodeToString(data);
	}
}
