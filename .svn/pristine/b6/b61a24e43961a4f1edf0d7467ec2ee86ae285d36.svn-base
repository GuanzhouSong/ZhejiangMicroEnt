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
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_pb_licenceinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping({"/reg/client/yr/pb/pblicence","/reg/server/yr/pb/pblicence"})
public class YrPbLicenceInfoController extends BaseController {
	
	    //个体户年报许可信息表
		@Autowired
		private IYrPbLicenceInfoService yrPbLicenceInfoService;
		
		//个体户基本信息表
		@Autowired
		private IYrPbBaseInfoService yrPbBaseInfoService;
		
		//个体户公示许可信息表
		@Autowired
		private IPbLicenceinfoService pbLicenceinfoService;
		
		/**
		 * 
		 * 描述: 保存（修改）
		 * @auther gaojinling
		 * @date 2016年9月24日 
		 * @param yrPbLicenceInfo
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		@ResponseBody
		public AjaxResult save(@Valid YrPbLicenceInfo yrPbLicenceInfo) throws Exception{
			try {//1.保存个体户许可信息
				if(yrPbLicenceInfo != null && StringUtil.isNotBlank(yrPbLicenceInfo.getLicID())){
					if(yrPbLicenceInfoService.updateYrPbLicenceInfo(yrPbLicenceInfo)>0){
						return AjaxResult.success("1");//保存
					}else{
						return AjaxResult.error("表单修改失败");
					}
				}else{
					if(yrPbLicenceInfoService.saveYrPbLicenceInfo(yrPbLicenceInfo)>0){
						return AjaxResult.success("0");//修改
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
		 * @param outinvIds
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/batchDelete")
	    @ResponseBody
		 public AjaxResult batchDelete(String licenceIds)throws Exception{
			 if(StringUtil.isNotEmpty(licenceIds)){
				 //保存日志
				/* String year="2016";
				 YrForinvestMent yrForinvestMent=new YrForinvestMent();
				 yrForinvestMent.setOUTINVID(outinvIds);
				 yrForinvestMent.setYear(Integer.parseInt(year));
				 saveYrForinvestMentLog(yrForinvestMent, "3");*/
				if(yrPbLicenceInfoService.deleteYrPbLicenceInfoRtn(licenceIds)>0){
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
		 * @param outinvid
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/show")
		@ResponseBody
		public AjaxResult show(String licID) throws Exception {
			//主键licID 
			if (StringUtils.isNotEmpty(licID)) {
				YrPbLicenceInfo yrPbLicenceInfo = yrPbLicenceInfoService.selectOneByLicId(licID);
				return AjaxResult.success("查询成功",yrPbLicenceInfo);	
			}else{//进入新增页面
				 return AjaxResult.error("查询失败");
			} 
			 
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
		public PageResponse<YrPbLicenceInfo> viewlistJSON(PageRequest request) throws Exception {
			Map<String, Object>  map = request.getParams();	
			List<YrPbLicenceInfo> data = new ArrayList<YrPbLicenceInfo>();
			if(map.containsKey("anCheID")){
				//根据年报id获取本年度个体户网站信息
				List<YrPbLicenceInfo> yrPbWebsiteInfos =  yrPbLicenceInfoService.selectPbLicenceListByAnCheID(map.get("anCheID").toString());
				if(yrPbWebsiteInfos != null && yrPbWebsiteInfos.size() >0 ){//本年度有  直接显示本年度
					 data=yrPbLicenceInfoService.queryPageByAnCheID(request);
				}else{ //本年度没有 显示上一年度
					//先查出企业上一年度年报id,通过年报id查询上一年度网站信息
					List<YrPbBaseInfo> yrPbBaseInfos = yrPbBaseInfoService.selectYrPbBaseInfoList(map.get("priPID").toString(),Integer.parseInt(map.get("year").toString())-1);
				    YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfos.get(0);
				    map.put("anCheID", yrPbBaseInfo.getAnCheID());
				    request.setParams(map);
				    data = yrPbLicenceInfoService.queryPageByAnCheID(request);  
				}
			}
			return new PageResponse<YrPbLicenceInfo>(data);
		}
		
		
		/**
		 * 
		 * 描述:返回单个年份个体公示信息分页（预览页用到）
		 * @auther gaojinling
		 * @date 2016年9月12日 
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping({ "/licencelist.json", "licencelist.xml" })
		@ResponseBody
		public PageResponse<YrPbLicenceInfo> listJSON(PageRequest request) throws Exception {
			Map<String, Object>  map = request.getParams();	
			List<YrPbLicenceInfo> data = new ArrayList<YrPbLicenceInfo>();
			if(map.containsKey("anCheID")){
				 data=yrPbLicenceInfoService.queryPageByAnCheID(request);
			}
			return new PageResponse<YrPbLicenceInfo>(data);
		}
		
		
		/**
		 * 
		 * 描述:返回单个年份企业公示信息分页（查看与打印年报时用到）
		 * @auther gaojinling
		 * @date 2016年9月12日 
		 * @param request
		 * @return
		 * @throws Exception
		 */
		@RequestMapping({ "/pblicencelist.json", "pblicencelist.xml" })
		@ResponseBody
		public PageResponse<PbLicenceinfo> pbWebsitelistJSON(PageRequest request) throws Exception {
			Map<String, Object>  map = request.getParams();	
			List<PbLicenceinfo> data = new ArrayList<PbLicenceinfo>();
			if(map.containsKey("anCheID")){
				 data= pbLicenceinfoService.queryPbLicencePage(request);
			}
			return new PageResponse<PbLicenceinfo>(data);
		}
	
	
}