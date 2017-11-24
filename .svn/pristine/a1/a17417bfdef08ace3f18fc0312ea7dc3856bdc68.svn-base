package com.icinfo.cs.nocreditPunish.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishRuleDto;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishRule;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishRuleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 失信联合惩戒规则控制器
 * @author caoxu
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/syn/noCreditPunish/rule", "/reg/server/noCreditPunish/rule" })
public class NoCreditPunishRuleController extends BaseController {
	
	//private final static Logger logger = LoggerFactory.getLogger(NoCreditPunishRuleController.class);
	
	@Autowired
	private NoCreditPunishRuleService noCreditPunishRuleService;
	
	/**
	 * 跳转到规则列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list"})
	public String list() throws Exception {
		return "/syn/system/nocreditPunish/rule/punishrulelist";
	}
	
	/**
     * 惩戒规则JSON数据列表（带分页）
     *
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishRule> listJSON(PageRequest request) throws Exception {
		List<NoCreditPunishRule> data = noCreditPunishRuleService.queryPage(request, request.getParams());
		return new PageResponse<NoCreditPunishRule>(data);
	}
	
	/**
	 * 惩戒规则列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/listAll.json", "listAll.xml" })
	@ResponseBody
	public List<NoCreditPunishRule> listAll(Map<String, Object> parms) throws Exception {
		List<NoCreditPunishRule> data = noCreditPunishRuleService.queryList(parms);
		return data;
	}

	/**
	 * 弹出添加框
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/show" })
	public String show(String id, ModelMap map) throws Exception {
		if (StringUtils.isNotEmpty(id)) {
			NoCreditPunishRule rule = noCreditPunishRuleService.findRuleById(id);
			map.addAttribute("rule", rule);
		}
		// 获取当前用户
		SysUserDto user = this.noCreditPunishRuleService.getCurrUser();
		map.put("user", user);
		return "/syn/system/nocreditPunish/rule/punishruleedit";
	}
	
	/**
	 * 保存规则
	 * @param ruleDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult save(@Valid @RequestBody NoCreditPunishRuleDto ruleDto, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查红色*的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		// 校验领域+事由唯一性
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("punCause", ruleDto.getPunCause().trim());
		parms.put("punField", ruleDto.getPunField().trim());
		// 编辑保存
		if (StringUtils.isNotEmpty(ruleDto.getId())) {
			// 编辑校验逻辑
			NoCreditPunishRule rule = noCreditPunishRuleService.findRuleById(ruleDto.getId());
			if (rule.getPunField().equals(ruleDto.getPunField().trim())
					&& rule.getPunCause().equals(ruleDto.getPunCause().trim())) {
				// 没有修改过这两个，则不校验
			} else {
				// 修改过其中任何一个，校验
				if (this.noCreditPunishRuleService.ruleSaveValid(parms)) {
					return AjaxResult.error("请确保【惩戒事由】与【惩戒领域】组合起来是唯一的");
				}
			}
			if (noCreditPunishRuleService.update(ruleDto) > 0) {
				return AjaxResult.success("修改规则成功.");
			}
			return AjaxResult.success("修改规则失败！.");
		} else {
			// 新增保存，先校验
			if (this.noCreditPunishRuleService.ruleSaveValid(parms)) {
				return AjaxResult.error("请确保【惩戒事由】与【惩戒领域】组合起来是唯一的");
			}
			if (noCreditPunishRuleService.insert(ruleDto) > 0) {
				return AjaxResult.success("创建新规则成功.");
			}
			return AjaxResult.error("创建新规则失败！");
		}
	}
	
	/**
	 * 根据领域加载事由
	 * @param punField
	 * @return
	 */
	@RequestMapping(value = "/getCauseByField", method = RequestMethod.POST)
    @ResponseBody
	public List<NoCreditPunishRule> getCauseByField(String punField) {
		if (!punField.isEmpty()) {
			Map<String, Object> parms = new HashMap<String, Object>();
			parms.put("punField", punField.trim());
			List<NoCreditPunishRule> rules = this.noCreditPunishRuleService.queryList(parms);
			return rules;
		}
		return new ArrayList<NoCreditPunishRule>();
	}
	
	/**
	 * 根据领域，事由查询规则
	 * @param punField
	 * @param punCause
	 * @return
	 */
	@RequestMapping(value = "/getRuleByFieldAndCause", method = RequestMethod.POST)
    @ResponseBody
	public NoCreditPunishRule getRuleByFieldAndCause(String punField, String punCause) {
		if (!punField.isEmpty() && !punCause.isEmpty()) {
			Map<String, Object> parms = new HashMap<String, Object>();
			parms.put("punCause", punCause.trim());
			parms.put("punField", punField.trim());
			List<NoCreditPunishRule> rules = this.noCreditPunishRuleService.queryList(parms);
			if (rules.size() > 0) {
				return rules.get(0);
			}
		}
		return null;
	}
	
	/**
     * 删除规则
     *
     * @param id
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(String id) throws Exception {
		if (StringUtils.isEmpty(id)) {
			return AjaxResult.error("请先选择要删除的规则！");
		}
		if (noCreditPunishRuleService.deleteByPrimaryKey(id) > 0) {
			return AjaxResult.success("删除规则成功.");
		}
		return AjaxResult.error("删除规则失败！");
	}
	
	/**
	 * 选择框
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/selectrule"})
	public String selectrule() throws Exception {
		return "/syn/system/nocreditPunish/rule/selectdig";
	}

}
