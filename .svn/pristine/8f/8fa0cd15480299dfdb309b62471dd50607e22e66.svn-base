package com.icinfo.cs.sment.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sment.dto.BulletinsReadRecordDto;
import com.icinfo.cs.sment.mapper.SmBulletinsReadRecordMapper;
import com.icinfo.cs.sment.model.BulletinsReadRecord;
import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.cs.sment.service.ISmBulletinsReadRecordService;
import com.icinfo.cs.system.dto.SysUserDto;
/**
 * 描述:   小微企业公告通知 sm_bulletins_read_record 对应的Service接口实现类.<br>
 *
 * @author 
 * @date 2017年05月02日
 */
@Service
public class SmBulletinsReadRecordServiceImpl implements ISmBulletinsReadRecordService{
	@Autowired
	private SmBulletinsReadRecordMapper smBulletinsReadRecordMapper;

	/**
     * 查询当前登录用户可查看的通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param sysUserDto
     * @return
     * @throws Exception
     */
	public List<BulletinsReadRecordDto> doSelectBulletinBySysUser(SysUserDto sysUserDto) throws Exception {
		Map<String ,Object> param=new HashMap<>();
		param.put("systemType",sysUserDto.getUserType());
		param.put("readerUserId", sysUserDto.getId());
		param.put("reader", sysUserDto.getUsername());
        param.put("deptCode",sysUserDto.getDeptCode() != null ? StringUtil.substring(sysUserDto.getDeptCode(), 0, 8) : "000000");
		return smBulletinsReadRecordMapper.selectBulletinBySysUser(param);
	}

	/**
     * 阅读通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param sysUserDto
     * @return
     * @throws Exception
     */
	public int doRead(String bulletinId, SysUserDto sysUserDto) {
		BulletinsReadRecord condition = new BulletinsReadRecord();
		condition.setBulletinId(bulletinId);
		condition.setReaderUserId(sysUserDto.getId());
		BulletinsReadRecord exitCondition = smBulletinsReadRecordMapper.selectOne(condition);
		if(exitCondition==null){
			exitCondition=new BulletinsReadRecord();
			exitCondition.setReaderUserId(sysUserDto.getId());
			exitCondition.setReader(sysUserDto.getUsername());
			exitCondition.setIsRead("1");
			exitCondition.setIsCollection("0");
			exitCondition.setBulletinId(bulletinId);
			exitCondition.setCreateTime(new Date());	
		}else{
			exitCondition.setIsRead("1");
            return smBulletinsReadRecordMapper.updateByPrimaryKey(exitCondition);
		}
		return smBulletinsReadRecordMapper.insert(exitCondition);
	}
	
	
}
