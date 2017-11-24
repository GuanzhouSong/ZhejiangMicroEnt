package com.icinfo.cs.sment.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sment.mapper.SmentBulletinsMapper;
import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.cs.sment.service.ISmentBulletinsService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
/**
 * 描述:   小微企业公告通知 sm_bulletins 对应的Service接口实现类.<br>
 *
 * @author 
 * @date 2017年05月02日
 */
@Service
public class SmentBulletinsServiceImpl implements ISmentBulletinsService{
	@Autowired
	private SmentBulletinsMapper smentBulletinsMapper;

	/**
	 *描述： 获取通知公告列表
	 */
	public List<SmentBulletins> selectBulletinsList(PageRequest request,SysUserDto sysUse) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> param = request.getParams();
		return smentBulletinsMapper.selectBulletinsList(param);
	}

	/** 
	 * 描述: 插入公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param SmentBulletins
	 * @return
	 * @throws SQLException 
	 */
	public int insertBulletins(SmentBulletins smentBulletins) throws SQLException {
		smentBulletins.setCreateTime(new Date());
		smentBulletins.setReadCount(0);
		return smentBulletinsMapper.insert(smentBulletins);
	}

	/** 
	 * 描述: 修改公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param SmentBulletins
	 * @return
	 * @throws SQLException 
	 */
	public int updateBulletins(SmentBulletins smentBulletins) throws SQLException {
		Example ex = new Example(Bulletins.class);
		ex.createCriteria().andEqualTo("UID", smentBulletins.getUID());
		smentBulletins.setSetTime(new Date());
		return smentBulletinsMapper.updateByExampleSelective(smentBulletins,ex);
	}

	/** 
	 * 描述: 根据UID查找公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public SmentBulletins selectByUID(String uid) {
		SmentBulletins record = new SmentBulletins();
		record.setUID(uid);
		return smentBulletinsMapper.selectOne(record);
	}

	/** 
	 * 描述: 根据UID删除公告
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public int deleteBulletinsByUid(String uid) {
		 Example ex = new Example(Bulletins.class);
		 ex.createCriteria().andEqualTo("UID", uid);
		 return smentBulletinsMapper.deleteByExample(ex);
	}



}
