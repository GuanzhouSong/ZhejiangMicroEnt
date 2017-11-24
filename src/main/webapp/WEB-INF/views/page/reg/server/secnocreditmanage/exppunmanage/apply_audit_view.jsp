<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常类严违申请审核查看</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<h5 class="com-info-title left pdl10">企业基本信息</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right">企业名称</td>
        <td colspan="3" width="40%">${baseInfo.entName}</td>
        <td class="bg-gray right">统一代码（注册号）</td>
        <td>
<%--         ${baseInfo.regNO} --%>
        	<c:choose>
		   		<c:when test="${baseInfo.uniCode != '' && baseInfo.uniCode != null }">
		   			${baseInfo.uniCode}
		   		</c:when>
		   		<c:when test="${baseInfo.regNO != '' && baseInfo.regNO != null }">
		   			${baseInfo.regNO}
		   		</c:when>
			    <c:otherwise>
			    </c:otherwise>
			</c:choose>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right" width="10%">法定代表人（负责人）</td>
        <td width="28%">${baseInfo.leRep}</td>
        <td class="bg-gray right" width="8%">联系电话</td>
        <td width="18%">${baseInfo.tel}</td>
        <td class="bg-gray right" width="11%">登记机关</td>
        <td>${baseInfo.regOrgName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">企业联络员</td>
        <td>${pubEppassword.lianame}</td>
        <td class="bg-gray right">联系电话</td>
        <td>${pubEppassword.tel}</td>
        <td class="bg-gray right">管辖单位</td>
        <td>${baseInfo.localAdmName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">登记状态</td>
        <td>${hx:publicStatus(baseInfo.regState)}</td>
        <td class="bg-gray right">注销日期</td>
        <td><c:if test="${midBaseInfo.regState=='XX'||midBaseInfo.regState=='DX'}"><fmt:formatDate value="${midBaseInfo.altDate}" pattern="yyy年MM月dd日"/></c:if></td>
        <td class="bg-gray right">片区/商圈</td>
        <td>${baseInfo.sliceNOName}</td>
    </tr>
    <tr>
        <td class="bg-gray right"> 住所（经营场所）</td>
        <td colspan="5">${baseInfo.dom}</td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">严违失信信息<a class="fr mr10" href="##">严违失信历史记录</a></h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-row mb10">
    <thead>
	    <th class="bg-gray" width="10%">序号</th>
	    <th class="bg-gray" width="10%">操作</th>
	    <th class="bg-gray" width="10%">处罚类别</th>
	    <th class="bg-gray" width="30%">行政处罚文号</th>
	    <th class="bg-gray" width="30%">处罚决定日期</th>
	    <th class="bg-gray" width="30%">处罚决定机关</th>
    </thead>
    <tbody id="srcList"></tbody>
</table>

<form id="applyForm">
	<input type="hidden" id="caseNo" name="caseNo" value="${apply.sourceId}" >
	<input type="hidden" id="priPID" name="priPID" value="${apply.priPID}" >
	<input type="hidden" name="uid" value="${apply.uid}" >
       
	<h5 class="com-info-title left pdl10">列入严违信息
	    <a id="packUpOrUnFurled" href="javascript:void(0);" class="fr mr10"><span id="packUpOrUnFurled_">收起</span><i class="tran-icons"></i></a>
	    <a class="fr mr10" href="##">严违失信历史记录</a></h5>
    
    <!-- 列入信息 -->
	<form id="content_form">
	<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10 sevBreachInforTable">
	    <tbody>
		    <tr>
		        <td class="bg-gray right" width="10%">列入严违原因</td>
		        <td width="66%">
		            <div class="ipt-box">
		                <input type="text" class="ipt-txt" value="${apply.addSecCause}" readonly />
		            </div>
		        </td>
		        <td class="bg-gray right" width="10%">最近处罚日期</td>
		        <td id="lastPunDate"></td>
		    </tr>
		    <tr>
		        <td class="bg-gray right">列入严违说明</td>
		        <td colspan="3">
		            <div class="">
		                <div class="ipt-box">
		                    <textarea rows="5" readonly>${apply.addSecExplain}</textarea>
		                </div>
		            </div>
		        </td>
		    </tr>
		    <tr>
		        <td class="bg-gray right">列入严违依据</td>
		        <td colspan="3">
		            <div class="ipt-box col-3">
		            <input type="text" value="${apply.addSecBasedNum}份" class="ipt-txt" readonly>
		            </div>
		        </td>
		    </tr>
		    
		    <c:forEach items="${basedList}" var="base" varStatus="status">
			    <tr class="tr${status.count} tr">
			        <td class="bg-gray right">依据${status.count}</td>
			        <td colspan="3">
			        	<div class="ipt-box yj-ipt clearfix" style="text-align:left;">
				            <span>${base.based}</span>
			            <div class="ipt-box yj-ipt clearfix">
			        </td>
			    </tr>
		    </c:forEach>
	    </table>
	    <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10 sevBreachInforTable">
		    <tr>
		        <td class="bg-gray right" width="10%">列入严违期限</td>
		        <td><fmt:formatDate value="${apply.addSecTerm}" pattern='yyy-MM-dd'/></td>
		        <td class="bg-gray right" width="9%">列入严违日期</td>
		        <td><fmt:formatDate value="${apply.addSecDate}" pattern="yyy-MM-dd"/></td>
		        <td class="bg-gray right" width="9%">列入严违机关</td>
		        <td>${apply.addSecOrg}</td>
		  </tr>
		  <tr>
            <td class="bg-gray right">列入严违文书</td>
            <td colspan="5">
            <span>
                ${apply.addSecNo}
            </span>
            </td>
          </tr>
		    </tbody>
	</table>
	<h5 id="h5" class="com-info-title left pdl10">意见信息 <a style="color: red">&emsp;请于<fmt:formatDate value="${apply.addSecTerm}" pattern="yyy年MM月dd日"/>前列入严违失信名单</a></h5>    
    <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
        <tbody>
		  <tr>
		        <td class="bg-gray right" width="10%">经办人</td>
		        <td><div class="ipt-box">${apply.applyMan}</div></td>
		        <td class="bg-gray right" width="9%">经办人意见</td>
		        <td>${apply.applyCheck}</td>
		        <td class="bg-gray right" width="9%">申请日期</td>
		        <td><fmt:formatDate value="${apply.applyDate}" pattern='yyy-MM-dd'/></td>
		        
		    </tr>
		    <c:if test="${apply.firstName != null}">
		    <tr>
		        <td class="bg-gray right" width="10%">初审人</td>
		        <td><div class="ipt-box">${apply.firstName}</div></td>
		        <td class="bg-gray right" width="9%">初审意见</td>
		        <td>${apply.firstOpin}</td>
		        <td class="bg-gray right" width="9%">初审日期</td>
		        <td><fmt:formatDate value="${apply.firstdate}" pattern='yyy-MM-dd'/></td>
		        
			</tr>
			</c:if>
			<c:if test="${apply.auditName != null}">
			  <tr>
		        <td class="bg-gray right" width="9%">审核人  </td>
		        <td><div class="ipt-box">${apply.auditName}</div></td>
		        <td class="bg-gray right" width="10%">审核意见</td>
		        <td><div class="ipt-box">${apply.auditOpin}</div></td>
		        <td class="bg-gray right" width="9%">审核日期  </td>
		        <td><fmt:formatDate value="${apply.auditDate}" pattern="yyy-MM-dd"/></td>
		      </tr>
		    </c:if>
	    </tbody>
	</table>
	</form>
	
	<!-- 延期信息 -->
	
	<div class="center mt20">
	    <input id="cancel" type="button" class="btn" value="返回">
	</div>
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/exppunmanage/apply_audit_view.js"></script>
</body>
</html>