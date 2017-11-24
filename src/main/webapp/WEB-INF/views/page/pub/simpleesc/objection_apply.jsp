<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异议申请人信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../common/enterpriseforsimpleesc.jsp"></jsp:include>
<div class="mb20 mt20">
<input type="hidden" value="${erEscAppinfo.entName }" id="erEscEntName">
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
								${erEscAppinfo.entName }
							</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">统一社会信用代码/注册号：</span>
                        <span>${(!empty erEscAppinfo.uniSCID)?erEscAppinfo.uniSCID:erEscAppinfo.regNO}</span>
                    </li>
                    <li>
                        <em>• </em>
                        <span class="title">登记机关：</span>
							<span>
								${erEscAppinfo.regOrgName }
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
                        <form id="form0" method="post">
                        	<input type="hidden" id="objection" name="objection"/>
                            <input type="hidden" id="prefix" name="priPID" value="${erEscAppinfo.priPID }"/>
                            <input type="hidden" id="encryPriPID" value="${erEscAppinfo.encryPriPID }"/>
                            <input type="hidden" id="regOrg" name="regOrg" value="${erEscAppinfo.regOrg }"/>
                            <input type="hidden" id="localAdm" name="localAdm" value="${erEscAppinfo.localAdm }"/>
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">姓名*</td>
                                    <td><input type="text" name="name" id="name"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证号码*</td>
                                    <td><input type="text" name="cerNO" id="cerNO"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证件正面照片*</td>
                                    <td>
                                    	<input type="hidden" name="certificatesPic" id="certificatesPic">
	                                    <input id="btnFile_1" type="file" class="w320" name="btnFile">
	                                    <input type="button" id="btnUpload_1" value="上传" class="btn">
										<span id="uploadState_1" style="color:red;display:none">上传中....</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">身份证件背面照片*</td>
                                    <td>
                                    	<input type="hidden" name="bcertificatesPic" id="bcertificatesPic">
	                                    <input id="btnFile_2" type="file" class="w320" name="btnFile">
	                                    <input type="button" id="btnUpload_2" value="上传" class="btn">
										<span id="uploadState_2" style="color:red;display:none">上传中....</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">移动电话*</td>
                                    <td><input type="text" name="mobTel" id="mobTel"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320" name="validateCode" id="validateCode"><input type="button" id="getCode" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                        	<c:forEach var="codeObjection" items="${codeObjections }">
                                            	<li><span> ${codeObjection.content } </span><input type="checkbox" value="${codeObjection.content }"></li>
                                        	</c:forEach>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" id="btn0" value="确定" class="confirm-btn"></p>
                        </form>
                        </div>
                        <div style="display: none">
                        <form id="form1" method="post">
                        	<input type="hidden" id="objection1" name="objection"/>
                            <input type="hidden" id="prefix1" name="priPID" value="${erEscAppinfo.priPID }"/>
                            <input type="hidden" id="encryPriPID1" value="${erEscAppinfo.encryPriPID }"/>
                            <input type="hidden" id="regOrg1" name="regOrg" value="${erEscAppinfo.regOrg }"/>
                            <input type="hidden" id="localAdm" name="localAdm" value="${erEscAppinfo.localAdm }"/>
                            <input type="hidden" name="uniSCID" id="uniSCID1">
                            <input type="hidden" name="regNO" id="regNO1">
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">企业名称*</td>
                                    <td><input type="text" name="entName" id="entName"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">统一社会信用代码/注册号*</td>
                                    <td><input type="text" id="unireg1"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">法定代表人（负责人）*</td>
                                    <td><input type="text" name="leRep" id="leRep"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">法定代表人（负责人）证件号码*</td>
                                    <td><input type="text" name="cerNO" id="cerNO1"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">营业执照（正本）证件照片*</td>
                                    <td>
                                    	<input type="hidden" name="certificatesPic" id="certificatesPic3">
	                                    <input id="btnFile_3" type="file" class="w320" name="btnFile">
	                                    <input type="button" id="btnUpload_3" value="上传" class="btn">
										<span id="uploadState_3" style="color:red;display:none">上传中....</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员姓名*</td>
                                    <td><input type="text" name="name" id="name1"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员移动电话*</td>
                                    <td><input type="text" name="mobTel" id="mobTel1"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320" name="validateCode" id="validateCode1"><input type="button" id="getCode1" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                        	<c:forEach var="codeObjection" items="${codeObjections }">
                                            	<li><span> ${codeObjection.content } </span><input type="checkbox" value="${codeObjection.content }"></li>
                                        	</c:forEach>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" id="btn1" value="确定" class="confirm-btn"></p>
                            </form>
                        </div>
                        <div style="display: none">
                        <form id="form2"  method="post">
                        	<input type="hidden" id="objection2" name="objection"/>
                            <input type="hidden" id="prefix2" name="priPID" value="${erEscAppinfo.priPID }"/>
                            <input type="hidden" id="encryPriPID2" value="${erEscAppinfo.encryPriPID }"/>
                            <input type="hidden" id="regOrg2" name="regOrg" value="${erEscAppinfo.regOrg }"/>
                            <input type="hidden" id="localAdm" name="localAdm" value="${erEscAppinfo.localAdm }"/>
                            <input type="hidden" name="uniSCID" id="uniSCID2">
                            <input type="hidden" name="regNO" id="regNO2">
                            <table class="table-common">
                                <tr>
                                    <td class="abnor-title">单位名称*</td>
                                    <td><input type="text" name="entName" id="entName2"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">统一社会信用代码/单位证照号码*</td>
                                    <td><input type="text" id="unireg2"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">单位证照（正面）照片*</td>
                                    <td>
                                    	<input type="hidden" name="certificatesPic" id="certificatesPic4">
	                                    <input id="btnFile_4" type="file" class="w320" name="btnFile">
	                                    <input type="button" id="btnUpload_4" value="上传" class="btn">
										<span id="uploadState_4" style="color:red;display:none">上传中....</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员姓名*</td>
                                    <td><input type="text" name="name" id="name2"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">联络员移动电话*</td>
                                    <td><input type="text" name="mobTel" id="mobTel2"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">验证码*</td>
                                    <td><input type="text" class="w320" name="validateCode" id="validateCode2"><input type="button" id="getCode2" value="获取验证码" class="btn"></td>
                                </tr>
                                <tr>
                                    <td class="abnor-title">异议内容*</td>
                                    <td>
                                        <ul class="abnor-content">
                                        	<c:forEach var="codeObjection" items="${codeObjections }">
                                            	<li><span> ${codeObjection.content } </span><input type="checkbox" value="${codeObjection.content }"></li>
                                        	</c:forEach>
                                        	<li><span>其他</span>&nbsp;&nbsp;<textarea style="margin: 0px; width: 443px; height: 69px;" type="text" value="" maxlength="2000" id="otherContent" name="otherContent"></textarea>
                                        </ul>
                                    </td>
                                </tr>
                            </table>
                            <p class="center"><input type="button" id="btn2" value="确定" class="confirm-btn"></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/simpleesc/objection_apply.js"></script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $('.abnor-tab li').click(function () {
            $(this).addClass('active').siblings().removeClass('active');
            $('.abnor-cont div').eq($(this).index()).show().siblings().hide();
        });
    })
</script>
</body>
</html>