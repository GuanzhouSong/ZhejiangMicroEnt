/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.system.model.BulletinsReadRecord;

import javax.persistence.Column;
import java.util.Date;


/**
 * 描述:    cs_bulletins_read_record 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
public class BulletinsReadRecordDto extends BulletinsReadRecord {

    @Column(name = "Title")
    private String title;


    //发布范围(1- 全市  2-本局)
    @Column(name = "BulScope")
    private String bulScope;

    @Column(name = "Source")
    private String source;

    @Column(name = "SetDeptCode")
    private String setDeptCode;

    @Column(name = "SetDeptname")
    private String setDeptname;


    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    @Column(name = "SetName")
    private String setName;

    @Column(name = "contents")
    private String contents;

    public String getBulScope() {
        return bulScope;
    }

    public void setBulScope(String bulScope) {
        this.bulScope = bulScope;
    }

    public String getSetDeptCode() {
        return setDeptCode;
    }

    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSetDeptname() {
        return setDeptname;
    }

    public void setSetDeptname(String setDeptname) {
        this.setDeptname = setDeptname;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}