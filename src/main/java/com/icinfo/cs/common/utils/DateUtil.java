
package com.icinfo.cs.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.icinfo.framework.tools.utils.DateUtils;

/** 
 * 描述: 日期工具类
 * @author ZhouYan
 * @date 2016年8月29日  
 */
public class DateUtil extends DateUtils{
	
	public static int SART_YEAR = 2013;

	/** 
	 * 描述: 以指定的格式来格式化日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param format
	 * @return 
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				result = "";
			}
		}
		return result;
	}
	
	
	/** 
	 * 描述: 把字符转为日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param strDate
	 * @param format
	 * @return 
	 */
	public static Date stringToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception er) {
			return null;
		}
	}

	/** 
	 * 描述: 获取当前完整时间
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentTime() {
		return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/** 
	 * 描述: 获取当前完整年份
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentYear() {
		return dateToString(new Date(), "yyyy");
	}

	/**
	 * 描述: 获取当前完整月份
	 * @auther wangjin
	 * @date
	 * @return
	 */
	public static String getCurrentMonth() {
		return dateToString(new Date(), "MM");
	}
	/**
	 * 描述: 获取当前完整年份和月份
	 * @auther wangjin
	 * @date
	 * @return
	 */
	public static String getCurrentYearAndMonth() {
		return dateToString(new Date(), "yyyyMM");
	}
	/**
	 * 描述: 获取当前完整年份和月份和日
	 * @auther wangjin
	 * @date
	 * @return
	 */
	public static String getCurrentYearAndMonthAndDay() {
		return dateToString(new Date(), "yyyyMMdd");
	}

	
	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentDate() {
		return dateToString(new Date(), "yyyy-MM-dd");
	}
	

	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentFormatDate() {
		return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static Date getSysCurrentDate() {
		return stringToDate(getCurrentDate(),"yyyy-MM-dd");
	}
	
	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String formatDate(Date date) {
		return dateToString(date, "yyyy年MM月dd日");
	}
	
	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String formatDateNew(Date date) {
		return dateToString(date, "yyyy-MM-dd");
	}

	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentSimpleTime() {
		return dateToString(new Date(), "HH:mm:ss");
	}

	/** 
	 * 描述: 获取当前完整日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getCurrentSimpleDate() {
		return dateToString(new Date(), "yyyyMMdd");
	}

	/** 
	 * 描述: 把日期转成完整格式。如：2007-1-1 转化后为 2007-01-01
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param strDate
	 * @param regex
	 * @return 
	 */
	public static String toComplexDate(String strDate, String regex) {
		try {
			String tmp_date[] = strDate.split(regex);
			String tmp_year = tmp_date[0];
			String tmp_month = tmp_date[1];
			String tmp_day = tmp_date[2];
			if (Integer.parseInt(tmp_month) <= 9) {
				tmp_month = "0" + tmp_month;
			}
			if (Integer.parseInt(tmp_day) <= 9) {
				tmp_day = "0" + tmp_day;
			}
			return tmp_year + "-" + tmp_month + "-" + tmp_day;
		} catch (Exception er) {
			return strDate;
		}
	}

	/** 
	 * 描述: 获取N年后时间
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNyearlater(Date date, int N) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return formatter.format(now.getTime());
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	
	/** 
	 * 描述: 获取N年后日期(负数表示向前推N年)
	 * @auther ylr
	 * @date 2016年11月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getyearlaterDate(Date date, int N) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.YEAR, N);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(now.getTime());
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	
	/** 
	 * 描述: 获取N年后日期(负数表示向前推N年)
	 * @auther ylr
	 * @date 2016年11月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static Date getyearlaterDateObject(Date date, int N) {
		Calendar now = Calendar.getInstance();
		try {
			if(date == null){
				return null;
			}
			now.setTime(date);
			now.add(Calendar.YEAR, N);
		} catch (Exception er) {
			er.printStackTrace();
		}
		return now.getTime();
	}
	
	/** 
	 * 描述: 获取N年后日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNyearlaterDate(Date date, int N) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(now.getTime());
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	
	/** 
	 * 描述: 获取N年后日期对象
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static Date getNyearlaterDateObject(Date date, int N) {
		Calendar now = Calendar.getInstance();
		try {
		
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			
		} catch (Exception er) {
			er.printStackTrace();
		}
		return now.getTime();
	}

	/** 
	 * 描述: 获取N月后时间
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNmonthlater(Date date, int N) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(now.getTime());
	}
	
	/** 
	 * 描述: 获取N月后时间
	 * 
	 * @author zhuyong
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNmonthlater(Date date, int N,String format) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(now.getTime());
	}

	/** 
	 * 描述: 获取N月后日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNmonthlaterDate(Date date, int N) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(now.getTime());
	}

	/** 
	 * 描述: 获取N天后日期(字符串形式)
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNdaylater(Date date, int N) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.format(getNdaylaterDate(date, N) );
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	
	/** 
	 * 描述: 获取N天后日期(字符串形式)
	 * 
	 * @author 朱勇
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static String getNdaylater2(Date date, int N) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(getNdaylaterDate(date, N) );
		} catch (Exception er) {
			return dateToString(new Date(), "yyyy-MM-dd");
		}
	}
	
	/** 
	 * 描述: 获取N天后日期
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static Date getNdaylaterDate(Date date, int N) {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, N);
			return now.getTime();
	}
	
	/** 
	 * 描述: 获取N小时后时间
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static Date getNhourlater(Date date, int N) {
		long myTime = (date.getTime() / 1000) + 60 * 60 * N;
		date.setTime(myTime * 1000);
		return date;
	}

	/** 
	 * 描述: 获取N分钟后时间
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param date
	 * @param N
	 * @return 
	 */
	public static Date getNMinutelater(Date date, int N) {
		long myTime = (date.getTime() / 1000) + 60 * N;
		date.setTime(myTime * 1000);
		return date;
	}
	
	/** 
	 * 描述: 返回两个日期之间的时间 单位分钟
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param beforeDate
	 * @param nowDate
	 * @return 
	 */
	public static long getBetweenDaysToMut(Date beforeDate,Date nowDate){
		long myTime = (nowDate.getTime() / 1000)-(beforeDate.getTime() / 1000);
		return myTime/60;
	}

	/** 
	 * 描述: 计算两日期相差天数
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param beforeDate
	 * @param afterDate
	 * @return 
	 */
	public static int getBetweenDays(String beforeDate, String afterDate) {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			int betweenDays = 0;
			Date d1 = format.parse(beforeDate);
			Date d2 = format.parse(afterDate);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			// 保证第二个时间一定大于第一个时间
			//if (c1.after(c2)) {
			//	c1 = c2;
			//	c2.setTime(d1);
			//}
			int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			betweenDays = c2.get(Calendar.DAY_OF_YEAR)
					- c1.get(Calendar.DAY_OF_YEAR);
			for (int i = 0; i < betweenYears; i++) {
				c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
				betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
			}
			return betweenDays;
		} catch (Exception er) {
			return 0;
		}
	}
	
	/** 
	 * 描述: 计算两日期相差月数
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param beforeDate
	 * @param afterDate
	 * @return 
	 */
	public static int getBetweenMonths(String beforeDate, String afterDate) {
		try {
			int iMonth = 0;
			int flag = 0;
			try {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d1 = format.parse(beforeDate);
				Date d2 = format.parse(afterDate);

				Calendar objCalendarDate1 = Calendar.getInstance();
				objCalendarDate1.setTime(d1);

				Calendar objCalendarDate2 = Calendar.getInstance();
				objCalendarDate2.setTime(d2);

				if (objCalendarDate2.equals(objCalendarDate1))
					return 0;
				if (objCalendarDate1.after(objCalendarDate2)) {
					Calendar temp = objCalendarDate1;
					objCalendarDate1 = objCalendarDate2;
					objCalendarDate2 = temp;
				}
				if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
						.get(Calendar.DAY_OF_MONTH))
					flag = 1;

				if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
						.get(Calendar.YEAR))
					iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
							.get(Calendar.YEAR))
							* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
							- objCalendarDate1.get(Calendar.MONTH);
				else
					iMonth = objCalendarDate2.get(Calendar.MONTH)
							- objCalendarDate1.get(Calendar.MONTH) - flag;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return iMonth;

		} catch (Exception er) {
			return 0;
		}
	}
	
	
	public static Date addMonth(Date d, int i) {
		Date date = null;
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gc.setTime(d);
		gc.add(Calendar.MONTH, i);
		try {
			date = sf.parse(sf.format(gc.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/** 
	 * 描述: 获取小时对应的毫秒数
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @param hour
	 * @return 
	 */
	public static long convertHourToMilliseconds(float hour){
		return (long) (hour*60*60*1000);
	}
	
	/** 
	 * 描述: 根据系统当前时间自动获取上一年度
	 * @auther ZhouYan
	 * @date 2016年8月29日 
	 * @return 
	 */
	public static String getPreYear(){
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-1);
		return String.valueOf(curr.get(Calendar.YEAR));
	}
	
	/** 
	 * 描述: 格式化查询条件：起始日期
	 * @auther ZhouYan
	 * @date 2014年11月27日 
	 * @param startTime
	 * @return 
	 */
	public static Date getStartDate(String startTime) {
		if (startTime != null && startTime.length() > 0) {
			return DateUtil.stringToDate(startTime + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}

	/** 
	 * 描述: 格式化查询条件：截止日期
	 * @auther ZhouYan
	 * @date 2014年11月27日 
	 * @param endTime
	 * @return 
	 */
	public static Date getEndDate(String endTime) {
		if (endTime != null && endTime.length() > 0) {
			return DateUtil.stringToDate(endTime + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}
	
	/**
	 * 获取前一天最后一刻时间
	 * 
	 * @author zhuyong
	 * @param day
	 * @return
	 */
	public static String getDayBeforeDayEnd(Date day){
		return getNdaylater2(day, -2) + " 23:59:59";
	}
	
	/**
	 * 获取后一天零点时间
	 * 
	 * @author zhuyong
	 * @param day
	 * @return
	 */
	public static String getDayAfterDayStart(Date day){
		return getNdaylater2(day, 0) + " 00:00:00";
	}
	
	/** 
	 * 描述: 获取从某个开始到今天的所有年份
	 * @auther chenxin
	 * @date 2016年10月10日 
	 * @param starYear
	 * @return 
	 */
	public static List<String> getYearToNow(){
		int starYear = SART_YEAR;
		List<String> yearList = new ArrayList<String>();
		Calendar curr = Calendar.getInstance();
		String year = String.valueOf(curr.get(Calendar.YEAR));
		int yearInt = Integer.parseInt(year);
		for(int i = yearInt;i>=starYear;i--){
			yearList.add(String.valueOf(i));
		}
		return yearList;
	}
	
	/** 
	 * 描述: 获取年报年度
	 * @auther chenxin
	 * @date 2016年10月10日 
	 * @param starYear
	 * @return 
	 */
	public static List<String> getYearToNowForReport(){
		int starYear = SART_YEAR;
		List<String> yearList = new ArrayList<String>();
		Calendar curr = Calendar.getInstance();
		String year = String.valueOf(curr.get(Calendar.YEAR));
		int yearInt = Integer.parseInt(year);
		for(int i = yearInt-1;i>=starYear;i--){
			yearList.add(String.valueOf(i));
		}
		return yearList;
	}

	/**
	 * 描述：获取从2013年开始的年报年份列表
	 * @author: wangjin
	 * @return
     */
	public static List<String> getYearList(){
		List<String> yearList = new ArrayList<String>();
		Calendar curr = Calendar.getInstance();
		String year = String.valueOf(curr.get(Calendar.YEAR));
		int yearInt = Integer.parseInt(year)-1;
		for(int i=2013;i<=yearInt;i++){
			yearList.add(String.valueOf(i));
		}
		return yearList;
	}

	/**
	 * 描述：获取系统年份的前一年到2013年截至的年份列表
	 * @author: wangjin
	 * @return
	 */
	public static List<String> getYearDescList(){
		List<String> yearList = new ArrayList<String>();
		Calendar curr = Calendar.getInstance();
		String year = String.valueOf(curr.get(Calendar.YEAR));
		int yearInt = Integer.parseInt(year)-1;
		for(int i=yearInt;i>=2013;i--){
			yearList.add(String.valueOf(i));
		}
		return yearList;
	}
	/**
	 * 描述：获取2013年截至当前的年份列表
	 * @author: wangjin
	 * @return
	 */
	public static List<String> getcurYearDescList(){
		List<String> yearList = new ArrayList<String>();
		Calendar curr = Calendar.getInstance();
		String year = String.valueOf(curr.get(Calendar.YEAR));
		int yearInt = Integer.parseInt(year);
		for(int i=yearInt;i>=2013;i--){
			yearList.add(String.valueOf(i));
		}
		return yearList;
	}

	/**
	 *@描述： 获取系统前一天的日期
	 *@author: wangjin
	 *@date 2017-07-26 13:08
	 *@return
	 */
	public static String getPreDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		return new SimpleDateFormat("yyyy年MM月dd日").format(date);

	}


	/** 
	 * 描述: 格式化查询条件：日期拼接上当前时分秒
	 * @auther ZhouYan
	 * @date 2014年11月27日 
	 * @param startTime
	 * @return 
	 */
	public static Date getAllDate(Date date) {
		if (date != null ) {
			return DateUtil.stringToDate(dateToString(date,"yyyy-MM-dd") + dateToString(new Date()," HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}
	
	/**
	 * 返回今年第一天
	 * @author fanzhen
	 * @date 20170510
	 * @return
	 */
	public static Date getNowYearFirstDay(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date nowDate = cal.getTime();
		return nowDate;
	}
	
	
	/**
	 * 返回下一年第一天
	 * @author fanzhen
	 * @date 20170510
	 */
	public static Date getNextYearFirstDay(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getNowYearFirstDay());
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)+1);
		Date nextDate = cal.getTime();
		return nextDate;
	}
	
	/**
	 * 获取某一年的第一天
	 * 
	 * @author zhuyong
	 * @param N
	 * @return
	 */
	public static String getNextYearStart(int N){
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
			return formatter.format(now.getTime()) + "-01-01";
		} catch (Exception e) {
			return "1980-01-01";
		}
	}

	/**
	 * 获取某一年年初
	 * 
	 * @author zhuyong
	 * @param date
	 * @return
	 */
	public static Date getYearFirstDate(Date date){
		if(date == null){
			return null;
		}
		String midDay = dateToString(date, "yyyy") + "-01-01";
		return stringToDate(midDay, "yyyy-MM-dd");
	}
	

	/**
	 * 获取某一年度下一年的年中日期
	 * 
	 * @author zhuyong
	 * @param date
	 * @return
	 */
	public static Date getNextYearMidDate(Date date){
		if(date == null){
			return null;
		}
		String midDay = (Integer.valueOf(dateToString(date, "yyyy")) + 1) + "-07-01";
		return stringToDate(midDay, "yyyy-MM-dd");
	}
}
