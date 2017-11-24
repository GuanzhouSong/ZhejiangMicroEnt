/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.base.service.ICodeContriFormService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.service.ISysLogService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  对外投资  cs_yr_forinvestment 对应的Controller类.<br>
 * 对外投资
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/forinvestment")
public class YrForinvestMentController extends BaseController {
	@Autowired
	private IYrForinvestMentService yrForinvestMentService; 
	@Autowired
	private ICodeContriFormService codeContriFormService;
	@Autowired
	private IYrBaseInfoService yrBaseInfoService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	private ISysLogService iSysLogService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
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
	public ModelAndView show(String year, HttpSession session) throws Exception {

		ModelAndView view = new ModelAndView("reg/client/yr/forinvest/forinvest_edit");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

		//判断参数是否有值
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

			view.addObject("codeList", codeContriFormService.selectAllCodeContriForm());//获取出资方式
			view.addObject("year", year);
			view.addObject("encodeYear", encodeYear);  //年份进行加密
			view.addObject("priPID", priPID);
			view.addObject("tabName", RepTypeUtil.formForinvestment);//年报对外投资
			view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
			view.addObject("yrForm", yrForm);
		}
		return view;
	}


	/**
	 * 对外投资信息表 数据列表 当前年份的上一年数据
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_last"})
	@ResponseBody
	public PageResponse<YrForinvestMent> list_json_last(PageRequest request) throws Exception {
		List<YrForinvestMent> data = yrForinvestMentService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForinvestMent>(data);
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
	public PageResponse<YrForinvestMent> list_json_tody(PageRequest request,HttpSession session) throws Exception {

		String year = (String)request.getParams().get("year"); //获取当前年份
		String priPID = (String) request.getParams().get("priPID");//主体身份代码

		if(StringUtil.checkYearAndPripid(year,priPID)) {

			if (!(year.equals(session.getAttribute("forinvestment_flag")))) {
				session.removeAttribute("forinvestment_flag");//如果不是同一年份则删除该session值
			}

			//手动全部清除列表   数据的标识
			String delteFalg = (String) session.getAttribute("forinvestment_flag");  //获取手动全部删除的session 年份值
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year)); //获取年报信息
			if (yrRegCheck != null && "0".equals(yrRegCheck.getIsReported())) {       //判断当前对象是否已经进行年报 如果进行年报 则不再往下执行
				YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));
				if (yrForm != null && !"1".equals(yrForm.getForinvestment())) {   //如果是未填报就往下执行
					if (!year.equals(delteFalg)) {        //用于判断当前插入的上一年的数据是否是手动清空 是手动清空就不必再次插入上一年的数据
						List<YrForinvestMent> list = yrForinvestMentService.selectByYearAndPripidList(Integer.valueOf(year), priPID); //获取当前数据
						if (list.size() == 0) {   //如果当前年份的数据为空的时候 往下执行
							YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID); //获取年基本信息 主要是为了获取年报id
							List<YrForinvestMent> _list = yrForinvestMentService.selectByYearAndPripidList(Integer.valueOf(year) - 1, priPID);
							yrForinvestMentService.insertyrForinvestMentlList(_list, yrBaseInfo.getAnCheID());
						}
					}
				}
			}
		}
		List<YrForinvestMent> data = yrForinvestMentService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForinvestMent>(data);
	}


	/**
	 * 保存和更新操作页面
	 * @autor wangjin
	 * @param outinvid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit_show", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult edit_show(String outinvid,String priPID) throws Exception {
		if(StringUtil.isNotEmpty(outinvid)&&StringUtil.isNotEmpty(priPID)){
			return AjaxResult.success("success",yrForinvestMentService.selectByInvIdAndPriPID(outinvid,priPID));
		}
		return AjaxResult.error("fail");
	}


	/**
	 * 保存和更新操作
	 * @autor wangjin
	 * @param yrForinvestMent
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save(YrForinvestMent yrForinvestMent) throws Exception {
		//判断参数是否有值
		if(StringUtil.checkYearAndPripid(yrForinvestMent.getYear(),yrForinvestMent.getPriPID())) {
			if (StringUtil.isNotEmpty(yrForinvestMent.getOutinvid())) {
				if (yrForinvestMentService.update(yrForinvestMent) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
					return AjaxResult.success("更新成功!");
				} else {
					return AjaxResult.error("更新失败!");
				}
			}
			if (yrForinvestMentService.insert(yrForinvestMent) > 0) {
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
	 * @param outinvid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batch_delete(String outinvid,String year,HttpSession session) throws Exception {

		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID = midBaseInfoDto.getPriPID(); //获取主体身份代码

		//判断参数是否有值
		if(StringUtil.isNotEmpty(priPID)) {
			String outinvIDs[] = outinvid.split(",");
			List<String> list_outinvIDs = Arrays.asList(outinvIDs);
			if (StringUtil.isNotEmpty(outinvid)) {
				synchronized (this) {
					if (yrForinvestMentService.batch_delete(list_outinvIDs, priPID) > 0) {
						List<YrForinvestMent> list = yrForinvestMentService.selectByYearAndPripidList(Integer.valueOf(year), priPID);
						if ((list.size() == 0)) { //判断当前年份是否存在数据
							session.setAttribute("forinvestment_flag", year);
						}
						return AjaxResult.success("删除成功!");
					}
				}
			}
		}
		return AjaxResult.error("删除失败!");
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
			BigDecimal rj_Money = yrForinvestMentService.selectInvestSubConAmSumByYearAndPriPid(queryMap);
			rj_Money = rj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

			//实缴 出资合计
			BigDecimal sj_Money = yrForinvestMentService.selectInvestSumByYearAndPriPid(queryMap);
			sj_Money = sj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

			data = rj_Money + "," + sj_Money;
		}
		return AjaxResult.success("",data);
	}


	/**
	 *
	 * 描述 : 对外投资实缴总额
	 * @author: 赵祥江
	 * @date  : 2016年9月8日 下午7:32:47
	 * @param :
	 * @return: AjaxResult
	 * @throws
	 */
	@RequestMapping("/selectInvestSumByYearAndPriPid")
	@ResponseBody
	public AjaxResult selectInvestSumByYearAndPriPid(String  year,HttpSession session) throws Exception{
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		queryMap.put(Constants.CS_YEAR,year );
		return AjaxResult.success("", yrForinvestMentService.selectInvestSumByYearAndPriPid(queryMap)) ;
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
				yrForm.setForinvestment("1");//已填报
				if(yrFormService.updateForm(yrForm)>0){
					return AjaxResult.success("保存完成!");
				}
			}
		}
		return AjaxResult.error("保存失败!");
	}

	/**
	 * 根据统一信用代码或注册号查询企业名称
	 * @author: wangjin
	 * @param regNo
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value = "/regNo_getEntName", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntName(String  regNo) throws Exception{
		String entName="";
		if(StringUtil.isNotBlank(regNo)){
			MidBaseInfo midBaseInfo =  midBaseInfoService.selectMidBaseInfoByRegno(regNo);
			if(midBaseInfo!=null&&StringUtil.isNotEmpty(midBaseInfo.getEntName())){
				entName = midBaseInfo.getEntName();
			}
		}
		return AjaxResult.success("", entName) ;
	}

}