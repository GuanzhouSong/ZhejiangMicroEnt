package com.icinfo.cs.common.utils;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 根据时间生成唯一id串
 * @author caoxu
 *
 */
public class GenerSeqUtil {
	
	//format格式化缓冲区追加开始位
    private static final FieldPosition POSITION = new FieldPosition(0);

    private final static Format dft = new SimpleDateFormat("yyyyMMddHHmmss");
 
    //用于产生四位数
    private final static NumberFormat nft = new DecimalFormat("0000");
 
    //累加器
    private static int seqNum = 0;
 
    private static final int MAX = 9999;
 
	/**
	 * 生成唯一时间序列号
	 * 
	 * @return String
	 */
	public static synchronized String generateID() {
		StringBuffer sb = new StringBuffer();
		// 生成字符串
		dft.format(Calendar.getInstance().getTime(), sb, POSITION);
		nft.format(seqNum, sb, POSITION);
		if (seqNum == MAX)
			seqNum = 0;
		else
			seqNum++;
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(generateID());
		System.out.println(generateID());
		System.out.println(generateID());
		System.out.println(generateID());
	}

}
