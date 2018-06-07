package com.hong.utils.test;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.hong.utils.DrawRandomCode;
import com.hong.utils.MD5Utils;

class DrawRandomCodeTest {

	static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	@Test
	@DisplayName("测试验证码图片生成")
	@RepeatedTest(5)
	void testGenerateRandomCode() throws UnsupportedEncodingException {
		int width = 300;
		int height = 150;
		int codeLength = 10;
		String filePath = "E:\\logs\\test.png";
		Color backgroundColor =Color.CYAN ;
		Color fontColor = Color.BLACK;
		int fontSize = 50;
		DrawRandomCode.generateRandomCode(width, height, codeLength, 
				filePath, backgroundColor, fontColor, fontSize);
		assertTrue("生成成功", new File(filePath).length()>0);
		try {
			String s = MD5Utils.MD5To32Char("12345");
			System.out.println(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	

}
