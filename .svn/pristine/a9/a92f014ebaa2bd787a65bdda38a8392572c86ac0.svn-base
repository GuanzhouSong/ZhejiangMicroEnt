package com.icinfo.cs.upload.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.depsyn.constant.CsDepsynPunishStatus;
import com.icinfo.cs.depsyn.constant.DepSynConstant;
import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.depsyn.model.CsDepsynPunish;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.service.ICsDepsynPunishUploadService;
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
public class CsDepsynPunishUploadServiceImpl implements ICsDepsynPunishUploadService {

    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    /**
     * 处理行政处罚 excel
     *
     * @param in 输入流
     * @return 处理结果, 若为 null, 则非空字段为空
     */
    @Override
    public CsDepsynPunishDto processDepsynExcel(InputStream in, SysUserDto sysUserDto) throws Exception {
        CsDepsynPunishDto csDepsynPunishDto = new CsDepsynPunishDto();
        List<CsDepsynPunish> list = new ArrayList<>();
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
            CsDepsynPunish csDepsynPunish = createCsDepsynPunish(row, sysUserDto);
            csDepsynPunish.setId(i-1);

            //
            if (StringUtil.isBlank(csDepsynPunish.getPenAuth()) || StringUtil.isBlank(csDepsynPunish.getEntName())) {
                return null;
            }

            if (StringUtil.isBlank(csDepsynPunish.getRegNO()) && StringUtil.isBlank(csDepsynPunish.getUniScid())) {
                return null;
            }

            // 根据企业名称进行校验
            MidBaseInfo midBaseInfo = (selectByEntName(csDepsynPunish.getEntName()).size() == 0)
                    ? null : selectByEntName(csDepsynPunish.getEntName()).get(0);
            if (midBaseInfo == null) {
                csDepsynPunish.setCheckState(CsDepsynPunishStatus.CHECKSTATE_NO.getValue());
                list.add(csDepsynPunish);
                invalidNun++;
                continue;
            } else {
                csDepsynPunish.setCheckState(CsDepsynPunishStatus.CHECKSTATE_YES.getValue());
            }

            // 校验社会统一信用代码
            csDepsynPunish.setUniScidState(csDepsynPunish.getUniScid().equals(midBaseInfo.getUniCode())
                    ? CsDepsynPunishStatus.UNISCIDSTATE_YES.getValue() : CsDepsynPunishStatus.UNISCIDSTATE_NO.getValue());

            // 校验注册号
            csDepsynPunish.setRegNOState(csDepsynPunish.getRegNO().equals(midBaseInfo.getRegNO())
                    ? CsDepsynPunishStatus.REGNOSTATE_YES.getValue() : CsDepsynPunishStatus.REGNOSTATE_NO.getValue());

            // 校验处罚决定书签发日期
            csDepsynPunish.setCerIssDateState(checkCerIssDate(csDepsynPunish.getCerIssDate())
                    ? CsDepsynPunishStatus.CERISSDATESTATE_YES.getValue() : CsDepsynPunishStatus.CERISSDATESTATE_NO.getValue());

            csDepsynPunish.setCheckState("1");
            // 社会统一信用代码, 注册号, 处罚决定书签日志 任意一个不满足, 无效数据增加 1.
            if(CsDepsynPunishStatus.UNISCIDSTATE_NO.getValue().equals(csDepsynPunish.getUniScidState())
                    || CsDepsynPunishStatus.REGNOSTATE_NO.getValue().equals(csDepsynPunish.getRegNOState())
                    || CsDepsynPunishStatus.CERISSDATESTATE_NO.getValue().equals(csDepsynPunish.getCerIssDateState())) {
            	csDepsynPunish.setCheckState("0");
                invalidNun++;
            }
            list.add(csDepsynPunish);
        }

        if(list.size() == 0) {
            return null;
        }
        csDepsynPunishDto.setCsDepsynPunishList(list);
        csDepsynPunishDto.setInvalidNun(invalidNun);

        return csDepsynPunishDto;
    }

    /**
     * 基于excel行数据生成行政处罚对象
     *
     * @param row excel行
     * @return 行政处罚对象
     */
    private CsDepsynPunish createCsDepsynPunish(Row row, SysUserDto sysUserDto) {
        CsDepsynPunishDto csDepsynPunish = new CsDepsynPunishDto();
        csDepsynPunish.setPenDecNo(ExcelUtil.getCellContent(row.getCell(1)));
        csDepsynPunish.setCerIssDate(ExcelUtil.getCellContent(row.getCell(2)));
        csDepsynPunish.setIllegActType(ExcelUtil.getCellContent(row.getCell(3)));
        csDepsynPunish.setPenType(ExcelUtil.getCellContent(row.getCell(4)));
        csDepsynPunish.setPenAuth(ExcelUtil.getCellContent(row.getCell(5)));
        csDepsynPunish.setEntName(ExcelUtil.getCellContent(row.getCell(6)));
        csDepsynPunish.setRegNO(ExcelUtil.getCellContent(row.getCell(7)));
        csDepsynPunish.setUniScid(ExcelUtil.getCellContent(row.getCell(8)));
        csDepsynPunish.setInputPerID(sysUserDto.getId());
        csDepsynPunish.setInputDepCode(sysUserDto.getDepSynName());
        csDepsynPunish.setInputDate(new Date());

        Calendar c = Calendar.getInstance();
        c.setTime(csDepsynPunish.getInputDate());
        csDepsynPunish.setYear(String.valueOf(c.get(Calendar.YEAR)));

        csDepsynPunish.setAdcode(sysUserDto.getSysDepart().getAdcode());

        csDepsynPunish.setProType(DepSynConstant.PRO_TYPE_PLLU);
        csDepsynPunish.setResubTime(csDepsynPunish.getInputDate());

        return csDepsynPunish;
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
