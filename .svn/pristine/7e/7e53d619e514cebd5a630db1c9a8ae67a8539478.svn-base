<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统首页页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<body>
    <div class="border-top9">
        <div class="mod header-se">
            <h2 class="mt33"><a href="#"><img src="/img/pub/zj-logo.png" alt=""></a></h2>
            <a href="javascript:void(0)" class="area-select locate-icon">导航<b class="pull-down-icon"></b></a>
            <div class="area-box">
                <p>国家企业信用信息公示系统</p>
                <p><span>华北</span><a href="">北京</a><a href="">天津</a><a href="">河北</a><a href="">山西</a><a href="">内蒙古</a></p>
                <p><span>东北</span><a href="">辽宁</a><a href="">吉林</a><a href="">黑龙江</a></p>
                <p><span>华东</span><a href="">上海</a><a href="">江苏</a><a href="">浙江</a><a href="">山东</a><a href="">安徽</a></p>
                <p><span>华南</span><a href="">广东</a><a href="">广西</a><a href="">海南</a><a href="">福建</a></p>
                <p><span>华中</span><a href="">湖北</a><a href="">湖南</a><a href="">河南</a><a href="">江西</a></p>
                <p><span>西南</span><a href="">四川</a><a href="">重庆</a><a href="">贵州</a><a href="">云南</a><a href="">西藏</a></p>
                <p><span>西北</span><a href="">陕西</a><a href="">甘肃</a><a href="">青海</a><a href="">宁夏</a><a href="">新疆</a></p>
            </div>
            <a href="#" class="local-pd collect-icon">地方频道</a>
        </div>
    </div>
    <div class="se-banner-bg">
        <div class="search-banner"></div>
        <div class="search-cont">
            <div class="select-tab"><a href="#" class="select">企业信用信息</a><a href="##">经营异常名录</a><a href="">严重违法失信企业名单</a></div>
            <div class="search-do">
                <form action="doGetEntSearchResult" method="get" id="form">
                    <input type="text" class="se-box" placeholder="请输入企业名称、注册号或统一社会信用代码" name="searchKeyWord">
                    <input type="button" value="" class="se-btn">
                </form>
            </div>
        </div>
    </div>

    <div class="border-bottom">
        <div class="mod se-other-nav">
            <ul class="clearfix">
                <li><a href="#"><i class="se-icon gs-info"></i><span>信息公示</span></a></li>
                <li><a href="#"><i class="se-icon se-compinfo"></i><span>企业信息填报</span></a></li>
                <li><a href="#"><i class="se-icon xwqy-info"></i><span>小微企业名录</span></a></li>
                <li><a href="#"><i class="se-icon part-app"></i><span>部门信息交换</span></a></li>
                <li><a href="#"><i class="se-icon use-help"></i><span>使用帮助</span></a></li>
            </ul>
        </div>

    </div>
    <jsp:include page="../../common/footer.jsp"></jsp:include>
    <script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
    <script src="<c:url value="/js/component/tab.js"/>"></script>
    <script src="<c:url value="/js/lib/laydate/laydate.js"/>"></script>
    <script>
        $('.area-select').on('click',function () {
            $('.area-box').toggle();
        })
        $(document).on('click',function (e) {
            if($(e.target).closest('.area-select').length==0&&$(e.target).closest('.area-box').length == 0){
                $('.area-box').hide();
            }
        })
        $(".se-btn").click(function(){
        	var searchKeyword = $(".se-box").val();
        	if(searchKeyword==""){
        		alert("企业名称或注册号不能为空!");
        	}else{
        		$("#form").submit();
        	}
        });
    </script>

</body>
</html>