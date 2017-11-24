package com.icinfo.cs.sment.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

public interface SmentBulletinsMapper extends Mapper<SmentBulletins> {
	/**
	 * 获取通知公告信息列表
	 * @param map
	 * @return
	 */
	public List<SmentBulletins> selectBulletinsList(Map<String,Object> param);
	/**
	 * 根据UID获取通知公告信息
	 * @param uid
	 * @return
	 */
	public SmentBulletins selectByUID(String uid);
}
