/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.message.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.dto.CsMessageDto;
import com.icinfo.cs.message.dto.CsMessageRelDto;
import com.icinfo.cs.message.model.CsMessage;
import com.icinfo.cs.message.model.CsMessageRel;
import com.icinfo.cs.message.service.ICsMessageRelService;
import com.icinfo.cs.message.service.ICsMessageService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.cs.system.service.ISysDeliverInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_message 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
@Controller
@RequestMapping("/reg/message")
public class CsMessageController extends CSBaseController {

    @Autowired
    private ICsMessageService      csMessageService;

    @Autowired
    private ICsMessageRelService   csMessageRelService;

    @Autowired
    private IPubEppasswordService  pubEppasswordService;

    @Autowired
    private IEntSearchService      entSearchService;
    @Autowired
    private IMidBaseInfoService    midBaseInfoService;
    @Autowired
    private IErEscAppinfoService   erEscAppinfoService;

    // 联络员确认书送达地址
    @Autowired
    private ISysDeliverInfoService deliverInfoService;

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
     * 描述: 跳转至查看页面
     * @author 张文男
     * @date 2017年5月22日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageView")
    public String toMessageView() throws Exception{
        return "message/message_view";
    }

    /** 
     * 描述: 跳转至未年报查看页面
     * @author 张文男
     * @date 2017年6月9日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageUnreportView")
    public String toMessageUnreportView() throws Exception{
        return "message/message_unreport_view";
    }

    /** 
     * 描述: 跳转至已年报查看页面
     * @author 张文男
     * @date 2017年6月9日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageReportView")
    public String toMessageReportView() throws Exception{
        return "message/message_report_view";
    }

    /** 
     * 描述: 跳转至查看列表页面
     * @author 张文男
     * @date 2017年5月24日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageViewList")
    public ModelAndView toMessageViewList(String priPID) throws Exception{
        ModelAndView mav = new ModelAndView ("message/message_viewlist");
        MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid (priPID);
        List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate (priPID);
        if (midDtos != null && midDtos.size () > 0) {
            midBaseInfoDto.setPunishDate (midDtos.get (0).getPunishDate ());
        }

        mav.addObject ("dto", midBaseInfoDto);
        mav.addObject ("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID (priPID));
        return mav;
    }

    /** 
     * 描述: 跳转至消息列表
     * @author 张文男
     * @date 2017年5月18日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessagelist")
    public String toMessagelist() throws Exception{
        return "message/message_list";
    }

    /** 
     * 描述: 跳转至消息编辑
     * @author 张文男
     * @date 2017年5月18日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageEdit")
    public String toMessageEdit() throws Exception{
        return "message/message_edit";
    }

    /** 
     * 描述: 跳转至消息企业列表
     * @author 张文男
     * @date 2017年5月18日 
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMessageEntlist")
    public String toMessageEntlist() throws Exception{
        return "message/message_entlist";
    }

    @RequestMapping(value = "/queryPageListForEntarchives.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<SmBaseinfoDto> queryPageListForEntarchives(PageRequest request) throws Exception{
        creatDefaultDBAuthEnv (request, "sb.RegOrg", "sb.LocalAdm");
        // PageResponse<SmBaseinfoDto> list = smBaseinfoService.queryPageListForEntarchives(request);
        return null;
    }

    /** 
     * 描述: 根据联络员手机号判断是否存在，ture存在false不存在
     * @author 张文男
     * @date 2017年5月19日 
     * @param tel
     * @return 
     */

    @RequestMapping(value = "queryPubEppasswordIsExistByTel.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryPubEppasswordIsExistByTel(String tel){
        try {
            List<PubEppassword> list = pubEppasswordService.queryPubEppasswordListByTel (tel);
            boolean state = false;
            if (null != list && list.size () > 0) {
                state = true;
            }
            return AjaxResult.success ("操作成功！", state);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 根据联络电话获取最新3条企业名称数据
     * @author 张文男
     * @date 2017年5月19日 
     * @param tel
     * @return 
     */

    @RequestMapping(value = "queryEntNameFirst3ListByPubEppasswordTel.json",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult queryEntNameFirst3ListByPubEppasswordTel(String tel){
        try {
            List<String> entNamelist = pubEppasswordService.queryEntNameFirst3ListByPubEppasswordTel (tel);
            return AjaxResult.success ("操作成功！", entNamelist);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 根据联络员手机号获取对应消息分页列表
     * @author 张文男
     * @date 2017年5月22日 
     * @param liaisonManTel
     * @param pageNum
     * @param pageSize
     * @return 
     */

    @RequestMapping(value = "queryMessagePageListByLiaisonManTel.json",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult queryMessagePageListByLiaisonManTel(String liaisonManTel,Integer pageNum,Integer pageSize){
        try {
            PageResponse<CsMessage> list = csMessageService.queryMessagePageListByLiaisonManTel (liaisonManTel, pageNum, pageSize);
            return AjaxResult.success ("操作成功！", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年5月19日 
     * @param session
     * @param dto
     * @return 
     */

    @RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit
    public AjaxResult saveOrUpdate(CsMessageDto dto){
        try {
            PageRequest request = new PageRequest ();
            request.setParams (dto.getParamMap ());
            request.setLength (99999999);
            request.setPageNum (0);
            creatDefaultDBAuthEnv (request, "localAdm", "localAdm");

            csMessageService.saveOrUpdate (dto, request);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 获取消息分页列表 
     * @author 张文男
     * @date 2017年5月23日 
     * @param request
     * @return 
     */

    @RequestMapping(value = "queryMessagPageList.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsMessageRelDto> queryMessagPageList(PageRequest request){
        try {
            creatDefaultDBAuthEnv (request, "cmb.RegOrg", "cmb.LocalAdm");
            PageResponse<CsMessageRelDto> list = csMessageRelService.queryMessagPageList (request);
            return list;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    /** 
     * 描述: 获取消息分页列表根据企业id
     * @author 张文男
     * @date 2017年5月24日 
     * @param request
     * @return 
     */

    @RequestMapping(value = "queryMessagPageListByPriPID.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsMessageRelDto> queryMessagPageListByPriPID(PageRequest request){
        try {
            PageResponse<CsMessageRelDto> list = csMessageRelService.queryMessagPageListByPriPID (request);
            return list;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    /** 
     * 描述: 根据查询条件获取统计信息
     * @author 张文男
     * @date 2017年5月25日 
     * @param request
     * @return 
     */

    @RequestMapping(value = "queryMessageCount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryMessageCount(@RequestParam Map<String, Object> map){
        try {
            PageRequest page = new PageRequest ();
            page.setParams (map);
            creatDefaultDBAuthEnv (page, "cmb.RegOrg", "cmb.LocalAdm");
            CsMessageRelDto bean = csMessageRelService.queryMessageCount (map);
            return AjaxResult.success ("操作成功！", bean);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 根据msgUid获取消息详情
     * @author 张文男
     * @date 2017年5月24日 
     * @param msgUid
     * @return 
     */

    @RequestMapping(value = "querycsMessageByMsgUid.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult querycsMessageByMsgUid(String msgUid){
        try {
            CsMessageDto bean = csMessageService.queryCsMessageDtoByMsgUid (msgUid);
            return AjaxResult.success ("操作成功！", bean);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 获取消息分页列表根据消息ID
     * @author 张文男
     * @date 2017年5月24日 
     * @param request
     * @return 
     */

    @RequestMapping(value = "queryMessagPageListByMsgUid.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<CsMessageRel> queryMessagPageListByMsgUid(PageRequest request){
        try {
            PageResponse<CsMessageRel> list = csMessageRelService.queryMessagPageListByMsgUid (request);
            return list;
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    /** 
     * 描述: 获取消息列表根据消息ID
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @return 
     */

    @RequestMapping(value = "queryMessagListByMsgUid.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryMessagListByMsgUid(String msgUid){
        try {
            List<CsMessageRel> list = csMessageRelService.queryMessagListByMsgUid (msgUid);
            return AjaxResult.success ("操作成功！", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /** 
     * 描述: 导出excel
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @param response
     * @throws Exception 
     */

    @RequestMapping(value = "excelExportByMsgUid",method = RequestMethod.POST)
    @RepeatSubmit
    public void excelExportByMsgUid(@RequestParam String msgUid,HttpServletResponse response) throws Exception{
        response.setContentType ("application/vnd.ms-excel");
        response.setHeader ("Content-disposition", "attachment;filename=" + new String (("企业信息.xls").getBytes ("GB2312"),"ISO8859-1"));
        OutputStream ouputStream = response.getOutputStream ();
        csMessageRelService.excelExportByMsgUid (msgUid, ouputStream);
    }

    /** 
     * 描述: 根据消息id更新数据
     * @author 张文男
     * @date 2017年5月26日 
     * @param csMessage
     * @return 
     */

    @RequestMapping(value = "updateMessageByMsgUid.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateMessageByMsgUid(CsMessage csMessage){
        try {
            csMessageService.updateMessageByMsgUid (csMessage);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    @RequestMapping(value = "/diliverinfo",method = RequestMethod.GET)
    public ModelAndView selectDeliverList() throws Exception{
        ModelAndView view = new ModelAndView ("message/sysdiliver_list");
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("deliIsValid", "1");// 有效
        List<SysDeliverInfo> deliverList = deliverInfoService.selectDeliverInfoList (map);
        view.addObject ("deliverList", deliverList);
        return view;
    }

    /** 
     * 描述: 根据年份、是否年报、联络员手机获取企业名称分页列表
     * @author 张文男
     * @date 2017年6月9日 
     * @param request
     * @return
     * @throws Exception 
     */

    @RequestMapping(value = "/queryEntNamePageList.json",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<PubEppasswordDto> queryEntNamePageList(PageRequest request) throws Exception{
        PageResponse<PubEppasswordDto> list = pubEppasswordService.queryEntNamePageList (request);
        return list;
    }

    /** 
     * 描述: 根据年份、是否年报、联络员手机获取企业名称列表
     * @author 张文男
     * @date 2017年6月9日 
     * @param year
     * @param isreported
     * @param tel
     * @return
     * @throws Exception 
     */

    @RequestMapping(value = "/queryEntNameList.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryEntNameList(Integer year,String isreported,String tel) throws Exception{
       
        try {
            List<PubEppasswordDto> list = pubEppasswordService.queryEntNameList (year, isreported, tel);
            return AjaxResult.success ("操作成功！",list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
}