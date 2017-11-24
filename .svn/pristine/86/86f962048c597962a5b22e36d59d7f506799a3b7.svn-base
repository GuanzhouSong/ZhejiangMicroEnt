require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','laydate'], function (layer, util, http) {


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
        $('#deptEditInfoForm').validate({
        	rules: {
                deptName: {
                    required: true
                },
                deptShortName: {
                    required: true
                },
                docShortName: {
                    required: true
                },
                sameGov: {
                    required: true
                },
                sameCourt: {
                    required: true
                }
            },
            messages : {
                deptName: {
                    required : "部门名称不能为空",
                },
                deptShortName: {
                    required : "部门简称不能为空",
                },
                docShortName: {
                    required : "部门字号不能为空",
                },
                sameGov: {
                    required : "同级人民政府不能为空",
                },
                sameCourt: {
                    required : "同级人民法院不能为空",
               }
            },
            showErrors:function(errorMap,errorList){
              for(var i in errorMap){
              	console.log(i);
                  layer.tips(errorMap[i],$('#deptEditInfoForm input[name='+i+']'),{
                      tips:3,
                      tipsMore:true,
                      ltype:0
                   });
                 }
             },
        	submitHandler: function () {
                var formParam = $('#deptEditInfoForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/yr/departname/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
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