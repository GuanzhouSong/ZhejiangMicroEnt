/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.drcheck.dto.PubScinfoBackDto;
import com.icinfo.cs.drcheck.service.IPubScinfoBackService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_pub_scinfo_back 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Controller
@RequestMapping("/syn/pub/server/drcheck/pubscinfoback")
public class PubScinfoBackController extends BaseController {
    @Autowired
    private IPubScinfoBackService pubScinfoBackService;
    @Autowired
    private IPanoramaSearchService panoramaSearchService;
    
    
    /**
     * 描述：获取查抽检查待抽检列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScinfoBackDto> listJSON(PageRequest request) throws Exception {
		List<PubScinfoBackDto>	data = pubScinfoBackService.queryPubScinfoBackDtoPage(request);
        return new PageResponse<PubScinfoBackDto>(data);
    }
	
	 
    /**
     * 描述：批量导入待抽检库
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/addbatch",method= RequestMethod.POST)
    @ResponseBody
    public void addbatch(@RequestParam("file") MultipartFile file, String taskNO,HttpServletResponse response) throws Exception {
        InputStream in = file.getInputStream();
        boolean flag = pubScinfoBackService.batchImportBack(in, taskNO);
        JSONObject json = new JSONObject();
        if(flag){
            json.put("status", "success");
        }else{
        	json.put("status", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	

	/**
	 * 
	 * 描述: 进入批量导入页面
	 * @auther chenxin
	 * @date 2017-02-20
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/enterimportpage",method= RequestMethod.GET)
	public ModelAndView importbatch(String taskNO) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/drcheck/pubscinfoback_import");
		view.addObject("taskNO",taskNO);
		return view;
	}
	
	/**
	 * 描述：录入抽查检查结果
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAdd(@RequestBody PubScinfoBackDto pubScinfoBackDto) throws Exception {
		if(pubScinfoBackService.addScinfoBackByTaskNO(pubScinfoBackDto.getTaskNO(),pubScinfoBackDto.getPripIdList())){
			return AjaxResult.success("导入待抽检库成功");
		}
		return AjaxResult.error("导入待抽检库失败");
	}
	
	/**
	 * 描述：录入抽查检查结果
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addAll", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddAll(@RequestParam Map<String,Object> params) throws Exception {
		String taskNO = (String)params.get("taskNO");
		panoramaSearchService.doSearchForPubScinfoList(taskNO, params);
		return AjaxResult.success("导入待抽检库成功");
	}
	
	/**
	 * 描述：统计待抽检库数量
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCount(String taskNO) throws Exception {
		int count = pubScinfoBackService.countPubScinfoBack(taskNO);
		return AjaxResult.success(count+"");
	}
	
	/**
	 * 描述：清除待抽检库
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doRemove(String taskNO) throws Exception {
		if(StringUtils.isNotEmpty(taskNO)){
			pubScinfoBackService.cleanScinfoBackByTaskNO(taskNO);
			return AjaxResult.success("清除成功");
		}
		return AjaxResult.error("清除失败");
	}
	
	  /**
     * 
     * 描述: 随机抽取
     * @auther chenxin
     * @date 2016年11月21日 
     * @param taskNO
     * @return
     * @throws Exception
     */
    @RequestMapping("/randoment")
    @ResponseBody
    public AjaxResult doRandomEnt(String taskNO,int totalRandomNumber)throws Exception{
    	if(pubScinfoBackService.randomPubScinfoByRegOrg(taskNO, totalRandomNumber)){
    		return AjaxResult.success("随机生成成功");
    	}
		return AjaxResult.error("随机生成失败");
    }
	
}