<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="enterprise-info-top">
    <div class="outer-blue-bg">
        <div class="mod enterprise-info-header">
            <ul class="enterprise-info-nav">
                <li class="bdlnone"><a href="#"><i class="icon-home"></i>首页</a></li>
                <li><a href="#"><i class="icon-reported"></i>企业信息填报</a></li>
                <li class="bdrnone"><a href="#"><i class="icon-notice"></i>信息公告</a></li>
                <li class="bdrnone"><a href="#"><i class="icon-help"></i>使用帮助</a></li>
            </ul>
            <a href="#" class="area-select search-style">导航</a>
            <div class="area-box search-box-style">
                <p>国家企业信用信息公示系统</p>
                <p><span>华北</span><a href="">北京</a><a href="">天津</a><a href="">河北</a><a href="">山西</a><a href="">内蒙古</a></p>
                <p><span>东北</span><a href="">辽宁</a><a href="">吉林</a><a href="">黑龙江</a></p>
                <p><span>华东</span><a href="">上海</a><a href="">江苏</a><a href="">浙江</a><a href="">山东</a><a href="">安徽</a></p>
                <p><span>华南</span><a href="">广东</a><a href="">广西</a><a href="">海南</a><a href="">福建</a></p>
                <p><span>华中</span><a href="">湖北</a><a href="">湖南</a><a href="">河南</a><a href="">江西</a></p>
                <p><span>西南</span><a href="">四川</a><a href="">重庆</a><a href="">贵州</a><a href="">云南</a><a href="">西藏</a></p>
                <p><span>西北</span><a href="">陕西</a><a href="">甘肃</a><a href="">青海</a><a href="">宁夏</a><a href="">新疆</a></p>
            </div>
        </div>
    </div>
    <div class="outer-white-bg">
        <div class="mod enterprise-info-search clearfix">
            <div class="logo"><a href="#"></a></div>
            <div class="search-content">
                <div class="select-tab">
                    <a href="#" class="select item-first">企业信用信息</a><a href="##">经营异常名录</a><a href="">严重违法失信企业名单</a>
                </div>
                <div class="search-do">
                    <form action="doGetEntSearchResult" method="get" id="form">
                        <input type="text" id="searchKeyWord" class="se-box" placeholder="请输入企业名称、统一社会信用代码或注册号" name="searchKeyWord">
                        <input type="button" value="" class="se-btn">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
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