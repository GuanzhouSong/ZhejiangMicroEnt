/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_pb_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping({"/reg/client/yr/pb/pbwebsite","/reg/server/yr/pb/pbwebsite"})
public class YrPbWebsiteInfoController extends BaseController {
	
	//个体户年报信息表
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;
	
	//个体户基本信息表
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	
	//个体户公示年报信息表
	@Autowired
	private IPbWebsiteinfoService pbWebsiteinfoService;
	
	
	/**
	 * 
	 * 描述: 保存（修改）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param yrPbBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid YrPbWebsiteInfo yrPbWebsiteInfo ) throws Exception{
		try {
			if(yrPbWebsiteInfoService.saveYrPbWebsiteInfo(yrPbWebsiteInfo)>0){
				String webid = yrPbWebsiteInfo.getWebID();//主键webid
				return AjaxResult.success("新增成功!",webid);
			}else{
				return AjaxResult.error("表单保存失败");					
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("表单保存失败");
		}
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
    @ResponseBody
	 public AjaxResult delete(String webID)throws Exception{
		if(StringUtils.isNotEmpty(webID) && yrPbWebsiteInfoService.deleteByWebID(webID)>0){
			 return AjaxResult.success("删除成功");
		}
		return  AjaxResult.error("删除失败");
	 }
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteall")
    @ResponseBody
	 public AjaxResult deleteAll(String anCheID)throws Exception{
		if(StringUtils.isNotEmpty(anCheID) && yrPbWebsiteInfoService.deleteByAnCheID(anCheID)>0){
			 return AjaxResult.success("删除成功");
		}
		return  AjaxResult.error("删除失败");
	 }
	
	/**
	 * 
	 * 描述: 单个查询（修改许可证进入单个页面使用）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param webID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show")
	@ResponseBody
	public ModelAndView show(String webID) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/pbwebsite_detial");
		if (StringUtil.isNotEmpty(webID)) {
			YrPbWebsiteInfo yrPbWebsiteInfo = yrPbWebsiteInfoService.selectOneByWebId(webID);
			view.addObject("yrPbWebsiteInfo", yrPbWebsiteInfo);
		}
		return view;
	}
	
	/**
	 * 
	 * 描述: 分页查询个体户网站信息(request中包含年报id,主体代码，年份以及分页参数)(进入年报)
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request(request中包含年报id,主体代码，年份以及分页参数)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<YrPbWebsiteInfo> viewlistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrPbWebsiteInfo> data = new ArrayList<YrPbWebsiteInfo>();
		if(map.containsKey("anCheID")){
			//根据年报id获取本年度个体户网站信息
			List<YrPbWebsiteInfo> yrPbWebsiteInfos =  yrPbWebsiteInfoService.selectPbWebsiteListByanCheID(map.get("anCheID").toString());
			if(yrPbWebsiteInfos != null && yrPbWebsiteInfos.size() >0 ){//本年度有  直接显示本年度
				 data=yrPbWebsiteInfoService.queryPageByAnCheID(request);
			}else{ //本年度没有 显示上一年度
				//先查出企业上一年度年报id,通过年报id查询上一年度网站信息
				List<YrPbBaseInfo> yrPbBaseInfos = yrPbBaseInfoService.selectYrPbBaseInfoList(map.get("priPID").toString(),Integer.parseInt(map.get("year").toString())-1);
			    YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfos.get(0);
			    map.put("anCheID", yrPbBaseInfo.getAnCheID());
			    request.setParams(map);
			    data = yrPbWebsiteInfoService.queryPageByAnCheID(request);  
			}
		}
		return new PageResponse<YrPbWebsiteInfo>(data);
	}
	
	
	/**
	 * 
	 * 描述:返回单个年份个体网站信息分页（预览页用到）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/websitelist.json", "websitelist.xml" })
	@ResponseBody
	public PageResponse<YrPbWebsiteInfo> listJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrPbWebsiteInfo> data = new ArrayList<YrPbWebsiteInfo>();
		if(map.containsKey("anCheID")){
			 data=yrPbWebsiteInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrPbWebsiteInfo>(data);
	}
	
	
	/**
	 * 
	 * 描述:返回单个年份个体公示网站信息分页（查看与打印年报时用到）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/pbwebsitelist.json", "pbwebsitelist.xml" })
	@ResponseBody
	public PageResponse<PbWebsiteinfo> pbWebsitelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<PbWebsiteinfo> data = new ArrayList<PbWebsiteinfo>();
		if(map.containsKey("anCheID")){
			 data= pbWebsiteinfoService.queryPbWebsitePage(request);
		}
		return new PageResponse<PbWebsiteinfo>(data);
	}
	
	
	
	
	
	/**********************************************工商端个体户补录************************************************************/
	
	
	/**
	 * 
	 * 描述: 保存（修改）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param yrPbBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveWeb", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveWeb(@Valid YrPbWebsiteInfo yrPbWebsiteInfo ) throws Exception{
		try {//1.保存个体户许可信息
			if(yrPbWebsiteInfo != null && StringUtil.isNotBlank(yrPbWebsiteInfo.getWebID())){
				if(yrPbWebsiteInfoService.updateYrPbWebsiteInfo(yrPbWebsiteInfo)>0){
					return AjaxResult.success("1");
				}else{
					return AjaxResult.error("表单修改失败");
				}
			}else{
				if(yrPbWebsiteInfoService.saveYrPbWebsiteInfo(yrPbWebsiteInfo)>0){
					return AjaxResult.success("0");
				}else{
					return AjaxResult.error("表单保存失败");					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("表单保存失败");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 描述: 批量删除
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/batchDelete")
    @ResponseBody
	 public AjaxResult batchDelete(String webIds)throws Exception{
		 if(StringUtil.isNotEmpty(webIds)){
			 //保存日志
			/* String year="2016";
			 YrForinvestMent yrForinvestMent=new YrForinvestMent();
			 yrForinvestMent.setOUTINVID(outinvIds);
			 yrForinvestMent.setYear(Integer.parseInt(year));
			 saveYrForinvestMentLog(yrForinvestMent, "3");*/
			if(yrPbWebsiteInfoService.deleteYrPbWebsiteInfoRtn(webIds)>0){
				 return AjaxResult.success("批量删除成功");
			}else{
				 return AjaxResult.error("批量删除失败");
			}
		 }else{
			 return AjaxResult.error("未选择");
		 }
		 
	 }
	
	/**
	 * 
	 * 描述: 单个查询（修改许可证进入单个页面使用）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param webID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showWeb")
	@ResponseBody
	public AjaxResult showWeb(String webID) throws Exception {
		//主键licID 
		if (StringUtils.isNotEmpty(webID)) {
			//如果是修改根据主键查询出对外投资对象  回显
			YrPbWebsiteInfo yrPbWebsiteInfo = yrPbWebsiteInfoService.selectOneByWebId(webID);
			return AjaxResult.success("查询成功",yrPbWebsiteInfo);	
		}else{//进入新增页面
			 return AjaxResult.error("查询失败");
		} 
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}