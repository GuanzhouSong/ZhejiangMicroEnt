/**
 * Created by Administrator on 2016/10/25.
 */
/**
 * Created by Administrator on 2016/10/23.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'component/sfc_report',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, util, http,handlebars) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    init();
    /**
     * 初始化函数集合
     */

    function init() {

        FormValid();// 综合表
        bind();
        initMoney();//金额计算初始化
        eacho();//回显初始化
    }

    //判断综合信息表得 年报 状态来判断是查看还填报或修改状态
    function eacho(){
        var declStatus = $("#_declStatus").val();// 获取 综合信息填表状态0:未申报 1:申报待核2:已核实 3已退回
        if(declStatus=='1'||declStatus=='2'){ //只能查看
            $("input,select").attr("disabled","disabled");
            $(".icon-close,.btn-common").hide();
        }
    }

    //金额计算 鼠标移出事件
    function initMoney(){
        $(".units").bind("blur", doCal);
        $(".icon-close").bind("click",doCal);//点击打叉时候
    }

    function  doCal(){
        var statement1 = parseFloat(($("#statement1").val() - 0).toFixed(2)),
            statement2 = parseFloat(($("#statement2").val() - 0).toFixed(2)),
            statement5 = parseFloat(($("#statement5").val() - 0).toFixed(2)),
            statement6 = parseFloat(($("#statement6").val() - 0).toFixed(2)),
            statement10 = parseFloat(($("#statement10").val() - 0).toFixed(2)),
            statement11 = parseFloat(($("#statement11").val() - 0).toFixed(2)),
            statement12 = parseFloat(($("#statement12").val() - 0).toFixed(2)),
            statement15 = parseFloat(($("#statement15").val() - 0).toFixed(2)),
            statement16 = parseFloat(($("#statement16").val() - 0).toFixed(2)),
            statement17 = parseFloat(($("#statement17").val() - 0).toFixed(2)),
            statement18 = parseFloat(($("#statement18").val() - 0).toFixed(2)),
            statement21 = parseFloat(($("#statement21").val() - 0).toFixed(2)),
            statement22 = parseFloat(($("#statement22").val() - 0).toFixed(2)),
            statement23 = parseFloat(($("#statement23").val() - 0).toFixed(2)),
            statement24 = parseFloat(($("#statement24").val() - 0).toFixed(2)),
            statement28 = parseFloat(($("#statement28").val() - 0).toFixed(2));

        //1+2-5-6=10
        statement10 = (statement1 + statement2 - statement5 - statement6).toFixed(2)-0;
        if(!isNaN(statement10)){
            $("#statement10").val((statement10-0).toFixed(2));
        }
        //10+11-12=15
        statement15 = (statement10 + statement11 - statement12).toFixed(2)-0;
        if(!isNaN(statement15)){
            $("#statement15").val((statement15-0).toFixed(2));
        }
        //16行=15行
        statement16 = statement15;
        if(!isNaN(statement16)){
            $("#statement16").val((statement16-0).toFixed(2));
        }
        //16+17+18=21
        statement21 = (statement16 + statement17 + statement18).toFixed(2)-0;
        if(!isNaN(statement21)){
            $("#statement21").val((statement21-0).toFixed(2));
        }
        //21-22-23-24=28
        statement28 = (statement21 - statement22 - statement23 - statement24).toFixed(2)-0;
        if(!isNaN(statement28)){
            $("#statement28").val((statement28-0).toFixed(2));
        }

    }

    /**
     * 表单验证 并保存
     */
    function FormValid() {
        $("#sfcearningdistForm").validate({
            onkeyup:false, //键盘按下不进行触发 默认是鼠标移出输入框后再进行触发
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
                    var ele = $('#sfcearningdistForm input[name='+i+']'), index, parentEle, cls;
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
                busInc: {
                    maxlength: 16
                },
                thatSurplus: {
                    maxlength: 16
                },
                annDisInc: {
                    maxlength: 16
                },
                undistSurplusBegin: {
                    maxlength: 16
                },
                busSpend: {
                    maxlength: 16
                },
                otherTrans: {
                    maxlength: 16
                },
                manageFees: {
                    maxlength: 16
                },
                distSurplus: {
                    maxlength: 16
                },
                busEarn: {
                    maxlength: 16
                },
                extSurAccuFund: {
                    maxlength: 16
                },
                otherInc:{
                    maxlength: 16
                },
                returnSurplusPay:{
                    maxlength: 16
                },
                otherSpend:{
                    maxlength: 16
                },
                remainSurplusPay:{
                    maxlength: 16
                },
                thisSurplus:{
                    maxlength: 16
                },
                undistSurplusEnd:{
                    maxlength: 16
                }
            },
            submitHandler: function () {

                //判断 【本年盈余】与【年度报告中的盈余总额】是否相等
                var _value = parseInt($("#priYeaProfit").val()*100);
                var statement15= parseInt($("#statement15").val()*100);
                if(_value!=statement15){
                    layer.tips('【本年盈余】与【年度报告中的盈余总额】不一致，请检查并修正信息！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em style="color:red;font-size: 20px;cursor: pointer;display: block;text-align: right" class="js_close_tips">×</em>','#statement15',{tips:3, tipsMore:true, ltype:0,time:0});
                    return;
                }

                var formParam =  $("#sfcearningdistForm").serializeObject();
                $(".js-save").attr("disabled", true); //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/sfc/incstatement/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success'){
                            layer.msg(data.msg, {icon: 1,time: 1000}, function () {
                                window.location.reload();//延迟重新刷新页面
                            });
                        }else if(data.status=='fail'){
                            $(".js-save").attr("disabled", false);
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-save").attr("disabled", false);
                    }
                });

            }
        });
    };


    //按钮事件
    function bind() {
        util.bindEvents([
            /* {
             el: '.js-btn-save',  // 总表提交
             event: 'click',
             handler: function () {
             $('#').submit();
             }
             },*/
            {
                el: '.js-btn-cancel',  // 取消
                event: 'click',
                handler: function () {
                    layer.confirm('您确定取消当前操作吗？', { btn: ['确定', '取消'],icon: 3, title: '温馨提示',closeBtn: 0}, function (index) {
                        window.close();//关闭当前窗口
                    });
                }

            },
            {
                el: '.js_close_tips',          //触发提示关闭tip层
                event: 'click',
                handler: function () {
                    layer.closeAll('tips'); //关闭所有的tips层
                }
            }
        ])
    }
});
