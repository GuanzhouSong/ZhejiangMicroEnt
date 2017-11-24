<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>企业详情年报信息页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../pub/common/enterprise.jsp"></jsp:include>
<div class="mod1366 info-tb-hd">
    <div class="logo"><a href="http://118.178.31.19/client/entsearch/toEntSearch"></a></div>
</div>
<div class="mb20 mt20">

    <div class="mod detail-main">
        <div class="tab-panel">
            <div class="mod-bd-panel_company pt10">
                <div class="abnorm-title pos-rel">
                        <h3>泰康有限公司</h3>
                        <a href="javascript:void(0)" class="wycomplain">我要异议</a>
                </div>
                <h3 class="i-title">
                    <i></i>企业公告信息
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <em>• </em>
                        <span class="title">企业名称：</span>
							<span>
								保险公司
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">农专社名称：</span>
                        <span></span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">登记机关：</span>
							<span>
								保险公司
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">公告期：</span>
                        <span class="light bold">2017年1月5日-2017年2月18日</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">全体投资人承诺书：</span>
							<span>
								<a href="#" class="light-yellow">查看详情</a>
							</span>
                    </li>
                </ul>
            </div>

            <!-- 异议信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>异议信息
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th width="68">序号</th>
                        <th>异议申请人</th>
                        <th width="388">异议内容</th>
                        <th>异议时间</th>
                    </tr>
                    </thead>
                    <tbody id="table-sfc_branchinfo">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>


            <!-- 简易注销结果信息 -->
            <div class="mod-bd-panel_company" id="nianbao">
                <h3 class="i-title">
                    <i></i>简易注销结果
                </h3>
                <table class="table-common mb20">
                    <thead>
                    <tr>
                        <th>简易注销结果</th>
                        <th>公告申请日期</th>
                    </tr>
                    </thead>
                    <tbody id="table-sfc_updateinfo">
                    </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
                            <span class="page-total">共查询到 <em id="_total_sfc_updateinfo"></em> 条信息，共 <em
                                    id="_pageNum_sfc_updateinfo"></em> 页</span>
                    <div id="pagination_sfc_updateinfo" class="pagination">
                    </div>
                </div>
            </div>
        </div>
    </div>



</body>
</html>