/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.composite.controller.syn;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.SfcHonor;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.service.ISfcCominfoService;
import com.icinfo.cs.yr.service.ISfcHonorService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 
 * 描述: 农专社部门审核   综合信息报表工商端审核
 * @author gaojinling
 * @date 2016年11月29日
 */
@Controller
@RequestMapping({ "/syn/cominfoserver", "/reg/server/cominfoserver" })
public class SfcCominfoServerController extends BaseController {
    //综合信息
    @Autowired
    private ISfcCominfoService sfcCominfoService;
    //主表
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    //基本信息
    @Autowired
    private IYrSfcBaseinfoService yrSfcBaseinfoService;
    //荣誉信息
    @Autowired
    private ISfcHonorService sfcHonorService;



    /**
     * 
     * 描述: 综合信息报表（工商端查看）
     * @auther gaojinling
     * @date 2016年11月29日 
     * @param year
     * @param priPID
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, String priPID,HttpSession session) throws Exception {
    	SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认协同
		String sysUrl="/syn";
		//警示
		if("1".equals(sysUser.getUserType())){
			sysUrl="/reg/server";
		}
		
    	ModelAndView view = new ModelAndView("/syn/system/composite/sfcgeneralinfo_view");
		if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)){			

        view.addObject("sfcCominfo", sfcCominfoService.selectByYearAndPripid(Integer.parseInt(year),priPID));
        //查询农专的基本信息
        YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID,"0");
        if(yrSfcBaseinfo!=null){
            BigDecimal vendInc =   yrSfcBaseinfo.getVendInc()==null?null: yrSfcBaseinfo.getVendInc().setScale(4,BigDecimal.ROUND_HALF_UP);//销售额或营业收入
            BigDecimal ratGro = yrSfcBaseinfo.getRatGro()==null?null: yrSfcBaseinfo.getRatGro().setScale(4,BigDecimal.ROUND_HALF_UP);//纳税金额
            view.addObject("vendInc",vendInc);
            view.addObject("ratGro",ratGro);
        }
        view.addObject("sysUrl",sysUrl);
        view.addObject("year",year);
        view.addObject("priPID",priPID);
        view.addObject("yrSfcBaseinfo",yrSfcBaseinfo); 
        //查询年报主表信息
        YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));
        view.addObject("yrRegCheck",yrRegCheck);
		}
        return view;
    }
    
    /**
     * 
     * 描述: 荣誉信息（工商端查看）
     * @auther gaojinling
     * @date 2016年11月29日 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/sfcHonorlist.json"})
    @ResponseBody
    public PageResponse<SfcHonor> list_json(PageRequest request) throws Exception {
        List<SfcHonor> data = sfcHonorService.select_queryPage(request);//执行参数条件查询
        return new PageResponse<SfcHonor>(data);
    }





}