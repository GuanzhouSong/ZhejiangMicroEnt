/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.dto;

import org.apache.commons.lang.StringUtils;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.registmanage.model.QualificationLimit;

/**
 * 描述:    cs_qualification_limit 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
public class QualificationLimitDto extends QualificationLimit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1072823131690956388L;
	private String dom;
	private int relCount1;
	private int relCount2;
	private int relCount3;
	private int mgrRecCount;
	
	public int getRelCount1() {
		return relCount1;
	}

	public void setRelCount1(int relCount1) {
		this.relCount1 = relCount1;
	}

	public int getRelCount2() {
		return relCount2;
	}

	public void setRelCount2(int relCount2) {
		this.relCount2 = relCount2;
	}

	public int getRelCount3() {
		return relCount3;
	}

	public void setRelCount3(int relCount3) {
		this.relCount3 = relCount3;
	}

	public String getPriPIDDesc(){
		if(StringUtils.isNotEmpty(getPriPID())){
			return AESEUtil.encodeCorpid(getPriPID());
		}
		return "";
	}
	
	/**
     * 获取当事人证件类型0:经营许可证 其他参考编码表
     *
     * @return CertType - 当事人证件类型0:经营许可证 其他参考编码表
     */
    public String getCertTypeName() {
    	if("0".equals(getCertType()))
    		return "营业执照";
    	if("10".equals(getCertType()))
    		return "居民身份证";
    	if("20".equals(getCertType()))
    		return "军官证";
    	if("30".equals(getCertType()))
    		return "警官证";
    	if("40".equals(getCertType()))
    		return "外国(地区)护照";
    	if("52".equals(getCertType()))
    		return "香港身份证";
    	if("54".equals(getCertType()))
    		return "澳门身份证";
    	if("56".equals(getCertType()))
    		return "台湾身份证";
    	if("90".equals(getCertType()))
    		return "其他有效身份证件";
    	
        return "";
    }
    
    /**
     * 获取限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     *
     * @return LimitType - 限制类别0:吊销企业1:失信被执行人2:刑事责任司法判决3:失信惩戒黑名单4:工商严重违法失信
     */
    public String getLimitTypeName() {
    	if("0".equals(getLimitType()))
    		return "吊销企业";
    	if("1".equals(getLimitType()))
    		return "失信被执行人";
    	if("2".equals(getLimitType()))
    		return "刑事责任司法判决";
    	if("3".equals(getLimitType()))
    		return "失信惩戒黑名单";
    	if("4".equals(getLimitType()))
    		return "工商严重违法失信";
    	
        return "";
    }

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public int getMgrRecCount() {
		return mgrRecCount;
	}

	public void setMgrRecCount(int mgrRecCount) {
		this.mgrRecCount = mgrRecCount;
	}
}