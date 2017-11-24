/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.system.dto.BulletinsReadRecordDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IBulletinsReadRecordService;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.cs.yr.service.IBulletinsService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * 描述:    cs_bulletins_read_record 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Controller
@RequestMapping({"/syn/system/bulletin","/reg/system/bulletin"})
public class BulletinsReadRecordController extends BaseController {

    @Autowired
    private IBulletinsReadRecordService bulletinsReadRecordService;

    @Autowired
    private IBulletinsService bulletinsService;


    /**
     * 进入通知公告列表页面（管理端首页）
     * @author ZhuDefeng
     * @date 2016-11-28
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public ModelAndView list() throws Exception {
        ModelAndView mav = new ModelAndView( "system/bulletin/bulletin_list");
        return mav;
    }


    /**
     * 获取通知公告数据
     * @author ZhuDefeng
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public AjaxResult doReadBulletins(PageRequest request)throws Exception{
        HttpSession session=getSession();
        SysUserDto sysUser= (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        List<BulletinsReadRecordDto> bulletinses=bulletinsReadRecordService.doSelectBulletinBySysUser(sysUser);
//		for(BulletinsReadRecordDto bulletinsReadRecordDto : bulletinses ){
//            if(StringUtil.isNotEmpty(bulletinsReadRecordDto.getReaderUserId()) && StringUtil.isNotEmpty(bulletinsReadRecordDto.getReader()) && !(bulletinsReadRecordDto.getReader().equals(sysUser.getUsername())) && !(bulletinsReadRecordDto.getReaderUserId().equals(sysUser.getId()))){
//            	bulletinsReadRecordDto.setIsRead("0");
//            	bulletinsReadRecordDto.setIsCollection("0");
//            }
//			
//		}
        return  AjaxResult.success("bulletins",bulletinses);
    }


    /**
     * 阅读当前通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param bulletinId 通知公告ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/read")
    public ModelAndView  read(String bulletinId) throws Exception {
    	if (StringUtils.isNotBlank(bulletinId)) {
            SysUserDto sysUserDto= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
            int result=bulletinsReadRecordService.doRead(bulletinId,sysUserDto);
        }
        Bulletins bulletins=bulletinsService.selectByUID(bulletinId);
		ModelAndView mav = new ModelAndView("/system/bulletin/bulletin_view");
        mav.addObject("Bulletins", bulletins);
        return mav;
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
        Bulletins bulletins=bulletinsService.selectByUID(bulletinId);
		ModelAndView mav = new ModelAndView("/system/bulletin/bulletin_view");
		mav.addObject("Bulletins", bulletins);
        return mav;
    }

    /**
     * 收藏当前通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param bulletinId 通知公告ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/collection")
    @ResponseBody
    public AjaxResult collection(String bulletinId) throws Exception {
        if (StringUtils.isNotBlank(bulletinId)) {
            SysUserDto sysUserDto= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
            int result=bulletinsReadRecordService.doCollection(bulletinId,sysUserDto);
            if(result>0) return AjaxResult.success("已收藏!");
            else return AjaxResult.error("收藏失败！");
        }
        return AjaxResult.error("收藏失败！");
    }

    /**
     * 进入通知公告查看页面
     * @author ZhuDefeng
     * @date 2016-11-28
     * @return
     * @throws Exception
     */
    @RequestMapping("/viewBulletin")
    public ModelAndView view(String bulletinId) throws Exception {
        ModelAndView mav = new ModelAndView( "bulletin/viewBulletin");
        Bulletins bulletin=null;
        mav.addObject("bulletin",bulletin);
        return mav;
    }
    
    /**
     * 
     * 描述: 查看更多公告页面
     * @auther gaojinling
     * @date 2017年1月9日 
     * @return
     * @throws Exception
     */
    @RequestMapping("/listmore")
    public ModelAndView listMore() throws Exception {
        ModelAndView mav = new ModelAndView( "system/bulletin/bulletin_listmore");
        return mav;
    }
    
    /**
     * 
     * 描述: 查看更多公告页面
     * @auther gaojinling
     * @date 2017年1月9日 
     * @return
     * @throws Exception
     */
    @RequestMapping("/reglistmore")
    public ModelAndView reglistMore() throws Exception {
        ModelAndView mav = new ModelAndView( "system/bulletin/bulletin_reglistmore");
        return mav;
    }
    

}