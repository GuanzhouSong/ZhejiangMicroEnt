package com.icinfo.cs.depsyn.constant;

/**
 * Created by wangxiao on 2016/12/10.
 */
public enum CsDepsynLicenseStatus {
    CERISSDATESTATE_NO("0", "时间格式不匹配"),
    CERISSDATESTATE_YES("1", "时间格式匹配"),
    REGNOSTATE_NO("0", "注册码不匹配"),
    REGNOSTATE_YES("1", "注册码匹配"),
    UNISCIDSTATE_NO("0", "统一社会信用代码不匹配"),
    UNISCIDSTATE_YES("1", "统一社会信用代码匹配"),
    CHECKSTATE_NO("0", "数据校验不匹配"),
    CHECKSTATE_YES("1", "数据校验匹配");

    private String value;
    private String desc;

    CsDepsynLicenseStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
