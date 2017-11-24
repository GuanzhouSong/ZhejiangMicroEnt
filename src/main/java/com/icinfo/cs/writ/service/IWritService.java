/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service;

import com.icinfo.cs.writ.dto.WritCountDto;
import com.icinfo.cs.writ.dto.WritDto;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_writ 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
public interface IWritService extends BaseService {

    /**
     * 描述：获取企业文书列表
     * @author:wangjin
     * @param request
     * @return
     */
    List<WritDto> select_queryPage(PageRequest request);

    /**
     * 描述：更新回执时间
     * @author:wangjin
     * @param writUuid
     */
    void UpdateReceiveTimeByWritUuid(String writUuid,String receivePeople);

    /**
     * 描述：查阅状态更新
     * @author:wangjin
     * @param uuid
     */
    int UpdateLookStatue(String uuid);

    /**
     * 描述：根据条件查询获取结果集
     * @author:wangjin
     * @param request
     * @return
     */
    List<WritDto> search_result(PageRequest request);

    /**
     * 描述:根据查询条件统计数据
     * @author:wangjin
     * @param request
     * @return
     */
    WritCountDto search_countResult(PageRequest request);

    /**
     * 描述：根据pripid 查询当前企业的文书
     * @author：wangjin
     * @param priPID
     * @return
     */
    List<Writ> selectByPripidList(String priPID);

    /**
     * 描述：获取当前对象值
     * @author: wangjin
     * @param uuid
     * @return
     */
    Writ selectByUUID(String uuid);

    /**
     * 描述：添加文书内容  map 参数
     * @author: wangjin
     * @param map
     * TODO  文书类型的设置使用枚举中的方法：如（WritTypeEnum.WRIT_TYPE_XingZheng.getType()//行政指导书类型）
     *
     */
    void addWritByMap(Map<String, Object> map);

    /**
     * 描述：添加文书内容 对象参数
     * @author: wangjin
     * @param writ
     * TODO  文书类型的设置使用枚举中的方法：如（WritTypeEnum.WRIT_TYPE_XingZheng.getType()//行政指导书类型）
     */
    void addWrit(Writ writ);

    /**
     * @描述: 判断 文书的类型显示
     * @author：wangjin
     * @date:  2017-06-29
     * @param view
     * @param uuid
     * @return
     */
    ModelAndView getChooseWritData(ModelAndView view, String uuid) throws Exception;
}