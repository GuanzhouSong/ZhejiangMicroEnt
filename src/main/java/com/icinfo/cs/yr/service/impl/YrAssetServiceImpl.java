/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.icinfo.cs.common.utils.DateUtil;

import com.icinfo.cs.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.YrAssetMapper;
import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_asset 对应的Service接口实现类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Service
public class YrAssetServiceImpl extends MyBatisServiceSupport implements IYrAssetService {
    @Autowired
    YrAssetMapper yrAssetMapper;


	/**
	 * 新增数据
	 * @autor: wangjin
	 * @param yrAsset
	 * @return
	 */
	@Override
	public int insert(YrAsset yrAsset) {
		//时间戳
		yrAsset.setCreateTime(DateUtil.getSysDate());
		//金额单位转换
		swtichBigDecimal(yrAsset,"1");
		return yrAssetMapper.insert(yrAsset);
	}
	
	/**
	 * 
	 * 描述: 保存for分支机构
	 * @auther ljx
	 * @date 2016年10月9日 
	 * @param yrAsset
	 * @return
	 */
	@Override
	public int insertForBranch(YrAsset yrAsset){
  	yrAsset.setCreateTime(DateUtil.getSysDate());
  	swtichBigDecimal(yrAsset,"1");
  	return yrAssetMapper.insert(yrAsset);
	}

	/**
	 * 更新数据
	 * @autor: wangjin
	 * @param yrAsset
	 * @return
	 */
	@Override
	public int update(YrAsset yrAsset) {
		Example example = new Example(YrAsset.class);
		//金额单位转换
		swtichBigDecimal(yrAsset,"1");
		//时间戳
		//yrAsset.setCreateTime(DateUtil.getSysDate());
		example.createCriteria().andEqualTo("assetID", yrAsset.getAssetID()).andEqualTo("priPID",yrAsset.getPriPID());
		return yrAssetMapper.updateByExampleSelective(yrAsset,example);
	}
   
	/**
	 * 
	 * 描述: 保存for分支机构
	 * @auther ljx
	 * @date 2016年10月9日 
	 * @param yrAsset
	 * @return
	 */
	@Override
	public int updateForBranch(YrAsset yrAsset) {
		if(StringUtil.isNotEmpty(yrAsset.getPriPID())){
			Example example = new Example(YrAsset.class);
			swtichBigDecimal(yrAsset,"1");
			//判断是否是非独立核算
			if("2".equals(yrAsset.getEntBelong())){
				yrAssetMapper.updateValuesByEntBelong(yrAsset.getAssetID(),yrAsset.getPriPID());
			}
			example.createCriteria().andEqualTo("assetID", yrAsset.getAssetID()).andEqualTo("priPID",yrAsset.getPriPID());
			return yrAssetMapper.updateByExampleSelective(yrAsset,example);
		}
		return 0;
	}

	
	
	/**
	 * 根据年份和主体身份代码进行查询
	 * @autor: wangjin
	 * @param year
	 * @param pripid
     * @return
     */
	@Override
	public YrAsset selectByYearAndPripid(Integer year, String pripid) {
		if(StringUtil.isNotEmpty(pripid)&&year!=null){
			YrAsset yrAsset = new YrAsset();
			yrAsset.setYear(year);
			yrAsset.setPriPID(pripid);
			yrAsset=yrAssetMapper.selectOne(yrAsset);
			if(yrAsset!=null){  //正式用的时候打开注释
				swtichBigDecimal(yrAsset,"2");
			}
			return yrAsset;
		}
		return null;

	}
	/**
	 * 
	 * 描述: 根据年份和主体身份代码进行查询for分支机构
	 * @auther ljx
	 * @date 2016年10月9日 
	 * @param year
	 * @param priPId
	 * @return
	 */
	@Override
    public YrAsset selectByYearPridIdForBranch(Integer year,String priPId){
		if(StringUtil.isNotEmpty(priPId)&&year!=null){
			YrAsset yrAsset = new YrAsset();
			yrAsset.setYear(year);
			yrAsset.setPriPID(priPId);
			yrAsset=yrAssetMapper.selectOne(yrAsset);
			if(yrAsset!=null){
				swtichBigDecimal(yrAsset,"2");

			}
			return yrAsset;
		}
		return null;

    }
	
   
	
	
	/**
     * 无条件查询
	 * @autor: wangjin
     * @param request
     * @return
     */
    @Override
    public List<YrAsset> queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return yrAssetMapper.selectAll();
    }

    /**
     * 条件查询
	 * @autor: wangjin
     * @param request
     * @return
     */
    @Override
    public List<YrAsset> search_queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return yrAssetMapper.search_queryPage(request.getParams());
    }

    /**
     *  根据assetID查询
	 *  @autor: wangjin
     * @param assetID
     * @return
     */
    @Override
    public  YrAsset selectByAssetID(String assetID){
        YrAsset yrAsset=new YrAsset();
        yrAsset.setAssetID(assetID);
        return yrAssetMapper.selectOne(yrAsset);
    }



    /**
     * 根据assetID进行 删除
	 * @autor: wangjin
     * @param assetID
     * @return
     */
    @Override
    public int deleteByUuid(String assetID) {
        YrAsset yrAsset = new YrAsset();
        yrAsset.setAssetID(assetID);
        //yrAsset.setDelState("1");
        return yrAssetMapper.delete(yrAsset);
    }
    /**
     * 根据assetID进行 物理删除
     * @param assetID
     * @return
     */
    @Override
    public int updateByUuid(String assetID) {
        YrAsset yrAsset = new YrAsset();
        Example example = new Example(YrAsset.class);
        example.createCriteria().andEqualTo("assetID", assetID);
        return yrAssetMapper.updateByExampleSelective(yrAsset,example);
    }
    
    
  
    
    
    /**
	 * 
	 * 描述 : 根据新增和修改相应的换算金额字段
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 上午9:51:17 
	 * @param : falg:1 表元转为万元  2 表示万元转换为元
	 * @return: void
	 * @throws
	 */
	public void swtichBigDecimal(YrAsset yrAsset ,String flag){ 
		if("1".equals(flag)){
			// 资产总额
			yrAsset.setAssGro(bigDecimalDivideWan(yrAsset.getAssGro())); 
			// 负债总额
			yrAsset.setLiaGro(bigDecimalDivideWan(yrAsset.getLiaGro()));
			// 营业总收入
			yrAsset.setVendInc(bigDecimalDivideWan(yrAsset.getVendInc()));
			// 其中主营业务收入
			yrAsset.setMaiBusInc(bigDecimalDivideWan(yrAsset.getMaiBusInc())); 
			// 利润总额
			yrAsset.setProGro(bigDecimalDivideWan(yrAsset.getProGro()));
			// 净利润
			yrAsset.setNetInc(bigDecimalDivideWan(yrAsset.getNetInc()));
			// 纳税总额
			yrAsset.setRatGro(bigDecimalDivideWan(yrAsset.getRatGro()));
			// 所有者权益合计
			yrAsset.setTotEqu(bigDecimalDivideWan(yrAsset.getTotEqu()));
			// 货币资金
			yrAsset.setMoneFunds(bigDecimalDivideWan(yrAsset.getMoneFunds()));
			// 应收账款
			yrAsset.setAccRec(bigDecimalDivideWan(yrAsset.getAccRec()));
			// 其他应收款
			yrAsset.setOthAccRec(bigDecimalDivideWan(yrAsset.getOthAccRec()));
			// 存货
			yrAsset.setInventory(bigDecimalDivideWan(yrAsset.getInventory()));
			// 流动资产合计
			yrAsset.setTotCurrAssets(bigDecimalDivideWan(yrAsset.getTotCurrAssets()));
			// 长期投资
			yrAsset.setLongInvest(bigDecimalDivideWan(yrAsset.getLongInvest()));
			// 固定资产
			yrAsset.setFixAssets(bigDecimalDivideWan(yrAsset.getFixAssets()));
			// 无形资产
			yrAsset.setIntAssets(bigDecimalDivideWan(yrAsset.getIntAssets()));
			// 应付账款
			yrAsset.setAccPay(bigDecimalDivideWan(yrAsset.getAccPay()));
			// 其他应付款
			yrAsset.setOthPay(bigDecimalDivideWan(yrAsset.getOthPay()));
			// 流动负债合计
			yrAsset.setTotCurrLiab(bigDecimalDivideWan(yrAsset.getTotCurrLiab()));
			//实收资本
			yrAsset.setRecCap(bigDecimalDivideWan(yrAsset.getRecCap()));
			// 当年出口创汇总额
			yrAsset.setExpGro(bigDecimalDivideWan(yrAsset.getExpGro()));
			// 当年研究开发、技术改造、科技创新等方面的支出
			yrAsset.setIntelGro(bigDecimalDivideWan(yrAsset.getIntelGro()));
			// 增值税
			yrAsset.setAddTax(bigDecimalDivideWan(yrAsset.getAddTax()));
			// 城市维护建设税
			yrAsset.setCityTax(bigDecimalDivideWan(yrAsset.getCityTax()));
			// 营业税
			yrAsset.setMngTax(bigDecimalDivideWan(yrAsset.getMngTax()));
			// 印花税
			yrAsset.setFloTax(bigDecimalDivideWan(yrAsset.getFloTax()));
			// 消费税
			yrAsset.setExpenseTax(bigDecimalDivideWan(yrAsset.getExpenseTax()));
			// 土地增值税
			yrAsset.setLandTax(bigDecimalDivideWan(yrAsset.getLandTax()));
			// 企业所得税
			yrAsset.setEntTax(bigDecimalDivideWan(yrAsset.getEntTax()));
			// 关税
			yrAsset.setDutyTax(bigDecimalDivideWan(yrAsset.getDutyTax()));
			// 个人所得税
			yrAsset.setPersonTax(bigDecimalDivideWan(yrAsset.getPersonTax()));
			// 教育费附加
			yrAsset.setTechTax(bigDecimalDivideWan(yrAsset.getTechTax()));
			// 房产税
			yrAsset.setHouseTax(bigDecimalDivideWan(yrAsset.getHouseTax()));
			// 水利基金
			yrAsset.setWaterTax(bigDecimalDivideWan(yrAsset.getWaterTax()));
			// 城镇土地使用税
			yrAsset.setLanUseTax(bigDecimalDivideWan(yrAsset.getLanUseTax()));
			// 其他
			yrAsset.setOtherTax(bigDecimalDivideWan(yrAsset.getOtherTax()));
			// 当年减免国税
			yrAsset.setMinNationTax(bigDecimalDivideWan(yrAsset.getMinNationTax()));
			// 当年减免地税
			yrAsset.setMinLandTax(bigDecimalDivideWan(yrAsset.getMinLandTax()));
			// 当年水电费支出总额
			yrAsset.setWaterFee(bigDecimalDivideWan(yrAsset.getWaterFee()));
			// 当年工资支出总额
			yrAsset.setSalaryFee(bigDecimalDivideWan(yrAsset.getSalaryFee()));
			// 当年房租支出总额
			yrAsset.setRentFee(bigDecimalDivideWan(yrAsset.getRentFee()));
			// 当年五险一金支出总额
			yrAsset.setSocFee(bigDecimalDivideWan(yrAsset.getSocFee()));
			/* 万元为单位的
			//当年从金融机构获得贷款总额
			//yrAsset.setFinOrgLoan(bigDecimalDivideWan(yrAsset.getFinOrgLoan()));
			//当年从小额贷款公司等其他渠道融资总额
			//yrAsset.setComLoan(bigDecimalDivideWan(yrAsset.getComLoan()));
			//截止当年末，从金融机构获得的贷款余额
			//yrAsset.setEndLoan(bigDecimalDivideWan(yrAsset.getEndLoan()));
			//当年贷款利息支出总额
			//yrAsset.setPayLoan(bigDecimalDivideWan(yrAsset.getPayLoan()));
			*/
         }else if("2".equals(flag)){//查询
        	// 资产总额
 			yrAsset.setAssGro(bigDecimalDivideYuan(yrAsset.getAssGro()));
 			// 负债总额
 			yrAsset.setLiaGro(bigDecimalDivideYuan(yrAsset.getLiaGro()));
 			// 营业总收入
 			yrAsset.setVendInc(bigDecimalDivideYuan(yrAsset.getVendInc()));
 			// 其中主营业务收入
 			yrAsset.setMaiBusInc(bigDecimalDivideYuan(yrAsset.getMaiBusInc())); 
 			// 利润总额
 			yrAsset.setProGro(bigDecimalDivideYuan(yrAsset.getProGro()));
 			// 净利润
 			yrAsset.setNetInc(bigDecimalDivideYuan(yrAsset.getNetInc()));
 			// 纳税总额
 			yrAsset.setRatGro(bigDecimalDivideYuan(yrAsset.getRatGro()));
 			// 所有者权益合计
 			yrAsset.setTotEqu(bigDecimalDivideYuan(yrAsset.getTotEqu()));
 			// 货币资金
 			yrAsset.setMoneFunds(bigDecimalDivideYuan(yrAsset.getMoneFunds()));
 			// 应收账款
 			yrAsset.setAccRec(bigDecimalDivideYuan(yrAsset.getAccRec()));
 			// 其他应收款
 			yrAsset.setOthAccRec(bigDecimalDivideYuan(yrAsset.getOthAccRec()));
 			// 存货
 			yrAsset.setInventory(bigDecimalDivideYuan(yrAsset.getInventory()));
 			// 流动资产合计
 			yrAsset.setTotCurrAssets(bigDecimalDivideYuan(yrAsset.getTotCurrAssets()));
 			// 长期投资
 			yrAsset.setLongInvest(bigDecimalDivideYuan(yrAsset.getLongInvest()));
 			// 固定资产
 			yrAsset.setFixAssets(bigDecimalDivideYuan(yrAsset.getFixAssets()));
 			// 无形资产
 			yrAsset.setIntAssets(bigDecimalDivideYuan(yrAsset.getIntAssets()));
 			// 应付账款
 			yrAsset.setAccPay(bigDecimalDivideYuan(yrAsset.getAccPay()));
 			// 其他应付款
 			yrAsset.setOthPay(bigDecimalDivideYuan(yrAsset.getOthPay()));
 			// 流动负债合计
 			yrAsset.setTotCurrLiab(bigDecimalDivideYuan(yrAsset.getTotCurrLiab()));
			//实收资本
			yrAsset.setRecCap(bigDecimalDivideYuan(yrAsset.getRecCap()));
 			// 当年出口创汇总额
 			yrAsset.setExpGro(bigDecimalDivideYuan(yrAsset.getExpGro()));
 			// 当年研究开发、技术改造、科技创新等方面的支出
 			yrAsset.setIntelGro(bigDecimalDivideYuan(yrAsset.getIntelGro()));
 			// 增值税
 			yrAsset.setAddTax(bigDecimalDivideYuan(yrAsset.getAddTax()));
 			// 城市维护建设税
 			yrAsset.setCityTax(bigDecimalDivideYuan(yrAsset.getCityTax()));
 			// 营业税
 			yrAsset.setMngTax(bigDecimalDivideYuan(yrAsset.getMngTax()));
 			// 印花税
 			yrAsset.setFloTax(bigDecimalDivideYuan(yrAsset.getFloTax()));
 			// 消费税
 			yrAsset.setExpenseTax(bigDecimalDivideYuan(yrAsset.getExpenseTax()));
 			// 土地增值税
 			yrAsset.setLandTax(bigDecimalDivideYuan(yrAsset.getLandTax()));
 			// 企业所得税
 			yrAsset.setEntTax(bigDecimalDivideYuan(yrAsset.getEntTax()));
 			// 关税
 			yrAsset.setDutyTax(bigDecimalDivideYuan(yrAsset.getDutyTax()));
 			// 个人所得税
 			yrAsset.setPersonTax(bigDecimalDivideYuan(yrAsset.getPersonTax()));
 			// 教育费附加
 			yrAsset.setTechTax(bigDecimalDivideYuan(yrAsset.getTechTax()));
 			// 房产税
 			yrAsset.setHouseTax(bigDecimalDivideYuan(yrAsset.getHouseTax()));
 			// 水利基金
 			yrAsset.setWaterTax(bigDecimalDivideYuan(yrAsset.getWaterTax()));
 			// 城镇土地使用税
 			yrAsset.setLanUseTax(bigDecimalDivideYuan(yrAsset.getLanUseTax()));
 			// 其他
 			yrAsset.setOtherTax(bigDecimalDivideYuan(yrAsset.getOtherTax()));
 			// 当年减免国税
 			yrAsset.setMinNationTax(bigDecimalDivideYuan(yrAsset.getMinNationTax()));
 			// 当年减免地税
 			yrAsset.setMinLandTax(bigDecimalDivideYuan(yrAsset.getMinLandTax()));
 			// 当年水电费支出总额
 			yrAsset.setWaterFee(bigDecimalDivideYuan(yrAsset.getWaterFee()));
 			// 当年工资支出总额
 			yrAsset.setSalaryFee(bigDecimalDivideYuan(yrAsset.getSalaryFee()));
 			// 当年房租支出总额
 			yrAsset.setRentFee(bigDecimalDivideYuan(yrAsset.getRentFee()));
 			// 当年五险一金支出总额
 			yrAsset.setSocFee(bigDecimalDivideYuan(yrAsset.getSocFee()));

 			/**万元为单位的*/
 			//当年从金融机构获得贷款总额
			yrAsset.setFinOrgLoan(yrAsset.getFinOrgLoan()==null?null:yrAsset.getFinOrgLoan().setScale(4, BigDecimal.ROUND_HALF_UP));
			//当年从小额贷款公司等其他渠道融资总额
			yrAsset.setComLoan(yrAsset.getComLoan()==null?null:yrAsset.getComLoan().setScale(4, BigDecimal.ROUND_HALF_UP));
			//截止当年末，从金融机构获得的贷款余额
			yrAsset.setEndLoan(yrAsset.getEndLoan()==null?null:yrAsset.getEndLoan().setScale(4, BigDecimal.ROUND_HALF_UP));
			//当年贷款利息支出总额
			yrAsset.setPayLoan(yrAsset.getPayLoan()==null?null:yrAsset.getPayLoan().setScale(4, BigDecimal.ROUND_HALF_UP));
		 }
	}
	
	
	/**
	 * 
	 * 描述: 元转化为万元
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 上午10:15:44 
	 * @param :
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

	/** 
	 * 描述:  根据内部序号年度查询，不转换金额
	 * @auther ZhouYan
	 * @date 2016年10月25日 
	 * @param year
	 * @param pripid
	 * @return 
	 */
	@Override
	public YrAsset selectYrAssetByYearAndPripid(int year, String pripid) {
		YrAsset yrAsset = new YrAsset();
		yrAsset.setYear(year);
		yrAsset.setPriPID(pripid);
		yrAsset=yrAssetMapper.selectOne(yrAsset);
		return yrAsset;
	}
	
}