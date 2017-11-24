<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>短信机验证</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div class="tabbale" data-component="tab">
    <form id="tableForm" class="form-box">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name col-5">手机号：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <input type="text" class="ipt-txt" id="js-phone" name="phone" value="" placeholder="请输入手机号">
                        </div>
                    </div>
                </div>
                <div class="col-4" >
                    <label class="item-name col-5">省市：</label>
                    <div class="col-7">
                        <div class="ipt-box col-11">
                            <select id="js-city" name="regOrg" class="ipt-txt">
                                <option value="" >--请选择--</option>
                                <option value="330000">省局</option>
                                <option value="330100">杭州</option>
                                <option value="330200">宁波</option>
                                <option value="330300">温州</option>
                                <option value="330400">嘉兴</option>
                                <option value="330500">湖州</option>
                                <option value="330600">绍兴</option>
                                <option value="330700">金华</option>
                                <option value="330800">衢州</option>
                                <option value="330900">舟山</option>
                                <option value="331000">台州</option>
                                <option value="332500">丽水</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix mt10">
            <div class="center">
                <span style="color: red;">>>>测试短信机,请使用自己的手机号码进行测试</span>
            </div>
        </div>
        <div class="clearfix mt10">
            <div class="center">
                <input type="button"  id="search" value="查询" class="btn mr20">
                <input type="button"  id="cancel" onclick="$('#tableForm')[0].reset();" value="重置" class="btn mr20">
            </div>
        </div>
    </form>
    <script src="/js/lib/require.js"></script>
    <script src="/js/config.js"></script>
    <script>
        require(['component/iframeLayer','common/util','common/http','jquery.serialize'], function (layer, util, http) {
            //查询：
            $('#search').on('click',function(){
                var phone = $.trim($('#js-phone').val());
                var regOrg = $.trim($('#js-city').val());

                var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
                if(!(phone&&regOrg)){ layer.msg("手机号和省市为必填项!",{icon: 6, time: 3000});return; }
                if( !mobile.test(phone)){ layer.msg("请输入有效的手机号码!",{icon: 6, time: 3000}); $('#js-phone').select();return; }

                var params ={'phone':phone,'regOrg':regOrg};
                http.httpRequest({
                    url: '/reg/server/backup/sms_valid',
                    serializable: false,
                    data:params,
                    type: 'post',
                    beforeSend: function () {
                        layer.msg("请求中,请稍等......", {shade: [0.8, '#393D49'], icon: 6, time: 0});
                    },
                    success: function (data) {
                        console.log(data);
                        layer.closeAll();//关闭弹出层
                        if (data.status == "success") {
                            layer.msg(data.msg,{icon: 6, time: 3000});
                        }else if(data.status == 'fail'){
                            layer.alert(data.msg,{icon: 5});
                        }
                    },
                    error: function (data) {
                        layer.closeAll();//关闭弹出层
                        layer.alert('系统异常,请联系管理人员',{icon: 5});
                        //layer.msg("系统异常,请联系管理人员!",{shade: [0.8, '#393D49'],icon: 6,time:3000})
                    }
                });
            });
        });
    </script>
</div>
</body>
</html>
