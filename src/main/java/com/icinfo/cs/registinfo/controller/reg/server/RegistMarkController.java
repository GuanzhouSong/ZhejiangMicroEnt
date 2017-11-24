/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.cs.registinfo.dto.RegistMarkDto;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistMarkHis;
import com.icinfo.cs.registinfo.service.IRegistMarkHisService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_regist_mark 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/registmark")
public class RegistMarkController extends CSBaseController {

    @Autowired
    private IRegistMarkService    registMarkService;

    @Autowired
    private IRegistMarkHisService registMarkHisService;
    
    @Autowired
    private IMainMarkRelService mainMarkRelService;

    @RequestMapping("/registMarkAuditListPage")
    public ModelAndView registMarkAuditListPage(HttpSession session) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        ModelAndView view = new ModelAndView ("/reg/server/registmark/registmarkaudit_list");
        // 警示协同的地址 默认警示
        String sysUrl = "/reg/server";
        String deptCode = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            sysUrl = "/syn";
            deptCode = sysUser.getSysDepart ().getAdcode ().substring (0, 4);
        } else {
            deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 4);
        }
        view.addObject ("sysUrl", sysUrl);
        view.addObject ("sysUser", sysUser);
        view.addObject ("deptCode", deptCode);
        return view;
    }

    /**
     * 
     * 描述   进入审核页面
     * @author 赵祥江
     * @date 2017年3月23日 上午11:08:45 
     * @param 
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/registMarkAuditPage")
    public ModelAndView registMarkAuditPage(HttpSession session,String uid,String flag) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        ModelAndView view = new ModelAndView ("/reg/server/registmark/registmarkaudit_edit");
        RegistMark registMark = registMarkService.selectRegistMarkBymarkUuid (uid);
        // 警示协同的地址 默认警示
        String sysUrl = "/reg/server";
        String deptCode = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            sysUrl = "/syn";
            deptCode = sysUser.getSysDepart ().getAdcode ().substring (0, 4);
        } else {
            deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 4);
        }
        
        // 警示协同的地址 默认警示
        String deptCode2 = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            deptCode2= sysUser.getSysDepart ().getAdcode ().substring (0, 6);
        } else {
            deptCode2 = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        }

        String userType = "";
        if (deptCode2.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode2.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
        }
        
        
        view.addObject ("flag", flag);
        view.addObject ("registMark", registMark);
        view.addObject ("sysUrl", sysUrl);
        view.addObject ("sysUser", sysUser);
        view.addObject ("nowDate", DateUtil.getCurrentDate ());
        view.addObject ("auditDeptName", sysUser.getDepartMent ().getDeptName ());
        view.addObject ("deptCode", deptCode);
        view.addObject ("userType", userType);
        
        return view;
    }

    /**
     * 描述: 分类标签目录申请-列表
     * 
     * @author 张文男
     * @date 2017年3月22日
     * @param session
     * @return
     * @throws Exception
     */

    @RequestMapping("/toDirectoryApplyList")
    public ModelAndView toDirectoryApplyList(HttpSession session) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        ModelAndView view = new ModelAndView ("/reg/server/registmark/registmarkapply_list");
        // 警示协同的地址 默认警示
        String sysUrl = "/reg/server";
        String deptCode = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            sysUrl = "/syn";
            deptCode = sysUser.getSysDepart ().getAdcode ().substring (0, 4);
        } else {
            deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 4);
        }
        view.addObject ("sysUrl", sysUrl);
        view.addObject ("sysUser", sysUser);
        view.addObject ("deptCode", deptCode);
        return view;
    }

    /**
     * 描述: 分类标签目录申请-新增
     * 
     * @author 张文男
     * @date 2017年3月22日
     * @param session
     * @return
     * @throws Exception
     */

    @RequestMapping("/registmarkapply_add")
    public ModelAndView registmarkapplyAdd(HttpSession session) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        // 警示协同的地址 默认警示
        String deptCode = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            deptCode = sysUser.getSysDepart ().getAdcode ().substring (0, 6);
        } else {
            deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        }

        String userType = "";
        if (deptCode.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
        }
        ModelAndView view = new ModelAndView ("/reg/server/registmark/registmarkapply_add");
        view.addObject ("sysUser", sysUser);
        view.addObject ("deptCode", deptCode);
        view.addObject ("userType", userType);
        view.addObject ("nowDate", DateUtil.getCurrentDate ());
        return view;
    }

    /** 
     * 描述: 分类标签目录申请-编辑
     * @author 张文男
     * @date 2017年3月23日 
     * @param id
     * @return
     * @throws Exception 
     */

    @RequestMapping("/registmarkapply_edit")
    public ModelAndView registmarkapplyAdd(HttpSession session,String id,String flag) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        // 警示协同的地址 默认警示
        String deptCode = "";
        // 协同
        if ("2".equals (sysUser.getUserType ())) {
            deptCode = sysUser.getSysDepart ().getAdcode ().substring (0, 6);
        } else {
            deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        }

        String userType = "";
        if (deptCode.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
        }
        ModelAndView view = new ModelAndView ("/reg/server/registmark/registmarkapply_edit");
        view.addObject ("bean", registMarkService.queryBeanByMarkUuid (id));
        // 修改和查看标识 1 修改 2 查看详情
        view.addObject ("flag", flag);
        view.addObject ("userType", userType);
        return view;
    }

    /**
     * 
     * 描述 分页查询标签审核列表 @author 赵祥江 @date 2017年3月23日 上午9:00:53 @param @return
     * PageResponse<RegistMarkDto> @throws
     */
    @RequestMapping("/selectRegistMarkAuditJSON")
    @ResponseBody
    public PageResponse<RegistMarkDto> selectRegistMarkAuditJSON(HttpSession session,PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        // 去掉查询参数的左右空格
        com.icinfo.cs.common.utils.StringUtil.paramTrim (queryMap);
        request.setParams (queryMap);
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else if (sysSetDeptCode.substring (4, 6).equals ("00")) {// 市局
            sysSetDeptCode = sysSetDeptCode.substring (0,4);
        } 
        
        queryMap.put ("sysSetDeptCode", sysSetDeptCode);
        List<RegistMarkDto> registMarkDtoList = registMarkService.queryRegistMarkAuditJSONList (request);
        return new PageResponse<RegistMarkDto> (registMarkDtoList);
    }

    /**
     * 描述: 根据标签名称模糊查询列表
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param IDName
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryListInstrIDName.json")
    @ResponseBody
    public AjaxResult queryListInstrIDName(HttpSession session,String term) throws Exception{
        // 去掉查询参数的左右空格
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        
        String psetDeptCode = "";
        String deptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        String userType = "";
        if (deptCode.equals ("330000")) {// 省局
            userType = "1";
        } else if (deptCode.substring (4, 6).equals ("00")) {// 市局
            userType = "2";
        } else {// 区县局
            userType = "3";
            psetDeptCode = deptCode.substring (0, 4) + "00";
        }
        
        return AjaxResult.success ("", registMarkService.queryListInstrIDName (term,userType,deptCode,psetDeptCode));
    }
    
    /** 
     * 描述: 根据code获取标签信息
     * @author 张文男
     * @date 2017年4月19日 
     * @param idcode
     * @return 
     */
    
    @RequestMapping("/queryByIDCode.json")
    @ResponseBody
    public AjaxResult queryByIDCode(String idcode) {
        return AjaxResult.success ("", registMarkService.queryByIDCode (idcode));
    }
    

    /**
     * 描述: 根据类型、父级code获取所有标签列表
     * 
     * @author 张文男
     * @date 2017年3月23日
     * @param type
     * @param pcode
     * @return
     * @throws Exception
     */

    @RequestMapping("/queryListByIDType.json")
    @ResponseBody
    public AjaxResult queryListByIDType(String type,String pcode) throws Exception{
        return AjaxResult.success ("", registMarkService.queryListByIDType (type, pcode));
    }

    /**
     * 批量分配
     *
     * @param bean
     * @return AjaxResult
     */
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult saveOrUpdate(RegistMark bean) throws Exception{
        bean.setAuditState ("1");
        bean.setAuditDeptName ("");
        bean.setAuditorName ("");
        registMarkService.saveOrUpdate (bean);
        return AjaxResult.success ("操作成功!");
    }

    /** 
     * 描述: 获取分页列表
     * @author 张文男
     * @date 2017年3月23日 
     * @param request
     * @return
     * @throws Exception 
     */

    @RequestMapping("/registmarkapply_list.json")
    @ResponseBody
    public PageResponse<RegistMark> registmarkapplyList(HttpSession session,PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        // 去掉查询参数的左右空格
        com.icinfo.cs.common.utils.StringUtil.paramTrim (queryMap);
        request.setParams (queryMap);
        
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else if (sysSetDeptCode.substring (4, 6).equals ("00")) {// 市局
            sysSetDeptCode = sysSetDeptCode.substring (0,4);
        } 
        
        request.getParams ().put ("sysSetDeptCode", sysSetDeptCode);
        List<RegistMark> list = registMarkService.queryPageList (request);
        return new PageResponse<RegistMark> (list);
    }

    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年3月23日 
     * @param id
     * @return
     * @throws Exception 
     */

    @RequestMapping("/registmarkapply_delete.json")
    @ResponseBody
    public AjaxResult registmarkapplyDelete(String id,String idcode) throws Exception{
        registMarkService.deleteByMarkUuid (id,idcode);
        return AjaxResult.success ("", null);
    }

    @RequestMapping(value = "/commitRegistMarkAudit",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult commitRegistMarkAudit(@RequestBody Map<String, String> registMap,HttpSession session) throws Exception{
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            registMarkService.audit (sysUser, registMap);
            return AjaxResult.success ("审核成功!", "0");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("审核失败!");
    }

    /**
     * 
     * 描述   分页查询标签历史记录审核列表
     * @author 赵祥江
     * @date 2017年3月23日 上午9:00:53 
     * @param 
     * @return PageResponse<RegistMarkDto>
     * @throws
     */
    @RequestMapping("/selectRegistMarkAuditHisJSON")
    @ResponseBody
    public PageResponse<RegistMarkHis> selectRegistMarkAuditHisJSON(PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        // 去掉查询参数的左右空格
        com.icinfo.cs.common.utils.StringUtil.paramTrim (queryMap);
        request.setParams (queryMap);
        List<RegistMarkHis> registMarkDtoList = registMarkHisService.queryRegistMarkHisListByIdCode (request);
        return new PageResponse<RegistMarkHis> (registMarkDtoList);
    }
    
    
    /** 
     * 描述: 统计子类标签数量
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode
     * @return 
     */
    
    @RequestMapping("/queryCountLikeIDCode.json")
    @ResponseBody
    public AjaxResult queryCountLikeIDCode(String idcode) {
        try {
            long count = registMarkService.queryCountLikeIDCode (idcode);
            return AjaxResult.success ("",count);
        } catch (Exception e) {
           e.printStackTrace ();
        }
        return AjaxResult.error ("数据获取失败");
    }
 
    /** 
     * 描述: 根据父类code获取双随机子类列表 
     * @author 张文男
     * @date 2017年4月21日 
     * @param pcode
     * @return 
     */
    
    @RequestMapping("/queryDoublyStoListByPcode.json")
    @ResponseBody
    public AjaxResult queryDoublyStoListByPcode(String pcode) {
        try {
            List<RegistMarkDto> list = registMarkService.queryDoublyStoListByPcode (pcode);
            return AjaxResult.success ("",list);
        } catch (Exception e) {
           e.printStackTrace ();
        }
        return AjaxResult.error ("数据获取失败");
    }
    
    /** 
     * 描述: 根据code获取双随机3级信息
     * @author 张文男
     * @date 2017年4月21日 
     * @param code
     * @return 
     */
    
    @RequestMapping("/queryDoublyStoThiInfoByCode.json")
    @ResponseBody
    public AjaxResult queryDoublyStoThiInfoByCode(String code) {
        try {
            List<RegistMarkDto> bean = registMarkService.queryDoublyStoThiInfoByCode (code);
            return AjaxResult.success ("",bean);
        } catch (Exception e) {
           e.printStackTrace ();
        }
        return AjaxResult.error ("数据获取失败");
    }
}