/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.composite.controller.syn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.SfcBalanctsheet;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.cs.yr.model.YrSfcLicenceInfo;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.service.ISfcBalanctsheetService;
import com.icinfo.cs.yr.service.ISfcIncomechangeService;
import com.icinfo.cs.yr.service.ISfcIncstatementService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.cs.yr.service.IYrSfcBranchInfoService;
import com.icinfo.cs.yr.service.IYrSfcLicenceInfoService;
import com.icinfo.cs.yr.service.IYrSfcSocialSecurityService;
import com.icinfo.cs.yr.service.IYrSfcWebsiteInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 
 * 描述: 农专社部门审核   综合信息报表工商端审核
 * @author gaojinling
 * @date 2016年11月29日
 */
@Controller
@RequestMapping({ "/syn/balanctsheet", "/reg/server/balanctsheet" })
public class SfcBalanctsheetServerController extends BaseController {
    @Autowired
    private ISfcBalanctsheetService sfcBalanctsheetService;
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    @Autowired
    private ISfcIncomechangeService sfcIncomechangeService;
    @Autowired
    private IYrSfcBaseinfoService yrSfcBaseinfoService;
    @Autowired
    private ISfcIncstatementService sfcIncstatementService;
    @Autowired
    private ICodeCertypeService codeCertypeService;
    @Autowired
    private IPubEppasswordService pubEppasswordService;
    @Autowired
    private IYrSfcLicenceInfoService yrSfcLicenceInfoService;
    @Autowired
    private IYrSfcWebsiteInfoService yrSfcWebsiteInfoService;
    @Autowired
    private IYrSfcBranchInfoService yrSfcBranchInfoService; 
    @Autowired
	private IYrSfcSocialSecurityService yrSfcSocialSecurityService;


    /**
     * 
     * 描述: 资产负债（工商端查看）
     * @auther gaojinling
     * @date 2016年11月29日 
     * @param year
     * @param priPID
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, String priPID) throws Exception{
        ModelAndView view = new ModelAndView("/syn/system/composite/sfcassetlia_view");
		if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)){			
        List<SfcBalanctsheet> sfcBalanctsheetList = sfcBalanctsheetService.selectByYearAndPripid(Integer.parseInt(year),priPID);
        //获取上一年的数据
        List<SfcBalanctsheet> lastYearList = sfcBalanctsheetService.selectByYearAndPripid(Integer.parseInt(year)-1,priPID);
       if(lastYearList.size()>0){
            if(lastYearList.get(1)!=null){
                view.addObject("lastYearData",lastYearList.get(1)); //获取上一年 年末数据
            }
        }else {
            view.addObject("lastYearData",null); //获取上一年 年末数据
        }
        view.addObject("sfcBalanctsheetList",sfcBalanctsheetList);
        view.addObject("year",year);
        view.addObject("priPID",priPID);
		}
        return view;
    }
    
    /**
     * 
     * 描述: 盈余分配（工商端查看）
     * @auther gaojinling
     * @date 2016年11月29日 
     * @param year
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/incomeChange")
    public ModelAndView incomeChangeView(String year,String priPID) throws Exception {
        ModelAndView view = new ModelAndView("/syn/system/composite/sfcequitalter_view");
		if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)){			
        view.addObject("sfcIncomechange", sfcIncomechangeService.selectByYearAndPripid(Integer.parseInt(year),priPID));
        view.addObject("sheetList", sfcBalanctsheetService.selectByYearAndPripid(Integer.valueOf(year),priPID));
        view.addObject("year",year);
        view.addObject("priPID",priPID);
		}
        return view;
    }
    
    /**
     * 
     * 描述: 成员权益变动（工商端查看）
     * @auther gaojinling
     * @date 2016年11月29日 
     * @param year
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/incStatement")
    public ModelAndView incStatementView(String year, String priPID) throws Exception {
        ModelAndView view = new ModelAndView("/syn/system/composite/sfcearningdist_view");
		if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)){			
        //查询农专的基本信息
        YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID,"0");
        if(yrSfcBaseinfo!=null){
            //万元 转换成 元
            BigDecimal priYeaProfit = yrSfcBaseinfo.getPriYeaProfit() == null ? null : yrSfcBaseinfo.getPriYeaProfit().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);//盈余总额
            view.addObject("priYeaProfit",priYeaProfit);
        }
        view.addObject("sfcIncstatement", sfcIncstatementService.selectByYearAndPripid(Integer.parseInt(year),priPID));
        view.addObject("year",year);
        view.addObject("priPID",priPID);
		}
        return view;
    }
    
    
    /**
     * 
     * 描述   根据农专基本信息页面
     * @author 赵祥江
     * @date 2016年12月1日 下午3:58:43 
     * @param 
     * @return ModelAndView
     * @throws
     */
	@RequestMapping("/sfcBaseInfo")
	public ModelAndView serverList(String priPID,String year,HttpSession session) throws Exception{	 
			ModelAndView view = new ModelAndView("/syn/system/composite/sfcbaseinfo_view");
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			//警示协同的地址 默认协同
			String sysUrl="/syn";
			//警示
			if("1".equals(sysUser.getUserType())){
				sysUrl="/reg/server";
			}
			if(StringUtil.isNotEmpty(year)){
		        //查询年报主表信息
		        YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year)); 
				//查询基本信息
				YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID,"1");
			    view.addObject("yrSfcBaseinfo",yrSfcBaseinfo); 
			    view.addObject("yrRegCheck", yrRegCheck);
				view.addObject("year", year); 
				//查询备案信息
				PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
			    if(pubEppassword != null){
			    	view.addObject("pubEppassword",pubEppassword);
			    }
			    //证件类型
				List<CodeCertype> Certypes = codeCertypeService.selectAll();
				//社保信息 
				YrSfcSocialSecurity yrSfcSocialSecurity=yrSfcSocialSecurityService.selectYrSfcSocialSecurityByAnCheID(yrSfcBaseinfo==null?"0000":yrSfcBaseinfo.getAnCheID(), "0");
				view.addObject("yrSfcSocialSecurity", yrSfcSocialSecurity);
			    view.addObject("Certypes", Certypes);
 				view.addObject("sysUrl", sysUrl);
			}
 		return view;
	}
	
	/**
	 * 
	 * 描述   根据年报ID分页查询农专许可证信息
	 * @author 赵祥江
	 * @date 2016年12月1日 下午3:58:18 
	 * @param 
	 * @return PageResponse<YrSfcLicenceInfo>
	 * @throws
	 */
	@RequestMapping({ "/licencelistJSON.json", "licencelist.xml" })
	@ResponseBody
	public PageResponse<YrSfcLicenceInfo> licencelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcLicenceInfo> data = new ArrayList<YrSfcLicenceInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcLicenceInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcLicenceInfo>(data);
	}


	/**
	 * 
	 * 描述   根据年报ID分页查询网站网店信息
	 * @author 赵祥江
	 * @date 2016年12月1日 下午3:57:55 
	 * @param 
	 * @return PageResponse<YrSfcWebsiteInfo>
	 * @throws
	 */
	@RequestMapping({ "/websitelistJSON.json", "websitelist.xml" })
	@ResponseBody
	public PageResponse<YrSfcWebsiteInfo> websitelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcWebsiteInfo> data = new ArrayList<YrSfcWebsiteInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcWebsiteInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcWebsiteInfo>(data);
	}



	/**
	 * 
	 * 描述   根据年报ID分页查询农专分支机构信息
	 * @author 赵祥江
	 * @date 2016年12月1日 下午3:57:36 
	 * @param 
	 * @return PageResponse<YrSfcBranchInfo>
	 * @throws
	 */
	@RequestMapping({ "/branchlistJSON.json", "branchlist.xml" })
	@ResponseBody
	public PageResponse<YrSfcBranchInfo> branchlistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcBranchInfo> data = new ArrayList<YrSfcBranchInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcBranchInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcBranchInfo>(data);
	}
}