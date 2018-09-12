package com.hong.utils.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test01 {  
    public static void main(String[] args) {  
        double d = 756.2345566;  
  
        //����һ������ķ���������DecimalFormat��  
        DecimalFormat df = new DecimalFormat(".00");  
        System.out.println(df.format(d));  
  
        //��������ֱ��ͨ��String���format����ʵ��  
        System.out.println(String.format("%.2f", d));  
  
        //��������ͨ��BigDecimal��ʵ��  
        BigDecimal bg = new BigDecimal(d);  
        double d3 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
        System.out.println(d3);  
  
        //�����ģ�ͨ��NumberFormat��ʵ��  
        NumberFormat nf = NumberFormat.getNumberInstance();  
        nf.setMaximumFractionDigits(2);  
        System.out.println(nf.format(d));  
  
    }  
}  
