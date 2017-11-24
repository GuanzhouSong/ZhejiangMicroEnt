require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'common/validateRules', 'jquery.serialize', 'laydate'], function
    (layer, dataTable, util, http, handlebars) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {


        bind();
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
                el: '#save',
                event: 'click',
                handler: function () {
                    if ($('#smscontent').val() == "") {
                        layer.msg("请填写发送内容！", {time: 1000});
                        return;
                    }
                    if ($('input[name="send"]:checked').length < 1) {
                        layer.msg("请选择发送对象", 500);
                        return;
                    }

                    //保存送达方式
                    var type = '';
                    $('input[name="send"]:checked').each(function () {
                        type += ',' + $(this).val();
                    });

                    http.httpRequest({
                        url: '/reg/server/masssms/sendsms?smscontent=' + $('#smscontent').val() + '&send=' + type.substr(1) + '&tel=' + $('#tel').val() + '&liatel=' + $('#liatel').val()
                        + '&regorg=' + $('#regorg').val() ,
                        serializable: true,
                        data: {},
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                layer.close({close: true});
                            });
                        }
                    })
                }
            }

        ])
    }

})