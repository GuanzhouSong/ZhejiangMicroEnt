 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>知识产权出质信息列表页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>


<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>知识产权出质登记信息</h4>
        <div class="permit-list">
            <table border="0" id="permit-table" cellspacing="0" cellpadding="0" class="table-ordinary">
               <thead>
                <tr>
                    <th width="190"> 出质商标注册号</th>
                    <th>名称</th>
                    <th>种类</th>
                    <th>出质人名称</th>
                    <th width="90">质权人名称</th>
                    <th width="186">质权登记期限</th>
                    <th width="80">登记状态</th>
                    <th width="75">公示状态</th>
                    <th width="80">操作</th>
                </tr>
                </thead>
                
            </table>
        </div>
        <p class="btn"><input type="button" value="添加" class="btn-common js-add">
        <input type="button" value="打印预览" id="print" class="btn-common">
        <input type="button" id="pubAll" value="保存并公示" class="btn-common">
        <input type="button" value="关闭" class="btn-common" id="close">
        </p>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
  <a href="#" class="{{this.class}}">{{this.text}}</a> 
    {{/each}}
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/ippldg/list_main.js"/>"></script>
  

</body>
</html>