/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 描述:    cs_rpt_announcement_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name = "cs_rpt_announcement_info")
public class RptAnnounceMentInfo implements Serializable {
	 /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * 描述:  
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 地市编码
     */
    @Column(name = "areacode")
    private String areacode;  
    /**
     * 登记机关
     */
    @Column(name = "regorgCode")
    private String regorgCode; 
    /**
     * 管辖单位
     */
    @Column(name = "localadmCode")
    private String localadmCode; 
    /**
     * 公告类型
     */
    @Column(name = "PubType")
    private String PubType; 
    
    /**
     * 条数
     */
    @Column(name = "num")
    private Integer num;

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getRegorgCode() {
		return regorgCode;
	}

	public void setRegorgCode(String regorgCode) {
		this.regorgCode = regorgCode;
	}

	public String getLocaladmCode() {
		return localadmCode;
	}

	public void setLocaladmCode(String localadmCode) {
		this.localadmCode = localadmCode;
	}

	public String getPubType() {
		return PubType;
	}

	public void setPubType(String pubType) {
		PubType = pubType;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}