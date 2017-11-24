/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_department 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月20日
 */
public interface IDepartMentService extends BaseService {
	
	 /**
	 * 
	 * 描述: 查询所有
	 * @auther gaojinling
	 * @date 2016年9月21日 
	 * @return
	 */
	  List<DepartMent> selectAll();
	  
	  /**
	   * 
	   * 描述: 单个
	   * @auther gaojinling
	   * @date 2016年9月21日 
	   * @param deptDid
	   * @return
	   */
	  DepartMent selectOne(String deptDid);
	  
	  /**
	   * 
	   * 描述   根据deptCode编码查询部门
	   * @author 赵祥江
	   * @date 2016年10月13日 下午1:37:19 
	   * @param 
	   * @return DepartMent
	   * @throws
	   */
	  public DepartMent selectDepartMentByDeptCode(String deptCode);
	  
	  /**
		 * 
		 * 描述: 嘉兴港区分局和经济开发区分局特殊处理
		 * @auther gaojinling
		 * @date 2017年11月7日 
		 * @param deptCode
		 * @return
		 */
		public DepartMent selectDepartMentByDeptCodespec(String deptCode);
	  
	  /**
	   * 
	   * 描述: 保存
	   * @auther gaojinling
	   * @date 2016年9月21日 
	   * @param department
	   * @return
	   */
	  int save(DepartMent department);
	  
	  /**
	   * 
	   * 描述:利用父节点查询
	   * @auther gaojinling
	   * @date 2016年9月21日 
	   * @param parentId
	   * @return
	   */
	  List<DepartMent> selectByParentId(String parentId);
	  
	  /**
	   * 
	   * 描述: 更新
	   * @auther gaojinling
	   * @date 2016年9月21日 
	   * @param department
	   * @return
	   */
	  int update(DepartMent department);
	  
	  /**
	   * 
	   * 描述: 删除
	   * @auther gaojinling
	   * @date 2016年9月21日 
	   * @param deptId
	   * @return
	   */
	  int deleteByDeptId(String deptId);
     
	  /**
	   * 描述: 获取部门名称规范管理列表数据
	   * @auther yujingwei
	   * @date 2016年9月21日 
	   * @param request
	   * @return List<DepartMent>
	   * @throws Exception
	   */
	 public  List<DepartMent> queryPage(PageRequest request) throws Exception;

	/**
	 * 描述：获取全市部门（包含市级本部门）
	 *
	 * @param deptCodeFirst4 部门编码前4位
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 */
	List<DepartMent> doGetLevelCityDept(final String deptCodeFirst4) throws Exception;

	/**
	 * 描述：获取本局部门
	 *
	 * @param deptCodeFirst6 部门编码前6位
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 */
	List<DepartMent> doGetLevelCountryDept(final String deptCodeFirst6) throws Exception;
    
	/**
	 * 描述:警示部门节点处理
	 * @auther yujingwei
	 * @date 2016年12月22日 
	 * @param list
	 * @param parentId
	 * @return AjaxResult
	 * @throws Exception
	 */
	public String doGetDepdid(List<DepartMent> list, String parentId) throws Exception;
	
	/**
	 * 
	 * 描述: 根据登录人员级别过滤部门编码列表
	 * @auther gaojinling
	 * @date 2017年1月11日 
	 * @return
	 * @throws Exception
	 */
	public List<DepartMent> selectDepartmentPermissionList(Map<String, Object> map) throws Exception;


	/**
	 * 根据用户所属层级来查询部门数据<br/>
	 *黄凌玲 2017/1/9 14:36:20<br/>
	 *目前用户在任一功能的查询条件选择“登记机关”、“管辖单位”“片区”时都可以看到全省所有部门选项，未与人员的数据查询权限匹配，要求修改如下：<br/>
	 *1、数据查询范围为“全省”的人员，匹配省级部门+11个地市部门列表<br/>
	 *2、数据查询范围为“本市”的人员，匹配省级部门+本市部门列表<br/>
	 *3、数据查询范围为“本局”“本所”的人员，匹配省级部门+本局（分局+所）列表。<br/>
	 * @param userSearchRange 用户查询范围
	 * @param deptCodeLikeVal
	 * @return 部门列表
	 * @author ZhuDefeng
	 * @date 2017-01-09
	 */
	List<DepartMent> doFindDepartmentBySearchRange(String userSearchRange,String deptCodeLikeVal) throws Exception;

}