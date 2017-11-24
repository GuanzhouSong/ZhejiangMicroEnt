/**
 * Copyright@ 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 工具文件 <br/>
 * @author 胡义振
 * @date 2013-9-30
 * @version 1.0
 */
package com.icinfo.cs.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.icinfo.cs.common.constant.Constants;

/** 
 * 描述: 报表类型配置工具类
 * @author ZhouYan
 * @date 2016年9月13日  
 */
public class RepTypeUtil{
	
	//内外资公司法人（股份有限公司）
	public final static String entTypeLTD = "1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,5200,5210,5220,5230,5240,5290,6200,6210,6220,6230,6240,6250,6260,6270,6280,6290";
	
	//年报对外担保
	public static final String formForguaranteeinfo = "forguaranteeinfo"; 
	//年报其他情况
	public static final String formOtherinfo = "otherinfo"; 
	//年报对外投资
	public static final String formForinvestment = "forinvestment"; 
	//年报资产状况
	public static final String formAsset = "asset";
	//年报出资情况
	public static final String formSubcapital = "subcapital";
	//年报股权转让
	public static final String formAlterstockinfo = "alterstockinfo";	
	//年报经营情况
	public static final String formAssetbranch = "assetbranch";
	//社保情况
	public static final String formSocialSecurity = "socialSecurity";

	
	//即时行政许可
	public static final String formPermit = "permit";
	//即时知识产权出质登记
	public static final String formIppldg = "ippldg";
	//即时行政处罚
	public static final String formCase = "case";
	//即时股东及出资
	public static final String formInvestment = "investment";
	//即时股权变更
	public static final String formInvsralt = "invsralt";
	
	/** 
	 * 描述: 获取企业报表配置
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param entTypeCatg
	 * @param entType
	 * @return 
	 */
	public static List<String> getReportTypeList(String entTypeCatg, String entType, String year) {
		List<String> reportTypeList = new ArrayList<String>();
		if(StringUtils.isNotBlank(entTypeCatg)) {
			/*
			 * 11内资公司法人（有限责任公司）
			 * 11内资公司法人（股份有限公司）
			 * 21外资公司法人（有限责任公司）
			 * 21外资公司法人（股份有限公司）
			 * 13内资非公司企业法人
			 * 31个人独资企业
			 * 33内资合伙企业
			 * 内资非法人企业
			 * 27外商投资合伙企业
			 * 中外合作非法人企业
			 */
			if("11,13,21,27,31,33".indexOf(entTypeCatg) != -1){
				if("11,21".indexOf(entTypeCatg) != -1) {
					reportTypeList.add(formSubcapital); //出资情况   1
				}
				reportTypeList.add(formForinvestment); //对外投资  2
				reportTypeList.add(formAsset); //资产状况   3
			}

			/*
			 * 12内资分公司
			 * 14内资非公司企业法人分支机构
			 * 22外资分支机构
 			 * 24外国（地区）企业在中国境内从事生产经营活动
			 * 28外商投资合伙企业分支机构
			 * 32个人独资分支机构
 			 * 34内资合伙企业分支机构
			 */
			if("12,14,22,24,28,32,34".indexOf(entTypeCatg) != -1){
				reportTypeList.add(formAssetbranch); //经营情况  3
			}

			if("11,13,21,27,31,33".indexOf(entTypeCatg) != -1){
				if("11,21".indexOf(entTypeCatg) != -1) {
					//内外资公司法人（有限责任公司）
					if(StringUtils.isNotBlank(entType) && entTypeLTD.indexOf(entType) == -1) {
						reportTypeList.add(formAlterstockinfo); //股权转让   4
					}
				}
			}
			//对外担保和其他情况所有类型都配置
			reportTypeList.add(formOtherinfo); //其他情况   5
			reportTypeList.add(formForguaranteeinfo); //对外担保   6

			//判断年份大于等于2016年才能进行添加
			if(Integer.valueOf(year)>=2016){
				reportTypeList.add(formSocialSecurity);  // 社保信息  7
			}
		}
		return reportTypeList;
	}	
	
	/** 
	 * 描述: 获取即时信息报表配置
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param entTypeCatg
	 * @param entType
	 * @return 
	 */
	public static List<String> getImReportTypeList(String entTypeCatg, String entType) {
		List<String> imReportTypeList = new ArrayList<String>();
		if(StringUtils.isNotBlank(entTypeCatg)) {
			/*
			 * 11内资公司法人（有限责任公司）
			 * 11内资公司法人（股份有限公司）
			 * 21外资公司法人（有限责任公司）
			 * 21外资公司法人（股份有限公司）
			 */
			if("11,21".indexOf(entTypeCatg) != -1) {
				imReportTypeList.add(formInvestment); //股东及出资
				//内外资公司法人（有限责任公司）
				if(StringUtils.isNotBlank(entType) && entTypeLTD.indexOf(entType) == -1) {
					imReportTypeList.add(formInvsralt); //股权变更
				}
			}

			//行政许可、知识产权出质登记、行政处罚所有类型都配置
			imReportTypeList.add(formPermit); //行政许可
			imReportTypeList.add(formIppldg); //知识产权出质登记
			imReportTypeList.add(formCase); //行政处罚

		}
		return imReportTypeList;
	}	
	
	/** 
	 * 描述: 返回系统类型：1企业2个体户3农专
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param entTypeCatg
	 * @return 
	 */
	public static String getSystemType(String entTypeCatg) {
		String systemType = Constants.SYSTEM_TYPE_ENT;//企业
		if(entTypeCatg.equals(Constants.entTypeCatgPB)) {//个体户
			systemType = Constants.SYSTEM_TYPE_PB;
		}else if(Constants.entTypeCatgSFC.indexOf(entTypeCatg) != -1){ //农专
			systemType = Constants.SYSTEM_TYPE_SFC;
		}
		return systemType;
	}
}
