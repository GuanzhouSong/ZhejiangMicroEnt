<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情年报信息页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<div class="mt20 mb20 clearfix">
    <div class="contact-mod mod">
        <div class="contact-mod-hd">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>分支机构信息
                    <span class="number" id="">共计3条信息</span>
                </h3>
                <!-- 分支机构信息 -->
                <div class="renyuan-list clearfix h-372">
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                    <div class="item item2">
                        <div class="title">泰康人寿保险股份有限公司江西分公司</div>
                        <p>· 统一社会信用代码/注册号：3600001229465</p>
                        <p>· 登记机关：江西省工商行政管理局</p>
                    </div>
                </div>
                <div class="load-more">
                    <span>加载更多</span>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function(){
        $('.load-more').on('click',function(){
            $('.renyuan-list').removeClass('h-372');
            $(this).hide();
        })
    })
</script>
</body>
</html>