package com.hong.utils.test;

import com.hong.utils.Base64Utils;

//ͼƬת��Base64����
public class TestBase64 {

	public static void main(String[] args) {
		String readPath = "C:\\Users\\3hhws\\Desktop\\penguins.jpg";
		String writePath = "C:\\Users\\3hhws\\Desktop\\penguins1.jpg";
		String base64Str= Base64Utils.getImageStr(readPath);
		System.out.println(base64Str);
		Base64Utils.generateImage(base64Str, writePath);
		System.out.println("ת���ɹ�");
	}

}
