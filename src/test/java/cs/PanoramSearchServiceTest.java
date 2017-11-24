package cs;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.copysend.dto.CopySendDto;
import com.icinfo.cs.copysend.service.ICopySendService;
import com.icinfo.cs.es.dto.PanoramaSearchDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.framework.core.test.SpringTxTestCase;

/**
 * 全景查询方法测试类
 * 
 * @author zhuyong
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class PanoramSearchServiceTest extends SpringTxTestCase {

	@Autowired
	IPanoramaSearchService iPanoramaSearchSercice;
//	@Autowired
//	ICopySendService copySendService;
	
	@Test
	public void doGetSearchListTest() throws Exception{
		iPanoramaSearchSercice.doGetSearchList("浙江");
		
//		System.out.println(iPanoramaSearchSercice.doGetSearchList(null));
//		List<PanoramaSearchDto> list = iPanoramaSearchSercice.doGetSearchList("浙江");
//		for (PanoramaSearchDto panoramaSearchDto : list) {
//			System.err.println(panoramaSearchDto);
//		}
		
		
//		CopySendDto copySend = new CopySendDto();
//		Map<String, Object> qryMap = new HashMap<>();
//		copySend.setCheckDate(new Date());
//		System.out.println("--------------------");
////		List<CopySendDto> aa = copySendService.queryPageOfSend(null);
//		if(aa.size()>0){
//			System.out.println(11);
//			System.out.println(aa.get(0).toString());
//		}else{
//			System.out.println(22);
//		}
//		System.out.println("--------------------");
		
	}
	@Test
	public void insert() throws Exception{
		
	}
	
//	@Test
//	public void methodTest() throws Exception{
//		iPanoramaSearchService2.doInsertIndexToGs();
//	}
}
