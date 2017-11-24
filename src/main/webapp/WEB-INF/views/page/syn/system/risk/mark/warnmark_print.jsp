<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>预警标识打印页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
<style type="text/css">
.hide{
		display: none;
}
</style>
<style media="print" type="text/css">
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
object { display: none}
.Noprint{ display:none; }
.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>
<style type="text/css">
	.height40{
		height: 40px;
	}
</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6，2，433，14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div class="pd20">
    <div class="print-nocard">
        <h3>预警提示标识信息</h3>
    </div>
    <div class="form-list">
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 标识名称：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt"  id="markName" value=""  >
                </div>
            </div>
            <label class="item-name col-2">标识类型：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                <input type="text" class="ipt-txt" id="markType" value="" >
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">标识级别：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                  <input type="text" class="ipt-txt" id="markClass" value="" >
                </div>
            </div>
            <label class="item-name col-2"><span style="color: red;">*</span> 标识有效期：</label>
            <div class="col-3">
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt"  id="markStartDate" value="" />
                </div>
                <span class="item-txt col-2"><i class="line-icon"></i></span>
                <div class="ipt-box col-5">
                    <input type="text" class="ipt-txt" id="markEndDate" value="" />
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 标识内容：</label>
            <div class="col-8">
                <div class="ipt-box">
                    <input type="text" style="width:826px;" class="ipt-txt" id="markContent" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">指定提示方式：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                   <input type="text" class="ipt-txt" id="markAppointWay" value="">
                </div>
            </div>
            <label class="item-name col-2">指定提示部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                 <input type="text"  id="markAppointDept"  class="ipt-txt" style="height: 30px;" name="markAppointDept" value=""/>
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2">设置部门：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text"  id="markSetDept"  class="ipt-txt" style="height: 30px;" value=""  />
                </div>
            </div>
            <label class="item-name col-2">设置时间：</label>
            <div class="col-3">
                <div class="ipt-box col-12">
                    <input type="text" class="ipt-txt" id="markSetDate" value="">
                </div>
            </div>
        </div>
        <div class="form-item clearfix">
            <label class="item-name col-2"><span style="color: red;">*</span> 设置部门联系人：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="setDeptContact" value="">
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
            <label class="item-name col-2">传真：</label>
            <div class="col-3">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" id="fax" value="">
                </div>
            </div>
            <label class="item-name col-2">邮箱：</label>
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
<script src="<c:url value="/js/syn/system/risk/mark/warnmark_print.js"/>"></script> 
<script src="<c:url value="/js/reg/server/orderreformset/orderreformsetaudit_print_main.js"/>"></script> 
<script>
    window._CONFIG = {
    		_adminGuideType:'${orderReformSet.adminGuideType}',//整改项目 
    		_adminGuideDocType:'${orderReformSet.adminGuideDocType}',  //通知书送达方式
    		_chooseDay:'${chooseDay}' ,
    		_viewFlag:'${viewFlag}'
     } 
</script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>