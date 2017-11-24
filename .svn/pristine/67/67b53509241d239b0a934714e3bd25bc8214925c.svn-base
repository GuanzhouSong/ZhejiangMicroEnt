/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  cs_code_street 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月28日
 */
@Table(name = "cs_code_street")
public class CodeStreet implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    /**
     * 编码
     */
    @Column(name = "Code")
    private String code;

    /**
     * 内容
     */
    @Column(name = "Content")
    private String content;

    /**
     * 上级编码
     */
    @Column(name = "SupCode")
    private String supCode;

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
     * 获取编码
     *
     * @return Code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取上级编码
     *
     * @return SupCode - 上级编码
     */
    public String getSupCode() {
        return supCode;
    }

    /**
     * 设置上级编码
     *
     * @param supCode 上级编码
     */
    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }
}