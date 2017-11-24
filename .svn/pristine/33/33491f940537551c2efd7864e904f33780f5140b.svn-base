/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_quartz_job 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月20日
 */
@Table(name = "cs_quartz_job")
public class CsQuartzJob implements Serializable {
    
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 任务名称
     */
    @Column(name = "JobName")
    private String jobName;

    /**
     * 任务日期
     */
    @Column(name = "JobDay")
    private String jobDay;

    
    /**
     * 执行任务服务器ip
     */
    @Column(name = "JobServerIp")
    private String jobServerIp;


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
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取任务名称
     *
     * @return JobName - 任务名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置任务名称
     *
     * @param jobName 任务名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取任务日期
     *
     * @return JobDay - 任务日期
     */
    public String getJobDay() {
        return jobDay;
    }

    /**
     * 设置任务日期
     *
     * @param jobDay 任务日期
     */
    public void setJobDay(String jobDay) {
        this.jobDay = jobDay;
    }

	public String getJobServerIp() {
		return jobServerIp;
	}

	public void setJobServerIp(String jobServerIp) {
		this.jobServerIp = jobServerIp;
	}
    

}