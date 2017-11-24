package com.icinfo.cs.favorable.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.model.FavorAbleInfoHis;
import com.icinfo.cs.favorable.service.IFavorAbleInfoHisService;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


@Controller
@RequestMapping({"/reg/server/favorableaudit","/syn/favorableaudit"})
public class FavorAbleInfoAuditController extends CSBaseController{
	
	@Autowired
	private IFavorAbleInfoService favorAbleInfoService;
    
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IPubServerHisModService pubServerHisModService;
	
	@Autowired
	private IFavorAbleInfoHisService favorAbleInfoHisService;
	
	/**
	 * 描述   进入企业良好信息审核页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return ModelAndView
	 */
	@RequestMapping("/list")
	public ModelAndView favorAbleInfoSearchList() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorableaudit_list");
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 描述   进入企业良好信息详情页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return ModelAndView
	 */
	@RequestMapping("/details")
	public ModelAndView detailsView(String uid) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorable_details");
		FavorAbleInfo favorAbleInfo = favorAbleInfoService.selectFavorAbleInfoByUid(uid);
		if(favorAbleInfo != null){
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(favorAbleInfo.getPriPID());
			// 判断是否显示历次审核记录
			List<PubServerHisMod> pubServerHisMods = pubServerHisModService.
					doGetPubServerHisModList(favorAbleInfo.getPriPID(),favorAbleInfo.getUid());
			if(CollectionUtils.isNotEmpty(pubServerHisMods)){
				view.addObject("hisModSize", pubServerHisMods.size());
			}
			view.addObject("baseInfo", baseInfo);
			view.addObject("favorAbleInfo", favorAbleInfo);
		}
		return view;
	}
	
	/**
	 * 描述   进入企业良好信息详情页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return ModelAndView
	 */
	@RequestMapping("/sigInfo")
	public ModelAndView sigInfo(String hisNO) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/details_his");
		FavorAbleInfoHis ableInfoHis = favorAbleInfoHisService.doGetAbleInfoHisInfoBy(hisNO);
		if(ableInfoHis != null){
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(ableInfoHis.getPriPID());
			view.addObject("baseInfo", baseInfo);
			view.addObject("favorAbleInfo", ableInfoHis);
		}
		return view;
	}
	
	/**
	 * 描述：获取行政处罚详情页修改记录列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubServerHisMod>(data)
	 * @throws Exception
	 */
	@RequestMapping("/modlist.json")
	@ResponseBody
	public PageResponse<PubServerHisMod> modlistJSON(PageRequest request) throws Exception {
		List<PubServerHisMod> data = pubServerHisModService.queryPage(request);
		return new PageResponse<PubServerHisMod>(data);
	}
	
	/**
	 * 描述   进入企业良好信息批量审核页面
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @return view
	 */
	@RequestMapping("/viewBacth")
	public ModelAndView viewBacth(String uids) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/favorable/viewBacth");
		view.addObject("uids", uids);
		return view;
	}
	
	/**
	 * 描述：企业良好信息提交
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doCommitFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception{
		try {
			if(favorAbleInfoService.doCommitFavorableInfo(favorAbleInfo)){
				return AjaxResult.success("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}
	
	/**
	 * 描述：企业良好信息提交
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveBatch", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult dosaveBatchFavorableInfo(FavorAbleInfo favorAbleInfo,String uids) throws Exception{
		try {
			if(favorAbleInfoService.doSaveBatchFavorableInfo(favorAbleInfo,uids)){
				return AjaxResult.success("批量审核成功！");
			}
		} catch (Exception e) {
			return AjaxResult.error("批量审核失败！");
		}
		return AjaxResult.error("批量审核失败！");
	}
}
