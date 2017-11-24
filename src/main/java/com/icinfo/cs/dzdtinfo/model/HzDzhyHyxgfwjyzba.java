/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述: CS_HZ_DZHY_HYXGFWJYZBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_HYXGFWJYZBA")
public class HzDzhyHyxgfwjyzba implements Serializable {

	/**
	 * 主键
	 */
	@Id
	@Column(name = "PRIPID")
	private String priPid;
	/**
	 * 主要代理 业务范围
	 * 
	 */
	@Column(name = "DLFW")
	private String dlfw;

	private static final long serialVersionUID = 1L;

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:05:27
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:05:27
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
	 * @when 2017年6月15日上午10:05:27
	 * @return the dlfw
	 */
	public String getDlfw() {
		return dlfw;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午10:05:27
	 * @param dlfw
	 *            the dlfw to set
	 */
	public void setDlfw(String dlfw) {
		this.dlfw = dlfw;
	}

}