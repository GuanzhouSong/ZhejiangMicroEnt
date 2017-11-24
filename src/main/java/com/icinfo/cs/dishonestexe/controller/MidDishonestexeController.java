/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dishonestexe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.dishonestexe.model.MidDishonestexe;
import com.icinfo.cs.dishonestexe.service.IMidDishonestexeService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/** 
 * 描述: 失信被执行人信息 Controller
 * @author 张文男
 * @date 2017年3月17日  
 */
@Controller
@RequestMapping({"/syn/dishonestexe"})
public class MidDishonestexeController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(MidDishonestexeController.class);

    @Autowired
    private IMidDishonestexeService midDishonestexeService;
    
	/**
	 * 根据自然人身份证号获取分页列表信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryListByCardNum"})
	@ResponseBody
	public PageResponse<MidDishonestexe> queryListByCardNum(PageRequest request) throws Exception {
		List<MidDishonestexe> list = midDishonestexeService.queryListByCardNum(request);//执行参数条件查询
		return new PageResponse<MidDishonestexe>(list);
	}
    
}