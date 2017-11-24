package com.icinfo.cs.login.controller.reg.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.cs.yr.service.IPubPbePasswordService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/** 
 * 描述: 密码管理企业端<br>
 * @author ZhouJun
 * @date 2016年9月23日  
 */
@Controller
@RequestMapping("reg/client/login/pbepassword")
public class YrPbePasswordController extends BaseController{
	@Autowired IPubPbePasswordService pubPbePasswordService;

	/** 
	 * 描述: 进入忘记密码页面
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @return 
	 */
	@RequestMapping("toForgetPassword")
	public String toForgetPassword(){
		return "reg/client/login/pbforgetpassword";
	}
	
	/** 
	 * 描述: 进入获取密码页面
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @return 
	 */
	@RequestMapping("toGetPassword")
	public String toGetPassword(){
		return "reg/client/login/pbgetpassword";
	}
	
	
	/** 
	 * 描述: 根据number从密码表或者中间表查询数据
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param number
	 * @param flag
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="checkInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkInfo(String number,@RequestParam(required=false) String flag) throws Exception{
		Map<String,Object> maps= new HashMap<>();
		MidBaseInfo mbi = new MidBaseInfo();
		PubPbePassword ppp =new PubPbePassword();
		if(number.length()==15||number.length()==13){
			if(StringUtil.isNotEmpty(flag)&"forget".equals(flag)){
				PubPbePassword mid =pubPbePasswordService.selectOneByRegNO(number);
				if(mid!=null){
				ppp.setEntName(mid.getEntName());
				ppp.setLiaName(mid.getLiaName());
				ppp.setLiaIDNum(mid.getLiaIDNum());
				ppp.setTel(mid.getTel());
				maps.put("MidBaseInfo", ppp);
				maps.put("msg","success");}
				else{
					maps.put("msg","noexist");
				}
			}else {
				if(pubPbePasswordService.selectOneByRegNO(number)!=null){
					maps.put("msg","exis");
					return maps;
				}
			MidBaseInfo  mid = pubPbePasswordService.selectBaseInfoByConditions(number, "", "");
			if(mid!=null){
				mbi.setLeRep(mid.getLeRep());
				mbi.setEntName(mid.getEntName());
				mbi.setTel(mid.getTel());
				mbi.setCerNO(mid.getCerNO());
				maps.put("MidBaseInfo", mbi);
				maps.put("msg","success");}else{
					maps.put("msg","error");
				}
			}
		}else if(number.length()==18){
			if(StringUtil.isNotEmpty(flag)&&"forget".equals(flag)){
				PubPbePassword mid =	pubPbePasswordService.selectOneByUniCode(number);
				if(mid!=null){
				ppp.setEntName(mid.getEntName());
				ppp.setLiaName(mid.getLiaName());
				ppp.setLiaIDNum(mid.getLiaIDNum());
				ppp.setTel(mid.getTel());
				maps.put("MidBaseInfo", ppp);}else{
					maps.put("msg","noexist");
				}
			}else {
				if(pubPbePasswordService.selectOneByUniCode(number)!=null){
					maps.put("msg","exis");
				}
			MidBaseInfo  mid = pubPbePasswordService.selectBaseInfoByConditions("", number, "");
			if(mid!=null){
			mbi.setLeRep(mid.getLeRep());
			mbi.setEntName(mid.getEntName());
			mbi.setTel(mid.getTel());
			mbi.setCerNO(mid.getCerNO());
			maps.put("MidBaseInfo", mbi);
			maps.put("msg","success");}else{
				maps.put("msg","error");
			}
			
			}
		}else {
			maps.put("msg", "error");
		}
		return maps;
	}
	
	/** 
	 * 描述: 插入密码表
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param tel
	 * @param number
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="insertPassword",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertPassword(String tel,String number) throws Exception{
		Map<String,Object> maps= new HashMap<>();
		MidBaseInfo  mbi = null;
		if(number.length()==15||number.length()==13){
			mbi = pubPbePasswordService.selectBaseInfoByConditions(number, "", "");
		}else if(number.length()==18){
			mbi = pubPbePasswordService.selectBaseInfoByConditions("", number, "");
		}
		PubPbePassword ppp =pubPbePasswordService.convertMidBaseInfoToPubPbePassword(mbi, tel);
		String pwd = StringUtil.NextInt(000000, 999999).toString();
		ppp.setPassword(pwd);
		if(pubPbePasswordService.insert(ppp)){
			maps.put("msg", "success");
		}else {
			maps.put("msg","false");
		}
		
		return maps;
	}
	
	/** 
	 * 描述: 更新密码
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param number
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="forgetPassword",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult forgetPassword(String number) throws Exception{
		PubPbePassword ppp =null;
		if(number.length()==15||number.length()==13){
			ppp =pubPbePasswordService.selectOneByRegNO(number);
		}else if(number.length()==18){
			ppp =pubPbePasswordService.selectOneByUniCode(number);
		}
		if(ppp!=null){
			String newPwd =pubPbePasswordService.updatePassword(ppp);
			return  AjaxResult.success(newPwd);
		}else {
			return AjaxResult.error("请先获取密码");
		}
		
	}
}
