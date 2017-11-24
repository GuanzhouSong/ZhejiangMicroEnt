<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>司法协助公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<script type="text/javascript">
function handleDate(pramdate){
	if(pramdate == null || pramdate == '' || pramdate == 'undefined' ){
		return '';
	}
	var time = new Date(pramdate);
	var y = time.getFullYear();  
    var m = time.getMonth() + 1;  
    m = m < 10 ? ('0' + m) : m;  
    var d = time.getDate();  
    d = d < 10 ? ('0' + d) : d;
    return '<u>'+y+'</u>&nbsp;年&nbsp;<u>'+m+'</u>&nbsp;月&nbsp;<u>'+d+'</u>&nbsp;日';
}
</script>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20 mt20">
    <div class="mod mod-notice-detail mod-notice-detail2">
        <div class="mod-notice-hd mod-hd">
            <h3>司法协助公告</h3>
        </div>
       <c:if test="${pubType =='9'}">
        <div class="mod-notice-bd">
            <h1>
				${pubJusticeInfo.entName}
				<p>司法股权冻结公告</p>
			</h1>
			<div class="mt33" style="padding-bottom: 70px;">
				<p style="text-indent:2em;">执行法院：${pubJusticeInfo.executionCourt}</p>
				<p style="text-indent:2em;">执行文书文号：${pubJusticeInfo.exeRulNum}</p>
				<p style="text-indent:2em;">执行事项：
					<c:if test="${pubJusticeInfo.executeItem == '1'}">公示冻结</c:if>
         			<c:if test="${pubJusticeInfo.executeItem == '2'}">续行冻结</c:if>
         			<c:if test="${pubJusticeInfo.executeItem == '3'}">解除冻结股权、其他投资权益</c:if>
				</p>
				<p style="text-indent:2em;">被执行人：${pubJusticeInfo.inv}</p>
				<p style="text-indent:2em;">被执行人证照/证件种类：
				      <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
		                   <c:if test="${codeCertype.code == pubJusticeInfo.cerType}">
		                      ${codeCertype.content}
		                   </c:if>
                      </c:forEach>
				</p>
				<p style="text-indent:2em;">被执行人证照/证件号码：${pubJusticeInfo.cerNO}</p>
				<p style="text-indent:2em;">被执行人持有股权、其他投资权益的数额：
				<fmt:formatNumber value="${pubJusticeInfo.froAm}" pattern="###,###,###,##0.0000"/>${pubJusticeInfo.froAuth}
				</p>
				<c:if test="${pubJusticeInfo.executeItem == 1 || pubJusticeInfo.executeItem == 2}">
				     <c:if test="${pubJusticeInfo.executeItem == 1}">
				     <p style="text-indent:2em;">冻结期限：
					                  自&nbsp;
						  <script>document.write(handleDate("${pubJusticeInfo.froFrom}"))</script>
						  &nbsp;起至&nbsp;
						  <script>document.write(handleDate("${pubJusticeInfo.froTo}"))</script>
					      &nbsp;止
					  </p>
				     </c:if>
				     <c:if test="${pubJusticeInfo.executeItem == 2}">
				     <p style="text-indent:2em;">续行冻结期限：
					                  自&nbsp;
						  <script>document.write(handleDate("${pubJusticeInfo.froFrom}"))</script>
						  &nbsp;起至&nbsp;
						  <script>document.write(handleDate("${pubJusticeInfo.froTo}"))</script>
					      &nbsp;止
					 </p>
				     </c:if>
				</c:if>
				<c:if test="${pubJusticeInfo.executeItem == 3}">
				    <p style="text-indent:2em;">解除冻结日期：
				        <script>document.write(handleDate("${pubJusticeInfo.thawDate}"))</script>
				    </p>
				</c:if>
				<p style="text-indent:2em;">公示日期：
				<script>document.write(handleDate("${pubJusticeInfo.publicDate}"))</script>
				</p>
			</div>
      </c:if>
      
      <c:if test="${pubType =='10'}">
        <div class="mod-notice-bd">
            <h1>
				${pubJusticeInfo.entName}
				<p>司法股东变更公告</p>
			</h1>
			<div class="mt33" style="padding-bottom: 70px;">
				<p style="text-indent:2em;">执行法院：${pubJusticeInfo.executionCourt}</p>
				<p style="text-indent:2em;">执行文书文号：${pubJusticeInfo.exeRulNum}</p>
				<p style="text-indent:2em;">执行事项：强制转让被执行人股权，办理有限责任公司股东变更登记</p>
				<p style="text-indent:2em;">被执行人：${pubJusticeInfo.inv}</p>
				<p style="text-indent:2em;">被执行人证照/证件种类：
				      <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
		                   <c:if test="${codeCertype.code == pubJusticeInfo.cerType}">
		                      ${codeCertype.content}
		                   </c:if>
                      </c:forEach>
				</p>
				<p style="text-indent:2em;">被执行人证照/证件号码：${pubJusticeInfo.cerNO}</p>
				<p style="text-indent:2em;">被执行人持有股权、其他投资权益的数额：
				    <fmt:formatNumber value="${pubJusticeInfo.froAm}" pattern="###,###,###,##0.0000"/>${pubJusticeInfo.froAuth}
				</p>
				<p style="text-indent:2em;">受让人：${pubJusticeInfo.assInv}</p>
				<p style="text-indent:2em;">受让人证件种类：
				  <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
                       <c:if test="${codeCertype.code == pubJusticeInfo.assCerType}">
                          ${codeCertype.content}
                       </c:if>
                   </c:forEach>
				</p>
				<p style="text-indent:2em;">受让人证件号码：${pubJusticeInfo.assCerNO}</p>
				<p style="text-indent:2em;">协助执行日期：
				   <script>document.write(handleDate("${pubJusticeInfo.executeDate}"))</script>
				</p>
			</div>
        </c:if>  
    </div>
</div>
		</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>