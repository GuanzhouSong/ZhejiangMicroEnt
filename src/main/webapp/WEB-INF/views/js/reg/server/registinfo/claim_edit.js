require(['component/iframeLayer', 'component/dataTable',
 'common/util', 'common/http','handlebars', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'], function
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
                submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                var url='/reg/server/registinfo/registinfo/claim';
                if($('#fromtype').val()=='back'){
                url= '/reg/server/registinfo/registinfo/batchBack';
                }
                http.httpRequest({
                    url:url ,
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
                layer.close({reload: false});
            }
        }
        ])
    }

})