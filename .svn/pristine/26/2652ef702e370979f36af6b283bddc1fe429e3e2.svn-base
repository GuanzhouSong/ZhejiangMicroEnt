/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_server_hismod 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Controller("ServerPubOtherPunishSearch")
@RequestMapping({"/pub/server/pubotherpunishsearch","/syn/server/pubotherpunishsearch"})
public class OtherpunishSearchController extends CSBaseController {
	
	@Autowired
	private IPubOtherpunishService pubOtherpunishService;
	
	@Autowired
	private IPubOtherPunishAlterService pubOtherPunishAlterService;
	
	@Autowired
	private IImCasaltService imCasaltService;
	
	/**
	 * 描述: 进入行政处罚信息查询列表页
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishsearch_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
     * 描述：获取行政处罚信息查询列表数据
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return PageResponse<PubOtherpunish>(data)
     * @throws Exception
     */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<PubOtherpunishDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"b.CheckDep","b.LocalAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<PubOtherpunishDto> data = pubOtherpunishService.queryPageForPunishSearch(request);
        return new PageResponse<PubOtherpunishDto>(data);
    }
	
	/**
	 * 描述：获取行政处罚信息查询计数个数
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubOtherpunish>(data)
	 * @throws Exception
	 */
	@RequestMapping(value="/total.json",method= RequestMethod.POST)
	@ResponseBody
	public List<PubOtherpunishDto> totalListJSON(@RequestBody Map<String, Object> pramsMap) throws Exception {
		creatDefaultDBAuthEnv(pramsMap,"b.CheckDep","b.LocalAdm");
		List<PubOtherpunishDto> totalList = pubOtherpunishService.queryTotalForPunishSearch(pramsMap);
		return totalList;
	}
	
	/**
	 * 描述: 进入行政处罚信息查询列表页
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView doView(String pripid,String caseNO,String punSource,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishsearch_details");
		if(StringUtil.isNotEmpty(pripid) 
				&& StringUtil.isNotEmpty(caseNO)){
			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("priPID", pripid);
			qryMap.put("caseNO", caseNO);
			qryMap.put("punSource", punSource);
			PubOtherpunishDto pubOtherpunish = pubOtherpunishService.selectOtherPunishDetails(qryMap);
			/*1.来源其它部门变更记录*/
			if("1".equals(punSource)){
				List<PubOtherPunishAlter> pubOtherPunishAlterList = pubOtherPunishAlterService.doGetAlterInfoList(pripid,caseNO);
				view.addObject("pubOtherPunishAlterList", pubOtherPunishAlterList);
			}
			/*2.来源企业变更记录*/
			if("3".equals(punSource)){
				List<ImCasalt> imCasaltList = imCasaltService.queryPageByCaseNO(null, caseNO);
				view.addObject("imCasaltList", imCasaltList);
			}
			view.addObject("pubOtherpunish", pubOtherpunish);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}
	
	/**
	 * 描述: 进入企业全景查询（行政处罚查询）页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/search_list")
	public ModelAndView searchList(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("syn/system/search/punishsearch/punishsearch");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
     * 描述：企业全景查询（行政处罚查询）
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return PageResponse<PubOtherpunish>(data)
     * @throws Exception
     */
	@RequestMapping("/search_list.json")
	@ResponseBody
    public PageResponse<PubOtherpunishDto> queryPunishListJson(PageRequest request) throws Exception {
		List<PubOtherpunishDto> data = pubOtherpunishService.queryPageForPunishSearch(request);
        return new PageResponse<PubOtherpunishDto>(data);
    }
}