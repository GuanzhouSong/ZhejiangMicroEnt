/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.rpt.rptmapper.RptSmBaseinfoMapper;
import com.icinfo.cs.sment.dto.EntarchivesHisDto;
import com.icinfo.cs.sment.mapper.EntarchivesHisMapper;
import com.icinfo.cs.sment.model.EntarchivesHis;
import com.icinfo.cs.sment.service.IEntarchivesHisService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Service
public class EntarchivesHisServiceImpl extends MyBatisServiceSupport implements IEntarchivesHisService {

    @Autowired
    private EntarchivesHisMapper entarchivesHisMapper;
    
    @Autowired
    private RptSmBaseinfoMapper rptSmBaseinfoMapper;

    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年5月4日 
     * @param bean 
     */

    public void insert(EntarchivesHis bean){
        entarchivesHisMapper.insert (bean);
    }

    /** 
     * 描述: 根据企业id获取历史信息
     * @author 张文男
     * @date 2017年5月4日 
     * @param priPID
     * @return 
     */

    public EntarchivesHis queryByPriPID(String priPID){
        Example e = new Example (EntarchivesHis.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        List<EntarchivesHis> list = entarchivesHisMapper.selectByExample (e);
        if (null != list && list.size () > 0) { return list.get (0); }
        return null;
    }

    @Override
    public List<EntarchivesHisDto> queryPage(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        return entarchivesHisMapper.selectEntarchivesHisList (request.getParams ());
    }

    /** 
     * 描述:  根据企业id删除历史信息
     * @author 张文男
     * @date 2017年5月9日 
     * @param priPID 
     */

    public void deleteByPriPID(String priPID){
        Example e = new Example (EntarchivesHis.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        entarchivesHisMapper.deleteByExample (e);
    }
    
    private int count(String setDeptCode){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put ("setDeptCode", setDeptCode);
        int count =  rptSmBaseinfoMapper.countZx (map);
        return count;
    }
    
    /** 
     * 描述: 根据部门code获取已注销企业数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param sysUser
     * @return 
     */
    
    public int count(SysUserDto sysUser){
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }

        int count = count (sysSetDeptCode);
        return count;

    }
}