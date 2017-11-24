/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.rpt.rptdto.RptSmBaseinfoDto;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.sment.dto.EntarchivesDto;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;
import com.icinfo.cs.sment.model.EntarchivesAdjust;
import com.icinfo.cs.sment.model.EntarchivesHelp;
import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.cs.sment.service.IEntarchivesAdjustService;
import com.icinfo.cs.sment.service.IEntarchivesHelpService;
import com.icinfo.cs.sment.service.IEntarchivesOperateService;
import com.icinfo.cs.sment.service.IEntarchivesService;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.cs.sment.service.ISmEntAbovescaleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Controller
@RequestMapping("/sment/entarchives/")
public class EntarchivesController extends CSBaseController {

    @Autowired
    private IEntarchivesService entarchivesService;
//    @Autowired
//    private ISmBaseinfoService smBaseinfoService;
    @Autowired
    private IYrAssetService yrAssetService;
    @Autowired
    private IEntarchivesOperateService entarchivesOperateService;
    @Autowired
    private IEntarchivesHelpService entarchivesHelpService;
    @Autowired
    private IEntarchivesAdjustService entarchivesAdjustService;
	@Autowired
	private ISmEntAbovescaleService smEntAbovescaleService;
    
    
    
    
    /** 
     * 描述: 获取登录用户信息
     * @author 张文男
     * @date 2017年5月8日 
     * @param session
     * @return 
     */
    
    @RequestMapping(value = "queryLoginUserInfo.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryLoginUserInfo(HttpSession session){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            return AjaxResult.success ("操作成功！", sysUser);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /** 
     * 描述: 根据企业id获取对应调整记录
     * @author 张文男
     * @date 2017年5月8日 
     * @param session
     * @param priPID
     * @return 
     */
    
    @RequestMapping(value = "queryEntarchivesAdjustListByPriPID.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryEntarchivesAdjustListByPriPID(HttpSession session,String priPID){
        try {
            List<EntarchivesAdjust> list = entarchivesAdjustService.queryEntarchivesAdjustListBy (priPID);
            return AjaxResult.success ("操作成功！", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 根据企业id、年份获取对应数据
     * @author 张文男
     * @date 2017年5月8日 
     * @param session
     * @param priPID
     * @param year
     * @return 
     */
    
    @RequestMapping(value = "queryEntarchivesHelpListByByPriPIDAndYear.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryEntarchivesHelpListByByPriPIDAndYear(HttpSession session,String priPID,int year){
        try {
            List<EntarchivesHelp> list = entarchivesHelpService.queryEntarchivesHelpListBy (priPID, year);
            return AjaxResult.success ("操作成功！", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 根据企业id、年份获取对应数据
     * @author 张文男
     * @date 2017年5月8日 
     * @param session
     * @param priPID
     * @param year
     * @return 
     */
    
    @RequestMapping(value = "queryEntarchivesOperateByPriPIDAndYear.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryEntarchivesOperateByPriPIDAndYear(HttpSession session,String priPID,int year){
        try {
            EntarchivesOperate data =  entarchivesOperateService.queryEntarchivesOperateBy (priPID, year);
            return AjaxResult.success ("操作成功！", data);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 根据年份、企业id获取年报信息
     * @author 张文男
     * @date 2017年5月5日 
     * @param session
     * @param pripid
     * @param year
     * @return 
     */
    
    @RequestMapping(value = "queryYrAssetByPriPIDAndYear.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryYrAssetByPriPIDAndYear(HttpSession session,String pripid,Integer year){
        try {
            YrAsset data = yrAssetService.selectYrAssetByYearAndPripid (year, pripid);
            return AjaxResult.success ("操作成功！", data);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 跳转至企业列表页面
     * @author 张文男
     * @date 2017年5月2日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesEntlist")
    public String toEntarchivesEntlist() throws Exception{
        return "sment/entarchives/entarchives_entlist";
    }
    
    /** 
     * 描述: 跳转至培育库列表页面
     * @author 张文男
     * @date 2017年5月4日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesList")
    public String toEntarchivesList() throws Exception{
        return "sment/entarchives/entarchives_list";
    }
    
    
    /** 
     * 描述: 跳转至企业批量新增页面
     * @author 张文男
     * @date 2017年5月2日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesBatchAdd")
    public String toEntarchivesBatchAdd() throws Exception{
        return "sment/entarchives/entarchives_batch_add";
    }
    
    /** 
     * 描述: 跳转至企业编辑页面
     * @author 张文男
     * @date 2017年5月2日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesEdit")
    public String toEntarchivesEdit() throws Exception{
        return "sment/entarchives/entarchives_edit";
    }
    
    
    /** 
     * 描述: 跳转至企业查看页面
     * @author 张文男
     * @date 2017年5月9日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesView")
    public String toEntarchivesView() throws Exception{
        return "sment/entarchives/entarchives_view";
    }
    
    /** 
     * 描述: 跳转至企业跟踪页面
     * @author 张文男
     * @date 2017年5月9日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesFollow")
    public String toEntarchivesFollow() throws Exception{
        return "sment/entarchives/entarchives_follow";
    }
    
    
    /** 
     * 描述: 跳转至企业移除页面
     * @author 张文男
     * @date 2017年5月5日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesRemove")
    public String toEntarchivesRemove() throws Exception{
        return "sment/entarchives/entarchives_remove";
    }
    
    /** 
     * 描述: 跳转至企业帮扶页面
     * @author 张文男
     * @date 2017年5月3日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesHelpEdit")
    public String toEntarchivesHelpEdit() throws Exception{
        return "sment/entarchives/entarchives_help_edit";
    }
    
    /** 
     * 描述: 跳转至企业帮扶页面
     * @author 张文男
     * @date 2017年5月5日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesHelpTypeTree")
    public String toEntarchivesHelpTypeTree() throws Exception{
        return "sment/entarchives/entarchives_helptype_tree";
    }
    
    /** 
     * 描述: 跳转至企业区域树页面
     * @author 张文男
     * @date 2017年5月5日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesAreaTree")
    public String toEntarchivesAreaTree() throws Exception{
        return "sment/entarchives/entarchives_area_tree";
    }
    
    /** 
     * 描述: 跳转至企业区域树-一级页面
     * @author 张文男
     * @date 2017年5月8日 
     * @return
     * @throws Exception 
     */
    
    @RequestMapping("toEntarchivesAreaSingleTree")
    public String toEntarchivesAreaSingleTree() throws Exception{
        return "sment/entarchives/entarchives_area_singletree";
    }
    
    
    /** 
     * 描述: 添加修改培育库
     * @author 张文男
     * @date 2017年5月5日 
     * @param session
     * @param bean
     * @return 
     */
    
    @RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult saveOrUpdate(HttpSession session,EntarchivesDto bean){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            entarchivesService.saveOrUpdate (bean,sysUser);
            // 警示协同的地址 默认警示
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 添加修改培育库-帮扶信息
     * @author 张文男
     * @date 2017年5月11日 
     * @param session
     * @param bean
     * @return 
     */
    
    @RequestMapping(value = "saveOrUpdateForHelp",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult saveOrUpdateForHelp(HttpSession session,EntarchivesDto bean){
        try {
            // 警示协同的地址 默认警示
            entarchivesService.saveOrUpdateForHelp (bean, true);
            // 警示协同的地址 默认警示
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /** 
     * 描述: 移除培育库
     * @author 张文男
     * @date 2017年5月5日 
     * @param session
     * @param bean
     * @return 
     */
    
    @RequestMapping(value = "remove",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult remove(HttpSession session,EntarchivesAdjust bean){
        try {
            entarchivesService.remove (bean);
            // 警示协同的地址 默认警示
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
    /** 
     * 描述: 根据priPID获取信息
     * @author 张文男
     * @date 2017年5月5日 
     * @param session
     * @param uid
     * @return 
     */
    
    @RequestMapping(value = "queryByPriPID.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryByPriPID(HttpSession session,String priPID,String isAdd){
        try {
            EntarchivesDto data = entarchivesService.queryEntarchivesDtoByPriPID (priPID);
            if(StringUtils.isNotBlank(isAdd) && "true".equalsIgnoreCase(isAdd)){ // 新增
                if(null == data){
                    data = new EntarchivesDto ();
                    data.setPriPID (priPID);
                }
            	// 初始化 负责人和联络员等信息
            	data = entarchivesService.initEntarchivesDto(data);
            }
            return AjaxResult.success ("操作成功！",data);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    @RequestMapping(value = "count.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult count(HttpSession session,String cultivationTypeCode){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            int count = entarchivesService.count (sysUser, cultivationTypeCode);
           
            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 描述: 统计帮扶信息
     * @author 张文男
     * @date 2017年6月20日
     * @param session
     * @param helpState
     * @return
     */

    @RequestMapping(value = "countByHelp.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countByHelp(PageRequest request){
        try {
            SysUserDto sysUser = new SysUserDto();
            creatDefaultDBAuthEnv(request, "sb.RegOrg", "sb.LocalAdm");
            int count = entarchivesService.countByHelp (sysUser, request);

            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }


    /**
     *@Description 前往首页帮扶信息列表
     *@author ylr
     *@date 2017-11-16
     */
    @RequestMapping("toWelcomeHelpList")
    public ModelAndView  toWelcomeHelpList(String helpState)throws Exception{
        ModelAndView mv = new ModelAndView("/sment/entarchives/welcome_help_list");
        mv.addObject("helpState",helpState);
        return mv;
    }

    /**
     *@Description 前往首页提醒事项列表
     *@author ylr
     *@date 2017-11-17
     */
    @RequestMapping("toWelcomeTxsxList")
    public ModelAndView  toWelcomeTxsxList(String state)throws Exception{
        ModelAndView mv = new ModelAndView("/sment/entarchives/welcome_txsx_list");
        mv.addObject("state",state);
        return mv;
    }

//    /**
//     *@Description 首页帮扶信息列表展示
//     *@author ylr
//     *@date 2017-11-16
//     */
//    @RequestMapping(value = "selectHelpPageList.json",method = RequestMethod.POST)
//    @ResponseBody
//    public PageResponse<RptSmBaseinfoDto> selectHelpPageList(HttpSession session, PageRequest request){
//        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
//        List<RptSmBaseinfoDto> list = entarchivesService.selectHelpPageList(request,sysUser);
//        return new PageResponse<RptSmBaseinfoDto>(list);
//    }


    /**
     * 描述: 统计入库企业违法违规数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param session
     * @param helpState
     * @return 
     */
    
    @RequestMapping(value = "countWfwgBySetDeptCode.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countWfwgBySetDeptCode(HttpSession session,String helpState){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Long count = entarchivesService.countWfwgBySetDeptCode (sysUser);
           
            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述:  统计入库企业经营异常数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param session
     * @param helpState
     * @return 
     */
    
    @RequestMapping(value = "countJyycBySetDeptCode.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countJyycBySetDeptCode(HttpSession session,String helpState){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Long count = entarchivesService.countJyycBySetDeptCode (sysUser);
           
            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /** 
     * 描述: 统计入库企业上规升级数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param session
     * @param helpState
     * @return 
     */
    
//    @RequestMapping(value = "countSgsjBySetDeptCode.json",method = RequestMethod.POST)
//    @ResponseBody
//    public AjaxResult countSgsjBySetDeptCode(HttpSession session,String helpState){
//        try {
//            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
//            Long count = entarchivesService.countSgsjBySetDeptCode (sysUser);
//           
//            return AjaxResult.success ("操作成功！",count);
//        } catch (Exception e) {
//            e.printStackTrace ();
//        }
//        return AjaxResult.error ("操作失败！");
//    }  
    
    /** 
     * 描述: 统计入库企业经营下降20%数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param session
     * @param helpState
     * @return 
     */
    
    @RequestMapping(value = "countJyxjBySetDeptCode.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countJyxjBySetDeptCode(HttpSession session,String helpState){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Long count = entarchivesService.countJyxjBySetDeptCode (sysUser);
           
            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 首页可视化--培育库统计
     * 完成培育动态统计--培育库企业
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param session
     * @param operateType
     * @return
     */
    @RequestMapping(value = "chartcount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult chartcount(HttpSession session,String operateType){
        try {
//            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Map<String, Object> map = new HashMap<String, Object>();
            EntarchivesDto entarchivesDto = new EntarchivesDto();
            
            if(operateType != null && "1".equals(operateType)){ //企业类型
                entarchivesDto = entarchivesService.cultivationTypeScount(map);
            }else if(operateType != null && "2".equals(operateType)){//区域分类
                entarchivesDto = entarchivesService.qyflCount(map);
            }else if(operateType != null && "3".equals(operateType)){
                entarchivesDto = entarchivesService.industryTypeCount(map);
            }else if(operateType != null && "4".equals(operateType)){
                entarchivesDto = entarchivesService.entCrowdCodeCount(map);
            }
            return AjaxResult.success ("操作成功",entarchivesDto);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 培育库企业成长轨迹（营业总收入）
     * @auther gaojinling
     * @date 2017年8月16日 
     * @param session
     * @param operateType
     * @return
     */
    @RequestMapping(value = "vendIncCount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult vendIncCount(HttpSession session,String operateType){
        try {
//            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Map<String, Object> map = new HashMap<String, Object>();
            List<EntarchivesDto> entarchivesDtos = entarchivesService.vendIncCount(map);
            List<String> years = new ArrayList<String>();
            List<BigDecimal> vendIncs = new ArrayList<BigDecimal>();
            List<BigDecimal> proGros = new ArrayList<BigDecimal>();
            List<BigDecimal> ratGros = new ArrayList<BigDecimal>();
            for(EntarchivesDto entarchivesDto :entarchivesDtos){
            	years.add(entarchivesDto.getYear()+"年");
            	vendIncs.add(entarchivesDto.getVendInc());
            	proGros.add(entarchivesDto.getProGro());
            	ratGros.add(entarchivesDto.getRatGro());
            }
            JSONObject obj = new JSONObject();
//            JSONObject.toJSON(dataList)
            obj.put("years", years);
            obj.put("vendIncs", vendIncs);
            obj.put("proGros", proGros);
            obj.put("ratGros", ratGros);
            return AjaxResult.success ("操作成功",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 限上规上企业成长轨迹
     * @auther gaojinling
     * @date 2017年8月16日 
     * @param session
     * @param operateType
     * @return
     */
    @RequestMapping(value = "smEntAbovescaleCount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult smEntAbovescaleCount(HttpSession session,String type){
        try {
//            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", type);
            List<SmEntAbovescaleDto> abovescaleDtos = smEntAbovescaleService.smEntAbovescaleCount(map);
            List<String> years = new ArrayList<String>();
            List<BigDecimal> abovescale1s = new ArrayList<BigDecimal>();
            List<BigDecimal> abovescale2s = new ArrayList<BigDecimal>();
            List<BigDecimal> abovescale3s = new ArrayList<BigDecimal>();
            for(SmEntAbovescaleDto abovescaleDto :abovescaleDtos){
            	years.add(abovescaleDto.getYear()+"年");
            	abovescale1s.add(abovescaleDto.getAboveType1());
            	abovescale2s.add(abovescaleDto.getAboveType2());
            	abovescale3s.add(abovescaleDto.getAboveType3());
            }
            JSONObject obj = new JSONObject();
            obj.put("years", years);
            obj.put("abovescale1s", abovescale1s);
            obj.put("abovescale2s", abovescale2s);
            obj.put("abovescale3s", abovescale3s);
            return AjaxResult.success ("操作成功",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
  
    /**
     *   
     * 描述: 首页可视化统计（固定数据部分 小微企业总数 规上、限上企业户数 动产抵押企业 国家商标）
     * @auther gaojinling
     * @date 2017年8月17日 
     * @param session
     * @param helpState
     * @return
     */
    @RequestMapping(value = "countgd.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countgd(HttpSession session) throws Exception{
    	Map<String, Object> map = new HashMap<String, Object>();
        try {
            JSONObject obj = new JSONObject();
            //规上、限上企业户数
            int entAbovescalecount = smEntAbovescaleService.smEntAbovescaleTotal(map);
            //动产抵押企业户数
            int mortRegInfocount = smEntAbovescaleService.mortRegInfoTotal(map);
            //国家商标个数
            int tmDetailInfocount = smEntAbovescaleService.tmDetailInfoTotal(map);
            obj.put("entAbovescalecount", entAbovescalecount);
            obj.put("mortRegInfocount", mortRegInfocount);
            obj.put("tmDetailInfocount", tmDetailInfocount);
            return AjaxResult.success ("操作成功！",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
   
    
    
    
}