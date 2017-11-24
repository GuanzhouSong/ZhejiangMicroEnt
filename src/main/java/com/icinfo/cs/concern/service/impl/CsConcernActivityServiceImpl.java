package com.icinfo.cs.concern.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.concern.dto.CsConcernActivityDto;
import com.icinfo.cs.concern.mapper.CsConcernActivityMapper;
import com.icinfo.cs.concern.model.CsConcernActivity;
import com.icinfo.cs.concern.service.CsConcernActivityService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_concern_activity 对应的Service接口实现类.<br>
 *
 * @author caoxu
 * @date 2016年11月06日
 */
@Service
public class CsConcernActivityServiceImpl extends MyBatisServiceSupport implements CsConcernActivityService {
	
	@Autowired
	private CsConcernActivityMapper csConcernActivityMapper;
	
	/**
	 * 查询列表
	 * @param request
	 * @param parms
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CsConcernActivity> queryPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return this.csConcernActivityMapper.selectActivityList(parms);
	}
	
	/**
     * 根据主键查询
     * @param id
     * @return
     * @throws Exception
     */
	@Override
	public CsConcernActivity getById(String id) throws Exception {
		if (isEmpty(id)) {
            return null;
        }
        return csConcernActivityMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 保存活动单
	 * @param csConcernActivityDto
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(CsConcernActivityDto csConcernActivityDto) throws Exception {
		csConcernActivityDto.setCreateTime(new Date());
		csConcernActivityDto.setState(1);
		return this.csConcernActivityMapper.insert(csConcernActivityDto);
	}
	
	/**
	 * 更新活动单
	 * @param csConcernActivityDto
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(CsConcernActivityDto csConcernActivityDto) throws Exception {
		return this.csConcernActivityMapper.updateByPrimaryKey(csConcernActivityDto);
	}

}
