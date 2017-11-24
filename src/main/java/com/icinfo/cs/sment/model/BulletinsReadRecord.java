package com.icinfo.cs.sment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
/**
 * 描述:   小微企业通知公告sm_bullentins_read_record 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月04日
 */
@Table(name="sm_bulletins_read_record")
public class BulletinsReadRecord {
	/**
     * uuid
     */
	@Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
	private String UID;
	/**
     * 通知公告Id
     */
    @Column(name = "BulletinId")
	private String bulletinId;
	/**
     * 是否阅读
     */
    @Column(name = "IsRead")
	private String isRead;
	/**
     * 是否收藏
     */
    @Column(name = "IsCollection")
	private String isCollection;
	/**
     * 读者
     */
    @Column(name = "Reader")
	private String reader;
	/**
     * 读者Id
     */
    @Column(name = "ReaderUserId")
	private String readerUserId;
	/**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date createTime;
    
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getBulletinId() {
		return bulletinId;
	}
	public void setBulletinId(String bulletinId) {
		this.bulletinId = bulletinId;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getIsCollection() {
		return isCollection;
	}
	public void setIsCollection(String isCollection) {
		this.isCollection = isCollection;
	}
	public String getReader() {
		return reader;
	}
	public void setReader(String reader) {
		this.reader = reader;
	}
	public String getReaderUserId() {
		return readerUserId;
	}
	public void setReaderUserId(String readerUserId) {
		this.readerUserId = readerUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
