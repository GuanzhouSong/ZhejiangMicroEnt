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
    <input type="hidden" name="entNameDesc" id="entNameDesc" value="${pubAnnounceMent.entNameDesc }" />
    <input type="hidden" name="UID" id="UID" value="${pubAnnounceMent.UID }" />
    <input type="hidden" name="pubTypeDesc" id="pubTypeDesc" value="${pubAnnounceMent.pubTypeDesc }" />
    <input type="hidden" name="sourceId" id="sourceId" value="${expSeriousCrimeList.sourceId }" />
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
<input id="uid" type="hidden" value="${expSeriousCrimeList.uid}" />
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
        <td><fmt:formatDate value='${expSeriousCrimeList.secNoticeDate }' pattern='yyy-MM-dd'/></td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">列入严违信息
    <a id="packUpOrUnFurled" href="javascript:void(0);" class="fr mr10"><span id="packUpOrUnFurled_">收起</span><i id="packUpOrUnFurledIcon" class="tran-icons"></i></a>
    <a class="fr mr10" href="##">异常类列入严违历史记录</a></h5>

<form id="content_form">
    <input id="secBasedStr" name="secBasedStr" type="hidden"/>
    <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10" id="sevBreachInforTable">
        <tbody>
        <tr>
            <td class="bg-gray right" width="10%">列入严违原因</td>
            <td width="66%" colspan="3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="addSecCause" value="${expSeriousCrimeList.addSecCause}" readonly/>
                </div>
            </td>
            <td class="bg-gray right" width="10%">异常届满日期</td>
            <td><fmt:formatDate value='${expSeriousCrimeList.expExpiredDate}' pattern='yyy-MM-dd'/></td>
        </tr>
        <tr>
            <td class="bg-gray right">
                列入严违说明
            </td>
            <td colspan="5">
                <div class=""> 
                    <div class="ipt-box">
                    <textarea name="addSecExplain" rows="5" readonly>${expSeriousCrimeList.addSecExplain}
                    </textarea>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">
                列入严违依据
            </td>
            <td colspan="5">
                <div class="ipt-box col-3">
                    <c:if test="${expSeriousCrimeList.addSecBasedNum != null}">${expSeriousCrimeList.addSecBasedNum}份</c:if>
                </div>
            </td>
        </tr>
			
        <c:forEach items="${basedList}" var="base" varStatus="status">
            <tr class="tr${status.count} tr">
                <td class="bg-gray right">依据${status.count}</td>
                <td colspan="5">
                    <div class="ipt-box yj-ipt clearfix">
                        <span class="light-dark-blue">
                        	<c:choose>
	                        	<c:when test="${fn:contains(base.based ,'《列入经营异常名录满3年提醒公告》（公示系统）')}">
	                        		<input id="detail_2" style="cursor:pointer;" type="text" class="ipt-txt light-dark-blue" value="${base.based}" readonly/>
	                        	</c:when>
	                        	<c:when test="${fn:contains(base.based ,'《列入经营异常名录决定书》（警示系统）')}">
	                        		<input id="detail_1" style="cursor:pointer;" type="text" class="ipt-txt light-dark-blue" value="${base.based}" readonly/>
	                        	</c:when>
	                        	<c:otherwise> 
	                        		 <input type="text" class="ipt-txt" value="${base.based}" readonly/>
	                        	</c:otherwise>
	                        </c:choose>
                        </span>
<!--                         <span class="close-box"><i class="close-icon"></i></span> -->
                    </div>
                </td>
            </tr>
        </c:forEach>


        <tr>
            <td class="bg-gray right" width="11%">
                列入严违期限
            </td>
            <td><fmt:formatDate value='${expSeriousCrimeList.addSecTerm}' pattern='yyy-MM-dd'/></td>
            <td class="bg-gray right" width="11%">列入严违日期</td>
            <td><fmt:formatDate value="${expSeriousCrimeList.addSecDate}" pattern="yyy-MM-dd"/></td>
            <td class="bg-gray right" width="11%">列入严违机关</td>
            <td>${expSeriousCrimeList.addSecOrg}</td>
        </tr>
        <tr>
            <td class="bg-gray right">
                列入严违文书
            </td>
            <td colspan="5">
	            <c:if test="${expSeriousCrimeList.addSecNo != null}">
		            <a href="javascript:void(0)" id="approval" class="light-dark-blue">
		                《列入严重违法失信企业名单审批表》、
		            </a>
		            <a href="javascript:void(0)" id="decide" class="light-dark-blue">《列入严重违法失信企业名单决定书》</a>
		            （${expSeriousCrimeList.addSecNo}）
	            </c:if>
            </td>
        </tr>
        </tbody>
    </table>
        <c:if test="${expSeriousCrimeList.applyMan != null}">
        <h5 id="h5" class="com-info-title left pdl10">意见信息 <a style="color: red">&emsp;请于<fmt:formatDate value="${expSeriousCrimeList.addSecTerm}" pattern="yyy年MM月dd日"/>前列入严违失信名单</a></h5>
        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
        <tbody>
        <tr>
            <td class="bg-gray right"> 经办人</td>
            <td>${expSeriousCrimeList.applyMan}</td>
            <td class="bg-gray right">经办人意见</td>
            <td>${expSeriousCrimeList.applyCheck}</td>
            <td class="bg-gray right">申请日期</td>
            <td><fmt:formatDate value="${expSeriousCrimeList.applyDate}" pattern="yyy-MM-dd"/></td>
        </tr></c:if>
        <c:if test="${expSeriousCrimeList.firstName != null}">
        <tr>
            <td class="bg-gray right">初审人</td>
            <td>${expSeriousCrimeList.firstName}</td>
            <td class="bg-gray right">初审意见</td>
            <td>${expSeriousCrimeList.firstOpin}</td>
            <td class="bg-gray right">初审日期</td>
            <td><fmt:formatDate value="${expSeriousCrimeList.firstdate}" pattern="yyy-MM-dd"/></td>
        </tr></c:if>
        <c:if test="${expSeriousCrimeList.auditName != null}">
        <tr>
            <td class="bg-gray right">审核人</td>
            <td>${expSeriousCrimeList.auditName}</td>
            <td class="bg-gray right">审核意见</td>
            <td>${expSeriousCrimeList.auditOpin}</td>
            <td class="bg-gray right">审核日期</td>
            <td><fmt:formatDate value="${expSeriousCrimeList.auditDate}" pattern="yyy-MM-dd"/></td>
        </tr></c:if>
        </tbody>
    </table>
</form>

<!-- <h5 class="com-info-title left pdl10">延期严违信息<a href="javascript:void(0);" class="fr mr10">收起<i -->
<!--         class="tran-icons"></i></a><a class="fr mr10">异常类延期严违历史记录</a></h5> -->
<!-- <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10"> -->
<!--     <tbody> -->
<!--     <tr> -->
<!--         <td class="bg-gray right" width="11%"> -->
<!--             延期严违原因 -->
<!--         </td> -->
<!--         <td colspan="3"> -->
<!--             <div class="ipt-box"> -->
<!--                 <select name=""> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                 </select> -->
<!--             </div> -->
<!--         </td> -->
<!--         <td width="11%" class="bg-gray right">严违行为新发生日期</td> -->
<!--         <td width="12%"></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             列入严违说明 -->
<!--         </td> -->
<!--         <td colspan="5" height="90px"> -->
<!--             <div class="max-height90"> -->
<!--                 经查，该企业被列入经营异常名录届满3年仍未履行相关义务。**年*月*日，该企业因**（事由）被**工商（市场监管）局列入经营异常名录。截止**年*月*日已届满3年，仍未履行相关义务。以上事实有：1.**年*月*日《列入经营异常名录决定书》一份；2.**年*月*日浙江省企业信用信息公示平台《列入经营异常名录满3年提醒公告》一份；上述行为违反了《企业信息公示暂行条例》的相关规定。根据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，建议将其列入严重违法失信企业名单并予以公示。 -->
<!--             </div> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             列入严违依据 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <div class="ipt-box col-2"> -->
<!--                 <select name="" id=""> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                 </select> -->
<!--             </div> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             依据1 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <span class="light-dark-blue ">**年*月*日《列入经营异常名录决定书》（警示系统）</span> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             延期严违期限 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <span class="light-dark-blue ">**年*月*日《列入经营异常名录满3年提醒公告》（公示系统）</span> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             延期严违文书 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right" width="11%">延期严违日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right" width="11%">延期严违机关</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             经办人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">申请日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">严违届满延至</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             初审人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">初审日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">初审意见</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             审核人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">审核日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">审核意见</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     </tbody> -->
<!-- </table> -->
<!-- <h5 class="com-info-title left pdl10">移出严违信息<a href="javascript:void(0);" class="fr mr10">收起<i -->
<!--         class="tran-icons"></i></a></h5> -->
<!-- <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10"> -->
<!--     <tbody> -->

<!--     <tr> -->
<!--         <td class="bg-gray right" width="11%"> -->
<!--             移出严违原因 -->
<!--         </td> -->
<!--         <td colspan="3"> -->
<!--             <div class="ipt-box"> -->
<!--                 <select name=""> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                 </select> -->
<!--             </div> -->
<!--         </td> -->
<!--         <td class="bg-gray right" width="11%">企业申请移出日期</td> -->
<!--         <td width="12%"></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             移出严违说明 -->
<!--         </td> -->
<!--         <td colspan="5" height="90px"> -->
<!--             <div class="max-height90"> -->
<!--                 经查，该企业被列入经营异常名录届满3年仍未履行相关义务。**年*月*日，该企业因**（事由）被**工商（市场监管）局列入经营异常名录。截止**年*月*日已届满3年，仍未履行相关义务。以上事实有：1.**年*月*日《列入经营异常名录决定书》一份；2.**年*月*日浙江省企业信用信息公示平台《列入经营异常名录满3年提醒公告》一份；上述行为违反了《企业信息公示暂行条例》的相关规定。根据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，建议将其列入严重违法失信企业名单并予以公示。 -->
<!--             </div> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             移出严违依据 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <div class="ipt-box col-2"> -->
<!--                 <select name="" id=""> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                     <option value=""></option> -->
<!--                 </select> -->
<!--             </div> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             依据1 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <span class="light-dark-blue ">**年*月*日《列入经营异常名录决定书》（警示系统）</span> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             移出严违期限 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right" width="11%">移出严违日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right" width="11%">移出严违机关</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             移出严违文书 -->
<!--         </td> -->
<!--         <td colspan="5"> -->
<!--             <span class="light-dark-blue"> -->
<!--                 《移出严重违法失信企业名单审批表》、 《移出严重违法失信企业名单决定书》（浙工商严违出〔2017〕第5号） -->
<!--             </span> -->
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             经办人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">申请日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">严违届满延至</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             初审人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">初审日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">初审意见</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     <tr> -->
<!--         <td class="bg-gray right"> -->
<!--             审核人 -->
<!--         </td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">审核日期</td> -->
<!--         <td></td> -->
<!--         <td class="bg-gray right">审核意见</td> -->
<!--         <td></td> -->
<!--     </tr> -->
<!--     </tbody> -->
<!-- </table> -->
<div class="center mt20">
    <input id="close" type="button" class="btn" value="关闭">
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/expsecmanage/indetail.js"></script>
</body>
</html>