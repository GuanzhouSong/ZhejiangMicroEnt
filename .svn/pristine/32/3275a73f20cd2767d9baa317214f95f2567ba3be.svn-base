package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.service.IYrForinvestMentService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 描述: 对外投资~server端<br>
 * @author wangjin
 * @date 2016年10月16日
 */
@Controller
@RequestMapping("/reg/server/yr/forinvestment_server")
public class YrForinvestMentServerController extends BaseController {
	@Autowired
	private IYrForinvestMentService yrForinvestMentService; 
	@Autowired
	private IYrFormService yrFormService;


	/**
	 * 对外投资情况详情
	 * @autor: wangjin
	 * @param year pripid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") // /reg/server/yr/forinvestment_server/view
	public ModelAndView show(String year,String priPID,String entType) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/search/entreportsearch/yrreport/forinvest_view");
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			view.addObject("year", year);
			view.addObject("priPID", priPID);
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
	 * 对外投资信息表 数据列表  当前年份
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrForinvestMent> list_json_tody(PageRequest request) throws Exception {
		List<YrForinvestMent> data = yrForinvestMentService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForinvestMent>(data);
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
	public AjaxResult countMoney(String year, String priPID) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		queryMap.put(Constants.CS_YEAR,year );

		//认缴 出资合计
		BigDecimal rj_Money = yrForinvestMentService.selectInvestSubConAmSumByYearAndPriPid(queryMap);
		rj_Money = rj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

		//实缴 出资合计
		BigDecimal sj_Money = yrForinvestMentService.selectInvestSumByYearAndPriPid(queryMap);
		sj_Money = sj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

		Object data = rj_Money+","+sj_Money;
		return AjaxResult.success("",data);
	}



}
