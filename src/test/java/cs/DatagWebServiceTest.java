/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.icinfo.cs.dtinfo.service.IPubDtInfoService;
import com.icinfo.cs.webservice.service.IWsMidLerepService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.test.SpringTxTestCase;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * 描述:  datagws测试类
 *
 * @author ylr
 * @date 2017年02月16日
 */
public class DatagWebServiceTest extends SpringTxTestCase {
	    @Autowired
	    private IWsMidLerepService wsMidLerepService;
//	    @Autowired
//	    private IPubDtInfoService pubDtInfoService;
	    
	    
	    @Test
	    // 如果你需要真正插入数据库,将Rollback设为false
	     @Rollback(false)
	    public void test() throws Exception {
	    	String url = "http://localhost:8082/webservice/midlerep/wsmidlerepcount.json?startdate=20161204120450&enddate=20161205120450";
	 	        StringBuilder json = new StringBuilder();
	 	        try {
	 	            URL urlObj = new URL(url);
	 	            URLConnection yc = urlObj.openConnection();
	 	            BufferedReader in = new BufferedReader(new InputStreamReader(
	 	                                        yc.getInputStream()));
	 	            String inputLine = null;
	 	            while ( (inputLine = in.readLine()) != null) {
	 	                json.append(inputLine);
	 	            }
	 	            in.close();
	 	            JSONObject jsonObject = JSONObject.fromObject(json);
	 	            System.out.println(jsonObject.getInt("data"));
	 	        } catch (MalformedURLException e) {
	 	        	System.out.println("1111");
	 	        } catch (IOException e) {
	 	        	System.out.println("2222");
	 	        }
	    	
    
    }

    
}
