/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月09日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.ForinvestMentDto;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_forinvestment 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface ForinvestMentMapper extends Mapper<ForinvestMent> {
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return 
	 */
	int insertByAnCheID(@Param(Constants.CS_ANCHEID)String anCheID);
	
    /**
     * 
     * 描述: 公示侧对外投资信息查询（过滤敏感词）
     * @auther chenyl
     * @date 2016年10月10日 
     * @param searchMap
     * @return
     */
	List<ForinvestMentDto> selectForinvestMentForPub(Map<String, Object> searchMap);
}