package com.icinfo.cs.dtinfo.controller.reg;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.dtinfo.service.IPubDtInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * 描述:    cs_special_rec_task 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Controller
@RequestMapping({"/reg/server/dtinfocharts"})
public class PubDtinfoEchartsController extends CSBaseController{
	
	@Autowired
	private IPubDtInfoService pubDtInfoService;
   
	/**
	 * 描述:获取推送，认领，部门个数等基础数据(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDtcommonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getDtcommonJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
			PubDtInfoDto dtInfoDto = pubDtInfoService.doGetDtCommonDataForCharts(request);
			return AjaxResult.success("", dtInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取数据失败！", e.getMessage());
		}
	}
	
	/**
	 * 描述:获取部门推送情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDeptClaimData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getDeptClaimData(PageRequest request,HttpSession session) throws Exception {
		try {
			PubDtInfoDto dtInfoDto = pubDtInfoService.doGetDeptClaimDataForCharts(request);
			return AjaxResult.success("", dtInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取数据失败！", e.getMessage());
		}
	}
	
	/**
	 * 描述:获取部门推送top10情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/getClaimInfoForDutyData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getClaimInfoForDutyData(PageRequest request,HttpSession session) throws Exception {
		try {
			List<PubDtInfoDto> dtInfoDtos = pubDtInfoService.doGetClaimInfoForDutyData(request);
			return AjaxResult.success("", dtInfoDtos);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取数据失败！", e.getMessage());
		}
	}
	
	/**
	 * 描述:获取部门认领情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDutyClaimOptData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getDutyClaimOptData(PageRequest request,HttpSession session) throws Exception {
		try {
			PubDtInfoDto dtInfoDto = pubDtInfoService.doGetDutyClaimOptForCharts(request);
			return AjaxResult.success("", dtInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取数据失败！", e.getMessage());
		}
	}
	
	/**
	 * 描述:获取各地市部门认领情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAreaClaimData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getAreaClaimData(PageRequest request,HttpSession session) throws Exception {
		try {
			List<PubDtInfoDto> dtInfoDtos = pubDtInfoService.doGetAreaClaimDataForCharts(request);
			return AjaxResult.success("", dtInfoDtos);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("获取数据失败！", e.getMessage());
		}
	}
}
