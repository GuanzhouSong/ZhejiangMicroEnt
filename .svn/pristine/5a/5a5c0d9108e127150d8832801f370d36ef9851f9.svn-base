/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.record.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.CertUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.ILoginService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPubPbePasswordService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.zjaicsso.cas.client.authentication.AttributePrincipal;

/** 
 * 描述: 企业端登录service实现
 * @author ZhouYan
 * @date 2016年9月28日  
 */
@Service
public class LoginServiceImpl extends MyBatisServiceSupport implements ILoginService {
	private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IPubPbePasswordService pubPbePasswordService;
	@Autowired
	private ISysLogService sysLogService;

	/** 
	 * 描述: 企业证书登录
	 * @auther ZhouYan
	 * @date 2016年11月16日 
	 * @param principal
	 * @param expiredFlag
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doEntKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception {
		logger.info("******************浙江省网上政务大厅企业联合身份认证登录 start******************");
    	if (principal == null) {
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
        }
    	String usertype = principal.getAttributes().get("usertype").toString(); //用户类型
    	if("2".equals(usertype)){
    		String entname = StringUtil.doReplaceBlank(principal.getCorporateAttributes().get("companyName").toString());    //企业名称
        	String regno = principal.getCorporateAttributes().get("companyRegNumber").toString();   //工商注册号
        	String pripid = principal.getCorporateAttributes().get("companySerialNumber").toString();   //内部序号
        	String outDateString = CertUtil.getCertSubjectMapContent(principal.getAttributes().get("certBase64").toString()).get("certValidEndTime");//证书有效期
        	String uniscid = null;
        	if(principal.getCorporateAttributes().get("uscc") != null) {
        		uniscid = principal.getCorporateAttributes().get("uscc").toString();//统一代码
        	}
        	
        	logger.info("企业名称：" + entname);
        	logger.info("注册号：" + regno);
        	logger.info("内部序号：" + pripid);
        	logger.info("证书有效期：" + outDateString);
        	logger.info("统一代码：" + uniscid);
        	logger.info("从cookies取证书有效期校验标志：" + expiredFlag);
        	logger.info("******************浙江省网上政务大厅企业联合身份认证登录 end******************");
        	
        	// a.通过CAKey里面的注册号或内部序号查询企业信息, 并判断是否变更
        	MidBaseInfoDto midBaseInfoDto = null;
        	ResultRtn<MidBaseInfoDto> rtn = doGetMidBaseInfoForCAKeyLogin(regno, entname, pripid, Constants.SYSTEM_TYPE_ENT);
        	if(rtn.isSucess()){
        		midBaseInfoDto = rtn.getData();
        	}else{
        		return new ResultRtn<T>(rtn.getErrorCode(),rtn.getError());
        	}
        	
            // b.如证书过期标识为0, 验证证书日期，如过期，则转向延期操作, 并存储参数
            if("0".equals(expiredFlag)){
            	ResultRtn<T> certRtn = doCheckCertOutDate(outDateString);
            	if(!certRtn.isSucess()){
            		return certRtn;
            	}
            }
            
            // c.判断企业登录业务
            boolean yearReportFlag = false;
            ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
            if(!bizRtn.isSucess()){
            	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
            		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
            	}
        	}else{
        		yearReportFlag = bizRtn.isFlag();
        	}
            
            // d.保存基本信息、登录方式到session
            doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_OAUTH, yearReportFlag,"");
    	}else{
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
    	}
    	return new ResultRtn<T>(true);
	}
	
	  /** 
     * 描述: 根据注册号和名称查询企业准入信息
     * @auther ZhouYan
     * @date 2016年8月29日 
     * @param regno
     * @param entname
     * @param pripid
     * @return
     * @throws Exception 
     */
    private ResultRtn<MidBaseInfoDto> doGetMidBaseInfoForCAKeyLogin(String regno, String entname, String pripid, String systemType) throws Exception {
    	MidBaseInfoDto midBaseInfoDto = null;
        try {
        	if("notgetnbbh".equals(pripid)){
        		//1.没有内部序号，则根据注册号查询企业信息
        		midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(regno, null, systemType);
        	}else{
        		//2.有内部序号，则根据内部序号查询企业信息
        		midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(pripid, systemType);
        	}
        } catch (Exception e) {
            return new ResultRtn<MidBaseInfoDto>("0", "系统异常, 请联系管理员！"+ e);
        }
        // 3.库里面查询不到, 提示不属于系统范围
        if (midBaseInfoDto == null) {
        	return new ResultRtn<MidBaseInfoDto>("0", "您企业不属于该系统用户范围，请确认所登录的年报网址是否正确！");
        } else {
        	// 4.企业名称已变更，转向变更操作(个体户名称不做比对校验)
            if (!entname.trim().equalsIgnoreCase(StringUtil.doReplaceBlank(midBaseInfoDto.getEntName().trim()))&&!"50".equals(midBaseInfoDto.getEntTypeCatg())) {
                return new ResultRtn<MidBaseInfoDto>("1", "数字证书登录失败，证书里的企业名称已变更！"+"【"+entname+"】");
            }
        }
		// 企业大类：23  外国（地区）企业常驻代表机构  不在此系统内
		if("23".equals(midBaseInfoDto.getEntTypeCatg().trim())){
			return new ResultRtn<MidBaseInfoDto>("0", "外资常驻代表机构不属于本系统范围内！");
		}
        return new ResultRtn<MidBaseInfoDto>(midBaseInfoDto);
    }
    
    /** 
     * 描述: 验证证书日期，如过期，则转向延期操作, 并存储参数
     * @auther ZhouYan
     * @date 2016年8月29日 
     * @param outDateString
     * @throws Exception 
     */
    private ResultRtn<T> doCheckCertOutDate(String outDateString) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date certdate = sdf.parse(outDateString);//证书有效日期
        Date curdate = new Date();
        // 1.数字证书已过期,转延期操作
        if (certdate.getTime() < curdate.getTime()) {
        	return new ResultRtn<T>("2", "数字证书登录失败：证书已过期！");
        }
        // 2.数字证书30天后即将过期，提醒进行延期
//        Date somedaysafter = sdf.parse(DateUtil.getNdaylater(curdate, 30));
//        if (certdate.getTime() < somedaysafter.getTime()) {
//        	return new ResultRtn<T>("3", "证书有效期将于" + outDateString + "到期！");
//        }
        return new ResultRtn<T>(true);
    }
    
    /** 
     * 描述: 判断企业登录业务
     * @auther ZhouYan
     * @date 2016年8月29日 
     * @param midBaseInfoDto
     * @throws Exception 
     */
    private ResultRtn<Boolean> doCheckLoginDataBiz(MidBaseInfoDto midBaseInfoDto) throws Exception {
    	boolean yearReportFlag = true; //是否符合年报标记，当前新成立企业只能填写即时信息，不能年报
        List<YrRegCheck> yrRegCheckList = null;
        // 1.判断企业是否是当年度12月31日前成立的
        if (midBaseInfoDto.getEstDate() == null) {
        	return new ResultRtn<Boolean>("0", "您企业成立日期为空，无法正常登录，请联系您企业所属工商部门进行处理！");
        }else{
        	Date endDate = DateUtil.stringToDate(DateUtil.getPreYear() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss"); //获取上一年的时间
        	if(midBaseInfoDto.getEstDate().after(endDate)){ //判断当前企业成立日期是否大于上一年的时间   如果:是 表示是今年新成立的企业 ---> 只能填写即时信息，不能年报
        		yearReportFlag = false;
        	}
        }
        
        // 2.判断年报数据是否初始化, 即主表是否有数据
        try {
    		yrRegCheckList = yrRegCheckService.doGetYrRegCheckInit(midBaseInfoDto.getPriPID());//查询当前主表列表
    		ArrayList<Integer> yearList= new ArrayList<Integer>();
    		for(YrRegCheck yrRegCheck : yrRegCheckList) {
    			yearList.add(yrRegCheck.getYear());
    		}
    		String initYear = yearList.toString();
    		Date estDate = midBaseInfoDto.getEstDate();
    		//如果是个转企，按个转企时间初始化年报主表
    		if("1".equals(midBaseInfoDto.getIsIndivid()) && null != midBaseInfoDto.getIndividDate()) {
    			estDate = midBaseInfoDto.getIndividDate();
    		}
    		int estYear = Integer.valueOf(DateUtil.dateToString(estDate, "yyyy")); // 成立日期年度
    		int yrYear = 2013; //企业年报起始年度
    		if(Constants.entTypeCatgSFC.indexOf(midBaseInfoDto.getEntTypeCatg()) != -1) {
    			yrYear = 2014; //农专从14年度开始
    		}else if(midBaseInfoDto.getEntTypeCatg().equals(Constants.entTypeCatgPB)){
    			yrYear = 2015; //个体户从15年度开始
    		}
    		int startYear = estYear > yrYear ? estYear : yrYear; // 初始化起始年度
    		for(int i = startYear; i < Integer.valueOf(DateUtil.getCurrentYear()) ;i++) {
    			if(initYear.indexOf(String.valueOf(i)) == -1) {
    				logger.info("未初始化年度："+String.valueOf(i));
    				yrRegCheckService.doInitYrRegCheck(midBaseInfoDto.getPriPID(), i);
    			}
    		}
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResultRtn<Boolean>("0", "您企业年报数据初始化失败，无法正常登录，请联系您企业所属工商部门进行处理！" + ex);
        }
        return new ResultRtn<Boolean>(yearReportFlag);
    }
    
    /** 
     * 描述: 保存基本信息、登录方式到session
     * @auther ZhouYan
     * @date 2016年8月29日 
     * @param midBaseInfoDto
     * @param loginType
     * @throws Exception 
     */
    private void doSaveLoginSession(MidBaseInfoDto midBaseInfoDto, String loginType, boolean yearReportFlag,String certSn) throws Exception {
    	// 获取session
    	ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    	HttpSession session = attrs.getRequest().getSession();
    	// 设置基本信息到session
    	session.setAttribute("midBaseInfoDto", midBaseInfoDto);
    	// 设置登录方式到session
        session.setAttribute("loginType", loginType);
        // 设置是否符合年报标记
        session.setAttribute("yearReportFlag", yearReportFlag);
		//设置 证书序列号存到session中
		session.setAttribute("keyCerSn",certSn);
        logger.info("loginType:" + session.getAttribute("loginType").toString());
        //加日志
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID,midBaseInfoDto.getPriPID());//企业内部序号
        logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME,midBaseInfoDto.getEntName());//企业名称
        logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,midBaseInfoDto.getRegNO());//企业注册号
        logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());//年份
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGEENTYPE,midBaseInfoDto.getEntTypeCatg());//企业类型
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);//企业端
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, loginType);//登录方式
		logMap.put(ISysLogService.LOG_MAP_KEY_REMARK,"登录详情(2:联络员登录;5:数字证书登录)："+loginType+" | 证书序列号："+certSn);//登录方式 和  证书序列号
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.loginTypeLog.getCode());//操作类型
		sysLogService.doAddSysLog(logMap, attrs.getRequest());
    }
    
    /** 
     * 描述: 企业联络员登录
     * @auther ZhouYan
     * @date 2016年9月28日 
     * @param pubEppasswordDto
     * @return
     * @throws Exception 
     */
    @Override
	public ResultRtn<T> doPwdLogin(PubEppasswordDto pubEppasswordDto, String systemType)
			throws Exception {
    	// a.验证企业登录数据用户范围, 判断数据是否存在
    	MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(pubEppasswordDto.getRegno(), null, systemType);
        
    	if(midBaseInfoDto == null) {
    		return new ResultRtn<T>("0", "您企业不属于该系统用户范围，请确认所登录的年报网址是否正确！");
    	}
    	
        // b.判断企业登录业务
        boolean yearReportFlag = false;
        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
        if(!bizRtn.isSucess()){
        	//如果有业务异常，则返回
        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
        		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
        	}
    	}else{
    		yearReportFlag = bizRtn.isFlag();
    	}
        
      /*  // c.校验手机验证码登陆信息
        ResultRtn<T> pwdRtn = doCheckPubEppassword(pubEppasswordDto, midBaseInfoDto.getRegNO());
        if(!pwdRtn.isSucess()){
    		return pwdRtn;
    	}
        */
        // d.保存基本信息、登录方式到session
        doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_PWD, yearReportFlag,"");
        return new ResultRtn<T>(true);
	}
    
    /** 
	 * 描述: 校验手机验证码登陆信息
	 * @auther ZhouYan
	 * @date 2016年8月30日 
	 * @param pubEppasswordDto
	 * @throws Exception 
	 */
	private ResultRtn<T> doCheckPubEppassword(PubEppasswordDto pubEppasswordDto, String midRegNo) throws Exception {
        // 1.查询企业联络员登录信息
		if(StringUtils.isNotBlank(midRegNo)) {
			pubEppasswordDto.setUnicode(midRegNo);
		}
        List<PubEppassword> pubEppasswordList = pubEppasswordService.doCheckLogin(pubEppasswordDto);
        // 2.如果有信息, 说明企业登录信息输入正确, 则判断手机验证码是否过期
        if (pubEppasswordList != null && pubEppasswordList.size() > 0) {
        	if(DateUtil.getBetweenDaysToMut(pubEppasswordList.get(0).getCreatetime(), new Date()) > 1440){
        		return new ResultRtn<T>("0", "验证码已失效，请重新获取！ ");
        	}
       }else {
        	// 3.如果没有信息, 说明企业登录信息输入错误
        	return new ResultRtn<T>("0", "您输入的验证码有误，请重新输入！");
        }
        return new ResultRtn<T>(true);
    }

	/** 
	 * 描述: 个体户用户名密码登录
	 * @auther ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doPbPwdLogin(PubPbePassword pubPbePassword)
			throws Exception {
		// a.校验验证码
		
		// b.验证企业登录数据用户范围, 判断数据是否存在
    	MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(pubPbePassword.getRegNO(), null, Constants.SYSTEM_TYPE_PB);
    	
    	if(midBaseInfoDto == null) {
    		return new ResultRtn<T>("0", "您企业不属于该系统用户范围，请确认所登录的年报网址是否正确！");
    	}else{
    		// 如果个体工商户有统一社会信用代码必须以统一社会信用代码的方式登录；如果个体工商户没有统一社会信用代码允许以注册号登录。
            if (StringUtils.isNotBlank(midBaseInfoDto.getUniCode()) && !midBaseInfoDto.getUniCode().equals(pubPbePassword.getRegNO())) {
            	return new ResultRtn<T>("0", "个体工商户有统一社会信用代码必须以统一社会信用代码的方式登录！");
            }
    	}
        
        // c.判断企业登录业务
        boolean yearReportFlag = false;
        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
        if(!bizRtn.isSucess()){
        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
        		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
        	}
    	}else{
    		yearReportFlag = bizRtn.isFlag();
    	}
        if(!yearReportFlag) {
        	return new ResultRtn<T>("0", "个体工商户年度报告用户范围为" + DateUtil.getPreYear() + "年12月31日之前成立的个体工商户。");
        }
        
        // d.校验用户名密码登陆信息
        ResultRtn<T> pwdRtn = doCheckPubPbEppassword(pubPbePassword);
        if(!pwdRtn.isSucess()){
    		return pwdRtn;
    	}
        
        // e.保存基本信息、登录方式到session
        doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_PWD, yearReportFlag,"");
        return new ResultRtn<T>(true);
	}
	
	/** 
	 * 描述: 校验个体户用户名密码登陆信息
	 * @auther ZhouYan
	 * @date 2016年10月8日 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	private ResultRtn<T> doCheckPubPbEppassword(PubPbePassword pubPbePassword) throws Exception {
        // 1.查询个体户用户名密码登陆信息
        List<PubPbePassword> pubPbePasswordList = pubPbePasswordService.doCheckLogin(pubPbePassword);
        // 2.如果没有信息, 说明个体户登录信息输入错误
        if (pubPbePasswordList == null || pubPbePasswordList.isEmpty()) {
        	return new ResultRtn<T>("0", "您输入的信息有误，请重新输入！");
        }
        return new ResultRtn<T>(true);
    }

	/** 
	 * 描述: 个体户证书登录
	 * @auther ZhouYan
	 * @date 2016年10月8日 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doPbKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception {
		logger.info("******************浙江省网上政务大厅企业联合身份认证登录 start******************");
    	if (principal == null) {
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
        }
    	String usertype = principal.getAttributes().get("usertype").toString(); //用户类型
    	if("2".equals(usertype)){
    		String entname = StringUtil.doReplaceBlank(principal.getCorporateAttributes().get("companyName").toString());    //企业名称
        	String regno = principal.getCorporateAttributes().get("companyRegNumber").toString();   //工商注册号
        	String pripid = principal.getCorporateAttributes().get("companySerialNumber").toString();   //内部序号
        	String outDateString = CertUtil.getCertSubjectMapContent(principal.getAttributes().get("certBase64").toString()).get("certValidEndTime");//证书有效期
        	String uniscid = null;
        	if(principal.getCorporateAttributes().get("uscc") != null) {
        		uniscid = principal.getCorporateAttributes().get("uscc").toString();//统一代码
        	}
        	
        	logger.info("企业名称：" + entname);
        	logger.info("注册号：" + regno);
        	logger.info("内部序号：" + pripid);
        	logger.info("证书有效期：" + outDateString);
        	logger.info("统一代码：" + uniscid);
        	logger.info("从cookies取证书有效期校验标志：" + expiredFlag);
        	logger.info("******************浙江省网上政务大厅企业联合身份认证登录 end******************");
		
			// b.通过CAKey里面的注册号或内部序号查询企业信息, 并判断是否变更
	    	MidBaseInfoDto midBaseInfoDto = null;
	    	ResultRtn<MidBaseInfoDto> rtn = doGetMidBaseInfoForCAKeyLogin(regno, entname, pripid, Constants.SYSTEM_TYPE_PB);
	    	if(rtn.isSucess()){
	    		midBaseInfoDto = rtn.getData();
	    	}else{
	    		return new ResultRtn<T>(rtn.getErrorCode(),rtn.getError());
	    	}
	    	
	        // c.如证书过期标识为0, 验证证书日期，如过期，则转向延期操作, 并存储参数
	        if("0".equals(expiredFlag)){
	        	ResultRtn<T> certRtn = doCheckCertOutDate(outDateString);
	        	if(!certRtn.isSucess()){
	        		return certRtn;
	        	}
	        }
	        
	        // d.判断企业登录业务
	        boolean yearReportFlag = false;
	        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
	        if(!bizRtn.isSucess()){
	        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
            		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
            	}
	    	}else{
	    		yearReportFlag = bizRtn.isFlag();
	    	}
	        if(!yearReportFlag) {
	        	return new ResultRtn<T>("0", "个体工商户年度报告用户范围为" + DateUtil.getPreYear() + "年12月31日之前成立的个体工商户。");
	        }
	        
	        // e.保存基本信息、登录方式到session
	        doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_KEY, yearReportFlag,"");
    	}else{
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
    	}
		return new ResultRtn<T>(true);
	}
	

	/** 
	 * 描述: 农专证书登录
	 * @auther ZhouYan
	 * @date 2016年10月23日 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doSFCKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception {
		logger.info("******************浙江省网上政务大厅企业联合身份认证登录 start******************");
    	if (principal == null) {
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
        }
    	String usertype = principal.getAttributes().get("usertype").toString(); //用户类型
    	if("2".equals(usertype)){
    		String entname = StringUtil.doReplaceBlank(principal.getCorporateAttributes().get("companyName").toString());    //企业名称
        	String regno = principal.getCorporateAttributes().get("companyRegNumber").toString();   //工商注册号
        	String pripid = principal.getCorporateAttributes().get("companySerialNumber").toString();   //内部序号
        	String outDateString = CertUtil.getCertSubjectMapContent(principal.getAttributes().get("certBase64").toString()).get("certValidEndTime");//证书有效期
        	String uniscid = null;
        	if(principal.getCorporateAttributes().get("uscc") != null) {
        		uniscid = principal.getCorporateAttributes().get("uscc").toString();//统一代码
        	}
        	
        	logger.info("企业名称：" + entname);
        	logger.info("注册号：" + regno);
        	logger.info("内部序号：" + pripid);
        	logger.info("证书有效期：" + outDateString);
        	logger.info("统一代码：" + uniscid);
        	logger.info("从cookies取证书有效期校验标志：" + expiredFlag);
        	logger.info("******************浙江省网上政务大厅企业联合身份认证登录 end******************");
        
	        // a.通过CAKey里面的注册号或内部序号查询企业信息, 并判断是否变更
	    	MidBaseInfoDto midBaseInfoDto = null;
	    	ResultRtn<MidBaseInfoDto> rtn = doGetMidBaseInfoForCAKeyLogin(regno, entname, pripid, Constants.SYSTEM_TYPE_SFC);
	    	if(rtn.isSucess()){
	    		midBaseInfoDto = rtn.getData();
	    	}else{
	    		return new ResultRtn<T>(rtn.getErrorCode(),rtn.getError());
	    	}
	    	
	        // b.如证书过期标识为0, 验证证书日期，如过期，则转向延期操作, 并存储参数
	        if("0".equals(expiredFlag)){
	        	ResultRtn<T> certRtn = doCheckCertOutDate(outDateString);
	        	if(!certRtn.isSucess()){
	        		return certRtn;
	        	}
	        }
	        
	        // c.判断企业登录业务
	        boolean yearReportFlag = false;
	        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
	        if(!bizRtn.isSucess()){
	        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
            		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
            	}
	    	}else{
	    		yearReportFlag = bizRtn.isFlag();
	    	}
	        
	        // d.保存基本信息、登录方式到session
	        doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_KEY, yearReportFlag,"");
    	}else{
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
    	}
        return new ResultRtn<T>(true);
	}

	/*******************************************************国家局版本登录**************************************************************/

	/** 
	 * 描述:  国家局版本联络员登录
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doPwdAllLogin(PubEppasswordDto pubEppasswordDto)
			throws Exception {
		// a.验证企业登录数据用户范围, 判断数据是否存在
    	MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(pubEppasswordDto.getRegno(), null, null);
        
    	if(midBaseInfoDto == null) {
    		return new ResultRtn<T>("0", "您企业不属于该系统用户范围，请确认所登录的年报网址是否正确！");
    	}
    	
    	String systemType = null;
    	if(StringUtils.isNotBlank(midBaseInfoDto.getEntTypeCatg())){
    		systemType =  RepTypeUtil.getSystemType(midBaseInfoDto.getEntTypeCatg());
    	}else{
    		return new ResultRtn<T>("0", "企业类型为空！");
    	}
    	
        // b.判断企业登录业务
        boolean yearReportFlag = false;
        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
        if(!bizRtn.isSucess()){
        	//如果有业务异常，则返回
        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
        		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
        	}
    	}else{
    		yearReportFlag = bizRtn.isFlag();
    	}
        
        if(!yearReportFlag && (systemType.equals(Constants.SYSTEM_TYPE_PB) || systemType.equals(Constants.SYSTEM_TYPE_SFC))) {
        	String type = systemType.equals(Constants.SYSTEM_TYPE_PB) ? "个体工商户" : "农民专业合作社";
        	return new ResultRtn<T>("0", type + "年度报告用户范围为" + DateUtil.getPreYear() + "年12月31日之前成立的" + type +"。");
        }
        
        // c.校验手机验证码登陆信息
        ResultRtn<T> pwdRtn = doCheckPubEppassword(pubEppasswordDto, midBaseInfoDto.getRegNO());
        if(!pwdRtn.isSucess()){
    		return pwdRtn;
    	}
        
        // d.保存基本信息、登录方式到session
        doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_PWD, yearReportFlag,"");
        return new ResultRtn<T>(true);
	}

	/** 
	 * 描述: 国家局版本证书登录
	 * @auther ZhouYan
	 * @date 2016年12月11日 
	 * @param principal
	 * @param expiredFlag
	 * @return
	 * @throws Exception 
	 */
	@Override
	public ResultRtn<T> doKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception {
		logger.info("******************浙江省网上政务大厅企业联合身份认证登录 start******************");

		logger.info("打印证书信息：" + principal);

    	if (principal == null) {
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
        }
    	String usertype = principal.getAttributes().get("usertype").toString(); //用户类型
		   		logger.info("获取的key用户类型是：" + usertype);

		String regno= "";//获取工商注册号或统一信用代码

    	if("2".equals(usertype)){
    		String entname = StringUtil.doReplaceBlank(principal.getCorporateAttributes().get("companyName").toString());    //企业名称
				logger.info("获取到key的企业名称：" + entname);

			if(principal.getCorporateAttributes().get("companyRegNumber")!=null){
				 regno = principal.getCorporateAttributes().get("companyRegNumber").toString();   //工商注册号
				logger.info("获取到key的工商注册号：" + regno);
			}

        	String pripid = principal.getCorporateAttributes().get("companySerialNumber").toString();   //内部序号
				logger.info("获取到key的内部序号：" + pripid);

        	String outDateString = CertUtil.getCertSubjectMapContent(principal.getAttributes().get("certBase64").toString()).get("certValidEndTime");//证书有效期
				logger.info("获取到key的证书有效期：" + outDateString);

			String certSn = principal.getAttributes().get("certSn").toString();//证书序列号
				logger.info("获取到key的证书序列号：" + certSn);

        	String uniscid = null;
        	if(principal.getCorporateAttributes().get("uscc") != null) {
        		uniscid = principal.getCorporateAttributes().get("uscc").toString();//统一代码
				logger.info("获取到key的统一代码：" + uniscid);
        	}

			//如果注册号为空  则将统一信用代码的值赋值给 regno
			if(StringUtils.isBlank(regno)){
				regno = uniscid;
				logger.info("注册号为空的情况下将统一代码赋值给regno：" + regno);
			}
			
        	logger.info("企业名称：" + entname);
        	logger.info("内部序号：" + pripid);
        	logger.info("证书有效期：" + outDateString);
        	logger.info("统一代码：" + uniscid);
        	logger.info("从cookies取证书有效期校验标志：" + expiredFlag);
        	logger.info("******************浙江省网上政务大厅企业联合身份认证登录 end******************");
        	
        	// a.通过CAKey里面的注册号或内部序号查询企业信息, 并判断是否变更
        	MidBaseInfoDto midBaseInfoDto = null;
        	ResultRtn<MidBaseInfoDto> rtn = doGetMidBaseInfoForCAKeyLogin(regno, entname, pripid, null);
        	if(rtn.isSucess()){
        		midBaseInfoDto = rtn.getData();
        	}else{
        		return new ResultRtn<T>(rtn.getErrorCode(),rtn.getError());
        	}
        	
            // b.如证书过期标识为0, 验证证书日期，如过期，则转向延期操作, 并存储参数
            if("0".equals(expiredFlag)){
            	ResultRtn<T> certRtn = doCheckCertOutDate(outDateString);
            	if(!certRtn.isSucess()){
            		return certRtn;
            	}
            }
            
            String systemType = null;
        	if(StringUtils.isNotBlank(midBaseInfoDto.getEntTypeCatg())){
        		systemType =  RepTypeUtil.getSystemType(midBaseInfoDto.getEntTypeCatg());
        	}else{
        		return new ResultRtn<T>("0", "企业类型为空！");
        	}
            
            // c.判断企业登录业务
            boolean yearReportFlag = false;
            ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
            if(!bizRtn.isSucess()){
            	//如果有业务异常，则返回
            	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
            		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
            	}
        	}else{
        		yearReportFlag = bizRtn.isFlag();
        	}
            
            if(!yearReportFlag && (systemType.equals(Constants.SYSTEM_TYPE_PB) || systemType.equals(Constants.SYSTEM_TYPE_SFC))) {
            	String type = systemType.equals(Constants.SYSTEM_TYPE_PB) ? "个体工商户" : "农民专业合作社";
            	return new ResultRtn<T>("0", type + "年度报告用户范围为" + DateUtil.getPreYear() + "年12月31日之前成立的" + type +"。");
            }
            
            // d.保存基本信息、登录方式到session
            doSaveLoginSession(midBaseInfoDto, Constants.LOGIN_TYPE_OAUTH, yearReportFlag,certSn);
    	}else{
    		return new ResultRtn<T>("0", "联合身份认证登录失败，请用数字证书登录!");
    	}
    	return new ResultRtn<T>(true);
	}
	
	
	
	
	
	/**********************************************App联络员手机号登录校验*****************************************************************/
	
	/**
	 * 
	 * 描述: App联络员手机号登录校验
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResultRtn<T> doPbPwdAppLogin(PubEppasswordDto pubEppasswordDto) throws Exception {
		// a.验证企业登录数据用户范围, 判断数据是否存在

		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(pubEppasswordDto.getRegno(), null, "2");
        
    	if(midBaseInfoDto == null) {
    		return new ResultRtn<T>("1", "您个体户不属于该系统用户范围，请确认所登录的年报网址是否正确！");
    	}
    	
    	String systemType = null;
    	if(StringUtils.isNotBlank(midBaseInfoDto.getEntTypeCatg())){
    		systemType =  RepTypeUtil.getSystemType(midBaseInfoDto.getEntTypeCatg());
    	}else{
    		return new ResultRtn<T>("2", "核准表企业类型为空！");
    	}
    	
        // b.判断企业登录业务
        boolean yearReportFlag = false;
        ResultRtn<Boolean> bizRtn = doCheckLoginDataBiz(midBaseInfoDto);
        if(!bizRtn.isSucess()){
        	//如果有业务异常，则返回
        	if(StringUtils.isNotBlank(bizRtn.getErrorCode())) {
        		return new ResultRtn<T>(bizRtn.getErrorCode(),bizRtn.getError());
        	}
    	}else{
    		yearReportFlag = bizRtn.isFlag();
    	}
        
        if(!yearReportFlag && (systemType.equals(Constants.SYSTEM_TYPE_PB) || systemType.equals(Constants.SYSTEM_TYPE_SFC))) {
        	String type = systemType.equals(Constants.SYSTEM_TYPE_PB) ? "个体工商户" : "农民专业合作社";
        	return new ResultRtn<T>("0", type + "年度报告用户范围为" + DateUtil.getPreYear() + "年12月31日之前成立的" + type +"。");
        }
        return new ResultRtn<T>(true);
	}
	
	
}