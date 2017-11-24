/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月09日
 * @version 2.0
 */
package com.icinfo.cs.registinfo.mapper;

import com.icinfo.cs.datacount.dto.RptTrade;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.model.RegistInfo;
import com.icinfo.cs.registinfo.model.RegistInfoHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_regist_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface RegistInfoMapper extends Mapper<RegistInfo> {

    /**
     * 根据查询参数查询
     * @param params
     * @return
     */
    List<RegistInfoDto> registModiQueryPage(Map<String, Object> params);

    int batchDistribute(RegistInfo registInfo);

    int batchBack(RegistInfoDto registInfo);

    /**
     * 
     * 描述: 户口建档变更列表查询
     * @auther 
     * @date 2017年4月18日 
     * @param params
     * @return
     */
    List<RegistInfoDto> registInfoAgainQueryPage(Map<String, Object> params);

    List<Map<String,String>> selectAllMarkType();


    RegistInfoDto selectByPriPid(String pripid);


    RegistInfoHis selectByPripidForHis(String priPID);

    List<RegistInfo> selectMidInfoNotSyn(HashedMap hashedMap);

    List<RegistInfoDto> registDistributeQueryPage(Map<String, Object> params);

    Long registClaimQueryPage_total(Map<String, Object> params);

    List<RegistInfoDto> registClaimQueryPage_regist(Map<String, Object> params);

    List<RegistInfoDto> registClaimQueryPage(Map<String, Object> params);

    List<PubScinfo> selectPubScinfos(Map<String, Object> params);
    /**
     * 七大产业统计
     * @param params
     * @return
     */
    List<RptTrade> selectRptTrade(Map<String, Object> params);
    
    /**
     * 
     * 描述: 待分配数量
     * @auther gaojinling
     * @date 2017年10月12日 
     * @param map
     * @return
     * @throws Exception
     */
    int selectAltRegistInfoCount(Map<String, Object> map) throws Exception;
    /**
     * 
     * 描述: 新设户待建档
     * @auther gaojinling
     * @date 2017年10月12日 
     * @param map
     * @return
     * @throws Exception
     */
    int selectNewRegistInfoCount(Map<String, Object> map) throws Exception;
    /**
     * 
     * 描述: 变更待建档 
     * @auther gaojinling
     * @date 2017年10月12日 
     * @param map
     * @return
     * @throws Exception
     */
    int selectModRegistInfoCount(Map<String, Object> map) throws Exception;

}