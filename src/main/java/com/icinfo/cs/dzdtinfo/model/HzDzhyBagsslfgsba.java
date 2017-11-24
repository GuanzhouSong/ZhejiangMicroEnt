/**
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.dzdtinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述: CS_HZ_DZHY_BAGSSLFGSBA 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月14日
 */
@Table(name = "CS_HZ_DZHY_BAGSSLFGSBA")
public class HzDzhyBagsslfgsba implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 主键
	 */
	@Column(name = "PRIPID")
	private String priPid;

	/**
	 * 总公司保安服务许可证发证机关
	 */
	@Column(name = "XKFZJG")
	private String xkfzjg;

	/**
	 * 编号
	 */
	@Column(name = "XKFZJGNO")
	private String xkfzjgNo;

	/**
	 * 负责人姓名
	 */
	@Column(name = "FZRNAME")
	private String fzrName;
	
	//币种
	@Column(name = "CURRENCY")
	private String currency;

	/**
	 * 毕业院校
	 */
	@Column(name = "FZREDU")
	private String fzredu;

	/**
	 * 学历
	 */
	@Column(name = "FZRXL")
	private String fzrxl;

	/**
	 * 工作简历
	 */
	@Column(name = "FZRJL")
	private String fzrjl;

	/**
	 * 总公司法定代表人姓名
	 */
	@Column(name = "FDDBRNAME")
	private String fddbrName;
	
	@Column(name = "FDDBREDU")
	private String fddbrEdu;
	
	@Column(name = "FDDBRXL")
	private String fddbrXl;
	
	@Column(name = "FDDBRJL")
	private String fddbrJl;
	
	
	/**
	 * 拟开展的保安服务项目
	 */
	@Column(name = "BAFWXM")
	private String bafwxm;
	/**
	 * 保卫工作联系人
	 */
	@Column(name = "BWNAME")
	private String bwName;
	/**
	 * 保卫工作联系人电话
	 */
	@Column(name = "BAMOBTEL")
	private String baMobtel;
	/**
	 * 总公司注册资本
	 */
	@Column(name = "REGCAP")
	private BigDecimal regcap;
	/**
	 * 营业执照发证机关
	 */
	@Column(name = "ZZFZJG")
	private String zzfzjg;
	/**
	 * 总公司地址
	 */
	@Column(name = "DOM")
	private String dom;
	/**
	 * 营业场所面积
	 */
	@Column(name = "JYMJ")
	private BigDecimal jymj;
	/**
	 * 总经理姓名
	 */
	@Column(name = "ZJLNAME")
	private String zjlName;
	/**
	 * 总经理身份证号码
	 */
	@Column(name = "ZJLCERNO")
	private String zjlcerNo;
	/**
	 * 总经理毕业院校
	 */
	@Column(name = "ZJLEDU")
	private String zjledu;
	/**
	 * 总经理学历
	 */
	@Column(name = "ZJLXL")
	private String zjlxl;
	/**
	 * 副总经理姓名
	 */
	@Column(name = "FZJLNAME")
	private String fzjlName;
	/**
	 * 副总经理身份证号码
	 */
	@Column(name = "FZJLCERNO")
	private String fzjlcerNo;
	/**
	 * 副总经理毕业院校
	 */
	@Column(name = "FZJLEDU")
	private String fzjledu;
	
	@Column(name = "FDDBRCERNO")
	private String fddbrCerno;
	
	
	/**
	 * 副总经理学历
	 */
	@Column(name = "FZJLXL")
	private String fzjlxl;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id
	 *            主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the priPid
	 */
	public String getPriPid() {
		return priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param priPid
	 *            the priPid to set
	 */
	public void setPriPid(String priPid) {
		this.priPid = priPid;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the xkfzjg
	 */
	public String getXkfzjg() {
		return xkfzjg;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param xkfzjg
	 *            the xkfzjg to set
	 */
	public void setXkfzjg(String xkfzjg) {
		this.xkfzjg = xkfzjg;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the xkfzjgno
	 */
	public String getXkfzjgNo() {
		return xkfzjgNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param xkfzjgno
	 *            the xkfzjgno to set
	 */
	public void setXkfzjgNo(String xkfzjgNo) {
		this.xkfzjgNo = xkfzjgNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the fzrName
	 */
	public String getFzrName() {
		return fzrName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param fzrName
	 *            the fzrName to set
	 */
	public void setFzrName(String fzrName) {
		this.fzrName = fzrName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the fzredu
	 */
	public String getFzredu() {
		return fzredu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param fzredu
	 *            the fzredu to set
	 */
	public void setFzredu(String fzredu) {
		this.fzredu = fzredu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the fzrxl
	 */
	public String getFzrxl() {
		return fzrxl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param fzrxl
	 *            the fzrxl to set
	 */
	public void setFzrxl(String fzrxl) {
		this.fzrxl = fzrxl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the fzrjl
	 */
	public String getFzrjl() {
		return fzrjl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param fzrjl
	 *            the fzrjl to set
	 */
	public void setFzrjl(String fzrjl) {
		this.fzrjl = fzrjl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the fddbrName
	 */
	public String getFddbrName() {
		return fddbrName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param fddbrName
	 *            the fddbrName to set
	 */
	public void setFddbrName(String fddbrName) {
		this.fddbrName = fddbrName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the bafwxm
	 */
	public String getBafwxm() {
		return bafwxm;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param bafwxm
	 *            the bafwxm to set
	 */
	public void setBafwxm(String bafwxm) {
		this.bafwxm = bafwxm;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the bwName
	 */
	public String getBwName() {
		return bwName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param bwName
	 *            the bwName to set
	 */
	public void setBwName(String bwName) {
		this.bwName = bwName;
	}

	public String getBaMobtel() {
		return baMobtel;
	}

	public void setBaMobtel(String baMobtel) {
		this.baMobtel = baMobtel;
	}

	public String getFzjlcerNo() {
		return fzjlcerNo;
	}

	public void setFzjlcerNo(String fzjlcerNo) {
		this.fzjlcerNo = fzjlcerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the regcap
	 */
	public BigDecimal getRegcap() {
		return regcap;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param regcap
	 *            the regcap to set
	 */
	public void setRegcap(BigDecimal regcap) {
		this.regcap = regcap;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the zzfzjg
	 */
	public String getZzfzjg() {
		return zzfzjg;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @param zzfzjg
	 *            the zzfzjg to set
	 */
	public void setZzfzjg(String zzfzjg) {
		this.zzfzjg = zzfzjg;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:30
	 * @return the dom
	 */
	public String getDom() {
		return dom;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param dom
	 *            the dom to set
	 */
	public void setDom(String dom) {
		this.dom = dom;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the jymj
	 */
	public BigDecimal getJymj() {
		return jymj;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param jymj
	 *            the jymj to set
	 */
	public void setJymj(BigDecimal jymj) {
		this.jymj = jymj;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the zjlName
	 */
	public String getZjlName() {
		return zjlName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param zjlName
	 *            the zjlName to set
	 */
	public void setZjlName(String zjlName) {
		this.zjlName = zjlName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the zjlcerno
	 */
	public String getZjlcerNo() {
		return zjlcerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param zjlcerno
	 *            the zjlcerno to set
	 */
	public void setZjlcerNo(String zjlcerNo) {
		this.zjlcerNo = zjlcerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the zjledu
	 */
	public String getZjledu() {
		return zjledu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param zjledu
	 *            the zjledu to set
	 */
	public void setZjledu(String zjledu) {
		this.zjledu = zjledu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the zjlxl
	 */
	public String getZjlxl() {
		return zjlxl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param zjlxl
	 *            the zjlxl to set
	 */
	public void setZjlxl(String zjlxl) {
		this.zjlxl = zjlxl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the fzjlName
	 */
	public String getFzjlName() {
		return fzjlName;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param fzjlcerno
	 *            the fzjlcerno to set
	 */
	public void setFzjlcerno(String fzjlcerNo) {
		this.fzjlcerNo = fzjlcerNo;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the fzjledu
	 */
	public String getFzjledu() {
		return fzjledu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param fzjledu
	 *            the fzjledu to set
	 */
	public void setFzjledu(String fzjledu) {
		this.fzjledu = fzjledu;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @return the fzjlxl
	 */
	public String getFzjlxl() {
		return fzjlxl;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月15日上午9:44:31
	 * @param fzjlxl
	 *            the fzjlxl to set
	 */
	public void setFzjlxl(String fzjlxl) {
		this.fzjlxl = fzjlxl;
	}

	public String getFddbrEdu() {
		return fddbrEdu;
	}

	public void setFddbrEdu(String fddbrEdu) {
		this.fddbrEdu = fddbrEdu;
	}

	public String getFddbrXl() {
		return fddbrXl;
	}

	public void setFddbrXl(String fddbrXl) {
		this.fddbrXl = fddbrXl;
	}

	public String getFddbrJl() {
		return fddbrJl;
	}

	public void setFddbrJl(String fddbrJl) {
		this.fddbrJl = fddbrJl;
	}

	public void setFzjlName(String fzjlName) {
		this.fzjlName = fzjlName;
	}

	public String getFddbrCerno() {
		return fddbrCerno;
	}

	public void setFddbrCerno(String fddbrCerno) {
		this.fddbrCerno = fddbrCerno;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}