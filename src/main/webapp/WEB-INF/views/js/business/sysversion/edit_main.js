require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	formValid();
        bind();
    }
    
    /**
     * 表单验证
     */
    function formValid() {
        $('#sysversion-form').validate({
            rules: {
            	title: {
                    required: true,
                    maxlength:512
	            },
	        	contents: {
		        	required: true
		        }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                	if(i == "title"){
                		layer.tips(errorMap[i],$('#sysversion-form input[name='+i+']'),{
                			tips:3,
                			tipsMore:true,
                			ltype:0
                		});
                	}else{
                		layer.tips(errorMap[i],$('#contents'),{
                			tips:3,
                			tipsMore:true,
                			ltype:0
                		});
                	}
                }
            },
            submitHandler: function () {
            	 http.httpRequest({
                     url: '/reg/server/sysversion/save',
                     serializable: false,
                     data: $('#sysversion-form').serializeObject(),
                     type: 'post',
                     success: function (data) {
                         layer.msg(data.msg, {time: 1000}, function () {
                             layer.close({reload: true});
                         });
                     }
                 });
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }]);
    }
});
