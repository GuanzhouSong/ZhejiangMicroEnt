/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.mainmark.dto;

import com.icinfo.cs.mainmark.model.MainMark;

/**
 * 描述: cs_main_mark 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public class MainMarkDto extends MainMark {

    private static final long serialVersionUID = 1L;
    private String            entName;
    private String            uniCode;
    private String            regNO;
    private String            markName1;
    private String            markName3;
    private String            markName4;



    public String getEntName(){
        return entName;
    }

    public void setEntName(String entName){
        this.entName = entName;
    }

    public String getUniCode(){
        return uniCode;
    }

    public void setUniCode(String uniCode){
        this.uniCode = uniCode;
    }

    public String getRegNO(){
        return regNO;
    }

    public void setRegNO(String regNO){
        this.regNO = regNO;
    }

    
    public String getMarkName1(){
        return markName1;
    }

    
    public void setMarkName1(String markName1){
        this.markName1 = markName1;
    }

    
    public String getMarkName3(){
        return markName3;
    }

    
    public void setMarkName3(String markName3){
        this.markName3 = markName3;
    }

    
    public String getMarkName4(){
        return markName4;
    }

    
    public void setMarkName4(String markName4){
        this.markName4 = markName4;
    }

}