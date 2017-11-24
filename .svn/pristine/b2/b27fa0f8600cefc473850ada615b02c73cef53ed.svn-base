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
                if($('#backReason').val()== ""){
                layer.msg("请填写退回理由！", {time: 1000});return;
                }else{
                formParam.backReason=$('#backReason').val();
                }
                http.httpRequest({
                    url: '/reg/server/registinfo/registinfo/batchBack',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({close: true,reload:true});
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
        {          el: '#checkAll',
                    event: 'click',
                    handler: function () {
                  var flag=$(this).prop("checked");
                  $("input:checkbox[name='_checkbox']").prop("checked", flag);
                    }
        }
        ])
    }

})