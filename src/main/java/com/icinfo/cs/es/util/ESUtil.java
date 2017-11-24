package com.icinfo.cs.es.util;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author bai 2016-7-19
 */
@Component
public class ESUtil {
	@Value("${es.ip}")
	private String esHost;// es服务器的ip

	@Value("${es.port}")
	private String esPort;// es服务器的端口

	/**
	 * 
	 * 描述             : 组装es的boolQuery json字符串 
	 * @author: 赵祥江
	 * @date  : 2016年7月21日 上午8:56:37 
	 * @param : QueryBuilder  查询条件
	 * @param : startNum 分页 查询的开始条数
	 * @param : endNum   分页 取多少条
	 * @return: String   返回json格式字符串
	 * @throws
	 */
	public   static String toBoolQueryStr(QueryBuilder bueryBuilder,int startNum,int endNum){
		StringBuffer sb=new StringBuffer();
		sb.append("{ \"query\" :  ");
		sb.append(bueryBuilder);
		sb.append(",\"from\":"+startNum+",");
		sb.append("\"size\":"+endNum+"");
		sb.append("}");
		return  sb.toString();
	} 

}
