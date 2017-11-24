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
        //----------------------------------年初------------------------------------
        var
            yearstart1 = parseFloat(($("#yearstart1").val() - 0).toFixed(2)),
            yearstart5 = parseFloat(($("#yearstart5").val() - 0).toFixed(2)),
            yearstart6 = parseFloat(($("#yearstart6").val() - 0).toFixed(2)),
            yearstart10 = parseFloat(($("#yearstart10").val() - 0).toFixed(2)),
            yearstart11 = parseFloat(($("#yearstart11").val() - 0).toFixed(2)),
            yearstart12 = parseFloat(($("#yearstart12").val() - 0).toFixed(2)),
            yearstart13 = parseFloat(($("#yearstart13").val() - 0).toFixed(2)),
            yearstart15 = parseFloat(($("#yearstart15").val() - 0).toFixed(2)),
            yearstart16 = parseFloat(($("#yearstart16").val() - 0).toFixed(2)),
            yearstart17 = parseFloat(($("#yearstart17").val() - 0).toFixed(2)),
            yearstart20 = parseFloat(($("#yearstart20").val() - 0).toFixed(2)),
            yearstart21 = parseFloat(($("#yearstart21").val() - 0).toFixed(2)),
            yearstart22 = parseFloat(($("#yearstart22").val() - 0).toFixed(2)),
            yearstart25 = parseFloat(($("#yearstart25").val() - 0).toFixed(2)),
            yearstart27 = parseFloat(($("#yearstart27").val() - 0).toFixed(2)),
            yearstart28 = parseFloat(($("#yearstart28").val() - 0).toFixed(2)),
            yearstart29 = parseFloat(($("#yearstart29").val() - 0).toFixed(2)),



            yearstart30 = parseFloat(($("#yearstart30").val() - 0).toFixed(2)),
            yearstart31 = parseFloat(($("#yearstart31").val() - 0).toFixed(2)),
            yearstart32 = parseFloat(($("#yearstart32").val() - 0).toFixed(2)),
            yearstart33 = parseFloat(($("#yearstart33").val() - 0).toFixed(2)),
            yearstart35 = parseFloat(($("#yearstart35").val() - 0).toFixed(2)),
            yearstart36 = parseFloat(($("#yearstart36").val() - 0).toFixed(2)),
            yearstart40 = parseFloat(($("#yearstart40").val() - 0).toFixed(2)),
            yearstart41 = parseFloat(($("#yearstart41").val() - 0).toFixed(2)),
            yearstart42 = parseFloat(($("#yearstart42").val() - 0).toFixed(2)),
            yearstart43 = parseFloat(($("#yearstart43").val() - 0).toFixed(2)),
            yearstart44 = parseFloat(($("#yearstart44").val() - 0).toFixed(2)),
            yearstart45 = parseFloat(($("#yearstart45").val() - 0).toFixed(2)),
            yearstart46 = parseFloat(($("#yearstart46").val() - 0).toFixed(2)),
            yearstart47 = parseFloat(($("#yearstart47").val() - 0).toFixed(2)),
            yearstart50 = parseFloat(($("#yearstart50").val() - 0).toFixed(2)),
            yearstart51 = parseFloat(($("#yearstart51").val() - 0).toFixed(2)),
            yearstart54 = parseFloat(($("#yearstart54").val() - 0).toFixed(2)),

            //----------------------------年末---------------------------------
            yearend1 = parseFloat(($("#yearend1").val() - 0).toFixed(2)),
            yearend5 = parseFloat(($("#yearend5").val() - 0).toFixed(2)),
            yearend6 = parseFloat(($("#yearend6").val() - 0).toFixed(2)),
            yearend10 = parseFloat(($("#yearend10").val() - 0).toFixed(2)),
            yearend11 = parseFloat(($("#yearend11").val() - 0).toFixed(2)),
            yearend12 = parseFloat(($("#yearend12").val() - 0).toFixed(2)),
            yearend13 = parseFloat(($("#yearend13").val() - 0).toFixed(2)),
            yearend15 = parseFloat(($("#yearend15").val() - 0).toFixed(2)),
            yearend16 = parseFloat(($("#yearend16").val() - 0).toFixed(2)),
            yearend17 = parseFloat(($("#yearend17").val() - 0).toFixed(2)),
            yearend20 = parseFloat(($("#yearend20").val() - 0).toFixed(2)),
            yearend21 = parseFloat(($("#yearend21").val() - 0).toFixed(2)),
            yearend22 = parseFloat(($("#yearend22").val() - 0).toFixed(2)),
            yearend25 = parseFloat(($("#yearend25").val() - 0).toFixed(2)),
            yearend27 = parseFloat(($("#yearend27").val() - 0).toFixed(2)),
            yearend28 = parseFloat(($("#yearend28").val() - 0).toFixed(2)),
            yearend29 = parseFloat(($("#yearend29").val() - 0).toFixed(2)),



            yearend30 = parseFloat(($("#yearend30").val() - 0).toFixed(2)),
            yearend31 = parseFloat(($("#yearend31").val() - 0).toFixed(2)),
            yearend32 = parseFloat(($("#yearend32").val() - 0).toFixed(2)),
            yearend33 = parseFloat(($("#yearend33").val() - 0).toFixed(2)),
            yearend35 = parseFloat(($("#yearend35").val() - 0).toFixed(2)),
            yearend36 = parseFloat(($("#yearend36").val() - 0).toFixed(2)),
            yearend40 = parseFloat(($("#yearend40").val() - 0).toFixed(2)),
            yearend41 = parseFloat(($("#yearend41").val() - 0).toFixed(2)),
            yearend42 = parseFloat(($("#yearend42").val() - 0).toFixed(2)),
            yearend43 = parseFloat(($("#yearend43").val() - 0).toFixed(2)),
            yearend44 = parseFloat(($("#yearend44").val() - 0).toFixed(2)),
            yearend45 = parseFloat(($("#yearend45").val() - 0).toFixed(2)),
            yearend46 = parseFloat(($("#yearend46").val() - 0).toFixed(2)),
            yearend47 = parseFloat(($("#yearend47").val() - 0).toFixed(2)),
            yearend50 = parseFloat(($("#yearend50").val() - 0).toFixed(2)),
            yearend51 = parseFloat(($("#yearend51").val() - 0).toFixed(2)),
            yearend54 = parseFloat(($("#yearstart54").val() - 0).toFixed(2));

        //10=1+5+6
        yearstart10 = (yearstart1 + yearstart5 + yearstart6 ).toFixed(2)-0;
        yearend10 = (yearend1 + yearend5 + yearend6 ).toFixed(2)-0;
        if(!isNaN(yearstart10)){  //判断相加的值是否是数字
            $("#yearstart10").val(yearstart10);
        }
        if(!isNaN(yearend10)){  //判断相加的值是否是数字
            $("#yearend10").val(yearend10);
        }

        //15=12+13
        yearstart15 = (yearstart12 + yearstart13).toFixed(2)-0;
        yearend15 = (yearend12 + yearend13).toFixed(2)-0;
        if(!isNaN(yearstart15)){  //判断相加的值是否是数字
            $("#yearstart15").val(yearstart15);
        }
        if(!isNaN(yearend15)){  //判断相加的值是否是数字
            $("#yearend15").val(yearend15);
        }

        //20=16-17
        yearstart20 = (yearstart16 - yearstart17).toFixed(2)-0;
        yearend20 = (yearend16 - yearend17).toFixed(2)-0;
        if(!isNaN(yearstart20)){  //判断相加的值是否是数字
            $("#yearstart20").val(yearstart20);
        }
        if(!isNaN(yearend20)){  //判断相加的值是否是数字
            $("#yearend20").val(yearend20);
        }

        //25=20+21+22
        yearstart25 = (yearstart20 + yearstart21 + yearstart22).toFixed(2)-0;
        yearend25 = (yearend20 + yearend21 + yearend22).toFixed(2)-0;
        if(!isNaN(yearstart25)){  //判断相加的值是否是数字
            $("#yearstart25").val(yearstart25);
        }
        if(!isNaN(yearend25)){  //判断相加的值是否是数字
            $("#yearend25").val(yearend25);
        }

        //28=11+15+25+27
        yearstart28 = (yearstart11 + yearstart15 + yearstart25 + yearstart27).toFixed(2)-0;
        yearend28 = (yearend11 + yearend15 + yearend25 + yearend27).toFixed(2)-0;
        if(!isNaN(yearstart28)){  //判断相加的值是否是数字
            $("#yearstart28").val(yearstart28);
        }
        if(!isNaN(yearend28)){  //判断相加的值是否是数字
            $("#yearend28").val(yearend28);
        }

        //29=10+28
        yearstart29 = (yearstart10 + yearstart28).toFixed(2)-0;
        yearend29 = (yearend10 + yearend28).toFixed(2)-0;
        if(!isNaN(yearstart29)){  //判断相加的值是否是数字
            $("#yearstart29").val(yearstart29);
        }
        if(!isNaN(yearend29)){  //判断相加的值是否是数字
            $("#yearend29").val(yearend29);
        }

        //36= 30+31+32+33+35
        yearstart36 = (yearstart30 + yearstart31 + yearstart32 + yearstart33 + yearstart35).toFixed(2)-0;
        yearend36 = (yearend30 + yearend31 + yearend32 + yearend33 + yearend35).toFixed(2)-0;
        if(!isNaN(yearstart36)){  //判断相加的值是否是数字
            $("#yearstart36").val(yearstart36);
        }
        if(!isNaN(yearend36)){  //判断相加的值是否是数字
            $("#yearend36").val(yearend36);
        }

        //42= 40+41
        yearstart42 = (yearstart40 + yearstart41).toFixed(2)-0;
        yearend42 = (yearend40 + yearend41).toFixed(2)-0;
        if(!isNaN(yearstart42)){  //判断相加的值是否是数字
            $("#yearstart42").val(yearstart42);
        }
        if(!isNaN(yearend42)){  //判断相加的值是否是数字
            $("#yearend42").val(yearend42);
        }

        //43= 36+42
        yearstart43 = (yearstart36 + yearstart42).toFixed(2)-0;
        yearend43 = (yearend36 + yearend42).toFixed(2)-0;
        if(!isNaN(yearstart43)){  //判断相加的值是否是数字
            $("#yearstart43").val(yearstart43);
        }
        if(!isNaN(yearend43)){  //判断相加的值是否是数字
            $("#yearend43").val(yearend43);
        }

        //51=44+45+46+47+50
        yearstart51 = (yearstart44 + yearstart45 + yearstart46 + yearstart47 + yearstart50).toFixed(2)-0;
        yearend51 = (yearend44 + yearend45 + yearend46 + yearend47 + yearend50 ).toFixed(2)-0;
        if(!isNaN(yearstart51)){  //判断相加的值是否是数字
            $("#yearstart51").val(yearstart51);
        }
        if(!isNaN(yearend51)){  //判断相加的值是否是数字
            $("#yearend51").val(yearend51);
        }

        //54 = 43+51
        yearstart54 = (yearstart43 + yearstart51).toFixed(2)-0;
        yearend54 = (yearend43 + yearend51).toFixed(2)-0;
        if(!isNaN(yearstart54)){  //判断相加的值是否是数字
            $("#yearstart54").val(yearstart54);
        }
        if(!isNaN(yearend54)){  //判断相加的值是否是数字
            $("#yearend54").val(yearend54);
        }


    }

    /**
     * 表单验证 并保存
     */
    function FormValid() {
       $("#sfcassetliaForm").validate({
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
                   var ele = $("#sfcassetliaForm input[name="+"'"+i+"'"+"],#sfcassetliaForm textarea[name="+"'"+i+"'"+"]"), index, parentEle, cls;
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
            submitHandler: function () {
                var formParam =  $("#sfcassetliaForm").serialize();
                $(".js-save").attr("disabled", true);//防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/sfc/balanctsheet/save',
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
                el: '.js-lastYearData',  // 读取上一年度数据
                event: 'click',
                handler: function () {
                    var _data = $("#lastYearData").val();
                    if(_data!='1'){layer.alert("您的企业没有上一年的数据,无法读取!", {icon: 7}); return}
                    $("input").each(function(){
                        if($(this).attr("data-yeardata")){
                            $(this).val($(this).data("yeardata")).attr("readonly","readonly");
                            $(this).next().attr("class","")
                        }
                    });
                    layer.confirm('已经成功读取到上一年度数据，已将数据填充至[年初数]中。<br />如需修改请点击【调账】按钮。', { btn: ['确定'],icon: 1, title: '温馨提示',closeBtn: 0}, function (index) {
                        $(".js-editData").removeAttr("disabled").removeAttr("readonly");
                        layer.close(index);
                    });

                }
            },
            {
                el: '.js-editData',  // 调账
                event: 'click',
                handler: function () {
                    $("input").not("#yearstart12,#yearstart30,#yearstart31,#yearstart44").each(function(){  //yearstart12   yearstart30    yearstart31    yearstart44
                        if($(this).attr("data-yeardata")){
                            $(this).removeAttr("readonly");
                            $(this).next().attr("class","icon-close")
                        }
                    });
                    //打开调账说明
                    $(".js-remark-ui").show();
                    $("#_remark").addClass("required").removeAttr("readonly");
                    layer.alert("您好，已打开调账功能，您可以修改数据。",{title: '温馨提示',icon: 1});
                }
            },
            {
                el: '.js-btn-cancel',  // 取消
                event: 'click',
                handler: function () {
                    layer.confirm('您确定取消当前操作吗？', { btn: ['确定', '取消'],icon: 3, title: '温馨提示',closeBtn: 0}, function (index) {
                        window.close();//关闭当前窗口
                    });
            }

            }
        ])
    }
});
