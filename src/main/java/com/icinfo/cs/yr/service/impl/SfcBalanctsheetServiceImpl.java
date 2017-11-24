/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.SfcBalanctsheetMapper;
import com.icinfo.cs.yr.model.SfcBalanctsheet;
import com.icinfo.cs.yr.service.ISfcBalanctsheetService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:  cs_sfc_balanctsheet 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月23日
 */
@Service
public class SfcBalanctsheetServiceImpl extends MyBatisServiceSupport implements ISfcBalanctsheetService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcBalanctsheetServiceImpl.class);

    @Autowired
    private SfcBalanctsheetMapper sfcBalanctsheetMapper;


    /**
     * 根据 年份和身份主体代码查询表数据集合
     * @author: wangjin
     * @param year
     * @param priPID
     * @return
     */
    @Override
    public List<SfcBalanctsheet> selectByYearAndPripid(Integer year, String priPID) {
        if(StringUtils.isNotBlank(priPID)&&year!=null){
            Example example = new Example(SfcBalanctsheet.class);
            example.setOrderByClause(" BalanceType asc ");
            Example.Criteria criteria = example.createCriteria().andEqualTo("priPID", priPID);
            criteria.andEqualTo("year", year);
            List<SfcBalanctsheet> sfcBalanctsheetList = sfcBalanctsheetMapper.selectByExample(example);
            for(SfcBalanctsheet s: sfcBalanctsheetList){
                getBigDecimal(s); //获取数据 并将万元 设置为 元
            }
            return sfcBalanctsheetList;
        }
        return  null;
    }


    /**
     * 更新数据
     * @author: wangjin
     * @param sfcBalanctsheetList
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int update(List<SfcBalanctsheet> sfcBalanctsheetList) {
        if(StringUtils.isNotBlank(sfcBalanctsheetList.get(0).getPriPID())&&sfcBalanctsheetList.get(0).getId()!=null&&sfcBalanctsheetList.get(1).getId()!=null){
            int i = 0;
            if(CollectionUtils.isNotEmpty(sfcBalanctsheetList)){
                for(SfcBalanctsheet s: sfcBalanctsheetList){
                    swtichBigDecimal(s); // 元 转换成 万元入库
                    Example example = new Example(SfcBalanctsheet.class);
                    Example.Criteria criteria = example.createCriteria().andEqualTo("priPID", s.getPriPID()).andEqualTo("id",s.getId());
                    criteria.andEqualTo("year", s.getYear());
                    criteria.andEqualTo("balanceType", s.getBalanceType());
                    
                    i = sfcBalanctsheetMapper.updateByExampleSelective(s,example);
                }
            }
            return i;
        }
        return 0;
    }
    /**
     * 新增数据
     * @author: wangjin
     * @param sfcBalanctsheetList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(List<SfcBalanctsheet> sfcBalanctsheetList) {
        int i=0;
        if(CollectionUtils.isNotEmpty(sfcBalanctsheetList)){
            SfcBalanctsheet sfcBalanctsheet1 = sfcBalanctsheetList.get(0);
            SfcBalanctsheet sfcBalanctsheet2 = sfcBalanctsheetList.get(1);
            sfcBalanctsheet1.setCreateTime(DateUtils.getSysDate());
            sfcBalanctsheet2.setCreateTime(DateUtils.getSysDate());
            swtichBigDecimal(sfcBalanctsheet1);// 元 转换成 万元入库
            swtichBigDecimal(sfcBalanctsheet2);// 元 转换成 万元入库
                 sfcBalanctsheetMapper.insert(sfcBalanctsheet1);
             i = sfcBalanctsheetMapper.insert(sfcBalanctsheet2);
        }
        return i;
    }

    /**
     * 金额 元 转换成 万元
     * @author: wangjin
     * @param sfcBalanctsheet
     * @return
     */
    private SfcBalanctsheet swtichBigDecimal(SfcBalanctsheet sfcBalanctsheet) {
        if(sfcBalanctsheet!=null) {
            /** 货币资金 */
            sfcBalanctsheet.setMoneFunds(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getMoneFunds()));

            /** 应收款项 */
            sfcBalanctsheet.setAccRec(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getAccRec()));

            /** 存货 */
            sfcBalanctsheet.setInventory(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getInventory()));

            /** 流动资产合计 */
            sfcBalanctsheet.setTotCurrAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getTotCurrAssets()));

            /** 对外投资 */
            sfcBalanctsheet.setForInvestAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getForInvestAssets()));

            /** 牲畜(禽)资产 */
            sfcBalanctsheet.setLiveStockAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getLiveStockAssets()));

            /** 林木资产 */
            sfcBalanctsheet.setTreeAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getTreeAssets()));

            /** 农业资产合计 */
            sfcBalanctsheet.setArgAssetsAmount(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getArgAssetsAmount()));

            /** 固定资产原值 */
            sfcBalanctsheet.setFixAssetsOri(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getFixAssetsOri()));

            /** 减：累计折旧 */
            sfcBalanctsheet.setAccDepreciation(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getAccDepreciation()));

            /** 固定资产净值 */
            sfcBalanctsheet.setFixAssetsWorth(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getFixAssetsWorth()));

            /** 固定资产清理 */
            sfcBalanctsheet.setFixAssetsClean(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getFixAssetsClean()));

            /** 在建工程 */
            sfcBalanctsheet.setProConstr(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getProConstr()));

            /** 固定资产合计 */
            sfcBalanctsheet.setFixAssetsAmount(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getFixAssetsAmount()));

            /** 无形资产 */
            sfcBalanctsheet.setIntAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getIntAssets()));

            /** 长期资产合计 */
            sfcBalanctsheet.setLongAssetsAmount(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getLongAssetsAmount()));

            /** 资产总计 */
            sfcBalanctsheet.setAssGro(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getAssGro()));

            /** 短期借款 */
            sfcBalanctsheet.setShortBorrowing(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getShortBorrowing()));

            /** 应付款项 */
            sfcBalanctsheet.setAccPay(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getAccPay()));

            /** 应付工资 */
            sfcBalanctsheet.setWagePay(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getWagePay()));

            /** 应付盈余返还 */
            sfcBalanctsheet.setReturnSurplusPay(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getReturnSurplusPay()));

            /** 应付剩余盈余 */
            sfcBalanctsheet.setRemainSurplusPay(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getRemainSurplusPay()));

            /** 流动负债合计 */
            sfcBalanctsheet.setTotCurrLiab(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getTotCurrLiab()));

            /** 长期借款 */
            sfcBalanctsheet.setLongBorrowing(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getLongBorrowing()));

            /** 专项应付款 */
            sfcBalanctsheet.setSpecificPay(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getSpecificPay()));

            /** 长期负债合计 */
            sfcBalanctsheet.setLTermLiaAm(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getLTermLiaAm()));

            /** 负债合计 */
            sfcBalanctsheet.setLiaGro(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getLiaGro()));

            /** 股金 */
            sfcBalanctsheet.setCapitalAmount(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getCapitalAmount()));

            /** 专项基金 */
            sfcBalanctsheet.setSpecificFund(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getSpecificFund()));

            /** 资本公积 */
            sfcBalanctsheet.setCapAccuFund(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getCapAccuFund()));

            /** 盈余公积 */
            sfcBalanctsheet.setSurAccuFund(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getSurAccuFund()));

            /** 未分配盈余 */
            sfcBalanctsheet.setUndistSurplus(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getUndistSurplus()));

            /** 所有者权益合计 */
            sfcBalanctsheet.setTotEqu(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getTotEqu()));

            /** 负债和所有者权益总计 */
            sfcBalanctsheet.setTotLiaEqu(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getTotLiaEqu()));

            /** 无法收回、尚未批准核销的应收款项 */
            sfcBalanctsheet.setApprAccRec(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprAccRec()));

            /** 盘亏、毁损和报废、尚未批准核销的存货 */
            sfcBalanctsheet.setApprInventory(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprInventory()));

            /** 无法收回、尚未批准核销的对外投资 */
            sfcBalanctsheet.setApprForInvestAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprForInvestAssets()));

            /** 死亡毁损、尚未批准核销的农业资产 */
            sfcBalanctsheet.setApprArgAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprArgAssets()));

            /** 盘亏、毁损和报废、尚未批准核销的固定资产 */
            sfcBalanctsheet.setApprFixAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprFixAssets()));

            /** 毁损和报废、尚未批准核销的在建工程 */
            sfcBalanctsheet.setApprProConstr(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprProConstr()));

            /** 注销和无效、尚未批准核销的无形资产 */
            sfcBalanctsheet.setApprIntAssets(StringUtil.bigDecimalDivideWan(sfcBalanctsheet.getApprIntAssets()));
        }
        return sfcBalanctsheet;
    }

    /**
     *  获取数据 将万元转换成元 并保留2位有效数字
     *  @author: wangjin
     * @param sfcBalanctsheet
     * @return
     */
    private SfcBalanctsheet getBigDecimal(SfcBalanctsheet sfcBalanctsheet) {
        if(sfcBalanctsheet!=null){
            /** 货币资金 */
            sfcBalanctsheet.setMoneFunds(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getMoneFunds()));

            /** 应收款项 */
            sfcBalanctsheet.setAccRec(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getAccRec()));

            /** 存货 */
            sfcBalanctsheet.setInventory(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getInventory()));

            /** 流动资产合计 */
            sfcBalanctsheet.setTotCurrAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getTotCurrAssets()));

            /** 对外投资 */
            sfcBalanctsheet.setForInvestAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getForInvestAssets()));

            /** 牲畜(禽)资产 */
            sfcBalanctsheet.setLiveStockAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getLiveStockAssets()));

            /** 林木资产 */
            sfcBalanctsheet.setTreeAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getTreeAssets()));

            /** 农业资产合计 */
            sfcBalanctsheet.setArgAssetsAmount(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getArgAssetsAmount()));

            /** 固定资产原值 */
            sfcBalanctsheet.setFixAssetsOri(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getFixAssetsOri()));

            /** 减：累计折旧 */
            sfcBalanctsheet.setAccDepreciation(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getAccDepreciation()));

            /** 固定资产净值 */
            sfcBalanctsheet.setFixAssetsWorth(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getFixAssetsWorth()));

            /** 固定资产清理 */
            sfcBalanctsheet.setFixAssetsClean(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getFixAssetsClean()));

            /** 在建工程 */
            sfcBalanctsheet.setProConstr(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getProConstr()));

            /** 固定资产合计 */
            sfcBalanctsheet.setFixAssetsAmount(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getFixAssetsAmount()));

            /** 无形资产 */
            sfcBalanctsheet.setIntAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getIntAssets()));

            /** 长期资产合计 */
            sfcBalanctsheet.setLongAssetsAmount(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getLongAssetsAmount()));

            /** 资产总计 */
            sfcBalanctsheet.setAssGro(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getAssGro()));

            /** 短期借款 */
            sfcBalanctsheet.setShortBorrowing(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getShortBorrowing()));

            /** 应付款项 */
            sfcBalanctsheet.setAccPay(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getAccPay()));

            /** 应付工资 */
            sfcBalanctsheet.setWagePay(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getWagePay()));

            /** 应付盈余返还 */
            sfcBalanctsheet.setReturnSurplusPay(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getReturnSurplusPay()));

            /** 应付剩余盈余 */
            sfcBalanctsheet.setRemainSurplusPay(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getRemainSurplusPay()));

            /** 流动负债合计 */
            sfcBalanctsheet.setTotCurrLiab(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getTotCurrLiab()));

            /** 长期借款 */
            sfcBalanctsheet.setLongBorrowing(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getLongBorrowing()));

            /** 专项应付款 */
            sfcBalanctsheet.setSpecificPay(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getSpecificPay()));

            /** 长期负债合计 */
            sfcBalanctsheet.setLTermLiaAm(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getLTermLiaAm()));

            /** 负债合计 */
            sfcBalanctsheet.setLiaGro(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getLiaGro()));

            /** 股金 */
            sfcBalanctsheet.setCapitalAmount(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getCapitalAmount()));

            /** 专项基金 */
            sfcBalanctsheet.setSpecificFund(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getSpecificFund()));

            /** 资本公积 */
            sfcBalanctsheet.setCapAccuFund(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getCapAccuFund()));

            /** 盈余公积 */
            sfcBalanctsheet.setSurAccuFund(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getSurAccuFund()));

            /** 未分配盈余 */
            sfcBalanctsheet.setUndistSurplus(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getUndistSurplus()));

            /** 所有者权益合计 */
            sfcBalanctsheet.setTotEqu(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getTotEqu()));

            /** 负债和所有者权益总计 */
            sfcBalanctsheet.setTotLiaEqu(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getTotLiaEqu()));

            /** 无法收回、尚未批准核销的应收款项 */
            sfcBalanctsheet.setApprAccRec(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprAccRec()));

            /** 盘亏、毁损和报废、尚未批准核销的存货 */
            sfcBalanctsheet.setApprInventory(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprInventory()));

            /** 无法收回、尚未批准核销的对外投资 */
            sfcBalanctsheet.setApprForInvestAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprForInvestAssets()));

            /** 死亡毁损、尚未批准核销的农业资产 */
            sfcBalanctsheet.setApprArgAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprArgAssets()));

            /** 盘亏、毁损和报废、尚未批准核销的固定资产 */
            sfcBalanctsheet.setApprFixAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprFixAssets()));

            /** 毁损和报废、尚未批准核销的在建工程 */
            sfcBalanctsheet.setApprProConstr(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprProConstr()));

            /** 注销和无效、尚未批准核销的无形资产 */
            sfcBalanctsheet.setApprIntAssets(StringUtil.getBigDecimalDivideYuan(sfcBalanctsheet.getApprIntAssets()));
        }
        return sfcBalanctsheet;
    }






}