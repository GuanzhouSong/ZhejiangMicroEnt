/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.drcheck.service.IPubScinfoHisService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_scinfo_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Controller
@RequestMapping("/syn/drcheck/syn/server/pubscinfohis")
public class PubScinfoHisController extends BaseController {

    @Autowired
    private IPubScinfoHisService pubScinfoHisService;
    
    /**
     * 
     * 描述: 随机抽取
     * @auther chenxin
     * @date 2016年11月04日 
     * @param taskNO
     * @return
     * @throws Exception
     */
    @RequestMapping("/random")
    @ResponseBody
    public AjaxResult doRandom(String taskNO,float percent)throws Exception{
    	if(pubScinfoHisService.randomPubscinfo(taskNO, percent)){
    		return AjaxResult.success("随机生成成功");
    	}
		return AjaxResult.error("随机生成失败");
    }
    
    /**
     * 
     * 描述: 随机抽取数量统计
     * @auther chenxin
     * @date 2016年11月04日 
     * @param taskNO
     * @return
     * @throws Exception
     */
    @RequestMapping("/number")
    @ResponseBody
    public AjaxResult doGetNumber(int total,float percent)throws Exception{
    	String message = pubScinfoHisService.countFirstNumber(total, percent);
		return AjaxResult.success(message);
    }
}