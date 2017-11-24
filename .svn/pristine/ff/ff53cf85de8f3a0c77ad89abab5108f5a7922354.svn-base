require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValidate();
        bind();
        
    }
    
    function formValidate(){
    	$('#hx-form').validate({
    		rules: { },
            showErrors:function(errorMap,errorList){},
            submitHandler: function () {
                var formParam = $('#hx-form').serializeObject();
                http.httpRequest({
                    url: '/syn/con/csconcernobj/dosaveconapplymark',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	layer.close({reload: true});
                        });
                    }
                });
            }
        });
    }
    
    
    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        },{
        	el:'.markRadio',
        	event:'click',
        	handler:function(){
        		$('.markTable').hide();
        		$('#'+$(this).val()).show();
        	}
        }
        ]);
    }
    
    
})
