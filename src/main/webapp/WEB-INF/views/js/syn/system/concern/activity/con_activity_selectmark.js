require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize'], function (layer, dataTable, util, http) {
	
	init();
	/**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }

	var json={};
    function confirm(){
    	var markNo=$("input[type='radio']:checked").val();
    	var markName=$("input[type='radio']:checked").attr("markName");
    	json.markNo=markNo;
    	json.markName=markName;
    }
    
    function bind() {
        util.bindEvents([{
            el: '#confirm',
            event: 'click',
            handler: function() {
            	confirm();
            	layer.close(json);
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
        },{
        	el:'.markRadio',
        	event:'click',
        	handler:function(){
        		$('.markTable').hide();
        		$('#'+$(this).val()).show();
        	}
        }])
    }
    
});