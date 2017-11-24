<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>在线录入</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=zxlr&menu=zxlr"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="<c:url value='/depsyn/index'/>">信息提供</a> &gt;
            <a href="javascript:void(0)" class="cur">在线录入</a>
        </div>
        <div class="pdlr5">
            <div class="tab">
                <li><a href="<c:url value='/depsyn/punish/index'/>">行政处罚信息</a></li>
                <li><a href="<c:url value='/depsyn/license/index'/>">行政许可信息</a></li>
                <li><a href="<c:url value='/depsyn/spot/index'/>">抽查检查结果</a></li>
                <li><a href="<c:url value='/depsyn/small/index'/>">小微企业扶持信息</a></li>
                <li><a href="<c:url value='/depsyn/compun/index'/>">联合惩戒信息</a></li>
                <li><a href="<c:url value='/depsyn/notice/index'/>" class="cur">部门公告</a></li>
            </div>
            <div class="panel-bd">
                <form id="js-form">
                    <div class="tips">正在填报：部门公告</div>
                    <table cellpadding="0" cellspacing="0" class="table-common mb10">
                        <tbody>
                        <tr>
                            <td width="150" class="bg-gray">标题</td>
                            <td><input type="text" placeholder="请输入标题" name="title" class="ipt-txt-w100 js-save-data" required></td>
                        </tr>
                        <tr>
                            <td class="bg-gray">正文</td>
                            <td>
                                <textarea placeholder="请输入正文" name="content" class="textarea-txt-w100 js-save-data" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="bg-gray">附件(仅PDF)</td>
                            <td class="left" style="padding-left: 8px;">
                                <input type="button" value="点击上传附件" class="ipt-btn js-ipt-btn">
                                <input id="file" type="file" class="ipt-btn js-save-data none" name="file" required>
                                <input type="text" id="js-pdf-file" style="width: 70%;" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td class="bg-gray">发布部门</td>
                            <td class="left"><input type="text" name="department" class="ipt-txt-w100 js-save-data" required></td>
                        </tr>
                        <tr>
                            <td class="bg-gray">发布机关</td>
                            <td class="left"><input type="text" name="relAuth" class="ipt-txt-w100 js-save-data" required></td>
                        </tr>
                        <tr>
                            <td class="bg-gray">发布时间</td>
                            <td class="left"><input type="text" name="relDate" readonly value="<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>" class="ipt-txt-w100 js-save-data js-relDate-date"></td>
                        </tr>
                        <tr>
                            <td class="bg-gray">部门所在省份</td>
                            <td class="left"><input type="text" name="relPro" value="浙江省" class="ipt-txt-w100 js-save-data" required></td>
                        </tr>
                        </tbody>
                    </table>
                    <input id="js-add" type="submit" value="提交" class="ipt-btn fr mr20 mb3">
                    <input id="js-reset" type="reset" class="none">
                </form>
                <div class="table-title">成功发布的列表</div>
                <table cellpadding="0" cellspacing="0" class="table-common">
                    <thead>
                    <tr>
                        <th width="70">序号</th>
                        <th width="224">标题名称</th>
                        <th width="122">发布部门</th>
                        <th width="186">发布机关</th>
                        <th width="175">发布时间</th>
                        <th>部门所在省份</th>
                    </tr>
                    </thead>
                    <tbody id="js-list-content">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                    <span class="page-total">共查询到
                        <em id="js-total"></em> 条信息，共
                        <em id="js-pageTotal"></em> 页
                    </span>
                    <div class="pagination">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script id="listTemplate" type="text/x-handlebars-template">
    {{#each data}}
    <tr>
        <td>{{id}}</td>
        <td>{{title}}</td>
        <td>{{department}}</td>
        <td>{{relAuth}}</td>
        <td>{{relDate}}</td>
        <td>{{relPro}}</td>
    </tr>
    {{/each}}
</script>
<script src="/js/depsyn/notice/notice_main.js"></script>
</body>
</html>