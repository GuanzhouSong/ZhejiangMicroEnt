/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App 年报各填报报表.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/yrpbbaseinfo")
public class AppQueryYrPbBaseinfoController extends CSBaseController {
	
	//mid基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	@Autowired
	private IYrPbLicenceInfoService yrPbLicenceInfoService;
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;

	/**
	 * 
	 * 描述: 个体户年报报表查询cs_yr_pb_baseinfo/cs_yr_pb_licenceinfo/cs_yr_pb_websiteinfo  3张表
	 * @auther gaojinling
	 * @date 2017年2月21日 
	 * @param pripid
	 * @param year
	 * @param info   取值 all/baseInfo/licenceInfo/websiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryYrPbBaseinfo.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryMidBaseInfo(String pripid,String year,String info)throws Exception{
	 JSONObject jsonObj = new JSONObject();
		try {
			if(StringUtil.isBlank(pripid) || StringUtil.isBlank(year) || StringUtil.isBlank(info) ) {
				jsonObj.put("result",  "");
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			
			//查询核准基本信息（个体户）
			pripid = AESEUtil.decodeCorpid(pripid); //内部序号解密
			MidBaseInfoDto midBaseInfoDto  = midBaseInfoService.selectMidBaseInfoByPripid(pripid, "2");
			
			if(midBaseInfoDto == null){
				jsonObj.put("result",  "");
				jsonObj.put("errcode", "1");
			    return AjaxResult.success("该个体户不在系统范围内", jsonObj); 
			}
			
			YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, pripid,"1");
			if(yrPbBaseInfo != null){
			}else{
			YrPbBaseInfo yrPbBaseInfoTem = new YrPbBaseInfo();
			yrPbBaseInfoTem.setName(midBaseInfoDto.getLeRep());
			yrPbBaseInfoTem.setPriPID(midBaseInfoDto.getPriPID());
			yrPbBaseInfoTem.setRegNO(midBaseInfoDto.getRegNO());
			yrPbBaseInfoTem.setOpLoc(midBaseInfoDto.getDom());
			yrPbBaseInfoTem.setTraName(midBaseInfoDto.getEntName());
			yrPbBaseInfoTem.setUniCode(midBaseInfoDto.getUniCode());
			yrPbBaseInfoTem.setComPhone(midBaseInfoDto.getTel());
			yrPbBaseInfoTem.setYear(Integer.valueOf(year));
			yrPbBaseInfoService.saveYrPbBaseInfo(yrPbBaseInfoTem);
			yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, pripid,"1");
			}
			
     		//获取年报anCheID
			String anCheID = yrPbBaseInfo.getAnCheID();
			// 查询信息结果map
			Map<String, Object> resultMap = new HashMap<String, Object>();
			//个体户年报基本信息
			if("all".equals(info) || "baseInfo".equals(info)){
				Map<String, Object> baseInfoMap = new HashMap<String, Object>();
				if(yrPbBaseInfo != null){
					baseInfoMap.put("anCheID", yrPbBaseInfo.getAnCheID() == null ? "" :yrPbBaseInfo.getAnCheID() );
					baseInfoMap.put("priPID", AESEUtil.encodeCorpid(yrPbBaseInfo.getPriPID()));
					baseInfoMap.put("year", yrPbBaseInfo.getYear());
					baseInfoMap.put("traName", yrPbBaseInfo.getTraName() == null ? "" :yrPbBaseInfo.getTraName());
					baseInfoMap.put("regNO", yrPbBaseInfo.getRegNO() == null ? "" :yrPbBaseInfo.getRegNO());
					baseInfoMap.put("opLoc", yrPbBaseInfo.getOpLoc() == null ? "" :yrPbBaseInfo.getOpLoc());
					baseInfoMap.put("empNum", yrPbBaseInfo.getEmpNum() == null ? "" :yrPbBaseInfo.getEmpNum());
					baseInfoMap.put("fundAm", yrPbBaseInfo.getFundAm() == null ? "" :yrPbBaseInfo.getFundAm());
					baseInfoMap.put("ratGro", yrPbBaseInfo.getRatGro() == null ? "" :yrPbBaseInfo.getRatGro());
					//营业额或营业收入是否公示
					baseInfoMap.put("vendIncIsPub", yrPbBaseInfo.getVendIncIsPub() == null ? "0" :yrPbBaseInfo.getVendIncIsPub());
					baseInfoMap.put("uniCode", yrPbBaseInfo.getUniCode() == null ? "" :yrPbBaseInfo.getUniCode());
					baseInfoMap.put("name", yrPbBaseInfo.getName() == null ? "" :yrPbBaseInfo.getName());
					baseInfoMap.put("tel", yrPbBaseInfo.getTel() == null ? "" :yrPbBaseInfo.getTel());
					baseInfoMap.put("vendInc", yrPbBaseInfo.getVendInc() == null ? "" :yrPbBaseInfo.getVendInc());
					baseInfoMap.put("isLegRep", yrPbBaseInfo.getIsLegRep() == null ? "" :yrPbBaseInfo.getIsLegRep());
					baseInfoMap.put("parInsCN", yrPbBaseInfo.getParInsCN() == null ? "" :yrPbBaseInfo.getParInsCN());
					baseInfoMap.put("pbFundAm", yrPbBaseInfo.getPbFundAm() == null ? "" :yrPbBaseInfo.getPbFundAm());
					baseInfoMap.put("partOrgIs", yrPbBaseInfo.getPartOrgIs() == null ? "" :yrPbBaseInfo.getPartOrgIs());
					baseInfoMap.put("comPhone", yrPbBaseInfo.getComPhone() == null ? "" :yrPbBaseInfo.getComPhone());
					baseInfoMap.put("rreeTaxIs", yrPbBaseInfo.getRreeTaxIs() == null ? "" :yrPbBaseInfo.getRreeTaxIs());
					baseInfoMap.put("parIns", yrPbBaseInfo.getParIns() == null ? "" :yrPbBaseInfo.getParIns());
					baseInfoMap.put("numParM", yrPbBaseInfo.getNumParM() == null ? "" :yrPbBaseInfo.getNumParM());
					baseInfoMap.put("resParMSign", yrPbBaseInfo.getResParMSign() == null ? "" :yrPbBaseInfo.getResParMSign());
					baseInfoMap.put("resParSecSign", yrPbBaseInfo.getResParSecSign() == null ? "" :yrPbBaseInfo.getResParSecSign());
					//纳税总额是否公示
					baseInfoMap.put("ratGroIsPub", yrPbBaseInfo.getRatGroIsPub() == null ? "0" :yrPbBaseInfo.getRatGroIsPub());
					baseInfoMap.put("disEmps", yrPbBaseInfo.getDisEmps() == null ? "" :yrPbBaseInfo.getDisEmps());
					baseInfoMap.put("exSoldEmps", yrPbBaseInfo.getExSoldEmps() == null ? "" :yrPbBaseInfo.getExSoldEmps());
					baseInfoMap.put("uniGradEmps", yrPbBaseInfo.getUniGradEmps() == null ? "" :yrPbBaseInfo.getUniGradEmps());
					baseInfoMap.put("unemEmps", yrPbBaseInfo.getUnemEmps() == null ? "" :yrPbBaseInfo.getUnemEmps());
					baseInfoMap.put("memberNumsIsPub", yrPbBaseInfo.getMemberNumsIsPub() == null ? "" :yrPbBaseInfo.getMemberNumsIsPub());
					baseInfoMap.put("websiteFlag", yrPbBaseInfo.getWebsiteFlag() == null ? "" :yrPbBaseInfo.getWebsiteFlag());
					baseInfoMap.put("licenseFlag", yrPbBaseInfo.getLicenseFlag() == null ? "" :yrPbBaseInfo.getLicenseFlag());
					baseInfoMap.put("areaAddressCopy", yrPbBaseInfo.getAreaAddressCopy() == null ? "" :yrPbBaseInfo.getAreaAddressCopy());
					baseInfoMap.put("streeAddressCopy", yrPbBaseInfo.getStreeAddressCopy() == null ? "" :yrPbBaseInfo.getStreeAddressCopy());
					baseInfoMap.put("cityAddressCopy", "3325".equals(midBaseInfoDto.getRegOrg().substring(0, 4)) ? "331100000000": midBaseInfoDto.getRegOrg().substring(0, 4)+"00000000"); //城市编码
				}
				resultMap.put("baseInfo", baseInfoMap);
			}
			//许可信息
			if("all".equals(info) || "licenceInfo".equals(info)){
				List<Object> indLicenseTempList = new ArrayList<Object>();
				List<YrPbLicenceInfo> IndLicenseInfoList = yrPbLicenceInfoService.selectPbLicenceListByAnCheID(anCheID);
				if(IndLicenseInfoList != null && IndLicenseInfoList.size()>0){
					for(YrPbLicenceInfo yrPbLicenceInfo : IndLicenseInfoList){
						Map<String, Object> licInfoMap = new HashMap<String, Object>();
						licInfoMap.put("anCheID", yrPbLicenceInfo.getAnCheID());//年报id
						licInfoMap.put("licID", yrPbLicenceInfo.getLicID());//唯一标识
						licInfoMap.put("licName", yrPbLicenceInfo.getLicName() == null ? "" : yrPbLicenceInfo.getLicName() == null); //许可编码
						licInfoMap.put("licNameCN", yrPbLicenceInfo.getLicNameCN() == null ? "" : yrPbLicenceInfo.getLicNameCN());//许可中文名称
						licInfoMap.put("valTo", DateUtil.dateToString(yrPbLicenceInfo.getValTo(), "yyyy-MM-dd"));//许可中文名称
						indLicenseTempList.add(licInfoMap);
					}
				}
				resultMap.put("licenceInfo", indLicenseTempList);
			}
			
			//网站信息
			if("all".equals(info) || "websiteInfo".equals(info)){
				List<Object> indwebTempList = new ArrayList<Object>();
				List<YrPbWebsiteInfo> yrPbWebsiteInfoList = yrPbWebsiteInfoService.selectPbWebsiteListByanCheID(anCheID);
				if(yrPbWebsiteInfoList != null && yrPbWebsiteInfoList.size()>0){
					for(YrPbWebsiteInfo yrPbWebsiteInfo : yrPbWebsiteInfoList){
						Map<String, Object> webInfoMap = new HashMap<String, Object>();
						webInfoMap.put("anCheID", yrPbWebsiteInfo.getAnCheID());
						webInfoMap.put("webSite", yrPbWebsiteInfo.getWebSite() == null ? "" :yrPbWebsiteInfo.getWebSite());//网站（网店）网址
						webInfoMap.put("webType", yrPbWebsiteInfo.getWebType() == null ? "" :yrPbWebsiteInfo.getWebType() ); //网站网店类型(1 网站  2网店)
						webInfoMap.put("webID", yrPbWebsiteInfo.getWebID());//唯一标识
						webInfoMap.put("webSitName", yrPbWebsiteInfo.getWebSitName() == null ? "" :yrPbWebsiteInfo.getWebSitName());//网站网店名称
						webInfoMap.put("webPlatFormType", yrPbWebsiteInfo.getWebPlatFormType() == null ? "" :yrPbWebsiteInfo.getWebPlatFormType());//网络交易平台运营类型:(第三方网络交易类平台-1;自营网络交易类平台-2;二者皆有-3)
						webInfoMap.put("webGoodsType", yrPbWebsiteInfo.getWebGoodsType() == null ? "" : yrPbWebsiteInfo.getWebGoodsType());//网络交易产品类型:(商品交易类平台-1;服务交易类平台-2;二者皆有-3)
						webInfoMap.put("eCommerceType", yrPbWebsiteInfo.geteCommerceType() == null ? "" :yrPbWebsiteInfo.geteCommerceType());// 电商类型:(B2B=1、B2C=2、C2C=3、团购=4、其他=5)
						webInfoMap.put("icpBackNO", yrPbWebsiteInfo.getIcpBackNO() == null ? "" :yrPbWebsiteInfo.getIcpBackNO());//ICP证号/备案号
						webInfoMap.put("weChatPublicNO", yrPbWebsiteInfo.getWeChatPublicNO() == null ? "" :yrPbWebsiteInfo.getWeChatPublicNO());//微信公众服务号
						webInfoMap.put("appNames", yrPbWebsiteInfo.getAppNames() == null ? "" :yrPbWebsiteInfo.getAppNames());// APP软件名称
						webInfoMap.put("belongPlatFormName", yrPbWebsiteInfo.getBelongPlatFormName() == null ? "" :yrPbWebsiteInfo.getBelongPlatFormName());//所属平台名称:如天猫、淘宝、京东、1688、蘑菇街、贝贝网、义乌购、海宁皮城等）
						webInfoMap.put("sendAddress", yrPbWebsiteInfo.getSendAddress() == null ? "" : yrPbWebsiteInfo.getSendAddress());//发货地址
						webInfoMap.put("backAddress", yrPbWebsiteInfo.getBackAddress() == null ? "" : yrPbWebsiteInfo.getBackAddress());//退货地址
						webInfoMap.put("webSmallType", yrPbWebsiteInfo.getWebSmallType() == null ? "" :yrPbWebsiteInfo.getWebSmallType());//网站类型：网络交易平台，企业信息管网
						indwebTempList.add(webInfoMap);
					}
				}
				resultMap.put("websiteInfo", indwebTempList);
			}

			jsonObj.put("result",  resultMap);
			jsonObj.put("errcode", "0");
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("result",  "");
			jsonObj.put("errcode", "500");
			e.printStackTrace();
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}	
	
}