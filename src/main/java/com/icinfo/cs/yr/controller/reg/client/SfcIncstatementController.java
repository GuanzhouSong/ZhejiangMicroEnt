/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.cs.yr.model.SfcIncstatement;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.service.ISfcFormService;
import com.icinfo.cs.yr.service.ISfcIncstatementService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.core.web.annotation.Token;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * 描述:  cs_sfc_incstatement 盈余及分配  对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月23日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/incstatement")
public class SfcIncstatementController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcIncstatementController.class);

    @Autowired
    private ISfcIncstatementService sfcIncstatementService;
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    @Autowired
    private IYrSfcBaseinfoService yrSfcBaseinfoService;
    //农专报表状态
    @Autowired
    private ISfcFormService sfcFormService;




    /** 编辑对话框  盈余及分配
     * @author: wangjin
     * @param year
     * @param session
     * @return
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, HttpSession session) throws Exception {
        ModelAndView view = new ModelAndView("reg/client/yr/auxtab/incstatement_edit");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
        //参数判断
        if(StringUtil.checkYearAndPripid(year,priPID)) {
            String encodeYear = year;          //接收加密年份
            year = AESEUtil.decodeYear(year); //年份解密处理

            //查询农专的基本信息
            YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID, "0");
            if (yrSfcBaseinfo != null) {
                //万元 转换成 元
                BigDecimal priYeaProfit = yrSfcBaseinfo.getPriYeaProfit() == null ? null : yrSfcBaseinfo.getPriYeaProfit().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);//盈余总额
                view.addObject("priYeaProfit", priYeaProfit);
            }

            //查询农专填报状态表
            SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(priPID, Integer.valueOf(year));

            //查询年报主表信息
            YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));

            view.addObject("yrRegCheck", yrRegCheck);//年报主表信息*/
            view.addObject("tabName", "incstatement");// 盈余及分配
            view.addObject("sfcForm", sfcForm);
            view.addObject("encodeYear", encodeYear);  //年份进行加密
            view.addObject("year", year);
            view.addObject("priPID", priPID);
            view.addObject("sfcIncstatement", sfcIncstatementService.selectByYearAndPripid(Integer.parseInt(year), priPID));
        }

        return view;

    }

    /**
     * 保存和更新操作
     * @autor:  wangjin
     * @param sfcIncstatement
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save(SfcIncstatement sfcIncstatement) throws Exception {
        if(StringUtil.checkYearAndPripid(sfcIncstatement.getYear(),sfcIncstatement.getPriPID())) {
            if (sfcIncstatement.getId()!=null) {
                if (sfcIncstatementService.update(sfcIncstatement) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
                    return AjaxResult.success("更新成功");
                } else {
                    return AjaxResult.error("更新失败");
                }
            }
            if (sfcIncstatementService.insert(sfcIncstatement) > 0) {
                SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(sfcIncstatement.getPriPID(), Integer.valueOf(sfcIncstatement.getYear()));
                if (sfcForm != null) {
                    sfcForm.setIncstatement("1");//已填报
                    sfcFormService.updateForm(sfcForm);
                }
                return AjaxResult.success("保存成功");
            } else {
                return AjaxResult.error("保存失败");
            }
        }
        return AjaxResult.error("参数为空,执行失败");
    }

}