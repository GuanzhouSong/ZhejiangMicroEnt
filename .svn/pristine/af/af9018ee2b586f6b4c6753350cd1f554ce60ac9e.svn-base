package cs;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.es.service.ICsMidPersonService;
import com.icinfo.framework.core.test.SpringTxTestCase;

@SuppressWarnings("all")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class ICsMidPersonServiceTest extends SpringTxTestCase{
	
	@Autowired
	ICsMidPersonService service;
	
	@Test
	public void test() throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("keyword", "张玮兰");
		service.queryList(map);
	}
}
