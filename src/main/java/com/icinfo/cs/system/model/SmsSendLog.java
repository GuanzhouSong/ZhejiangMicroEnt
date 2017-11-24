/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_sms_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月31日
 */
@Table(name = "cs_sms_log")
public class SmsSendLog implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 手机号码
     */
    @Column(name = "PhoneNum")
    private String phoneNum;
    
    /**
     * 登记机关编码
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 发送状态 Success -1，Faild或其它-0，手机号码校验不通过-2
     */
    @Column(name = "SendState")
    private String sendState;
    
    /**
     * 发送内容
     */
    @Column(name = "SendContent")
    private String sendContent;
    
    /**
     * 返回信息
     */
    @Column(name = "ReturnMsg")
    private String returnMsg;

    /**
     * 生成时间
     */
    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

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
     * 获取唯一标识
     *
     * @return UID - 唯一标识
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置唯一标识
     *
     * @param UID 唯一标识
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取手机号码
     *
     * @return PhoneNum - 手机号码
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNum 手机号码
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 获取发送状态
     *
     * @return SendState - 发送状态
     */
    public String getSendState() {
        return sendState;
    }

    /**
     * 设置发送状态
     *
     * @param sendState 发送状态
     */
    public void setSendState(String sendState) {
        this.sendState = sendState;
    }
    
    /**
     * 获取生成时间
     *
     * @return CreatTime - 生成时间
     */
	public Date getCreateTime() {
		return createTime;
	}
    
	 /**
     * 设置生成时间
     *
     * @return CreatTime - 生成时间
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}
	
	
    
    
}