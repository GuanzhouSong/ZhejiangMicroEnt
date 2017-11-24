require(['component/iframeLayer', 'component/dataTable',
 'common/util', 'common/http','handlebars', 'jquery.validate', 'jquery.serialize', 'laydate'], function
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
            rules: {
            	lcalAdm: {
                    required: true
                }
            },
            submitHandler: function () {
                var formParam = $('#registInfoForm').serializeObject();
                if($('#remark').val().trim()== ""){
                layer.msg("请填写情况说明！", {time: 1000});return;
                }else{
                formParam.remark=$('#remark').val();
                }
                http.httpRequest({
                    url: '/reg/server/registinfo/unlicensedinfo/recordModi',
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