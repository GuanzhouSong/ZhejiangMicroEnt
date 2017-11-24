<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常类严违申请列入</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<h5 class="com-info-title left pdl10">企业基本信息</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right">企业名称</td>
        <td colspan="3" width="40%">${midBaseInfo.entName}</td>
        <td class="bg-gray right">统一代码（注册号）</td>
        <td>
<%--         ${midBaseInfo.regNO} --%>
			<c:choose>
		   		<c:when test="${midBaseInfo.uniCode != '' && midBaseInfo.uniCode != null }">
		   			${midBaseInfo.uniCode}
		   		</c:when>
		   		<c:when test="${midBaseInfo.regNO != '' && midBaseInfo.regNO != null }">
		   			${midBaseInfo.regNO}
		   		</c:when>
			    <c:otherwise>
			    </c:otherwise>
			</c:choose>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right" width="10%">法定代表人（负责人）</td>
        <td width="28%">${midBaseInfo.leRep}</td>
        <td class="bg-gray right" width="8%">联系电话</td>
        <td width="18%">${midBaseInfo.tel}</td>
        <td class="bg-gray right" width="11%">登记机关</td>
        <td>${midBaseInfo.regOrgName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">企业联络员</td>
        <td>${pubEppassword.lianame}</td>
        <td class="bg-gray right">联系电话</td>
        <td>${pubEppassword.tel}</td>
        <td class="bg-gray right">管辖单位</td>
        <td>${midBaseInfo.localAdmName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">登记状态</td>
        <td>${hx:publicStatus(midBaseInfo.regState)}</td>
        <td class="bg-gray right">注销日期</td>
        <td><c:if test="${midBaseInfo.regState=='XX'||midBaseInfo.regState=='DX'}"><fmt:formatDate value="${midBaseInfo.altDate}" pattern="yyy年MM月dd日"/></c:if></td>
        <td class="bg-gray right">片区/商圈</td>
        <td>${midBaseInfo.sliceNOName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">
            住所（经营场所）
        </td>
        <td colspan="5">${midBaseInfo.dom}</td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">异常届满信息<a class="fr mr10" href="##">异常届满历史记录</a></h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-row mb10">
    <thead>
    <th class="bg-gray" width="30%">列入异常原因</th>
    <th class="bg-gray" width="12%">列入日期</th>
    <th class="bg-gray" width="30%">列入异常机关</th>
    <th class="bg-gray" width="11%">列入异常文号</th>
    <th class="bg-gray">异常届满日期</th>
    <th class="bg-gray">届满提醒公告日期</th>
    </thead>
    <tbody>
    <tr>
        <td>${expSeriousCrimeList.speCauseCN}</td>
        <td><fmt:formatDate value="${expSeriousCrimeList.abnTime}" pattern="yyy-MM-dd"/></td>
        <td>${expSeriousCrimeList.decorgCN}</td>
        <td>${expSeriousCrimeList.penDecNo}</td>
        <td><fmt:formatDate value="${expSeriousCrimeList.expExpiredDate}" pattern="yyy-MM-dd"/></td>
        <td><fmt:formatDate value="${expSeriousCrimeList.secNoticeDate}" pattern="yyy-MM-dd"/></td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">列入严违信息
    <a id="packUpOrUnFurled" href="javascript:void(0);" class="fr mr10"><span id="packUpOrUnFurled_">收起</span><i class="tran-icons"></i></a>
    <a class="fr mr10" href="##">异常类列入严违历史记录</a></h5>
    
<form id="content_form">
<table id="sevBreachInforTable" cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right" width="10%">列入严违原因</td>
        <td width="66%">
            <div class="ipt-box">
                <input type="text" class="ipt-txt" value="${expSeriousCrimeList.addSecCause}" readonly />
            </div>
        </td>
        <td class="bg-gray right" width="10%">异常届满日期</td>
        <td><fmt:formatDate value='${expSeriousCrimeList.expExpiredDate}' pattern='yyy-MM-dd'/></td>
    </tr>
    <tr>
        <td class="bg-gray right">
            列入严违说明
        </td>
        <td colspan="3">
            <div class="">
                <div class="ipt-box">
                    <textarea rows="5" readonly>${expSeriousCrimeList.addSecExplain}
                    </textarea>
                </div>
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right">
            列入严违依据
        </td>
        <td colspan="3">
            <div class="ipt-box col-3">
            <input type="text" value="${expSeriousCrimeList.addSecBasedNum}份" class="ipt-txt" readonly>
            </div>
        </td>
    </tr>
    
    <c:forEach items="${basedList}" var="base" varStatus="status">
	    <tr class="tr${status.count} tr">
	        <td class="bg-gray right">依据${status.count}</td>
	        <td colspan="3">
	        	<div class="ipt-box yj-ipt clearfix">
		            <span class="light-dark-blue"><input type="text" class="ipt-txt" value="${base.based}" readonly/></span>
<!-- 		            <span class="close-box"><i class="close-icon"></i></span> -->
	            </div>
	        </td>
	    </tr>
    </c:forEach>
    
    </tbody>
</table>
<h5 id="h5" class="com-info-title left pdl10">审批意见信息 <a style="color: red">&emsp;请于<fmt:formatDate value="${expSeriousCrimeList.addSecTerm}" pattern="yyy年MM月dd日"/>前列入严违失信名单</a></h5>
<input type="hidden" name="sourceId" value="${expSeriousCrimeList.sourceId}" />
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
    <tbody>
    <tr>
        <td class="bg-gray right" width="10%">经办人</td>
        <td width="20%"><div class="ipt-box">${expSeriousCrimeList.applyMan}</div></td>
        <td class="bg-gray right" width="9%">经办人意见</td>
        <td><div class="ipt-box">${expSeriousCrimeList.applyCheck}</div></td>
        <td class="bg-gray right" width="9%">申请日期</td>
        <td><fmt:formatDate value="${expSeriousCrimeList.applyDate}" pattern="yyy-MM-dd"/></td>
  </tr>
  
  <tr>
        <td class="bg-gray right" width="10%">初审意见  </td>
        <td>
                <div class="radio-box">
                    <label for=""><input class="firstCheck" name="firstCheck" value="1" type="radio" checked >拟列入 </label>
                    <label for=""><input class="firstCheck" name="firstCheck" value="0" type="radio"> 拟不列入 </label>
                </div>
        </td>
        <td class="bg-gray right" width="9%">初审人  </td>
        <input type="hidden" value="${sysUser.deptCode}" name="firstDept" />
        <input type="hidden" name="firstDeptName" value="${sysUser.dept}"/>
        <td><div class="ipt-box"> <input type="text" value="${sysUser.realName}" name="firstName" class="ipt-txt"> </div></td>
        <td class="bg-gray right" width="9%"> 初审日期  </td>
        <td><div class="ipt-box"> <input type="text" value="<fmt:formatDate value="${date}" pattern="yyy-MM-dd"/>" name="firstdate" class="ipt-txt" readonly> </div></td>
    </tr>
    <tr>
        <td class="bg-gray right" width="15%">初审意见补充  </td>
		<td colspan="5">
			<div class="ipt-box">
				<input id="firstOpin" type="text" name="firstOpin" value="同意经办人意见，拟将其列入严重违法失信企业名单，请局领导审批。" class="ipt-txt">
			</div>
		</td>
	</tr>
   </tbody>
</table>
</form>
<div class="center mt20">
    <input id="save" type="button" class="btn mr10" value="提交">
    <input id="cancel" type="button" class="btn" value="取消">
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/expsecmanage/firstreview.js"></script>
</body>
</html>