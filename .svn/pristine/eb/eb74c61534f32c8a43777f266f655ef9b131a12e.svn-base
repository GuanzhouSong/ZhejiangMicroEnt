/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:    cs_yr_alterstockinfo 对应的Controller类.<br>
 *    股权转让 控制层
 * @author framework generator
 * @date 2016年08月29日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/alterstock")
public class YrAlterStockInfoController extends BaseController {
	@Autowired
	private IYrAlterStockInfoService yrAlterStockInfoService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	private ISignatureService signatureService;


	/**
	 * 页面显示
	 * @autor: wangjin
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String year,HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/client/yr/stock/stock_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

		if(StringUtil.checkYearAndPripid(year,priPID)) {
			String encodeYear = year;          //接收加密年份
			year = AESEUtil.decodeYear(year);  //年份解密

			//获取年报anCheID
			YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
			if (yrBaseInfo != null) {
				if (StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())) {
					view.addObject("anCheID", yrBaseInfo.getAnCheID());
				}
			}
			//查询年报主表信息
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
			//获取表单填写的状态
			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

			//获取电子公章图片字符串路径
			Signature signature = signatureService.selectByYearAndPripid(year,priPID);
			if(signature!=null&&StringUtils.isNotBlank(signature.getTextCode())){
				view.addObject("qzImgBase64", signature.getTextCode());
			}

			view.addObject("year", year);
			view.addObject("encodeYear", encodeYear);  //年份进行加密
			view.addObject("priPID", priPID);
			view.addObject("tabName", RepTypeUtil.formAlterstockinfo);//股权变更
			view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
			view.addObject("yrForm", yrForm);
		}
		return view;
	}



	/**
	 * 股份变更信息表 数据列表 当前年份的数据
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrAlterStockInfo> list_json_last(PageRequest request) throws Exception {
		List<YrAlterStockInfo> data = yrAlterStockInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrAlterStockInfo>(data);
	}


	/**
	 * 保存和更新操作
	 * @autor wangjin
	 * @param yrAlterStockInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save(YrAlterStockInfo yrAlterStockInfo) throws Exception {

		if(StringUtil.checkYearAndPripid(yrAlterStockInfo.getYear(),yrAlterStockInfo.getPriPID())) {
				yrAlterStockInfo.setInv(StringUtil.doHtm(yrAlterStockInfo.getInv())); //设置转义字符
			if (StringUtil.isNotEmpty(yrAlterStockInfo.getInvAltID())) {
				if (yrAlterStockInfoService.update(yrAlterStockInfo) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
					return AjaxResult.success("更新成功!");
				} else {
					return AjaxResult.error("更新失败!");
				}
			}

			if (yrAlterStockInfoService.insert(yrAlterStockInfo) > 0) {
				return AjaxResult.success("新增成功!");
			} else {
				return AjaxResult.error("新增失败!");
			}
		}
		return AjaxResult.error("参数为空,执行失败!");
	}


	/**
	 * 保存和更新操作页面
	 * @autor wangjin
	 * @param invAltID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit_show", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult edit_show(String invAltID,String priPID) throws Exception {
		if(StringUtil.isNotEmpty(invAltID)&&StringUtil.isNotEmpty(priPID)){
			return AjaxResult.success("success",yrAlterStockInfoService.selectByInvIdAndPriPID(invAltID,priPID));
		}
		return AjaxResult.error("fail");
	}

	/**
	 * 删除 操作
	 * @autor wangjin
	 * @param invAltID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batch_delete(String invAltID, HttpSession session) throws Exception {

		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID(); //获取主体身份代码
		if(StringUtil.isNotEmpty(priPID)){
			String invIDs[] = invAltID.split(",");
			List<String> list_invAltID = Arrays.asList(invIDs);
			if (StringUtil.isNotEmpty(invAltID)) {
				if (yrAlterStockInfoService.batch_delete(list_invAltID, priPID) > 0) {
					return AjaxResult.success("删除成功!");
				}
			}
		}
		return AjaxResult.error("删除失败!");
	}


	/**
	 * 根据年份和身份主体代码更新表单状态
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult updateForm(String year,String priPID) throws Exception {
		if(StringUtil.checkYearAndPripid(year,priPID)){
			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID,Integer.valueOf(year));
			if(yrForm!=null){
				yrForm.setAlterstockinfo("1");//已填报
				if(yrFormService.updateForm(yrForm)>0){
					return AjaxResult.success("保存完成!");
				}
			}
		}
		return AjaxResult.error("保存失败!");
	}

}