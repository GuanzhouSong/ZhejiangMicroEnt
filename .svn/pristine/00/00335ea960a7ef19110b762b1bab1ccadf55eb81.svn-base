package cs;

import com.icinfo.cs.webservice.mapper.WsMidBaseInfoMapper;
import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.cs.webservice.service.IWsMidBaseInfoService;
import com.icinfo.framework.core.test.SpringTxTestCase;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FENG on 2017/2/15.
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@ContextConfiguration(locations = { "/entry/dev/spring-entry.xml" })
public class WsMidBaseInfoServiceTest extends SpringTxTestCase {
    @Autowired
    IWsMidBaseInfoService iWsMidBaseInfoService;

    @Autowired
    private WsMidBaseInfoMapper wsMidBaseInfoMapper;

    @Test
    public void doGetWsMidBaseInfoListTest() throws Exception {
        Map<String, Object> map = new HashMap<String,Object>();
        Example example= new Example(WsMidBaseInfo.class);
        example.createCriteria().andEqualTo("priPID","3302040040009750");
        System.out.print("ff::"+wsMidBaseInfoMapper.selectByExample(example));
    }


}
