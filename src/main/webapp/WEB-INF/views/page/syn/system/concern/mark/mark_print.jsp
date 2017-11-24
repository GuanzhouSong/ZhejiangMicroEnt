<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>关注服务打印页面</title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
</head>
<body class="pd10">

<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6，2，433，14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>


<div class="pd20">
    <div class="print-nocard mb20">
        <h3>关注服务标识信息</h3>
    </div>
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 关注服务标识名称：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="markName" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                  <input type="text" class="ipt-txt" id="markClass" value="">
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 关注服务标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" id="markStartDate" value="">
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" id="markEndDate" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 关注服务标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <textarea rows="5" id="markContent"></textarea>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">关注服务标识适用地区：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                   <input type="text" class="ipt-txt" id="markUseArea" value="">
                </div>
            </div>
            <label class="item-name col-2">关注服务标识状态：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" id="markState" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                   <input type="text" class="ipt-txt" id="markAppointWay" value="">
                </div>
            </div>
            <label class="item-name col-2"> 设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
	                <input type="text"  class="ipt-txt" style="height: 30px;" id="markSetDept" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3">标识指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept"  class="ipt-txt" style="height: 30px;"value=""/>
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" id="markSetDate" value=""  />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"><span style="color: red;">*</span> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="setDeptContact"value="">
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 联系电话：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="tel" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-3"> 传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="fax" value="">
                </div>
            </div>
            <label class="item-name col-2"> 邮箱：</label>
            <div class="col-3">
                <div class="ipt-box">
                     <input type="text" class="ipt-txt" id="email" value="" >
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/concern/mark/mark_print.js"/> "></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>