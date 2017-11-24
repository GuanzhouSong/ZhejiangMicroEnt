/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_sp_pledge 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月27日
 */
@Table(name = "cs_sp_pledge")
public class SpPledge implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;
    
    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     *  序号
     */
    @Column(name = "uid")
    private String uid;

    /**
     *  质权抵押编号
     */
    @Column(name = "OrderNO")
    private String orderNO;

    /**
     *  出质人姓名
     */
    @Column(name = "Pledgor")
    private String pledgor;

    /**
     *  出质人证照/证件号码
     */
    @Column(name = "PleBLicNO")
    private String pleBLicNO;

    /**
     *  出质股权数额
     */
    @Column(name = "ImpAm")
    private BigDecimal impAm;

    /**
     *  质权人
     */
    @Column(name = "ImpOrg")
    private String impOrg;

    /**
     *  质权人证照/证件号码
     */
    @Column(name = "ImpBLicNO")
    private String impBLicNO;

    /**
     *  备案日期
     */
    @Column(name = "RecDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date recDate;

    /**
     *  状态
     */
    @Column(name = "Status")
    private String status;

    /**
     *  设立日期
     */
    @Column(name = "EquPleDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date equPleDate;

    /**
     *  注销原因
     */
    @Column(name = "CanRea")
    private String canRea;

    /**
     *  来源
     */
    @Column(name = "EquSource")
    private String equSource;

    /**
     *  时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 序号
     *
     * @return uid -  序号
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置 序号
     *
     * @param uid  序号
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取 质权抵押编号
     *
     * @return OrderNO -  质权抵押编号
     */
    public String getOrderNO() {
        return orderNO;
    }

    /**
     * 设置 质权抵押编号
     *
     * @param orderNO  质权抵押编号
     */
    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    /**
     * 获取 出质人姓名
     *
     * @return Pledgor -  出质人姓名
     */
    public String getPledgor() {
        return pledgor;
    }

    /**
     * 设置 出质人姓名
     *
     * @param pledgor  出质人姓名
     */
    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    /**
     * 获取 出质人证照/证件号码
     *
     * @return PleBLicNO -  出质人证照/证件号码
     */
    public String getPleBLicNO() {
        return pleBLicNO;
    }

    /**
     * 设置 出质人证照/证件号码
     *
     * @param pleBLicNO  出质人证照/证件号码
     */
    public void setPleBLicNO(String pleBLicNO) {
        this.pleBLicNO = pleBLicNO;
    }

    /**
     * 获取 出质股权数额
     *
     * @return ImpAm -  出质股权数额
     */
    public BigDecimal getImpAm() {
        return impAm;
    }

    /**
     * 设置 出质股权数额
     *
     * @param impAm  出质股权数额
     */
    public void setImpAm(BigDecimal impAm) {
        this.impAm = impAm;
    }

    /**
     * 获取 质权人
     *
     * @return ImpOrg -  质权人
     */
    public String getImpOrg() {
        return impOrg;
    }

    /**
     * 设置 质权人
     *
     * @param impOrg  质权人
     */
    public void setImpOrg(String impOrg) {
        this.impOrg = impOrg;
    }

    /**
     * 获取 质权人证照/证件号码
     *
     * @return ImpBLicNO -  质权人证照/证件号码
     */
    public String getImpBLicNO() {
        return impBLicNO;
    }

    /**
     * 设置 质权人证照/证件号码
     *
     * @param impBLicNO  质权人证照/证件号码
     */
    public void setImpBLicNO(String impBLicNO) {
        this.impBLicNO = impBLicNO;
    }

    /**
     * 获取 备案日期
     *
     * @return RecDate -  备案日期
     */
    public Date getRecDate() {
        return recDate;
    }

    /**
     * 设置 备案日期
     *
     * @param recDate  备案日期
     */
    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    /**
     * 获取 状态
     *
     * @return Status -  状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态
     *
     * @param status  状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取 设立日期
     *
     * @return EquPleDate -  设立日期
     */
    public Date getEquPleDate() {
        return equPleDate;
    }

    /**
     * 设置 设立日期
     *
     * @param equPleDate  设立日期
     */
    public void setEquPleDate(Date equPleDate) {
        this.equPleDate = equPleDate;
    }

    /**
     * 获取 注销原因
     *
     * @return CanRea -  注销原因
     */
    public String getCanRea() {
        return canRea;
    }

    /**
     * 设置 注销原因
     *
     * @param canRea  注销原因
     */
    public void setCanRea(String canRea) {
        this.canRea = canRea;
    }

    /**
     * 获取 来源
     *
     * @return EquSource -  来源
     */
    public String getEquSource() {
        return equSource;
    }

    /**
     * 设置 来源
     *
     * @param equSource  来源
     */
    public void setEquSource(String equSource) {
        this.equSource = equSource;
    }

    /**
     * 获取 时间戳
     *
     * @return CreateTime -  时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 时间戳
     *
     * @param createTime  时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}
    
	/**
     * 获取股权出质状态名称
     *@author chenyu
     * @param createTime  时间戳
     */
	public String getStatusName(){
		if(this.getStatus().equals("X"))
			return "注销";
		if(this.getStatus().equals("C"))
			return "撤销";
		if(this.getStatus().equals("D"))
			return "吊销";
		if(this.getStatus().equals("K"))
			return "存续";
		if(this.getStatus().equals("B"))
			return "存续";
		if(this.getStatus().equals("A"))
			return "存续";
		if(this.getStatus().equals("DA"))
			return "存续";
		if(this.getStatus().equals("Q"))
			return "迁出";
		return null;
	}
}