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
    <title>登记备案信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>


<div class="mod detail-main mt20">
    <div class="tab-panel">
        <!-- 营业执照信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>商标详细信息
            </h3>
            <ul class="encounter-info clearfix pdb160">
<%--                 <c:if test="${fn:indexOf('11,21,13', entBasicInfo.entTypeCatg)!=-1}"> --%>
                    <li>
                        <span class="title"><em>• </em>商标注册号</span>
	                    <span>${tmDetailInfoDto.REG_NUM }</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>注册公告日期：</span>
                        <span><fmt:formatDate value="${tmDetailInfoDto.REG_ANNC_DATE}" pattern="yyyy年MM月dd日"/></span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>类别：</span>
                        <span>第${tmDetailInfoDto.INT_CLS }类</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>注册公告期号：</span>
                        <span>${tmDetailInfoDto.REG_ANNC_ISSUE }</span>
                    </li>
                    <li>
                        <span class="title"><em>• </em>商标专用权起止日期：</span>
                        <span><fmt:formatDate value="${tmDetailInfoDto.PROPERTY_BGN_DATE}" pattern="yyyy年MM月dd日"/>至<fmt:formatDate value="${tmDetailInfoDto.PROPERTY_END_DATE}" pattern="yyyy年MM月dd日"/></span>
                    </li>

                    <li>

                    </li>
                    <li>
                        <span class="title fl"><em>• </em>商标图样：</span>
                        <span class="fl">
                            <img src="data:image/png;base64,${tmDetailInfoDto.imageString}" alt="" width="287px">
                        </span>
                    </li>
                    <li>
                        <span class="title fl"><em>• </em>商品/服务项目：</span>
                        <span class="brand-item fl">
                             <c:forEach items="${goodsList}" var="goods" varStatus="status">
                                 <b>${goods.similar_code}——   ${goods.goods_cn_name}</b>
		                 	  </c:forEach>
                        </span>
                    </li>
<%--                 </c:if> --%>
            </ul>
        </div>
    </div>
</div>

<script>
    //参数的传递
//     window._CONFIG = {
//         repType: '${imReportType}',

//     }
</script>
<jsp:include page="../../common/footer.jsp"></jsp:include>

</body>
</html>