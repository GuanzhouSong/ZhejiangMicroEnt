/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述: CS_HZ_DZHY_LXSFSFWWDBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_LXSFSFWWDBA")
public class HzDzhyLxsfsfwwdba implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@Column(name = "PRIPID")
	private String priPid;
	/**
	 * 机构类型
	 */
	@Column(name = "JGLX")
	private String jglx;
	//币种
	@Column(name = "CURRENCY")
	private String currency;
	
	//旅游类型
	@Column(name = "TRAVETYPE")
	private String traveType;
	
	
	
	/**
	 * 增存质量保证金日期
	 */
	@Column(name = "ADDDATE")
	private Date addDate;
	/**
	 * 增存金额
	 */
	@Column(name = "ADDJE")
	private BigDecimal addje;
	/**
	 * 银行
	 */
	@Column(name = "ZYKHYH")
	private String zykhyh;
	/**
	 * 银行帐号
	 */
	@Column(name = "ZYKHYHZH")
	private String zykhyhzh;

	private static final long serialVersionUID = 1L;

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param priPid
	 *            the priPid to set
	 */
	public void setPriPid(String priPid) {
		this.priPid = priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the jglx
	 */
	public String getJglx() {
		return jglx;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param jglx
	 *            the jglx to set
	 */
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param addDate
	 *            the addDate to set
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the addje
	 */
	public BigDecimal getAddje() {
		return addje;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param addje
	 *            the addje to set
	 */
	public void setAddje(BigDecimal addje) {
		this.addje = addje;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the zykhyh
	 */
	public String getZykhyh() {
		return zykhyh;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param zykhyh
	 *            the zykhyh to set
	 */
	public void setZykhyh(String zykhyh) {
		this.zykhyh = zykhyh;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @return the zykhyhzh
	 */
	public String getZykhyhzh() {
		return zykhyhzh;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:06:36
	 * @param zykhyhzh
	 *            the zykhyhzh to set
	 */
	public void setZykhyhzh(String zykhyhzh) {
		this.zykhyhzh = zykhyhzh;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTraveType() {
		return traveType;
	}

	public void setTraveType(String traveType) {
		this.traveType = traveType;
	} 
}