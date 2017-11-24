/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.datacount.dto.RptTrade;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.model.RegistInfo;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistUnlicensed;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_regist_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IRegistInfoService extends BaseService {


    /**
     *  获取认领建档表格数据，系统分页
     * @param request
     * @return
     */
    List<RegistInfoDto> registInfoQueryPage_all(PageRequest request);
    /**
     *  获取认领建档表格数据，自己分页
     * @param request
     * @return
     */
    PageResponse<RegistInfoDto> registInfoQueryPage_page(PageRequest request) throws Exception;

    /**
     * 修改
     * @param registInfoDto
     * @return
     */
    int batchModi(RegistInfoDto registInfoDto,SysUserDto sysUser);

    /**
     * 批量修改
     * @param registInfoDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int modi(RegistInfoDto registInfoDto,SysUserDto sysUser);

    RegistInfoDto getRegistInfoByID(MidBaseInfoDto midBaseInfoDto, RegistInfoDto registinfoq);

    int claim(RegistInfo registInfo);


    /**
     * 批量分配
     * @param registInfo
     * @return
     */
    int batchDistribute(RegistInfoDto registInfo);

    @Transactional
    int batchDelegate(RegistInfo registInfo);

    /**
     * 批量退回
     * @param registInfo
     * @return
     */
    int batchBack(RegistInfoDto registInfo);

    /**
     * 获取企业基础表数据
     * @return
     */
    MidBaseInfoDto selectMidBaseInfoByPripid(String priPID);

    /**
     * 获取cs_regist_info表全部数据
     * @param request
     * @return
     */
    List<RegistInfoDto> registModiInfoQueryPage(PageRequest request);


    List<RegistInfoDto> registDistributeInfoQueryPage(PageRequest request);

    Map<String, Object> allAbnormals(String priPID, String entTypeCatg, Map<String, Object> data);

    List<RegistInfoDto> registInfoAgainQueryPage(PageRequest request);

    List<Map<String,String>> selectAllMarkType();

    List<RegistMark> selectCsWarnMark(RegistInfoDto registInfoDto);

    List<RegistUnlicensed> selectSuperItem(RegistInfoDto registInfoDto);

    List<RegistInfoDto> registDelegateInfoQueryPage(PageRequest request);

    /**
     * 把变更重建档的数据备份到历史表，并且往建档表新插入一条记录，插入mid表的基本信息
     * @param registInfoDto
     * @return
     */
    @Transactional
    int bakHistoryDataAndInsert(RegistInfoDto registInfoDto);

    int registInfoSyn();


    RegistInfoDto selectRegistInfoByPriPID(String pripid) ;
    /**
     * 七大产业统计
     * @param request
     * @return
     */
    List<RptTrade> getDataCountQueryPage(PageRequest request);
    
    /**
     * 
     * 描述: 待分配(建档待分配及初始待分配)数量
     * @auther gaojinling
     * @date 2017年10月12日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectAltRegistInfoCount(Map<String, Object> map) throws Exception;
    
    /**
     * 
     * 描述: 新户待建档
     * @auther gaojinling
     * @date 2017年10月13日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectNewRegistInfoCount(Map<String, Object> map) throws Exception;
    
    /**
     * 
     * 描述: 变更户待建档
     * @auther gaojinling
     * @date 2017年10月13日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectModRegistInfoCount(Map<String, Object> map) throws Exception;
}