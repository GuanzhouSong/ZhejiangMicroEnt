/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.google.code.yanf4j.core.Session;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringToInUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.copysend.service.ICopySendIllegalService;         
import com.icinfo.cs.datacount.dto.RptTrade;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.impl.MidBaseInfoServiceImpl;
import com.icinfo.cs.govguide.service.impl.GovguideServiceImpl;
import com.icinfo.cs.login.mapper.PubEppasswordMapper;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.mainmark.dto.MainMarkDto;
import com.icinfo.cs.mainmark.mapper.MainMarkMapper;
import com.icinfo.cs.mainmark.mapper.MainMarkRelMapper;
import com.icinfo.cs.mainmark.model.MainMark;
import com.icinfo.cs.mainmark.model.MainMarkRel;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.orderreform.service.IOrderReformSetService;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.mapper.PubApprMarkRelMapper;
import com.icinfo.cs.registinfo.mapper.RegistInfoHisMapper;
import com.icinfo.cs.registinfo.mapper.RegistInfoMapper;
import com.icinfo.cs.registinfo.mapper.RegistMarkMapper;
import com.icinfo.cs.registinfo.mapper.RegistUnlicensedMapper;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.cs.registinfo.model.RegistInfo;
import com.icinfo.cs.registinfo.model.RegistInfoHis;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistUnlicensed;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.registinfo.service.IRegistInfoService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.mapper.YrOtherInfoMapper;
import com.icinfo.cs.yr.mapper.YrPbBaseInfoMapper;
import com.icinfo.cs.yr.mapper.YrSfcBaseinfoMapper;
import com.icinfo.cs.yr.mapper.YrWebsiteInfoMapper;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.*;

/**
 * 描述:    cs_regist_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class RegistInfoServiceImpl extends MyBatisServiceSupport implements IRegistInfoService {
    @Autowired
    RegistInfoMapper registInfoMapper;
    @Autowired
    RegistMarkMapper registMarkMapper;
    @Autowired
    RegistInfoHisMapper registInfoHisMapper;
    @Autowired
    RegistUnlicensedMapper registUnlicensedMapper;
    @Autowired
    MidBaseInfoMapper midBaseInfoMapper;
    @Autowired
    PubEppasswordMapper pubEppasswordMapper;
    @Autowired
    YrOtherInfoMapper yrOtherInfoMapper;
    @Autowired
    YrWebsiteInfoMapper yrWebsiteInfoMapper;
    @Autowired
    MidBaseInfoServiceImpl midBaseInfoService;
    @Autowired
    GovguideServiceImpl govguideService;
    @Autowired
    private IOrderReformSetService orderReformSetService;
    @Autowired
    private IPubOpanoMalyService pubOpanoMalyService;
    @Autowired
    ICsEntWarnService csEntWarnService;
    @Autowired
    ICsSuperviseObjService csSuperviseObjService;
    @Autowired
    ICsConcernObjService csConcernObjService;
    @Autowired
    IPubPbopanomalyService pubPbopanomalyService;
    @Autowired
    ICopySendIllegalService copySendIllegalService;
    @Autowired
    private IPanoramaSearchService panoramaSearchService;
    @Autowired
    MainMarkMapper mainMarkMapper;
    @Autowired
    MainMarkRelMapper mainMarkRelMapper;
    @Autowired
    IMainMarkRelService mainMarkRelService;
    @Autowired
    YrPbBaseInfoMapper yrPbBaseInfoMapper;
    @Autowired
    YrSfcBaseinfoMapper yrSfcBaseInfoMapper;
    @Autowired
    IRegistMarkService registMarkService;
    @Autowired
    IpubScSpecialLibraryService pubScSpecialLibraryService;
    @Autowired
    IPubApprMarkRelService pubApprMarkRelService;
    @Autowired
    PubApprMarkRelMapper pubApprMarkRelMapper;
    
    


    /**
     * 户口认领建档表格数据
     * --暂时没用到
     *
     * @param request
     * @return
     */
    @Override
    public List<RegistInfoDto> registInfoQueryPage_all(PageRequest request) {
        if (request.getParams() != null) {
            StringToInUtil.strToIns(request.getParams());
        }
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return registInfoMapper.registClaimQueryPage(request.getParams());
    }

    /**
     * 户口认领建档表格数据
     * --数据库和索引联合拼接查询
     *
     * @param request
     * @return
     */
    public PageResponse<RegistInfoDto> registInfoQueryPage_page(PageRequest request) throws Exception {
    	Map<String, Object> p = new HashMap<String, Object>();
        p.put("regState", RegStateEnum.CUNXU.getParam());
        if (request.getParams() != null) {
            request.getParams().putAll(p);
        } else {
            request.setParams(p);
        }
        List<RegistInfoDto> all = new ArrayList<RegistInfoDto>();
        //获取regist分页
        List<RegistInfoDto> regists = getRegistFromDb(request);
        int regist_all = registInfoMapper.registClaimQueryPage_total(StringToInUtil.strToIns(request.getParams())).intValue();
        //获取mid分页
//        Object[] mids = getMidFromIndex(request, regists, request.getLength(), regist_all);
//        long mid_all= (long) mids[1];
        all.addAll(regists);
//        all.addAll((List<RegistInfoDto>) mids[0]);
        return new PageResponse<RegistInfoDto>(all, regist_all, request);
    }


    /**
     * 从数据库获取regist表分页数据
     * @param request
     * @param request
     * @return
     */
    private List<RegistInfoDto> getRegistFromDb(PageRequest request) {
        //去掉in后面的空格
        Map params = new HashedMap();
        params.putAll(request.getParams());
        StringToInUtil.strToIns(params);
        //查询出建档表数据和总数
        params.put("_pnum", (request.getPageNum() - 1) * request.getLength());
        params.put("_len", request.getLength());
        return registInfoMapper.registClaimQueryPage_regist(params);
    }

    /**从索引获取mid表分页数据
     * 计算mid表的初始大小和初始页数
     * mid_first_length（初始大小-mid表初次展现的长度）=pageLength-regist_all%pageLength 取余
     * mid_first_pagenum（初始页数-mid表在第几页开始展现）=regist_all/pageLength
     * mid_start（开始条数-mid表完全开始展现的start 第一次完全展现=mid_first_length）=(request.getPageNum()-mid_first_pagenum-1)*pageLength+mid_first_length
     */
    private Object[]  getMidFromIndex(PageRequest request, List<RegistInfoDto> regists, int pageLength, int regist_all) throws Exception {
        Map params = new HashedMap();
        List<RegistInfoDto> mids = new ArrayList<RegistInfoDto>();
        Object[] obj = new Object[2];
        int mid_first_length = 0;
        int mid_start = 0;
        int mid_first_pagenum = 1;
        int requestPageNum = request.getPageNum();
        int regist_size = regists == null ? 0 : regists.size();
        mid_first_length = pageLength - regist_size;
        mid_first_pagenum = regist_all / pageLength + 1;
        mid_start = (requestPageNum - mid_first_pagenum - 1) * pageLength + mid_first_length;
        if (mid_first_length > 0 && requestPageNum == mid_first_pagenum) {  //mid表第一次展现
            request.setLength(mid_first_length);
            request.setStart(0);
        } else if (requestPageNum > mid_first_pagenum) { //mid表完全展现
            request.setLength(pageLength);
            request.setStart(mid_start);
        }
        if (params.get("uniCode") != null && StringUtil.isNotEmpty(params.get("uniCode").toString())) {
            params.put("cidRegNO", (String) params.get("uniCode"));
        }
        if (params.get("estDate_sta") != null && StringUtil.isNotEmpty((String) params.get("estDate_sta"))) {
            params.put("estDateStart", (String) params.get("estDate_sta"));
        }
        if (params.get("estDate_end") != null && StringUtil.isNotEmpty((String) params.get("estDate_end"))) {
            params.put("estDateEnd", (String) params.get("estDate_end"));
        }
        params.put("isClaimRegist", "Y");
        params.putAll(request.getParams());
        request.setParams(params);
        Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
        if ((params.get("claimState") == null
                || "".equals(params.get("claimState"))
                || "0".equals(params.get("claimState")))
                && mid_first_length > 1) {
            for (PanoramaResultDto panoramaResultDto : data) {
                RegistInfoDto regist = new RegistInfoDto();
                regist.setClaimState("0");
                regist.setPriPID(panoramaResultDto.getPriPID());
                regist.setRegNO(panoramaResultDto.getRegNO());
                regist.setUniCode(panoramaResultDto.getUniscid());
                regist.setEntName(panoramaResultDto.getEntName());
                regist.setLeRep(panoramaResultDto.getLeRep());
                regist.setDom(panoramaResultDto.getDom());
                regist.setEstDate(panoramaResultDto.getEstDate());
                regist.setLocalAdmName(panoramaResultDto.getLocalAdmName());
                regist.setSliceNOName(panoramaResultDto.getSliceNOName());//片区商圈本来是空的。
                mids.add(regist);
            }
        }
        obj[0]=mids;
        obj[1]=data.getTotal();
        return obj;
    }



    @Override
    public RegistInfoDto selectRegistInfoByPriPID(String pripid) {
        return registInfoMapper.selectByPriPid(pripid);
    }

    /**
     * 七大产业统计
     *
     * @param request
     * @return
     */
    @Override
    public List<RptTrade> getDataCountQueryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return registInfoMapper.selectRptTrade(request.getParams());
    }

    /**
     * 统计企业各种异常状态
     *
     * @param priPID
     * @param data
     * @return
     */
    @Override
    public Map<String, Object> allAbnormals(String priPID, String entTypeCatg, Map<String, Object> data) {
        if (StringUtil.isEmpty(priPID)) return data;
        try {

            //1,行政指导
            int govguide_num = govguideService.getCountByPripid(priPID);
            data.put("govguide_num", govguide_num);
            //2责令整改
            int order_num = orderReformSetService.getCountByPripid(priPID);
            data.put("correct_num", order_num);
            //3列入经营异常(2)
            Map<String, Object> paramsMap = new HashMap<String, Object>();
            //个体户列入经营异常

            if ("50".equals(entTypeCatg)) {
                paramsMap.clear();
                paramsMap.put(Constants.CS_PRIPID, priPID);
                data.put("pubopanoy_num", pubPbopanomalyService.selectMarkEntCount(paramsMap));
            } else {
                //企业农专列入经营异常
                PageRequest request = new PageRequest();
                paramsMap.put(Constants.CS_PRIPID, priPID);
                //applyFalg标识 1 表示查询已经审核通过的
                paramsMap.put("applyFalg", "1");
                request.setParams(paramsMap);
                List<PubOpanoMalyDto> pubOpanoMalyDtoList = pubOpanoMalyService.queryPubOpanoMalyList(request);
                data.put("pubopanoy_num", pubOpanoMalyDtoList == null ? "0" : pubOpanoMalyDtoList.size());
            }
            // 4预警提示（4）
            Map<String, Object> param = new HashedMap();
            param.put("priPID", priPID);
            List<CsEntWarnDto> csEntWarnDtos = csEntWarnService.selectEffectiveWarnMark(param);
            data.put("warn_num", csEntWarnDtos == null ? 0 : csEntWarnDtos.size());
            //9列入关注服务对象(0
            List<CsConcernObjDto> csConcernObjDtos = csConcernObjService.selectEffectiveConMark(param);
            data.put("concern_num", csConcernObjDtos == null ? 0 : csConcernObjDtos.size());
            //10列入重点监管(0
            List<CsSuperviseObjDto> csSuperviseObjDtos = csSuperviseObjService.selectEffectiveSupMark(param);
            data.put("supervise_num", csSuperviseObjDtos == null ? 0 : csSuperviseObjDtos.size());
            // 5列入抽查检查（2）
            List<PubScinfo> pubScinfos = registInfoMapper.selectPubScinfos(param);
            data.put("check_num", pubScinfos == null ? 0 : pubScinfos.size());
            // 6部门抄告抄送（0）
            int copysend_num = copySendIllegalService.selectCountByPriPID(priPID);
            data.put("copysend_num", copysend_num);

            //7列入案源管理（0）

            // 8信息修正申请(1)

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * 
     * 描述: 户口建档变更查询列表
     * @auther 
     * @date 2017年4月18日 
     * @param request
     * @return
     */
    @Override
    public List<RegistInfoDto> registInfoAgainQueryPage(PageRequest request) {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("altDate", LocalDate.now().minusDays(Constants.AgainRegistDays).toString());
        p.put("regState", RegStateEnum.CUNXU.getParam());
        if (request.getParams() != null) {
            StringToInUtil.strToIns(request.getParams());
            request.getParams().putAll(p);
        } else {
            request.setParams(p);
        }

        PageHelper.startPage(request.getPageNum(), request.getLength());
        return registInfoMapper.registInfoAgainQueryPage(request.getParams());
    }


    @Override
    public List<Map<String, String>> selectAllMarkType() {
        List<Map<String, String>> res = registInfoMapper.selectAllMarkType();
        return res;
    }

    @Override
    public List<RegistInfoDto> registModiInfoQueryPage(PageRequest request) {
    	Map<String, Object> p = new HashMap<String, Object>();
        p.put("regState", RegStateEnum.CUNXU.getParam());
        if (request.getParams() != null) {
        	StringToInUtil.strToIns(request.getParams());
            concatCustomQry(request.getParams());
            request.getParams().putAll(p);
        } else {
            request.setParams(p);
        }
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return registInfoMapper.registModiQueryPage(request.getParams());
    }


    /**
     * @param request
     * @return
     */
    @Override
    public List<RegistInfoDto> registDistributeInfoQueryPage(PageRequest request) {
    	Map<String, Object> p = new HashMap<String, Object>();
        p.put("regState", RegStateEnum.CUNXU.getParam());
        if (request.getParams() != null) {
            StringToInUtil.strToIns(request.getParams());
            request.getParams().putAll(p);
        } else {
            request.setParams(p);
        }
        PageHelper.startPage(request.getPageNum(), request.getLength());
        List<RegistInfoDto> registInfoDtos = registInfoMapper.registDistributeQueryPage(request.getParams());
        return registInfoDtos;
    }

    /**
     * 委托列表页面
     *
     * @param request
     * @return
     */
    @Override
    public List<RegistInfoDto> registDelegateInfoQueryPage(PageRequest request) {
    	Map<String, Object> p = new HashMap<String, Object>();
        p.put("regState", RegStateEnum.CUNXU.getParam());
        if (request.getParams() != null) {
            StringToInUtil.strToIns(request.getParams());
            request.getParams().putAll(p);
        } else {
            request.setParams(p);
        }
        PageHelper.startPage(request.getPageNum(), request.getLength());
        List<RegistInfoDto> registInfoDtos = registInfoMapper.registDistributeQueryPage(request.getParams());
        return registInfoDtos;
    }

    @Override
    @Transactional
    public int bakHistoryDataAndInsert(RegistInfoDto registInfoDto) {
        if (StringUtil.isEmpty(registInfoDto.getPriPID())) return 0;
        int res = 0;
        String[] priPID_ = registInfoDto.getPriPID().split(",");
        //把建档表的数据批量备份到历史表
        for (String _priPID : priPID_) {
            if (StringUtil.isEmpty(_priPID)) continue;
            RegistInfoHis registInfoHis = registInfoMapper.selectByPripidForHis(_priPID);
            res = registInfoHisMapper.insert(registInfoHis);
        }

        //删除原先的建档数据
        Example example = new Example(RegistInfo.class);
        example.createCriteria().andIn("priPID", Arrays.asList(priPID_));
        res = registInfoMapper.deleteByExample(example);
        //把新的基础数据批量插入到建档表
        int count=0;
        for (String _priPID : priPID_) {
            if (StringUtil.isEmpty(_priPID)) continue;
            MidBaseInfo midBaseInfo = midBaseInfoMapper.selectMidBaseInfoByPripid(_priPID);
            registInfoDto.setEntName(midBaseInfo.getEntName());
            registInfoDto.setUniCode(midBaseInfo.getUniCode());
            registInfoDto.setRegNO(midBaseInfo.getRegNO());
            registInfoDto.setLocalAdm(midBaseInfo.getLocalAdm());
            registInfoDto.setRegistState("2");//分配 已分配
            registInfoDto.setClaimState("1");//认领，已认领
            res = count+registInfoMapper.insert(registInfoDto);
        }
        return res;
    }

    /**
     * 主体户口定时任务：查找不在建档表里的MID数据,插入建档表，有管辖单位的
     * 不加事务，因为没有原子性。
     *
     * @return
     */
    @Override
    public int registInfoSyn() {
    	HashedMap map = new HashedMap();
    	map.put("regState", RegStateEnum.CUNXU.getParam());
        //查询未同步的数据
        List<RegistInfo> registInfos = registInfoMapper.selectMidInfoNotSyn(map);
        //手动插入
        for (RegistInfo registInfo : registInfos) {
        	registInfo.setSetTime(new Date());
            int res = registInfoMapper.insert(registInfo);
            if (res < 1) return 0;
        }
        return 1;
    }


    /**
     * 批量建档和批量修改的公用方法
     *
     * @param registInfoDto
     * @param registInfoDto
     * @return
     */
    @Transactional
    @Override
    public int batchModi(RegistInfoDto registInfoDto,SysUserDto sysUser) {
        int res = 0;
        //初始化pripid字符串，分割成数组
        String[] priPIDArray = registInfoDto.getPriPID().split(",");

        //2，判断是否变更重建档
        //如果是
        if ("1".equals(registInfoDto.getIsChangeArch())) {
            res = bakHistoryDataAndInsert(registInfoDto);
        }
        //不是变更重建档
        else {
            //批量修改建档表
            registInfoDto.setPriPID(null); //pripid不修改，设置成null
            Example example = new Example(RegistInfo.class);
            example.createCriteria().andIn("priPID", Arrays.asList(priPIDArray));
            res = registInfoMapper.updateByExampleSelective(registInfoDto, example);
        }
        if (res == 0) return res;
        //批量更新cs_mid_baseinfo的片区商圈
        batchUpdateMidBaseinfoSliceNoByPriPid(registInfoDto, priPIDArray);
        //批量更新监管项目\主体标签
//        if (res == 0) return res;
        for (String priPID : priPIDArray) {
            if (StringUtil.isEmpty(priPID)) continue;
            registInfoDto.setPriPID(priPID);
            //更新监管项目关联表
//            res = modiUnlicensed(registInfoDto);
//            if (res == 0) return 0;
            //更新主体标签关联表
            modiRegistMark(registInfoDto,sysUser);
//            if (res == 0) return 0;
        }
        return res;
    }

    /**
     * 拼接查询条件
     *
     * @param params joinItem 操作规则： 和 或
     * @param params _blankItem空数据条件：  监管项目  分类标签  片区/商圈  个转企日期  法定代表人联系电话  户口联系电话  经营场所地址
     * @param params matchItem匹配条件：  片区/商圈与管辖单位不匹配
     * @return
     */
    private void concatCustomQry(Map params) {
        String joinItem = (String) params.get("joinItem");
        String _blankItem = (String) params.get("_blankItem");
        String matchItem = (String) params.get("matchItem");
        StringBuffer stringBuffer = new StringBuffer();
        //符合完整查询的条件：joinItem不为空，或者_blankItem、matchItem2者之中一个不为空。
        if (StringUtil.isNotEmpty(joinItem) && StringUtil.isNotEmpty(_blankItem)) {
            joinItem = joinItem.toUpperCase();
            String[] blankItemArr = _blankItem.split(",");
            for (int i = 0; i < blankItemArr.length; i++) {
                String blankItem = blankItemArr[i];
                if (StringUtil.isEmpty(blankItem)) continue;
                //监管项目为空
                if (blankItem.equals("registUnlicensed")) {
                    params.put("registUnlicensedBlankSql", registUnlicensedBlankSql(joinItem));
                }
                //主体标签为空
                else if (blankItem.equals("registMark")) {
                    params.put("registMarkBlankSql", registMarkBlankSql(joinItem));
                }
                //regist_info表字段为空，把首字母大写
                else {
                    stringBuffer.append(registColumnBlankSql(blankItem, joinItem));
                }
            }
            params.put("registColumnBlankSql", stringBuffer.toString());
        }
        //匹配条件：  片区/商圈与管辖单位不匹配
        if (StringUtil.isNotEmpty(matchItem)) {
            params.put("sliceNOLocalAdmNotMatchSql", sliceNOLocalAdmNotMatchSql());
        }
    }

    /**
     * 管辖单位与片区商圈不匹配
     *
     * @return
     */
    private String sliceNOLocalAdmNotMatchSql() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" AND NOT EXISTS \n").append(
                "  (SELECT \n").append(
                "    1 \n").append(
                "  FROM\n").append(
                "    cs_code_sliceno s \n").append(
                "  WHERE s.SupCode = r.LocalAdm\n").append(
                "  AND s.`Code`=r.`SliceNO`  \n").append(
                "  )");
        return stringBuffer.toString();
    }

    private String registColumnBlankSql(String blankItem, String joinItem) {
        StringBuffer stringBuffer = new StringBuffer();
        //首字符大写，进行字母的ascii编码前移，
        char[] cs = blankItem.toCharArray();
        cs[0] -= 32;
        String columnName = String.valueOf(cs);
        stringBuffer.append(" ").append(joinItem).append(" ( r.").
                append(columnName).append(" IS NULL OR r.").
                append(columnName).append(" = '' ) ");
        return stringBuffer.toString();
    }

    private String registMarkBlankSql(String joinItem) {
        String sql = " " + joinItem + " NOT EXISTS ( " +
                "        SELECT 1 FROM cs_regist_mark g WHERE g.PriPID=r.PriPID " +
                "        )";
        return sql;

    }

    private String registUnlicensedBlankSql(String joinItem) {
        String sql = " " + joinItem + " NOT EXISTS ( " +
                "        SELECT 1 FROM cs_regist_unlicensed u WHERE u.PriPID=r.PriPID " +
                "        )";
        return sql;
    }


    @Override
    public RegistInfoDto getRegistInfoByID(MidBaseInfoDto midBaseInfoDto, RegistInfoDto registinfoq) {
        RegistInfoDto registInfoDto = new RegistInfoDto();
        //基本信息-- 各种联系人信息,请求联络员信息
        registInfoDto = getEPPASSWORDInfo(midBaseInfoDto, registinfoq, registInfoDto);
        
        //查出来主体建档信息.
//        RegistInfoDto registInfoDtotemp = new RegistInfoDto();
//        if (StringUtil.isNotEmpty(registinfoq.getPriPID())) {
//        	registInfoDtotemp = registInfoMapper.selectByPriPid(registinfoq.getPriPID());
//        }
        
        //基本信息--查出来企业联系电话、邮箱、网站网址信息
        if (registInfoDto.getArchState() == null || registInfoDto.getArchState().equals("0")) {
            registInfoDto = getEntInfo(midBaseInfoDto, registinfoq, registInfoDto);
        }
        //未建档的变更重建档，直接返回
     /*   if (registInfoDto == null ||
                ("1".equals(registinfoq.getIsChangeArch()) && registinfoq.getArchState().equals("0"))
                )*/
        //未建档的直接返回
        if ("0".equals(registinfoq.getArchState())) {
            registInfoDto.setPriPID(registinfoq.getPriPID());
            registInfoDto.setArchState(registinfoq.getArchState());
            registInfoDto.setIsChangeArch(registinfoq.getIsChangeArch());
            registInfoDto.setUID(registinfoq.getUID());
            return registInfoDto;
        }

        //查出来主体建档信息.
        if (StringUtil.isNotEmpty(registinfoq.getPriPID())) {
            registInfoDto = registInfoMapper.selectByPriPid(registinfoq.getPriPID());
            registInfoDto.setIsChangeArch(registinfoq.getIsChangeArch());
        }
        return registInfoDto;
    }

    /**
     * 企业电话，邮箱,企业网址
     *
     * @param midBaseInfoDto
     * @param registinfoq
     * @param registInfoDto
     * @return
     */
    public RegistInfoDto getEntInfo(MidBaseInfo midBaseInfoDto, RegistInfoDto registinfoq, RegistInfoDto registInfoDto) {
        YrWebsiteInfo yrWebsiteInfo = new YrWebsiteInfo();
        YrOtherInfo yrOtherInfo = new YrOtherInfo();
        YrPbBaseInfo yrPbBaseInfo = new YrPbBaseInfo();
        YrSfcBaseinfo yrSfcBaseinfo =  new YrSfcBaseinfo();
        Example example = new Example(YrOtherInfo.class);
        example.createCriteria().andEqualTo("priPID", registinfoq.getPriPID());
        example.orderBy("year").desc();
        List<YrOtherInfo> yrOtherInfol = yrOtherInfoMapper.selectByExample(example);
        example = new Example(YrWebsiteInfo.class);
        example.createCriteria().andEqualTo("priPID", registinfoq.getPriPID());
        example.orderBy("year").desc();
        List<YrWebsiteInfo> yrWebsiteInfol = yrWebsiteInfoMapper.selectByExample(example);
        if (yrWebsiteInfol != null && yrWebsiteInfol.size() > 0) {
            yrWebsiteInfo = yrWebsiteInfol.get(0);
        }
        if (yrOtherInfol != null && yrOtherInfol.size() > 0) {
            yrOtherInfo = yrOtherInfol.get(0);
        }
        //设置省市县3级地址
        if(StringUtil.isNotEmpty(midBaseInfoDto.getEntTypeCatg())){
        	if("50".equals(midBaseInfoDto.getEntTypeCatg())){ //个体户
                example = new Example(YrPbBaseInfo.class);
                example.createCriteria().andEqualTo("priPID", registinfoq.getPriPID());
                example.orderBy("year").desc();
                List<YrPbBaseInfo> YrPbBaseInfos = yrPbBaseInfoMapper.selectByExample(example);
                if(YrPbBaseInfos != null && YrPbBaseInfos.size()>0){
                	yrPbBaseInfo = YrPbBaseInfos.get(0);
                }
                registInfoDto.setAreaAddress(yrPbBaseInfo == null ? null : yrPbBaseInfo.getAreaAddress() );
                registInfoDto.setCityAddress(yrPbBaseInfo == null ? null : yrPbBaseInfo.getCityAddress() );
                registInfoDto.setStreeAddress(yrPbBaseInfo == null ? null : yrPbBaseInfo.getStreeAddress() );
                registInfoDto.setDesAddress(yrPbBaseInfo == null ? null : yrPbBaseInfo.getDesAddress() );
                registInfoDto.setDom(yrPbBaseInfo == null ? null : yrPbBaseInfo.getAddr());
        	}else if ("16".equals(midBaseInfoDto.getEntTypeCatg()) || "17".equals(midBaseInfoDto.getEntTypeCatg())){ //农专社
                example = new Example(YrSfcBaseinfo.class);
                example.createCriteria().andEqualTo("priPID", registinfoq.getPriPID());
                example.orderBy("year").desc();
                List<YrSfcBaseinfo> YrSfcBaseInfos = yrSfcBaseInfoMapper.selectByExample(example);
                if(YrSfcBaseInfos != null && YrSfcBaseInfos.size()>0){
                	yrSfcBaseinfo = YrSfcBaseInfos.get(0);
                }
                registInfoDto.setAreaAddress(yrSfcBaseinfo == null ? null : yrSfcBaseinfo.getAreaAddress() );
                registInfoDto.setCityAddress(yrSfcBaseinfo == null ? null : yrSfcBaseinfo.getCityAddress() );
                registInfoDto.setStreeAddress(yrSfcBaseinfo == null ? null : yrSfcBaseinfo.getStreeAddress() );
                registInfoDto.setDesAddress(yrSfcBaseinfo == null ? null : yrSfcBaseinfo.getDesAddress() );
                registInfoDto.setDom(yrSfcBaseinfo == null ? null : yrSfcBaseinfo.getDom());
        	}else{
                registInfoDto.setAreaAddress(yrOtherInfo == null ? null : yrOtherInfo.getAreaAddress() );
                registInfoDto.setCityAddress(yrOtherInfo == null ? null : yrOtherInfo.getCityAddress() );
                registInfoDto.setStreeAddress(yrOtherInfo == null ? null : yrOtherInfo.getStreeAddress() );
                registInfoDto.setDesAddress(yrOtherInfo == null ? null : yrOtherInfo.getDesAddress() );
                registInfoDto.setDom(yrOtherInfo == null ? null : yrOtherInfo.getAddr());
        	}
        	
        }

        
        
        //企业电话，CS_YR_OTHERINFO  cs_mid_baseinfo
        if (yrOtherInfo != null && yrOtherInfo.getOtherInfoIsTel() != null && yrOtherInfo.getOtherInfoIsTel().equals("1")) {
            registInfoDto.setUnitTel(yrOtherInfo.getTel());
        } else {
            registInfoDto.setUnitTel(midBaseInfoDto.getTel());
        }
        //企业邮箱，CS_YR_OTHERINFO  cs_mid_baseinfo
        if (yrOtherInfo != null && yrOtherInfo.getOtherInfoIsEmail() != null && yrOtherInfo.getOtherInfoIsEmail().equals("1")) {
            registInfoDto.setUnitEmail(yrOtherInfo.getEmail());
        } else {
            registInfoDto.setUnitEmail(midBaseInfoDto.getEmail());
        }
        //企业网址 企业年报网站或网店信息表CS_YR_WEBSITEINFO
        if (yrWebsiteInfo != null) {
            registInfoDto.setWebSite(yrWebsiteInfo.getWebSite());
        }
        return registInfoDto;
    }

    /**
     * -- 1联络员信息 ：
     * -- 联络员信息表
     * -- CS_PUB_EPPASSWORD
     * -- 3.4.4企业年报其他情况表
     * -- CS_YR_OTHERINFO
     * -- 准入登记信息表 cs_mid_baseinfo
     * -- 2企业网址： 企业年报网站或网店信息表cs_yr_websiteinfo
     * --  个体户网址：cs_yr_pb_websiteinfo
     * --  农专社网址：cs_yr_sfc_websiteinfo
     * -- 3企业联系电话、企业邮箱： cs_yr_otherinfo  cs_mid_baseinfo
     * -- 4法定代表人姓名和电话：cs_pub_eppassword cs_yr_otherinfo  cs_mid_baseinfo
     * -- 5法定代表人证件号码： cs_mid_baseinfo
     *
     * @param midBaseInfoDto
     * @param registinfoq
     * @param registInfoDto
     * @return
     */
    private RegistInfoDto getEPPASSWORDInfo(MidBaseInfo midBaseInfoDto, RegistInfoDto registinfoq, RegistInfoDto registInfoDto) {
        Example example = new Example(RegistMark.class);
        example.createCriteria().andEqualTo("priPID", registinfoq.getPriPID());
        example.orderBy("year").desc();
        //顺序不能变。因为example的class是共用的。
        PubEppassword pubEppassword = new PubEppassword();
        YrOtherInfo yrOtherInfo = new YrOtherInfo();

        List<YrOtherInfo> yrOtherInfol = yrOtherInfoMapper.selectByExample(example);

        example = new Example(PubEppassword.class);
        example.createCriteria().andEqualTo("pripid", registinfoq.getPriPID());
        example.orderBy("applyTime").desc();
        List<PubEppassword> pubEppasswordl = pubEppasswordMapper.selectByExample(example);
        if (pubEppasswordl != null && pubEppasswordl.size() > 0) {
            pubEppassword = pubEppasswordl.get(0);
        }
        if (yrOtherInfol != null && yrOtherInfol.size() > 0) {
            yrOtherInfo = yrOtherInfol.get(0);
        }


        //法定代表人姓名和电话 CS_PUB_EPPASSWORD CS_YR_OTHERINFO  cs_mid_baseinfo
        if (pubEppassword != null && StringUtil.isNotEmpty(pubEppassword.getLerep())) {
            registInfoDto.setLeRep(pubEppassword.getLerep());
            registInfoDto.setLeRepPhone(pubEppassword.getLerepphone());
        } else if (yrOtherInfo != null && StringUtil.isNotEmpty(yrOtherInfo.getLeRep())) {
            registInfoDto.setLeRep(yrOtherInfo.getLeRep());
            registInfoDto.setLeRepPhone(yrOtherInfo.getLeRepPhone());
        } else {
            registInfoDto.setLeRep(midBaseInfoDto.getLeRep());
            registInfoDto.setLeRepPhone(midBaseInfoDto.getTel());
        }
        //法定代表人证件号码  cs_mid_baseinfo
        registInfoDto.setLeRepCardNo(midBaseInfoDto.getCerNO());
        //企业联络员姓名和电话
        if (pubEppassword != null && StringUtil.isNotEmpty(pubEppassword.getLianame())) {
            registInfoDto.setEntEppa(pubEppassword.getLianame());
            registInfoDto.setEntEppaPhone(pubEppassword.getTel());
        } else {
            registInfoDto.setEntEppa(yrOtherInfo.getLiaName());
            registInfoDto.setEntEppaPhone(yrOtherInfo.getLiaPhone());
        }

        return registInfoDto;
    }

    /**
     * 获取主体标签关联信息
     *
     * @param registInfoDtop
     * @return
     */
    @Override
    public List<RegistMark> selectCsWarnMark(RegistInfoDto registInfoDtop) {
        //未建档的变更重建档不需要查询。
        if (registInfoDtop == null ||
                ("1".equals(registInfoDtop.getIsChangeArch()) && registInfoDtop.getArchState().equals("0")))
            return null;
        List<RegistMark> registMarks = registMarkMapper.selectCsWarnMarkGroupByType(registInfoDtop);
        return registMarks;
    }

    /**
     * 获取监管项目关联信息
     *
     * @param registInfoDtop
     * @return
     */
    @Override
    public List<RegistUnlicensed> selectSuperItem(RegistInfoDto registInfoDtop) {
        //变更重建档不需要查询。
        if (registInfoDtop == null ||
                ("1".equals(registInfoDtop.getIsChangeArch()) && registInfoDtop.getArchState().equals("0")))
            return null;
        List<RegistUnlicensed> superItems = registUnlicensedMapper.selectSuperItem(registInfoDtop);
        return superItems;
    }


    @Override
    public int claim(RegistInfo registInfo) {
        Example example = new Example(RegistInfo.class);
        example.createCriteria().andEqualTo("priPID", registInfo.getPriPID());
        RegistInfoDto registInfoForExist = registInfoMapper.selectByPriPid(registInfo.getPriPID());
        if (registInfoForExist == null) {
            //未分配，插入建档表
            MidBaseInfo midBaseInfo = midBaseInfoMapper.selectMidBaseInfoByPripid(registInfo.getPriPID());
            registInfo.setUID(UUID.randomUUID().toString().replace("-", ""));
            if (midBaseInfo != null) {
                registInfo.setPriPID(midBaseInfo.getPriPID());
                registInfo.setEntName(midBaseInfo.getEntName());
                registInfo.setUniCode(midBaseInfo.getUniCode());
                registInfo.setRegNO(midBaseInfo.getRegNO());
                registInfo.setLocalAdm(midBaseInfo.getLocalAdm());//认领的话，mid表的管辖单位是存在的
                registInfo.setTel(midBaseInfo.getTel());
            }
            registInfo.setCreateTime(new Date());
            registInfo.setIsChangeArch("0");//不是变更重建档
            registInfo.setArchState("0");//未建档
            registInfo.setRegistState("2");//无需分配，直接认领的数据
            registInfo.setClaimState("1");//认领
            return registInfoMapper.insert(registInfo);
        }
        return registInfoMapper.updateByExampleSelective(registInfo, example);
    }


    /**
     * 无论建档和修改都是modi没有插入操作
     * 变更重建档是备份、插入
     *
     * @param registInfoDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int modi(RegistInfoDto registInfoDto,SysUserDto sysUser) {
        int res = 0;

        //2,判断是否变更重建档
        //如果是
        if (registInfoDto.getIsChangeArch() != null && registInfoDto.getIsChangeArch().equals("1")) {
            //备份并且插入建档表
            res = bakHistoryDataAndInsert(registInfoDto);
        }
        //如果不是
        else {
            //更新建档表开始
            Example example = new Example(RegistInfo.class);
            example.createCriteria().andEqualTo("priPID", registInfoDto.getPriPID());
            res = registInfoMapper.updateByExampleSelective(registInfoDto, example);
        }
        if (res == 0) return res;
        //更新cs_mid_baseinfo的片区商圈
        batchUpdateMidBaseinfoSliceNoByPriPid(registInfoDto, registInfoDto.getPriPID().split(","));//调用批量更新的方法，分割，字符串，单个也可以用。
        //更新监管项目关联表
//        res = modiUnlicensed(registInfoDto);
//        if (res == 0) return 0;
        //更新主体标签关联表
        res = modiRegistMark(registInfoDto,sysUser);
        if (res == 0) return 0;
        return res;
    }

    /**
     * 根据前台传入的参数。插入建档表
     *
     * @param registInfoDto
     * @return
     */
    public int insertRegistInfo(RegistInfoDto registInfoDto) {
        registInfoDto.setRegistState("1");
        registInfoDto.setCreateTime(new Date());
        return registInfoMapper.insert(registInfoDto);
    }


    /**
     * 根据传入的priPIDs，批量更新MidBaseinfo的片区商圈
     *
     * @param registInfoDto
     * @return UPDATE cs_mid_baseinfo SET =#{}
     * WHERE PriPID IN(${priPID})
     */
    @Transactional
    private int batchUpdateMidBaseinfoSliceNoByPriPid(RegistInfoDto registInfoDto, String[] priPID) {
        MidBaseInfo midBaseInfo = new MidBaseInfo();
        midBaseInfo.setSliceNO(registInfoDto.getSliceNO());
        midBaseInfo.setSliceNOName(registInfoDto.getSliceNOName());
        Example example = new Example(MidBaseInfo.class);
        example.createCriteria().andIn("priPID", Arrays.asList(priPID));
        return midBaseInfoMapper.updateByExampleSelective(midBaseInfo, example);

    }

    /**
     * registInfoDto里面有前台带过来的管辖单位。
     *
     * @param registInfoDto
     * @return
     */
    @Transactional
    @Override
    public int batchDistribute(RegistInfoDto registInfoDto) {
        int res = 0;
        if (registInfoDto.getPriPID() == null) return 0;

        String[] _pripid = registInfoDto.getPriPID().split(",");
        for (String pripid : _pripid) {
            if (StringUtil.isEmpty(pripid)) continue;
            Example example = new Example(RegistInfo.class);
            example.createCriteria().andEqualTo("priPID", pripid);
            registInfoDto.setPriPID(pripid);
            registInfoDto.setArchState("0");//未建档
            registInfoDto.setClaimState("0");//未认领
            registInfoDto.setRegistState("2");//已分配
            RegistInfoDto infoIsExist = registInfoMapper.selectByPriPid(pripid);
            if (infoIsExist != null) {
                //退回待分配，直接修改
                res = res+registInfoMapper.updateByExampleSelective(registInfoDto, example);
            } else {
                //未分配，插入建档表
                MidBaseInfo midBaseInfo = midBaseInfoMapper.selectMidBaseInfoByPripid(pripid);
                registInfoDto.setUID(UUID.randomUUID().toString().replace("-", ""));
                registInfoDto.setEntName(midBaseInfo.getEntName());
                registInfoDto.setUniCode(midBaseInfo.getUniCode());
                registInfoDto.setRegNO(midBaseInfo.getRegNO());
                registInfoDto.setTel(midBaseInfo.getTel());
                registInfoDto.setCreateTime(new Date());
                registInfoDto.setIsChangeArch("0");//不是变更重建档
                registInfoDto.setArchState("0");//未建档
                registInfoDto.setClaimState("0");//未认领
                res = res+registInfoMapper.insert(registInfoDto);
            }
            //同步mid表的管辖单位
          /*  MidBaseInfo midBaseInfo = new MidBaseInfo();
            midBaseInfo.setLocalAdm(registInfoDto.getLocalAdm());
            midBaseInfo.setLocalAdmName(registInfoDto.getLocalAdmName());
            midBaseInfoMapper.updateByExampleSelective(midBaseInfo, example);*/
        }

        return res;
    }

    /**
     * 批量委托
     *
     * @param registInfo
     * @return
     */
    @Transactional
    @Override
    public int batchDelegate(RegistInfo registInfo) {
        int res = 0;
        if (registInfo.getPriPID() == null) return 0;
        Example example = new Example(RegistInfo.class);
        example.createCriteria().andIn("priPID", Arrays.asList(registInfo.getPriPID().split(",")));
        registInfo.setPriPID(null);
        res = registInfoMapper.updateByExampleSelective(registInfo, example);
        return res;
    }

    @Transactional
    @Override
    public int batchBack(RegistInfoDto registInfo) {
    	int res = 0;
        if (registInfo.getPriPID() == null) return 0;
        String[] _pripid = registInfo.getPriPID().split(",");
        for (String pripid : _pripid) {
            if (StringUtil.isEmpty(pripid)) continue;
            RegistInfoDto registInfoForExist = registInfoMapper.selectByPriPid(pripid);
            if (registInfoForExist == null) {
                //mid表的管辖单位不为空的退回，插入建档表，管辖单位不用插入。
                MidBaseInfo midBaseInfo = midBaseInfoMapper.selectMidBaseInfoByPripid(pripid);
                registInfo.setUID(UUID.randomUUID().toString().replace("-", ""));
                if (midBaseInfo != null) {
                    registInfo.setEntName(midBaseInfo.getEntName());
                    registInfo.setUniCode(midBaseInfo.getUniCode());
                    registInfo.setRegNO(midBaseInfo.getRegNO());
                    registInfo.setTel(midBaseInfo.getTel());
                }
                registInfo.setPriPID(pripid);
                registInfo.setCreateTime(new Date());
                registInfo.setIsChangeArch("0");//不是变更重建档
                registInfo.setArchState("0");//未建档
                registInfo.setRegistState("3");//退回待分配
                registInfo.setClaimState("0");//未认领
                res = res + registInfoMapper.insert(registInfo);
            } else {
                Example example = new Example(MidBaseInfo.class);
                example.createCriteria().andEqualTo("priPID", pripid);
                registInfo.setPriPID(null);
                registInfo.setRegistState("3");
                registInfo.setLocalAdm("");
                registInfo.setClaimName("");
                registInfo.setClaimCode("");
                res = res + registInfoMapper.updateByExampleSelective(registInfo, example);
            }
        }
        return res;

    }

    @Override
    public MidBaseInfoDto selectMidBaseInfoByPripid(String priPID) {
        MidBaseInfoDto midBaseInfoDto = midBaseInfoMapper.selectMidBaseInfoByPripid(priPID);
        return midBaseInfoDto;
    }


    /**
     * 更新监管项目
     *
     * @param registInfoDto
     * @return
     */
    private int modiUnlicensed(RegistInfoDto registInfoDto) {
        int res = 1;
        Example example = new Example(RegistUnlicensed.class);

        if (StringUtil.isEmpty(registInfoDto.getPriPID())) return -1;
        example.createCriteria().andEqualTo("priPID", registInfoDto.getPriPID());
        registUnlicensedMapper.deleteByExample(example);
        RegistUnlicensed registUnlicensed = new RegistUnlicensed();
        registUnlicensed.setPriPID(registInfoDto.getPriPID());
        // registUnlicensed.setUID(null);//是空的。用pripid关联
        String superNos = registInfoDto.getSuperNos();
        String superNames = registInfoDto.getSuperNoNames();
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

    /**
     * 更新主体标签
     *
     * @param registInfoDto
     * @return
     */
    private int modiRegistMark(RegistInfoDto registInfoDto,SysUserDto sysUser) {
    	int res = 1;
        if (StringUtil.isEmpty(registInfoDto.getPriPID())) return -1;        
        //删除当前企业标签表记录
        pubApprMarkRelService.deleteInPriPID(registInfoDto.getPriPID());
        
        PubApprMarkRel pubApprMarkRel = new PubApprMarkRel();
        pubApprMarkRel.setPriPID(registInfoDto.getPriPID());
        //注意iDCode是以逗号形式分割的字符串，因为是批量插入的
        String idCodes = registInfoDto.getiDCodes();
        String idCodeNames = registInfoDto.getiDCodeNames();
        if (idCodes != null) {
            String[] superNo = idCodes.split(",");
            String[] superName = idCodeNames.split(",");
            for (int i = 0; i < superNo.length; i++) {
                if (superNo[i].equals("")) continue;
                pubApprMarkRel.setMarkCode(superNo[i]);
                pubApprMarkRel.setMarkName(superName[i]);
                res = pubApprMarkRelMapper.insert(pubApprMarkRel);
                if (res == 0) 
                	return res;
            }
            //更新专项库
            List<RegistMark> strList = registMarkService.queryDoublyStoThiInfo(idCodes);
//            if(strList != null && strList.size() > 0){
            	try {
					pubScSpecialLibraryService.doNewSaveMarkToSpecialLibrary(registInfoDto.getPriPID(),strList,"2" ,sysUser);
				} catch (Exception e) {
					e.printStackTrace();
                	return res;
				}
//            }  
        }
        return res;
    }
    
    
    
    /**
     * 
     * 描述: 待分配(建档待分配及初始待分配)数量
     * @auther gaojinling
     * @date 2017年10月12日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectAltRegistInfoCount(Map<String, Object> map) throws Exception{
    	map.put("regState", RegStateEnum.CUNXU.getParam());
    	return registInfoMapper.selectAltRegistInfoCount(map);
    }
    
    /**
     * 
     * 描述: 新户待建档
     * @auther gaojinling
     * @date 2017年10月13日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectNewRegistInfoCount(Map<String, Object> map) throws Exception{
    	map.put("regState", RegStateEnum.CUNXU.getParam());
    	return registInfoMapper.selectNewRegistInfoCount(map);

    }
    
    /**
     * 
     * 描述: 变更户待建档
     * @auther gaojinling
     * @date 2017年10月13日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectModRegistInfoCount(Map<String, Object> map) throws Exception{
    	map.put("regState", RegStateEnum.CUNXU.getParam());
    	return registInfoMapper.selectModRegistInfoCount(map);

    }
    
    
    


}