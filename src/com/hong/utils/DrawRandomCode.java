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
 * @description ���ɺ��������ͼƬ
 */
public class DrawRandomCode {

	/**
	 * @param width
	 *            ���ɵ�ͼƬ���
	 * @param height
	 *            ���ɵ�ͼƬ����
	 * @param codeLength
	 *            ���ɵ�����볤��
	 * @param filePath
	 *            ���ɵ�ͼƬ���·��
	 * @param backgroundColor
	 *            ͼƬ����
	 * @param fontColor
	 *            �������ɫ
	 * @param fontSize
	 *            ����������С
	 */
	public static void generateRandomCode(int width, int height, int codeLength, String filePath, Color backgroundColor,
			Color fontColor, int fontSize) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		// Graphics2D ���� �Ĵ����������������BufferedImage����
		Graphics2D graphics2d = bi.createGraphics();
		graphics2d.setBackground(backgroundColor);
		// ͨ�����õı�����ɫ�����������ԭ�е�����
		graphics2d.clearRect(0, 0, width, height);
		graphics2d.setColor(fontColor);
		graphics2d.setFont(new Font(Font.DIALOG, Font.ITALIC, fontSize));
		// �����
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Random r = new Random(System.currentTimeMillis());
		// �����洢��sb����
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < codeLength; i++) {
			int rnum = r.nextInt(26) + 65;
			sb.append((char) rnum);
			
		}
		System.out.println("���ɵ���֤�룺"+sb.toString());
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
