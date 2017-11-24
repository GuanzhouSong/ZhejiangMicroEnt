require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {

	var urlHead=window._CONFIG.urlHead;
	 init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
	        bind();
	    }
	    
	    
	    function bind() {
	        util.bindEvents([{
	            el: '#ent',
	            event: 'click',
	            handler: function() {
	            	var data=new Object();
	            	data.url=urlHead+'/noCreditPunish/info/addmyent';
	            	layer.close(data);
	            }
	        }, {
	            el: '#man',
	            event: 'click',
	            handler: function() {
	            	var data=new Object();
	            	data.url=urlHead+'/noCreditPunish/info/addmyman';
	            	layer.close(data);
	            }
	        }])
	    }
	    
});