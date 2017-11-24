require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPage',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'
], function (layer, util, http,handlebars,paginationPage) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {

        bind();
    }



    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.desc_show',// 网站或网店 查看详情
                event: 'click',
                handler: function () {

                    var webid = $(this).data("webid");
                    var webTypeKey = $(this).data("type");
                    var title = '';
                    var height = '';
                    if(webTypeKey == '1'){
                        title = '网站';
                        height = '55%';
                    }else if(webTypeKey == '2'){
                        title = '网店';
                        height = '45%';
                    }
                    layer.dialog({
                        title: title,
                        area: ['48%', height],
                        content: '/reg/server/yr/yrotherinfo_server/show?webid='+webid,
                        callback: function (data) {
                        }
                    });
                }
            }
        ])
    }
});
