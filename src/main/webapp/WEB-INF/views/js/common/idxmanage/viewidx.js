require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery',
         'jquery.serialize','laydate','common/validateRules'],
         function (layer, dataTable, util, http,handlebars) {
	
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
    		rules: {
    			priPID:{required:true}
    		},
    		onkeyup:false,
            showErrors:function(errorMap,errorList){
            	 for(var i in errorMap){
                     layer.tips(errorMap[i],$('#hx-form input[name='+i+'],textarea[name='+i+']'),{
                         tips:3,
                         tipsMore:true,
                         ltype:0
                     });
                 }
            },
            submitHandler: function () {
                var formParam = $('#warnForm').serializeObject();
                http.httpRequest({
                    url: '/esmanage/selectIdxInfo',
                    serializable: true,
                    data: $("#hx-form").serializeObject(),
                    type: 'post',
                    success: function (data) {
                    	$("#area").html(data.msg);
//                        layer.msg(data.msg, {time: 1500}, function () {
//                        	if(data.status=='success'){
//                        		window.location.reload();
//                        	}
//                        });
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
            	window.close();
            }
        }
        ]);
    }
    
    
})
