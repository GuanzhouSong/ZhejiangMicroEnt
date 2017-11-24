/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.FoodstorageBaseDto;
import com.icinfo.cs.yr.dto.FoodstorageCountDto;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_foodstorage_base 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller
@RequestMapping("/reg/server/yr/foodstoragebase")
public class FoodstorageBaseController extends CSBaseController {
	@Autowired
	private ICodeRegorgService codeRegorgService;
	
	@Autowired
	private ICodeRegunitService codeRegunitService;
	
	@Autowired
	private ICodeEntcatgService codeEntcatgService;
	
	@Autowired
	private ICodeSlicenoService codeSlicenoService;
	
	@Autowired
	private IFoodstorageBaseService foodstorageBaseService;
	
	/**
	 * 
	 * 描述: 进入申请修改列表页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView enterListServerpage() throws Exception{
		List<CodeRegunit> codeRegUnitList = codeRegunitService.selectCodeRegunitAll();
		List<CodeRegorg> codeRegorgList = codeRegorgService.selectCodeRegorgList();
		List<CodeEntcatg> codeEntcatgList = codeEntcatgService.selectAll();
		List<CodeSliceno> codeSlicenoList = codeSlicenoService.selectAll();
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstoragebase/foodstoragebase_list");
		view.addObject("codeRegUnitList",codeRegUnitList);
		view.addObject("codeRegorgList",codeRegorgList);
		view.addObject("codeEntcatgList",codeEntcatgList);
		view.addObject("codeSlicenoList",codeSlicenoList);
		view.addObject("yearList",DateUtil.getYearToNow());
		return view;
	}
	
	/**
     * 描述：获取列表Json数据
     * @author chenxin
     * @date 2016-09-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageBaseDto> listJSONServer(PageRequest request) throws Exception {
		List<FoodstorageBaseDto> data = foodstorageBaseService.queryPage(request);
        return new PageResponse<FoodstorageBaseDto>(data);
    }
	
	/**
	 * 描述：进入申请修改审核详细页面
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public ModelAndView showFoodstorageBaseServerPage(@RequestParam(required = false) Integer foodstorageBaseId) throws Exception {
		if(foodstorageBaseId <= 0){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", foodstorageBaseId);
		FoodstorageBase foodstorageBase =  foodstorageBaseService.selecFoodstorageBaseById(map);
        ModelAndView view = new ModelAndView("/reg/server/yr/foodstoragebase/foodstoragebase_edit");
		view.addObject(foodstorageBase);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入食品仓储统计列表页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/count",method= RequestMethod.GET)
	public ModelAndView enterCountServerPage(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstoragebase/foodstoragecount_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		sysUser.setUserVest(sysUser.getUserVest(sysUser));
		view.addObject("startSetdate", DateUtil.getCurrentYear()+"-01-01");
		view.addObject("endSetdate", this.getDateBefore(DateUtil.getSysDate(), 1));
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   食品仓储统计
	 * @author 赵祥江
	 * @date 2017年5月8日 下午7:10:47 
	 * @param 
	 * @return PageResponse<FoodstorageCountDto>
	 * @throws
	 */
	@RequestMapping(value="/foodstorageCount.json")
    @ResponseBody
    public PageResponse<FoodstorageCountDto> foodstorageCountListJSON(PageRequest request) throws Exception {
		request.setLength(99999);
		List<FoodstorageCountDto> data = foodstorageBaseService.queryFoodstorageCountPage(request);
        return new PageResponse<FoodstorageCountDto>(data);
    }
	
	/**
	 * 
	 * 描述   获取几天前的日期
	 * @author 赵祥江
	 * @date 2017年5月31日 下午1:56:40 
	 * @param 
	 * @return String
	 * @throws
	 */
	private  String getDateBefore(Date d, int N) {  
	       Calendar now = Calendar.getInstance();  
	       now.setTime(d);  
	       now.set(Calendar.DATE, now.get(Calendar.DATE) -N); 
	       return    DateUtils.formatDate(now.getTime(), "yyyy-MM-dd");  
    }
	
}