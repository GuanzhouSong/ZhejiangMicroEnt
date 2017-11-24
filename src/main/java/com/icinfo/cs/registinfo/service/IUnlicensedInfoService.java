/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.registinfo.dto.UnlicensedInfoDto;
import com.icinfo.cs.registinfo.model.UlFind;
import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.cs.registinfo.model.UlRecord;
import com.icinfo.cs.registinfo.model.UnlicensedInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:    cs_unlicensed_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IUnlicensedInfoService extends BaseService {
    List<UnlicensedInfo> unlicensedInfoQueryPage(PageRequest request);

    List<UlManage> manageInfoQueryPage(PageRequest request);


    List<UlFind> findInfoQueryPage(PageRequest request);

    List<UlRecord> recodeInfoQueryPage(PageRequest request);


    UnlicensedInfoDto getUnlicensedInfoByUid(String uid, HttpSession session);

    /**
     * 对无照库进行修改
     * @param unlicensedInfoDto
     * @return
     */
    int doModiUnlicensedInfo(UnlicensedInfoDto unlicensedInfoDto);

    /**
     * 对处理记录进行修改
     * @param ulManage
     * @return
     */
    int doModiUlManageInfo(UlManage ulManage);

    /**
     * 销户
     * @param uid
     * @return
     */
    int logOff(String uid);

    UlManage getUlManageByid(String id);

    UlRecord getUlRecordByid(String id);

    int doModiUlFindById(UlFind ulFind);

    UlFind getUlFindByid(String id);

    int doModiUlRecordById(UlRecord ulRecord);

    UnlicensedInfoDto getMidBaseinfoByregNO(String regNO);

    List<MidBaseInfoDto> yetLogoffQueryPage(PageRequest request);
}