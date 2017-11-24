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
                disposeDate: {
                    required: true
                }
            },
            messages: {
                disposeDate: {
                    required: '请选择处理时间'
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
                    url: '/reg/server/registinfo/unlicensedinfo/manageModi',
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
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            }
        ])
    }

})