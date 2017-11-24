/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.sccheck.dto.PubScPlanTaskDto;
import com.icinfo.cs.sccheck.dto.PubScentAgentDto;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScentAgentService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 
 * 描述: 首页可视化（抽查“双随机”）
 * @author gaojinling
 * @date 2017年11月9日
 */
@Controller
@RequestMapping("/reg/server/regChartsCheck" )
public class RegChartCheckController extends CSBaseController  {
	 @Autowired
	 private IPubScPlanTaskService pubScPlanTaskService;
	 @Autowired
	 private IPubScentAgentService pubScentAgentService;
	 @Autowired
	 private IPubScentResultService pubScentResultService;


	 /**
	  * “双随机”可视化  抽查任务统计
	  * @auther gaojinling
	  * @date 2017年11月9日 
	  * @param request
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value = "/getChecktaskTotal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getChecktaskTotal(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);

        try {
//        	map.put("rptYear", DateUtil.getCurrentYear());
        	map.put("rptDateEnd", DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));
        	//根据登录人员的职能部门设置整体权限
        	setCheckDefaultParams(sysUser,map);
        	List<PubScPlanTaskDto> list = pubScPlanTaskService.selectScPlanTaskChartsCount(map);
        	if(!map.containsKey("groupFlag")){//分组标志不存在
        		PubScPlanTaskDto pubScPlanTaskDto = list.get(0);
                return AjaxResult.success("操作成功",pubScPlanTaskDto);
        	}else{//分组标志存在，查询12地市数据
        		List<String> areaCodes = new ArrayList<String>();
        		List<Integer> sureCheckNums = new ArrayList<Integer>();
        		List<Integer> isCheckTedNums = new ArrayList<Integer>();
                List<BigDecimal> checkRoateList = new ArrayList<BigDecimal>();
        		for(PubScPlanTaskDto dto : list ){
        			areaCodes.add(dto.getAreaCode());
        			sureCheckNums.add(dto.getEntTotal());
        			isCheckTedNums.add(dto.getFinishedNum());
        			checkRoateList.add(dto.getCheckRoate());
        		}
                JSONObject obj = new JSONObject();
                obj.put("areaCodes", areaCodes);
                obj.put("sureCheckNums", sureCheckNums);
                obj.put("isCheckTedNums", isCheckTedNums);
                obj.put("checkRoateList", checkRoateList);
                return AjaxResult.success ("操作成功",obj);
        	}
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！"); 
	}
	
	
	 /**
	  * “双随机”可视化  参与抽查人员统计
	  * @auther gaojinling
	  * @date 2017年11月9日 
	  * @param request
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value = "/getCheckPersonTotal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getCheckPersonTotal(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
       try {
//       	map.put("rptYear", DateUtil.getCurrentYear());
       	map.put("rptDateEnd", DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));
       	//根据登录人员的职能部门设置整体权限
       	setCheckDefaultParams(sysUser,map);
       	List<PubScentAgentDto> list = pubScentAgentService.selectPubScentAgentChartsCount(map);
       	if(!map.containsKey("groupFlag")){//分组标志不存在
       		PubScentAgentDto pubScentAgentDto = list.get(0);
            return AjaxResult.success("操作成功",pubScentAgentDto);
       	}else{//分组标志存在，查询12地市数据
       		List<String> areaCodes = new ArrayList<String>();
       		List<Integer> checkPersonNums = new ArrayList<Integer>();
       		int checkPersonNum = 0;
       		for(PubScentAgentDto dto : list ){
       			areaCodes.add(dto.getAreaCode());
       			checkPersonNums.add(dto.getCheckPersonNum());
       			checkPersonNum= checkPersonNum+dto.getCheckPersonNum();
       		}
               JSONObject obj = new JSONObject();
               obj.put("areaCodes", areaCodes);
               obj.put("checkPersonNums", checkPersonNums);
               obj.put("checkPersonNum", checkPersonNum);
               return AjaxResult.success ("操作成功",obj);
       	}
       } catch (Exception e) {
           e.printStackTrace ();
       }
       return AjaxResult.error ("操作失败！"); 
	}
	
	/**
	 * “双随机”可视化  抽检结果统计
	 * @auther gaojinling
	 * @date 2017年11月9日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCheckResultTotal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getCheckResultTotal(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		try {
//			map.put("rptYear", DateUtil.getCurrentYear());
			map.put("rptDateEnd", DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));
			//根据登录人员的职能部门设置整体权限
			setCheckDefaultParams(sysUser,map);
			List<PubScentResultDto> list = pubScentResultService.selectScentResultChartCount(map);
			PubScentResultDto dto = new PubScentResultDto();
			if(list != null && list.size()>0){
				dto = list.get(0);
			}
			return AjaxResult.success ("操作成功",dto);
		} catch (Exception e) {
			e.printStackTrace ();
		}
		return AjaxResult.error ("操作失败！"); 
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}