/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    rpt_sm_ent_info_all 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月09日
 */
@Table(name = "rpt_sm_ent_info_all")
public class RptSmEntInfoAll implements Serializable {
    /**
     * 登记机关
     */
    @Column(name = "regorg")
    private String regorg;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;


    /**
     * 企业细分类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 行业门类
     */
    @Column(name = "IndustryPhy")
    private String industryPhy;


    /**
     * 第一产业个数
     */
    @Column(name = "ThrIndustry1")
    private BigDecimal thrIndustry1;
    /**
     * 第二产业个数
     */
    @Column(name = "ThrIndustry2")
    private BigDecimal thrIndustry2;
    /**
     * 第三产业个数
     */
    @Column(name = "ThrIndustry3")
    private BigDecimal thrIndustry3;
    /**
     * 八大产业（1）
     */
    @Column(name = "EigIndustry1")
    private BigDecimal eigIndustry1;
    /**
     * 八大产业（2）
     */
    @Column(name = "EigIndustry2")
    private BigDecimal eigIndustry2;
    /**
     * 八大产业（3）
     */
    @Column(name = "EigIndustry3")
    private BigDecimal eigIndustry3;
    /**
     * 八大产业（4）
     */
    @Column(name = "EigIndustry4")
    private BigDecimal eigIndustry4;
    /**
     * 八大产业（5）
     */
    @Column(name = "EigIndustry5")
    private BigDecimal eigIndustry5;
    /**
     * 八大产业（6）
     */
    @Column(name = "EigIndustry6")
    private BigDecimal eigIndustry6;
    /**
     * 八大产业（7）
     */
    @Column(name = "EigIndustry7")
    private BigDecimal eigIndustry7;
    /**
     * 八大产业（8）
     */
    @Column(name = "EigIndustry8")
    private BigDecimal eigIndustry8;

    /**
     * 注册资本0-10
     */
    @Column(name = "RegCap10")
    private BigDecimal regCap10;
    /**
     * 注册资本10-50
     */
    @Column(name = "RegCap50")
    private BigDecimal regCap50;

    /**
     * 注册资本50-100
     */
    @Column(name = "RegCap100")
    private BigDecimal regCap100;

    /**
     * 注册资本100-500
     */
    @Column(name = "RegCap500")
    private BigDecimal regCap500;

    /**
     * 注册资本500以上
     */
    @Column(name = "RegCapO500")
    private BigDecimal regCapO500;

    /**
     * 从业人数0-5
     */
    @Column(name = "empnum5")
    private BigDecimal empnum5;

    /**
     * 从业人数5-10
     */
    @Column(name = "empnum10")
    private BigDecimal empnum10;

    /**
     * 从业人数10-20
     */
    @Column(name = "empnum20")
    private BigDecimal empnum20;

    /**
     * 从业人数20-50
     */
    @Column(name = "empnum50")
    private BigDecimal empnum50;

    /**
     * 从业人数50-100
     */
    @Column(name = "empnum100")
    private BigDecimal empnum100;

    /**
     * 从业人数50-100
     */
    @Column(name = "empnum200")
    private BigDecimal empnum200;

    /**
     * 从业人数200-300
     */
    @Column(name = "empnum300")
    private BigDecimal empnum300;

    /**
     * 从业人数300-500
     */
    @Column(name = "empnum500")
    private BigDecimal empnum500;

    /**
     * 从业人数500以上
     */
    @Column(name = "empnumO500")
    private BigDecimal empnumO500;

    /**
     * 在册
     */
    @Column(name = "newEnt")
    private BigDecimal newEnt;

    /**
     * 新设
     */
    @Column(name = "canEnt")
    private BigDecimal canEnt;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    private Date estDate;

    /**
     * 核准日期
     */
    @Column(name = "ApprDate")
    private Date apprDate;

    @Column(name = "EntNum")
    private Long entNum;

    /**
     * 新设小微企业法人平均年龄
     */
    @Column(name = "avgAge")
    private Double avgAge;

    /**
     * 新设小微企业法人80后
     */
    @Column(name = "cer80")
    private BigDecimal cer80;

    /**
     * 新设小微企业法人90后
     */
    @Column(name = "cer90")
    private BigDecimal cer90;

    /**
     * 新设小微企业法人为省内
     */
    @Column(name = "cer33")
    private BigDecimal cer33;

    /**
     * 新设企业注册基本总额
     */
    @Column(name = "RegCapAll")
    private BigDecimal regCapAll;

    /**
     * 新设企业注册基本平均数
     */
    @Column(name = "RegCapAvg")
    private BigDecimal regCapAvg;

    /**
     * 新设企业股东全为自然人
     */
    @Column(name = "InvLeg")
    private BigDecimal invLeg;

    private static final long serialVersionUID = 1L;

    /**
     * 获取登记机关
     *
     * @return regorg - 登记机关
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * 设置登记机关
     *
     * @param regorg 登记机关
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdm 管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取企业细分类型
     *
     * @return EntType - 企业细分类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业细分类型
     *
     * @param entType 企业细分类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取行业门类
     *
     * @return IndustryPhy - 行业门类
     */
    public String getIndustryPhy() {
        return industryPhy;
    }

    /**
     * 设置行业门类
     *
     * @param industryPhy 行业门类
     */
    public void setIndustryPhy(String industryPhy) {
        this.industryPhy = industryPhy;
    }


    /**
     * 获取注册资本0-10
     *
     * @return RegCap10 - 注册资本0-10
     */
    public BigDecimal getRegCap10() {
        return regCap10;
    }

    /**
     * 设置注册资本0-10
     *
     * @param regCap10 注册资本0-10
     */
    public void setRegCap10(BigDecimal regCap10) {
        this.regCap10 = regCap10;
    }

    /**
     * 获取注册资本10-50
     *
     * @return RegCap50 - 注册资本10-50
     */
    public BigDecimal getRegCap50() {
        return regCap50;
    }

    /**
     * 设置注册资本10-50
     *
     * @param regCap50 注册资本10-50
     */
    public void setRegCap50(BigDecimal regCap50) {
        this.regCap50 = regCap50;
    }

    /**
     * 获取注册资本50-100
     *
     * @return RegCap100 - 注册资本50-100
     */
    public BigDecimal getRegCap100() {
        return regCap100;
    }

    /**
     * 设置注册资本50-100
     *
     * @param regCap100 注册资本50-100
     */
    public void setRegCap100(BigDecimal regCap100) {
        this.regCap100 = regCap100;
    }

    /**
     * 获取注册资本100-500
     *
     * @return RegCap500 - 注册资本100-500
     */
    public BigDecimal getRegCap500() {
        return regCap500;
    }

    /**
     * 设置注册资本100-500
     *
     * @param regCap500 注册资本100-500
     */
    public void setRegCap500(BigDecimal regCap500) {
        this.regCap500 = regCap500;
    }

    /**
     * 获取注册资本500以上
     *
     * @return RegCapO500 - 注册资本500以上
     */
    public BigDecimal getRegCapO500() {
        return regCapO500;
    }

    /**
     * 设置注册资本500以上
     *
     * @param regCapO500 注册资本500以上
     */
    public void setRegCapO500(BigDecimal regCapO500) {
        this.regCapO500 = regCapO500;
    }

    /**
     * 获取从业人数0-5
     *
     * @return empnum5 - 从业人数0-5
     */
    public BigDecimal getEmpnum5() {
        return empnum5;
    }

    /**
     * 设置从业人数0-5
     *
     * @param empnum5 从业人数0-5
     */
    public void setEmpnum5(BigDecimal empnum5) {
        this.empnum5 = empnum5;
    }

    /**
     * 获取从业人数5-10
     *
     * @return empnum10 - 从业人数5-10
     */
    public BigDecimal getEmpnum10() {
        return empnum10;
    }

    /**
     * 设置从业人数5-10
     *
     * @param empnum10 从业人数5-10
     */
    public void setEmpnum10(BigDecimal empnum10) {
        this.empnum10 = empnum10;
    }

    /**
     * 获取从业人数10-20
     *
     * @return empnum20 - 从业人数10-20
     */
    public BigDecimal getEmpnum20() {
        return empnum20;
    }

    /**
     * 设置从业人数10-20
     *
     * @param empnum20 从业人数10-20
     */
    public void setEmpnum20(BigDecimal empnum20) {
        this.empnum20 = empnum20;
    }

    /**
     * 获取从业人数20-50
     *
     * @return empnum50 - 从业人数20-50
     */
    public BigDecimal getEmpnum50() {
        return empnum50;
    }

    /**
     * 设置从业人数20-50
     *
     * @param empnum50 从业人数20-50
     */
    public void setEmpnum50(BigDecimal empnum50) {
        this.empnum50 = empnum50;
    }

    /**
     * 获取从业人数50-100
     *
     * @return empnum100 - 从业人数50-100
     */
    public BigDecimal getEmpnum100() {
        return empnum100;
    }

    /**
     * 设置从业人数50-100
     *
     * @param empnum100 从业人数50-100
     */
    public void setEmpnum100(BigDecimal empnum100) {
        this.empnum100 = empnum100;
    }

    /**
     * 获取从业人数50-100
     *
     * @return empnum200 - 从业人数50-100
     */
    public BigDecimal getEmpnum200() {
        return empnum200;
    }

    /**
     * 设置从业人数50-100
     *
     * @param empnum200 从业人数50-100
     */
    public void setEmpnum200(BigDecimal empnum200) {
        this.empnum200 = empnum200;
    }

    /**
     * 获取从业人数200-300
     *
     * @return empnum300 - 从业人数200-300
     */
    public BigDecimal getEmpnum300() {
        return empnum300;
    }

    /**
     * 设置从业人数200-300
     *
     * @param empnum300 从业人数200-300
     */
    public void setEmpnum300(BigDecimal empnum300) {
        this.empnum300 = empnum300;
    }

    /**
     * 获取从业人数300-500
     *
     * @return empnum500 - 从业人数300-500
     */
    public BigDecimal getEmpnum500() {
        return empnum500;
    }

    /**
     * 设置从业人数300-500
     *
     * @param empnum500 从业人数300-500
     */
    public void setEmpnum500(BigDecimal empnum500) {
        this.empnum500 = empnum500;
    }

    /**
     * 获取从业人数500以上
     *
     * @return empnumO500 - 从业人数500以上
     */
    public BigDecimal getEmpnumO500() {
        return empnumO500;
    }

    /**
     * 设置从业人数500以上
     *
     * @param empnumO500 从业人数500以上
     */
    public void setEmpnumO500(BigDecimal empnumO500) {
        this.empnumO500 = empnumO500;
    }

    /**
     * 获取新设
     *
     * @return newEnt - 新设
     */
    public BigDecimal getNewEnt() {
        return newEnt;
    }

    /**
     * 设置新设
     *
     * @param newEnt 新设
     */
    public void setNewEnt(BigDecimal newEnt) {
        this.newEnt = newEnt;
    }

    /**
     * 获取注销
     *
     * @return canEnt - 注销
     */
    public BigDecimal getCanEnt() {
        return canEnt;
    }

    /**
     * 设置注销
     *
     * @param canEnt 注销
     */
    public void setCanEnt(BigDecimal canEnt) {
        this.canEnt = canEnt;
    }

    /**
     * 获取成立日期
     *
     * @return EstDate - 成立日期
     */
    public Date getEstDate() {
        return estDate;
    }

    /**
     * 设置成立日期
     *
     * @param estDate 成立日期
     */
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    /**
     * 获取核准日期
     *
     * @return ApprDate - 核准日期
     */
    public Date getApprDate() {
        return apprDate;
    }

    /**
     * 设置核准日期
     *
     * @param apprDate 核准日期
     */
    public void setApprDate(Date apprDate) {
        this.apprDate = apprDate;
    }

    /**
     * @return EntNum
     */
    public Long getEntNum() {
        return entNum;
    }

    /**
     * @param entNum
     */
    public void setEntNum(Long entNum) {
        this.entNum = entNum;
    }

    /**
     * 获取新设小微企业法人平均年龄
     *
     * @return avgAge - 新设小微企业法人平均年龄
     */
    public Double getAvgAge() {
        return avgAge;
    }

    /**
     * 设置新设小微企业法人平均年龄
     *
     * @param avgAge 新设小微企业法人平均年龄
     */
    public void setAvgAge(Double avgAge) {
        this.avgAge = avgAge;
    }

    /**
     * 获取新设小微企业法人80后
     *
     * @return cer80 - 新设小微企业法人80后
     */
    public BigDecimal getCer80() {
        return cer80;
    }

    /**
     * 设置新设小微企业法人80后
     *
     * @param cer80 新设小微企业法人80后
     */
    public void setCer80(BigDecimal cer80) {
        this.cer80 = cer80;
    }

    /**
     * 获取新设小微企业法人90后
     *
     * @return cer90 - 新设小微企业法人90后
     */
    public BigDecimal getCer90() {
        return cer90;
    }

    /**
     * 设置新设小微企业法人90后
     *
     * @param cer90 新设小微企业法人90后
     */
    public void setCer90(BigDecimal cer90) {
        this.cer90 = cer90;
    }

    /**
     * 获取新设小微企业法人为省内
     *
     * @return cer33 - 新设小微企业法人为省内
     */
    public BigDecimal getCer33() {
        return cer33;
    }

    /**
     * 设置新设小微企业法人为省内
     *
     * @param cer33 新设小微企业法人为省内
     */
    public void setCer33(BigDecimal cer33) {
        this.cer33 = cer33;
    }

    /**
     * 获取新设企业注册基本总额
     *
     * @return RegCapAll - 新设企业注册基本总额
     */
    public BigDecimal getRegCapAll() {
        return regCapAll;
    }

    /**
     * 设置新设企业注册基本总额
     *
     * @param regCapAll 新设企业注册基本总额
     */
    public void setRegCapAll(BigDecimal regCapAll) {
        this.regCapAll = regCapAll;
    }

    /**
     * 获取新设企业注册基本平均数
     *
     * @return RegCapAvg - 新设企业注册基本平均数
     */
    public BigDecimal getRegCapAvg() {
        return regCapAvg;
    }

    /**
     * 设置新设企业注册基本平均数
     *
     * @param regCapAvg 新设企业注册基本平均数
     */
    public void setRegCapAvg(BigDecimal regCapAvg) {
        this.regCapAvg = regCapAvg;
    }

    /**
     * 获取新设企业股东全为自然人
     *
     * @return InvLeg - 新设企业股东全为自然人
     */
    public BigDecimal getInvLeg() {
        return invLeg;
    }

    /**
     * 设置新设企业股东全为自然人
     *
     * @param invLeg 新设企业股东全为自然人
     */
    public void setInvLeg(BigDecimal invLeg) {
        this.invLeg = invLeg;
    }

	public BigDecimal getThrIndustry1() {
		return thrIndustry1;
	}

	public void setThrIndustry1(BigDecimal thrIndustry1) {
		this.thrIndustry1 = thrIndustry1;
	}

	public BigDecimal getThrIndustry2() {
		return thrIndustry2;
	}

	public void setThrIndustry2(BigDecimal thrIndustry2) {
		this.thrIndustry2 = thrIndustry2;
	}

	public BigDecimal getThrIndustry3() {
		return thrIndustry3;
	}

	public void setThrIndustry3(BigDecimal thrIndustry3) {
		this.thrIndustry3 = thrIndustry3;
	}

	public BigDecimal getEigIndustry1() {
		return eigIndustry1;
	}

	public void setEigIndustry1(BigDecimal eigIndustry1) {
		this.eigIndustry1 = eigIndustry1;
	}

	public BigDecimal getEigIndustry2() {
		return eigIndustry2;
	}

	public void setEigIndustry2(BigDecimal eigIndustry2) {
		this.eigIndustry2 = eigIndustry2;
	}

	public BigDecimal getEigIndustry3() {
		return eigIndustry3;
	}

	public void setEigIndustry3(BigDecimal eigIndustry3) {
		this.eigIndustry3 = eigIndustry3;
	}

	public BigDecimal getEigIndustry4() {
		return eigIndustry4;
	}

	public void setEigIndustry4(BigDecimal eigIndustry4) {
		this.eigIndustry4 = eigIndustry4;
	}

	public BigDecimal getEigIndustry5() {
		return eigIndustry5;
	}

	public void setEigIndustry5(BigDecimal eigIndustry5) {
		this.eigIndustry5 = eigIndustry5;
	}

	public BigDecimal getEigIndustry6() {
		return eigIndustry6;
	}

	public void setEigIndustry6(BigDecimal eigIndustry6) {
		this.eigIndustry6 = eigIndustry6;
	}

	public BigDecimal getEigIndustry7() {
		return eigIndustry7;
	}

	public void setEigIndustry7(BigDecimal eigIndustry7) {
		this.eigIndustry7 = eigIndustry7;
	}

	public BigDecimal getEigIndustry8() {
		return eigIndustry8;
	}

	public void setEigIndustry8(BigDecimal eigIndustry8) {
		this.eigIndustry8 = eigIndustry8;
	}
    
    
}