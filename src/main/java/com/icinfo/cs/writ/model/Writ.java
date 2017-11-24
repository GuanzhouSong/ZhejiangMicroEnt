/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.writ.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:  cs_writ 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月06日
 */
@Table(name = "cs_writ")
public class Writ implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Uuid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uuid;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 文号
     */
    @Column(name = "WritNo")
    private String writNo;

    /**
     * 文书类型
     */
    @Column(name = "WritType")
    private String writType;

    /**
     * 文书名称
     */
    @Column(name = "WritName")
    private String writName;


    /**
     * 发送时间
     */
    @Column(name = "SendTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendTime;

    /**
     * 发送人
     */
    @Column(name = "SendPeople")
    private String sendPeople;

    /**
     * 通知对象
     */
    @Column(name = "NoticePeople")
    private String noticePeople;

    /**
     * 联系方式
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 查阅状态：0 未查阅  1已查阅
     */
    @Column(name = "MessageLookStatue")
    private String messageLookStatue;

    /**
     * 回执人
     */
    @Column(name = "ReceivePeople")
    private String receivePeople;

    /**
     * 文书回执状态 0：未回执  1：已回执
     */
    @Column(name = "WritReceiveStatue")
    private String writReceiveStatue;

    /**
     * 文书回执时间
     */
    @Column(name = "WritReceiveTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date writReceiveTime;

    /**
     * 催告次数
     */
    @Column(name = "InformNum")
    private Integer informNum;

    /**
     * 最新催告时间
     */
    @Column(name = "NewestInformTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date newestInformTime;

    /**
     * 文书关联主键 --> 文书决定书的主键
     */
    @Column(name = "WritKeyID")
    private String writKeyID;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 默认构造函数
     */
    public Writ() {
       super();
    }

    /**
     * 描述: 构造函数
     * @param priPID 内部序号
     * @param writNo 文号
     * @param writType 文书类型
     * @param writKeyID 文书主键 - 决定书主键
     */
    public Writ(String priPID, String writNo, String writType, String writKeyID) {
        this.priPID = priPID;
        this.writNo = writNo;
        this.writType = writType;
        this.writKeyID = writKeyID;
    }

    /**
     * 描述: 构造函数
     * @param priPID 内部序号
     * @param writNo 文号
     * @param writType 文书类型
     * @param writKeyID 文书主键 - 决定书主键
     * @param year  年份
     */
    public Writ(String priPID, String writNo, String writType, String writKeyID,Integer year) {
        this.priPID = priPID;
        this.writNo = writNo;
        this.writType = writType;
        this.writKeyID = writKeyID;
        this.year = year;
    }

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
     * @return Uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
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
     * 获取文号
     *
     * @return WritNo - 文号
     */
    public String getWritNo() {
        return writNo;
    }

    /**
     * 设置文号
     *
     * @param writNo 文号
     */
    public void setWritNo(String writNo) {
        this.writNo = writNo;
    }

    /**
     * 获取文书类型
     *
     * @return WritType - 文书类型
     */
    public String getWritType() {
        return writType;
    }

    /**
     * 设置文书类型
     *
     * @param writType 文书类型
     */
    public void setWritType(String writType) {
        this.writType = writType;
    }

    /**
     * 获取文书名称
     *
     * @return WritName - 文书名称
     */
    public String getWritName() {
        return writName;
    }

    /**
     * 设置文书名称
     *
     * @param writName 文书名称
     */
    public void setWritName(String writName) {
        this.writName = writName;
    }
    /**
     * 获取发送时间
     *
     * @return SendTime - 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取发送人
     *
     * @return SendPeople - 发送人
     */
    public String getSendPeople() {
        return sendPeople;
    }

    /**
     * 设置发送人
     *
     * @param sendPeople 发送人
     */
    public void setSendPeople(String sendPeople) {
        this.sendPeople = sendPeople;
    }

    /**
     * 获取通知对象
     *
     * @return NoticePeople - 通知对象
     */
    public String getNoticePeople() {
        return noticePeople;
    }

    /**
     * 设置通知对象
     *
     * @param noticePeople 通知对象
     */
    public void setNoticePeople(String noticePeople) {
        this.noticePeople = noticePeople;
    }

    /**
     * 获取联系方式
     *
     * @return Tel - 联系方式
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系方式
     *
     * @param tel 联系方式
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取查阅状态：0 未查阅  1已查阅
     *
     * @return MessageLookStatue - 查阅状态：0 未查阅  1已查阅
     */
    public String getMessageLookStatue() {
        return messageLookStatue;
    }

    /**
     * 设置查阅状态：0 未查阅  1已查阅
     *
     * @param messageLookStatue 查阅状态：0 未查阅  1已查阅
     */
    public void setMessageLookStatue(String messageLookStatue) {
        this.messageLookStatue = messageLookStatue;
    }

    /**
     * 获取回执人
     *
     * @return ReceivePeople - 回执人
     */
    public String getReceivePeople() {
        return receivePeople;
    }

    /**
     * 设置回执人
     *
     * @param receivePeople 回执人
     */
    public void setReceivePeople(String receivePeople) {
        this.receivePeople = receivePeople;
    }

    /**
     * 获取文书回执状态 0：未回执  1：已回执
     *
     * @return WritReceiveStatue - 文书回执状态 0：未回执  1：已回执
     */
    public String getWritReceiveStatue() {
        return writReceiveStatue;
    }

    /**
     * 设置文书回执状态 0：未回执  1：已回执
     *
     * @param writReceiveStatue 文书回执状态 0：未回执  1：已回执
     */
    public void setWritReceiveStatue(String writReceiveStatue) {
        this.writReceiveStatue = writReceiveStatue;
    }

    /**
     * 获取文书回执时间
     *
     * @return WritReceiveTime - 文书回执时间
     */
    public Date getWritReceiveTime() {
        return writReceiveTime;
    }

    /**
     * 设置文书回执时间
     *
     * @param writReceiveTime 文书回执时间
     */
    public void setWritReceiveTime(Date writReceiveTime) {
        this.writReceiveTime = writReceiveTime;
    }

    /**
     * 获取催告次数
     *
     * @return InformNum - 催告次数
     */
    public Integer getInformNum() {
        return informNum;
    }

    /**
     * 设置催告次数
     *
     * @param informNum 催告次数
     */
    public void setInformNum(Integer informNum) {
        this.informNum = informNum;
    }

    /**
     * 获取最新催告时间
     *
     * @return NewestInformTime - 最新催告时间
     */
    public Date getNewestInformTime() {
        return newestInformTime;
    }

    /**
     * 设置最新催告时间
     *
     * @param newestInformTime 最新催告时间
     */
    public void setNewestInformTime(Date newestInformTime) {
        this.newestInformTime = newestInformTime;
    }

    /**
     * 获取文书关联主键
     *
     * @return WritKeyID - 文书关联主键
     */
    public String getWritKeyID() {
        return writKeyID;
    }

    /**
     * 设置文书关联主键
     *
     * @param writKeyID 文书关联主键
     */
    public void setWritKeyID(String writKeyID) {
        this.writKeyID = writKeyID;
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