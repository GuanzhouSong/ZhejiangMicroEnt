<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>简易注销详情页</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../common/enterpriseforsimpleesc.jsp"></jsp:include>
<div class="mb20 mt20">
	<form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${erEscAppinfo.priPID }"/>
    </form>
    <div class="mod detail-main">
        <div class="tab-panel">
            <div class="mod-bd-panel_company pt10">
                <div class="abnorm-title pos-rel">
                        <h3>${erEscAppinfo.entName }简易注销公告信息</h3>
                        <c:if test="${erEscAppinfo.simplecanRea!='5'&&objectionFlag==1 }">
                       		 <a href="objectionApply?encryPriPID=${erEscAppinfo.encryPriPID }" class="wycomplain">我要异议</a>
                		</c:if>
                </div>
                <h3 class="i-title">
                    <i></i>企业公告信息
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <em>• </em>
                        <span class="title">企业名称：</span>
							<span>
								${erEscAppinfo.entName }
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">统一社会信用代码/注册号：</span>
                        <span>${(!empty erEscAppinfo.uniSCID)?erEscAppinfo.uniSCID:erEscAppinfo.regNO}</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">登记机关：</span>
							<span>
								${erEscAppinfo.regOrgName }
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">公告期：</span>
                        <span class="light bold"><fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">全体投资人承诺书：</span>
							<span>
								<a href="findLetter?encryPriPID=${erEscAppinfo.encryPriPID}" class="light-yellow" target="_blank">查看详情</a>
							</span>
                    </li>
                </ul>
            </div>

		<!-- 异议信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>异议信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="40">序号</th>
                    <th width="70">异议申请人</th>
                    <th width="240">异议内容</th>
                    <th width="100">异议时间</th>
                </tr>
                </thead>
                <tbody id="table-objection">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="_total_objection"></em> 条信息，共 <em id="_pageNum_objection"></em> 页</span>
                <div id="pagination_objection" class="pagination">
                </div>
            </div>
        </div>
        <script id="table-template-objection" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{name}}</td>
                <td>{{{objection}}}</td>
                <td>{{objapptime}}</td>
            </tr>
            {{/each}}
        </script>
        
        <!-- 简易注销结果信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>简易注销结果
            </h3>
            <c:if test="${erEscScrinfo.simplecanRea=='4' }">
	            <table class="table-common mb20">
	                <thead>
	                <tr>
	                    <th width="200">简易注销结果</th>
	                    <th width="200">公告申请日期</th>
	                </tr>
	                </thead>
	                <tbody id="table-scrinfo">
	                	<tr>
	                		<td>${erEscScrinfo.simplecanReaName }</td>
	                		<td><fmt:formatDate value="${erEscScrinfo.appDate}" pattern="yyyy年MM月dd日"/></td>
	                	</tr>
	                </tbody>
	            </table>
            </c:if>
            <c:if test="${erEscAppinfo.simplecanRea=='5' }">
	            <table class="table-common mb20">
	                <thead>
	                <tr>
	                    <th width="200">简易注销结果</th>
	                    <th width="200">公告撤销日期</th>
	                </tr>
	                </thead>
	                <tbody id="table-scrinfo">
	                	<tr>
	                		<td>撤销简易注销</td>
	                		<td><fmt:formatDate value="${erEscAppinfo.cancelDate}" pattern="yyyy年MM月dd日"/></td>
	                	</tr>
	                </tbody>
	            </table>
            </c:if>
            <c:if test="${erEscScrinfo.simplecanRea=='1'||erEscScrinfo.simplecanRea=='2'||erEscScrinfo.simplecanRea=='3' }">
	            <table class="table-common mb20">
	                <thead>
	                <tr>
	                    <th width="200">简易注销结果</th>
	                    <th width="200">核准日期</th>
	                </tr>
	                </thead>
	                <tbody id="table-scrinfo">
	                	<tr>
	                		<td>${erEscScrinfo.simplecanReaName }</td>
	                		<td><fmt:formatDate value="${erEscScrinfo.apprDate}" pattern="yyyy年MM月dd日"/></td>
	                	</tr>
	                </tbody>
	            </table>
            </c:if>
        </div>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/simpleesc/objection_detail.js"></script>

</body>
</html>