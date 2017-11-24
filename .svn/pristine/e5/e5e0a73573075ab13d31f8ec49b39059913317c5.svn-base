package com.icinfo.cs.es.controller.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CsMidLerep;
import com.icinfo.cs.base.service.ICsMidLerepService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.dto.CsMidBlackListDto;
import com.icinfo.cs.es.dto.CsMidPersonDto;
import com.icinfo.cs.es.model.CsAttachmentEstate;
import com.icinfo.cs.es.model.CsMidBlackList;
import com.icinfo.cs.es.model.CsMortEstateInfo;
import com.icinfo.cs.es.model.CsPubIlldisdetail;
import com.icinfo.cs.es.service.ICsAttachmentEstateService;
import com.icinfo.cs.es.service.ICsMidBlackListService;
import com.icinfo.cs.es.service.ICsMidPersonService;
import com.icinfo.cs.es.service.ICsMortEstateInfoService;
import com.icinfo.cs.es.service.ICsPubIlldisdetailService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishInfoService;
import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.cs.other.model.SpPledge;
import com.icinfo.cs.other.service.IMortRegInfoService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.other.service.ISpPledgeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 自然人综合查询控制器
 * 
 * @author zhuyong
 */
@Controller
@RequestMapping("/syn/personsearch")
public class PersonSearchController extends BaseController {
	@Autowired
	private IMidInvService midInvService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IMortRegInfoService mortRegInfoService;
	@Autowired
	private ISpPledgeService spPledgeService;
	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;
	@Autowired
	private ICsMidPersonService csMidPersonService;
	@Autowired
	private ICsMidBlackListService csMidBlackListService;
	@Autowired
	private NoCreditPunishInfoService noCreditPunishInfoService;
	@Autowired
	private ICsPubIlldisdetailService csPubIlldisdetailService;
	@Autowired
	private ICsMortEstateInfoService csMortEstateInfoService;
	@Autowired
	private ICsAttachmentEstateService csAttachmentEstateService;
	@Autowired
	IMidMemberService csMidMemberService;
	@Autowired
	ICsMidLerepService csMidLerepService;
	@Autowired
	IImIppldgService imIppldgService;

	/**
	 * 进入自然人综合查询页面
	 * 
	 * @author chenyu
	 * @return
	 */
	@RequestMapping("doEnPersonSearch")
	public ModelAndView doEnPersonSearch(HttpSession session) {
		SysUserDto sysUserSession = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = "";
		// 协同
		if ("2".equals(sysUserSession.getUserType())) {
			if (sysUserSession.getSysDepart() != null) {
				deptCode = sysUserSession.getSysDepart().getAdcode();
				if (deptCode.length() > 4) {
					deptCode = deptCode.substring(0, 4);
				}
			}
		} else {// 警示
			if (sysUserSession.getDepartMent() != null) {
				deptCode = sysUserSession.getDepartMent().getDeptCode();
				if (deptCode.length() > 4) {
					deptCode = deptCode.substring(0, 4);
				}
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("deptCode", deptCode);//存入当期登录用户所在行政区划
		mav.setViewName("syn/system/search/personsearch/personsearch");
		return mav;
	}

	/**
	 * 获取搜索结果JSON数据列表
	 *
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/personsearchlist.json")
	@ResponseBody
	public List<CsMidPersonDto> listJSON(@NotBlank String keyword, String sex, String dictCode) throws Exception {
		return csMidPersonService.queryList(keyword, sex, dictCode);
	}

	/** 
	 * 描述: 获取自然人分页列表总数
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param keyword
	 * @param sex
	 * @param dictCode
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping("/selectPersonListCount")
	@ResponseBody
	public Long selectPersonListCount(@NotBlank String keyword, String sex, String dictCode) throws Exception {
		return csMidPersonService.selectPersonListCount(keyword, sex, dictCode);
	}


	/** 
	 * 描述: 根据类型、人员身份证获取人员对应的企业列表
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param type
	 * @param cerNo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping("/personentpagelist.json")
	@ResponseBody
	public PageResponse<CsMidPersonDto> selectPersonEntPageList(String type, String cerNo, PageRequest request)
			throws Exception {
		List<CsMidPersonDto> list = csMidPersonService.selectPersonEntPageList(type, cerNo, request);
		return new PageResponse<CsMidPersonDto>(list);
	}

	/**
	 * 进入自然人综合详情页面
	 * 
	 * @author chenyu
	 * @return
	 */
	@RequestMapping("/doEnPersonSearchDetails/{cerNO}")
	public ModelAndView doEnPersonSearchDetails(@PathVariable(value = "cerNO") String cerNO) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/search/personsearch/personsearchdetails");
		mav.addObject("ggNum", 0).addObject("dbrNum", 0).addObject("hmdNum", 0).addObject("invNum", 0);

		if (StringUtils.isBlank(cerNO))
			return mav;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", AESEUtil.decodeCorpid(cerNO));
		List<CsMidPersonDto> data = csMidPersonService.queryList(map);
		if (data.size() > 0)
			mav.addObject("dto", data.get(0));

		map.clear();
		map.put("cerNO", AESEUtil.decodeCorpid(cerNO));

		// 任职高管
		List<MidMember> csMidMemberList = csMidMemberService.selectMidMemberListForSearch(map);
		if (csMidMemberList != null && csMidMemberList.size() > 0
				&& StringUtils.isNotBlank(csMidMemberList.get(0).getPriPID()))
			mav.addObject("ggNum", csMidMemberList.size());

		// 法定代表人
		List<CsMidLerep> csMidLerepList = csMidLerepService.selectMidLerepList(map);
		if (csMidLerepList != null && csMidLerepList.size() > 0
				&& StringUtils.isNotBlank(csMidLerepList.get(0).getPriPID()))
			mav.addObject("dbrNum", csMidLerepList.size());

		// 任职黑名单
		List<CsMidBlackList> csMidBlackList = csMidBlackListService.selectCsMidBlackList(map);
		if (csMidBlackList != null && csMidBlackList.size() > 0
				&& StringUtils.isNotBlank(csMidBlackList.get(0).getPriPID()))
			mav.addObject("hmdNum", csMidBlackList.size());

		// 投资信息
		List<MidInvDto> invDtoList = midInvService.queryPageResultByCerNO(AESEUtil.decodeCorpid(cerNO));
		if (invDtoList != null && invDtoList.size() > 0)
			mav.addObject("invNum", invDtoList.size());

		mav.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mav;
	}

	/**
	 * 获取任职企业信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/doGetMidBaseInfoList")
	@ResponseBody
	public PageResponse<MidBaseInfoDto> doGetMidBaseInfoList(PageRequest request) throws Exception {

		List<MidBaseInfoDto> data = midBaseInfoService.selectMidBaseInfoDtoListByCerNO(request);

		return new PageResponse<MidBaseInfoDto>(data);
	}

	/**
	 * 获取个人投资公司信息
	 *
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetMidInvList")
	@ResponseBody
	public PageResponse<MidInvDto> doGetMidInvList(PageRequest request) throws Exception {
		List<MidInvDto> data = midInvService.queryPageResultByCerNO(request);
		return new PageResponse<MidInvDto>(data);
	}

	/**
	 * 获取个人动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetMortRegInfoList")
	@ResponseBody
	public PageResponse<MortRegInfo> doGetMortRegInfoList(PageRequest request) throws Exception {
		List<MortRegInfo> data = mortRegInfoService.selectMortRegInfoListByCerNO(request);
		return new PageResponse<MortRegInfo>(data);
	}

	/**
	 * 获取个人股权出质信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetSpPledgeList")
	@ResponseBody
	public PageResponse<SpPledge> doGetSpPledgeList(PageRequest request) throws Exception {
		List<SpPledge> data = spPledgeService.selectSpPledgeListByCerNO(request);
		return new PageResponse<SpPledge>(data);
	}

	/**
	 * 获取个人股权冻结信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetPubJusticeInfoList")
	@ResponseBody
	public PageResponse<PubJusticeInfoDto> doGetPubJusticeInfoList(PageRequest request) throws Exception {
		List<PubJusticeInfoDto> data = pubJusticeInfoService.selectSpPledgeListByCerNO(request);
		return new PageResponse<PubJusticeInfoDto>(data);
	}

	/**
	 * 获取吊销黑名单信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetCsMidBlackListList")
	@ResponseBody
	public PageResponse<CsMidBlackListDto> doGetCsMidBlackListList(PageRequest request) throws Exception {
		List<CsMidBlackListDto> data = csMidBlackListService.selectCsMidBlackListByCerNO(request);
		return new PageResponse<CsMidBlackListDto>(data);
	}

	/**
	 * 获取失信惩戒信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetNoCreditPunishInfoList")
	@ResponseBody
	public PageResponse<NoCreditPunishInfo> doGetNoCreditPunishInfoList(PageRequest request) throws Exception {
		List<NoCreditPunishInfo> data = noCreditPunishInfoService.selectInfoListByCerNO(request);
		return new PageResponse<NoCreditPunishInfo>(data);
	}

	/**
	 * 获取严重违法失信信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetCsPubIlldisDetailList")
	@ResponseBody
	public PageResponse<CsPubIlldisdetail> doGetCsPubIlldisDetailList(PageRequest request) throws Exception {
		List<CsPubIlldisdetail> data = csPubIlldisdetailService.selectCsPubIlldisDetailListByCerNO(request);
		return new PageResponse<CsPubIlldisdetail>(data);
	}

	/**
	 * 获取个人不动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetCsMortEstateInfoList")
	@ResponseBody
	public PageResponse<CsMortEstateInfo> doGetCsMortEstateInfoList(PageRequest request) throws Exception {
		List<CsMortEstateInfo> data = csMortEstateInfoService.selectCsMortEstateInfoListByCerNO(request);
		return new PageResponse<CsMortEstateInfo>(data);
	}

	/**
	 * 获取个人不动产查封信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetCsAttachmentEstateList")
	@ResponseBody
	public PageResponse<CsAttachmentEstate> doGetCsAttachmentEstateList(PageRequest request) throws Exception {
		List<CsAttachmentEstate> data = csAttachmentEstateService.selectCsAttachmentEstateListByCerNO(request);
		return new PageResponse<CsAttachmentEstate>(data);
	}


	/** 
	 * 描述: 根据自然人身份证号获取 个人知识产权出质登记列表
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping("/doGetImIppldgListByCerNO")
	@ResponseBody
	public PageResponse<ImIppldg> doGetImIppldgListByCerNO(PageRequest request) throws Exception {
		List<ImIppldg> list = imIppldgService.selectListByCerNO(request);
		return new PageResponse<ImIppldg>(list);
	}

}
