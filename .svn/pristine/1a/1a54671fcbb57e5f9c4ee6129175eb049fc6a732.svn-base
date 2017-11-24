package com.icinfo.cs.yr.controller.reg.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.cs.yr.service.IIndividQuestionnaireService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

@Controller
@RequestMapping("/reg/server/yr/questionnairesearch")
public class IndividQueSearchController extends BaseController {
	
	@Autowired
	private IIndividQuestionnaireService IndividQuestionnaireService;
	
	@Autowired
	private IIndividQueMainService individQueMainService;
	
	@Autowired 
	private ICodeRegunitService codeRegunitService;
	
	@Autowired
	private ICodeRegorgService codeRegorgService;
	
	/**
	 * 
	 * 描述: 进入个转企调查表修正页面
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/yr/questionnaire/quesearch_list");
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
     * 描述：获取个转企调查表列表数据
     * @author yujingwei
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<IndividQueMain> listJSON(PageRequest request) throws Exception {
		List<IndividQueMain> data = individQueMainService.queryPage(request);
        return new PageResponse<IndividQueMain>(data);
    }
	
	/**
	 * 
	 * 描述: 进入个转企调查表修正详细页面
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView view(String pripid,Integer year) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/yr/questionnaire/quesearch_edit");
		List<IndividQueMain> individQueMainList  = individQueMainService.selectIndividQueMainList(pripid, year);
		List<IndividQuestionnaire> questionnaireList = IndividQuestionnaireService.selectQuestionnaireList(pripid, year, null);
		//须根据当前用户判断查询机关
		view.addObject("individQueMainList", individQueMainList);
		view.addObject("questionnaireList", IndividQuestionnaireService.wrapQuestionnaireList(questionnaireList));
		return view;
	}
}