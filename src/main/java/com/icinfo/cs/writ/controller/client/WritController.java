/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.controller.client;


import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubSccheckItemResult;
import com.icinfo.cs.sccheck.model.PubScentResultMaterial;
import com.icinfo.cs.sccheck.service.IPubSccheckItemResultService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubScentResultMaterialService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.writ.dto.WritDto;
import com.icinfo.cs.writ.dto.WritParams;
import com.icinfo.cs.writ.model.Dzhz;
import com.icinfo.cs.writ.model.Dzqz;
import com.icinfo.cs.writ.service.IDzhzService;
import com.icinfo.cs.writ.service.IDzqzService;
import com.icinfo.cs.writ.service.IWritService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.framework.tools.utils.WebUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 描述:  cs_writ 对应的Controller类.  企业联连 文书 <br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/writ")   //  http://127.0.0.1:8082/reg/client/yr/ent/writ/show
public class WritController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WritController.class);
    @Autowired
    private IWritService writService;
    @Autowired
    private IDzhzService dzhzService;
    @Autowired
    private IDzqzService dzqzService;
    @Autowired
    IPubEppasswordService pubEppasswordService;
    //签章地址
    @Value("${webSigntureServer}")
    private String webSigntureServer;
    
    @Autowired
	IPubScentResultService pubScentResultService;
    @Autowired
	IPubScentResultMaterialService pubScentResultMaterialService;
    @Autowired
	IPubSccheckItemResultService pubSccheckItemResultService;
    @Autowired
	IPubSccheckItemService pubSccheckItemService;
	@Autowired
	ICodeRegunitService codeRegunitService;

    /**
     * 显示列表页面
     * @return
     */
    @RequestMapping("/show")
    public ModelAndView show(){
        ModelAndView view = new ModelAndView("reg/client/writ/writ_list");
        return  view;
    }


    /**
     * 描述：获取企业文书列表
     * @author:wangjin
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list_json"})
    @ResponseBody
    public PageResponse<WritDto> list_json(PageRequest request)throws  Exception{
        List<WritDto> data = writService.select_queryPage(request);
        return  new PageResponse<WritDto>(data);
    }

    /**
     * 更新查阅状态
     * @param uuid
     * @return
     */
    @RequestMapping("/updateLookStatue")
    @ResponseBody
    public AjaxResult UpdateLookStatue(String uuid){
        if(StringUtil.isNotBlank(uuid)){
            if(writService.UpdateLookStatue(uuid)>0)return AjaxResult.success("已查阅");
        }
        return AjaxResult.error("");
    }



    /**
     * 立即回执 页面
     * @author: wangjin
     * @return
     */
    @RequestMapping("/promptly_writ")
    @ResponseBody
    public ModelAndView promptly(WritParams writParams) throws UnsupportedEncodingException {
        ModelAndView view = new ModelAndView("reg/client/writ/promptly_writ");
        PubEppassword pubEppassword = null;
        Dzhz dzhz = null;
        Dzqz dzqz = null;
        if(isNotBlank(writParams.getUuid(),writParams.getPriPID())){
            //获取联络员信息
            pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(writParams.getPriPID());
            //获取电子回执
            dzhz =dzhzService.selectbyWritUuid(writParams.getUuid());
            //获取电子签章
            dzqz = dzqzService.selectbyWritUuid(writParams.getUuid());
        }
        view.addObject("dzhz",dzhz);//电子回执
        view.addObject("dzqz",dzqz);//电子签章

        //获取不同类型的决定书
        try {
            view = writService.getChooseWritData(view,writParams.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取系统时间
        String sysDate = DateUtil.getCurrentDate();
        view.addObject("sysDate",sysDate); //系统时间
        view.addObject("writParams",writParams);
        //判断联络信息是否为空
        if(pubEppassword!=null&& StringUtils.isNotBlank(pubEppassword.getLiaidnum())&&StringUtils.isNotBlank(pubEppassword.getTel())){
            view.addObject("lianname",pubEppassword.getLianame());//联络员姓名
            view.addObject("tel",pubEppassword.getTel());//联络员电话号码
        }
        return  view;
    }

    /**
     * 描述：保存回执数据
     * @author:wangjin
     * @param dzhz
     * @return
     */
    @RequestMapping(value = "/receiptSave", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult receiptSave(Dzhz dzhz){
        String writUuid = dzhz.getWritUuid();
        String receivePeople =dzhz.getReceivePeople();//回执人
        //判断传递的参数是否为空
        if(isNotBlank(dzhz.getWritUuid(),dzhz.getPriPID())){
            //return  dzhzService.save(dzhz)>0?AjaxResult.success("保存成功!"):AjaxResult.error("保存失败!");
            if(dzhzService.save(dzhz)>0){
                writService.UpdateReceiveTimeByWritUuid(writUuid,receivePeople);  //更新回执时间和回执人
                return AjaxResult.success("回执成功");
            }
                return AjaxResult.error("回执失败");
        }
        return AjaxResult.error("参数为空");
    }


    /**
     * 描述：保存签章成功纪录
     * @author: wangjin
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveSignture")
    @ResponseBody
    @RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult doSaveSignture(String cert, String signedData, String signContent,String year,String pripid,String writUuid) {
        //构建 json参数
        JSONObject paramJsonObject = new JSONObject();
        //项目ID，由签章系统分配
        paramJsonObject.put("project", "ycproject");
        //证书公钥base64，由jsp页面获取传入
        paramJsonObject.put("cert", cert);
        //签名值，由jsp页面获取传入
        paramJsonObject.put("signedData", signedData);
        //签名原文，由jsp页面获取传入
        paramJsonObject.put("signContent", signContent);
        //该地址获取 entry/dev/spring.properties
        String url = webSigntureServer;
        //使用框架的postStream方法发送请求
        String result = WebUtils.postStream(url, paramJsonObject.toJSONString(), "utf-8");
        JSONObject rltJson = null;
        try {
            //判断接口获取的数据是否满足序列化条件
            rltJson = JSONObject.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("签章失败");
        }
        String sealImgBase64 = "";
        if("0".equals(rltJson.getString("retcode"))){
            //获得签名ID
            String signId = rltJson.getString("signId");
            //获得印章图片base64
            sealImgBase64 = "data:image/page;base64,"+rltJson.getString("sealImgBase64");

            if(doSaveAndUpdate(year,pripid,sealImgBase64,writUuid)){
                return  AjaxResult.success("签章成功",sealImgBase64);
            }
        }
        return AjaxResult.error("签章失败");
    }


    public boolean doSaveAndUpdate(String year,String pripid,String sealImgBase64,String writUuid){
        boolean falg = false;
        Dzqz dzqz = null;

        if(StringUtil.isNotBlank(writUuid)) {
            //查询签章中是否有数据
            dzqz = dzqzService.selectbyWritUuid(writUuid);
        }
        //判断当前表中是否有纪录 有则更新  无则新增
        if(dzqz!=null){
            dzqz.setImageCode(sealImgBase64);
            falg = dzqzService.modify(dzqz)>0?true:false;
        }else{
            falg = dzqzService.save(year,pripid, sealImgBase64,writUuid)>0?true:false;
        }
        return falg;
    }


    /**
     * 描述：签章失败  修改签章状态
     * @param writUuid
     */
    @RequestMapping("/doModifyStatus")
    @ResponseBody
    public void doModifyStatus(String writUuid ){
        if(StringUtil.isNotBlank(writUuid)){
            dzqzService.modifyStatus(dzqzService.selectbyWritUuid(writUuid));
        }
    }

    /**
     * 描述:判断参数是否存在为空
     * @author:wangjin
     * @param uuid
     * @param pripid
     * @return
     */
    public boolean isNotBlank(String uuid,String pripid){
        boolean falg = false;
        if(StringUtil.isNotBlank(uuid)&&StringUtil.isNotBlank(pripid)){
           falg = true;
        }
        return falg;
    }


    /**
	 * 
	 * 描述   年报端 获取企业的抽查通知书
	 * @author 赵祥江
	 * @date 2017年11月14日 下午2:34:53 
	 * @param 
	 * @return PageResponse<PubScentResultDto>
	 * @throws
	 */
	@RequestMapping("queryYearReportPageResult.json")
	@ResponseBody
	public PageResponse<PubScentResultDto> queryYearReportPageResult(PageRequest request,String priPID) throws Exception { 
		//通知书设置标识
		Map<String,Object> qMap=request.getParams();
		if(qMap==null){
			qMap=new HashMap<String,Object>();
			qMap.put("priPID", priPID);
		}
		qMap.put("admissionFlag", "1");
		request.setParams(qMap);
		List<PubScentResultDto> pubScentResultDtos = pubScentResultService.queryYearReportPageResult(request);
		return new PageResponse<PubScentResultDto>(pubScentResultDtos);
	}
	
	/**
	 * 
	 * 描述   打印抽查检查通知书
	 * @author 赵祥江
	 * @date 2017年11月15日 下午3:42:55 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("noticeprint")
	public ModelAndView noticePrint(@RequestParam String resultUid, @RequestParam String priPID, HttpSession session)
			throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/scresult/scresultnotice_print");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		PubScentResultDto pubScentResultDto = pubScentResultService.queryPubScentResultDtoByUid(resultUid);
		// 查询有没有保存的通知书
		PubScentResultMaterial pubScentResultMaterial = pubScentResultMaterialService
				.findPubScentResultMaterialByResultUid(pubScentResultDto.getUid());
		if (pubScentResultMaterial != null) {
			mav.addObject("pubScentResultMaterial", pubScentResultMaterial);
			Date checkDateFrom = pubScentResultMaterial.getCheckDateFrom();
			Date checkDateTo = pubScentResultMaterial.getCheckDateTo();
			Date fillDate = pubScentResultMaterial.getFillDate();
			Calendar c = Calendar.getInstance();
			if (checkDateFrom != null) {
				c.setTime(checkDateFrom);
				mav.addObject("checkDateFromYear", c.get(Calendar.YEAR));
				mav.addObject("checkDateFromMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("checkDateFromDay", c.get(Calendar.DAY_OF_MONTH));
			}
			if (checkDateTo != null) {
				c.setTime(checkDateTo);
				mav.addObject("checkDateToYear", c.get(Calendar.YEAR));
				mav.addObject("checkDateToMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("checkDateToDay", c.get(Calendar.DAY_OF_MONTH));
			}
			if (fillDate != null) {
				c.setTime(fillDate);
				mav.addObject("fillDateYear", c.get(Calendar.YEAR));
				mav.addObject("fillDateMonth", c.get(Calendar.MONTH) + 1);
				mav.addObject("fillDateDay", c.get(Calendar.DAY_OF_MONTH));
			}
			String material = pubScentResultMaterial.getMaterial();
			if (!StringUtil.isEmpty(material)) {
				String[] materials = material.split(",");
				List<String> materialList = Arrays.asList(materials);
				mav.addObject("materialList", materialList);
				mav.addObject("num", materialList.size() + 1);
			}
		}

		List<PubSccheckItemResult> pubSccheckItemResultList = pubSccheckItemResultService
				.queryPubSccheckItemResultByTaskUidAndPriPID(pubScentResultDto.getTaskUid(), priPID);
		List<PubSccheckItem> pubSccheckItemList = new ArrayList<PubSccheckItem>();
		if (pubSccheckItemResultList.size() <= 0) {
			pubSccheckItemList = pubSccheckItemService.selectEntRlate(pubScentResultDto.getTaskUid(), priPID);
		} else {
			for (PubSccheckItemResult pubSccheckItemResult : pubSccheckItemResultList) {
				PubSccheckItem pubSccheckItem = new PubSccheckItem();
				pubSccheckItem.setCheckCode(pubSccheckItemResult.getCheckCode());
				pubSccheckItem.setCheckName(pubSccheckItemResult.getCheckName());
				pubSccheckItemList.add(pubSccheckItem);
			}
		}

		mav.addObject("pubScentResultDto", pubScentResultDto);
		mav.addObject("pubSccheckItemList", pubSccheckItemList);
//		if(pubScentResultMaterial != null && StringUtils.isNotEmpty(pubScentResultMaterial.getDepartMent())){
//			mav.addObject("deptName", pubScentResultMaterial.getDepartMent());
//		}else{
//			mav.addObject("deptName", sysUserDto.getDepartMent().getDeptName());
//		}
		if(pubScentResultMaterial != null && StringUtils.isNotEmpty(pubScentResultMaterial.getDepartMent())){
			mav.addObject("deptName", pubScentResultMaterial.getDepartMent());
		}else{
			if("1".equals(sysUserDto.getUserType())){
				String deptCode = sysUserDto.getDepartMent().getDeptCode();
				if(deptCode.length() == 8 && !deptCode.endsWith("00")){
					CodeRegunit codeRegunit = codeRegunitService.selectByPCode(deptCode);
					mav.addObject("deptName", codeRegunit.getContent());
				}else{
					mav.addObject("deptName", sysUserDto.getDepartMent().getDeptName());
				}
			}else{
				mav.addObject("deptName", sysUserDto.getSysDepart().getOrgName());
			}
		}
		if(pubScentResultMaterial != null && StringUtils.isNotEmpty(pubScentResultMaterial.getContactName())){
			mav.addObject("realName", pubScentResultMaterial.getContactName());
		}else{
			mav.addObject("realName", sysUserDto.getRealName());
		}
		if(pubScentResultMaterial != null && StringUtils.isNotEmpty(pubScentResultMaterial.getContactTel())){
			mav.addObject("phone", pubScentResultMaterial.getContactTel());
		}else{
			mav.addObject("phone", sysUserDto.getPhone());
		}
		return mav;
	}

}