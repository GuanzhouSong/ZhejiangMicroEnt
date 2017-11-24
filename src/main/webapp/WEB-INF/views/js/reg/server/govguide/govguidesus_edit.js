require(['component/iframeLayer', 'component/dataTable', 'common/util',
    'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate', 'jquery.validate', 'common/validateRules'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        formValid();
        initShowContent(_adminguideitem);
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#infoForm').validate({
            onkeyup: false,
            onfocusout: function (el) {

            },
            messages: {
                susdate: {
                    required: "请选择中止日期"
                }
            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#infoForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });

                }
            },
            submitHandler: function () {
                if($('#susremark').val()==''){
                    layer.msg('请填写中止说明！', {time: 1000}, function () {
                    });
                    return false;
                }
                var formParam = $('#infoForm').serializeObject();
                //更改各种审核状态
                formParam = changeState(formParam);
                http.httpRequest({
                    url: '/reg/server/govguide/govguide/modi',
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
    };
    function bind() {
        util.bindEvents([
            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
                el: '#edit_print',
                event: 'click',
                handler: function () {
                    var fromtype = _fromtype;
                    var _id = "_doPrint_" + new Date().getTime();
                    var url = '/reg/server/govguide/govguide/toSusEditPring?fromtype=' + fromtype + '&uid=' + $('#uid').val() + '&pripid=' + $('#pripid').val();
                    try {
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                    }
                    catch (e) {
                        alert("打印错误!");
                    }

                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close();
                }
            },
            {
                el: '#adminguideitem',
                event: 'change',
                handler: function () {
                    var item = $('#adminguideitem option:selected').val();
                    $('#adminguidecercontent-' + item).attr('style', 'display:block');
                    for (var i = 1; i < 7; i++) {
                        if (item != i) {
                            $('#adminguidecercontent-' + i).attr('style', 'display:none');
                        }
                    }
                }
            }
        ])
    }

//计算内容
    function sumContent(item) {
        var txt = '';
        if (item == 1) {
            $('.adminguidecercontent-1').each(function () {
                txt += $(this).val() + "&";
            });
        } else if (item == 2) {
            $('.adminguidecercontent-2').each(function () {
                txt += $(this).val() + "&";
            });
        }
        return txt;
    }
//清空其他内容
    function initShowContent(item) {
        //显示内容
        var _con=_adminguidecercontent.split('&');
        debugger
        if(_con.length>0){
            $('.adminguidecercontent-' + item).each(function (i,e) {
                //填充内容
                if(i<_con.length){
                    $(this).val(_con[i]);
                    //textarea
                    if(item==1&&i==1){
                        $(this).html(_con[1]);
                    }
                }

            });
        }
    }
    function changeState(formParam) {
        //如果无效中止
        formParam.auditstate = '4';
        formParam.efftstatus = '0';
        return formParam;
    }
})
