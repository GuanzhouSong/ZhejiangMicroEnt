package com.icinfo.cs.es.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PubEntSearchDto;

/**
 * @author bai
 */
@Component
public class SortUtil {

	/**
	 * 描述：对es查询出的列表进行排序
	 * 
	 * @author
	 * @date 2016年11月4日
	 * @param pubEntSearchDtos
	 */
	public void doEntListSort(List<PubEntSearchDto> pubEntSearchDtos, final String searchKeyWord, final String entarea) {

		Collections.sort(pubEntSearchDtos, new Comparator<PubEntSearchDto>() {
			public int compare(PubEntSearchDto p1, PubEntSearchDto p2) {
				int entTypeCatg1 = 0;
				int entTypeCatg2 = 0;
				if (!StringUtils.isEmpty(p1.getEntTypeCatg())) {
					entTypeCatg1 = Integer.parseInt(p1.getEntTypeCatg());
				}
				if (!StringUtils.isEmpty(p2.getEntTypeCatg())) {
					entTypeCatg2 = Integer.parseInt(p2.getEntTypeCatg());
				}

				if (entTypeCatg1 == 50) {
					entTypeCatg1 = 100;
				} else if (entTypeCatg1 == 16 || entTypeCatg1 == 17) {
					entTypeCatg1 = 200;
				} else if (entTypeCatg1 == 0) {
					entTypeCatg1 = 0;
				} else {
					entTypeCatg1 = 300;
				}
				if (entTypeCatg2 == 50) {
					entTypeCatg2 = 100;
				} else if (entTypeCatg2 == 16 || entTypeCatg2 == 17) {
					entTypeCatg2 = 200;
				} else if (entTypeCatg2 == 0) {
					entTypeCatg2 = 0;
				} else {
					entTypeCatg2 = 300;
				}
				
				String entName1 = p1.getEntName();
				String entName2 = p2.getEntName();
				if (searchKeyWord.equals(entName1)) {
					return 0;
				}
				if (searchKeyWord.equals(entName2)) {
					return 0;
				}
				
				String hisEntName1 = p1.getHisEntName();
				String hisEntName2 = p2.getHisEntName();
				if(!StringUtil.isEmpty(hisEntName1)){
					if (searchKeyWord.equals(hisEntName1)) {
						return 0;
					}
				}
				if(!StringUtil.isEmpty(hisEntName2)){
					if (searchKeyWord.equals(hisEntName2)) {
						return 0;
					}
				}

				if (entTypeCatg2 > entTypeCatg1) {
					return 1;
				} else if (entTypeCatg2 < entTypeCatg1) {
					return -1;
				} else {// 1.类型相同时,2.按照关键字完整性来排序
					if (entName1.contains(searchKeyWord) && !entName2.contains(searchKeyWord)) {
						return -1;
					} else if (!entName1.contains(searchKeyWord) && entName2.contains(searchKeyWord)) {
						return 1;
					} else {// 3.不包含行政区划的排上面

						if (StringUtils.isEmpty(entarea)) {
							return 0;
						}
						if (entName1.length() < 2) {
							return 0;
						}
						if (entName2.length() < 2) {
							return 0;
						}
						if (entarea.contains(entName1.substring(0, 2)) && !entarea.contains(entName2.substring(0, 2))) {
							return 1;
						} else if (!entarea.contains(entName1.substring(0, 2))
								&& entarea.contains(entName2.substring(0, 2))) {
							return -1;
						} else {// 4,5.注册资金的大小
							BigDecimal b1 = p1.getRegCap();
							BigDecimal b2 = p2.getRegCap();

							if (StringUtils.isEmpty(b1)) {
								b1 = BigDecimal.ZERO;
							}
							if (StringUtils.isEmpty(b2)) {
								b2 = BigDecimal.ZERO;
							}
							if (b1.doubleValue() > b2.doubleValue()) {
								return -1;
							} else if (b1.doubleValue() < b2.doubleValue()) {
								return 1;
							} else {// 6.成立日期远近,成立时间长的排上,成立时间短的排下。
								try {
									String estDateStr1 = p1.getEstDate();
									String estDateStr2 = p2.getEstDate();
									long estDateTime1 = 0;
									long estDateTime2 = 0;

									if (!StringUtils.isEmpty(estDateStr1)) {
										estDateTime1 = DateUtil.parseDate(estDateStr1, "yyyy-MM-dd").getTime();
									}
									if (!StringUtils.isEmpty(estDateStr1)) {
										estDateTime2 = DateUtil.parseDate(estDateStr2, "yyyy-MM-dd").getTime();
									}

									if (estDateTime1 > estDateTime2) {
										return 1;
									} else if (estDateTime1 < estDateTime2) {
										return -1;
									} else {// 7.按照名称长短进行排序，名称短的排上，名称长的排下
										if (entName1.length() > entName2.length()) {
											return 1;
										} else if (entName1.length() < entName2.length()) {
											return -1;
										} else {
											return 0;
										}
									}
								} catch (ParseException e) {
									return 0;
								}
							}
						}
					}
				}
			}
		});
	}

}
