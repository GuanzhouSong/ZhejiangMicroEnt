+function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], factory);
    } else {
        factory($);
    }
}(function ($) {
    'use strict';
    // 返回顶部页面元素
    var backToTop = '<p id="back-to-top"><a href="javascript:void(0)"><em>返回<br />导航</em></a></p>';

    //返回顶部初始化
    initBackToTop({
        domId: "back-to-top",
        showDistance: 100,
        fadeTime: 300,
        scrollTime: 200
    });

    /**
     * 返回顶部统一添加
     * @param opt
     */
    function initBackToTop(opt) {
        try {
            $("body").append(backToTop);
            opt.showDistance = opt.showDistance || 100;
            opt.fadeTime = opt.fadeTime || 300;
            opt.scrollTime = opt.scrollTime || 200;

            $(window).scroll(function () {
                if ($(window).scrollTop() > opt.showDistance) {
                    $("#" + opt.domId).fadeIn(opt.fadeTime);
                }
                else {
                    $("#" + opt.domId).fadeOut(opt.fadeTime);
                }
            });
            //绑定点击事件
            $("#" + opt.domId).click(function () {
                $('body,html').animate({scrollTop: 0}, opt.scrollTime);
                return false;
            });
        } catch (e) {

        }
    }
});