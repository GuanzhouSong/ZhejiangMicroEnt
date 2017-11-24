package com.icinfo.cs.rpt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.rpt.rptdto.SmRptAddcountDto;
import com.icinfo.cs.rpt.rptmodel.SmCountAreaDist;
import com.icinfo.cs.rpt.rptmodel.SmCountMonthRoute;
import com.icinfo.cs.rpt.rptservice.ISmCountAreaDistService;
import com.icinfo.cs.rpt.rptservice.ISmCountMonthRouteService;
import com.icinfo.cs.rpt.rptservice.ISmRptAddcountService;
import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 图表统计
 * 
 * @author zhuyong
 */
@Controller
@RequestMapping("/sment/server/chartscount" )
public class SmentChartsCountController {

	@Autowired
	private ISmCountAreaDistService smCountAreaDistService;
	@Autowired
	private ISmCountMonthRouteService smCountMonthRouteService;
	@Autowired
	private ISmRptAddcountService smRptAddcountService;

	@RequestMapping("/mapList.json")
	@ResponseBody
	public AjaxResult mapList() throws Exception{
		JSONArray arr = smCountAreaDistService.selectAll();
		return AjaxResult.success("dataList", arr);
	}
	
	@RequestMapping("/zcList.json")
	@ResponseBody
	public AjaxResult zcList() throws Exception{
		JSONObject obj = smCountMonthRouteService.selectAllByZC();
		return AjaxResult.success("dataList", obj);
	}
	
	
	@RequestMapping("/xsList.json")
	@ResponseBody
	public AjaxResult xsList() throws Exception{
		JSONObject xsList = smCountMonthRouteService.selectAllByXS();
		JSONObject zxList = smCountMonthRouteService.selectAllByZX();
		JSONArray arr = new JSONArray();
		arr.add(xsList); arr.add(zxList);
		return AjaxResult.success("dataList", arr);
	}
	
	/**
	 * 
	 * 描述: 登记主表、年报主表、列入异常表、移出异常表数据量
	 * @auther gaojinling
	 * @date 2017年8月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/smRptAddcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult smRptAddcount(HttpSession session){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("rptDateEnd", DateUtil.getCurrentDate());
            map.put("rptDateStart", DateUtil.getNdaylater2(DateUtil.getSysCurrentDate(),-20));
            List<SmRptAddcountDto> smRptAddcountDtos = smRptAddcountService.tableAddCount(map);
            List<String> rptDates = new ArrayList<String>();
            List<Long> tableType1s = new ArrayList<Long>();
            List<Long> tableType2s = new ArrayList<Long>();
            List<Long> tableType3s = new ArrayList<Long>();
            List<Long> tableType4s = new ArrayList<Long>();
            for(SmRptAddcountDto smRptAddcountDto :smRptAddcountDtos){
            	rptDates.add(smRptAddcountDto.getCountDate());
            	tableType1s.add(smRptAddcountDto.getAddCount1());
            	tableType2s.add(smRptAddcountDto.getAddCount2());
            	tableType3s.add(smRptAddcountDto.getAddCount3());
            	tableType4s.add(smRptAddcountDto.getAddCount4());
            }
            JSONObject obj = new JSONObject();
            obj.put("rptDates", rptDates);
            obj.put("tableType1s", tableType1s);
            obj.put("tableType2s", tableType2s);
            obj.put("tableType3s", tableType3s);
            obj.put("tableType4s", tableType4s);
            return AjaxResult.success ("操作成功",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
	
	
	
	
	
}
