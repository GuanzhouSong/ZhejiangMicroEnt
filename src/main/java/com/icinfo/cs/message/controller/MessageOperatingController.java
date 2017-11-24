/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;

/**
 * 描述:    cs_message_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
@Controller
@RequestMapping("/message/operatingmessage")
public class MessageOperatingController extends CSBaseController {
	private static final Logger logger = LoggerFactory.getLogger(MessageOperatingController.class);
	@Autowired
    private IMidBaseInfoService  midBaseInfoService; 
	@Autowired
	private ICodeRegStateService codeRegStateService;
	
	 
	
	/**
	 * 
	 * 描述  企信连联 专项查询 经营期限 -根据企业名称和信用代码获取企业信息
	 * @author 赵祥江
	 * @date 2017年10月9日 上午10:24:42 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getOperatingList.json")
	@ResponseBody
	public JSONObject getOperatingList(String keyword ,String secretkey,String pageNo, String pageSize) throws Exception{
		JSONObject jSONObject=midBaseInfoService.getOperatingList(keyword, secretkey, 0,10);
		return jSONObject;
	} 
	
	
	/**
	 * 
	 * 描述   企信连联 专项查询 经营期限 -查询联络员旗下企业信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午2:29:05 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getOperatingListByTel.json")
	@ResponseBody
	public JSONObject getOperatingListByTel(String tel ,String keyword,String secretkey,String searchFlag) throws Exception{
		JSONObject jSONObject=midBaseInfoService.getOperatingListByTel(tel, keyword,secretkey,searchFlag);
		return jSONObject;
	}
	
	/**
	 * 
	 * 描述   根据主体身份代码查询企业信息
	 * @author 赵祥江
	 * @date 2017年10月11日 上午10:02:21 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getEntInfoByPriPID.json")
	@ResponseBody
	public JSONObject getEntInfoByPriPID(String priPID ,String secretkey) throws Exception{
		JSONObject jsonObject = new JSONObject();
		List<Object> expiresList = new ArrayList<Object>();
		String key="asdfghjkl"; 
		try {
			//校验口令
			if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			if(StringUtil.isBlank(priPID)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "主体身份代码不能为空");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			List<MidBaseInfoDto> midBaseInfoDtoList= midBaseInfoService.doGetListByPriPID(priPID);
			if(midBaseInfoDtoList!=null&&midBaseInfoDtoList.size()>0){
				MidBaseInfoDto midBaseInfoDto=midBaseInfoDtoList.get(0);
				CodeRegState codeRegState=codeRegStateService.selectCsStateDesc(StringUtil.isBlank(midBaseInfoDto.getRegState())?"000":midBaseInfoDto.getRegState());
				Map<String, Object> expiresListMap = new HashMap<String, Object>();
				//经营期限 
				expiresListMap.put("opToDate",midBaseInfoDto.getOpTo()==null?"9999-09-09":DateUtil.formatDate(midBaseInfoDto.getOpTo(), "yyyy-MM-dd"));
				// 企业名称
				expiresListMap.put("entName", midBaseInfoDto.getEntName()==null?"":midBaseInfoDto.getEntName());
				// 统一社会信用代码
				expiresListMap.put("uniCode",  StringUtil.isBlank(midBaseInfoDto.getUniCode())?midBaseInfoDto.getRegNO():midBaseInfoDto.getUniCode()); 
				//企业状态
				expiresListMap.put("regStateCn",codeRegState==null||StringUtil.isBlank(codeRegState.getCsStateDesc())?"":codeRegState.getCsStateDesc()); 
				expiresList.add(expiresListMap); 
			} 
			jsonObject.put("resultList", JSONArray.fromObject(expiresList));
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功"); 
		} catch (Exception e) {
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"),e);
		} 
		return jsonObject;
	}
	
	
}