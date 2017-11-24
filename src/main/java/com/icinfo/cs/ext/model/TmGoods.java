/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.ext.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:    cs_tm_goods 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月08日
 */
@Table(name = "cs_tm_goods")
public class TmGoods implements Serializable {
    /**
     * 注册号
     */
    @Column(name = "reg_num")
    private String reg_num;

    /**
     * 国际分类
     */
    @Column(name = "int_cls")
    private String int_cls;

    /**
     * 商品编码
     */
    @Column(name = "goods_code")
    private String goods_code;

    /**
     * 类似群编码
     */
    @Column(name = "similar_code")
    private String similar_code;

    /**
     * 删除标志
     */
    @Column(name = "del_sign")
    private String del_sign;

    /**
     * 商品序号
     */
    @Column(name = "goods_seq_num")
    private Integer goods_seq_num;

    /**
     * 中文名称
     */
    @Column(name = "goods_cn_name")
    private String goods_cn_name;

    private static final long serialVersionUID = 1L;

    /**
     * 获取注册号
     *
     * @return reg_num - 注册号
     */
    public String getReg_num() {
        return reg_num;
    }

    /**
     * 设置注册号
     *
     * @param reg_num 注册号
     */
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    /**
     * 获取国际分类
     *
     * @return int_cls - 国际分类
     */
    public String getInt_cls() {
        return int_cls;
    }

    /**
     * 设置国际分类
     *
     * @param int_cls 国际分类
     */
    public void setInt_cls(String int_cls) {
        this.int_cls = int_cls;
    }

    /**
     * 获取商品编码
     *
     * @return goods_code - 商品编码
     */
    public String getGoods_code() {
        return goods_code;
    }

    /**
     * 设置商品编码
     *
     * @param goods_code 商品编码
     */
    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    /**
     * 获取类似群编码
     *
     * @return similar_code - 类似群编码
     */
    public String getSimilar_code() {
        return similar_code;
    }

    /**
     * 设置类似群编码
     *
     * @param similar_code 类似群编码
     */
    public void setSimilar_code(String similar_code) {
        this.similar_code = similar_code;
    }

    /**
     * 获取删除标志
     *
     * @return del_sign - 删除标志
     */
    public String getDel_sign() {
        return del_sign;
    }

    /**
     * 设置删除标志
     *
     * @param del_sign 删除标志
     */
    public void setDel_sign(String del_sign) {
        this.del_sign = del_sign;
    }

    /**
     * 获取商品序号
     *
     * @return goods_seq_num - 商品序号
     */
    public Integer getGoods_seq_num() {
        return goods_seq_num;
    }

    /**
     * 设置商品序号
     *
     * @param goods_seq_num 商品序号
     */
    public void setGoods_seq_num(Integer goods_seq_num) {
        this.goods_seq_num = goods_seq_num;
    }

    /**
     * 获取中文名称
     *
     * @return goods_cn_name - 中文名称
     */
    public String getGoods_cn_name() {
        return goods_cn_name;
    }

    /**
     * 设置中文名称
     *
     * @param goods_cn_name 中文名称
     */
    public void setGoods_cn_name(String goods_cn_name) {
        this.goods_cn_name = goods_cn_name;
    }
}