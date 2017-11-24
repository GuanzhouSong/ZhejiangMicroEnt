require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },{
            el: '#save',
            event: 'click',
            handler: function () {
            	$('#foodstoragebaseback-form').validate({
            		rules: {
            			backReason: {
                            required: true,
                            maxlength:200
                        }
                    },
                    showErrors:function(errorMap,errorList){
	                    for(var i in errorMap){
	                		layer.tips(errorMap[i],$('#backReason'),{
	                			tips:3,
	                			tipsMore:true,
	                			ltype:0
	                		});
	                    }
                    },
                    submitHandler: function () {
                        var formParam = $('#foodstoragebaseback-form').serializeObject();
                        http.httpRequest({
                            url: '/reg/server/yr/foodstorageback/commit',
                            serializable: false,
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
        }]);
    }
});
