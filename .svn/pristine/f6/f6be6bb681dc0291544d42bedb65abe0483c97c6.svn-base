/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inspect.controller.reg.server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.inspect.dto.ReportCheckInfoDto;
import com.icinfo.cs.inspect.model.ReportCheckCode;
import com.icinfo.cs.inspect.model.ReportCheckInfo;
import com.icinfo.cs.inspect.model.ReportCheckItem;
import com.icinfo.cs.inspect.model.ReportCheckResult;
import com.icinfo.cs.inspect.service.IReportCheckInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  cs_report_check_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年01月17日
 */
@Controller
@RequestMapping("/reg/server/inspect/")
public class ReportCheckInfoController extends CSBaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ReportCheckInfoController.class);

    @Autowired
    private IReportCheckInfoService reportCheckInfoService;
    @Autowired
    private IMidBaseInfoService iMidBaseInfoService;
    @Autowired
    private IYrRegCheckService iYrRegCheckService;


    //-------------------------------------------------跳转页面方法--------------------------------------

    @RequestMapping("/toInspectInputList")
    public ModelAndView toInspectInputList() throws Exception {
        ModelAndView view = new ModelAndView("reg/server/inspect/inputinfo_list");
        view.addObject("yearList",DateUtil.getYearToNowForReport());
        return view;
    }

    @RequestMapping("/toInspectCheckList")
    public ModelAndView toInspectCheckList() throws Exception {
        ModelAndView view = new ModelAndView("reg/server/inspect/checkinfo_list");
        view.addObject("yearList",DateUtil.getYearToNowForReport());
        return view;
    }

    @RequestMapping("/toInspectViewList")
    public ModelAndView toInspectViewList() throws Exception {
        ModelAndView view = new ModelAndView("reg/server/inspect/viewinfo_list");
        view.addObject("yearList",DateUtil.getYearToNowForReport());
        view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
        return view;
    }

    /**
     * 详情展示
     * 1,fromtype
     * 录入：add
     * 审核不通过修改：backedit
     * 待审核修改：edit
     * 审核不通过详情：detail
     * 审核通过详情：detail
     *
     * @param year
     * @param uid
     * @param pripid
     * @param fromtype
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/toShow")
    public ModelAndView toShow(String year, String uid, String pripid, String fromtype, HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        ModelAndView view = new ModelAndView("reg/server/inspect/inspect_edit");
        MidBaseInfo midBaseInfo = iMidBaseInfoService.selectMidBaseInfoByPripid(pripid);
        //年报主表
//        YrRegCheck yrRegCheck = iYrRegCheckService.selectCheckInfoByPripidAndYear(pripid, Integer.parseInt(year));
        //获取所有的一般检查内容。
        List<ReportCheckCode> codes_com = reportCheckInfoService.getCodeListByEntType(midBaseInfo, "common", Integer.parseInt(year));
        //获取所有的重点检查内容。
        List<ReportCheckCode> codes_key = reportCheckInfoService.getCodeListByEntType(midBaseInfo, "key", Integer.parseInt(year));


        //获取所有的违反登记法律法规。
        List<ReportCheckCode> codes_reglaw = reportCheckInfoService.getCommonKeyCodeList("", "reglaw", 0);
        //获取所有的违反其他法律法规。
        List<ReportCheckCode> codes_othlaw = reportCheckInfoService.getCommonKeyCodeList("", "othlaw", 0);

        //获取所有的检查结果。
        List<ReportCheckCode> codes_res = reportCheckInfoService.getCommonKeyCodeList("", "res", 0);
        //获取所有的后续处置。
        List<ReportCheckCode> codes_dispose = reportCheckInfoService.getCommonKeyCodeList("", "dispose", 0);
        //获取核查主表
        ReportCheckInfo reportCheckInfo = reportCheckInfoService.getCheckInfoByUid(uid);
        String linkmanAndTel = reportCheckInfoService.getLinkManAndTel(midBaseInfo);
        //获取已选中的核查结果
        List<ReportCheckResult> reportCheckResults = reportCheckInfoService.getCheckResByUid(uid);
        //获取已选中的一般、重点核查科目；登记法律法规；其他法律法规；
        List<ReportCheckItem> reportCheckItems = reportCheckInfoService.getCheckedItem(uid);
        view.addObject("midBaseInfo", midBaseInfo);
//        view.addObject("yrRegCheck", yrRegCheck);
        view.addObject("linkmanAndTel", linkmanAndTel);
        view.addObject("codes_com", codes_com);
        view.addObject("codes_key", codes_key);
        view.addObject("codes_reglaw", codes_reglaw);
        view.addObject("codes_othlaw", codes_othlaw);
        view.addObject("codes_res", codes_res);
        view.addObject("codes_dispose", codes_dispose);
        view.addObject("reportCheckInfo", reportCheckInfo);
        view.addObject("reportCheckResults", reportCheckResults);
        view.addObject("reportCheckItems_othlaw", reportCheckItems.stream().filter(o -> "othlaw".equals(o.getType())).collect(Collectors.toList()));
        view.addObject("reportCheckItems_reglaw", reportCheckItems.stream().filter(o -> "reglaw".equals(o.getType())).collect(Collectors.toList()));
        view.addObject("reportCheckItems_common", reportCheckItems.stream().filter(o -> "common".equals(o.getType())).collect(Collectors.toList()));
        view.addObject("reportCheckItems_key", reportCheckItems.stream().filter(o -> "key".equals(o.getType())).collect(Collectors.toList()));
        view.addObject("reportItemWays", reportCheckInfo.getItemWay() == null ? "" : reportCheckInfo.getItemWay().split("&"));
        view.addObject("reportDispose", reportCheckInfo.getResDispose() == null ? "" : reportCheckInfo.getResDispose().split("&"));

        view.addObject("fromtype", fromtype);


        if ("add".equals(fromtype)) {
            reportCheckInfo.setInfoFillMan(sysUser.getRealName());
            reportCheckInfo.setInfoFillDate(new Date());
            reportCheckInfo.setDepartName(sysUser.getDepartMent().getDeptName());
            reportCheckInfo.setDepart(sysUser.getDepartMent().getDeptDID());
            reportCheckInfo.setInfoCheckOrg(midBaseInfo.getRegOrg());
            reportCheckInfo.setInfoCheckOrgName(midBaseInfo.getRegOrgName());

        }
        if ("edit".equals(fromtype)) {
            reportCheckInfo.setModName(sysUser.getRealName());
            reportCheckInfo.setModTime(new Date());
        }

        return view;
    }
    //-------------------------------------------------业务逻辑方法--------------------------------------


    @RequestMapping("/newinputList.json")
    @ResponseBody
    public PageResponse<ReportCheckInfoDto> inputListJSONNew(PageRequest request) throws Exception {
        creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
        List<ReportCheckInfoDto> data = reportCheckInfoService.inspectInputInfoQueryPageNew(request);
//        int total = reportCheckInfoService.inspectInputInfoQueryPage_total(request);
        return new PageResponse<ReportCheckInfoDto>(data);
    }
    
    @RequestMapping("/inputList.json")
    @ResponseBody
    public PageResponse<ReportCheckInfoDto> inputListJSON(PageRequest request) throws Exception {
        creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
        List<ReportCheckInfoDto> data = reportCheckInfoService.inspectInputInfoQueryPage_all(request);
//        int total = reportCheckInfoService.inspectInputInfoQueryPage_total(request);
        return new PageResponse<ReportCheckInfoDto>(data);
    }
   /*@RequestMapping("/inputList.json")
   @ResponseBody
   public PageResponse<ReportCheckInfoDto> inputListJSON(PageRequest request) throws Exception {
       creatOptDBAuthEnv(request, "yr.CheckDep", "yr.LocalAdm");
       List<ReportCheckInfoDto> data = reportCheckInfoService.inspectInputInfoQueryPage_all(request);
       return new PageResponse<ReportCheckInfoDto>(data);
   }*/

    @RequestMapping("/checkList.json")
    @ResponseBody
    public PageResponse<ReportCheckInfoDto> checkListJSON(PageRequest request) throws Exception {
        creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
        List<ReportCheckInfoDto> data = reportCheckInfoService.inspectCheckInfoQueryPage(request);
        return new PageResponse<ReportCheckInfoDto>(data);
    }

    @RequestMapping("/viewList.json")
    @ResponseBody
    public PageResponse<ReportCheckInfoDto> viewListJSON(PageRequest request) throws Exception {
        creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
        List<ReportCheckInfoDto> data = reportCheckInfoService.inspectViewInfoQueryPage(request);
        return new PageResponse<ReportCheckInfoDto>(data);
    }

    /**
     * 删除
     *
     * @param uid_fordelete
     * @return AjaxResult
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult del(@RequestParam String uid_fordelete) throws Exception {
        int res = reportCheckInfoService.del(uid_fordelete);
        if (res < 1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody ReportCheckInfoDto reportCheckInfoDto) throws Exception {
        int res = reportCheckInfoService.modiPre(reportCheckInfoDto, reportCheckInfoDto.getFromtype());
        if (res < 1)
            return AjaxResult.error("操作失败！");
        else return AjaxResult.success("操作成功!");
    }

    @RequestMapping("/countCheckNum")
    @ResponseBody
    public AjaxResult countCheckNum(PageRequest request) throws Exception {
    	creatOptDBAuthEnv(request, "r.CheckDep", "r.LocalAdm");
        Map res = reportCheckInfoService.countCheckNum(request.getParams());
        return AjaxResult.success("操作成功!", res);
    }

    /** 
     * 描述: TODO
     * @auther ZhouYan
     * @date 2017年11月6日 
     * @param paramsMap
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/total.json",method= RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> totalListJSON(@RequestBody Map<String, Object> paramsMap) throws Exception {
    	creatOptDBAuthEnv(paramsMap,"b.CheckDep","b.LocalAdm");
    	Integer total = 0;
    	Map<String,Object> totalMap = new HashMap<String,Object>();
    	paramsMap.put("disposeStateCount", "1");
		total= reportCheckInfoService.selectCheckInfoCountTotal(paramsMap);
		totalMap.put("disposeState1", total);
		paramsMap.put("disposeStateCount", "2");
		total= reportCheckInfoService.selectCheckInfoCountTotal(paramsMap);
		totalMap.put("disposeState2", total);
		return totalMap;
	}

}