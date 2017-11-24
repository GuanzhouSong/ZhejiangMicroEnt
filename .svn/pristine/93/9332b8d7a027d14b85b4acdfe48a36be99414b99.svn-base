package com.icinfo.cs.upload.service;

import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.system.dto.SysUserDto;

import java.io.InputStream;

/**
 * 行政处罚excel上传服务接口
 *
 * Created by wangxiao on 2016/12/10.
 */
public interface ICsDepsynPunishUploadService {

    /**
     * 处理行政处罚 excel
     *
     * @param in 输入流
     * @return 处理结果, 若为 null, 则非空字段为空
     */
    CsDepsynPunishDto processDepsynExcel(InputStream in, SysUserDto sysUserDto) throws Exception;
}
