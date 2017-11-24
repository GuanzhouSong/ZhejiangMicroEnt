package cs;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.sment.model.SmBaseinfoHis;
import com.icinfo.cs.sment.service.ISmBaseinfoHisService;
import com.icinfo.framework.core.test.SpringTxTestCase;

@SuppressWarnings("all")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class SmBaseinfoHisServiceTest extends SpringTxTestCase{

	@Autowired
	private ISmBaseinfoHisService smBaseinfoHisService;
	@Test
	public void test() throws Exception{
		SmBaseinfoHis smBaseinfoHis = new SmBaseinfoHis();
		System.out.println(smBaseinfoHisService);
		System.out.println("*************************************************");
		int i = smBaseinfoHisService.insertSmBaseinfoHis(smBaseinfoHis);
		System.out.println(i);
	}
	
}
