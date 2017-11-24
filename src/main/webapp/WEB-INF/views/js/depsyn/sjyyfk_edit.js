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
    		rules: {
    			realNum:{required:true},
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
           	 for(var i in errorMap){
                 layer.tips(errorMap[i],$('#hxForm input[name='+i+'],textarea[name='+i+']'),{
                     tips:3,
                     tipsMore:true,
                     ltype:0
                 });
              }
            },
            submitHandler: function () {
                var formParam = $('#hxForm').serializeObject();
                http.httpRequest({
                    url: '/depsyn/savedata',
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
