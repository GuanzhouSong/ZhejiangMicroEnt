/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.message.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_message 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月18日
 */
@Table(name = "cs_message")
public class CsMessage implements Serializable {

    @Id
    @Column(name = "id")
    @Before
    private Integer           id;

    /**
     * 消息uuid
     */
    @Column(name = "MsgUid")
    private String            msgUid;

    /**
     * 消息标题
     */
    @Column(name = "MsgTitle")
    private String            msgTitle;

    /**
     * 消息内容txt文档路径
     */
    @Column(name = "MsgTxtPath")
    private String            msgTxtPath;

    /**
     * 消息备注
     */
    @Column(name = "MsgRemark")
    private String            msgRemark;

    /**
     * 消息pc端阅读状态 1 已读 0 未读
     */
    @Column(name = "MsgPcReadState")
    private String            msgPcReadState;

    /**
     * 消息pc端阅读时间
     */
    @Column(name = "MsgPcReadTime")
    private Date              msgPcReadTime;

    /**
     * 消息pc阅读人id
     */
    @Column(name = "MsgPcReadId")
    private String            msgPcReadId;

    /**
     * 消息pc阅读人姓名
     */
    @Column(name = "MsgPcReadName")
    private String            msgPcReadName;

    /**
     * 消息pc阅读人电话
     */
    @Column(name = "MsgPcReadTel")
    private String            msgPcReadTel;

    /**
     * 消息微信端阅读状态 1 已读 0 未读
     */
    @Column(name = "MsgWxReadState")
    private String            msgWxReadState;

    /**
     * 消息微信端阅读时间
     */
    @Column(name = "MsgWxReadTime")
    private Date              msgWxReadTime;

    /**
     * 消息微信阅读人id
     */
    @Column(name = "MsgWxReadId")
    private String            msgWxReadId;

    /**
     * 消息微信阅读人姓名
     */
    @Column(name = "MsgWxReadName")
    private String            msgWxReadName;

    /**
     * 消息微信阅读人电话
     */
    @Column(name = "MsgWxReadTel")
    private String            msgWxReadTel;

    /**
     * 消息连联端阅读状态 1 已读 0 未读
     */
    @Column(name = "MsgLlReadState")
    private String            msgLlReadState;

    /**
     * 消息连联端阅读时间
     */
    @Column(name = "MsgLlReadTime")
    private Date              msgLlReadTime;

    /**
     * 消息连联阅读人id
     */
    @Column(name = "MsgLlReadId")
    private String            msgLlReadId;

    /**
     * 消息连联阅读人姓名
     */
    @Column(name = "MsgLlReadName")
    private String            msgLlReadName;

    /**
     * 消息连联阅读人电话
     */
    @Column(name = "MsgLlReadTel")
    private String            msgLlReadTel;

    /**
     * 发送时间
     */
    @Column(name = "SendTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date              sendTime;

    /**
     * 发送人id
     */
    @Column(name = "SendId")
    private String            sendId;

    /**
     * 发送人姓名
     */
    @Column(name = "SendName")
    private String            sendName;

    /**
     * 发送部门id
     */
    @Column(name = "SendDeptId")
    private String            sendDeptId;

    //摘要
    @Column(name = "MsgAbstract")
    private String            msgAbstract;

    //类型
    @Column(name = "MsgType")
    private String            msgType;

    /**
     * 发送部门名称
     */
    @Column(name = "SendDeptName")
    private String            sendDeptName;

    @Column(name = "CreateTime")
    private Date              createTime;

    @Column(name = "UpdateTime")
    private Date              updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId(){
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取消息uuid
     *
     * @return MsgUid - 消息uuid
     */
    public String getMsgUid(){
        return msgUid;
    }

    /**
     * 设置消息uuid
     *
     * @param msgUid 消息uuid
     */
    public void setMsgUid(String msgUid){
        this.msgUid = msgUid;
    }

    /**
     * 获取消息标题
     *
     * @return MsgTitle - 消息标题
     */
    public String getMsgTitle(){
        return msgTitle;
    }

    /**
     * 设置消息标题
     *
     * @param msgTitle 消息标题
     */
    public void setMsgTitle(String msgTitle){
        this.msgTitle = msgTitle;
    }

    /**
     * 获取消息内容txt文档路径
     *
     * @return MsgTxtPath - 消息内容txt文档路径
     */
    public String getMsgTxtPath(){
        return msgTxtPath;
    }

    /**
     * 设置消息内容txt文档路径
     *
     * @param msgTxtPath 消息内容txt文档路径
     */
    public void setMsgTxtPath(String msgTxtPath){
        this.msgTxtPath = msgTxtPath;
    }

    /**
     * 获取消息备注
     *
     * @return MsgRemark - 消息备注
     */
    public String getMsgRemark(){
        return msgRemark;
    }

    /**
     * 设置消息备注
     *
     * @param msgRemark 消息备注
     */
    public void setMsgRemark(String msgRemark){
        this.msgRemark = msgRemark;
    }

    /**
     * 获取消息pc端阅读状态 1 已读 0 未读
     *
     * @return MsgPcReadState - 消息pc端阅读状态 1 已读 0 未读
     */
    public String getMsgPcReadState(){
        return msgPcReadState;
    }

    /**
     * 设置消息pc端阅读状态 1 已读 0 未读
     *
     * @param msgPcReadState 消息pc端阅读状态 1 已读 0 未读
     */
    public void setMsgPcReadState(String msgPcReadState){
        this.msgPcReadState = msgPcReadState;
    }

    /**
     * 获取消息pc端阅读时间
     *
     * @return MsgPcReadTime - 消息pc端阅读时间
     */
    public Date getMsgPcReadTime(){
        return msgPcReadTime;
    }

    /**
     * 设置消息pc端阅读时间
     *
     * @param msgPcReadTime 消息pc端阅读时间
     */
    public void setMsgPcReadTime(Date msgPcReadTime){
        this.msgPcReadTime = msgPcReadTime;
    }

    /**
     * 获取消息pc阅读人id
     *
     * @return MsgPcReadId - 消息pc阅读人id
     */
    public String getMsgPcReadId(){
        return msgPcReadId;
    }

    /**
     * 设置消息pc阅读人id
     *
     * @param msgPcReadId 消息pc阅读人id
     */
    public void setMsgPcReadId(String msgPcReadId){
        this.msgPcReadId = msgPcReadId;
    }

    /**
     * 获取消息pc阅读人姓名
     *
     * @return MsgPcReadName - 消息pc阅读人姓名
     */
    public String getMsgPcReadName(){
        return msgPcReadName;
    }

    /**
     * 设置消息pc阅读人姓名
     *
     * @param msgPcReadName 消息pc阅读人姓名
     */
    public void setMsgPcReadName(String msgPcReadName){
        this.msgPcReadName = msgPcReadName;
    }

    /**
     * 获取消息pc阅读人电话
     *
     * @return MsgPcReadTel - 消息pc阅读人电话
     */
    public String getMsgPcReadTel(){
        return msgPcReadTel;
    }

    /**
     * 设置消息pc阅读人电话
     *
     * @param msgPcReadTel 消息pc阅读人电话
     */
    public void setMsgPcReadTel(String msgPcReadTel){
        this.msgPcReadTel = msgPcReadTel;
    }

    /**
     * 获取消息微信端阅读状态 1 已读 0 未读
     *
     * @return MsgWxReadState - 消息微信端阅读状态 1 已读 0 未读
     */
    public String getMsgWxReadState(){
        return msgWxReadState;
    }

    /**
     * 设置消息微信端阅读状态 1 已读 0 未读
     *
     * @param msgWxReadState 消息微信端阅读状态 1 已读 0 未读
     */
    public void setMsgWxReadState(String msgWxReadState){
        this.msgWxReadState = msgWxReadState;
    }

    /**
     * 获取消息微信端阅读时间
     *
     * @return MsgWxReadTime - 消息微信端阅读时间
     */
    public Date getMsgWxReadTime(){
        return msgWxReadTime;
    }

    /**
     * 设置消息微信端阅读时间
     *
     * @param msgWxReadTime 消息微信端阅读时间
     */
    public void setMsgWxReadTime(Date msgWxReadTime){
        this.msgWxReadTime = msgWxReadTime;
    }

    /**
     * 获取消息微信阅读人id
     *
     * @return MsgWxReadId - 消息微信阅读人id
     */
    public String getMsgWxReadId(){
        return msgWxReadId;
    }

    /**
     * 设置消息微信阅读人id
     *
     * @param msgWxReadId 消息微信阅读人id
     */
    public void setMsgWxReadId(String msgWxReadId){
        this.msgWxReadId = msgWxReadId;
    }

    /**
     * 获取消息微信阅读人姓名
     *
     * @return MsgWxReadName - 消息微信阅读人姓名
     */
    public String getMsgWxReadName(){
        return msgWxReadName;
    }

    /**
     * 设置消息微信阅读人姓名
     *
     * @param msgWxReadName 消息微信阅读人姓名
     */
    public void setMsgWxReadName(String msgWxReadName){
        this.msgWxReadName = msgWxReadName;
    }

    /**
     * 获取消息微信阅读人电话
     *
     * @return MsgWxReadTel - 消息微信阅读人电话
     */
    public String getMsgWxReadTel(){
        return msgWxReadTel;
    }

    /**
     * 设置消息微信阅读人电话
     *
     * @param msgWxReadTel 消息微信阅读人电话
     */
    public void setMsgWxReadTel(String msgWxReadTel){
        this.msgWxReadTel = msgWxReadTel;
    }

    /**
     * 获取消息连联端阅读状态 1 已读 0 未读
     *
     * @return MsgLlReadState - 消息连联端阅读状态 1 已读 0 未读
     */
    public String getMsgLlReadState(){
        return msgLlReadState;
    }

    /**
     * 设置消息连联端阅读状态 1 已读 0 未读
     *
     * @param msgLlReadState 消息连联端阅读状态 1 已读 0 未读
     */
    public void setMsgLlReadState(String msgLlReadState){
        this.msgLlReadState = msgLlReadState;
    }

    /**
     * 获取消息连联端阅读时间
     *
     * @return MsgLlReadTime - 消息连联端阅读时间
     */
    public Date getMsgLlReadTime(){
        return msgLlReadTime;
    }

    /**
     * 设置消息连联端阅读时间
     *
     * @param msgLlReadTime 消息连联端阅读时间
     */
    public void setMsgLlReadTime(Date msgLlReadTime){
        this.msgLlReadTime = msgLlReadTime;
    }

    /**
     * 获取消息连联阅读人id
     *
     * @return MsgLlReadId - 消息连联阅读人id
     */
    public String getMsgLlReadId(){
        return msgLlReadId;
    }

    /**
     * 设置消息连联阅读人id
     *
     * @param msgLlReadId 消息连联阅读人id
     */
    public void setMsgLlReadId(String msgLlReadId){
        this.msgLlReadId = msgLlReadId;
    }

    /**
     * 获取消息连联阅读人姓名
     *
     * @return MsgLlReadName - 消息连联阅读人姓名
     */
    public String getMsgLlReadName(){
        return msgLlReadName;
    }

    /**
     * 设置消息连联阅读人姓名
     *
     * @param msgLlReadName 消息连联阅读人姓名
     */
    public void setMsgLlReadName(String msgLlReadName){
        this.msgLlReadName = msgLlReadName;
    }

    /**
     * 获取消息连联阅读人电话
     *
     * @return MsgLlReadTel - 消息连联阅读人电话
     */
    public String getMsgLlReadTel(){
        return msgLlReadTel;
    }

    /**
     * 设置消息连联阅读人电话
     *
     * @param msgLlReadTel 消息连联阅读人电话
     */
    public void setMsgLlReadTel(String msgLlReadTel){
        this.msgLlReadTel = msgLlReadTel;
    }

    /**
     * 获取发送时间
     *
     * @return SendTime - 发送时间
     */
    public Date getSendTime(){
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime){
        this.sendTime = sendTime;
    }

    /**
     * 获取发送人id
     *
     * @return SendId - 发送人id
     */
    public String getSendId(){
        return sendId;
    }

    /**
     * 设置发送人id
     *
     * @param sendId 发送人id
     */
    public void setSendId(String sendId){
        this.sendId = sendId;
    }

    /**
     * 获取发送人姓名
     *
     * @return SendName - 发送人姓名
     */
    public String getSendName(){
        return sendName;
    }

    /**
     * 设置发送人姓名
     *
     * @param sendName 发送人姓名
     */
    public void setSendName(String sendName){
        this.sendName = sendName;
    }

    /**
     * 获取发送部门id
     *
     * @return SendDeptId - 发送部门id
     */
    public String getSendDeptId(){
        return sendDeptId;
    }

    /**
     * 设置发送部门id
     *
     * @param sendDeptId 发送部门id
     */
    public void setSendDeptId(String sendDeptId){
        this.sendDeptId = sendDeptId;
    }

    /**
     * 获取发送部门名称
     *
     * @return SendDeptName - 发送部门名称
     */
    public String getSendDeptName(){
        return sendDeptName;
    }

    /**
     * 设置发送部门名称
     *
     * @param sendDeptName 发送部门名称
     */
    public void setSendDeptName(String sendDeptName){
        this.sendDeptName = sendDeptName;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * @return UpdateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    
    public String getMsgAbstract(){
        return msgAbstract;
    }

    
    public void setMsgAbstract(String msgAbstract){
        this.msgAbstract = msgAbstract;
    }

    
    public String getMsgType(){
        return msgType;
    }

    
    public void setMsgType(String msgType){
        this.msgType = msgType;
    }
}