/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.dto.ModApplicationDto;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:    cs_mod_application 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
@Controller
@RequestMapping("/reg/server/yr/modapplication")
public class ModApplicationController extends CSBaseController {
	
	@Autowired
	private IModApplicationService modApplicationService;
	
	@Autowired
	//登记机关
	private ICodeRegorgService codeRegorgService;
	
	@Autowired
	//管辖单位
	private ICodeRegunitService codeRegunitService;
	
	@Autowired
	private ISysLogService iSysLogService;
	
	//token管理
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private IRegIndexService regIndexService;
	

	
	/**
	 * 
	 * 描述: 进入申请修改列表页面
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/modapplication/modapplication_list");
		view.addObject("yearList",DateUtil.getYearToNowForReport());
		return view;
	}
	
	/**
     * 描述：获取列表Json数据
     * @author chenxin
     * @date 2016-09-11
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<ModApplicationDto> listJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request,"c.CheckDep","c.LocalAdm");
		List<ModApplicationDto> data = modApplicationService.queryPage(request);
        return new PageResponse<ModApplicationDto>(data);
    }
	
	/**
     * 描述：获取年报申报历史表列表Json数据
     * @author chenxin
     * @date 2016-09-11
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/historylist.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<ModApplication> listHisToryJSON(PageRequest request) throws Exception {
		List<ModApplication> data = modApplicationService.queryHisPage(request);
        return new PageResponse<ModApplication>(data);
    }
	
	/**
	 * 描述：进入申请修改审核详细页面
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit",method = RequestMethod.GET)
	public ModelAndView editModApplicationPage(@RequestParam(required = false) Integer modApplicationId) throws Exception {
		if(modApplicationId <= 0){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", modApplicationId);
		ModApplicationDto modApplicationDto =  modApplicationService.selectModApplicationApplyById(map);
		UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);//-->sysUser
		modApplicationDto.setCurrentDate(DateUtil.getCurrentDate());
		modApplicationDto.setAudName(userProfile.getRealName());
        ModelAndView view = new ModelAndView("/reg/server/yr/modapplication/modapplication_edit");
		view.addObject(modApplicationDto);
		return view;
	}
	

	/**
	 * 描述：进入申请修改审核详细页面
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public ModelAndView showModApplicationPage(@RequestParam(required = false) Integer modApplicationId) throws Exception {
		if(modApplicationId <= 0){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", modApplicationId);
		ModApplicationDto modApplicationDto =  modApplicationService.selectModApplicationApplyById(map);
		UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);//-->sysUser
		modApplicationDto.setCurrentDate(DateUtil.getCurrentDate());
		modApplicationDto.setAudName(userProfile.getRealName());
        ModelAndView view = new ModelAndView("/reg/server/yr/modapplication/modapplication_show");
		view.addObject(modApplicationDto);
		return view;
	}
	
	/**
	 * 描述：年报修改申请审核
	 * 
	 * @author chenxin
	 * @date 2016-09-14
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommitModApplycationCheck(ModApplication modApplication,String entTypeCatg,String regNo) throws Exception {
		if (modApplication.getId() != null) {
			Map<String, String> logMap = new HashMap<String, String>();
			List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
			UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);//-->sysUser
			SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			modApplication.setAudDate(new Date());
			modApplication.setAudName(userProfile.getRealName());
			modApplication.setModResubmit("1");
			if (modApplicationService.applyModApplicationAddLog(modApplication, logCollector)) {
				//修改申请审核成功，对当前用户对应的统计缓存数据重新设置
		    	//统计map
		        Map<String, Object> forBidmap = new HashMap<String, Object>();
		        //操作权限添加
		        creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
				//1.得到当前统计条数  （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
		        List<Integer> temList= tokenManager.getRegCountList(userProfile.getUserId());
		        List<Integer> countTepList = new ArrayList<Integer>();
		        if(temList != null && temList.size() >0 ){ //缓存存在
	                countTepList.add(temList.get(0));  //敏感词审核
	                countTepList.add(temList.get(1)-1); //修改申请审核
	                countTepList.add(temList.get(2)); //企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
	                countTepList.add(temList.get(3)); //农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
		        }else{ //缓存不存在,数据库取值，重新设置缓存
		        	countTepList = regIndexService.getCount(forBidmap,sysUser);
		        }
		        //2 重新设置缓存
				tokenManager.setRegCountToken(userProfile.getUserId(), countTepList);
				
				logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID, modApplication.getPriPID());
				logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME, modApplication.getEntName());
				logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,modApplication.getYear().toString());
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SERVER);
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.ModApplicationLog.getCode());
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGEENTYPE,entTypeCatg);
				logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,regNo);
				SysLogJson logJson = new SysLogJson(logCollector);
				JSONObject jsonObject = JSONObject.fromObject(logJson);
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
				iSysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
				return AjaxResult.success("保存成功");
			}
		}
		return AjaxResult.error("保存失败");
	}
}