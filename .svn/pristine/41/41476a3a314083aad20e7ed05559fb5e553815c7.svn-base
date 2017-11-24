/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月19日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.model.pubScSpecialLibrary;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scspecial_library 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月19日
 */
public interface pubScSpecialLibraryMapper extends Mapper<pubScSpecialLibrary> {

	List<pubScSpecialLibrary> selectScSpecialLibraryInfo(Map<String, Object> params);
	
	/**
     * 描述: 获取专项检查对象主体库数据
     * @auther yujingwei
     * @date 2017年4月19日
     * @param request
     * @return List<pubScSpecialLibrary>
     * @throws Exception
     */
	List<pubScSpecialLibrary> selectScSpecialLibraryList(Map<String, Object> params);

	List<Map<String, Object>> selectScSpecialTreeMap(String isCheck);

	String selectSpLibraryByName(String specialName);

	String selectSpLibraryByCode(String specialCode);

	List<Map<String, Object>> selectMarkTreeMap();
	
	List<pubScSpecialLibraryDto> selectScSpecialInitTotal(Map<String, Object> paramInfoMap);
	
	/**
	 * 描述: 专项检查对象库统计（录入）
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
	List<pubScSpecialLibraryDto> selectScSpecialOptInitTotal(Map<String, Object> paramInfoMap);
	
	/**
	 * 描述: 按照登记机关统计专项检查对象主体库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibraryDto> selectScSpecialLibraryCountByRegOrg(Map<String, Object> params);
    
    /**
	 * 描述: 统计按照地区专项检查对象主体库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibraryDto> selectScSpecialLibraryCountByArea(Map<String, Object> params);
    
    /**
	 * 描述: 按照管辖单位统计专项检查对象主体库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibraryDto> selectScSpecialLibraryCountByLocaladm(Map<String, Object> params);
    
    /**
     * 描述: 查询需要导入待抽检库的专项库
     * @auther chenxin
     * @date 2017年5月19日
     * @param params
     * @return List<pubScSpecialLibrary>
     * @throws Exception
     */
    public List<pubScSpecialLibrary> selectScSpecialList(Map<String, Object> params);
    
    /**
     * 描述: 统计导入待抽检库的专项库数量
     * @auther chenxin
     * @date 2017年5月19日
     * @param params
     * @return int
     * @throws Exception
     */
    public int selectScSpecialCount(Map<String, Object> params);

    /**
     * 描述: 查询一家企业涉及的所有检查事项
	 * @auther chenxin
	 * @date 2017年4月19日
     * @param priPID
     * @return
     */
	public List<String> selectCheckCodeList(String priPID);

	/**
	 * 描述: 查询企业的所有专项库
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectPubScSpecialLibrary(Map<String, Object> params);

	/**
	 * 描述:统计
	 * @auther chenxin
	 * @date 2017年7月12日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectCountBySpecial(Map<String, Object> params);
	
	/**
	 * 描述:查询某个专项数据
	 * @auther chenxin
	 * @date 2017年7月12日
	 * @param params
	 * @throws Exception
	 */
	public pubScSpecialLibraryDto selectPubScSpeForRandom(Map<String, Object> params);

	/**
	 * 描述:查询
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectListBySpecial(Map<String, Object> params);

	/**
	 * 描述:查询列表企业
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectPubScSpeListForRandom(Map<String, Object> params)throws Exception;
}