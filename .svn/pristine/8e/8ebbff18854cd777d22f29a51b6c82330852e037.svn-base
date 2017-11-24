require(['component/iframeLayer', 'common/util', 'common/http', 'jquery','jquery.serialize'], function(layer, util, http) {
	init();
	/**
     * 初始化函数集合
     */
    function init() {
        bind(); 
    } 
	
	//事件绑定
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
        }
        ])
    }
    
});