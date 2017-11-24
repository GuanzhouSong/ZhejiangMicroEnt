/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubSctaskDto;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_sctask 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface PubSctaskMapper extends Mapper<PubSctask> {
    /**
     * 
     * 描述: 保存信息
     * @auther ljx
     * @date 2016年10月25日 
     * @param pubSctask
     * @return
     */
	int insert(PubSctask pubSctask);
  /**
   * 	
   * 描述: 查询for json 多条件
   * @auther ljx
   * @date 2016年10月25日 
   * @param map
   * @return
   */
  List<PubSctaskDto> selectByManyCationToListJson(Map<String,Object>map);
  /**
   *  
   * 描述:多条件查询本部门组织的任务
   * @auther ljx
   * @date 2016年11月11日 
   * @param map
   * @return
   */
  List<PubSctaskDto> selectLeadStacktoListJson(Map<String,Object>map);
  /**
   * 
   * 描述: 多条件查询本部门实施任务
   * @auther ljx
   * @date 2016年11月11日 
   * @param map
   * @return
   */
  List<PubSctaskDto> selectDeptStacktoListJson(Map<String,Object>map);
  
  
  
  /**
   * 
   * 描述:查询最大id
   * @auther ljx
   * @date 2016年10月26日 
   * @return
   */
  int selectMaxId();
  /**
   * 
   * 描述: 条件统计
   * @auther ljx
   * @date 2016年10月27日 
   * @param map
   * @return
   */
  int selectCountByCation(Map<String,Object> map);
 
  /**
   * 描述: 查询任务信息（有审核信息）
 * @param updateDate 
   * @auther yujingwei
   * @date 2016年10月27日 
   * @return List<PubSctask>
   */
   List<PubSctask> selectScTaskListForBulletin(String updateDate);
  

}