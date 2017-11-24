package com.icinfo.cs.nocreditPunish.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishRule;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishrule 对应的Service接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishRuleService extends BaseService {

	/**
     * 查询列表
     *
     * @param request
     * @return
     * @throws Exception
     */
	public List<NoCreditPunishRule> queryPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	public List<NoCreditPunishRule> queryList(Map<String, Object> parms);

	/**
     * 根据主键查询规则
     *
     * @param id
     * @return
     * @throws Exception
     */
	public NoCreditPunishRule findRuleById(String id) throws Exception;

	/**
     * 保存规则
     *
     * @param id
     * @return
     * @throws Exception
     */
	public int insert(NoCreditPunishRule rule) throws Exception;

	/**
	 * 规则保存校验
	 * @param parms
	 * @return
	 */
	public Boolean ruleSaveValid(Map<String, Object> parms);

	/**
     * 更新规则
     * @param rule
     * @return
     * @throws Exception
     */
	public int update(NoCreditPunishRule rule) throws Exception;

	/**
     * 通过主键删除规则
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
	public int deleteByPrimaryKey(String primaryKey) throws Exception;

	/**
	 * 获取当前用户
	 * @return
	 */
	public SysUserDto getCurrUser() throws Exception;

}
