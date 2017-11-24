package com.icinfo.cs.es.controller.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.es.dto.SmEntSearchDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.ISmEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 小微企业查询控制器
 * 
 * @author zhuyong
 */

@Controller
@RequestMapping("sment/smentsearch")
public class SmEntSearchController extends CSBaseController {
	@Autowired
	ISmEntSearchService smEntSearchService;

	@Autowired
	IEntSearchService entSearchService;
	
	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;
	
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	
	@Autowired
	IPubOpaDetailService pubOpaDetailService;
	
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	
	@Autowired
	ISmBaseinfoService smBaseinfoService;

	/**
	 * 描述：小微企业信息查询页面
	 *
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("sment/smentsearch/smentsearch_view");
		return mav;
	}

	/**
	 * 描述：小微企业信息查询数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年5月2日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<SmEntSearchDto> comPanoQueryPage(PageRequest request) throws Exception {
		// creatDefaultDBAuthEnv(request, "localAdm", "localAdm");
		Page<SmEntSearchDto> data = smEntSearchService.doGetSmEntSearchList(request);
		return new PageResponse<SmEntSearchDto>(data);
	}

	/**
	 * 描述：小微企业查询详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年5月4日
	 * @param priPID
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doSmEntSearchDetail/{priPID}")
	public ModelAndView doEnAppSearchDetails(@PathVariable(value = "priPID") String priPID, HttpSession session)
			throws Exception {
		priPID = AESEUtil.decodeCorpid(priPID);
		ModelAndView mav = new ModelAndView("sment/smentsearch/smentsearch_detail");
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("priPID", priPID);
		MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
		mav.addObject("dto", midBaseInfoDto);
		mav.addObject("encryPriPID", AESEUtil.encodeCorpid(priPID));
		mav.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		mav.addObject("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));
		return mav;
	}
	
	/**
	 * 描述：检查企业是否是异常名录和严重违法
	 * @author Administrator
	 * @date 2017年5月4日
	 * @param entTypeCatg
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	private String checkIsOpanomaly(String entTypeCatg, String priPID) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		String opanomaly = "0";
		String seriousCrime = "0";
		if ("50".equals(entTypeCatg)) {
			List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(map);
			if (dataList != null && dataList.size() > 0) {
				opanomaly = "1";
			}
		} else {
			List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch(map);
			if (dataList != null && dataList.size() > 0) {
				opanomaly = "1";
			}
		}
		List<ExpSeriousCrimeList> expSeriousCrimeList = expSeriousCrimeListService
				.selectSeriousCrimeInfoByPriPID(priPID);
		if (expSeriousCrimeList != null && expSeriousCrimeList.size() > 0) {
			seriousCrime = "1";
		}
		// 同时被列入异常和严重违法
		if ("1".equals(opanomaly) && "1".equals(seriousCrime)) {
			return "1";
		} else if ("1".equals(opanomaly) && !"1".equals(seriousCrime)) {// 只列入异常
			return "2";
		} else if (!"1".equals(opanomaly) && "1".equals(seriousCrime)) {// 只列入严重违法
			return "3";
		} else {
			return "0";
		}
	}

	/**
	 * 描述：根据id范围向云服务器导入小微企业全量数据
	 * 
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doInsertPubDataToGsById")
	public void doInsertPubDataToGsById() throws Exception {
		//smEntSearchService.doInsertSmEntDataToGsById();
		smBaseinfoService.doInsertSmEntDataToGsById();
	}
	
	/**
	 * 描述：更新小微企业信息
	 * 
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateSmEnt")
	public ModelAndView updateSmEnt(@RequestParam String condition) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infoinsert/insertDataToGs");
		boolean bool = smEntSearchService.updateSmEnt(condition);
		if (bool) {
			mav.addObject("msg", "单条索引更新成功");
		} else {
			mav.addObject("msg", "单条索引更新失败");
		}
		mav.addObject("condition", condition);
		return mav;
	}

}
