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
<body>
<div class="container .container-fluid">
    <div class="" style="margin-top: 10px;">
        <form class="form-horizontal" id="sysLicenseForm">
            <input type="hidden" name="id" value="${sysLicense.id }"/>
            <div class="form-list mt10">
                <div class="form-item clearfix">
                    <label class="item-name col-3">许可事项名称：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="licName" class="ipt-txt"
                                   value="${sysLicense.licName }">
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">许可事项编号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="licNO" class="ipt-txt"
                                   value="${sysLicense.licNO }">
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">审批部门类型：</label>
                    <div class="col-9">
                        <div class="ipt-box col-4">
                            <select name="licDeptType">
                                <option value="1"
                                        <c:if test="${sysLicense.licDeptType==1 }">selected</c:if>
                                >审批部门类型1
                                </option>
                                <option value="2"
                                        <c:if test="${sysLicense.licDeptType==2 }">selected</c:if>
                                >审批部门类型2
                                </option>
                                <option value="3"
                                        <c:if test="${sysLicense.licDeptType==3 }">selected</c:if>
                                >审批部门类型3
                                </option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">审批部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="licDept" class="ipt-txt"
                                   value="${sysLicense.licDept }">
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">法律依据：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="licRea" class="ipt-txt"
                                   value="${sysLicense.licRea }">
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">级别：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="licZone" class="ipt-txt"
                                   value="${sysLicense.licZone }">
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">设置时间：</label>
                    <div class="col-9">
                        <div class="ipt-box col-575">
                            <input type="text" class="ipt-txt laydate-icon"
                                   onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
                                   name="setTime" readonly="readonly"
                                   value="<fmt:formatDate value='${sysLicense.setTime }' pattern='yyyy-MM-dd hh:mm:ss'/>"/>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">前置/后置：</label>
                    <div class="col-9">
                        <div class="radio-box col-9">
                            <c:choose>
                                <c:when test="${sysLicense.licType==1}">
                                    <input type="radio" name="licType" value="1"
                                           checked="checked"> 前置&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="licType" value="2"> 后置
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="licType"
                                           value="1"> 前置&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="licType" value="2"
                                           checked="checked"> 后置
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="form-item clearfix">
                    <label class="item-name col-3">是否有效：</label>
                    <div class="col-9">
                        <div class="radio-box col-9">
                            <c:choose>
                                <c:when test="${sysForbidword.isValid==0}">
                                    <input type="radio" name="isValid"
                                           value="1"> 是&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="isValid" value="0"
                                           checked="checked"> 否
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="isValid" value="1"
                                           checked="checked"> 是&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="isValid" value="0"> 否
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
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
<script src="/js/reg/server/yr/syslicense/edit_main.js"></script>
</body>
</html>