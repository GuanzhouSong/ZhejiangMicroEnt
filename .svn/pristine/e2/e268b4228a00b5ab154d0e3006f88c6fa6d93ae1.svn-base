package com.icinfo.cs.sment.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.cs.sment.service.ISmentBulletinsService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/*
 * 公告通知测试
 */
@Controller
@RequestMapping("/sment/bulletins")
public class SmentBulletinsController extends BaseController{
	@Autowired
	private ISmentBulletinsService ismentBulletinsService;
	
	@Autowired
	private ISmentBulletinsService isBulletinsService;
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView view = new ModelAndView("/sment/bulletins/bulletins_list");
		return view;
	}
	/**
	 * 描述: 获取列表数据
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping({"/list.json", "list.xml"})
	@ResponseBody
	public PageResponse<SmentBulletins> listJSON(PageRequest request){
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		List<SmentBulletins> list = ismentBulletinsService.selectBulletinsList(request,userProfile);
		return new PageResponse<SmentBulletins>(list);
	}
	
	/** 
	 * 描述: 通知公告新增与修改
	 * @author Czj
	 * @date 2017年05月03日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(SmentBulletins smentBulletins) throws SQLException{
		if(StringUtil.isNotBlank(smentBulletins.getContents())){
			smentBulletins.setContents(StringEscapeUtils.unescapeHtml(smentBulletins.getContents()));
		}
		
		if(StringUtils.isEmpty(smentBulletins.getUID())){
			smentBulletins.setSetTime(new Date());
			if(ismentBulletinsService.insertBulletins(smentBulletins)>0){
				return AjaxResult.success("增加成功!");
			}else{
				return AjaxResult.error("增加失败!");
			}
		}else {
			if(ismentBulletinsService.updateBulletins(smentBulletins)>0){
				return AjaxResult.success("修改成功!");
			}else{
				return AjaxResult.error("修改失败!");
			}
		}
	}
	
	/** 
	 * 描述: 到新增页面
	 * @author Czj
	 * @date 2017年05月03日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("toInsert")
	public ModelAndView toInsert() throws SQLException{
		//获取当前登录的用户名
		ModelAndView mav = new ModelAndView("/sment/bulletins/bulletins_edit");
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysUser", userProfile);
		mav.addObject("flag", "insert");
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	/** 
	 * 描述: 到修改页面
	 * @author Czj
	 * @date 2017年05月03日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("toUpdate")
	public ModelAndView toUpdate(String uid) throws SQLException{
		//获取当前登录的用户名
		ModelAndView mav = new ModelAndView("/sment/bulletins/bulletins_edit");
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysUser", userProfile);		
		mav.addObject("SmentBulletins", ismentBulletinsService.selectByUID(uid));
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	
	/** 
	 * 描述: 进入公告的查看页面
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("tosee")
	public ModelAndView toSee(String uid) throws SQLException{
		ModelAndView mav = new ModelAndView("/sment/bulletins/bulletins_see");
		SmentBulletins smentBulletins = ismentBulletinsService.selectByUID(uid);
		mav.addObject("SmentBulletins", smentBulletins);
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级		
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("flag", "1");
		return mav;
	}
	
	/** 
	 * 描述: 删除
	 * @author Czj
	 * @date 2017年05月03日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(String uid) throws SQLException {
		if(StringUtils.isEmpty(uid)){
			   return AjaxResult.error("删除的公告不存在");
			}
			if(ismentBulletinsService.deleteBulletinsByUid(uid) >0){
				isBulletinsService.deleteBulletinsByUid(uid);
				return AjaxResult.success("删除公告成功");
			}
			return AjaxResult.error("删除公告失败"); 
	}
	/**
	 * 描述:to通知公告更多页面
	 * @author Czj
	 * @date 2017-05-07
	 * @return
	 */
	@RequestMapping("toMoreList")
	public ModelAndView toMoreList(){
		ModelAndView mv = new ModelAndView("/sment/bulletins/bulletins_more");
		return mv;
	}

}
