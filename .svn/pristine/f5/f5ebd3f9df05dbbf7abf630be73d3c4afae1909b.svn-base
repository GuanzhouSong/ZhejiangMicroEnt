/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月19日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_depart 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface SysDepartMapper extends Mapper<SysDepart> {
	/**
	 * 
	 * 描述  查询adCode不重复且其长度为13 包含M编码的部门结果集
	 * @author 赵祥江
	 * @date 2016年11月3日 下午3:19:35 
	 * @param 
	 * @return List<SysDepart>
	 * @throws
	 */
	public List<SysDepart> selectDistinctAdCodeSysDepartList(Map<String,Object> parmMap);


    /**
     * 描述：获取全市部门（包含省市本部门）
     * @author ZhuDefeng
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<SysDepart> doGetLevelCityDept(Map<String,Object> qryMap)throws Exception;

    /**
     * 描述：根据职能部门编码获取部门
     * @author ZhuDefeng
     * @date 2016-11-23
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<DeptTree> findDeptByDutyCodeByDutyCode(Map<String,Object> qryMap)throws Exception;

    /**
     * 描述：根据部门编码获取部门
     * @author ZhuDefeng
     * @date 2016-11-25
     * @param orgCoding
     * @return
     * @throws Exception
     */
    List<DeptTree> findDeptByDutyCodeByOrgCoding(String orgCoding)throws Exception;

    /**
     * 描述：根据AdCode前6位获取部门
     * @author ZhuDefeng
     * @date 2016-12-2
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<DeptTree> findDeptByAdCodeFront6Char(Map<String, Object> qryMap)throws Exception;


    /**
     * 根据父代码值查询部门数据
     * @author ZhuDefeng
     * @date 2016-12-20
     * @param porgCoding
     * @return
     * @throws Exception
     */
    List<DeptTree> findDeptByPorgCoding(String porgCoding)throws Exception;
    
    
    /**
	 * 
	 * 描述   获取行政区划的树形结构
	 * @author 赵祥江
	 * @date 2017年1月11日 上午10:21:27 
	 * @param 
	 * @return List<DeptTree>
	 * @throws
	 */
	 List<DeptTree> deptTreeCtity(Map<String, Object> qryMap)
			throws Exception;


	/**
	 * 获取当前节点下的最大的AdCode部门信息
	 * @author ZhuDefeng
	 * @date 2016-11-29
	 * @param orgCoding
	 * @return
	 * @throws Exception
	 */
	String getMaxAdCode(String orgCoding)throws Exception;

	/**
	 * 获取当前节点下的最大的OrgCoding部门信息
	 * @author ZhuDefeng
	 * @date 2016-11-29
	 * @param orgCoding
	 * @return
	 * @throws Exception
	 */
	String getMaxOrgCode(String orgCoding)throws Exception;
}