/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.rpt.rptmapper.SmCountMonthRouteMapper;
import com.icinfo.cs.rpt.rptmodel.SmCountMonthRoute;
import com.icinfo.cs.rpt.rptservice.ISmCountMonthRouteService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    sm_count_month_route 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
@Service
public class SmCountMonthRouteServiceImpl extends MyBatisServiceSupport implements ISmCountMonthRouteService {

    @Autowired
    private SmCountMonthRouteMapper smCountMonthRouteMapper;

  
    //在册（查询最近的12个月）
    @Override
    public JSONObject selectAllByZC() throws Exception {
//        Example example = new Example(SmCountMonthRoute.class);
//        example.createCriteria().andEqualTo("smflag","ZC");
//        example.setOrderByClause("smmonth ASC");
//        List<SmCountMonthRoute> monthList = smCountMonthRouteMapper.selectByExample(example);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("smFlag", "ZC");
        map.put("numStart", 0);
        map.put("pageSize", 12);
        List<SmCountMonthRoute> monthList =  smCountMonthRouteMapper.selectSmCountMonthRoute(map);

        List<String> strList = new ArrayList<String>();
        List<Integer> dataList = new ArrayList<Integer>();
        JSONObject obj = new JSONObject();
        for(int i = 0;i<monthList.size();i++){
            strList.add(monthList.get(monthList.size()-1-i).getSmmonth());
            dataList.add(monthList.get(monthList.size()-1-i).getSmcount());
        }
        obj.put("dataList", JSONObject.toJSON(dataList));
        obj.put("strList", JSONObject.toJSON(strList));

        return obj;
    }

    //新设、注销 查询最近的18个月的
    @Override
    public JSONObject selectAllByXS() throws Exception {
//        Example example = new Example(SmCountMonthRoute.class);
//        example.createCriteria().andEqualTo("smflag","XS");
//        example.setOrderByClause("smmonth ASC");
//        List<SmCountMonthRoute> monthList = smCountMonthRouteMapper.selectByExample(example);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("smFlag", "XS");
        map.put("numStart", 0);
        map.put("pageSize", 18);
        List<SmCountMonthRoute> monthList =  smCountMonthRouteMapper.selectSmCountMonthRoute(map);

        List<String> strList = new ArrayList<String>();
        List<Integer> dataList = new ArrayList<Integer>();
        JSONObject obj = new JSONObject();
        for(int i = 0;i<monthList.size();i++){
            strList.add(monthList.get(monthList.size()-i-1).getSmmonth());
            dataList.add(monthList.get(monthList.size()-i-1).getSmcount());
        }
        obj.put("dataList", JSONObject.toJSON(dataList));
        obj.put("strList", JSONObject.toJSON(strList));

        return obj;
    }
    
    //注销
    @Override
    public JSONObject selectAllByZX() throws Exception {
//        Example example = new Example(SmCountMonthRoute.class);
//        example.createCriteria().andEqualTo("smflag","ZX");
//        example.setOrderByClause("smmonth ASC");
//        List<SmCountMonthRoute> monthList = smCountMonthRouteMapper.selectByExample(example);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("smFlag", "ZX");
        map.put("numStart", 0);
        map.put("pageSize", 18);
        List<SmCountMonthRoute> monthList =  smCountMonthRouteMapper.selectSmCountMonthRoute(map);

        List<String> strList = new ArrayList<String>();
        List<Integer> dataList = new ArrayList<Integer>();
        JSONObject obj = new JSONObject();
        for(int i = 0;i<monthList.size();i++){
            strList.add(monthList.get(monthList.size()-i-1).getSmmonth());
            dataList.add(monthList.get(monthList.size()-i-1).getSmcount());
        }
        obj.put("dataList", JSONObject.toJSON(dataList));
        obj.put("strList", JSONObject.toJSON(strList));

        return obj;
    }
}