/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_forinvestment 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_forinvestment")
public class ForinvestMent implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 所投资企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 所投资企业统一社会信用代码/所投资企业注册号
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 企业对外投资标识
     */
    @Column(name = "OUTINVID")
    private String OUTINVID;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取所投资企业名称
     *
     * @return EntName - 所投资企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置所投资企业名称
     *
     * @param entName 所投资企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取所投资企业统一社会信用代码/所投资企业注册号
     *
     * @return UniCode - 所投资企业统一社会信用代码/所投资企业注册号
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置所投资企业统一社会信用代码/所投资企业注册号
     *
     * @param uniCode 所投资企业统一社会信用代码/所投资企业注册号
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
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
     * 获取年报ID
     *
     * @return AnCheID - 年报ID
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报ID
     *
     * @param anCheID 年报ID
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取企业对外投资标识
     *
     * @return OUTINVID - 企业对外投资标识
     */
    public String getOUTINVID() {
        return OUTINVID;
    }

    /**
     * 设置企业对外投资标识
     *
     * @param OUTINVID 企业对外投资标识
     */
    public void setOUTINVID(String OUTINVID) {
        this.OUTINVID = OUTINVID;
    }
    
    /** 
 	 * 描述: 公示敏感词校验字符串
 	 * @auther ZhouYan
 	 * @date 2016年9月14日 
 	 * @return 
 	 */
 	public String getPubForbidInfo() {
 		return "对外投资信息 [在中国境内投资设立或购买股权的企业名称=" + entName + "]";
 	}
}