package com.icinfo.cs.upload.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.cs.depsyn.model.CsDepsynPunish;
import com.icinfo.cs.depsyn.service.ICsDepsynLicenseService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.service.ICsDepsynLicenseUploadService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

/**
 * 行政处罚 excel 导入控制器
 *
 * Created by wangxiao on 2016/12/12.
 */
@Controller
@RequestMapping("/depsyn/excel/license")
public class LicenseExcelUploadController extends BaseController {

    /**
     * excel上传服务
     */
    @Autowired
    private ICsDepsynLicenseUploadService csDepsynLicenseUploadService;

    /**
     * 行政许可服务
     */
    @Autowired
    private ICsDepsynLicenseService csDepsynLicenseService;

    /**
     * 跳转至上传行政处罚页面
     * @return
     */
    @RequestMapping(value = "/toupload", method = RequestMethod.GET)
    public String toUploda() {
        return "/depsyn/upload/license_upload";
    }

    /**
     * 上传行政处罚 excel
     *
     * @param file 上传文件
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadDepsynPunishExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

        InputStream in = file.getInputStream();
        CsDepsynLicenseDto csDepsynLicenseDto = csDepsynLicenseUploadService.processDepsynExcel(in, sysUser);
        JSONObject json = new JSONObject();
        if (csDepsynLicenseDto == null) {
            json.put("status", "error");
        } else {
            json.put("status", "success");
            session.setAttribute("invalid", csDepsynLicenseDto.getInvalidNun());
            session.setAttribute("punishList", csDepsynLicenseDto.getCsDepsynLicenseList());
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }

    /**
     * 批量添加
     *
     * @return 页面
     */
    @RequestMapping(value = "/toaddbatch", method = RequestMethod.GET)
    public String toAddBatch() {
        return "/depsyn/upload/license_addbatch";
    }

    /**
     * 分页获取新增的行政处罚列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页条数
     * @param session  HttpSession
     * @return 查询结果
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public PageResponse<CsDepsynPunish> getCsDepsynPunishList(int pageNum, int pageSize, HttpSession session) throws Exception {
        Object objList = session.getAttribute("punishList");
        if(objList != null) {
            List<CsDepsynPunish> list = (List<CsDepsynPunish>) objList;
            Page<CsDepsynPunish> pageList = new Page<>(pageNum, pageSize);
            pageList.setTotal(list.size());
            Long toIndex = pageNum * pageSize > pageList.getTotal() ? pageList.getTotal() : pageNum * pageSize;
            pageList.addAll(list.subList((pageNum - 1) * pageSize, toIndex.intValue()));

            PageResponse<CsDepsynPunish> csDepsynPunishPageResponse = new PageResponse<>(pageList);
            return csDepsynPunishPageResponse;
        }
        return null;
    }

    /**
     * 批量保存数据
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addbatch", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult addDepsynPunishBatch(HttpSession session) throws Exception {
        Object obj = session.getAttribute("punishList");
        if (obj != null) {
            List<CsDepsynLicense> licenseList = (List<CsDepsynLicense>) obj;
            csDepsynLicenseService.addLicenseBatch(licenseList);
            session.removeAttribute("licenseList");
            return AjaxResult.success("处理成功");
        }

        return AjaxResult.error("处理失败");
    }
}
