package cs;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.framework.core.test.SpringTxTestCase;

/**
 * 全景查询方法测试类
 * 
 * @author zhuyong
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class IMidMemberServiceTest extends SpringTxTestCase{
	@Autowired
	IMidMemberService service;
	
	@Test
	public void methodTest() throws Exception{
		List<MidMemberDto> dtos = service.queryListResult("1310822000002504");
		for (MidMemberDto midMemberDto : dtos) {
			System.err.println(midMemberDto.getPosiContent());
		}
		
	}
}
