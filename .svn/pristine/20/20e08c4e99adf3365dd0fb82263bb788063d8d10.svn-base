/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.copysend.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_copy_send_illegal 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月24日
 */
@Table(name = "cs_copy_send_illegal")
public class CopySendIllegal implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 抄告单编号
     */
    @Column(name = "CopyFormNo")
    private String copyFormNo;

    /**
     * 当事人名称
     */
    @Column(name = "ClientName")
    private String clientName;

    /**
     * 证件类型
     */
    @Column(name = "CertType")
    private String certType;

    /**
     * 证件号
     */
    @Column(name = "CertNo")
    private String certNo;

    /**
     * 地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 当事人联系电话
     */
    @Column(name = "ClientTel")
    private String clientTel;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取UID
     *
     * @return UID - UID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置UID
     *
     * @param UID UID
     */
    public void setUid(String uid) {
        this.uid = uid;
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
     * 获取抄告单编号
     *
     * @return CopyFormNo - 抄告单编号
     */
    public String getCopyFormNo() {
        return copyFormNo;
    }

    /**
     * 设置抄告单编号
     *
     * @param copyFormNo 抄告单编号
     */
    public void setCopyFormNo(String copyFormNo) {
        this.copyFormNo = copyFormNo;
    }

    /**
     * 获取当事人名称
     *
     * @return ClientName - 当事人名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置当事人名称
     *
     * @param clientName 当事人名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取证件类型
     *
     * @return CertType - 证件类型
     */
    public String getCertType() {
		return certType;
	}
    
    public String getCertTypeName() {
    	if("0".equals(certType))
    		return "营业执照";
    	if("10".equals(certType))
    		return "居民身份证";
    	if("20".equals(certType))
    		return "军官证";
    	if("30".equals(certType))
    		return "警官证";
    	if("40".equals(certType))
    		return "外国(地区)护照";
    	if("52".equals(certType))
    		return "香港身份证";
    	if("54".equals(certType))
    		return "澳门身份证";
    	if("56".equals(certType))
    		return "台湾身份证";
    	if("90".equals(certType))
    		return "其他有效身份证件";
        return certType;
    }

    

	/**
     * 设置证件类型
     *
     * @param certType 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取证件号
     *
     * @return CertNo - 证件号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置证件号
     *
     * @param certNo 证件号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * 获取地址
     *
     * @return Address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取当事人联系电话
     *
     * @return ClientTel - 当事人联系电话
     */
    public String getClientTel() {
        return clientTel;
    }

    /**
     * 设置当事人联系电话
     *
     * @param clientTel 当事人联系电话
     */
    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}