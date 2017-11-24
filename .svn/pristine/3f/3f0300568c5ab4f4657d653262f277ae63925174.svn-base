/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_pub_scresult 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller
@RequestMapping("/syn/server/drcheck/pubscresult")
public class PubScresultController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(PubScresultController.class);

    @Autowired
    private IPubScresultService pubScresultService;
    
    /**
	 * 描述：根据priPID查询抽查检查JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月30Øß日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubScresultDto> listJSON(PageRequest request) throws Exception {
		List<PubScresultDto> pubScresultDtos = pubScresultService.queryPageResult(request);
		logger.info("pubScresultDtos {}", pubScresultDtos);
		return new PageResponse<PubScresultDto>(pubScresultDtos);
	}
	
	/**
     * 描述：获取历史抽查检查记录
     * @author chenxin
     * @date 2016-09-11
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/resultlist.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScresultDto> listResultJSON(PageRequest request) throws Exception {
		List<PubScresultDto> data = pubScresultService.queryPagePubScresultDto(request);
        return new PageResponse<PubScresultDto>(data);
    }
}