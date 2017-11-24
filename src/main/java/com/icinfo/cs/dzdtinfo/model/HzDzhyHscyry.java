/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述: CS_HZ_DZHY_HSCYRY 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_HSCYRY")
public class HzDzhyHscyry implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@Column(name = "PRIPID")
	private String priPid;
	/**
	 * 回收从业人员ID
	 */
	@Column(name = "HSCYID")
	private String hscyId;
	/**
	 * 从业人员姓名
	 */
	@Column(name = "NAME")
	private String name;
	/**
	 * 身份证号码
	 */
	@Column(name = "CERNO")
	private String cerNo;
	/**
	 * 手机号码
	 */
	@Column(name = "MOBTEL")
	private String mobtel;
	/**
	 * 职务
	 */
	@Column(name = "POSITION")
	private String position;

	private static final long serialVersionUID = 1L;

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
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
	 * @when 2017年6月15日上午10:04:22
	 * @return the hscyId
	 */
	public String getHscyId() {
		return hscyId;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @param hscyId
	 *            the hscyId to set
	 */
	public void setHscyId(String hscyId) {
		this.hscyId = hscyId;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @return the cerNo
	 */
	public String getCerNo() {
		return cerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @param cerNo
	 *            the cerNo to set
	 */
	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @return the mobtel
	 */
	public String getMobtel() {
		return mobtel;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @param mobtel
	 *            the mobtel to set
	 */
	public void setMobtel(String mobtel) {
		this.mobtel = mobtel;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:04:22
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

}