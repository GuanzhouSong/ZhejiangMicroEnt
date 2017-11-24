<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>认缴变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod pdt20">
    <div class="mod-cont">
      <input type="hidden"  id="subID" name="subID" value="${imInvprodetail.subID}">
                <input type="hidden"  id="invID" name="invID" value="${invID}">
        <h4>股东及出资信息</h4>
        <div class="invactdetail-change invprodetail_change">
            <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                <tr>
                    <th colspan="2" class="before" width="50%">变更前</th>
                    <th colspan="2" class="after" width="50%">变更后</th>
                </tr>
                <tr>
                    <td class="tab-c-title">出资方式</td>
                    <td width="300" id="change1T">${imInvprodetail.conFormCN}</td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" title="change1" value="出资方式">出资方式</span></td>
                    <td width="300">
                        <span>${imInvprodetail.conFormCN}</span>
                        <div class="item-txt" style="display: none">
                            <select name="conForm" id="change1" class="select-txt">
                              
                               <c:forEach items="${codeList}"  var="pr">
                       <option value="${pr.code }"
		               <c:if test="${imInvprodetail.conForm==pr.code}"> selected="selected" </c:if>>${pr.content }</option>
                         </c:forEach> 
                            </select>
                            
                        </div>
                       
                    </td>
                     <input type="hidden" id="conFormCN" name="conFormCN" value="${imInvprodetail.conFormCN}">
                </tr>
                <tr>
                    <td class="tab-c-title" >认缴出资额（万${midBaseInfoDto.currencyCn}）</td>
                    <td class="assetItemText" id="change2T">${imInvprodetail.subConAm }</td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" title="change2"  value="认缴出资额（万${midBaseInfoDto.currencyCn}）">认缴出资额（万${midBaseInfoDto.currencyCn}）</span></td>
                    <td><span class="assetItemText">${imInvprodetail.subConAm }</span><input type="text" id="change2" name="subConAm" class="ipt-txt assetItem"></td>
                </tr>
                <tr>
                    <td class="tab-c-title">出资日期</td>
                    <td id="change3T"><fmt:formatDate value="${imInvprodetail.conDate}" pattern="yyyy-MM-dd"/></td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" title="change3" value="出资日期">出资日期</span></td>
                    <td><span><fmt:formatDate value="${imInvprodetail.conDate}" pattern="yyyy-MM-dd"/></span><input id="change3" type="text" name="conDate"  class="ipt-txt laydate-icon" id="end" readonly="readonly"  </td>
                </tr>
                <tr>
                    <td class="tab-c-title"></td>
                    <td></td>
                    <td class="tab-c-title">变更时间</td>
                    <td><input type="text" class="ipt-txt laydate-icon change-time" id="altDate" name="altDate" readonly="readonly"  ></td>
                </tr>
            </table>
        </div>
        <p class="btn"><input type="button" id="savechange" value="保存" class="btn-common"><input type="button" value="取消" id="cancel" class="btn-common"></p>
    </div>
</div>
  <form id="changeForm"></form>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
        $(this).closest('td').next('td').find('.item-txt').toggle();
    })
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/client/im/invprodetail/change_main.js"></script>
</body>
</html>