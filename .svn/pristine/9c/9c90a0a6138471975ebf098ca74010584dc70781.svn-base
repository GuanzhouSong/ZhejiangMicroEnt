/**
 * Created by Administrator on 2016/11/9.
 */
define([ 'component/iframeLayer','jquery'], function (layer,$) {
    //用户退出登录
    $("#clientLogOut").click(function(){
        var url = $(this).data("url");
        layer.confirm('您确定退出吗?', { btn: ['确定', '取消'],icon: 7, title: '提示'}, function () {
            //replace 通过加载 URL 指定的文档来替换当前文档 ，这个方法是替换当前窗口页面，前后两个页面共用一个  窗口，所以是没有后退返回上一页的
            window.location.replace(url);
        });
    });

});






