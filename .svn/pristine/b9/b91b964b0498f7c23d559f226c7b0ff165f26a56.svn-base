/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package cs;

import java.util.HashMap;
import java.util.Map;

import com.icinfo.cs.dtinfo.service.IPubDtInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.test.SpringTxTestCase;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * 描述:  .<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
public class YrRegCheckServiceTest extends SpringTxTestCase {
	    @Autowired
	    private IYrRegCheckService yrRegCheckService;
	    @Autowired
	    private IPubDtInfoService pubDtInfoService;
	    
	    
	    @Test
	    // 如果你需要真正插入数据库,将Rollback设为false
	     @Rollback(false)
	    public void testSaveLightInfoReport() throws Exception {

	    	PageRequest request = new PageRequest();
	        Map<String, Object> map = new HashMap<String, Object>();   
	        map.put("year", 2015);
	        request.setStart(0);
	        request.setPageNum(0);
	    	request.setLength(10);
	    	request.setParams(map);
	    	
//	    	yrRegCheckService.selectPbReceiveQueryPage(request);
    
    }

    
}
