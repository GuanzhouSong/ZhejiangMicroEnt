/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.reg.client;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.other.service.IMortRegInfoService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.other.service.ISpPledgeService;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    er_esc_appinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller
@RequestMapping("/reg/client/simpleesc/erescappinfo")
public class ErEscAppinfoController extends BaseController {
	
	public final static String isMatchEnt = "1100,1110,1120,1121,1122,1123,1124,1130,1140,1150,1151,1152,1153,1154,1190,3100,"
			+ "3200,4530,4531,4532,4533,4540,5100,5110,5120,5130,5140,5150,5160,5400,5410,5420,5430,6100,6110,6120,6130,6140,6150,6160,6170";
	
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	
	@Autowired
	private IPubOtherpunishService pubOtherpunishService;
	
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	
	@Autowired
	private IErEscAppinfoService erEscAppinfoService;
	
	@Autowired
	private ISpPledgeService spPledgeService;
	
	@Autowired
	private IMortRegInfoService mortRegInfoService;
	
	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;
	
	@Autowired
	private ICodeRegorgService codeRegorgService;
	
	@Value("${cloudModel}")
	private String cloudModel;

	@Autowired
	OssClient ossClient;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
	 * 描述: 判断是否符合简易注销申请条件
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@RequestMapping("isMatch")
	@ResponseBody
	public AjaxResult isMatchCondition(HttpSession session) throws Exception{
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		
		// 1.判断是否符合简易注销的企业类型
		if(StringUtil.isNotEmpty(midBaseInfoDto.getEntType())){
			if(isMatchEnt.indexOf(midBaseInfoDto.getEntType()) == -1){
				return AjaxResult.error("你企业类型不符合简易注销的要求，不适用简易注销程序！");
			} 
		}
		// 2.判断是否曾经被终止简易注销（是否被终止如何理解？）
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.doGetErEscAppinfoByPriPID(midBaseInfoDto.getPriPID());
		if(erEscAppinfo != null && StringUtil.isNotEmpty(erEscAppinfo.getSimplecanRea())){
			return AjaxResult.error("你企业已经申请过简易注销，不适用简易注销程序！");
		}
		// 3.判断是否有行政处罚记录
		if(CollectionUtils.isNotEmpty(pubOtherpunishService.doGetPubOtherPunishList(midBaseInfoDto.getRegNO(),midBaseInfoDto.getEntName()))){
			return AjaxResult.error("你企业有被予以行政处罚情形，不适用简易注销程序！");
		}
		// 4.判断是否正在被列入经营异常
		PageRequest request = new PageRequest();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put(Constants.CS_PRIPID, midBaseInfoDto.getPriPID());
        paramsMap.put("applyFalg", "1");
        request.setParams(paramsMap);
        List<PubOpanoMalyDto> pubOpanoMalyDtoList = pubOpanoMalyService.queryPubOpanoMalyList(request);
        if(CollectionUtils.isNotEmpty(pubOpanoMalyDtoList)){
        	return AjaxResult.error("你企业正在被列入经营异常名录，不适用简易注销程序！");
        }
        // 5.判断是否被列入严重违法失信企业名单
        if(CollectionUtils.isNotEmpty(expSeriousCrimeListService.selectSeriousCrimeInfoByPriPID(midBaseInfoDto.getPriPID()))){
        	return AjaxResult.error("你企业已被列入严重违法失信企业名单，不适用简易注销程序！");
        }
        // 6.判断是否有股权出质情形
        if(CollectionUtils.isNotEmpty(spPledgeService.selectSpPledgeInfoListByPriPID(midBaseInfoDto.getPriPID()))){
        	return AjaxResult.error("你企业有股权出质情形，不适用简易注销程序！");
        }
        // 7.判断是否有动产抵押情形
        PageRequest mortrequest = new PageRequest();
		Map<String, Object> mortMap = new HashMap<String, Object>();
		mortMap.put("regNO", midBaseInfoDto.getRegNO());
		mortMap.put("uniCode", midBaseInfoDto.getUniCode());
		mortrequest.setParams(mortMap);
        if(CollectionUtils.isNotEmpty(mortRegInfoService.queryPage(mortrequest))){
        	return AjaxResult.error("你企业有动产抵押情形，不适用简易注销程序！");
        }
        // 8.判断是否有股权冻结情形
        if(pubJusticeInfoService.doJudgeIsExsitIsForzenInfo(midBaseInfoDto.getPriPID())){
        	return AjaxResult.error("你企业存在股权（投资权益）被冻结，不适用简易注销程序！");
        }
		return AjaxResult.success("");
	}
	
	/**
	 * 描述: 判断是否已经保存并公示
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doCheckIsPub(HttpSession session) throws Exception{
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.doGetErEscAppinfoByPriPID(midBaseInfoDto.getPriPID());
		return AjaxResult.success("success", erEscAppinfo);
	}
	
	/**
	 * 描述: 保存简易注销申请信息
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=3000)
	public AjaxResult doSaveErEscAppinfo(ErEscAppinfo erEscAppinfo,String saveType) throws Exception{
		try {
			if(!erEscAppinfoService.doSaveErEscAppinfo(erEscAppinfo,saveType)){
				return AjaxResult.error("保存失败！"); 
			}
		} catch (Exception ex) {
			return AjaxResult.error("保存失败！"+ex.getMessage()); 
		}
		return AjaxResult.success("保存成功！");
	}
	
	/**
	 * 描述: 撤销简易注销信息
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	@ResponseBody
	@RepeatSubmit(timeout=3000)
	public AjaxResult doSaveErEscAppinfo(HttpSession session) throws Exception{
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		try {
			if(!erEscAppinfoService.doCancelErEscAppinfo(midBaseInfoDto.getPriPID())){
				return AjaxResult.error("撤销失败！");
			}
		} catch (Exception ex) {
			return AjaxResult.error("撤销失败！"+ex.getMessage());
		}
		return AjaxResult.success("撤销成功！");
	}
	
	/**
	 * 承诺书查看
	 * @author yujingwei
	 * @date 2017年2月15日
	 * @param session
	 * @return
	 */
	@RequestMapping("view")
	public ModelAndView viewCommitment(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/simplecan/commitment");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.doGetErEscAppinfoByPriPID(midBaseInfoDto.getPriPID());
		if(erEscAppinfo != null){
			String fileName = erEscAppinfo.getCommitment();
			BASE64Encoder encoder = new BASE64Encoder();
			erEscAppinfo.setCommitment(encoder.encode(downFormOSSa(fileName)));
		}
		view.addObject("erEscAppinfo", erEscAppinfo);
		return view;
	}
	
	/**
	 * 预览打印
	 * @author yujingwei
	 * @date 2017年2月15日
	 * @param session
	 * @return 
	 */
	@RequestMapping("print")
	public ModelAndView viewPrint(String priPID) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/simplecan/print");
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.doGetErEscAppinfoByPriPID(priPID);
		if(erEscAppinfo !=null){
			List<CodeRegorg> codeRegorgs = codeRegorgService.selectRegOrgByCodes(erEscAppinfo.getRegOrg());
			if(CollectionUtils.isNotEmpty(codeRegorgs)){
				erEscAppinfo.setRegOrg(codeRegorgs.get(0).getContent());
			}
		}
		view.addObject("erEscAppinfo", erEscAppinfo);
		return view;
	}
	
	/**
	 * 描述: 获取信息用于提示
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@RequestMapping(value = "/tipInfo", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doGetTipInfo(HttpSession session) throws Exception{
		ErEscAppinfo erEscAppinfo = new ErEscAppinfo();
		erEscAppinfo.setNoticeFrom(new Date());
		erEscAppinfo.setNoticeTo(DateUtil.getNdaylaterDate(new Date(), 45));
		erEscAppinfo.setEndDate(DateUtil.getNdaylaterDate(new Date(), 75));
		return AjaxResult.success("success", erEscAppinfo);
	}
	
	/**
	 * 描述：上传接口（兼容IE8）
	 * 
	 * @author yujingwei
	 * @date 2017年2月14日
	 * @param file
	 * @param prefix
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "file") MultipartFile file, String prefix) {
		String fileName = prefix + "-" + "全体投资人承诺书";
		if(file.getSize() > 1000000){
			return "false";
		}
		String result = null;
		if ("Y".equals(cloudModel)) {
			result = uploadToOSS(file, fileName);
		} else {
			result = "error";
		}
		return result;
	}
	
	
	/**
	 * 从OSS下载文件接口
	 * @param fileName
	 * @return
	 */
	private byte[] downFormOSSa(String fileName) {
		if (fileName == null || StringUtils.isBlank(fileName)) {
			return null;
		}
		try {// 从OSS获取文件流
			byte[] by = null;
			by = ossClient.getStream(fileName);
			return by;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 上传到OSS服务器
	 * 
	 * @param files
	 * @param fileName
	 * @return
	 */
	private String uploadToOSS(MultipartFile file, String fileName) {
		boolean flag = false;
		try {
			flag = ossClient.putStream(file, "simpleesc/commitment/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		if (flag) {
			return "simpleesc/commitment/" + fileName;
		} else {
			return "error";
		}
	}
	
	/**
	 *  文件下载
	 * @throws Exception
	 */
	@RequestMapping("/otherinfo")
	public ResponseEntity<byte[]> file_down(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/client/simplecan")+File.separator+"otherinfo.docx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("外商投资准入特别管理措施.doc".getBytes("GBK"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
	 * 全体投资人模板文件下载
	 * @throws Exception
	 */
	@RequestMapping("/commitmod")
	public ResponseEntity<byte[]> commitment(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/client/simplecan")+File.separator+"commitment.docx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("全体投资人承诺书.docx".getBytes("GBK"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
}