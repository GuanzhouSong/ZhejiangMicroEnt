/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.orderreform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CommonDic;
import com.icinfo.cs.base.service.ICommonDicService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.govguide.model.Govguide;
import com.icinfo.cs.orderreform.model.OrderReformSet;
import com.icinfo.cs.orderreform.service.IOrderReformSetService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysPermision;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.impl.RegIndexServiceImpl;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_orderreform_set 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月07日
 */
@Controller
@RequestMapping("/reg/server/orderreformset")
public class OrderReformSetController extends CSBaseController  {
	@Autowired
	private IOrderReformSetService orderReformSetService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICommonDicService commonDicService;
	@Autowired
	private IDepartMentService departMentService;
	@Autowired 
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IRegIndexService regIndexService;
	
	/**
	 * 
	 * 描述   进入责令整改申请列表页面
	 * @author 赵祥江
	 * @date 2016年11月7日 下午2:50:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderReformSetListPage")
	public ModelAndView orderReformSetListPage() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformset_list");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入责令整改审核列表页面
	 * @author 赵祥江
	 * @date 2016年11月9日 下午5:52:25 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderReformSetAuditListPage")
	public ModelAndView orderReformSetAuditListPage() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetaudit_list");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入责令整改事项树页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:11:21 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderreformsetree")
	public ModelAndView orderreformsetree() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetree");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入法律树页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:11:36 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/commonDictree")
	public ModelAndView commonDictree() throws Exception{ 
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/lawtree");
 		return view;
	}
	
	/**
	 * 
	 * 描述   进入法定代表人处罚法页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:11:57 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/leReppunishtree")
	public ModelAndView leReppunishtree() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/leReppunishtree");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入登记事项页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:12:12 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/registrationtree")
	public ModelAndView registrationtree() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/registrationtree");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入违法行为页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:12:24 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/illegaltree")
	public ModelAndView illegaltree() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/illegaltree");
		return view;
	}
	
	/**
	 * 
	 * 描述   打印
	 * @author 赵祥江
	 * @date 2016年11月11日 下午1:47:08 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderreFormsetApplyPrint") 
	public ModelAndView orderreFormsetApplyPrint(HttpSession session,String uid,String  adminGuideType,String pripid,String viewFlag) throws Exception{
 		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_print");
		MidBaseInfo  midBaseInfo =null;
		OrderReformSet orderReformSet=null;
		if(StringUtil.isEmpty(uid)){
			//解密主体身份代码
			pripid=AESEUtil.decodeCorpid(pripid); 
			midBaseInfo=midBaseInfoService.selectByPripid(pripid==null?"00000":pripid);
			orderReformSet=new OrderReformSet();
			orderReformSet.setAdminGuideType(adminGuideType);
			orderReformSet.setAuditState("0");
			orderReformSet.setApplyMan(sysUser.getRealName());
			orderReformSet.setApplyDate(DateUtils.getSysDate());
 			view.addObject("sysUser", sysUser);
			view.addObject("appDate", DateUtils.getDate());
		}else{
			orderReformSet=orderReformSetService.selectOrderReformSetByUid(uid);
			midBaseInfo=midBaseInfoService.selectByPripid(orderReformSet.getPriPID());
			if("1".equals(orderReformSet.getAuditState())){//审核通过
				view  = new ModelAndView("/reg/server/orderreformset/orderreformsetstate_print");
			}else if("2".equals(viewFlag)){
				view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_print");
			}else{
				view  = new ModelAndView("/reg/server/orderreformset/orderreformsetview_print");
			}
			String[] guideContentArr= orderReformSet.getAdminGuideCerContent().split("&");
			view.addObject("guideContentArr", guideContentArr);
			view.addObject("chooseDay", guideContentArr[guideContentArr.length-1]);
		} 
		view.addObject("orderReformSet", orderReformSet);
		view.addObject("midBaseInfo", midBaseInfo);
		view.addObject("viewFlag", viewFlag);
		return view;
	}
	
	
	
	
	/**
	 * 
	 * 描述   查询法律树
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:13:13 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/selectCommonDicListByDicColumn", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult selectCommonDicListByDicColumn() throws Exception {
		List<CommonDic> commonDicList =commonDicService.selectCommonDicListByDicColumn("law");
		List<SysPermision> sysPermisionList=new ArrayList<SysPermision>();
		if(commonDicList.size()>0){
			for(CommonDic commonDic:commonDicList){
				SysPermision sysPermision=new SysPermision();
				sysPermision.setId(commonDic.getDicValue());
				sysPermision.setName(commonDic.getDicExlain());
				sysPermision.setPermisionSysType(commonDic.getDicRemark());
				sysPermision.setParentId(commonDic.getDicPid().toString());
				sysPermisionList.add(sysPermision);
			}
		}
		return AjaxResult.success("", sysPermisionList);
	} 
	
	
	/**
	 * 
	 * 描述   进入责令整改审核弹窗页面
	 * @author 赵祥江
	 * @date 2016年11月9日 下午5:52:25 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderReformSetAuditEditPage")
	public ModelAndView orderReformSetAuditEditPage(HttpSession session ,String viewFlag,String uid) throws Exception{
 		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		OrderReformSet orderReformSet=orderReformSetService.selectOrderReformSetByUid(uid);
		String[] guideContentArr= orderReformSet.getAdminGuideCerContent().split("&");
  		String pripid=orderReformSet.getPriPID();
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetaudit_edit");;
		MidBaseInfo  midBaseInfo =midBaseInfoService.selectByPripid(pripid);
  		//viewFlag 1审核  2查看  3终止
  		view.addObject("auditDate", DateUtils.getDate());
  		view.addObject("midBaseInfo", midBaseInfo); 
		view.addObject("viewFlag", viewFlag); 
		view.addObject("sysUser", sysUser); 
		view.addObject("guideContentArr", guideContentArr); 
		view.addObject("orderReformSet", orderReformSet);
		view.addObject("chooseDay", guideContentArr[guideContentArr.length-1]);
		return view;
	}
	
	
	
	
	/**
	 * 
	 * 描述   进入待申请企业页面
	 * @author 赵祥江
	 * @date 2016年11月7日 下午4:14:19 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/orderReformSetApplyPage")
	public ModelAndView orderReformSetApplyPage() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_list");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	

	/**
	 * 
	 * 描述   查询企业列表
	 * @author 赵祥江
	 * @date 2016年12月12日 下午4:21:41 
	 * @param 
	 * @return PageResponse<PanoramaResultDto>
	 * @throws
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception { 
		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	
	/**
	 * 
	 * 描述   进入添加页面
	 * @author 赵祥江
	 * @date 2016年11月7日 下午4:14:19 
	 * @param 
	 * @return ModelAndView
	 * @throws 
	 */
	@RequestMapping("/orderReformSetApplyEditPage")
	public ModelAndView orderReformSetApplyEditPage(HttpSession session,String pripid,String viewFlag,String  adminGuideType) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_edit");
		String regOrgName="";
		String localAdmName="";
		MidBaseInfo  midBaseInfo =midBaseInfoService.selectByPripid(pripid);
		if(midBaseInfo!=null){
			regOrgName=midBaseInfo.getRegOrgName()==null?"":midBaseInfo.getRegOrgName();
			localAdmName=midBaseInfo.getLocalAdmName()==null?"":midBaseInfo.getLocalAdmName();
		}
		view.addObject("sysUser", sysUser); 
		view.addObject("appDate", DateUtils.getDate());
  		view.addObject("midBaseInfo", midBaseInfo); 
		view.addObject("viewFlag", viewFlag); 
		view.addObject("appYear", DateUtils.getYear());
		//加密主体身份代码
		view.addObject("encodeCorpid", AESEUtil.encodeCorpid(pripid)); 
		
		OrderReformSet orderReformSet=new OrderReformSet();
		orderReformSet.setAdminGuideType(adminGuideType==null?"0":adminGuideType);
		orderReformSet.setLocalAdmName(localAdmName);
		orderReformSet.setRegOrgName(regOrgName);
		view.addObject("orderReformSet", orderReformSet);
		return view;
	}
	
	/**
	 * 
	 * 描述   根据不同的类型进入指定的页面
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:13:39 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/showOrderReformSetApplyEditPage")
	public ModelAndView showOrderReformSetApplyEditPage(HttpSession session ,String viewFlag,String uid) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		OrderReformSet orderReformSet=orderReformSetService.selectOrderReformSetByUid(uid);
		String[] guideContentArr= orderReformSet.getAdminGuideCerContent().split("&");
		//数组转换成LIST
 		String pripid=orderReformSet.getPriPID();
		ModelAndView view  =null;
		MidBaseInfo  midBaseInfo =midBaseInfoService.selectByPripid(pripid);
  		if("1".equals(viewFlag)){//修改
 			view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_detail");
 			view.addObject("sysUser", sysUser); 
 			view.addObject("appYear", DateUtils.getYear());
 		}else if("2".equals(viewFlag)){//查看详情明细
 			orderReformSet=orderReformSetService.selectOrderReformSetByUid(uid);
 			view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_detail");
 		}else if("3".equals(viewFlag)){
 			view  = new ModelAndView("/reg/server/orderreformset/orderreformsetapply_edit");
 			view.addObject("orderReformSet", orderReformSet);
 		}  
  		view.addObject("midBaseInfo", midBaseInfo); 
		view.addObject("viewFlag", viewFlag); 
		view.addObject("guideContentArr", guideContentArr); 
		view.addObject("orderReformSet", orderReformSet);
		view.addObject("chooseDay", guideContentArr[guideContentArr.length-1]);
		return view;
	}
	
	/**
	 * 
	 * 描述   提交
	 * @author 赵祥江
	 * @date 2016年11月8日 下午8:16:22 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitOrderReformSet", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitOrderReformSet(@RequestBody OrderReformSet orderReformSet) throws Exception {
        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		//操作成功后  缓存重新设置（责令整改新增申请成功，待审核+1）
		Map<String, Object> forBidmap = operateMap();
    	//获取责令整改状态
    	OrderReformSet oldOrderReformSet = orderReformSetService.selectOrderReformSetByUid(orderReformSet.getUid());
    	String oldState = oldOrderReformSet == null ? "":oldOrderReformSet.getAuditState();
		if(StringUtil.isNotEmpty(orderReformSet.getUid())){//修改
			if (orderReformSetService.updateOrderReformSetByUid(orderReformSet)> 0) {
    			try {
    		    	if("2".equals(oldState) && "0".equals(orderReformSet.getAuditState())){//退回修改成功后，变为未审核，待审核+1
        				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 12, 1,"1",sysUser);
    		    	}
    			} catch (Exception e) {
    				return AjaxResult.success("修改成功");
    			}
				return AjaxResult.success("修改成功!");
			} else {
				return AjaxResult.error("修改失败!");
			}
		}else{//新增
			if (orderReformSetService.insertOrderReformSet(orderReformSet) > 0) {
	    			try { //新增成功
	    				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 12, 1,"1",sysUser);
	    			} catch (Exception e) {
	    				return AjaxResult.success("添加成功");
	    			}
				return AjaxResult.success("添加成功!");
			} else {
				return AjaxResult.error("添加失败!");
			}
		}
	} 
	
	
	/**
	 * 
	 * 描述   审核提交
	 * @author 赵祥江
	 * @date 2016年10月13日 下午7:14:13 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitAuditOrderReformSet", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitAuditOrderReformSet(@RequestBody OrderReformSet orderReformSet) throws Exception {
 		if(StringUtil.isNotEmpty(orderReformSet.getUid())){ 
  			String  auditState=orderReformSet.getAuditState();
 			//审核通过时生成文号
 			if("1".equals(auditState)){ 
 	 				String  docNo= orderReformSetService.selectOrderReformSetPenDecNoByDocShorName(orderReformSet.getRegOrg()==null?"000":orderReformSet.getRegOrg());
 	 	 			if(docNo.indexOf("#")>=0){ 
 	 	 				return AjaxResult.error("保存失败!生成责令整改通知书文号时发生错误:部门字号不能为空,请检查配置"); 
 	 	 			}
  	 	 			orderReformSet.setPenDecNo(docNo); 
 			}
		    SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			//操作成功后  缓存重新设置（责令整改新增申请成功，待审核+1）
			Map<String, Object> forBidmap = operateMap();
	    	OrderReformSet oldOrderReformSet = orderReformSetService.selectOrderReformSetByUid(orderReformSet.getUid());
	    	String oldState = oldOrderReformSet == null ? "":oldOrderReformSet.getAuditState();
 			if (orderReformSetService.updateOrderReformSetByUid(orderReformSet)> 0) { 
		    	if(!"0".equals(orderReformSet.getAuditState()) && "0".equals(oldState)){//确定为审核，不为未审核状态下的修改
    				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 12, 1,"2",sysUser);
		    	}
				return AjaxResult.success("保存成功!");
			} else {
			   return AjaxResult.error("保存失败!");
			} 
		}
		return AjaxResult.error("保存失败!");
	}  
	
	/**
	 * 
	 * 描述   分页查询责令整改列表
	 * @author 赵祥江
	 * @date 2016年11月14日 下午8:13:56 
	 * @param 
	 * @return PageResponse<OrderReformSet>
	 * @throws
	 */
	@RequestMapping({"/selectOrderReformSetListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<OrderReformSet> selectOrderReformSetListJSON(PageRequest request)throws Exception{ 
		creatDefaultDBAuthEnv(request,"RegOrg","LocalAdm");
		Map<String,Object> parmMap=request.getParams();
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
	    List<OrderReformSet>  orderReformSetList= orderReformSetService.queryOrderReformSetList(request);
	    return new PageResponse<OrderReformSet>(orderReformSetList);
	} 
	
	/**
	 * 
	 * 描述   根据主键uid删除
	 * @author 赵祥江
	 * @date 2016年11月9日 上午11:04:59 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/deleteOrderReformSet")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String uid) throws Exception{
		if (StringUtil.isNotEmpty(uid)) {
	    	OrderReformSet oldOrderReformSet = orderReformSetService.selectOrderReformSetByUid(uid);
	    	String oldState = oldOrderReformSet == null ? "":oldOrderReformSet.getAuditState();
			if(orderReformSetService.deleteOrderReformSetByUid(uid)>0){
		        try {
					if(oldState.equals("0")){//待审核状态下的申请
						SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
						//操作成功后  缓存重新设置（责令整改申请删除成功，待审核-1）
						Map<String, Object> forBidmap = operateMap();
						regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 12, 1,"2",sysUser);
					}
				} catch (Exception e) {
					return AjaxResult.success("删除成功!");
				}
				return AjaxResult.success("删除成功!");
			}
		}
		return  AjaxResult.error("删除失败");
	}
	
	
	public Map<String, Object> operateMap() throws Exception{
			SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			return forBidmap;
	}
}