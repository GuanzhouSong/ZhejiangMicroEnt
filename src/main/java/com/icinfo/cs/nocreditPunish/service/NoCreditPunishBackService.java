package com.icinfo.cs.nocreditPunish.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishBackDto;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishBack;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishback 对应的Service接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishBackService extends BaseService {

	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	public List<NoCreditPunishBack> queryPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	public List<NoCreditPunishBack> queryList(Map<String, Object> parms) throws Exception;

	/**
	 * 获取当前用户
	 * @return
	 */
	public SysUserDto getCurrUser() throws Exception;

	/**
	 * 判断某个部门是否已反馈
	 * @param batchNo
	 * @param deptCode
	 * @return
	 * @throws Exception
	 */
	public Boolean deptBackExist(Map<String, Object> parms) throws Exception;

	/**
	 * 新增反馈条目
	 * @param depts
	 * @param deptCodes
	 * @param batchNo
	 * @return
	 * @throws Exception
	 */
	public int insertBackDetail(String depts, String deptCodes, String batchNo, String feedBack) throws Exception;

	/**
	 * 根据多个条件删除
	 * @param batchNo
	 * @return
	 */
	public int delete(Map<String, Object> parms) throws Exception;

	/**
	 * 更新反馈
	 * @param noCreditPunishBack
	 * @return
	 */
	public int update(NoCreditPunishBack noCreditPunishBack) throws Exception;

	/**
	 * 更新反馈
	 * @param noCreditPunishBack
	 * @return
	 */
	public boolean update(NoCreditPunishBackDto noCreditPunishBackDto);

}
