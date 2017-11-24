/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_rpt_qcdz_map 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年10月31日
 */
@Table(name = "cs_rpt_qcdz_map")
public class RptQcdzMap implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 登记机关编码
     */
    @Column(name = "regorg")
    private String regorg;

    /**
     * 当前时刻数据
     */
    @Column(name = "xsNum")
    private Long xsNum;

    @Column(name = "update_time")
    private Date update_time;

    /**
     * 前一次更新数据
     */
    @Column(name = "zxNum")
    private Long zxNum;

    @Column(name = "addNum")
    private Long addNum;

    /**
     * 登记机关对应地图上的区域名称
     */
    @Column(name = "content")
    private String content;

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
     * 获取登记机关编码
     *
     * @return regorg - 登记机关编码
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * 设置登记机关编码
     *
     * @param regorg 登记机关编码
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * 获取当前时刻数据
     *
     * @return xsNum - 当前时刻数据
     */
    public Long getXsNum() {
        return xsNum;
    }

    /**
     * 设置当前时刻数据
     *
     * @param xsNum 当前时刻数据
     */
    public void setXsNum(Long xsNum) {
        this.xsNum = xsNum;
    }

    /**
     * @return update_time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param update_time
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * 获取前一次更新数据
     *
     * @return zxNum - 前一次更新数据
     */
    public Long getZxNum() {
        return zxNum;
    }

    /**
     * 设置前一次更新数据
     *
     * @param zxNum 前一次更新数据
     */
    public void setZxNum(Long zxNum) {
        this.zxNum = zxNum;
    }

    /**
     * @return addNum
     */
    public Long getAddNum() {
        return addNum;
    }

    /**
     * @param addNum
     */
    public void setAddNum(Long addNum) {
        this.addNum = addNum;
    }

    /**
     * 获取登记机关对应地图上的区域名称
     *
     * @return content - 登记机关对应地图上的区域名称
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置登记机关对应地图上的区域名称
     *
     * @param content 登记机关对应地图上的区域名称
     */
    public void setContent(String content) {
        this.content = content;
    }
}