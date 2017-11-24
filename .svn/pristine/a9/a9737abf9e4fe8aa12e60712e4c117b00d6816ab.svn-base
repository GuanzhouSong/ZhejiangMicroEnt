/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringToInUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.registinfo.dto.UnlicensedInfoDto;
import com.icinfo.cs.registinfo.mapper.*;
import com.icinfo.cs.registinfo.model.*;
import com.icinfo.cs.registinfo.service.IUnlicensedInfoService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 描述:    cs_unlicensed_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class UnlicensedInfoServiceImpl extends MyBatisServiceSupport implements IUnlicensedInfoService {

    @Autowired
    UnlicensedInfoMapper unlicensedInfoMapper;
    @Autowired
    RegistUnlicensedMapper registUnlicensedMapper;
    @Autowired
    UlFindMapper ulFindMapper;
    @Autowired
    UlManageMapper ulManageMapper;
    @Autowired
    UlRecordMapper ulRecordMapper;
    @Autowired
    MidBaseInfoMapper midBaseInfoMapper;

    @Override
    public List<UlFind> findInfoQueryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return ulFindMapper.findInfoQueryPage(request.getParams());
    }

    @Override
    public List<UlRecord> recodeInfoQueryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return ulRecordMapper.recordInfoQueryPage(request.getParams());
    }

    @Override
    public List<UlManage> manageInfoQueryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return ulManageMapper.manageInfoQueryPage(request.getParams());
    }

    @Override
    public List<UnlicensedInfo> unlicensedInfoQueryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return unlicensedInfoMapper.unlicensedInfoQueryPage(request.getParams());
    }

    @Override
    public List<MidBaseInfoDto> yetLogoffQueryPage(PageRequest request) {
        if(request.getParams()!=null){
            StringToInUtil.strToIn(request.getParams());
        }
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> paramsMap = request.getParams();
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        return midBaseInfoMapper.yetLogoffQueryPage(paramsMap);
    }

    @Override
    public UnlicensedInfoDto getUnlicensedInfoByUid(String uid, HttpSession session) {
        if (StringUtil.isEmpty(uid)) {
            UnlicensedInfoDto unlicensedInfoDto = new UnlicensedInfoDto();
            SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
            unlicensedInfoDto.setSetName(sysUser.getUsername());
            unlicensedInfoDto.setSetTime(new Date());
            return unlicensedInfoDto;

        }
        UnlicensedInfoDto unlicensedInfoDto = unlicensedInfoMapper.selectUnlicensedInfoByUid(uid);
        if (unlicensedInfoDto == null) return unlicensedInfoDto;
        //设置经营内容
        // unlicensedInfoDto=getOperationScope(uid,unlicensedInfoDto);
        //设置监管项目
     //   unlicensedInfoDto = getregistUnlicensed(uid, unlicensedInfoDto);
        return unlicensedInfoDto;
    }


    private UnlicensedInfoDto getOperationScope(String uid, UnlicensedInfoDto unlicensedInfoDto) {
        Example example = new Example(PubEppassword.class);
        if (StringUtil.isEmpty(uid)) return unlicensedInfoDto;
        example.createCriteria().andEqualTo("uid", uid);
        List<RegistUnlicensed> registUnlicenseds = registUnlicensedMapper.selectByExample(example);
        if (registUnlicenseds == null) {
            return unlicensedInfoDto;
        }
        String registUnlicensedsStr = "";
        String registUnlicensedsNamesStr = "";
        for (RegistUnlicensed registUnlicensed : registUnlicenseds) {
            registUnlicensedsStr += "," + registUnlicensed.getSuperNo();
            registUnlicensedsNamesStr += "," + registUnlicensed.getSuperName();
        }
        unlicensedInfoDto.setSuperNos(registUnlicensedsStr.replaceFirst(",", ""));
        unlicensedInfoDto.setSuperNoNames(registUnlicensedsNamesStr.replaceFirst(",", ""));
        return unlicensedInfoDto;

    }

    /**
     * 获取监管项目关联信息
     *
     * @param uid
     * @param unlicensedInfoDto
     * @return
     */
    private UnlicensedInfoDto getregistUnlicensed(String uid, UnlicensedInfoDto unlicensedInfoDto) {
        Example example = new Example(PubEppassword.class);
        if (StringUtil.isEmpty(uid)) return unlicensedInfoDto;
        example.createCriteria().andEqualTo("uid", uid);
        List<RegistUnlicensed> registUnlicenseds = registUnlicensedMapper.selectByExample(example);
        String registUnlicensedsStr = "";
        String registUnlicensedsNamesStr = "";
        if (registUnlicenseds == null) {
            return unlicensedInfoDto;
        }
        for (RegistUnlicensed registUnlicensed : registUnlicenseds) {
            registUnlicensedsStr += "," + registUnlicensed.getSuperNo();
            registUnlicensedsNamesStr += "," + registUnlicensed.getSuperName();
        }
        unlicensedInfoDto.setSuperNos(registUnlicensedsStr.replaceFirst(",", ""));
        unlicensedInfoDto.setSuperNoNames(registUnlicensedsNamesStr.replaceFirst(",", ""));
        return unlicensedInfoDto;
    }

    @Override
    public int doModiUnlicensedInfo(UnlicensedInfoDto unlicensedInfoDto) {
        int res = 0;
        if (unlicensedInfoDto == null) return res;
        unlicensedInfoDto.setProLoc(unlicensedInfoDto.getProLocCity() + unlicensedInfoDto.getProLocCounty()
                + unlicensedInfoDto.getProLocStreet() + unlicensedInfoDto.getProLocAddress());
        if (StringUtil.isEmpty(unlicensedInfoDto.getUID())) {
            unlicensedInfoDto.setUID(UUID.randomUUID().toString().replace("-", ""));
            res = unlicensedInfoMapper.insert(unlicensedInfoDto);
        } else {
            Example example = new Example(UnlicensedInfo.class);
            example.createCriteria().andEqualTo("UID", unlicensedInfoDto.getUID());
            res = unlicensedInfoMapper.updateByExampleSelective(unlicensedInfoDto, example);
        }
        //更新监管项目表
        res = modiregistUnlicensed(unlicensedInfoDto);
        return res;
    }

    @Override
    @Transactional
    public int doModiUlManageInfo(UlManage ulManage) {
        int res = 0;
        if (ulManage.getId() == null) {
            if (ulManage.getDisposeWay() != null && ulManage.getDisposeWay().equals("6")) {
                res = logOff(ulManage.getUID());
                if (res == 0) return 0;
            }
            return ulManageMapper.insert(ulManage);

        } else return ulManageMapper.updateByPrimaryKey(ulManage);
    }

    @Override
    public int logOff(String uid) {
        UnlicensedInfo unlicensedInfo = new UnlicensedInfo();
        Example example = new Example(UnlicensedInfo.class);
        example.createCriteria().andEqualTo("UID", uid);
        unlicensedInfo.setUnlicState("2");
        return unlicensedInfoMapper.updateByExampleSelective(unlicensedInfo, example);
    }

    @Override
    public UlManage getUlManageByid(String id) {
        if (StringUtil.isEmpty(id)) return null;
        return ulManageMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public UlFind getUlFindByid(String id) {
        if (StringUtil.isEmpty(id)) return null;
        return ulFindMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public UlRecord getUlRecordByid(String id) {
        if (StringUtil.isEmpty(id)) return null;
        return ulRecordMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public int doModiUlFindById(UlFind ulFind) {
        if (ulFind.getId() == null)
            return ulFindMapper.insert(ulFind);
        else return ulFindMapper.updateByPrimaryKey(ulFind);
    }

    @Override
    public int doModiUlRecordById(UlRecord ulRecord) {
        if (ulRecord.getId() == null)
            return ulRecordMapper.insert(ulRecord);
        else return ulRecordMapper.updateByPrimaryKey(ulRecord);
    }

    @Override
    public UnlicensedInfoDto getMidBaseinfoByregNO(String regNO) {
        MidBaseInfo midBaseInfo = new MidBaseInfo();
        midBaseInfo.setRegNO(regNO);
        UnlicensedInfoDto unlicensedInfoDto = unlicensedInfoMapper.selectMidBaseinfoByregNO(midBaseInfo);
        // unlicensedInfoDto.seto
        return unlicensedInfoDto;
    }


    private int modiregistUnlicensed(UnlicensedInfoDto unlicensedInfoDto) {
        int res = 1;
        Example example = new Example(RegistUnlicensed.class);
        if (StringUtil.isNotEmpty(unlicensedInfoDto.getUID())) {
            example.createCriteria().andEqualTo("UID", unlicensedInfoDto.getUID());
            registUnlicensedMapper.deleteByExample(example);
        }

        RegistUnlicensed registUnlicensed = new RegistUnlicensed();
        registUnlicensed.setPriPID(unlicensedInfoDto.getPriPID());
        registUnlicensed.setUID(unlicensedInfoDto.getUID());
        String superNos = unlicensedInfoDto.getSuperNos();
        String superNames = unlicensedInfoDto.getSuperNoNames();
        //注意SuperNo是以逗号形式分割的字符串，因为是批量插入的
        if (superNos != null) {
            String[] superNo = superNos.split(",");
            String[] superName = superNames.split(",");
            for (int i = 0; i < superNo.length; i++) {
                if (superNo[i].equals("")) continue;
                registUnlicensed.setSuperNo(superNo[i]);
                registUnlicensed.setSuperName(superName[i]);
                res = registUnlicensedMapper.insert(registUnlicensed);
                if (res == 0) return res;
            }
        }
        return res;
    }

}