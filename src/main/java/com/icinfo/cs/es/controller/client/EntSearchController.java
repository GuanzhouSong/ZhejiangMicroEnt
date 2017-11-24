package com.icinfo.cs.es.controller.client;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.cs.base.service.ICodeDzLicenseService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.RestFulClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.LimitwordDto;
import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.model.PubSearchLog;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.ILimitwordService;
import com.icinfo.cs.es.service.IPubSearchLogService;
import com.icinfo.cs.es.util.Des;
import com.icinfo.cs.es.util.DomainSecurity;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.ext.service.IMidAltitemService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.ISysForbidwordService;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;

/**
 * 描述：企业综合查询
 * 
 * @author baifangfang
 * @date 2016年8月30日
 */
@Controller
@RequestMapping("client/entsearch")
public class EntSearchController {
	private static final Logger logger = LoggerFactory.getLogger(EntSearchController.class);

	@Autowired
	IEntSearchService entSearchService;

	@Autowired
	IBaseInfoService baseInfoService;

	@Autowired
	ISysForbidwordService sysForbidwordService;

	@Autowired
	ILimitwordService limitwordService;

	@Autowired
	IPubSearchLogService pubSearchLogService;

	@Autowired
	IErEscAppinfoService erEscAppinfoService;

	@Autowired
	IMidInvService midInvService;

	@Autowired
	Des des;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ICodeDzLicenseService codeDzLicenseService;

	@Autowired
	RestFulClient sclient;

	@Autowired
	IMidAltitemService midAltitemService;

	private static final String infoKey = "209814cqwxqqnbasdf";

	/**
	 * 描述：公示综合查询
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param searchKeyWord
	 * @param currentPage
	 * @return
	 */
	@DomainSecurity
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView doGetAppSearchResult(@RequestParam(required = false) String searchKeyWord,
			@RequestParam(required = false, defaultValue = "0") int currentPage,
			@RequestParam(required = false) String pubType, @RequestParam(required = false) String isOpanomaly) {
		logger.info("searchKeyWord {},isOpanomaly {}", searchKeyWord, isOpanomaly);

		if (StringUtils.isEmpty(searchKeyWord)) {
			return null;
		}
		String decSearchKeyWord = des.strDec(searchKeyWord, "a", "b", "c");
		logger.info("decode keyword {}", decSearchKeyWord);

		ModelAndView mav = new ModelAndView("pub/infopublic/infosearch/entsearch_list");
		if (StringUtils.isEmpty(decSearchKeyWord)) {
			mav = new ModelAndView("redirect:toEntSearch");
			return mav;
		}

		// 敏感词审核
		List<SysForbidword> sysForbidwords = sysForbidwordService.findSysForbidBySearchKeyWord(decSearchKeyWord);
		if (sysForbidwords != null && sysForbidwords.size() > 0) {
			mav = new ModelAndView("pub/infopublic/infosearch/zhejiang");
			if ("1".equals(isOpanomaly)) {
				mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else if ("2".equals(isOpanomaly)) {
				mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else {
				mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			}
			mav.addObject("msg", "输入的关键字包含敏感词，请重新输入");
			return mav;
		}

		// 企业名称由四段式构成，行政区划+字号+行业+公司性质，本系统仅支持对“行业”和“字号”的模糊查询
		List<LimitwordDto> limitwordDtos = new ArrayList<LimitwordDto>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("limitword", decSearchKeyWord);
		limitwordDtos = limitwordService.queryListResult(queryMap);

		if (limitwordDtos != null && limitwordDtos.size() > 0) {
			mav = new ModelAndView("pub/infopublic/infosearch/zhejiang");
			if ("1".equals(isOpanomaly)) {
				mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else if ("2".equals(isOpanomaly)) {
				mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else {
				mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			}
			mav.addObject("msg", "输入的关键字不明确，请重新输入");
			return mav;
		}

		logger.info("input param searchKeyWord {},currentPage {}", decSearchKeyWord, currentPage);
		Map<String, Object> entBasicInfos;
		if (currentPage > 5) {
			entBasicInfos = entSearchService.doGetAppSearchResult(decSearchKeyWord, 4, isOpanomaly);
		} else {
			entBasicInfos = entSearchService.doGetAppSearchResult(decSearchKeyWord, currentPage, isOpanomaly);
			if (entBasicInfos != null) {
				mav.addObject("size", entBasicInfos.get("size"));
			}
		}

		if ("1".equals(isOpanomaly)) {
			mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else if ("2".equals(isOpanomaly)) {
			mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else {
			mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		}

		logger.info("entBasicInfos {}", entBasicInfos);
		if (entBasicInfos != null) {
			mav.addObject("entBasicInfos", entBasicInfos.get("resultPage"));
			mav.addObject("took", entBasicInfos.get("took"));
		}
		mav.addObject("flag", "list?isOpanomaly=" + isOpanomaly + "&pubType=" + pubType + "&searchKeyWord="
				+ searchKeyWord + "&currentPage=");

		// 保存到公示搜索日志表
		String pubIp = getNetIP();
		Date now = new Date();
		PubSearchLog pubSearchLog = new PubSearchLog();
		pubSearchLog.setPubIp(pubIp);
		pubSearchLog.setPubSearchKey(decSearchKeyWord);
		pubSearchLog.setPubType(pubType);
		pubSearchLog.setPubTime(now);
		pubSearchLogService.savePubSearchLog(pubSearchLog);

		return mav;
	}
	
	/**
	 * 描述：公示搜索接口
	 * 
	 * @author baifangfang
	 * @date 2017年11月10日
	 * @param searchKeyWord
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "entlist", method = RequestMethod.GET)
	public ModelAndView entList(@RequestParam(required = false) String searchKeyWord,
			@RequestParam(required = false, defaultValue = "0") int currentPage,
			@RequestParam(required = false) String pubType, @RequestParam(required = false) String isOpanomaly) {
		logger.info("searchKeyWord {},isOpanomaly {}", searchKeyWord, isOpanomaly);

		if (StringUtils.isEmpty(searchKeyWord)) {
			return null;
		}

		ModelAndView mav = new ModelAndView("pub/infopublic/infosearch/entsearch_list");

		// 敏感词审核
		List<SysForbidword> sysForbidwords = sysForbidwordService.findSysForbidBySearchKeyWord(searchKeyWord);
		if (sysForbidwords != null && sysForbidwords.size() > 0) {
			mav = new ModelAndView("pub/infopublic/infosearch/zhejiang");
			if ("1".equals(isOpanomaly)) {
				mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else if ("2".equals(isOpanomaly)) {
				mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else {
				mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			}
			mav.addObject("msg", "输入的关键字包含敏感词，请重新输入");
			return mav;
		}

		// 企业名称由四段式构成，行政区划+字号+行业+公司性质，本系统仅支持对“行业”和“字号”的模糊查询
		List<LimitwordDto> limitwordDtos = new ArrayList<LimitwordDto>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("limitword", searchKeyWord);
		limitwordDtos = limitwordService.queryListResult(queryMap);

		if (limitwordDtos != null && limitwordDtos.size() > 0) {
			mav = new ModelAndView("pub/infopublic/infosearch/zhejiang");
			if ("1".equals(isOpanomaly)) {
				mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else if ("2".equals(isOpanomaly)) {
				mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			} else {
				mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
			}
			mav.addObject("msg", "输入的关键字不明确，请重新输入");
			return mav;
		}

		logger.info("input param searchKeyWord {},currentPage {}", searchKeyWord, currentPage);
		Map<String, Object> entBasicInfos;
		if (currentPage > 5) {
			entBasicInfos = entSearchService.doGetAppSearchResult(searchKeyWord, 4, isOpanomaly);
		} else {
			entBasicInfos = entSearchService.doGetAppSearchResult(searchKeyWord, currentPage, isOpanomaly);
			if (entBasicInfos != null) {
				mav.addObject("size", entBasicInfos.get("size"));
			}
		}

		if ("1".equals(isOpanomaly)) {
			mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else if ("2".equals(isOpanomaly)) {
			mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else {
			mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		}

		logger.info("entBasicInfos {}", entBasicInfos);
		if (entBasicInfos != null) {
			mav.addObject("entBasicInfos", entBasicInfos.get("resultPage"));
			mav.addObject("took", entBasicInfos.get("took"));
		}
		mav.addObject("flag", "list?isOpanomaly=" + isOpanomaly + "&pubType=" + pubType + "&searchKeyWord="
				+ searchKeyWord + "&currentPage=");

		// 保存到公示搜索日志表
		String pubIp = getNetIP();
		Date now = new Date();
		PubSearchLog pubSearchLog = new PubSearchLog();
		pubSearchLog.setPubIp(pubIp);
		pubSearchLog.setPubSearchKey(searchKeyWord);
		pubSearchLog.setPubType(pubType);
		pubSearchLog.setPubTime(now);
		pubSearchLogService.savePubSearchLog(pubSearchLog);

		return mav;
	}

	/**
	 * 描述：进入公示企业查询页面
	 * 
	 * @author baifangfang
	 * @date 2016年9月11日
	 * @return
	 */
	@RequestMapping("toEntSearch")
	public ModelAndView toSearch(String entName) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infosearch/zhejiang");
		mav.addObject("classFlag", 1);
		if (StringUtil.isNotEmpty(entName)) { // 添加分享的的企业名称
			entName = AESEUtil.decodeYear(entName);// 解密
			mav.addObject("entName", entName);
		}
		return mav;
	}

	/**
	 * 描述：根据文档id查询企业详情
	 * 
	 * @author baifangfang
	 * @date 2016年9月9日
	 * @param docId
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@DomainSecurity
	@RequestMapping(value = "selectByDocId", method = RequestMethod.GET)
	public ModelAndView selectByDocId(@RequestParam String docId, @RequestParam int classFlag,
			@RequestParam(required = false) String pubType) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/baseinfo");
		if (classFlag == 1) {
			mav = new ModelAndView("pub/infopublic/infodetail/baseinfo");
			mav.addObject("classflag", 1);// 5个tab标签显示样式标记
			mav.addObject("classFlag", 1);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else if (classFlag == 2) {
			mav = new ModelAndView("pub/infopublic/infodetail/anomalyinfo");
			mav.addObject("classflag", 4);// 5个tab标签显示样式标记
			mav.addObject("classFlag", 2);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		} else {
			mav = new ModelAndView("pub/infopublic/infodetail/illegalinfo");
			mav.addObject("classflag", 5);// 5个tab标签显示样式标记
			mav.addObject("classFlag", 3);// 1.企业信用信息2.经营异常名录3.严重违法失信企业
		}
		String decodeDocId = AESEUtil.decodeCorpid(docId);
		logger.info("input param docId {}", docId);

		// 查es
		PubEntSearchDto entBasicInfoES = entSearchService.selectByDocId(decodeDocId);
		// 查表
		PubEntSearchDto entBasicInfo = entSearchService.selectByPriPID(decodeDocId);
		entBasicInfo.setIsOpanomaly(entBasicInfoES.getIsOpanomaly());
		entBasicInfo.setEncryPriPID(docId);
		if (("33".equals(entBasicInfo.getEntTypeCatg()) || "27".equals(entBasicInfo.getEntTypeCatg()))
				&& "1".equals(entBasicInfo.getExeAffSign())) {// 合伙企业法人从投资表取值
			entBasicInfo.setLeRep(entBasicInfo.getInv());
		}

		// 查询该企业简易注销信息
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(entBasicInfo.getPriPID());
		if (erEscAppinfo != null) {
			mav.addObject("flag", "1");
			mav.addObject("erEscAppinfo", erEscAppinfo);
			if (erEscAppinfo.getNoticeTo() != null && erEscAppinfo.getNoticeTo().getTime() > new Date().getTime()
					&& !"5".equals(erEscAppinfo.getSimplecanRea())) {
				entBasicInfo.setIsSimpleCancle("1");
				mav.addObject("objectionFlag", "1");
			} else {
				mav.addObject("objectionFlag", "0");
			}
		}

		String basx = entBasicInfo.getBasx();
		String contents = "";
		if (!StringUtil.isEmpty(basx)) {
			String[] basxs = basx.split(",");
			for (int i = 0; i < basxs.length; i++) {
				CodeDzLicense codeDzLicense = codeDzLicenseService.selectCodeLicenseByExaCodeAndLicType(basxs[i], "2");
				if (codeDzLicense != null) {
					String content = codeDzLicense.getExaName();
					contents = content + "，" + contents;
				}
			}
		}
		if (!StringUtil.isEmpty(contents)) {
			contents = contents.substring(0, contents.length() - 1);
		}
		entBasicInfo.setBasxCN(contents);
		mav.addObject("entBasicInfo", entBasicInfo);
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());

		// 保存到公示搜索日志表
		String pubIp = getNetIP();
		Date now = new Date();
		PubSearchLog pubSearchLog = new PubSearchLog();
		pubSearchLog.setPubIp(pubIp);
		pubSearchLog.setPriPID(entBasicInfo.getPriPID());
		pubSearchLog.setPubType(pubType);
		pubSearchLog.setPubTime(now);
		pubSearchLogService.savePubSearchLog(pubSearchLog);

		long invEnd = DateUtil.parseDate("2014-02-28", "yyyy-MM-dd").getTime();
		mav.addObject("invEnd", invEnd);

		return mav;
	}

	private String getNetIP() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@RequestMapping("testIP")
	public ModelAndView testIP() throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/testIP");
		String ip1 = request.getHeader("x-forwarded-for");
		if (ip1 == null || ip1.length() == 0 || "unknown".equalsIgnoreCase(ip1)) {
			ip1 = request.getHeader("Proxy-Client-IP");
		}
		if (ip1 == null || ip1.length() == 0 || "unknown".equalsIgnoreCase(ip1)) {
			ip1 = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip1 == null || ip1.length() == 0 || "unknown".equalsIgnoreCase(ip1)) {
			ip1 = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip1 == null || ip1.length() == 0 || "unknown".equalsIgnoreCase(ip1)) {
			ip1 = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip1 == null || ip1.length() == 0 || "unknown".equalsIgnoreCase(ip1)) {
			ip1 = request.getRemoteAddr();
		}
		mav.addObject("xforwardedforip_1", ip1);

		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP
		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
					netip = ip.getHostAddress();
					finded = true;
					break;
				} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
					localip = ip.getHostAddress();
				}
			}
		}
		mav.addObject("netip2", netip);
		mav.addObject("localip3", localip);
		return mav;
	}

	/**
	 * 描述：向云服务器导入全量数据根据id范围
	 * 
	 * @author baifangfang
	 * @date 2016年11月15日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doInsertPubDataToGsById")
	public void doInsertPubDataToGsById() throws Exception {
		entSearchService.doInsertPubDataToGsById();
	}

	/**
	 * 描述：向云服务器导入全量数据根据id范围(使用多线程的方式)
	 * 
	 * @author baifangfang
	 * @date 2017年1月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doInsertPubDataToGsByIdUseThreadPool")
	public void doInsertPubDataToGsByIdUseThreadPool() throws Exception {
		entSearchService.doInsertPubDataToGsByIdUseThreadPool();
	}

	/**
	 * 描述：根据企业名称或注册号或统一代码向云服务器导入单条数据
	 * 
	 * @author baifangfang
	 * @date 2016年12月10日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateOrSaveToGs")
	public ModelAndView updateOrSaveToGs(@RequestParam String condition) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");
		Boolean bool = entSearchService.doInsertPubSingleDataToGs(condition);
		if (bool) {
			mav.addObject("msg", "单条索引更新成功");
		} else {
			mav.addObject("msg", "单条索引更新失败");
		}
		mav.addObject("condition", condition);
		return mav;
	}

	/**
	 * 描述：根据pripid更新索引(是否简易注销)
	 * 
	 * @author baifangfang
	 * @date 2017年4月13日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isSimpleCancle")
	public ModelAndView isSimpleCancle(@RequestParam String priPID, @RequestParam String password,
			@RequestParam String isSimpleCancle) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("priPID", priPID);
		jsonMap.put("isSimpleCancle", isSimpleCancle);

		String isSuccess = "0";
		if (!StringUtil.isEmpty(priPID) && infoKey.equals(password)) {
			isSuccess = entSearchService.updatePubIndex(jsonMap);
		}
		if ("1".equals(isSuccess)) {
			mav.addObject("msg", "简易注销更新成功");
		} else {
			mav.addObject("msg", "简易注销更新失败");
		}
		mav.addObject("priPID", priPID);
		return mav;
	}

	/**
	 * 描述：根据内部序号删除索引
	 * 
	 * @author baifangfang
	 * @date 2017年2月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteEntByPriPID", method = RequestMethod.POST)
	public ModelAndView deleteEntByPriPID(@RequestParam String priPID, @RequestParam String password) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");

		Boolean bool = false;
		if (!StringUtil.isEmpty(priPID) && infoKey.equals(password)) {
			bool = entSearchService.deleteEntByPriPID(priPID);
		}
		if (bool) {
			mav.addObject("msg", "单条索引删除成功");
		} else {
			mav.addObject("msg", "单条索引删除失败");
		}
		mav.addObject("priPID", priPID);
		return mav;
	}

	/**
	 * 描述：根据核准日期向云服务器导入数据
	 * 
	 * @author baifangfang
	 * @date 2016年12月16日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doInsertPubDataToGsByApprDate")
	public ModelAndView doInsertPubDataToGsByApprDate(@RequestParam String apprDate) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");
		Boolean bool = entSearchService.doInsertPubDataToGsByApprDate(apprDate);
		if (bool) {
			mav.addObject("msg", "根据核准日期更新成功");
		} else {
			mav.addObject("msg", "根据核准日期更新失败");
		}
		mav.addObject("apprDate", apprDate);
		return mav;
	}

	/**
	 * 描述：根据企业名称或注册号或统一代码向云服务器导入单条数据
	 * 
	 * @author baifangfang
	 * @date 2016年12月10日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateOrSaveToGsView")
	public ModelAndView updateOrSaveToGs() {
		return new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");
	}

	/**
	 * 描述：业务咨询与技术支持连续方式链接页面
	 * 
	 * @author baifangfang
	 * @date 2016年11月24日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("contact")
	public ModelAndView contact() throws Exception {
		ModelAndView mav = new ModelAndView("pub/common/contact");
		mav.addObject("classFlag", 1);
		return mav;
	}

	/**
	 * 执行事务合伙人索引更新
	 * 
	 * @author baifangfang
	 * @throws Exception
	 */
	@RequestMapping("updatePartner")
	public void updatePartner() throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<MidInv> midInvList = midInvService.findMidInvByExeAffSign();
		List<String> returnResult = new ArrayList<String>();
		for (MidInv midInv : midInvList) {
			jsonMap.put("priPID", midInv.getPriPID());
			jsonMap.put("leRep", midInv.getInv());
			String i = entSearchService.updatePubIndex(jsonMap);
			returnResult.add(i);
		}
		System.out.println(returnResult);
	}
	
	/**
	 * 是否经营异常更新
	 * 
	 * @author baifangfang
	 * @throws Exception
	 */
	@RequestMapping("updateOpanTest")
	public void updateOpan() throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("priPID", "3302030000042193");
		jsonMap.put("isOpanomaly", 0);
		String i = entSearchService.updatePubIndex(jsonMap);
		System.out.println(i);
	}

	/**
	 * 历史名称索引更新
	 * 
	 * @author baifangfang
	 * @throws Exception
	 */
	@RequestMapping("updateHisEntName")
	public void updateHisEntName() throws Exception {
		entSearchService.updateHisEntName();
	}

	/**
	 * 描述：判断该企业是否有电子营业执照
	 * 
	 * @author yujingwei
	 * @date 2017年2月13日
	 * @param encryPriPID
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "bussinessLic")
	public ModelAndView objectionDetail(String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/businesslic");
		// priPID解密
		String paramPriPID = AESEUtil.decodeCorpid(encryPriPID);
		// 查询该企业是否有电子营业执照
		String elBusinessLicFlag = doJudgeIsExsitBussinessLic(paramPriPID);

		PubEntSearchDto entBasicInfo = entSearchService.selectByPriPID(paramPriPID);
		if ("1".equals(elBusinessLicFlag)) {
			BASE64Encoder encoder = new BASE64Encoder();
			// 获取图片流
			byte[] licByte = doGetBusinessLicByte(entBasicInfo.getRegNO(), entBasicInfo.getUNICODE());
			// 转base64
			String base64Str = encoder.encode(licByte);
			mav.addObject("businessLicByte", base64Str);
		}
		mav.addObject("elBusinessLicFlag", elBusinessLicFlag);
		return mav;
	}

	/**
	 * 调用web接口判断企业是否含有电子营业执照
	 * 
	 * @author yujingwei
	 * @return String
	 */
	private String doJudgeIsExsitBussinessLic(String priPID) {
		try {
			String parameterForSend = "method=getWsdjSbms&PRIPID=" + priPID;
			// 调用远程服务
			String result = sclient.callRemoteForBusinessLicService(parameterForSend);
			if (StringUtil.isBlank(result) || result.indexOf("sucess") == -1) {
				return null;
			} else {
				JSONObject jsonObj = JSONObject.fromObject(result);
				if (jsonObj.containsKey("code")) {
					String returnCode = jsonObj.get("code").toString();
					// 输出结果
					System.out.println("返回的结果编码：" + returnCode);
					return returnCode;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Hppt请求获取流
	 * 
	 * @author yujingwei
	 * @return byte[]
	 */
	private byte[] doGetBusinessLicByte(String regNO, String uniCode) {
		try {
			String GET_URL = "http://59.202.29.134:8081/businessCheck/viewLicence_view_20151215.do?attribute13="
					+ uniCode + "&attribute17=" + regNO;
			CloseableHttpClient client = HttpClients.createDefault();
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(GET_URL);
			System.out.println("请求地址：" + GET_URL);

			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			// 执行请求操作，并拿到结果（同步阻塞）
			CloseableHttpResponse response = client.execute(httpPost);
			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				byte[] body = EntityUtils.toByteArray(entity);
				return body;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
