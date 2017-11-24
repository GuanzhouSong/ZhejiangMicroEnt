/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.PubDeptScitemDto;
import com.icinfo.cs.drcheck.mapper.PubDeptScitemMapper;
import com.icinfo.cs.drcheck.model.PubDeptScitem;
import com.icinfo.cs.drcheck.service.IPubDeptScitemService;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_dept_scitem 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
@Service
public class PubDeptScitemServiceImpl extends MyBatisServiceSupport implements IPubDeptScitemService {
    @Autowired
    private PubDeptScitemMapper pubDeptScitemMapper;
    @Autowired
    private IPubDeptSctaskService pubDeptSctaskService;

	@Override
	public List<Map<String, Object>> selectToTreeMap(String deptCode) {
		// TODO Auto-generated method stub
		return pubDeptScitemMapper.selectToTreeMap(deptCode);
	}
	
	/**
     * 描述：修改实施部门检查科目
     * @author chenxin
     * @date 2016-11-15
     * @param pubDeptScitemDto
     * @return
     * @throws Exception
     */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean saveDeptScitem(PubDeptScitemDto pubDeptScitemDto)throws Exception {
		String scTypes = pubDeptScitemDto.getScTypes();
		String scNames = pubDeptScitemDto.getScNames();
		String taskNO =  pubDeptScitemDto.getTaskNO();
		String deptTaskNO = pubDeptScitemDto.getDeptTaskNO();
		String deptCode = pubDeptScitemDto.getDeptCode();
		if(StringUtils.isNotEmpty(scTypes) && StringUtils.isNotEmpty(scNames) 
				&& StringUtils.isNotEmpty(taskNO) && StringUtils.isNotEmpty(deptTaskNO) && StringUtils.isNotEmpty(deptCode)){
			//1.先清空数据
			Example example = new Example(PubDeptScitem.class);
    		example.createCriteria().andEqualTo("TaskNO",taskNO).andEqualTo("DeptCode",deptCode);
			pubDeptScitemMapper.deleteByExample(example);
			//2.批量插入
			String[] arrType = scTypes.split(",");
			String[] arrName = scNames.split(",");
			for(int i = 0;i<arrType.length;i++){
				if(StringUtils.isNotEmpty(arrType[i])){
					PubDeptScitem pubDeptScitem = new PubDeptScitem();
					pubDeptScitem.setTaskNO(taskNO);
					pubDeptScitem.setDeptCode(deptCode);
					pubDeptScitem.setScType(arrType[i]);
					pubDeptScitem.setScName(arrName[i]);
					pubDeptScitem.setCreateTime(new Date());
					pubDeptScitemMapper.insert(pubDeptScitem);
				}
			}
			//3.修改实施部门任务表检查科目
			pubDeptSctaskService.updateInspectTypes(deptTaskNO, scTypes, scNames);
			return true;
		}
		
		return false;
	}
}