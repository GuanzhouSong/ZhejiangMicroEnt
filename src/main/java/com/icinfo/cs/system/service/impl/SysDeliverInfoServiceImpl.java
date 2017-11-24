/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.mapper.SysDeliverInfoMapper;
import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.cs.system.service.ISysDeliverInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_sys_deliverinfo 对应的Service接口实现类.<br>   
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class SysDeliverInfoServiceImpl extends MyBatisServiceSupport implements ISysDeliverInfoService {
	
	@Autowired
	private SysDeliverInfoMapper  sysDeliverInfoMapper ;

	/**
	 * 
	 * 描述:  查询确认送达书匹配地址
	 * @auther gaojinling
	 * @date 2016年8月30日 
	 * @param map
	 * @return
	 */
	@Override
	public List<SysDeliverInfo> selectDeliverInfoList(Map<String, Object> map) {
		return sysDeliverInfoMapper.selectDeliverInfoList(map);
	}
	
	
	/**
	 * 
	 * 描述: 根据条件分页查询配送地址信息
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SysDeliverInfo> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());		
		return sysDeliverInfoMapper.selectDeliverInfoList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 根据主键更新
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int update(SysDeliverInfo sysDeliverInfo) throws Exception {
		 if(StringUtils.isNotBlank(sysDeliverInfo.getUid())){
			 sysDeliverInfo.setSetTime(new Date());
			 Example example = new Example(SysDeliverInfo.class);
			example.createCriteria().andEqualTo("uid", sysDeliverInfo.getUid());
			return sysDeliverInfoMapper.updateByExample(sysDeliverInfo, example); 
		 }else{
			 return 0 ;
		 }
	}
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int inset(SysDeliverInfo sysDeliverInfo) throws Exception{
		 sysDeliverInfo.setSetTime(new Date());
		return sysDeliverInfoMapper.insert(sysDeliverInfo);
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int delete(SysDeliverInfo sysDeliverInfo) throws Exception {
		SysDeliverInfo sysDeliverInfoTem = new SysDeliverInfo();
		sysDeliverInfoTem.setUid(sysDeliverInfo.getUid());
		sysDeliverInfoTem.setId(sysDeliverInfo.getId());
		return sysDeliverInfoMapper.delete(sysDeliverInfoTem);
	}
	
	/**
	 * 
	 * 描述: 根据主键uid删除
	 * @auther gaojinling
	 * @date 2016年9月21日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public int deletebyPrimaryKey (String uid) throws Exception{
		if(StringUtils.isNotBlank(uid)){
			 Example example = new Example(SysDeliverInfo.class);
		     example.createCriteria().andEqualTo("uid", uid);
			return sysDeliverInfoMapper.deleteByExample(example);
		}else{
			return 0;
		}
	}
	
	
	
	
	/**
	 * 
	 * 描述: 查询单个信息（根据主键uid）
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param UID
	 * @return
	 * @throws Exception
	 */
	public SysDeliverInfo selectDeliverInfoByPrimaryKey (String uid) throws Exception {
		SysDeliverInfo sysDeliverInfo = new SysDeliverInfo();
		sysDeliverInfo.setUid(uid);
		return sysDeliverInfoMapper.selectOne(sysDeliverInfo);
//		return sysDeliverInfoMapper.selectByPrimaryKey(UID);
	}
	
}