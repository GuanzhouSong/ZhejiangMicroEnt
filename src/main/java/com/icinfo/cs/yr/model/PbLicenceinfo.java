/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_pb_licenceinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月12日
 */
@Table(name = "cs_pb_licenceinfo")
public class PbLicenceinfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2673711069641258417L;

	@Id
    @Column(name = "id")
    private Integer id;

    /**
     * 许可文件名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 有效期至
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
    @Column(name = "ValTo")
    private Date valTo;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    private Date createTime;

    /**
     * 许可文件中文名称
     */
    @Column(name = "LicNameCN")
    private String licNameCN;

    /**
     * 许可文件Id
     */
    @Column(name = "LicID")
    private String licID;

    /**
     * 年报Id
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取许可文件名称
     *
     * @return LicName - 许可文件名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可文件名称
     *
     * @param licName 许可文件名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取有效期至
     *
     * @return ValTo - 有效期至
     */
    public Date getValTo() {
        return valTo;
    }

    /**
     * 设置有效期至
     *
     * @param valTo 有效期至
     */
    public void setValTo(Date valTo) {
        this.valTo = valTo;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取许可文件中文名称
     *
     * @return LicNameCN - 许可文件中文名称
     */
    public String getLicNameCN() {
        return licNameCN;
    }

    /**
     * 设置许可文件中文名称
     *
     * @param licNameCN 许可文件中文名称
     */
    public void setLicNameCN(String licNameCN) {
        this.licNameCN = licNameCN;
    }

    /**
     * 获取许可文件Id
     *
     * @return LicID - 许可文件Id
     */
    public String getLicID() {
        return licID;
    }

    /**
     * 设置许可文件Id
     *
     * @param licID 许可文件Id
     */
    public void setLicID(String licID) {
        this.licID = licID;
    }

    /**
     * 获取年报Id
     *
     * @return AnCheID - 年报Id
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报Id
     *
     * @param anCheID 年报Id
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }
    
  	/** 
  	 * 描述: 公示敏感词校验字符串
  	 * @auther ZhouYan
  	 * @date 2016年10月10日 
  	 * @return 
  	 */
  	public String getPubForbidInfo() {
  		return "许可证信息 [行政许可名称=" + licNameCN + "]";
  	}
}