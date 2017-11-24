/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.rpt.rptservice.IRptSmBaseinfoService;
import com.icinfo.cs.sment.model.SmBaseinfoTemp;
import com.icinfo.cs.sment.service.ISmBaseinfoTempService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import net.sf.json.JSONObject;

/**
 * 描述:    sm_baseinfo_temp 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Controller
@RequestMapping("/sment/smBaseinfoTemp")
public class SmBaseinfoTempController extends BaseController {

    @Autowired
    private ISmBaseinfoTempService smBaseinfoTempService;
    
    @Autowired
    private IRptSmBaseinfoService rptSmBaseinfoService;

    @RequestMapping("toPageList")
    public String toPageList() throws Exception{
        return "sment/smbaseinfotemp/smbaseinfotemp_list";
    }
    
    
    @RequestMapping(value = "/queryPageList.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<SmBaseinfoTemp> queryPageList(HttpSession session,PageRequest request) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        PageResponse<SmBaseinfoTemp> list = smBaseinfoTempService.queryPageList (request, sysUser);
        return list;
    }
    
    @RequestMapping(value="/excelImport",method= RequestMethod.POST)
    @ResponseBody
    public void excelImport(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        
        Map<String, Object> resultMap = smBaseinfoTempService.excelImport (file, sysUser);
        JSONObject json = new JSONObject();
        if(resultMap != null){
         json.put("state", "success");
         json.put("status", resultMap.get("status"));
            json.put("allImportTatol", resultMap.get("allImportTatol"));
            json.put("msg", resultMap.get("msg"));
        }else{
         json.put("state", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
    
    /** 
     * 描述: 根据注册号获取不在培育库的pripid
     * @author 张文男
     * @date 2017年6月15日 
     * @param regNoOrUniCode
     * @return 
     */
    
    @RequestMapping(value = "queryPriPIDByRegNoOrUniCode.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryPriPIDByRegNoOrUniCode(String regNoOrUniCode){
        try {
            String priPID = rptSmBaseinfoService.queryPriPIDByRegNoOrUniCode (regNoOrUniCode);
            return AjaxResult.success ("操作成功！", priPID);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /** 
     * 描述: 删除
     * @author 张文男
     * @date 2017年6月15日 
     * @param id
     * @return 
     */
    
    @RequestMapping(value = "deleteByid.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteByid(Integer id){
        try {
            smBaseinfoTempService.deleteByid (id);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
}