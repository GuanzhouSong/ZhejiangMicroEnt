/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserAreaManageService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.StringUtils;


/**
 * 描述:    cs_sys_depart 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping({"/common/system/sysdepart","/syn/system/sysdepart"})
public class SynDeptSelectController extends CSBaseController {
    private static final long serialVersionUID = -2084061139014623436L;

    private Logger logger= LoggerFactory.getLogger(SynDeptSelectController.class);

    @Autowired
    private ISysDepartService sysDepartService;
    @Autowired
	private ISysUserAreaManageService sysUserAreaManageService;


    /**
     *
     * 进入全选部门树页面（复选、懒加载全部数据）
     * @author ZhuDefeng
     * @date 2016-10-19
     * @param
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/alldeptcheckboxtreeselect")
    public ModelAndView allDeptCheckBoxTreePage(String isNoCheck) throws Exception{
        ModelAndView view  = new ModelAndView("/common/select/syn_all_dept_ckbox_tree_select");
        view.addObject("isNoCheck",isNoCheck);
        return view;
    }

    /**
     *
     * 进入全选部门树页面（单选，懒加载所有数据）
     * @author ZhuDefeng
     * @date 2016-11-11
     * @param
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/alldeptradiotreeselect")
    public ModelAndView allDeptRadioTreePage(String isNoCheck) throws Exception{
        ModelAndView view  = new ModelAndView("/common/select/syn_all_dept_radio_tree_select");
        view.addObject("isNoCheck",isNoCheck);
        return view;
    }

    /**
     *
     *部门树选择页面根据职能部门编码来过滤部门树
     * @author ZhuDefeng
     * @date 2016-11-14
     * @param
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/deptSelectByDuty")
    public ModelAndView deptSelectByDuty(String dutyDeptCodes,String isFilterBySysUser,String treeType,String isNoCheck,String isUserMange) throws Exception{
        ModelAndView view  = new ModelAndView("/common/select/syn_dept_select_by_duty");
        view.addObject("dutyDeptCodes",dutyDeptCodes);
        view.addObject("isFilterBySysUser",isFilterBySysUser);
        view.addObject("treeType",treeType);
        view.addObject("isNoCheck",isNoCheck);
        view.addObject("isUserMange",isUserMange);
        return view;
    }
    
    /**
     * 
     * 描述   行政区划树
     * @author 赵祥江
     * @date 2017年1月11日 上午11:02:01 
     * @param 
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/deptSelectCtity")
    public ModelAndView deptSelectCtity(String isFilterBySysUser,String treeType,String isNoCheck,String isUserMange) throws Exception{
        ModelAndView view  = new ModelAndView("/common/select/syn_dept_select_city");
        view.addObject("isFilterBySysUser",isFilterBySysUser);
        view.addObject("treeType",treeType==null||"".equals(treeType)?"radio":treeType);
        view.addObject("isNoCheck",isNoCheck);
        view.addObject("isUserMange",isUserMange);
        return view;
    }

    /**
     * 获取所有部门数据（懒加载）
     *
     * @param porgCoding 父节点代码值
     * @author ZhuDefeng
     * @date 2016-11-13
     * @return
     * @throws Exception
     */
    @RequestMapping("/treeWithAllDept")
    @ResponseBody
    public List<SysDepart>  allDeptTree(String porgCoding,String isNoCheck)throws Exception{
        if (StringUtils.isEmpty(porgCoding)) {
            porgCoding = "001";
        }
        SysDepart sysDepart=new SysDepart();
        sysDepart.setPorgCoding(porgCoding);
        List<SysDepart> sysDepartList = null;
        if("1".equals(isNoCheck)||"true".equals(isNoCheck)) {
            sysDepartList= sysDepartService.doGetDepartment(sysDepart, true);//异步取数据，只取出父节点为porgCoding的节点集合
        }else{
            sysDepartList=sysDepartService.doGetDepartment(sysDepart, false);//异步取数据，只取出父节点为porgCoding的节点集合
        }
        return sysDepartList;
    }


    /**
     * 根据职能部门代码来查询部门数据（非懒加载）
     *
     * @author ZhuDefeng
     * @date 2016-11-23
     * @param dutyDeptCodes 职能部门编码（用逗号隔开）
     * @return
     * @throws Exception
     */
    @RequestMapping("/treeByCityCode")
    @ResponseBody
    public List<DeptTree> deptTreeByCityCode(String dutyDeptCodes,String isNoCheck)throws Exception{
        SysUserDto sysUserDto=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        String userLevel=sysUserDto.getUserVest();
        String deptCodeTmp=sysUserDto.getSysDepart().getAdcode();
        SysDepart sysDepart=new SysDepart();
        List<SysDepart> sysDepartList=null;
        if(DBAuthorConstants.USER_LEVEL_PROV.equals(userLevel)){
            sysDepart.setPorgCoding("001");
        }
        if(DBAuthorConstants.USER_LEVEL_CITY.equals(userLevel)){
            sysDepart.setPorgCoding(deptCodeTmp.substring(0,4));
        }
        if(DBAuthorConstants.USER_LEVEL_COUNTRY.equals(userLevel)){
            sysDepart.setPorgCoding(deptCodeTmp.substring(0,6));
        }
        if(DBAuthorConstants.USER_LEVEL_UNIT.equals(userLevel)){
            return null;
        }
        return null;
    }

    /**
     * 根据职能部门代码来查询部门数据（非懒加载）
     *
     * @author ZhuDefeng
     * @date 2016-11-23
     * @param dutyDeptCodes 职能部门编码（用逗号隔开）
     * @return
     * @throws Exception
     */
    @RequestMapping("/treeByDutyCodes")
    @ResponseBody
    public List<DeptTree> deptTreeByDutyDeptCodes(String dutyDeptCodes,String isFilterBySysUser,String isNoCheck,String isUserMange)throws Exception{
        if(StringUtil.isBlank(dutyDeptCodes)&&!"1".equals(isUserMange)) {
            logger.error("获取部门时出错，参数dutyDeptCodes为空");
            return null;
        }
        SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
        //区域管理员
        SysUserAreaManage sysUserAreaManage=sysUserAreaManageService.selectSysUserAreaManageByUserIdentity(sysUser.getId(), "1");
        Map<String,Object> qryMap=new HashMap<>();
        //用户管理模块走下面逻辑其他模块保持不变
        if("1".equals(isUserMange)){
        	if(sysUserAreaManage!=null){//如果是区域管理员则只显示用户所在区域的列表
           	 qryMap.put("isSysUserAreaManage","1");
           	 String deptCodeLike=replaceByUserLevel(sysUser.getSysDepart().getAdcode(),sysUser.getSearchRangeLevel(),"%");
           	 qryMap.put("deptCodeLike",deptCodeLike);
           }else{
           	 qryMap.put("dutyDeptCodes",dutyDeptCodes.split(","));
           }
        }else{
        	 qryMap.put("dutyDeptCodes",dutyDeptCodes.split(","));
        }
        
        if("true".equals(isNoCheck)){
            qryMap.put("isNoCheck","true");
        }
        if(StringUtil.isBlank(isNoCheck)||"false".equals(isNoCheck)){
            qryMap.put("isNoCheck","false");
        }
        List<DeptTree> sysDepartList=new ArrayList<>();
        //权限过滤且不是区域管理员的时候根据查询范围获取
        if("true".equals(isFilterBySysUser)&&sysUserAreaManage==null){
            if(sysUser!=null&&StringUtil.isNotBlank(sysUser.getSearchRangeLevel())){
                if("3".equals(sysUser.getSearchRangeLevel())){
                    qryMap.put("cityOrgMark",sysUser.getSysDepart().getAdcode().substring(0,4));
                }
                if("2".equals(sysUser.getSearchRangeLevel())){
                    qryMap.put("areaOrgMark",sysUser.getSysDepart().getAdcode().substring(0,6));
                }
                if("1".equals(sysUser.getSearchRangeLevel())){//不可能是1
                    return null;
                }
            }
        }
       sysDepartList=sysDepartService.doFindDeptByDutyCodeByDutyCode(qryMap);
        return sysDepartList;
    }

    /**
     * 
     * 描述   获取行政区划
     * @author 赵祥江
     * @date 2017年1月11日 上午10:34:43 
     * @param 
     * @return List<DeptTree>
     * @throws
     */
    @RequestMapping("/deptTreeCtity")
    @ResponseBody
    public List<DeptTree> deptTreeCtity(String isFilterBySysUser,String isNoCheck,String isUserMange)throws Exception{
    	SysUserDto sysUser=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
    	Map<String,Object> qryMap=new HashMap<>();
        if("true".equals(isNoCheck)){
            qryMap.put("isNoCheck","true");
        }
        if(StringUtil.isBlank(isNoCheck)||"false".equals(isNoCheck)){
            qryMap.put("isNoCheck","false");
        }
        /*if("true".equals(isFilterBySysUser)){
            SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
            if(sysUser!=null&&StringUtil.isNotBlank(sysUser.getSearchRangeLevel())){
                if("3".equals(sysUser.getSearchRangeLevel())){
                    qryMap.put("cityOrgMark",sysUser.getSysDepart().getAdcode().substring(0,4));
                }
                if("1".equals(sysUser.getSearchRangeLevel())||StringUtils.isEmpty(sysUser.getSearchRangeLevel())){
                    DeptTree deptTree=sysDepartService.doFindDeptByDutyCodeAndOrgCoding(sysUser.getDeptCode());
                    sysDepartList.add(deptTree);
                    return sysDepartList;
                }
            }
        }*/
        List<DeptTree> sysDepartList=new ArrayList<DeptTree>();
        //非用户管理
        if(!"1".equals(isUserMange)||("1".equals(sysUser.getIsAdmin())||"2".equals(sysUser.getIsAdmin()))||"4".equals(sysUser.getSearchRangeLevel())){
        	sysDepartList=sysDepartService.deptTreeCtity(qryMap);
        	 //虚拟一个省级节点
            DeptTree deptTree=new DeptTree();
            deptTree.setIsParent("false");
            deptTree.setOrgCoding("001005");
            deptTree.setOrgName("省本级");
            deptTree.setPorgCoding("001003");
            deptTree.setAdcode("330000");
            deptTree.setNocheck("false");
            sysDepartList.add(deptTree);
        }else{
        	//区域管理员
            SysUserAreaManage sysUserAreaManage=sysUserAreaManageService.selectSysUserAreaManageByUserIdentity(sysUser.getId(), "1");
            if(sysUserAreaManage!=null){//如果是区域管理员则只显示用户所在区域的列表
            	qryMap.put("adCodeSubFour",sysUser.getSysDepart().getAdcode().substring(0, 4));
          	    //区域管理员标识
            	qryMap.put("isSysUserAreaManage","1");
            	String deptCodeLike=replaceByUserLevel(sysUser.getSysDepart().getAdcode(),sysUser.getSearchRangeLevel(),"%");
            	qryMap.put("deptCodeLike",deptCodeLike);
            }
            sysDepartList=sysDepartService.deptTreeCtity(qryMap);
        }
        return sysDepartList;
    }


    /**
     * 描述：获取部门信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/query")
    @ResponseBody
    public AjaxResult load(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("部门信息不存在");
        }
        SysDepart sysDepart = sysDepartService.doGetById(Integer.parseInt(id));
        if (sysDepart != null) {
            return AjaxResult.success("加载成功", sysDepart);
        } else {
            return AjaxResult.error("部门信息不存在");
        }
    }

}