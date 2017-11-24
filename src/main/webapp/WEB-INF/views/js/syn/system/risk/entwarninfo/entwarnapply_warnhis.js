require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {
	init();
	function init() {
        bind();
    }
    
    function bind() {
        util.bindEvents([
                         {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ]);
    }
    
})
