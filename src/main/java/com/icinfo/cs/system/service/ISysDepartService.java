/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_sys_depart 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface ISysDepartService extends BaseService {


    /**
     * 描述:根据ID查询部门信息
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    public SysDepart doGetById(Integer id) throws Exception;

    /**
     * 描述:根据部门代码查询部门信息
     *
     * @param orgCoding 部门节点Code
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-20
     */
    public SysDepart doGetByCode(String orgCoding) throws Exception;


    /**
     * 描述:根据部门代码查询部门信息
     *
     * @param orgCoding 部门节点Code
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-20
     */
    public DeptTree doGetDeptTreeByCode(String orgCoding,String isParent,String nocheck) throws Exception;

    /**
     * 描述:根据父节点获取直接子节点的代码集合
     * 部门编码为15位的为最末端子节点（真正意义的部门节点）
     *
     * @param sysDepart    协同部门树查询参数
     * @param isSetNoCheck 是否设置树节点的noCheck属性
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    public List<SysDepart> doGetDepartment(final SysDepart sysDepart, final boolean isSetNoCheck) throws Exception;

    /**
     * 描述:部门维护修改接口
     *
     * @param sysDepart
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    public int doModDepartment(final SysDepartDto sysDepart) throws Exception;

    /**
     * 描述:部门维护删除接口
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    public int doRmDepartment(final Integer id) throws Exception;

    /**
     * 描述:部门维护新增接口
     *
     * @param sysDepart
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-19
     */
    public int doSaveDepartment(final SysDepartDto sysDepart) throws Exception;


    /**
     * 描述   根据行政编码查询
     *
     * @param
     * @return List<SysDepart>
     * @throws
     * @author 赵祥江
     * @date 2016年10月26日 下午7:55:57
     */
    public List<SysDepart> doGetSysDepartByAdcode(String adcode) throws Exception;



    /**
     * 描述  查询adCode不重复且其长度为13 包含M编码的部门结果集
     *
     * @param
     * @return List<SysDepart>
     * @throws
     * @author 赵祥江
     * @date 2016年11月3日 下午3:19:35
     */
    public List<SysDepart> selectDistinctAdCodeSysDepartList(Map<String, Object> parmMap);


    /**
     * 描述：根据职能部门编码获取部门
     * @author ZhuDefeng
     * @date 2016-11-23
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<DeptTree> doFindDeptByDutyCodeByDutyCode(Map<String,Object> qryMap)throws Exception;

    /**
     * 描述：根据部门编码获取部门
     * @author ZhuDefeng
     * @date 2016-11-25
     * @param orgCoding
     * @return
     * @throws Exception
     */
    List<DeptTree> doFindDeptByDutyCodeAndOrgCoding(String orgCoding)throws Exception;

    /**
     * 获取当前节点下的下一个唯一的AdCode值
     * @author chenxin
     * @date 2017-09-21
     * @param orgCoding 父节点部门编码
     * @return
     */
    String doNextAdCode(String orgCoding,boolean flag) throws Exception;

    /**
     * 获取当前节点下的下一个唯一的OrgCoding值
     * @author chenxin
     * @date 2017-09-21
     * @param orgCoding 父节点部门编码
     * @return
     */
    String doNextOrgCoding(String orgCoding,boolean flag) throws Exception;

    /**
     * 
     * 描述   获取行政区划的树形结构
     * @author 赵祥江
     * @date 2017年1月11日 上午10:18:15 
     * @param 
     * @return List<DeptTree>
     * @throws
     */
    List<DeptTree> deptTreeCtity(Map<String,Object> qryMap)throws Exception;

    /**
     * 查询部门编码
     * @param checkDeptName
     * @param dutyDeptCodes
     * @return
     */
	public DeptDutycodeRef selectByName(String checkDeptName, String dutyDeptCodes);
	
	/**
	 * 描述：更新父节点
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param porgCoding
	 * @return
	 * @throws Exception
	 */
	public void updateParentFlag(String porgCoding)throws Exception;
}
