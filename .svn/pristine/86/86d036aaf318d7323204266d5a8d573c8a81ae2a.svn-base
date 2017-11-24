<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div>
    <div class="mt10">
        <form class="form-horizontal" id="pubExcludeEntForm">
            <input type="hidden" name="id" value="${pubExcludeEnt.id }"/>
            <input type="hidden" name="priPID" value="${priPID }"/>
            <div class="form-list mt10">
                <div class="form-item clearfix">
                <div class="col-12">
                    <label class="item-name col-3">限制来函部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="excDept" class="ipt-txt" value="${pubExcludeEnt.excDept }">
                        </div>
                    </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                <div class="col-12">
                    <label class="item-name col-3">限制公示理由：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="excRea" class="ipt-txt"
                                   value="${pubExcludeEnt.excRea }">
                        </div>
                    </div>
                </div></div>
                <div class="form-item clearfix">
                <div class="col-12">
                    <label class="item-name col-3">是否有效：</label>
                    <div class="col-9">
                        <div class="radio-box col-9">
                            <c:choose>
                                <c:when test="${pubExcludeEnt.isValid==0}">
                                    <input type="radio" name="isValid" value="1"> 是&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="isValid" value="0" checked="checked"> 否
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="isValid" value="1"
                                           checked="checked"> 是&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="isValid" value="0"> 否
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div></div>
                <div class="center mt10">
                    <button id="save" type="submit" class="btn mr20">提交</button>
                    <button id="cancel" type="button" class="btn">取消编辑</button>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/pubexcludeent/edit_main.js"></script>
</body>
</html>