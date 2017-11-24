<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body> 
 
 
<form   id="permitForm">
   <input type="hidden" name="priPID" value=${midBaseInfoDto.priPID }>
            <input type="hidden" name="entName" value=${midBaseInfoDto.entName }>
              <input type="hidden" name="regNO" value=${midBaseInfoDto.regNO }>
               <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }>
              <input type="hidden" name="licID" value="${mPermit.licID}">
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>行政许可信息</h4>
        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">许可文件编号</div>
                        <div class="item-txt">
                            <input type="text" readonly name="licNO"  placeholder="请输入许可文件编号"
                           value="${mPermit.licNO}" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">许可文件名称</div>
                        <div class="item-txt">
                            <input readonly type="text" name="licNameCN"   placeholder="请输入许可文件名称"
                           value="${mPermit.licNameCN}"class="ipt-txt">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name">有效日期</div>
                        <div class="item-txt">
                            <input type="text" readonly name="valFrom"     placeholder="请输入开始时间"   value="<fmt:formatDate value="${mPermit.valFrom}" pattern="yyyy-MM-dd"/>" class="ipt-txt ipt-txt-mdd ipt-txt laydate-icon" id="start" readonly="" > —
                            <input type="text"  readonly    name="valTo"  placeholder="请输入结束时间"
                           value="<fmt:formatDate value="${mPermit.valTo}" pattern="yyyy-MM-dd"/>" class="ipt-txt ipt-txt-mdd ipt-txt laydate-icon" id="end" readonly=""  >

                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">许可机关</div>
                        <div class="item-txt">
                            <input type="text" name="licAnth" readonly    placeholder="请输入许可机关"
                           value="${mPermit.licAnth}" class="ipt-txt">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name">许可内容</div>
                        <div class="item-txt">
                            <textarea name="licItem" readonly id="" cols="" rows="5">${mPermit.licItem }</textarea>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
         
    </div>
</div>
 
</body>

</html>