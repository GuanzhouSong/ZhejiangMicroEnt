package gscloud;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.gov.zj.gsj.v1.api.DefaultGsjClient;
import cn.gov.zj.gsj.v1.api.GsjClient;
import cn.gov.zj.gsj.v1.obj.entity.InputData;
import cn.gov.zj.gsj.v1.obj.entity.InputRequest;
import cn.gov.zj.gsj.v1.obj.entity.InputResponse;
import cn.gov.zj.gsj.v1.sys.ApiException;

public class DbGsTest {
	
	public static void main(String[] args) {
		System.out.println("start...");
		long t1 = System.currentTimeMillis();
		String tableName = "cs_pub_scinfo";
		List<InputData> dataList = new ArrayList<InputData>();
		InputData bean;
		for (int i = 0 ; i<50000 ;i++) {
			bean = new InputData();
			bean.putData("TaskNO", "111111111111");
			bean.putData("PriPID", "222222222222");
			bean.putData("EntName", "浙江测试企业有限公司");
			bean.putData("UniCode", "3333333333333");
			bean.putData("RegNO", "444444444444");
			bean.putData("LeRep", "张三");
			bean.putData("OpLoc", "浙江省工商");
			bean.putData("RegOrg", "555555555555");
			bean.putData("RegOrgDesc", "杭州市局");
			bean.putData("EstDate", "2010-01-01");
			bean.putData("EntTypeCatg", "666");
			bean.putData("IndustryDesc", "落霞与孤鹜齐飞");
			bean.putData("LocalAdml", "秋水共长天一色");
			bean.putData("Remark", "<html><head></head><body>2938u5qp293490q283u4092834790123845urpasiejfo isdfq239r8uqwpeirjqwuer098q23jr;okwq3jopr89u239joqI348409283U49P283</body></html>");
			bean.putData("CreateTime", "2016-01-10");
			dataList.add(bean);
		}
		inputManyInstance("", dataList, tableName);
		long t2 = System.currentTimeMillis();
		System.out.println("执行程序耗时：" + (t2-t1) + "ms");
		System.out.println("end...");
		
	}

	public static void inputManyInstance(String xid,List<InputData> dataList,String tableName) {
		long time1 = System.currentTimeMillis();
		String serverUrl = "http://59.202.25.69/";// 例如:http://59.202.28.159/ ，结尾的斜杠不要漏了
		String user = "csuser";//要操作的数据库用户名
		String password = "csuserdb";//数据库密码
		GsjClient client = new DefaultGsjClient(serverUrl, user, password);// 初始化一个GsjClient
		
		InputRequest inputRequest = new InputRequest();
		inputRequest.setIp("59.202.28.95");//数据库IP
		inputRequest.setDb("zjcsdb");//数据库名
		inputRequest.setTable(tableName);//表名
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
			e.printStackTrace();
		}
		long time4 = System.currentTimeMillis();
		System.out.println("插入共耗时"+(time4-time1)+"毫秒");
	}
}
