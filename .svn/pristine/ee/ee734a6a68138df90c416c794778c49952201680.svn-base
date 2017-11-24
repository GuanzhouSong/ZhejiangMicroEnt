<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <ul class="clearfix dr-step01">
                    <li class="cur" style="width: 201px">
                        <a href="/depsyn/excel/template"><%--select--%></a>
                    </li>
                    <li style="width: 208px">
                        <a href="/depsyn/excel/download/license"><%--download--%></a>
                    </li>
                    <li style="width: 233px">
                        <a href="/depsyn/excel/confirm/license"><%--upload--%></a>
                    </li>
                </ul>
            </div>
            <div class="dr-tab-cont">
                <div class="item select-step01">
                    <h5>模板分为行政许可模板,行政处罚模板,选择您所需要的模板,【登记机关】,【企业名称】,【注册号】,【统一社会信用代码】后两个不能同时为空</h5>
                    <dl class="select-mb clearfix">
                        <dd class="active" data-type="license">
                            <img src="/img/pub-syn/load-xl.jpg" alt="">
                        <span>
                            行政许可
                        </span>
                            <i class="icon-check"></i>
                        </dd>
                        <dd data-type="punish">
                            <img src="/img/pub-syn/load-xl.jpg" alt="">
                        <span>
                            行政处罚
                        </span>
                            <i class="icon-check"></i>
                        </dd>
                        <dd data-type="spotcheck">
                            <img src="/img/pub-syn/load-xl.jpg" alt="">
                        <span>
                            抽查检查结果
                        </span>
                            <i class="icon-check"></i>
                        </dd>
                        <dd data-type="compunish">
                            <img src="/img/pub-syn/load-xl.jpg" alt="">
                        <span>
                            联合惩戒
                        </span>
                            <i class="icon-check"></i>
                        </dd>
                    </dl>
                    <p class="sel-btn center mt44">
                        <input type="button" value="确定" style="margin-right: 16px" id="js-confirm"><input type="button" value="重置" id="js-reset">
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {

        $('.select-mb dd').click(function () {
            $(this).addClass('active').siblings().removeClass('active');

            $('.dr-step01 li a').each(function (index) {
                if(index != 0) {
                    var url = $(this).attr('href');
                    $(this).attr('href', url.substr(0, url.lastIndexOf('/')) + '/' + $('.active').data('type'))
                }
            });
        });

        $("#js-confirm").click(function () {
            var type = $('.active').data('type');
            window.location.href = '/depsyn/excel/download/' + type;
        });

        $("#js-reset").click(function() {
            $('.select-mb dd:first').click();
        });
    })
</script>
</body>
</html>