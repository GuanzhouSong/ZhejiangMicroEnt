/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.rpt.rptdto.DeptPubInfoRptDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzIndustryDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzInvcountDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzMapDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzTodayDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzYearCountDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzZtQsDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzZtcountDto;
import com.icinfo.cs.rpt.rptmodel.SmCountAreaDist;
import com.icinfo.cs.rpt.rptservice.IDeptPubInfoRptService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzIndustryService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzInvcountService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzMapService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzTodayService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzYearCountService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtQsService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtcountService;
import com.icinfo.cs.rpt.rptservice.impl.RptQcdzZtcountServiceImpl;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_rpt_qcdz_ztcount 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Controller
@RequestMapping("/qcdz" )
public class RptQcdzZtcountController extends BaseController {
	@Autowired
	private IRptQcdzZtcountService qcdzZtcountService;
	@Autowired
	private IRptQcdzZtQsService rptQcdzZtQsService;
	@Autowired
	private IRptQcdzTodayService rptQcdzTodayService;
	@Autowired
	private IRptQcdzYearCountService rptQcdzYearCountService;
	@Autowired
	private IRptQcdzInvcountService rptQcdzInvcountService;
	@Autowired
	private IDeptPubInfoRptService deptPubInfoRptService;
	@Autowired
	private IRptQcdzIndustryService rptQcdzIndustryService;
	@Autowired
	private IRptQcdzMapService rptQcdzMapService;
	
	
    @RequestMapping(value = "/bigscreen6")
    public ModelAndView toQcdzPage() throws Exception{
    	ModelAndView view = new ModelAndView("/reg/server/charts/qcdz_charts");
    	return view;
    }
    
    @RequestMapping(value = "/bigscreen4")
    public ModelAndView toQcdzPage6() throws Exception{
    	ModelAndView view = new ModelAndView("/reg/server/charts/qcdz_charts4");
    	return view;
    }
	
	

	/**
	 * 
	 * 描述: 大屏可视化 --查询主体数据(图一上)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/rptQcdzZtcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzZtcount(HttpSession session){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            RptQcdzZtcountDto rptQcdzZtcountDto = new RptQcdzZtcountDto();
            List<RptQcdzZtcountDto> dtos = qcdzZtcountService.selectRptQcdzZtcount(map);
            if(dtos!=null && dtos.size()>0){
            	rptQcdzZtcountDto = dtos.get(0);
            }
            return AjaxResult.success ("操作成功",rptQcdzZtcountDto);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
	/**
	 * 
	 * 描述: 大屏可视化 --查询当前年份各月度新设消亡数据(图一下)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/rptQcdzMouthXsxwcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzMouthXsxwcount(HttpSession session){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<RptQcdzZtQsDto> rptQcdzZtQsDtos = rptQcdzZtQsService.selectRptQcdzZtQsList(map);
            List<String> mounths = new ArrayList<String>();
            List<Integer> xsList = new ArrayList<Integer>();
            List<Integer> xwList = new ArrayList<Integer>();
            if(rptQcdzZtQsDtos != null && rptQcdzZtQsDtos.size()>0){
                for(RptQcdzZtQsDto rptQcdzZtQsDto : rptQcdzZtQsDtos){
                	mounths.add(rptQcdzZtQsDto.getMonthcode());
                	xsList.add(rptQcdzZtQsDto.getNewcount());
                	xwList.add(rptQcdzZtQsDto.getCancount());
                }
            }
            JSONObject obj = new JSONObject();
            obj.put("mounths", mounths);
            obj.put("xsList", xsList);
            obj.put("xwList", xwList);
            return AjaxResult.success ("操作成功",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }  
    /**
     * 
     * 描述: 大屏可视化 --查询当天新设消亡数据(图三)
     * @auther gaojinling
     * @date 2017年9月25日 
     * @param session
     * @return
     */
    @RequestMapping(value = "/rptQcdzTodayXsxwcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzTodayXsxwcount(HttpSession session,String type){
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("type", type);
    		List<RptQcdzTodayDto> dtos = rptQcdzTodayService.selectRptQcdzTodayList(map);
    		List<String> names = new ArrayList<String>();
            List<Integer> xsList = new ArrayList<Integer>();
            List<Integer> xwList = new ArrayList<Integer>();
    		if(dtos != null && dtos.size()>0){
        		for(RptQcdzTodayDto rptQcdzTodayDto:dtos){
        			names.add(rptQcdzTodayDto.getName());
        			xsList.add(rptQcdzTodayDto.getNewcount());
        			xwList.add(rptQcdzTodayDto.getCancount());
        		}
    		}
    		JSONObject obj = new JSONObject();
    		obj.put("names", names);
    		obj.put("xsList", xsList);
    		obj.put("xwList", xwList);
    		return AjaxResult.success ("操作成功",obj);
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("操作失败！");
    } 
    
    /**
     * 
     * 描述: 大屏可视化 --查询近6年主体增长情况(图四)
     * @auther gaojinling
     * @date 2017年9月25日 
     * @param session
     * @return
     */
    @RequestMapping(value = "/rptQcdzYearXsxwcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzYearXsxwcount(HttpSession session,int length){
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("length", length);
    		List<RptQcdzYearCountDto> dtos = rptQcdzYearCountService.selectRptQcdzYearCountList(map);
    		
    		List<Integer> years = new ArrayList<Integer>();
            List<Integer> addCountList = new ArrayList<Integer>();
            List<BigDecimal> addRoateList = new ArrayList<BigDecimal>();
    		if(dtos != null && dtos.size()>0){
    			for(int i=dtos.size()-1;i>=0;i--){
    				years.add(dtos.get(i).getYear());
    				addCountList.add(dtos.get(i).getAddcount());
    				addRoateList.add(dtos.get(i).getAddrate());
    			}
    		}
    		JSONObject obj = new JSONObject();
    		obj.put("years", years);
    		obj.put("addCountList", addCountList);
    		obj.put("addRoateList", addRoateList);
    		return AjaxResult.success ("操作成功",obj);
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("操作失败！");
    } 
    
    
    /**
	 * 
	 * 描述: 大屏可视化--图5 投资分布（查询法人股东和自然人股东）
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/rptQcdzInvcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzQcdzInvcount(HttpSession session,String type){
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("type", type);
    		List<RptQcdzInvcountDto> dtos = rptQcdzInvcountService.selectRptQcdzInvcountList(map);
    		JSONObject obj = new JSONObject();
    		if("1".equals(type)){//查询All
    			RptQcdzInvcountDto rptQcdzInvcountDto = new RptQcdzInvcountDto(); 
    			if(dtos != null && dtos.size()>0){
    				rptQcdzInvcountDto  = dtos.get(0);
    				}
        		return AjaxResult.success ("操作成功",rptQcdzInvcountDto);
    		}else{//查询区域
        		List<String> names = new ArrayList<String>();
                List<Integer> entCountList = new ArrayList<Integer>();
                List<Integer> perCountList = new ArrayList<Integer>();
                List<BigDecimal> entRateList = new ArrayList<BigDecimal>();
                List<BigDecimal> perRateList = new ArrayList<BigDecimal>();
        		if(dtos != null && dtos.size()>0){
            		for(RptQcdzInvcountDto rptQcdzInvcountDto :dtos){
            			names.add(rptQcdzInvcountDto.getName());
            			entCountList.add(rptQcdzInvcountDto.getEntcount());
            			perCountList.add(rptQcdzInvcountDto.getPercount());
            			entRateList.add(rptQcdzInvcountDto.getEntrate());
            			perRateList.add(rptQcdzInvcountDto.getPerrate());
            		}
        		}
        		obj.put("names", names);
        		obj.put("entCountList", entCountList);
        		obj.put("perCountList", perCountList);
        		obj.put("entRateList", entRateList);
        		obj.put("perRateList", perRateList);
        		return AjaxResult.success ("操作成功",obj);
    		}
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("操作失败！");
    } 
    /**
     * 
     * 描述:大屏可视化 图6监管动态 
     * @auther gaojinling
     * @date 2017年9月27日 
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/rptPublicInfocount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptPublicInfocount(HttpSession session){
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		List<DeptPubInfoRptDto> dtos = deptPubInfoRptService.selectRptPublicInfoList(map);
    		JSONObject obj = new JSONObject();
    		//来源工商户数
			List<Integer> gsHCountList = new ArrayList<Integer>();
			//来源工商条数
			List<Integer> gsTCountList = new ArrayList<Integer>();
			//来源其他部门户数
			List<Integer> otherHCountList = new ArrayList<Integer>();
			//来源其他部门条数
			List<Integer> otherTCountList = new ArrayList<Integer>();
			if(dtos != null && dtos.size()>0){
				DeptPubInfoRptDto deptPubInfoRptDto = dtos.get(0);
				
				gsHCountList.add(deptPubInfoRptDto.getOpanomlyH());
				gsHCountList.add(deptPubInfoRptDto.getIllDisHoneH());
				gsHCountList.add(deptPubInfoRptDto.getPunishH());
				gsHCountList.add(deptPubInfoRptDto.getSpotcheckH());
				
				gsTCountList.add(deptPubInfoRptDto.getOpanomlyT());
				gsTCountList.add(deptPubInfoRptDto.getIllDisHoneT());				
				gsTCountList.add(deptPubInfoRptDto.getPunishT());
				gsTCountList.add(deptPubInfoRptDto.getSpotcheckT());

				otherHCountList.add(deptPubInfoRptDto.getOtherpanomlyH());
				otherHCountList.add(deptPubInfoRptDto.getOtherillDisHoneH());				
				otherHCountList.add(deptPubInfoRptDto.getOtherpunishH());
				otherHCountList.add(deptPubInfoRptDto.getSpotcheckotherH());

				otherTCountList.add(deptPubInfoRptDto.getOtherpanomlyT());
				otherTCountList.add(deptPubInfoRptDto.getOtherillDisHoneT());				
				otherTCountList.add(deptPubInfoRptDto.getOtherpunishT());
				otherTCountList.add(deptPubInfoRptDto.getSpotcheckotherT());

			}
			obj.put("gsHCountList", gsHCountList);
			obj.put("gsTCountList", gsTCountList);
			obj.put("otherHCountList", otherHCountList);
			obj.put("otherTCountList", otherTCountList);
			return AjaxResult.success ("操作成功",obj);
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("操作失败！");
    }
    
    
	/**
	 * 
	 * 描述: 大屏可视化 --查询法人自然人股东行业占比(图五下饼图)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param session
	 * @return
	 */
    @RequestMapping(value = "/rptQcdzIndustry.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzZtIndustry(HttpSession session,String invtype){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("invtype", invtype);
            List<RptQcdzIndustryDto> dtos =  rptQcdzIndustryService.selectRptQcdzIndustryList(map);
            return AjaxResult.success ("操作成功",dtos);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 大屏可视化 --查询地图数据（图2）
     * @auther gaojinling
     * @date 2017年9月25日 
     * @param session
     * @return
     */
    @RequestMapping(value = "/rptQcdzMap.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult RptQcdzMap(HttpSession session){
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("operateType", "xsNum");
    		List<RptQcdzMapDto> qcdzMapDtos = rptQcdzMapService.selectRptQcdzMapList(map);//新设部分 		
    		JSONArray arr1 = new JSONArray();
    		for(RptQcdzMapDto qcdzMapDto :qcdzMapDtos){
                JSONObject obj = new JSONObject();
                obj.put("name", qcdzMapDto.getContent());
                obj.put("value", qcdzMapDto.getXsNum());
                arr1.add(obj);
    		}
    		
    		JSONArray arr2 = new JSONArray();
    		map.put("operateType", "zxNum");
    		List<RptQcdzMapDto> zxqcdzMapDtos = rptQcdzMapService.selectRptQcdzMapList(map);//注销部分
    		for(RptQcdzMapDto qcdzMapDto :zxqcdzMapDtos){
                JSONObject obj = new JSONObject();
                obj.put("name", qcdzMapDto.getContent());
                obj.put("value", qcdzMapDto.getZxNum());
                arr2.add(obj);
    		}
    		
    		JSONArray arr3 = new JSONArray();
    		map.remove("operateType");
    		map.put("totalType", 1);
    		List<RptQcdzMapDto> totalqcdzMapDtos = rptQcdzMapService.selectRptQcdzMapList(map);//全部标注的点数据
    		List<Long> zxCountList = new ArrayList<Long>();
    		for(RptQcdzMapDto qcdzMapDto :totalqcdzMapDtos){
                JSONObject obj = new JSONObject();
                obj.put("name", qcdzMapDto.getContent());
                obj.put("value", qcdzMapDto.getXsNum());
                zxCountList.add(qcdzMapDto.getZxNum());
                arr3.add(obj);
    		}

    		JSONObject obj = new JSONObject();
    		obj.put("xsData", arr1);
    		obj.put("zxNum", arr2);
    		obj.put("totalData", arr3);
    		obj.put("zxCountList", zxCountList);
    		return AjaxResult.success ("操作成功",obj);
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("操作失败！");
    }
    
    
    
    
    
    
    
    
	
}