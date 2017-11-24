/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.pub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_justiceinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller("PubJusticeInfo")
@RequestMapping("/pub/pubjusticeinfo")
public class PubJusticeInfoController extends BaseController {
	
	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;
	
	/** 
	 * 描述: 获取司法协助信息录入列表数据
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<PubJusticeInfo> listJSON(PageRequest request) throws Exception {
		List<PubJusticeInfo> data = pubJusticeInfoService.queryPageForPub(request);
        return new PageResponse<PubJusticeInfo>(data);
    }
	
	/** 
	 * 描述: 司法协助信息录入详情
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param pripid
	 * @param UID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public ModelAndView doEnDetail(String uid) throws Exception{
		ModelAndView view = new ModelAndView("pub/infopublic/infodetail/justicedetail");
		if(StringUtil.isNotBlank(uid)){
			//查询冻结、解冻、续冻或失效信息
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfoForPub(uid);
			//a.有解冻、续冻或失效信息时
			if(pubJusticeInfo != null && StringUtil.isNotBlank(pubJusticeInfo.getJusticeConNO())) {
				PubJusticeInfo pubJusticeConInfo = pubJusticeInfoService.doGetPubJusticeInfoForPub(pubJusticeInfo.getJusticeConNO());
				//关联冻结信息
				view.addObject("pubJusticeInfo", pubJusticeConInfo);
				//解冻、续冻或失效信息
				view.addObject("pubJusticeConInfo", pubJusticeInfo);
			}else{
				//b.股权冻结、股东变更
				view.addObject("pubJusticeInfo", pubJusticeInfo);
			}
		}
		return view;
	}
	
}