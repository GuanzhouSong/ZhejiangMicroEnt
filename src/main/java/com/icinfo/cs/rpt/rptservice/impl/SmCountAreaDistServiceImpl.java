/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.rpt.rptmapper.SmCountAreaDistMapper;
import com.icinfo.cs.rpt.rptmodel.SmCountAreaDist;
import com.icinfo.cs.rpt.rptservice.ISmCountAreaDistService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:    sm_count_area_dist 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
@Service
public class SmCountAreaDistServiceImpl extends MyBatisServiceSupport implements ISmCountAreaDistService {

    @Autowired
    private SmCountAreaDistMapper smCountAreaDistMapper;

    @Override
    public JSONArray selectAll() throws Exception {
        List<SmCountAreaDist> areaList =smCountAreaDistMapper.selectAll();
        JSONArray arr = new JSONArray();
        for(SmCountAreaDist area:areaList){
            JSONObject app1 = new JSONObject();
            app1.put("name", area.getSmarea());
            app1.put("value", area.getSmcount());
            arr.add(app1);
        }

        return arr;
    }


}