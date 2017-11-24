package com.icinfo.cs.sment.util;

import java.math.BigDecimal;
import java.util.Date;

import com.icinfo.cs.common.utils.BigDecimalUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;

/**
 * 小微企业相关规则
 * 
 * @author zhuyong
 */
public class SmentRuleUtils {
	
	public final static String ENTTYPES=",1000,1100,1110,1120,1121,1122,1123,1130,1140,1150,1151,1152,1153,1190,1200,1210,1211,1212,1213,1219,1220,1221,1222,1223,1229,3000,3100,3200,3300,3400,3500,4530,4531,4532,4533,4540,4400,4410,4420,4600,4700,5000,5100,5110,5120,5130,5140,5150,5160,5190,5200,5210,5220,5230,5240,5290,6000,6100,6110,6120,6130,6140,6150,6160,6170,6190,6200,6210,6220,6230,6240,6250,6260,6290,5400,5410,5420,5430,5490,6400,6410,6420,6430,6490,7300,7310,7390,5300,5310,5320,5390,6300,6310,6320,6390,";
	
	public final static String ENTTYPECATG = ",22,25,28,32,34,";
	
	public final static String REGSTATE = ",K,B,A,DA,X,Q,";

	/**
	 * 判断一家企业是否为新设小微企业
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static boolean checkMidEntIsSm(SmBaseinfoDto dto){
		try {
			return checkEstDate(dto.getEstDate()) 
					&& checkRegState(dto.getRegState())
					&& (
						(checkEntType(dto.getEntType()) && checkRegCap(dto.getRegCap()) && checkCompany(dto.getCurrencyCn())) 
						|| (checkEntTypeCatg(dto.getEntTypeCatg()))
					);
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * 判断一家作为新设列入的小微企业是否有效
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static boolean checkSmIsValid(SmBaseinfoDto dto){
		try {
			return checkEstDateIsValidate(dto.getEstDate()) 
					&& checkRegState(dto.getRegState())
					&& (
						(checkEntType(dto.getEntType()) && checkRegCap(dto.getRegCap()) && checkCompany(dto.getCurrencyCn())) 
						|| (checkEntTypeCatg(dto.getEntTypeCatg()))
					);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 成立日期大于当前年第一天  并且 小于 下一年第一天 为true
	 * @author fanzhen
	 * @date 20170515
	 * @return
	 */
	private static boolean checkEstDate(Date estDate){
		return DateUtil.getNowYearFirstDay().before(estDate) && DateUtil.getNextYearFirstDay().after(estDate);
	}
	
	/**
	 * 成立日期大于当前年第一天  并且 小于 下一年年中
	 * 
	 * @author fanzhen
	 * @date 20170515
	 * @return
	 */
	private static boolean checkEstDateIsValidate(Date estDate){
		return DateUtil.getYearFirstDate(estDate).before(estDate) 
				&& DateUtil.getNextYearMidDate(estDate).after(estDate);
	}
	
	
	/**
	 * @author fanzhen
	 * 登记状态(CA19) 在K,B,A,DA,X,Q中返回true
	 * 
	 * @date 20170515
	 * @param dto
	 * @return
	 */
	private static boolean checkRegState(String regState){
		return REGSTATE.contains("," + regState + ",");
	}
	
	/**
	 * 市场主体类型在ENTTYPES范围内返回true
	 * @author fanzhen
	 * @date 20170515
	 * @param dto
	 * @return
	 */
	private static boolean checkEntType(String entType){
		return ENTTYPES.contains("," + entType + ",");
	}
	
	/**
	 * 市场主体类型大类在ENTTYPECATG之内返回true
	 * @author fanzhen
	 * @date 20170515
	 * @param dto
	 * @return
	 */
	private static boolean checkEntTypeCatg(String entTypeCatg){
		return ENTTYPECATG.contains("," + entTypeCatg + ",");
	}
	
	/**
	 * 注册资本在0-500之内返回true
	 * 
	 * @author fanzhen
	 * @date 20170515
	 * @param dto
	 * @return
	 */
	private static boolean checkRegCap(BigDecimal regCap){
		return BigDecimalUtil.BigDecimalCompareTo(regCap,0) 
				&& !BigDecimalUtil.BigDecimalCompareTo(regCap,500);
	}
	
	/**
	 * 检查单位是否符合要求
	 * 
	 * @author zhuyong
	 * @param curr
	 * @return
	 */
	private static boolean checkCompany(String curr){
		return "元人民币".equals(curr.trim());
	}
	
	
}
