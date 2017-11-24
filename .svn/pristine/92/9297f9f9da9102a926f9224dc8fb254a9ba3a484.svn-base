require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'common/validateRules',
    'jquery.validate',
    'jquery.serialize',
    'component/backToTop',
    'laydate',
    'component/report'
], function (layer, util, http,handlebars) {

    init();
    laydate.skin('molv');//初始化皮肤
    /**
     * 初始化函数集合
     */

    function init() {
        eacho();//数据回显
        bind();
    }



    //数据回显
    function eacho(){
        //电话 邮件
        var _tel =   $("input:radio[name=otherInfoIsTel]:checked").val();
        var _email = $("input:radio[name=otherInfoIsEmail]:checked").val();
        if(_tel=="0"){
            $('input[name="tel"]').attr("readonly","readonly").css("background","#CCC");
        }
        if(_email=="0"){
            $('input[name="email"]').attr("readonly","readonly").css("background","#CCC");
        }

        //组建方式 回显
        var _parInsVlaue = $("#_parIns").val();//获取 党组织建制的值
        if(_parInsVlaue=='0'){
            $("#_parSetTime").attr("type","hidden").attr("disabled","disabled");//设置为隐藏域并添加disabled属性避免效验
            $("#_one").css("display","none");
            $("#_two").css("display","none");
        }
        if(_parInsVlaue=='1'){
            $("#_parSetTime").attr("type","text").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_one").css("display","block").removeAttr("disabled");
            $("#_two").css("display","none").attr("disabled","disabled");
            //获取组建方式的值：
            var _v = $("#_parOrgW").val();
            $("#_one option").each(function(){
                var $v = $(this).val();
                if(_v==$v){$(this).prop("selected",true);}
            });
        }
        if(_parInsVlaue=='2'||_parInsVlaue=='3'){
            $("#_parSetTime").attr("type","text").removeAttr("disabled");//显示并移除disabled属性  时间
            $("#_two").css("display","block").removeAttr("disabled");
            $("#_one").css("display","none").attr("disabled","disabled");
            //获取组建方式的值：
            var _v = $("#_parOrgW").val();
            $("#_two option").each(function(){
                var $v = $(this).val();
                if(_v==$v){$(this).prop("selected",true);}
            });
        }

        //是否经营广告 默认选否
        var _advBusFlag = $("#_advBusFlag").val();
        if(!_advBusFlag){
            $("input:radio[name='advBusFlag'][value='0']").prop("checked",true);
        }
        //企业是否有网站或网店
        var _wzdata = parseInt($("#_wzdata").val(),10);
        if(_wzdata>0){
            $("#qywz").slideDown().show();
        }

    }



    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '#xx',  //
                event: 'click',
                handler: function () {

                }
            }
        ])
    }
});
