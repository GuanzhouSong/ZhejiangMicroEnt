/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;

import com.icinfo.cs.bulletin.dto.PubAnnounceMentDto;
import com.icinfo.cs.bulletin.model.PubAnnounceMent;
import com.icinfo.cs.bulletin.service.IPubAnnounceMentService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.cs.yr.service.IBulletinsService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_bulletins 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
@Controller
@RequestMapping({ "/syn/yr/bulletins/", "/reg/server/yr/bulletins/","/pub/yr/bulletins/" })
public class BulletinsController extends CSBaseController {
	
	
	@Autowired 
	IBulletinsService bulletinsService;
	//公示信息公告
	@Autowired 
	IPubAnnounceMentService pubAnnounceMentService;
	@Value("${cloudModel}")
	private String cloudModel;

	@Autowired
	OssClient ossClient;
	
	private Map<String, Object> dataParmMap;
	
	
	/**
	 * 描述   进入公示系统信息公告查询页面
	 * @author yujingwei
	 * @date 2017年07月19日  
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/search")
	public ModelAndView pubOpanoMalyListPage() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/bulletins/pubbulletin_search");
		return view;
	}
	
	/** 
	 * 描述: 获取列表数据
	 * @author yujingwei
	 * @date 2017年07月19日 
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping({"search.json","list.xml"})
	@ResponseBody
	public PageResponse<PubAnnounceMentDto> bulletinSearchJSON(PageRequest request) throws Exception{
		Map<String,Object> queryMap=getRequestParam(request); 
		Integer total=0;
		// 清空全局变量
		if (dataParmMap != null) {
			dataParmMap.clear();
		}
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		dataParmMap = queryMap;
		List<PubAnnounceMentDto> dtos = pubAnnounceMentService.doGetPubBulletinfoForServer(request);
		total = pubAnnounceMentService.doGetPubBulletinTotalForServer(request);
		return new PageResponse<PubAnnounceMentDto>(dtos,total,request);
	}
	
	
	/** 
	 * 描述:查询公告信息统计
	 * @author yujingwei
	 * @date 2017年07月19日 
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/searchCount", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult initSearchCountJSON() throws Exception {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.putAll(dataParmMap);
		if (qryMap.isEmpty()) {
			return null;
		}
		Integer distincTotal = pubAnnounceMentService.doGetDistinctBulletinTotal(dataParmMap);
		return AjaxResult.success("", distincTotal);
	}

	/** 
	 * 描述: 保存与更新操作
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @param bulletins
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(Bulletins bulletins) throws Exception{
		if(StringUtil.isNotBlank(bulletins.getContents())){
			bulletins.setContents(StringEscapeUtils.unescapeHtml(bulletins.getContents()));
		}
		if(StringUtils.isEmpty(bulletins.getUID())){
			bulletins.setUID(StringUtil.uuid());
			bulletins.setSetTime(new Date());
//			bulletins.setModTime(new Date());
			bulletins.setIsValid("1");
			if(bulletinsService.insertBulletins(bulletins)>0){
				if("1".equals(bulletins.getBulType())){//公示公告，操作公示信息公告表(新增公告均为有效公告)
					savepubAnnounceMent(bulletins);
				}
				return AjaxResult.success("增加成功!");
			}else{
				return AjaxResult.error("增加失败!");
			}
		}else {
			bulletins.setModTime(new Date());
			if(bulletinsService.updateBulletins(bulletins)>0){
				if("1".equals(bulletins.getBulType())){//公示公告，操作公示信息公告表
					pubAnnounceMentService.deleteOne(bulletins.getUID());
					if("1".equals(bulletins.getIsValid())){ //操作变为有效，新增数据
						savepubAnnounceMent(bulletins);
					}
				}
				return AjaxResult.success("修改成功!");
			}else{
				return AjaxResult.error("修改失败!");
			}
		}
	}
	
	/**
	 * 
	 * 描述: 将有效公示公告插入信息公示公告中
	 * @auther gaojinling
	 * @date 2017年6月8日 
	 * @param bulletins
	 * @return
	 * @throws Exception
	 */
	public int savepubAnnounceMent(Bulletins bulletins) throws Exception{
		PubAnnounceMent pubAnnounceMent = new PubAnnounceMent();
		pubAnnounceMent.setPubTitle(bulletins.getTitle());
		pubAnnounceMent.setAuditDeptName(bulletins.getSetDeptname());
		pubAnnounceMent.setAuditDate(bulletins.getSetTime());
		String PubType = "";
		if("4".equals(bulletins.getBulScope())){
			PubType = "13";
		}else if("5".equals(bulletins.getBulScope())){
			PubType = "14";
		}else if("6".equals(bulletins.getBulScope())){
			PubType = "15";
		}else if("7".equals(bulletins.getBulScope())){
		PubType = "17";
	    }
		pubAnnounceMent.setPubType(PubType);
		pubAnnounceMent.setLinkUID(bulletins.getUID());
		return pubAnnounceMentService.insertOne(pubAnnounceMent);
	}
	
	/** 
	 * 描述: 到新增页面
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("toInsert")
	public ModelAndView toInsert(String bulType) throws SQLException{
		ModelAndView mav;
		if(StringUtil.isNotBlank(bulType) && "3".equals(bulType)){ //警示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/bulletins_edit");
		}else{ //公示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/pubbulletins_edit");
		}
		//获取当前登录的用户名
		 SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysUser", userProfile);
		mav.addObject("flag", "insert");
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	
	/** 
	 * 描述: 到编辑页面
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("toupdate")
	public ModelAndView toupdate(String uid,String bulType) throws SQLException {
		ModelAndView mav;
		if(StringUtil.isNotBlank(bulType) && "3".equals(bulType)){ //警示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/bulletins_edit");
		}else{ //公示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/pubbulletins_edit");
		}
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		Bulletins bulletins = bulletinsService.selectByUID(uid);
		String files = bulletins.getBulData();
		if (files != null && !files.isEmpty()) {
			mav.addObject("files", files.split("\\|"));
		}
		mav.addObject("sysUser", userProfile);
		mav.addObject("flag", "update");
		mav.addObject("Bulletins", bulletins);
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	
	
	/** 
	 * 描述: 删除
	 * @author ZhouJun
	 * @date 2016年9月27日 
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
			if(bulletinsService.deleteBulletinsByUid(uid) >0){
				return AjaxResult.success("删除公告成功");
			}
			return AjaxResult.error("删除公告失败"); 
	}
	
	/** 
	 * 描述: 表格加载
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @param request
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping({"list.json","list.xml"})
	@ResponseBody
	public PageResponse<Bulletins> listJSON(PageRequest request,HttpSession session) throws SQLException{
		SysUserDto userProfile = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> map = getRequestParam(request);
		if(map.containsKey("bulType") && map.get("bulType") != null && "1".equals(map.get("bulType").toString())){//公示系统公告，加权限
			creatDefaultDBAuthEnv(request,"LEFT(SetDeptCode,6)","SetDeptCode");
		}
		List<Bulletins> bulletinslist=  bulletinsService.selectBulletins(request,userProfile);
		return new PageResponse<Bulletins>(bulletinslist);
	}
	
	/** 
	 * 描述: 主页
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("list")
	public  ModelAndView toList(String bulType) throws SQLException{
		ModelAndView mav;
		if(StringUtil.isNotBlank(bulType) && "3".equals(bulType)){ //警示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/bulletins_list");
		}else{ //公示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/pubbulletins_list");
		}
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	
	/** 
	 * 描述: 主页
	 * @author ZhouJun
	 * @date 2016年9月27日 
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("reglist")
	public  ModelAndView regList() throws SQLException{
		ModelAndView mav = new ModelAndView("/reg/server/yr/bulletins/bulletins_list");
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级
		return mav;
	}
	
	/** 
	 * 描述: 进入公告的查看页面
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping("tosee")
	public ModelAndView toSee(String uid,String bulType) throws SQLException{
		ModelAndView mav;
		if(StringUtil.isNotBlank(bulType) && "3".equals(bulType)){ //警示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/bulletins_see");
		}else{ //公示公告
			mav = new ModelAndView("/reg/server/yr/bulletins/pubbulletins_see");
		}
		Bulletins bulletins = bulletinsService.selectByUID(uid);
		mav.addObject("Bulletins", bulletins);
		String files = bulletins.getBulData();
		if (files != null && !files.isEmpty()) {
			mav.addObject("files", files.split("\\|"));
		}
		if(bulletins != null && StringUtil.isNotEmpty(bulletins.getUID())){//更新阅读量
			Bulletins Readbulletins = new Bulletins();
			Readbulletins.setUID(bulletins.getUID());
			Readbulletins.setReadCount(bulletins.getReadCount()+1);  //阅读量加1
			bulletinsService.updateBulletins(Readbulletins);
		}
		SysUserDto userProfile = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("userVest", userProfile.getUserVest(userProfile));//层级		
		mav.addObject("userType", userProfile.getUserType());
		mav.addObject("flag", "1");
		return mav;
	}
	
	
	/**
	 * 
	 * 描述: 上传附件
	 * @auther gaojinling
	 * @date 2017年6月7日 
	 * @param file
	 * @param prefix
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "btnFile") MultipartFile files, String fileName) {
		if(files.getSize() > 20*1024*1000){
			return "false";
		}
		String result = null;
		if ("Y".equals(cloudModel)) {
			result = uploadToOSS(files, "bulletins/buldata/" + fileName);
		} else {
			result = "error";
		}
		return result;
	}
	
	/**
	 * 
	 * 描述: 查看单个附件
	 * @auther gaojinling
	 * @date 2017年6月7日 
	 * @param fileName 文件路径
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("view")
	public ModelAndView viewCommitment(String fileName) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/bulletins/buldata");
		String bulData = "";
		if(StringUtil.isNotBlank(fileName)){
			BASE64Encoder encoder = new BASE64Encoder();
		    bulData = encoder.encode(downFormOSSa(fileName));
		}
		view.addObject("bulData", bulData);
		return view;
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
			flag = ossClient.putStream(file, fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		if (flag) {
			return fileName;
		} else {
			return "error";
		}
	}
	
	
	
}