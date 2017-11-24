/**
 * Created by Administrator on 2017-04-27.
 */
require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/clearform',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'jquery.placeholder',
    'jquery.icinfo',
    'layer1'
], function (layer, util, http,handlebars,clearform) {
    $('input, textarea').placeholder();
    $('.js-ipt-box').expandInput();
    init();

    //初始化函数
    function init() {
        //判断输入框中是否有因为 ' 号
        $.validator.addMethod("specials", function(value, element) {
            if(value){
                return  value.indexOf("'")>-1?false:true;
            }
        }, "输入文本中不能有特殊符号 如：（活动 '） 中的 ' 号 ");
        formValid_one();
        formValid_two();
        formValid_three();
        bind();
        _hover();  //逻辑关系提示初始化
    }
    //提示初始化
    function _hover(){
        var index;
        $(".icon-question").hover(function (){
            var id = $(this).data("id");
            var msg = $(this).data("msg");
            index = layer.tips(msg,'#'+id,{tips:1, tipsMore:true, ltype:0,time:1000000});
        },function (){
            layer.close(index,{ltype:0});
        });
    }

    //信息网站
    function formValid_one() {
        $('#from_one').validate({
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
                    var ele = $('#from_one input[name='+i+']'), index, parentEle, cls;
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
                            index = layer.tips(errorMap[i], $(this), {tips: 3,ltype:0, time: 0})
                        }, function () {
                            layer.close(index,{ltype:0});
                        }))
                    })(i);
                }
            },
            rules: {
                webSitName:{
                    required:true,
                    maxlength:100
                },
                webSite:{
                    required:true,
                    url:true,
                    maxlength:100
                },
                icpBackNO:{
                    specials:true
                },
                weChatPublicNO:{
                    specials:true
                },
                appNames:{
                    specials:true
                }
            },
            messages: {
            },
            submitHandler: function () {
                var formParam = $('#from_one').serializeObject();
                $(".js-save-one").attr("disabled", true);  //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/ent/yrwebsiteinfo/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                layer.close({reload: true});
                            });

                        }else if(data.status=='fail'){
                            $(".js-save-one").attr("disabled", false);
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-save-one").attr("disabled", false);
                    }
                });
            }
        })
    };
    //交易网站
    function formValid_two() {
        $('#from_two').validate({
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
                    var ele = $('#from_two input[name='+i+']'), index, parentEle, cls;
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
                            index = layer.tips(errorMap[i], $(this), {tips: 3,ltype:0, time: 0})
                        }, function () {
                            layer.close(index,{ltype:0});
                        }))
                    })(i);
                }
            },
            rules: {
                webSitName:{
                    required:true,
                    maxlength:100
                },
                webSite:{
                    required:true,
                    url:true,
                    maxlength:100
                },
                webPlatFormType:{
                    required:true
                },
                webGoodsType:{
                    required:true
                },
                eCommerceType:{
                    required:true
                },
                icpBackNO:{
                    specials:true
                },
                weChatPublicNO:{
                    specials:true
                },
                appNames:{
                    specials:true
                }
            },
            messages: {
            },
            submitHandler: function () {
                var formParam = $('#from_two').serializeObject();
                $(".js-save-two").attr("disabled", true);  //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/ent/yrwebsiteinfo/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                layer.close({reload: true});
                            });
                        }else if(data.status=='fail'){
                            $(".js-save-two").attr("disabled", false);
                            layer.msg(data.msg, {icon: 2,time: 1000});
                        }
                    },
                    error:function(){
                        $(".js-save-two").attr("disabled", false);
                    }
                });
            }
        })
    };
    //网店
    function formValid_three() {
        $('#from_three').validate({
            onkeyup: false,
            onfocusout: function (el) {
                var parentEle, cls, ele = $(el);
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
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    var ele = $('#from_three input[name=' + i + ']'), index, parentEle, cls;
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
                            index = layer.tips(errorMap[i], $(this), {tips: 3,ltype:0, time: 0})
                        }, function () {
                            layer.close(index,{ltype:0});
                        }))
                    })(i);
                }
            },
            rules: {
                webSitName: {
                    required: true,
                    maxlength: 100
                },
                webSite: {
                    required: true,
                    url: true,
                    maxlength: 100
                },
                belongPlatFormName: {
                    required: true
                },
                sendAddress: {
                    required: true,
                    maxlength: 100,
                    specials:true
                },
                backAddress: {
                    required: true,
                    maxlength: 100,
                    specials:true
                },
                icpBackNO:{
                    specials:true
                },
                weChatPublicNO:{
                    specials:true
                },
                appNames:{
                    specials:true
                },
                otherName:{
                    specials:true
                }

            },
            submitHandler: function () {
                var formParam = $('#from_three').serializeObject();

                if($('input:radio[name=belongPlatFormName]:checked').val()=='other'){
                    formParam['belongPlatFormName']= $.trim($("#js-other").val());
                }

                $(".js-save-three").attr("disabled", true);  //防止表单重复提交
                http.httpRequest({
                    url: '/reg/client/yr/ent/yrwebsiteinfo/save',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if (data.status == 'success') {
                            layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                                layer.close({reload: true});
                            });
                        } else if (data.status == 'fail') {
                            $(".js-save-three").attr("disabled", false);
                            layer.msg(data.msg, {icon: 2, time: 1000});
                        }
                    },
                    error: function () {
                        $(".js-save-three").attr("disabled", false);
                    }
                });
            }
        })
    };

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: 'input:radio[name=belongPlatFormName]',
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    if($this.val()=='other'){
                        $("#js-select-other").show();
                        $("#js-other").rules("add", {required: true});
                    }else{
                        $("#js-other").rules("remove", "required");
                        $("#js-select-other").hide();
                    }
                }
            },
            {
                el: '.js-cancel',  //关闭
                event: 'click',
                handler: function () {
                    layer.close();
                }
            }
        ])
    }
});


