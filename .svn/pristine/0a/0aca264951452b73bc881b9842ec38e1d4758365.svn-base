/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.IMessageOpanoMalyService;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_message_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
@Controller
@RequestMapping("/message/opanomalymessage")
public class MessageOpanoMalyController extends CSBaseController {
	@Autowired
    private IPubEppasswordService  pubEppasswordService; 
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService; 
	@Autowired
	private IMessageOpanoMalyService messageOpanoMalyService;
	@Autowired
	private ICreditProveListService creditProveListService;
	
	
	
	/**
	 * 
	 * 描述   查看详情
	 * @author 赵祥江
	 * @date 2017年7月5日 下午6:27:27 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toMessageOpanoMalyView")
	public ModelAndView pubOpanoMalyListPage(String msgReadTel,String isMove,String sendDate) throws Exception{
		List<PubOpanoMaly> pubOpanoMalyList=new ArrayList<PubOpanoMaly>();
		List<PubOpaDetail> pubOpaDetailList=new ArrayList<PubOpaDetail>();
		List<String> pList=new ArrayList<String>();
		PageRequest request=new PageRequest();
		request.setLength(9999);
		Map<String,Object> qMap=new HashMap<String,Object>();
		ModelAndView view  = new ModelAndView("message/message_opanomaly_view");
		if(StringUtil.isNotBlank(msgReadTel)&&StringUtil.isNotBlank(isMove)){
			List<PubEppassword> pubEppasswordList= pubEppasswordService.queryPubEppasswordListByTel(msgReadTel);
			if(pubEppasswordList.size()>0){ 
				for(PubEppassword pubEppassword:pubEppasswordList){
					String pripID=pubEppassword.getPripid(); 
					//列入
					if("3".equals(isMove)){
						//List<PubOpanoMaly> pubOpanoMalytemList= pubOpanoMalyService.selectOpanoMalyByPripId(pripID); 
						qMap.clear();
						qMap.put("pripids", StringUtil.doSplitStringToSqlFormat(pripID,","));
						request.setParams(qMap);
						List<PubOpanoMaly> pubOpanoMalytemList=creditProveListService.selectOpanomalyResultMapByPripids(request);
			    	    if(pubOpanoMalytemList!=null&&pubOpanoMalytemList.size()>0){
			    	    	pubOpanoMalyList.addAll(pubOpanoMalytemList);
			    	    	if(!pList.contains(pripID)){
			    	    		pList.add(pripID);
			    	    	}
			    	    }
					}else if("2".equals(isMove)||"1".equals(isMove)) {//移出、撤销
						List<PubOpaDetail> pubOpaDetailTemList= pubOpaDetailService.selectPubOpaDetailBypriPIDAndIsMove(pripID, isMove);
			    	    if(pubOpaDetailTemList!=null&&pubOpaDetailTemList.size()>0){
			    	    	pubOpaDetailList.addAll(pubOpaDetailTemList);
			    	    	if(!pList.contains(pripID)){
			    	    		pList.add(pripID);
			    	    	}
			    	    }
					}
				}
			}
		}
		view.addObject("pubOpanoMalyList", pubOpanoMalyList);
		view.addObject("pubOpaDetailList", pubOpaDetailList);
		view.addObject("isMove", isMove); 
		view.addObject("pList", pList); 
		return view;
	}
	
	/**
	 * 
	 * 描述   定时推送消息
	 * @author 赵祥江
	 * @date 2017年7月12日 上午11:19:02 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void quartzJob () throws Exception{
		messageOpanoMalyService.quartzJob(); 
	}
	
	/**
	 * 
	 * 描述  企信连联 专项查询 异常 -根据企业名称和信用代码获取异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 上午10:24:42 
	 * @param  
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getOpanoMalyList.json")
	@ResponseBody
	public JSONObject getOpanoMalyList(String keyword ,String secretkey,String pageNo, String pageSize,String searchType) throws Exception{
		JSONObject jSONObject=pubOpanoMalyService.getOpanoMalyList(keyword, secretkey, 0,10,searchType);
		return jSONObject;
	}
	
	/**
	 * 
	 * 描述 企信连联 专项查询 异常 -根据主体身份代码查询异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 上午11:27:20 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getOpanoMalyListByPriPID.json")
	@ResponseBody
	public JSONObject getOpanoMalyListByPriPID(String priPID ,String secretkey) throws Exception{
		JSONObject jSONObject=pubOpanoMalyService.getOpanoMalyListByPriPID(priPID, secretkey);
		return jSONObject;
	}
	
	
	/**
	 * 
	 * 描述   企信连联 专项查询 异常 -查询联络员旗下企业的异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午2:29:05 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getOpanoMalyListByTel.json")
	@ResponseBody
	public JSONObject getOpanoMalyListByTel(String tel ,String keyword,String secretkey) throws Exception{
		JSONObject jSONObject=pubOpanoMalyService.getOpanoMalyListByTel(tel, keyword,secretkey);
		return jSONObject;
	}
	
	
}