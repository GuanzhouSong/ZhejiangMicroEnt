/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.SfcIncomechangeMapper;
import com.icinfo.cs.yr.model.SfcIncomechange;
import com.icinfo.cs.yr.model.SfcIncstatement;
import com.icinfo.cs.yr.service.ISfcIncomechangeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_sfc_incomechange 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月27日
 */
@Service
public class SfcIncomechangeServiceImpl extends MyBatisServiceSupport implements ISfcIncomechangeService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcIncomechangeServiceImpl.class);

    @Autowired
    private SfcIncomechangeMapper sfcIncomechangeMapper;

    /**
     * 根据 年份和身份主体代码查询当前对象
     *@author: wangjin
     * @param year
     * @param priPID
     * @return
     */
    @Override
    public SfcIncomechange selectByYearAndPripid(Integer year, String priPID) {
        if(year!=null&& StringUtils.isNotBlank(priPID)){
            SfcIncomechange sfcIncomechange = new SfcIncomechange();
            sfcIncomechange.setYear(year);
            sfcIncomechange.setPriPID(priPID);
            sfcIncomechange = sfcIncomechangeMapper.selectOne(sfcIncomechange);
            getBigDecimal(sfcIncomechange);
            return sfcIncomechange;
        }
        return null;
    }
    /**
     * 更新数据
     * @author: wangjin
     * @param sfcIncomechange
     * @return
     */
    @Override
    public int update(SfcIncomechange sfcIncomechange) {
        if(StringUtils.isNotBlank(sfcIncomechange.getPriPID())&&sfcIncomechange.getId()!=null){
            //sfcIncomechange.setCreateTime(DateUtils.getSysDate());
            swtichBigDecimal(sfcIncomechange);// 元 转换成 万元入库
            Example example = new Example(SfcIncstatement.class);
            example.createCriteria().andEqualTo("id", sfcIncomechange.getId()).andEqualTo("priPID",sfcIncomechange.getPriPID()).andEqualTo("year",sfcIncomechange.getYear());
            return sfcIncomechangeMapper.updateByExampleSelective(sfcIncomechange,example);
        }
        return 0;
    }
    /**
     * 更新数据
     * @author: wangjin
     * @param sfcIncomechange
     * @return
     */
    @Override
    public int insert(SfcIncomechange sfcIncomechange) {
        sfcIncomechange.setCreateTime(DateUtils.getSysDate());
        swtichBigDecimal(sfcIncomechange);// 元 转换成 万元入库
        return sfcIncomechangeMapper.insert(sfcIncomechange);
    }


    /**
     * 金额 元 转换成 万元
     * @author: wangjin
     * @param sfcIncomechange
     * @return
     */
    private SfcIncomechange swtichBigDecimal(SfcIncomechange sfcIncomechange) {

        if(sfcIncomechange!=null) {
                /** 股金-年初余额（万元） */
                    sfcIncomechange.setChgStockStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockStartBal()));
                /** 股金-本年增加数 */
                    sfcIncomechange.setChgStockAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockAdd()));
                /** 股金-本年增加数--资本公积转赠 */
                    sfcIncomechange.setChgStockAddCap(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockAddCap()));
                /** 股金-本年增加数--盈余公积转赠 */
                    sfcIncomechange.setChgStockAddSur(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockAddSur()));
                /** 股金-本年增加数--成员增加出资 */
                    sfcIncomechange.setChgStockAddMem(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockAddMem()));
                /** 股金-本年减少数 */
                    sfcIncomechange.setChgStockLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockLess()));
                /** 股金-年末余额 */
                    sfcIncomechange.setChgStockEndBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgStockEndBal()));
                /** 专项基金-年初余额 */
                    sfcIncomechange.setChgFundStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundStartBal()));
                /** 专项基金-本年增加数 */
                    sfcIncomechange.setChgFundAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundAdd()));
                /** 专项基金-本年增加数-国家财政直接补助 */
                    sfcIncomechange.setChgFundAddSsd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundAddSsd()));
                /** 专项基金-本年增加数-接受捐赠转入 */
                    sfcIncomechange.setChgFundAddDona(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundAddDona()));
                /** 专项基金-本年减少数 */
                    sfcIncomechange.setChgFundLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundLess()));
                /** 专项基金-年末余额 */
                    sfcIncomechange.setChgFundEndBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgFundEndBal()));
                /** 资本公积--年初余额 */
                    sfcIncomechange.setChgCapitalStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalStartBal()));
                /** 资本公积--本年增加数 */
                    sfcIncomechange.setChgCapitalAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalAdd()));
                /** 资本公积--本年增加数--股金溢价 */
                    sfcIncomechange.setChgCapitalAddPre(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalAddPre()));
                /** 资本公积-本年增加数--资产评估增值 */
                    sfcIncomechange.setChgCapitalAddAppr(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalAddAppr()));
                /** 资本公积-本年减少数 */
                    sfcIncomechange.setChgCapitalLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalLess()));
                /** 资本公积-年末余额 */
                    sfcIncomechange.setChgCapitalEndBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgCapitalEndBal()));
                /** 盈余公积-年初余额 */
                    sfcIncomechange.setChgProfitStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgProfitStartBal()));
                /** 盈余公积-本年增加数 */
                    sfcIncomechange.setChgProfitAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgProfitAdd()));
                /** 盈余公积-本年增加数-从盈余中提取 */
                    sfcIncomechange.setChgProfitAddSur(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgProfitAddSur()));
                /** 盈余公积-本年减少数 */
                    sfcIncomechange.setChgProfitLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgProfitLess()));
                /** 盈余公积-年末余额 */
                    sfcIncomechange.setChgProfitEndBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgProfitEndBal()));
                /** 未分配盈余-年初余额 */
                    sfcIncomechange.setChgNogetStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetStartBal()));
                /** 未分配盈余-本年增加数 */
                    sfcIncomechange.setChgNogetAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetAdd()));
                /** 未分配盈余-本年减少数 */
                    sfcIncomechange.setChgNogetLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetLess()));
                /** 未分配盈余-按交易量（额）分配的盈余 */
                    sfcIncomechange.setChgNogetLessVol(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetLessVol()));
                /** 未分配盈余-剩余盈余分配 */
                    sfcIncomechange.setChgNogetLessSur(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetLessSur()));
                /** 未分配盈余-年末余额 */
                    sfcIncomechange.setChgNogetEndBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgNogetEndBal()));
                /** 合计-年初余额 */
                    sfcIncomechange.setChgTotalStartBal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgTotalStartBal()));
                /** 合计-本年增加数 */
                    sfcIncomechange.setChgTotalAdd(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgTotalAdd()));
                /** 合计-本年减少数 */
                    sfcIncomechange.setChgTotalLess(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgTotalLess()));
                /** 合计-年末余额 */
                    sfcIncomechange.setChgTotalEndbal(StringUtil.bigDecimalDivideWan(sfcIncomechange.getChgTotalEndbal()));

        }

        return sfcIncomechange;
    }

    /**
     *  获取数据 将万元转换成元 并保留2位有效数字
     *  @author: wangjin
     * @param sfcIncomechange
     * @return
     */
    private SfcIncomechange getBigDecimal(SfcIncomechange sfcIncomechange) {
        if(sfcIncomechange!=null){
            /** 股金-年初余额（万元） */
            sfcIncomechange.setChgStockStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockStartBal()));
            /** 股金-本年增加数 */
            sfcIncomechange.setChgStockAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockAdd()));
            /** 股金-本年增加数--资本公积转赠 */
            sfcIncomechange.setChgStockAddCap(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockAddCap()));
            /** 股金-本年增加数--盈余公积转赠 */
            sfcIncomechange.setChgStockAddSur(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockAddSur()));
            /** 股金-本年增加数--成员增加出资 */
            sfcIncomechange.setChgStockAddMem(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockAddMem()));
            /** 股金-本年减少数 */
            sfcIncomechange.setChgStockLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockLess()));
            /** 股金-年末余额 */
            sfcIncomechange.setChgStockEndBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgStockEndBal()));
            /** 专项基金-年初余额 */
            sfcIncomechange.setChgFundStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundStartBal()));
            /** 专项基金-本年增加数 */
            sfcIncomechange.setChgFundAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundAdd()));
            /** 专项基金-本年增加数-国家财政直接补助 */
            sfcIncomechange.setChgFundAddSsd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundAddSsd()));
            /** 专项基金-本年增加数-接受捐赠转入 */
            sfcIncomechange.setChgFundAddDona(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundAddDona()));
            /** 专项基金-本年减少数 */
            sfcIncomechange.setChgFundLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundLess()));
            /** 专项基金-年末余额 */
            sfcIncomechange.setChgFundEndBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgFundEndBal()));
            /** 资本公积--年初余额 */
            sfcIncomechange.setChgCapitalStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalStartBal()));
            /** 资本公积--本年增加数 */
            sfcIncomechange.setChgCapitalAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalAdd()));
            /** 资本公积--本年增加数--股金溢价 */
            sfcIncomechange.setChgCapitalAddPre(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalAddPre()));
            /** 资本公积-本年增加数--资产评估增值 */
            sfcIncomechange.setChgCapitalAddAppr(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalAddAppr()));
            /** 资本公积-本年减少数 */
            sfcIncomechange.setChgCapitalLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalLess()));
            /** 资本公积-年末余额 */
            sfcIncomechange.setChgCapitalEndBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgCapitalEndBal()));
            /** 盈余公积-年初余额 */
            sfcIncomechange.setChgProfitStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgProfitStartBal()));
            /** 盈余公积-本年增加数 */
            sfcIncomechange.setChgProfitAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgProfitAdd()));
            /** 盈余公积-本年增加数-从盈余中提取 */
            sfcIncomechange.setChgProfitAddSur(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgProfitAddSur()));
            /** 盈余公积-本年减少数 */
            sfcIncomechange.setChgProfitLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgProfitLess()));
            /** 盈余公积-年末余额 */
            sfcIncomechange.setChgProfitEndBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgProfitEndBal()));
            /** 未分配盈余-年初余额 */
            sfcIncomechange.setChgNogetStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetStartBal()));
            /** 未分配盈余-本年增加数 */
            sfcIncomechange.setChgNogetAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetAdd()));
            /** 未分配盈余-本年减少数 */
            sfcIncomechange.setChgNogetLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetLess()));
            /** 未分配盈余-按交易量（额）分配的盈余 */
            sfcIncomechange.setChgNogetLessVol(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetLessVol()));
            /** 未分配盈余-剩余盈余分配 */
            sfcIncomechange.setChgNogetLessSur(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetLessSur()));
            /** 未分配盈余-年末余额 */
            sfcIncomechange.setChgNogetEndBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgNogetEndBal()));
            /** 合计-年初余额 */
            sfcIncomechange.setChgTotalStartBal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgTotalStartBal()));
            /** 合计-本年增加数 */
            sfcIncomechange.setChgTotalAdd(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgTotalAdd()));
            /** 合计-本年减少数 */
            sfcIncomechange.setChgTotalLess(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgTotalLess()));
            /** 合计-年末余额 */
            sfcIncomechange.setChgTotalEndbal(StringUtil.getBigDecimalDivideYuan(sfcIncomechange.getChgTotalEndbal()));
        }

        return sfcIncomechange;
    }




}