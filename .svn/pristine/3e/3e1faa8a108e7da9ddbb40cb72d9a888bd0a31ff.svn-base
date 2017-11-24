package com.icinfo.cs.upload.service;

import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.system.dto.SysUserDto;

import java.io.InputStream;

/**
 * Created by wangxiao on 2016/12/12.
 */
public interface ICsDepsynLicenseUploadService {

    /**
     * 处理行政处罚 excel
     *
     * @param in 输入流
     * @return 处理结果, 若为 null, 则非空字段为空
     */
    CsDepsynLicenseDto processDepsynExcel(InputStream in, SysUserDto sysUserDto) throws Exception;
}
