require(['component/iframeLayer',
    'common/util','common/http','handlebars', 'jquery', 'common/validateRules', 'metisMenu', 'contabs', 'jquery.layout','jquery.nanoscroller'], function (layer, util,http,handlebars) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        layoutInit();
        initMenu();
        bind();
        calcHeight();
        $(".nano").nanoScroller();
    }
    var viewTemplate = handlebars.compile($('#tpl').html());

    /**
     * 页面布局初始化
     */
    function layoutInit() {
        $('#container').layout({
            west: {
                size: '180'
            },
            north: {
                spacing_open: 0
            },
            togglerContent_open: '<div class="ui-icon"></div>',
            togglerContent_closed: '<div class="ui-icon"></div>'
        });
    }

    /**
     * 初始化菜单
     */
    function initMenu() {
        $('#side-menu').metisMenu();
    }

    /**
     * 计算iframe主体高度
     */
    function setHeight() {
        var h = $(window).height();
        $('.J_mainContent').css('height', h - $('.J_mainContent').offset().top - 40 + 'px');
    }
    function calcHeight() {
        setHeight();
        window.onresize = function () {
            setHeight();
            setTimeout(function(){
                $(".nano").nanoScroller();
            },500);

        };
    }

    var el = $('.js-new-info-list');
    var len = el.find('li').length;
    var i = 0;
    var height = el.find('li').height();

    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        }, {
            el: '.logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        },
            {
                el: '.js-tips-close',
                event: 'click',
                handler: function () {
                    $(this).closest('.js-tips-box').fadeOut('1000',function(){
                        setHeight();
                    });
                }
            }, {
                el: '.js-tips-last',
                event: 'click',
                handler: function () {
                    if (i == 0) {
                        i = len - 1;
                    } else {
                        i--;
                    }
                    el.stop().animate({
                        top: -i * height + 'px'
                    }, 500);
                }
            }, {
                el: '.js-tips-next',
                event: 'click',
                handler: function () {
                    if (i == len - 1) {
                        i = 0;
                    } else {
                        i++;
                    }
                    el.stop().animate({
                        top: -i * height + 'px'
                    }, 500);
                }
            }, {
                el: '.js-closeAll-tab',
                event: 'click',
                handler: function () {
                    $('.J_menuTabs .J_menuTab:first').addClass('active');
                    $('.J_mainContent .J_iframe:first').show();
                    $('.J_menuTabs .J_menuTab:not(:first)').remove();
                    $('.J_mainContent .J_iframe:not(:first)').remove();
                }
            },
            //{
            //    el: '#myAccount',
            //    event: 'click',
            //    handler: function () {
            //    }
            //},
            //{
            //    el: '#myPermission',
            //    event: 'click',
            //    handler: function () {
            //    }
            //},
            {
                el: '#passwordM',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '修改密码',
                        area: ['628px', '500px'],
                        content: '/reg/server/sysuser/editPsw',
                        callback: function (data) {
                            if(data['status']=='success'){
                                location.assign('/syn/logout');
                            }
                        }
                    })
                }
            },
            {
                el: '#searchEnt',
                event: 'click',
                handler: function () {
                    console.log($(".J_iframe"));
                    $(".J_iframe").attr("src",'/syn/panoramasearch/doenappsearch');
                    //location.assign('/syn/panoramasearch/doenappsearch');
                }
            },
            {
                el: '.js-search-input',
                event: 'keyup',
                handler: function () {
                    getSearchList();
                }
            },
            {
                el: '.js-search-btn',
                event: 'click',
                handler: function () {
                    getSearchList();
                }
            },
            {
                el: '.js-search-result-list li',
                event: 'click',
                handler: function () {
                    $('.js-search-input').val($(this).text());
                    $('.js-search-result-list').hide();
                    var index = $(this).attr('data-index');
                    var selector = $('#side-menu a[data-index="' + index + '"]');
                    if (selector.closest('.nav-third-level').length) {
                        selector.closest('.nav-third-level').siblings('a').trigger('click');
                    }
                    selector.closest('.list-item').children('a').trigger('click');
                    selector.addClass('cur');
                }
            },
            {
                el: document,
                event: 'click',
                handler: function(e){
                    if(!$(e.target).closest('.search-box-panel').length){
                        $('.js-search-result-list').hide();
                    }
                }
            },{
                el: document,
                event: 'keydown',
                handler: function(e){
                    if (!$('.js-search-result-list li').length)return;
                    $('.js-search-result-list li').removeClass('cur');
                    var len = $('.js-search-result-list li').length;
                    if (e.keyCode == 38) {
                        $('.js-search-input').blur();
                        $('.js-search-input').val($('.js-search-result-list li').eq(resultIndex).text());
                        resultIndex--;
                        if (resultIndex < 0) {
                            resultIndex = 0;
                        }
                    }
                    if (e.keyCode == 40) {
                        $('.js-search-input').blur();
                        $('.js-search-input').val($('.js-search-result-list li').eq(resultIndex).text());
                        resultIndex++;
                        if (resultIndex > len - 1) {
                            resultIndex = len - 1;
                        }
                    }

                    if (e.keyCode == 13) {//回车键
                        $('.js-search-input').blur();
                        $('.js-search-input').val($('.js-search-result-list li').eq(resultIndex).text());
                        $('.js-search-result-list li').eq(resultIndex).trigger('click');
                    }
                    $('.js-search-result-list li').eq(resultIndex).addClass('cur');

                }
            }
        ]);

        var resultIndex = -1;
        $('.js-search-result-list').on('mouseenter','li',function(){
            $('.js-search-result-list li').removeClass('cur');
            $(this).addClass('cur');
            resultIndex = $(this).index();
        });
    }

    /**
     * 获取搜索的菜单数据
     */
    function getSearchList() {
        var txt=$("#key-word").val();
        if(txt==""){
            //$("#side-menu").show();
            $("#rltMenuItem").hide();
            return;
        }
        http.httpRequest({
            type:'get',
            url: '/reg/server/syspermision/searchMenu',
            data: {keyWord:$("#key-word").val()},
            success: function(data){
                //$("#side-menu").hide();
                $("#rltMenuItem").show();
                if (data.status == 'success') {
                    var context=new Object();
                    context["menus"]=data.data;
                    $('#rltMenuItem').html(viewTemplate(context));
                }
            }
        })
    }

    function logOut() {
        layer.confirm('确定要退出登录吗?', {icon: 2, title: '提示'}, function () {
            location.assign('/syn/logout');
        });
    }
})