<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<%-- <jsp:include page="common/header.jsp"></jsp:include> --%>

<%--联络员变更 start--%>


<%--联络员详情或变更 start--%>






<%-- 首页tab切换主体开始 --%>
<div class="mod index-cont mt10" style="display: none">
    <div class="client-index-tab" data-component="tab">
        <div class="mb20 mt100">
            <div class="tab-panel">
                <%--简易注销公告填写--%>
                <div id="simpleapply" class="mod thick-border logout-info">
                    <div class="mod-hd">
                        <div class="title">
                            <h3>简易注销：全体投资人承诺书补传</h3>
                            <span class="light">输入企业名称，图片上传后，请务必点击保存！</span>
                        </div>
                    </div>
                    <div class="mod-bd">
                        <form id="simapplyform">
                        <table class="table-public mt5">
                            <tbody>
                            <tr>
                                <td class="focus-state">
                                    <div class="item-name w168">企业名称</div>
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" id="entName" name="entName" value="" class="ipt-txt w308" 
                                        style="padding-left: 5px;text-align: left;">
                                        <i class="icon-close"></i>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="item-name w168">全体投资人承诺书</div>
                                    <input type="file" id="commitment_file" name="file" class="left ipt-txt w650">
                                    <input type="hidden" name="commitment" id="uploadurl">
                                    <div class="ipt-box js-ipt-box">
                                        <input type="text" value="" id="showfile" class="left ipt-txt w650" placeholder="" style="display:none">
                                        <input type="button" id="uploadfile" value="上传" class="btn-common btn-upload">
                                        <input type="button" id="reloadfile" value="重新上传" class="btn-common btn-upload" style="display:none">
                                        <input type="button" id="uploading" value="上传中..." class="btn-common btn-upload" style="display:none">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="item-name w168"></div>
                                    <div class="ipt-box js-ipt-box">
                                       <span class="light mt10"> 
	                                                                                                   注：经全体投资人签字确认的承诺书请扫描或拍照后以图片JPG格式进行上传，上传的单张图片大小不超过1M。
                                </span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" >
                                    <p class="center mt10 mb10">
                                        <input type="button" value="保 存" state="01"  class="btn-common mr5 apply-save">
                                    </p>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        </form>
                    </div>
                </div>
                <%--简易注销公告详情--%>
            </div>
        </div>
    </div>
</div>

<div class="simConfirm" style="display: none">
  <div class="mt20 ml10">
         请输入操作密码：
    <input type="password" id="password" name="" />
    <div class="center mt10">
    <input type="button" id="confirm" class="btn-common mr10" value="确认">
  </div>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="<c:url value="/js/pub/simpleesc/upload.js"/>"></script>
</body>
</html>
