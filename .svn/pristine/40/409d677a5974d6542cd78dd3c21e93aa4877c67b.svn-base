/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.yr.dto.YrOtherInfoDto;
import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:    cs_yr_otherinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/yrotherinfo")
public class YrOtherInfoController extends BaseController {
	@Autowired
	private IYrOtherInfoService yrOtherInfoService;
	@Autowired
	IYrAssetService yrAssetService;
	@Autowired
	private IYrWebsiteInfoService yrWebsiteInfoService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	private IYrBaseInfoService yrBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	ICodeCertypeService codeCertypeService; //证件类型
	@Autowired
	private ISignatureService signatureService;

	/**
	 * 编辑对话框
	 * @autor：wangjin
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String year, HttpSession session) throws Exception {

		ModelAndView view = new ModelAndView("/reg/client/yr/other/other_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(year,priPID)) {

			String encodeYear = year;          //接收加密年份
			year = AESEUtil.decodeYear(year);  //年份解密
			if (StringUtils.isNotEmpty(year) && StringUtils.isNotEmpty(priPID)) {
				view.addObject("yrOtherInfo", yrOtherInfoService.selectByYearAndPripid(Integer.parseInt(year), priPID));
				view.addObject("lastYrOtherInfo", yrOtherInfoService.selectByYearAndPripid(Integer.parseInt(year) - 1, priPID));//前一年数据
			}

			//获取年报anCheID
			YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
			if (yrBaseInfo != null) {
				if (StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())) {
					view.addObject("anCheID", yrBaseInfo.getAnCheID());
				}
			}
			// 获取当前企业网站信息列表
			List<YrWebsiteInfo> yrWebsiteInfoList = yrWebsiteInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
			if (yrWebsiteInfoList.size() > 0) {
				view.addObject("yrWebsiteInfoList", yrWebsiteInfoList);
			}

			//查询年报主表信息
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));

			//查询资产状况中企业从业人数
			YrAsset yrAsset = yrAssetService.selectByYearAndPripid(Integer.valueOf(year), priPID);
			if (yrAsset != null) {
				view.addObject("empNum", yrAsset.getEmpNum()); //获取从业人数
			}
			//获取表单填写的状态
			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

			//获取电子公章图片字符串路径
			Signature signature = signatureService.selectByYearAndPripid(year,priPID);
			if(signature!=null&& com.icinfo.framework.tools.utils.StringUtils.isNotBlank(signature.getTextCode())){
				view.addObject("qzImgBase64", signature.getTextCode());
			}

			view.addObject("year", year);
			view.addObject("encodeYear", encodeYear);  //年份进行加密
			view.addObject("priPID", priPID);
			view.addObject("tabName", RepTypeUtil.formOtherinfo);//年报其他情况
			view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
			view.addObject("yrForm", yrForm);
		}
		return view;
	}

	/**
	 * 保存和更新操作
	 * @autor:wangjin
	 * @param yrOtherInfoDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save( YrOtherInfoDto yrOtherInfoDto) throws Exception {

		if(StringUtil.checkYearAndPripid(yrOtherInfoDto.getYear(),yrOtherInfoDto.getPriPID())) {

			YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(yrOtherInfoDto.getPriPID(), yrOtherInfoDto.getYear());
			String sign = yrOtherInfoDto.getSign();   //获取当前是【暂存状态】还是保持状态 【保存】

			if (StringUtils.isNotEmpty(yrOtherInfoDto.getOtherID())) {
				if (yrOtherInfoService.update(yrOtherInfoDto) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
					if ((StringUtils.equalsIgnoreCase("temporary", sign))) {
						return AjaxResult.success("暂存成功");
					} else {
						if (yrForm != null) {
							if (!"1".equals(yrForm.getOtherinfo())) {
								yrForm.setOtherinfo("1");//表单状态已填报
								yrFormService.updateForm(yrForm);
							}
						}
						return AjaxResult.success("保存成功");
					}
				} else {
					return AjaxResult.error("保存失败!");
				}
			}
			if (yrOtherInfoService.insert(yrOtherInfoDto) > 0) {
				if (!(StringUtils.equalsIgnoreCase("temporary", sign))) {  //如果是【暂存】情况的时候不进行保存表单状态
					if (yrForm != null) {
						yrForm.setOtherinfo("1");//表单状态已填报
						yrFormService.updateForm(yrForm);
					}
					return AjaxResult.success("保存完成!");
				}
				return AjaxResult.success("保存成功!", yrOtherInfoDto.getOtherID());
			} else {
				return AjaxResult.error("保存失败!");
			}
		}
		return AjaxResult.error("参数为空,执行失败!");
	}


	/**
	 * 验证校验  其中党员人数不能超过企业从业人数
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(String year,HttpSession session ) throws Exception {

		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID();// 获取主体身份代码

		if (StringUtil.checkYearAndPripid(year, priPID)) {

			//查询资产状况中企业从业人数
			int empNum = 0;
			YrAsset yrAsset = yrAssetService.selectByYearAndPripid(Integer.valueOf(year), priPID);
			if (yrAsset != null) {
				empNum = yrAsset.getEmpNum(); //获取从业人数
			}
			//查询其他情况表中 党员人数
			int numParM = 0;
			YrOtherInfo yrOtherInfo = yrOtherInfoService.selectByYearAndPripid(Integer.valueOf(year), priPID);
			if (yrOtherInfo != null) {
				if (yrOtherInfo.getNumParM() == null) {
					return AjaxResult.success("success"); //如果党员人数为空则返回真
				} else {
					numParM = yrOtherInfo.getNumParM();//获取党员人数
				}
			} else {
				return AjaxResult.success("success");
			}
			//如果党员人数大于 企业从业人数
			if (numParM > empNum) {
				return AjaxResult.error("党员人数" + numParM + "人不能大于企业从业人数" + empNum + "人" + ",请回到【其他情况】表单中进行修改!");
			}
			return AjaxResult.success("success");
		}
		return AjaxResult.error("参数为空值,提交失败!");
	}
}
