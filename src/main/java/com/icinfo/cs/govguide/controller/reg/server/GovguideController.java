/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.govguide.controller.reg.server;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.impl.MidBaseInfoServiceImpl;
import com.icinfo.cs.govguide.model.Govguide;
import com.icinfo.cs.govguide.service.IGovguideService;
import com.icinfo.cs.orderreform.model.OrderReformSet;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.cs.yr.service.impl.SysLicenseServiceImpl;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_govguide_set 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping("/reg/server/govguide/govguide/")
public class GovguideController extends CSBaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(GovguideController.class);

    @Autowired
    private IGovguideService govguideService;
    @Autowired
    private MidBaseInfoServiceImpl midBaseInfoService;
    @Autowired
    private SysLicenseServiceImpl sysLicenseService;
	@Autowired
	IRegIndexService regIndexService;
    //-------------------------------------------------跳转页面方法--------------------------------------
    /**
     * 跳转到行政指导设置表格页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toList")
    public ModelAndView toList() throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguide_list");

        return  modelAndView;
    }
    /**
     * 跳转到行政指导设置新增表格页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toAddList")
    public ModelAndView toAddList() throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguideadd_list");
        modelAndView.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
        return  modelAndView;
    }
    /**
     * 跳转到行政指导审核表格页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toCheckList")
    public ModelAndView toCheckList() throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguidecheck_list");
        return  modelAndView;
    }
    /**
     * 跳转到许可证选择页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toLicence")
    public ModelAndView toLicence() throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/licence_list");
        List<SysLicense> sysLicenses = sysLicenseService.selectVaildLicList(null);
        modelAndView.addObject("sysLicenses",sysLicenses);
        return  modelAndView;
    }
    /**
     * 跳转到行政指导设置新增、编辑、中止、审核页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toAdd")
    public ModelAndView toAdd(String uid,String pripid,String fromtype, HttpSession session) throws Exception{
        //申请查看、审核查看、审核也是这个页面
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguideadd_edit");
        Govguide govguide = new Govguide();
        SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
        //修改
        if(!fromtype.equals("add")){
            govguide = govguideService.getGovGuideByUid(uid);

        }
        //添加
        else{
            govguide.setApplyman(sysUser.getRealName());
            govguide.setApplydate(new Date());
            govguide.setUid("");
            govguide.setPripid(pripid);
            MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pripid);
            if(midBaseInfo!=null){
                govguide.setEntname(midBaseInfo.getEntName());
                govguide.setRegorgname(midBaseInfo.getRegOrgName());
                govguide.setRegorg(midBaseInfo.getRegOrg());
                govguide.setLocaladm(midBaseInfo.getLocalAdm());
                govguide.setLocaladmname(midBaseInfo.getLocalAdmName());
                govguide.setEntname(midBaseInfo.getEntName());
                govguide.setUniscid(midBaseInfo.getUniCode());
                govguide.setRegno(midBaseInfo.getRegNO());
            }

        }
        //审核
        if(fromtype.equals("check")){
            govguide.setAuditname(sysUser.getRealName());
            govguide.setAuditdate(new Date());
        }
        //中止
        if(fromtype.equals("sus")||fromtype.equals("susview")){
            modelAndView = new ModelAndView("reg/server/govguide/govguidesus_edit");
            govguide.setApplysusman(sysUser.getRealName());
            govguide.setApplysusdate(new Date());
        }
        modelAndView.addObject("govguide",govguide);
        modelAndView.addObject("fromtype",fromtype);
        return  modelAndView;
    }
    /**
     * 跳转到打印书通知页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toViewPrint")
    public ModelAndView toViewPrint(String uid,String pripid,String entname,String fromtype, HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguideview_print");//审核查看也是这个页面
        Govguide govguide = new Govguide();
        //修改
        if(StringUtil.isNotEmpty(uid)){
            govguide = govguideService.getGovGuideByUid(uid);
        }
        LocalDate localDate = LocalDate.now();

        modelAndView.addObject("now", localDate.getYear()+"年"+localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日");
        modelAndView.addObject("govguide",govguide);
        modelAndView.addObject("fromtype",fromtype);
        return  modelAndView;
    }
    /**
     * 跳转到编辑打印页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toEditPrint")
    public ModelAndView toEditPrint(String uid,String pripid,String fromtype, HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguideedit_print");//审核查看也是这个页面
        Govguide govguide = new Govguide();
        SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
        //修改
        if(!fromtype.equals("add")){
            govguide = govguideService.getGovGuideByUid(uid);
        }
        //添加
        else{
            govguide.setApplyman(sysUser.getRealName());
            govguide.setApplydate(new Date());
            govguide.setUid("");
            govguide.setPripid(pripid);
            MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pripid);
            govguide.setEntname(midBaseInfo.getEntName());
            govguide.setUniscid(midBaseInfo.getUniCode());
            govguide.setRegno(midBaseInfo.getRegNO());
        }
        //审核
        if(fromtype.equals("check")){
            govguide.setAuditname(sysUser.getRealName());
            govguide.setAuditdate(new Date());
        }
        modelAndView.addObject("govguide",govguide);
        modelAndView.addObject("fromtype",fromtype);
        return  modelAndView;
    }

    /**
     * 跳转到编辑打印页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toSusEditPring")
    public ModelAndView toSusPring(String uid,String pripid,String entname,String fromtype, HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView("reg/server/govguide/govguidesus_print");//审核查看也是这个页面
        Govguide govguide = new Govguide();
        //修改
        if(StringUtil.isNotEmpty(uid)){
            govguide = govguideService.getGovGuideByUid(uid);
        }
        modelAndView.addObject("govguide",govguide);
        modelAndView.addObject("fromtype",fromtype);
        return  modelAndView;
    }
    //-------------------------------------------------业务逻辑方法--------------------------------------
    /**
     * 请求行政指导设置页面表格数据。cs_govguide_set
     * @param request
     * @return PageResponse
     *
     */
    @RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<Govguide> listJSON(PageRequest request) throws Exception {
        creatDefaultDBAuthEnv(request,"RegOrg","LocalAdm");
        List<Govguide> data = govguideService.govguide_querypage(request);
        return new PageResponse<Govguide>(data);
    }
    /**
     * 请求行政指导设置新增页面表格数据。cs_mid_baseinfo
     * @param request
     * @return PageResponse
     *
     */
    @RequestMapping("/listAdd.json")
    @ResponseBody
    public PageResponse<MidBaseInfo> listAddJSON(PageRequest request) throws Exception {
        List<MidBaseInfo> data = govguideService.midbaseinfoForAdd_querypage(request);
        return new PageResponse<MidBaseInfo>(data);
    }
    /**
     * 请求行政指导审核页面表格数据。cs_govguide_set
     * @param request
     * @return PageResponse
     *
     */
    @RequestMapping("/listCheck.json")
    @ResponseBody
    public PageResponse<Govguide> listCheckJSON(PageRequest request) throws Exception {
        creatDefaultDBAuthEnv(request,"RegOrg","LocalAdm");
        List<Govguide> data = govguideService.govguidecheck_querypage(request);
        return new PageResponse<Govguide>(data);
    }

    /**
     * 新增\修改、审核、中止行政指导
     * @param govguide
     * @return AjaxResult
     *
     */
    @RequestMapping("/modi")
    @ResponseBody
    public AjaxResult modi(@RequestBody Govguide govguide) throws Exception {    	
    	//新增+1 成功后 变为未审核
    	boolean flag = StringUtil.isEmpty(govguide.getUid());
    	//不为新增，获取当前行政指导状态
    	String oldState = "";
    	if(!flag){
    		Govguide oldGovguide = govguideService.getGovGuideByUid(govguide.getUid());
    		oldState = oldGovguide == null ? "":oldGovguide.getAuditstate();
    	}

    	//审核-1
    	//修改  由退回修改状态 修改成功后 也为未审核
        int res  = govguideService.modiGovSet(govguide);
        if(res<1)
        {
            if(res==-1)
                return AjaxResult.error("操作失败,该企业所属的部门字号不能为空,请检查配置后重新审核！");
            return AjaxResult.error("操作失败！");
        }
        else 
            if(flag || ("2".equals(oldState)&&"0".equals(govguide.getAuditstate()))){//新增或者退回修改后成功
    			try {
    		        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
    				//操作成功后  缓存重新设置（行政指导新增申请成功，待审核+1）
    				Map<String, Object> forBidmap = new HashMap<String, Object>();
    				String regOrg = selectRegorgByDeptCode(sysUser);
    				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
    				forBidmap.put("regOrg", regOrg);
    				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 11, 1,"1",sysUser);
    			} catch (Exception e) {
    				return AjaxResult.success("操作成功");
    			}
            }
            if(!"0".equals(govguide.getAuditstate()) && govguide.getAuditstate() != null && "0".equals(oldState)){//确定为审核，待审核-1
    			try {
    		        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
    				//操作成功后  缓存重新设置（行政指导新增申请成功，待审核+1）
    				Map<String, Object> forBidmap = new HashMap<String, Object>();
    				String regOrg = selectRegorgByDeptCode(sysUser);
    				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
    				forBidmap.put("regOrg", regOrg);
    				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 11, 1,"2",sysUser);
    			} catch (Exception e) {
    				return AjaxResult.success("操作成功");
    			}
            }
        	return AjaxResult.success("操作成功!");
    }
    /**
     * 删除行政指导
     * @param uid
     * @return AjaxResult
     *
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult del(String uid) throws Exception {
		Govguide oldGovguide = govguideService.getGovGuideByUid(uid);
		String oldState = oldGovguide == null ? "":oldGovguide.getAuditstate();
        int res  = govguideService.delGovSet(uid);
        if(res<1)
            return AjaxResult.error("操作失败！");
        else 
			try {
				if("0".equals(oldState)){
			        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					//操作成功后  缓存重新设置（行政指导新增申请删除成功，待审核-1）
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 11, 1,"2",sysUser);
				}
			} catch (Exception e) {
				return AjaxResult.success("操作成功");
			}
        	return AjaxResult.success("操作成功!");
    }



}