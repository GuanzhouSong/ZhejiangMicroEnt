/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.mapper.PubScresultMapper;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scresult 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubScresultServiceImpl extends MyBatisServiceSupport implements IPubScresultService {

    @Autowired
    private PubScresultMapper pubScresultMapper;
    
    /**
	 * 描述：根据任务编号和主体身份代码查询抽查检查结果信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScresult selectPubScresultByTaskNO(String taskNO, String priPID) {
    	PubScresult pubScresult = new PubScresult();
    	pubScresult.setTaskNO(taskNO);
    	pubScresult.setPriPID(priPID);
    	return pubScresultMapper.selectOne(pubScresult);
    }
    
    /**
	 * 描述:保存抽检结果录入信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScresult
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean savePubScresult(PubScresult pubScresult,SysUserDto sysUser) throws Exception {
		if(pubScresult != null){
			pubScresult.setSetUserId(sysUser.getId());
			pubScresult.setSetUserName(sysUser.getRealName());
			pubScresult.setSetTime(new Date());
			if(pubScresult.getId() != null && pubScresult.getId().intValue() > 0){
				pubScresultMapper.updateByPrimaryKeySelective(pubScresult);
			}else{
				pubScresult.setCreateTime(new Date());
				pubScresultMapper.insertSelective(pubScresult);
			}
    		return true;
    	}
    	return false;
    }
    
    /**
     * 描述:审核抽检结果录入信息
     * @author chenxin
     * @date 2016-10-27
     * @param pubScresult
     * @param sysUser
     * @return
     * @throws Exception
     */
    @Override
    public boolean auditPubScresult(PubScresult pubScresult,SysUserDto sysUser) throws Exception {
		if(pubScresult != null){
			pubScresult.setAuditDate(new Date());
			pubScresult.setAuditDept(sysUser.getDeptCode());
			pubScresult.setAuditName(sysUser.getRealName());
			if(pubScresult.getId() != null && pubScresult.getId().intValue() > 0){
				pubScresultMapper.updateByPrimaryKeySelective(pubScresult);
			}else{
				pubScresult.setCreateTime(new Date());
				pubScresultMapper.insertSelective(pubScresult);
			}
    		return true;
    	}
    	return false;
    }

	@Override
	public List<PubScresultDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScresultMapper.queryPageResultByPripid(request.getParams());
	}
	
	/**
	 * 描述：根据priPID查询历史抽检记录
	 *
	 * @author baifangfang
	 * @date 2016年11月15日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScresultDto> queryPagePubScresultDto(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScresultMapper.queryPagePubScresultList(request.getParams());
	}
	
	/**
	 * 描述:获取公告详细信息列表数据（用于公告）
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresultList
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScresultDto> selectScresultInfoForBulletin(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScresultMapper.selectScresultForBulletin(request.getParams());
	}
	
	/**
	 * 描述:获取检查公告详情数据
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresultList
	 * @param request
	 * @return List<PubScresultDto>
	 * @throws Exception
	 */
	public List<PubScresultDto> selectCheckScresultInfoForBulletin(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScresultMapper.selectCheckScresultInfoForBulletin(request.getParams());
	}
	
}