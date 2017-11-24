package com.icinfo.cs.nocreditPunish.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import net.sf.json.JSONArray;

/**
 * cs_nocredit_punishinfo 对应的Service接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishInfoService extends BaseService {

	/**
     * 保存惩戒单
     * @param rule
     * @return
     * @throws Exception
     */
	public int insert(NoCreditPunishInfo noCreditPunishInfo) throws Exception;

	/**
	 * 根据企业名称获取信息
	 * @param entName
	 * @return
	 */
	public NoCreditPunishDetail selectEnt(String entName) throws Exception;

	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	public List<NoCreditPunishInfo> queryPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	public List<NoCreditPunishInfo> queryList(Map<String, Object> parms) throws Exception;

	/**
	 * 获取需要反馈的戒单列表（企业、自然人）
	 * @return
	 */
	public List<NoCreditPunishInfoDto> selectAuditedInfoPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 获取所有的戒单列表（企业、自然人）
	 * @return
	 */
	public List<NoCreditPunishInfoDto> selectAllInfoList(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 获取当前用户
	 * @return
	 */
	public SysUserDto getCurrUser() throws Exception;

	/**
	 * 查询单个单据
	 * @param parms
	 * @return
	 */
	public NoCreditPunishInfo getInfo(String batchNo) throws Exception;

	/**
	 * 更新惩戒单主信息
	 * @param noCreditPunishInfo
	 * @return
	 */
	public int update(NoCreditPunishInfo noCreditPunishInfo) throws Exception;

	/**
	 * 根据企业id获取信息
	 * @param entName
	 * @return
	 */
	public List<NoCreditPunishInfo> selectInfoListByPriPID(PageRequest request);
	
	/**
	 * 根据个人cerNO获取信息
	 * @param entName
	 * @return
	 */
	public List<NoCreditPunishInfo> selectInfoListByCerNO(PageRequest request);

	/**
	 * 根据证件号获取自然人信息
	 * @param keyword
	 * @return
	 */
	public NoCreditPunishDetail selectMan(String keyword) throws Exception;

	/**
	 * 保存惩戒单明细
	 * @param array
	 * @param noCreditPunishInfoDto
	 */
	public void insertDetail(JSONArray array, NoCreditPunishInfoDto noCreditPunishInfoDto);

	/**
	 * 查询惩戒全信息列表
	 * @return
	 */
	public List<NoCreditPunishInfoDto> selectAllFullInfoList(PageRequest request, Map<String, Object> parms) throws Exception;
	
	/**
	 * 查询惩戒全信息列表统计
	 * @return
	 */
	public Integer getAllFullInfoTotal(Map<String, Object> qryMap) throws Exception;

    String searchlistJSON_downednum(Map<String, Object> request);
    
    /** 
     * 描述:根据自然人身份号获取列表数据
     * @author 张文男
     * @date 2017年3月17日 
     * @param request
     * @return 
     */
    
    public List<NoCreditPunishDetail>  selectNoCreditPunishDetailListByCerNO(PageRequest request);



    /**
     * 
     * 描述   获取列表
     * @author 赵祥江
     * @date 2017年8月27日 下午12:18:26 
     * @param 
     * @return List<NoCreditPunishInfoDto>
     * @throws
     */
    public List<NoCreditPunishInfoDto> selectAllInfoJsonList(PageRequest request, Map<String, Object> parms) throws Exception;

    /**
     * 
     * 描述   删除
     * @author 赵祥江
     * @date 2017年8月27日 下午2:15:43 
     * @param 
     * @return int
     * @throws
     */
    public int deleteNoCreditPunishInfoByBatchNo(String batchNo) throws Exception;

    /** 
     * 描述:获取失信联合惩戒信息
     * @author yujingwei
     * @date 2017年08月25日 
     * @param parms
     * @return List<NoCreditPunishInfoDto>
     */
	public List<NoCreditPunishInfoDto> selectNoCreditPunishinfo(Map<String, Object> parms);
}
