package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.cs.yr.service.ISfcFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 描述:    农专辅助报表的跳转控制层  对应的Controller类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/sfcwritehome")
public class YrSfcWriteHomeController {

    //农专报表状态
    @Autowired
    private ISfcFormService sfcFormService;

    @RequestMapping("/home")
    public String list(String year, RedirectAttributes attr, HttpSession session) throws Exception{

        String encodeYear = year;          //接收加密年份
        year = AESEUtil.decodeYear(year);  //年份解密

        //获取session的企业基本信息
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        String pripid = midBaseInfoDto.getPriPID();

        //获取农专表单填写的状态,如果为null 新增当前年份和身份主体代码
        SfcForm sfcForm= sfcFormService.selectSfcFormByPripidAndYear(pripid, Integer.valueOf(year));
        if(sfcForm == null) {
            sfcFormService.insert(pripid, Integer.valueOf(year));//初始化
        }

        attr.addAttribute("year",encodeYear);
        String url = "redirect:/reg/client/yr/sfc/cominfo/show";
        return url;
    }


}
