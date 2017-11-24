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
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
        	<em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
        	<c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
        <p>
            <em class="register-office">法定代表人/负责人：${midBaseInfoDto.leRep}</em>
            <em>成立日期：<fmt:formatDate value="${midBaseInfoDto.estDate}" dateStyle="long"/></em>
            <c:if test="${!empty midBaseInfoDto.regCap}">
                <em>注册资本：<fmt:formatNumber type="number"  value=" ${midBaseInfoDto.regCap }"  pattern="0.00" maxFractionDigits="2"/>万${midBaseInfoDto.currencyCn}</em>
            </c:if>
        </p>
    </div>
</div>
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
                    <td> <a href="#" class="viewPbHisReport" id='{{reportNo}}' title='{{anCheID}}'>详情</a>&nbsp;<a href="#" class="printPbHisReport" id='{{reportNo}}' title='{{anCheID}}'>打印</a></td>
            </tr> 
    {{/each}} 
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/pbyr/pbreportprint_list.js"/>"></script>
 <script>
    window._CONFIG = {
       _year:'${year}', //年报年度
       _pripid:'${pripid}'  //主体代码  
    }
</script>
</body>
</html>