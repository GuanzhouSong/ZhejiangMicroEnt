/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.pub.client;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 个体户异常.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Controller("ClientPubPbopanomalyController")
@RequestMapping("/pub/client/pubpbopanomaly")
public class PubPbopanomalyController extends BaseController {

	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;

	@Autowired
	IPubPbOpadetailService pubPbOpadetailService;

	/**
	 * 描述: 纳入/移出经营异常名录信息（公示单个个体户展示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list/list.json", method = RequestMethod.POST)
	@ResponseBody
	public PageResponse<PubPbopanomalyDto> listJSON(PageRequest request) throws Exception {
		// 查询标记异常并通过审核的企业
		List<PubPbopanomalyDto> pubPbopanomalyDtos = pubPbopanomalyService.selectPubPbopanomalyListForPub(request);
		Page<PubPbopanomalyDto> data = new Page<PubPbopanomalyDto>(request.getPageNum(), request.getLength());
		int num = 0;
		for (PubPbopanomalyDto pubPbopanomalyDto : pubPbopanomalyDtos) {
			// 查询每条记录异常恢复信息
			PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService
					.selectPubPbOpadetailDtoByBusExcList(pubPbopanomalyDto.getBusExcList());
			PubPbopanomalyDto ppd = new PubPbopanomalyDto();
			if (pubPbOpadetailDto != null) {
				if ("3".equals(pubPbOpadetailDto.getAuditState())) {// 更正恢复（撤销）,公示异常不显示
					continue;
				}
				BeanUtils.copyProperties(pubPbopanomalyDto, ppd);
				if ("1".equals(pubPbOpadetailDto.getAuditState())) {// 异常恢复审核成功
					ppd.setNorReaCN(pubPbOpadetailDto.getNorReaCN());
					ppd.setNorDate(pubPbOpadetailDto.getNorDate());
					ppd.setNorDecOrgCN(pubPbOpadetailDto.getNorDecOrgCN());
				}
				num++;
				data.add(ppd);
			} else {
				BeanUtils.copyProperties(pubPbopanomalyDto, ppd);
				data.add(ppd);
				num++;
			}
		}
		data.setTotal(num);
		return new PageResponse<PubPbopanomalyDto>(data);
	}
}