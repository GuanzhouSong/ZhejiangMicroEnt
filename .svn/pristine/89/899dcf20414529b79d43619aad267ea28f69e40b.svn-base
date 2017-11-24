/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.List;
import java.util.Map;

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

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.cs.im.service.IImInvsraltService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 股权变更信息 cs_im_invsralt 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/invsralt/")
public class ImInvsraltController extends BaseController {
	@Autowired
	private IImInvsraltService imInvsraltService;

	/**
	 * 
	 * 描述: 股权变更信息列表
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/invsralt/invsralt_list");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;
	}

	/**
	 * 
	 * 描述: 股权变更信息列表json数据
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public AjaxResult listJSON(PageRequest request, HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID = null;
		List<ImInvsralt> data = null;
		if (midBaseInfoDto != null) {
			priPID = midBaseInfoDto.getPriPID();
			data = imInvsraltService.queryPage(request, priPID);
			for (ImInvsralt imv : data) {
				imv.setInvAltID(AESEUtil.encodeCorpid(imv.getInvAltID()));// 加密
			}
		}

		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: 股权变更信息修改或添加页面
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param session
	 * @param invAltID
	 * @param pubFlag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(HttpSession session, String invAltID, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (StringUtils.isNotEmpty(invAltID)) {
			invAltID = AESEUtil.decodeCorpid(invAltID);// 解密
			ImInvsralt imInvsralt = imInvsraltService.findByInvAltID(invAltID,midBaseInfoDto.getPriPID());

			view.addObject("imInvsralt", imInvsralt);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals("0")) {
					view.setViewName("/reg/client/im/invsralt/invsralt_edit");
				} else {
					if (pubFlag.equals("1")) {
						view.setViewName("/reg/client/im/invsralt/invsralt_change");
					}
				}
			}
		} else {
			view.setViewName("/reg/client/im/invsralt/invsralt_edit");
		}
		
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;

	}

	/**
	 * 
	 * 描述: 保存,或更新许可信息
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param imInvsralt
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImInvsralt imInvsralt, BindingResult result) throws Exception {
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
		if (StringUtils.isNotEmpty(imInvsralt.getInvAltID())) {
			if (imInvsraltService.update(imInvsralt) > 0) {
				return AjaxResult.success("更新成功");
			} else {
				return AjaxResult.error("更新失败");
			}
		} else {
			imInvsralt.setPubFlag("0");
			if (imInvsraltService.insert(imInvsralt) > 0) {
				return AjaxResult.success("新增成功");
			} else {
				return AjaxResult.error("新增失败");
			}
		}
	}

	/**
	 * 
	 * 描述: 删除操作
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param invAltID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public AjaxResult delete(String invAltID, HttpSession session) throws Exception {
		String priPID = null;
		if (StringUtils.isNotEmpty(invAltID)) {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");

			if (midBaseInfoDto != null) {
				priPID=midBaseInfoDto.getPriPID();
				int result = imInvsraltService.delByInvAltId(AESEUtil.decodeCorpid(invAltID),priPID);
				if (result > 0) {
					return AjaxResult.success("删除成功");
				} else {
					return AjaxResult.error("删除失败");
				}
			}else{
				return AjaxResult.error("未登录");
			}
		} else {
			return AjaxResult.error("未选择信息");
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
		imInvsraltService.pubAll(priPID);
		return AjaxResult.success("公示成功");
	}
	/**
	 * 
	 * 描述: 打印
	 * @auther ljx
	 * @date 2016年11月15日 
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/print",method=RequestMethod.GET)
     public ModelAndView print(HttpSession session,PageRequest request)throws Exception{
    		ModelAndView view=new ModelAndView("reg/client/im/invsralt/invsralt_print");
    		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
    		String priPID=null; 
    		List<ImInvsralt> data = null;
    		if (midBaseInfoDto != null) {
    			priPID=midBaseInfoDto.getPriPID();
    			data=imInvsraltService.queryPage(request, priPID);
    		}
    		view.addObject("invsraltList",data);
    		return view;
    	 
     }
	
	

}