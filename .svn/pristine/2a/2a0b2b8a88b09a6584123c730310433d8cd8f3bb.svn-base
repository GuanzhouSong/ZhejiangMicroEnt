<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="pd10">

<div>
    <div class="">
        <form class="form-horizontal" id="foodstoragebaseback-form">
            <input type="hidden" name="priPID" value="${foodstorageBaseDto.priPID}"/>
            <input type="hidden" name="id" value="${foodstorageBaseDto.id}"/>
            <input type="hidden" name="entName" value="${foodstorageBaseDto.entName}"/>
            <input type="hidden" name="year" value="${foodstorageBaseDto.year}"/>
            <input type="hidden" name="entTypeCatg" value="${foodstorageBaseDto.entTypeCatg}"/>
            <input type="hidden" name="regNO" value="${foodstorageBaseDto.regNO}"/>
            <input type="hidden" name="priPID" value="${foodstorageBaseDto.priPID }"/>
            <table class="table-horizontal">
                <tr>
                    <td width="20%" class="bg-gray right">统一代码/注册号</td>
                    <td width="40%">
                        <c:if test="${foodstorageBaseDto.uniSCID != null && foodstorageBaseDto.uniSCID != ''}">
                            ${foodstorageBaseDto.uniSCID}
                        </c:if>
                        <c:if test="${foodstorageBaseDto.uniSCID == null || foodstorageBaseDto.uniSCID == ''}">
                            ${foodstorageBaseDto.regNO }
                        </c:if>
                    </td>
                    <td width="20%" class="bg-gray right">提交日期</td>
                    <td>
                        <fmt:formatDate value="${foodstorageBaseDto.setTime }" pattern="yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right">企业名称</td>
                    <td colspan="3">
                        ${foodstorageBaseDto.entName }
                    </td>
                </tr>
                <tr>
                    <td class="bg-gray right"><span style="color: red;">*</span>退回原因</td>
                    <td colspan="3">
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt required" width="80%" name="backReason" id="backReason"/>
                        </div>
                    </td>
                </tr>
            </table>
            <div class="center mt10">
                <button id="save" type="submit" class="btn">保存</button>
                <button id="cancel" type="button" class="btn">取消</button>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/foodstorageback/baseback_edit_main.js"></script>
</body>
</html>