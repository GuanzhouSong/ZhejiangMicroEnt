package cs;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.cs.im.dto.ImInvupdateDto;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.cs.im.service.IImInvupdateService;
import com.icinfo.framework.core.test.SpringTxTestCase;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 全景查询方法测试类
 * 
 * @author zhuyong
 */
@SuppressWarnings("all")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)  
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class IImInvupdateServiceTest extends SpringTxTestCase{
	@Autowired
	IImInvupdateService service;
	
	@Test
	public void methodTest() throws Exception{
		PageRequest request = new PageRequest();
		request.setParams(new HashMap<String,Object>(){{put("priPID", "3301850000105241");}});
		List<ImInvupdateDto> list = service.queryList(request);
		for (ImInvupdateDto dto : list) {
			System.out.println(dto);
		}
		
	}
}
