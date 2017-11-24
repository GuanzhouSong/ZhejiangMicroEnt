/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.inspect.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  cs_report_check_code 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年01月18日
 */
@Table(name = "cs_report_check_code")
public class ReportCheckCode implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Content")
    private String content;

    /**
     * 一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    @Column(name = "Type")
    private String type;

    @Column(name = "NoPrivate1")
    private String noPrivate1;

    @Column(name = "NoPrivate2")
    private String noPrivate2;

    @Column(name = "NoPrivate3")
    private String noPrivate3;

    @Column(name = "Private1")
    private String private1;

    @Column(name = "Private2")
    private String private2;

    @Column(name = "Private3")
    private String private3;

    @Column(name = "Sfc")
    private String sfc;
    @Column(name = "Is2016")
    private String is2016;
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
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     *
     * @return Type - 一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    public String getType() {
        return type;
    }

    /**
     * 设置一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     *
     * @param type 一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return NoPrivate1
     */
    public String getNoPrivate1() {
        return noPrivate1;
    }

    /**
     * @param noPrivate1
     */
    public void setNoPrivate1(String noPrivate1) {
        this.noPrivate1 = noPrivate1;
    }

    /**
     * @return NoPrivate2
     */
    public String getNoPrivate2() {
        return noPrivate2;
    }

    /**
     * @param noPrivate2
     */
    public void setNoPrivate2(String noPrivate2) {
        this.noPrivate2 = noPrivate2;
    }

    /**
     * @return NoPrivate3
     */
    public String getNoPrivate3() {
        return noPrivate3;
    }

    /**
     * @param noPrivate3
     */
    public void setNoPrivate3(String noPrivate3) {
        this.noPrivate3 = noPrivate3;
    }

    /**
     * @return Private1
     */
    public String getPrivate1() {
        return private1;
    }

    /**
     * @param private1
     */
    public void setPrivate1(String private1) {
        this.private1 = private1;
    }

    /**
     * @return Private2
     */
    public String getPrivate2() {
        return private2;
    }

    /**
     * @param private2
     */
    public void setPrivate2(String private2) {
        this.private2 = private2;
    }

    /**
     * @return Private3
     */
    public String getPrivate3() {
        return private3;
    }

    /**
     * @param private3
     */
    public void setPrivate3(String private3) {
        this.private3 = private3;
    }

    /**
     * @return Sfc
     */
    public String getSfc() {
        return sfc;
    }

    /**
     * @param sfc
     */
    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getIs2016() {
        return is2016;
    }

    public void setIs2016(String is2016) {
        this.is2016 = is2016;
    }
}