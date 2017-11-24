<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政处罚详情</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<div class="mt20 mb20 clearfix">
    <div class="contact-mod mod">
        <div class="contact-mod-hd">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>行政处罚信息摘要
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <span class="title"><em>• </em>行政处罚决定书文号：</span>
	                    <span>${pubOtherpunishDto.penDecNo}</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>作出行政处罚机关名称：</span>
                        <span>${pubOtherpunishDto.judAuth}</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>名称：</span>
                        <span>${pubOtherpunishDto.entName}</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>统一社会信用代码/注册号：</span>
                        <span>${pubOtherpunishDto.regNO}</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>法定代表人（负责人）姓名：</span>
                        <span>${pubOtherpunishDto.leRep}</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>作出行政处罚决定日期：</span>
                        <span><fmt:formatDate value="${pubOtherpunishDto.penDecIssDate}" pattern="yyyy年MM月dd日"/></span>
                    </li>
                    <li>
	                    <span class="title"><em>• </em>违法行为类型：</span>
                        <span>${pubOtherpunishDto.illegActType}</span>
                    </li>
                    <li>
	                    <span class="title"><em>• </em>行政处罚内容：</span>
                        <span>${pubOtherpunishDto.penContent}</span>
                    </li>
                </ul>
            </div>
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>行政处罚决定书
                </h3>
                <div class="decision-con">
                ${pubOtherpunishDto.punDecDoc}
                <!-- 
                    <h3>____工商行政管理局</h3>
                    <div class="title-bar">
                        行政处罚决定书<br />
                        ____工商__字〔__〕__号
                    </div>
                    <p>
                        （一）当事人的姓名或者名称、地址等基本情况；<br />
                        （二）违反法律、法规或者规章的事实和证据；<br />
                        （三）行政处罚的内容和依据；<br />
                        （四）采纳当事人陈述、申辩的情况及理由；<br />
                        （五）行政处罚的履行方式和期限；<br />
                        （六）不服行政处罚决定，申请行政复议或者提起行政诉讼的途径和期限；<br />
                        （七）作出行政处罚决定的工商行政管理机关的名称、作出行政处罚决定的日期。
                    </p>
                     -->
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
</body>
</html>