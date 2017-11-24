package com.icinfo.cs.nocreditPunish.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishRuleMapper;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishRule;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishRuleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishrule 对应的Mapper接口实现类.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
@Service
public class NoCreditPunishRuleServiceImpl extends MyBatisServiceSupport implements NoCreditPunishRuleService {
	
	@Autowired
	private NoCreditPunishRuleMapper noCreditPunishRuleMapper;
	
	@Autowired
	private  HttpServletRequest request;
	
	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public List<NoCreditPunishRule> queryPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(NoCreditPunishRule.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return noCreditPunishRuleMapper.selectByExample(example);
	}
	
	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	@Override
	public List<NoCreditPunishRule> queryList(Map<String, Object> parms) {
		Example example = new Example(NoCreditPunishRule.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		List<NoCreditPunishRule> list = noCreditPunishRuleMapper.selectByExample(example);
		return list;
	}
	
	/**
     * 根据主键查询规则
     * @param id
     * @return
     * @throws Exception
     */
	@Override
	public NoCreditPunishRule findRuleById(String id) throws Exception {
		if (isEmpty(id)) {
            return null;
        }
        return noCreditPunishRuleMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 保存规则
     * @param rule
     * @return
     * @throws Exception
     */
	@Override
	@Transactional(rollbackFor = Exception.class)
    public int insert(NoCreditPunishRule rule) throws Exception {
		rule.setCreateTime(new Date());
		return noCreditPunishRuleMapper.insert(rule);
	}
	
	/**
     * 更新规则
     * @param rule
     * @return
     * @throws Exception
     */
	@Override
	@Transactional(rollbackFor = Exception.class)
    public int update(NoCreditPunishRule rule) throws Exception {
		if (rule == null || isEmpty(rule.getId())) {
            return 0;
        }
		return noCreditPunishRuleMapper.updateByPrimaryKeySelective(rule);
	}
	
	/**
	 * 规则保存校验
	 * @param parms
	 * @return
	 */
	@Override
	public Boolean ruleSaveValid(Map<String, Object> parms) {
		List<NoCreditPunishRule> list = queryList(parms);
		return list.size() > 0 ? true : false;
	}
	
	/**
     * 通过主键删除规则
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKey(String primaryKey) throws Exception {
        return noCreditPunishRuleMapper.deleteByPrimaryKey(primaryKey);
    }
    
    /**
	 * 获取当前用户
	 * @return
	 */
	@Override
	public SysUserDto getCurrUser() throws Exception {
		SysUserDto user = (SysUserDto) request.getSession().getAttribute(Constants.SESSION_SYS_USER);
		return user;
	}

}
