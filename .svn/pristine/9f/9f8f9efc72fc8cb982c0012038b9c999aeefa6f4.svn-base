<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>企业认领/接收信息查询详情（主体信息）</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/syn.css">      
</head>
<body>
            <div class="tab-panel">
                <div class="mt10">
                 <input type="hidden" id ="priPID" value="${priPID}" ><!-- 内部序号 -->
                    <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mt30">
                        <thead>
                        <tr >
			            <th colspan="8" style="text-align: center;">许可审批信息</th>
			            </tr>
                        <tr>
                            <th width="5.5%">序号 </th>
                            <th width="10.7%">许可文件编号</th>
                            <th width="26.5%">许可文件名称</th>
                            <th>有效期自</th>
                            <th>有效期至</th>
                            <th width="18.7%">许可机关</th>
                            <th width="13.4%">许可内容</th>
                            <th width="10%">状态</th>
                        </tr>
                        </thead>
                        <tbody id="dbao_page_one">
                        </tbody>
                    </table>
                    <div class="notice-pagination-box clearfix">
                        <span class="page-total">共查询到<em id="_total"></em>条信息，共<em id="_pageNum"></em>页</span>
                        <div id="pagination" class="pagination">
                    </div>
<!--                     <p class="center mt15"><input type="button" class="btn" value="返 回"></p> -->
                </div>
            </div>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script id="table-template-one" type="text/x-handlebars-template">
{{#each data}}  
             <tr>
                    <td>{{xh @index}}</td>
                    <td>{{licNO}}</td>
                    <td>{{licNameCN}}</td>
                    <td>{{licValFrom}}</td>
                    <td>{{licValTo}}</td>
                    <td>{{licAnth}}</td>
                    <td>{{licScope}}</td>
             </tr> 
{{/each}} 
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdtinfo/pubdtinfoDetail_licinfo.js"></script>
</body>
</html>