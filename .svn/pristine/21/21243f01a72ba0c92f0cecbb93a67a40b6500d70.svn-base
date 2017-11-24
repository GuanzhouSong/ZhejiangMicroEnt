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
    <title>抄告抄送打印页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
<style type="text/css">
.ml25r55 {
    display: inline-block;
    margin: 0 55px 0 25px;
}
.fr {
    display: inline-block;
    margin: 0 55px 0 25px;
}
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
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3>
                                <p id="copytitle">部门抄告单（<span id="copyTypeName"></span>）</p>
                                <span>抄告单编号：<span id="copyFormNo"></span></span>
                            </h3>
                            <p class="right print-data">抄告发起日期：<span id="copyDate"></span>
                            <form id="content_form">
                                <div class="bg-gray3">
                                    <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                        <tbody>
                                        <tr>
                                            <td class="tb-form-hd" width="11.7%">
                                                抄告接收部门
                                            </td>
                                            <td width="52%">
                                                <div class="ipt-box" id="acceptDeptNames">
                                                </div>
                                            </td>
                                            <td class="tb-form-hd" width="15%">
                                                抄告类型
                                            </td>
                                            <td>
                                                <div class="ipt-box" id="copyType">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">涉嫌违法事项</td>
                                                <td>
                                                    <div class="ipt-box" id="illegalItem">
                                                    </div>
                                                </td>


                                            <td class="tb-form-hd">
                                                信息来源
                                            </td>
                                            <td>
                                                <div class="radio-box" id="copyInfoFrom" >
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd"><div class="center">
                                                <input id="add_detail" type="button"
                                                       style="position:static;"
                                                       class="btn btn-xs" value="涉嫌违法当事人信息">
                                            </div></td>
                                            <td colspan="3" class="pd0">
                                                <table id="illegal_table" class="inner-table center">
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">具体违法情况</td>
                                            <td colspan="3" class="pd3">
                                                <div><textarea style="width: 99%;" name="illegalCase" id="illegalCase" cols=" "
                                                               rows="5" readonly></textarea></div>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="tb-form-hd">证据资料上传
                                                <div class="light bold">单个文件不超过20M</div>
                                            </td>
                                            <td colspan="3" class="pd1">
                                                <div id="filelabel">
                                                </div>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="tb-form-hd">
                                                抄告发起部门
                                            </td>

                                            <td width="52%">
                                                <div class="ipt-box" id="copyDepartName">
                                                </div>
                                            </td>
                                            <td class="tb-form-hd" width="160px">
                                                是否需要反馈处理结果
                                            </td>
                                            <td>
                                                <div class="radio-box" id="feedbackNeed">
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">抄告发起部门联系人</td>
                                            <td >
                                                <div class="ipt-box" id="copyDepartPerson">
                                                </div>
                                            </td>
                                            <td class="tb-form-hd">
                                                联系电话（必填）
                                            </td>
                                            <td>
                                                <div class="ipt-box" id="copyDepartTel">
                                                </div>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tb-form-hd">
                                                传真
                                            </td>
                                            <td>
                                                <div class="ipt-box" id="copyDepartFax">
                                                </div>

                                            </td>
                                            <td class="tb-form-hd">
                                                电子邮件
                                            </td>
                                            <td>
                                                <div class="ipt-box" id="copyDepartMail">
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>

                                    <table id="sh_table" style="display: none;" border="0" cellspacing="0" cellpadding="0"
                                       class="table-form mt10">
                                    <tr>
                                        <td class="tb-form-hd" width="11.7%">审核结果</td>
                                        <td width="31.5%">
                                            <div class="ipt-box" id="checkResult">
                                            </div>
                                        </td>
                                        <td class="tb-form-hd" width="8.4%">审核人</td>
                                        <td>
                                            <div class="ipt-box" id="checkPerson">
                                            </div>
                                        </td>
                                        <td class="tb-form-hd" width="10%">审核日期</td>
                                        <td>
                                            <div class="ipt-box" id="checkDate">
                                                </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="tb-form-hd">具体审核意见</td>
                                        <td colspan="5" class="pd3">
                                        <div>
                                        <textarea style="width: 99%;" id="checkOpinion" cols=" " rows="5" readonly></textarea>
                                        </div>
                                        </td>
                                    </tr>

                                </table>
                                    
						<table id="fk_table" style="display: none;" border="0" cellspacing="0" cellpadding="0" class="table-form mt10"> 
							<tr>
								<td class="tb-form-hd" width="10%">反馈人</td>
								<td>
									<div class="ipt-box" id="feedbackPerson">
									</div>
								</td>
							</tr>
							<tr>
								<td class="tb-form-hd">反馈意见</td>
								<td class="pd3">
									<div>
										<textarea style="width: 99%;" name="feedback" id="feedback" cols=" " rows="5" readonly></textarea>
									</div>
								</td>
							</tr>	
						</table>
						
						<table id="fkopt_table" style="display: none;" border="0" cellspacing="0" cellpadding="0" class="table-form mt10">
						</table>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
    </div>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/copysend/cgcs_print.js"/>"></script> 
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>
</body>
</html>