package gscloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.gov.zj.gsj.v1.api.GsjClient;
import cn.gov.zj.gsj.v1.obj.entity.DeleteRequest;
import cn.gov.zj.gsj.v1.obj.entity.DeleteResponse;
import cn.gov.zj.gsj.v1.obj.entity.InputData;
import cn.gov.zj.gsj.v1.obj.entity.InputRequest;
import cn.gov.zj.gsj.v1.obj.entity.InputResponse;
import cn.gov.zj.gsj.v1.obj.entity.ModifyRequest;
import cn.gov.zj.gsj.v1.obj.entity.ModifyResponse;
import cn.gov.zj.gsj.v1.obj.entity.QueryRequest;
import cn.gov.zj.gsj.v1.obj.entity.QueryResponse;
import cn.gov.zj.gsj.v1.sys.ApiException;

/**
 * 工商云平台数据库相关方法操作
 *
 * @author zhuyong
 */
public class CrudClould {
	public void crudClould() {
	}

	/**
	 * 数据查询
	 * 
	 * @param client
	 * @param ip
	 * @param db
	 * @param table
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, String> queryInstance(GsjClient client, String ip, String db, String sql) {
		QueryRequest queryRequest = new QueryRequest();
		@SuppressWarnings("rawtypes")
		HashMap hmr = new HashMap();
		queryRequest.setIp(ip);// 数据库 IP
		queryRequest.setDb(db);// 数据库名
		queryRequest.setQuery(sql);// select
		// select // *
		queryRequest.setPageNum(0);// 查询起始，注意不是页数
		queryRequest.setPageSize(20);// 查询数量
		try {
			QueryResponse queryResponse = client.excute(queryRequest);
			System.out.println(queryResponse.getErrorCode());
			if (StringUtils.isEmpty(queryResponse.getErrorCode())) { // 执行成功
				String result = queryResponse.getResult(); // 获取结果信息
				System.out.println("result:" + result);
				hmr.put("result", "success");
				hmr.put("data", result);
				return hmr;
			} else {
				String errorCode = queryResponse.getErrorCode(); // 获取错误码
				String message = queryResponse.getMessage(); // 获取错误

				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
				hmr.put("result", "error");
				hmr.put("errorCode", errorCode);
				hmr.put("message", message);
				return hmr;

			}
		} catch (ApiException e) {
			e.printStackTrace();
		} finally {

			// client.
		}
		hmr.put("result", "error");
		hmr.put("errorCode", "111");
		hmr.put("message", "连接异常");
		return hmr;
	}

	/**
	 * 单条数据插入
	 * 
	 * @param client
	 * @param ip
	 * @param db
	 * @param table
	 */
	public void InputInstance(GsjClient client, String ip, String db, String table) {
		InputRequest inputRequest = new InputRequest();
		inputRequest.setIp(ip);// 数据库 IP
		inputRequest.setDb(db);// 数据库名
		inputRequest.setTable(table);// 表名
		InputData data = new InputData();
		data.putData("field", "test");// 字段名和字段值，字段值如果是日期格式则需使用"YYYY-MM-DD
										// hh:mm:ss"(长短按字段格式定)格式的字符串作为字段值填入
		data.putData("field2", "test2");
		data.putData("field3", "test3");
		inputRequest.setData(data);
		try {
			InputResponse inputResponse = client.excute(inputRequest);
			if (StringUtils.isEmpty(inputResponse.getErrorCode())) { // 执行成功
				String result = inputResponse.getResult(); // 获取结果信息

				System.out.println("result:" + result);
			} else {
				String errorCode = inputResponse.getErrorCode(); // 获取错误码
				String message = inputResponse.getMessage(); // 获取错误信息
				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
			}
		} catch (ApiException e) {
			// TODO: handle exception
		}
	}

	/**
	 * 多条数据
	 */
	public void InputManyInstance(GsjClient client, String ip, String db, String table) {
		InputRequest inputRequest = new InputRequest();
		inputRequest.setIp("59.202.28.95");// 数据库 IP
		inputRequest.setDb("TESTDB");// 数据库名
		inputRequest.setTable("testab");// 表名
		List<InputData> dataList = new ArrayList<InputData>();
		InputData data1 = new InputData();
		data1.putData("field", "test");// 字段名和字段值，字段值如果是日期格式则需使用"YYYY-MM-DD
										// hh:mm:ss"(长短按字段格式定)格式的字符串作为字段值填入
		data1.putData("field2", "test2");
		data1.putData("field3", "test3");
		dataList.add(data1);
		InputData data2 = new InputData();
		data2.putData("field", "test4");

		data2.putData("field2", "test5");
		data2.putData("field3", "test6");
		dataList.add(data2);
		inputRequest.setDatas(dataList);
		try {
			InputResponse inputResponse = client.excute(inputRequest);
			if (StringUtils.isEmpty(inputResponse.getErrorCode())) { // 执行成功
				String result = inputResponse.getResult(); // 获取结果信息
				System.out.println("result:" + result);
			} else {
				String errorCode = inputResponse.getErrorCode(); // 获取错误码
				String message = inputResponse.getMessage(); // 获取错误信息
				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
			}
		} catch (ApiException e) {
			// TODO: handle exception
		}
	}

	/**
	 * 更新操作
	 */
	public void ModifyInstance(GsjClient client, String ip, String db, String table) {
		ModifyRequest modifyRequest = new ModifyRequest();
		modifyRequest.setIp("59.202.28.95");// 数据库 IP
		modifyRequest.setDb("TESTDB");// 数据库名

		modifyRequest.setTable("testab");// 表名
		InputData data = new InputData();
		data.putData("field", "test8");// 字段名和字段值，字段值如果是日期格式则需使用"YYYY-MM-DD
										// hh:mm:ss"(长短按字段格式定)格式的字符串作为字段值填入
		data.putData("field2", "test88");
		data.putData("field3", "test888");
		modifyRequest.setWhere("id=1 and field=test");// where 条件，用于 updatesql
		modifyRequest.setData(data);
		try {
			ModifyResponse modifyResponse = client.excute(modifyRequest);
			if (StringUtils.isEmpty(modifyResponse.getErrorCode())) { // 执行成功
				String result = modifyResponse.getResult(); // 获取结果信息
				System.out.println("result:" + result);
			} else {
				String errorCode = modifyResponse.getErrorCode(); // 获取错误码
				String message = modifyResponse.getMessage(); // 获取错误信息
				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
			}
		} catch (ApiException e) {
			// TODO: handle exception
		}
	}

	/**
	 * 删除操作 若删除成功则返回值 result 为“success , 删除数据数量:n”，n 为删除的数据条数。
	 */
	public void deleteInstance(GsjClient client, String ip, String dbName, String tableName,String whereSql) {
		DeleteRequest deleteRequest = new DeleteRequest();
		deleteRequest.setIp("59.202.28.95");// 数据库 IP
		deleteRequest.setDb(dbName);// 数据库名
		deleteRequest.setTable(tableName);// 表名
		deleteRequest.setWhere(whereSql);// where 条件，用于 delete sql
		try {
			DeleteResponse deleteResponse = client.excute(deleteRequest);
			if (StringUtils.isEmpty(deleteResponse.getErrorCode())) { // 执行成功
				String result = deleteResponse.getResult(); // 获取结果信息
				System.out.println("result:" + result);
			} else {
				String errorCode = deleteResponse.getErrorCode(); // 获取错误码
				String message = deleteResponse.getMessage(); // 获取错误信息
				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
