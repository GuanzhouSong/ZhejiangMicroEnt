require(['component/iframeLayer', 'common/util',
    'common/http', 'jquery', 'select2', 'jquery.serialize', 'laydate', 'common/validateRules',
    'jquery.validate'], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initShowContent(_adminguideitem);
        bind();
        formValid();
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
                othernoticetype: {
                    required: "请选择其他送达方式"
                },
                stadate: {
                    required: "请选择开始日期"
                },
                enddate: {
                    required: "请选择结束日期"
                },
                auditstate: {
                    required: "请选择审核结果"
                },
                localadmname: {
                    required: "请选择管辖单位"
                },
                regorgname: {
                    required: "请选择登记机关"
                },
                _adminguidecercontent7: {
                    required: "请选择许可证"
                },
                prodate: {
                    required: "请选择出具日期"
                }
            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#infoForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });

                    layer.tips(errorMap[i], $('#infoForm textarea[name=' + i + ']'), {  // textarea
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });
                }
            },
            submitHandler: function () {

                var formParam = $('#infoForm').serializeObject();
                //清空为了验证的name
                delete formParam._adminguidecercontent1;
                delete formParam._adminguidecercontent2;
                delete formParam._adminguidecercontent3;
                delete formParam._adminguidecercontent4;
                delete formParam._adminguidecercontent5;
                delete formParam._adminguidecercontent6;
                delete formParam._adminguidecercontent7;
                //清空为了验证的name end
                var item = '';
                if (_fromtype == 'check')
                    item = _adminguideitem;
                else
                    item = formParam.adminguideitem;
                formParam.adminguidecercontent = sumContent(item);
                //更改各种审核状态和其他送达方式
                formParam = changeState(formParam);
                http.httpRequest({
                    url: '/reg/server/govguide/govguide/modi',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        var index = layer.msg(data.msg, {time: 1500}, function () {
                        });
                        if(data.status!='fail'){
                            setTimeout(function(){
                                layer.close(index);
                                layer.close({type:'save'});
                            },1000)
                        }
                    }
                })
            }
        })
    };
    function bind() {
        util.bindEvents([

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
            },
            {
                el: '#print',
                event: 'click',
                handler: function () {
                    var _id = "_doPrint_" + new Date().getTime();
                    var url = '/reg/server/govguide/govguide/toViewPrint?fromtype=' + _fromtype + '&uid=' + $('input[name="uid"]').val() + '&pripid=&entname=';
                    try {
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                    }
                    catch (e) {
                        alert("打印错误!");
                    }

                }
            },
            {
                el: '#edit_print',
                event: 'click',
                handler: function () {
                    var _id = "_doPrint_" + new Date().getTime();
                    var url = '/reg/server/govguide/govguide/toEditPrint?fromtype=' + _fromtype
                            + '&pripid=' + $('#pripid').val()
                            + '&uid=' + $('#uid').val()
                        ;
                    try {
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                    }
                    catch (e) {
                        alert("打印错误!");
                    }

                }
            },
            {
                el: '#choose',
                event: 'click',
                handler: function () {
                    if(_fromtype=='checkview')return;
                    layer.dialog({
                        title: '选择许可证',
                        area: ['428px', '400px'],
                        content: '/reg/server/govguide/govguide/toLicence',
                        callback: function (data) {
                            if(typeof data.name !='undefined'){
                                $('#adminguidecercontent-3-name').val(data.name);
                                $('#adminguidecercontent-3-code').val(data.code);
                            }
                        }
                    });
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    layer.close({type: 'cancel'});
                }
            }
        ])
    }

//计算内容
    function sumContent(item) {
        var txt = '';
        $('.adminguidecercontent-' + item).each(function () {
            txt += $(this).val() + "&";
        });
        return txt;
    }
//清空其他内容
    function initShowContent(item) {
        //显示内容
        var _con=_adminguidecercontent.split('&');
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
        //如果是退回修改保存后提交，把审核状态改成未审核
        if (_fromtype == 'backmodi') {
            formParam.auditstate = '0';
        }
        //如果是审核，根据审核状态，改变有效状态
        if (_fromtype == 'check') {
            if (formParam.auditstate == '1') {
                formParam.efftstatus = '1';
            } else if (formParam.auditstate == '2') {
                formParam.efftstatus = '2';
            } else if (formParam.auditstate == '3') {
                formParam.efftstatus = '0';
            }
        }
        //保存送达方式
        var type = '';
        $('input[name="othernoticetype"]:checked').each(function () {
            type += ',' + $(this).val();
        });
        formParam.othernoticetype = type.substr(1);
        return formParam;
    }

})
