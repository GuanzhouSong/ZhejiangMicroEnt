package com.icinfo.cs.depsyn.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.depsyn.dto.DepSynSearchHisDto;
import com.icinfo.cs.depsyn.mapper.DepSynSearchKeyMapper;
import com.icinfo.cs.depsyn.model.DepSynSearchHis;
import com.icinfo.cs.depsyn.model.DepSynSearchKey;
import com.icinfo.cs.depsyn.service.IDepSynSearchHisService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 查询历史记录service实现类
 * @author caoxu
 *
 */
@Service
public class DepSynSearchHisServiceImpl implements IDepSynSearchHisService {
	
	@Autowired
	private com.icinfo.cs.depsyn.mapper.DepSynSearchHisMapper depSynSearchHisMapper;
	
	@Autowired
	private DepSynSearchKeyMapper depSynSearchKeyMapper;
	
	/**
	 * 新增查询记录
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
    public int insert(DepSynSearchHis depSynSearchHis, MidBaseInfo baseInfo) {
		depSynSearchHis.setHisEntName(baseInfo.getEntName());
		depSynSearchHis.setHisPriPID(baseInfo.getPriPID());
		depSynSearchHis.setHisRegNO(baseInfo.getRegNO());
		depSynSearchHis.setHisUniCode(baseInfo.getUniCode());
		depSynSearchHis.setHisViewTime(new Date());
		return this.depSynSearchHisMapper.insert(depSynSearchHis);
	}
	
	/**
	 * 更新查询记录
	 * @param depSynSearchHis
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(DepSynSearchHis depSynSearchHis) {
		depSynSearchHis.setHisViewTime(new Date());
		Example example = new Example(DepSynSearchHis.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("hisUserId", depSynSearchHis.getHisUserId());
		criteria.andEqualTo("hisPriPID", depSynSearchHis.getHisPriPID());
		return this.depSynSearchHisMapper.updateByExampleSelective(depSynSearchHis, example);
	}
	
	/**
	 * 判断记录是否存在
	 * @param queryMap
	 * @return
	 */
	@Override
	public boolean historyExist(Map<String, Object> queryMap) {
		DepSynSearchHisDto dto = this.depSynSearchHisMapper.historyExist(queryMap);
		if (dto == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 获取最近记录
	 * @param queryMap
	 * @return
	 */
	@Override
	public List<DepSynSearchHisDto> selectHistory(Map<String, Object> queryMap) {
		List<DepSynSearchHisDto> list = this.depSynSearchHisMapper.selectHistory(queryMap);
		// 计算距今时间
		for (DepSynSearchHisDto dto : list) {
			dto.setFromNow(getBetweenStr(dto.getHisViewTime()));
		}
		return list;
	}

	private String getBetweenStr(Date before) {
		// 依次处理秒、分钟、小时、天
		long between = DateUtil.getBetweenDaysToMut(before, new Date());
		if (between == 0) {
			return (new Date().getTime() / 1000) - (before.getTime() / 1000) + "秒前";
		} else if (between >= 1 && between < 60) {
			return between + "分钟前";
		} else if (between >= 60 && between < 1440) {
			return between / 60 + "小时前";
		} else if (between > 1440 && between < 10080) {
			return between / 60 / 24 + "天前";
		} else
			return "超过一周";
	}
	
	/**
	 * 查询条件组合记录
	 * @param queryMap
	 * @return
	 */
	@Override
	public List<DepSynSearchKey> selectParams(Map<String, Object> queryMap) {
		return this.depSynSearchKeyMapper.selectParams(queryMap);
	}
	
	/**
	 * 新增查询条件组合
	 * @param depSynSearchKey
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(DepSynSearchKey depSynSearchKey) {
		depSynSearchKey.setUpdateTime(new Date());
		return this.depSynSearchKeyMapper.insert(depSynSearchKey);
	}

	/**
	 * 更新查询条件组合
	 * @param depSynSearchKey
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(DepSynSearchKey depSynSearchKey) {
		depSynSearchKey.setUpdateTime(new Date());
		Example example = new Example(DepSynSearchKey.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userId", depSynSearchKey.getUserId());
		criteria.andEqualTo("params", depSynSearchKey.getParams());
		return this.depSynSearchKeyMapper.updateByExampleSelective(depSynSearchKey, example);
	}
	
	/**
	 * 判断条件组合是否存在
	 * @param queryMap
	 * @return
	 */
	@Override
	public boolean paramsExist(Map<String, Object> queryMap) {
		DepSynSearchKey key = this.depSynSearchKeyMapper.paramsExist(queryMap);
		if (key == null) {
			return false;
		}
		return true;
	}

}
