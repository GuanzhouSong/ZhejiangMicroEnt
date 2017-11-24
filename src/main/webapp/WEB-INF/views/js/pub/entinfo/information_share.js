require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'qrcode',
    'common/validateRules',
    'jquery.serialize'
], function (layer, util, http,handlebars) {
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
                el: '.js-share-info', //信息分享
                event: 'click',
                handler: function () {
                    $("#_report-layer").show();
                    layer.dialog({
                        title: ['信息分享','color:#fff;background:#d5b661;font-size:16px;'],
                        shadeClose: false, //是否点击遮罩关闭
                        closeBtn: 1,      //显示小叉按钮
                        content: $('#_report-layer'),
                        type: 1,         //显示页面
                        area: ['320','130'] //高度和宽度
                    });

                }
            }
        ])
    }
});


