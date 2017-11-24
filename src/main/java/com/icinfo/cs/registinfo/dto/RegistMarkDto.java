/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.dto;

import com.icinfo.cs.registinfo.model.RegistMark;

/**
 * 描述: cs_regist_mark 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class RegistMarkDto extends RegistMark {

    private String setTimeStr;
    private String priPID;
    
    private String IDCode2;
    private String IDName2;
    
    private String IDCode3;
    private String IDName3;
    
    private String code;
    private String codeDesc;
    private String pcode;
    private String inspectCode;
    
    public String getPriPID(){
        return priPID;
    }

    public void setPriPID(String priPID){
        this.priPID = priPID;
    }

    public String getSetTimeStr(){
        return setTimeStr;
    }

    public void setSetTimeStr(String setTimeStr){
        this.setTimeStr = setTimeStr;
    }

    
    public String getIDCode2(){
        return IDCode2;
    }

    
    public void setIDCode2(String iDCode2){
        IDCode2 = iDCode2;
    }

    
    public String getIDName2(){
        return IDName2;
    }

    
    public void setIDName2(String iDName2){
        IDName2 = iDName2;
    }

    
    public String getIDCode3(){
        return IDCode3;
    }

    
    public void setIDCode3(String iDCode3){
        IDCode3 = iDCode3;
    }

    
    public String getIDName3(){
        return IDName3;
    }

    
    public void setIDName3(String iDName3){
        IDName3 = iDName3;
    }

    
    public String getCode(){
        return code;
    }

    
    public void setCode(String code){
        this.code = code;
    }

    
    public String getCodeDesc(){
        return codeDesc;
    }

    
    public void setCodeDesc(String codeDesc){
        this.codeDesc = codeDesc;
    }

    
    public String getPcode(){
        return pcode;
    }

    
    public void setPcode(String pcode){
        this.pcode = pcode;
    }

    
    public String getInspectCode(){
        return inspectCode;
    }

    
    public void setInspectCode(String inspectCode){
        this.inspectCode = inspectCode;
    }
}