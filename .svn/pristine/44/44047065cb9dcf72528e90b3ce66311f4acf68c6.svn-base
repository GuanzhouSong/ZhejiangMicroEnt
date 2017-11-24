package com.icinfo.cs.sccheck.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.mapper.PubScentMapper;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubSccheckItemResult;
import com.icinfo.cs.sccheck.model.PubScentResultMaterial;
import com.icinfo.cs.sccheck.service.IPubSccheckItemResultService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.cs.sccheck.service.IPubSccheckWeChatService;
import com.icinfo.cs.sccheck.service.IPubScentResultMaterialService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.controller.CSBaseController;


/**
 * 描述:    cs_pub_dtinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({"/sccheck/wechat"})
public class PubSccheckWeChatController extends CSBaseController{
	
	@Autowired
	private IPubSccheckWeChatService pubSccheckWeChatService; 
	
	@Autowired
	IPubScentResultService pubScentResultService; 
	@Autowired
	IPubEppasswordService pubEppasswordService; 
	@Autowired
	IPubSccheckTypeService pubSccheckTypeService; 
	@Autowired
	IPubSccheckItemResultService pubSccheckItemResultService; 
	@Autowired
	IPubSccheckItemService pubSccheckItemService; 
	@Autowired
	IPubScentResultMaterialService pubScentResultMaterialService; 
	@Autowired
	private PubScentMapper pubScentMapper;
	
    @Value("${scCheckDomain}")
	private String   scCheckDomain;

	
	
	/**
	 * 
	 * 描述   根据联系电话和企业名称和社会信用代码查询抽查检查名单列表
	 * @author 赵祥江
	 * @date 2017年8月9日 上午9:55:11 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getSccheckeEntList.json")
	@ResponseBody
	public JSONObject getSccheckeEntList(String tel ,String keyword ,String secretkey,String pageNo, String pageSize) throws Exception{
		int ipageNo=pageNo==null?1:Integer.parseInt(pageNo);
		int ipageSize=pageSize==null?10:Integer.parseInt(pageSize);
		JSONObject jSONObject=pubSccheckWeChatService.getSccheckeEntList(tel, keyword, secretkey, ipageNo, ipageSize,"0");
		return jSONObject;
	}
	
	/**
	 * 
	 * 描述   查询详情
	 * @author 赵祥江
	 * @date 2017年8月9日 下午5:41:18 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/viewdetail.json")
	@ResponseBody
	public JSONObject viewdetail(String tel ,String pubscentid ,String secretkey) throws Exception{
		JSONObject jSONObject=pubSccheckWeChatService.getSccheckeEntList(tel, pubscentid, secretkey, 1, 10,"1");
		return jSONObject;
	}
	
	/**
	 * 
	 * 描述   查看抽查检查通知书
	 * @author 赵祥江
	 * @date 2017年8月9日 上午10:51:23 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("viewNoticeBook")
	public ModelAndView viewNoticeBook(String resultUid, HttpSession session)
			throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/scresult/scresultwechatnotice_detail");
		PubScentResultDto pubScentResultDto = pubScentResultService.queryPubScentResultDtoByUid(resultUid);
		String priPID=pubScentResultDto==null?"000000":pubScentResultDto.getPriPID();
		// 查询有没有保存的通知书
		PubScentResultMaterial pubScentResultMaterial = pubScentResultMaterialService
				.findPubScentResultMaterialByResultUid(pubScentResultDto.getUid());
		if (pubScentResultMaterial != null) {
			mav.addObject("deptName", pubScentResultMaterial.getDepartMent());
			mav.addObject("contactTel", pubScentResultMaterial.getContactTel()); 
			mav.addObject("contactName", pubScentResultMaterial.getContactName());
			mav.addObject("pubScentResultMaterial", pubScentResultMaterial);
			Date checkDateFrom = pubScentResultMaterial.getCheckDateFrom();
			Date checkDateTo = pubScentResultMaterial.getCheckDateTo();
			Date fillDate = pubScentResultMaterial.getFillDate();
			Calendar c = Calendar.getInstance();
			if (checkDateFrom != null) {
				c.setTime(checkDateFrom);
				mav.addObject("checkDateFromYear", c.get(Calendar.YEAR));
				mav.addObject("checkDateFromMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("checkDateFromDay", c.get(Calendar.DAY_OF_MONTH));
			}
			if (checkDateTo != null) {
				c.setTime(checkDateTo);
				mav.addObject("checkDateToYear", c.get(Calendar.YEAR));
				mav.addObject("checkDateToMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("checkDateToDay", c.get(Calendar.DAY_OF_MONTH));
			}
			if (fillDate != null) {
				c.setTime(fillDate);
				mav.addObject("fillDateYear", c.get(Calendar.YEAR));
				mav.addObject("fillDateMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("fillDateDay", c.get(Calendar.DAY_OF_MONTH));
			}
			String material = pubScentResultMaterial.getMaterial();
			if (!StringUtil.isEmpty(material)) {
				String[] materials = material.split(",");
				List<String> materialList = Arrays.asList(materials);
				mav.addObject("materialList", materialList);
				mav.addObject("num", materialList.size() + 1);
			}
		}

		List<PubSccheckItemResult> pubSccheckItemResultList = pubSccheckItemResultService
				.queryPubSccheckItemResultByTaskUidAndPriPID(pubScentResultDto.getTaskUid(), priPID);
		List<PubSccheckItem> pubSccheckItemList = new ArrayList<PubSccheckItem>();
		if (pubSccheckItemResultList.size() <= 0) {
			pubSccheckItemList = pubSccheckItemService.selectEntRlate(pubScentResultDto.getTaskUid(), priPID);
		} else {
			for (PubSccheckItemResult pubSccheckItemResult : pubSccheckItemResultList) {
				PubSccheckItem pubSccheckItem = new PubSccheckItem();
				pubSccheckItem.setCheckCode(pubSccheckItemResult.getCheckCode());
				pubSccheckItem.setCheckName(pubSccheckItemResult.getCheckName());
				pubSccheckItemList.add(pubSccheckItem);
			}
		}
		mav.addObject("pubScentResultDto", pubScentResultDto);
		mav.addObject("pubSccheckItemList", pubSccheckItemList);
		return mav;
	}
	
	
	/**
	 * 
	 * 描述   绑定微信推送抽查检查消息
	 * @author 赵祥江
	 * @date 2017年8月10日 下午2:23:04 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/sccheckMsgPush.json")
	@ResponseBody
	public JSONObject sccheckMsgPush(String tel ,String secretkey) throws Exception{
		JSONObject jSONObject= pubSccheckWeChatService.sccheckMsgPush(tel, secretkey, "1"); 
		return jSONObject; 
 	}
	
	/**
	 * 
	 * 描述   根据联系电话获取抽查检查企业列表
	 * @author 赵祥江
	 * @date 2017年9月6日 下午2:13:50 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@RequestMapping(value="/getSccheckEntListByTel.json")
	@ResponseBody
	public JSONObject getSccheckEntListByTel(String tel ,String secretkey) throws Exception{ 
		return pubSccheckWeChatService.getSccheckEntListByTel(tel, secretkey); 
 	}
	
	/**
	 * 
	 * 描述   定时推送查看详细信息
	 * @author 赵祥江
	 * @date 2017年8月10日 下午2:25:56 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toMessageSccheckView")
	public ModelAndView toMessageSccheckView(String tel,String sendDate) throws Exception{
		List<PubScentDto> pList=new ArrayList<PubScentDto>(); 
		Map<String,Object> searchMap=new HashMap<String,Object>();
		searchMap.put("tel",tel);
		searchMap.put("isView","0");
		searchMap.put("numStart", 0);
		searchMap.put("pageSize", 9999);
		ModelAndView view  = new ModelAndView("syn/system/sccheck/scresult/sccheckmessage_view"); 
		if(StringUtil.isNotBlank(tel)){
			List<PubScentDto> pubScentDtoList=  pubScentMapper.selectSccheckeMsgEntList(searchMap);
			if(pubScentDtoList.size()>0){ 
				searchMap.clear();
				for(PubScentDto pubScentDto:pubScentDtoList){
					 if(!searchMap.containsKey(pubScentDto.getEntName())){
						 pList.add(pubScentDto);
						 searchMap.put(pubScentDto.getEntName(), pubScentDto);
					 }
				}
			}
		}
		view.addObject("scCheckDomain", scCheckDomain);
		view.addObject("pList", pList); 
		return view;
	}
	
	
	
	/**
	 * 
	 * 描述   根据消息id展示详情
	 * @author 赵祥江
	 * @date 2017年8月24日 下午3:39:04 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toMessageOperatorView")
	public ModelAndView toMessageOperatorSccheckView(String mms_msg_id) throws Exception{
		ModelAndView view  = new ModelAndView("syn/system/sccheck/scresult/sccheckmessage_operator_view");
		List<PubScentDto> pList=pubSccheckWeChatService.getMsgInfoByMsgId(mms_msg_id);
		view.addObject("scCheckDomain", scCheckDomain);
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
	public void sccheckMsgDsPush() throws Exception{
	 //该功能只是2017年08月15日执行，过后不再使用 所以注释掉	
	 //	pubSccheckWeChatService.sccheckMsgPush(null, null, "0"); 
	}
	
}
