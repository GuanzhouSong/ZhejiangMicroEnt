/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.mapper.BulletinsMapper;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.cs.yr.service.IBulletinsService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_bulletins 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
@Service
public class BulletinsServiceImpl extends MyBatisServiceSupport implements IBulletinsService {
	
	
	@Autowired BulletinsMapper bulletinsMapper;




	/** 
	 * 描述: 插入公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int insertBulletins(Bulletins bulletins) throws SQLException {
		bulletins.setCreateTime(new Date());
		bulletins.setReadCount(0);
		return bulletinsMapper.insert(bulletins);
		
	}

	/** 
	 * 描述: 更新公告
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int updateBulletins(Bulletins bulletins) throws SQLException {
		Example ex = new Example(Bulletins.class);
		ex.createCriteria().andEqualTo("UID", bulletins.getUID());
		bulletins.setCreateTime(new Date());
		return bulletinsMapper.updateByExampleSelective(bulletins,ex);
		
	}

	

	/** 
	 * 描述: 获取列表数据
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public List<Bulletins> selectBulletins(PageRequest request,SysUserDto sysUser) throws SQLException {
		 PageHelper.startPage(request.getPageNum(), request.getLength());
		 Map<String, Object> map = request.getParams();		 
         map.put("systemType", sysUser.getUserType());
         if(map.containsKey("bulType") && map.get("bulType") != null && "3".equals(map.get("bulType").toString())){//首页公告(对内公告)
             if("1".equals(sysUser.getUserType())){
            	 map.put("deptCode",sysUser.getDeptCode() != null ? StringUtil.substring(sysUser.getDeptCode(), 0, 8) : "000000");
             }else{
            	 map.put("deptCode",sysUser.getSysDepart().getAdcode() != null ? StringUtil.substring(sysUser.getSysDepart().getAdcode(),0,8) : "000000");
             } 
         }
		 return  bulletinsMapper.selectBulletinsList(map);
	}

	/** 
	 * 描述: 根据UID查询
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param UID
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public Bulletins selectByUID(String UID) throws SQLException {
		Bulletins record = new Bulletins();
		record.setUID(UID);
		return bulletinsMapper.selectOne(record);
			
	}

	/** 
	 * 描述: 根据Uid删除
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int deleteBulletinsByUid(String uid) throws SQLException {
		 Example ex = new Example(Bulletins.class);
		 ex.createCriteria().andEqualTo("UID", uid);
		 return bulletinsMapper.deleteByExample(ex);
	}
	
	/**
	 * 
	 * 描述: 企业端公告
	 * @auther gaojinling
	 * @date 2016年12月5日 
	 * @param request
	 * @param sysUser
	 * @return
	 * @throws SQLException
	 */
	public List<Bulletins> selectBulletinsClientList(PageRequest request) throws SQLException {
		 PageHelper.startPage(request.getPageNum(), request.getLength());
		 Map<String, Object> map = request.getParams();	
		 map.put("bulClientType", 1);//企业端公告标志
		 return  bulletinsMapper.selectBulletinsClientList(map);
	}
	
	
}