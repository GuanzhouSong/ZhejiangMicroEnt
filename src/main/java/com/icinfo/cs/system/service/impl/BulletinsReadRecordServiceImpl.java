/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.BulletinsReadRecordDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.mapper.BulletinsReadRecordMapper;
import com.icinfo.cs.system.model.BulletinsReadRecord;
import com.icinfo.cs.system.service.IBulletinsReadRecordService;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 描述:    cs_bulletins_read_record 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class BulletinsReadRecordServiceImpl extends MyBatisServiceSupport implements IBulletinsReadRecordService {

    @Autowired
    private BulletinsReadRecordMapper bulletinsReadRecordMapper;

    /**
     * 阅读通知公告
     *
     * @param bulletinId 通知公告ID
     * @param sysUserDto 当前登录用户
     * @author ZhuDefeng
     * @date 2016-11-29
     */
    @Override
    public int  doCollection(String bulletinId,SysUserDto sysUserDto) {
        BulletinsReadRecord condition=new BulletinsReadRecord();
        condition.setBulletinID(bulletinId);
        condition.setReaderUserId(sysUserDto.getId());
        BulletinsReadRecord bulletinsReadRecord=bulletinsReadRecordMapper.selectOne(condition);
        if(bulletinsReadRecord==null){
            bulletinsReadRecord=new BulletinsReadRecord();
            bulletinsReadRecord.setReaderUserId(sysUserDto.getId());
            bulletinsReadRecord.setReader(sysUserDto.getUsername());
            bulletinsReadRecord.setIsRead("0");
            bulletinsReadRecord.setIsCollection("1");
            bulletinsReadRecord.setBulletinID(bulletinId);
            bulletinsReadRecord.setCreateTime(new Date());
            return bulletinsReadRecordMapper.insert(bulletinsReadRecord);
        }else{
            bulletinsReadRecord.setIsCollection("1");
            return bulletinsReadRecordMapper.updateByPrimaryKey(bulletinsReadRecord);
        }
    }

    /**
     * 阅读通知公告
     *
     * @param bulletinId 通知公告ID
     * @param sysUserDto 当前登录用户
     * @author ZhuDefeng
     * @date 2016-11-29
     */
    @Override
    public int doRead(String bulletinId,SysUserDto sysUserDto) {
        BulletinsReadRecord condition=new BulletinsReadRecord();
        condition.setBulletinID(bulletinId);
        condition.setReaderUserId(sysUserDto.getId());
        BulletinsReadRecord bulletinsReadRecord=bulletinsReadRecordMapper.selectOne(condition);
        if(bulletinsReadRecord==null){
            bulletinsReadRecord=new BulletinsReadRecord();
            bulletinsReadRecord.setReaderUserId(sysUserDto.getId());
            bulletinsReadRecord.setReader(sysUserDto.getUsername());
            bulletinsReadRecord.setIsRead("1");
            bulletinsReadRecord.setIsCollection("0");
            bulletinsReadRecord.setBulletinID(bulletinId);
            bulletinsReadRecord.setCreateTime(new Date());	
        }else{
            bulletinsReadRecord.setIsRead("1");
            return bulletinsReadRecordMapper.updateByPrimaryKey(bulletinsReadRecord);
        }

    	

       return bulletinsReadRecordMapper.insert(bulletinsReadRecord);
    }

    /**
     * 查询当前登录用户可查看的通知公告
     *
     * @param sysUserDto
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-11-28
     */
    @Override
    public List<BulletinsReadRecordDto> doSelectBulletinBySysUser(SysUserDto sysUserDto) throws Exception {
        Map<String ,Object> qryMap=new HashMap<>();
        qryMap.put("systemType",sysUserDto.getUserType());
        qryMap.put("readerUserId", sysUserDto.getId());
        qryMap.put("reader", sysUserDto.getUsername());
        if("1".equals(sysUserDto.getUserType())){
            qryMap.put("deptCode",sysUserDto.getDeptCode() != null ? StringUtil.substring(sysUserDto.getDeptCode(), 0, 8) : "000000");
        }else{
            qryMap.put("deptCode",sysUserDto.getSysDepart().getAdcode() != null ? StringUtil.substring(sysUserDto.getSysDepart().getAdcode(),0,8) : "000000");
        }
        
//        if("2".equals(sysUserDto.getUserType())&&sysUserDto.getSysDepart()!=null){
//            qryMap.put("adCode",StringUtil.substring(sysUserDto.getSysDepart().getAdcode(),0,4));
//            qryMap.put("orgCoding",sysUserDto.getSysDepart().getOrgCoding());
//        }
        List<BulletinsReadRecordDto> bulletinsReadRecordDtos=bulletinsReadRecordMapper.selectBulletinBySysUser(qryMap);
//        for (Iterator iter = bulletinsReadRecordDtos.iterator(); iter.hasNext();) {
//            BulletinsReadRecordDto bulletinsReadRecordDto= (BulletinsReadRecordDto) iter.next();
//            if(StringUtil.equals(bulletinsReadRecordDto.getBulScope(),"2")&&!StringUtil.equals(sysUserDto.getDeptCode(),bulletinsReadRecordDto.getSetDeptCode())){
//                iter.remove();
//            }
//        }
        return bulletinsReadRecordDtos;
    }
}