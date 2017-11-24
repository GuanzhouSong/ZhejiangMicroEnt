<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可信息修改记录</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body>
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>行政许可变更信息
    </h3>
    <table class="table-common mb20">
        <thead>
        <tr>
            <th width="156">
                变更事项
            </th>
            <th width="310">
                变更时间
            </th>
            <th width="310">
                变更前内容
            </th>
            <th>
                变更后内容
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="pr">

            <tr>
                <td>
                        ${pr.altItemContent }
                </td>
                <td>
                    <fmt:formatDate value="${pr.altDate }" dateStyle="long"/>
                </td>
                <td>
                        ${pr.altBeContent }
                </td>
                <td>
                        ${pr.altAfContent }
                </td>
            </tr>

        </c:forEach>


        </tbody>
    </table>
</div>
</body>
</html>