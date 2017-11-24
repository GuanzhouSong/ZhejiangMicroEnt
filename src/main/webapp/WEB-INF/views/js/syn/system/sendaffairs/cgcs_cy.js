require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','common/ajaxfileupload'], function (layer, dataTable, util, http,handlebars) {
	var _urlHead = window._CONFIG._urlHead;
	var copyFormNo = $("#copyFormNo").val();
	init();
	
	   function init() {
	        bind();
	    }
	   
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	save();
	            }
	        }, {
	            el: '#cancel',
	            event: 'click',
	            handler: function() {
	            	layer.msg("已返回！", {time: 1500}, function() {window.history.go(-1);});
	            }
	        }, {
	            el: '#print',
	            event: 'click',
	            handler: function() {
	            	window.open(_urlHead+"doEnPrint","_blank");
	            }
	        }
	        ])
	    }
})
