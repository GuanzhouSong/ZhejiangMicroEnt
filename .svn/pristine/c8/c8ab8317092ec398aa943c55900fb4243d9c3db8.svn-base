<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股权变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
 
 
 
<form id="invsraltForm"> 
<input type="hidden" name="priPID" value=${midBaseInfoDto.priPID }>
                <input type="hidden" name="entName" value=${midBaseInfoDto.entName }>
              <input type="hidden" name="regNO" value=${midBaseInfoDto.regNO }>
               <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }>
            
                <input type="hidden" name="invAltID" id="invAltID" value="${imInvsralt.invAltID}">
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        
        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            股东
                        </div>
                        <div class="item-txt">
                            <input type="text"  name="inv" readonly  placeholder="请输入股东名称"
                           value="${imInvsralt.inv}" class="ipt-txt ipt-txt-per">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">股权变更日期</div>
                        <div class="item-txt">
                            <input type="text"  name="equAltDate" id="equAlDate"   readonly  placeholder="请输入股权变更日期"
                           value="<fmt:formatDate value="${imInvsralt.equAltDate}" pattern="yyyy-MM-dd"/>" class="ipt-txt ipt-txt-per laydate-icon" readonly=""  >
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name">变更前股权比例 </div>
                        <div class="item-txt">
                      
                            <input type="text" name="beTransAmPr" readonly id="beTransAmPr"  placeholder="请输入变更前股权比例"
                           value="${imInvsralt.beTransAmPr}"    class="ipt-txt ipt-txt-per"> %
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">变更后股权比例</div>
                        <div class="item-txt">
                            <input type="text"   name="afTransAmPr" readonly  id="citySel" placeholder="请输入变更后股权比例"
                           value="${imInvsralt.afTransAmPr}" class="ipt-txt ipt-txt-per"> %
                        </div>
                    </div>
                </li>
            </ul>
        </div>
      
    </div>
</div>
</form>
 
</body>
</html>