/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述: cs_regist_info_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年11月10日
 */
@Table(name = "cs_regist_info_his")
public class RegistInfoHis implements Serializable {
	/**
	 * 自增序号
	 */
	@Id
	@Column(name = "ID")
	@Before
	private Integer ID;

	/**
	 * 序号：UUID
	 */
	@Column(name = "UID")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 企业名称
	 */
	@Column(name = "EntName")
	private String entName;

	/**
	 * 统一社会信用代码
	 */
	@Column(name = "UniCode")
	private String uniCode;

	/**
	 * 注册号
	 */
	@Column(name = "RegNO")
	private String regNO;

	/**
	 * 片区/商圈
	 */
	@Column(name = "SliceNO")
	private String sliceNO;

	/**
	 * 片区管辖人员
	 */
	@Column(name = "SliceMan")
	private String sliceMan;

	/**
	 * 片区管辖人员联系电话
	 */
	@Column(name = "SliceTel")
	private String sliceTel;

	/**
	 * 个转企日期
	 */
	@Column(name = "IndividDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date individDate;

	/**
	 * 法人有效联系电话
	 */
	@Column(name = "Tel")
	private String tel;

	/**
	 * 主体户口联系人
	 */
	@Column(name = "Linkman")
	private String linkman;

	/**
	 * 联系电话
	 */
	@Column(name = "Linktel")
	private String linktel;

	/**
	 * 经营场所地址
	 */
	@Column(name = "OpLoc")
	private String opLoc;

	/**
	 * 管辖单位
	 */
	@Column(name = "LocalAdm")
	private String localAdm;

	/**
	 * 分配人
	 */
	@Column(name = "SetName")
	private String setName;

	/**
	 * 分配日期
	 */
	@Column(name = "SetTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date setTime;

	/**
	 * 退回人
	 */
	@Column(name = "BackName")
	private String backName;

	/**
	 * 退回日期
	 */
	@Column(name = "BackTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date backTime;

	/**
	 * 退回理由
	 */
	@Column(name = "BackReason")
	private String backReason;

	/**
	 * 分配状态：1未分配；2已分配；3退回待分配
	 */
	@Column(name = "RegistState")
	private String registState;

	/**
	 * 建档状态：0未建档；1已建档
	 */
	@Column(name = "ArchState")
	private String archState;

	/**
	 * 认领状态：0未认领；1已认领；2超时未认领；3超时认领
	 */
	@Column(name = "ClaimState")
	private String claimState;

	/**
	 * 认领时间
	 */
	@Column(name = "ClaimDate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date claimDate;

	/**
	 * 认领人账号
	 */
	@Column(name = "ClaimCode")
	private String claimCode;

	/**
	 * 认领人姓名
	 */
	@Column(name = "ClaimName")
	private String claimName;

	/**
	 * 是否进行实地勘察：0否1是
	 */
	@Column(name = "IsInvestigate")
	private String isInvestigate;

	/**
	 * 勘察时间
	 */
	@Column(name = "InvestigateDate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date investigateDate;

	/**
	 * 勘察文件
	 */
	@Column(name = "InvestigateFile")
	private String investigateFile;

	/**
	 * 经营场所地址与实地是否一致：0不一致1一直
	 */
	@Column(name = "IsSameAddr")
	private String isSameAddr;

	/**
	 * 经营场所与实地不一致原因：0查无下落，1商务秘书公司代理，2异地经营
	 */
	@Column(name = "DiffAddrReason")
	private String diffAddrReason;

	/**
	 * 企业联系电话
	 */
	@Column(name = "UnitTel")
	private String unitTel;

	/**
	 * 乡村、街道
	 */
	@Column(name = "Street")
	private String street;

	/**
	 * 是否变更重建档0否1是
	 */
	@Column(name = "IsChangeArch")
	private String isChangeArch;

	/**
	 * 变更重建档类型：1内外资转型，2被撤消（吊销）恢复，3个转企，4个转企&新迁入
	 */
	@Column(name = "ChangeArchState")
	private String changeArchState;

	/**
	 * 企业网站网址
	 */
	@Column(name = "WebSite")
	private String webSite;

	/**
	 * 企业邮箱
	 */
	@Column(name = "UnitEmail")
	private String unitEmail;

	/**
	 * 分配来源(委托状态)：1委托,2自管，3系统自动
	 */
	@Column(name = "RegistSource")
	private String registSource;

	/**
	 * 财务负责人
	 */
	@Column(name = "Finance")
	private String finance;

	/**
	 * 财务负责人联系电话
	 */
	@Column(name = "FinanceTel")
	private String financeTel;

	/**
	 * 时间戳（建档日期，建档时候更新）
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 委托时间
	 */
	@Column(name = "ComDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date comDate;

	/**
	 * 受托管辖机关
	 */
	@Column(name = "DelegateOrg")
	private String delegateOrg;

	/**
	 * 受托管辖机关名称
	 */
	@Column(name = "DelegateOrgName")
	private String delegateOrgName;

	/**
	 * 委托人姓名
	 */
	@Column(name = "DelegateName")
	private String delegateName;

	// 企业联络员联系电话
	@Column(name = "EntEppaPhone")
	private String entEppaPhone;
	// 户口联系人手机号码
	@Column(name = "LinkPhone")
	private String linkPhone;

	/**
	 * 实际经营场所-市 编码
	 */
	@Column(name = "CityAddress")
	private String cityAddress;

	/**
	 * 实际经营场所-县区 编码
	 */
	@Column(name = "AreaAddress")
	private String areaAddress;

	/**
	 * 实际经营场所-街道 编码
	 */
	@Column(name = "StreeAddress")
	private String streeAddress;

	/**
	 * 实际经营场所-描述信息
	 */
	@Column(name = "DesAddress")
	private String desAddress;

	/**
	 * 建档人
	 */
	@Column(name = "ArchName")
	private String archName;

	/**
	 * 时间戳
	 */
	@Column(name = "ModDate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modDate;

	/**
	 * 建档日期
	 */
	@Column(name = "ArchDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date archDate;

	/**
	 * 分类监管：1一般监管，2分类监管
	 */
	@Column(name = "RegistMarkType")
	private String registMarkType;

	/**
	 * 实际经营场所-经营场所地址
	 */
	@Column(name = "ActualOpLoc")
	private String actualOpLoc;

	/**
	 * 实地经营场地-市 编码
	 */
	@Column(name = "ActualCityAddress")
	private String actualCityAddress;

	/**
	 * 实地经营场地-县区 编码
	 */
	@Column(name = "ActualAreaAddress")
	private String actualAreaAddress;

	/**
	 * 实地经营场地-街道 编码
	 */
	@Column(name = "ActualStreeAddress")
	private String actualStreeAddress;

	/**
	 * 实地经营场地-街道
	 */
	@Column(name = "ActualStreet")
	private String actualStreet;

	/**
	 * 实地经营场地-描述信息
	 */
	@Column(name = "ActualDesAddress")
	private String actualDesAddress;

	@Column(name = "WebSiteName")
	private String webSiteName;

	public String getActualOpLoc() {
		return actualOpLoc;
	}

	public void setActualOpLoc(String actualOpLoc) {
		this.actualOpLoc = actualOpLoc;
	}

	public String getActualCityAddress() {
		return actualCityAddress;
	}

	public void setActualCityAddress(String actualCityAddress) {
		this.actualCityAddress = actualCityAddress;
	}

	public String getActualAreaAddress() {
		return actualAreaAddress;
	}

	public void setActualAreaAddress(String actualAreaAddress) {
		this.actualAreaAddress = actualAreaAddress;
	}

	public String getActualStreeAddress() {
		return actualStreeAddress;
	}

	public void setActualStreeAddress(String actualStreeAddress) {
		this.actualStreeAddress = actualStreeAddress;
	}

	public String getActualStreet() {
		return actualStreet;
	}

	public void setActualStreet(String actualStreet) {
		this.actualStreet = actualStreet;
	}

	public String getActualDesAddress() {
		return actualDesAddress;
	}

	public void setActualDesAddress(String actualDesAddress) {
		this.actualDesAddress = actualDesAddress;
	}

	public String getWebSiteName() {
		return webSiteName;
	}

	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * 获取自增序号
	 *
	 * @return ID - 自增序号
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * 设置自增序号
	 *
	 * @param ID
	 *            自增序号
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * 获取序号：UUID
	 *
	 * @return UID - 序号：UUID
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * 设置序号：UUID
	 *
	 * @param UID
	 *            序号：UUID
	 */
	public void setUID(String UID) {
		this.UID = UID;
	}

	/**
	 * 获取主体身份代码
	 *
	 * @return PriPID - 主体身份代码
	 */
	public String getPriPID() {
		return priPID;
	}

	/**
	 * 设置主体身份代码
	 *
	 * @param priPID
	 *            主体身份代码
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取企业名称
	 *
	 * @return EntName - 企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置企业名称
	 *
	 * @param entName
	 *            企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取统一社会信用代码
	 *
	 * @return UniCode - 统一社会信用代码
	 */
	public String getUniCode() {
		return uniCode;
	}

	/**
	 * 设置统一社会信用代码
	 *
	 * @param uniCode
	 *            统一社会信用代码
	 */
	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	/**
	 * 获取注册号
	 *
	 * @return RegNO - 注册号
	 */
	public String getRegNO() {
		return regNO;
	}

	/**
	 * 设置注册号
	 *
	 * @param regNO
	 *            注册号
	 */
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	/**
	 * 获取片区/商圈
	 *
	 * @return SliceNO - 片区/商圈
	 */
	public String getSliceNO() {
		return sliceNO;
	}

	/**
	 * 设置片区/商圈
	 *
	 * @param sliceNO
	 *            片区/商圈
	 */
	public void setSliceNO(String sliceNO) {
		this.sliceNO = sliceNO;
	}

	/**
	 * 获取片区管辖人员
	 *
	 * @return SliceMan - 片区管辖人员
	 */
	public String getSliceMan() {
		return sliceMan;
	}

	/**
	 * 设置片区管辖人员
	 *
	 * @param sliceMan
	 *            片区管辖人员
	 */
	public void setSliceMan(String sliceMan) {
		this.sliceMan = sliceMan;
	}

	/**
	 * 获取片区管辖人员联系电话
	 *
	 * @return SliceTel - 片区管辖人员联系电话
	 */
	public String getSliceTel() {
		return sliceTel;
	}

	/**
	 * 设置片区管辖人员联系电话
	 *
	 * @param sliceTel
	 *            片区管辖人员联系电话
	 */
	public void setSliceTel(String sliceTel) {
		this.sliceTel = sliceTel;
	}

	/**
	 * 获取个转企日期
	 *
	 * @return IndividDate - 个转企日期
	 */
	public Date getIndividDate() {
		return individDate;
	}

	/**
	 * 设置个转企日期
	 *
	 * @param individDate
	 *            个转企日期
	 */
	public void setIndividDate(Date individDate) {
		this.individDate = individDate;
	}

	/**
	 * 获取法人有效联系电话
	 *
	 * @return Tel - 法人有效联系电话
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置法人有效联系电话
	 *
	 * @param tel
	 *            法人有效联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 获取主体户口联系人
	 *
	 * @return Linkman - 主体户口联系人
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * 设置主体户口联系人
	 *
	 * @param linkman
	 *            主体户口联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * 获取联系电话
	 *
	 * @return Linktel - 联系电话
	 */
	public String getLinktel() {
		return linktel;
	}

	/**
	 * 设置联系电话
	 *
	 * @param linktel
	 *            联系电话
	 */
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	/**
	 * 获取经营场所地址
	 *
	 * @return OpLoc - 经营场所地址
	 */
	public String getOpLoc() {
		return opLoc;
	}

	/**
	 * 设置经营场所地址
	 *
	 * @param opLoc
	 *            经营场所地址
	 */
	public void setOpLoc(String opLoc) {
		this.opLoc = opLoc;
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
	 * @param localAdm
	 *            管辖单位
	 */
	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	/**
	 * 获取分配人
	 *
	 * @return SetName - 分配人
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * 设置分配人
	 *
	 * @param setName
	 *            分配人
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * 获取分配日期
	 *
	 * @return SetTime - 分配日期
	 */
	public Date getSetTime() {
		return setTime;
	}

	/**
	 * 设置分配日期
	 *
	 * @param setTime
	 *            分配日期
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	/**
	 * 获取退回人
	 *
	 * @return BackName - 退回人
	 */
	public String getBackName() {
		return backName;
	}

	/**
	 * 设置退回人
	 *
	 * @param backName
	 *            退回人
	 */
	public void setBackName(String backName) {
		this.backName = backName;
	}

	/**
	 * 获取退回日期
	 *
	 * @return BackTime - 退回日期
	 */
	public Date getBackTime() {
		return backTime;
	}

	/**
	 * 设置退回日期
	 *
	 * @param backTime
	 *            退回日期
	 */
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	/**
	 * 获取退回理由
	 *
	 * @return BackReason - 退回理由
	 */
	public String getBackReason() {
		return backReason;
	}

	/**
	 * 设置退回理由
	 *
	 * @param backReason
	 *            退回理由
	 */
	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

	/**
	 * 获取分配状态：1未分配；2已分配；3退回待分配
	 *
	 * @return RegistState - 分配状态：1未分配；2已分配；3退回待分配
	 */
	public String getRegistState() {
		return registState;
	}

	/**
	 * 设置分配状态：1未分配；2已分配；3退回待分配
	 *
	 * @param registState
	 *            分配状态：1未分配；2已分配；3退回待分配
	 */
	public void setRegistState(String registState) {
		this.registState = registState;
	}

	/**
	 * 获取建档状态：0未建档；1已建档
	 *
	 * @return ArchState - 建档状态：0未建档；1已建档
	 */
	public String getArchState() {
		return archState;
	}

	/**
	 * 设置建档状态：0未建档；1已建档
	 *
	 * @param archState
	 *            建档状态：0未建档；1已建档
	 */
	public void setArchState(String archState) {
		this.archState = archState;
	}

	/**
	 * 获取认领状态：0未认领；1已认领；2超时未认领；3超时认领
	 *
	 * @return ClaimState - 认领状态：0未认领；1已认领；2超时未认领；3超时认领
	 */
	public String getClaimState() {
		return claimState;
	}

	/**
	 * 设置认领状态：0未认领；1已认领；2超时未认领；3超时认领
	 *
	 * @param claimState
	 *            认领状态：0未认领；1已认领；2超时未认领；3超时认领
	 */
	public void setClaimState(String claimState) {
		this.claimState = claimState;
	}

	/**
	 * 获取认领时间
	 *
	 * @return ClaimDate - 认领时间
	 */
	public Date getClaimDate() {
		return claimDate;
	}

	/**
	 * 设置认领时间
	 *
	 * @param claimDate
	 *            认领时间
	 */
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	/**
	 * 获取认领人账号
	 *
	 * @return ClaimCode - 认领人账号
	 */
	public String getClaimCode() {
		return claimCode;
	}

	/**
	 * 设置认领人账号
	 *
	 * @param claimCode
	 *            认领人账号
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	/**
	 * 获取认领人姓名
	 *
	 * @return ClaimName - 认领人姓名
	 */
	public String getClaimName() {
		return claimName;
	}

	/**
	 * 设置认领人姓名
	 *
	 * @param claimName
	 *            认领人姓名
	 */
	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}

	/**
	 * 获取是否进行实地勘察：0否1是
	 *
	 * @return IsInvestigate - 是否进行实地勘察：0否1是
	 */
	public String getIsInvestigate() {
		return isInvestigate;
	}

	/**
	 * 设置是否进行实地勘察：0否1是
	 *
	 * @param isInvestigate
	 *            是否进行实地勘察：0否1是
	 */
	public void setIsInvestigate(String isInvestigate) {
		this.isInvestigate = isInvestigate;
	}

	/**
	 * 获取勘察时间
	 *
	 * @return InvestigateDate - 勘察时间
	 */
	public Date getInvestigateDate() {
		return investigateDate;
	}

	/**
	 * 设置勘察时间
	 *
	 * @param investigateDate
	 *            勘察时间
	 */
	public void setInvestigateDate(Date investigateDate) {
		this.investigateDate = investigateDate;
	}

	/**
	 * 获取勘察文件
	 *
	 * @return InvestigateFile - 勘察文件
	 */
	public String getInvestigateFile() {
		return investigateFile;
	}

	/**
	 * 设置勘察文件
	 *
	 * @param investigateFile
	 *            勘察文件
	 */
	public void setInvestigateFile(String investigateFile) {
		this.investigateFile = investigateFile;
	}

	/**
	 * 获取经营场所地址与实地是否一致：0不一致1一直
	 *
	 * @return IsSameAddr - 经营场所地址与实地是否一致：0不一致1一直
	 */
	public String getIsSameAddr() {
		return isSameAddr;
	}

	/**
	 * 设置经营场所地址与实地是否一致：0不一致1一直
	 *
	 * @param isSameAddr
	 *            经营场所地址与实地是否一致：0不一致1一直
	 */
	public void setIsSameAddr(String isSameAddr) {
		this.isSameAddr = isSameAddr;
	}

	/**
	 * 获取经营场所与实地不一致原因：0查无下落，1商务秘书公司代理，2异地经营
	 *
	 * @return DiffAddrReason - 经营场所与实地不一致原因：0查无下落，1商务秘书公司代理，2异地经营
	 */
	public String getDiffAddrReason() {
		return diffAddrReason;
	}

	/**
	 * 设置经营场所与实地不一致原因：0查无下落，1商务秘书公司代理，2异地经营
	 *
	 * @param diffAddrReason
	 *            经营场所与实地不一致原因：0查无下落，1商务秘书公司代理，2异地经营
	 */
	public void setDiffAddrReason(String diffAddrReason) {
		this.diffAddrReason = diffAddrReason;
	}

	/**
	 * 获取企业联系电话
	 *
	 * @return UnitTel - 企业联系电话
	 */
	public String getUnitTel() {
		return unitTel;
	}

	/**
	 * 设置企业联系电话
	 *
	 * @param unitTel
	 *            企业联系电话
	 */
	public void setUnitTel(String unitTel) {
		this.unitTel = unitTel;
	}

	/**
	 * 获取乡村、街道
	 *
	 * @return Street - 乡村、街道
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 设置乡村、街道
	 *
	 * @param street
	 *            乡村、街道
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 获取是否变更重建档0否1是
	 *
	 * @return IsChangeArch - 是否变更重建档0否1是
	 */
	public String getIsChangeArch() {
		return isChangeArch;
	}

	/**
	 * 设置是否变更重建档0否1是
	 *
	 * @param isChangeArch
	 *            是否变更重建档0否1是
	 */
	public void setIsChangeArch(String isChangeArch) {
		this.isChangeArch = isChangeArch;
	}

	/**
	 * 获取变更重建档类型：1内外资转型，2被撤消（吊销）恢复，3个转企，4个转企&新迁入
	 *
	 * @return ChangeArchState - 变更重建档类型：1内外资转型，2被撤消（吊销）恢复，3个转企，4个转企&新迁入
	 */
	public String getChangeArchState() {
		return changeArchState;
	}

	/**
	 * 设置变更重建档类型：1内外资转型，2被撤消（吊销）恢复，3个转企，4个转企&新迁入
	 *
	 * @param changeArchState
	 *            变更重建档类型：1内外资转型，2被撤消（吊销）恢复，3个转企，4个转企&新迁入
	 */
	public void setChangeArchState(String changeArchState) {
		this.changeArchState = changeArchState;
	}

	/**
	 * 获取企业网站网址
	 *
	 * @return WebSite - 企业网站网址
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * 设置企业网站网址
	 *
	 * @param webSite
	 *            企业网站网址
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * 获取企业邮箱
	 *
	 * @return UnitEmail - 企业邮箱
	 */
	public String getUnitEmail() {
		return unitEmail;
	}

	/**
	 * 设置企业邮箱
	 *
	 * @param unitEmail
	 *            企业邮箱
	 */
	public void setUnitEmail(String unitEmail) {
		this.unitEmail = unitEmail;
	}

	/**
	 * 获取分配来源(委托状态)：1委托,2自管，3系统自动
	 *
	 * @return RegistSource - 分配来源(委托状态)：1委托,2自管，3系统自动
	 */
	public String getRegistSource() {
		return registSource;
	}

	/**
	 * 设置分配来源(委托状态)：1委托,2自管，3系统自动
	 *
	 * @param registSource
	 *            分配来源(委托状态)：1委托,2自管，3系统自动
	 */
	public void setRegistSource(String registSource) {
		this.registSource = registSource;
	}

	/**
	 * 获取财务负责人
	 *
	 * @return Finance - 财务负责人
	 */
	public String getFinance() {
		return finance;
	}

	/**
	 * 设置财务负责人
	 *
	 * @param finance
	 *            财务负责人
	 */
	public void setFinance(String finance) {
		this.finance = finance;
	}

	/**
	 * 获取财务负责人联系电话
	 *
	 * @return FinanceTel - 财务负责人联系电话
	 */
	public String getFinanceTel() {
		return financeTel;
	}

	/**
	 * 设置财务负责人联系电话
	 *
	 * @param financeTel
	 *            财务负责人联系电话
	 */
	public void setFinanceTel(String financeTel) {
		this.financeTel = financeTel;
	}

	/**
	 * 获取时间戳（建档日期，建档时候更新）
	 *
	 * @return CreateTime - 时间戳（建档日期，建档时候更新）
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置时间戳（建档日期，建档时候更新）
	 *
	 * @param createTime
	 *            时间戳（建档日期，建档时候更新）
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取委托时间
	 *
	 * @return ComDate - 委托时间
	 */
	public Date getComDate() {
		return comDate;
	}

	/**
	 * 设置委托时间
	 *
	 * @param comDate
	 *            委托时间
	 */
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	/**
	 * 获取受托管辖机关
	 *
	 * @return DelegateOrg - 受托管辖机关
	 */
	public String getDelegateOrg() {
		return delegateOrg;
	}

	/**
	 * 设置受托管辖机关
	 *
	 * @param delegateOrg
	 *            受托管辖机关
	 */
	public void setDelegateOrg(String delegateOrg) {
		this.delegateOrg = delegateOrg;
	}

	/**
	 * 获取受托管辖机关名称
	 *
	 * @return DelegateOrgName - 受托管辖机关名称
	 */
	public String getDelegateOrgName() {
		return delegateOrgName;
	}

	/**
	 * 设置受托管辖机关名称
	 *
	 * @param delegateOrgName
	 *            受托管辖机关名称
	 */
	public void setDelegateOrgName(String delegateOrgName) {
		this.delegateOrgName = delegateOrgName;
	}

	/**
	 * 获取委托人姓名
	 *
	 * @return DelegateName - 委托人姓名
	 */
	public String getDelegateName() {
		return delegateName;
	}

	/**
	 * 设置委托人姓名
	 *
	 * @param delegateName
	 *            委托人姓名
	 */
	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setEntEppaPhone(String entEppaPhone) {
		this.entEppaPhone = entEppaPhone;
	}

	public String getEntEppaPhone() {
		return entEppaPhone;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getAreaAddress() {
		return areaAddress;
	}

	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}

	public String getStreeAddress() {
		return streeAddress;
	}

	public void setStreeAddress(String streeAddress) {
		this.streeAddress = streeAddress;
	}

	public String getDesAddress() {
		return desAddress;
	}

	public void setDesAddress(String desAddress) {
		this.desAddress = desAddress;
	}

	public void setArchName(String archName) {
		this.archName = archName;
	}

	public String getArchName() {
		return archName;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setArchDate(Date archDate) {
		this.archDate = archDate;
	}

	public Date getArchDate() {
		return archDate;
	}

	public void setRegistMarkType(String registMarkType) {
		this.registMarkType = registMarkType;
	}

	public String getRegistMarkType() {
		return registMarkType;
	}
}