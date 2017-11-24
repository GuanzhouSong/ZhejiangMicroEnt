package com.icinfo.cs.es.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.icinfo.cs.common.utils.DateUtil;

import cn.gov.zj.gsj.v2.api.DefaultGsjClient;
import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;
import cn.gov.zj.gsj.v2.sys.ApiException;

/**
 * 工商云平台操作-相关工具类
 * 
 * @author zhuyong
 */
@SuppressWarnings("all")
public class EsGsTest {
	


	/**
	 * 更新索引 根据_id来更新，无：插入 有：覆盖
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
		request.setType("single");// single是1条1插，batch是累积到1000条才插入
		client.excute(request);
	}

	/**
	 * 删除索引
	 * 
	 * @author zhuyong
	 * @param client
	 * @param ids
	 * @param idxName
	 * @throws ApiException
	 */
	public static void deleteIndex(GsjClient client, List<String> ids, String idxName) throws ApiException {
		IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
		indexDeleteRequest.setIds(ids);
		indexDeleteRequest.setIndex(idxName);
		client.excute(indexDeleteRequest);
	}

	
	
	
	/**
	 * 查询
	 * 测试用
	 * 
	 * @author zhuyong
	 * @param client
	 * @param sql
	 * @throws ApiException
	 */
	public static void queryIndex(GsjClient client, String sql) throws ApiException {
		IndexQueryRequest request = new IndexQueryRequest();
		request.setSql(sql);
		IndexQueryResponse response = client.excute(request);

		if (response.getErrorCode().isEmpty()) {
			System.out.println(response.getResult());
		} else {
			System.out.println(response.getErrorCode());
			System.out.println(response.getMessage());
		}

	}

	
	/**
	 * 初始化GsjClient 作为读端使用
	 * 测试用
	 *
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	private static GsjClient getClient() throws Exception {
		String serverUrl = "http://59.202.25.69/";// 例如: http://59.202.25.69/  结尾的斜杠不要漏了
		String user = "csuser";// 要操作的数据库用户名
		String password = "csuserdb";// 数据库密码
		return new DefaultGsjClient(serverUrl, user, password);// 初始化一个GsjClient
	}
	
	
	/** 测试方法 */
	public static void main(String[] args) throws Exception {
		List<String>list = DateUtil.getYearToNow();
//		 String jsonData =
//		 "{\"name\":\"杭州网新科技有限公司\",\"nameppl\":\"杭州网新科技有限公司\","
//		 + "\"regno\":\"123423453456\",\"uniscid\":\"2252AGFJH34553EE\","
//		 + "\"regcap\":\"2200.10\",\"estdate\":\"20150808101110\"}";
//		//
		String idxName = "anls_es";
		GsjClient client = getClient();
//		 String _id = "3000";
//		 updateIndexBySingle(client, idxName, _id, jsonData);
//		String sql = "select * from anls_es ";
//		 String sql = "select * from anls_es where nameppl = matchQuery('杭州公司') order by _score desc ";
		 String sql = "select * from anls_cs_mid_baseinfo_pub where priPID = '3301810000151901' ";
//		 String sql = "select * from anls_hx where estdate > '20140808101010' ";
		queryIndex(client, sql);
		// List<String> ids = new ArrayList<String>();
		// ids.add("200001");
		// ids.add("3000");
		// ids.add("1000");
		// ids.add("2000");
		// deleteIndex(client, ids, idxName);

		
	}

}
