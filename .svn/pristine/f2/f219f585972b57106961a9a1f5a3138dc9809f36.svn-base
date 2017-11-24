package com.icinfo.cs.common.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.ISysForbidwordService;

@Component
@Lazy(false)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class KeywordFilter {
	/** 直接禁止的 */
	private static HashMap keysMap = new HashMap();
	private static int matchType = 1; // 1:最小长度匹配 2：最大长度匹配

	@Autowired
	private ISysForbidwordService sysForbidwordService;

	private static KeywordFilter keywordFilter; // 关键点1 静态初使化 一个工具类
												// 这样是为了在spring初使化之前

	public static void setKeywordFilter(KeywordFilter keywordFilter) {
		KeywordFilter.keywordFilter = keywordFilter;
	}

	// 关键二 通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
	@PostConstruct
	public void init() {
		keywordFilter = this;
		keywordFilter.sysForbidwordService = this.sysForbidwordService; // 初使化时将已静态化的testService实例化
		keysMap = addKeywordsByList(keywordFilter.sysForbidwordService.doGetListForCache());
	}

	/**
	 * 
	 * 描述: 将敏感词List<SysForbidword>转化为HashMap 拼装结果类似于：{习={近={平={isEnd=1},
	 * isEnd=0}, isEnd=0}, 共={产={党={isEnd=1}, isEnd=0}, isEnd=0}, 左={isEnd=0,
	 * 派={isEnd=1}},sEnd=0},神={父={isEnd=1}, isEnd=0}}
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param keywords
	 * @return
	 */
	public static HashMap addKeywordsByList(List<SysForbidword> keywords) {
		if (keywords == null)
			keywords = keywordFilter.sysForbidwordService.doGetListForCache();
		HashMap keysMap = new HashMap();
		for (int i = 0; i < keywords.size(); i++) {
			String key = keywords.get(i).getBanLetter().trim();
			HashMap nowhash = null;
			nowhash = keysMap;
			for (int j = 0; j < key.length(); j++) {
				char word = key.charAt(j);
				Object wordMap = nowhash.get(word);
				if (wordMap != null) {
					nowhash = (HashMap) wordMap;
				} else {
					HashMap<String, String> newWordHash = new HashMap<String, String>();
					newWordHash.put("isEnd", "0");
					nowhash.put(word, newWordHash);
					nowhash = newWordHash;
				}
				if (j == key.length() - 1) {
					nowhash.put("isEnd", "1");
				}
			}
		}

		return keysMap;

	}

	/**
	 * 
	 * 描述: 将敏感词List<String>转化为HashMap
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param keywords
	 * @return
	 */
	public static HashMap addKeywords(List<String> keywords) {

		HashMap keysMap = new HashMap();
		for (int i = 0; i < keywords.size(); i++) {
			String key = keywords.get(i).trim();
			HashMap nowhash = null;
			nowhash = keysMap;
			for (int j = 0; j < key.length(); j++) {
				char word = key.charAt(j);
				Object wordMap = nowhash.get(word);
				if (wordMap != null) {
					nowhash = (HashMap) wordMap;
				} else {
					HashMap<String, String> newWordHash = new HashMap<String, String>();
					newWordHash.put("isEnd", "0");
					nowhash.put(word, newWordHash);
					nowhash = newWordHash;
				}
				if (j == key.length() - 1) {
					nowhash.put("isEnd", "1");
				}
			}
		}
		// System.out.println(keysMap);
		return keysMap;
	}

	/**
	 * 
	 * 描述: 清空敏感词keysMap
	 * 
	 * @auther chenyl
	 * @date 2016年10月9日
	 */
	public static void clearKeywords() {
		keysMap.clear();
	}

	/**
	 * 
	 * 描述: 检查一个字符串从begin位置起开始是否有keyword符合，
	 * 如果有符合的keyword值，返回值为匹配keyword的长度，否则返回零。flag 1:最小长度匹配 2：最大长度匹配
	 * 
	 * @auther chenyl
	 * @date 2016年10月9日
	 * @param keysMap
	 * @param txt
	 * @param begin
	 * @param flag
	 * @return
	 */
	private static int checkKeyWords(HashMap keysMap, String txt, int begin, int flag) {
		HashMap nowhash = null;
		nowhash = keysMap;
		int maxMatchRes = 0;
		int res = 0;
		int l = txt.length();
		char word = 0;
		for (int i = begin; i < l; i++) {
			word = txt.charAt(i);
			Object wordMap = nowhash.get(word);
			if (wordMap != null) {
				res++;
				nowhash = (HashMap) wordMap;
				if (((String) nowhash.get("isEnd")).equals("1")) {
					if (flag == 1) {
						wordMap = null;
						nowhash = null;
						txt = null;
						return res;
					} else {
						maxMatchRes = res;
					}
				}
			} else {
				txt = null;
				nowhash = null;
				return maxMatchRes;
			}
		}
		txt = null;
		nowhash = null;
		return maxMatchRes;
	}

	/**
	 * 描述: 返回txt字符串中包含敏感词的列表
	 * 
	 * @auther chenyl
	 * @date 2016年10月9日
	 * @param keysMap
	 * @param txt
	 * @return
	 */
	public static Set<String> getTxtKeyWords(HashMap keysMap, String txt) {
		
		Set set = new HashSet();
		if(txt==null||"".equals(txt)) return set;
		int l = txt.length();
		for (int i = 0; i < l;) {
			int len = checkKeyWords(keysMap, txt, i, matchType);
			if (len > 0) {
				set.add(txt.substring(i, i + len));
				i += len;
			} else {
				i++;
			}
		}
		txt = null;
		return set;
	}

	/**
	 * 描述: 判断txt字符串中是否有敏感词
	 * 
	 * @auther chenyl
	 * @date 2016年10月9日
	 * @param keysMap
	 * @param txt
	 * @return
	 */
	public static boolean isContentKeyWords(HashMap keysMap, String txt) {
		if(txt==null||"".equals(txt)) return false;
		for (int i = 0; i < txt.length(); i++) {
			int len = checkKeyWords(keysMap, txt, i, 1);
			if (len > 0) {
				return true;
			}
		}
		txt = null;
		return false;
	}

	public static int getMatchType() {
		return matchType;
	}

	public static void setMatchType(int matchType) {
		KeywordFilter.matchType = matchType;
	}

	/**
	 * 描述: 将文本中的敏感词进行替换成****
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param content
	 * @return
	 */
	public static String getReplaceCon(String content) {
		if(content==null||"".equals(content)) return content;
		boolean boo = isContentKeyWords(keysMap, content);
		if (boo) {
			Set<String> set = getTxtKeyWords(keysMap, content);
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				content = content.replace(it.next(), "****");
			}
			return content;
		} else {

			return content;
		}

	}

	/**
	 * 描述: 根据传入的List<SysForbidword>替换文本中的敏感词
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param keywords
	 * @param content
	 * @return
	 */
	public static String getReplaceCon(List<SysForbidword> keywords, String content) {
		if(content==null||"".equals(content)) return content;
		HashMap keysMap = addKeywordsByList(keywords);
		boolean boo = isContentKeyWords(keysMap, content);
		if (boo) {
			Set<String> set = getTxtKeyWords(keysMap, content);
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				content = content.replace(it.next(), "****");
			}
			return content;
		} else {

			return content;
		}

	}

	/**
	 * 描述: 根据组成的敏感词集合，将文本中的敏感词进行替换成****
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param content
	 * @return
	 */
	public static String getReplaceCon(HashMap keysMap, String content) {
		if(content==null||"".equals(content)) return content;
		boolean boo = isContentKeyWords(keysMap, content);
		if (boo) {
			Set<String> set = getTxtKeyWords(keysMap, content);
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				content = content.replace(it.next(), "****");
			}
			return content;
		} else {

			return content;
		}

	}

	/**
	 * 描述: 根据库中敏感词记录，修改keysMap的内容，敏感词内容修改后调用此方法
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 */
	public static void changeKeysMap() {
		clearKeywords();
		keysMap = addKeywordsByList(keywordFilter.sysForbidwordService.doGetListForCache());
	}

	/**
	 * 判断是字符串中是否有敏感字符字符
	 * @param txt
	 * @return
     */
	public static String getKeyWordsBytxt(String txt) {
		String keyword="";
		if(txt==null||"".equals(txt)) return keyword;
		int l = txt.length();
		for (int i = 0; i < l;) {
			int len = checkKeyWords(keysMap, txt, i, matchType);
			if (len > 0) {
				keyword = keyword +(txt.substring(i, i + len));
				i += len;
			} else {
				i++;
			}
		}
		return keyword;
	}


}
