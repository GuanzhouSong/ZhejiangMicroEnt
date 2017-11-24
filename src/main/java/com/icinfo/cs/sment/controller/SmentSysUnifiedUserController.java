/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.UnifiedUserRecord;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysRoleService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.system.service.IUnifiedUserRecordService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;

/**
 * 
 * 描述:  统一用户管理
 * @author: 赵祥江
 * @date: 2017年9月5日 下午3:17:25
 */
@Controller
@RequestMapping("/smentunified/sysuser")
public class SmentSysUnifiedUserController extends CSBaseController {
    private final static Logger logger = LoggerFactory.getLogger(SmentSysUnifiedUserController.class);
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ICodeEntcatgService codeEntcatgService;
    @Autowired
    private IDepartMentService departMentService; 
    @Autowired
    private ISysLogService sysLogService;
    
    @Autowired
    private IUnifiedUserRecordService unifiedUserRecordService;
    
	/**
	 * 同步新增修改用户的方法
	 */
	public static final String SYNCUSER = "synchronizeUser";
	
	
	/**
	 * 同步删除用户的方法
	 */
	public static final String DELETEUSER = "deleteUser";
    
    
    /**
     * 
     * 描述   添加/修改统一户
     * @author 赵祥江
     * @date 2017年6月7日 下午2:45:14 
     * @param 
     * @return JSONObject
     * @throws
     */
    @RequestMapping(value = "/synchronizeUser")
   	@ResponseBody 
    public  JSONObject  synchronizeUser(String loginname,String orgcoding,String userid, String servicecode,String servicepwd,String method, String time,String sign,String describe,String args)
       { 
    	//删除
    	if(DELETEUSER.equals(method)){
    		return deleteUser(orgcoding, userid);
    	}else{//新增和修改
    		//访问参数验证
    	    String  key="xwqy";
    	    String unifiedState="0";
    	    String unifiedMessage="同步成功";
           	JSONObject jsonObj = new JSONObject();
           	Map<String,String> parmMap=new HashMap<String,String>(); 
           	UnifiedUserRecord unifiedUserRecord =new UnifiedUserRecord();
           		try {
               		//校验会话的合法性
           			if(!key.equals(servicecode)){ 
           				jsonObj.put("result",  "2001");
           				return jsonObj;  
           			}
           			int a=0;
           			if(StringUtil.isBlank(args)){
           				jsonObj.put("result",  "2012");
           				return jsonObj;  
           			}
           			//JSONArray  jSONArray=null;
           			JSONObject jsonObj2 =null;
           			try {
           				args=StringEscapeUtils.unescapeHtml4(args);
           				//内容 
           				unifiedUserRecord.setContent(args);
           				jsonObj2=JSONObject.fromObject(args);  
           				if(jsonObj2!=null&&!jsonObj2.containsKey("userid")){
           					jsonObj.put("result",  "2012");
           					logger.error("统一用户同步参数错误:userid不能为空");
           					return jsonObj; 
           				}
        			} catch (Exception e) {
        				e.printStackTrace();
        				jsonObj.put("result",  "2012");
        				logger.error("统一用户同步序列化参数错误", e);
           				return jsonObj; 
        			}
           	       	if(jsonObj2!=null){
               		       //用户主键ID
           	       			 userid=getParmVal(jsonObj2,"userid");
	           	       		 //校验用户id
	           	  			 if(StringUtil.isBlank(userid)){ 
	           	  				jsonObj.put("result", "2099");
	           	  				return jsonObj;
	           	  			 }
           	       			//组织机构编码
           	       			 orgcoding=getParmVal(jsonObj2,"orgcoding");
           	       			//旧组织机构编码（如果不调换组织机构，不要传该参数）
           	       			String oldorgcoding=getParmVal(jsonObj2,"oldorgcoding");
           	       			//附属组织机构编码,多						个附属组织以”;” (英文输入法、半角)分号隔开
           	       			String extendorgcoding=getParmVal(jsonObj2,"extendorgcoding"); 
           	       			//附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
           	       			String extendorderby=getParmVal(jsonObj2,"extendorderby");
           	       			//用户的真实姓名(新增时，不能为空)
           	       			String username=getParmVal(jsonObj2,"username");
           	       		    //旧登录名（如果不调换组织机构，不要传该参数。用户换组织和修改登录名不会同时进行）
           	       			String oldloginname=getParmVal(jsonObj2,"oldloginname");
           	       			//登录名
           	       			 loginname=getParmVal(jsonObj2,"loginname");
           	       			//密码加密类型 值为：1. 表示明文  2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）  4 .AES （sun自带库加密
           	       			String encryptiontype=getParmVal(jsonObj2,"encryptiontype");
           	       			//密码（编辑统一用户时为空默认为原密码）
           	       			String loginpwd=getParmVal(jsonObj2,"loginpwd");
           	       			//邮件
           	       			String email=getParmVal(jsonObj2,"email");
           	       			//手机号码（常用手机）
           	       			String mobile=getParmVal(jsonObj2,"mobile");
           	       			//手机号码2（备用手机）
           	       			String mobile2=getParmVal(jsonObj2,"mobile2");
           	       			//座机号码（常用电话）
           	       			String telephone=getParmVal(jsonObj2,"telephone");
           	       			//座机号码2（备用电话）
           	       			String telephone2=getParmVal(jsonObj2,"telephone2");
           	       			//虚拟网号
           	       			String virtualnum=getParmVal(jsonObj2,"virtualnum");
           	       			//职务，可能有多个。（多个职务之间用半角字符“;”隔开）
           	       			String userposition=getParmVal(jsonObj2,"userposition");
           	       			//职称
           	       			String usertitle=getParmVal(jsonObj2,"usertitle");
           	       			//邮编
           	       			String postcode=getParmVal(jsonObj2,"postcode"); 
           	       			//CA证书KEY
           	       			String cakey=getParmVal(jsonObj2,"cakey");
           	       			//性别 1男 2女
           	       			String sex=getParmVal(jsonObj2,"sex"); 
           	       			//生日
           	       			String birthday=getParmVal(jsonObj2,"birthday"); 
           	       			//国籍
           	       			String country=getParmVal(jsonObj2,"country"); 
           	       			//省级
           	       			String province=getParmVal(jsonObj2,"province");
           	       			//城市
           	       			String city=getParmVal(jsonObj2,"city"); 
           	       			//办公室地址
           	       			String officeaddress=getParmVal(jsonObj2,"officeaddress"); 
           	       			//办公室号
           	       			String officenum=getParmVal(jsonObj2,"officenum") ;
           	       			//办公电话
           	       			String officephone=getParmVal(jsonObj2,"officephone");
           	       			//办公传真
           	       			String officefax=getParmVal(jsonObj2,"officefax");
           	       			//家庭电话
           	       			String homephone=getParmVal(jsonObj2,"homephone");
           	       			//家庭地址
           	       			String homeaddress=getParmVal(jsonObj2,"homeaddress");
           	       			//是否在编    1 在编2 不在编
           	       			String official=getParmVal(jsonObj2,"official");
           	       			//编制类别  1：行政编制  2：事业编制
           	       			String officialtype=getParmVal(jsonObj2,"officialtype");
           	       			//证件类型证件类型1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
           	       			String idtype=getParmVal(jsonObj2,"idtype");
           	       			//证件号码
           	       			String idnum=getParmVal(jsonObj2,"idnum");
           	       			//用户激活状态  1激活，2未激活
           	       			String useable=getParmVal(jsonObj2,"useable");
           	       			//排序
           	       			String orderby=getParmVal(jsonObj2,"orderby");
           	       			//头像地址
           	       			String headpicture=getParmVal(jsonObj2,"headpicture");
           	       			//管辖单位
           	       			String localadm=getParmVal(jsonObj2,"gxdwdm"); 
           	       	    	//登记机关
           	       			String djjg=getParmVal(jsonObj2,"djjg"); 
           	       	    	
           	       		
           	       	        unifiedUserRecord.setUserId(userid);
           	       	        unifiedUserRecord.setOrgCoding(orgcoding);
           	       	        unifiedUserRecord.setOldOrgCoding(oldorgcoding);
           	       	        unifiedUserRecord.setExTendOrgCoding(extendorgcoding);
           	       	        unifiedUserRecord.setExTendOrderBy(extendorderby);     
           	       	        unifiedUserRecord.setUserName(username);
           	       	  		unifiedUserRecord.setOldLoginName(oldloginname);
           	       	  		unifiedUserRecord.setLoginName(loginname);
           	       	  		unifiedUserRecord.setEncrypTionType(encryptiontype);
           	       	  		unifiedUserRecord.setLoginPwd(loginpwd);
           	       	  		unifiedUserRecord.setEmail(email); 
           	       	  		unifiedUserRecord.setMobile(mobile);
           	       	  		unifiedUserRecord.setMobile2(mobile2);		
           	       	  		unifiedUserRecord.setTelepHone(telephone);
           	       	  		unifiedUserRecord.setTelepHone2(telephone2);
           	       	  		unifiedUserRecord.setVirtualNum(virtualnum);
           	       	  		unifiedUserRecord.setUserPosiTion(userposition); 
           	       	  		unifiedUserRecord.setUserTitle(usertitle);
           	       	  		unifiedUserRecord.setPostCode(postcode);
           	       	  		unifiedUserRecord.setCaKey(cakey);
           	       	  		unifiedUserRecord.setSex(sex);
           	       	  		if(StringUtil.isNotBlank(birthday)){
           	       	  			unifiedUserRecord.setBirthDay(DateUtil.stringToDate(birthday,"yyyy-MM-dd") ); 
           	       	  		}
           	       	  		unifiedUserRecord.setCountry(country);
           	       	  		unifiedUserRecord.setProvince(province);
           	       	  		unifiedUserRecord.setCity(city);
           	       	  		unifiedUserRecord.setOfficeAddress(officeaddress);
           	       	  		unifiedUserRecord.setOfficeNum(officenum);
           	       	  		unifiedUserRecord.setOfficePhone(officephone);
           	       	  		unifiedUserRecord.setOfficeFax(officefax);
           	       	  		unifiedUserRecord.setHomePhone(homephone);
           	       	  		unifiedUserRecord.setHomeAddress(homeaddress);
           	       	  		unifiedUserRecord.setOfficial(official);
           	       	  		unifiedUserRecord.setOfficialType(officialtype);
           	       	  		unifiedUserRecord.setIdType(idtype);
           	       	  		unifiedUserRecord.setIdNum(idnum);
           	       	  		unifiedUserRecord.setUseAble(useable);
           	       	  		unifiedUserRecord.setOrderby(orderby);
           	       	  		unifiedUserRecord.setHeadPicture(headpicture);
           	       	  		unifiedUserRecord.setRemark(describe); 
           	       	  		if(StringUtil.isNotBlank(localadm)){
           	       	  		   //管辖单位 如果没有八位补足八位
           	       	  		   unifiedUserRecord.setLocalAdm(subStrEight(localadm));
           	       	  		   //直属分局 
           	       	  		   if("33001000".equals(unifiedUserRecord.getLocalAdm())){
           	       	  		       unifiedUserRecord.setRegOrg("330000"); 
           	       	  		   }
           	       	  		}
           	       	  		if(StringUtil.isNotBlank(djjg)&&StringUtil.isBlank(unifiedUserRecord.getRegOrg())){
           	       	  			//直属分局 
     	       	  			    if("330010".equals(djjg)){
     	       	  			    	unifiedUserRecord .setRegOrg("330000"); 
     	       	  			    }else{
     	       	  			    	unifiedUserRecord .setRegOrg(djjg); 
     	       	  			    }
           	       	  		} 
           	       	  		unifiedUserRecord.setUserType(DBAuthorConstants.USER_TYPE_SMENT); 
           	       			SysUser sysUser=new SysUser();
           	       			if(StringUtil.isNotBlank(loginname)){
           	       				sysUser.setUsername(loginname);
           	       			}
           	       			if(StringUtil.isNotBlank(loginpwd)){
           	       				sysUser.setPassword(loginpwd);
           	       			}
           	       			if(StringUtil.isNotBlank(username)){
           	       				sysUser.setRealName(username);
           	       			}
           	       			if(StringUtil.isNotBlank(email)){
           	       				sysUser.setEmail(email);
           	       			}
           	       			sysUser.setUserId(userid);
           	       			if(StringUtil.isNotBlank(useable)){
           	       				sysUser.setStatus("2".equals(useable)?"0":useable);
           	       			}
           	       			if(StringUtil.isNotBlank(officeaddress)){
           	       				sysUser.setDesc(officeaddress);
           	       			}
           	       			//TODO 科室
           	       			sysUser.setDeptName(null);
           	       			
           	       			if(StringUtil.isNotBlank(userposition)){
           	       				sysUser.setPost(userposition);
           	       			}
           	       			if(StringUtil.isNotBlank(mobile)){
           	       				sysUser.setTelPhone(mobile);
           	       			}
           	       			if(StringUtil.isNotBlank(telephone)){
           	       				sysUser.setPhone(telephone);
           	       			}
           	       			if(StringUtil.isNotBlank(officephone)){
           	       				sysUser.setPhoneExt(officephone);
           	       			} 
           	   				//TODO 用户设置人
           	   				sysUser.setUserSetPerson(null); 
           	   			    //系统类型
           	   	   		    sysUser.setUserType(DBAuthorConstants.USER_TYPE_SMENT);  
           	       		    //根据用户和系统类型查询用户
           	       		    parmMap.put("userId", userid);
           	       		    parmMap.put("userType", DBAuthorConstants.USER_TYPE_SMENT);
           	       		    SysUser sysUserTem =null;
           	       		    List<SysUser> sysUserList=sysUserService.selectSysUser(parmMap);
           	       		    if(sysUserList!=null&&sysUserList.size()>0){
           	       		    	sysUserTem = sysUserList.get(0); 
           	       		    } 
           	    		    //新增
           	    		    if(sysUserTem==null){
           	    		    	if(StringUtil.isBlank(sysUser.getUsername())){
           	    		    		jsonObj.put("result",  "2004");
           	    	   				return jsonObj; 
           	    		    	}
           	    		    	if(StringUtil.isBlank(sysUser.getPassword())){
           	    		    		jsonObj.put("result",  "2007");
           	    	   				return jsonObj; 
           	    		    	} 
           	    		    	//加密后的密码
           	    		    	sysUser.setUserPasswordKey(AESEUtil.encodeCorpid(sysUser.getPassword()));
           	    		    	if(StringUtil.isBlank(sysUser.getRealName())){
           	    		    		jsonObj.put("result",  "2017");
           	    	   				return jsonObj; 
           	    		    	}
           	    		    	//部门
           	    		    	if(StringUtil.isBlank(localadm)&&StringUtil.isBlank(djjg)){
           	    		    		jsonObj.put("result",  "2005");
           	    	   				return jsonObj; 
           	    		    	}
           	    		    	DepartMent departMent=null;
           	    		    	String deStr="00000";
           	    		    	if(StringUtil.isBlank(localadm)||localadm.length()!=8){
           	    		    		if(StringUtil.isNotBlank(localadm)){
           	    		    			deStr=subStrEight(localadm);
           	    		    		}else if(StringUtil.isBlank(djjg)){
           	    		    			jsonObj.put("result",  "2005");
               	    	   				return jsonObj;
           	    		    		}else{
           	    		    			deStr=subStrEight(djjg);
           	    		    		}
           	    		    	}else{
           	    		    		deStr=localadm;
           	    		    	}
           	    		    	departMent=departMentService.selectDepartMentByDeptCode(deStr);
           	    		    	if(departMent==null){
           	    		    		jsonObj.put("result",  "2005");
           	    	   				return jsonObj;
           	    		    	}
           	    		    	//删除标识0 正常 1 已删除
           	    		    	sysUser.setDeleteFlag("0");
           	    		    	//用户所属部门
           	    		    	sysUser.setDeptCode(departMent.getDeptDID());
           	    		    	//SysUser sysUsers=sysUserService.selectByLoginName(sysUser.getUsername(), DBAuthorConstants.USER_TYPE_SMENT);
           	    		    	//Status 0 无效 1 有效 2删除
           	    		    	/*if(sysUsers!=null&&!sysUsers.getUserId().equals(userid)&&!"2".equals(sysUsers.getStatus())){
           	    		    		jsonObj.put("result",  "2010");
           	    	   				return jsonObj; 
           	    		    	} */
           	    		    	unifiedUserRecord.setStateType("0");
           	    		    	sysUser.setId(StringUtil.uuid());
           	    		    	//默认本部门权限
           	    		    	sysUser.setSearchRangeLevel("1");
           	    		    	a= sysUserService.insertUnifiedUser(sysUser); 
           	    		    	if(a>0){ 
           	    		    		//保存日志
           	    					//saveUnifiedLog("新增统一用户:【"+sysUser.getUsername()+"】、姓名【"+sysUser.getRealName()+"】","0");
           	    		    	}else{
           	    		    		unifiedState="2099";
           	    		    		unifiedMessage="同步失败";
           	    		    	}
           	    		    }else{//修改
           	    		    	if(StringUtil.isNotBlank(sysUser.getPassword())){
           	    		    		//加密后的密码
           		    		    	sysUser.setUserPasswordKey(AESEUtil.encodeCorpid(sysUser.getPassword()));
        	    		    	}  
           	    		    	sysUser.setId(sysUserTem.getId()); 
           	    		    	a=sysUserService.updateSysUserByUidAndUserType(sysUser);
           	    		    	unifiedUserRecord.setStateType("1");
           	    		    	if(a>0){
           	    		    		//保存日志
           	    					//saveUnifiedLog("修改统一用户:【"+sysUser.getUsername()+"】、姓名【"+sysUser.getRealName()+"】","1");
           	    		    	}else{
           	    		    		unifiedState="2099";
           	    		    		unifiedMessage="同步失败";
           	    		    	}
           	    		    }
           	    		    unifiedUserRecord.setUnifiedState(unifiedState);
        		    		unifiedUserRecord.setUnifiedMessage(unifiedMessage);
        		    		unifiedUserRecord.setUserId(sysUser.getUserId());
        	   	    		//保存
        	   	       		unifiedUserRecordService.insertUnifiedUserRecord(unifiedUserRecord);	
               			
               			}
           		    if(a>0){
           	    		jsonObj.put("result",  "0"); 
           	    	}else{
           	    		jsonObj.put("result",  "2099"); 
           	    	}    
           		} catch (Exception e) {
           			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
           			e.printStackTrace(new PrintStream(baos));  
           			String exception = baos.toString();
        			//保存
               		try {
               			unifiedState="2099";
        	    		unifiedMessage="系统异常"+exception.trim();
        	    		if(unifiedMessage.length()>1000){
        	    			unifiedMessage=unifiedMessage.substring(0, 1000);
        	    		}
        	    		unifiedUserRecord.setUnifiedState(unifiedState);
        	    		unifiedUserRecord.setUnifiedMessage(unifiedMessage);
        				unifiedUserRecordService.insertUnifiedUserRecord(unifiedUserRecord);
        			} catch (Exception e1) {
        				e1.printStackTrace();
        				logger.error("统一用户错误", e1);
        			}
        	       	logger.error("统一用户错误", e);
           			jsonObj.put("result",  "2099"); 
           		} 
           		return jsonObj;
    	   } 
       }
    
    
    
    /**
     * 
     * 描述   删除用户
     * @author 赵祥江
     * @date 2017年6月5日 下午2:42:16 
     * @param 
     * @return JSONObject
     * @throws
     */
    public  JSONObject  deleteUser(
    		String orgcoding,String userid){
    	Map<String,String> parmMap=new HashMap<String,String>();
    	JSONObject jsonObj = new JSONObject();
    	String unifiedState="0";
    	String stateType="2";
    	String unifiedMessage="删除成功"; 
    	String loginname="";
    	UnifiedUserRecord unifiedUserRecord=new UnifiedUserRecord();
    	unifiedUserRecord.setUserType(DBAuthorConstants.USER_TYPE_SMENT);
    	try { 
    		//校验用户id 用户名 
			if(StringUtil.isBlank(userid)){ 
				jsonObj.put("result", "2104");
				return jsonObj;
			}
			//根据用户和系统类型查询用户
  		    parmMap.put("userId", userid);
  		    parmMap.put("userType", DBAuthorConstants.USER_TYPE_SMENT);
  		    SysUser sysUser =null;
  		    List<SysUser> sysUserList=sysUserService.selectSysUser(parmMap);
  		    if(sysUserList!=null&&sysUserList.size()>0){
  		    	sysUser = sysUserList.get(0); 
  		    } 
			if(sysUser!=null){ 
				loginname=sysUser.getUsername();
       	        unifiedUserRecord.setUserName(sysUser.getRealName());
       	  		try {
       	  			//密码解密
       	  			if(StringUtil.isNotBlank(sysUser.getUserPasswordKey())){
          	  		 unifiedUserRecord.setLoginPwd(AESEUtil.decodeCorpid(sysUser.getUserPasswordKey()));
          	  		} 
				} catch (Exception e) {
				} 
       	  		unifiedUserRecord.setEmail(sysUser.getEmail()); 
       	  		unifiedUserRecord.setMobile(sysUser.getTelPhone());
       	  		unifiedUserRecord.setTelepHone(sysUser.getPhone());
       	  		unifiedUserRecord.setUserPosiTion(sysUser.getPost()); 
       	  		unifiedUserRecord.setOfficePhone(sysUser.getPhoneExt());
				SysUser sysUserTem =new SysUser();
				sysUserTem.setId(StringUtil.isBlank(sysUser.getId())?"000000":sysUser.getId());
				//删除标识 0  正常
				sysUserTem.setDeleteFlag("1");
				sysUserTem.setStatus("0");
				int i=sysUserService.updateSysUserByUidAndUserType(sysUserTem);
				if(i>0){
					jsonObj.put("result",  "0");
					//保存日志
					//saveUnifiedLog("删除统一用户:【用户名:"+sysUser.getUsername()+"】、姓名【"+sysUser.getRealName()+"】、【用户id:"+userid+"】","2");
				}else{
					unifiedState="2104";
					unifiedMessage="删除失败,根据登录名:【"+loginname+"】、【用户id:"+userid+"】没有找到用户信息";
				}
			}else{
				unifiedState="2104";
				jsonObj.put("result",unifiedState);
				unifiedMessage="删除失败,根据登录名:【"+loginname+"】、【用户id:"+userid+"】没有找到用户信息";
			} 
			unifiedUserRecord.setOrgCoding(orgcoding);
			unifiedUserRecord.setUserId(userid); 
			unifiedUserRecord.setLoginName(loginname);
			//unifiedUserRecord.setRemark(describe); 
			unifiedUserRecord.setStateType(stateType);
			unifiedUserRecord.setUnifiedState(unifiedState);
    		unifiedUserRecord.setUnifiedMessage(unifiedMessage);
    		unifiedUserRecordService.insertUnifiedUserRecord(unifiedUserRecord);
		} catch (Exception e) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
   			e.printStackTrace(new PrintStream(baos));  
   			String exception = baos.toString();
			jsonObj.put("result",  "2099"); 
			unifiedUserRecord.setUnifiedState("2099");
    		unifiedUserRecord.setStateType(stateType);
    		try { 
	    		unifiedMessage="系统异常"+exception.trim();
	    		if(unifiedMessage.length()>1000){
	    			unifiedMessage=unifiedMessage.substring(0, 1000);
	    		}
	    		unifiedUserRecord.setUnifiedMessage(unifiedMessage);
				unifiedUserRecordService.insertUnifiedUserRecord(unifiedUserRecord);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
    	return jsonObj;
    } 
    
    /**
     * 
     * 描述   获取参数值
     * @author 赵祥江
     * @date 2017年7月28日 下午5:41:52 
     * @param 
     * @return boolean
     * @throws
     */
    private String  getParmVal(JSONObject jsObj,String prarm) throws Exception{
    	 if(jsObj!=null&&jsObj.containsKey(prarm)&&jsObj.get(prarm)!=null&&!"".equals(jsObj.get(prarm))){
    		 return jsObj.get(prarm).toString();
    	 }
    	 return null;
    }
    
    
    /**
     * 
     * 描述   保存统一用户登录日志
     * @author 赵祥江
     * @date 2017年6月6日 上午10:02:14 
     * @param 
     * @return void
     * @throws
     */
     private void saveUnifiedLog(String  msgContent,String addFlag){
         try{
             Map<String,String> logMap=new HashMap<String,String>();
             logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
             logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,DBAuthorConstants.USER_TYPE_SMENT);//小微系统
             logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
             if("0".equals(addFlag)){
            	 logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.smentaddUnifiedLog.getCode());//操作类型-新增
             }else if("1".equals(addFlag)){
            	 logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.smenteditUnifiedLog.getCode());//操作类型-修改
             }else if("2".equals(addFlag)){
            	 logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.smentdelUnifiedLog.getCode());//操作类型-删除
             }
             sysLogService.doAddSysLog(logMap,getRequest());
         }catch(Exception e){
             logger.error("记录小微系统统一用户日志时出现异常:"+e.getMessage());
         }
     }
     
     
    /**
     * 
     * 描述   根据传入字符串的长度 返回八位长度的字符串
     * @author 赵祥江
     * @date 2017年9月18日 下午3:50:43 
     * @param 
     * @return String
     * @throws
     */
 	private  String subStrEight(String deptStr) throws Exception {
		String proveNo="";
		if(deptStr.length()<8){
			 for(int i=0;i<8-deptStr.length();i++){
				 proveNo+="0";
			 }
			 deptStr+=proveNo;
		}else{
			deptStr=deptStr.substring(0, 8);
		} 
		return deptStr;
	}
}
