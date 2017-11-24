/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.reg.server;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.WritTypeEnum;
import com.icinfo.cs.common.utils.ClassUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.es.util.ExcelFileUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.IMessageOpanoMalyService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.cs.writ.service.IWritService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_pub_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Controller
@RequestMapping({"/reg/server/opanomaly/pubopanomaly","/syn/server/opanomaly/pubopanomaly"})
public class PubOpanoMalyController extends CSBaseController {
    private static final Logger logger =LoggerFactory.getLogger(PubOpanoMalyController.class);
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IDepartMentService departMentService;
	//异常移出/撤销信息表
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IMessageOpanoMalyService mssessageOpanoMalyService;

	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private ICodeRegunitService codeRegunitService;
	@Autowired
	private ICodeSlicenoService codeSlicenoService;

	private Map<String,Object> dataParmMap;

	@Autowired
	private IRegIndexService regIndexService;
	@Autowired
	private TokenManager tokenManager;

	@Autowired
	ExcelFileUtil excelFileUtil;

	@Autowired
	HttpServletResponse response;

	private String priPids;

	//引入文书接口
	@Autowired
	private IWritService writService;
	
	@Autowired
	IEsManageService esManageService;


	/*----------企业--------- */
	/**
	 *
	 * 描述   进入异常申请列表页面
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:31:22
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyListPage")
	public ModelAndView pubOpanoMalyListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyent_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return view;
	}

	/**
	 *
	 * 描述   进入异常标记添加页面
	 * @author 赵祥江
	 * @date 2016年10月12日 上午9:11:04
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyAddSign")
	public ModelAndView pubOpanoMalyAddSign(HttpSession session,String priPID,String busExcList) throws Exception{
 		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyent_addsign");
		PubOpanoMaly pubOpanoMaly=null;
        if(StringUtil.isNotEmpty(busExcList)){//修改
        	pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
        	priPID=pubOpanoMaly.getPriPID();
        }
        view.addObject("departMent",sysUser==null?new DepartMent(): sysUser.getDepartMent());
        //企业、农专标识batchEntType
        String batchEntType="1";
        String regOrg="0";
       //企业基本信息
		MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
		if(midBaseInfo!=null){
			if("16".equals(midBaseInfo.getEntTypeCatg())||"17".equals(midBaseInfo.getEntTypeCatg())){
				batchEntType="2";
			}
			regOrg=midBaseInfo.getRegOrg();
 		}
 		view.addObject("batchEntType", batchEntType);
 		//决定机关
		CodeRegorg codeRegorg=codeRegorgService.selectRegOrgByCode(regOrg);
		view.addObject("codeRegorg", codeRegorg);
		//联络员信息
		PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
		view.addObject("sysUser", sysUser);
 		PageRequest request=new PageRequest();
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put(Constants.CS_PRIPID, priPID);
		//applyFalg标识 1 表示查询已经审核通过的
		paramsMap.put("applyFalg", "1");
		request.setParams(paramsMap);
 		//企业意见在列的异常信息
		List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.queryPubOpanoMalyList(request);
		view.addObject("pubOpanoMalyDtoList", pubOpanoMalyDtoList);
	    view.addObject("firstDate", DateUtils.getDate());
	    view.addObject("pubOpanoMaly", pubOpanoMaly);
	    view.addObject("nowNbYear",DateUtil.getPreYear());
		return view;
	}

	/**
	 *
	 * 描述   进入异常待添加企业列表页面
	 * @author 赵祥江
	 * @date 2016年10月13日 上午10:18:49
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyEntapplyList")
	public ModelAndView pubOpanoMalyEntapplyList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentapply_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
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
	 * 描述   分页查询已经列入的异常列表
	 * @author 赵祥江
	 * @date 2016年10月11日 上午11:00:08
	 * @param
	 * @return PageResponse<PubPbopanomalyDto>
	 * @throws
	 */
	@RequestMapping({"/pubOpanoMalyListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> pubOpanoMalyListJSON(PageRequest request)throws Exception{
	creatOptDBAuthEnv(request,"E.checkDep","E.localAdm");
	Map<String,Object> queryMap=getRequestParam(request);
	//企业标识0 表示查询农专社  1 表示查询企业
	queryMap.put("entTypeFlag", "1");
	//去掉查询参数的左右空格
	com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
	request.setParams(queryMap);
	List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.queryPubOpanoMalyList(request);
	Integer total=pubOpanoMalyService.selectPubOpanoMalyListCount(queryMap);
	return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList,total,request);
	}

	/**
	 *
	 * 描述   查询待列入异常的企业
	 * @author 赵祥江
	 * @date 2016年10月11日 下午2:38:47
	 * @param
	 * @return PageResponse<PubPbopanomalyDto>
	 * @throws
	 */
	@RequestMapping({"/midBasePubOpanoMalyListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<MidBaseInfoDto> midBasePubOpanoMalyListJSON(PageRequest request)throws Exception{
		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
	 //查询标识 1 表示查询企业
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		//企业和农专标识
		parmMap.put("entTypeFlag", "1");
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
	    List<MidBaseInfoDto>  midBaseInfoDtoList= pubOpanoMalyService.queryMidBasePubOpanoMalyList(request);
	    return new PageResponse<MidBaseInfoDto>(midBaseInfoDtoList);
	}

	/**
	 *
	 * 描述    提交
	 * @author 赵祥江
	 * @date 2016年10月11日 下午2:48:12
	 * @param
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitPubOpanoMaly", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitPubOpanoMaly(@RequestBody PubOpanoMaly pubOpanoMaly) throws Exception {
		//当前年度
		pubOpanoMaly.setSeqYear( Integer.parseInt(DateUtils.getYear()));
		if(pubOpanoMaly.getAbnTime()!=null){
			String aDate=DateUtils.formatDate(pubOpanoMaly.getAbnTime(), "yyyy-MM-dd")+" "+DateUtils.getTime();
			pubOpanoMaly.setAbnTime(DateUtil.stringToDate(aDate,"yyyy-MM-dd HH:mm:ss"));
		}
		if(StringUtil.isNotEmpty(pubOpanoMaly.getBusExcList())){//修改
			if (pubOpanoMalyService.updatePubOpanoMaly(pubOpanoMaly)> 0) {
				return AjaxResult.success("修改成功!");
			} else {
				return AjaxResult.error("修改失败!");
			}
		}else{//新增
			if (pubOpanoMalyService.insertPubOpanoMaly(pubOpanoMaly) > 0) {
				//列入申请成功，列入审核数据增加，对当前用户对应的统计缓存数据重新设置
				//企业基本信息
	 		     try {
					MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(pubOpanoMaly.getPriPID());
					 //若在册灭有  查询 所有状态企业
					 if(midBaseInfo == null ){
						 midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pubOpanoMaly.getPriPID()) ;
					 }
					//统计map
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					//操作权限添加
					creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
					//1.得到当前统计条数  （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
					SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "1",sysUser);
				} catch (Exception e) {
					logger.info("busExcList"+pubOpanoMaly.getBusExcList()+"列入申请提交缓存设置失败"+e.getMessage());
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
	@RequestMapping(value = "/commitAuditPubOpanoMaly", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public synchronized AjaxResult commitAuditPubOpanoMaly(@RequestBody PubOpanoMaly pubOpanoMaly) throws Exception {
 		if(StringUtil.isNotEmpty(pubOpanoMaly.getBusExcList())){
  			String  auditState=pubOpanoMaly.getAuditState();
 			//审核通过时生成文号
 			if("1".equals(auditState)){
 				DepartMent departMent=departMentService.selectDepartMentByDeptCode(pubOpanoMaly.getRegOrg());
  	 			if(StringUtil.isEmpty(departMent.getDocShortName())){
 	 				return AjaxResult.error("保存失败!部门字号不能为空,请检查配置");
 	 			}else{
 	 				Integer docNo= pubOpanoMalyService.selectPenDecNoByRegOrg(departMent.getDocShortName());
 	 	 			if(docNo==null){
 	 	 				docNo=new Integer(1);
 	 	 			}
 	 	 			String penDecNo=departMent.getDocShortName()+"异入〔" + DateUtils.getYear() + "〕第"+docNo+"号";
 	 	 			pubOpanoMaly.setPenDecNo(penDecNo);
 	 			}
 			}
 			if(pubOpanoMaly.getAbnTime()!=null){
 				String aDate=DateUtils.formatDate(pubOpanoMaly.getAbnTime(), "yyyy-MM-dd")+" "+DateUtils.getTime();
 	 			pubOpanoMaly.setAbnTime(DateUtil.stringToDate(aDate,"yyyy-MM-dd HH:mm:ss"));
 			}
 			if (pubOpanoMalyService.updatePubOpanoMaly(pubOpanoMaly)> 0) {
  	 			//审核通过
  	 			if("1".equals(auditState)){
  	 				Map<String,Object> indexMap=new HashMap<String,Object>();
	  	 			//更新企业列表索引
	  	 			esManageService.updateOnePanoramaIdx(pubOpanoMaly.getPriPID());
	  	 			//更新公示索引
	  	 			indexMap.put("priPID",pubOpanoMaly.getPriPID());
	  	 			indexMap.put("isOpanomaly", "1");
	  	 			entSearchService.updatePubIndex(indexMap);
					//添加文书
					addWritData(pubOpanoMaly); 
					try {
						//消息推送
						List<String> priPIDList=new ArrayList<String>();
						priPIDList.add(pubOpanoMaly.getPriPID());
						SysUserDto sysUser = (SysUserDto) getSession().getAttribute (Constants.SESSION_SYS_USER);
						mssessageOpanoMalyService.sendJoinOpanoMaly(priPIDList, sysUser);
					} catch (Exception e) {
						e.printStackTrace();
					} 
  	 			}
	 		     try {
					//企业基本信息
					 MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(pubOpanoMaly.getPriPID());
					 //若在册灭有  查询 所有状态企业
					 if(midBaseInfo == null ){
						 midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pubOpanoMaly.getPriPID()) ;
					 }
					//列入异常申请审核成功，对当前用户对应的统计缓存数据重新设置（予以和不予列入  均减一）
					//统计map
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					//操作权限添加
					creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
					//1.得到当前统计条数  （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
					SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "2",sysUser);
				} catch (Exception e) {
					logger.info("busExcList"+pubOpanoMaly.getBusExcList()+"列入审核缓存设置失败"+e.getMessage());
				}
				return AjaxResult.success("保存成功!");
			} else {
			   return AjaxResult.error("保存失败!");
			}

		}
		return AjaxResult.error("保存失败!");
	}

	/**
	 *@描述：  添加文书
	 *@author: wangjin
	 *@date 2017-07-11 9:57
	 *@return
	 */
	public void addWritData(PubOpanoMaly pubOpanoMaly){
		//添加文书内容
		try {
			writService.addWrit(new Writ(pubOpanoMaly.getPriPID(),pubOpanoMaly.getPenDecNo(), WritTypeEnum.WRIT_TYPE_LieRuYiChang.getType(),pubOpanoMaly.getBusExcList(),pubOpanoMaly.getYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * 描述   删除
	 * @author 赵祥江
	 * @date 2016年10月11日 下午5:33:39
	 * @param
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/deletePubOpanoMaly")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String busExcList,String priPID) throws Exception{
		if (StringUtil.isNotEmpty(busExcList)) {
			if(pubOpanoMalyService.deletePubOpanoMalyByBusExcList(busExcList)>0){
				try {
					//企业基本信息
		 		     MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
	  	 	         //若在册灭有  查询 所有状态企业
	  	 	         if(midBaseInfo == null ){
	  	 	        	 midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID) ;
	  	 	         }
					//列入异常申请删除，列入审核数据减少，对当前用户对应的统计缓存数据重新设置（-1）
					//统计map
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					//操作权限添加
					creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
					SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
                    //更新redis缓存
				    regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "2",sysUser);
				} catch (Exception e) {
					logger.info("busExcList"+busExcList+"列入申请删除缓存设置失败"+e.getMessage());
				}
				return AjaxResult.success("删除成功!");
			}
		}
		return  AjaxResult.error("删除失败");
	}


	/**
	 *
	 * 描述   进入异常审核列表页面
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:31:22
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyAuditListPage")
	public ModelAndView pubOpanoMalyAuditListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentaudit_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return view;
	}



	/**
	 *
	 * 描述   打印审批表
	 * @author 赵祥江
	 * @date 2016年10月13日 上午10:20:34
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyPrintspTable")
	public ModelAndView pubOpanoMalyPrintspTable(HttpSession session,String busExcList) throws Exception{
  		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentsptable_print");
 		PubOpanoMaly   pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
        view.addObject("pubOpanoMaly", pubOpanoMaly);
 		return view;
	}

	/**
	 *
	 * 描述   显示明细
	 * @author 赵祥江
	 * @date 2016年10月13日 上午10:20:47
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalyAuditEdit")
	public ModelAndView pubOpanoMalyAuditEdit(HttpSession session,String busExcList,String viewFlag) throws Exception{
 		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
 		PubOpanoMaly pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
 		ModelAndView view=null;
 		DepartMent  departMent =null;
  		if(StringUtil.isNotEmpty(viewFlag)&&"1".equals(viewFlag)){//列表查看
 			view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyent_view");
 		}else if("2".equals(viewFlag)){//查看详情明细
 			view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyent_detail");
 		} else{//审核页面
 			view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentaudit_edit");
 			departMent = departMentService.selectDepartMentByDeptCodespec(pubOpanoMaly.getRegOrg());
 			view.addObject("departMent", departMent);
 	        view.addObject("auditDepartMent", sysUser.getDepartMent());
 	        view.addObject("sysUser", sysUser);
 	        view.addObject("auditDate", DateUtils.getDate());
 		}
  		//主体身份代码
        String priPID=pubOpanoMaly.getPriPID();
        //企业基本信息
		MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		//联络员信息
		PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("pubEppassword", pubEppassword);
 		PageRequest request=new PageRequest();
		Map<String,Object> paramsMap=new HashMap<String,Object>();
		paramsMap.put(Constants.CS_PRIPID, priPID);
		paramsMap.put("applyFalg", "1");
		request.setParams(paramsMap);
 		//企业意见在列的异常信息
		List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.queryPubOpanoMalyList(request);
		view.addObject("pubOpanoMalyDtoList", pubOpanoMalyDtoList);
 	    view.addObject("pubOpanoMaly", pubOpanoMaly);
		return view;
	}

	/**
	 *
	 * 描述   生成决定书
	 * @author 赵祥江
	 * @date 2016年10月13日 上午10:46:04
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoJDBook")
	public ModelAndView pubOpanoJDBook(HttpSession session,String busExcList) throws Exception{
 		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentdecision_book");
 		PubOpanoMaly  pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
 		DepartMent  departMent = departMentService.selectDepartMentByDeptCodespec(pubOpanoMaly.getRegOrg());
        view.addObject("pubOpanoMaly", pubOpanoMaly);
        view.addObject("departMent", departMent);
		return view;
	}

	/**
	 *
	 * 描述   打印决定书
	 * @author 赵祥江
	 * @date 2016年10月13日 下午2:27:34
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoPrintJDBook")
	public ModelAndView pubOpanoPrintJDBook(HttpSession session,String busExcList) throws Exception{
  		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanoprintjdbook_print");
 		PubOpanoMaly   pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
        view.addObject("pubOpanoMaly", pubOpanoMaly);
 		return view;
	}


	/**
	 *
	 * 描述   校验是否已经生成决定书
	 * @author 赵祥江
	 * @date 2016年10月13日 上午10:52:11
	 * @param
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/existPubOpanoJDBook")
	@ResponseBody
	public AjaxResult existPubOpanoJDBook(String busExcList) throws Exception{
        PubOpanoMaly  pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
        //同级人民政府
        String deptSameGov= pubOpanoMaly.getDeptSameGov();
        //同级人民法院
        String deptSameCourt= pubOpanoMaly.getDeptSameCourt();
        //上级机关名称
        String deptUpName=pubOpanoMaly.getDeptUpName();
		if (StringUtil.isNotEmpty(deptSameGov)
				&& StringUtil.isNotEmpty(deptSameCourt)
				&& StringUtil.isNotEmpty(deptUpName)) {
			return AjaxResult.success("已经生成了决定书");
        }
		return AjaxResult.error("请先生成列入经营异常名录决定书");
	}


	/**
	 *
	 * 描述   进入企业异常名录查询页面
	 * @author 赵祥江
	 * @date 2016年10月26日 上午10:23:00
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySearchListPage")
	public ModelAndView pubOpanoMalySearchListPage() throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentsearch_list");
		view.addObject("yearList", this.getYearReport("1"));
		return view;
	}

	/**
	 *
	 * 描述   进入异常查询详情页面
	 * @author 赵祥江
	 * @date 2016年10月31日 下午4:16:26
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySearchViewPage")
	public ModelAndView pubOpanoMalySearchViewPage(String busExcList,HttpSession session) throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentsearch_view");
		//异常列入信息
		PubOpanoMaly pubOpanoMaly=pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		String priPID=pubOpanoMaly.getPriPID();
		PubOpaDetail pubOpaDetail=pubOpaDetailService.selectPubOpaDetailByBusExcList(pubOpanoMaly.getBusExcList(), priPID);
		view.addObject("pubOpaDetail", pubOpaDetail);
		//企业信息
		MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
		//如果企业不在存续 查询其他状态
		if(midBaseInfo==null){
			Map<String,Object> qMap=new HashMap<String,Object>();
			qMap.put("regState", "0");
			qMap.put("PriPID",priPID);
			List<MidBaseInfoDto> midBaseInfoDtoList=midBaseInfoService.selectMidBaseinfoByRegNoAndName(qMap);
		    if(midBaseInfoDtoList!=null&&midBaseInfoDtoList.size()>0){
		    	midBaseInfo=midBaseInfoDtoList.get(0);
		    }
		}
		//联络员信息
		PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
 	    view.addObject("pubOpanoMaly", pubOpanoMaly);
 	    String regOrg= pubOpanoMaly.getRegOrg()==null||"".equals(pubOpanoMaly.getRegOrg())? "0000":pubOpanoMaly.getRegOrg();
  	    view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
 	    String localAdm= pubOpanoMaly.getLocalAdm()==null||"".equals(pubOpanoMaly.getLocalAdm())? "0000":pubOpanoMaly.getLocalAdm();
 	    view.addObject("codeRegunit", this.codeRegunitService.selectCodeRegunitInfo(localAdm));
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
 	    return view;
	}

	/**
	 *
	 * 描述   分页查询在册 被列入过的企业信息
	 * @author 赵祥江
	 * @date 2016年10月26日 下午2:49:19
	 * @param
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws
	 */
	@RequestMapping({"/selectPubOpanoMalySearchListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> selectPubOpanoMalySearchListJSON(PageRequest request)throws Exception{
		Map<String,Object> queryMap=getRequestParam(request);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList=new ArrayList<PubOpanoMalyDto>();
		Integer total=0;
		//情空全局变量
		if(dataParmMap!=null){
			dataParmMap.clear();
		}

		if(! queryMap.containsKey("removePermit")){
			creatDefaultDBAuthEnv(request,"E.checkDep","E.localAdm");
		}

		//企业标识0 表示查询农专社  1 表示查询企业
		queryMap.put("entTypeFlag", "1");
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		//将查询参数赋给全局变量 统计查询结果用
		dataParmMap=queryMap;
		pubOpanoMalyDtoList= pubOpanoMalyService.selectPubOpanoMalySearchList(request);
		total=pubOpanoMalyService.selectPubOpanoMalySearchCount(queryMap);

 		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList,total,request);
	}

	/**
	 *
	 * 描述   异常查询 查询结果统计
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:36:54
	 * @param
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getSearchResultCount", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getSearchResultCount()throws Exception{
		Map<String,Object>  dataMap=new HashMap<String,Object>();
		Integer isOutCount=0;
		Integer notOutCount=0;
		Integer isPubCount=0;
		//creatDefaultDBAuthEnv(dataMap,"E.checkDep","E.localAdm");
		isOutCount=pubOpanoMalyService.selectIsInAndIsOutCount(dataParmMap);
		notOutCount=pubOpanoMalyService.selectIsInAndNotOutCount(dataParmMap);
		isPubCount=pubOpanoMalyService.selectIsPubCount(dataParmMap);
		dataMap.put("isInAndIsOutCount", isOutCount);
		dataMap.put("isInAndNotOutCount",notOutCount );
		dataMap.put("isPubCount", isPubCount);
		return AjaxResult.success("", dataMap);
	}



	/*----------农专社--------- */
	/**
	 *
	 * 描述   进入异常申请列表页面  农专
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:31:22
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySfcListPage")
	public ModelAndView pubOpanoMalySfcListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfc_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return view;
	}



	/**
	 *
	 * 描述   分页查询已经列入的异常列表 农专
	 * @author 赵祥江
	 * @date 2016年10月14日 下午4:57:50
	 * @param
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws
	 */
	@RequestMapping({"/pubOpanoMalySfcListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> pubOpanoMalySfcListJSON(PageRequest request)throws Exception{
		creatOptDBAuthEnv(request,"E.checkDep","E.localAdm");
		Map<String,Object> queryMap=getRequestParam(request);
		//企业标识0 表示查询农专社  1 表示查询企业
		queryMap.put("entTypeFlag", "0");
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
	    List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.queryPubOpanoMalyList(request);
	    Integer total=pubOpanoMalyService.selectPubOpanoMalyListCount(queryMap);
	    return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList,total,request);
	}


	/**
	 *
	 * 描述   进入农专待申请异常列表
	 * @author 赵祥江
	 * @date 2016年10月16日 下午5:41:09
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySfcapplyList")
	public ModelAndView pubOpanoMalySfcapplyList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfcapply_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
        return view;
	}


	/**
	 *
	 * 描述   查询待列表异常的农专列表
	 * @author 赵祥江
	 * @date 2016年10月16日 下午5:41:40
	 * @param
	 * @return PageResponse<MidBaseInfoDto>
	 * @throws
	 */
	@RequestMapping({"/midBasePubOpanoMalySfcListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<MidBaseInfoDto> midBasePubOpanoMalySfcListJSON(PageRequest request)throws Exception{
	 //查询标识 1 表示查询企业
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		//企业和农专标识
		parmMap.put("entTypeFlag", "0");
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
	    List<MidBaseInfoDto>  midBaseInfoDtoList= pubOpanoMalyService.queryMidBasePubOpanoMalyList(request);
	    return new PageResponse<MidBaseInfoDto>(midBaseInfoDtoList);
	}

	/**
	 *
	 * 描述   进入农专审核列表页面
	 * @author 赵祥江
	 * @date 2016年10月16日 下午5:42:04
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySfcAuditListPage")
	public ModelAndView pubOpanoMalySfcAuditListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg= selectRegorgByDeptCode(sysUser);
		ModelAndView view  = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfcaudit_list");
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return view;
	}



	/**
	 *
	 * 描述   进入农专异常名录查询页面
	 * @author 赵祥江
	 * @date 2016年10月26日 上午10:23:00
	 * @param
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubOpanoMalySfcSearchListPage")
	public ModelAndView pubOpanoMalySfcSearchListPage() throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/pubopanomalysfcsearch_list");
		view.addObject("yearList", this.getYearReport("0"));
		return view;
	}


	/**
	 *
	 * 描述   分页查询在册 被列入过的农专信息
	 * @author 赵祥江
	 * @date 2016年11月1日 下午2:09:36
	 * @param
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws
	 */
	@RequestMapping({"/selectPubOpanoMalySfcSearchListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> selectPubOpanoMalySfcSearchListJSON(PageRequest request)throws Exception{
		Map<String,Object> queryMap=getRequestParam(request);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList=new ArrayList<PubOpanoMalyDto>();
		Integer total=0;
		//情空全局变量
		if(dataParmMap!=null){
			dataParmMap.clear();
		}
		if(! queryMap.containsKey("removePermit")){
			 creatDefaultDBAuthEnv(request,"E.checkDep","E.localAdm");
		}
		 //企业标识0 表示查询农专社  1 表示查询企业
		 queryMap.put("entTypeFlag", "0");
		 //去掉查询参数的左右空格
		 com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		 dataParmMap=queryMap;
		 request.setParams(queryMap);
		 pubOpanoMalyDtoList= pubOpanoMalyService.selectPubOpanoMalySearchList(request);
		 total=pubOpanoMalyService.selectPubOpanoMalySearchCount(queryMap);
		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList,total,request);
	}


	/**
	 *
	 * 描述   根据企业类型得到列入的条数
	 * @author 赵祥江
	 * @date 2016年11月28日 下午2:17:13
	 * @param
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPbCountAndEntCount", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getPbCountAndEntCount(String priPID,String entTypeCatg)throws Exception{
		try {
			Map<String,Object> paramsMap=new HashMap<String,Object>();
	 		//个体户
			if("50".equals(entTypeCatg)){
				paramsMap.clear();
				paramsMap.put(Constants.CS_PRIPID, priPID);
 				return AjaxResult.success("dataCount", pubPbopanomalyService.selectMarkEntCount(paramsMap));
			}else{//企业农专
				PageRequest request=new PageRequest();
				paramsMap.put(Constants.CS_PRIPID, priPID);
				//applyFalg标识 1 表示查询已经审核通过的
				paramsMap.put("applyFalg", "1");
				request.setParams(paramsMap);
				List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.queryPubOpanoMalyList(request);
			    return AjaxResult.success("dataCount", pubOpanoMalyDtoList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AjaxResult.error("统计失败");
	}

	/**
	 * 查询企业农专的异常经营名录----协同系统---数据接入使用。add by liuhq
	 * @param request
	 * @return
	 * @throws Exception
	 * @date 2016.11.30
	 */
	@RequestMapping({"/getEntForDatajoinJSON.json","getEntForDatajoinJSON.xml"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> getEntForDatajoinJSON(PageRequest request,HttpSession session)throws Exception{
		Map<String,Object> queryMap= new HashedMap();
		//企业农专
		//applyFalg标识 1 表示查询已经审核通过的
		queryMap.put("applyFalg", "1");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		queryMap.put("adCode",sysUserDto.getSysDepart().getAdcode());
		if(request.getParams()==null)
		request.setParams(queryMap);
		else request.getParams().putAll(queryMap);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList= pubOpanoMalyService.selectPubOpanoMalyList_Fordatain(request);
		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList);
	}
	@RequestMapping({"/getEntForDatajoinJSON_downednum"})
	@ResponseBody
	public AjaxResult getEntForDatajoinJSON_downednum(String uniCode_regNO,String entName,HttpSession session)throws Exception{
		Map<String,Object> queryMap= new HashedMap();
		//企业农专
		//applyFalg标识 1 表示查询已经审核通过的
		queryMap.put("applyFalg", "1");
		queryMap.put("uniCode_regNO", uniCode_regNO);
		queryMap.put("entName", entName);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		queryMap.put("adCode",sysUserDto.getSysDepart().getAdcode());
		String downed = pubOpanoMalyService.getEntForDatajoinJSON_downednum(queryMap);
		return AjaxResult.success("downed",downed );

	}


	/**
	 *
	 * 描述   去除当年年度
	 * @author 赵祥江
	 * @date 2017年1月9日 下午2:44:36
	 * @param  flag 表示农专年报 年度去除2013年 1表示企业年报年度保留2013年
	 * @return List<String>
	 * @throws
	 */
	private List<String> getYearReport(String flag){
		List<String> yearList= DateUtil.getYearToNow();
		String year=DateUtil.getYear();
		if(yearList!=null&&yearList.size()>0){
			for(int i=0;i<yearList.size();i++){
				if("0".equals(flag)){
					if("2013".equals(yearList.get(i))){
						yearList.remove(i);
						i--;
						continue;
					}
				}
				if(year.equals(yearList.get(i))){
					yearList.remove(i);
					i--;
				}
			}
		}
		return yearList;
	}



	/**
	 *
	 * 描述: 异常名录查询（企业）（协同）
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/synpubOpanoMalySearchListPage")
	public ModelAndView synpubOpanoMalySearchListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/synpubopanomalyentsearch_list");
		view.addObject("yearList", this.getYearReport("1"));
		view.addObject("userType", sysUser.getUserType());
		return view;
	}



	/**
	 *
	 * 描述: 异常名录查询（农专）（协同）
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/synpubOpanoMalySfcSearchListPage")
	public ModelAndView synpubOpanoMalySfcSearchListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalysfc/synpubopanomalysfcsearch_list");
		view.addObject("yearList", this.getYearReport("0"));
		view.addObject("userType", sysUser.getUserType());
		return view;
	}


	/**
	 * 描述:根据自然人身份证获取列表
	 * @author 张文男
	 * @date 2017年3月17日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping({"/selectListByCerNO"})
	@ResponseBody
	public PageResponse<PubOpanoMaly> selectListByCerNO(PageRequest request,HttpSession session)throws Exception{
		List<PubOpanoMaly> list = pubOpanoMalyService.selectListByCerNO(request);
		return new PageResponse<PubOpanoMaly>(list);
	}


	/**
	 *
	 * 描述: 批量列入异常列表页
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectBatchInList")
	public ModelAndView selectBatchInList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatch_list");
 	    String regOrg= sysUser.getDepartMent().getDeptCode().length() > 5 ? sysUser.getDepartMent().getDeptCode().substring(0,6) : "0000";
  	    view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("yearList", this.getYearReport("0"));
		view.addObject("userType", sysUser.getUserType());
		view.addObject("nowNbYear", DateUtil.getPreYear());
		return view;
	}


	/**
	 *
	 * 描述: 批量列入异常列表查询
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/selectBatchInListJson.json"})
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> selectBatchInListJson(PageRequest request) throws Exception{
	  Map<String,Object> queryMap=getRequestParam(request);
	  com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
	  request.setParams(queryMap);
	  List<PubOpanoMalyDto>	 list = pubOpanoMalyService.selectBatchInList(request);
	  return new PageResponse<PubOpanoMalyDto>(list);
	}
	/**
	 *
	 * 描述:新增批量列入异常列表页
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectBatchInAddList")
	public ModelAndView selectBatchInAddList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchadd_list");
		String regOrg= selectRegorgByDeptCode(sysUser);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("year", DateUtil.getCurrentYear());
		view.addObject("userType", sysUser.getUserType());
		return view;
	}


	/**
	 *
	 * 描述: 新增批量列入异常列表查询
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/selectBatchInAddListJson.json"})
	@ResponseBody
	public PageResponse<MidBaseInfoDto> selectBatchInAddListJson(PageRequest request) throws Exception{
		Map<String,Object> queryMap=getRequestParam(request);
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		List<MidBaseInfoDto> list = midBaseInfoService.selectBatchPubOpanomalyInAddList(request);
		return new PageResponse<MidBaseInfoDto>(list);
	}


	/**
	 *
	 * 描述: 全部导出
	 * @auther gaojinling
	 * @date 2017年7月3日
	 * @param map
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping({ "/batchAllDownLoad" })
	@ResponseBody
	public void comPanoQueryPageDownLoad(@RequestParam Map<String, Object> map) throws Exception {
		Object query = map.get("map");
		JSONObject jasonObject = JSONObject.fromObject(query.toString());
		Map<String, Object> queryMap = (Map<String, Object>) jasonObject;
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		List<MidBaseInfoDto> list = midBaseInfoService.selectBatchPubOpanomalyInAddListAll(queryMap);
		//设置excel属性
		HSSFWorkbook hwb = excelFileUtil.batchOpanomalyWrite(list);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment;filename=" + new String(("可批量列入异常名录.xls").getBytes("GB2312"), "ISO8859-1"));
		OutputStream ouputStream = response.getOutputStream();
		hwb.write(ouputStream);
	}


	/**
	 *
	 * 描述: 处理批量添加的主体代码数据
	 * @auther gaojinling
	 * @date 2017年7月4日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getPriCode",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult enCodeData(@RequestParam String priPID) throws Exception{
//		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
//		Collections.addAll(idsList, priPID.split(","));
//		System.out.println(idsList.size());
		if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(priPids)){
			priPids = "";
		}
        if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(priPID)){
        	priPids = priPID;
        	return AjaxResult.success("数据处理成功",priPids);
        }
        return AjaxResult.success("传过来的pripid为空");
	}


	/**
	 *
	 * 描述:新增批量列入异常添加页
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectBatchInAdd")
	public ModelAndView selectBatchInAdd(HttpSession session,PubOpanoMalyDto pubOpanoMalyDto) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pubOpanoMalyDto.setRegOrg(pubOpanoMalyDto.getDecOrg());//设置登记机关
		pubOpanoMalyDto.setPriPID(priPids);//设置登记机关
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchadd_edit");
		String regOrg= selectRegorgByDeptCode(sysUser);
 		//登记机关对应的部门（决定书设置）
		DepartMent  departMent = departMentService.selectDepartMentByDeptCodespec(pubOpanoMalyDto.getRegOrg());
		view.addObject("pubOpanoMalyDto", pubOpanoMalyDto);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("departMent", departMent);
		view.addObject("year", DateUtil.getCurrentYear());
		view.addObject("userType", sysUser.getUserType());
		view.addObject("sysUser", sysUser);
		view.addObject("type", "one");
		return view;
	}

	/**
	 *
	 * 描述: 单页批量认领
	 * @auther gaojinling
	 * @date 2017年6月15日
	 * @param
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/batchInAddCommit")
    @ResponseBody
	public AjaxResult batchInAddCommit(@RequestBody PubOpanoMaly pubOpanoMaly) throws Exception{
		DepartMent departMent=departMentService.selectDepartMentByDeptCode(pubOpanoMaly.getRegOrg());
 		if(StringUtil.isEmpty(departMent.getDocShortName())){
 				return AjaxResult.error("保存失败!部门字号不能为空,请检查配置");
 		}else{
 				Integer docNo= pubOpanoMalyService.selectPenDecNoByRegOrg(departMent.getDocShortName());
 	 			if(docNo==null){
 	 				docNo=new Integer(1);
 	 		 }
 	 			String penDecNo=departMent.getDocShortName()+"异入〔" + DateUtils.getYear() + "〕第"+docNo+"号";
 	 			pubOpanoMaly.setPenDecNo(penDecNo);
 		}
   	        pubOpanoMalyService.batchInsertIn(pubOpanoMaly);
//    		//更新公示索引
//    		try {
//				String[] pripids = pubOpanoMaly.getPriPID().split(",");
//				for(String priPID : pripids){
//				Map<String,Object> indexMap=new HashMap<String,Object>();
//					indexMap.put("priPID",priPID);
//					indexMap.put("isOpan", "Y");
//					//更新企业列表索引
//					panoramaSearchService.updatePanoramaIdx(indexMap);
//					indexMap.remove("isOpan");
//					//更新公示索引
//					indexMap.put("isOpanomaly", "1");
//					entSearchService.updatePubIndex(indexMap);
//	        }
//			} catch (Exception e) {
//	        	return AjaxResult.success("单页批量列入成功");
        	return AjaxResult.success("单页批量列入成功");
	}



    /**
     *
     * 描述: 全部列入
     * @auther gaojinling
     * @date 2017年6月16日
     * @param pubOpanoMalyDto
     * @return
     * @throws Exception
     */
	@RequestMapping("/selectBatchInAddAll")
	@ResponseBody
	public ModelAndView show(PubOpanoMalyDto pubOpanoMalyDto) throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchadd_edit");
		view.addObject("pubOpanoMalyDto",pubOpanoMalyDto);
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		pubOpanoMalyDto.setRegOrg(pubOpanoMalyDto.getDecOrg());//设置登记机关
		String regOrg= selectRegorgByDeptCode(sysUser);
 		//登记机关对应的部门（决定书设置）
		DepartMent  departMent = departMentService.selectDepartMentByDeptCodespec(pubOpanoMalyDto.getRegOrg());
		view.addObject("pubOpanoMalyDto", pubOpanoMalyDto);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("departMent", departMent);
		view.addObject("year", DateUtil.getCurrentYear());
		view.addObject("userType", sysUser.getUserType());
		view.addObject("sysUser", sysUser);
		view.addObject("type", "all");
		return view;
	}

	/**
	 *
	 * 描述: 全部批量列入异常
	 * @auther gaojinling
	 * @date 2017年6月19日
	 * @param pubOpanoMaly
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/batchInAddAllCommit")
    @ResponseBody
	public AjaxResult batchInAddAllCommit(@Valid PubOpanoMaly pubOpanoMaly,String isIndivid,String estDateStart,String estDateEnd) throws Exception{
		try {
			DepartMent departMent=departMentService.selectDepartMentByDeptCode(pubOpanoMaly.getRegOrg());
			if(StringUtil.isEmpty(departMent.getDocShortName())){
					return AjaxResult.error("保存失败!部门字号不能为空,请检查配置");
			}else{
					Integer docNo= pubOpanoMalyService.selectPenDecNoByRegOrg(departMent.getDocShortName());
					if(docNo==null){
						docNo=new Integer(1);
				 }
					String penDecNo=departMent.getDocShortName()+"异入〔" + DateUtils.getYear() + "〕第"+docNo+"号"+"-";
					pubOpanoMaly.setPenDecNo(penDecNo);
			}
			//处理时间
		   pubOpanoMaly.setFirstdate(DateUtil.getAllDate(pubOpanoMaly.getFirstdate()));
		   pubOpanoMaly.setAuditDate(DateUtil.getAllDate(pubOpanoMaly.getAuditDate()));
		   pubOpanoMaly.setCreateTime(new Date());
		   //设置列入时间
		   pubOpanoMaly.setAbnTime(DateUtil.getAllDate(pubOpanoMaly.getAbnTime()));
		   //设置列入年份
		   pubOpanoMaly.setSeqYear(Integer.parseInt((DateUtil.getCurrentYear())));
			Map<String, Object> map = new HashMap<String, Object>();

			map = ClassUtil.setConditionMap(pubOpanoMaly);
			map.put("isIndivid", isIndivid);
			map.put("estDateStart", estDateStart);
			map.put("estDateEnd", estDateEnd);
			pubOpanoMalyService.insertIntoPubopaNomalyInALl(map);
			return AjaxResult.success("全部插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error(e.getMessage());
		}

	}

    /**
     *
     * 描述: 批量列入详情
     * @auther gaojinling
     * @date 2017年6月16日
     * @param pubOpanoMalyDto
     * @return
     * @throws Exception
     */
	@RequestMapping("/showDetail")
	@ResponseBody
	public ModelAndView showDetail(PubOpanoMalyDto pubOpanoMalyDto) throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchin_detail");
		List<PubOpanoMalyDto> pubOpanoMalyDtos = pubOpanoMalyService.selectBatchInListByPenDecNo(pubOpanoMalyDto.getPenDecNo());
		view.addObject("pubOpanoMalyDtos",pubOpanoMalyDtos);
		view.addObject("pubOpanoMalyDto",pubOpanoMalyDtos.get(0));
		view.addObject("initBatchNum",pubOpanoMalyDto.getInitBatchNum());
		view.addObject("penDecNo",pubOpanoMalyDto.getPenDecNo());
		return view;
	}
	/**
	 *
	 * 描述: 批量列入审批表打印
	 * @auther gaojinling
	 * @date 2017年6月16日
	 * @param pubOpanoMalyDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/printBatchTable")
	@ResponseBody
	public ModelAndView printBatchTable(PubOpanoMalyDto pubOpanoMalyDto) throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalyentsptable_print");
		List<PubOpanoMalyDto> pubOpanoMalyDtos = pubOpanoMalyService.selectBatchInListByPenDecNo(pubOpanoMalyDto.getPenDecNo());
		view.addObject("pubOpanoMalys",pubOpanoMalyDtos);
		view.addObject("pubOpanoMaly",pubOpanoMalyDtos.get(0));
		view.addObject("initBatchNum",pubOpanoMalyDto.getInitBatchNum());
		view.addObject("type","batch");
		return view;
	}
	/**
	 *
	 * 描述: 批量列入决定书打印
	 * @auther gaojinling
	 * @date 2017年6月16日
	 * @param pubOpanoMalyDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/printBatchBook")
	@ResponseBody
	public ModelAndView printBatchBook(PubOpanoMalyDto pubOpanoMalyDto) throws Exception{
		ModelAndView view= new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopanomalyent/pubopanomalybatchbook_print");
		List<PubOpanoMalyDto> pubOpanoMalyDtos = pubOpanoMalyService.selectBatchInListByPenDecNo(pubOpanoMalyDto.getPenDecNo());
		view.addObject("pubOpanoMalys",pubOpanoMalyDtos);
		view.addObject("pubOpanoMaly",pubOpanoMalyDtos.get(0));
		view.addObject("initBatchNum",pubOpanoMalyDto.getInitBatchNum());
		view.addObject("penDecNo",pubOpanoMalyDto.getPenDecNo());
		view.addObject("type","batch");
		return view;
	}


	/**
	 * 描述：查无下落后变更
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param session
	 */
	@RequestMapping("notFoundAltNum")
	@ResponseBody
	public void notFoundAltNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = pubOpanoMalyService.notFoundAltNum(qryMap);
		System.out.println(count+"====================");
	}
	
	/**
	 * 描述：查无下落后年报
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param session
	 */
	@RequestMapping("notFoundYcNum")
	@ResponseBody
	public void notFoundYcNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = pubOpanoMalyService.notFoundYcNum(qryMap);
		System.out.println(count+"====================");
	}
	
	/**
	 * 描述：经营异常将满三年
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param session
	 */
	@RequestMapping("opanomalySoonThreeYear")
	@ResponseBody
	public void opanomalySoonThreeYear() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = pubOpanoMalyService.opanomalySoonThreeYear(qryMap);
		System.out.println(count+"====================");
	}
	
	
	
	
		

}