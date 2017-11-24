/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    CS_HZ_DZHY_FDCJJJGBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_FDCJJJGBA")
public class HzDzhyFdcjjjgba implements Serializable {
    /**
     * 自增id
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
     * 经纪人ID
     */
    @Column(name = "JJRID")
    private String jjrId;

    /**
     * 经纪人姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 身份证号
     */
    @Column(name = "CERNO")
    private String cerNo;

    /**
     * 资格证名称
     */
    @Column(name = "QUALIFICATIONNAME")
    private String qualificationName;

    /**
     * 资格证号
     */
    @Column(name = "QUALIFICATIONNO")
    private String qualificationNo;

    /**
     * 职务
     */
    @Column(name = "POSITION")
    private String position;

    /**
     * 电话
     */
    @Column(name = "TEL")
    private String tel;

    @Column(name = "ZWGFZDW")
    private String zwgfzdw;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param priPid the priPid to set
	 */
	public void setPriPid(String priPid) {
		this.priPid = priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the jjrid
	 */
	public String getJjrId() {
		return jjrId;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param jjrid the jjrid to set
	 */
	public void setJjrId(String jjrId) {
		this.jjrId = jjrId;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the cerNO
	 */
	public String getCerNo() {
		return cerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param cerNO the cerNO to set
	 */
	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the qualificationName
	 */
	public String getQualificationName() {
		return qualificationName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param qualificationName the qualificationName to set
	 */
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the qualificationNo
	 */
	public String getQualificationNo() {
		return qualificationNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param qualificationNo the qualificationNo to set
	 */
	public void setQualificationNo(String qualificationNo) {
		this.qualificationNo = qualificationNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @return the zwgfzdw
	 */
	public String getZwgfzdw() {
		return zwgfzdw;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月15日上午9:58:37
	 * @param zwgfzdw the zwgfzdw to set
	 */
	public void setZwgfzdw(String zwgfzdw) {
		this.zwgfzdw = zwgfzdw;
	}

 
}