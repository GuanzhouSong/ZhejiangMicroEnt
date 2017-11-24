/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


/**
 * 描述:    cs_sys_depart 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping("/syn/system/sysdepart")
public class SysDepartController extends BaseController {
    private static final long serialVersionUID = -2084061139014623436L;

    @Autowired
    private ISysDepartService sysDepartService;

    @Autowired
    private ISysUserService sysUserService;



    /**
     *
     * 描述: 进入部门管理
     * @auther ZhuDefeng
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list() throws Exception{
        ModelAndView view=new ModelAndView("/system/sysdepart/list_main");
        return view;
    }

    /**
     * 描述：显示系统部门维护
     *
     * @param id  编辑部门ID
     * @param sid 部门树选中部门ID
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String id, String sid) throws Exception {
        ModelAndView view = new ModelAndView("/system/sysdepart/edit");
        SysDepart sysDepart=null;
        if (StringUtils.isNotEmpty(id)) {//修改时
            //修改时候加载原部门信息
            sysDepart=sysDepartService.doGetById(Integer.parseInt(id));
            if (sysDepart != null) {
                view.addObject("sysDepart",sysDepart);
                if (StringUtils.isNotEmpty(sysDepart.getPorgCoding())) {
                    //如果是修改，需要显示父部门名称
                    SysDepart parent=sysDepartService.doGetByCode(sysDepart.getPorgCoding());
                    if(parent!=null){
                        view.addObject("parentName", parent.getOrgName());
                    }
                }
            }
        }else {//新增时
            if (StringUtils.isNotEmpty(sid)) {
                SysDepart _temp = sysDepartService.doGetById(Integer.parseInt(sid));
                if (_temp != null) {
                    view.addObject("parentIdForSub", _temp.getOrgCoding());
                    view.addObject("parentIdForSibling", _temp.getPorgCoding());
                    boolean flag = false;//是否添加所及部门节点
                    if(StringUtils.isNotEmpty(_temp.getAdcode()) && _temp.getAdcode().split("M").length > 1){
                    	flag = true;
                    }
                    String nextAdCode=sysDepartService.doNextAdCode(_temp.getOrgCoding(),flag);//新增时获取下一个adCode值
                    String nextOrgCode=sysDepartService.doNextOrgCoding(_temp.getOrgCoding(),flag);//新增时获取下一个OrgCoding
                    view.addObject("nextAdCode", nextAdCode);
                    view.addObject("nextOrgCode", nextOrgCode);
                }
            }
        }
        return view;
    }


    /**
     * 描述：保存系统部门信息
     *
     * @param sysDepart
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(SysDepartDto sysDepart) throws Exception {
        if (sysDepart.getId()!=null) {
            if (sysDepartService.doModDepartment(sysDepart) > 0) {
                return AjaxResult.success("更新系统部门成功", sysDepart);
            }
            return AjaxResult.error("更新系统部门失败");
        }
        if (sysDepartService.doSaveDepartment(sysDepart)> 0) {
        	sysDepartService.updateParentFlag(sysDepart.getPorgCoding());
            return AjaxResult.success("新增系统部门成功", sysDepart);
        }
        return AjaxResult.error("新增系统部门失败");
    }


    /**
     * 描述：删除部门信息
     * @author ZhuDefeng
     * @param id
     * @return AjaxResult
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id)throws Exception{
        if(StringUtils.isEmpty(id)){
            return AjaxResult.error("删除的部门不存在");
        }
        SysDepart sysDepart=sysDepartService.doGetById(Integer.parseInt(id));
        SysDepart sysDepartCondition=new SysDepart();
        sysDepartCondition.setPorgCoding(sysDepart.getOrgCoding());
        if(sysDepartService.doGetDepartment(sysDepartCondition,false).size()>0){
            return AjaxResult.error("不能删除该部门节点，原因是当前部门节点下还有子节点！");
        }
        List<SysUser> sysUserList=sysUserService.doGetSysUserByDeptCode(sysDepart.getOrgCoding());
        if(sysUserList!=null&&sysUserList.size()>0){
            return AjaxResult.error("不能删除该部门节点，原因是当前部门节点下存在用戶！");
        }
        if(sysDepartService.doRmDepartment(Integer.parseInt(id)) >0){
        	sysDepartService.updateParentFlag(sysDepart.getPorgCoding());
            return AjaxResult.success("删除部门成功");
        }
        return AjaxResult.error("删除部门失败");

    }


}