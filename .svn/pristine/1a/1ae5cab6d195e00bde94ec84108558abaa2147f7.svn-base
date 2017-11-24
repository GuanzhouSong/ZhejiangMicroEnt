/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.message.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_message_rel 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月18日
 */
@Table(name = "cs_message_rel")
public class CsMessageRel implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    /**
     * 消息uuid
     */
    @Column(name = "MsgUid")
    private String msgUid;

    /**
     * 企业id
     */
    @Column(name = "PriPID")
    private String priPID;
    
    //企业名称
    @Column(name = "EntName")
    private String entName;

    /**
     * 联络员id
     */
    @Column(name = "LiaisonManId")
    private String liaisonManId;

    /**
     * 联络员姓名
     */
    @Column(name = "LiaisonManName")
    private String liaisonManName;

    /**
     * 联络员电话
     */
    @Column(name = "LiaisonManTel")
    private String liaisonManTel;

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
     * 获取消息uuid
     *
     * @return MsgUid - 消息uuid
     */
    public String getMsgUid() {
        return msgUid;
    }

    /**
     * 设置消息uuid
     *
     * @param msgUid 消息uuid
     */
    public void setMsgUid(String msgUid) {
        this.msgUid = msgUid;
    }

    /**
     * 获取企业id
     *
     * @return PriPID - 企业id
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置企业id
     *
     * @param priPID 企业id
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取联络员id
     *
     * @return LiaisonManId - 联络员id
     */
    public String getLiaisonManId() {
        return liaisonManId;
    }

    /**
     * 设置联络员id
     *
     * @param liaisonManId 联络员id
     */
    public void setLiaisonManId(String liaisonManId) {
        this.liaisonManId = liaisonManId;
    }

    /**
     * 获取联络员姓名
     *
     * @return LiaisonManName - 联络员姓名
     */
    public String getLiaisonManName() {
        return liaisonManName;
    }

    /**
     * 设置联络员姓名
     *
     * @param liaisonManName 联络员姓名
     */
    public void setLiaisonManName(String liaisonManName) {
        this.liaisonManName = liaisonManName;
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

    
    public String getEntName(){
        return entName;
    }

    
    public void setEntName(String entName){
        this.entName = entName;
    }
}