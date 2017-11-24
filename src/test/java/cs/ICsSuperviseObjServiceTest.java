package cs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.framework.core.test.SpringTxTestCase;

/**
 * 测试类
 * 
 * @author zhuyong
 */
@SuppressWarnings("all")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class ICsSuperviseObjServiceTest extends SpringTxTestCase{
	@Autowired
	ICsSuperviseObjService service;
	
	@Test
	public void methodTest() throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("entName", "杭州");
		List<CsSuperviseObjDto> list = service.queryListPage(null);
		for (CsSuperviseObjDto dto : list) {
			System.out.println(dto);
		}
		
	}
}
