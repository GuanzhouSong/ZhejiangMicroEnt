require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate'],
function(layer, dataTable, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//初始化
    	initData();
        bind();
        formValid(); 
    }
    
    
    function formValid(){
    	
    }
    
    function initData(){
        //将页面中财务相关输入框中，值为空的，设置默认值0
		$(".moneyJudge").each(function() {
	        var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
	        if(v != "" && v != null){
	        	$(this).val(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(2));
	        }
	   });
    }
    
    function bind() {
        util.bindEvents([
        {
            el: '#close',
            event: 'click',
            handler: function() {
            	layer.close();
             }
        }])
    }

})