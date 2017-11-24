require(['common/util', 'component/iframeLayer', 'common/http','jquery.serialize','jquery.validate','common/validateRules'], function (util, layer, http) {


    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        
       formCommit();
    }
    
    function formCommit(){
        $('#deptEditInfoForm').validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#deptEditInfoForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {
            	var length = $("input[name ='isValid']:checked").length;
            	if(length == 0){
            		layer.tips('请选择是否有效','#isValid',{tips:3, tipsMore:true, ltype:0});
            		$("#isValid").focus();
            		return false;
            	}
                var formParam = $('#deptEditInfoForm').serializeObject();
                http.httpRequest({
                    type: 'post',
                    url: '/reg/server/yr/department/save',
                    data: formParam,
                    success: function (data) {
                        if (data.status == 'success') {
                            layer.msg(data.msg, {time: 1000}, function () {
                                layer.close({reload: true});
                                return;
                            });
                        }
                        var errorMsg = data.msg;
                        var errors = data.errors;
                        if (errors.length > 0) {
                            for (var i = 0; i < errors.length; i++) {
                                errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                            }
                        }
                        layer.msg(errorMsg, {time: 1000});
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
        }])
    }
})