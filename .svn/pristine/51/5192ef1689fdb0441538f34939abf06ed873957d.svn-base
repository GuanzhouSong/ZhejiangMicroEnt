/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:   小微历史记录表 sm_baseinfo_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月12日
 */
@Table(name = "sm_baseinfo_his")
public class SmBaseinfoHis implements Serializable {
	
	/**
     * UID
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "UID")
    private String UID;
    
    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 列入小微原因
     */
    @Column(name = "SmentReason")
    private String smentReason;

    /**
     * 进入历史记录原因
     */
    @Column(name = "HisReason")
    private String hisReason;

    private static final long serialVersionUID = 1L;
    

    public SmBaseinfoHis() {
		super();
	}

	public SmBaseinfoHis( SmBaseinfoDto smDto,String hisReason) {
		super();
		this.priPID = smDto.getPriPID();
		this.smentReason = smDto.getSmentReason();
		this.hisReason = hisReason;
	}

	/**
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }


    /**
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取列入小微原因
     *
     * @return SmentReason - 列入小微原因
     */
    public String getSmentReason() {
        return smentReason;
    }

    /**
     * 设置列入小微原因
     *
     * @param smentReason 列入小微原因
     */
    public void setSmentReason(String smentReason) {
        this.smentReason = smentReason;
    }

	public String getHisReason() {
		return hisReason;
	}

	public void setHisReason(String hisReason) {
		this.hisReason = hisReason;
	}
    
    

}