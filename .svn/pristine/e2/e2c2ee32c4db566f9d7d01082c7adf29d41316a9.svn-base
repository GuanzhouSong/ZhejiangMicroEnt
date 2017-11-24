require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','common/validateRules'], function (layer, dataTable, util, http,handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValidate();
    }
    
    function formValidate(){
    	$('#hxForm').validate({
            submitHandler: function () {
                var formParam = $('#hxForm').serializeObject();
                http.httpRequest({
                    url: '/depsyn/editpunish',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status=='success'){
                        		layer.close({flag:true});
                        	}
                        });
                    }
                });
            }
        });
    }
    
    
    function bind() {
        util.bindEvents([{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
        ]);
    }
    
    
})
