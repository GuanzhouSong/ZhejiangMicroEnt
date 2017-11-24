/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年01月18日
 * @version 2.0
 */
package com.icinfo.cs.inspect.mapper;

import com.icinfo.cs.inspect.model.ReportCheckCode;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_report_check_code 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
public interface ReportCheckCodeMapper extends Mapper<ReportCheckCode> {
    List<ReportCheckCode> getCommonKeyCodeList(Map param);
}