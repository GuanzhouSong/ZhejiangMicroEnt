<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政处罚变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>


<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>行政处罚信息</h4>
       
        <div class="case-list">
        <form id="casaltForm">
         <input type="hidden" name="caseNO" id="caseNO" value="${caseNO }">
            <table border="0" id="permit-table" cellspacing="0" cellpadding="0" class="table-ordinary">
                <thead>
                <tr>
                    <th width="53">序号</th>
                    <th width="148">变更时间</th>
                    <th width="230">变更决定做出机关</th>
                    <th width="287">变更内容</th>
                    <th> 备注</th>
                </tr>
                </thead>
                <tbody id="tplPage">
                
                </tbody> 
                
                
            </table>
            </form>
        </div>
        <p class="btn"><input type="button" value="添加" id="save" class="btn-common">
       <!--  <input type="button" value="保存" class="btn-common"> -->
        <input type="button" value="取消"  id="cancel" class="btn-common">
       <!--  <input type="button" value="保存并公示" class="btn-common"> --></p>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}} 
             <tr>  <td>{{addOne @index}}</td>
                    <td>{{dataFormat altDate}} </td>
                    <td>{{penAuthName}}</td>
                    <td>{{penContent}}</td>
                    <td>{{remark}}</td>
                </tr>
   
    {{/each}}

   <tr>
          
   
                    <td></td>
                    <td><input type="text" class="ipt-txt laydate-icon" name="altDate" id="altDate" onclick="laydate({max: laydate.now()})" ></td>
                    <td><input type="text" class="ipt-txt" name="penAuthName" maxlength="100" onKeyDown="if(this.value.length>100){this.value=this.value.substr(0,100)}" id="penAuth"></td>
                    <td><input type="text" class="ipt-txt" name="penContent" id="penContent" ></td>
                    <td><input type="text" class="ipt-txt" name="remark" id="remark"></td>
                </tr> 

</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/case/change_main.js"/>"></script>
 
</body>
</html>