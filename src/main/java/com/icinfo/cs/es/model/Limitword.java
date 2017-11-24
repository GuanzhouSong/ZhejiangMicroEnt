/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述: cs_pub_limitword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年11月04日
 */
@Table(name = "cs_pub_limitword")
public class Limitword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 803519366794687743L;

	/**
	 * 自增ID
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 限制搜索词
	 */
	@Column(name = "Limitword")
	private String limitword;

	/**
	 * 1.行政区划2.公司性质
	 */
	@Column(name = "LimitFlag")
	private String limitFlag;

	/**
	 * 获取自增ID
	 *
	 * @return id - 自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增ID
	 *
	 * @param id
	 *            自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取限制搜索词
	 *
	 * @return Limitword - 限制搜索词
	 */
	public String getLimitword() {
		return limitword;
	}

	/**
	 * 设置限制搜索词
	 *
	 * @param limitword
	 *            限制搜索词
	 */
	public void setLimitword(String limitword) {
		this.limitword = limitword;
	}

	/**
	 * 获取1.行政区划2.公司性质
	 *
	 * @return LimitFlag - 1.行政区划2.公司性质
	 */
	public String getLimitFlag() {
		return limitFlag;
	}

	/**
	 * 设置1.行政区划2.公司性质
	 *
	 * @param limitFlag
	 *            1.行政区划2.公司性质
	 */
	public void setLimitFlag(String limitFlag) {
		this.limitFlag = limitFlag;
	}
}