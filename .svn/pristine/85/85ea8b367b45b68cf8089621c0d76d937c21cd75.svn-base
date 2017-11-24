package com.icinfo.cs.common.utils;



import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * 把字符串转化成sql的in里面的字符串
 * Created by hzhb on 2016/11/2.
 */
public class StringToInUtil {

   /**
     * 把字符串改成in格式---工具方法
     * @param params
     * @return
     */
    public static Map strToIn(Map params){
        if(params==null)return new HashedMap();

        if(StringUtil.isNotEmpty((String) params.get("regOrg"))){
            params.put("regOrg","'"+((String) ((String) params.get("regOrg")).substring(0, ((String) params.get("regOrg")).length()-1)).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("localAdm"))){
            params.put("localAdm","'"+((String) params.get("localAdm")).substring(0, ((String) params.get("localAdm")).length()-1).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("street"))){
            params.put("street","'"+((String) params.get("street")).substring(0, ((String) params.get("street")).length()-1).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("entType"))){
            params.put("entType","'"+((String) params.get("entType")).substring(0, ((String) params.get("entType")).length()-1).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("sliceNo"))){
            params.put("sliceNo","'"+((String) params.get("sliceNo")).substring(0, ((String) params.get("sliceNo")).length()-1).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("sliceNO"))){
            params.put("sliceNO","'"+((String) params.get("sliceNO")).substring(0, ((String) params.get("sliceNO")).length()-1).replaceAll(",","','")+"'");
        }
        if(StringUtil.isNotEmpty((String) params.get("industryCo"))){
            params.put("industryCo","'"+((String) params.get("industryCo")).substring(0, ((String) params.get("industryCo")).length()-1).replaceAll(",","','")+"'");
        }
        return params;
    }
    
    
    public static Map strToIns(Map params){
        if(params==null)return new HashedMap();

        if(StringUtil.isNotEmpty((String) params.get("regOrg"))){
            params.put("regOrg",StringUtil.doSplitStringToSqlFormat(params.get("regOrg").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("localAdm"))){
            params.put("localAdm",StringUtil.doSplitStringToSqlFormat(params.get("localAdm").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("street"))){
            params.put("street",StringUtil.doSplitStringToSqlFormat(params.get("street").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("entType"))){
            params.put("entType",StringUtil.doSplitStringToSqlFormat(params.get("entType").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("sliceNo"))){
            params.put("sliceNo",StringUtil.doSplitStringToSqlFormat(params.get("sliceNo").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("sliceNO"))){
            params.put("sliceNO",StringUtil.doSplitStringToSqlFormat(params.get("sliceNO").toString(),","));
        }
        if(StringUtil.isNotEmpty((String) params.get("industryCo"))){
            params.put("industryCo",StringUtil.doSplitStringToSqlFormat(params.get("industryCo").toString(),","));
        }
        return params;
    }
   
}
