/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import scala.inline;

import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.model.CodeInDusTry;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.cs.base.service.ICodeInDusTryService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.util.JsonDateValueProcessor;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.mapper.SmBaseinfoMapper;
import com.icinfo.cs.sment.model.SmBaseinfo;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import cn.gov.zj.gsj.v2.api.GsjClient;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertRequest;
import cn.gov.zj.gsj.v2.obj.entity.IndexInsertResponse;
import net.sf.json.JsonConfig;

/**
 * 描述: cs_sm_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Service
public class SmBaseinfoServiceImpl extends MyBatisServiceSupport implements ISmBaseinfoService {

    private static final Logger  logger = LoggerFactory.getLogger (SmBaseinfoServiceImpl.class);

    @Autowired
    SmBaseinfoMapper             smBaseinfoMapper;

    @Autowired
    GsjClient                    client;

    @Value("${cloudModel}")
    private String               cloudModel;                                                    // 云平台模式 Y：开启 N：不开启

    @Value("${es.smentsearchindex}")
    private String               smEntSearchIndex;                                              // 小微企业查询索引名称

    @Autowired
    private ICodeInDusTryService codeInDusTryService;

    @Autowired
    private ICodeEntTypeService  codeEntTypeService;

    private long                 total;

    /**
     * 描述: 培育库分页列表
     * 
     * @author 张文男
     * @date 2017年5月3日
     * @param request
     * @throws Exception 
     */
    public PageResponse<SmBaseinfoDto> queryPageListForEntarchives(PageRequest request) throws Exception{
        // PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> queryMap = request.getParams ();
        String industryCo = StringUtil.doSplitStringToSqlFormat (queryMap.get ("industryCo").toString (), ",");
        String entType = StringUtil.doSplitStringToSqlFormat (queryMap.get ("entType").toString (), ",");
        String regOrg = StringUtil.doSplitStringToSqlFormat (queryMap.get ("regOrg").toString (), ",");
        String localAdm = StringUtil.doSplitStringToSqlFormat (queryMap.get ("localAdm").toString (), ",");

        queryMap.put ("industryCo", industryCo);
        queryMap.put ("entType", entType);
        queryMap.put ("regOrg", regOrg);
        queryMap.put ("localAdm", localAdm);

        int pageSize = request.getLength ();
        queryMap.put ("numStart", (request.getPageNum () - 1) * pageSize);
        queryMap.put ("pageSize", pageSize);

        List<SmBaseinfoDto> newList = new ArrayList<SmBaseinfoDto> ();
        final CountDownLatch countDownLatch = new CountDownLatch (2);

        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    total = smBaseinfoMapper.queryPageListForEntarchivesCount (request.getParams ());
                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    List<SmBaseinfoDto> list = smBaseinfoMapper.queryPageListForEntarchives (request.getParams ());
                    for ( SmBaseinfoDto smBaseinfoDto : list ) {
                        String tmpIndustryCo = smBaseinfoDto.getIndustryCo ();
                        String tmpEntType = smBaseinfoDto.getEntType ();

                        CodeInDusTry codeInDusTry = codeInDusTryService.selectCodeInDusTryByCode (tmpIndustryCo);
                        CodeEntType codeEntType = codeEntTypeService.selectCodeEntTypeByCode (tmpEntType);
                        if (null != codeInDusTry) {
                            smBaseinfoDto.setIndustryCoName (codeInDusTry.getContent ());
                        }
                        if (null != codeEntType) {
                            smBaseinfoDto.setEntTypeName (codeEntType.getContent ());
                        }
                        newList.add (smBaseinfoDto);
                    }

                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }

            }
        }).start ();

        countDownLatch.await ();
        return new PageResponse<SmBaseinfoDto> (newList,total,request);
    }

    /**
     * 描述: 获取企业、培育库分页列表
     * 
     * @author 张文男
     * @date 2017年5月4日
     * @param params
     * @return
     */

    public List<SmBaseinfoDto> queryEntAndEntarchivesPageList(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        Map<String, Object> queryMap = request.getParams ();
        String industryCo = StringUtil.doSplitStringToSqlFormat (queryMap.get ("industryCo").toString (), ",");
        String entType = StringUtil.doSplitStringToSqlFormat (queryMap.get ("entType").toString (), ",");
        String regOrg = StringUtil.doSplitStringToSqlFormat (queryMap.get ("regOrg").toString (), ",");
        String localAdm = StringUtil.doSplitStringToSqlFormat (queryMap.get ("localAdm").toString (), ",");

        queryMap.put ("industryCo", industryCo);
        queryMap.put ("entType", entType);
        queryMap.put ("regOrg", regOrg);
        queryMap.put ("localAdm", localAdm);

        String areaTypeCode = queryMap.get ("areaTypeCode").toString ().replaceAll (",", "|");
        queryMap.put ("areaTypeCode", areaTypeCode);

        return smBaseinfoMapper.queryEntAndEntarchivesPageList (request.getParams ());
    }

    /**
     * 根据pripid分别从cs_mid_baseinfo和sm_baseinfo中取出数据
     * 
     * @author zhuyong
     * @param priPID
     * @return
     * @throws Exception
     */
    public List<SmBaseinfoDto> selectOneForCompare(String priPID) throws Exception{
        return smBaseinfoMapper.selectOneForCompare (priPID);
    }

    /**
     * 从cs_mid_baseinfo查询出结果插入到sm_baseinfo中去
     * 
     * @author zhuyong
     * @param priPID
     * @throws Exception
     */
    public void insertOneFromCsMidBaseinfo(String priPID,String isSment,String smentReason) throws Exception{
        Map<String, Object> qryMap = new HashMap<String, Object> ();
        qryMap.put ("priPID", priPID);
        qryMap.put ("isSment", isSment);
        qryMap.put ("smentReason", smentReason);
        smBaseinfoMapper.insertOneFromCsMidBaseinfo (qryMap);
    }

    /**
     * 描述: 根据企业id获取对象
     * 
     * @author 张文男
     * @date 2017年5月5日
     * @param priPID
     * @return
     */
    public SmBaseinfoDto queryBeanByPriPID(String priPID){
        return smBaseinfoMapper.queryBeanByPriPID (priPID);
    }

    @Override
    public Page<SmBaseinfoDto> doGetSmBaseinfoList(PageRequest request){
        Map<String, Object> map = request.getParams ();
        if (map.get ("regState") != null) {
            map.put ("regState", StringUtil.doSplitStringToSqlFormat (map.get ("regState").toString (), ","));
        }
        if (map.get ("industryCo") != null) {
            map.put ("industryCo", StringUtil.doSplitStringToSqlFormat (map.get ("industryCo").toString (), ","));
        }
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        return smBaseinfoMapper.queryPageResult (map);
    }

    @Override
    public List<SmBaseinfoDto> selectListByCondition(String condition){
        return smBaseinfoMapper.selectListByCondition (condition);
    }

    @Override
    public int queryIncreCount(Map<String, Object> qryMap){
        return smBaseinfoMapper.selectIncreCount (qryMap);
    }

    @Override
    public List<SmBaseinfoDto> queryIncreData(Map<String, Object> qryMap){
        return smBaseinfoMapper.selectIncreData (qryMap);
    }

    @Override
    public void doInsertSmEntDataToGsById(){
        JsonConfig jsonConfig = new JsonConfig ();
        jsonConfig.registerJsonValueProcessor (Date.class, new JsonDateValueProcessor ());
        long time1 = System.currentTimeMillis ();

        int perCount = 20000;// 每次导入数量
        int totalCount = 0;
        int total = getMaxId ();
        if (total % perCount == 0) {
            totalCount = total / perCount;
        }
        totalCount = (total / perCount) + 1;// 一共需导入次数

        try {
            IndexInsertRequest request = new IndexInsertRequest ();
            IndexInsertResponse response = null;
            String beanStr = "";// 存储bean转成的json字符串

            int start = 0;
            for ( int current = 0 ; current <= totalCount ; current++ ) {// 将数据库数据生成至索引中去
                logger.info ("小微企业信息查询全量生成索引 共循环{}次, 当前循环第{}次, 一次导入{}条", totalCount, current, perCount);
                start = current * perCount;
                List<SmBaseinfoDto> dataList = doGetListById (start);

                request.setIndex (smEntSearchIndex);// 索引名
                request.setType ("single");// single是1条1插，batch是累积到1000条才插入

                for ( SmBaseinfoDto data : dataList ) {
                    beanStr = net.sf.json.JSONArray.fromObject (data, jsonConfig).toString ().replace ("[", "").replace ("]", "");
                    request.setKey (data.getPriPID ());// 主键_ID的值
                    request.setJsonData (beanStr);// 要插入的字段名和字段值
                    response = client.excute (request);

                    if (response.getErrorCode ().isEmpty ()) {} else {
                        logger.info ("errorcode {},message {}", response.getErrorCode (), response.getMessage ());
                    }
                }
            }
        } catch (Exception e) {
            logger.info ("exception {}", e, e.getMessage ());
        }
        long time2 = System.currentTimeMillis ();
        logger.info ("小微企业信息全量生成索引 耗时:{}ms......", (time2 - time1));
    }

    private List<SmBaseinfoDto> doGetListById(int start){
        Map<String, Object> paramMap = new HashMap<String, Object> ();
        paramMap.put ("start", start);
        paramMap.put ("end", start + 20000);
        return smBaseinfoMapper.selectIndexListById (paramMap);
    }

    /**
     * 描述：获取小微最大id
     * 
     * @author baifangfang
     * @date 2017年5月9日
     * @return
     */
    private int getMaxId(){
        return smBaseinfoMapper.selectMaxId ();
    }

    @Override
    public List<SmBaseinfoDto> queryPageResult(PageRequest request){
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        return smBaseinfoMapper.selectYrInfoListByPriPID (request.getParams ());
    }

    /**
     * 删除
     * 
     * @author zhuyong
     * @param priPID
     * @throws Exception
     */
    @Override
    public void deleteByPriPID(String priPID) throws Exception{
        Example example = new Example (SmBaseinfo.class);
        example.createCriteria ().andEqualTo ("priPID", priPID);
        smBaseinfoMapper.deleteByExample (example);
    }

    /**
     * 
     * 描述: 小微监测年报信息统计（普通统计）
     * @auther gaojinling
     * @date 2017年5月5日 
     * @param request
     * @return
     * @throws Exception
     */
    public List<SmBaseinfoDto> selectYrSmNormalCount(PageRequest request) throws Exception{
        try {
            Map<String, Object> searchMap = request.getParams ();
            if (searchMap != null && searchMap.containsKey ("startCheckPushDate") && searchMap.containsKey ("endCheckPushDate")) {
                if (searchMap.get ("startCheckPushDate") != null && StringUtil.isNotBlank (searchMap.get ("startCheckPushDate").toString ())) {
                    searchMap.put ("startCheckPushDate", StringUtil.replace (searchMap.get ("startCheckPushDate").toString (), "-", ""));
                    searchMap.put ("endCheckPushDate", StringUtil.replace (searchMap.get ("endCheckPushDate").toString (), "-", ""));
                } else {
                    searchMap.put ("startCheckPushDate", searchMap.get ("rptyear").toString () + searchMap.get ("rptbeginmouth").toString ());
                }
            }
            if (searchMap != null && searchMap.containsKey ("industryCo") && searchMap.get ("industryCo") != null) { // 行业门类
                searchMap.put ("industryCo", StringUtil.doSplitStringToSqlFormat (searchMap.get ("industryCo").toString (), ","));
            }
            if (searchMap != null && searchMap.containsKey ("thrIndustry") && searchMap.get ("thrIndustry") != null) { // 三大产业
                searchMap.put ("thrIndustry", StringUtil.doSplitStringToSqlFormat (searchMap.get ("thrIndustry").toString (), ","));
            }
            PageHelper.startPage (request.getPageNum (), 20000);
            return smBaseinfoMapper.selectYrSmNormalCount (searchMap);
        } catch (Exception e) {
            e.printStackTrace ();
            logger.error ("exception {}", "小微监测年报信息统计（普通统计）!");
            throw new BusinessException ("小微监测年报信息统计（普通统计）!");
        }
    }

    /**
     * 
     * 描述: 小微监测年报信息统计（八大重点产业统计）
     * @auther gaojinling
     * @date 2017年5月5日 
     * @param request
     * @return
     * @throws Exception
     */
    public List<SmBaseinfoDto> selectYrRptImportCount(PageRequest request) throws Exception{
        try {
            Map<String, Object> searchMap = request.getParams ();
            if (searchMap != null && searchMap.containsKey ("startCheckPushDate") && searchMap.containsKey ("endCheckPushDate")) {
                if (searchMap.get ("startCheckPushDate") != null && StringUtil.isNotBlank (searchMap.get ("startCheckPushDate").toString ())) {
                    searchMap.put ("startCheckPushDate", StringUtil.replace (searchMap.get ("startCheckPushDate").toString (), "-", ""));
                    searchMap.put ("endCheckPushDate", StringUtil.replace (searchMap.get ("endCheckPushDate").toString (), "-", ""));
                } else {
                    searchMap.put ("startCheckPushDate", searchMap.get ("rptyear").toString () + searchMap.get ("rptbeginmouth").toString ());
                }
            }
            if (searchMap != null && searchMap.containsKey ("industryCo") && searchMap.get ("industryCo") != null) { // 行业门类
                searchMap.put ("industryCo", StringUtil.doSplitStringToSqlFormat (searchMap.get ("industryCo").toString (), ","));
            }
            if (searchMap != null && searchMap.containsKey ("thrIndustry") && searchMap.get ("thrIndustry") != null) { // 三大产业
                searchMap.put ("thrIndustry", StringUtil.doSplitStringToSqlFormat (searchMap.get ("thrIndustry").toString (), ","));
            }
            PageHelper.startPage (request.getPageNum (), 20000);
            return smBaseinfoMapper.selectYrSmImPortCount (searchMap);
        } catch (Exception e) {
            e.printStackTrace ();
            logger.error ("exception {}", "小微监测年报信息统计（八大重点产业统计）!");
            throw new BusinessException ("小微监测年报信息统计（八大重点产业统计）!");
        }
    }

    /** 
    * 描述: 根据注册号获取不在培育库的pripid
    * @author 张文男
    * @date 2017年6月15日 
    * @param regNoOrUniCode
    * @return 
    */

    public String queryPriPIDByRegNoOrUniCode(String regNoOrUniCode){
        List<String> list = smBaseinfoMapper.queryPriPIDByRegNoOrUniCode (regNoOrUniCode);
        if (null != list && list.size () > 0) { return list.get (0); }
        return null;
    }
    
    /** 
     * 描述: 根据pripid获取类型
     * @author 张文男
     * @date 2017年6月20日 
     * @param priPID
     * @return 
     */

    public List<String> selectTypeByPriPID(String priPID){
        return smBaseinfoMapper.selectTypeByPriPID (priPID);
    }
    
	/**
	 * 
	 * 描述: 小微企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseinfoCount(Map<String, Object> map) throws Exception{
		return smBaseinfoMapper.smbaseinfoCount(map);
	}
	
	/**
	 * 
	 * 描述: 小微可视化首页年报相关统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public SmBaseinfoDto smbaseinfoNbCount(Map<String, Object> map) throws Exception{
		return smBaseinfoMapper.smbaseinfoNbCount(map);
	}
	
	/**
	 * 
	 * 描述: 小微年报可视化三次产业统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseThreeTypeCount(Map<String, Object> map) throws Exception{
		return smBaseinfoMapper.smbaseThreeTypeCount(map);
	}

}