<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/12
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar">
    <ul class="navbar">
        <li class="list-item">
            <a href="javascript:void(0);" class="info ${param.module=='zxlr'?'selected':''}">信息提供</a>
            <ul class="subnavbar" style="display: ${param.module !='zxlr'?'none':'block'}">
                <li><a href="/depsyn/punish/index" class="${param.menu=='zxlr'?'selected':''}">在线录入</a>
                </li>
                <li><a href="/depsyn/excel/template" class="${param.menu=='pldr'?'selected':''}">批量导入</a>
                </li>
                <li><a href="/depsyn/datainterface/index" class="${param.menu=='sjjk'?'selected':''}">数据接口</a>
                </li>
                <li><a href="/depsyn/dataswap/index" class="${param.menu=='sjjh'?'selected':''}">数据交换</a>
                </li>
            </ul>
        </li>
        <li class="list-item">
            <a href="javascript:void(0);" class="info ${param.module=='sgz'?'selected':''}">信息接收</a>
            <ul class="subnavbar" style="display: ${param.module !='sgz'?'none':'block'}">
                <li><a href="/depsyn/pubdtinfo" class="${param.menu=='sgz'?'selected':''}">双告知</a></li>
                <li><a href="/depsyn/nocreditview" class="${param.menu=='qymd'?'selected':''}">严重违法失信<br/>企业名单</a></li>
                <li><a href="/depsyn/toabonList" class="${param.menu=='ycjyml'?'selected':''}">经营异常名录</a></li>
                <li><a href="/depsyn/topunishList" class="${param.menu=='lhcjxx'?'selected':''}">联合惩戒信息</a></li>
            </ul>
        </li>
        <li class="list-item">
            <a href="javascript:void(0);" class="info ${param.module=='wtsjcl'?'selected':''}">信息管理</a>
            <ul class="subnavbar" style="display: ${param.module !='wtsjcl'?'none':'block'}">
                <li><a href="/depsyn/datamanage" class="${param.menu=='wtsjcl'?'selected':''}">本部门问题数据处理</a></li>
                <li><a href="/depsyn/infoview" class="${param.menu=='xxcxtj'?'selected':''}">本部门归集或接收<br/>信息的查询统计</a>
                </li>
                <li><a href="/depsyn/feedbackview" class="${param.menu=='sjyyfk'?'selected':''}">数据应用反馈</a></li>
                <li><a href="/depsyn/doEnBatchCompare" class="${param.menu=='plbd'?'selected':''}">批量比对</a></li>
            </ul>
        </li>
        <li class="list-item">
            <a href="javascript:void(0);" class="info ${param.module=='qygjcx'?'selected':''}">信息查询</a>
            <ul class="subnavbar" style="display: ${param.module !='qygjcx'?'none':'block'}">
                <li><a href="/depsyn/search/searchlist" class="${param.menu=='qygjcx'?'selected':''}">企业高级查询</a></li>
                <li><a href="/depsyn/search/searchPort" class="${param.menu=='cxjk'?'selected':''}">查询接口</a></li>
            </ul>
        </li>
    </ul>
</div>
