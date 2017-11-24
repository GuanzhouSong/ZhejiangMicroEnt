require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'laydate',
    'component/report',
    'jquery.placeholder',
    'jquery.icinfo'

], function (layer, util, http,handlebars) {
    init();

    function init() {
        bind();
    }

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '.btn-common',  //法定代表人不是党员的时候触发
                event: 'click',
                handler: function () {
                	layer.close();
                }
            }
        ])
    }
});
