/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.dto.SfcBalanctsheetDto;
import com.icinfo.cs.yr.model.SfcBalanctsheet;
import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.ISfcBalanctsheetService;
import com.icinfo.cs.yr.service.ISfcFormService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;



/**
 * 描述:  cs_sfc_balanctsheet  资产负债 对应的Controller类.<br>
 *
 * @author framework generator wangjin
 * @date 2016年10月23日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/balanctsheet")
public class SfcBalanctsheetController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcBalanctsheetController.class);

    @Autowired
    private ISfcBalanctsheetService sfcBalanctsheetService;
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    //农专报表状态
    @Autowired
    private ISfcFormService sfcFormService;


    /**
     * 编辑对话框  资产负债
     * @param year
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, HttpSession session) throws Exception{

        ModelAndView view = new ModelAndView("reg/client/yr/auxtab/balanctsheet_edit");
        //获取session的企业基本信息
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        String priPID = midBaseInfoDto.getPriPID();
        //判断参数值
        if(StringUtil.checkYearAndPripid(year,priPID)) {

            String encodeYear = year;          //接收加密年份
            year = AESEUtil.decodeYear(year); //年份解密处理

            List<SfcBalanctsheet> sfcBalanctsheetList = sfcBalanctsheetService.selectByYearAndPripid(Integer.parseInt(year), priPID);
            //获取上一年的数据
            List<SfcBalanctsheet> lastYearList = sfcBalanctsheetService.selectByYearAndPripid(Integer.parseInt(year) - 1, priPID);
            if (lastYearList.size() > 0) {
                if (lastYearList.get(1) != null) {
                    view.addObject("lastYearData", lastYearList.get(1)); //获取上一年 年末数据
                }
            } else {
                view.addObject("lastYearData", null); //获取上一年 年末数据
            }
            //查询农专填报状态表
            SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(priPID, Integer.valueOf(year));

            //查询年报主表信息
            YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));

            view.addObject("yrRegCheck", yrRegCheck);//年报主表信息*/
            view.addObject("tabName", "balanctsheet");// 资产负债
            view.addObject("sfcForm", sfcForm);
            view.addObject("encodeYear", encodeYear);  //年份进行加密
            view.addObject("year", year);
            view.addObject("priPID", priPID);
            view.addObject("sfcBalanctsheetList", sfcBalanctsheetList);

        }
        return view;
    }

    /**
     * 保存或更新操作
     * @author: wangjin
     * @param sfcBalanctsheetDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save(SfcBalanctsheetDto sfcBalanctsheetDto)throws  Exception{

        List<SfcBalanctsheet> sfcBalanctsheetList = sfcBalanctsheetDto.getSfcBalanctsheetList();

        if(sfcBalanctsheetList.size()!=2)return  AjaxResult.error("保存失败");

        Integer year1 = sfcBalanctsheetList.get(0).getYear();
        String pripid1 = sfcBalanctsheetList.get(0).getPriPID();
        Integer year2 = sfcBalanctsheetList.get(1).getYear();
        String pripid2 = sfcBalanctsheetList.get(1).getPriPID();

        if(StringUtil.checkYearAndPripid(year1,pripid1)&&StringUtil.checkYearAndPripid(year2,pripid2)) {
            if (CollectionUtils.isNotEmpty(sfcBalanctsheetList)) {
                if (sfcBalanctsheetList.get(0).getId()!=null&&sfcBalanctsheetList.get(1).getId()!=null) {
                    if (sfcBalanctsheetService.update(sfcBalanctsheetList) > 0) { // 更新
                        return AjaxResult.success("更新成功");
                    }
                }
                if (sfcBalanctsheetService.insert(sfcBalanctsheetList) > 0) { //添加
                    SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(sfcBalanctsheetList.get(0).getPriPID(), Integer.valueOf(sfcBalanctsheetList.get(0).getYear()));
                    if (sfcForm != null) {
                        sfcForm.setBalanctsheet("1");//已填报
                        sfcFormService.updateForm(sfcForm);
                    }
                    return AjaxResult.success("保存成功");
                }
            }
        }else {
            return AjaxResult.error("参数为空,执行失败");
        }
        return AjaxResult.error("保存失败");
    }

}