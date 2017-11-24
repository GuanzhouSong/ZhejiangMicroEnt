/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.depsyn.dto.CsDepsynComPunDto;
import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.depsyn.dto.CsDepsynSpotDto;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.cs.depsyn.model.CsDepsynManageNum;
import com.icinfo.cs.depsyn.model.CsDepsynPunish;
import com.icinfo.cs.depsyn.service.ICsDepsynComPunService;
import com.icinfo.cs.depsyn.service.ICsDepsynLicenseService;
import com.icinfo.cs.depsyn.service.ICsDepsynManageNumService;
import com.icinfo.cs.depsyn.service.ICsDepsynPunishService;
import com.icinfo.cs.depsyn.service.ICsDepsynSpotService;
import com.icinfo.cs.infomange.dto.InfoReceStatDto;
import com.icinfo.cs.infomange.service.IInfoReceStatService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    info_rece_stat 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Controller
@RequestMapping("/depsyn")
public class DepInfoStatController extends BaseController {
	
	@Autowired
	IInfoReceStatService infoReceStatService;
	
    @Autowired
    private ICsDepsynPunishService csDepsynPunishService;
    
    @Autowired
    private ICsDepsynLicenseService csDepsynLicenseService;
    
    @Autowired
    private ICsDepsynSpotService csDepsynSpotService;
    
    @Autowired
    private ICsDepsynComPunService csDepsynComPunService;
    @Autowired
    private ICsDepsynManageNumService csDepsynManageNumService;
	/**
	 * 进入数据统计页面
	 * @author zjj
	 */
	@RequestMapping(value="/infoview",method= RequestMethod.GET)
	public ModelAndView infoView() throws Exception{
		ModelAndView view = new ModelAndView("/depsyn/infostat_list");
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
		for(int i=0;i<7;i++){
			qryMap.put("type", i);
			if(i==0) qryMap.put("type", "");
			qryMap.put("checkState", "");
			if(i>0 && i<5) 
				for(int j=0;j<4;j++){
					if(j==0) qryMap.put("checkState", "");
					if(j==1) qryMap.put("checkState", "1");
					if(j==2) qryMap.put("checkState", "0");
					if(j==3) {
						for(int k=0;k<26;k++){
						    list.add(0);
					    }
					 }else{
						 for(InfoReceStatDto infoReceStatDto : infoReceStatService.selectSendDateCount(qryMap)){
								list.add(infoReceStatDto.getNumYear());
								list.add(infoReceStatDto.getNum());
							}
					 }
						
				}
			if(i==5) 
				for(int j=0;j<2;j++){
					qryMap.put("checkState", j);
					if(j==0	) qryMap.put("checkState", "");
					for(InfoReceStatDto infoReceStatDto : infoReceStatService.selectSendDateCount(qryMap)){
						list.add(infoReceStatDto.getNumYear());
						list.add(infoReceStatDto.getNum());
					}
				}
			if(i==0||i==6){
				for(InfoReceStatDto infoReceStatDto : infoReceStatService.selectSendDateCount(qryMap)){
					list.add(infoReceStatDto.getNumYear());
					list.add(infoReceStatDto.getNum());
			  }
			}
		}
		return list;
	}
	/**
	 * 进入本部门行政处罚问题数据处理页面
	 * @author zjj
	 */
	@RequestMapping(value="/datamanage",method= RequestMethod.GET)
	public ModelAndView dataManage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/depsyn/infomanage_list");
		view.addObject("depCode", sysUser.getDepSynName());
        return view;
	}
	
	/**
	 * 获取本部门行政处罚问题数据
	 * @author zjj
	 */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsDepsynPunishDto> query(PageRequest request) throws Exception {
        List<CsDepsynPunishDto> data = csDepsynPunishService.searchPunish(request);
        return new PageResponse<CsDepsynPunishDto>(data);
    }
    
    /**
     * 进入添加行政处罚信息页面
     * @author zjj
     */
    @RequestMapping(value="/eneditpunish",method= RequestMethod.GET)
	public ModelAndView enEditPunish(String id) throws Exception{
		ModelAndView view = new ModelAndView("/depsyn/infomanage_edit");
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("id", id);
		List<CsDepsynPunishDto> csDepsynPunishList = csDepsynPunishService.selectPunishList(qryMap);
		if(csDepsynPunishList.size()>0) view.addObject("csDepsynPunish",csDepsynPunishList.get(0));
        return view;
	}
   
	/**
	 * 添加行政处罚信息
	 * @author zjj
	 * @throws Exception
	 */
	@RequestMapping(value="/editpunish",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult editPunish(@RequestBody CsDepsynPunish csDepsynPunish) throws Exception{
		if(csDepsynPunish !=null){
			if(csDepsynPunishService.editPunish(csDepsynPunish)>0)
			   return AjaxResult.success("修改成功！");
		}
	    return AjaxResult.error("修改失败!");
	}
	/**
	 * 删除行政处罚信息
	 * @author zjj
	 */
	@RequestMapping(value="/deletepunish",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deletePunish(String idArr) throws Exception{
		if(StringUtils.isNoneBlank(idArr)){
			String[] idStr =idArr.split(",");
			for(String str : idStr){
				csDepsynPunishService.deletePunish(str);
			}
			   return AjaxResult.success("删除成功！");
		}
	    return AjaxResult.error("删除失败!");
	}
	/**
	 * 进入本部门行政许可问题数据处理页面
	 * @author zjj
	 */
	@RequestMapping(value="/licenseview",method= RequestMethod.GET)
	public ModelAndView licenseView(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/depsyn/licensemanage");
		view.addObject("depCode", sysUser.getDepSynName());
        return view;
	}
	
    /**
     * 进入添加行政许可信息页面
     * @author zjj 
     */
    @RequestMapping(value="/eneditlicense",method= RequestMethod.GET)
	public ModelAndView enEditLicense(String id) throws Exception{
		ModelAndView view = new ModelAndView("/depsyn/licensemanage_edit");
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("id", id);
		List<CsDepsynLicenseDto> csDepsynLicenseList = csDepsynLicenseService.selectLicenseList(qryMap);
		if(csDepsynLicenseList.size()>0) view.addObject("csDepsynLicense",csDepsynLicenseList.get(0));
        return view;
	}
    
	/**
	 * 添加行政许可信息
	 * @author zjj
	 * @throws Exception
	 */
	@RequestMapping(value="/editlicense",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult editLicense(@RequestBody CsDepsynLicense csDepsynLicense) throws Exception{
		if(csDepsynLicense !=null){
			if(csDepsynLicenseService.editLicense(csDepsynLicense)>0)
			   return AjaxResult.success("修改成功！");
		}
	    return AjaxResult.error("修改失败!");
	}
	/**
	 * 删除行政处罚信息
	 * @author zjj
	 */
	@RequestMapping(value="/deletelicense",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteLicense(String idArr) throws Exception{
		if(StringUtils.isNoneBlank(idArr)){
			String[] idStr =idArr.split(",");
			for(String str : idStr){
				csDepsynLicenseService.deleteLicense(str);
			}
			   return AjaxResult.success("删除成功！");
		}
	    return AjaxResult.error("删除失败!");
	}
	/**
	 * 获取本部门行政许可问题数据
	 * @author zjj
	 */
    @RequestMapping(value = "/querylicense", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsDepsynLicenseDto> queryLicense(PageRequest request) throws Exception {
        List<CsDepsynLicenseDto> data = csDepsynLicenseService.searchLicense(request);
        return new PageResponse<CsDepsynLicenseDto>(data);
    }
    
	/**
	 * 进入本部门抽检抽查问题数据处理页面
	 * @author zjj
	 */
	@RequestMapping(value="/spotview",method= RequestMethod.GET)
	public ModelAndView spotView(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/depsyn/spotmanage");
		view.addObject("depCode", sysUser.getDepSynName());
        return view;
	}
	/**
	 * 获取本部门抽检抽查问题数据
	 * @author zjj
	 */
    @RequestMapping(value = "/queryspot", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsDepsynSpotDto> querySpot(PageRequest request) throws Exception {
        List<CsDepsynSpotDto> data = csDepsynSpotService.searchSpot(request);
        return new PageResponse<CsDepsynSpotDto>(data);
    }
    /**
     * 进入数据应用反馈页面
     * @author zjj
     */
	/**
	 * 进入本部门抽检抽查问题数据处理页面
	 * @author zjj
	 */
	@RequestMapping(value="/feedbackview",method= RequestMethod.GET)
	public ModelAndView feedbackView() throws Exception{
		ModelAndView view = new ModelAndView("/depsyn/sjyyfk_list");
        return view;
	}
	
	/**
	 * 获取数据应用反馈数据
	 * @author zjj
	 */
    @RequestMapping(value = "/feedbacklist", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsDepsynComPunDto> feedbackList(PageRequest request) throws Exception {
        List<CsDepsynComPunDto> data = csDepsynComPunService.searchFeedBackList(request);
        return new PageResponse<CsDepsynComPunDto>(data);
    }
	/**
	 * 进入数据应用反馈录入页面
	 * @author zjj
	 */
	@RequestMapping(value="/editview",method= RequestMethod.GET)
	public ModelAndView editView(String id) throws Exception{
		ModelAndView view = new ModelAndView("/depsyn/sjyyfk_edit");
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("id", id);
		
		List<CsDepsynComPunDto> csDepsynComPunList = csDepsynComPunService.selectDepsynComPunList(qryMap);
		if(csDepsynComPunList.size()>0)
			view.addObject("csDepsynComPunDto",csDepsynComPunList.get(0));
        return view;
	}
	/**
	 * 添加录入条数
	 * @author zjj
	 * @throws Exception
	 */
	@RequestMapping(value="/savedata",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveData(@RequestBody CsDepsynComPunDto csDepsynComPun) throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		CsDepsynManageNum csDepsynManageNum = new CsDepsynManageNum();
		
		if(StringUtils.isBlank(csDepsynComPun.getMsgType()) || StringUtils.isBlank(csDepsynComPun.getInputDepCode())) 
			return AjaxResult.error("操作失败!");
		qryMap.put("msgType", csDepsynComPun.getMsgType());
		qryMap.put("dept", csDepsynComPun.getInputDepCode());
		csDepsynManageNumService.deleteByMap(qryMap);
		
		csDepsynManageNum.setDept(csDepsynComPun.getInputDepCode());
		csDepsynManageNum.setMsgType(csDepsynComPun.getMsgType());
		csDepsynManageNum.setManageNum(csDepsynComPun.getRealNum());
		if(csDepsynManageNumService.insert(csDepsynManageNum)>0) 
			return AjaxResult.success("操作成功!");
		return AjaxResult.error("操作失败!");
	
	}
	
}