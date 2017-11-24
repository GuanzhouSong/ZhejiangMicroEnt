<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>实缴新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>
    <form  id="invprodetailForm">
       <input type="hidden" name="invID" id="invID" value=${invID }>
            <input type="hidden" name="paidID" value="${invactdetail.paidID}">
    
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>股东及出资信息 </h4>
        <div>
            <ul class="form-common-list invprodetail-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            <div class="middle-inner">
                                <p>实缴出资方式</p>
                            </div>
                        </div>
                        <div class="item-txt">
                            <select name="acConForm" id="acConForm" class="select-txt valid required" aria-invalid="false">
                              <option  value="">--请选择--</option>
                               <c:forEach items="${codeList}"  var="pr">
                                 <option value="${pr.code }" ${invactdetail.acConForm==pr.code?'selected':''}>${pr.content}</option>
                               </c:forEach>
                            </select>
                            <input type="hidden" id="acConFormCn" name="acConFormCn"  value="${invactdetail.acConFormCn}">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            <div class="middle-inner">
                                <p>实缴出资额（万${midBaseInfoDto.currencyCn}）</p>
                            </div>
                        </div>
                        <div class="item-txt">
                            <input type="text" name="acConAm" value="${invactdetail.acConAm}" value="" class="ipt-txt assetItem">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            <div class="middle-inner">
                                <p>实缴出资日期</p>
                            </div>
                        </div>
                        <div class="item-txt">
                            <input type="text"  name="conDate"  id="conDate"   value="<fmt:formatDate value="${invactdetail.conDate}"  pattern="yyyy-MM-dd"/>"  class="ipt-txt laydate-icon" readonly=""  >
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <p class="btn"><input type="submit" value="保存" id="submitButton" class="btn-common"><input type="button" value="取消"  id="cancel" class="btn-common"></p>
    </div>
</div>
</form>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/invactdetail/edit_main.js"/>"></script>
 
</body>
</html>