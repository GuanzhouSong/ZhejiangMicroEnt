require(['common/util', 'component/iframeLayer', 'common/http','jquery.validate','common/validateRules',  'ztree','jquery.serialize'], function (util, layer, http) {


    init();
    /**
     * 初始化函数集合
     */
    function init() {
        if($("#deptUId").val()==""){
            $("#orgCoding").removeAttr("readonly");
        }
        bind();
        formValid();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#sysDepartForm').validate({
            onkeyup:false,
            rules: {
                orgName: {
                    required: true
                },
                organizeAllName:{
                    required: true
                },
                dutyNames: {
                    required: true
                },
                adcode:{
                    required: true
                },
                liaName:{
                    required: true
                } ,
                liaPhone:{
                    required: true,
                    isTel: true
                }
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#sysDepartForm input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function () {

            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
                if($("#sysDepartForm").valid()){
                    var dutyCodes=$("#dutyCodes").val();
                    if(dutyCodes==""){
                        layer.tips("请选择职能部门",$('#dutyNames'),{
                            tips:3,
                            tipsMore:true,
                            ltype:0
                        });
                        return;
                    }
                    var formParam = $('#sysDepartForm').serializeObject();
                    http.httpRequest({
                        type: 'post',
                        url: '/syn/system/sysdepart/save',
                        data: formParam,
                        success: function (data) {
                            if (data.status == 'success') {
                                layer.msg(data.msg, {time: 500}, function () {
                                    layer.close({reload: true});
                                    return;
                                });
                            }
                            var errorMsg = data.msg;
                            var errors = data.errors;
                            if (errors.length > 0) {
                                for (var i = 0; i < errors.length; i++) {
                                    errorMsg += '<br/>' + (i + 1) + '：' + errors[i].field + errors[i].info;
                                }
                            }
                            layer.msg(errorMsg, {time: 1000});
                        }
                    });
                }
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        },
        {
            el: '#selectDutyCode',
            event: 'click',
            handler: function () {
                var dutyCodes=$("#dutyCodes").val();
                var select_dept_url=window._CONFIG.select_dept_url+"?deptDutyCodes="+dutyCodes;
                layer.dialog({
                    title: '选择职能部门',
                    area: ['350px', '666px'],
                    content: select_dept_url,
                    callback: function (data) {
                        if(data.deptCodes!=null&&data.deptNames!=null){
                            $("#dutyNamesHidden").val(data.deptNames);
                            $("#dutyNames").val(data.deptNames);
                            $("#dutyCodes").val(data.deptCodes);
                        }
                    }
                })
            }
        }
        ])
    }
})