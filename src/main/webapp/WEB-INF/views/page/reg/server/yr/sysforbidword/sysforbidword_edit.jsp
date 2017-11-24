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
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div>
    <div>
        <form class="form-horizontal" id="sysForbidwordForm">
            <input type="hidden" name="id" value="${sysForbidword.id }"/>
            <div class="form-list mt10">
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3">敏感词：</label>
                        <div class="col-9">
                            <div class="ipt-box col-9">
                                <input type="text" name="banLetter" class="ipt-txt" value="${sysForbidword.banLetter }">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3">说明(100字内)：</label>
                        <div class="col-9">
                            <div class="ipt-box col-9">
                                <textarea rows="4" name="banExp" cols="5" rows="5" maxlength="100">${sysForbidword.banExp }</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3">状态：</label>
                        <div class="col-9">
                            <div class="radio-box col-9">
                                <c:choose>
                                    <c:when test="${sysForbidword.isValid==0}">
                                        <input type="radio" name="isValid" value="1"> 有效&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="isValid" value="0" checked="checked"> 无效
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="isValid" value="1" checked="checked"> 有效&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" name="isValid" value="0"> 无效
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3">设置人：</label>
                        <div class="col-9">
                            <div class="ipt-box col-9">
                                <input type="text" name="setName" readonly="readonly" class="ipt-txt" value="${sysForbidword.setName }">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <div class="col-12">
                        <label class="item-name col-3">设置日期：</label>
                        <div class="col-9">
                            <div class="ipt-box col-3">
                                <input type="text" readonly="readonly" class="ipt-txt laydate-icon" name="setTime" value="<fmt:formatDate value='${sysForbidword.setTime }' pattern='yyyy-MM-dd hh:mm:ss'/>" />
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <div class="center mt10">
                    <button id="save" type="submit" class="btn mr20">提交</button>
                    <button id="cancel" type="button" class="btn">关闭</button>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/sysforbidword/edit_main.js"></script>
</body>
</html>