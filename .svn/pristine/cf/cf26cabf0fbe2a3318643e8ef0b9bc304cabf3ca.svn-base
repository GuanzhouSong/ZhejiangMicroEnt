<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/reg.client.css">
</head>
<body>
<!-- <div class="mod header"> -->
<!--     <a href="##" target="_blank"> -->
<!--         <img src="/img/reg/client/reg-c-logo.jpg" alt=""> -->
<!--     </a> -->
<!-- </div> -->
<!-- <div class="bg-blue"> -->
<!--     <div class="mod clearfix gssb-nav"> -->
<!--         <h3 class="h22-title fl">通知公告</h3> -->
<!--         <div class="fr"> -->
<%--             <a href="<c:url value="/reg/client/login/bulletins/list"/>" class="back">返回列表>></a> --%>
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->
<div class="mt20">
    <div class="mod mod-tb-notice-detail">
        <div class="mod-bd">
            <div class="content">
                <div class="hd center">
                    <h3>${Bulletins.title }</h3>
                    <p><span class="mr40">来源：${Bulletins.setDeptname }</span><span class="mr40">发布时间：<fmt:formatDate value="${Bulletins.setTime }" pattern="yyyy-MM-dd"/>
                    </p>
                </div>
                <div class="bd">
<!--                     <div class="clearfix"> -->
<!--                         <ul class="js-font-reset adjust-font-size mb10 mt5 fr"> -->
<!--                             <li class="tip">字体：</li> -->
<!--                             <li class="active" data-font="0">小</li> -->
<!--                             <li data-font="1">中</li> -->
<!--                             <li data-font="2">大</li> -->
<!--                         </ul> -->
<!--                     </div> -->
                    <div class="bd-cont" id="content">
                     <p id="content">${Bulletins.contents }</p>
                    </div>
                </div>
                <div class="fd">
                    发布人：${Bulletins.setName }
                </div>
            </div>
        </div>
    </div>
</div>
<%-- <jsp:include page="../common/footer.jsp"></jsp:include> --%>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $('.js-font-reset').on('click', 'li', function () {
        $(this).addClass('active').siblings().removeClass('active');
        var ele = $('.bd-cont');
        var font = $(this).data('font');
        if (font == 0) {
            ele.removeClass('middleFont').removeClass('bigFont').addClass('smallFont');
        }
        else if (font == 1) {
            ele.removeClass('smallFont').removeClass('bigFont').addClass('middleFont');
        }
        if (font == 2) {
            ele.removeClass('smallFont').removeClass('middleFont').addClass('bigFont');
        }
    })
</script>
</body>
</html>