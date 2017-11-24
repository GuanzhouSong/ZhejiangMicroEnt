/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.yr.mapper.SfcCominfoMapper;
import com.icinfo.cs.yr.model.SfcCominfo;
import com.icinfo.cs.yr.service.ISfcCominfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述:  cs_sfc_cominfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Service
public class SfcCominfoServiceImpl extends MyBatisServiceSupport implements ISfcCominfoService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcCominfoServiceImpl.class);

    @Autowired
    private SfcCominfoMapper sfcCominfoMapper;


    /** 更新数据
     *@author: wangjin
     * @param sfcCominfo
     * @return
     */
    @Override
    public int update(SfcCominfo sfcCominfo) {
        if(StringUtils.isNotBlank(sfcCominfo.getPriPID())&&sfcCominfo.getId()!=null){
            //sfcCominfo.setCreateTime(DateUtils.getSysDate()); //更新时间戳
            swtichBigDecimal(sfcCominfo,"1");
            Example example = new Example(SfcCominfo.class);
            example.createCriteria().andEqualTo("id", sfcCominfo.getId()).andEqualTo("priPID",sfcCominfo.getPriPID()).andEqualTo("year",sfcCominfo.getYear());
            return sfcCominfoMapper.updateByExample(sfcCominfo,example);
        }
        return 0;

    }


    /** 新增数据
     * @author: wangjin
     * @param sfcCominfo
     * @return
     */
    @Override
    public int insert(SfcCominfo sfcCominfo) {
        sfcCominfo.setCreateTime(DateUtils.getSysDate());
        swtichBigDecimal(sfcCominfo,"1");
        return sfcCominfoMapper.insert(sfcCominfo);
    }

    /**
     * @author: wangjin
     * 根据 年份和身份主体代码查询当前对象
     * @param year
     * @param priPID
     * @return
     */
    @Override
    public SfcCominfo selectByYearAndPripid(Integer year, String priPID) {
        if(StringUtils.isNotBlank(priPID)&& year!=null){
            SfcCominfo sfcCominfo = new SfcCominfo();
            sfcCominfo.setYear(year);
            sfcCominfo.setPriPID(priPID);
            sfcCominfo = sfcCominfoMapper.selectOne(sfcCominfo) ;
            if(sfcCominfo!=null){swtichBigDecimal(sfcCominfo,"2");} //查询
            return sfcCominfo;
        }
        return null;

    }

    /**
     * 金额转换
     * @AUTHOR:wangjin
     * @param sfcCominfo
     * @param flag
     */
    public void swtichBigDecimal( SfcCominfo sfcCominfo, String flag) {
        if("1".equals(flag)){
            /**社员年均纯收入(元)*/
            sfcCominfo.setFarArtAreNetIncome(bigDecimalDivideWan(sfcCominfo.getFarArtAreNetIncome()));
        }else if("2".equals(flag)){
            /**自有生产经营设备价值；单位：万元*/
            sfcCominfo.setFarArtOpeEquVal(sfcCominfo.getFarArtOpeEquVal()==null?null:sfcCominfo.getFarArtOpeEquVal().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 合作社投资总规模；单位：万元 */
            sfcCominfo.setFarArtCoopTotalInv(sfcCominfo.getFarArtCoopTotalInv()==null?null:sfcCominfo.getFarArtCoopTotalInv().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 其中：成员出资；单位：万元 */
            sfcCominfo.setFarArtMemInv(sfcCominfo.getFarArtMemInv()==null?null:sfcCominfo.getFarArtMemInv().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 贷款额,单位：万元 */
            sfcCominfo.setFarArtLoanAmount(sfcCominfo.getFarArtLoanAmount()==null?null:sfcCominfo.getFarArtLoanAmount().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 政府补助；单位：万元 */
            sfcCominfo.setFarArtGovGrants(sfcCominfo.getFarArtGovGrants()==null?null:sfcCominfo.getFarArtGovGrants().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 上年度销售总额；单位：万元 */
            sfcCominfo.setFarArtTotalSales(sfcCominfo.getFarArtTotalSales()==null?null:sfcCominfo.getFarArtTotalSales().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 利润总额；单位：万元 */
            sfcCominfo.setFarArtTotalProfit(sfcCominfo.getFarArtTotalProfit()==null?null:sfcCominfo.getFarArtTotalProfit().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 全年纳税总额；单位：万元 */
            sfcCominfo.setFarArtTaxAmount(sfcCominfo.getFarArtTaxAmount()==null?null:sfcCominfo.getFarArtTaxAmount().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 其中：所得税总额(万元) */
            sfcCominfo.setFarArtGroIncTax(sfcCominfo.getFarArtGroIncTax()==null?null:sfcCominfo.getFarArtGroIncTax().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 享受扶持资金；单位：万元 */
            sfcCominfo.setFarArtSupFinancing(sfcCominfo.getFarArtSupFinancing()==null?null:sfcCominfo.getFarArtSupFinancing().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 税费减免总额；单位：万元 */
            sfcCominfo.setFarArtTotalTaxCuts(sfcCominfo.getFarArtTotalTaxCuts()==null?null:sfcCominfo.getFarArtTotalTaxCuts().setScale(4,BigDecimal.ROUND_HALF_UP));
            /** 其中累计用于网络广告费用*/
             sfcCominfo.setFarArtNetAdCost(sfcCominfo.getFarArtNetAdCost()==null?null:sfcCominfo.getFarArtNetAdCost().setScale(4,BigDecimal.ROUND_HALF_UP));
            /**其中上年度网上销售额(万元)*/
            sfcCominfo.setFarArtNetSalesAmount(sfcCominfo.getFarArtNetSalesAmount()==null?null:sfcCominfo.getFarArtNetSalesAmount().setScale(4,BigDecimal.ROUND_HALF_UP));

            /** 合同金额；单位：万元   暂时未知*/
           /* sfcCominfo.setFarArtContAmount(sfcCominfo.getFarArtContAmount()==null?null:sfcCominfo.getFarArtContAmount().setScale(4,BigDecimal.ROUND_HALF_UP));*/
            //-----单位是元 万元转换成元  保留两位小数
            /** 社员年均纯收入；单位：元 */
            sfcCominfo.setFarArtAreNetIncome(sfcCominfo.getFarArtAreNetIncome()==null?null: sfcCominfo.getFarArtAreNetIncome().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));

            //百分比
            /**销售额年增长率*/
            sfcCominfo.setFarArtSalesIncRatio(sfcCominfo.getFarArtSalesIncRatio() == null ? null : sfcCominfo.getFarArtSalesIncRatio().setScale(3, BigDecimal.ROUND_HALF_UP));
            /**统一采购农业投入品比例*/
            sfcCominfo.setFarArtInpProRatio(sfcCominfo.getFarArtInpProRatio() == null ? null : sfcCominfo.getFarArtInpProRatio().setScale(3, BigDecimal.ROUND_HALF_UP));
            /**统一销售主产品比例*/
            sfcCominfo.setFarArtSaleProRatio(sfcCominfo.getFarArtSaleProRatio()==null?null:sfcCominfo.getFarArtSaleProRatio().setScale(3,BigDecimal.ROUND_HALF_UP));

        }
    }


    /**
     *
     * 描述: 元转化为万元
     * @author: 赵祥江
     * @date  : 2016年8月30日 上午10:15:44
     * @return: BigDecimal
     * @throws
     */
    public BigDecimal  bigDecimalDivideWan(BigDecimal s){
        return  s==null?null:s.divide(new BigDecimal(10000));
    }

    /**
     *
     * 描述: 万元转换成元  保留两位小数
     * @author: 赵祥江
     * @date  : 2016年8月30日 上午10:16:43
     * @param :
     * @return: BigDecimal
     * @throws
     */
    public BigDecimal bigDecimalDivideYuan(BigDecimal s) {
        return s == null ? null : s.multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }


}

