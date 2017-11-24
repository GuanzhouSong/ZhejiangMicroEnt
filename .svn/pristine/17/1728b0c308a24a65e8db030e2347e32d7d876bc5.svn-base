/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeSet;
import com.icinfo.cs.base.service.ICodeSetService;
import com.icinfo.cs.common.constant.CodeType;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.cs.im.service.IImInvactdetailService;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvupdateService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_im_invactdetail 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
@Controller
@RequestMapping("/reg/client/im/ent/invactdetail/")
public class ImInvactdetailController extends BaseController {
	@Autowired
	private IImInvactdetailService imInvactdetailService;
	@Autowired
	private IImInvestmentService imInvestmentService;
	@Autowired
	private IImInvupdateService imInvupdateService;
	@Autowired
	private ICodeSetService codeSetService;

	/**
	 * 实缴json列表 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param request
	 * @param invId
	 * @return
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON(PageRequest request, String invId) throws Exception {
		if (StringUtils.isNotEmpty(invId)) {
			invId = AESEUtil.decodeCorpid(invId);
		}

		List<ImInvactdetail> data = imInvactdetailService.findByInvId(request, invId);

		for (ImInvactdetail ivac : data) {
			if (StringUtils.isNotEmpty(ivac.getPaidID())) {
				ivac.setPaidID(AESEUtil.encodeCorpid(ivac.getPaidID()));
			}
		}
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 实缴修改或添加页面 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月31日
	 * @param paidID
	 * @param invID
	 * @param pubFlag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(String paidID, String invID, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(paidID)) {
			paidID = AESEUtil.decodeCorpid(paidID);
			ImInvactdetail invactdetail = imInvactdetailService.findByPaidID(paidID);
			view.addObject("invactdetail", invactdetail);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals("2")) {
					view.setViewName("/reg/client/im/invactdetail/invactdetail_edit");
				} else if (pubFlag.equals("1")) {
					view.setViewName("/reg/client/im/invactdetail/invactdetail_change");
				}
			}
		} else {
			view.setViewName("/reg/client/im/invactdetail/invactdetail_edit");
		}
		view.addObject("codeList", codeSetService.findCodeByType(CodeType.CODE_TYPE_CONTRIFORM));
		view.addObject("invID", invID);
		return view;

	}

	/**
	 * 保存，或更新实缴信息 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月31日
	 * @param invactdetail
	 * @param result
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImInvactdetail invactdetail, BindingResult result, HttpSession session)
			throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (result.hasErrors()) {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < result.getFieldErrors().size(); i++) {
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			AjaxResult error = AjaxResult
					.error("输入的内容【" + buffer.substring(0, buffer.length() - 1).toString() + "】为敏感词!");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (StringUtils.isNotEmpty(invactdetail.getPaidID())) {
			if (StringUtils.isNotEmpty(invactdetail.getInvID())) {
				invactdetail.setInvID(AESEUtil.decodeCorpid(invactdetail.getInvID()));
			}
			imInvactdetailService.update(invactdetail);
			return AjaxResult.success("更新成功");
		} else {

			ImInvestment imInvestment = imInvestmentService.findByInvId(AESEUtil.decodeCorpid(invactdetail.getInvID()),
					midBaseInfoDto.getPriPID());
			if (imInvestment != null) {
				invactdetail.setInv(imInvestment.getInv());
				invactdetail.setInvID(imInvestment.getInvID());
			}
			invactdetail.setPubFlag("2");// 暂存
			imInvactdetailService.insert(invactdetail);
			return AjaxResult.success("新增成功");
		}

	}

	/**
	 * 
	 * 描述: 变更实缴方法
	 * 
	 * @auther ljx
	 * @date 2016年9月8日 * @param session
	 * @param invactdetail
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult change(HttpSession session, HttpServletRequest request, @Valid ImInvactdetail invactdetail,
			BindingResult resu) throws Exception {
		if (resu.hasErrors()) {
			// 参数验证错误
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < resu.getFieldErrors().size(); i++) {
				buffer.append(resu.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			AjaxResult error = AjaxResult
					.error("输入的内容【" + buffer.substring(0, buffer.length() - 1).toString() + "】为敏感词!");
			error.addErrorInfo(resu.getAllErrors());

			return error;
		}
		String names = request.getParameter("names");
		String changevalues = request.getParameter("changevalues");
		String originalValues = request.getParameter("originalValues");
		String nameArray[] = names.split(",");
		String changeArray[] = changevalues.split(",");
		String original[] = originalValues.split(",");
		String altDate = request.getParameter("altDate");
		String invID = request.getParameter("invID");
		int result = 0;
		if (StringUtils.isNotEmpty(invID)) {
			invID = AESEUtil.decodeCorpid(invID);
		}

		// 类别
		List<CodeSet> codeList = codeSetService.findCodeByType(CodeType.CODE_TYPE_CONTRIFORM);
		Map<String, String> codeMap = new HashMap<String, String>();
		for (CodeSet code : codeList) {
			codeMap.put(code.getCode(), code.getContent());
		}
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (midBaseInfoDto != null) {
			invactdetail.setInvID(AESEUtil.decodeCorpid(invactdetail.getInvID()));
			if (imInvactdetailService.update(invactdetail) > 0) {
				for (int i = 0; i < nameArray.length; i++) {
					ImInvupdate imInvupdate = new ImInvupdate();
					imInvupdate.setInvID(invID);
					imInvupdate.setPriPID(midBaseInfoDto.getPriPID());
					imInvupdate.setEntName(midBaseInfoDto.getEntName());
					imInvupdate.setRegNO(midBaseInfoDto.getRegNO());
					imInvupdate.setUniCode(midBaseInfoDto.getUniCode());
					imInvupdate.setAltDate(DateUtil.stringToDate(altDate, "yyyy-MM-dd"));
					imInvupdate.setCreateTime(new Date());
					imInvupdate.setAltItemContent(nameArray[i]);
					imInvupdate.setAltBeContent(original[i]);
					if (nameArray[i].equals("出资方式")) {
						imInvupdate.setAltAfContent(codeMap.get(changeArray[i]));
					} else {
						imInvupdate.setAltAfContent(changeArray[i]);
					}

					result = imInvupdateService.insert(imInvupdate);
				}
			}
		}
		if (result > 0) {
			return AjaxResult.success("变更成功");
		} else {
			return AjaxResult.error("变更失败");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delByPaidId(String paidID) throws Exception {
		if (StringUtils.isNotEmpty(paidID)) {
			imInvactdetailService.delByPaidId(AESEUtil.decodeCorpid(paidID));
			return AjaxResult.success("删除成功");

		} else {
			return AjaxResult.error("未选择");
		}

	}

}