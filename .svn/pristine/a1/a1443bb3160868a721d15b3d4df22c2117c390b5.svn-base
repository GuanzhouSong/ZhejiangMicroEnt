package com.icinfo.cs.depsyn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_depsyn_search_key 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月10日
 */

@Table(name = "cs_depsyn_search_key")
public class DepSynSearchKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7879221641819942426L;
	
	@Column(name = "id")
	private Integer id;

	/**
	 * UUID
	 */
	@Column(name = "UID")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

	// 搜索条件组合
	@Column(name = "Params")
	private String params;

	// 用户id
	@Column(name = "UserId")
	private String userId;

	// 更新时间
	@Column(name = "UpdateTime")
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
