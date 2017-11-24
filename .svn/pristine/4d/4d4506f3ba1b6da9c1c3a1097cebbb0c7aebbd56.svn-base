/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.cs.yr.service.IYrSfcBranchInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_sfc_branchinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/sfcbranch")
public class YrSfcBranchInfoController extends BaseController {
	
	@Autowired
	private IYrSfcBranchInfoService yrSfcBranchInfoService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	/**
	 * 
	 * 描述:返回单个年份个体公示信息分页（预览页用到）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/branchlist.json", "branchlist.xml" })
	@ResponseBody
	public PageResponse<YrSfcBranchInfo> listJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcBranchInfo> data = new ArrayList<YrSfcBranchInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcBranchInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcBranchInfo>(data);
	}
	
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
	public AjaxResult save(@Valid YrSfcBranchInfo yrSfcBranchInfo) throws Exception{
		try {//1.保存许可信息
			if(yrSfcBranchInfo != null && StringUtil.isNotBlank(yrSfcBranchInfo.getBrID())){
				if(yrSfcBranchInfoService.updateYrSfcBranchInfo(yrSfcBranchInfo)>0){
					return AjaxResult.success("1");
				}else{
					return AjaxResult.error("表单修改失败");
				}
			}else{
				if(yrSfcBranchInfoService.saveYrSfcBranchInfo(yrSfcBranchInfo)>0){
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
	 * @param outinvIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/batchDelete")
    @ResponseBody
	 public AjaxResult batchDelete(String brIDs)throws Exception{
		 if(StringUtil.isNotEmpty(brIDs)){
			 //保存日志
			/* String year="2016";
			 YrForinvestMent yrForinvestMent=new YrForinvestMent();
			 yrForinvestMent.setOUTINVID(outinvIds);
			 yrForinvestMent.setYear(Integer.parseInt(year));
			 saveYrForinvestMentLog(yrForinvestMent, "3");*/
			if(yrSfcBranchInfoService.deleteYrSfcBranchInfoRtn(brIDs)>0){
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
	public AjaxResult show(String brID) throws Exception {
		//主键licID 
		if (StringUtils.isNotEmpty(brID)) {
			//如果是修改根据主键查询出对外投资对象  回显
			YrSfcBranchInfo yrSfcBranchInfo = yrSfcBranchInfoService.selectOneByBrID(brID);
			return AjaxResult.success("查询成功",yrSfcBranchInfo);	
		}else{//进入新增页面
			 return AjaxResult.error("查询失败");
		} 
		 
	}
	
	
	/**
	 * 
	 * 描述: 查询所输注册号是否属于浙江省（即为是否在mid表）
	 * @auther gaojinling
	 * @date 2017年2月9日 
	 * @param brID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search")
	@ResponseBody
	public AjaxResult search(String branUniCode) throws Exception {
		//主键licID 
		if (StringUtils.isNotEmpty(branUniCode)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regNO", branUniCode);
			map.put("regState", "1");
			List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
		    MidBaseInfoDto midBaseInfoDto;
			return AjaxResult.success("查询成功",midBaseInfoDtoList);	

		}else{//进入新增页面
			 return AjaxResult.error("查询失败");
		} 
		 
	}
}