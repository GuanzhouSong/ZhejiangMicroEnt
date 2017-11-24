/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.depsyn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:    cs_depsyn_notice 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月12日
 */
@Table(name = "cs_depsyn_notice")
public class CsDepsynNotice implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 标题
     */
    @Column(name = "Title")
    private String title;

    /**
     * 内容
     */
    @Column(name = "Content")
    private String content;

    /**
     * 附件存储路径
     */
    @Column(name = "StoreAddr")
    private String storeAddr;

    /**
     * 发布部门
     */
    @Column(name = "Department")
    private String department;

    /**
     * 发布机关
     */
    @Column(name = "RelAuth")
    private String relAuth;

    /**
     * 发布时间
     */
    @Column(name = "RelDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date relDate;

    /**
     * 所在省份
     */
    @Column(name = "RelPro")
    private String relPro;

    /**
     * 录入人员编号
     */
    @Column(name = "InputPerID")
    private String inputPerID;

    /**
     * 录入人部门编码
     */
    @Column(name = "InputDepCode")
    private String inputDepCode;

    /**
     * 录入时间
     */
    @Column(name = "InputDate")
    private Date inputDate;

    /**
     * 年份
     */
    @Column(name = "Year")
    private String year;

    /**
     * 行政编码
     */
    @Column(name = "Adcode")
    private String adcode;

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
     * 获取uuid
     *
     * @return uid - uuid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uuid
     *
     * @param uid uuid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取标题
     *
     * @return Title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     *
     * @return Content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取附件存储路径
     *
     * @return StoreAddr - 附件存储路径
     */
    public String getStoreAddr() {
        return storeAddr;
    }

    /**
     * 设置附件存储路径
     *
     * @param storeAddr 附件存储路径
     */
    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    /**
     * 获取发布部门
     *
     * @return Department - 发布部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置发布部门
     *
     * @param department 发布部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取发布机关
     *
     * @return RelAuth - 发布机关
     */
    public String getRelAuth() {
        return relAuth;
    }

    /**
     * 设置发布机关
     *
     * @param relAuth 发布机关
     */
    public void setRelAuth(String relAuth) {
        this.relAuth = relAuth;
    }

    /**
     * 获取发布时间
     *
     * @return RelDate - 发布时间
     */
    public Date getRelDate() {
        return relDate;
    }

    /**
     * 设置发布时间
     *
     * @param relDate 发布时间
     */
    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    /**
     * 获取所在省份
     *
     * @return RelPro - 所在省份
     */
    public String getRelPro() {
        return relPro;
    }

    /**
     * 设置所在省份
     *
     * @param relPro 所在省份
     */
    public void setRelPro(String relPro) {
        this.relPro = relPro;
    }

    /**
     * 获取录入人员编号
     *
     * @return InputPerID - 录入人员编号
     */
    public String getInputPerID() {
        return inputPerID;
    }

    /**
     * 设置录入人员编号
     *
     * @param inputPerID 录入人员编号
     */
    public void setInputPerID(String inputPerID) {
        this.inputPerID = inputPerID;
    }

    /**
     * 获取录入人部门编码
     *
     * @return InputDepCode - 录入人部门编码
     */
    public String getInputDepCode() {
        return inputDepCode;
    }

    /**
     * 设置录入人部门编码
     *
     * @param inputDepCode 录入人部门编码
     */
    public void setInputDepCode(String inputDepCode) {
        this.inputDepCode = inputDepCode;
    }

    /**
     * 获取录入时间
     *
     * @return InputDate - 录入时间
     */
    public Date getInputDate() {
        return inputDate;
    }

    /**
     * 设置录入时间
     *
     * @param inputDate 录入时间
     */
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取行政编码
     *
     * @return Adcode - 行政编码
     */
    public String getAdcode() {
        return adcode;
    }

    /**
     * 设置行政编码
     *
     * @param adcode 行政编码
     */
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }
}