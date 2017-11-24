/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.inspect.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  cs_report_check_item 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年01月17日
 */
@Table(name = "cs_report_check_item")
public class ReportCheckItem implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    /**
     * 序号：cs_report_check_info表的UUID
     */
    @Column(name = "UID")
    private String UID;

    /**
     * 检查事项编码：即时信息（01：股东认缴出资，02：股东实缴出资，03：股权变更,04:行政许可，05：出质登记，06：处罚信息，07：违反企业法规，08：违反其他法规，09：核查方式）；年报信息（10：登记住所，11：通信地址，12：邮政编码，13：联系电话，14：电子邮箱，15：企业状态信息，16：企业网站，17：网店名称，18：网址信息，19：企业投资，20：股权变更，21：股东认缴出资，22：股东实缴出资，23：对外担保，24：资产总额，25：负债总额，26：所有者权益，27：营业总收入，28：利润总额，29：纳税总额，30：从业人员，31：非公党建信息，32：违反企业法规，33：违反其他法规，34：核查方式）
     */
    @Column(name = "ItemCode")
    private String itemCode;

    /**
     * 检查事项内容
     */
    @Column(name = "ItemContent")
    private String itemContent;


    /**
     * 参照check_code表的type：一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    @Column(name = "Type")
    private String type;

    @Column(name = "Status")
    private String status;


    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * 获取序号：cs_report_check_info表的UUID
     *
     * @return UID - 序号：cs_report_check_info表的UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号：cs_report_check_info表的UUID
     *
     * @param UID 序号：cs_report_check_info表的UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取检查事项编码：即时信息（01：股东认缴出资，02：股东实缴出资，03：股权变更,04:行政许可，05：出质登记，06：处罚信息，07：违反企业法规，08：违反其他法规，09：核查方式）；年报信息（10：登记住所，11：通信地址，12：邮政编码，13：联系电话，14：电子邮箱，15：企业状态信息，16：企业网站，17：网店名称，18：网址信息，19：企业投资，20：股权变更，21：股东认缴出资，22：股东实缴出资，23：对外担保，24：资产总额，25：负债总额，26：所有者权益，27：营业总收入，28：利润总额，29：纳税总额，30：从业人员，31：非公党建信息，32：违反企业法规，33：违反其他法规，34：核查方式）
     *
     * @return ItemCode - 检查事项编码：即时信息（01：股东认缴出资，02：股东实缴出资，03：股权变更,04:行政许可，05：出质登记，06：处罚信息，07：违反企业法规，08：违反其他法规，09：核查方式）；年报信息（10：登记住所，11：通信地址，12：邮政编码，13：联系电话，14：电子邮箱，15：企业状态信息，16：企业网站，17：网店名称，18：网址信息，19：企业投资，20：股权变更，21：股东认缴出资，22：股东实缴出资，23：对外担保，24：资产总额，25：负债总额，26：所有者权益，27：营业总收入，28：利润总额，29：纳税总额，30：从业人员，31：非公党建信息，32：违反企业法规，33：违反其他法规，34：核查方式）
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置检查事项编码：即时信息（01：股东认缴出资，02：股东实缴出资，03：股权变更,04:行政许可，05：出质登记，06：处罚信息，07：违反企业法规，08：违反其他法规，09：核查方式）；年报信息（10：登记住所，11：通信地址，12：邮政编码，13：联系电话，14：电子邮箱，15：企业状态信息，16：企业网站，17：网店名称，18：网址信息，19：企业投资，20：股权变更，21：股东认缴出资，22：股东实缴出资，23：对外担保，24：资产总额，25：负债总额，26：所有者权益，27：营业总收入，28：利润总额，29：纳税总额，30：从业人员，31：非公党建信息，32：违反企业法规，33：违反其他法规，34：核查方式）
     *
     * @param itemCode 检查事项编码：即时信息（01：股东认缴出资，02：股东实缴出资，03：股权变更,04:行政许可，05：出质登记，06：处罚信息，07：违反企业法规，08：违反其他法规，09：核查方式）；年报信息（10：登记住所，11：通信地址，12：邮政编码，13：联系电话，14：电子邮箱，15：企业状态信息，16：企业网站，17：网店名称，18：网址信息，19：企业投资，20：股权变更，21：股东认缴出资，22：股东实缴出资，23：对外担保，24：资产总额，25：负债总额，26：所有者权益，27：营业总收入，28：利润总额，29：纳税总额，30：从业人员，31：非公党建信息，32：违反企业法规，33：违反其他法规，34：核查方式）
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取检查事项内容
     *
     * @return ItemContent - 检查事项内容
     */
    public String getItemContent() {
        return itemContent;
    }

    /**
     * 设置检查事项内容
     *
     * @param itemContent 检查事项内容
     */
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取参照check_code表的type：一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     *
     * @return Type - 参照check_code表的type：一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    public String getType() {
        return type;
    }

    /**
     * 设置参照check_code表的type：一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     *
     * @param type 参照check_code表的type：一般核查common;重点key;登记法律法规reglaw;其他法律法规othlaw;检查结果res；后续处置dispose
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取出资情况：1有实缴出资；2无实缴出资；3出资期限未到期；4分期出资期限到期；5出资总期限届满；6零出资；7部分出资；8已足额出资；
     *
     * @return ItemFund - 出资情况：1有实缴出资；2无实缴出资；3出资期限未到期；4分期出资期限到期；5出资总期限届满；6零出资；7部分出资；8已足额出资；
     */



}