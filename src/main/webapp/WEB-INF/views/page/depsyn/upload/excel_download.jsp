<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>批量导入</title>
    <link rel="stylesheet" href="/css/pub-syn.css">
</head>
<body class="outer-bg">
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="mod clearfix">
    <jsp:include page="../common/menu.jsp?module=zxlr&menu=pldr"></jsp:include>
    <div class="main">
        <div class="crumbs">
            <a href="javascript:void(0)">首页</a> &gt;
            <a href="javascript:void(0)">信息提供</a> &gt;
            <a href="javascript:void(0)" class="cur">批量导入</a>
        </div>
        <hr/>
        <div class="dr-box">
            <div class="dr-tab-hd">
                <ul class="clearfix dr-step02">
                    <li class="cur" style="width: 201px">
                        <a href="/depsyn/excel/template"><%--select--%></a>
                    </li>
                    <li style="width: 208px">
                        <a href=""><%--download--%></a>
                    </li>
                    <li style="width: 233px">
                        <a id="js-a-third" href=""><%--upload--%></a>
                    </li>
                </ul>
            </div>
            <div class="dr-tab-cont">
                <div class="item select-step02">
                    <div class="clearfix">
                        <div class="fl">
                            <img src="/img/pub-syn/load-xl-demo.jpg" alt="">
                        </div>
                        <div class="fr mb-right select-mb">
                            <h5>模板分为行政许可模板,行政处罚模板,选择您所需要的模板,【登记机关】,【企业名称】,【注册号】,【统一社会信用代码】后两个不能同时为空</h5>
                            <div class="active">
                                <img src="/img/pub-syn/load-xl-step02.jpg" alt="">
                        <span>
                            <c:if test="${type == 'license'}">
                                行政许可
                            </c:if>
                            <c:if test="${type == 'punish'}">
                                行政处罚
                            </c:if>
                            <c:if test="${type == 'spotcheck'}">
                                抽查检查结果
                            </c:if>
                            <c:if test="${type == 'compunish'}">
                                联合惩戒
                            </c:if>
                        </span>
                                <i class="icon-check"></i>
                            </div>
                            <p class="sel-btn center mt39">
                                <%--<input type="button" value="下载模板" id="js-download" data-type="${type}">--%>
                                <c:if test="${type == 'license'}">
                                    <a href="/template/xzxk.xls" id="js-download" data-type="${type}">下载模板</a>
                                </c:if>
                                <c:if test="${type == 'punish'}">
                                    <a href="/template/xzcf.xls" id="js-download" data-type="${type}">下载模板</a>
                                </c:if>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('#js-a-third').attr('href', '/depsyn/excel/confirm/' + $('#js-download').data('type'))

//        $('#js-download').click(function() {
//            var url = $('#js-url').val();
//            if(url != '') {
//                window.open(url);
//
//                var type = $(this).data('type');
//                window.location.href = '/depsyn/excel/confirm/' + type;
//            }
//        })
    })
</script>
</body>
</html>