<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>双告知-照面信息</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="plr20 mt20">
  <div class="encounter-layer">
            <h3 class="i-title">
                <i></i>照面信息
            </h3>
            <ul class="encounter-info clearfix">
                <li>
                    <span class="title right qyzc-info"><em>• </em>统一社会信用代码/注册号：</span>
                    <span>${midBaseInfo.uniCode == null ? midBaseInfo.regNO : midBaseInfo.uniCode}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>企业名称：</span>
                    <span>${midBaseInfo.entName}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>类型：</span>
                    <span>${midBaseInfo.entTypeName}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>法定代表人：</span>
                    <span>${midBaseInfo.leRep}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>注册资本：</span>
                    <span><fmt:formatNumber value="${midBaseInfo.regCap}" pattern="###,###,###,##0.0000"/>万元人民币</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>成立日期：</span>
                    <span><fmt:formatDate value="${midBaseInfo.estDate}" pattern="yyyy年MM月dd日"/></span>
                </li>
                <li>
	                    <span class="title right qyzc-info">
							<em>• </em>营业期限自：
                        </span>
                    <span><fmt:formatDate value="${midBaseInfo.opFrom}" pattern="yyyy年MM月dd日"/></span>
                </li>
                <li>
	                    <span class="title right qyzc-info">
							<em>• </em>营业期限至：
                        </span>
                    <span><fmt:formatDate value="${midBaseInfo.opTo}" pattern="yyyy年MM月dd日"/></span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>登记机关：</span>
                    <span>${midBaseInfo.regOrgName}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>核准日期：</span>
                    <span><fmt:formatDate value="${midBaseInfo.apprDate}" pattern="yyyy年MM月dd日"/></span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>住所：</span>
                    <span>${midBaseInfo.dom}</span>
                </li>
                <li>
                    <span class="title right qyzc-info"><em>• </em>登记状态：</span>
                    <span>${midBaseInfo.regState}</span>
                </li>
                <li class="width-per100">
                    <span class="title right qyzc-info"><em>• </em>经营范围：</span>
                    <span>${midBaseInfo.opScope}</span>
                </li>
            </ul>
        </div>
</body>
</html>