<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>认领页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<script type="text/javascript">
</script>
<body class="pd10">
<p>已选择企业数共<span class="light">${entsize}</span>家</p>

    <input id="priPID" type="hidden" name="priPID" value="${registInfoDto.priPID}"/>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right" width="10%">群发企业</td>
        <td colspan="5" valign="top" class="pd0">
            <table cellspacing="0" cellpadding="0" border="0" width="100%" class="inner-table">
                <thead>
                <tr>
                    <th>企业名称</th>
                    <th width="30%">法定代表人（负责人）手机号码</th>
                    <th width="30%" class="last-col">企业联络员手机号码</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="p" items="${masslist}">
                    <tr>
                        <td>${p.entname}</td>
                        <td>${p.tel}</td>
                        <td class="last-col">${p.liatel}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </td>
    </tr>

    <input type="hidden"  name="entname" value="${entname}"/>
    <input type="hidden"id="tel" name="tel" value="${tel}"/>
    <input type="hidden" id="liatel"name="liatel" value="${liatel}"/>
    <input type="hidden" id="regorg"name="regorg" value="${regorg}"/>
    <tr>
        <td class="bg-gray right" width="10%"><span class="light">*</span>发送内容<br/>(限100字内)</td>
        <td colspan="5">
            <div class="ipt-box">
                <textarea name="smscontent" id="smscontent" rows="4" maxlength="100"  ></textarea>
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right"><span class="light">*</span>发送对象</td>
        <td colspan="5">
            <div class="radio-box">
                <input type="checkbox" name="send" value="0"  />法定代表人（负责人）
                <input type="checkbox" name="send" value="1"  />企业联络员
            </div>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right" width="10%">发送人</td>
        <td width="20%">${uname}</td>
        <input type="hidden" name="uname" value="${uname}"/>
        <td class="bg-gray right" width="10%">发送日期</td>
        <td width="20%"><fmt:formatDate value="${now}" type="both"/></td>
        <input type="hidden" name="sdate" value="<fmt:formatDate value="${now}" type="both"/>"/>
        <td class="bg-gray right" width="10%">发送部门</td>
        <input type="hidden" name="dept" value="${dept}"/>
        <td>${dept}</td>
    </tr>
    </tbody>
</table>
    <div class="center mt20">
        <input id="save" type="button" class="btn mr20" value="保 存">
        <input id="cancel" type="button" class="btn mr20" value="取 消">
    </div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/masssms/masssms_edit.js"></script>
</body>
</html>