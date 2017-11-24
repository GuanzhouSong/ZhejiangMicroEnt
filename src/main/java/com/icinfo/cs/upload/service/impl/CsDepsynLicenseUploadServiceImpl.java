package com.icinfo.cs.upload.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.depsyn.constant.CsDepsynLicenseStatus;
import com.icinfo.cs.depsyn.constant.CsDepsynPunishStatus;
import com.icinfo.cs.depsyn.constant.DepSynConstant;
import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.service.ICsDepsynLicenseUploadService;
import com.icinfo.cs.upload.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;


/**
 * 行政处罚excel上传服务实现类
 *
 * Created by wangxiao on 2016/12/10.
 */
@Service
public class CsDepsynLicenseUploadServiceImpl implements ICsDepsynLicenseUploadService {

    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 处理行政处罚 excel
     *
     * @param in 输入流
     * @return 处理结果, 若为 null, 则非空字段为空
     */
    @Override
    public CsDepsynLicenseDto processDepsynExcel(InputStream in, SysUserDto sysUserDto) throws Exception {
        CsDepsynLicenseDto csDepsynLicenseDto = new CsDepsynLicenseDto();
        List<CsDepsynLicense> list = new ArrayList<>();
        Workbook workbook;
        try {
            // 上传文件格式校验
            workbook = WorkbookFactory.create(in);
        } catch (Exception e) {
            return null;
        }

        Sheet sheet = workbook.getSheetAt(0);

        // excel行数校验
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows < 3) {
            return null;
        }

        // 无效数据
        int invalidNun = 0;
        // 遍历处理每行
        for (int i = 2; i < rows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            // 生成行政处罚对象
            CsDepsynLicense csDepsynLicense = createCsDepsynLicense(row, sysUserDto);
            csDepsynLicense.setId(i-1);

            //
            if (StringUtil.isBlank(csDepsynLicense.getRegState()) || StringUtil.isBlank(csDepsynLicense.getEntName())) {
                return null;
            }

            if (StringUtil.isBlank(csDepsynLicense.getRegNO()) && StringUtil.isBlank(csDepsynLicense.getUniScid())) {
                return null;
            }

            // 根据企业名称进行校验
            MidBaseInfo midBaseInfo = (selectByEntName(csDepsynLicense.getEntName()).size() == 0)
                    ? null : selectByEntName(csDepsynLicense.getEntName()).get(0);
            if (midBaseInfo == null) {
                csDepsynLicense.setCheckState(CsDepsynLicenseStatus.CHECKSTATE_NO.getValue());
                list.add(csDepsynLicense);
                invalidNun++;
                continue;
            } else {
                csDepsynLicense.setCheckState(CsDepsynLicenseStatus.CHECKSTATE_YES.getValue());
            }

            // 校验社会统一信用代码
            csDepsynLicense.setUniScidState(csDepsynLicense.getUniScid().equals(midBaseInfo.getUniCode())
                    ? CsDepsynLicenseStatus.UNISCIDSTATE_YES.getValue() : CsDepsynLicenseStatus.UNISCIDSTATE_NO.getValue());

            // 校验注册号
            csDepsynLicense.setRegNOState(csDepsynLicense.getRegNO().equals(midBaseInfo.getRegNO())
                    ? CsDepsynLicenseStatus.REGNOSTATE_YES.getValue() : CsDepsynLicenseStatus.REGNOSTATE_NO.getValue());

            // 校验日期
//            csDepsynLicense.setCerIssDateState(checkCerIssDate(csDepsynLicense.getCerIssDate())
//                    ? CsDepsynLicenseStatus.CERISSDATESTATE_YES.getValue() : CsDepsynLicenseStatus.CERISSDATESTATE_NO.getValue());

            csDepsynLicense.setCheckState("1");
            // 社会统一信用代码, 注册号, 处罚决定书签日志 任意一个不满足, 无效数据增加 1.
            if(CsDepsynPunishStatus.UNISCIDSTATE_NO.getValue().equals(csDepsynLicense.getUniScidState())
                    || CsDepsynPunishStatus.REGNOSTATE_NO.getValue().equals(csDepsynLicense.getRegNOState())
                    /*|| CsDepsynPunishStatus.CERISSDATESTATE_NO.getValue().equals(csDepsynLicense.getCerIssDateState())*/) {
            	csDepsynLicense.setCheckState("0");
                invalidNun++;
            }
            list.add(csDepsynLicense);
        }

        if(list.size() == 0) {
            return null;
        }
        csDepsynLicenseDto.setCsDepsynLicenseList(list);
        csDepsynLicenseDto.setInvalidNun(invalidNun);

        return csDepsynLicenseDto;
    }

    /**
     * 基于excel行数据生成行政处罚对象
     *
     * @param row excel行
     * @return 行政处罚对象
     */
    private CsDepsynLicense createCsDepsynLicense(Row row, SysUserDto sysUserDto) {
        CsDepsynLicense csDepsynLicense = new CsDepsynLicense();
        csDepsynLicense.setLicNO(ExcelUtil.getCellContent(row.getCell(1)));
        csDepsynLicense.setLicName(ExcelUtil.getCellContent(row.getCell(2)));
        csDepsynLicense.setValFrom(ExcelUtil.getCellContent(row.getCell(3)));
        csDepsynLicense.setValTo(ExcelUtil.getCellContent(row.getCell(4)));
        csDepsynLicense.setLicAnth(ExcelUtil.getCellContent(row.getCell(5)));
        csDepsynLicense.setRegState(ExcelUtil.getCellContent(row.getCell(6)));
        csDepsynLicense.setEntName(ExcelUtil.getCellContent(row.getCell(7)));
        csDepsynLicense.setRegNO(ExcelUtil.getCellContent(row.getCell(8)));
        csDepsynLicense.setUniScid(ExcelUtil.getCellContent(row.getCell(9)));
        csDepsynLicense.setInputPerID(sysUserDto.getId());
        csDepsynLicense.setInputDepCode(sysUserDto.getDepSynName());
        csDepsynLicense.setInputDate(new Date());

        Calendar c = Calendar.getInstance();
        c.setTime(csDepsynLicense.getInputDate());
        csDepsynLicense.setYear(String.valueOf(c.get(Calendar.YEAR)));

        csDepsynLicense.setAdcode(sysUserDto.getSysDepart().getAdcode());

        csDepsynLicense.setProType(DepSynConstant.PRO_TYPE_PLLU);
        csDepsynLicense.setResubTime(csDepsynLicense.getInputDate());

        return csDepsynLicense;
    }

    /**
     * 根据企业名称查询
     *
     * @param entName 企业名称
     * @return 查询结果
     */
    private List<MidBaseInfo> selectByEntName(String entName) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("entname", entName);
        return midBaseInfoMapper.selectMidInfo(map);
    }

    /**
     * 检查处罚决定书签发日期格式
     *
     * @param cerIssDate 处罚决定书签发日期
     * @return 检查结果
     */
    private boolean checkCerIssDate(String cerIssDate) {
        if (StringUtil.isBlank(cerIssDate)) {
            return false;
        }
        return DateUtil.stringToDate(cerIssDate, "yyyy-MM-dd") == null ? false : true;
    }
}
