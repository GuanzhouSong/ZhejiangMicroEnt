package com.icinfo.cs.other.controller.reg.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.service.IPubJusticeInfoHisService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


@Controller("ServerPubJusticeInfoSearch")
@RequestMapping({"/reg/other/pubjusticeinfosearch","/syn/other/pubjusticeinfosearch"})
public class PubJusticeInfoSearchController extends CSBaseController {

	
	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;
	
	@Autowired
	private IPubServerHisModService pubServerHisModService; 
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IPubJusticeInfoHisService pubJusticeInfoHisService;
	
	@Autowired
	private ICodeCertypeService codeCertypeService;
	
	//股权冻结信息类别
	private static final String justiceTypeOne = "1";
    //股东变更信息类别
	private static final String justiceTypeTwo = "2";
	
	/**
	 * 描述: 进入司法协助信息查询列表页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfosearch_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}
	
	/**
     * 描述：获取司法协助信息查询列表数据
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return PageResponse<PubOtherpunish>(data)
     * @throws Exception
     */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<PubJusticeInfoDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"b.CheckDep","b.LocalAdm");
		List<PubJusticeInfoDto> data = pubJusticeInfoService.queryPageForSearch(request);
        return new PageResponse<PubJusticeInfoDto>(data);
    }
	
	/**
	 * 描述: 进入司法协助信息查询列表页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  pripid
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView viewDetails(String pripid,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfosearch_details");
		if(StringUtil.isNotBlank(pripid)){
			List<PubJusticeInfo> pubJusticeInfoListOne = pubJusticeInfoService.doGetPubJusticeInList(pripid,justiceTypeOne);
			List<PubJusticeInfo> pubJusticeInfoListTwo = pubJusticeInfoService.doGetPubJusticeInList(pripid,justiceTypeTwo);
			view.addObject("pubJusticeInfoListOne", pubJusticeInfoListOne);
			view.addObject("pubJusticeInfoListTwo", pubJusticeInfoListTwo);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}
	
	/**
	 * 描述: 进入司法协助股权冻结信息页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  pripid,frozState,justiceConNO,UID
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/frozView")
	public ModelAndView frozView(String pripid,String frozState,String justiceConNO,String UID,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/search_froz_details");
		if(StringUtil.isNotBlank(frozState) && StringUtil.isNotBlank(UID) && StringUtil.isNotBlank(pripid)){
			if(frozState.equals("1")){
				PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid, UID);
				view.addObject("pubJusticeInfo", pubJusticeInfo);
			}else if(StringUtil.isNotBlank(justiceConNO) && (frozState.equals("2") || frozState.equals("3"))){
				//justiceConNo条件存在时即为解冻或失效情况下，同时justiceConNo不为空或空字符串（代表其存在历史冻结记录）
				PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid, UID);
				view.addObject("pubJusticeInfo", pubJusticeInfo);
				PubJusticeInfo pubJusticeInfoCon = pubJusticeInfoService.doGetPubJusticeInfo(pripid, justiceConNO);
				view.addObject("pubJusticeInfoCon", pubJusticeInfoCon);
			}
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}
	
	/**
	 * 描述: 进入司法协助股东强制变更详情页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  UID,pripid
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/changeView")
	public ModelAndView changeView(String pripid , String UID,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/search_change_details");
		if(StringUtil.isNotBlank(UID) && StringUtil.isNotBlank(pripid)){
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid, UID);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}
}
