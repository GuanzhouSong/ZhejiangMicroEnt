/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_unified_user_record 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月07日
 */
@Table(name = "cs_unified_user_record")
public class UnifiedUserRecord implements Serializable {
    /**
     * 自增id
     */
	@Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主键UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 用户id
     */
    @Column(name = "UserId")
    private String userId;
    
    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private String userType;
    
    /**
     * 内容
     */
    @Column(name = "Content")
    private String content;
    
    
    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;
    
    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 组织机构编码
     */
    @Column(name = "OrgCoding")
    private String orgCoding;

    /**
     * 旧组织机构编码
     */
    @Column(name = "OldOrgCoding")
    private String oldOrgCoding;

    /**
     * 附属组织机构编码,多个附属组织以”;”隔开
     */
    @Column(name = "ExTendOrgCoding")
    private String exTendOrgCoding;

    /**
     * 附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
     */
    @Column(name = "ExTendOrderBy")
    private String exTendOrderBy;

    /**
     * 用户真实姓名
     */
    @Column(name = "UserName")
    private String userName;

    /**
     * 旧登录名
     */
    @Column(name = "OldLoginName")
    private String oldLoginName;

    /**
     * 登录名
     */
    @Column(name = "LoginName")
    private String loginName;

    /**
     * 密码加密类型:1. 表示明文 2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）4 .AES （sun自带库加密，密钥【servicepwd】为SSO提供）
     */
    @Column(name = "EncrypTionType")
    private String encrypTionType;

    /**
     * 密码
     */
    @Column(name = "LoginPwd")
    private String loginPwd;

    /**
     * 邮件
     */
    @Column(name = "Email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "Mobile")
    private String mobile;

    /**
     * 手机号码2（备用手机）
     */
    @Column(name = "Mobile2")
    private String mobile2;

    /**
     * 座机号码（常用电话）
     */
    @Column(name = "TelepHone")
    private String telepHone;

    /**
     * 座机号码2（备用电话）
     */
    @Column(name = "TelepHone2")
    private String telepHone2;

    /**
     * 虚拟网号
     */
    @Column(name = "VirtualNum")
    private String virtualNum;

    /**
     * 职务，可能有多个。（多个职务之间用半角字符“;”隔开）
     */
    @Column(name = "UserPosiTion")
    private String userPosiTion;

    /**
     * 职称
     */
    @Column(name = "UserTitle")
    private String userTitle;

    /**
     * CA证书KEY
     */
    @Column(name = "CaKey")
    private String caKey;

    /**
     * 邮编
     */
    @Column(name = "PostCode")
    private String postCode;

    /**
     * 性别 1男 2女
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "BirthDay")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthDay;

    /**
     * 国籍
     */
    @Column(name = "Country")
    private String country;

    /**
     * 省籍
     */
    @Column(name = "Province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "City")
    private String city;

    /**
     * 办公室地址
     */
    @Column(name = "OfficeAddress")
    private String officeAddress;

    /**
     * 办公室号
     */
    @Column(name = "OfficeNum")
    private String officeNum;

    /**
     * 办公电话
     */
    @Column(name = "OfficePhone")
    private String officePhone;

    /**
     * 办公室传真
     */
    @Column(name = "OfficeFax")
    private String officeFax;

    /**
     * 家庭电话
     */
    @Column(name = "HomePhone")
    private String homePhone;

    /**
     * 家庭地址
     */
    @Column(name = "HomeAddress")
    private String homeAddress;

    /**
     * 是否在编1 在编2 不在编
     */
    @Column(name = "Official")
    private String official;

    /**
     * 1：行政编制  2：事业编制
     */
    @Column(name = "OfficialType")
    private String officialType;

    /**
     * 证件类型证件类型 1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
     */
    @Column(name = "IdType")
    private String idType;
    
    /**
     * 证件号码
     */
    @Column(name = "IdNum")
    private String idNum;
    

    /**
     * 用户激活状态 1激活，2未激活
     */
    @Column(name = "UseAble")
    private String useAble;

    /**
     * 排序
     */
    @Column(name = "Orderby")
    private String orderby;

    /**
     * 头像地址
     */
    @Column(name = "HeadPicture")
    private String headPicture;

    /**
     * 用户描述
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 同步状态 0 同步成功 0之外的状态表示同步失败
     */
    @Column(name = "UnifiedState")
    private String unifiedState;

    /**
     * 同步信息 记录同步时的结果
     */
    @Column(name = "UnifiedMessage")
    private String unifiedMessage;

    /**
     * 操作类型 0 新增 1 修改 2 删除
     */
    @Column(name = "IStateType")
    private String stateType;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取用户id
     *
     * @return UserId - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取组织机构编码
     *
     * @return OrgCoding - 组织机构编码
     */
    public String getOrgCoding() {
        return orgCoding;
    }

    /**
     * 设置组织机构编码
     *
     * @param orgCoding 组织机构编码
     */
    public void setOrgCoding(String orgCoding) {
        this.orgCoding = orgCoding;
    }

    /**
     * 获取旧组织机构编码
     *
     * @return OldOrgCoding - 旧组织机构编码
     */
    public String getOldOrgCoding() {
        return oldOrgCoding;
    }

    /**
     * 设置旧组织机构编码
     *
     * @param oldOrgCoding 旧组织机构编码
     */
    public void setOldOrgCoding(String oldOrgCoding) {
        this.oldOrgCoding = oldOrgCoding;
    }

    /**
     * 获取附属组织机构编码,多个附属组织以”;”隔开
     *
     * @return ExTendOrgCoding - 附属组织机构编码,多个附属组织以”;”隔开
     */
    public String getExTendOrgCoding() {
        return exTendOrgCoding;
    }

    /**
     * 设置附属组织机构编码,多个附属组织以”;”隔开
     *
     * @param exTendOrgCoding 附属组织机构编码,多个附属组织以”;”隔开
     */
    public void setExTendOrgCoding(String exTendOrgCoding) {
        this.exTendOrgCoding = exTendOrgCoding;
    }

    /**
     * 获取附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
     *
     * @return ExTendOrderBy - 附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
     */
    public String getExTendOrderBy() {
        return exTendOrderBy;
    }

    /**
     * 设置附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
     *
     * @param exTendOrderBy 附属组织排序。  组织编码:排序号. 多个附属组织以”;” (英文输入法、半角)分号隔开.修改附属用户排序号，只同步对应组织下的排序号
     */
    public void setExTendOrderBy(String exTendOrderBy) {
        this.exTendOrderBy = exTendOrderBy;
    }

    /**
     * 获取用户真实姓名
     *
     * @return UserName - 用户真实姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户真实姓名
     *
     * @param userName 用户真实姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取旧登录名
     *
     * @return OldLoginName - 旧登录名
     */
    public String getOldLoginName() {
        return oldLoginName;
    }

    /**
     * 设置旧登录名
     *
     * @param oldLoginName 旧登录名
     */
    public void setOldLoginName(String oldLoginName) {
        this.oldLoginName = oldLoginName;
    }

    /**
     * 获取登录名
     *
     * @return LoginName - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取密码加密类型:1. 表示明文 2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）4 .AES （sun自带库加密，密钥【servicepwd】为SSO提供）
     *
     * @return EncrypTionType - 密码加密类型:1. 表示明文 2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）4 .AES （sun自带库加密，密钥【servicepwd】为SSO提供）
     */
    public String getEncrypTionType() {
        return encrypTionType;
    }

    /**
     * 设置密码加密类型:1. 表示明文 2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）4 .AES （sun自带库加密，密钥【servicepwd】为SSO提供）
     *
     * @param encrypTionType 密码加密类型:1. 表示明文 2. 表示Base64(UTF-8字符集操作) 3 .MD5 （标准32位小写）4 .AES （sun自带库加密，密钥【servicepwd】为SSO提供）
     */
    public void setEncrypTionType(String encrypTionType) {
        this.encrypTionType = encrypTionType;
    }

    /**
     * 获取密码
     *
     * @return LoginPwd - 密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置密码
     *
     * @param loginPwd 密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * 获取邮件
     *
     * @return Email - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return Mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取手机号码2（备用手机）
     *
     * @return Mobile2 - 手机号码2（备用手机）
     */
    public String getMobile2() {
        return mobile2;
    }

    /**
     * 设置手机号码2（备用手机）
     *
     * @param mobile2 手机号码2（备用手机）
     */
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    /**
     * 获取座机号码（常用电话）
     *
     * @return TelepHone - 座机号码（常用电话）
     */
    public String getTelepHone() {
        return telepHone;
    }

    /**
     * 设置座机号码（常用电话）
     *
     * @param telepHone 座机号码（常用电话）
     */
    public void setTelepHone(String telepHone) {
        this.telepHone = telepHone;
    }

    /**
     * 获取座机号码2（备用电话）
     *
     * @return TelepHone2 - 座机号码2（备用电话）
     */
    public String getTelepHone2() {
        return telepHone2;
    }

    /**
     * 设置座机号码2（备用电话）
     *
     * @param telepHone2 座机号码2（备用电话）
     */
    public void setTelepHone2(String telepHone2) {
        this.telepHone2 = telepHone2;
    }

    /**
     * 获取虚拟网号
     *
     * @return VirtualNum - 虚拟网号
     */
    public String getVirtualNum() {
        return virtualNum;
    }

    /**
     * 设置虚拟网号
     *
     * @param virtualNum 虚拟网号
     */
    public void setVirtualNum(String virtualNum) {
        this.virtualNum = virtualNum;
    }

    /**
     * 获取职务，可能有多个。（多个职务之间用半角字符“;”隔开）
     *
     * @return UserPosiTion - 职务，可能有多个。（多个职务之间用半角字符“;”隔开）
     */
    public String getUserPosiTion() {
        return userPosiTion;
    }

    /**
     * 设置职务，可能有多个。（多个职务之间用半角字符“;”隔开）
     *
     * @param userPosiTion 职务，可能有多个。（多个职务之间用半角字符“;”隔开）
     */
    public void setUserPosiTion(String userPosiTion) {
        this.userPosiTion = userPosiTion;
    }

    /**
     * 获取职称
     *
     * @return UserTitle - 职称
     */
    public String getUserTitle() {
        return userTitle;
    }

    /**
     * 设置职称
     *
     * @param userTitle 职称
     */
    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    /**
     * 获取CA证书KEY
     *
     * @return CaKey - CA证书KEY
     */
    public String getCaKey() {
        return caKey;
    }

    /**
     * 设置CA证书KEY
     *
     * @param caKey CA证书KEY
     */
    public void setCaKey(String caKey) {
        this.caKey = caKey;
    }

    /**
     * 获取邮编
     *
     * @return PostCode - 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置邮编
     *
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取性别 1男 2女
     *
     * @return Sex - 性别 1男 2女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别 1男 2女
     *
     * @param sex 性别 1男 2女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return BirthDay - 生日
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * 设置生日
     *
     * @param birthDay 生日
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * 获取国籍
     *
     * @return Country - 国籍
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国籍
     *
     * @param country 国籍
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取省籍
     *
     * @return Province - 省籍
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省籍
     *
     * @param province 省籍
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return City - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取办公室地址
     *
     * @return OfficeAddress - 办公室地址
     */
    public String getOfficeAddress() {
        return officeAddress;
    }

    /**
     * 设置办公室地址
     *
     * @param officeAddress 办公室地址
     */
    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    /**
     * 获取办公室号
     *
     * @return OfficeNum - 办公室号
     */
    public String getOfficeNum() {
        return officeNum;
    }

    /**
     * 设置办公室号
     *
     * @param officeNum 办公室号
     */
    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    /**
     * 获取办公电话
     *
     * @return OfficePhone - 办公电话
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * 设置办公电话
     *
     * @param officePhone 办公电话
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     * 获取办公室传真
     *
     * @return OfficeFax - 办公室传真
     */
    public String getOfficeFax() {
        return officeFax;
    }

    /**
     * 设置办公室传真
     *
     * @param officeFax 办公室传真
     */
    public void setOfficeFax(String officeFax) {
        this.officeFax = officeFax;
    }

    /**
     * 获取家庭电话
     *
     * @return HomePhone - 家庭电话
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * 设置家庭电话
     *
     * @param homePhone 家庭电话
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * 获取家庭地址
     *
     * @return HomeAddress - 家庭地址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置家庭地址
     *
     * @param homeAddress 家庭地址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * 获取是否在编1 在编2 不在编
     *
     * @return Official - 是否在编1 在编2 不在编
     */
    public String getOfficial() {
        return official;
    }

    /**
     * 设置是否在编1 在编2 不在编
     *
     * @param official 是否在编1 在编2 不在编
     */
    public void setOfficial(String official) {
        this.official = official;
    }

    /**
     * 获取1：行政编制  2：事业编制
     *
     * @return OfficialType - 1：行政编制  2：事业编制
     */
    public String getOfficialType() {
        return officialType;
    }

    /**
     * 设置1：行政编制  2：事业编制
     *
     * @param officialType 1：行政编制  2：事业编制
     */
    public void setOfficialType(String officialType) {
        this.officialType = officialType;
    }

    /**
     * 获取证件类型证件类型 1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
     *
     * @return IdType - 证件类型证件类型 1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型证件类型 1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
     *
     * @param idType 证件类型证件类型 1身份证2.护照3.军官证4.士兵证5.户口簿 默认为 1.身份证
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 获取用户激活状态 1激活，2未激活
     *
     * @return UseAble - 用户激活状态 1激活，2未激活
     */
    public String getUseAble() {
        return useAble;
    }

    /**
     * 设置用户激活状态 1激活，2未激活
     *
     * @param useAble 用户激活状态 1激活，2未激活
     */
    public void setUseAble(String useAble) {
        this.useAble = useAble;
    }

    /**
     * 获取排序
     *
     * @return Orderby - 排序
     */
    public String getOrderby() {
        return orderby;
    }

    /**
     * 设置排序
     *
     * @param orderby 排序
     */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    /**
     * 获取头像地址
     *
     * @return HeadPicture - 头像地址
     */
    public String getHeadPicture() {
        return headPicture;
    }

    /**
     * 设置头像地址
     *
     * @param headPicture 头像地址
     */
    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
     * 获取同步状态 0 同步成功 0之外的状态表示同步失败
     *
     * @return UnifiedState - 同步状态 0 同步成功 0之外的状态表示同步失败
     */
    public String getUnifiedState() {
        return unifiedState;
    }

    /**
     * 设置同步状态 0 同步成功 0之外的状态表示同步失败
     *
     * @param unifiedState 同步状态 0 同步成功 0之外的状态表示同步失败
     */
    public void setUnifiedState(String unifiedState) {
        this.unifiedState = unifiedState;
    }

    /**
     * 获取同步信息 记录同步时的结果
     *
     * @return UnifiedMessage - 同步信息 记录同步时的结果
     */
    public String getUnifiedMessage() {
        return unifiedMessage;
    }

    /**
     * 设置同步信息 记录同步时的结果
     *
     * @param unifiedMessage 同步信息 记录同步时的结果
     */
    public void setUnifiedMessage(String unifiedMessage) {
        this.unifiedMessage = unifiedMessage;
    }

    /**
     * 获取操作类型 0 新增 1 修改 2 删除
     *
     * @return StateType - 操作类型 0 新增 1 修改 2 删除
     */
    public String getStateType() {
        return stateType;
    }

    /**
     * 设置操作类型 0 新增 1 修改 2 删除
     *
     * @param stateType 操作类型 0 新增 1 修改 2 删除
     */
    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	} 
}