package com.icinfo.cs.nocreditPunish.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishBackDto;
import com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishBackMapper;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishBack;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishBackService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishback 对应的Mapper接口实现类.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
@Service
public class NoCreditPunishBackServiceImpl extends MyBatisServiceSupport implements NoCreditPunishBackService {
	
	@Autowired
	private NoCreditPunishBackMapper noCreditPunishBackMapper;
	
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
	public List<NoCreditPunishBack> queryPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(NoCreditPunishBack.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return noCreditPunishBackMapper.selectByExample(example);
	}
	
	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	@Override
	public List<NoCreditPunishBack> queryList(Map<String, Object> parms) throws Exception {
		Example example = new Example(NoCreditPunishBack.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		List<NoCreditPunishBack> list = noCreditPunishBackMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 保存反馈
	 * @param noCreditPunishBack
	 * @return
	 */
	private int insert(NoCreditPunishBack noCreditPunishBack) {
		return this.noCreditPunishBackMapper.insert(noCreditPunishBack);
	}
	
	/**
	 * 新增反馈条目
	 * @param depts
	 * @param deptCodes
	 * @param batchNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertBackDetail(String depts, String deptCodes, String batchNo, String feedBack) throws Exception {
		String[] codeArr = deptCodes.split(",");
		String[] deptArr = depts.split(",");
		int k = 0;
		for (int i = 0; i<codeArr.length; i++) {
			NoCreditPunishBackDto noCreditPunishBackDto = new NoCreditPunishBackDto();
			noCreditPunishBackDto.setBatchNo(batchNo);
			noCreditPunishBackDto.setBackDept(deptArr[i]);
			noCreditPunishBackDto.setBackDeptCode(codeArr[i]);
			noCreditPunishBackDto.setState(0);
			noCreditPunishBackDto.setFeedBack(feedBack);
			k = this.insert(noCreditPunishBackDto);
		}
		return k;
	}
	
	/**
	 * 根据多个条件删除
	 * @param parms
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Map<String, Object> parms) throws Exception {
		Example example = new Example(NoCreditPunishBack.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return this.noCreditPunishBackMapper.deleteByExample(example);
	}
	
	/**
	 * 更新反馈
	 * @param noCreditPunishBack
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(NoCreditPunishBack noCreditPunishBack) throws Exception {
		Example example = new Example(NoCreditPunishBack.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("batchNo", noCreditPunishBack.getBatchNo());
		SysUserDto sysUserDto = getCurrUser();
		if (sysUserDto.getUserType().equals("1")) {
			criteria.andLike("backDeptCode", noCreditPunishBack.getBackDeptCode() + "%");
		} else
			criteria.andEqualTo("backDeptCode", noCreditPunishBack.getBackDeptCode());
		noCreditPunishBack.setCreateTime(new Date());
		noCreditPunishBack.setState(1);
		return this.noCreditPunishBackMapper.updateByExampleSelective(noCreditPunishBack, example);
	}
	
	/**
	 * 更新反馈
	 * @param noCreditPunishBack
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean update(NoCreditPunishBackDto noCreditPunishBackDto) {
		try {
			SysUserDto sysUserDto = getCurrUser();
			if (sysUserDto.getUserType().equals("1")) {
				noCreditPunishBackDto.setUserType("1");
			}
			noCreditPunishBackDto.setCreateTime(new Date());
			noCreditPunishBackDto.setState(1);
			this.noCreditPunishBackMapper.updateBack(noCreditPunishBackDto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	
	/**
	 * 判断某个部门是否已反馈
	 * @param batchNo
	 * @param deptCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean deptBackExist(Map<String, Object> parms) throws Exception {
		List<NoCreditPunishBack> backs = this.noCreditPunishBackMapper.deptBackExist(parms);
		return backs.size() > 0 ? true : false;
	}

}
