/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ai12315.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述:    cs_ai_12315_invopt_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月06日
 */
@Table(name = "cs_ai_12315_invopt_info")
public class Ai12315InvoptInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "PT_ID")
    private String ptId;

    @Column(name = "CONT_ID")
    private String contId;

    @Column(name = "PTTYPE")
    private String ptType;

    @Column(name = "PRIPID")
    private String priPID;

    @Column(name = "INVOPT")
    private String invopt;

    @Column(name = "RegNO")
    private String regNO;

    @Column(name = "UniSCID")
    private String uniSCID;

    @Column(name = "UBINDTYPE")
    private String ubindtype;

    @Column(name = "EntType")
    private String entType;

    @Column(name = "Addr")
    private String addr;

    @Column(name = "Tel")
    private String tel;

 

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

	public String getPtId() {
		return ptId;
	}

	public void setPtId(String ptId) {
		this.ptId = ptId;
	}

	public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}

	public String getPtType() {
		return ptType;
	}

	public void setPtType(String ptType) {
		this.ptType = ptType;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getInvopt() {
		return invopt;
	}

	public void setInvopt(String invopt) {
		this.invopt = invopt;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getUniSCID() {
		return uniSCID;
	}

	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}

	public String getUbindtype() {
		return ubindtype;
	}

	public void setUbindtype(String ubindtype) {
		this.ubindtype = ubindtype;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}