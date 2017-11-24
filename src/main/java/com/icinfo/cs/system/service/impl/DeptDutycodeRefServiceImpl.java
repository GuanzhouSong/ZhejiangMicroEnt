/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.mapper.DeptDutycodeRefMapper;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_dept_dutycode_ref 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class DeptDutycodeRefServiceImpl extends MyBatisServiceSupport implements IDeptDutycodeRefService {


	@Autowired
	private DeptDutycodeRefMapper deptDutycodeRefMapper;

    /**
     * 描述：根据部门编码查询所对应的职能部门编码
     *
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-11-21
     */
    @Override
    public SysDepartDto getDutyCodesBySysDept(SysDepart sysDepart) throws Exception {
        SysDepartDto sysDepartDto=new SysDepartDto();
        DeptDutycodeRef deptDutycodeRefCondition=new DeptDutycodeRef();
        deptDutycodeRefCondition.setOrgCoding(sysDepart.getOrgCoding());
        List<DeptDutycodeRef> deptDutycodeRefs=deptDutycodeRefMapper.select(deptDutycodeRefCondition);
        StringBuilder stringBuilderDutyCode=new StringBuilder();
        StringBuilder stringBuilderDutyName=new StringBuilder();
        for (DeptDutycodeRef deptDutycodeRef:deptDutycodeRefs){
            stringBuilderDutyCode.append(deptDutycodeRef.getDutyDeptCode()+",");
            stringBuilderDutyName.append(deptDutycodeRef.getDutyDeptName()+",");
        }
        if(StringUtil.isNotBlank(stringBuilderDutyCode.toString())){
            String deptDutyCodes=StringUtil.substring(stringBuilderDutyCode.toString(),0,stringBuilderDutyCode.toString().length()-1);
            String deptDutyNames=StringUtil.substring(stringBuilderDutyName.toString(),0,stringBuilderDutyName.toString().length()-1);

            sysDepartDto.setDutyCodes(deptDutyCodes);
            sysDepartDto.setDutyNames(deptDutyNames);
        }
        sysDepartDto.setOrgCoding(sysDepart.getOrgCoding());
        sysDepartDto.setOrgName(sysDepart.getOrgName());
        sysDepartDto.setAdcode(sysDepart.getAdcode());
        sysDepartDto.setDevCoding(sysDepart.getDevCoding());
        sysDepartDto.setDisponClient(sysDepart.getDisponClient());
        sysDepartDto.setOrderBy(sysDepart.getOrderBy());
        sysDepartDto.setOrganizeAllName(sysDepart.getOrganizeAllName());
        sysDepartDto.setPorgCoding(sysDepart.getPorgCoding());
        sysDepartDto.setQuanLimag(sysDepart.getQuanLimag());
        return sysDepartDto;
    }

    /**
     * 
     * 描述   根据部门编码和职能编码查询
     * @author 赵祥江
     * @date 2016年11月22日 下午4:47:16 
     * @param 
     * @return DeptDutycodeRef
     * @throws
     */
	@Override
	public DeptDutycodeRef getDeptDutycodeRefByAdCodeAndDutyDeptCode(
			String adCode, String dutyDeptCode) throws Exception {
		DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
		deptDutycodeRef.setAdCode(adCode);
		deptDutycodeRef.setDutyDeptCode(dutyDeptCode);
		return deptDutycodeRefMapper.selectOne(deptDutycodeRef);
	}

	/**
	 * 
	 * 描述   获取所有数据
	 * @author  赵祥江
	 * @date 2016年11月23日 下午7:59:19 
	 * @param  
	 * @throws
	 */
	@Override
	public List<DeptDutycodeRef> getAllDutyCodesBySysDept() {
 		return deptDutycodeRefMapper.selectAll();
	}

	/**
	 * 
	 * 描述   根据adCod的前九位和职能编码查询
	 * @author 赵祥江
	 * @date 2016年11月25日 下午4:33:45 
	 * @param 
	 * @return DeptDutycodeRef
	 * @throws
	 */
	@Override
	public List<DeptDutycodeRef> getDeptDutycodeRefByAdCodeSubDutyDeptCode(
			String adCode, String dutyDeptCode) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("adCode", adCode);
		queryMap.put("dutyDeptCode", dutyDeptCode);
 		return deptDutycodeRefMapper.selectDeptDutycodeRefByAdCodeSubDutyDeptCode(queryMap);
	}

	/**
     * 
     * 描述   根据adCod的前九位和职能编码查询
     * @author 陈鑫
     * @date 2016年12月27日 下午4:33:45 
     * @param 
     * @return String
     * @throws
     */
	@Override
	public String selectDeptCodeByAdCodeSubDutyDeptCode(String userType,String adCode,String dutyDeptCode) throws Exception {
		if("2".equals(userType)){
			return adCode;
		}else if("1".equals(userType)){
			String checkDep = StringUtil.substring(adCode, 0, 6)+"0";//工商直接当前部门编码前6位加0
			adCode = StringUtil.substring(checkDep, 0, 6)+"000";
			List<DeptDutycodeRef> deptDutycodeReflist = getDeptDutycodeRefByAdCodeSubDutyDeptCode(adCode, dutyDeptCode);
			if(deptDutycodeReflist != null && deptDutycodeReflist.size() > 0 && deptDutycodeReflist.get(0) != null){
				DeptDutycodeRef deptDutycodeRef = deptDutycodeReflist.get(0);
				if(StringUtil.isNotEmpty(deptDutycodeRef.getOrgCoding())){
					return deptDutycodeRef.getOrgCoding();
				}
			}
		}
		return null;
	}

    /**
     * 根据部门编码查询职能部门编码（如果多个，以逗号隔开）
     *
     * @param deptCode
     * @return adCode
     * @throws
     * @author ZhuDefeng
     * @date 2016-11-28
     */
    @Override
    public String doSelectDutyCodesByDeptCode(String deptCode) throws Exception {
        if(StringUtil.isBlank(deptCode))return "";
        DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
        deptDutycodeRef.setOrgCoding(deptCode);
        List<DeptDutycodeRef> deptDutycodeRefList=deptDutycodeRefMapper.select(deptDutycodeRef);
        StringBuilder stringBuilderDutyCode=new StringBuilder();
        for (DeptDutycodeRef deptDutyRef:deptDutycodeRefList){
            stringBuilderDutyCode.append(deptDutyRef.getDutyDeptCode()+",");
        }
        if(StringUtil.isNotBlank(stringBuilderDutyCode.toString())){
            String deptDutyCodes=StringUtil.substring(stringBuilderDutyCode.toString(),0,stringBuilderDutyCode.toString().length()-1);
            return deptDutyCodes;
        }
        return "";
    }

    /**
     * 
     * 描述   根据adCode查询
     * @author  赵祥江
     * @date 2017年1月12日 下午3:19:44 
     * @param  
     * @throws
     */
	@Override
	public List<DeptDutycodeRef> selectDeptDutycodeRefByAdCode(String adCode)
			throws Exception {
		DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
		deptDutycodeRef.setAdCode(adCode);
		return deptDutycodeRefMapper.select(deptDutycodeRef);
	}
}