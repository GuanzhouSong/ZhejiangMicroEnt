package com.icinfo.cs.common.constant;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 描述：获取随机数
 *
 * @author chenxin
 * @date 2016/8/15
 */
public class SkipNum {
	private static final int PERCENT_MAX = 100;
    /**
     * 描述：生成首个随机数
     * @author chenxin
     * @date 2016-11-04
     * @param total
     * @param percent
     * @return
     */
    public static int getRandom(int total,float percent){
    	int maxRandom = Math.round((float)total / ((float)total * (percent/PERCENT_MAX)));
    	int num=new Random().nextInt(maxRandom)+1;
    	return num;
    }
    
    /**
     * @author chenxin
     * @date 2016-11-04
     * @param total
     * @param firstNum
     * @param percent
     * @return
     */
    public static List<String> getAllRandomNumber(int total,int firstNum, int percent){
    	List<String> list = new ArrayList<String>();
    	int skipNum = Math.round((float)total / ((float)total * ((float)percent/PERCENT_MAX)));
    	int allCheck = Math.round((float)total * ((float)percent/PERCENT_MAX));
    	for(int i = firstNum;i < total ;i = i+skipNum){
    		if(i <= total){
    			list.add(i+"");
    		}
    	}
    	if(list.size() < allCheck ){
    		do{
        		String number = getRandomNumber(total);
        		if(!list.contains(number)){
        			list.add(number);
    			}
        	}while(list.size() < allCheck);
    	}
    	return list;
    }
    
    /**
     * @author chenxin
     * @date 2016-11-04
     * @param total
     * @param firstNum
     * @param percent
     * @return
     */
    public static List<String> getAllRandomNumber(int total, float percent){
    	int firstNum = new Random().nextInt(total)+1;
    	List<String> list = new ArrayList<String>();
    	int skipNum = Math.round((float)total / ((float)total * (percent/PERCENT_MAX)));
    	int allCheck = Math.round((float)total * ( percent / PERCENT_MAX));
    	for(int i = firstNum;i < total ;i = i+skipNum){
    		if(i <= total){
    			list.add(i+"");
    		}
    	}
    	if(list.size() < allCheck ){
    		do{
        		String number = getRandomNumber(total);
        		if(!list.contains(number)){
        			list.add(number);
    			}
        	}while(list.size() < allCheck);
    	}
    	return list;
    }
    
    /**
     * @author chenxin
     * @date 2016-11-04
     * @param total
     * @param num
     * @return
     */
    public static List<String> getRandomNumber(int total,int num){
    	List<String> list = new ArrayList<String>();
    	do{
    		String number = getRandomNumber(total);
    		if(!list.contains(number)){
    			list.add(number);
			}
    	}while(list.size() < num);
    	return list;
    }
    
    /**
     * @author chenxin
     * @date 2016-11-04
     * @param total
     * @param num
     * @return
     */
    public static String getRandomNumber(int total){
    	int rand=new Random().nextInt(total)+1;
    	return rand+"";
    }
    
    public static void main(String[] args) {
		System.out.println(getRandomNumber(3));
	}
}
