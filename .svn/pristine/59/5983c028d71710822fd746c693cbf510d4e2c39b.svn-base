require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate', 'common/validateRules'], function (layer, dataTable, util, http, handlebars) {
    var _urlHead = window._CONFIG._urlHead;
    var copyFormNo = $("#copyFormNo").val();
    init();

    function init() {
        formValid();
        bind();
    }


    //抄告反馈
    function formValid() {
        $('#content_form').validate({
            rules: {
                feedbackPerson: { // 审核人
                    required: true
                },
                feedback: { //反馈意见
                    required: true
                },
            },
            messages: {},
            onkeyup: false,
            onfocusout: function (el) {
                $(el).valid();
            },
            showErrors: function (errorMap, errorList) {
                $("#save").attr("disabled", false);
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#content_form input[name=' + i + '],textarea[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0
                    });
                }
            },
            submitHandler: function () {

            }
        })

    }


    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                $("#save").attr("disabled", true);
                // $("#content_form").submit();
                if ($("#content_form").valid()) {
                    var formParam = $('#content_form').serializeObject();
                    http.httpRequest({
                        url: _urlHead + 'saveFeedback',
                        serializable: true,
                        data: formParam,
                        type: 'post',
                        success: function (json) {
                            if (json.status == "success") {
                                layer.msg(json.msg, {time: 800}, function () {
                                    window.history.go(-1);
                                });

                            } else {
                                $("#save").attr("disabled", false);
                                layer.msg(json.msg, {time: 800}, function () {
                                });
                            }
                        }
                    });
                }
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.msg("您取消了反馈！", {time: 1500}, function () {
                    window.history.go(-1);
                });
            }
        }, {
            el: '#print',
            event: 'click',
            handler: function () {
                window.open(_urlHead + "doEnPrint?copyFormNo=" + encodeURIComponent(copyFormNo), "_blank");
            }
        }
        ])
    }
})
