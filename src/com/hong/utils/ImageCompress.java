package com.hong.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
public class ImageCompress {

	public static void main(String[] args) throws IOException {
		ImageCompress thumbnailatorTest = new ImageCompress();
//		thumbnailatorTest.test1();
		thumbnailatorTest.test2();
//		thumbnailatorTest.test3();
//		thumbnailatorTest.test4();
//		thumbnailatorTest.test5();
//		thumbnailatorTest.test6();
//		thumbnailatorTest.test7();
//		thumbnailatorTest.test8();
//		thumbnailatorTest.test9();
	}
	
	/**
	 * ָ����С��������
	 * 
	 * @throws IOException
	 */
	private void test1() throws IOException {
		/*
		 * size(width,height) ��ͼƬ���200С���߱�300С������
		 * ��ͼƬ���200С���߱�300�󣬸���С��300��ͼƬ�������� ��ͼƬ���200�󣬸߱�300С������С��200��ͼƬ��������
		 * ��ͼƬ���200�󣬸߱�300��ͼƬ��������С����Ϊ200���Ϊ300
		 */
		Thumbnails.of("C:/Users/3hhws/Desktop/Jellyfish_��ͼ��.bmp").size(200, 300).toFile(
				"C:/Users/3hhws/Desktop/image_200x300.jpg");
		Thumbnails.of("C:/Users/3hhws/Desktop/Jellyfish_��ͼ��.bmp").size(2560, 2048).toFile(
				"C:/Users/3hhws/Desktop/image_2560x2048.jpg");
	}

	/**
	 * ���ձ�����������
	 * 
	 * @throws IOException
	 */
	private void test2() throws IOException {
		/**
		 * scale(����)
		 */
		Thumbnails.of("F:\\Tool\\eclipse-juno-win32\\workspace\\webjky\\webjky\\sampleImage\\ZZ010302WT20180000000000329097\\imagePosition3_temp.bmp").scale(0.5f).outputFormat("jpg")
					.toFile("C:/Users/3hhws/Desktop/image_25%");
		Thumbnails.of("F:\\Tool\\eclipse-juno-win32\\workspace\\webjky\\webjky\\sampleImage\\ZZ010302WT20180000000000329097\\imagePosition3_temp.bmp").size(1280, 1024).outputFormat("jpg").toFile(
				"C:/Users/3hhws/Desktop/image_110%.bmp");
	}

	/**
	 * �����ձ�����ָ����С��������
	 * 
	 * @throws IOException
	 */
	private void test3() throws IOException {
		/**
		 * keepAspectRatio(false) Ĭ���ǰ��ձ������ŵ�
		 */
		Thumbnails.of("C:/Users/3hhws/Desktop/��¥.jpg").size(120, 120).keepAspectRatio(false)
				.toFile("C:/image_120x120.jpg");
	}

	/**
	 * ��ת
	 * 
	 * @throws IOException
	 */
	private void test4() throws IOException {
		/**
		 * rotate(�Ƕ�),������˳ʱ�� ��������ʱ��
		 */
		Thumbnails.of("C:/Users/3hhws/Desktop/��¥.jpg").size(1280, 1024).rotate(90).toFile(
				"C:/image+90.jpg");
		Thumbnails.of("C:/Users/3hhws/Desktop/��¥.jpg").size(1280, 1024).rotate(-90).toFile(
				"C:/iamge-90.jpg");
	}

	/**
	 * ˮӡ
	 * 
	 * @throws IOException
	 */
	private void test5() throws IOException {
		/**
		 * watermark(λ�ã�ˮӡͼ��͸����)
		 */
		Thumbnails.of("images/test.jpg").size(1280, 1024).watermark(
				Positions.BOTTOM_RIGHT,
				ImageIO.read(new File("images/watermark.png")), 0.5f)
				.outputQuality(0.8f).toFile(
						"C:/image_watermark_bottom_right.jpg");
		Thumbnails.of("images/test.jpg").size(1280, 1024).watermark(
				Positions.CENTER,
				ImageIO.read(new File("images/watermark.png")), 0.5f)
				.outputQuality(0.8f).toFile("C:/image_watermark_center.jpg");
	}

	/**
	 * �ü�
	 * 
	 * @throws IOException
	 */
	private void test6() throws IOException {
		/**
		 * ͼƬ����400*400������
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400,
				400).size(200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_center.jpg");
		/**
		 * ͼƬ����400*400������
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.BOTTOM_RIGHT,
				400, 400).size(200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_bootom_right.jpg");
		/**
		 * ָ������
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400, 400).size(
				200, 200).keepAspectRatio(false).toFile(
				"C:/image_region_coord.jpg");
	}

	/**
	 * ת��ͼ���ʽ
	 * 
	 * @throws IOException
	 */
	private void test7() throws IOException {
		/**
		 * outputFormat(ͼ���ʽ)
		 */
		Thumbnails.of("C:/Users/3hhws/Desktop/��¥.jpg").size(1280, 1024).outputFormat("jpg")
				.toFile("C:/Users/3hhws/Desktop/image_1280x1024.jpg");
		Thumbnails.of("C:/Users/3hhws/Desktop/��¥.jpg").size(1280, 1024).outputFormat("jpg")
				.toFile("C:/Users/3hhws/Desktop/image_1280x1024.jpg");
	}

	/**
	 * �����OutputStream
	 * 
	 * @throws IOException
	 */
	private void test8() throws IOException {
		/**
		 * toOutputStream(������)
		 */
		OutputStream os = new FileOutputStream(
				"C:/image_1280x1024_OutputStream.png");
		Thumbnails.of("images/test.jpg").size(1280, 1024).toOutputStream(os);
	}

	/**
	 * �����BufferedImage
	 * 
	 * @throws IOException
	 */
	private void test9() throws IOException {
		/**
		 * asBufferedImage() ����BufferedImage
		 */
		BufferedImage thumbnail = Thumbnails.of("images/test.jpg").size(1280,
				1024).asBufferedImage();
		ImageIO.write(thumbnail, "jpg", new File(
				"C:/image_1280x1024_BufferedImage.jpg"));
	}

}