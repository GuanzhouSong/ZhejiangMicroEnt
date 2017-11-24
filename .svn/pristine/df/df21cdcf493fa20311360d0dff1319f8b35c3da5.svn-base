/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.ModApplicationDto;
import com.icinfo.cs.yr.mapper.ModApplicationMapper;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_mod_application 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
@Service
public class ModApplicationServiceImpl extends MyBatisServiceSupport implements IModApplicationService {
	
	@Autowired
	private ModApplicationMapper modApplicationMapper;
	
	@Autowired
	private IYrRegCheckService iYrRegCheckService;
	
	/**
	 * 描述: 获取年报修改列表list数据
     * @auther chenxin
     * @date 2016年09月11日 
	 * @param request
	 * @return List<ModApplicationDto>
	 */
	@Override
	public List<ModApplicationDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> map = request.getParams();
		if(map.get("modResult")!=null&&StringUtils.isNotBlank(map.get("modResult").toString())){
			String modResult = map.get("modResult").toString();
			if("0".equals(modResult)){
				map.put("modResult0", "0");
				map.remove("modResult");
			}
		}
        return modApplicationMapper.selectModApplicationApplyList(request.getParams());
	}
	
	/**
	 * 描述: 获取年报修改审核历史记录列表list数据
	 * @auther chenxin
	 * @date 2016年09月11日 
	 * @param request
	 * @return
	 */
	@Override
	public List<ModApplication> queryHisPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return modApplicationMapper.selectModApplicationApplyHisList(request.getParams());
	}
	
	/**
     * 
     * 描述: 查询年报修改信息
     * @auther chenxin
     * @date 2016年9月11日 
     * @param priPID
     * @return ModApplicationDto
     */
	@Override
	public ModApplication selectModApplication(String priPID) {
		ModApplication modApplication=new  ModApplication();
		modApplication.setPriPID(priPID);
		return modApplicationMapper.selectOne(modApplication);
	}
	
	/**
	 * 
	 * 描述: 查询年报修改信息
	 * @auther chenxin
	 * @date 2016年9月11日 
	 * @param map
	 * @return ModApplicationDto
	 */
	@Override
	public ModApplicationDto selectModApplicationApplyById(Map<String, Object> map) {
		return modApplicationMapper.selectModApplicationApplyById(map);
	}
	
	/**
	 * 
	 * 描述: 修改年报修改申请(并且记录日志)
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param modApplication
	 * @return boolean
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean applyModApplicationAddLog(ModApplication modApplication,
			List<SysLogTable> logCollector) throws Exception {
		if(modApplication != null && doAddLog4ModApplication(modApplication, logCollector)){
			if(modApplicationMapper.updateByPrimaryKeySelective(modApplication) > 0){
				String priPID = modApplication.getPriPID();
				int year = modApplication.getYear();
				if("1".equals(modApplication.getModResult())){//同意则改变年报状态
	 				if(iYrRegCheckService.doAddLog4UpdateYrRegCheckState(priPID, year, logCollector)){
						return true;
					}
				}else{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 记录修改年报修改日志
	 * @auther chenxin
	 * @date 2016年9月18日 
	 * @param modApplication
	 * @param logCollector
	 * @return boolean
	 */
	private boolean doAddLog4ModApplication(ModApplication modApplication,
			List<SysLogTable> logCollector) throws Exception {
		if(modApplication != null && modApplication.getId() != null){
			ModApplication modApplicationParam = new ModApplication();
			modApplicationParam.setId(modApplication.getId());
			ModApplication dbModApplication = modApplicationMapper.selectOne(modApplicationParam);
			List<SysLogJsonItem> logJsonItemList = ObjectComparator.compareObject(dbModApplication, modApplication);
			SysLogTable logTable = SysLogTable.generateLogTable(LogTables.CS_MOD_APPLICATION.getCode(), logJsonItemList, null, OperationTypes.UPDATE.getCode());	
			if(logTable!=null){
				logCollector.add(logTable);
    		} 
			return true;
		}
    	return false;
	}

	/**
	 * 
	 * 描述: 企业端：根据年报年度和主体代码查询当前年报修改记录
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:22:05 
	 * @param :
	 * @return: List<ModApplication>
	 * @throws
	 */
	@Override
	public List<ModApplication> selectModApplicationPriPIDAndYear(int year,String priPID) {
		Example example=new Example(ModApplication.class); 
		example.createCriteria()
		.andEqualTo(Constants.CS_YEAR, year)
		.andEqualTo(Constants.CS_PRIPID, priPID)
		.andEqualTo("modResubmit", "0"); 
		return modApplicationMapper.selectByExample(example);
	}

	/**
	 * @throws Exception 
	 * 
	 * 描述             : 保存
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:35:08 
	 * @param : 
	 * @throws
	 */
	@Override
	public int insertModApplication(ModApplication modApplication) throws Exception {
		modApplication.setPriPID(modApplication.getPriPID());
		modApplication.setModResult("0");//待审核
		modApplication.setModResubmit("0");//设置为有效记录
		modApplication.setModSubmitDate(DateUtils.getSysDate());//提交时间
		modApplication.setCreateTime(DateUtils.getSysDate());
		return modApplicationMapper.insert(modApplication);
	}

	/** 
	 * 描述: 提交年报时，设置修改申请失效
	 * @auther ZhouYan
	 * @date 2016年9月20日 
	 * @param pripid
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int updateModApplicationInvalid(String pripid, Integer year)
			throws Exception {
		ModApplication modApplication = new ModApplication();
		modApplication.setModResubmit("1");
		Example example=new Example(ModApplication.class); 
		example.createCriteria().andEqualTo(Constants.CS_YEAR, year).andEqualTo(Constants.CS_PRIPID, pripid); 
		return modApplicationMapper.updateByExampleSelective(modApplication, example);
	}

	/** 
	 * 描述: 企业端：查询历史修改记录
	 * @auther ZhouYan
	 * @date 2016年9月22日 
	 * @param request
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public List<ModApplication> select_queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap=  request.getParams();
		Example example = new Example(ModApplication.class); 
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, searchMap.get(Constants.CS_PRIPID).toString())
				.andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
		example.setOrderByClause(searchMap.get("orderby").toString());
		return modApplicationMapper.selectByExample(example);
	}
	
	
	/**
	 * 
	 * 描述: 年报修改申请审核条数（警示端首页）
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectModCount(Map<String, Object> map) throws Exception {
		try {
			return modApplicationMapper.selectModApplicationCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("年报修改申请待审核条数查询失败!");
		}
	}
	
}