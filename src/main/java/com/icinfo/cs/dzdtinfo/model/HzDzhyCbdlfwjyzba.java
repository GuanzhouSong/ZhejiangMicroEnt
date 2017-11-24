/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    CS_HZ_DZHY_CBDLFWJYZBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_CBDLFWJYZBA")
public class HzDzhyCbdlfwjyzba implements Serializable {
    @Id
    @Column(name = "PRIPID")
   /**
     * 主键
     */
    
    private String priPid;
    /**
     * 经营类型
     */
    @Column(name = "JYZLX")
    private String jyzlx;

    private static final long serialVersionUID = 1L;

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:46:22
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:46:22
	 * @param priPid the priPid to set
	 */
	public void setPriPid(String priPid) {
		this.priPid = priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:46:22
	 * @return the jyzlx
	 */
	public String getJyzlx() {
		return jyzlx;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:46:22
	 * @param jyzlx the jyzlx to set
	 */
	public void setJyzlx(String jyzlx) {
		this.jyzlx = jyzlx;
	}

}