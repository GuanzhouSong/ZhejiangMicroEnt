/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inspect.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringToInUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.inspect.dto.ReportCheckInfoDto;
import com.icinfo.cs.inspect.mapper.ReportCheckCodeMapper;
import com.icinfo.cs.inspect.mapper.ReportCheckInfoMapper;
import com.icinfo.cs.inspect.mapper.ReportCheckItemMapper;
import com.icinfo.cs.inspect.mapper.ReportCheckResultMapper;
import com.icinfo.cs.inspect.model.ReportCheckCode;
import com.icinfo.cs.inspect.model.ReportCheckInfo;
import com.icinfo.cs.inspect.model.ReportCheckItem;
import com.icinfo.cs.inspect.model.ReportCheckResult;
import com.icinfo.cs.inspect.service.IReportCheckInfoService;
import com.icinfo.cs.login.mapper.PubEppasswordMapper;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.yr.mapper.YrOtherInfoMapper;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_report_check_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年01月17日
 */
@Service
public class ReportCheckInfoServiceImpl extends MyBatisServiceSupport implements IReportCheckInfoService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ReportCheckInfoServiceImpl.class);

    @Autowired
    private ReportCheckInfoMapper reportCheckInfoMapper;

    @Autowired
    private ReportCheckResultMapper reportCheckResultMapper;
    @Autowired
    private ReportCheckItemMapper reportCheckItemMapper;
    @Autowired
    private ReportCheckCodeMapper reportCheckCodeMapper;
    @Autowired
    private ReportCheckItemMapper getReportCheckItemMapper;
    @Autowired
    private PubEppasswordMapper pubEppasswordMapper;
    @Autowired
    private YrOtherInfoMapper yrOtherInfoMapper;
    private static final int IS_2016 = 2016;

    @Override
    public List<ReportCheckInfoDto> inspectInputInfoQueryPage(PageRequest request) {
        if(request.getParams()!=null){
            changeresResultForIn(request.getParams());
        }
        List<ReportCheckInfoDto> reportCheckInfoDtos = getFromCheckInfo(request);
        if (reportCheckInfoDtos == null || reportCheckInfoDtos.size() < request.getLength()) {
            int regist_all = getTotalFromCheckInfo(request);
            List<ReportCheckInfoDto> reportCheckInfoDtos2 = getFromYrInfo(request,
                    reportCheckInfoDtos == null ? 0 : reportCheckInfoDtos.size(), request.getLength(), regist_all);
            reportCheckInfoDtos.addAll(reportCheckInfoDtos2);
        }
        return reportCheckInfoDtos;
    }

    private int getTotalFromCheckInfo(PageRequest request) {
        //去掉in后面的空格
        Map params = new HashedMap();
        params.putAll(request.getParams());
        return reportCheckInfoMapper.getTotalFromCheckInfo(params);
    }

    /**
     * 从数据库获取check表分页数据
     *
     * @param request
     * @param request
     * @return
     */
    private List<ReportCheckInfoDto> getFromCheckInfo(PageRequest request) {
        //去掉in后面的空格
        Map params = new HashedMap();
        params.putAll(request.getParams());
        //查询出check
        params.put("_pnum", (request.getPageNum() - 1) * request.getLength());
        params.put("_len", request.getLength());
        return reportCheckInfoMapper.inspectInputInfoQueryPage(params);
    }

    /**
     * 从数据库获取yr表分页数据
     *
     * @param request
     * @param request
     * @return
     */
    private List<ReportCheckInfoDto> getFromYrInfo(PageRequest request, int regist_size, int pageLength, int regist_all) {
        Map params = new HashedMap();
        List<RegistInfoDto> mids = new ArrayList<RegistInfoDto>();
        Object[] obj = new Object[2];
        int mid_first_length = 0;
        int mid_start = 0;
        int mid_first_pagenum = 1;
        int requestPageNum = request.getPageNum();
        mid_first_length = pageLength - regist_size;
        mid_first_pagenum = regist_all / pageLength + 1;
        mid_start = (requestPageNum - mid_first_pagenum - 1) * pageLength + mid_first_length;
        if (mid_first_length > 0 && requestPageNum == mid_first_pagenum) {  //mid表第一次展现
            params.put("_pnum", 0);
            params.put("_len", mid_first_length);
        } else if (requestPageNum > mid_first_pagenum) { //mid表完全展现
            params.put("_pnum", mid_start);
            params.put("_len", pageLength);
        }
        params.putAll(request.getParams());
        List<ReportCheckInfoDto> reportCheckInfoDtos = reportCheckInfoMapper.inspectYrInfoQueryPage(params);
        return reportCheckInfoDtos;

    }

    @Override
    public List<ReportCheckInfoDto> inspectCheckInfoQueryPage(PageRequest request) {
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			changeresResultForIn(request.getParams());
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return reportCheckInfoMapper.inspectCheckInfoQueryPage(request.getParams());
    }

    @Override
    public List<ReportCheckInfoDto> inspectViewInfoQueryPage(PageRequest request) {
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			changeresResultForIn(request.getParams());
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return reportCheckInfoMapper.inspectViewInfoQueryPage(request.getParams());
    }

    @Override
    public int inspectInputInfoQueryPage_total(PageRequest request) {
    /*    if(request.getParams()!=null){
            changeresResultForIn(request.getParams());
        }*/
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
        if (request.getParams() != null) {
        	paramsMap = request.getParams();
        	paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
            if ((paramsMap.get("resResult") != null && !"".equals(paramsMap.get("resResult")))
                    ||
                    (paramsMap.get("infoAuditResult") != null && !"".equals(paramsMap.get("infoAuditResult")) && !"3".equals(paramsMap.get("infoAuditResult")))
                    )
                return reportCheckInfoMapper.getTotalFromCheckInfo(paramsMap);

        }
        paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        return reportCheckInfoMapper.inspectInputInfoQueryPage_total(paramsMap);
    }


    @Override
    @Transactional
    public int del(String uid) {
        if (StringUtil.isEmpty(uid)) return 0;
        ReportCheckInfo reportCheckInfo = new ReportCheckInfo();
        reportCheckInfo.setUID(uid);
        reportCheckInfoMapper.delete(reportCheckInfo);
        ReportCheckResult reportCheckResult = new ReportCheckResult();
        reportCheckResult.setUID(uid);
        reportCheckResultMapper.delete(reportCheckResult);
        ReportCheckItem reportCheckItem = new ReportCheckItem();
        reportCheckItem.setUID(uid);
        reportCheckItemMapper.delete(reportCheckItem);
        return 1;
    }

    @Override
    public Map countCheckNum(Map<String, Object> params) {
        Map res = new HashMap();
        if(params!=null){
            changeresResultForIn(params);
        }
        res.put("waitCheckNum", reportCheckInfoMapper.countWaitCheckNum(params));
        res.put("checkNo", reportCheckInfoMapper.countCheckNoNum(params));
        return res;
    }

    @Override
    public List<ReportCheckCode> getCommonKeyCodeList(String entType, String checkType, int year) {
        Map param = new HashMap();
        param.put("entType", entType);
        param.put("checkType", checkType);
        if (year < IS_2016) {
            param.put("Is2016", "Y");
        }
        List<ReportCheckCode> reportCheckCodes = reportCheckCodeMapper.getCommonKeyCodeList(param);
        return reportCheckCodes;
    }

    @Override
    public List<ReportCheckCode> getCodeListByEntType(MidBaseInfo midBaseInfo, String checkType, int year) {
        String entType = getEntType(midBaseInfo);
        return getCommonKeyCodeList(entType, checkType, year);
    }

    @Override
    public int add(ReportCheckInfoDto reportCheckInfoDto) {
        //插入主表
        reportCheckInfoDto.setUID(UUID.randomUUID().toString().replace("-", ""));
        reportCheckInfoMapper.insert(reportCheckInfoDto);
        insertUnionData(reportCheckInfoDto);
        return 1;
    }

    @Override
    public int modi(ReportCheckInfoDto reportCheckInfoDto) {
        //更新主表
        Example example = new Example(ReportCheckInfo.class);
        example.createCriteria().andEqualTo("UID", reportCheckInfoDto.getUID());
        reportCheckInfoMapper.updateByExample(reportCheckInfoDto, example);
        deleteUnionData(reportCheckInfoDto);
        insertUnionData(reportCheckInfoDto);

        return 1;
    }

    private void insertUnionData(ReportCheckInfoDto reportCheckInfoDto) {
        //item表
        insertCheckItemBySplit(reportCheckInfoDto.getCommon(), "common", reportCheckInfoDto.getUID());
        insertCheckItemBySplit(reportCheckInfoDto.getKey(), "key", reportCheckInfoDto.getUID());
        insertCheckItem(reportCheckInfoDto.getReglaw(), reportCheckInfoDto.getReglawCon(), "reglaw", reportCheckInfoDto.getUID());
        insertCheckItem(reportCheckInfoDto.getOthlaw(), reportCheckInfoDto.getOthlawCon(), "othlaw", reportCheckInfoDto.getUID());
        //result表
        insertResult(reportCheckInfoDto);
    }


    private void deleteUnionData(ReportCheckInfoDto reportCheckInfoDto) {
        //删除item表
        ReportCheckItem reportCheckItem = new ReportCheckItem();
        reportCheckItem.setUID(reportCheckInfoDto.getUID());
        reportCheckItemMapper.delete(reportCheckItem);
        //删除result表
        ReportCheckResult reportCheckResult = new ReportCheckResult();
        reportCheckResult.setUID(reportCheckInfoDto.getUID());
        reportCheckResultMapper.delete(reportCheckResult);
    }

    /**
     * 插入结果表
     *
     * @param reportCheckInfoDto
     */
    private void insertResult(ReportCheckInfoDto reportCheckInfoDto) {
        if (StringUtil.isEmpty(reportCheckInfoDto.getRes())) return;
        Arrays.stream(reportCheckInfoDto.getRes().split(",")).forEach(o -> {
            ReportCheckResult reportCheckResult = new ReportCheckResult();
            reportCheckResult.setUID(reportCheckInfoDto.getUID());
            reportCheckResult.setYear(reportCheckInfoDto.getYear());
            reportCheckResult.setPriPID(reportCheckInfoDto.getPriPID());
            reportCheckResult.setResResult(o);
            reportCheckResultMapper.insert(reportCheckResult);
        });

    }

    /**
     * 插入check item表插入一般、重点核查项目.
     * 用&分割实际情况
     *
     * @param
     */
    private void insertCheckItemBySplit(String key, String type, String uid) {
        if (StringUtil.isEmpty(key)) return;
        Arrays.stream(key.split(",")).forEach(o -> {
            String[] oArr = o.split("&");
            if (oArr.length > 1) {
                ReportCheckItem reportCheckItem = new ReportCheckItem();
                reportCheckItem.setItemCode(oArr[0]);
                reportCheckItem.setStatus(oArr[1]);
                reportCheckItem.setType(type);
                reportCheckItem.setUID(uid);
                reportCheckItem.setItemContent(oArr.length > 2 ? oArr[2] : "");
                reportCheckItemMapper.insert(reportCheckItem);
            }

        });
    }

    /**
     * 插入check item表 插入补充核查项目
     *
     * @param
     */
    private void insertCheckItem(String key, String keycon, String type, String uid) {
        if (StringUtil.isNotEmpty(key)) {
            Arrays.stream(key.split(",")).forEach(o -> {
                ReportCheckItem reportCheckItem = new ReportCheckItem();
                reportCheckItem.setItemCode(o);
                reportCheckItem.setType(type);
                reportCheckItem.setUID(uid);
                reportCheckItem.setItemContent(keycon);
                reportCheckItemMapper.insert(reportCheckItem);
            });
        }
    }

    @Override
    public List<ReportCheckItem> getCheckedItem(String uid) {
        if (StringUtil.isEmpty(uid)) return new ArrayList<ReportCheckItem>();
        ReportCheckItem reportCheckItem = new ReportCheckItem();
        reportCheckItem.setUID(uid);
        List<ReportCheckItem> select = getReportCheckItemMapper.select(reportCheckItem);
        if (select == null) select = new ArrayList<ReportCheckItem>();
        return select;
    }

    @Override
    public int modiPre(ReportCheckInfoDto reportCheckInfoDto, String fromtype) {
    	reportCheckInfoDto.setInfoAuditResult("5");
    	return modi(reportCheckInfoDto);
    }

    @Override
    public String getLinkManAndTel(MidBaseInfo midBaseInfo) {
        PubEppassword pubEppassword = new PubEppassword();
        Example example = new Example(PubEppassword.class);
        example.createCriteria().andEqualTo("pripid", midBaseInfo.getPriPID());
        example.orderBy("applyTime").desc();
        List<PubEppassword> pubEppasswordl = pubEppasswordMapper.selectByExample(example);
        List<YrOtherInfo> yrOtherInfol = yrOtherInfoMapper.selectByExample(example);
        YrOtherInfo yrOtherInfo = new YrOtherInfo();

        if (pubEppasswordl != null && pubEppasswordl.size() > 0) {
            pubEppassword = pubEppasswordl.get(0);
        }
        if (yrOtherInfol != null && yrOtherInfol.size() > 0) {
            yrOtherInfo = yrOtherInfol.get(0);
        }

        if (pubEppassword != null && StringUtil.isNotEmpty(pubEppassword.getLianame())) {
            return pubEppassword.getLianame() + "  " + pubEppassword.getTel();
        } else {
            return yrOtherInfo.getLiaName() + "  " + yrOtherInfo.getLiaPhone();
        }

    }

    @Override
    public List<ReportCheckInfoDto> inspectInputInfoQueryPage_all(PageRequest request) {
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
        if(request.getParams()!=null){
            changeresResultForIn(request.getParams());
            paramsMap = request.getParams();
        }
        paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return reportCheckInfoMapper.inspectInputInfoQueryPage_all(request.getParams());
    }
    
    /**
     * 描述:新增补报核查记录
     * @author chenxin
     * @date 2017-02-03
     * @param request
     * @return
     */
    @Override
    public List<ReportCheckInfoDto> inspectInputInfoQueryPageNew(PageRequest request) {
        
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			changeresResultForIn(request.getParams());
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
        return reportCheckInfoMapper.inspectYrInfoQueryPage(paramsMap);
    }
    


    @Override
    public ReportCheckInfo getCheckInfoByUid(String uid) {
        if (StringUtil.isEmpty(uid)) return new ReportCheckInfo();
        ReportCheckInfo checkInfo = new ReportCheckInfo();
        checkInfo.setUID(uid);
        ReportCheckInfo reportCheckInfo = reportCheckInfoMapper.selectOne(checkInfo);
        return reportCheckInfo;
    }

    @Override
    public List<ReportCheckResult> getCheckResByUid(String uid) {
        if (StringUtil.isEmpty(uid)) return new ArrayList<ReportCheckResult>();
        ReportCheckResult reportCheckResult = new ReportCheckResult();
        reportCheckResult.setUID(uid);
        return reportCheckResultMapper.select(reportCheckResult);
    }

    /**
     * 1、非私营企业（企业小类：除私营企业外）
     * 2、私营企业（企业小类：1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580）
     * 3、分支机构（企业大类：12,14,22,28,32,34）
     * 4、从事生产经营活动企业（企业大类：24）
     * 5、内资非法人企业（忽略）
     * 6、有限责任公司（企业大类：11,21）
     * 7、股份有限责任公司（企业大类：11,21；并且企业小类：1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,5200,5210,5220,5230,5240,5290,6200,6210,6220,6230,6240,6250,6260,6270,6280,6290）
     * 8、非公司企业法人（企业大类：13）
     * 9、合伙企业（企业大类：27,33）
     * 10、个人独资企业（企业大类：31）
     * 11、非法人中外合作企业（忽略）
     * 12、农专社（企业大类：16,17）
     * 13、个体户（企业大类：50）
     *
     * @param midBaseInfo
     * @return
     */
    private String getEntType(MidBaseInfo midBaseInfo) {
        List<String> privateEnt = Arrays.asList("1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580".split(","));
        List<String> branch = Arrays.asList("12,14,22,28,32,34".split(","));//分支机构
        List<String> busi_ent = Arrays.asList("24".split(","));//从事生产经营活动企业
        List<String> limit_lia = Arrays.asList("11,21".split(","));
        List<String> gf_limit_lia = Arrays.asList("1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,5200,5210,5220,5230,5240,5290,6200,6210,6220,6230,6240,6250,6260,6270,6280,6290".split(","));
        List<String> noent_lerep = Arrays.asList("13".split(","));
        List<String> share_ent = Arrays.asList("27,33".split(","));
        List<String> person_ent = Arrays.asList("31".split(","));
        String entType = midBaseInfo.getEntType() + "";
        String entTypeCatg = midBaseInfo.getEntTypeCatg() + "";
        //企业
        if (!(entTypeCatg.equals("50") && entTypeCatg.equals("16") && entTypeCatg.equals("17"))) {
            //私营企业
            if (privateEnt.contains(entType)) {
                if (branch.contains(entTypeCatg)) {
                    List<String> entTypes = Arrays.asList("12,14,34,32".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "Private1";
                } else if (limit_lia.contains(entTypeCatg) || gf_limit_lia.contains(entType)) {
                    List<String> entTypes = Arrays.asList("11".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "Private2";
                } else if (noent_lerep.contains(entTypeCatg) || share_ent.contains(entTypeCatg) || person_ent.contains(entTypeCatg)) {
                    List<String> entTypes = Arrays.asList("13,33,31".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "Private3";
                }

            }
            //非私营企业
            else {
                if (branch.contains(entTypeCatg) || busi_ent.contains(entTypeCatg)) {
                    List<String> entTypes = Arrays.asList("12,14,34,32,22,28,24".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "NoPrivate1";
                } else if (limit_lia.contains(entTypeCatg) || gf_limit_lia.contains(entType)) {
                    List<String> entTypes = Arrays.asList("11,21".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "NoPrivate2";
                } else if (noent_lerep.contains(entTypeCatg) || share_ent.contains(entTypeCatg) || person_ent.contains(entTypeCatg)) {
                    List<String> entTypes = Arrays.asList("13,33,31,27".split(","));
                    if (entTypes.contains(entTypeCatg))
                        return "NoPrivate3";
                }
            }
        }
        //农专社
        if (entTypeCatg.equals("16")) {
            return "Sfc";
        } else return "";
    }


    private void changeresResultForIn(Map params) {
        if (params != null) {
            StringToInUtil.strToIn(params);
        }
        if (params!= null &&params.get("resResult") != null) {
            String resResult =params.get("resResult").toString();
            if (StringUtil.isNotEmpty(resResult)) {
                params.put("resResult", "'" + resResult.replace(",", "','") + "'");
            }
        }
    }
    
    /**
     * 描述:查询待审核个数
     * 
     * @author yujingwei
     * @date 2017-02-03
     * @param request
     * @return qryMap
     */
	public Integer selectNeedToAuditCountForCheck(Map<String, Object> qryMap) throws Exception{
		return reportCheckInfoMapper.selectNeedToAuditCountForCheck(qryMap);
	}
	
	/**
     * 描述:查询待录入个数
     * 
     * @author yujingwei
     * @date 2017-02-03
     * @param request
     * @return qryMap
     */
	public Integer selectNeedToInputCountForCheck(Map<String, Object> qryMap) throws Exception{
		qryMap.put("regState", RegStateEnum.CUNXU.getParam());
		return reportCheckInfoMapper.selectNeedToInputCountForCheck(qryMap);
	}

	/** 
	 * 描述: 统计
	 * @auther ZhouYan
	 * @date 2017年11月6日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Integer selectCheckInfoCountTotal(Map<String, Object> qryMap)
			throws Exception {
		if(qryMap.get("disposeStateCount") != null && qryMap.get("disposeStateCount").equals("1")) {
			changeresResultForIn(qryMap);
			qryMap.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return reportCheckInfoMapper.selectCheckInfoCountTotal(qryMap);
	}

	/** 
	 * 描述: 补报核查企业同步
	 * @auther ZhouYan
	 * @date 2017年11月7日 
	 * @throws Exception 
	 */
	@Override
	public void doReportCheckQuartz() throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		List<ReportCheckInfo> newReportCheckInfoList = reportCheckInfoMapper.selectNewReportCheckInfo(paramsMap);
		if(!newReportCheckInfoList.isEmpty()) {
			//增量
			reportCheckInfoMapper.insertReportCheckInfo(paramsMap);
			logger.info("cs_report_check_info增量");
		}
	}
	
	
}