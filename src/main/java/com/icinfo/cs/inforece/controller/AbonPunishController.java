/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.controller;


import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONParser;
import com.icinfo.cs.common.constant.RegStates;
import com.icinfo.cs.common.utils.ExcelUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/syn/anonpunish/anonpunish")
public class AbonPunishController extends BaseController {
    @Autowired
    IMidBaseInfoService midBaseInfoService;
    @Autowired
    NoCreditPunishInfoService noCreditPunishInfoService;

    /**
     * 进入异常名录页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/toabonList", method = RequestMethod.GET)
    public ModelAndView toabonList(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/syn/system/inforece/manabno/manabno_list");
        return mv;
    }

    /**
     * 进入联合惩戒页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/topunishList", method = RequestMethod.GET)
    public ModelAndView topunishList(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/syn/system/inforece/unionpunish/unionpunish_list");
        return mv;
    }

    /**
     * 进入照面信息页面
     *
     * @return
     * @throws Exception
     * @author liuhq
     */
    @RequestMapping(value = "/toedit", method = RequestMethod.GET)
    public ModelAndView toedit(String pripid, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/syn/system/inforece/manabno/manabno_edit");
        if (StringUtil.isEmpty(pripid) || "null".equals(pripid)) return mv;
        MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pripid);
        if(midBaseInfo!=null)
        midBaseInfo.setRegState(RegStates.getValue(midBaseInfo.getRegState()).getName());
        mv.addObject("midBaseInfo", midBaseInfo);
        return mv;
    }

    /**
     * 联合惩戒导出
     *
     * @param params
     * @return
     */
    @RequestMapping("/export")
    public ResponseEntity<byte[]> export(String pripids,String params) throws Exception {
//        JSONParser JSON = new JSONParser(params.replaceAll("&quot;", "\""));
//        Map<String, Object> param = JSON.parseMap();
        Map<String, Object> param = new HashMap<String, Object>();
        String fileName = "联合惩戒导出";

        String columnNames[] = {"getLitiName", "getUniCode"
        };//列名
        String header[] = {"名称/姓名", "证照号码/证件号码"};//map中的key
        PageRequest request = new PageRequest();
        pripids= "'"+pripids.replaceAll(",","','")+"'";
        param.put("pripids",pripids);
        List<NoCreditPunishInfoDto> dtos = this.noCreditPunishInfoService.selectAllFullInfoList(request, param);


        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            ExcelUtil.createWorkBook(fileName, dtos, header, columnNames).write(os);
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String((fileName + ".xls").getBytes("GBK"), "iso-8859-1") + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(os.toByteArray(),
                headers, HttpStatus.OK);

    }
}