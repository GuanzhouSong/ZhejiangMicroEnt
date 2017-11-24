/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.rpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.rpt.rptdto.RptSmBaseinfoDto;
import com.icinfo.cs.rpt.rptservice.IRptSmBaseinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sm_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Controller
@RequestMapping("/sment/rptsmBaseinfo")
public class RptSmBaseinfoController extends CSBaseController {

	@Autowired
	private IRptSmBaseinfoService smBaseinfoService;
	
	/**
	 * 描述: 培育库分页列表
	 * 
	 * @author 张文男
	 * @date 2017年5月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/queryPageListForEntarchives.json", method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> queryPageListForEntarchives(PageRequest request) throws Exception {
	 creatDefaultDBAuthEnv(request, "sb.RegOrg", "sb.LocalAdm");
	 PageResponse<RptSmBaseinfoDto> list = smBaseinfoService.queryPageListForEntarchives(request);
		return list;
	}

	/**
	 * 描述: 获取企业、培育库分页列表
	 * 
	 * @author 张文男
	 * @date 2017年5月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/queryEntAndEntarchivesPageList.json", method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> queryEntAndEntarchivesPageList(PageRequest request) throws Exception {
	 creatDefaultDBAuthEnv(request, "sb.RegOrg", "sb.LocalAdm");
	 List<RptSmBaseinfoDto> list = smBaseinfoService.queryEntAndEntarchivesPageList(request);
	 return new PageResponse<RptSmBaseinfoDto>(list);
	}

	/**
	 * 描述：小微企业信息查询页面
	 *
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("sment/smentsearch/smentsearch_view");
		mav.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mav;
	}

	/**
	 * 描述：小微企业信息查询数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> smEntQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "A.RegOrg", "A.LocalAdm");
		Page<RptSmBaseinfoDto> data = smBaseinfoService.doGetSmBaseinfoList(request);
		return new PageResponse<RptSmBaseinfoDto>(data);
	}


	/**
	 * 描述：小微企业年报信息查看详情列表页
	 * 
	 * @author baifangfang
	 * @date 2017年5月11日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yrinfolist.json")
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> yrinfoJSON(PageRequest request) throws Exception {
		List<RptSmBaseinfoDto> smBaseinfoDtos = smBaseinfoService.queryPageResult(request);
		return new PageResponse<RptSmBaseinfoDto>(smBaseinfoDtos);
	}

	
	
	 /**
     * 
     * 描述: 登记信息统计（普通统计）
     * @auther gaojinling
     * @date 2017年5月4日 
     * @param session
     * @return
     * @throws Exception
     */
	@RequestMapping("/rptYrSmNormalCount")
	public ModelAndView rptYrSmNormalCount(HttpSession session,String normalFlag) throws Exception{
		ModelAndView view;
		if("1".equals(normalFlag)){
			view  = new ModelAndView("/sment/rpt/rptyrsmnormal_list"); 
		}else{
			view  = new ModelAndView("/sment/rpt/rptyrsmimport_list"); 
		}
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.stringToDate(DateUtil.getYear()+"-01-01", "YYYY-MM-dd"));  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylaterDate(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:  年报信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptYrSmNormalCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> rptYrSmNormalCountJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
	 List<RptSmBaseinfoDto> data= smBaseinfoService.selectYrSmNormalCount(request);
	 return new PageResponse<RptSmBaseinfoDto>(data);
	}
	
	/**
	 * 
	 * 描述:   年报信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptYrSmImportCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> rptYrSmImportCountJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
	 List<RptSmBaseinfoDto> data= smBaseinfoService.selectYrRptImportCount(request);
	 return new PageResponse<RptSmBaseinfoDto>(data);
	}
		
	
    /** 
     * 描述: 统计入库企业上规升级数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param session
     * @param helpState
     * @return 
     */
    
    @RequestMapping(value = "countSgsjBySetDeptCode.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countSgsjBySetDeptCode(HttpSession session,String helpState){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            Long count = smBaseinfoService.countSgsjBySetDeptCode(sysUser.getDepartMent ().getDeptCode ().substring (0, 6));
           
            return AjaxResult.success ("操作成功！",count);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

	/**
	 *@Description 统计入库企业上规升级数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	@RequestMapping(value = "selectSgsjBySetDeptCodeList.json",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> selectSgsjBySetDeptCodeList(HttpSession session,PageRequest request)throws Exception{
			SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
			List<RptSmBaseinfoDto> sgsjBySetDeptCodeList = smBaseinfoService.selectSgsjBySetDeptCodeList (sysUser,request);
			return new PageResponse<RptSmBaseinfoDto> (sgsjBySetDeptCodeList);
	}


	 /**
	 *@Description 根据部门code获取已注销企业数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	@RequestMapping(value = "selectZxList.json",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> selectZxList(HttpSession session,PageRequest request)throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
		List<RptSmBaseinfoDto> sgsjBySetDeptCodeList = smBaseinfoService.selectZxList (sysUser,request);
		return new PageResponse<RptSmBaseinfoDto> (sgsjBySetDeptCodeList);
	}
	/**
	 *@Description 统计入库企业经营异常数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	@RequestMapping(value = "selectJyycBySetDeptCodeList.json",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> selectJyycBySetDeptCodeList(HttpSession session,PageRequest request)throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
		List<RptSmBaseinfoDto> jyycBySetDeptCodeList = smBaseinfoService.selectJyycBySetDeptCodeList (sysUser,request);
		return new PageResponse<RptSmBaseinfoDto> (jyycBySetDeptCodeList);
	}

	/**
	 *@Description 统计入库企业违法违规数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	@RequestMapping(value = "selectWfwgBySetDeptCodeList.json",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> selectWfwgBySetDeptCodeList(HttpSession session,PageRequest request)throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
		List<RptSmBaseinfoDto> wfwgBySetDeptCodeList = smBaseinfoService.selectWfwgBySetDeptCodeList (sysUser,request);
		return new PageResponse<RptSmBaseinfoDto> (wfwgBySetDeptCodeList);
	}

	/**
	 *@Description 统计入库企业营收下降数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	@RequestMapping(value = "selectJyxjBySetDeptCodeList.json",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<RptSmBaseinfoDto> selectJyxjBySetDeptCodeList(HttpSession session,PageRequest request)throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
		List<RptSmBaseinfoDto> jyxjBySetDeptCodeList = smBaseinfoService.selectJyxjBySetDeptCodeList (sysUser,request);
		return new PageResponse<RptSmBaseinfoDto> (jyxjBySetDeptCodeList);
	}






    /**
     * 获取历史数据
     * #@author zjj
     * 20170508
     */
    @RequestMapping({ "/doGetEntarchivesHisList.json", "list.xml" })
    @ResponseBody
    public PageResponse<RptSmBaseinfoDto> doGetEntarchivesHisList(PageRequest request) throws Exception{
        creatDefaultDBAuthEnv (request, "sb.RegOrg", "sb.LocalAdm");
        List<RptSmBaseinfoDto> entarchivesHis = smBaseinfoService.queryPage (request);
        return new PageResponse<RptSmBaseinfoDto> (entarchivesHis);
    }
    
    /** 
     * 描述: 根据企业id获取企业基本信息
     * @author 张文男
     * @date 2017年5月5日 
     * @param session
     * @param pripid
     * @return 
     */
    
    @RequestMapping(value = "queryEntInfoByPriPID.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult queryEntInfoByPriPID(HttpSession session,String pripid){
        try {
            RptSmBaseinfoDto data = smBaseinfoService.queryBeanByPriPID (pripid);
            return AjaxResult.success ("操作成功！", data);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     *   
     * 描述: 首页可视化统计（固定数据部分 小微企业总数 规上、限上企业户数 动产抵押企业 国家商标）
     * @auther gaojinling
     * @date 2017年8月17日 
     * @param session
     * @param helpState
     * @return
     */
    @RequestMapping(value = "countgd.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countgd(HttpSession session) throws Exception{
    	Map<String, Object> map = new HashMap<String, Object>();
        try {
            JSONObject obj = new JSONObject();
        	//小微企业总数
            int baseinfocount = smBaseinfoService.smbaseinfoCount(map);
            //八大万亿产业小微企业总数(即小微企业中属于八大产业总数)
            map.put("eightIndutryType",1);
            int eightIndutryCount = smBaseinfoService.smbaseinfoCount(map);
            obj.put("baseinfocount", baseinfocount);
            obj.put("eightIndutryCount", eightIndutryCount);
            return AjaxResult.success ("操作成功！",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 首页可视化（年报相关部分）
     * @auther gaojinling
     * @date 2017年8月17日 
     * @param session
     * @param operateType
     * @return
     */
    @RequestMapping(value = "smbaseinfoNbCount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult smbaseinfoNbCount(HttpSession session,String operateType){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("year", DateUtil.getPreYear());
            RptSmBaseinfoDto smBaseinfoDto = new RptSmBaseinfoDto();
            smBaseinfoDto = smBaseinfoService.smbaseinfoNbCount(map);
            return AjaxResult.success ("操作成功",smBaseinfoDto);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    /**
     * 
     * 描述: 首页可视化（三次产业统计相关）
     * @auther gaojinling
     * @date 2017年8月17日 
     * @param session
     * @param operateType
     * @return
     */
    @RequestMapping(value = "smbaseThreeTypeCount.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult smbaseThreeTypeCount(HttpSession session,String threeType){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            JSONObject obj = new JSONObject();
            map.put("threeType", "0");
            int ThreeTypeCountAll = smBaseinfoService.smbaseThreeTypeCount(map);
            map.put("threeType", "1");
            int ThreeTypeCount1 = smBaseinfoService.smbaseThreeTypeCount(map);
            map.put("threeType", "2");
            int ThreeTypeCount2 = smBaseinfoService.smbaseThreeTypeCount(map);
            map.put("threeType", "3");
            int ThreeTypeCount3 = smBaseinfoService.smbaseThreeTypeCount(map);
            obj.put("ThreeTypeCountAll", ThreeTypeCountAll);
            obj.put("ThreeTypeCount1", ThreeTypeCount1);
            obj.put("ThreeTypeCount2", ThreeTypeCount2);
            obj.put("ThreeTypeCount3", ThreeTypeCount3);
            return AjaxResult.success ("操作成功",obj);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }
    
    
	
	
	

}