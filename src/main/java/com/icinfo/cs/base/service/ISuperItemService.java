/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.SuperItem;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;

/**
 * 描述:  cs_super_item 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
public interface ISuperItemService extends BaseService {
    List<SuperItem> selectSuperItemsByType(String superType);
}