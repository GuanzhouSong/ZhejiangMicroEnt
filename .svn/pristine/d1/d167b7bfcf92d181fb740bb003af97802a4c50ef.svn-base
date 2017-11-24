require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {

	//警示 协同的URL前缀
	var _sysUrl=window._CONFIG._sysUrl;
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
	            	data.url=_sysUrl+'/creditproveinfo/addmyent';
	            	layer.close(data);
	            }
	        }, {
	            el: '#man',
	            event: 'click',
	            handler: function() {
	            	var data=new Object();
	            	data.url=_sysUrl+'/creditproveinfo/addmyman';
	            	layer.close(data);
	            }
	        }])
	    }
	    
});