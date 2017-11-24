/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.DepartMentMapper;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_department 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月20日
 */
@Service
public class DepartMentServiceImpl extends MyBatisServiceSupport implements IDepartMentService {
	
	
	    @Autowired
	    private DepartMentMapper departmentMapper;

	    /**
	     * 
	     * 描述: 查询所有
	     * @auther gaojinling
	     * @date 2016年9月21日 
	     * @return
	     */
		@Override
		public List<DepartMent> selectAll() {
			Example example = new Example(DepartMent.class);
			example.orderBy("deptDID").asc();
			return departmentMapper.selectByExample(example);
		}

		/**
		 * 
		 * 描述: 查询单个对象
		 * @auther gaojinling
		 * @date 2016年9月21日 
		 * @param deptDid
		 * @return
		 */
		@Override
		public DepartMent selectOne(String deptDid) {
			DepartMent department=new DepartMent();
			department.setDeptDID(deptDid);
			return departmentMapper.selectOne(department);
		}

		/**
		 * 
		 * 描述: 保存
		 * @auther gaojinling
		 * @date 2016年9月21日 
		 * @param department
		 * @return
		 */
		@Override
		public int save(DepartMent department) {
			return departmentMapper.insert(department);
		}

		/**
		 * 
		 * 描述: 查询
		 * @auther gaojinling
		 * @date 2016年9月21日 
		 * @param parentId
		 * @return
		 */
		@Override
		public List<DepartMent> selectByParentId(String parentId) {
			 Example example=new Example(DepartMent.class);
			 example.orderBy("deptDID").desc();
			 example.createCriteria().andEqualTo("deptPID", parentId); 
			return departmentMapper.selectByExample(example) ;
		}

		/**
		 * 
		 * 描述: 更新
		 * @auther gaojinling
		 * @date 2016年9月21日 
		 * @param department
		 * @return
		 */
		@Override
		public int update(DepartMent department) {
			Example example=new Example(DepartMent.class);
			example.createCriteria().andEqualTo("deptDID",department.getDeptDID());
			return departmentMapper.updateByExampleSelective(department, example);
		}

		/**
		 * 
		 * 描述: 删除
		 * @auther gaojinling
		 * @date 2016年9月21日 
		 * @param deptId
		 * @return
		 */
		@Override
		public int deleteByDeptId(String deptId) {
			Example exampl=new Example(DepartMent.class);
			exampl.createCriteria().andEqualTo("deptPID",deptId);
			departmentMapper.deleteByExample(exampl);
			Example example=new Example(DepartMent.class);
			example.createCriteria().andEqualTo("deptDID", deptId);
			return departmentMapper.deleteByExample(example);
		}
		
		/**
		   * 描述: 获取部门名称规范管理列表数据
		   * @auther yujingwei
		   * @date 2016年9月21日 
		   * @param request
		   * @return List<DepartMent>
		   * @throws Exception
		   */
		 @Override
		 public  List<DepartMent> queryPage(PageRequest request) throws Exception{
			 PageHelper.startPage(request.getPageNum(), request.getLength());
			 List<DepartMent> departMentList =  departmentMapper.selectDepartmentList(request.getParams());
			 return departMentList;
		 }

		 /**
		  * 
		  * 描述   根据deptCode编码查询部门信息
		  * @author  赵祥江
		  * @date 2016年10月13日 下午1:38:43 
		  * @param  
		  * @throws
		  */
		@Override
		public DepartMent selectDepartMentByDeptCode(String deptCode) {
			DepartMent departMent=new DepartMent();
			departMent.setDeptCode(deptCode);
			return departmentMapper.selectOne(departMent);
		}
		/**
		 * 
		 * 描述: 嘉兴港区分局和经济开发区分局特殊处理
		 * @auther gaojinling
		 * @date 2017年11月7日 
		 * @param deptCode
		 * @return
		 */
		public DepartMent selectDepartMentByDeptCodespec(String deptCode) {
			DepartMent departMent=new DepartMent();
			if("330405".equals(deptCode) || "330403".equals(deptCode)){//嘉兴港区分局,嘉兴经开分局
				deptCode = "330400";
 		    }
			departMent.setDeptCode(deptCode);
			return departmentMapper.selectOne(departMent);
		}
		
		
		

	/**
	 * 描述：获取全市部门（包含市级本部门）
	 *
	 * @param deptCodeFirst4 部门编码前4位
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 */
	@Override
	public List<DepartMent> doGetLevelCityDept(String deptCodeFirst4) throws Exception {
		Example example=new Example(DepartMent.class);
		example.createCriteria().andLike("deptCode",deptCodeFirst4+"%");
		return departmentMapper.selectByExample(example);
	}

	/**
	 * 描述：获取本局部门
	 *
	 * @param deptCodeFirst6 部门编码前6位
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 */
	@Override
	public List<DepartMent> doGetLevelCountryDept(String deptCodeFirst6) throws Exception {
		Example example=new Example(DepartMent.class);
		example.createCriteria().andLike("deptCode",deptCodeFirst6+"%");
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 描述:警示部门节点处理
	 * @auther yujingwei
	 * @date 2016年12月22日 
	 * @param list
	 * @param parentId
	 * @return AjaxResult
	 * @throws Exception
	 */
	public String doGetDepdid(List<DepartMent> departMentlist, String parentId) throws Exception{
		String deptID = null;
		if(CollectionUtils.isNotEmpty(departMentlist)){
			//取得当前末尾排序最大的子节点
			for(DepartMent departMent : departMentlist){
				 if(departMent.getDeptDID().contains(".")){
					 deptID = departMent.getDeptDID();
					 break;
				 }
			}
			if(deptID != null){
				if(deptID.endsWith(".")){
					//子节点以点结尾
					String tempCode = deptID.substring(deptID.length() - 2,deptID.length() - 1);
					int reCode =Integer.parseInt(tempCode) + 1;
					deptID = deptID.substring(0,deptID.length() - 2) + reCode + ".";
				}else{
					//子节点以数字结尾
					String tempCode = deptID.substring(deptID.length() - 2);
				    int reCode = Integer.parseInt(tempCode) + 1;
				    if(reCode >= 10){
				    	deptID = deptID.substring(0,deptID.length() - 2) + reCode;
				    }else{
				    	deptID = deptID.substring(0,deptID.length() - 2) + "0" + reCode; 
				    } 
				}
			}
		}else{
			//该父节点下无其它子节点
			String appendStr = parentId.endsWith(".")?"00":".00";
			deptID = parentId + appendStr;
		}
		return deptID;
	}
	
    /**
     * 
     * 描述: 根据登录人员级别过滤部门编码列表
     * @auther gaojinling
     * @date 2016年9月21日 
     * @return
     */
	@Override
	public List<DepartMent> selectDepartmentPermissionList(Map<String, Object> map) throws Exception {
		return departmentMapper.selectDepartmentPermissionList(map);
	}

	/**
	 * 根据用户所属层级来查询部门数据<br/>
	 * 黄凌玲 2017/1/9 14:36:20<br/>
	 * 目前用户在任一功能的查询条件选择“登记机关”、“管辖单位”“片区”时都可以看到全省所有部门选项，未与人员的数据查询权限匹配，要求修改如下：<br/>
	 * 1、数据查询范围为“全省”的人员，匹配省级部门+11个地市部门列表<br/>
	 * 2、数据查询范围为“本市”的人员，匹配省级部门+本市部门列表<br/>
	 * 3、数据查询范围为“本局”“本所”的人员，匹配省级部门+本局（分局+所）列表。<br/>
	 *
	 * @param userSearchRange 用户查询范围
	 * @param deptCodeLikeVal
	 * @return 部门列表
	 * @author ZhuDefeng
	 * @date 2017-01-09
	 */
	@Override
	public List<DepartMent> doFindDepartmentBySearchRange(String userSearchRange, String deptCodeLikeVal) throws Exception {
		return null;
	}


}