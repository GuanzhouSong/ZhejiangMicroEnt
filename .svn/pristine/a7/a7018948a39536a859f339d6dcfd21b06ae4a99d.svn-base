package com.icinfo.cs.es.test;
import java.util.ArrayList;
import java.util.List;

import cn.gov.zj.gsj.v2.api.DefaultGsjClient;
import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexDeleteResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexQueryResponse;
import cn.gov.zj.gsj.v2.sys.ApiException;

/**
 * 
 * 中澳提供的demo源码
 * 
 * @author zhuyong
 */
public class ESTest {
	private static GsjClient client;
	static {
		String serverUrl = "http://59.202.25.69/"; // 例如: http://59.202.25.69/  http://localhost:8080/
//		String serverUrl = "http://59.202.59.40/";
		String user = "csuser";
		String password = "csuserdb";
		// 初始化一个GsjClient
		client = new DefaultGsjClient(serverUrl, user, password);
	}
	
	public static void main(String[] args) throws ApiException {
//		System.err.println("\n注意是测试云环境还是正式云环境\n注意是测试云环境还是正式云环境\n注意是测试云环境还是正式云环境\n 40-正式环境          69-测试环境");
//		System.err.println("\n60秒后开始执行.....");
//		try { Thread.sleep(60000); } catch (InterruptedException e) { }//确认操作是否有误
//		testSqlDeleteIndexRequest();
//		testExcuteIndexInsert();
//		testDeleteIndexRequest();
//		testSqlDeleteIndexRequest();
		//testExcuteIndexQuery1();
		testSqlDeleteIndexRequest();
	}
	
	public static void  testExcuteIndexQuery1() throws ApiException{
        IndexQueryRequest request = new  IndexQueryRequest();
//        request.setSql("select count(*) from anls_cs_idx_panorama WHERE  (entTypeCatg in ('50')) AND localAdm IN (33028102) AND regOrg IN (330281) AND regState IN ('K','B','A','DA','X') AND estDate <'20170101000000' AND (yrIsRep2016='0') AND (yrRepState2016 in ('00','10','12','11','13','20'))");//索引查询sql
        //request.setSql("select count(*) from anls_cs_idx_panorama WHERE  entTypeCatg IN (50) AND regState IN ('K','B','A','DA','X') and ( (yrIsRep2014 in (0) AND estDate <'20150101000000') and  (yrIsRep2013 in (0) AND estDate <'20140101000000'))");//索引查询sql
        request.setSql("select count(*) from anls_sment_baseinfo");
        //request.setSql("select count(*) from anls_cs_idx_panorama where yrIsRep2015='1'");
        //request.setSql("select count(*) from anls_cs_idx_panorama where yrIsRep2015='2'");//索引查询sql
        IndexQueryResponse response = client.excute(request);
        if(response.getErrorCode().isEmpty()){
        	  System.out.println(response.getResult());
        }else{
        	 System.out.println(response.getErrorCode());
        	 System.out.println(response.getMessage());
        }
      
    }
    public static void  testExcuteIndexQuery2() throws ApiException{
        IndexQueryRequest request = new  IndexQueryRequest();
        request.setIndex("anls_test");//索引名
        request.setFields("dff");//索引字段
        request.setValue("*");//查询值
        request.setFrom(0);//查询起始
        request.setSize(100);//查询数量
        request.setSortFiled("name");//排序字段
        request.setSortType("desc");//排序方式desc或者asc
        IndexQueryResponse response = client.excute(request);
        if(response.getErrorCode().isEmpty()){
      	  	System.out.println(response.getResult());
        }else{
        	System.out.println(response.getErrorCode());
        	System.out.println(response.getMessage());
        }
    }
    
    public static void testExcuteIndexInsert() throws ApiException{
        IndexInsertRequest request = new IndexInsertRequest();
        request.setIndex("anls_sment_baseinfo");//索引名
        request.setKey("1310822000002465");//主键_ID的值
        request.setJsonData("{\"entName\":\"临海市鹏程纺织配件厂\",\"entNamePPL\":\"临海市鹏程纺织配件厂\",\"regNO\":\"3310821002462\",\"dom\":\"临海市尤溪镇陈加村\",\"leRep\":\"程岳彪\",\"entType\":\"11\",\"regState\":\"K\",\"priPID\":\"1310822000002465\"}");//要插入的字段名和字段值
        request.setType("single");//single是1条1插，batch是累积到1000条才插入
        IndexInsertResponse response = client.excute(request);
        if(response.getErrorCode().isEmpty()){
      	  	System.out.println(response.getResult());
        }else{
        	System.out.println(response.getErrorCode());
        	System.out.println(response.getMessage());
        }
    }
	
    public static void testDeleteIndexRequest() throws ApiException {
        IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
        List<String> ids = new ArrayList<String>();
        ids.add("1234");
        ids.add("4444");
        indexDeleteRequest.setIds(ids);
        indexDeleteRequest.setIndex("anls_test");
        IndexDeleteResponse response = client.excute(indexDeleteRequest);

        if(response.getErrorCode().isEmpty()){
      	  	System.out.println(response.getResult());
        }else{
        	System.out.println(response.getErrorCode());
        	System.out.println(response.getMessage());
        }
    }
    
    public static void testSqlDeleteIndexRequest() throws ApiException {
        IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
        indexDeleteRequest.setSql("delete from anls_cs_idx_panorama");
        IndexDeleteResponse response = client.excute(indexDeleteRequest);
        
        if(response.getErrorCode().isEmpty()){
      	  	System.out.println(response.getResult());
        }else{                                                                          
        	System.out.println(response.getErrorCode());
        	System.out.println(response.getMessage());
        }
    }
    
	
}
