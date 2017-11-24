package com.icinfo.cs.depsyn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * 描述:    cs_depsyn_search_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月10日
 */
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_depsyn_search_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月10日
 */

@Table(name = "cs_depsyn_search_his")
public class DepSynSearchHis implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5538697350216853416L;

	@Column(name = "id")
	private Integer id;

	/**
	 * UUID
	 */
	@Column(name = "UID")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "HisPriPID")
    private String hisPriPID;
    
    /**
     * 企业名称
     */
    @Column(name = "HisEntName")
    private String hisEntName;
    
    /**
     * 统一信用代码
     */
    @Column(name = "HisUniCode")
    private String hisUniCode;
    
    /**
     * 注册号
     */
    @Column(name = "HisRegNO")
    private String hisRegNO;
    
    /**
     * 用户id
     */
    @Column(name = "HisUserId")
    private String hisUserId;
    
    /**
     * 浏览时间
     */
	@Column(name = "HisViewTime")
    private Date hisViewTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getHisPriPID() {
		return hisPriPID;
	}

	public void setHisPriPID(String hisPriPID) {
		this.hisPriPID = hisPriPID;
	}

	public String getHisEntName() {
		return hisEntName;
	}

	public void setHisEntName(String hisEntName) {
		this.hisEntName = hisEntName;
	}

	public String getHisUniCode() {
		return hisUniCode;
	}

	public void setHisUniCode(String hisUniCode) {
		this.hisUniCode = hisUniCode;
	}

	public String getHisRegNO() {
		return hisRegNO;
	}

	public void setHisRegNO(String hisRegNO) {
		this.hisRegNO = hisRegNO;
	}

	public String getHisUserId() {
		return hisUserId;
	}

	public void setHisUserId(String hisUserId) {
		this.hisUserId = hisUserId;
	}

	public Date getHisViewTime() {
		return hisViewTime;
	}

	public void setHisViewTime(Date hisViewTime) {
		this.hisViewTime = hisViewTime;
	}

}
