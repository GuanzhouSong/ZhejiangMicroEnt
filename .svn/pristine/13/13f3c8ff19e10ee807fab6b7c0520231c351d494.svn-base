/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import com.icinfo.cs.base.service.impl.CodeRegunitServiceImpl;
import com.icinfo.cs.base.service.impl.CodeSlicenoServiceImpl;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStates;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.registinfo.dto.UnlicensedInfoDto;
import com.icinfo.cs.registinfo.model.*;
import com.icinfo.cs.registinfo.service.impl.RegistInfoServiceImpl;
import com.icinfo.cs.registinfo.service.impl.RegistUnlicensedServiceImpl;
import com.icinfo.cs.registinfo.service.impl.UlRecordServiceImpl;
import com.icinfo.cs.registinfo.service.impl.UnlicensedInfoServiceImpl;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_unlicensed_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/registinfo/unlicensedinfo/")
public class UnlicensedInfoController extends CSBaseController {

    @Autowired
    UnlicensedInfoServiceImpl unlicensedInfoService;
    @Autowired
    CodeSlicenoServiceImpl codeSlicenoService;
    @Autowired
    CodeRegunitServiceImpl codeRegunitService;
    @Autowired
    RegistInfoServiceImpl registInfoService;
    @Autowired
    RegistUnlicensedServiceImpl registUnlicensedService;
    @Autowired
    UlRecordServiceImpl ulRecordService;

    @Autowired
    IPanoramaSearchService panoramaSearchService;
    /**
     * 跳转到无证无照库查询列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toUnllicensedQryList")
    public ModelAndView toUnllicensedQryList(UnlicensedInfoDto UnlicensedInfoDto) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        return  new ModelAndView("reg/server/registinfo/unlicensedqry_list",data);
    }
    /**
     * 跳转经济户口销户记录列表页面
     * @return ModelAndView
     *
     */
    @RequestMapping("toLogoffList")
    public ModelAndView toModiList() throws Exception{
        Map<String,Object> data = new HashMap<String,Object>();

        return  new ModelAndView("reg/server/registinfo/logoff_list",data);
    }

    /**
     * 获取查询企业列表
     *
     * @author zhuyong
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/panoQueryPage" })
    @ResponseBody
    public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
        creatDefaultDBAuthEnv(request,"CheckDep","LocalAdm");
        Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
        return new PageResponse<PanoramaResultDto>(data);
    }
    /**
     * 跳转到无证无照库建档页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toUnllicensedShow")
    public ModelAndView toUnllicensedShow(UnlicensedInfoDto UnlicensedInfoDto,HttpSession session) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //无证无照记录
        UnlicensedInfoDto unlicensedInfoDto = unlicensedInfoService.getUnlicensedInfoByUid(UnlicensedInfoDto.getUID(),session);
        //管辖单位
        List codeRegUnitList = codeRegunitService.selectAll();
        //片区商圈
        List codeSlicenoList = codeSlicenoService.selectAll();

        //市县区街道 // TODO: 2016/9/27

        data.put("unlicensedInfoDto",unlicensedInfoDto);
        data.put("codeRegUnitList",codeRegUnitList);
        data.put("codeSlicenoList",codeSlicenoList);
        return  new ModelAndView("reg/server/registinfo/unlicensedregist_edit",data);
    }

    /**
     * 跳转到无照建档---处理记录--编辑页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toManageShow")
    public ModelAndView toManageShow(String disposeWayShow,String id, String uid, String priPid, HttpSession session) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //无证无照处理记录
        if(StringUtil.isNotEmpty(id)&&!id.equals("undefined")&&!id.equals("null")){
            UlManage ulManage = unlicensedInfoService.getUlManageByid(id);
            data.put("unmanageDto",ulManage);
        }else{
            SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
            UlManage ulManage = new UlManage();
            ulManage.setUID(uid);
            ulManage.setPriPID(priPid);
            ulManage.setDisposeName(sysUser.getUsername());
            ulManage.setDisposeDate(new Date());
            data.put("unmanageDto",ulManage);
        }
        data.put("disposeWayShow",disposeWayShow);
        return  new ModelAndView("reg/server/registinfo/unmanage_edit",data);
    }
    /**
     * 跳转到销户编辑页面 --从户口建档页面过来
     * @return
     * @throws Exception
     */
    @RequestMapping("toLogoffShow")
    public ModelAndView toLogoffShow(String uid, String priPid, HttpSession session) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //企业基本信息
        MidBaseInfoDto midBaseInfoDto = registInfoService.selectMidBaseInfoByPripid(priPid);
        midBaseInfoDto.setRegState(RegStates.getName(midBaseInfoDto.getRegState()));
        //无照库信息
        UnlicensedInfoDto unlicensedInfoDto = unlicensedInfoService.getUnlicensedInfoByUid(uid,session);
        //监管项目
        RegistUnlicensed registUnlicensed = registUnlicensedService.getSupersiveByPriPID(priPid);
        //许可证名称
        UlRecord ulRecord = ulRecordService.getUlRecordByPriPID(priPid);
        data.put("ulRecord",ulRecord);
        data.put("unlicensedInfoDto",unlicensedInfoDto);
        data.put("midBaseInfoDto",midBaseInfoDto);
        data.put("registUnlicensed",registUnlicensed);
        SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
        data.put("loginrealname",sysUser.getRealName());
        data.put("now",new Date());

        return  new ModelAndView("reg/server/registinfo/logoff_edit",data);
    }

    /**
     * 跳转到无照建档---发现记录--编辑页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toFindShow")
    public ModelAndView toFindShow(String id,String uid,String priPid, HttpSession session ) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //无证无照处理记录
        if(StringUtil.isNotEmpty(id)){
            UlFind ulFind = unlicensedInfoService.getUlFindByid(id);
            data.put("unfindDto",ulFind);
        }else{
            SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
            UlFind ulFind = new UlFind();
            ulFind.setUID(uid);
            ulFind.setPriPID(priPid);
            ulFind.setFindName(sysUser.getUsername());
            ulFind.setFindDate(new Date());
            data.put("unfindDto",ulFind);
        }
        return  new ModelAndView("reg/server/registinfo/unfind_edit",data);
    }
    /**
     * 跳转到无照建档---无证记录--编辑页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toRecordShow")
    public ModelAndView toRecordShow(String id,String uid,String priPid) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //无证无照处理记录
        if(StringUtil.isNotEmpty(id)){
            UlRecord ulRecord = unlicensedInfoService.getUlRecordByid(id);
            data.put("unrecordDto",ulRecord);
        }else{
            UlRecord ulRecord = new UlRecord();
            ulRecord.setUID(uid);
            ulRecord.setPriPID(priPid);
            data.put("unrecordDto",ulRecord);
        }
        return  new ModelAndView("reg/server/registinfo/unrecord_edit",data);
    }
    /**
     * 跳转到无证无照库监管列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping("toUnllicensedSuperviseList")
    public ModelAndView toUnllicensedSuperviseList(UnlicensedInfoDto UnlicensedInfoDto) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        //管辖单位
        List codeRegUnitList = codeRegunitService.selectAll();
        //片区商圈
        List codeSlicenoList = codeSlicenoService.selectAll();
        data.put("codeRegUnitList",codeRegUnitList);
        data.put("codeSlicenoList",codeSlicenoList);
        return  new ModelAndView("reg/server/registinfo/unlicensedsupervise_list",data);
    }
    //-------------------------------------------------逻辑操作方法--------------------------------------
    /**
     * 请求建档编辑页面的无证无照信息库表格数据
     * -- 无证无照list
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<UnlicensedInfo> list(PageRequest request) throws Exception {
        List<UnlicensedInfo> data = unlicensedInfoService.unlicensedInfoQueryPage(request);
        return new PageResponse<UnlicensedInfo>(data);
    }
    /**
     * 请求户口建档编辑页面的无证无照信息库表格数据
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/listForLogoff.json")
    @ResponseBody
    public PageResponse<UnlicensedInfo> listForLogoff(PageRequest request) throws Exception {
        if(request.getParams()==null){
            Map param = new HashMap();
            param.put("unlicState","1");//未销户
            request.setParams(param);
        }else{
            request.getParams().put("unlicState","1");//未销户
        }
        List<UnlicensedInfo> data = unlicensedInfoService.unlicensedInfoQueryPage(request);
        return new PageResponse<UnlicensedInfo>(data);
    }
    /**
     * 经济户口 销户记录list
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/listYetLogoff.json")
    @ResponseBody
    public PageResponse<MidBaseInfoDto> listYetLogoff(PageRequest request)   throws Exception{
            List<MidBaseInfoDto> data = unlicensedInfoService.yetLogoffQueryPage(request);
            return new PageResponse<MidBaseInfoDto>(data);

    }

    @RequestMapping(value="/unlicensedRegist", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult unlicensedRegist(@RequestBody UnlicensedInfoDto unlicensedInfoDto) throws Exception {
        int res = unlicensedInfoService.doModiUnlicensedInfo(unlicensedInfoDto);
        if(res<1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }
    @RequestMapping(value="/getMidBaseinfoByregNO", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getMidBaseinfoByregNO(String regNO) throws Exception {
        regNO = regNO.substring(0,regNO.indexOf("?"));
        if (StringUtil.isEmpty(regNO)) {
            return AjaxResult.error("操作失败！");
        }
        UnlicensedInfoDto unlicensedInfoDto = unlicensedInfoService.getMidBaseinfoByregNO(regNO);
        if(unlicensedInfoDto==null)
            return AjaxResult.success("操作成功!",new UnlicensedInfoDto());
        else
        return AjaxResult.success("操作成功!",unlicensedInfoDto);
    }


    @RequestMapping(value="manageModi", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult manageModi(@RequestBody UlManage ulManage) throws Exception {
        int res = unlicensedInfoService.doModiUlManageInfo(ulManage);
        if(res<1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }


    @RequestMapping(value="findModi", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult findModi(@RequestBody UlFind ulFind) throws Exception {
        int res = unlicensedInfoService.doModiUlFindById(ulFind);
        if(res<1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }
    @RequestMapping(value="recordModi", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult recordModi(@RequestBody UlRecord ulRecord) throws Exception {
        int res = unlicensedInfoService.doModiUlRecordById(ulRecord);
        if(res<1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }
}