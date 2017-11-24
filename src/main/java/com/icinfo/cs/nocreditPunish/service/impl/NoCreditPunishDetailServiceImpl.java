package com.icinfo.cs.nocreditPunish.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishDetailService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * cs_nocredit_punishdetail 对应的Mapper接口实现类.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
@Service
public class NoCreditPunishDetailServiceImpl extends MyBatisServiceSupport implements NoCreditPunishDetailService {
	
	@Autowired
	private com.icinfo.cs.nocreditPunish.mapper.NoCreditPunishDetailMapper noCreditPunishDetailMapper;
	

	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public List<NoCreditPunishDetail> queryPage(PageRequest request, Map<String, Object> parms) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(NoCreditPunishDetail.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return noCreditPunishDetailMapper.selectByExample(example);
	}
	
	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	@Override
	public List<NoCreditPunishDetail> queryList(Map<String, Object> parms) throws Exception {
		Example example = new Example(NoCreditPunishDetail.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		List<NoCreditPunishDetail> list = noCreditPunishDetailMapper.selectByExample(example);
		return list;
	}
	
	/**
     * 保存惩戒明细
     * @param rule
     * @return
     * @throws Exception
     */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(NoCreditPunishDetail noCreditPunishDetail) throws Exception {
		return this.noCreditPunishDetailMapper.insert(noCreditPunishDetail);
	}
	
	/**
	 * 某家企业是否存在惩戒记录
	 * @param priPID
	 * @return
	 */
	@Override
	public Boolean detailEntExist(String priPID) throws Exception {
		List<NoCreditPunishDetail> details = this.noCreditPunishDetailMapper.detailEntExist(priPID);
		return details.size() > 0 ? true : false;
	}
	
	/**
	 * 某个自然人是否存在惩戒记录
	 * @param cardNo
	 * @return
	 */
	@Override
	public Boolean detailManExist(String cardNo) throws Exception {
		List<NoCreditPunishDetail> details = this.noCreditPunishDetailMapper.detailManExist(cardNo);
		return details.size() > 0 ? true : false;
	}
	
	/**
	 * 根据多个条件删除
	 * @param batchNo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Map<String, Object> parms) throws Exception {
		Example example = new Example(NoCreditPunishDetail.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return this.noCreditPunishDetailMapper.deleteByExample(example);
	}

	@Override
	public List<NoCreditPunishDetail> selectListByCerNO(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return noCreditPunishDetailMapper.selectListByCerNO(request.getParams());
	}

}
