<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" href="/css/reg.server.css">
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

        .underline {
            text-decoration: underline;
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
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div style="width:650px; margin:0 auto;">
    <h1 class="center">${orderReformSet.regOrgName}</h1>
    <h1 class="center">责令整改通知书</h1>
    <h2 class="center">${orderReformSet.penDecNo}</h2>
   <!-- 其他 -->
   <c:if test="${orderReformSet.adminGuideType=='0'}">
       <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）：</span>
       <p class="left"> 经查，你企业因<span class="underline">${guideContentArr[0] }</span>行为，违反了
	   <span class="underline">${guideContentArr[1] }</span>的规定,属于<span class="underline">
	   ${guideContentArr[2]}</span>，根据中华人民共和国 <span class="underline">${guideContentArr[3] }</span>，
	        现责令你企业在<span class="underline">${chooseDay=='3'?'三个月内':''}
	   ${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}${chooseDay=='15'?'十五内':''}</span>
                    改正上诉违法行为，责令改正具体事项如下：<span class="underline">${guideContentArr[4]}</span>
	   </p>
	   <p>如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[5]}或者${guideContentArr[6]}人民政府申请
	          复议；也可以在六个月内依法向人民法院提起诉讼。
	   </p>
   </c:if>
   
   <!-- 逾期出资 -->
   <c:if test="${orderReformSet.adminGuideType=='1'}">
     <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）及有关投资人（股东）：</span>
     <p class="left"> 你公司注册资本<span class="underline">${guideContentArr[0]}</span>万元，截止目前实
             收资本<span class="underline">${guideContentArr[1]}</span>万 元，根据公司章程和有关法律法规的规定，投资人（股东）
             应当于<span class="underline">${guideContentArr[2]}</span>前缴纳出资款<span class="underline">
    ${guideContentArr[2]}</span>（其中：<span class="underline">${guideContentArr[3]}</span>），
           现出资期限已届满但上述投资人（股东）未按规定足额出资，上述行为违反了《中华人民共和国公司法》第二十八条第一款、第二百条；《中华人民共和国
           公司登记管理条例》第七十条的规定，构成了公司股东未按期交付作为出资的货币行为。根据《中华人民共和国公司法》第二百条、《中华人民共和国公司登
           记管理条例》第七十条的规定，现责令你公司投资人（股东）改正，在<span class="underline">${chooseDay=='3'?'三个月内':''}
    ${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}${chooseDay=='15'?'十五内':''}</span>
           足额缴付出资，或者依法办理减少注册资本手 续，或者依法办理清算注销手续 。</p>
   <p>如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[4]}或者${guideContentArr[5]}人民政府申请
          复议；也可以在六个月内依法向人民法院提起诉讼。
   </p>
   </c:if>
   
   <!-- 法定代表人任职资格 -->
   <c:if test="${orderReformSet.adminGuideType=='2'}">
      <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）：</span>
      <p class="left"> 经查，你企业法定代表人(高管)<span class="underline">${guideContentArr[0] }</span>，
	          曾担任<span class="underline">${guideContentArr[1] }</span>的法定代表人(高管),该企业于<span class="underline">
	   ${guideContentArr[2]}</span>被 <span class="underline">${guideContentArr[3] }</span>，根据《公司法》第一百
	         四十七条、《企业法人法定代表人登记管理规定》第四条等相关法律法规的规定， <span class="underline">${guideContentArr[4] }</span>，
	         不得担任其他企业的法定代表人或高级管理人员等职务。现根据《企业法人法定代
	         表人登记管理规定第八条、第十二条的规定,责令你企业 于<span class="underline">${chooseDay=='3'?'三个月内':''}
	   ${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}${chooseDay=='15'?'十五内':''}</span>
                     依法办理法定代表人(高管)的变更登记。出现不符合任职资格情形又拒不履行变更登记义务的，企业登记机关可以依法实施行政处罚，情节严重的，撤销企业登记，吊销企业法人营业执照。             
	   </p>
	   <p>如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[5]}或者${guideContentArr[6]}人民政府申请
	          复议；也可以在六个月内依法向人民法院提起诉讼。
	   </p>   
   </c:if>
   
   <!-- 许可证到期、被吊销、被撤销 -->
   <c:if test="${orderReformSet.adminGuideType=='3'}">
	   <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）：</span>
	   <p>你企业经营范围中涉及的专项审批许可证：<span class="underline">${guideContentArr[0]}</span> 有效期已届满（/被许可部门
	        撤销、吊销），  根据企业登记管 理相关法律法规的规定，现责令你企业立即停止上述专项审批许可项目经营活动， 在 <span class="underline">
	   ${chooseDay=='3'?'三个月内':''}${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}
	   ${chooseDay=='15'?'十五内':''}</span> 变更经营范围  取消上述经营项目，或者依法重新申领有关专项 审批许可证并到工商部门办理相关变更
	         手续，或者依法办理企业注销手续 。 拒不办理相关手续的，工商部门可以依法实施行政处罚，情节严重的，可以撤销 企业登记或吊销企业法人营业执照。 未取得合
	         法有效专项审批许可证擅自从事相关经营项目的，依照无证无照经营予以定性查处。
	   </p>
       <p> 如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[1]}或者${guideContentArr[2]}人民政府申请
		            复议；也可以在六个月内依法向人民法院提起诉讼。
	   </p>
   </c:if>
   <!-- 经营期限到期 -->
   <c:if test="${orderReformSet.adminGuideType=='4'}">
     <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）：</span>
     <p class="left"> 你企业章程规定的经营期限已于<span class="underline">${guideContentArr[0]}</span>届满，根据企
               业登记管理相关法律法规的规定，现责令你企业<span class="underline">${chooseDay=='3'?'三个月内':''} 
     ${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}${chooseDay=='15'?'十五内':''}</span>依法
              办理企业经营期限延期变更或注销手续。 拒不办理相关手续的，工商部门可以依法实施行政处罚。
     </p>
	<p> 如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[1]}或者${guideContentArr[2]}人民政府申请
	            复议；也可以在六个月内依法向人民法院提起诉讼。
	</p>
   </c:if>
   
   <!-- 登记事项变更或备案 -->
   <c:if test="${orderReformSet.adminGuideType=='5'}">
	     <span >${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）：</span>
	     <p class="left"> 你企业的登记事项已发生变动（<span class="underline">${guideContentArr[0] }</span>），
	            与工商部门的核准登记内容不符。 根据企业登记管理相关法律法规的规定，现责令你企业于<span class="underline">${chooseDay=='3'?'三个月内':''} 
        ${chooseDay=='60'?'六十日内':''}${chooseDay=='30'?'三十日内':''}${chooseDay=='15'?'十五内':''}</span>依法向工商部门申请
                        办理相关的变更或备案手续。 出现登 记事项与实际情况不符合又拒不履行变更或备案登记义务的，工商部门将依法实施行政处罚。
	     </p>
		<p> 如果对本责令改正通知不服，可以在收到本通知之日起六十日内向${guideContentArr[1]}或者${guideContentArr[2]}人民政府申请
		            复议；也可以在六个月内依法向人民法院提起诉讼。
		</p> 
   </c:if> 
<p><span class="underline"></span></p>
<p></p>
<p></p>
<p class="left">联系人：${orderReformSet.linkMan}   联系电话：${orderReformSet.tel}</p>
<p class="right"><fmt:formatDate value="<%=new Date()%>" pattern="yyyy年MM月dd日" /></p>
<hr>
<p class="center">
    <span class="djjg">登记机关：${orderReformSet.regOrgName}</span>
    <span class="gxdw">管辖单位：${orderReformSet.localAdmName}</span>
</p>
</div>
<div class="main center" style="margin-top:40px">
   <div style="width:630px; margin:0 auto;">
                    <h1 class="center">送达回证</h1>
                    <table cellpadding="0" cellspacing="1" border="1"class="center  table-horizontal mt10">
                        <tbody>
                        <tr>
                            <td height="40" colspan="4">
                                ${orderReformSet.entName}（注册号 ${orderReformSet.regNo}）
                            </td>
                        </tr>
                        <tr>
                            <td height="40" width="90" align="center">文书类型</td>
                            <td width="130">责令整改通知书</td>
                            <td width="90" align="center">文号</td>
                            <td >${orderReformSet.penDecNo}</td>
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
                        </tbody>
                    </table>
   </div>
   <p class="PageNext">&nbsp;</p> 
</div> 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/common/print/printsetup.js"/>"></script>
<script src="<c:url value="/js/common/print/print.js"/>"></script>

</body>
</html>