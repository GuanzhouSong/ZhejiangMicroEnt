<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>实缴变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod pdt20">
  <input type="hidden"  id="paidID" name="paidID" value="${invactdetail.paidID}">
   <input type="hidden"  id="invID" name="paidID" value="${invID}">
    <div class="mod-cont">
        <h4>股东及出资信息<input  type="hidden" id="acConFormCn" name="acConFormCn" value="${invactdetail.acConFormCn}"></h4>
        <div class="invactdetail-change">
            <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                <tr>
                    <th colspan="2" class="before" width="50%">变更前</th>
                    <th colspan="2" class="after" width="50%">变更后</th>
                </tr>
                <tr>
                    <td class="tab-c-title">出资方式</td>
                    <td width="300" id="change1T">${invactdetail.acConFormCn}</td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" title="change1" value="出资方式">出资方式</span></td>
                    <td width="300">
                        <span>${invactdetail.acConFormCn}</span>
                        <div class="item-txt" style="display: none">
                            <select name="acConForm" id="change1" class="select-txt">
                               <c:forEach items="${codeList}"  var="pr">
                       <option value="${pr.code }"
		               <c:if test="${invactdetail.acConForm==pr.code}"> selected="selected" </c:if>>${pr.content }</option>
                         </c:forEach>  
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="tab-c-title">实缴出资额（万${midBaseInfoDto.currencyCn}）</td>
                    <td id="change2T" class="assetItemText">${invactdetail.acConAm }</td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" title="change2" value="实缴出资额（万${midBaseInfoDto.currencyCn}）">实缴出资额（万${midBaseInfoDto.currencyCn}）</span></td>
                    <td><span class="assetItemText">${invactdetail.acConAm }</span><input name="acConAm" type="text" id="change2" class="ipt-txt assetItem"></td>
                </tr>
                <tr>
                    <td class="tab-c-title">出资日期</td>
                    <td id="change3T"><fmt:formatDate value="${invactdetail.conDate}"  pattern="yyyy-MM-dd"/></td>
                    <td class="tab-c-title"><span><input type="checkbox" name="change" value="出资日期" title="change3">出资日期</span></td>
                    <td><span><fmt:formatDate value="${invactdetail.conDate}"  pattern="yyyy-MM-dd"/></span><input type="text" id="change3" name="conDate" value="" class="ipt-txt laydate-icon"   readonly="readonly"  ></td>
                </tr>
                <tr>
                    <td class="tab-c-title"></td>
                    <td></td>
                    <td class="tab-c-title">变更时间</td>
                    <td><input type="text" id="altDate" value="" name="altDate" class="ipt-txt laydate-icon change-time" readonly="readonly"  ></td>
                </tr>
            </table>
        </div>
        <p class="btn"><input type="button" id="savechange" value="保存" class="btn-common"><input type="button" id="cancel" value="取消" class="btn-common"></p>
    </div>
</div>
 <form id="changeForm"></form>
<jsp:include page="../../common/footer.jsp"></jsp:include> 

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/invactdetail/change_main.js"/>"></script>
 
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
        $(this).closest('td').next('td').find('.item-txt').toggle();
    })
</script>
</body>
</html>