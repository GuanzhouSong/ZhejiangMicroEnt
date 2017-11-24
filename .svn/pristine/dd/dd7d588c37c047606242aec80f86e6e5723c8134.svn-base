/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.drcheck.dto.PubDeptSctaskDto;
import com.icinfo.cs.drcheck.dto.PubScinfoDto;
import com.icinfo.cs.drcheck.model.PubScdispose;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.drcheck.model.PubScresultOpinionHis;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.cs.drcheck.service.IPubScdisposeService;
import com.icinfo.cs.drcheck.service.IPubScinfoAgentService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.cs.drcheck.service.IPubScitemResultService;
import com.icinfo.cs.drcheck.service.IPubScitemService;
import com.icinfo.cs.drcheck.service.IPubScresultOpinionHisService;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentService;
import com.icinfo.cs.drcheck.service.IPubSctaskService;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_pub_scinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller
@RequestMapping("/syn/pub/server/drcheck/pubscinfo")
public class PubScinfoController extends CSBaseController {
	//企业大类
	@Autowired
	private ICodeEntcatgService codeEntcatgService;
	//锁定企业
    @Autowired
    private IPubScinfoService pubScinfoService;
    //主任务表
    @Autowired
    private IPubSctaskService pubSctaskService;
    //实施部门任务表
    @Autowired
    private IPubDeptSctaskService pubDeptSctaskService;
    //抽查检查结果
    @Autowired
    private IPubScresultService pubScresultService;
    //抽查检查后续处理信息
    @Autowired
    private IPubScdisposeService pubScdisposeService;
    //部门对应事项
    @Autowired
    private IPubScitemService pubScitemService;
    //检查项结果
    @Autowired
    private IPubScitemResultService pubScitemResultService;
    //部门抽取执法人员
    @Autowired
    private IPubSctaskAgentService pubSctaskAgentService;
    @Autowired
    private ICsEntWarnService csEntWarnService;
    @Autowired
    private ICsSuperviseObjService csSuperviseObjService;
    @Autowired
    private ICsConcernObjService csConcernObjService;
    @Autowired
    private IPubScresultOpinionHisService pPubScresultOpinionHisService;
    @Autowired
    private IPubScinfoAgentService pubScinfoAgentService;
    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;
    
    
    /**
	 * 
	 * 描述: 进入抽查检查企业列表页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(HttpSession session) throws Exception{
		return getSearchModelAndViewForPage("/syn/system/drcheck/pubscinforesultedit_list",session);
	}
	
	/**
	 * 
	 * 描述: 进入抽查检查企业审核列表页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/auditlist",method= RequestMethod.GET)
	public ModelAndView auditlist(HttpSession session) throws Exception{
		return getSearchModelAndViewForPage("/syn/system/drcheck/pubscinforesultaudit_list",session);
	}
	
	/**
	 * 
	 * 描述: 进入抽查检查企业查询列表页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/searchlist",method= RequestMethod.GET)
	public ModelAndView searchlist(HttpSession session) throws Exception{
		return getSearchModelAndViewForPage("/syn/system/drcheck/pubscinforesultsearch_list",session);
	}
	
	/**
	 * 
	 * 描述: 获取跳转页面ModelAndView
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	private ModelAndView getSearchModelAndViewForPage(String url,HttpSession session)throws Exception{
		ModelAndView view = new ModelAndView(url);
		List<CodeEntcatg> listEntcatg=codeEntcatgService.selectAll();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
    	view.addObject("listEntcatg", listEntcatg);//企业类型大类
		return view;
	}
	
	
	/**
     * 描述：获取查抽检查结果录入列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScinfoDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		creatDefaultDBAuthEnv(request, "i.RegOrg", "i.LocalAdm");
		List<PubScinfoDto> data = pubScinfoService.queryPubScinfoDtoPage(request);
		for(PubScinfoDto pubScinfoDto : data){
			String agentName = pubScinfoAgentService.selectPubScinfoAgentDto(pubScinfoDto.getDeptTaskNO(), pubScinfoDto.getTaskNO(), pubScinfoDto.getPriPID());
			pubScinfoDto.setAgentName(agentName);
		}
        return new PageResponse<PubScinfoDto>(data);
    }
	
	/**
	 * 描述：获取查抽检查结果录入列表-有权限
	 * @author chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listauth.json",method= RequestMethod.GET)
	@ResponseBody
	public PageResponse<PubScinfoDto> listAuthJSON(PageRequest request,HttpSession session) throws Exception {
		creatDefaultDBAuthEnv(request, "i.RegOrg", "i.LocalAdm");
		List<PubScinfoDto> data = pubScinfoService.queryPubScinfoDtoPageByAuth(request);
		for(PubScinfoDto pubScinfoDto : data){
			String agentName = pubScinfoAgentService.selectPubScinfoAgentDto(pubScinfoDto.getDeptTaskNO(), pubScinfoDto.getTaskNO(), pubScinfoDto.getPriPID());
			pubScinfoDto.setAgentName(agentName);
		}
		return new PageResponse<PubScinfoDto>(data);
	}
	
	
	  
    /**
	 * 
	 * 描述: 进入抽查检查企业结果录入页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/edit",method= RequestMethod.GET)
	public ModelAndView doEdit(HttpSession session,String taskNO,String priPID) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		return getSearchModelAndViewForShow("/syn/system/drcheck/pubscinforesult_edit", taskNO, priPID,sysUser);
	}
	
	 /**
	 * 
	 * 描述: 进入抽查检查企业结果审核页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/audit",method= RequestMethod.GET)
	public ModelAndView doAudit(HttpSession session,String taskNO,String priPID) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		return getSearchModelAndViewForShow("/syn/system/drcheck/pubscinforesult_audit", taskNO, priPID,sysUser);
	}
	
	 /**
	 * 
	 * 描述: 进入抽查检查企业结果查询详情页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/search",method= RequestMethod.GET)
	public ModelAndView doSearchDetail(HttpSession session,String taskNO,String priPID) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		return getSearchModelAndViewForShow("/syn/system/drcheck/pubscinforesult_search", taskNO, priPID,sysUser);
	}
	
	/**
	 * 
	 * 描述: 获取跳转详情页面ModelAndView
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	private ModelAndView getSearchModelAndViewForShow(String url,String taskNO,String priPID,SysUserDto sysUser)throws Exception{
		ModelAndView view = new ModelAndView(url);
		if(StringUtils.isEmpty(taskNO) || StringUtils.isEmpty(priPID)){
			return view;
		}
		PubScinfoDto pubScinfo = pubScinfoService.selectPubScinfoDtoByTaskNO(taskNO, priPID);//企业信息
		PubSctask pubSctask = pubSctaskService.selectPubSctaskByTaskNO(taskNO);//主体任务
		List<PubDeptSctaskDto> pubDeptSctaskDtoList = pubDeptSctaskService.selectPubDeptSctypesList(taskNO,priPID);//实施部门任务
		pubDeptSctaskDtoList = sortPubDeptSctaskDtoList(pubDeptSctaskDtoList, sysUser);
		PubDeptSctaskDto pubDeptSctaskDto = pubDeptSctaskDtoList.get(0);
		String inspectDept = pubDeptSctaskDto.getInspectDept();//实施部门编码
		String deptTaskNO = pubDeptSctaskDto.getUID();//实施部门UID
		String agentNames = pubScinfoAgentService.selectPubScinfoAgentDto(deptTaskNO,taskNO,priPID);
		PubScresult pubScresult = pubScresultService.selectPubScresultByTaskNO(pubDeptSctaskDto.getUID(), priPID);
		PubScdispose pubScdispose = pubScdisposeService.selectPubScdisposeByTaskNO(pubDeptSctaskDto.getUID(), priPID);
		List<PubScitemResult> pubScitemResultList = pubScitemResultService.selectByTaskNOAndScType(deptTaskNO,taskNO,priPID,inspectDept);
		//历次审核意见
		List<PubScresultOpinionHis> pubScresultOpinionHisList = pPubScresultOpinionHisService.doGetScOpinionHisList(taskNO,deptTaskNO,priPID);
		String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("priPID", priPID);
        qryMap.put("checkState", "1");
        qryMap.put("entWarnState", "1");
        view.addObject("yjNum", csEntWarnService.selectCsEntWarnInfo(qryMap).size());//获取指定审核信息
		qryMap.put("supCheckState", "1");
		qryMap.put("SupState", "1");
		view.addObject("jgNum", csSuperviseObjService.queryListNoPage(qryMap).size());//重点监管信息查询
		qryMap.put("conState", "1");
		view.addObject("gzNum", csConcernObjService.selectCsConObjInfo(qryMap).size());//关注服务申请数据
		
		view.addObject("pubScinfo",pubScinfo);
		view.addObject("pubSctask",pubSctask);
		view.addObject("pubDeptSctaskDtoList",pubDeptSctaskDtoList);
		view.addObject("agentNames",agentNames);
		view.addObject("pubScresult",pubScresult);
		view.addObject("pubScdispose",pubScdispose);
		view.addObject("pubScitemResultList",pubScitemResultList);
		view.addObject("pubDeptSctaskDto",pubDeptSctaskDto);
		view.addObject("currentDate",DateUtil.getCurrentDate());
		view.addObject("pubScresultOpinionHisList", pubScresultOpinionHisList);
		view.addObject("sessionDeptCode", deptCode);
		return view;
	}
	
	/**
	 * 描述：录入抽查检查结果详情页面
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @param priPID
	 * @param inspectDept
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doDetail(String taskNO,String deptTaskNO,String priPID,String inspectDept) throws Exception {
		PubDeptSctaskDto pubDeptSctaskDto = new PubDeptSctaskDto();
		if(StringUtils.isEmpty(deptTaskNO) || StringUtils.isEmpty(priPID) || StringUtils.isEmpty(inspectDept)){
			return AjaxResult.error("查询失败");
		}
//		PubDeptSctask pubDeptSctask = pubDeptSctaskService.selectPubDeptSctaskByUID(deptTaskNO);
		PubScresult pubScresult = pubScresultService.selectPubScresultByTaskNO(deptTaskNO, priPID);
		PubScdispose pubScdispose = pubScdisposeService.selectPubScdisposeByTaskNO(deptTaskNO, priPID);
		String agentNames = pubScinfoAgentService.selectPubScinfoAgentDto(deptTaskNO,taskNO,priPID);
		List<PubScitemResult> pubScitemResultList = pubScitemResultService.selectByTaskNOAndScType(deptTaskNO,taskNO,priPID,inspectDept);
		//历次审核意见
		List<PubScresultOpinionHis> pubScresultOpinionHisList = pPubScresultOpinionHisService.doGetScOpinionHisList(taskNO,deptTaskNO,priPID);
		pubDeptSctaskDto.setPubScresultOpinionHiList(pubScresultOpinionHisList);
		pubDeptSctaskDto.setPubScresult(pubScresult);
		pubDeptSctaskDto.setPubScdispose(pubScdispose);
		pubDeptSctaskDto.setPubScitemResultList(pubScitemResultList);
		pubDeptSctaskDto.setAgentNames(agentNames);
		if(pubScresult != null && pubScresult.getInspectDeptTime() != null){
			pubDeptSctaskDto.setInspectDateDesc(DateUtil.formatDateNew(pubScresult.getInspectDeptTime()));
		}
		return AjaxResult.success("查询成功",pubDeptSctaskDto);
	}
	
	/**
	 * 
	 * @param oldPubDeptSctaskDtoList
	 * @param sysUser
	 * @return
	 */
	private List<PubDeptSctaskDto> sortPubDeptSctaskDtoList(List<PubDeptSctaskDto> oldPubDeptSctaskDtoList,SysUser sysUser)throws Exception{
		List<PubDeptSctaskDto> newPubDeptSctaskDtoList = new ArrayList<PubDeptSctaskDto>();
		if(oldPubDeptSctaskDtoList != null){
			String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
			for(PubDeptSctaskDto old : oldPubDeptSctaskDtoList){
				if(old!= null && StringUtils.isNotEmpty(old.getInspectDept()) && deptCode.equals(old.getInspectDept())){
					newPubDeptSctaskDtoList.add(old);
				}
			}
			for(PubDeptSctaskDto old : oldPubDeptSctaskDtoList){
				if(old!= null && StringUtils.isNotEmpty(old.getInspectDept()) && !deptCode.equals(old.getInspectDept())){
					newPubDeptSctaskDtoList.add(old);
				}
			}
		}
		return newPubDeptSctaskDtoList;
    }
	
	/**
	 * 描述：录入抽查检查结果
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommit(@RequestBody PubScinfoDto pubScinfoDto,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);//-->sysUser
		pubScinfoDto.setSysUserDto(sysUser);
		if(pubScinfoService.commitPubScinfoDto(pubScinfoDto)){
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
	}
	
	/**
	 * 描述：录入抽查检查结果
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAudit(@RequestBody PubScinfoDto pubScinfoDto,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);//-->sysUser
		pubScinfoDto.setSysUserDto(sysUser);
		if(pubScinfoService.auditPubScinfoDto(pubScinfoDto)){
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
	}
	
	
	//===============随机抽检结果列表===================
	/**
     * 描述：获取查抽检查结果录入列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/randomlist.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScinfoDto> randomListJSON(PageRequest request) throws Exception {
		List<PubScinfoDto> data = pubScinfoService.queryRandomPubScinfoList(request);
        return new PageResponse<PubScinfoDto>(data);
    }
	
	  
    /**
	 * 
	 * 描述: 进入随机配对页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/matchresult",method= RequestMethod.GET)
	public ModelAndView doShowMatchResult(String taskNO,String deptTaskNO) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/scinfoAgentResult");
		view.addObject("taskNO", taskNO);
		view.addObject("deptTaskNO", deptTaskNO);
		return view;
	}
	
	/**
	 * 描述：配对结果
	 * @author chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/resultlist.json",method= RequestMethod.GET)
	@ResponseBody
	public PageResponse<PubScinfoDto> resultListJSON(PageRequest request) throws Exception {
		Map<String,Object> params = request.getParams();
		String deptTaskNO = (String)params.get("deptTaskNO");
		if(StringUtils.isNotEmpty(deptTaskNO)){
			List<PubScinfoDto> data = pubScinfoService.queryRandomPubScinfoList(request);
			for(PubScinfoDto pubScinfoDto : data){
				String agentName = pubScinfoAgentService.selectPubScinfoAgentDto(deptTaskNO, pubScinfoDto.getTaskNO(), pubScinfoDto.getPriPID());
				pubScinfoDto.setAgentName(agentName);
			}
			return new PageResponse<PubScinfoDto>(data);
		}
		return new PageResponse<PubScinfoDto>(new ArrayList<PubScinfoDto>());
	}
	
	/**
     * 描述：获取查抽检查结果录入列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/clean",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult cleanRandomResult(String taskNO) throws Exception {
		if(StringUtils.isNotBlank(taskNO)){
			pubScinfoService.cleanPubScinfoByTaskNO(taskNO);
			return AjaxResult.success("清除成功");
		}
		return AjaxResult.error("清除失败");
    }
	
	

	/**
	 * 
	 * 描述:定时更新抽查检查时间
	 * @author yujingwei
	 * @date 2016-10-19
	 * @param void
	 * @throws Exception
	 */
	public void creatPubScinfoByQuartz() throws Exception{
		pubScinfoService.updateEsByPubscTask();
	}
	
	
	/**
	 * 
	 * 描述: 进入抽查检查企业查询列表页面
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/scdetail",method= RequestMethod.GET)
	public ModelAndView scDetaillList(HttpSession session,String taskNO,String screenType) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType = sysUser.getUserType();
		String url = "";
		if("1".equals(userType)){
			url = "/syn/system/drcheck/pubscinforeg";
		}else if("2".equals(userType)){
			url = "/syn/system/drcheck/pubscinfosyn";
		}
		List<PubScinfoDto> pubScinfoDtoList = pubScinfoService.selectRegOrgShortCount(taskNO);
		int allEnt = pubScinfoService.selectCountByTaskNO(taskNO);
		ModelAndView view = new ModelAndView(url);
		view.addObject("pubScinfoDtoList", pubScinfoDtoList);
		view.addObject("allEnt", allEnt);
		return view;
	}
	
}