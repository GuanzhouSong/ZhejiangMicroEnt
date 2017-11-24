package gscloud;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import cn.gov.zj.gsj.v1.api.DefaultGsjClient;
import cn.gov.zj.gsj.v1.api.GsjClient;
/**
 * 云数据库相关操作测试
 * 
 * @author zhuyong
 */
public class SqlForFile {

	private static GsjClient client;
	
	private static String ip = "59.202.28.95";
	private static String db = "zjcsdb";

	static {
		String serverUrl = "http://59.202.25.69/";// 例如:http://59.202.28.159/   // ，结尾的斜杠不要漏了
		String user = "csuser";// 要操作的数据库用户名
		String password = "csuserdb";// 数据库密码
		client = new DefaultGsjClient(serverUrl, user, password);// 初始化一个GsjClient
	}
	
	/**
	 * 测试插入
	 * 
	 * @throws Exception
	 */
	public static void testInsert() throws Exception{
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。

		CrudClould cc = new CrudClould();

		try {
			String str = "";
			String str1 = "";
			fis = new FileInputStream("F:\\123.sql");// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
			while ((str = br.readLine()) != null) {
				String sql = str;
				System.out.println(str);
				HashMap<String, String> hm = cc.queryInstance(client, ip, db, sql);

				String result = hm.get("result");
				if (null == result || "".equals(result)) {

				} else if ("success".equals(result)) {
					// String data = hm.get("data");
					// getJson(data);

				} else if ("error".equals(result)) {
					System.out.println("errorCode : " + hm.get("errorCode") + " message : " + hm.get("message"));
				}
			}
			// 当读取的一行不为空时,把读到的str的值赋给str1
			System.out.println(str1);// 打印出str1

		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 删除方法测试
	 * 
	 * @throws Exception
	 */
	public static void testDelete() throws Exception{
		CrudClould cc = new CrudClould();
		cc.deleteInstance(client, ip, db, "cs_lic_dept","");
	}

	public static void main(String[] args) throws Exception{
//		testDelete();
		testInsert();
	}
}
