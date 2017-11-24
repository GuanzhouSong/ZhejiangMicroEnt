package com.icinfo.cs.es.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.dto.SmEntSearchDto;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;

/**
 * 工商云平台es操作-相关工具类
 * 
 * @author zhuyong
 */
public class EsGsUtil {
	
	/**
	 * 更新索引 根据_id来更新
	 * 
	 * @author zhuyong
	 * @throws Exception
	 */
	public static void updateIndexBySingle(GsjClient client, String idxName, String _id, String jsonData)
			throws Exception {
		IndexInsertRequest request = new IndexInsertRequest();
		request.setIndex(idxName);// 索引名
		request.setKey(_id);// 主键_ID的值
		request.setJsonData(jsonData);// 要插入的字段名和字段值
		request.setType("single");// single是1条1插
		client.excute(request);
	}
	
	
	/**
	 * 云平台执行搜索sql
	 * 
	 * @author zhuyong
	 * @param sql
	 * @param client
	 * @return
	 * @throws Exception
	 */
	public static IndexQueryResponse getQueryRep(String sql,GsjClient client) throws Exception{
		IndexQueryRequest query = new  IndexQueryRequest();
		query.setSql(sql);
		return client.excute(query);
	}
	
	/**
	 * 根据请求的返回字符串，获取返回总结果条数
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public static Integer getRstTotal(JSONObject json) throws Exception{
		return (Integer)json.get("total");
	}
	
	/**
	 * 判断 某一列 中是否存在并且有值
	 * key is exists
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static boolean KIE(Map<String,Object> map,String field){
		if(!map.containsKey(field))
			return false;
		if(map.get(field) == null) 
			return false;
		return StringUtils.isNotBlank(map.get(field).toString());
	}
	
	/**
	 * 获取前一天的日期
	 * 目的：解决ES查询时日期查询大于等于的问题
	 * before one day 
	 * 
	 * @author zhuyong
	 * @param strDate
	 * @return
	 */
	public static String BOD(String strDate){
		return DateUtil.getNdaylater2(DateUtil.stringToDate(strDate, "yyyy-MM-dd") , -1);
	}
	
	/**
	 * 获取后一天的日期
	 * 目的：解决ES查询时日期查询大于等于的问题
	 * after one day 
	 * 
	 * @author zhuyong
	 * @param strDate
	 * @return
	 */
	public static String AOD(String strDate){
		return DateUtil.getNdaylater2(DateUtil.stringToDate(strDate, "yyyy-MM-dd") , 1);
	}
	
	/**
	 * 获取下一年年初
	 * get next year
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static String GNY(String yrYear){
		return (Integer.parseInt(yrYear)+1) + "-01-01";
	}
	
	/**
	 * 格式化日期格式，用作云平台日期比较
	 * 
	 * @author zhuyong
	 * @param date
	 * @return
	 */
	public static  String FCD(String date){
		return "'" + date.replaceAll("-", "") + "000000'";
	}
	
	/**
	 * 获取map中某一元素的值
	 * map get value
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static String MGV(Map<String,Object> map,String field){
		return map.get(field) + "";
	}
	
	/**
	 * 检查平RIPID是否为空
	 * 
	 * @author zhuyong
	 * @param jsonMap
	 * @return
	 */
	public static boolean checkPriPIDIsBlank(Map<String,Object> jsonMap){
		return (jsonMap == null || !jsonMap.containsKey("priPID") || "".equals(jsonMap.get("priPID")+"")); 
	}
	
	/**
	 * 将返回字符串转成json对象
	 * 
	 * @author zhuyong
	 * @param reqStr
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getJsonObj(String reqStr) throws Exception{
		return JSONObject.parseObject(reqStr).getJSONObject("hits");
	}
	
	/**
	 * 将es的返回结果解析为jsonArray
	 * 
	 * @author zhuyong
	 * @param reqStr
	 * @return
	 * @throws Exception
	 */
	public static JSONArray parseEsReqResult(JSONObject json) throws Exception{
		return json.getJSONArray("hits");
	}
	
	/**
	 * 描述： 将jsonarray类型的数据转成全景查询结果集
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public static List<PanoramaResultDto> jsonArr2List(JSONArray jsonArr) throws Exception {
		List<PanoramaResultDto> dataList = new ArrayList<PanoramaResultDto>();
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArr.get(i);
			JSONObject appObj = jsonObj.getJSONObject("_source");
			dataList.add((PanoramaResultDto) JSONObject.toJavaObject(appObj, PanoramaResultDto.class));
		}
		return dataList;
	}
	
	/**
	 * 描述： 将jsonarray类型的数据转成小微企业查询结果集
	 * 
	 * @author baifangfang
	 * @return
	 * @throws Exception
	 */
	public static List<SmEntSearchDto> jsonArr2ListSmEnt(JSONArray jsonArr) throws Exception {
		List<SmEntSearchDto> dataList = new ArrayList<SmEntSearchDto>();
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonArr.get(i);
			JSONObject appObj = jsonObj.getJSONObject("_source");
			dataList.add((SmEntSearchDto) JSONObject.toJavaObject(appObj, SmEntSearchDto.class));
		}
		return dataList;
	}
	
	/**
	 * 用map中的数据更新json对象
	 * 
	 * @author zhuyong
	 * @param jsonObj
	 * @param updMap
	 * @return
	 * @throws Exception
	 */
	public static net.sf.json.JSONObject updateJsonObj(net.sf.json.JSONObject jsonObj,Map<String,Object> updMap,String cloudOpen,String cloudModel) throws Exception{
		Iterator<String> keys = updMap.keySet().iterator(); 
		while(keys.hasNext()){ 
		   String key = (String) keys.next();
		   jsonObj.put(key, formatUpdateDate(updMap.get(key)+"",cloudOpen,cloudModel));
		} 
		return jsonObj;
	}
	
	/**
	 * 格式化日期
	 * 需要兼容云平台和原生es两种日期格式
	 * 
	 * @param param
	 * @param cloudOpen
	 * @param cloudModel
	 * @return
	 * @throws Exception
	 */
	private static String formatUpdateDate(String param,String cloudOpen,String cloudModel) throws Exception{
		if(StringUtils.isBlank(param))  return null;
		if(!param.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) 
			return param;
		
		if(cloudOpen.equalsIgnoreCase(cloudModel)){
			return param.replaceAll("-", "")+"000000";//云平台日期格式
		}
		
		return param + "T00:00:00.000+08:00";
	}
}
