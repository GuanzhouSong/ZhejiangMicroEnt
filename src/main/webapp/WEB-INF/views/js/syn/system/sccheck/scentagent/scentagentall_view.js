require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
    /**
	 * 初始化函数集合
	 */
    function init() { 
        bind();
       
    }
   
    function bind() {
    	util.bindEvents([{
            el: '#reRandom',
            event: 'click',
            handler: function () {
            	layer.close({rerandom:true});
            }
            	
        },{
            el: '#lock',
            event: 'click',
            handler: function () {
            	var deptTaskUid= $("#deptTaskUid").val();
            	layer.confirm('锁定后企业和执法人员随即匹配结果将不可修改，您确定要继续吗？', {icon: 2, title: '提示'}, function (index) {
	    			http.httpRequest({
	    				url: window._CONFIG.chooseUrl+'/pub/server/sccheck/entagent/lockagent',
	    				serializable: false, 
	    				data: {deptTaskUid:deptTaskUid},
	    				type:"post",
	    				success: function (data) {
	    					layer.msg(data.msg, {time: 1000}, function () {
	    						if(data.status == 'success'){
	    							layer.close({reload:true});
	    						}
	    						layer.close(index);
	    					});
	    				}
	    			});
            	});
            }
        }]);
    }
});
