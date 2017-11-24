<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mod header">
    <a href="##"  target="_blank">
 <%--       <img src="../../../img/reg/client/reg-c-logo.jpg" alt="">--%>
        <img src="<c:url value="/img/reg/client/reg-c-logo.jpg"/>" alt="">
    </a>
    <div class="hd-nav">
        <ul class="clearfix">
            <li>
                <a href="##">客户端<i class="tiny-icon"></i> </a>
                <div class="client js-client">
                    <i class="tiny-icon trangle"></i>
                    <a href="##" class="download btn-icon">安装客户端软件</a>
                    <p>第一时间获取异常预警，不再担心错过工商重要消息通告。</p>
                    <h4 class="clearfix">三步完成预警信息订阅 <a href="##"  target="_blank" class="fr">详细教程</a></h4>
                  <%--  <img src="../../../img/reg/client/reg-client-class.jpg" alt="">--%>
                   <img src="<c:url value="/img/reg/client/reg-client-class.jpg"/>" alt="">
                </div>
            </li>
            <li>
                <a>消息<span class="tiny-icon">99+</span><i class="tiny-icon"></i></a>
                <div class="news js-news">
                    <i class="tiny-icon trangle"></i>
                    <dl>
                        <dd>
                            <h5><a href="javascript:void(0)"  target="_blank">[通知] 2016年年报工作正式开始</a><b class="tiny-icon"></b></h5>
                            <span>[浙江省工商局] 2016-6-12</span>
                        </dd>
                        <dd>
                            <h5><a href="javascript:void(0)"  target="_blank">[通知] 2016年年报工作正式开始</a></h5>
                            <span>[浙江省工商局] 2016-6-12</span>
                        </dd>
                        <dd>
                            <h5><a href="javascript:void(0)"  target="_blank"> 2016年年报工作正式开始</a></h5>
                            <span>[浙江省工商局] 2016-6-12</span>
                        </dd>
                    </dl>
                    <p>您还有<strong class="light">9</strong>条未读消息。<a href="javascript:void(0)"  target="_blank">查看所有消息</a></p>
                </div>
            </li>
            <li>
                <a>帮助<i class="tiny-icon"></i></a>
                <div class="help js-help">
                    <i class="tiny-icon trangle"></i>
                    <dl>
                        <dd><a href="javascript:void(0)"  target="_blank"><b class="tiny-icon icon-video"></b>视频教程</a></dd>
                        <dd><a href="javascript:void(0)"  target="_blank"><b class="tiny-icon icon-ques"></b>常见问题</a></dd>
                        <dd><a href="javascript:void(0)"  target="_blank"><b class="tiny-icon icon-online"></b>联系客服</a></dd>
                        <dd><a href="<c:url value='/reg/client/yr/ent/consult/toClientConsultListPage' />"  target="_blank"><b class="tiny-icon icon-online"></b>异议申请</a></dd>
                    </dl>
                </div>
            </li>
            <li>
                <a href="javascript:void(0)"
                          onclick="layer.confirm('您确定要退出吗?', { btn: ['确定', '取消'],icon: 7, title: '提示'}, function () {
                             window.location.replace('<c:url value="/reg/client/login/loginOut"/>?logoutUrl='+window.location.href);
                         });">退出</a>

            </li>
        </ul>
    </div> 
</div>