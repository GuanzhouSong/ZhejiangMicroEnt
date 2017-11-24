require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'jquery.serialize', 'laydate', 'common/validateRules'], function
    (layer, dataTable, util, http, handlebars) {


    init();
    var table;

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
        $('#registInfoForm').validate({
            onkeyup: false,
            onfocusout: function (el) {

            },
            rules: {
            	surverDate: {
                    required: true
                },
                surverName: {
                    required: true
                }
            },
            messages: {
            	surverDate: {
                    required: '请选择勘察时间'
                },
                surverName: {
                    required: '请输入勘察人员'
                }
            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#registInfoForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                http.httpRequest({
                    url: '/reg/server/registinfo/registinfo/editRecord',
                    serializable: true,
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
        util.bindEvents([
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            }
        ])
    }

})