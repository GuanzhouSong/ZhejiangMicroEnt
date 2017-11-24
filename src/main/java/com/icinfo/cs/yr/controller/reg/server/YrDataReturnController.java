/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sys_forbidword 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Controller
@RequestMapping("/reg/server/yr/yrdatareturn/")
public class YrDataReturnController extends CSBaseController {
	private static final Logger logger = LoggerFactory.getLogger(YrDataReturnController.class);
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	/**
	 * 描述：进入数据回导列表页面
	 * 
	 * @author ljx
	 * @date 2017年1月5日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/yr/datareturn/datareturn_list");
		return mav;
	}

	/**
	 * 
	 * 描述 查询企业列表 @author ljx @date 2016年12月12日 下午4:21:41 @param @return
	 * PageResponse<PanoramaResultDto> @throws
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "checkDep", "localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * 描述：进入数据回导列表页面
	 * 
	 * @author ljx
	 * @date 2017年1月5日
	 * @return
	 * @param priPID
	 * @throws Exception
	 */
	@RequestMapping("toreturnpage")
	public ModelAndView toReturnPage(PageRequest request, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/yr/datareturn/datareturn_page");
		MidBaseInfo midBaseInfo = new MidBaseInfo();
		if (StringUtils.isNotEmpty(priPID)) {
			midBaseInfo = midBaseInfoService.selectByPripid(AESEUtil.decodeCorpid(priPID));// 查询出企业基本情况根据priPID
			view.addObject("midBaseInfo", midBaseInfo);
		}
		if (midBaseInfo != null) {// 查询企业年报情况
			List<YrRegCheck> checkList = yrRegCheckService.doGetYrRegCheckInit(midBaseInfo.getPriPID());// 先根据priPId查询是否有年报信息
			if (checkList != null && checkList.size() > 0) {// 如果有年报信息
				view.addObject("ifreturn", false);// 不需要回导
				view.addObject("checkList", checkList);
			} else {// 根据企业名称和注册号查询其年报信息
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("regNO", midBaseInfo.getRegNO());
				//map.put("entName", midBaseInfo.getEntName());
				request.setParams(map);
				checkList = yrRegCheckService.selectByRegNoOrName(midBaseInfo.getRegNO(),midBaseInfo.getEntName());
				view.addObject("checkList", checkList);
				if (checkList != null && checkList.size() > 0) {// 如果有年报信息,判断其priPID
					for (YrRegCheck check : checkList) {
						if (check.getPriPID().equals(midBaseInfo.getPriPID())) {// 判断是否可以回导
							view.addObject("ifreturn", false);// 不需回导
						} else {
							view.addObject("oldpriPID",check.getPriPID());
							view.addObject("ifreturn", true);// 需要回导
						}
					}
				}else{
					view.addObject("ifreturn", false);//无年报,不回导
				}
			}
		}

		return view;
	}
	/** 更新priPID根据新的priPID
	 * @author ljx
	 * @param priPID
	 * @param oldPriPID
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dataReturn", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult dateReturn(String priPID,String oldPriPID,HttpSession session)throws Exception{
		if(StringUtils.isNotEmpty(priPID)&&StringUtils.isNotEmpty(oldPriPID)){
			if(yrRegCheckService.updatePriPIdForDataReturn(priPID, oldPriPID)>0){
				return AjaxResult.success("回导成功");
			}else{
				return AjaxResult.error("回导失败");
			}
			
		}else{
			return AjaxResult.error("回导失败");
		} 
		
	}
	 

}