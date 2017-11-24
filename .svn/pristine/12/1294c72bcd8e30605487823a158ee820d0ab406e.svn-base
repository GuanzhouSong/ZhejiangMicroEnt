<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政指导</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/printer.css">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <style media="print" type="text/css">
        .Noprint {
            display: none;
        }
    </style>
    <style type="text/css">
        .height40 {
            height: 40px;
        }

        h1 {
            font-family: "黑体";
            font-size: 22pt;
            height: 50px;
            line-height: 50px;
            font-weight: normal;
            letter-spacing: 8px;
        }

        h2 {
            font-size: 14pt;
            line-height: 50px;
            height: 50px;
            font-weight: normal;
        }

        .djjg, .gxdw {
            font-size: 10pt;
            padding: 0 10pt;
        }

        p {
            text-indent: 2em;
        }

        p, span, div {
            line-height: 37px;
            font-family: "宋体";
            font-size: 14pt;
        }

        hr {
            display: block;
            -webkit-margin-before: 0.5em;
            -webkit-margin-after: 0.5em;
            -webkit-margin-start: auto;
            -webkit-margin-end: auto;
            border-style: inset;
            border-width: 1px;
        }
    </style>
</head>
<script type="text/javascript">
var _adminguideitem='${govguide.adminguideitem}';
var _fromtype='${fromtype}';
</script>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
 <c:set value="${fn:split(govguide.adminguidecercontent,'&')}" var="adminguidecercontent"/>
<div style="width:560px; margin:0 auto;">
    <h1 class="center">浙江省工商行政管理局</h1>
    <h1 class="center">行政指导/温馨提示书</h1>
    <h2 class="center">${govguide.pendecno}</h2>
    <p class="left">${govguide.entname}（注册号 ${govguide.regno}）：</p>
<p>
  <div id="adminguidecercontent-1"${govguide.adminguideitem==1?'':'style="display:none"'}>
                 你企业因<c:forEach var="p" items="${adminguidecercontent}"  begin="0" end ="0">${p}</c:forEach>的情况，特对你企业提醒提示如下:
               <c:forEach var="p" items="${adminguidecercontent}"  begin="1" end ="1">${p}</c:forEach>
  </div>
  <div id="adminguidecercontent-2"${govguide.adminguideitem==2?'':'style="display:none"'}>
              根据公司章程和公司登记相关法律法规的规定，你公司投资人（股东）应当于<c:forEach var="p" items="${adminguidecercontent}"  begin="0" end ="0">${p}</c:forEach>前缴纳出资款<c:forEach var="p" items="${adminguidecercontent}"  begin="1" end ="1">${p}</c:forEach>（其中：
                <c:forEach var="p" items="${adminguidecercontent}"  begin="2" end ="2">${p}</c:forEach>），出资期限即将届满，
               特别提醒：<c:forEach var="p" items="${adminguidecercontent}"  begin="3" end ="3">${p}</c:forEach>
             如果法定出资期限届满你公司投资人（股东）未依法足额出资，你公司未主动采取措施办理减资、
             变更或注销手续的，工商部门将依法对相关投资人（股东）及你公司实施行政处罚。
  </div>
  <div id="adminguidecercontent-3" ${govguide.adminguideitem==3?'':'style="display:none"'}>
              你企业经营范围中涉及的专项审批许可证：<br/>
             <c:forEach var="p" items="${adminguidecercontent}"  begin="0" end ="0">${p}</c:forEach>
               有效期即将届满，根据企业登记管理相关法律法规的规定，相关许可证失效后继续从事该许可项目的，
               或未取得合法有效专项审批许可证擅自从事相关经营项目的，依照无证无照经营行为予以定性查处。
               因此，建议你企业在许可证有效期届满之前，依法重新申领有关专项审批许可证，
               或者到工商部门办理相关经营范围变更手续取消该许可经营项目。
   </div>
   <div id="adminguidecercontent-4"${govguide.adminguideitem==4?'':'style="display:none"'}>
              你企业章程规定的经营期限即将届满，根据企业登记管理相关法律法规的规定，经营期限到期的企业，应当依法清算注销。
               <br/>如你企业需要继续经营的，建议你企业在期限到期之前，向企业登记机关（工商部门）申请办理经营期限延期变更登记手续。
               <br/>经营期限到期后擅自从事经营活动的，依照无证无照经营予以定性查处。
   </div>
   <div id="adminguidecercontent-5"${govguide.adminguideitem==5?'':'style="display:none"'}>
            据了解，你企业已长期未正常开展经营活动，根据《公司法》、《企业法人登记管理条例》等企业登记管理相关法律法规的规定，企业领取执照后6个月未开业或自行停业时间超过6个月以上的，工商部门可以依法吊销企业的营业执照。
            <br/>因此，建议你企业予以重视，加强企业管理，积极从事经营活动，以避免承担因长期未经营而产生的受罚风险。
   </div>
   <div id="adminguidecercontent-6"${govguide.adminguideitem==6?'':'style="display:none"'}>
           你公司已办理清算备案，进入清算阶段。现对你公司建议提示如下：
           <br/>1.尽快完成清算工作，并按照规定办理营业执照注销登记。
           <br/>2.进入清算程序的企业，在办理注销手续前，应当办理年检手续。
    </div>
</p>
<p><span class="underline"></span></p>
<p></p>
<p></p>
<p class="left">联系人：${govguide.linkman}   联系电话：${govguide.tel}</p>
<p class="right">${now}</p>
<hr>
<p class="center">
    <span class="djjg">登记机关：${govguide.regorgname}</span>
    <span class="gxdw">管辖单位：${govguide.localadmname}</span>
</p>
</div>
<div class="main center" style="margin-top:40px">
   <div style="width:630px; margin:0 auto;">
                    <h1 class="center">送达回证</h1>
                    <table cellpadding="0" cellspacing="0" class="center table-horizontal">
                        <tbody><tr>
                            <td height="40" colspan="4">
                                ${govguide.entname}（注册号 ${govguide.regno}）
                            </td>
                        </tr>
                        <tr>
                            <td height="40" width="90" align="center">文书类型</td>
                            <td width="130">行政指导书</td>
                            <td width="90" align="center">文号</td>
                            <td >${govguide.pendecno}</td>
                        </tr>
                        <tr>
                            <td height="40" align="center">送达地点</td>
                            <td></td>
                            <td align="center">送达方式</td>
                            <td><input type="checkbox">邮寄
                            <input type="checkbox">直接送达
                            <input type="checkbox">其他</td>
                        </tr>
                        <tr>
                            <td height="124" align="center">收件人</td>
                            <td align="right" valign="bottom">
                                <div class="sign">
                                    <p class="center">（签名或者盖章）</p>
                                    <p class="center">年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
                                </div>
                            </td>
                            <td align="center">见证人</td>
                            <td align="right" valign="bottom">
                                <div class="sign">
                                    <p class="center">（签名或者盖章）</p>
                                    <p class="center">年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="83" align="center">送达人</td>
                            <td colspan="3" align="right" valign="bottom">
                                <div class="sign">
                                    <p class="center">（签名或者盖章）</p>
                                    <p class="center">年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</p>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="40" align="center">备注</td>
                            <td colspan="3"></td>
                        </tr>
                    </tbody></table>
                </div>
                <p class="PageNext">&nbsp;</p>


        </div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/govguide/govguideview_print.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>