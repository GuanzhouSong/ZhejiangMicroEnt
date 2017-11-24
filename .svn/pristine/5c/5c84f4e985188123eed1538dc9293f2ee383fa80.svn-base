/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.SfcIncstatementMapper;
import com.icinfo.cs.yr.model.SfcIncstatement;
import com.icinfo.cs.yr.service.ISfcIncstatementService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_sfc_incstatement 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月23日
 */
@Service
public class SfcIncstatementServiceImpl extends MyBatisServiceSupport implements ISfcIncstatementService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcIncstatementServiceImpl.class);

    @Autowired
    private SfcIncstatementMapper sfcIncstatementMapper;

    /**
     * 根据 年份和身份主体代码查询当前对象
     *@author: wangjin
     * @param year
     * @param priPID
     * @return
     */
    @Override
    public SfcIncstatement selectByYearAndPripid(Integer year, String priPID) {
        if(year!=null&& StringUtils.isNotBlank(priPID)){
            SfcIncstatement sfcIncstatement = new SfcIncstatement();
            sfcIncstatement.setYear(year);
            sfcIncstatement.setPriPID(priPID);
            sfcIncstatement = sfcIncstatementMapper.selectOne(sfcIncstatement);
            getBigDecimal(sfcIncstatement);
            return sfcIncstatement;
        }
        return null;
    }

    /**
     * 更新数据
     * @author: wangjin
     * @param sfcIncstatement
     * @return
     */
    @Override
    public int update(SfcIncstatement sfcIncstatement) {
        if(StringUtils.isNotBlank(sfcIncstatement.getPriPID())&&sfcIncstatement.getId()!=null){
            //sfcIncstatement.setCreateTime(DateUtils.getSysDate()); //更新时间戳
            swtichBigDecimal(sfcIncstatement);// 元 转换成 万元入库
            Example example = new Example(SfcIncstatement.class);
            example.createCriteria().andEqualTo("id", sfcIncstatement.getId()).andEqualTo("priPID",sfcIncstatement.getPriPID()).andEqualTo("year",sfcIncstatement.getYear());
            return sfcIncstatementMapper.updateByExampleSelective(sfcIncstatement,example);
        }
        return 0;
    }

    /**
     * 新增数据
     * @author: wangjin
     * @param sfcIncstatement
     * @return
     */
    @Override
    public int insert(SfcIncstatement sfcIncstatement) {
        sfcIncstatement.setCreateTime(DateUtils.getSysDate());
        swtichBigDecimal(sfcIncstatement);// 元 转换成 万元入库
        return sfcIncstatementMapper.insert(sfcIncstatement);
    }

    /**
     * 金额 元 转换成 万元
     * @author: wangjin
     * @param sfcIncstatement
     * @return
     */
    private SfcIncstatement swtichBigDecimal(SfcIncstatement sfcIncstatement) {
        if(sfcIncstatement!=null) {
            /** 经营收入 */
            sfcIncstatement.setBusInc(StringUtil.bigDecimalDivideWan(sfcIncstatement.getBusInc()));
            /** 加：投资收益 */
            sfcIncstatement.setAnnDisInc(StringUtil.bigDecimalDivideWan(sfcIncstatement.getAnnDisInc()));
            /** 减：经营支出 */
            sfcIncstatement.setBusSpend(StringUtil.bigDecimalDivideWan(sfcIncstatement.getBusSpend()));
            /** 管理费用 */
            sfcIncstatement.setManageFees(StringUtil.bigDecimalDivideWan(sfcIncstatement.getManageFees()));
            /** 经营收益 */
            sfcIncstatement.setBusEarn(StringUtil.bigDecimalDivideWan(sfcIncstatement.getBusEarn()));
            /** 加：其他收入 */
            sfcIncstatement.setOtherInc(StringUtil.bigDecimalDivideWan(sfcIncstatement.getOtherInc()));
            /** 减：其他支出 */
            sfcIncstatement.setOtherSpend(StringUtil.bigDecimalDivideWan(sfcIncstatement.getOtherSpend()));
            /** 三、本年盈余 */
            sfcIncstatement.setThisSurplus(StringUtil.bigDecimalDivideWan(sfcIncstatement.getThisSurplus()));
            /** 四、本年盈余 */
            sfcIncstatement.setThatSurplus(StringUtil.bigDecimalDivideWan(sfcIncstatement.getThatSurplus()));
            /** 加：年初未分配盈余 */
            sfcIncstatement.setUndistSurplusBegin(StringUtil.bigDecimalDivideWan(sfcIncstatement.getUndistSurplusBegin()));
            /** 其他转入 */
            sfcIncstatement.setOtherTrans(StringUtil.bigDecimalDivideWan(sfcIncstatement.getOtherTrans()));
            /** 五、可分配盈余 */
            sfcIncstatement.setDistSurplus(StringUtil.bigDecimalDivideWan(sfcIncstatement.getDistSurplus()));
            /** 减：提取盈余公积 */
            sfcIncstatement.setExtSurAccuFund(StringUtil.bigDecimalDivideWan(sfcIncstatement.getExtSurAccuFund()));
            /** 盈余返还 */
            sfcIncstatement.setReturnSurplusPay(StringUtil.bigDecimalDivideWan(sfcIncstatement.getReturnSurplusPay()));
            /** 剩余盈余分配 */
            sfcIncstatement.setRemainSurplusPay(StringUtil.bigDecimalDivideWan(sfcIncstatement.getRemainSurplusPay()));
            /** 六、年末未分配盈余 */
            sfcIncstatement.setUndistSurplusEnd(StringUtil.bigDecimalDivideWan(sfcIncstatement.getUndistSurplusEnd()));

        }
        return sfcIncstatement;
    }
    /**
     *  获取数据 将万元转换成元 并保留2位有效数字
     *  @author: wangjin
     * @param sfcIncstatement
     * @return
     */
    private SfcIncstatement getBigDecimal(SfcIncstatement sfcIncstatement) {

        if(sfcIncstatement!=null) {
            /** 经营收入 */
            sfcIncstatement.setBusInc(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getBusInc()));
            /** 加：投资收益 */
            sfcIncstatement.setAnnDisInc(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getAnnDisInc()));
            /** 减：经营支出 */
            sfcIncstatement.setBusSpend(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getBusSpend()));
            /** 管理费用 */
            sfcIncstatement.setManageFees(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getManageFees()));
            /** 经营收益 */
            sfcIncstatement.setBusEarn(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getBusEarn()));
            /** 加：其他收入 */
            sfcIncstatement.setOtherInc(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getOtherInc()));
            /** 减：其他支出 */
            sfcIncstatement.setOtherSpend(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getOtherSpend()));
            /** 三、本年盈余 */
            sfcIncstatement.setThisSurplus(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getThisSurplus()));
            /** 四、本年盈余 */
            sfcIncstatement.setThatSurplus(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getThatSurplus()));
            /** 加：年初未分配盈余 */
            sfcIncstatement.setUndistSurplusBegin(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getUndistSurplusBegin()));
            /** 其他转入 */
            sfcIncstatement.setOtherTrans(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getOtherTrans()));
            /** 五、可分配盈余 */
            sfcIncstatement.setDistSurplus(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getDistSurplus()));
            /** 减：提取盈余公积 */
            sfcIncstatement.setExtSurAccuFund(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getExtSurAccuFund()));
            /** 盈余返还 */
            sfcIncstatement.setReturnSurplusPay(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getReturnSurplusPay()));
            /** 剩余盈余分配 */
            sfcIncstatement.setRemainSurplusPay(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getRemainSurplusPay()));
            /** 六、年末未分配盈余 */
            sfcIncstatement.setUndistSurplusEnd(StringUtil.getBigDecimalDivideYuan(sfcIncstatement.getUndistSurplusEnd()));
        }

        return sfcIncstatement;
    }

}