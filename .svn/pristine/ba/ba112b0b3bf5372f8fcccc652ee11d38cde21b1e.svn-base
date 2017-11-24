package com.icinfo.cs.sccheck.controller;

import java.net.URLEncoder;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.controller.CSBaseController;


/**
 * 描述:    cs_pub_dtinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({"/tz/sccheck"})
public class PubSccheckAppController extends CSBaseController{
	
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService;
	
	@Autowired
	private IPubScentResultService pubScentResultService;

	
	/**
	 * 描述  ：查询任务列表(台州双随机接口)
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param moduleid，userCode，pageNo，pageSize
	 * @return JSONObject
	 * @throws Exception
	 */
	@RequestMapping(value="/getReportList.json",method= RequestMethod.GET)
	@ResponseBody
	public JSONObject doGetScentCheckTask(String moduleid ,String userCode ,int pageNo, int pageSize) throws Exception{
		JSONObject jsonObject = pubScPlanTaskService.doGetScentCheckTaskListForTz(moduleid, userCode, pageNo, pageSize);
		return jsonObject;
	}
	
	/**
	 * 描述  ：查询任务详情(台州双随机接口)
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param userCode，apprivalid，moduleid
	 * @return JSONObject
	 * @throws Exception
	 */
	@RequestMapping(value="/checkTask.json",method= RequestMethod.GET)
	@ResponseBody
	public JSONObject doGetScentCheckTaskDetails(String userCode, String apprivalid ,String moduleid) throws Exception{
		JSONObject jsonObject = pubScPlanTaskService.doGetScentCheckTaskDetailsForTz(userCode, apprivalid, moduleid);
		return jsonObject;
	}
	
	/**
	 * 描述  ：查询任务个数(台州双随机接口)
	 * @author yujingwei
	 * @date 2017年08月01日 
	 * @param userCode
	 * @return JSONObject
	 * @throws Exception
	 */
	@RequestMapping(value="/getOrderNum.json",method= RequestMethod.GET)
	@ResponseBody
	public JSONObject doGetScentCheckTaskDetails(String userCode) throws Exception{
		JSONObject jsonObject = pubScPlanTaskService.doGetScentCheckTaskTotalForTz(userCode);
		return jsonObject;
	}
	
	/**
	 * 描述：双随机结果数据导入
	 * @author chenxin
	 * @date 2017年06月20日 
	 * @param token，args
	 * @return JSONObject
	 * @throws Exception
	 */
	@RequestMapping(value = "/importResult")
	@ResponseBody
	public JSONObject importResult(String token, String args)throws Exception{
		JSONObject jsonObj = pubScentResultService.saveBathResults(token,args);
		if(jsonObj!=null&&jsonObj.containsKey("msg")){ 
			jsonObj.put("msg", URLEncoder.encode(jsonObj.getString("msg"), "GBK"));
//			jsonObj.put("msg", jsonObj.getString("msg"));
		}
		return jsonObj;
	}
	
}
