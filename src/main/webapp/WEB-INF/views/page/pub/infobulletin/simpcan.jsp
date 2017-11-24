<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>简易注销公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>简易注销公告</h3>
        </div>
        <div class="mod-notice-bd" style="padding: 40px;">
            <h1 class="h1-notice12">${erEscAppinfo.entName}简易注销公告信息</h1>
            <h3 class="i-title mt20" style="color: #804000;">
                <i></i>企业公告信息
            </h3>
            <input type="hidden" id="penType" value=" ${pubOtherpunish.penType}">
            <table class="table-horizontal table-notice12" border="0" cellspacing="0" cellpadding="0" width="100%">
                <tr>
                    <td width="30%" class="ftd">企业名称</td>
                    <td>
                    ${erEscAppinfo.entName}
                    </td>
                </tr>
                <tr>
                    <td class="ftd">统一社会信用代码/注册号</td>
                    <td>
                     ${empty erEscAppinfo.uniSCID?erEscAppinfo.regNO:erEscAppinfo.uniSCID}
                    </td>
                </tr>
                <tr>
                    <td class="ftd">登记机关</td>
                    <td>
                     ${erEscAppinfo.regOrgName}
                    </td>
                </tr>
                <tr>
                    <td class="ftd">公告期</td>
                    <td class="light-red">
                        <strong>
	                        <fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年-MM月-dd日" />&nbsp;-&nbsp;<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年-MM月-dd日" />
                        </strong>
                    </td>
                </tr>
                <tr>
                    <td class="ftd">全体投资人承诺书</td>
                    <td>
                       <a  href="/pub/infobulletin/view?priPID=${erEscAppinfo.priPID}" target="_blank">查看详情</a>
                    </td>
                </tr>
                <tr>
                    <td class="ftd">备注</td>
                    <td class="light-red">
                        <strong>如需对该企业简易注销公告提出异议，查看该企业简易注销被提出的异议信息、
                        简易注销结果等详细信息，请到公示系统首页查询。</strong>
                    </td>
                </tr>
            </table>
            <br>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>