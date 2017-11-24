package com.icinfo.cs.writ.dto;

/**
 * 描述：统计查询结果
 * @author: wangjin
 * @date：2017-06-14
 */
public class WritCountDto {

    private Integer entNameNum;// 企业条数

    private Integer writNum;   //文书条数

    private Integer lookNum;   //查阅条数

    private Integer notLookNum; //未查阅条数


    public Integer getEntNameNum() {
        return entNameNum;
    }

    public void setEntNameNum(Integer entNameNum) {
        this.entNameNum = entNameNum;
    }

    public Integer getWritNum() {
        return writNum;
    }

    public void setWritNum(Integer writNum) {
        this.writNum = writNum;
    }

    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }

    public Integer getNotLookNum() {
        return notLookNum;
    }

    public void setNotLookNum(Integer notLookNum) {
        this.notLookNum = notLookNum;
    }
}
