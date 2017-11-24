package cs;

import java.util.HashMap;
import java.util.Map;

import com.icinfo.framework.core.test.SpringControllerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.sment.service.IBaseinfoDataSyncService;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.framework.core.test.SpringTxTestCase;

@SuppressWarnings("all")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
//@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class IBaseinfoDataSyncServiceTest extends SpringTxTestCase{

	@Autowired
	IBaseinfoDataSyncService service;
	
	@Autowired
	ISmBaseinfoService service2;

	@Test
	public void run() throws Exception{
//		service.insertSmentInc();
//		System.err.println("\n"+service.selectSyncCountForBaseinfo(qryMap));
	}
	
//	@Test
	public void run2() throws Exception{
//		System.err.println("\n"+service2.selectOneForCompare("3301810000154554").size());
	}

//	@Test
	public void insertOneFromCsMidBaseinfo() throws Exception{
		service2.deleteByPriPID("3301810000154554");
//		service2.insertOneFromCsMidBaseinfo("3302293000033157");
	}
}
