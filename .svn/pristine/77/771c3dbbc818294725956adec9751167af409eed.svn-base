/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidInv;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: 股东及 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/investment/")
public class ImInvestmentController extends BaseController {
	@Autowired
	private IImInvestmentService imInvestmentService;

	/**
	 * 
	 * 描述: 股东列表页
	 * 
	 * @auther ljx
	 * @date 2016年8月29日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/investment/investment_list");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		view.addObject("midBaseInfoDto", midBaseInfoDto);

		return view;
	}

	/**
	 * 描述: 股东列表json数据 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON(HttpSession session,PageRequest request) throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		List<ImInvestment> data = null;
		Map<String,Object> params = new HashMap();
		if (midBaseInfoDto != null) {
			params.put("priPID", midBaseInfoDto.getPriPID());
			params.put("name",request.getParams().get("name").toString());
			request.setParams(params);
			data = imInvestmentService.findInvestmentWithDetailByPriPID(request, false);
			for (ImInvestment ivt : data) {
				ivt.setInvID(AESEUtil.encodeCorpid(ivt.getInvID()));
			}
		}

		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: 股东出资,添加和修改页面
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param session
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(HttpSession session, String id) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/investment/investment_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		ImInvestment imInvestment = new ImInvestment();
		String inviD = null;
		if (midBaseInfoDto != null) {
			inviD = (String) midBaseInfoDto.getPriPID();
			imInvestment.setInvID(inviD);
			imInvestment.setEntName(midBaseInfoDto.getEntName());
			imInvestment.setPriPID(inviD);
			imInvestment.setRegNO(midBaseInfoDto.getRegNO());
			imInvestment.setUniCode(midBaseInfoDto.getUniCode());
		}

		if (StringUtils.isEmpty(id)) {
			String invID = imInvestmentService.insert(imInvestment);
			invID = AESEUtil.encodeCorpid(invID);
			view.addObject("invID", invID);
		} else {
			view.addObject("invID", id);
			id = AESEUtil.decodeCorpid(id);
			view.addObject("inv", imInvestmentService.findByInvId(id,midBaseInfoDto.getPriPID()).getInv());
		}
		return view;

	}

	/**
	 * 
	 * 描述: 保存方法
	 * 
	 * @auther ljx
	 * @date 2016年9月12日
	 * @param imInvestment
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(@Valid ImInvestment imInvestment, BindingResult result,String sensitive) throws Exception {

		boolean flag = false;
		//如果判断条件成立表示  是股东列表选择的 不进行敏感词校验
		if(StringUtils.isNotBlank(sensitive)&&"yes".equals(sensitive)){ flag = true; }

		if(!flag){
			if (result.hasErrors()) {
				// 参数验证错误
				StringBuffer buffer=new StringBuffer();
				for(int i=0;i<result.getFieldErrors().size();i++){
					buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
				}
				AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
				error.addErrorInfo(result.getAllErrors());
				return error;
			}
		}

		imInvestment.setInvID(AESEUtil.decodeCorpid(imInvestment.getInvID()));
		if (imInvestmentService.update(imInvestment) > 0) {
			return AjaxResult.success("保存成功");
		} else {
			return AjaxResult.error("保存失败");
		}

	}

	/**
	 * 
	 * 描述: 删除
	 * 
	 * @auther ljx
	 * @date 2016年9月12日
	 * @param invId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String invId, HttpSession session) throws Exception {
		String priPID = null;
		if (StringUtils.isNotEmpty(invId)) {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			if (midBaseInfoDto != null) {
				priPID = midBaseInfoDto.getPriPID();
				imInvestmentService.delByInvId(AESEUtil.decodeCorpid(invId), priPID);
				return AjaxResult.success("删除成功");

			} else {
				return AjaxResult.error("未登录");
			}
		}else{
			return AjaxResult.error("未选择");
		}
	}

	/**
	 * 
	 * 描述:公示
	 * 
	 * @auther ljx
	 * @date 2016年9月12日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pubAll")
	@ResponseBody
	public AjaxResult pubAll(HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID = null;
		if (midBaseInfoDto != null) {
			priPID = midBaseInfoDto.getPriPID();
		}
		Map<String,String> qryMap=imInvestmentService.pubInv(priPID);
		if(StringUtil.equals(qryMap.get("success").toString(),"true")){
			return AjaxResult.success("公示成功");
		}else{
			return AjaxResult.error("compareFlg",qryMap.get("compareFlg"));
		}
	}
	
	@RequestMapping("/print")
	public ModelAndView print(HttpSession session)throws Exception{
		ModelAndView view=new ModelAndView("reg/client/im/investment/investment_print");
		return view; 
	}

	/**
	 *
	 * 描述: 跳转到股东列表选择页面
	 *
	 * @author ZhuDefeng
	 * @date 2017-02-14
	 * @param priPID 企业内部序号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/inv_select")
	public ModelAndView midInvSelect(String priPID) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/investment/mid_inv_select");
		List<MidInv> midInvList=imInvestmentService.selectInvestmentDtosFromMidInv(priPID);
		view.addObject("midInvList",midInvList);
		return view;
	}
}