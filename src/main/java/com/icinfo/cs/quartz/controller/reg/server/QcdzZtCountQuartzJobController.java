package com.icinfo.cs.quartz.controller.reg.server;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.qcdz.qcdzdto.HzQyhznrDto;
import com.icinfo.cs.qcdz.service.IHzQyhznrService;
import com.icinfo.cs.rpt.rptdto.RptQcdzYearCountDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzIndustry;
import com.icinfo.cs.rpt.rptmodel.RptQcdzInvcount;
import com.icinfo.cs.rpt.rptmodel.RptQcdzMap;
import com.icinfo.cs.rpt.rptmodel.RptQcdzToday;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtQs;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtcount;
import com.icinfo.cs.rpt.rptservice.IRptQcdzIndustryService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzInvcountService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzMapService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzTodayService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzYearCountService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtQsService;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtcountService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.web.BaseController;

/**
 * 
 * 描述: TODO<br>
 * @author gaojinling
 * @date 2017年9月25日
 */
@Controller
@RequestMapping("/quartz/qcdzZtCount")
public class QcdzZtCountQuartzJobController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(QcdzZtCountQuartzJobController.class);


	@Autowired
	private IHzQyhznrService hzQyhznrService;
	@Autowired
	private IRptQcdzZtcountService rptQcdzZtcountService;
	@Autowired
	ICsQuartzJobService csQuartzJobService; 
	@Autowired
	private IRptQcdzTodayService rptQcdzTodayService;
	@Autowired
	private IRptQcdzYearCountService rptQcdzYearCountService;
	@Autowired
	private IRptQcdzZtQsService rptQcdzZtQsService;
	@Autowired
	private IRptQcdzInvcountService rptQcdzInvcountService;
	@Autowired
	private IRptQcdzIndustryService rptQcdzIndustryService;
	@Autowired
	private IRptQcdzMapService rptQcdzMapService;
	
	
	
 	
	/**
	 * 
	 * 描述: 整体在册数据交换
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public String qcdzZtCount() throws Exception{
		try {
			logger.info("全程电子化主体在册数量cs_rpt_qcdz_ztcount定时同步任务开始");
			Thread.sleep(110000);
			csQuartzJobService.insert(QuartzJobName.QCDZ_ZTCOUNT_JOB.getJobName());

			Map<String, Object> map  =  new HashMap<String, Object>();
		    //从全程电子化数据源查询当前最新的主体总数相关数据
			//主体总数
			String nowyear = DateUtil.getCurrentYear();
			map.put("nowyear", nowyear);
			List<HzQyhznrDto> hzQyhznrDtos = hzQyhznrService.selectZtCount(map);
			//分类数据
			List<HzQyhznrDto> dtos = hzQyhznrService.selectTypeZtCount(map);
			if(hzQyhznrDtos !=null && dtos!=null){
				RptQcdzZtcount  rptQcdzZtcount = new RptQcdzZtcount();
				rptQcdzZtcount.setZtCount(hzQyhznrDtos.get(0).getZtTotal());
				rptQcdzZtcount.setPreZtTotal(hzQyhznrDtos.get(0).getPreZtTotal());
				rptQcdzZtcount.setYearAddRoate(hzQyhznrDtos.get(0).getYearAddRoate());
				for(HzQyhznrDto hzQyhznrDto :dtos){
					if("qy".equalsIgnoreCase(hzQyhznrDto.getType())){
						rptQcdzZtcount.setQyCount(hzQyhznrDto.getTypeCount());
					}
					if("nz".equalsIgnoreCase(hzQyhznrDto.getType())){
						rptQcdzZtcount.setNzCount(hzQyhznrDto.getTypeCount());
					}
					if("gt".equalsIgnoreCase(hzQyhznrDto.getType())){
						rptQcdzZtcount.setGtCount(hzQyhznrDto.getTypeCount());
					}
				}
				//将查询出的数据插入到直连数据库统计表中（先删除当前数据,再插入）
				 rptQcdzZtcountService.delete();
				 rptQcdzZtcountService.save(rptQcdzZtcount);
			}
			
			//主体新设注销趋势（更新或插入最新月份数据）
			String nowMouthcode = DateUtil.dateToString(new Date(),"M");
			String estDatebegin = DateUtil.dateToString(new Date(), "yyyy-MM")+"-01";
			//从查询当前月份数据是否存在
			int newCount = rptQcdzZtQsService.selectOne(nowMouthcode);
			//查询最新月份新设注销数据
			map.put("estDateBegin", estDatebegin);
			map.put("nowMouthcode", nowMouthcode);
			List<HzQyhznrDto> mouthHzlist = hzQyhznrService.selectXsXwCount(map);
		    HzQyhznrDto hzQyhznrDto = mouthHzlist.get(0);
		    RptQcdzZtQs rptQcdzZtQs = new RptQcdzZtQs();
		    rptQcdzZtQs.setCancount(hzQyhznrDto.getXwCount().intValue());
		    rptQcdzZtQs.setNewcount(hzQyhznrDto.getXsCount().intValue());
		    rptQcdzZtQs.setMonthcode(hzQyhznrDto.getMouthcode());
			if(newCount == 1){//当前月份存在,更新
				rptQcdzZtQsService.update(rptQcdzZtQs);
			}else{
				rptQcdzZtQsService.save(rptQcdzZtQs);
			}
			
			//当日新设注销（各主体大类及各地市分布）
			Map<String, List<String>> strmap = new HashMap<String, List<String>>();
			List<String> sList = Arrays.asList("qy","gt","nz");
			List<String> codelist = Arrays.asList("3301","3302","3303","3304","3305","3306","3307","3308","3309","3310","3325");
			strmap.put("1", sList);
			strmap.put("2", codelist);
			String nowdate = DateUtil.getCurrentDate();
			for(int j=1;j<=strmap.size();j++){
				for(int i =0;i<strmap.get(Integer.toString(j)).size();i++){
					List<String> templist =  strmap.get(Integer.toString(j));
					if(j==1){
						map.clear();
						map.put("nowDate", nowdate);
						map.put("type", templist.get(i));
					}else{
						map.clear();
						map.put("nowDate", nowdate);
						map.put("areaCode", templist.get(i));
					}
					//新设数据
					Integer xscount = hzQyhznrService.selectDayXsCount(map);
					//注销数据
					Integer zxcount = hzQyhznrService.selectDayZxCount(map);
					RptQcdzToday rptQcdzToday = new RptQcdzToday();
					rptQcdzToday.setCancount(zxcount);
					rptQcdzToday.setNewcount(xscount);
					rptQcdzToday.setName(templist.get(i));
					rptQcdzToday.setOrderid(j==1 ? i : Integer.parseInt(templist.get(i)));
					rptQcdzToday.setType(Integer.toString(j));
					rptQcdzToday.setDaycode(DateUtil.getSysCurrentDate());
					//更新数据
					rptQcdzTodayService.update(rptQcdzToday);
				}
			}
			
			//今年最新年份主题增长数及增长速率
			//当前年份在册主体数量
			int zcNowYearCount = hzQyhznrService.selectzcCount();
			//查询统计表中近2年的数据
			map.put("length", 2);
			List<RptQcdzYearCountDto> countDtos = rptQcdzYearCountService.selectRptQcdzYearCountList(map);
			//最新年份数据
			RptQcdzYearCountDto nowrptQcdzYearCountDto = countDtos.get(0);
			//上一年份数据
			RptQcdzYearCountDto prerptQcdzYearCountDto = countDtos.get(1);
			
		    if(Integer.parseInt(DateUtil.getCurrentYear()) == nowrptQcdzYearCountDto.getYear()){//当前年份数据已经存在，更新
				RptQcdzYearCountDto newRptQcdzYearCountDto = new RptQcdzYearCountDto();
				newRptQcdzYearCountDto.setAllcount(zcNowYearCount);
				newRptQcdzYearCountDto.setNewcount(zcNowYearCount);
				newRptQcdzYearCountDto.setCancount(0);
				newRptQcdzYearCountDto.setYear(nowrptQcdzYearCountDto.getYear());
				newRptQcdzYearCountDto.setAddcount(zcNowYearCount-prerptQcdzYearCountDto.getAllcount());
				newRptQcdzYearCountDto.setIsshow("1");
				newRptQcdzYearCountDto.setAddrate(newRptQcdzYearCountDto.getAddcount() == 0 ? new BigDecimal(0.00) :new BigDecimal((newRptQcdzYearCountDto.getAddcount()*100.000/prerptQcdzYearCountDto.getAllcount())).setScale(2, BigDecimal.ROUND_HALF_UP));
				rptQcdzYearCountService.update(newRptQcdzYearCountDto);
		    }else{//当前年份数据不存在  insert
				RptQcdzYearCountDto newRptQcdzYearCountDto = new RptQcdzYearCountDto();
				newRptQcdzYearCountDto.setAllcount(zcNowYearCount);
				newRptQcdzYearCountDto.setNewcount(zcNowYearCount);
				newRptQcdzYearCountDto.setCancount(0);
				newRptQcdzYearCountDto.setYear(Integer.parseInt(DateUtil.getCurrentYear()));
				newRptQcdzYearCountDto.setAddcount(zcNowYearCount-nowrptQcdzYearCountDto.getAllcount());
				newRptQcdzYearCountDto.setIsshow("1");
				newRptQcdzYearCountDto.setAddrate(newRptQcdzYearCountDto.getAddcount() == 0 ? new BigDecimal(0.00) : new BigDecimal((newRptQcdzYearCountDto.getAddcount()*100.000/nowrptQcdzYearCountDto.getAllcount())).setScale(2, BigDecimal.ROUND_HALF_UP));
				rptQcdzYearCountService.save(newRptQcdzYearCountDto);
		    }
		    
		    //股东分类
		    //查询股东总数（只查询类型为法人和自然人的）
		    List<HzQyhznrDto> invtypeHzTotalList = hzQyhznrService.selectinvTypeCount(map);
		    int invtypeTotal = invtypeHzTotalList.get(0).getInvTypeCount();
		    //查询股东分类（分类查询）
		    map.put("groupFlag", 1);
		    List<HzQyhznrDto> invtypeHzList = hzQyhznrService.selectinvTypeCount(map);
		    int entTypeTotal = 0;
		    int perTypeTotal = 0;
		    for(HzQyhznrDto hzQyhznrDto2 :invtypeHzList ){
		    	if("1".equals(hzQyhznrDto2.getInvType()) || "3".equals(hzQyhznrDto2.getInvType())){//法人
		    		entTypeTotal = entTypeTotal+hzQyhznrDto2.getInvTypeCount();
		    	}else{//自然人
		    		perTypeTotal = perTypeTotal+hzQyhznrDto2.getInvTypeCount();
		    	}
		    }
		    RptQcdzInvcount rptQcdzInvcount = new RptQcdzInvcount();
		    rptQcdzInvcount.setAllcount(invtypeTotal);
		    rptQcdzInvcount.setEntcount(entTypeTotal);
		    rptQcdzInvcount.setPercount(perTypeTotal);
		    rptQcdzInvcount.setType("1");
		    rptQcdzInvcount.setName("All");
		    rptQcdzInvcount.setEntrate(new BigDecimal(entTypeTotal*100.00/invtypeTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
		    rptQcdzInvcount.setPerrate(new BigDecimal(perTypeTotal*100.00/invtypeTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
		    rptQcdzInvcountService.update(rptQcdzInvcount);
		    
				
			logger.info("全程电子化主体在册数量cs_rpt_qcdz_ztcount定时同步任务结束");
			return "全程电子化主体在册数量cs_rpt_qcdz_ztcount定时同步任务结束";
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new BusinessException(e.getCause().getMessage(),e);
		}
	}

	
	
	/**
	 * 
	 * 描述: 慢交换数据
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public String qcdzDayXszxCount() throws Exception{
		try {
			logger.info("全程电子化慢交换定时同步任务开始");
			SleepUtil.threadSleep();
			csQuartzJobService.insert(QuartzJobName.QCDZ_SLOWDATA_JOB.getJobName());

			Map<String, Object> map  =  new HashMap<String, Object>();		
		    //区域分类(12地市)
		    map.clear();
			List<String> areacodelist = Arrays.asList("3301","3302","3303","3304","3305","3306","3307","3308","3309","3310","3325");
			for(String str : areacodelist){
				map.put("areaCode", str);
			    List<HzQyhznrDto> areaInvtypeHzList = hzQyhznrService.selectAreainvTypeCount(map);
			    int areaentTypeTotal = 0 ;
			    int areaperTypeTotal = 0 ;
			    for(HzQyhznrDto qyhznrDto : areaInvtypeHzList){
			    	if("1".equals(qyhznrDto.getInvType()) || "3".equals(qyhznrDto.getInvType())){//法人
			    		areaentTypeTotal = areaentTypeTotal+qyhznrDto.getInvTypeCount();
			    	}else{//自然人
			    		areaperTypeTotal = areaperTypeTotal+qyhznrDto.getInvTypeCount();
			    	}
			    }
			    RptQcdzInvcount arearptQcdzInvcount = new RptQcdzInvcount();
			    arearptQcdzInvcount.setAllcount(areaentTypeTotal+areaperTypeTotal);
			    arearptQcdzInvcount.setEntcount(areaentTypeTotal);
			    arearptQcdzInvcount.setPercount(areaperTypeTotal);
			    arearptQcdzInvcount.setType("2");
			    arearptQcdzInvcount.setName(str);
			    arearptQcdzInvcount.setEntrate(new BigDecimal(areaentTypeTotal*100.00/(areaentTypeTotal+areaperTypeTotal)).setScale(2, BigDecimal.ROUND_HALF_UP));
			    arearptQcdzInvcount.setPerrate(new BigDecimal(areaperTypeTotal*100.00/(areaentTypeTotal+areaperTypeTotal)).setScale(2, BigDecimal.ROUND_HALF_UP));
			    rptQcdzInvcountService.update(arearptQcdzInvcount); 
			}
			
			//股东行业占比
		    List<String> invtypes = Arrays.asList("1","2");
		    for(String  invType : invtypes){
		    	map.put("invType", invType);
		    	//查询总数
		    	int total = hzQyhznrService.selectIndustryinvTypeTotalCount(map);
		    	int fivetotal = 0;
		    	//查询占比数前五的行业数
		    	List<HzQyhznrDto> hyList = hzQyhznrService.selectIndustryinvTypeCount(map);
		    	//删除类型下数据
		    	rptQcdzIndustryService.delete(invType);
		    	//依次插入占比前五数据
		    	for(HzQyhznrDto qyhznrDto : hyList){
		    		fivetotal = fivetotal + qyhznrDto.getIndNum();
		    		RptQcdzIndustry rptQcdzIndustry = new RptQcdzIndustry();
		    		rptQcdzIndustry.setHydm(qyhznrDto.getHydm());
		    		rptQcdzIndustry.setHymc(qyhznrDto.getHymc());
		    		rptQcdzIndustry.setInvtype(invType);
		    		rptQcdzIndustry.setHyrate(new BigDecimal(qyhznrDto.getIndNum()*100.00/total).setScale(2, BigDecimal.ROUND_HALF_UP));
		    	    rptQcdzIndustryService.save(rptQcdzIndustry);
		    	}
		    	//插入除去前五后其他的数据
	    		RptQcdzIndustry rptQcdzIndustryqt = new RptQcdzIndustry();
	    		rptQcdzIndustryqt.setHydm("ZQT");
	    		rptQcdzIndustryqt.setHymc("其他");
	    		rptQcdzIndustryqt.setInvtype(invType);
	    		rptQcdzIndustryqt.setHyrate(new BigDecimal((total-fivetotal)*100.00/total).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	    rptQcdzIndustryService.save(rptQcdzIndustryqt);
		    }
				
			logger.info("全程电子化慢交换定时同步任务结束");
			return "全程电子化慢交换定时同步任务结束";
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new BusinessException(e.getCause().getMessage(),e);
		}
		
	}
	
	/**
	 * 
	 * 描述: 地图数据单独交换（5分钟内各登记机关下新设 注销数据）
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("testmap")
	public String qcdzMapCount() throws Exception{
		try {
			logger.info("全程电子化地图数据定时同步任务开始");
			Thread.sleep(100*60*3);
			csQuartzJobService.insert(QuartzJobName.QCDZ_MAPDATA_JOB.getJobName());
			
			Map<String, Object> map  =  new HashMap<String, Object>();		
			map.put("nowDate", DateUtil.getCurrentDate());
			//更新直连库中地图所有数据
			RptQcdzMap rptQcdzMap = new RptQcdzMap();
			rptQcdzMap.setXsNum(new Long((long)0));
			rptQcdzMap.setZxNum(new Long((long)0));
			rptQcdzMapService.updateAll(rptQcdzMap);
			//新设部分数据
			List<HzQyhznrDto> hzQyhznrDtos = hzQyhznrService.selectHzMapList(map);
			for(HzQyhznrDto hzQyhznrDto : hzQyhznrDtos){
				RptQcdzMap qcdzMap = new RptQcdzMap();
				qcdzMap.setRegorg(hzQyhznrDto.getREGORG());
				qcdzMap.setXsNum(hzQyhznrDto.getXsNum());
				rptQcdzMapService.updateByRegorg(qcdzMap);
			}
			
			//注销部分数据
			List<HzQyhznrDto> bfQyhznrDtos = hzQyhznrService.selectBfMapList(map);
			for(HzQyhznrDto hzQyhznrDto : bfQyhznrDtos){
				RptQcdzMap qcdzMap = new RptQcdzMap();
				qcdzMap.setRegorg(hzQyhznrDto.getREGORG());
				qcdzMap.setZxNum(hzQyhznrDto.getZxNum());
				rptQcdzMapService.updateByRegorg(qcdzMap);
			}
			logger.info("全程电子化地图部分数据交换定时同步任务结束");
			return "全程电子化地图部分数据交换定时同步任务结束";
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getCause().getMessage(),e);
		}
		
	}

	
	
	/**
	 * 描述：个体户未按时年报列异测试
	 * @author baifangfang
	 * @date 2017年7月19日
	 * @throws Exception
	 */
	@RequestMapping("test")
	public void test() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		String nowyear = DateUtil.getCurrentYear();
		map.put("nowyear", nowyear);
		//主体总数
		List<HzQyhznrDto> hzQyhznrDtos = hzQyhznrService.selectZtCount(map);
		//分类数据
		List<HzQyhznrDto> dtos = hzQyhznrService.selectTypeZtCount(map);
		if(hzQyhznrDtos !=null && dtos!=null){
			RptQcdzZtcount  rptQcdzZtcount = new RptQcdzZtcount();
			rptQcdzZtcount.setZtCount(hzQyhznrDtos.get(0).getZtTotal());
			rptQcdzZtcount.setPreZtTotal(hzQyhznrDtos.get(0).getPreZtTotal());
			rptQcdzZtcount.setYearAddRoate(hzQyhznrDtos.get(0).getYearAddRoate());
			for(HzQyhznrDto hzQyhznrDto :dtos){
				if("qy".equalsIgnoreCase(hzQyhznrDto.getType())){
					rptQcdzZtcount.setQyCount(hzQyhznrDto.getTypeCount());
				}
				if("nz".equalsIgnoreCase(hzQyhznrDto.getType())){
					rptQcdzZtcount.setNzCount(hzQyhznrDto.getTypeCount());
				}
				if("gt".equalsIgnoreCase(hzQyhznrDto.getType())){
					rptQcdzZtcount.setGtCount(hzQyhznrDto.getTypeCount());
				}
			}
			//将查询出的数据插入到直连数据库统计表中（先删除当前数据,再插入）
			 rptQcdzZtcountService.delete();
			 rptQcdzZtcountService.save(rptQcdzZtcount);
		}
		
		//主体新设注销趋势（更新或插入最新月份数据）
		String nowMouthcode = DateUtil.dateToString(new Date(),"M");
		String estDatebegin = DateUtil.dateToString(new Date(), "yyyy-MM")+"-01";
		//从查询当前月份数据是否存在
		int newCount = rptQcdzZtQsService.selectOne(nowMouthcode);
		//查询最新月份新设注销数据
		map.put("estDateBegin", estDatebegin);
		map.put("nowMouthcode", nowMouthcode);
		List<HzQyhznrDto> mouthHzlist = hzQyhznrService.selectXsXwCount(map);
	    HzQyhznrDto hzQyhznrDto = mouthHzlist.get(0);
	    RptQcdzZtQs rptQcdzZtQs = new RptQcdzZtQs();
	    rptQcdzZtQs.setCancount(hzQyhznrDto.getXwCount().intValue());
	    rptQcdzZtQs.setNewcount(hzQyhznrDto.getXsCount().intValue());
	    rptQcdzZtQs.setMonthcode(hzQyhznrDto.getMouthcode());
		if(newCount == 1){//当前月份存在,更新
			rptQcdzZtQsService.update(rptQcdzZtQs);
		}else{
			rptQcdzZtQsService.save(rptQcdzZtQs);
		}
		
		//当日新设注销（各主体大类及各地市分布）
		Map<String, List<String>> strmap = new HashMap<String, List<String>>();
		List<String> sList = Arrays.asList("qy","gt","nz");
		List<String> codelist = Arrays.asList("3301","3302","3303","3304","3305","3306","3307","3308","3309","3310","3325");
		strmap.put("1", sList);
		strmap.put("2", codelist);
		String nowdate = DateUtil.getCurrentDate();
		for(int j=1;j<=strmap.size();j++){
			for(int i =0;i<strmap.get(Integer.toString(j)).size();i++){
				List<String> templist =  strmap.get(Integer.toString(j));
				if(j==1){
					map.clear();
					map.put("nowDate", nowdate);
					map.put("type", templist.get(i));
				}else{
					map.clear();
					map.put("nowDate", nowdate);
					map.put("areaCode", templist.get(i));
				}
				//新设数据
				Integer xscount = hzQyhznrService.selectDayXsCount(map);
				//注销数据
				Integer zxcount = hzQyhznrService.selectDayZxCount(map);
				RptQcdzToday rptQcdzToday = new RptQcdzToday();
				rptQcdzToday.setCancount(zxcount);
				rptQcdzToday.setNewcount(xscount);
				rptQcdzToday.setName(templist.get(i));
				rptQcdzToday.setOrderid(j==1 ? i : Integer.parseInt(templist.get(i)));
				rptQcdzToday.setType(Integer.toString(j));
				rptQcdzToday.setDaycode(DateUtil.getSysCurrentDate());
				//更新数据
				rptQcdzTodayService.update(rptQcdzToday);
			}
		}
		
		//今年最新年份主题增长数及增长速率
		//当前年份在册主体数量
		int zcNowYearCount = hzQyhznrService.selectzcCount();
		//查询统计表中近2年的数据
		map.put("length", 2);
		List<RptQcdzYearCountDto> countDtos = rptQcdzYearCountService.selectRptQcdzYearCountList(map);
		//最新年份数据
		RptQcdzYearCountDto nowrptQcdzYearCountDto = countDtos.get(0);
		//上一年份数据
		RptQcdzYearCountDto prerptQcdzYearCountDto = countDtos.get(1);
		
	    if(Integer.parseInt(DateUtil.getCurrentYear()) == nowrptQcdzYearCountDto.getYear()){//当前年份数据已经存在，更新
			RptQcdzYearCountDto newRptQcdzYearCountDto = new RptQcdzYearCountDto();
			newRptQcdzYearCountDto.setAllcount(zcNowYearCount);
			newRptQcdzYearCountDto.setNewcount(zcNowYearCount);
			newRptQcdzYearCountDto.setCancount(0);
			newRptQcdzYearCountDto.setYear(nowrptQcdzYearCountDto.getYear());
			newRptQcdzYearCountDto.setAddcount(zcNowYearCount-prerptQcdzYearCountDto.getAllcount());
			newRptQcdzYearCountDto.setIsshow("1");
			newRptQcdzYearCountDto.setAddrate(newRptQcdzYearCountDto.getAddcount() == 0 ? new BigDecimal(0.00) :new BigDecimal((newRptQcdzYearCountDto.getAddcount()*100.000/prerptQcdzYearCountDto.getAllcount())).setScale(2, BigDecimal.ROUND_HALF_UP));
			rptQcdzYearCountService.update(newRptQcdzYearCountDto);
	    }else{//当前年份数据不存在  insert
			RptQcdzYearCountDto newRptQcdzYearCountDto = new RptQcdzYearCountDto();
			newRptQcdzYearCountDto.setAllcount(zcNowYearCount);
			newRptQcdzYearCountDto.setNewcount(zcNowYearCount);
			newRptQcdzYearCountDto.setCancount(0);
			newRptQcdzYearCountDto.setYear(Integer.parseInt(DateUtil.getCurrentYear()));
			newRptQcdzYearCountDto.setAddcount(zcNowYearCount-nowrptQcdzYearCountDto.getAllcount());
			newRptQcdzYearCountDto.setIsshow("1");
			newRptQcdzYearCountDto.setAddrate(newRptQcdzYearCountDto.getAddcount() == 0 ? new BigDecimal(0.00) : new BigDecimal((newRptQcdzYearCountDto.getAddcount()*100.000/nowrptQcdzYearCountDto.getAllcount())).setScale(2, BigDecimal.ROUND_HALF_UP));
			rptQcdzYearCountService.save(newRptQcdzYearCountDto);
	    }
		
		 
	    //股东分类
	    //查询股东总数（只查询类型为法人和自然人的）
	    List<HzQyhznrDto> invtypeHzTotalList = hzQyhznrService.selectinvTypeCount(map);
	    int invtypeTotal = invtypeHzTotalList.get(0).getInvTypeCount();
	    //查询股东分类（分类查询）
	    map.put("groupFlag", 1);
	    List<HzQyhznrDto> invtypeHzList = hzQyhznrService.selectinvTypeCount(map);
	    int entTypeTotal = 0;
	    int perTypeTotal = 0;
	    for(HzQyhznrDto hzQyhznrDto2 :invtypeHzList ){
	    	if("1".equals(hzQyhznrDto2.getInvType()) || "3".equals(hzQyhznrDto2.getInvType())){//法人
	    		entTypeTotal = entTypeTotal+hzQyhznrDto2.getInvTypeCount();
	    	}else{//自然人
	    		perTypeTotal = perTypeTotal+hzQyhznrDto2.getInvTypeCount();
	    	}
	    }
	    RptQcdzInvcount rptQcdzInvcount = new RptQcdzInvcount();
	    rptQcdzInvcount.setAllcount(invtypeTotal);
	    rptQcdzInvcount.setEntcount(entTypeTotal);
	    rptQcdzInvcount.setPercount(perTypeTotal);
	    rptQcdzInvcount.setType("1");
	    rptQcdzInvcount.setName("All");
	    rptQcdzInvcount.setEntrate(new BigDecimal(entTypeTotal*100.00/invtypeTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
	    rptQcdzInvcount.setPerrate(new BigDecimal(perTypeTotal*100.00/invtypeTotal).setScale(2, BigDecimal.ROUND_HALF_UP));
	    rptQcdzInvcountService.update(rptQcdzInvcount);
	    
	    
	    //区域分类(12地市)
	    map.clear();
		List<String> areacodelist = Arrays.asList("3301","3302","3303","3304","3305","3306","3307","3308","3309","3310","3325");
		for(String str : areacodelist){
			map.put("areaCode", str);
		    List<HzQyhznrDto> areaInvtypeHzList = hzQyhznrService.selectAreainvTypeCount(map);
		    int areaentTypeTotal = 0 ;
		    int areaperTypeTotal = 0 ;
		    for(HzQyhznrDto qyhznrDto : areaInvtypeHzList){
		    	if("1".equals(qyhznrDto.getInvType()) || "3".equals(qyhznrDto.getInvType())){//法人
		    		areaentTypeTotal = areaentTypeTotal+qyhznrDto.getInvTypeCount();
		    	}else{//自然人
		    		areaperTypeTotal = areaperTypeTotal+qyhznrDto.getInvTypeCount();
		    	}
		    }
		    RptQcdzInvcount arearptQcdzInvcount = new RptQcdzInvcount();
		    arearptQcdzInvcount.setAllcount(areaentTypeTotal+areaperTypeTotal);
		    arearptQcdzInvcount.setEntcount(areaentTypeTotal);
		    arearptQcdzInvcount.setPercount(areaperTypeTotal);
		    arearptQcdzInvcount.setType("2");
		    arearptQcdzInvcount.setName(str);
		    arearptQcdzInvcount.setEntrate(new BigDecimal(areaentTypeTotal*100.00/(areaentTypeTotal+areaperTypeTotal)).setScale(2, BigDecimal.ROUND_HALF_UP));
		    arearptQcdzInvcount.setPerrate(new BigDecimal(areaperTypeTotal*100.00/(areaentTypeTotal+areaperTypeTotal)).setScale(2, BigDecimal.ROUND_HALF_UP));
		    rptQcdzInvcountService.update(arearptQcdzInvcount); 
		}
		
		//股东行业占比
	    List<String> invtypes = Arrays.asList("1","2");
	    for(String  invType : invtypes){
	    	map.put("invType", invType);
	    	//查询总数
	    	int total = hzQyhznrService.selectIndustryinvTypeTotalCount(map);
	    	int fivetotal = 0;
	    	//查询占比数前五的行业数
	    	List<HzQyhznrDto> hyList = hzQyhznrService.selectIndustryinvTypeCount(map);
	    	//删除类型下数据
	    	rptQcdzIndustryService.delete(invType);
	    	//依次插入占比前五数据
	    	for(HzQyhznrDto qyhznrDto : hyList){
	    		fivetotal = fivetotal + qyhznrDto.getIndNum();
	    		RptQcdzIndustry rptQcdzIndustry = new RptQcdzIndustry();
	    		rptQcdzIndustry.setHydm(qyhznrDto.getHydm());
	    		rptQcdzIndustry.setHymc(qyhznrDto.getHymc());
	    		rptQcdzIndustry.setInvtype(invType);
	    		rptQcdzIndustry.setHyrate(new BigDecimal(qyhznrDto.getIndNum()*100.00/total).setScale(2, BigDecimal.ROUND_HALF_UP));
	    	    rptQcdzIndustryService.save(rptQcdzIndustry);
	    	}
	    	//插入除去前五后其他的数据
    		RptQcdzIndustry rptQcdzIndustryqt = new RptQcdzIndustry();
    		rptQcdzIndustryqt.setHydm("ZQT");
    		rptQcdzIndustryqt.setHymc("其他");
    		rptQcdzIndustryqt.setInvtype(invType);
    		rptQcdzIndustryqt.setHyrate(new BigDecimal((total-fivetotal)*100.00/total).setScale(2, BigDecimal.ROUND_HALF_UP));
    	    rptQcdzIndustryService.save(rptQcdzIndustryqt);
	    }
	    
	    
	}
	
	

}
