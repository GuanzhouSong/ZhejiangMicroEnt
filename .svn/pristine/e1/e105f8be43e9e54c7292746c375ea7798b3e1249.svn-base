/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package cs;


import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.framework.core.test.SpringTxTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * 描述:  .<br>
 *
 * @author xiajunwei
 * @date 2016年04月20日
 */
public class PubopdadetailServiceTest extends SpringTxTestCase {
	    @Autowired
	    private IPubOpaDetailService pubopdadetailService;
	    
	    
	    @Test
	    // 如果你需要真正插入数据库,将Rollback设为false
	     @Rollback(false)
	    public void testSaveLightInfoReport() throws Exception {

	    	String busExcList = "ad33aee6914c11e6b98600188b839ae8";
	    	String priPID = "3301220000092469";
	    	PubOpaDetail pubOpaDetail = pubopdadetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
	    	System.out.println("成功");
    
    }

    
}
