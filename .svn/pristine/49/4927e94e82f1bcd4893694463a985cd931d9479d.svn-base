/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.rpt.rptmodel.CorpLink;
import com.icinfo.cs.rpt.rptmodel.CorpNode;
import com.icinfo.cs.rpt.rptservice.IRelationNetAllService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_relation_net_all 对应的Controller类.<br>
 *        Echarts3 获取数据
 * @author framework generator
 * @date 2017年07月12日
 */
@Controller
@RequestMapping("/reg/server/rptyr/relationnetall" )//@RequestMapping({"/reg/server/rptyr/relationnetall"})
public class RelationNetAllController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(RelationNetAllController.class);

    @Autowired
    private IRelationNetAllService relationNetAllService;
    @Autowired
    private IEntSearchService entSearchService;


    /**
     *@描述：  关系图页面
     *@author: wangjin
     *@date 2017-07-12 11:02
     *@return
     */
    @RequestMapping("/relationShow")
    public ModelAndView relationShow(String priPID) throws UnsupportedEncodingException {
        priPID = AESEUtil.decodeCorpid(priPID);//解密
        ModelAndView view = new ModelAndView("/reg/server/rpt/echarts/relation-view");
        MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
        view.addObject("midBaseInfo", midBaseInfoDto);
        return view;
    }


    /**
     *@描述：  获取数据
     *@author: wangjin
     *@date 2017-07-12 15:58
     *@return
     */
    @RequestMapping(value = "/getJsonData", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getJsonData(PageRequest request) throws Exception {

        Map<String, Object> mapData = relationNetAllService.select_result(request);
        if(!mapData.isEmpty()){
            List<CorpNode> nodeList = (List<CorpNode>)mapData.get("nodeList");
            List<CorpLink> linkList = (List<CorpLink>)mapData.get("linkList");

            List<Object> listData = new ArrayList<Object>();
            listData.add(JSONArray.fromObject(nodeList));
            listData.add(JSONArray.fromObject(linkList));
            return AjaxResult.success("获取结果集", listData);
        }
        return AjaxResult.error("未查询到数据");
    }


}