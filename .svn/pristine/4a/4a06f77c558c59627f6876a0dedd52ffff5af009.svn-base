require(['component/iframeLayer', 'component/dataTable',
    'common/util', 'common/http', 'handlebars', 'jquery.validate', 'jquery.serialize', 'laydate', 'common/validateRules'], function
    (layer, dataTable, util, http, handlebars) {


    init();
    /**
     * 初始化函数集合
     */
    
    function init() {

        formValid();
        bind();
        initNormal();
    }
    
    var disposeState = $("#disposeState").val();
    if(disposeState=='1'){
    	$(".sp").hide();
    }else{
    	$(".sp").show();
    }

    var const_zhegnchagn_code = '1';

    function initNormal() {
        var const_zhegnchagn_code = '1';
        if($('#fromtype').val()=='detail') return;
        
        if ($('input[name="resResult"]:checked').val() ==const_zhegnchagn_code) {
            $('input[name="resResult"]').each(function () {
                if ($(this).val() != const_zhegnchagn_code) {
                    $(this).prop("disabled", "disabled");

                }
            })
        }
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#infoForm').validate({
            onkeyup: false,
            onfocusout: function (el) {
            },
            rules: {
                itemWay: {
                    required: true
                },
                resResult: {
                    required: true
                },
                infoCheckOrgName: {
                    required: true
                },
                departName: {
                    required: true
                },
                infoCheckMan: {
                    required: true
                },
                infoCheckDate: {
                    required: true
                },
                infoAuditResult: {
                    required: true
                },
                infoAuditOpin: {
                    required: true
                },
                disposeState: {
                	required: true
                }
            },
            messages: {
                itemWay: {
                    required: '请选择检查方式'
                },
                resResult: {
                    required: '请选择检查结果'
                },
                infoAuditResult: {
                    required: '请选择审核意见'
                },
                disposeState: {
                    required: '请选择后续处置措施是否完结'
                }
            },

            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#infoForm input[name=' + i + '],#infoForm textarea[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0

                    });

                }
            },

            submitHandler: function () {
                var formParam = getFormParam($('#infoForm').serializeObject());
                //提交验证
                if ($('.class1.cs-nochecked').length + $('.class2.cs-checked').length < $('#codes_com_size').val()) {
                    layer.msg("请选择一般核查内容", {time: 1000}, {});
                    return;
                }

                if ($('.class1-key.cs-nochecked').length + $('.class2-key.cs-checked').length < $('#codes_key_size').val()) {
                    layer.msg("请选择重点核查内容", {time: 1000}, {});
                    return;
                }
                /*       var common_flag = true;
                 $('.class1').each(function () {
                 if(!$(this).hasClass("cs-nochecked")){
                 common_flag=false;
                 }
                 });
                 if(!common_flag){
                 layer.msg("请选择一般核查内容", {time: 1000}, {});
                 return;
                 }*/
                var flag = true;
                $('.class1.cs-nochecked').each(function () {
                    if ($.trim(getNextInputval($(this))) == '') {
                        flag = false;
                    }
                });
                if (!flag) {
                    layer.msg("请填写相应的实际情况", {time: 1000}, {});
                    return;
                }
                //检查日期不能晚于录入日期
                var end = new Date($('#infoCheckDate').val().replace("-", "/").replace("-", "/"));
                var start = new Date($("#infoFillDate").val().replace("-", "/").replace("-", "/"));
                if (end > start) {
                    layer.msg("检查日期不能晚于录入日期", {time: 1000}, {});
                    return;
                }
                
                if($('input[name="disposeState"]:checked').val() == '2'){
                	if($('#disposeFinishDate').val() == '') {
                		layer.msg("请输入完结日期", {time: 1000}, {});
                		return;
                	}
                	var finish = new Date($('#disposeFinishDate').val().replace("-", "/").replace("-", "/"));
                    if (finish > start) {
                        layer.msg("完结日期不能晚于录入日期", {time: 1000}, {});
                        return;
                    }
                }
                
                if ($('#fromtype').val() == 'edit') {
                	if($('#modContent').val() == '') {
                		layer.msg("请输入修改内容", {time: 1000}, {});
                        return;
                	}
                }

                //提交验证end
                var url = '/reg/server/inspect/add';
                http.httpRequest({
                    url: url,
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

    /**
     * 获取复选框后面的文本
     * @param $obj
     * @returns {*|{}}
     */
    function getNextInputval($obj) {
        return $obj.parent().parent().next().find("input").val();
    }

    /**
     * 设置复选框
     * @param $obj
     * @param arr
     * @param type
     */
    function setArr($obj, arr, type) {
        $obj.each(function () {
            if (type == 'N') {
                if ($(this).hasClass('cs-nochecked'))
                    arr.push($(this).attr("id") + "&" + type + "&" + getNextInputval($(this)));
            }
            if (type == 'Y') {
                if ($(this).hasClass('cs-checked'))
                    arr.push($(this).attr("id") + "&" + type + "&" + getNextInputval($(this)));
            }
        })
    }

    /**
     * 获取表单数据
     * @param formParam
     */
    function getFormParam(formParam) {
        //一般核查内容获取
        var commonarr = [];
        setArr($('.class1'), commonarr, 'N');
        setArr($('.class2'), commonarr, 'Y');
        formParam.common = commonarr.toString();

        //重点核查内容获取
        var keyarr = [];
        setArr($('.class1-key'), keyarr, 'N');
        setArr($('.class2-key'), keyarr, 'Y');
        formParam.key = keyarr.toString();
        //登记法律法规
        var reglawarr = [];
        $('input[name="reglaw"]:checked').each(function () {
            reglawarr.push($(this).val());
        })
        formParam.reglaw = reglawarr.toString();
        //其他法律法规
        var othlawarr = [];
        $('input[name="othlaw"]:checked').each(function () {
            othlawarr.push($(this).val());
        })
        formParam.othlaw = othlawarr.toString();
        //检查结果内容获取
        var resarr = [];
        $('input[name="resResult"]:checked').each(function () {
            resarr.push($(this).val());
        })
        formParam.res = resarr.toString();
        //后续处置获取
        var disposearr = [];
        $('input[name="resDispose"]:checked').each(function () {
            disposearr.push($(this).val());
        })
        formParam.resDispose = disposearr.toString().replace(/,/g, "&");
        //检查方式获取
        var itemwayarr = [];
        $('input[name="itemWay"]:checked').each(function () {
            itemwayarr.push($(this).val());
        })
        formParam.itemWay = itemwayarr.toString().replace(/,/g, "&");
        //fromtype获取
        formParam.fromtype = $('#fromtype').val();
        return formParam;
    }

    /**
     * 选正常禁选其他选项
     */
    function disabledOtherCheckbox(disabled) {
        $('input[name="resResult"]').each(function () {
            if ($(this).val() != const_zhegnchagn_code) {
                $(this).prop("checked", false);
                if (disabled == '') {
                    $(this).removeAttr('disabled');
                } else {
                    $(this).attr('disabled', 'disabled');
                }

            }
        });
    }

    /**
     * 其他关联后置处置的checkbox
     * @param res
     * 未按规定公示年报信息    2    责令其公示未公示信息1
     未按规定公示其他应当公示的信息3    责令其公示未公示信息1
     公示信息隐瞒真实情况、弄虚作假4    责令其改正虚假公示的信息3
     通过登记的住所（经营场所）无法联系5    拟列入经营异常名录5
     不予配合情节严重6    公示其不予配合情节4
     */
    function unionOtherDispose(res) {
        var obj = [{res: 2, dispose: 1},
            {res: 3, dispose: 1},
            {res: 4, dispose: 3},
            {res: 5, dispose: 5},
            {res: 6, dispose: 4}];
        $.each(obj, function (i, o) {
            if (o.res == res) {
                $('input[name="resDispose"][value="' + o.dispose + '"]').prop('checked', true);
                $('input[name="disposeState"][value="1"]').prop('checked', true);
                $(".sp").hide();
            }
        });

    }

    // 部门单选
    function doSelectDept() {
        var select_dept_url = window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择部门',
            area: ['25%', '60%'],
            content: select_dept_url,
            callback: function (data) {
                if (data.deptCode != null && data.deptName != null) {
                    $("#departName").val(data.deptName);
                    $("#depart").val(data.deptId);
                }
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
            }, {
                el: '#departName',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;
                    doSelectDept();
                }
            }, {
                el: '#infoCheckOrgName',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;
                    layer.dialog({
                        title: '选择检查机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck?isPermissionCheck=true',
                        callback: function (data) {
                            if (typeof data.returnname == 'undefined' || typeof data.returncode == 'undefined' || data.returnname == '' || data.returncode == '')return;
                            //重新加载列表数据
                            $("#infoCheckOrg").val(data.returncode);
                            $("#infoCheckOrgName").val(data.returnname);
                        }
                    })


                }
            }, {
                el: 'input[name="resResult"]',
                event: 'click',
                handler: function () {
                    if ($(this).val() == const_zhegnchagn_code && $(this).prop("checked")) { //正常
                        disabledOtherCheckbox('disabled');
                        $('input[name="disposeState"][value="2"]').prop('checked', true);
                        $(".sp").show();
                    } else if ($(this).val() == const_zhegnchagn_code && !$(this).prop("checked")) { //不选正常
                        disabledOtherCheckbox('');
                    } else {
                        unionOtherDispose($(this).val()); //其他关联后置处置的checkbox
                    }

                }
            }, {
                el: 'input[name="resDispose"]',
                event: 'click',
                handler: function () {
                	$('input[name="disposeState"][value="1"]').prop('checked', true);
                	$(".sp").hide();
                }
            }, {
                el: 'input[name="disposeState"]',
                event: 'change',
                handler: function () {
                	if($(this).val() == '1'){
                    	$(".sp").hide();
                    }else{
                    	$(".sp").show();
                    }
                }
            }, {
                el: '#check-all-nomal',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;
                    if ($(this).prop("checked")) {
                        $(".class1").removeClass("cs-nochecked");
                        $(".class2").removeClass("csg-checked").addClass("cs-checked");
                        $('.item-text-normal').hide();
                    } else {
                        $(".class1").removeClass("cs-nochecked");
                        $(".class2").removeClass("cs-checked").addClass("csg-checked");
                        $('.item-text-normal').hide();

                    }
                }
            }, {
                el: '#check-all-nomal-key',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;
                    if ($(this).prop("checked")) {
                        $(".class1-key").removeClass("cs-nochecked");
                        $(".class2-key").removeClass("csg-checked").addClass("cs-checked");
                        $('.item-text-key').hide();

                    } else {
                        $(".class1-key").removeClass("cs-nochecked");
                        $(".class2-key").removeClass("cs-checked").addClass("csg-checked");
                        $('.item-text-key').hide();

                    }
                }
            }, {
                el: '.class1,.class1-key',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;
                    if ($(this).hasClass('cs-nochecked')) {
                        $(this).removeClass("cs-nochecked");
                        $(this).parent().parent().next().find(".ipt-box").hide();
                    } else {
                        $(this).addClass("cs-nochecked");
                        $(this).next().removeClass("cs-checked").addClass("csg-checked");
                        $(this).parent().parent().next().find(".ipt-box").show();
                        $(this).parent().parent().next().find(".ipt-txt").focus();
                    }
                }
            }, {
                el: '.class2,.class2-key',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() == 'detail') return;

                    if ($(this).hasClass('cs-checked')) {
                        $(this).removeClass("cs-checked").addClass("csg-checked");
                    } else {
                        $(this).addClass("cs-checked");
                        $(this).prev().removeClass("cs-nochecked");
                        $(this).parent().parent().next().find(".ipt-box").hide();
                    }
                }
            }
        ])
    }

})