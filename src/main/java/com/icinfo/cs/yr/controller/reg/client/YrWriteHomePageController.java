/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:    cs_yr_asset 对应的Controller类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/yrwritehomepage")
public class YrWriteHomePageController extends BaseController {


    @Autowired
    IYrAssetService yrAssetService;//资产状况
    @Autowired
    IYrRegCheckService yrRegCheckService;
    @Autowired
    IYrFormService yrFormService;
    @Autowired
    IYrBaseInfoService yrBaseInfoService;//企业年报基本信息


    /**
     * 填报 首页 显示
     * @autor wangjin
     * @param year 年份
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping("/write_homepage")
    public String index_list(String year ,HttpSession session,RedirectAttributes attr) throws Exception {

        String encodeYear = year;          //接收加密年份
        year = AESEUtil.decodeYear(year);  //年份解密

        //获取session的企业基本信息
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        String priPID=midBaseInfoDto.getPriPID();//身份主体代码

        //查询年报主表信息
        //YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));
        //获取企业报表配置
        List<String> reportTypeList = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType(),year);
        session.setAttribute("reportTypeList",reportTypeList);  //企业报表配置存放至session中

        try {
            YrBaseInfo yrBaseInfo =  yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year),priPID);
            if(yrBaseInfo==null){//判断当前企业年报基本信息表是否有数据 否则新增一条数据
                YrBaseInfo _yrBaseInfo = new YrBaseInfo();
                _yrBaseInfo.setPriPID(midBaseInfoDto.getPriPID()); //主体身份代码
                _yrBaseInfo.setEntName(midBaseInfoDto.getEntName());//企业名称
                _yrBaseInfo.setRegNO(midBaseInfoDto.getRegNO());//注册号
                _yrBaseInfo.setEntType(midBaseInfoDto.getEntType());//企业类型
                _yrBaseInfo.setUniCode(midBaseInfoDto.getUniCode());//统一社会信用代码
                _yrBaseInfo.setYear(Integer.valueOf(year));//年报年度
                int i = yrBaseInfoService.insert(_yrBaseInfo);
                if(!(i>0)){return null;}
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/prompt/show";
        }

        try {
            //获取表单填写的状态,如果为null 新增当前年份和身份主体代码
            YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));
            if(yrForm == null) {
                int j = yrFormService.insert(priPID, Integer.valueOf(year),reportTypeList);
                if(!(j>0)){return null;}
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/prompt/show";
        }

        //判断Tab第一个显示的页面
        String urlTab = "";
        String repList = reportTypeList.get(0);
        //年报出资情况
        if(RepTypeUtil.formSubcapital.equals(repList)){urlTab = "redirect:/reg/client/yr/ent/subcapital/show";}

        //年报对外投资
        if(RepTypeUtil.formForinvestment.equals(repList)){urlTab = "redirect:/reg/client/yr/ent/forinvestment/show";}

        //年报资产状况
        if(RepTypeUtil.formAsset.equals(repList)){urlTab =  "redirect:/reg/client/yr/ent/yrasset/show";}

        //年报经营情况
        if(RepTypeUtil.formAssetbranch.equals(repList)){urlTab =  "redirect:/reg/client/yr/ent/yrassetbranch/show";}

        //年报股权转让
        if(RepTypeUtil.formAlterstockinfo.equals(repList)){urlTab = "redirect:/reg/client/yr/ent/alterstock/show";}

        //年报其他情况
        if(RepTypeUtil.formOtherinfo.equals(repList)){urlTab = "redirect:/reg/client/yr/ent/yrotherinfo/show";}

        //年报对外担保
        if(RepTypeUtil.formForguaranteeinfo.equals(repList)){urlTab = "redirect:/reg/client/yr/ent/forguarantee/show";}

        attr.addAttribute("year",encodeYear);
        return urlTab;
    }


    /** Tab 显示模板
     * @author wangjin
     * @return
     * @throws Exception
     */
/*    @RequestMapping("/tab_template")
    public ModelAndView tab_template(HttpSession session,String pripid,String year,String tabName)throws Exception{
        ModelAndView view = new ModelAndView();

        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码

        //查询年报主表信息
        //YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));

        //获取企业报表配置 (已经存放至session中)
        //List<String> reportTypeList = RepTypeUtil.getReportTypeList(yrRegCheck.getEntTypeCatg(), yrRegCheck.getEntType());

        //获取表单填写的状态
        YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

        //view.addObject("reportTypeList", reportTypeList);
        //view.addObject("yrRegCheck",yrRegCheck);

        view.addObject("currentYear",year); //年份未进行加密的参数传递

        year = AESEUtil.encodeYear(year); //年份进行加密处理
        view.addObject("yrForm",yrForm);
        view.addObject("year",year);
        view.addObject("priPID",priPID);
        view.addObject("tabName",tabName);//获取当前是哪个填报表单
        view.setViewName("reg/client/yr/template/tab_template");
        return view;
    }*/


    /** View 显示模板
     * @author wangjin
     * @return
     * @throws Exception
     */
   /* @RequestMapping("/view_template")*/
/*    public ModelAndView view_template(HttpSession session,String pripid,String year)throws Exception{
        year = AESEUtil.encodeYear(year); //年份进行加密处理
        ModelAndView view = new ModelAndView();
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
        view.addObject("year",year);
        view.addObject("priPID",priPID);
        view.setViewName("reg/client/yr/template/view_template");
        return view;
    }*/



}


