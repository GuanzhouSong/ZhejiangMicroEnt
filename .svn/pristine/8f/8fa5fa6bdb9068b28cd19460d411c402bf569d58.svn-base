/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.infomange.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.infomange.dto.InfoReceStatDto;
import com.icinfo.cs.infomange.service.IInfoReceStatService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    info_rece_stat 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Controller
@RequestMapping("/syn/infomange/inforecestat")
public class InfoReceStatController extends BaseController {
	
	@Autowired
	IInfoReceStatService infoReceStatService;
	
	/**
	 * 进入数据统计页面
	 * @author zjj
	 */
	@RequestMapping(value="/infoview",method= RequestMethod.GET)
	public ModelAndView infoView() throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/infomange/inforecestat");
        return view;
	}
 /**
  * 保存下载数据
  * @author zjj
  * @return
  * @throws Exception
  */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(String priPID,String id,String type,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        String[] priArr = priPID.split(",");
        String[] idArr = id.split(",");
        for(int i=0;i<idArr.length;i++){
        	InfoReceStatDto infoReceStat = new InfoReceStatDto();
    		infoReceStat.setPriPID(priArr[i]);
    		infoReceStat.setRelateId(idArr[i]);
    		infoReceStat.setAdcode(sysUser.getSysDepart().getAdcode());
    		infoReceStat.setType(type);
    		infoReceStat.setCreateTime(new Date());
    		infoReceStat.setYear(DateUtil.getCurrentYear());
    		infoReceStatService.insert(infoReceStat);
        }
        return AjaxResult.success("下载成功!");
	}
	/**
	 * 获取统计数据
	 * @author zjj
	 */
	@RequestMapping(value="/getdata",method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> getData(String year) throws Exception{
		List<Integer> list = new ArrayList<Integer>();
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("year", year);
		for(int i=0;i<5;i++){
			qryMap.put("type", i);
			for(InfoReceStatDto infoReceStatDto : infoReceStatService.selectDownDateCount(qryMap)){
				list.add(infoReceStatDto.getNumYear());
				list.add(infoReceStatDto.getNum());
			}
		}
		return list;
	}
}