package com.hong.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerateQRCode {

	public static void encodeQRCode(int width, int height, String format,
			String content, Map<EncodeHintType, ?> hints) {

		BitMatrix bitMatrix;
		System.out.println("生成二维码开始...");
		try {
			
			bitMatrix = new MultiFormatWriter().encode(content,
					BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("C:\\Users\\3hhws\\Desktop\\code.png")
					.toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			System.out.println("生成二维码成功。");
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int width = 120; // 图片的宽度
		int height = 120; // 图片的高度
		String format = "png"; // 图片的格式
		String content = "18814383273"; // 内容

		/**
		 * 定义二维码的参数
		 */
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // 指定二维码的纠错等级为中级
		hints.put(EncodeHintType.MARGIN, 1); // 设置图片的边距
		GenerateQRCode.encodeQRCode(width, height, format, content, hints);
		
		
		MultiFormatReader formatReader=new MultiFormatReader();
	    File file=new File("C:\\Users\\3hhws\\Desktop\\code.png");
	    BufferedImage image;
	    try {
	            image = ImageIO.read(file);
	            BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
	            HashMap<EncodeHintType, Object> hints1=new HashMap();
	            hints1.put(EncodeHintType.CHARACTER_SET,"utf-8");    //指定字符编码为“utf-8”
	            Result result=formatReader.decode(binaryBitmap);
	            System.out.println("解析结果："+result.toString());
	            System.out.println("二维码格式："+result.getBarcodeFormat());
	            System.out.println("二维码文本内容："+result.getText());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
