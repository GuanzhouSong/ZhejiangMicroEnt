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
                <h3 class="i-title">
                    <i></i>异议对象
                </h3>
                <ul class="encounter-info clearfix">
                    <li>
                        <em>• </em>
                        <span class="title">异议对象：</span>
							<span>
								保险公司
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">统一社会信用代码/注册号：</span>
                        <span></span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">登记机关：</span>
							<span>
								保险公司
							</span>
                    </li>

                </ul>
            </div>

            <!-- 异议信息 -->
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>异议申请人信息
                </h3>
                <div>
                    <ul class="abnor-tab clearfix">
                        <li class="active">自然人</li>
                        <li>企业</li>
                        <li>其它相关单位</li>
                    </ul>
                    <div class="abnor-cont">
                        <div>
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">姓名*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证号码*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证件正面照片*</td>
                                    <td><input type="text" class="w320"><input type="button" value="上传" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证件背面照片*</td>
                                    <td><input type="text" class="w320"><input type="button" value="上传" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">移动电话*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320"><input type="button" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                            <li><span>有债权债务未结清</span><input type="checkbox"></li>
                                            <li><span>属于涉及国家规定实施准入特别管理措施的外商投资企业</span><input type="checkbox"></li>
                                            <li><span>正在被列入企业经营异常名录或严重违法失信企业名单</span><input type="checkbox"></li>
                                            <li><span>存在股权（投资权益）被冻结，出质或动产抵押等情形</span><input type="checkbox"></li>
                                            <li><span>有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的</span><input type="checkbox"></li>
                                            <li><span>企业所属的非法人分支机构未办理注销登记</span><input type="checkbox"></li>
                                            <li><span>曾被终止简易注销程序</span><input type="checkbox"></li>
                                            <li><span>属于法律，行政法规或者国务院决定规定在注销登记前需经批准的企业</span><input type="checkbox"></li>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" value="确定" class="confirm-btn"></p>
                        </div>
                        <div style="display: none">
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">企业名称*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">统一社会信用代码/注册号*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">法定代表人（负责人）*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">法定代表人（负责人）证件号码*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">营业执照（正本）证件照片*</td>
                                    <td><input type="text" class="w320"><input type="button" value="上传" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员姓名*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员移动电话*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320"><input type="button" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                            <li><span>有债权债务未结清</span><input type="checkbox"></li>
                                            <li><span>属于涉及国家规定实施准入特别管理措施的外商投资企业</span><input type="checkbox"></li>
                                            <li><span>正在被列入企业经营异常名录或严重违法失信企业名单</span><input type="checkbox"></li>
                                            <li><span>存在股权（投资权益）被冻结，出质或动产抵押等情形</span><input type="checkbox"></li>
                                            <li><span>有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的</span><input type="checkbox"></li>
                                            <li><span>企业所属的非法人分支机构未办理注销登记</span><input type="checkbox"></li>
                                            <li><span>曾被终止简易注销程序</span><input type="checkbox"></li>
                                            <li><span>属于法律，行政法规或者国务院决定规定在注销登记前需经批准的企业</span><input type="checkbox"></li>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" value="确定" class="confirm-btn"></p>
                        </div>
                        <div style="display: none">
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">单位名称*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">统一社会信用代码/注册号*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">单位证照（正面）照片*</td>
                                    <td><input type="text" class="w320"><input type="button" value="上传" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员姓名*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员移动电话*</td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320"><input type="button" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                            <li><span>有债权债务未结清</span><input type="checkbox"></li>
                                            <li><span>属于涉及国家规定实施准入特别管理措施的外商投资企业</span><input type="checkbox"></li>
                                            <li><span>正在被列入企业经营异常名录或严重违法失信企业名单</span><input type="checkbox"></li>
                                            <li><span>存在股权（投资权益）被冻结，出质或动产抵押等情形</span><input type="checkbox"></li>
                                            <li><span>有正在被立案调查或采取行政强制，司法协助，被予以行政处罚等情形的</span><input type="checkbox"></li>
                                            <li><span>企业所属的非法人分支机构未办理注销登记</span><input type="checkbox"></li>
                                            <li><span>曾被终止简易注销程序</span><input type="checkbox"></li>
                                            <li><span>属于法律，行政法规或者国务院决定规定在注销登记前需经批准的企业</span><input type="checkbox"></li>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" value="确定" class="confirm-btn"></p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>


</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('.abnor-tab li').click(function () {
            $(this).addClass('active').siblings().removeClass('active');
            $('.abnor-cont div').eq($(this).index()).show().siblings().hide();
        })
    })
</script>
</body>
</html>