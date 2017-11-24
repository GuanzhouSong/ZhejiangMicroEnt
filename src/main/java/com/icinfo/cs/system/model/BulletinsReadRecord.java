/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_bulletins_read_record 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月21日
 */
@Table(name = "cs_bulletins_read_record")
public class BulletinsReadRecord implements Serializable {
    /**
     * UUID
     */
    @Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 通知公告ID
     */
    @Column(name = "BulletinID")
    private String bulletinID;

    /**
     * 是否已阅
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
     * 读者
     */
    @Column(name = "ReaderUserId")
    private String readerUserId;

    @Column(name = "CreateTime")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取UUID
     *
     * @return UID - UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置UUID
     *
     * @param UID UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }


    public String getReaderUserId() {
        return readerUserId;
    }

    public void setReaderUserId(String readerUserId) {
        this.readerUserId = readerUserId;
    }

    /**
     * 获取通知公告ID
     *
     * @return BulletinID - 通知公告ID
     */
    public String getBulletinID() {
        return bulletinID;
    }

    /**
     * 设置通知公告ID
     *
     * @param bulletinID 通知公告ID
     */
    public void setBulletinID(String bulletinID) {
        this.bulletinID = bulletinID;
    }

    /**
     * 获取是否已阅
     *
     * @return IsRead - 是否已阅
     */
    public String getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已阅
     *
     * @param isRead 是否已阅
     */
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取是否收藏
     *
     * @return IsCollection - 是否收藏
     */
    public String getIsCollection() {
        return isCollection;
    }

    /**
     * 设置是否收藏
     *
     * @param isCollection 是否收藏
     */
    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }

    /**
     * 获取读者
     *
     * @return Reader - 读者
     */
    public String getReader() {
        return reader;
    }

    /**
     * 设置读者
     *
     * @param reader 读者
     */
    public void setReader(String reader) {
        this.reader = reader;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}