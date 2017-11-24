package gscloud;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import cn.gov.zj.gsj.v1.api.DefaultGsjClient;
import cn.gov.zj.gsj.v1.api.GsjClient;
import cn.gov.zj.gsj.v1.obj.entity.InputData;
import cn.gov.zj.gsj.v1.obj.entity.InputRequest;
import cn.gov.zj.gsj.v1.obj.entity.InputResponse;
import cn.gov.zj.gsj.v1.obj.entity.QueryRequest;
import cn.gov.zj.gsj.v1.obj.entity.QueryResponse;
import cn.gov.zj.gsj.v1.sys.ApiException;
/**
 * 工商提供的demo 
 * 
 * @author zhuyong
 */
public class TestDemo {
	
	public static void main(String[] args) {
		queryInstance("1");
	}
	
	public static void queryInstance(String xid) {
		String serverUrl = "http://59.202.28.159/";// 例如:http://59.202.28.159/ ，结尾的斜杠不要漏了
		String user = "csuser";//要操作的数据库用户名
		String password = "csuserdb";//数据库密码
		// 初始化一个GsjClient
		GsjClient client = new DefaultGsjClient(serverUrl, user, password);
		QueryRequest queryRequest = new QueryRequest();
		queryRequest.setIp("59.202.28.95");//数据库IP
		queryRequest.setDb("zjcsdb");//数据库名
		queryRequest.setQuery("SELECT a.id,a.PriPID, a.EntName, a.RegNO,a.LeRep,a.EntType,a.UNICODE,a.CreateTime,a.LeRepPhone,a.Tel,a.PasID,a.PasStatus,a.LiaIDNum,a.LiaIDType,a.LiaName, b.RegOrg,b.LocalAdm,b.CheckDep, b.RegOrgName, b.LocalAdmName FROM cs_pub_phoneapply a INNER JOIN cs_mid_baseinfo b ON a.PriPID = b.PriPID WHERE a.PasStatus = '02' order by a.CreateTime Desc ");// sql，不支持select *,insert sql必须指定字段名
//		queryRequest.setXid(xid);//设置事务xid，设置xid则为对应xid的事务操作;不设或xid为空则为非事务操作
		queryRequest.setPageNum(0);//查询起始，注意不是页数。不是select语句则无需设置
		queryRequest.setPageSize(50000);//查询数量，不设置则默认返回所有结果。不是select语句则无需设置
		  List<InputData> dataList = new ArrayList<InputData>();
		try {
			long time1 = System.currentTimeMillis();
			long time2 = System.currentTimeMillis();
			QueryResponse queryResponse = client.excute(queryRequest);
			long time3 = System.currentTimeMillis();
			System.out.println("查询共耗时"+(time3-time2)+"时间");
			System.out.println(queryResponse.getErrorCode());
			if (StringUtils.isEmpty(queryResponse.getErrorCode())) { // 执行成功
				String result = queryResponse.getResult(); // 获取结果信息
				JSONArray json = JSONArray.fromObject(result);
				JSONObject jsonObj = null,sourceObj=null;
		        String priPID = "";
		        String entName = "";
		        String regno = "";
		        String lerep = "";
		        String localadmname = "";
		        String regorgname = "";
		        Object source = null;
				for (int i = 0; i < json.size(); i++) {
					sourceObj = (JSONObject) json.get(i);
					source = sourceObj.get("values");
					jsonObj = JSONObject.fromObject(source);
					InputData data = new InputData();
					priPID = jsonObj.get("pripid")+"";
					entName = jsonObj.get("entname")+"";
					regno = jsonObj.get("regno")+"";
//					checkdepname = jsonObj.get("checkdepname")+"";
//					dom = jsonObj.get("dom")+"";
//					domdistrict = jsonObj.get("domdistrict")+"";
//					industryco = jsonObj.get("industryco")+"";
					lerep = jsonObj.get("lerep")+"";
//					localadm = jsonObj.get("localadm")+"";
					localadmname = jsonObj.get("localadmname")+"";
//					localregorgcode = jsonObj.get("localregorgcode")+"";
					regorgname = jsonObj.get("regorgname")+"";
					data.putData("priPID", priPID);
					data.putData("entName", entName);
					data.putData("taskNO", priPID);
					data.putData("regNO", regno);
					data.putData("LeRep", lerep);
					data.putData("OpLoc", localadmname);
					data.putData("IndustryDesc", regorgname);
					data.putData("Remark", regorgname);
					dataList.add(data);
				}
				inputManyInstance(xid, dataList);
//				System.out.println("result:" + result);
			} else {
				String errorCode = queryResponse.getErrorCode(); // 获取错误码
				String message = queryResponse.getMessage(); // 获取错误信息
				System.out.println("errorCode:" + errorCode);
				System.out.println("message:" + message);
			}
			long time4 = System.currentTimeMillis();
			
			System.out.println("查询加插入共耗时"+(time4-time1)+"时间"+",插入数量："+dataList.size() );
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	

	public static void inputManyInstance(String xid,List<InputData> dataList) {
		long time1 = System.currentTimeMillis();
		String serverUrl = "http://59.202.25.69/";// 例如:http://59.202.28.159/ ，结尾的斜杠不要漏了
		String user = "csuser";//要操作的数据库用户名
		String password = "csuserdb";//数据库密码
		// 初始化一个GsjClient
		GsjClient client = new DefaultGsjClient(serverUrl, user, password);
		InputRequest inputRequest = new InputRequest();
		inputRequest.setIp("59.202.28.95");//数据库IP
		inputRequest.setDb("zjcsdb");//数据库名
		inputRequest.setTable("cs_pub_scinfo");//表名
//		inputRequest.setXid(xid);//设置事务xid，设置xid则为对应xid的事务操作;不设或xid为空则为非事务操作
		inputRequest.setDatas(dataList);
		inputRequest.setData(null);//为了防止意外塞入单条数据，导致批量不执行，必须设null，或者保证在批量插入的时候不要在这个里面设置数据。
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
		long time4 = System.currentTimeMillis();
		System.out.println("插入共耗时"+(time4-time1)+"时间");
	}
}
