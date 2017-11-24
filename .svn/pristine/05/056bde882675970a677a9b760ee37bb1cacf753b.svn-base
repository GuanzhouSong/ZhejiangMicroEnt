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
    <title>抽查公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<style type="text/css">
.table-other td {
    border: 1px solid #edeeee;
    padding: 10px 5px;
    color: #666;
}
.checkcss {
    background-color: #eae3db;
    font-weight: bold;
    text-align: right;
    color: #87550F;
    text-align: center;
}
</style>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>抽查检查公告</h3>
        </div>
        <div class="mod-notice-bd" style="margin-top: 10px;padding-bottom: 10px;">
            <h1>${pubAnnounceMent.pubTitle}</h1><br>
            <input id="uid" type="hidden" value="${pubAnnounceMent.linkUID}"/>
            <input id="pubType" type="hidden" value="${pubAnnounceMent.pubType}"/>
            <table class="table-other" border="0" cellspacing="0" cellpadding="0" width="98%">
                        <thead>
                        <tr>
                            <td width="10%" class="checkcss" style="color:#87550F">序号</td>
                            <td width="20%" class="checkcss" style="color:#87550F">企业名称</td>
                            <td width="20%" class="checkcss" style="color:#87550F">统一社会信用代码/注册号</td>
                            <td width="15%" class="checkcss" style="color:#87550F">检查机关</td>
                            <td width="15%" class="checkcss" style="color:#87550F">检查时间</td>
                            <td width="20%" class="checkcss" style="color:#87550F">结果</td>
                        </tr>
	                     </thead>
                        <tbody id="pageList">
                        </tbody>
                     </table>
                     <div class="notice-pagination-box clearfix" style="padding-top: 20px">
                        <span class="page-total">共查询到<em id="info_total"></em>条信息，共<em id="info_pageNum"></em>页</span>
                        <div id="" class="pagination">

                        </div>
                    </div>
        </div>
    </div>
</div>
<script id="noticelist" type="text/x-handlebars-template">
    {{#each data}}
	 <tr>
        <td style="text-align: center;">{{xh @index}}</td>
        <td style="text-align: center;">{{entName}}</td>
        <td style="text-align: center;">{{regNO}}</td>
        <td style="text-align: center;">{{scDeptName}}</td>
        <td style="text-align: center;">{{inspectDeptTime}}</td>
        <td style="text-align: center;">{{scResult}}</td>
    </tr>
    {{/each}}
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/spotcheck_main.js"></script>
</body>
</html>