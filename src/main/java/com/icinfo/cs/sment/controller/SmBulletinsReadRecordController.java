package com.icinfo.cs.sment.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sment.service.ISmBulletinsReadRecordService;
import com.icinfo.cs.sment.service.ISmentBulletinsService;
import com.icinfo.cs.sment.dto.BulletinsReadRecordDto;
import com.icinfo.cs.sment.model.SmentBulletins;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    sm_bulletins_read_record 对应的Controller类.<br>
 *
 * @author 
 * @date 2017年05月04日
 */
@Controller
@RequestMapping("/sment/bulletinsRecord")
public class SmBulletinsReadRecordController extends BaseController {
	@Autowired
	private ISmBulletinsReadRecordService ismBulletinsReadRecordService;
	@Autowired
	private ISmentBulletinsService isBulletinsService;
	/**
     * 获取通知公告数据
     * @author Czj
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public AjaxResult doReadBulletins(PageRequest request)throws Exception{
        HttpSession session=getSession();
        SysUserDto sysUser= (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        List<BulletinsReadRecordDto> bulletinses=ismBulletinsReadRecordService.doSelectBulletinBySysUser(sysUser);
        return  AjaxResult.success("bulletinsReadRecord",bulletinses);
    }
    /**
     * 读取通知公告详细
     * @author Czj
     * @return
     * @throws SQLException 
     * @throws Exception
     */
    @RequestMapping("/read")
    public ModelAndView read(String bulletinId) throws SQLException{
    	if(StringUtils.isNotBlank(bulletinId)){
    		SysUserDto sysUserDto= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
            int result=ismBulletinsReadRecordService.doRead(bulletinId,sysUserDto);
    	}
    	ModelAndView mv =new ModelAndView("sment/bulletins/bulletins_view");
    	SmentBulletins smentBulletins=isBulletinsService.selectByUID(bulletinId);
    	if(smentBulletins == null ||"0".equals(smentBulletins.getIsValid())){
    		mv.addObject("error","该通知公告已失效");
    		return mv;
    	}
    	if(smentBulletins != null && StringUtil.isNotEmpty(smentBulletins.getUID())){//更新阅读量
    		smentBulletins.setReadCount(smentBulletins.getReadCount()+1);  //阅读量加1
			isBulletinsService.updateBulletins(smentBulletins);
		}
    	mv.addObject("SmentBulletins", smentBulletins);
		return mv;
    	
    }
    /**
     * 阅读当前通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param bulletinId 通知公告ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/scan")
    public ModelAndView  scan(String bulletinId) throws Exception {
    	ModelAndView mv =new ModelAndView("sment/bulletins/bulletins_view");
    	SmentBulletins smentBulletins=isBulletinsService.selectByUID(bulletinId);
    	String valid=smentBulletins.getIsValid();
    	if(smentBulletins == null ||"0".equals(smentBulletins.getIsValid())){
    		mv.addObject("error","该通知公告已失效");
    		return mv;
    	}
    	if(smentBulletins != null && StringUtil.isNotEmpty(smentBulletins.getUID())){//更新阅读量
    		smentBulletins.setReadCount(smentBulletins.getReadCount()+1);  //阅读量加1
			isBulletinsService.updateBulletins(smentBulletins);
		}
    	mv.addObject("SmentBulletins", smentBulletins);
		return mv;
    }
}
