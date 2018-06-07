package com.hong.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 * 
 * @author 3hhws
 * @since 2018.06.05
 * @description 生成含随机数的图片
 */
public class DrawRandomCode {

	/**
	 * @param width
	 *            生成的图片宽度
	 * @param height
	 *            生成的图片长度
	 * @param codeLength
	 *            生成的随机码长度
	 * @param filePath
	 *            生成的图片存放路径
	 * @param backgroundColor
	 *            图片背景
	 * @param fontColor
	 *            随机码颜色
	 * @param fontSize
	 *            随机码字体大小
	 */
	public static void generateRandomCode(int width, int height, int codeLength, String filePath, Color backgroundColor,
			Color fontColor, int fontSize) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		// Graphics2D 对象 的创建由其他组件或者BufferedImage创建
		Graphics2D graphics2d = bi.createGraphics();
		graphics2d.setBackground(backgroundColor);
		// 通过设置的背景颜色清除矩形区域原有的像素
		graphics2d.clearRect(0, 0, width, height);
		graphics2d.setColor(fontColor);
		graphics2d.setFont(new Font(Font.DIALOG, Font.ITALIC, fontSize));
		// 抗锯齿
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Random r = new Random(System.currentTimeMillis());
		// 随机码存储在sb对象
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < codeLength; i++) {
			int rnum = r.nextInt(26) + 65;
			sb.append((char) rnum);
			
		}
		System.out.println("生成的验证码："+sb.toString());
		graphics2d.drawString(String.valueOf(sb), 10, height / 2);
		FileImageOutputStream os = null;
		try {
			os = new FileImageOutputStream(new File(filePath));
			ImageIO.write(bi, "JPEG", os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			graphics2d.dispose();
		}

	}
}
