package com.icinfo.cs.im.controller.reg.server.iminfo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.system.controller.CSBaseController;

/**
 * 即时信息综合查询
 * 
 * @author ljx
 *
 */
@Controller
@RequestMapping("/reg/server/iminfo/")
public class ImInfoSearchController extends CSBaseController {

	@Autowired
	IEntSearchService entSearchService;

	@RequestMapping("list")
	public ModelAndView toImInfoSearch() {
		ModelAndView view = new ModelAndView("reg/server/iminfo/iminfolist");
		return view;
	}

	/**
	 * 即时信息选择项
	 * 
	 * @authorljx
	 * @return
	 */
	@RequestMapping("tochoseitem")
	public ModelAndView toChoseItem() {
		ModelAndView view = new ModelAndView("reg/server/iminfo/itemselect");
		return view;
	}
	/**
	 * to 详情页
	 * @param priPID
	 * @return
	 */
   /* @RequestMapping("todetail")
	public ModelAndView toDetail(String priPID) {
	    ModelAndView view=new ModelAndView("reg/server/iminfo/iminfodetail");
		if(StringUtils.isNotEmpty(priPID)){
			PubEntSearchDto entBasicInfo = entSearchService.selectByPriPID(priPID);
			view.addObject("entBasicInfo",entBasicInfo); 
			view.addObject("priPID",priPID); 
		}
		return view;
		

	}
*/
}
