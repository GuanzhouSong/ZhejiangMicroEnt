package com.icinfo.cs.common.tag;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;

/**
 * 描述： 自定义函数标签  <BR>
 * Author: wangjin<BR>
 * Date：2016-03-24 <BR>
 */
public class HxFunctions {

    /**
     *  年份字符串加密
     * @author: wangjin
     * @param str
     * @return
     */
    public static String encodeYear( String str){
        return AESEUtil.encodeYear(str);
    }

    /**
     *  内部序号字符串加密
     * @author: wangjin
     * @param str
     * @return
     */
    public static String encodePripid( String str){
        return AESEUtil.encodeCorpid(str);
    }


    /**
     * 描述：根据传递进来的登记状态编码 生成对应的文字表述
     * @param code
     * @return
     */
    public static String publicStatus(String code){

        String [] str1_arry = {"K","B","A","Q","X"}; //存续
        String [] str2_arry = {"XX","DX"};           //注销
        String str3 = "C";  //撤销
        String [] str4_arry = {"D","DA"};  //吊销
        String str5 = "QX";  //迁出

        if(StringUtil.isHave(str1_arry,code)){return "存续";}
        if(StringUtil.isHave(str2_arry,code)){return "注销";}
        if(StringUtil.equalsIgnoreCase(str3,code)){return "撤销";}
        if(StringUtil.isHave(str4_arry,code)){return "吊销";}
        if(StringUtil.equalsIgnoreCase(str5,code)){return "迁出";}

        return "";
    }


    /**
     * 描述：根据传递进来的登记状态编码 生成对应的style  年报后台详情
     * @param code
     * @return
     */
    public static String yReportStyle(String code){  //yReportStyle

        String [] str1_arry = {"K","B","A","Q","X"}; //存续
        String [] str2_arry = {"XX","DX"};           //注销
        String str3 = "C";  //撤销
        String [] str4_arry = {"D","DA"};  //吊销
        String str5 = "QX";  //迁出

        if(StringUtil.isHave(str1_arry,code)){return "icon-rectangle green fl mr10";}  //存续
        if(StringUtil.isHave(str2_arry,code)){return "icon-rectangle gray fl mr10";}  //注销
        if(StringUtil.equalsIgnoreCase(str3,code)){return "icon-rectangle green fl";} //撤销
        if(StringUtil.isHave(str4_arry,code)){return "icon-rectangle red fl";} //吊销
        if(StringUtil.equalsIgnoreCase(str5,code)){return "icon-rectangle blue fl";}  //迁出

        return "";
    }




    /**
     * 描述：根据传递进来的登记状态编码 生成对应的style  公示
     * @param code
     * @return
     */
    public static String publicStatusStyle(String code){

        String [] str1_arry = {"K","B","A","Q","X"}; //存续
        String [] str2_arry = {"XX","DX"};           //注销
        String str3 = "C";  //撤销
        String [] str4_arry = {"D","DA"};  //吊销
        String str5 = "QX";  //迁出

        if(StringUtil.isHave(str1_arry,code)){return "icon-blue";}  //存续
        if(StringUtil.isHave(str2_arry,code)){return "icon-gray";}  //注销
        if(StringUtil.equalsIgnoreCase(str3,code)){return "icon-gray";} //撤销
        if(StringUtil.isHave(str4_arry,code)){return "icon-red";} //吊销
        if(StringUtil.equalsIgnoreCase(str5,code)){return "icon-gray";}  //迁出

        return "";
    }




}
