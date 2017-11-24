/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.mainmark.dto.MainMarkDto;
import com.icinfo.cs.mainmark.dto.MainMarkHisDto;
import com.icinfo.cs.mainmark.dto.MainMarkRelDto;
import com.icinfo.cs.mainmark.service.IMainMarkHisService;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.cs.mainmark.service.IMainMarkService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_main_mark 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
@Controller
@RequestMapping("/reg/server/mainmark/")
public class MainMarkController extends BaseController {

    @Autowired
    private IMainMarkService            mainMarkService;

    @Autowired
    private IMainMarkHisService         mainMarkHisService;

    @Autowired
    private IMainMarkRelService         mainMarkRelService;

    @Autowired
    private IRegistMarkService          registMarkService;

    @Autowired
    private IEntSearchService           entSearchService;

    @Autowired
    private IMidBaseInfoService         midBaseInfoService;
    @Autowired
    private IPubEppasswordService       pubEppasswordService;

    @Autowired
    private IQualificationLimitService  qualificationLimitService;

    @Autowired
    private IPubPbopanomalyService      pubPbopanomalyService;

    @Autowired
    IErEscAppinfoService                erEscAppinfoService;

    @Autowired
    private IPubOpaDetailService        pubOpaDetailService;

    @Autowired
    private IExpSeriousCrimeListService expSeriousCrimeListService;

    /**
     * 描述: 跳转至申请分页列表
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @return
     * @throws Exception
     */

    @RequestMapping("toMainmarkapplyList")
    public String toMainmarkapplyList() throws Exception{
        return "reg/server/mainmark/mainmarkapply_list";
    }

    /**
     * 描述: 跳转至审核分页列表
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @return
     * @throws Exception
     */

    @RequestMapping("toMainmarkauditList")
    public String toMainmarkauditList() throws Exception{
        return "reg/server/mainmark/mainmarkaudit_list";
    }

    /**
     * 描述: 跳转至企业查询页面
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @return
     * @throws Exception
     */

    @RequestMapping("toAppsearch")
    public ModelAndView toAppsearch() throws Exception{
    	ModelAndView view = new ModelAndView("/reg/server/mainmark/appsearch");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
    }

    /**
     * 
     * 描述 检查企业是否是异常名录和严重违法 @author 赵祥江 @date 2017年3月21日 下午2:41:58 @param @return
     * String @throws
     */
    private String checkIsOpanomaly(String entTypeCatg,String priPID) throws Exception{
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put ("priPID", priPID);
        String opanomaly = "0";
        String seriousCrime = "0";
        if ("50".equals (entTypeCatg)) {
            List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList (map);
            if (dataList != null && dataList.size () > 0) {
                opanomaly = "1";
            }
        } else {
            List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch (map);
            if (dataList != null && dataList.size () > 0) {
                opanomaly = "1";
            }
        }
        List<ExpSeriousCrimeList> expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeInfoByPriPID (priPID);
        if (expSeriousCrimeList != null && expSeriousCrimeList.size () > 0) {
            seriousCrime = "1";
        }
        // 同时被列入异常和严重违法
        if ("1".equals (opanomaly) && "1".equals (seriousCrime)) {
            return "1";
        } else if ("1".equals (opanomaly) && !"1".equals (seriousCrime)) {// 只列入异常
            return "2";
        } else if (!"1".equals (opanomaly) && "1".equals (seriousCrime)) {// 只列入严重违法
            return "3";
        } else {
            return "0";
        }
    }

    /**
     * 描述: 跳转至编辑页面
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @return
     * @throws Exception
     */
    @RequestMapping("toMainmarkapplyEdit")
    public ModelAndView toMainmarkapplyEdit(HttpSession session,String markUuid,String priPID) throws Exception{
        ModelAndView view = new ModelAndView ("reg/server/mainmark/mainmarkapply_edit");
        view.addObject ("priPID", priPID);
        view.addObject ("markUuid", markUuid);

        MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid (priPID);
        List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate (priPID);
        if (midDtos != null && midDtos.size () > 0) {
            midBaseInfoDto.setPunishDate (midDtos.get (0).getPunishDate ());
        }
        if (midBaseInfoDto != null) {
        	List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
        	view.addObject("isLimit", limits);
        }

        // 联络员信息
        PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID);
        view.addObject ("liaName", pubEppassword == null ? "" : pubEppassword.getLianame ());
        view.addObject ("liaTel", pubEppassword == null ? "" : pubEppassword.getTel ());
        view.addObject ("dto", midBaseInfoDto);
        view.addObject ("isOpanomaly", checkIsOpanomaly (midBaseInfoDto.getEntTypeCatg (), priPID));
        view.addObject ("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID (priPID));
        if (StringUtils.isNotBlank (markUuid)) {
            MainMarkDto mainMarkDto = mainMarkService.queryViewByMarkPriPID (priPID);
            view.addObject ("mainMarkDto", mainMarkDto);
        }
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        view.addObject ("sysUser", sysUser);
        view.addObject ("nowDate", DateUtil.getCurrentDate ());

        return view;
    }

    /** 
     * 描述: 查看页面
     * @author 张文男
     * @date 2017年4月5日 
     * @param session
     * @param markUuid
     * @param priPID
     * @return
     * @throws Exception 
     */

    @RequestMapping("toMainmarkapplyView")
    public ModelAndView toMainmarkapplyView(HttpSession session,String markUuid,String priPID) throws Exception{
        ModelAndView view = new ModelAndView ("reg/server/mainmark/mainmarkapply_view");
        view.addObject ("priPID", priPID);
        view.addObject ("markUuid", markUuid);

        MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid (priPID);
        List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate (priPID);
        if (midDtos != null && midDtos.size () > 0) {
            midBaseInfoDto.setPunishDate (midDtos.get (0).getPunishDate ());
        }
        if (midBaseInfoDto != null) {
        	List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
        	view.addObject("isLimit", limits);
        }

        // 联络员信息
        PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID);
        view.addObject ("liaName", pubEppassword == null ? "" : pubEppassword.getLianame ());
        view.addObject ("liaTel", pubEppassword == null ? "" : pubEppassword.getTel ());
        view.addObject ("dto", midBaseInfoDto);
        view.addObject ("isOpanomaly", checkIsOpanomaly (midBaseInfoDto.getEntTypeCatg (), priPID));
        view.addObject ("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID (priPID));
        if (StringUtils.isNotBlank (markUuid)) {
            MainMarkDto mainMarkDto = mainMarkService.queryViewByMarkPriPID (priPID);
            view.addObject ("mainMarkDto", mainMarkDto);
        }

        return view;
    }

    /**
     * 描述: 跳转至审核编辑页面
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @return
     * @throws Exception
     */
    @RequestMapping("toMainmarkauditEdit")
    public ModelAndView toMainmarkauditEdit(HttpSession session,String markUuid,String priPID) throws Exception{
        ModelAndView view = new ModelAndView ("reg/server/mainmark/mainmarkaudit_edit");

        MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid (priPID);
        List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate (priPID);
        if (midDtos != null && midDtos.size () > 0) {
            midBaseInfoDto.setPunishDate (midDtos.get (0).getPunishDate ());
        }
        if (midBaseInfoDto != null) {
        	List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
        	view.addObject("isLimit", limits);
        }

        // 联络员信息
        PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID);
        view.addObject ("liaName", pubEppassword == null ? "" : pubEppassword.getLianame ());
        view.addObject ("liaTel", pubEppassword == null ? "" : pubEppassword.getTel ());
        view.addObject ("dto", midBaseInfoDto);
        view.addObject ("isOpanomaly", checkIsOpanomaly (midBaseInfoDto.getEntTypeCatg (), priPID));
        view.addObject ("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID (priPID));
        if (StringUtils.isNotBlank (markUuid)) {
            MainMarkDto mainMarkDto = mainMarkService.queryViewByMarkPriPID (priPID);
            view.addObject ("mainMarkDto", mainMarkDto);
        }

        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        view.addObject ("sysUser", sysUser);
        view.addObject ("nowDate", DateUtil.getCurrentDate ());
        view.addObject ("markUuid", markUuid);
        view.addObject ("priPID", priPID);
        return view;
    }

    /**
     * 描述: 跳转至批量编辑页面
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @return
     * @throws Exception
     */

    @RequestMapping("toMainmarkapplyBatchedit")
    public ModelAndView toMainmarkapplyBatchedit(HttpSession session,String priPIDs) throws Exception{
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        ModelAndView view = new ModelAndView ("reg/server/mainmark/mainmarkapply_batchedit");
        view.addObject ("sysUser", sysUser);
        view.addObject ("nowDate", DateUtil.getCurrentDate ());
        view.addObject ("priPIDs", priPIDs);
        return view;
    }

    /** 
     * 描述: 分页列表
     * @author 张文男
     * @date 2017年4月5日 
     * @param request
     * @return
     * @throws Exception 
     */

    @RequestMapping("mainmarkapplyList.json")
    @ResponseBody
    public PageResponse<MainMarkDto> mainmarkapplyList(HttpSession session,PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        // 去掉查询参数的左右空格
        com.icinfo.cs.common.utils.StringUtil.paramTrim (queryMap);
        request.setParams (queryMap);
        
        SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else if (sysSetDeptCode.substring (4, 6).equals ("00")) {// 市局
            sysSetDeptCode = sysSetDeptCode.substring (0,4);
        } 
        
        request.getParams ().put ("sysSetDeptCode", sysSetDeptCode);
        List<MainMarkDto> list = mainMarkService.queryPageList (request);
        return new PageResponse<MainMarkDto> (list);
    }

    /** 
     * 描述: 历史信息分页列表
     * @author 张文男
     * @date 2017年4月5日 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("mainmarkapplyHisList.json")
    @ResponseBody
    public PageResponse<MainMarkHisDto> mainmarkapplyHisList(PageRequest request) throws Exception{
        Map<String, Object> queryMap = request.getParams ();
        // 去掉查询参数的左右空格
        com.icinfo.cs.common.utils.StringUtil.paramTrim (queryMap);
        request.setParams (queryMap);
        List<MainMarkHisDto> list = mainMarkHisService.queryPageList (request);
        return new PageResponse<MainMarkHisDto> (list);
    }

    /**
     * 描述: 获取所有有效小类标签列表
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @param session
     * @return
     * @throws Exception
     */

    @RequestMapping("queryValidSubTypeMarkList.json")
    @ResponseBody
    public AjaxResult queryValidSubTypeMarkList(HttpSession session,String idname,String priPID,boolean isShowCheckOnly){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            List<Map<String,Object>> list = registMarkService.queryValidSubTypeListByUserInfo (sysUser, idname,priPID,isShowCheckOnly);
            return AjaxResult.success ("", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("数据获取失败");
    }
    
    /**
     * 描述: 根据用户信息及参数获取选中小类标签(户口建档)
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @param session
     * @return
     * @throws Exception
     */
    
    @RequestMapping("queryValidMarkByUserInfo.json")
    @ResponseBody
    public AjaxResult queryValidMarkByUserInfo(HttpSession session,String idname,String priPID,boolean isShowCheckOnly){
    	try {
    		SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
    		List<Map<String,Object>> list = registMarkService.queryValidMarkByUserInfo (sysUser, idname,priPID,isShowCheckOnly);
    		return AjaxResult.success ("", list);
    	} catch (Exception e) {
    		e.printStackTrace ();
    	}
    	return AjaxResult.error ("数据获取失败");
    }

    /** 
     * 描述: 获取已存在标签列表
     * @author 张文男
     * @date 2017年4月5日 
     * @param priPID
     * @return 
     */
    @RequestMapping("queryHasMarkList.json")
    @ResponseBody
    public AjaxResult queryHasMarkList(String priPID){
        try {
            List<MainMarkRelDto> list = mainMarkRelService.queryListInPriPIDAndIshis (priPID, "1", "0");
            return AjaxResult.success ("", list);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("数据获取失败");
    }

    /**
     * 描述: 保存或修改
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @param priPIDs
     * @param markCodes
     * @param markNames
     * @param setName
     * @param setTime
     * @param setDeptname
     * @return
     */

    @RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult saveOrUpdate(HttpSession session,String priPIDs,String markCodes,String markNames,String setName,String setTime,String setDeptname){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            // 警示协同的地址 默认警示
            String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
            mainMarkService.saveOrUpdate (priPIDs, markCodes, markNames, setName, setTime, setDeptname,sysSetDeptCode);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /**
     * 描述: 审核
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @param mainMark
     * @return
     */

    @RequestMapping(value = "audit",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult audit(MainMarkDto mainMark,HttpSession session){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            mainMarkService.audit (mainMark,sysUser);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /**
     * 描述: 根据标签id删除对应记录
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @param markUuid
     * @return
     */

    @RequestMapping(value = "deleteByMarkUuid",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteByMarkUuid(String markUuid){
        try {
            mainMarkService.deleteByMarkUuid (markUuid);
            return AjaxResult.success ("操作成功！");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
}