/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.sccheck.dto.PubScentBackDto;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentCondition;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScentBackService;
import com.icinfo.cs.sccheck.service.IPubScentConditionService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scent_back 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping({"/reg/pub/server/sccheck/entback","/syn/pub/server/sccheck/entback"})
public class PubScentBackController extends CSBaseController {
	@Autowired
	private IPubScentBackService pubScentBackService;
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IPubScentConditionService pubScentConditionService;
	@Autowired
	private IPubScentService pubScentService;
	/**
	 * 
	 * 描述: 进入检查对象随机抽取页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/tasklist",method= RequestMethod.GET)
	public ModelAndView doEntTaskList(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentbacktask_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl); 
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入抽取名单页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/randompage",method= RequestMethod.GET)
	public ModelAndView doEnterRandom(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = null;
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
		if(StringUtils.isNotEmpty(pubScPlanTask.getDutyDeptCode()) && ("A012".equals(pubScPlanTask.getDutyDeptCode())
			|| "A027".equals(pubScPlanTask.getDutyDeptCode()) || "A058".equals(pubScPlanTask.getDutyDeptCode()))){
			view = new ModelAndView("/syn/system/sccheck/scentback/scentbacktask_edit");
		}else{
			view = new ModelAndView("/syn/system/sccheck/scentback/crossRandomEnt_edit");
		}
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		view.addObject("pubScPlanTask", pubScPlanTask);
		return view;
	}
	

	/**
	 * 
	 * 描述: 进入抽取名单页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/viewrandompage",method= RequestMethod.GET)
	public ModelAndView doEnterViewRandom(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = null;
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
		if(StringUtils.isNotEmpty(pubScPlanTask.getDutyDeptCode()) && ("A012".equals(pubScPlanTask.getDutyDeptCode())
			||	"A027".equals(pubScPlanTask.getDutyDeptCode()) || "A058".equals(pubScPlanTask.getDutyDeptCode()))){
			view = new ModelAndView("/syn/system/sccheck/scentback/scentbacktask_view");
		}else{
			view = new ModelAndView("/syn/system/sccheck/scentback/crossRandomEnt_view");
		}
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		view.addObject("pubScPlanTask", pubScPlanTask);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入添加检查对象页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addpage",method= RequestMethod.GET)
	public ModelAndView doAddEntBack(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentback_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("yearList", DateUtil.getYearToNowForReport());
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		return view;
	}
	
	/**
     * 描述：获取查抽检查结果录入列表
     * @author chenxin
     * @date 2016-10-26
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScentBackDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		List<PubScentBackDto> data = null;
		data = pubScentBackService.queryPubScentBackDtoPage(request);
        return new PageResponse<PubScentBackDto>(data);
    }
	
	/**
	 * 描述：清除待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDelEntback(@RequestBody PubScentBackDto pubScentBackDto,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentBackService.doCleanPubScentBack(pubScentBackDto.getDelUidList(),pubScentBackDto.getTaskUid(),sysUser)){
			return AjaxResult.success("清除成功");
		}
		return AjaxResult.error("清除失败");
	}
	
	/**
	 * 
	 * 描述: 进入批量导入页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/exportpage",method= RequestMethod.GET)
	public ModelAndView doExportPage(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentback_excel");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid",taskUid);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入批量导入页面
	 * @auther chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/special",method= RequestMethod.GET)
	public ModelAndView doSpecialPage(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentback_special");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid",taskUid);
		return view;
	}
	
	/**
	 * 检查主体名单导入模板下载
	 * @author chenxin
	 * @date 2017年5月10日 
	 * @throws Exception
	 */
	@RequestMapping("/downloadExcel")
	public ResponseEntity<byte[]> downloadExcel(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("/template")+File.separator+file_name;
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("检查对象名单导入模板.xls".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
     * 描述：批量导入待抽检库
     * @author chenxin
     * @date 2017-05-17
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/export",method= RequestMethod.POST)
    @ResponseBody
    public void doExportEnt(@RequestParam("file") MultipartFile file, String taskUid,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        JSONObject json = pubScentBackService.doAddExcelBatch(in, taskUid,sysUser);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	
	
	/**
	 * 描述：导入待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddBatch(@RequestBody PubScentBackDto pubScentBackDto,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentBackService.doAddBatch(pubScentBackDto,sysUser)){
			return AjaxResult.success("导入待抽检库成功");
		}
		return AjaxResult.error("导入待抽检库失败");
	}
	
	/**
	 * 描述：导入所有待抽检库
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addAll", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddAll(@RequestParam Map<String,Object> params) throws Exception {
		String taskUid = (String)params.get("taskUid");
		panoramaSearchService.doSearchForPubScinfoList(taskUid, params);
		return AjaxResult.success("导入待抽检库成功");
	}
	
	/**
	 * 描述：导入专项库检查对象
	 * 
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addSpecial", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddSpecial(@RequestParam Map<String,Object> params) throws Exception {
		if(pubScentBackService.doAddSpecial(params)){
			return AjaxResult.success("导入成功");
		}
		return AjaxResult.error("导入失败");
	}
	
	/**
	 * 描述：统计专项库检查对象
	 * 
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countSpecial", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCountSpecial(@RequestParam Map<String,Object> params) throws Exception {
		if(params != null && params.get("taskUid") != null){
			int count = pubScentBackService.doCountSpecial(params);
			return AjaxResult.success("导入成功",count);
		}
		return AjaxResult.error("导入失败");
	}
	
	/**
     * 描述：清空待抽检库
     * @author chenxin
     * @date 2017-05-17
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/clean",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult doCleanEntBack(String taskUid,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentBackService.doCleanPubScentBack(taskUid,sysUser)){
			return AjaxResult.success("清除成功");
		}
		return AjaxResult.error("清除失败");
    }
	
	/**
	 * 描述：摇号
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/random",method= RequestMethod.GET)
	public ModelAndView doRandomEntBack(HttpSession session,String taskUid,String randomType) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		creatDefaultDBAuthEnv(params,"b.RegOrg","b.LocalAdm");
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentbackrandom_move");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pubScentBackService.doRandomEntBack(sysUser,taskUid,randomType,params);
		PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		view.addObject("pubScPlanTask", pubScPlanTask);
		return view;
	}
	
	/**
	 * 描述：锁定名单
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lock",method= RequestMethod.GET)
	public ModelAndView doLockEntBack(HttpSession session,String taskUid) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentback/scentbackrandom_lock");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
		List<PubScentCondition> pubSecentConditionList = pubScentConditionService.selectPubScentConditionList(taskUid, pubScPlanTask.getRandomType());
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		view.addObject("pubScPlanTask", pubScPlanTask);
		view.addObject("pubSecentConditionList", pubSecentConditionList);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}
	
	/**
     * 描述：锁定抽检结果
     * @author chenxin
     * @date 2017-05-17
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/lockEnt",method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult doLockEnt(HttpSession session,String taskUid) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScPlanTaskService.lockPubScPlanTaskByUid(sysUser, taskUid)){
			return AjaxResult.success("锁定成功");
		}
		return AjaxResult.error("锁定失败");
    }
	

	/**
	 * 描述：查看抽取名单
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/look",method= RequestMethod.GET)
	public ModelAndView doLookEntBack(HttpSession session,String taskUid) throws Exception {
		ModelAndView view = null;
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
		List<PubScentDto> pubScentDtoList = pubScentService.selectPubSentDtoListBytaskUId(taskUid);
		List<PubScentDto> pubScentDtoOrderList = null;
		if(pubScentDtoList != null && pubScentDtoList.size() == 1 && !"3300".equals(pubScentDtoList.get(0).getRegOrg())){
			String regOrg = pubScentDtoList.get(0).getRegOrg();
			pubScentDtoOrderList = pubScentService.selectBytaskUIdAndRegOrg(regOrg, taskUid);
			view = getViewByRegOrg(regOrg);
		}else{
			pubScentDtoOrderList = orderBy(pubScentDtoList);
			view = new ModelAndView("/syn/system/sccheck/scentback/scentbackrandom_look");
		}
		List<PubScent> pubScentList = pubScentService.selectPubSentListBytaskUId(taskUid);
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		view.addObject("pubScPlanTask", pubScPlanTask);
		view.addObject("pubScentDtoList", pubScentDtoOrderList);
		view.addObject("pubScentList", pubScentList);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}
	
	/**
	 * 描述：根据不同登记机关获取view
	 * @author chenxin
	 * @date 2017-08-30
	 * @param regOrg
	 * @return
	 */
	private ModelAndView getViewByRegOrg(String regOrg) {
		ModelAndView view = null;
		if("3301".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/hzmap_view");
		}else if("3302".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/nbmap_view");
		}else if("3303".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/wzmap_view");
		}else if("3304".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/jxmap_view");
		}else if("3305".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/huzmap_view");
		}else if("3306".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/sxmap_view");
		}else if("3307".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/jhmap_view");
		}else if("3308".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/qzmap_view");
		}else if("3309".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/zsmap_view");
		}else if("3310".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/tzmap_view");
		}else if("3325".equals(regOrg)){
			view = new ModelAndView("/syn/system/sccheck/scentback/lsmap_view");
		}
		return view;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderBy(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("3300", map));
		pubScentDtoOrderList.add(getPubScentDto("3305", map));
		pubScentDtoOrderList.add(getPubScentDto("3301", map));
		pubScentDtoOrderList.add(getPubScentDto("3307", map));
		pubScentDtoOrderList.add(getPubScentDto("3308", map));
		pubScentDtoOrderList.add(getPubScentDto("3325", map));
		pubScentDtoOrderList.add(getPubScentDto("3304", map));
		pubScentDtoOrderList.add(getPubScentDto("3306", map));
		pubScentDtoOrderList.add(getPubScentDto("3309", map));
		pubScentDtoOrderList.add(getPubScentDto("3302", map));
		pubScentDtoOrderList.add(getPubScentDto("3310", map));
		pubScentDtoOrderList.add(getPubScentDto("3303", map));
		return pubScentDtoOrderList;
	}
	
	/**
	 * 描述:按照页面排序生成数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param regOrg
	 * @param map
	 * @return
	 */
	private PubScentDto getPubScentDto(String regOrg,Map<String,Integer> map){
		PubScentDto pubScentDto = new PubScentDto();
		pubScentDto.setRegOrg(regOrg);
		int num = 0;
		if(map.get(regOrg) != null && map.get(regOrg) > 0){
			num = map.get(regOrg);
		}
		pubScentDto.setSpecialNum(num);
		return pubScentDto;
	}
}