/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.message.dto;

import com.icinfo.cs.message.model.CsMessageRel;

/**
 * 描述:    cs_message_rel 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public class CsMessageRelDto extends CsMessageRel {

    private String msgTitle;
    private String regNO;
    private String uniCode;
    private String entName;
    private String leRep;
    private String sendTime;
    private String sendName;
    private String msgPcReadState;
    private String msgPcReadTime;
    private String regOrgName;
    private String localAdmName;
    private String sliceNOName;
    private String regState;
    private String priPID;
    private String msgRemark;
    private Long   msgNum;
    private Long   msgReadNum;
    private Long   msgUnReadNum;
    private Long   entNum;

    public String getMsgTitle(){
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle){
        this.msgTitle = msgTitle;
    }

    public String getRegNO(){
        return regNO;
    }

    public void setRegNO(String regNO){
        this.regNO = regNO;
    }

    public String getUniCode(){
        return uniCode;
    }

    public void setUniCode(String uniCode){
        this.uniCode = uniCode;
    }

    public String getEntName(){
        return entName;
    }

    public void setEntName(String entName){
        this.entName = entName;
    }

    public String getLeRep(){
        return leRep;
    }

    public void setLeRep(String leRep){
        this.leRep = leRep;
    }

    public String getSendTime(){
        return sendTime;
    }

    public void setSendTime(String sendTime){
        this.sendTime = sendTime;
    }

    public String getSendName(){
        return sendName;
    }

    public void setSendName(String sendName){
        this.sendName = sendName;
    }

    public String getMsgPcReadState(){
        return msgPcReadState;
    }

    public void setMsgPcReadState(String msgPcReadState){
        this.msgPcReadState = msgPcReadState;
    }

    public String getMsgPcReadTime(){
        return msgPcReadTime;
    }

    public void setMsgPcReadTime(String msgPcReadTime){
        this.msgPcReadTime = msgPcReadTime;
    }

    public String getRegOrgName(){
        return regOrgName;
    }

    public void setRegOrgName(String regOrgName){
        this.regOrgName = regOrgName;
    }

    public String getLocalAdmName(){
        return localAdmName;
    }

    public void setLocalAdmName(String localAdmName){
        this.localAdmName = localAdmName;
    }

    public String getSliceNOName(){
        return sliceNOName;
    }

    public void setSliceNOName(String sliceNOName){
        this.sliceNOName = sliceNOName;
    }

    public String getRegState(){
        return regState;
    }

    public void setRegState(String regState){
        this.regState = regState;
    }

    public String getPriPID(){
        return priPID;
    }

    public void setPriPID(String priPID){
        this.priPID = priPID;
    }

    public Long getMsgNum(){
        return msgNum;
    }

    public void setMsgNum(Long msgNum){
        this.msgNum = msgNum;
    }

    public Long getMsgReadNum(){
        return msgReadNum;
    }

    public void setMsgReadNum(Long msgReadNum){
        this.msgReadNum = msgReadNum;
    }

    public Long getMsgUnReadNum(){
        return msgUnReadNum;
    }

    public void setMsgUnReadNum(Long msgUnReadNum){
        this.msgUnReadNum = msgUnReadNum;
    }

    public Long getEntNum(){
        return entNum;
    }

    public void setEntNum(Long entNum){
        this.entNum = entNum;
    }

    
    public String getMsgRemark(){
        return msgRemark;
    }

    
    public void setMsgRemark(String msgRemark){
        this.msgRemark = msgRemark;
    }

}