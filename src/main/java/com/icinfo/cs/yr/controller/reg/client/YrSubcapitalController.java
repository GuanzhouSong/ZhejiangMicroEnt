/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.RepTypeUtil;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeContriFormService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.cs.common.utils.StringUtil;
import javax.servlet.http.HttpSession;

/**
 * 描述:    cs_yr_subcapital 对应的Controller类.<br>
 *  年报 出资情况报表 
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/subcapital")
public class YrSubcapitalController extends BaseController {
	@Autowired
	private IYrSubcapitalService yrSubcapitalService; 
	@Autowired
	private ICodeContriFormService codeContriFormService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
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

		ModelAndView view = new ModelAndView("reg/client/yr/subcapital/subcapital_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID();// 获取主体身份代码

		//判断参数是否有值
		if (StringUtil.checkYearAndPripid(year, priPID)) {

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

			view.addObject("codeList", codeContriFormService.selectAllCodeContriForm());//获取出资方式
			view.addObject("year", year);
			view.addObject("encodeYear", encodeYear);  //年份进行加密
			view.addObject("priPID", priPID);
			view.addObject("tabName", RepTypeUtil.formSubcapital);//年报出资情况
			view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
			view.addObject("yrForm", yrForm);
		}
		return view;
	}


	/**
	 * 出资情况信息表 数据列表 当前年份的上一年数据
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
     */
	@RequestMapping({"/list_json_last"})
	@ResponseBody
	public PageResponse<YrSubcapital> list_json_last(PageRequest request) throws Exception {
		List<YrSubcapital> data = yrSubcapitalService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrSubcapital>(data);
	}

	/**
	 * 出资情况信息表 数据列表  当前年份
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrSubcapital> list_json_tody(PageRequest request,HttpSession session) throws Exception {

		String year = (String)request.getParams().get("year"); //获取当前年份
		String priPID = (String) request.getParams().get("priPID");//主体身份代码

		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			if (!(year.equals(session.getAttribute("subcapital_flag")))) {
				session.removeAttribute("subcapital_flag");//如果不是同一年份则删除该session值
			}
			//手动全部清除列表   数据的标识
			String delteFalg = (String) session.getAttribute("subcapital_flag");  //获取手动全部删除的session 年份值

			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year)); //获取年报信息
			if (yrRegCheck != null && "0".equals(yrRegCheck.getIsReported())) {       //判断当前对象是否已经进行年报 如果进行年报 则不再往下执行
				YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));
				if (yrForm != null && !"1".equals(yrForm.getSubcapital())) {   //如果是未填报就往下执行
					if (!year.equals(delteFalg)) {        //用于判断当前插入的上一年的数据是否是手动清空 是手动清空就不必再次插入上一年的数据
						List<YrSubcapital> list = yrSubcapitalService.selectByYearAndPripidList(Integer.valueOf(year), priPID); //获取当前数据
						if (list.size() == 0) {   //如果当前年份的数据为空的时候 往下执行
							YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID); //获取年基本信息 主要是为了获取年报id
							List<YrSubcapital> _list = yrSubcapitalService.selectByYearAndPripidList(Integer.valueOf(year) - 1, priPID);
							yrSubcapitalService.insertYrSubcapitalList(_list, yrBaseInfo.getAnCheID());
						}
					}
				}
			}
		}

		List<YrSubcapital> data = yrSubcapitalService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrSubcapital>(data);
	}

	/**
	 *认缴 出资 和 实缴 出资额 (合计)
	 * @author: wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countMoney", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult countMoney(String year,String priPID) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		queryMap.put(Constants.CS_YEAR,year );
		Object data = null;
		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			//认缴 出资合计
			BigDecimal rj_Money = yrSubcapitalService.rj_sumMoney(queryMap);
			rj_Money = rj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

			//实缴 出资合计
			BigDecimal sj_Money = yrSubcapitalService.sj_sumMoney(queryMap);
			sj_Money = sj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);
			data = rj_Money+","+sj_Money;
		}
		return AjaxResult.success("",data);
	}



	/**
	 * 年报提交前再次判断  企业注册资本和认缴出资总额是否相等
	 * @author: wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkMoney", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult checkMoney(String year,String priPID, HttpSession session) throws Exception {
		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			String entTypeLTD = RepTypeUtil.entTypeLTD;
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
			String entType = midBaseInfoDto.getEntType();//市场主体类型(CA16)
			if (entTypeLTD.indexOf(entType) != -1) { //如果 当前 市场主体类型 在内外资公司法人（股份有限公司）内 则不用进行金额的校验
				return AjaxResult.success("当前 市场主体类型 在内外资公司法人（股份有限公司）内 则不用进行金额的校验");
			}
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put(Constants.CS_PRIPID, priPID);
			queryMap.put(Constants.CS_YEAR, year);
			BigDecimal sumMoney = yrSubcapitalService.rj_sumMoney(queryMap);
			sumMoney = sumMoney.setScale(4, BigDecimal.ROUND_HALF_UP);
			BigDecimal regCap = midBaseInfoDto.getRegCap();   // 注册资本
			if (regCap == null) {
				regCap = new BigDecimal(0);
			} else {
				regCap = regCap.setScale(4, BigDecimal.ROUND_HALF_UP);
			}
			if (sumMoney.compareTo(regCap) == 0) {
				return AjaxResult.success("相等");
			}
			return AjaxResult.error("你企业的认缴出资总额与企业注册资本额不符");
		}
		return AjaxResult.error("","error"); //参数没有接收到会出现的问题！
	}




	/**
	 * 保存和更新操作页面
	 * @autor wangjin
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit_show", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult edit_show(String invID,String priPID) throws Exception {
		if(StringUtil.isNotEmpty(invID)&&StringUtil.isNotEmpty(priPID)){
			return AjaxResult.success("success",yrSubcapitalService.selectByInvIdAndPriPID(invID,priPID));
		}
		return AjaxResult.error("fail");
	}



	/**
	 * 保存和更新操作
	 * @autor wangjin
	 * @param yrSubcapital
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save(YrSubcapital yrSubcapital) throws Exception {
		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(yrSubcapital.getYear(),yrSubcapital.getPriPID())) {
			yrSubcapital.setInv(StringUtil.doHtm(yrSubcapital.getInv())); //设置转义字符
			if (StringUtils.isNotEmpty(yrSubcapital.getInvID())) {
				if (yrSubcapitalService.update(yrSubcapital) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
					return AjaxResult.success("更新成功!");
				} else {
					return AjaxResult.error("更新失败!");
				}
			}
			if (yrSubcapitalService.insert(yrSubcapital) > 0) {
				return AjaxResult.success("新增成功!");
			} else {
				return AjaxResult.error("新增失败!");
			}
		}
		return AjaxResult.error("参数为空,执行失败!");
	}

	/**
	 * 删除 操作
	 * @autor wangjin
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batch_delete(String invID,String year,HttpSession session) throws Exception {

		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID(); //获取主体身份代码
		//判断参数是否有值
		if(StringUtil.isNotEmpty(priPID)) {
			String invIDs[] = invID.split(",");
			List<String> list_invID = Arrays.asList(invIDs);
			if (StringUtil.isNotEmpty(invID)) {
				synchronized (this) {
					if (yrSubcapitalService.batch_delete(list_invID, priPID) > 0) {
						List<YrSubcapital> list = yrSubcapitalService.selectByYearAndPripidList(Integer.valueOf(year), priPID);
						if ((list.size() == 0)) { //判断当前年份是否存在数据
							session.setAttribute("subcapital_flag", year);
						}
						return AjaxResult.success("删除成功!");
					}
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
				yrForm.setSubcapital("1");//已填报
				if(yrFormService.updateForm(yrForm)>0){
					return AjaxResult.success("保存完成!");
				}
			}
		}
		return AjaxResult.error("保存失败!");
	}


}