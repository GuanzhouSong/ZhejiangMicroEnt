/**
 * Created by Administrator on 2016/11/22.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'component/dropDown',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'component/report',
    'jquery.placeholder',
    'jquery.icinfo'

], function (layer, util, http) {

    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    init();

    function init(){
        formValid();
        bind();
        init_total(); //计算合计金额*/
        reportStateFrom();//根据年报状态  /设置为年报状态不为未公示及待修改时表单不能修改
        _hover();
    }

    //年报状态判断
    function reportStateFrom(){
        var _value = $("#_reportState").val();
        if(_value!='00'&&_value!=='20'&&_value!='13'){
            $("input").attr("disabled","disabled");
            $(".icon-close,.btn-save").hide();
        }
    };

    //逻辑关系提示初始化
    function _hover(){
        var index;
        $(".icon-question").hover(function (){
            var id = $(this).data("id");
            var msg = $(this).data("msg");
            index = layer.tips(msg,'#'+id,{tips:1, tipsMore:true, ltype:0,time:1000000});
        },function (){
            layer.close(index);
        });
    }

    //合计金额
    function init_total(){
        $("#socialsecurityForm").find(".two,.three").bind("blur",doCal);
    }

    //计算金额值
    function doCal(){
        //$("#_paymentBaseTotal").val('');
        $("#_cumulArrearsTotal").val('');
        $("#_actualPaymentTotal").val('');
        //var v1=0,
        var v2=0,v3=0;
        //$("#socialsecurityForm").find(".one").each(function(){  if(!isNaN($(this).val())){v1 += parseFloat(($(this).val() - 0).toFixed(4));}});
        $("#socialsecurityForm").find(".two").each(function(){  if(!isNaN($(this).val())){v2 += parseFloat(($(this).val() - 0).toFixed(4));}});
        $("#socialsecurityForm").find(".three").each(function(){if(!isNaN($(this).val())){v3 += parseFloat(($(this).val() - 0).toFixed(4));}});
        //v1 = v1.toFixed(4);
        v2 = v2.toFixed(4);v3 = v3.toFixed(4);
        //if(!isNaN(v1)){$("#_paymentBaseTotal").val(v1);}
        if(!isNaN(v2)){$("#_actualPaymentTotal").val(v2);}
        if(!isNaN(v3)){$("#_cumulArrearsTotal").val(v3);}
    }


    /**
     * 表单验证 并保存
     */
    function formValid(){
        $("#socialsecurityForm").validate({
            onkeyup:false,
            onfocusout:function(el){
                var parentEle, cls,ele = $(el);
                if (ele.valid()) {
                    if (ele.is('input') && ele.attr('type') != 'text') {
                        cls = 'error-tips-radio';
                        ele.closest('.radio-box').removeClass(cls);
                    } else if (ele.is('select')) {
                        cls = 'error-tips';
                        ele.removeClass(cls);
                    } else {
                        cls = 'error-tips';
                        ele.removeClass(cls);
                        parentEle = ele.parent();
                        if (parentEle.has('.js-error-tips').length) {
                            parentEle.find('.js-error-tips').remove();
                        }
                    }
                }
            },
            showErrors:function(errorMap,errorList){
                for (var i in errorMap) {
                    var ele = $('#socialsecurityForm input[name='+i+']'), index, parentEle, cls;
                    if (ele.is('input') && ele.attr('type') != 'text') {
                        cls = 'error-tips-radio';
                        ele.closest('.radio-box').addClass(cls);
                    } else if (ele.is('select')) {
                        cls = 'error-tips';
                        ele.addClass(cls);
                    } else {
                        cls = 'error-tips';
                        ele.addClass(cls);
                        parentEle = ele.parent();
                        if (!parentEle.has('.js-error-tips').length) {
                            parentEle.append('<em class="js-error-tips error-tips-icon"></em>');
                        }
                    }
                    (function (i) {
                        parentEle && (parentEle.find('.js-error-tips').hover(function () {
                            index = layer.tips(errorMap[i], $(this), {tips: 3, time: 0})
                        }, function () {
                            layer.close(index);
                        }))
                    })(i);
                }
            },
            rules: {
                endowmentNum: {  //城镇职工基本养老保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                unemploymentNum:{  //失业保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                medicalNum:{   //职工基本医疗保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                empInjuryNum:{    //工伤保险
                    required: true,
                    digits: true,
                    maxlength:11
                },
                maternityNum:{   //生育保险
                    required: true,
                    digits: true,
                    maxlength:11
                },

                paymentEndowment:{  //单位缴费基数-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentUnemployment:{  //单位缴费基数-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentMedical:{  //单位缴费基数-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentEmpInjury:{  //单位缴费基数-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentMaternity:{  //单位缴费基数-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayEndowment:{  //本期实际缴费金额-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayUnemployment:{  //本期实际缴费金额-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayMedical:{  //本期实际缴费金额-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayEmpInjury:{  //本期实际缴费金额-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPayMaternity:{  //本期实际缴费金额-生育保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuEndowment:{  //单位累计欠缴金额-城镇职工基本养老保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuUnemployment:{  //单位累计欠缴金额-失业保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuMedical:{  //单位累计欠缴金额-医疗保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuEmpInjury:{  //单位累计欠缴金额-工伤保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumuMaternity:{  //单位累计欠缴金额-生育保险
                    required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentBase:{  //单位缴费基数
                    //required: true,
                    millionUnits:true,
                    maxlength:16
                },
                paymentBaseIsPub:{ //单位缴费基数 公示 不公示
                    required: true
                },
                cumulArrears:{     //单位累计欠缴金额
                    //required: true,
                    millionUnits:true,
                    maxlength:16
                },
                cumulArrearsIsPub:{    //单位累计欠缴金额 公示 不公示
                    required: true
                },
                actualPayment:{        //本期实际缴费金额
                    //required: true,
                    millionUnits:true,
                    maxlength:16
                },
                actualPaymentIsPub:{   //本期实际缴费金额 公示 不公示
                    required: true
                }
            },
            messages: {
                paymentBaseIsPub:"请选择一项",
                cumulArrearsIsPub:"请选择一项",
                actualPaymentIsPub:"请选择一项"
            },
            submitHandler: function () {

                //获取企业从业人数：  判断 参保人数总和是否大于企业从业人数
                var _empNum = parseInt($("#_empNum").val(),10);
                if(_empNum>0){
                    var endowmentNum =    parseInt($("#endowmentNum").val(),10); //城镇职工基本养老保险
                    var unemploymentNum = parseInt($("#unemploymentNum").val(),10); //失业保险
                    var medicalNum =      parseInt($("#medicalNum").val(),10); //职工基本医疗保险
                    var empInjuryNum =    parseInt($("#empInjuryNum").val(),10); //工伤保险
                    var maternityNum =    parseInt($("#maternityNum").val(),10); //生育保险
                    if(endowmentNum>_empNum){
                        layer.tips('城镇职工基本养老保险人数不得大于从业人数<em style="color:red">'+_empNum+'</em>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#endowmentNum',{tips:3, tipsMore:true, ltype:0,time:0});
                        $("#endowmentNum").focus();
                        return;
                    }
                    if(unemploymentNum>_empNum){
                        layer.tips('失业保险人数不得大于从业人数<em style="color:red">'+_empNum+'</em>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#unemploymentNum',{tips:3, tipsMore:true, ltype:0,time:0});
                        $("#unemploymentNum").focus();
                        return;
                    }
                    if(medicalNum>_empNum){
                        layer.tips('职工基本医疗保险人数不得大于从业人数<em style="color:red">'+_empNum+'</em>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#medicalNum',{tips:3, tipsMore:true, ltype:0,time:0});
                        $("#medicalNum").focus();
                        return;
                    }
                    if(empInjuryNum>_empNum){
                        layer.tips('工伤保险人数不得大于从业人数<em style="color:red">'+_empNum+'</em>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#empInjuryNum',{tips:3, tipsMore:true, ltype:0,time:0});
                        $("#empInjuryNum").focus();
                        return;
                        return;
                    }
                    if(maternityNum>_empNum){
                        layer.tips('生育保险人数不得大于从业人数<em style="color:red">'+_empNum+'</em>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#maternityNum',{tips:3, tipsMore:true, ltype:0,time:0});
                        $("#maternityNum").focus();
                        return;
                    }
                }

                var formParam = $('#socialsecurityForm').serializeObject();
                $(".js-save").attr("disabled", true); //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/ent/yrsocialsecurity/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                window.location.reload(); //重新加载页面
                            });
                        }else if(data.status=='fail'){
                            $(".js-save").attr("disabled", false); //
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-save").attr("disabled", false); //
                    }
                });
            }
        });
    }

    function bind() {
        util.bindEvents([
            {
                el: '.js_close_tips',          //触发提示关闭tip层
                event: 'click',
                handler: function () {
                    layer.closeAll('tips'); //关闭所有的tips层
                }
            },
            {
                el: '',
                event: 'click',
                handler: function () {

                }
            }
        ]);
    }

});