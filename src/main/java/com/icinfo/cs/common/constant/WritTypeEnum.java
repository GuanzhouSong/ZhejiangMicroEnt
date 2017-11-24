package com.icinfo.cs.common.constant;

/**
 * 描述：文书枚举
 *
 * @author: wangjin
 * @date：2017-06-22
 */
public enum WritTypeEnum {


    //******枚举 start*****

    WRIT_TYPE_XinZheng("1","行政指导书"),
    WRIT_TYPE_ZheLing("2","责令整改书"),
    WRIT_TYPE_ChouCha("3","抽查检查通知书"),
    WRIT_TYPE_LieRuYiChang("4","列入经营异常名录决定书"),
    WRIT_TYPE_YiChuYiCha("5","移出经营异常名录决定书"),
    WRIT_TYPE_CheXiaoYiChang("6","撤销列入经营异常名录决定书");

    //******枚举 end ******


    private String type;//编码
    private String desc;//描述


    private WritTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static String getValue(String type) {
        for (WritTypeEnum writTypeEnum : WritTypeEnum.values()) {
            if (writTypeEnum.getType().equals(type)) {
                return writTypeEnum.getDesc();
            }
        }
        return null;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
