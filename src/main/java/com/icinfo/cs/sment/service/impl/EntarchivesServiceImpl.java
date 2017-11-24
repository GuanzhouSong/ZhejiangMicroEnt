/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.icinfo.cs.rpt.rptmapper.RptSmBaseinfoMapper;
import com.icinfo.cs.rpt.rptservice.IRptSmBaseinfoService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.sment.dto.EntarchivesDto;
import com.icinfo.cs.sment.mapper.EntarchivesMapper;
import com.icinfo.cs.sment.model.Entarchives;
import com.icinfo.cs.sment.model.EntarchivesAdjust;
import com.icinfo.cs.sment.model.EntarchivesHelp;
import com.icinfo.cs.sment.model.EntarchivesHis;
import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.cs.sment.model.SmBusEntarchivesArea;
import com.icinfo.cs.sment.service.IEntarchivesAdjustService;
import com.icinfo.cs.sment.service.IEntarchivesHelpService;
import com.icinfo.cs.sment.service.IEntarchivesHisService;
import com.icinfo.cs.sment.service.IEntarchivesOperateService;
import com.icinfo.cs.sment.service.IEntarchivesService;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.cs.sment.service.ISmBusEntarchivesAreaService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Service
public class EntarchivesServiceImpl extends MyBatisServiceSupport implements IEntarchivesService {

    @Autowired
    private EntarchivesMapper            entarchivesMapper;

    @Autowired
    private IEntarchivesOperateService   entarchivesOperateService;

    @Autowired
    private IEntarchivesAdjustService    entarchivesAdjustService;

    @Autowired
    private IEntarchivesHelpService      entarchivesHelpService;

    @Autowired
    private IEntarchivesHisService       entarchivesHisService;

    @Autowired
    private ISmBusEntarchivesAreaService smBusEntarchivesAreaService;

    @Autowired
    private IPubEppasswordService        pubEppasswordService;
    
    @Autowired
    private IRptSmBaseinfoService           smBaseinfoService;
    @Autowired
    private RptSmBaseinfoMapper rptSmBaseinfoMapper;

    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年4月27日 
     * @param bean 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(EntarchivesDto bean,SysUserDto sysUser) throws IllegalAccessException,InstantiationException,InvocationTargetException,NoSuchMethodException{
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        bean.setSetDeptCode (sysSetDeptCode);
        
        String uid = bean.getUID ();
        Date nowDate = new Date ();
        bean.setUpdateTime (nowDate);

        EntarchivesOperate entarchivesOperate = bean.getEntarchivesOperate ();
        if (null != entarchivesOperate) {
            String priPID = bean.getPriPID ();
            entarchivesOperateService.deleteBy (priPID, entarchivesOperate.getYear ());
            entarchivesOperateService.insert (entarchivesOperate);
        }

        if (StringUtil.isNotBlank (uid)) {// 修改
            EntarchivesAdjust entarchivesAdjust = bean.getEntarchivesAdjust ();
            entarchivesAdjustService.insert (entarchivesAdjust);
            bean = saveOrUpdateForHelp (bean);
            updateByUID (bean);
        } else {
            String[] priPIDsArr = bean.getPriPIDs ().split (",");

            for ( String tmpPriPID : priPIDsArr ) {
                if (priPIDsArr.length > 1) {// 如果是批量新增则需要获取对应的帮扶信息

                    setEntarchivesDtoForHelp (bean, tmpPriPID);
                }
                bean = saveOrUpdateForHelp (bean);
                Entarchives insertBean = (Entarchives) BeanUtils.cloneBean (bean);
                insertBean.setPriPID (tmpPriPID);
                insertBean.setUID (StringUtil.uuid ());
                insertBean.setCreateTime (nowDate);
                deleteByPriPID (tmpPriPID);
                entarchivesMapper.insert (insertBean);
                EntarchivesHis entarchivesHis = entarchivesHisService.queryByPriPID (tmpPriPID);//如果是已注销过的企业则添加调整信息
                if(null != entarchivesHis){
                    EntarchivesAdjust entarchivesAdjust = new EntarchivesAdjust ();
                    entarchivesAdjust.setPriPID (tmpPriPID);
                    entarchivesAdjust.setAdjustReason ("重新入库");
                    entarchivesAdjust.setAdjustUserId (sysUser.getId ());
                    entarchivesAdjust.setAdjustUserName(sysUser.getRealName ());
                    entarchivesAdjust.setAdjustDeptId (sysUser.getDepartMent ().getDeptDID ());
                    entarchivesAdjust.setAdjustDeptName (sysUser.getDepartMent ().getDeptName ());
                    entarchivesAdjust.setAdjustTime (nowDate);
                    entarchivesAdjust.setAdjustState ("1");
                    entarchivesAdjustService.insert (entarchivesAdjust);
                    entarchivesHisService.deleteByPriPID (tmpPriPID);
                }
            }

        }

    }

    /** 
     * 描述: 保存修改帮扶信息
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    public EntarchivesDto saveOrUpdateForHelp(EntarchivesDto bean){
        List<EntarchivesHelp> entarchivesHelpList = bean.getEntarchivesHelpList ();
        int helpNum = 0;
        int isHelpNum = 0;
        if (null != entarchivesHelpList && entarchivesHelpList.size () > 0) {

            String priPID = entarchivesHelpList.get (0).getPriPID ();
            Integer year = entarchivesHelpList.get (0).getYear ();
            entarchivesHelpService.deleteBy (priPID, year);
            for ( EntarchivesHelp entarchivesHelp : entarchivesHelpList ) {
                if (null != entarchivesHelp) {
                    Date helpTime = entarchivesHelp.getHelpTime ();
                    String helpCount = entarchivesHelp.getHelpContent ();

                    if (null != helpTime || StringUtil.isNotBlank (helpCount)) {
                        isHelpNum++;
                    }
                    entarchivesHelp.setCreateTime (new Date ());
                    entarchivesHelpService.insert (entarchivesHelp);
                    helpNum++;
                }
            }
        }

        String helpState = "1";
        if (helpNum == 0) {// 无需求
            helpState = "1";
        } else if (helpNum != 0 && isHelpNum == 0) {// 未帮扶
            helpState = "2";
        } else if (helpNum != 0 && isHelpNum < helpNum) {// 部分帮扶
            helpState = "3";
        } else if (helpNum != 0 && isHelpNum == helpNum) {// 已帮扶
            helpState = "4";
        }
        bean.setHelpState (helpState);
        bean.setHelpNum (isHelpNum);
        bean.setHelpTypeNum (helpNum);
        return bean;
    }

    /** 
     * 描述: 用于批量新增获取历史帮扶信息
     * @author 张文男
     * @date 2017年5月11日 
     * @param bean
     * @param priPID 
     */

    private void setEntarchivesDtoForHelp(EntarchivesDto bean,String priPID){
        List<EntarchivesHelp> entarchivesHelpList = entarchivesHelpService.queryEntarchivesHelpListBy (priPID, Integer.parseInt (DateUtil.getCurrentYear ()));
        bean.setEntarchivesHelpList (entarchivesHelpList);
    }

    @Transactional(rollbackFor = Exception.class)
    private void saveOrUpdateForHelpIsTransactional(EntarchivesDto bean){

        EntarchivesDto dto = saveOrUpdateForHelp (bean);
        Entarchives nowEntarchives = queryEntarchivesByPriPID (bean.getPriPID ());
        nowEntarchives.setHelpState (dto.getHelpState ());
        nowEntarchives.setHelpNum (dto.getHelpNum ());
        nowEntarchives.setHelpTypeNum (dto.getHelpTypeNum ());
        updateByUID (nowEntarchives);
    }

    private EntarchivesDto saveOrUpdateForHelpNoTransactional(EntarchivesDto bean){
        return saveOrUpdateForHelp (bean);
    }

    /** 
     * 描述: 保存修改帮扶信息-是否开启事务
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean
     * @param isTransactional 
     */

    public void saveOrUpdateForHelp(EntarchivesDto bean,boolean isTransactional){
        if (isTransactional) {
            saveOrUpdateForHelpIsTransactional (bean);
        } else {
            saveOrUpdateForHelpNoTransactional (bean);
        }
    }

    /** 
     * 描述: 根据uuid更新数据
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */

    public void updateByUID(Entarchives bean){
        Example example = new Example (Entarchives.class);
        example.createCriteria ().andEqualTo ("UID", bean.getUID ());
        entarchivesMapper.updateByExample (bean, example);
    }

    /** 
     * 描述: 根据uid获取对应数据
     * @author 张文男
     * @date 2017年4月27日 
     * @param uid
     * @return 
     */
    @Override
    public EntarchivesDto queryBeanByUID(String uid){
        Example example = new Example (Entarchives.class);
        example.createCriteria ().andEqualTo ("UID", uid);
        List<Entarchives> list = entarchivesMapper.selectByExample (example);
        if (list.size () == 1) { return (EntarchivesDto) list.get (0); }
        return null;
    }

    /** 
     * 描述: 根据pripid获取信息
     * @author 张文男
     * @date 2017年5月4日 
     * @param priPID
     * @return 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */

    public EntarchivesDto queryEntarchivesDtoByPriPID(String priPID) throws IllegalAccessException,InvocationTargetException{
        Entarchives bean = queryEntarchivesByPriPID (priPID);
        if (null != bean) {
            EntarchivesDto dto = new EntarchivesDto ();
            BeanUtils.copyProperties (dto, bean);
            String tsxz = dto.getTsxz ();
            String kjfhy = dto.getKjfhy ();
            String kjdsy = dto.getKjdsy ();
            String Xwqyy = dto.getXwqyy();
            String qt = dto.getQt ();
            String zckj = dto.getZckj ();

            String[] tsxzArr = StringUtil.split (tsxz, ",");
            String[] kjfhyArr = StringUtil.split (kjfhy, ",");
            String[] kjdsyArr = StringUtil.split (kjdsy, ",");
            String[] xwqyyArr = StringUtil.split (Xwqyy, ",");
            String[] qtArr = StringUtil.split (qt, ",");
            String[] zckjArr = StringUtil.split (zckj, ",");

            String tsxzName = "";
            String kjfhyName = "";
            String kjdsyName = "";
            String qtName = "";
            String zckjName = "";
            String xwqyyName = "";

            if (null != tsxzArr) {
                for ( int i = 0 ; i < tsxzArr.length ; i++ ) {

                    SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (tsxzArr[i]);
                    if (null != smBusEntarchivesArea) {
                        tsxzName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
                    }
                }
            }
            if (null != kjfhyArr) {
                for ( int i = 0 ; i < kjfhyArr.length ; i++ ) {
                    SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (kjfhyArr[i]);

                    if (null != smBusEntarchivesArea) {
                        kjfhyName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
                    }
                }
            }
            if (null != kjdsyArr) {
                for ( int i = 0 ; i < kjdsyArr.length ; i++ ) {
                    SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (kjdsyArr[i]);

                    if (null != smBusEntarchivesArea) {
                        kjdsyName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
                    }
                }
            }
            if (null != xwqyyArr) {
            	for ( int i = 0 ; i < xwqyyArr.length ; i++ ) {
            		SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (xwqyyArr[i]);
            		
            		if (null != smBusEntarchivesArea) {
            			xwqyyName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
            		}
            	}
            }
            if (null != qtArr) {
                for ( int i = 0 ; i < qtArr.length ; i++ ) {
                    SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (qtArr[i]);

                    if (null != smBusEntarchivesArea) {
                        qtName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
                    }
                }
            }
            if (null != zckjArr) {
                for ( int i = 0 ; i < zckjArr.length ; i++ ) {
                    SmBusEntarchivesArea smBusEntarchivesArea = smBusEntarchivesAreaService.queryListByAreaCode (zckjArr[i]);

                    if (null != smBusEntarchivesArea) {
                        zckjName += (i > 0 ? "," : "") + smBusEntarchivesArea.getAreaName ();
                    }
                }
            }

            dto.setTsxzName (tsxzName);
            dto.setKjfhyName (kjfhyName);
            dto.setKjdsyName (kjdsyName);
            dto.setXwqyyName(xwqyyName);
            dto.setQtName (qtName);
            dto.setZckjName (zckjName);
            return dto;
        }
        return null;
    }

    /** 
     * 描述: 根据pripid获取信息
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @return 
     */

    public Entarchives queryEntarchivesByPriPID(String priPID){
        Example example = new Example (Entarchives.class);
        example.createCriteria ().andEqualTo ("priPID", priPID);
        List<Entarchives> list = entarchivesMapper.selectByExample (example);
        if (null != list && list.size () > 0) { return list.get (0); }
        return null;
    }

    /** 
     * 描述: 根据企业id删除培育库数据
     * @author 张文男
     * @date 2017年5月5日 
     * @param priPID 
     */

    public void deleteByPriPID(String priPID){
        Example example = new Example (Entarchives.class);
        example.createCriteria ().andEqualTo ("priPID", priPID);
        entarchivesMapper.deleteByExample (example);
    }

    /** 
     * 描述: 移除培育库
     * @author 张文男
     * @date 2017年5月5日 
     * @param bean
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException 
     */

    @Transactional(rollbackFor = Exception.class)
    public void remove(EntarchivesAdjust bean) throws IllegalAccessException,InstantiationException,InvocationTargetException,NoSuchMethodException{
        String priPID = bean.getPriPID ();
        EntarchivesHis his = entarchivesHisService.queryByPriPID (priPID);
        if (null != his) {// 已被移除，则抛出异常
            throw new RuntimeException ("数据已移除");
        }
        Date nowdate = new Date ();
        bean.setCreateTime (nowdate);
        bean.setAdjustTime (nowdate);
        bean.setAdjustState ("0");// 移除
        entarchivesAdjustService.insert (bean);

        Entarchives entarchives = queryEntarchivesByPriPID (priPID);
        EntarchivesHis entarchivesHis = new EntarchivesHis ();
        BeanUtils.copyProperties (entarchivesHis, entarchives);
        entarchivesHis.setRemoveTime (nowdate);
        entarchivesHis.setRemoveTypeCode (bean.getAdjustTypeCode ());
        entarchivesHis.setRemoveTypeName (bean.getAdjustTypeName ());
        entarchivesHisService.insert (entarchivesHis);
        // deleteByPriPID (priPID);
    }

    /** 
     * 描述: 初始化负责人 和联络员
     * 
     * @author zhuyong
     * @date 2017年5月4日
     */
    public EntarchivesDto initEntarchivesDto(EntarchivesDto dto) throws Exception{
        List<String> list = smBaseinfoService.selectTypeByPriPID (dto.getPriPID ());
        if(null != list && list.size () >0){
            dto.setIndustryType (StringUtils.join(list,","));
        }
        
        List<String> priPidList = new ArrayList<String> ();
        priPidList.add (dto.getPriPID ());
        List<PubEppassword> pubEppasswordList = pubEppasswordService.selectLiaInfo (priPidList, 0);
        if (pubEppasswordList == null || pubEppasswordList.size () == 0) return dto;

        PubEppassword pubEppassword = pubEppasswordList.get (0);
        if (StringUtils.isBlank (dto.getEntPrincipal ()) && StringUtils.isBlank (dto.getEntPrincipalTel ()) && StringUtils.isBlank (dto.getEntContact ()) && StringUtils.isBlank (dto.getEntContactTel ())) {
            dto.setEntPrincipal (pubEppassword.getLerep ());
            dto.setEntPrincipalTel (pubEppassword.getLerepphone ());
            dto.setEntContact (pubEppassword.getLianame ());
            dto.setEntContactTel (pubEppassword.getTel ());
        }
        
        return dto;
    }
    
    
    private int count(String cultivationTypeCode,String setDeptCode){
        Example example = new Example (Entarchives.class);
        Criteria c = example.createCriteria ();
        c.andEqualTo ("cultivationTypeCode", cultivationTypeCode);
        c.andLike ("setDeptCode", setDeptCode + "%");
        int count = entarchivesMapper.selectCountByExample (example);
        return count;
    }

    private int countByHelp(String helpState,String setDeptCode){
        Example example = new Example (Entarchives.class);
        Criteria c = example.createCriteria ();
        if (StringUtil.isNotBlank (helpState)) {
            c.andIn ("helpState", Arrays.asList (helpState.split (",")));
        }
        c.andLike ("setDeptCode", setDeptCode + "%");
        int count = entarchivesMapper.selectCountByExample (example);
        return count;
    }

    /** 
     * 描述: 根据用户部门code、培育库类型，获取待添加培育库数量
     * @author 张文男
     * @date 2017年6月15日 
     * @param sysUser
     * @param cultivationTypeCode
     * @return 
     */

    public int count(SysUserDto sysUser,String cultivationTypeCode){
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }

        int count = count (cultivationTypeCode, sysSetDeptCode);
        return count;

    }

    /** 
     * 描述: 统计帮扶信息
     * @author 张文男
     * @date 2017年6月20日 
     * @param sysUser
     * @param helpState
     * @return 
     */

    public int countByHelp(SysUserDto sysUser, PageRequest request){
        return rptSmBaseinfoMapper.countByHelp(request.getParams());
    }
    
    /** 
     * 描述: 统计入库企业违法违规数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countWfwgBySetDeptCode(SysUserDto sysUser){
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }
        return entarchivesMapper.countWfwgBySetDeptCode (sysSetDeptCode);
    }

    /** 
     * 描述: 统计入库企业经营异常数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countJyycBySetDeptCode(SysUserDto sysUser){
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }
        return entarchivesMapper.countJyycBySetDeptCode (sysSetDeptCode);
    }
    
    /** 
     * 描述:  统计入库企业上规升级数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param map
     * @return 
     */
    
    public Long countSgsjBySetDeptCode(SysUserDto sysUser){
        // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }
        return entarchivesMapper.countSgsjBySetDeptCode (sysSetDeptCode);
    }
    
    /** 
     * 描述: 统计入库企业经营下降20%数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param setDeptCode
     * @return 
     */
    
    public Long  countJyxjBySetDeptCode(SysUserDto sysUser){
     // 警示协同的地址 默认警示
        String sysSetDeptCode = sysUser.getDepartMent ().getDeptCode ().substring (0, 6);
        if (sysSetDeptCode.equals ("330000")) {// 省局
            sysSetDeptCode = "33";
        } else {
            sysSetDeptCode = sysSetDeptCode.substring (0, 4);
        }
        return entarchivesMapper.countJyxjBySetDeptCode (sysSetDeptCode);
    }
    
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto cultivationTypeScount(Map<String, Object> map) throws Exception{
    	return entarchivesMapper.cultivationTypeScount(map);
    }
    /**
     * 
     * 描述: 统计培育库企业区域分类
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto qyflCount(Map<String, Object> map) throws Exception{
    	return entarchivesMapper.qyflCount(map);
    }
    /**
     * 
     * 描述: 统计培育库企业八大产业
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto industryTypeCount(Map<String, Object> map) throws Exception{
    	return entarchivesMapper.industryTypeCount(map);
    }
    /**
     * 
     * 描述: 统计培育库企业创业人群
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto entCrowdCodeCount(Map<String, Object> map) throws Exception{
    	return entarchivesMapper.entCrowdCodeCount(map);
    }
    
    /**
     * 
     * 描述: 统计培育库企业营业总收入
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public List<EntarchivesDto> vendIncCount(Map<String, Object> map) throws Exception{
    	return entarchivesMapper.vendIncCount(map);
    };    
    
    
}