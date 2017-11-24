/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.EntAssignLog;
import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.cs.system.model.EntDelegateRecord;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IEntAssignLogService;
import com.icinfo.cs.system.service.IEntAssignRecordService;
import com.icinfo.cs.system.service.IEntDelegateRecordService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * 描述:  系统用户管理控制器.<br>
 *
 * @author ZhuDefeng
 * @date 2016年04月20日
 */
@Controller
@RequestMapping("/reg/server/entdbauth")
public class EntDBAuthController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(EntDBAuthController.class);

    @Autowired
    private IMidBaseInfoService midBaseInfoService;

    @Autowired
    private IEntAssignRecordService entAssignService;

    @Autowired
    private ICodeRegorgService codeRegorgService;

    @Autowired
    private ICodeRegunitService codeRegunitService;

    @Autowired
    private IEntDelegateRecordService delegateRecordService;

    @Autowired
    private IEntAssignLogService entAssignLogService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IPanoramaSearchService panoramaSearchService;


    /**
     * 描述：获取企业数据
     * @author ZhuDefeng
     * @date 2016-10-18
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<PanoramaResultDto> listJSON(PageRequest request) throws Exception {
        List<PanoramaResultDto> entBaseInfos=new ArrayList<PanoramaResultDto>();
        UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
        SysUser sysUser=sysUserService.selectByUserName(userProfile.getUsername());
        String deptCode=sysUser.getDeptCode();
        if(deptCode==null||deptCode.length()<8){
            return new PageResponse<PanoramaResultDto>(entBaseInfos);
        }else{
            entBaseInfos=panoramaSearchService.doGetSearchList(request);
        }
        return new PageResponse<PanoramaResultDto>(entBaseInfos);
    }

    /**
     *描述：进入企业数据权限的委托页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list4delegate")
    public ModelAndView list4delegate() throws Exception {
        ModelAndView mav = new ModelAndView("system/entdbauth/list4delegate");
        return  mav;
    }

    /**
     *描述：进入企业数据权限用户分配页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list4assign")
    public ModelAndView list4assign() throws Exception {
        ModelAndView mav = new ModelAndView("system/entdbauth/list4assign");
        return  mav;
    }

    /**
     *描述：进入企业数据权限用户分配操作日志查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list_assign_log")
    public ModelAndView listAssignLog() throws Exception {
        ModelAndView mav = new ModelAndView("system/entdbauth/list_assign_log");
        List<CodeRegorg> regOrgList = codeRegorgService.selectCodeRegorgList();
        mav.addObject("regOrgList", regOrgList);
        return  mav;
    }





    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list_assign_log_data.json", "list_assign_log_json.xml"})
    @ResponseBody
    public PageResponse<EntAssignLog> listAssignLogJSON(PageRequest request) throws Exception {
        List<EntAssignLog> entAssignLogs=entAssignLogService.doSelectPage(request);
        return new PageResponse<EntAssignLog>(entAssignLogs);
    }


    /**
     * 描述：设置委托
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delegate")
    @ResponseBody
    public AjaxResult delegate(String priPIDs) throws Exception {
        UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
        if(StringUtils.isBlank(priPIDs)){
            return AjaxResult.error("请至少选择一项！");
        }
        midBaseInfoService.setDelegate(priPIDs.split(","),userProfile);
        return AjaxResult.success("委托成功！");
    }

    /**
     * 描述：取消委托
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cancle_delegate")
    @ResponseBody
    public AjaxResult cancleDelegate(String priPIDs) throws Exception {
        UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
        if(StringUtils.isBlank(priPIDs)){
            return AjaxResult.error("请至少选择一项！");
        }
        midBaseInfoService.cancleDelegate(priPIDs.split(","), userProfile);
        return AjaxResult.success("委托成功！");
    }

    /**
     * 描述：跳转到委托记录查询页面
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delegate_record")
    public String delegateRecord()throws Exception{
        return "system/entdbauth/delegate_record";
    }


    /**
     * 描述：跳转到委托记录查询页面
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping({"/delegate_record.json","/delegate_record.xml"})
    @ResponseBody
    public PageResponse<EntDelegateRecord> delegateRecordJson(PageRequest request)throws Exception{
        List<EntDelegateRecord> entDelegateRecords=delegateRecordService.query(request);
        return new PageResponse<EntDelegateRecord>(entDelegateRecords);
    }

    /**
     * 描述：指定用户分配
     * @Author ZhuDefeng
     * @Date 2016-10-9
     * @return
     * @throws Exception
     */
    @RequestMapping("/select_dept_user")
    public ModelAndView selectUser4assign(String priPIDs) throws Exception {
        UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
        ModelAndView mav = new ModelAndView("system/entdbauth/select_dept_user");
        priPIDs = AESEUtil.encodeCorpid(priPIDs);//+密
        mav.addObject("priPIDs", priPIDs);
        return mav;
    }

    /**
     * 用户分配记录查询
     * @Author ZhuDefeng
     * @Date 2016-10-9
     * @return
     * @throws Exception
     */
    @RequestMapping("/assign_record")
    public String assignrecord()throws Exception{
        return "system/entdbauth/assign_record";
    }


    /**
     * 系统数据JSON数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/listAssignRecord.json", "listAssignRecord.xml"})
    @ResponseBody
    public PageResponse<EntAssignRecord> listAssignJSON(PageRequest request) throws Exception {
        List<EntAssignRecord> entAssigns=entAssignService.query(request);
        return new PageResponse<EntAssignRecord>(entAssigns);
    }

    /**
     * 描述：指定分配
     * @author ZhuDefeng
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/assign")
    @ResponseBody
    public AjaxResult assign(String priPIDs,String userIds) throws Exception {
        priPIDs = AESEUtil.decodeCorpid(priPIDs);//解密
        SysUserDto sysUserDto= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
        entAssignService.doAssign(priPIDs, userIds, sysUserDto);
        return AjaxResult.success("分配成功！");
    }

    /**
     * 描述：取消指定分配
     * @author ZhuDefeng
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cancle_assign")
    @ResponseBody
    public AjaxResult cancleAssign(String assignUID,String priPID,String userId) throws Exception {
        UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
        entAssignService.doCancleAssign(assignUID,priPID, userId, userProfile);
        return AjaxResult.success("取消成功！");

    }

}
