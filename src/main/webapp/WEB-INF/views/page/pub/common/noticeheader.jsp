<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="enterprise-info-top notice-info-top">
    <div class="outer-blue-bg mod1366">
        <div class="mod enterprise-info-header">
            <ul class="enterprise-info-nav">
                <li><a href="../../client/entsearch/toEntSearch"><i class="icon-home"></i>首页</a></li>
                <li><a href="http://118.178.33.191/login"><i class="icon-reported"></i>企业信息填报</a></li>
                <li><a href="../../pub/infobulletin/index"><i class="icon-notice"></i>信息公告</a></li>
                <li><a href="../../pub/infobulletin/help"><i class="icon-help"></i>使用帮助</a></li>
            </ul>
            <a href="#" class="area-select search-style">导航</a>
            <div class="area-box search-box-style">
                <p><a href="http://www.gsxt.gov.cn">国家企业信用信息公示系统</a></p>
                <p><span>华北</span><a href="http://bj.gsxt.gov.cn">北京</a><a href="http://tj.gsxt.gov.cn">天津</a><a href="http://he.gsxt.gov.cn">河北</a><a href="http://sx.gsxt.gov.cn">山西</a><a href="http://nm.gsxt.gov.cn">内蒙古</a>
                </p>
                <p><span>东北</span><a href="http://ln.gsxt.gov.cn">辽宁</a><a href="http://jl.gsxt.gov.cn">吉林</a><a href="http://hl.gsxt.gov.cn">黑龙江</a></p>
                <p><span>华东</span><a href="http://sh.gsxt.gov.cn">上海</a><a href="http://js.gsxt.gov.cn">江苏</a><a href="http://zj.gsxt.gov.cn">浙江</a><a href="http://sd.gsxt.gov.cn">山东</a><a href="http://ah.gsxt.gov.cn">安徽</a>
                </p>
                <p><span>华南</span><a href="http://gd.gsxt.gov.cn">广东</a><a href="http://gx.gsxt.gov.cn">广西</a><a href="http://hi.gsxt.gov.cn">海南</a><a href="http://fj.gsxt.gov.cn">福建</a></p>
                <p><span>华中</span><a href="http://hb.gsxt.gov.cn">湖北</a><a href="http://hn.gsxt.gov.cn">湖南</a><a href="http://ha.gsxt.gov.cn">河南</a><a href="http://jx.gsxt.gov.cn">江西</a></p>
                <p><span>西南</span><a href="http://sc.gsxt.gov.cn">四川</a><a href="http://cq.gsxt.gov.cn">重庆</a><a href="http://gz.gsxt.gov.cn">贵州</a><a href="http://yn.gsxt.gov.cn">云南</a><a href="http://xz.gsxt.gov.cn">西藏</a>
                </p>
                <p><span>西北</span><a href="http://sn.gsxt.gov.cn">陕西</a><a href="http://gs.gsxt.gov.cn">甘肃</a><a href="http://qh.gsxt.gov.cn">青海</a><a href="http://nx.gsxt.gov.cn">宁夏</a><a href="http://xj.gsxt.gov.cn">新疆</a>
                </p>
            </div>
        </div>
    </div>
    <div class="outer-white-bg mod1366">
        <div class="mod enterprise-info-search clearfix">
            <div class="logo"><a href="#"></a></div>
        </div>
    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(document).on('click',function (e) {
        if($(e.target).closest('.area-select').length==0&&$(e.target).closest('.area-box').length == 0){
            $('.area-box').hide();
        }else{
            $('.area-box').show();
        }
    })
</script>