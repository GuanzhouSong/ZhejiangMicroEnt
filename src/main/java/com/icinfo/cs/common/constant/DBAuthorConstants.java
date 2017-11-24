/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.common.constant;

/**
 * 描述:  .<br>
 *
 * @author xiajunwei
 * @date 2016年05月20日
 */
public final class DBAuthorConstants {


    /**
     *用户所属层级0：管理员
     */
    public final static String USER_LEVEL_ADMIN = "0";

    /**
     *用户所属层级3：省级
     */
    public final static String USER_LEVEL_PROV = "4";

    /**
     *用户所属层级2：市级
     */
    public final static String USER_LEVEL_CITY = "3";

    /**
     *用户所属层级1：分局
     */
    public final static String USER_LEVEL_COUNTRY = "2";

    /**
     *用户所属层级0：所、管辖单位
     */
    public final static String USER_LEVEL_UNIT = "1";


    //==用户查询范围==//

    /**
     *用户查询层级：本省
     */
    public final static String USER_SEARCH_RANGE_PROV = "4";


    /**
     *用户查询层级：本市
     */
    public final static String USER_SEARCH_RANGE_CITY = "3";


    /**
     *用户查询层级：本区
     */
    public final static String USER_SEARCH_RANGE_AREA = "2";


    /**
     *用户查询层级：本部门
     */
    public final static String USER_SEARCH_RANGE_SELF_DEPT = "1";


    //==以下变量适用于CSMapper.xml的过滤查询参数预计参数值对应的KEY==//

    /**
     * map.key:查询参数名(登记机关字段名)
     */
    public final  static String PARAM_NAME_CHECK_DEP ="checkDepKey";

    /**
     * map.key:查询参数名(登记状态)
     */
    public final  static String PARAM_NAME_REG_STATE="regStateKey";

    /**
     * map.key:查询参数名(登记状态)
     */
    public final  static String ES_PARAM_NAME_REG_STATE="esRegState";

    /**
     * map.key:模糊查询参数值(登记机关字段值)
     */
    public final  static String PARAM_LIKE_VAL_CHECK_DEP ="checkDepLikeVal";

    /**
     * map.key:精准查询参数值(登记机关字段值)
     */
    public final  static String PARAM_EQ_VAL_NAME_CHECK_DEP ="checkDepEqVal";

    /**
     *map.key:管辖单位别名
     */
    public final static String PARAM_NAME_LOCAL_ADM_ALIAS ="localAdmAlias";

    /**
     *map.value:管辖单位
     */
    public final static String PARAM_LIKE_VAL_LOCAL_ADM ="localAdmLikeVal";

    /**
     *map.key:in查询参数值
     */
    public final static String PARAM_NAME_REG_STATE_IN_VALUE ="regStateInValue";

    /**
     * 用户类型：警示
     */
    public static final String USER_TYPE_REG="1";

    /**
     * 用户类型：协同
     */
    public static final String USER_TYPE_SYN="2";
    /**
     * 用户类型：小微监测
     */
    public static final String USER_TYPE_SMENT="3";
}
