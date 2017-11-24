require(['common/util','component/iframeLayer'], function (util,layer) {
	 //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        // menuInit();
        bind();
    }

    function bind(){
        util.bindEvents([{
            el: '.info',
            event: 'click',
            handler: function(){
                $(this).toggleClass('selected');
                $(this).next().slideToggle();
                $(this).parent('.list-item').siblings().find('.subnavbar').slideUp().prev().removeClass('selected');
            }
        },{
            el: '#js-user-logout',
            event: 'click',
            handler: function(){
                layer.confirm('是否确认退出?',{},function () {
                    location.href = '/depsyn/logout'
                })
            }
        }])
    }

    /**
     * 菜单状态
     */
    function menuInit(){
        var params = util.getUrlParams(location.href).menu;
        var menu = $('.subnavbar').find('a');
        for(var i = 0 ;i < menu.length;i ++){
            if(menu.eq(i).attr('href').indexOf(params) !== -1){
                menu.eq(i).addClass('selected');
                menu.eq(i).closest('.subnavbar').show();
                menu.eq(i).closest('.list-item').children('a').addClass('selected');
            }
        }
    }
})