/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.SfcCominfo;
import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.service.ISfcCominfoService;
import com.icinfo.cs.yr.service.ISfcFormService;
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
 * 描述:  cs_sfc_cominfo  综合信息表 对应的Controller类.<br>
 *
 * @author framework generator  WANGJIN
 * @date 2016年10月19日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/cominfo")
public class SfcCominfoController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcCominfoController.class);

    @Autowired
    private ISfcCominfoService sfcCominfoService;

    @Autowired
    private IYrRegCheckService yrRegCheckService;

    @Autowired
    private IYrSfcBaseinfoService yrSfcBaseinfoService;
    //农专报表状态
    @Autowired
    private ISfcFormService sfcFormService;



    /** 编辑对话框   综合信息表
     * @author: wangjin
     * @param year
     * @param session
     * @return
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, HttpSession session) throws Exception {

        ModelAndView view = new ModelAndView("reg/client/yr/auxtab/cominfo_edit");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
        if(StringUtil.checkYearAndPripid(year,priPID)) {
            String encodeYear = year;          //接收加密年份
            year = AESEUtil.decodeYear(year); //年份解密处理
            view.addObject("sfcCominfo", sfcCominfoService.selectByYearAndPripid(Integer.parseInt(year), priPID));

            //查询农专的基本信息
            YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID, "0");
            if (yrSfcBaseinfo != null) {
                BigDecimal vendInc = yrSfcBaseinfo.getVendInc() == null ? null : yrSfcBaseinfo.getVendInc().setScale(4, BigDecimal.ROUND_HALF_UP);//销售额或营业收入
                BigDecimal ratGro = yrSfcBaseinfo.getRatGro() == null ? null : yrSfcBaseinfo.getRatGro().setScale(4, BigDecimal.ROUND_HALF_UP);//纳税金额
                view.addObject("vendInc", vendInc);
                view.addObject("ratGro", ratGro);
            }
            //查询农专填报状态表
            SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(priPID, Integer.valueOf(year));

            //查询年报主表信息
            YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));

            view.addObject("yrRegCheck", yrRegCheck);//年报主表信息*/
            view.addObject("tabName", "cominfo");// 综合信息表
            view.addObject("sfcForm", sfcForm);
            view.addObject("encodeYear", encodeYear);  //年份进行加密
            view.addObject("year", year);
            view.addObject("priPID", priPID);
            view.addObject("yrSfcBaseinfo", yrSfcBaseinfo);
        }
        return view;

    }


    /**
     * 保存和更新操作
     * @autor:  wangjin
     * @param sfcCominfo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save( SfcCominfo sfcCominfo) throws Exception {
        if (StringUtil.checkYearAndPripid(sfcCominfo.getYear(), sfcCominfo.getPriPID())) {
            if (sfcCominfo.getId()!=null) {
                if (sfcCominfoService.update(sfcCominfo) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
                    return AjaxResult.success("更新成功!");
                }
            }
            if (sfcCominfoService.insert(sfcCominfo) > 0) {
                SfcForm sfcForm = sfcFormService.selectSfcFormByPripidAndYear(sfcCominfo.getPriPID(), Integer.valueOf(sfcCominfo.getYear()));
                if (sfcForm != null) {
                    sfcForm.setCominfo("1");//已填报
                    sfcFormService.updateForm(sfcForm);
                }
                return AjaxResult.success("保存成功!");
            }
            return AjaxResult.error("执行失败!");
        }
        return AjaxResult.error("参数为空,执行失败!");
    }

}