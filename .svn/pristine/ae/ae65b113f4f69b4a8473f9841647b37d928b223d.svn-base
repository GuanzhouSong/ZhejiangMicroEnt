package com.icinfo.cs.es.controller.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * es索引维护
 * 
 * @author zhuyong
 */
@Controller
@RequestMapping({"/esmanage"})
public class EsManageController {
	
	@Autowired
	IEsManageService esManageService;
	
	@Autowired
	IPanoramaSearchService panoramaSearchService;
	
	@Autowired
	IMidBaseInfoService midBaseInfoService;
	
	//进入页面密码
	private static final String inKey = "hx123zhu12315HXasdfuiop";
	
	//更新使用密码
	private static final String scKey = "hx123zhu12315HXqwervbmn";

	/**
	 * es索引维护定时任务
	 * 
	 * @author zhuyong
	 * @date 2016-11-29
	 */
	@RequestMapping("/quartzJob")
	public void quartzJob(){
		esManageService.esQuartzJob();
	}

	
	/**
	 * es索引维护定时任务
	 * 
	 * @author zhuyong
	 * @date 2016-11-29
	 */
	@RequestMapping("/updateIdxByLocal")
	public void partUpdate() throws Exception{
	    System.err.println("/n start......................");
		FileReader reader = new FileReader("F://tt.txt");
	    BufferedReader br = new BufferedReader(reader);
	    String str = null;
	           
	    int i = 1;
	    while((str = br.readLine()) != null) {
	         if(StringUtils.isNotBlank(str)){
	            System.err.println(i + "-------------" + str);
	            esManageService.updateOnePanoramaIdx(str);
	            i++;
	          }
	    }
	           
	    br.close();
	    reader.close();
	    
	    System.err.println("/n end......................");
	}
	
	/**
	 * 进入索引查看页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/viewIdx/{param}")
	public String viewIdx(@PathVariable String param) throws Exception{
		if(!inKey.equals(param)){
			throw new Exception();
		}
		return "/common/esmanage/viewidx";
	}
	
	
	/**
	 * 索引信息查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectIdxInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult selectIdxInfo(@RequestBody Map<String,Object> map) {
		if(!map.containsKey("priPID") || "".equals(map.get("priPID")+"")){
			return AjaxResult.success("查询参数错误");	
		}
		return AjaxResult.success(panoramaSearchService.doGetResponseStr(map.get("priPID")+""));
	}
	
	/**
	 * 进入索引维护页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doEnPanoManage/{param}")
	public String doEnPanoManage(@PathVariable String param) throws Exception{
		if(!inKey.equals(param)){
			throw new Exception();
		}
		return "/common/esmanage/panomanage";
	}
	
	
	/**
	 * 索引更新
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUpdatePano", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doUpdatePano(@RequestBody Map<String, Object> map) throws Exception {
		if (!map.containsKey("keyword") || !map.containsKey("upassword"))
			return AjaxResult.error("更新失败");

		if ("".equals(map.get("keyword") + ""))
			return AjaxResult.error("更新失败");
		
		if (!scKey.equals(map.get("upassword") + ""))
			return AjaxResult.error("更新失败");// 验证更新密码

		List<MidBaseInfo> dataList = midBaseInfoService.selectMidInfoByKeyword(map);
		
		if(dataList == null || dataList.size() == 0 
				|| StringUtils.isBlank(dataList.get(0).getPriPID())){
			return AjaxResult.error("查询不到企业，无法更新");// 验证更新密码
		}
		
		return AjaxResult.success(esManageService.updateOnePanoramaIdx(dataList.get(0).getPriPID()));
	}
	
	/**
	 * 索引删除
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doDeletePano", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDeletePano(@RequestBody Map<String, Object> map) throws Exception {
		if (!map.containsKey("keyword_delete") || !map.containsKey("upassword_delete"))
			return AjaxResult.error("更新失败");

		if ("".equals(map.get("keyword_delete") + ""))
			return AjaxResult.error("更新失败");
		
		if (!scKey.equals(map.get("upassword_delete") + ""))
			return AjaxResult.error("更新失败");// 验证更新密码

		return AjaxResult.success(esManageService.deleteOnePanoramaIdx(map.get("keyword_delete") + ""));
	}
	
	
	
	
	
	
}




