require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'sha',
    'handlebars',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'pagination',
    'jquery'
], function (layer, util, http,sha,handlebars) {

    init();//初始化
    function init(){
        userLook();
        formValid();
        bind();

    }

    //页面停留6秒以上则视为已查阅
    function userLook(){
        //判断是已回执还是未回执,未回执停留在页面6秒视为已查阅
        var $this_uuid  = $('#js-uuid').val();
        if($this_uuid){
            var timer = null;
            clearTimeout(timer);
            timer = setTimeout(function () {
                http.httpRequest({
                    url: '/reg/client/yr/ent/writ/updateLookStatue',
                    serializable: false,
                    data: {'uuid':$this_uuid},
                    type: 'get',
                    success: function (data) {/*if(data.status='success') layer.msg("已查阅");*/}
                });
            }, 6000);
        }
    }

    //表单校验
    function formValid() {
        $('#dzhzFrom').validate({
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
                    var ele = $('#dzhzFrom input[name='+i+']'), index, parentEle, cls;
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
                receivePeople: { //回执人
                    required: true,
                    maxlength:50
                },
                tel:{           //联系电话
                    required: true,
                    checkMobile:true,
                    maxlength:30
                }
            },
            submitHandler: function () {
                var formParam = $('#dzhzFrom').serializeObject();
                http.httpRequest({
                    url: '/reg/client/yr/ent/writ/receiptSave',
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        if(data.status=='success') {
                            layer.msg(data.msg);
                            $("#js-module-two").hide();
                            $('.js-hz').removeClass('not-hz').addClass('already-hz').text('已回执');
                        }else if(data.status=='fail'){
                            layer.alert(data.msg+"!, 是否已经执行过回执操作,请点击【确定】按钮会自动刷新当前页面",{ title: '提示', icon: 7,closeBtn: 0,yes:function(index){
                                window.location.reload();
                                layer.close(index);
                            }});
                        }
                    },
                    error:function(){
                            layer.msg("系统异常!当前页面,重新操作");
                    }
                });
            }
        })
    };

    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '.js-stamp-preview', //盖章并预览
                event: 'click',
                handler: function () {
                    layer.msg("签章中,请稍等......",{shade: [0.8, '#393D49'],icon: 6,time:0});
                    doCheckJsonpService($("#js_signature_form"));
                }
            },
            {
                el: '.js-change-cancel', //取消
                event: 'click',
                handler: function () {
                    alert("取消");
                }
            },
            {
                el:'.js-submit-receipt', //提交回执
                event:'click',
                handler:function(){
                    $("#dzhzFrom").submit();
                }
            },
            {
                el:'.js-rewrite', //重新填写
                event:'click',
                handler:function(){
                    $("#dzhzFrom .js-content").attr("readonly",false).css("background","none");
                    $("#js-module-one").show();
                    $("#js-module-two").hide();
                }
            },
            {
                el:'#js-close', //关闭
                event:'click',
                handler:function(){
                   window.close();
                }
            }
        ]);
    }

    /******************************************* 电子签章接口 start *******************************************************/

    function doCheckJsonpService(form){
        //判断用户电脑签名服务是否正常启动
        var t1 = setTimeout(showError,1000);//使用字符串执行方法
        $.ajax({
            type : "get",
            async : false,
            url : "http://127.0.0.1:9818/lps?method=1",
            dataType : "jsonp",
            jsonp : "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            jsonpCallback : "myjsonpcall",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            success : function(json) {
                clearTimeout(t1);//去掉定时器
                //成功则调用签名方法
                doJsonpSignAndSubmitForm(form);
            }
        });
    }

    //jsonp签名,提交表单
    function doJsonpSignAndSubmitForm(form){
        //序列化form表单，成json对象
        var jsonuserinfo  = form.serializeObject();
        //json对象转字符串
        var jsonStr = JSON.stringify(jsonuserinfo);
        //字符串进行hash算法，生成摘要
        var shaObj = new sha("SHA-1", "TEXT");
        shaObj.update(jsonStr);
        var hash = shaObj.getHash("HEX");
        //获取登录时使用的证书序列号，从session中获取
        var certnum = jsonuserinfo['keyCerSn'];
        $.ajax({
            type : "get",
            async : false,
            url : "http://127.0.0.1:9818/lps?method=26&itype=3&iflag=1",
            data : {
                //用hash作为签名原文进行签名
                "signcontent" : hash,
                "name":certnum
            },
            dataType : "jsonp",
            jsonp : "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            jsonpCallback : "myjsonpcall",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            success : function(json) {
                var retcode = json.retcode;
                //retcode 不等于0 ，说明调用报错，输出错误信息
                if(retcode!=0){
                    nextOperation();
                    return;
                    //layer.alert('需要调用的证书序列号为'+certnum+';错误信息:'+json.errinfo);return false;
                }
                var retvalue = json.retvalue;
                var cert = retvalue.split(",")[0];
                var signData = retvalue.split(",")[1];
                cert = cert.split(":")[1];
                signData = signData.split(":")[1];
                var  signature_year = jsonuserinfo['year'];
                var  signature_priPID = jsonuserinfo['pripid'];
                var writUuid = jsonuserinfo['writUuid'];

                $.ajax({
                    type : "post",
                    async : false,
                    url : "/reg/client/yr/ent/writ/saveSignture",
                    data : {
                        "cert" : cert,
                        "signedData" : signData,
                        "signContent" : hash,
                        "year":signature_year,
                        "pripid":signature_priPID,
                        "writUuid":writUuid
                    },
                    dataType : "json",
                    success : function(data) {
                        if(data.status == "success"){
                            layer.closeAll();//关闭消息层
                            $("#dzhzFrom .js-content").attr("readonly",true);
                            $("#js-module-one").hide();
                            $("#js-module-two").show();
                            layer.msg(data.msg,{icon: 6,time: 3000});
                        }else{
                            nextOperation();
                        }
                    }
                });
            }
        });
    }

    //提示错误信息
    function showError(){layer.alert("签章失败，联连客户端签名服务不可用，请检查联连客户端是否正确安装并正常运行!",{yes:function(){nextOperation();}});}
    //提示签章失败后的执行顺序
    function nextOperation(){
        layer.closeAll();//关闭消息层
        layer.confirm('<em style="color: red">签章失败!&nbsp;</em>重试签章,点击【重试电子公章】；跳过<em style="color: green">电子公章</em>点击【继续下一步】', {
            btn: ['重试电子公章', '继续下一步'],
            icon:3,
            title: '信息提示',
            closeBtn: 0
        }, function (index) {
            $('.js-stamp-preview').click();
            layer.close(index);//成功关闭窗口
        }, function (index) {
            $("#js-module-one").hide();
            $("#js-module-two").show();
            //不可编辑
            $("#dzhzFrom .js-content").attr("readonly",true).css("background","#ccc");
            //修改签章失败的状态：
            var sig_params  = $("#js_signature_form").serializeObject();
            $.ajax({
                type : "post",
                async : true,
                url : "/reg/client/yr/ent/writ/doModifyStatus",
                data : {'writUuid':sig_params['writUuid']},
                dataType : "json",
                success : function(data) {
                }
            });
            layer.close(index);
        });
    }

    /******************************************* 电子签章接口 end *******************************************************/




});