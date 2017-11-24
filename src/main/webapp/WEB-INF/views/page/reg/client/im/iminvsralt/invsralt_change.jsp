<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>股权变更变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}<font>（登记机关：${midBaseInfoDto.regOrgName}）</font></h4>
        <p><em>统一社会信用代码：3300001006258 </em><em>注册号：3300001006258</em></p>
    </div>
</div>
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>股权变更信息
            <%--<a href="#">查看填报须知</a>--%>
        </h4>
        <div class="light-info">
            <span class="light">提示：企业有发生股东股权转让情况时请填写相应的股权变更信息。 </span>
            <i class="xbt-icon close"></i>
        </div>

        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            股东
                        </div>
                        <div class="item-txt">
                            <input type="text" name="" value="" class="ipt-txt ipt-txt-per">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">股权变更日期</div>
                        <div class="item-txt">
                            <input type="text" name="" value="" class="ipt-txt ipt-txt-per icon-date" readonly="" onclick="laydate()">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name">变更前股权比例</div>
                        <div class="item-txt">
                            <input type="text" name="" value="" class="ipt-txt ipt-txt-per"> %
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">变更后股权比例</div>
                        <div class="item-txt">
                            <input type="text" name="" value="" class="ipt-txt ipt-txt-per"> %
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <p class="btn"><input type="button" value="保存" class="btn-common"><input type="button" value="取消"  class="btn-common"></p>
    </div>
</div>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
</body>
</html>