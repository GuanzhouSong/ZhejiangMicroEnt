/**
 * Created by Administrator on 2016/10/25.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'component/backToTop',
    'component/sfc_report',
    'jquery.placeholder',
    'jquery.icinfo'
], function (layer, util, http) {
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

//计算和
function  doCal() {
//本年增加数
        // 股金
        var v1 = parseFloat(($("#chgStockAdd").val() - 0).toFixed(2));
        //专项基金
        var v2 = parseFloat(($("#chgFundAdd").val() - 0).toFixed(2));
        //资本公积
        var v3 = parseFloat(($("#chgCapitalAdd").val() - 0).toFixed(2));
        //盈余公积
        var v4 = parseFloat(($("#chgProfitAdd").val() - 0).toFixed(2));
        //未分配盈余
        var v5 = parseFloat(($("#chgNogetAdd").val() - 0).toFixed(2));
        //合计
        var total_1 = parseFloat((v1 + v2 + v3 + v4 + v5) - 0).toFixed(2);
        if(!isNaN(total_1)){
            $("#chgTotalAdd").val(total_1);
        }

//本年减少数
        // 股金
        var v6 = parseFloat(($("#chgStockLess").val() - 0).toFixed(2));
        //专项基金
        var v7 = parseFloat(($("#chgFundLess").val() - 0).toFixed(2));
        //资本公积
        var v8 = parseFloat(($("#chgCapitalLess").val() - 0).toFixed(2));
        //盈余公积
        var v9 = parseFloat(($("#chgProfitLess").val() - 0).toFixed(2));
        //未分配盈余
        var v10 = parseFloat(($("#chgNogetLess").val() - 0).toFixed(2));
        //合计
        var total_2 = parseFloat((v6+v7+v8+v9+v10)-0).toFixed(2);
        if(!isNaN(total_2)){
            $("#chgTotalLess").val(total_2);
        }
    }
//----------------------------------------------------------------------------------------------------------

 function moneyValide() {

        var flag = true;
        /////////////////////////本年增加数///////////////////
        //股金
        var chgStockAdd = parseFloat(($("#chgStockAdd").val() - 0).toFixed(2));
            // 其中：
            //资本公积转赠
            var chgStockAddCap = parseFloat(($("#chgStockAddCap").val() - 0).toFixed(2));
            //盈余公积转赠
            var chgStockAddSur = parseFloat(($("#chgStockAddSur").val() - 0).toFixed(2));
            //成员增加出资
            var chgStockAddMem = parseFloat(($("#chgStockAddMem").val() - 0).toFixed(2));


        //专项基金
        var chgFundAdd = parseFloat(($("#chgFundAdd").val() - 0).toFixed(2));
            // 其中：
            //国家财政直接补助
            var chgFundAddSsd = parseFloat(($("#chgFundAddSsd").val() - 0).toFixed(2));
            //接受捐赠转入
            var chgFundAddDona = parseFloat(($("#chgFundAddDona").val() - 0).toFixed(2));


        //资本公积
        var chgCapitalAdd = parseFloat(($("#chgCapitalAdd").val() - 0).toFixed(2));
            //其中：
            //股金溢价
            var chgCapitalAddPre = parseFloat(($("#chgCapitalAddPre").val() - 0).toFixed(2));
            //资产评估增值
            var chgCapitalAddAppr = parseFloat(($("#chgCapitalAddAppr").val() - 0).toFixed(2));

        //盈余公积
        var chgProfitAdd = parseFloat(($("#chgProfitAdd").val() - 0).toFixed(2));
            // 其中：
            //从盈余中提取
            var chgProfitAddSur = parseFloat(($("#chgProfitAddSur").val() - 0).toFixed(2));
        //未分配盈余
        var chgNogetAdd = parseFloat(($("#chgNogetAdd").val() - 0).toFixed(2));



        ////////////////////////////本年减少数//////////////////////
        // 股金
        var chgStockLess = parseFloat(($("#chgStockLess").val() - 0).toFixed(2));
        //专项基金
        var chgFundLess = parseFloat(($("#chgFundLess").val() - 0).toFixed(2));
        //资本公积
        var chgCapitalLess = parseFloat(($("#chgCapitalLess").val() - 0).toFixed(2));
        //盈余公积
        var chgProfitLess = parseFloat(($("#chgProfitLess").val() - 0).toFixed(2));

        //未分配盈余
        var chgNogetLess = parseFloat(($("#chgNogetLess").val() - 0).toFixed(2));
            // 其中：
            //按交易量(额)分配的盈
            var chgNogetLessVol = parseFloat(($("#chgNogetLessVol").val() - 0).toFixed(2));
            //剩余盈余分配
            var chgNogetLessSur = parseFloat(($("#chgNogetLessSur").val() - 0).toFixed(2));

        //年初余额
             //股金
             var chgStockStartBal = parseFloat(($("#chgStockStartBal").val() - 0).toFixed(2));
             //专项基金
             var chgFundStartBal = parseFloat(($("#chgFundStartBal").val() - 0).toFixed(2));
             //资本公积
             var chgCapitalStartBal = parseFloat(($("#chgCapitalStartBal").val() - 0).toFixed(2));
             //盈余公积
             var chgProfitStartBal = parseFloat(($("#chgProfitStartBal").val() - 0).toFixed(2));
             //未分配盈余
             var chgNogetStartBal = parseFloat(($("#chgNogetStartBal").val() - 0).toFixed(2));
        //年末余额
              //股金
             var chgStockEndBal = parseFloat(($("#chgStockEndBal").val() - 0).toFixed(2));
             //专项基金
             var chgFundEndBal = parseFloat(($("#chgFundEndBal").val() - 0).toFixed(2));
             //资本公积
             var chgCapitalEndBal = parseFloat(($("#chgCapitalEndBal").val() - 0).toFixed(2));
             //盈余公积
             var chgProfitEndBal = parseFloat(($("#chgProfitEndBal").val() - 0).toFixed(2));
             //未分配盈余
             var chgNogetEndBal = parseFloat(($("#chgNogetEndBal").val() - 0).toFixed(2));


     /////////////////////////////////////////////////////////////逻辑判断////////////////////////////////////////////////////////////////////
     //"资本公积转赠+盈余公积转赠+成员增加出资<=股金本年增加数！";

     if (parseFloat(chgStockAddCap + chgStockAddSur + chgStockAddMem).toFixed(2)-0 > parseFloat($("#chgStockAdd").val() - 0).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>1.资本公积转赠+盈余公积转赠+成员增加出资<=股金本年增加数！</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }

     //"国家财政直接补助+接受捐赠转入<=专项基金本年增加数！";
     if (parseFloat(chgFundAddSsd + chgFundAddDona).toFixed(2)-0 > parseFloat($("#chgFundAdd").val() - 0).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>2.国家财政直接补助+接受捐赠转入<=专项基金本年增加数！</em>", {icon: 7,area: ['500px', '150px']},function (index) {layer.close(index)});
         return;
     }

     //"股金溢价+资产评估增值<=资本公积本年增加数！";
     if (parseFloat(chgCapitalAddPre + chgCapitalAddAppr).toFixed(2)-0 > parseFloat($("#chgCapitalAdd").val() - 0).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>3.股金溢价+资产评估增值<=资本公积本年增加数！</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }
     //"从盈余中提取<=盈余公积本年增加数！";
     if (parseFloat(($("#chgProfitAddSur").val() - 0)).toFixed(2)-0 > parseFloat(($("#chgProfitAdd").val() - 0)).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>4.从盈余中提取<=盈余公积本年增加数！</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }

     //"其中按交易量(额)分配的盈余+剩余盈余分配<=未分配盈余本年减少数";
     if (parseFloat(chgNogetLessVol + chgNogetLessSur).toFixed(2)-0 > parseFloat(($("#chgNogetLess").val() - 0)).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>5.其中按交易量(额)分配的盈余+剩余盈余分配<=未分配盈余本年减少数</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }


     ////////////////////////////////////////////////数据平衡效验///////////////////////////////////////////////////////////////
     //"【股金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额"
     if (parseFloat(chgStockStartBal + chgStockAdd - chgStockLess).toFixed(2)-0 != parseFloat(chgStockEndBal).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>6.【股金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }

     //"【专项基金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额"
     if (parseFloat(chgFundStartBal + chgFundAdd - chgFundLess).toFixed(2)-0 != parseFloat(chgFundEndBal).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>7.【专项基金】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }

     //"【资本公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额"
     if (parseFloat(chgCapitalStartBal + chgCapitalAdd - chgCapitalLess).toFixed(2)-0 != parseFloat(chgCapitalEndBal).toFixed(2)-0) {
         flag = false;
         layer.alert("<em style='font-weight: bold'>8.【资本公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }
     //"【盈余公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额"
     if (parseFloat(chgProfitStartBal + chgProfitAdd - chgProfitLess).toFixed(2)-0 != parseFloat(chgProfitEndBal).toFixed(2)-0){
         flag = false;
         layer.alert("<em style='font-weight: bold'>9.【盈余公积】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }
     //"【未分配盈余】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额"
     if (parseFloat(chgNogetStartBal + chgNogetAdd - chgNogetLess).toFixed(2)-0 != parseFloat(chgNogetEndBal).toFixed(2)-0){
         flag = false;
         layer.alert("<em style='font-weight: bold'>10.【未分配盈余】数据平衡关系: 年初余额+本年增加数-本年减少数 = 年末余额</em>", {icon: 7,area: ['500px', '150px']}, function (index) {layer.close(index)});
         return;
     }
     return flag;
    }


    /**
     * 表单验证 并保存
     */
    function FormValid() {
        $("#TableForm").validate({
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
                    var ele = $('#TableForm input[name='+i+']'), index, parentEle, cls;
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
                chgStockAdd: {
                    required: true,
                    maxlength:16
                },
                chgFundAdd: {
                    required: true,
                    maxlength:16
                },
                chgCapitalAdd: {
                    required: true,
                    maxlength:16
                },
                chgProfitAdd: {
                    required: true,
                    maxlength:16
                },
                chgNogetAdd: {
                    required: true,
                    maxlength:16
                },
                chgStockAddCap: {
                    required: true,
                    maxlength:16
                },
                chgFundAddSsd: {
                    required: true,
                    maxlength:16
                },
                chgCapitalAddPre: {
                    required: true,
                    maxlength:16
                },
                chgProfitAddSur: {
                    required: true,
                    maxlength:16
                },
                chgStockAddSur: {
                    required: true,
                    maxlength:16
                },
                chgFundAddDona: {
                    required: true,
                    maxlength:16
                },
                chgCapitalAddAppr: {
                    required: true,
                    maxlength:16
                },
                chgStockAddMem: {
                    required: true,
                    maxlength:16
                },
                chgStockLess: {
                    required: true,
                    maxlength:16
                },
                chgFundLess: {
                    required: true,
                    maxlength:16
                },
                chgCapitalLess: {
                    required: true,
                    maxlength:16
                },
                chgProfitLess: {
                    required: true,
                    maxlength:16
                },
                chgNogetLess: {
                    required: true,
                    maxlength:16
                },
                chgNogetLessVol: {
                    required: true,
                    maxlength:16
                },
                chgNogetLessSur: {
                    required: true,
                    maxlength:16
                }
            },
            submitHandler: function () {
                //提交前进行逻辑判断
                if(!moneyValide()){ return; }
                var formParam =  $("#TableForm").serializeObject();
                $(".js-save").attr("disabled", true); //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/sfc/incomechange/save',
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
            {
                el: '.js-cancel',  // 取消
                event: 'click',
                handler: function () {
                    layer.confirm('您确定要取消当前操作吗？', { btn: ['确定', '取消'],icon: 3, title: '温馨提示',closeBtn: 0}, function (index) {
                        window.close();
                    });
                }

            }
        ])
    }
});
