/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * 描述:  警示系统部门管理控制器.<br>
 *
 * @author ZhuDefeng
 * @date 2016年04月20日
 */
@Controller
@RequestMapping({"/reg/system/dept/tree","/common/system/dept/tree"})
public class RegDeptTreeController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(RegDeptTreeController.class);

    @Autowired
    private IDepartMentService departMentService;


    @Autowired
    private ISysUserService sysUserService;

    /**
     * 描述：跳转到部门树选择页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/select")
    public ModelAndView select_dept(String treeType) throws Exception {
        ModelAndView mav=new ModelAndView("common/select/warn_dept_radio_tree_select");
        mav.addObject("treeType",treeType);
        return mav;
    }

    /**
     * 描述：跳转到部门树选择页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectAll")
    public ModelAndView selectAllDept(String treeType) throws Exception {
        ModelAndView mav=new ModelAndView("common/select/warn_all_dept_radio_tree_select");
        mav.addObject("treeType",treeType);
        return mav;
    }


    /**
     * 描述: 查询所有的警示部门数数据
     *
     * @return
     * @throws Exception
     * @auther ZhuDefeng
     * @date 2016年11月6日
     */
    @RequestMapping({"allTreeData.json", "treeData.xml"})
    @ResponseBody
    public AjaxResult allTreeData(String isNoCheck) throws Exception {
        List<DepartMent> resultData = new ArrayList<>();
        List<PermisionTreeNode> list = new ArrayList<PermisionTreeNode>();
        trans2PermisionTreeNodes(departMentService.selectAll(),list,isNoCheck);
        return AjaxResult.success("查询成功", list);
    }


    /**
     * 描述: 根据查询层级查询部门树数据
     *
     * @return
     * @throws Exception
     * @auther ZhuDefeng
     * @date 2016年11月6日
     */
    @RequestMapping({"treeData.json", "treeData.xml"})
    @ResponseBody
    public AjaxResult listJSON(String isNoCheck) throws Exception {
        List<DepartMent> resultData = new ArrayList<>();
        List<PermisionTreeNode> list = new ArrayList<PermisionTreeNode>();
        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
        if(StringUtils.equalsIgnoreCase(sysUser.getIsAdmin(),"1")){
            trans2PermisionTreeNodes(departMentService.selectAll(),list,isNoCheck);
            return AjaxResult.success("查询成功", list);
        }
        String level = sysUser.getSearchRangeLevel();
//        1：本所2：本局3：本市4：本省
        if (StringUtils.equalsIgnoreCase(level, "1")||StringUtils.isBlank(level)) {
//            DepartMent departMent=departMentService.selectDepartMentByDeptCode(sysUser.getDeptCode());
            DepartMent departMent=departMentService.selectOne(sysUser.getDepartMent().getDeptDID());
            resultData.add(departMent);
        }
        if (StringUtils.equalsIgnoreCase(level, "2")) {
            resultData = departMentService.doGetLevelCountryDept(StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6));
        }
        if (StringUtils.equalsIgnoreCase(level, "3")) {
            resultData = departMentService.doGetLevelCityDept(StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4));
        }
        if (StringUtils.equalsIgnoreCase(level, "4")) {
            resultData = departMentService.selectAll();
        }
        trans2PermisionTreeNodes(resultData,list,isNoCheck);
        return AjaxResult.success("查询成功", list);
    }

    /**
     * 描述：部门数据集合转化
     * @author ZhuDefeng
     * @date 2016-11-06
     * @param resultData
     * @param list
     */
    private void trans2PermisionTreeNodes(List<DepartMent> resultData, List<PermisionTreeNode> list,String isNoCheck) {
        for (DepartMent departMent : resultData) {
            PermisionTreeNode treeNode = new PermisionTreeNode();
            treeNode.setId(departMent.getDeptDID());
            treeNode.setpId(departMent.getDeptPID());
            treeNode.setName(departMent.getDeptName());
            treeNode.setCode(departMent.getDeptCode());
            treeNode.setDeptId(departMent.getId().toString());
            if (departMent.getDeptCode().length() > 6) {
                treeNode.setNocheck("false");
            } else {
                if("true".equals(isNoCheck)){
                    treeNode.setNocheck("true");
                }
            }
            list.add(treeNode);
        }
    }
}
