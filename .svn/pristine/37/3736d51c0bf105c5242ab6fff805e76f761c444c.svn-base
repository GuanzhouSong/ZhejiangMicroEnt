/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.message.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_message_sccheck 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月10日
 */
@Table(name = "cs_message_sccheck")
public class MessageScCheck implements Serializable {
    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 0,定时推送,1实时推送
     */
    @Column(name = "MsgType")
    private String msgType;

    /**
     * 主键uid
     */
    @Column(name = "MsgUid")
    private String msgUid;

    /**
     * 联络员电话
     */
    @Column(name = "LiaisonManTel")
    private String liaisonManTel;

    /**
     * 匹配信息
     */
    @Column(name = "MatchMsg")
    private String matchMsg;

    /**
     * 1、成功、2、部分成功、0失败
     */
    @Column(name = "State")
    private String state;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 发送内容
     */
    @Column(name = "Content")
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取0,定时推送,1实时推送
     *
     * @return MsgType - 0,定时推送,1实时推送
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 设置0,定时推送,1实时推送
     *
     * @param msgType 0,定时推送,1实时推送
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * 获取主键uid
     *
     * @return MsgUid - 主键uid
     */
    public String getMsgUid() {
        return msgUid;
    }

    /**
     * 设置主键uid
     *
     * @param msgUid 主键uid
     */
    public void setMsgUid(String msgUid) {
        this.msgUid = msgUid;
    }

    /**
     * 获取联络员电话
     *
     * @return LiaisonManTel - 联络员电话
     */
    public String getLiaisonManTel() {
        return liaisonManTel;
    }

    /**
     * 设置联络员电话
     *
     * @param liaisonManTel 联络员电话
     */
    public void setLiaisonManTel(String liaisonManTel) {
        this.liaisonManTel = liaisonManTel;
    }

    /**
     * 获取匹配信息
     *
     * @return MatchMsg - 匹配信息
     */
    public String getMatchMsg() {
        return matchMsg;
    }

    /**
     * 设置匹配信息
     *
     * @param matchMsg 匹配信息
     */
    public void setMatchMsg(String matchMsg) {
        this.matchMsg = matchMsg;
    }

    /**
     * 获取1、成功、2、部分成功、0失败
     *
     * @return State - 1、成功、2、部分成功、0失败
     */
    public String getState() {
        return state;
    }

    /**
     * 设置1、成功、2、部分成功、0失败
     *
     * @param state 1、成功、2、部分成功、0失败
     */
    public void setState(String state) {
        this.state = state;
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
     * 获取发送内容
     *
     * @return Content - 发送内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置发送内容
     *
     * @param content 发送内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}