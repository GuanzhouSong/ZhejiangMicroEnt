/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.dto.PubScitemResultDto;
import com.icinfo.cs.drcheck.mapper.PubScitemResultMapper;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.cs.drcheck.service.IPubScitemResultService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scitem_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubScitemResultServiceImpl extends MyBatisServiceSupport implements IPubScitemResultService {

    @Autowired
    private PubScitemResultMapper pubScitemResultMapper;
    
    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;

    /**
	 * 根据priPID获取抽查检查信息列表
	 *
	 * @author chenyu
	 * @date 2016-10-28
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScitemResultDto> selectPubScitemResultListByPriPID(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScitemResultMapper.selectPubScitemResultListByPriPID(request.getParams());
	}
    
    /**
	 * 描述：根据任务编号和科目大类查询配置项信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO 
	 * @param priPID
	 * @param inspectDept
	 * @return List<PubScitemResult>
	 * @throws Exception
	 */
    @Override
    public List<PubScitemResult> selectByTaskNOAndScType(String deptTaskNO,String taskNO,String priPID,String inspectDept) throws Exception {
		Example example = new Example(PubScitemResult.class);
		example.createCriteria().andEqualTo("taskNO", deptTaskNO).andEqualTo("setDeptCode", inspectDept).andEqualTo("priPID", priPID);
		example.setOrderByClause("ScType Asc,ItemCode Asc");
		List<PubScitemResult> pubScitemResultList =  pubScitemResultMapper.selectByExample(example);
		if(pubScitemResultList == null || pubScitemResultList.size() <= 0){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("taskNO", taskNO);
			params.put("inspectDept", inspectDept);
			pubScitemResultList = pubScitemResultMapper.selectPubScitemResultListNew(params);
		}
		if(pubScitemResultList == null){
			return new ArrayList<PubScitemResult>();
		}
    	return pubScitemResultList;
    }
    
    /**
	 * 描述：保存基本实施项结果录入信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubDeptSctaskList
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean savePubScitemResultList(List<PubScitemResult> pubScitemResultList,SysUserDto sysUser) throws Exception {
    	if(pubScitemResultList != null && pubScitemResultList.size() > 0){
    		for(PubScitemResult pubScitemResult : pubScitemResultList){
    			if(pubScitemResult != null){
    				pubScitemResult.setSetUserId(sysUser.getId());
					pubScitemResult.setSetUserName(sysUser.getRealName());
					pubScitemResult.setSetTime(new Date());
					pubScitemResult.setCreateTime(new Date());
					String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
					pubScitemResult.setSetDeptCode(deptCode);
    				if(pubScitemResult.getId() != null && pubScitemResult.getId().intValue() > 0){
    					pubScitemResultMapper.updateByPrimaryKeySelective(pubScitemResult);
    				}else{
    					pubScitemResultMapper.insertSelective(pubScitemResult);
    				}
    			}
    		}
    		return true;
    	}
    	return false;
    }
}