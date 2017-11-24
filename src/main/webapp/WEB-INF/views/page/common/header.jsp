<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<div class="header clearfix">
    <a href="#" class="logo fl">
        <img src="/img/syn/logo_js.png" alt="" class="fl"/>
        <h1 class="fl">
            <%--<span class="right mb2">杭州市市场监督管理局</span>--%>
            浙江省企业信用综合监管警示系统
        </h1>
    </a>
    <div class="hd-nav">
        <ul class="clearfix">
            <li class="popup">
                <a href="##">欢迎您！${sessionScope.session_sys_user.realName} （${sessionScope.session_sys_user.departMent.deptName}）<i class="xbt-icon trangle-icon"></i><em class="border-hide"></em></a>
                <div class="help client">
                    <p class="border-bottom"></p>
                    <dl>
                        <%--<dl>--%>
                        <%--<dd><a href="##" id="myAccount" ><b class="xbt-icon icon-user"></b>我的账户</a></dd>--%>
                        <%--<dd><a href="##" id="myPermission" ><b class="xbt-icon icon-power"></b>我的权限</a></dd>--%>
                        <dd><a href='javascript:void(0);' onclick="" id="passwordM" ><b class="xbt-icon icon-pwman"></b>密码管理</a></dd>
                        <%--</dl>--%>
                    </dl>
                </div>
            </li>
            <%--<li class="popup">--%>
            <%--|<a>消息<span class="xbt-icon num-bg">99+</span><i class="xbt-icon trangle-icon"></i><em class="border-hide"></em></a>--%>
            <%--<div class="news js-news">--%>
            <%--<dl>--%>
            <%--<dd>--%>
            <%--<h5><a href="##" target="_blank">[通知] 2016年年报工作正式开始</a><b class="xbt-icon"></b></h5>--%>
            <%--<span>[浙江省工商局] 2016-6-12</span>--%>
            <%--</dd>--%>
            <%--<dd>--%>
            <%--<h5><a href="##" target="_blank">[通知] 2016年年报工作正式开始</a></h5>--%>
            <%--<span>[浙江省工商局] 2016-6-12</span>--%>
            <%--</dd>--%>
            <%--<dd>--%>
            <%--<h5><a href="##" target="_blank"> 2016年年报工作正式开始</a></h5>--%>
            <%--<span>[浙江省工商局] 2016-6-12</span>--%>
            <%--</dd>--%>
            <%--</dl>--%>
            <%--<p>您还有<strong class="light">9</strong>条未读消息。<a href="##" target="_blank">查看所有消息</a></p>--%>
            <%--</div>--%>
            <%--</li>--%>
            <li>
                <a>查询</a>
            </li>
            <li class="popup">
                <a>工具<i class="xbt-icon trangle-icon"></i><em class="border-hide"></em></a>
                <div class="help js-tool">
                    <dl>
                        <dd><a href="##" target="_blank">法律法规</a></dd>
                        <dd><a href="##" target="_blank">政策公文</a></dd>
                        <dd><a href="##" target="_blank">许可清单</a></dd>
                        <dd><a href="##" target="_blank">案例荟萃</a></dd>
                    </dl>
                </div>
            </li>
            <li class="popup">
                <a>帮助<i class="xbt-icon trangle-icon"></i><em class="border-hide"></em></a>
                <div class="help js-help">
                    <dl>
                        <dd><a href="##" target="_blank"><b></b>新手入门</a></dd>
                        <dd><a href="##" target="_blank"><b class="xbt-icon icon-ques"></b>常见问题</a></dd>
                        <dd><a href="##" target="_blank"><b class="xbt-icon icon-serve"></b>服务支持</a></dd>
                        <dd><a href="##" target="_blank"><b class="xbt-icon icon-version"></b>版本信息</a></dd>
                        <dd><a href="##" target="_blank"><b class="xbt-icon icon-return"></b>意见反馈</a></dd>
                    </dl>
                </div>
            </li>
            <li><a class="js-logout">退出<i class="xbt-icon log-out"></i></a></li>
        </ul>
    </div>
</div>