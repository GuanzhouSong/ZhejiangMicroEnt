package com.icinfo.cs.im.controller.pub.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.cs.im.model.ImPrmtalt;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.cs.im.service.IImInvactdetailService;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvprodetailService;
import com.icinfo.cs.im.service.IImInvsraltService;
import com.icinfo.cs.im.service.IImInvupdateService;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.cs.im.service.IImIppldgaltService;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.im.service.IImPrmtaltService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 
 * 描述: 公示即时信息 对应的Controller类<br>
 * 
 * @author ljx
 * @date 2016年9月24日
 */
@Controller
@RequestMapping("/im/pub/investalter/")
public class IminvestalterController {
	@Autowired
	private IImInvestmentService imInvestmentService;
	@Autowired
	private IImInvsraltService imInvsraltService;

	@Autowired
	private IImIppldgService imIppldgService;
	@Autowired
	private IImPermitService imPermitService;
	@Autowired
	private IImCaseService imCaseService;
	@Autowired
	private IImPrmtaltService imPrmtaltService;
	@Autowired
	private IImInvactdetailService imInvactdetailService;
	@Autowired
	private IImInvprodetailService imInvprodetailService;
	@Autowired
	private IImInvupdateService invupdateService;
	@Autowired
	private IImIppldgaltService ippldgaltService;
	@Autowired
	private IImCasaltService casaltService;

	@RequestMapping("/list")
	public ModelAndView list(String priPID) throws Exception {
		ModelAndView view = new ModelAndView("/pub/infopublic/infodetail/iminvestalter");
		 view.addObject("priPID",priPID); 
		return view;
	}

	/**
	 * 
	 * 描述: 股东出资信息
	 * 
	 * @auther ljx
	 * @date 2016年9月26日
	 * @param request
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/investmentListJSON")
	@ResponseBody
	public PageResponse<ImInvestment> investmentListJSON(PageRequest request, String priPID) throws Exception {
		List<ImInvestment> list = new ArrayList<ImInvestment>();
		if (StringUtils.isNotEmpty(priPID)) {
		    	//priPID=AESEUtil.decodeCorpid(priPID);
		    	  request.getParams().put(Constants.CS_PRIPID, priPID);
		    	  request.getParams().put("pubFlag","1");
			 list = imInvestmentService.findInvestmentWithDetatilForPub(request);
		}
		return new PageResponse<ImInvestment>(list);

	}

	/**
	 * 
	 * 描述: 查看股东出资详情
	 * 
	 * @auther ljx
	 * @date 2016年9月26日
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showInvestment")
	public ModelAndView showInvestment(String invID,String priPID) throws Exception {
		ModelAndView view = new ModelAndView();
		ImInvestment invsetment = null;
		List<ImInvactdetail> actList = new ArrayList<ImInvactdetail>();
		List<ImInvprodetail> proList = new ArrayList<ImInvprodetail>();
		if (StringUtils.isNotEmpty(invID)) {
			invsetment = imInvestmentService.findByInvId(invID,priPID);
			actList = imInvactdetailService.findByInvIdNoPageForPub(invID);
			proList = imInvprodetailService.findByInvIdNoPageForPub(invID);
		}

		view.setViewName("/pub/infopublic/infodetail/investmentdetail");
		view.addObject("invsetment", invsetment);
		view.addObject("actList", actList);
		view.addObject("proList", proList);
		return view;

	}
   @RequestMapping("/showImvestupdate")
   public ModelAndView showImvestupdate(String priPID) throws Exception{
	   ModelAndView view=new ModelAndView("/pub/infopublic/infodetail/imvestmodify");
	   List<ImInvupdate> list=new ArrayList<ImInvupdate>();
	   if(StringUtils.isNotEmpty(priPID)){
	   list=invupdateService.queryListForPub(priPID);
	   }
	   view.addObject("list",list);
	   return view;
   } 
	
	/**
	 * 
	 * 描述: 股权变更信息
	 * 
	 * @auther ljx
	 * @date 2016年9月24日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("invsraListJSON")
	@ResponseBody
	public PageResponse<ImInvsralt> invsraListJSON(PageRequest request) throws Exception {
        List<ImInvsralt> list=imInvsraltService.queryPage(request);
		return new PageResponse<ImInvsralt>(list);
	}

	/**
	 * 
	 * 描述: 知识产权登记
	 * 
	 * @auther ljx
	 * @date 2016年9月24日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ippldgListJSON")
	@ResponseBody
	public PageResponse<ImIppldg> ippldgListJSON(PageRequest request, String priPID) throws Exception {
		List<ImIppldg> list=new ArrayList<ImIppldg>();
		if(StringUtils.isNotEmpty(priPID)){
			//priPID=AESEUtil.decodeCorpid(priPID);
        list = imIppldgService.queryPageForPUb(request, priPID);
		}
		return new PageResponse<ImIppldg>(list);
	}

	/**
	 * 
	 * 描述:查询行政许可
	 * 
	 * @auther ljx
	 * @date 2016年9月24日
	 * @param request
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("permitListJSON")
	@ResponseBody
	public PageResponse<ImPermit> permitListJSON(PageRequest request, String priPID) throws Exception {
		List<ImPermit> list=new ArrayList<ImPermit>();
		if(StringUtils.isNotEmpty(priPID)){
			//priPID=AESEUtil.decodeCorpid(priPID);
	    list = imPermitService.queryPageForPub(request, priPID);
		 }
		
		return new PageResponse<ImPermit>(list);
	}

	/**
	 * 
	 * 描述: 查询行政处罚
	 * 
	 * @auther ljx
	 * @date 2016年9月24日
	 * @param request
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("caseListJSON")
	@ResponseBody
	public PageResponse<ImCaseDto> caseListJSON(PageRequest request, String priPID) throws Exception {
		List<ImCaseDto> list= imCaseService.queryToPub(request, priPID); 
		for(ImCaseDto dto:list){
			 List<ImCasalt> lis=casaltService.queryForPub(dto.getCaseNO());
			dto.setCaslatList(lis);
			
		} 
		return  new PageResponse<ImCaseDto>(list);

	}

	/**
	 * 行政处罚详情 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年9月26日
	 * @param caseNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("showCase")
	public ModelAndView showCase(String caseNO,String priPID) throws Exception {
		ModelAndView view = new ModelAndView();
		ImCase imCase = null;
		if (StringUtils.isNotEmpty(caseNO)) {
			imCase = imCaseService.findByCaseNO(caseNO,priPID);
		}

		view.setViewName("/pub/infopublic/infodetail/justicedetail");
		view.addObject("imCase", imCase);
		return view;
	}

	/**
	 * 行政许可详情 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年9月26日
	 * @param licID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("showPermit")
	public ModelAndView showPermit(String licID,String priPID) throws Exception {
		ModelAndView view = new ModelAndView();
		ImPermit imPermit= imPermitService.selectByLicId(licID,priPID);
		if(imPermit.getPubType()!=null){
		
		if(imPermit.getPubType().equals("1")){ 
			List<ImPrmtalt> list = new ArrayList<ImPrmtalt>();
			if (StringUtils.isNotEmpty(licID)) {
				list = imPrmtaltService.selectBylicID(licID);
			} 
			view.addObject("list", list);
			view.setViewName("/pub/infopublic/infodetail/permitmodify"); 
		}
		if(imPermit.getPubType().equals("2")){
			view.addObject("title","行政许可注销信息");
			view.addObject("topTitle","注销日期");
			view.addObject("downTitle","注销原因");
			view.addObject("topContent",imPermit.getCanDate());
			view.addObject("downContent",imPermit.getEquPleCanRea());
			view.setViewName("/pub/infopublic/infodetail/showpermit");
		 }
		if(imPermit.getPubType().equals("3")){
			view.addObject("title","行政许可吊销信息");
			view.addObject("topTitle","吊销日期");
			view.addObject("downTitle","吊销原因");
			view.addObject("topContent",imPermit.getRevDate());
			view.addObject("downContent",imPermit.getSugRevReason());
			view.setViewName("/pub/infopublic/infodetail/showpermit");
		 }
		if(imPermit.getPubType().equals("4")){
			view.addObject("title","行政许可其他无效信息");
			view.addObject("topTitle","无效日期");
			view.addObject("downTitle","无效原因");
			view.addObject("topContent",imPermit.getInvAlidDate());
			view.addObject("downContent",imPermit.getInvAliDRea());
			view.setViewName("/pub/infopublic/infodetail/showpermit");
		} 
		}else{
			view.addObject("title","行政许可信息");
			view.addObject("topTitle","无"); 
			view.setViewName("/pub/infopublic/infodetail/showpermit");
		}
		
		return view;

	}
	/**
	 * 
	 * 描述: 知识产权登记信息
	 * @auther ljx
	 * @date 2016年11月1日 
	 * @param pleID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showIppldg")
	public ModelAndView showIppldg(String pleID,String priPID)throws Exception{
		ModelAndView view=new ModelAndView();  
		ImIppldg ippldg= imIppldgService.findByPleId(pleID,priPID);
		if(ippldg.getPubType()!=null){  
		if(ippldg.getPubType().equals("1")){ 
			  view.addObject("list", ippldgaltService.queryListForPub(pleID));
			  view.setViewName("/pub/infopublic/infodetail/permitIppldg"); 
		  }
		
		if(ippldg.getPubType().equals("2")){
			view.addObject("title","知识产权出质注销信息");
			view.addObject("topTitle","注销日期");
			view.addObject("downTitle","注销原因");
			view.addObject("topContent",ippldg.getCanDate());
			view.addObject("downContent",ippldg.getEquPleCanRea());
			view.setViewName("/pub/infopublic/infodetail/showippldg"); 
		} 
		if(ippldg.getPubType().equals("3")){
			view.addObject("title","知识产权出质其他无效信息");
			view.addObject("topTitle","无效日期");
			view.addObject("downTitle","无效原因");
			view.addObject("topContent",ippldg.getInvAlidDate());
			view.addObject("downContent",ippldg.getInvAliDRea());
			view.setViewName("/pub/infopublic/infodetail/showippldg");
			
		}  
		}else{
			view.addObject("title","知识产权出质登记信息");
			view.addObject("topTitle","无");
			 
			view.setViewName("/pub/infopublic/infodetail/showippldg");
			
			
		}
		  return view;
		
		
	}
	
	
	
	

}
