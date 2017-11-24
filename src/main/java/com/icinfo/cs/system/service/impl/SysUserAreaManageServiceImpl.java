/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserAreaManageDto;
import com.icinfo.cs.system.mapper.SysUserAreaManageMapper;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.cs.system.service.ISysUserAreaManageService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Service
public class SysUserAreaManageServiceImpl extends MyBatisServiceSupport implements ISysUserAreaManageService {
 
	@Autowired
	private SysUserAreaManageMapper sysUserAreaManageMapper;
	
	/**
	 * 
	 * 描述   分页查询区域管理员
	 * @author  赵祥江
	 * @date 2017年5月8日 下午2:31:02 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SysUserAreaManageDto> queryPage(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> queryMap= request.getParams();
		return sysUserAreaManageMapper.selectSysUserAreaManageList(queryMap);
	}

	/**
	 * 
	 * 描述   根据uid更新
	 * @author  赵祥江
	 * @date 2017年5月8日 下午2:31:18 
	 * @param  
	 * @throws
	 */
	@Override
	public int updateSysUserAreaManageByUid(SysUserAreaManage sysUserAreaManage) throws Exception {
		if(sysUserAreaManage!=null&&StringUtil.isNotBlank(sysUserAreaManage.getUid())){
			sysUserAreaManage.setCreateTime(DateUtils.getSysDate());
			Example example = new Example(SysUserAreaManage.class);
			example.createCriteria()
			.andEqualTo("uid", sysUserAreaManage.getUid()); 
			return sysUserAreaManageMapper.updateByExampleSelective(sysUserAreaManage, example);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   根据uid查询区域管理员
	 * @author  赵祥江
	 * @date 2017年5月8日 下午2:31:30 
	 * @param  
	 * @throws
	 */
	@Override
	public SysUserAreaManage selectSysUserAreaManageByUid(String uid)
			throws Exception {
        if(StringUtil.isNotBlank(uid)){
        	SysUserAreaManage sysUserAreaManage=new SysUserAreaManage();
        	sysUserAreaManage.setUid(uid);
        	return sysUserAreaManageMapper.selectOne(sysUserAreaManage);
        }
		return null;
	}

	/**
	 * 
	 * 描述   根据用户id和有效状态查询
	 * @author  赵祥江
	 * @date 2017年5月8日 下午2:31:50 
	 * @param  
	 * @throws
	 */
	@Override
	public SysUserAreaManage selectSysUserAreaManageByUserIdentity(
			String userIdentity,String userStatus) throws Exception {
		 if(StringUtil.isNotBlank(userIdentity)){
			 SysUserAreaManage sysUserAreaManage=new SysUserAreaManage();
	         sysUserAreaManage.setUserIdentity(userIdentity);
	         if(StringUtil.isNotBlank(userStatus)){
	        	 sysUserAreaManage.setUserStatus(userStatus);
	         }
	         return sysUserAreaManageMapper.selectOne(sysUserAreaManage);
		 }
		return null;
	}

	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年5月5日 上午11:38:06 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertSysUserAreaManage(SysUserAreaManage sysUserAreaManage)
			throws Exception { 
		return sysUserAreaManageMapper.insert(sysUserAreaManage);
	}

	/**
	 * 
	 * 描述   根据uid删除
	 * @author  赵祥江
	 * @date 2017年5月5日 下午2:42:35 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteSysUserAreaManageByUid(String uid) throws Exception {
		if(StringUtil.isNotBlank(uid)){
			SysUserAreaManage sysUserAreaManage=new SysUserAreaManage();
			sysUserAreaManage.setUid(uid);
			return sysUserAreaManageMapper.delete(sysUserAreaManage);
		}
		return 0;
	}
 
}