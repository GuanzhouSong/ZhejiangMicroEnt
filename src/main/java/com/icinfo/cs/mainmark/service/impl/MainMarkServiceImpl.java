/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.mainmark.dto.MainMarkDto;
import com.icinfo.cs.mainmark.dto.MainMarkRelDto;
import com.icinfo.cs.mainmark.mapper.MainMarkMapper;
import com.icinfo.cs.mainmark.mapper.MainMarkRelMapper;
import com.icinfo.cs.mainmark.model.MainMark;
import com.icinfo.cs.mainmark.model.MainMarkHis;
import com.icinfo.cs.mainmark.model.MainMarkRel;
import com.icinfo.cs.mainmark.service.IMainMarkHisService;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.cs.mainmark.service.IMainMarkService;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_main_mark 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
@Service
public class MainMarkServiceImpl extends MyBatisServiceSupport implements IMainMarkService {

    @Autowired
    private MainMarkMapper              mainMarkMapper;
    @Autowired
    private MainMarkRelMapper 		    mainMarkRelMapper;
    @Autowired
    private IMainMarkRelService         mainMarkRelService;
    @Autowired
    private IMainMarkHisService         mainMarkHisService;
    @Autowired
    private IpubScSpecialLibraryService pubScSpecialLibraryService;
    @Autowired
    private IRegistMarkService          registMarkService;
    @Autowired
    private IPubApprMarkRelService      pubApprMarkRelService;

    /**
     * 描述: 分页列表
     * 
     * @author 张文男
     * @date 2017年3月30日
     * @param request
     * @return
     */
    @Override
    public List<MainMarkDto> queryPageList(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> queryMap = request.getParams ();
        String auditState = StringUtil.doSplitStringToSqlFormat (queryMap.get ("auditState").toString (), ",");
        queryMap.put ("auditState", auditState);
        List<MainMarkDto> list = mainMarkMapper.queryPageList (queryMap);
        return list;
    }

    /**
     * 描述: 保存企业与标签关系
     * 
     * @author 张文男
     * @date 2017年3月31日
     * @param priPIDs
     * @param markCodes
     * @param markNames
     * @param setName
     * @param setTime
     * @param setDeptname
     * @throws ParseException
     */

    @Override
    public void saveOrUpdate(String priPIDs,String markCodes,String markNames,String setName,String setTime,String setDeptname,String setDeptCode) throws ParseException{
        saveOrUpdate (priPIDs, markCodes, markNames, setName, setTime, setDeptname, setDeptCode, false);
    }

    @Override
    public void deleteInPriPID(String priPID){
        priPID = StringUtil.doSplitStringToSqlFormat (priPID, ",");
        mainMarkMapper.deleteInPriPID (priPID);
    }

    /**
     * 描述: 审核
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @param mainMark
     * @throws ParseException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void audit(MainMark mainMark,SysUserDto sysUser) throws Exception{
        mainMarkMapper.updateByMarkUuid (mainMark);

        MainMarkHis his = new MainMarkHis ();
        his.setPriPID (mainMark.getPriPID ());
        his.setAuditDeptId (mainMark.getAuditDeptId ());
        his.setAuditDeptName (mainMark.getAuditDeptName ());
        his.setAuditorDesc (mainMark.getAuditorDesc ());
        his.setAuditorId (mainMark.getAuditorId ());
        his.setAuditorName (mainMark.getAuditorName ());
        his.setAuditState (mainMark.getAuditState ());
        his.setAuditTime (mainMark.getAuditTime ());
        mainMarkHisService.updateLastByPriPID (his);

        String auditState = mainMark.getAuditState ();
        if ("2".equals (auditState)) {
            List<RegistMark> list = registMarkService.queryListByMarkUuid (mainMark.getMarkUuid ());
            // if (null != list && list.size () > 0) {
            pubScSpecialLibraryService.doNewSaveMarkToSpecialLibrary (mainMark.getPriPID (), list, "2", sysUser);
            // }

            List<MainMarkRelDto> mainMarkRelDtoList = mainMarkRelService.queryListInPriPIDAndIshis (mainMark.getPriPID (), "1", "0");
            List<RegistMark> saveList = new ArrayList<RegistMark> ();
            for ( MainMarkRelDto mainMarkRelDto : mainMarkRelDtoList ) {
                String markCode = mainMarkRelDto.getMarkCode ();
                String markName = mainMarkRelDto.getMarkName ();
                RegistMark bean = new RegistMark ();
                bean.setIDCode (markCode);
                bean.setIDName (markName);
                saveList.add (bean);
            }
            pubApprMarkRelService.saveOrUpdate (mainMark.getPriPID (), saveList, false);
        }

    }

    /**
     * 描述: 根据标签id删除对应记录
     * 
     * @author 张文男
     * @date 2017年4月1日
     * @param markUuid
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMarkUuid(String markUuid){
        Example example = new Example (MainMark.class);
        Example.Criteria criteria = example.createCriteria ();
        criteria.andEqualTo ("markUuid", markUuid);
        // 删除主表
        mainMarkMapper.deleteByExample (example);
        mainMarkRelService.deleteByMarkUuid (markUuid);

    }

    /**
     * 描述: 根据uuid获取信息
     * 
     * @author 张文男
     * @date 2017年3月30日
     * @param markUuid
     * @return
     */

    public MainMarkDto queryViewByMarkUuid(String markUuid){
        return mainMarkMapper.queryViewByMarkUuid (markUuid);
    }

    /**
     * 根据priPID获取信息
     * @param priPID
     * @return
     */
    @Override
    public MainMarkDto queryViewByMarkPriPID(String priPID){
        return mainMarkMapper.queryViewByMarkPriPID (priPID);
    }

    /** 
     * 批量插入
     * 描述: TODO
     * @author 张文男
     * @date 2017年4月6日 
     * @param list 
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(List<MainMark> list){
        for ( MainMark mainMark : list ) {
            mainMarkMapper.insertOne (mainMark);
        }
    }

    /** 
     * 描述: 保存企业与标签关系
     * @author 张文男
     * @date 2017年4月25日 
     * @param priPIDs
     * @param markCodes
     * @param markNames
     * @param setName
     * @param setTime
     * @param setDeptname
     * @param setDeptCode
     * @param isDoublySto
     * @throws ParseException 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(String priPIDs,String markCodes,String markNames,String setName,String setTime,String setDeptname,String setDeptCode,boolean isDoublySto) throws ParseException{

        // 查询已有对应关系-非历史信息
        List<MainMarkRelDto> list = null;

        if (isDoublySto) {// 如果是双随机反向生成
            list = mainMarkRelService.queryListInPriPIDAndIshisAndNotIncludeDoublySto (priPIDs, "1", "0");
        } else {
            list = mainMarkRelService.queryListInPriPIDAndIshis (priPIDs, "1", "0");
        }

        Map<String, List<MainMarkRelDto>> mainMarkRelMap = new HashMap<String, List<MainMarkRelDto>> ();

        if (null != list && list.size () > 0) {

            for ( MainMarkRelDto mainMarkRelDto : list ) {
                String priPID = mainMarkRelDto.getPriPID ();

                if (mainMarkRelMap.containsKey (priPID)) {
                    List<MainMarkRelDto> tmpMainMarkRelList = mainMarkRelMap.get (priPID);
                    tmpMainMarkRelList.add (mainMarkRelDto);
                } else {
                    List<MainMarkRelDto> mainMarkRelList = new ArrayList<MainMarkRelDto> ();
                    mainMarkRelList.add (mainMarkRelDto);
                    mainMarkRelMap.put (priPID, mainMarkRelList);
                }

            }
            // 删除对应关系
            mainMarkRelService.deleteInPriPIDAndIshis (priPIDs, "0");
        }

        // 删除主表信息
        deleteInPriPID (priPIDs);
        // 组装主表插入信息

        String[] priPIDsArr = priPIDs.split (",");
        String[] markCodesArr = markCodes.split (",");
        String[] markNamesArr = markNames.split (",");

        Map<String, String> markCodesMap = new HashMap<String, String> ();
        for ( String str : markCodesArr ) {
            if (StringUtil.isNotBlank (str)) {
                markCodesMap.put (str, str);
            }
        }

        List<MainMark> mainList = new ArrayList<MainMark> ();
        List<MainMarkHis> mainHisList = new ArrayList<MainMarkHis> ();
        List<MainMarkRel> mainMarkRelList = new ArrayList<MainMarkRel> ();

        for ( int i = 0 ; i < priPIDsArr.length ; i++ ) {
            String priPID = priPIDsArr[i];

            String markUuid = StringUtil.uuid ();
            String mainMarkHisMarkUuid = StringUtil.uuid ();

            if (isDoublySto) {// 如果是双随机反向生成
                Date dateSetTime = new SimpleDateFormat ("yyyy-MM-dd").parse (setTime);
                Date creteTime = new Date ();
                MainMark bean = new MainMark ();
                bean.setMarkUuid (markUuid);
                bean.setPriPID (priPID);
                bean.setSetName (setName);
                bean.setSetTime (dateSetTime);
                bean.setSetDeptname (setDeptname);
                bean.setCreateTime (creteTime);
                bean.setAuditState ("2");
                bean.setAuditorName (setName);
                bean.setAuditTime (dateSetTime);
                bean.setAuditDeptId (setDeptCode);
                bean.setAuditDeptName (setDeptname);
                bean.setSetDeptCode (setDeptCode);

                mainList.add (bean);

                MainMarkHis mainMarkHis = new MainMarkHis ();
                mainMarkHis.setMarkUuid (mainMarkHisMarkUuid);
                mainMarkHis.setPriPID (priPID);
                mainMarkHis.setSetName (setName);
                mainMarkHis.setSetTime (dateSetTime);
                mainMarkHis.setSetDeptname (setDeptname);
                mainMarkHis.setCreateTime (creteTime);
                mainMarkHis.setAuditState ("2");
                mainMarkHis.setAuditorName (setName);
                mainMarkHis.setAuditTime (dateSetTime);
                mainMarkHis.setAuditDeptId (setDeptCode);
                mainMarkHis.setAuditDeptName (setDeptname);
                mainMarkHis.setAuditorDesc ("同意");
                mainMarkHis.setAuditorId (null);// 暂时用不上
                mainHisList.add (mainMarkHis);

            } else {
                Date dateSetTime = new SimpleDateFormat ("yyyy-MM-dd").parse (setTime);
                Date creteTime = new Date ();
                MainMark bean = new MainMark ();

                bean.setMarkUuid (markUuid);
                bean.setPriPID (priPID);
                bean.setSetName (setName);
                bean.setSetTime (dateSetTime);
                bean.setSetDeptname (setDeptname);
                bean.setCreateTime (creteTime);
                bean.setAuditState ("1");
                bean.setSetDeptCode (setDeptCode);

                mainList.add (bean);

                MainMarkHis mainMarkHis = new MainMarkHis ();
                mainMarkHis.setMarkUuid (mainMarkHisMarkUuid);
                mainMarkHis.setPriPID (priPID);
                mainMarkHis.setSetName (setName);
                mainMarkHis.setSetTime (dateSetTime);
                mainMarkHis.setSetDeptname (setDeptname);
                mainMarkHis.setCreateTime (creteTime);
                mainMarkHis.setAuditState ("1");
                mainHisList.add (mainMarkHis);
            }

            Map<String, String> cMarkCodeMap = new HashMap<String, String> ();
            if (mainMarkRelMap.containsKey (priPID)) {
                List<MainMarkRelDto> mainMarkRelDtoList = mainMarkRelMap.get (priPID);

                for ( MainMarkRelDto mainMarkRelDto : mainMarkRelDtoList ) {

                    String cMarkCode = mainMarkRelDto.getMarkCode ();
                    String cMarkName = mainMarkRelDto.getMarkName ();

                    // 获取原始标签
                    MainMarkRel mainMarkRel2 = new MainMarkRel ();
                    mainMarkRel2.setPriPID (priPID);
                    mainMarkRel2.setMarkUuid (markUuid);
                    mainMarkRel2.setMarkCode (cMarkCode);
                    mainMarkRel2.setMarkName (cMarkName);
                    mainMarkRel2.setType ("2");
                    mainMarkRel2.setIshis ("0");
                    mainMarkRelList.add (mainMarkRel2);

                    // 历史- 获取原始标签
                    MainMarkRel mainMarkRelHis2 = new MainMarkRel ();
                    mainMarkRelHis2.setPriPID (priPID);
                    mainMarkRelHis2.setMarkUuid (mainMarkHisMarkUuid);
                    mainMarkRelHis2.setMarkCode (cMarkCode);
                    mainMarkRelHis2.setMarkName (cMarkName);
                    mainMarkRelHis2.setType ("2");
                    mainMarkRelHis2.setIshis ("1");
                    mainMarkRelList.add (mainMarkRelHis2);

                    // 获取去除标签
                    if (!markCodesMap.containsKey (cMarkCode)) {
                        // 非历史
                        MainMarkRel mainMarkRel3 = new MainMarkRel ();
                        mainMarkRel3.setPriPID (priPID);
                        mainMarkRel3.setMarkUuid (markUuid);
                        mainMarkRel3.setMarkCode (cMarkCode);
                        mainMarkRel3.setMarkName (cMarkName);
                        mainMarkRel3.setType ("3");
                        mainMarkRel3.setIshis ("0");
                        mainMarkRelList.add (mainMarkRel3);

                        // 历史
                        MainMarkRel mainMarkRelHis3 = new MainMarkRel ();
                        mainMarkRelHis3.setPriPID (priPID);
                        mainMarkRelHis3.setMarkUuid (mainMarkHisMarkUuid);
                        mainMarkRelHis3.setMarkCode (cMarkCode);
                        mainMarkRelHis3.setMarkName (cMarkName);
                        mainMarkRelHis3.setType ("3");
                        mainMarkRelHis3.setIshis ("1");
                        mainMarkRelList.add (mainMarkRelHis3);
                    }

                    cMarkCodeMap.put (cMarkCode, cMarkName);
                }
            }

            for ( int j = 0 ; j < markCodesArr.length ; j++ ) {
                String markCode = markCodesArr[j];
                String markName = markNamesArr[j];

                // 当前关系不为空才插入数据
                if (StringUtil.isNotBlank (markCode)) {
                    // 当前关系插入
                    MainMarkRel mainMarkRel = new MainMarkRel ();
                    mainMarkRel.setPriPID (priPID);
                    mainMarkRel.setMarkUuid (markUuid);
                    mainMarkRel.setMarkCode (markCode);
                    mainMarkRel.setMarkName (markName);
                    mainMarkRel.setType ("1");
                    mainMarkRel.setIshis ("0");
                    mainMarkRelList.add (mainMarkRel);
                }

                // 获取新增标签
                if (!cMarkCodeMap.containsKey (markCode)) {
                    MainMarkRel mainMarkRel4 = new MainMarkRel ();
                    mainMarkRel4.setPriPID (priPID);
                    mainMarkRel4.setMarkUuid (markUuid);
                    mainMarkRel4.setMarkCode (markCode);
                    mainMarkRel4.setMarkName (markName);
                    mainMarkRel4.setType ("4");
                    mainMarkRel4.setIshis ("0");
                    mainMarkRelList.add (mainMarkRel4);

                    MainMarkRel mainMarkRel4His = new MainMarkRel ();
                    mainMarkRel4His.setPriPID (priPID);
                    mainMarkRel4His.setMarkUuid (mainMarkHisMarkUuid);
                    mainMarkRel4His.setMarkCode (markCode);
                    mainMarkRel4His.setMarkName (markName);
                    mainMarkRel4His.setType ("4");
                    mainMarkRel4His.setIshis ("1");
                    mainMarkRelList.add (mainMarkRel4His);
                }
            }

        }
        // 插入主表信息
        for ( MainMark mainMark : mainList ) {
            mainMarkMapper.insertOne (mainMark);
        }
        for ( MainMarkHis mainMarkHis : mainHisList ) {
            // 插入历史信息
            mainMarkHisService.insertOne (mainMarkHis);
        }
        for ( MainMarkRel mainMarkRel : mainMarkRelList ) {
            // 插入关系表
            mainMarkRelService.insertOne (mainMarkRel);
        }
    }

    /** 
     * 描述: 双随机反向绑定标签
     * @author 张文男
     * @date 2017年4月25日 
     * @param priPIDs
     * @param list
     * @param user
     * @throws Exception 
     */

    public void saveOrUpdateForDoublySto(String priPIDs,List<RegistMark> list,SysUserDto user) throws Exception{
        pubApprMarkRelService.saveOrUpdate (priPIDs, list, true);
    }
    
    /**
     * 描述: 判断是否带有食品仓储标签企业
     * @author yujingwei
     * @date 2017年5月24日
     * @param priPID
     * @return boolean
     */
	public boolean doJudgeIsFoodStorageEnt(String priPID) throws Exception{
		Example example = new Example(MainMarkRel.class);
		example.createCriteria()
		.andEqualTo("markName", "杭州-食品仓储企业")
		.andEqualTo("ishis", "0")
		.andEqualTo("priPID", priPID);
		List<MainMarkRel> mainMarkRels = mainMarkRelMapper.selectByExample(example);
		if(mainMarkRels !=null && mainMarkRels.size() > 0){
			return true;
		}
		return false;
	}
    

}