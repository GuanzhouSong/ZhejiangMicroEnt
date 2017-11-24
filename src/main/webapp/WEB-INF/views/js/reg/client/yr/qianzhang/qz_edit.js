require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'sha',
    'jquery.validate',
    'jquery.serialize',
    'jquery'
], function (layer,util,http,sha) {
    init();
    //初始化函数集合
    function init() {
        bind();
    }

    function doCheckJsonpService(form){
        //判断用户电脑签名服务是否正常启动
        var t1 = setTimeout(showError,1000);//使用字符串执行方法
        $.ajax({
            type : "get",
            async : false,
            url : "http://127.0.0.1:9818/lps?method=1",
            //url : "https://127.0.0.1:9819/lps?method=1",
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
            //url "https://127.0.0.1:9819/lps?method=26&itype=3&iflag=1",
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

                $.ajax({
                    type : "post",
                    async : false,
                    url : "/reg/client/yr/ent/signature/doSaveSignture",
                    data : {
                        "cert" : cert,
                        "signedData" : signData,
                        "signContent" : hash,
                        "year":signature_year,
                        "pripid":signature_priPID
                    },
                    dataType : "json",
                    success : function(data) {
                        if(data.status == "success"){
                            layer.msg(data.msg,{icon: 6,time: 3000});
                            $('#js-signature-box').hide();//签章成功后隐藏 加盖电子公章
                            $('#js-yearbox').show();      //显示提交按钮
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
        layer.confirm('<em style="color: red">签章失败!&nbsp;</em>重试签章,点击【重试电子公章】；跳过<em style="color: green">电子公章</em>点击【提交年报】', {
            btn: ['重试电子公章', '提交年报'],
            icon:3,
            title: '信息提示',
            closeBtn: 0
        }, function (index) {
            $("#js-signature").attr("disabled",false);
            $('#js-signature').click();
            layer.close(index);
        }, function (index) {
            //修改签章失败的状态：
            var sig_params  = $("#signature_params").serializeObject();
            $.ajax({
                type : "post",
                async : true,
                url : "/reg/client/yr/ent/signature/doModifyStatus",
                data : {"year":sig_params['year'], "pripid":sig_params['pripid']},
                dataType : "json",
                success : function(data) {
                }
            });
            $('#js-signature-box').hide();//签章成功后隐藏 加盖电子公章
            $('#js-yearbox').show();//显示提交年报按钮
            layer.close(index);
        });
    }

    function bind() {
        util.bindEvents([{
            el: '#js-signature',
            event: 'click',
            handler: function () {
                layer.msg("请稍等......",{icon: 6,time: 3000});
                $("#js-signature").attr("disabled",true);//禁用 签章按钮
                doCheckJsonpService($("#signature_params"));
            }
        }
        ])
    };

});
