require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'common/validateRules',
    'jquery.validate',
    'jquery.serialize',
    'component/backToTop',
    'component/report'
], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */

    function init() {
        bind();
    }




    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function () {
                //layer.close();
                alert("111");
            }
        }
        ])
    }

});