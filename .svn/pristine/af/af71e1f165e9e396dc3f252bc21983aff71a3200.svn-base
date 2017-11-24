<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>账号验证</title>
    <link rel="stylesheet" href="/css/syn.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
    <style type="text/css">
          
         .hq-yzm {
            font: normal 14px/25px 'Microsoft YaHei';
            color: #fff;
            background-color: #ffab30;
            border-radius: 3px;
            cursor: pointer;
            margin-left: 20px;
        }
       
        .hq-yzm_after {
            font: normal 14px/25px 'Microsoft YaHei';
            color: #fff;
            background-color:#ACA899;
            border-radius: 3px;
            cursor: pointer;
        }
        
        .c-r-warn {
		    font-size: 14px;
		    line-height: 16px;
		    color: #ff0000;
		    padding-left: 25px;
		    background: url(/img/reg/client/c-r-warn.png) no-repeat;
		    margin-bottom: 15px;
		    margin-left: 114px;
		}
    </style>
</head>
<body>
<div class="xt-top">
    <div class="mod2">
        <a href="###" class="logo"></a>
    </div>
</div>
<div class="bg-blue2 pd100">
    <div class="mod2">
        <h1><img src="/img/syn/account-title.jpg" alt=""></h1>

        <div class="account-valid-box">
            <h2>请校验您所在部门及个人信息：</h2> 
            <form action="" id="user_ck_form"> 
                    <div class="form-account-box"> 
                    <p class="c-r-warn">如发现信息有误，请联系技术支持0571-88234769处理</p>
                    <div class="form-item clearfix">
                        <label class="item-name">部门名称：</label> 
                        <div class="ipt-box">
                            <input type="hidden" name="userUsername" value="${sysUser.username}"/>
                            <input type="hidden" name="userType" value="${sysUser.userType}"/>
                            <input type="hidden" name="orgcode" value="${sysDepart.orgCoding}"/>
                            <input type="hidden" name="adcode" value="${sysDepart.adcode}"/>
                            <input type="text" class="ipt-txt clx" id="deptShortName" name="deptShortName" value="${sysDepart.orgName}"  readonly="readonly"  placeholder="">
                        </div> 
                    </div>  
                    <div class="form-item clearfix">
                        <label class="item-name fl">姓名：</label>

                        <div class="ipt-box fl">
                            <input type="text" class="ipt-txt ipt-txt2 clx" name="userRealName" value="${sysUser.realName}" readonly="readonly" >
                        </div>
                        <label class="item-name item-name2 fl">科室：</label>

                        <div class="ipt-box fl">
                            <input type="text" class="ipt-txt ipt-txt2 clx" name="deptName" value="${sysUser.deptName}"  placeholder="${empty sysUser.deptName?'无':''}" maxlength="50">
                        </div>
                    </div>
                    <div class="form-item clearfix">
                       <hr style="margin-left: 90px;margin-right: 100px;height: 10px;border:none;border-top: 2px dashed #cbd5de;margin-top: 20px;" />
                    </div>
                    <div class="form-item clearfix">
                        <label class="item-name fl"><span style="color:red;">*</span> 设置新密码：</label>

                        <div class="ipt-box fl">
                            <input type="password" class="ipt-txt ipt-txt2 clx" name="userPassword" id="sysUserPswNew" placeholder="请输入6位以上的数字或字母" maxlength="100">
                        </div>
                        <label class="item-name item-name2 fl"><span style="color:red;">*</span> 确认新密码：</label>

                        <div class="ipt-box fl">
                            <input type="password" class="ipt-txt ipt-txt2 clx" id="sysUserPswNewAgain" placeholder="请再次输入密码" maxlength="100">
                        </div>
                    </div> 
                    <div class="form-item clearfix">
                        <label class="item-name">手机号码：</label>

                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt2 clx" readonly="readonly"   value="${hideTel}"  >
                            <input type="hidden" class="ipt-txt ipt-txt2 clx" readonly="readonly" name="telPhone" placeholder="即为登录的用户名" id="telPhone" value="${sysUser.username}"  >
                            <span class="hq-yzm_after" id="genCheckCodeAfter" style="display: none;">获取验证码</span> 
                            <span class="hq-yzm" id="genCheckCode">获取验证码</span> 
                        </div>
                    </div>
                    <div class="form-item clearfix">
                        <label class="item-name"><span style="color:red;">*</span> 验证码：</label> 
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt ipt-txt2 clx" name="checkCode" id="checkCode" placeholder="请输入获取的验证码" maxlength="6">
                        </div>
                    </div>
                    <p class="center mt20 opera-btn2">
                        <input type="button" id="save" class="btn mr20" value="完 成">
                        <input type="button" class="btn" value="取 消" id="cancel">
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="tk-box tk-box3" id="ck_success" style="display: none">
    <%--<i class="close-icon"></i>--%>

    <div class="tk-cont clearfix">
        <div class="fl">
            <img src="/img/syn/account-success.png" alt="">
        </div>
        <div class="tk-suc-info fl">
            <h1>请确认以下信息！</h1>
            <h2>
                部门名称:<label id="unitName"></label><br/>对应的后置审批事项为：<label id="licItem"></label>.<br/>
            </h2>
            <h2>您今后可以选择使用帐号<label style="color: red">${sysUser.username}</label>登录。请记住刚才设置的密码哦！<br/>
                点击确认来保存上述信息并完成用户校验，是否确认？
            </h2>


        </div>
    </div>
        <p class="center">
            <input type="button" id="toLogin"  class="btn" value="确 认">
            <input type="button" id="exit" class="btn" value="取 消">
        </p>
</div>
<div class="log-footer log-footer2" >
    <div class="mod2 center">
        <div class="other-tip">
            <a href="">收藏本站</a>|
            <a href="<c:url value='/static_page/about_sys_syn.jsp'/>" target="_blank">关于信息交换共享平台</a>|
            <a href="<c:url value='/static_page/xszn.jsp'/>" target="_blank">新手指南</a>|
            <a href="http://www.icinfo.cn/html/service.action" target="_blank">联系我们</a>

            <select onchange="if(this.value!='')window.open(this.value);this.options[0].selected=true">
                <option value="相关链接">相关链接</option>
                <option value="http://www.zjzwfw.gov.cn/">浙江政务服务网</option>
                <option value="http://www.gsxt.gov.cn/">国家企业信用信息公示系统</option>
                <option value="http://www.zjcredit.gov.cn/">信用浙江网</option>
                <option value="http://www.zj.gov.cn/">浙江省人民政府</option>
                <!--                 <option value="http://online.icinfo.cn/eppnet/">企业数字证书（电子执照）服务</option> -->
            </select>
        </div>
        <p>
            主办单位：浙江省人民政府办公厅&nbsp;&nbsp;&nbsp;&nbsp;承办单位：浙江省工商行政管理局<br/>
            技术支持：浙江汇信科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;<span class="light-black">技术服务热线：400-888-4636</span>&nbsp;&nbsp;&nbsp;&nbsp;建议使用1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果
    </div>
</div>
<script>
    window._CONFIG = {
        isLogin: '${isLogin}',
        isChecked:'${isChecked}'
    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/business/sysuser/sysuser_ck.js"></script>
</body>
</html>
