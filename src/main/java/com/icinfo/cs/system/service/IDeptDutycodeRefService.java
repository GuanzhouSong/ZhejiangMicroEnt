/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;

import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_dept_dutycode_ref 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
public interface IDeptDutycodeRefService extends BaseService {


    /**
     * 描述：根据部门编码查询所对应的职能部门编码
     * @author ZhuDefeng
     * @date 2016-11-21
     * @return
     * @throws Exception
     */
    SysDepartDto getDutyCodesBySysDept(SysDepart sysDepart)throws Exception;
    
    /**
     * 
     * 描述   获取所有数据
     * @author 赵祥江
     * @date 2016年11月23日 下午7:57:55 
     * @param 
     * @return List<DeptDutycodeRef>
     * @throws
     */
    List<DeptDutycodeRef> getAllDutyCodesBySysDept();
    
    /**
     * 
     * 描述   根据部门编码和职能编码查询
     * @author 赵祥江
     * @date 2016年11月22日 下午4:47:16 
     * @param 
     * @return DeptDutycodeRef
     * @throws
     */
    DeptDutycodeRef  getDeptDutycodeRefByAdCodeAndDutyDeptCode(String adCode,String dutyDeptCode)throws Exception;

    
	/**
	 * 
	 * 描述   根据adCod的前九位和职能编码查询
	 * @author 赵祥江
	 * @date 2016年11月25日 下午4:33:45 
	 * @param 
	 * @return DeptDutycodeRef
	 * @throws
	 */
    List<DeptDutycodeRef>  getDeptDutycodeRefByAdCodeSubDutyDeptCode(String adCode,String dutyDeptCode)throws Exception;
    
    /**
     * 
     * 描述   根据adCod的前九位和职能编码查询
     * @author 陈鑫
     * @date 2016年12月27日 下午4:33:45 
     * @param 
     * @return String
     * @throws
     */
    String  selectDeptCodeByAdCodeSubDutyDeptCode(String userType,String adCode,String dutyDeptCode)throws Exception;

    /**
     *
     * 根据部门编码查询职能部门编码（如果多个，以逗号隔开）
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param
     * @return adCode
     * @throws
     */
    String doSelectDutyCodesByDeptCode(String deptCode)throws Exception;
    
    /**
     * 
     * 描述   根据adCode查询
     * @author 赵祥江
     * @date 2017年1月12日 下午3:18:23 
     * @param 
     * @return List<DeptDutycodeRef>
     * @throws
     */
    List<DeptDutycodeRef>  selectDeptDutycodeRefByAdCode(String adCode)throws Exception;


}