/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.other.service.IPubOtherlicenceHisService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_otherlicence_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({"/reg/server/other/pubohterlicenceHis/","/syn/server/other/pubohterlicenceHis/"})
public class PubOtherlicenceHisController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceHisController.class);

    @Autowired
    private IPubOtherlicenceHisService pubOtherlicenceHisService;
    /**
     * 
     * 描述: 查看详情
     * @auther ljx
     * @date 2016年10月20日 
     * @param hisNO
     * @return
     */
    @RequestMapping("/show")
    public ModelAndView show(String hisNO){
    	ModelAndView view=new ModelAndView("/reg/server/other/otherlicence/otheerlicenceHis_detail");
    	if(StringUtils.isNotEmpty(hisNO)){
    	view.addObject("pubOtherlicence",pubOtherlicenceHisService.selectByHisNO(hisNO));
    	}
    	return view;
    	
    }
    
}