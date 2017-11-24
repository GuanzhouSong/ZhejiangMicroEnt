/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    CS_HZ_DZHY_CSYSPJYDWBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_CSYSPJYDWBA")
public class HzDzhyCsyspjydwba implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主键
     */
    @Column(name = "PRIPID")
    private String priPid;

    /**
     * 经营单位性质
     */
    @Column(name = "JYDWXZ")
    private String jydwxz;

    /**
     * 艺术品类型
     */
    @Column(name = "YSPTYPE")
    private String ysptype;

    /**
     * 具体经营品种
     */
    @Column(name = "JYPZ")
    private String jypz;

    /**
     * 实际经营场所面积
     */
    @Column(name = "JYMJ")
    private BigDecimal jymj;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @param priPid the priPid to set
	 */
	public void setPriPid(String priPid) {
		this.priPid = priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @return the jydwxz
	 */
	public String getJydwxz() {
		return jydwxz;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @param jydwxz the jydwxz to set
	 */
	public void setJydwxz(String jydwxz) {
		this.jydwxz = jydwxz;
	}

	 

	public String getYsptype() {
		return ysptype;
	}

	public void setYsptype(String ysptype) {
		this.ysptype = ysptype;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @return the jypz
	 */
	public String getJypz() {
		return jypz;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @param jypz the jypz to set
	 */
	public void setJypz(String jypz) {
		this.jypz = jypz;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @return the jymj
	 */
	public BigDecimal getJymj() {
		return jymj;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:48:01
	 * @param jymj the jymj to set
	 */
	public void setJymj(BigDecimal jymj) {
		this.jymj = jymj;
	}

}