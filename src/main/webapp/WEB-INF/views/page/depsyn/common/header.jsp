<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/12
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="header mod">
    <img src="/img/pub-syn/top-img.png" alt="">
    <div class="txt">${sessionScope.dep}</div>
    <div class="header-tips">
        <div class="fl">
            <span><i class="icon icon1"></i><fmt:formatDate value="${sessionScope.today}" pattern="yyyy年MM月dd日" /></span>
            <span><i class="icon icon2"></i>您好！${sessionScope.dep} ${sessionScope.session_sys_user.realName}</span>
        </div>
        <div class="fr">
            <a href=""><i class="icon icon3"></i>修改密码</a>
            <a id='js-user-logout' href="javascript:void(0)"><i class="icon icon4"></i>用户退出</a>
        </div>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/depsyn/common/common_main.js"></script>
