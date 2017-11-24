<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>查看历史</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod">
 <input type="hidden" name="pageyear" id="pageyear" value="${year}">
 <input type="hidden" name="page" id="page">
    <div class="mod-hd">
        <div class="title">
            <h3>历次年度报告记录</h3>
        </div>
    </div>
    <div class="mod-bd">
        <div class="content content-contact">
            <div class="content-sm-height">
                <table id="hisreport_table" class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th class="bg" width="10%">序号</th>
                        <th class="bg" width="20%">年度</th>
                        <th class="bg">日期</th>
                        <th class="bg" width="20%">操作</th>
                    </tr>
                    </thead>
                     <tbody id="tplPage">
                 
                
                     </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount">0</em> 条信息，共<em id="pageCount">0</em>页</span>
                <div id="pagination_one" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}  
            <tr>
                    <td>{{xh @index}}</td>
                    <td>{{year}}</td>
                    <td>{{lastReportTime}}</td>
                    <td> <a href="#"  class="viewHisReport"   id={{reportNo}} title={{anCheID}} >详情</a>&nbsp;<a href="#" class="printHisReport" id='{{reportNo}}' title='{{anCheID}}'>打印</a></td>
            </tr> 
    {{/each}} 
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/pubhis/list_main.js"/>"></script>
 <script>
    window._CONFIG = {
       _year:'${year}', //年报年度
        _pripid:'${pripid}'  //主体代码 
    }
</script>
</body>
</html>