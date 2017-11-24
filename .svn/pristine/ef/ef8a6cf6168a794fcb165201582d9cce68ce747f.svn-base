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
		    font-family: "宋体";
		    font-size: 16pt;
		    height: 50px;
		    line-height: 50px;
		    font-weight: bold;
		    letter-spacing: 2px;
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
            color:#0000ff;
        }
        .blue{
            color:#0000ff;
        }
        .ipt-txt2{
            background-color: #fff;
		    line-height: 16px;
		    height: 24px;
		    padding: 4px 4px;
		    border-top: none;
		    border-right: none;
		    border-left: none;
		    border-bottom: 1px solid #adadad;
        }
    </style>
</head>
<body>

<div style="width:650px; margin:0 auto;">
       <p class="right">${limitNo }</p>
       <h1 class="center">履行清算义务告知书</h1>
       <p class="left"> <span class="underline">${qualificationLimit.clientName }</span>股东（投资人） ：
	   </p>
	   <p class="left">单位所投资的 <span class="underline">${midBaseInfoDto.entName }（${midBaseInfoDto.regNO }）</span> 
		   因<span class="underline">${qualificationLimit.limitReason }</span>于<span class="underline"><fmt:formatDate value="${midBaseInfoDto.punishDate}" type="date" pattern="yyyy年MM月dd日"/></span>
		   被<span class="underline">${midBaseInfoDto.regOrgName }</span>吊销营业执照。
		   根据《公司法》、《企业法人法定代表人登记管理规定》等相关法律法规的规定，
		   被吊销营业执照的企业应依法组织清算，企业在清算期间不得开展与清算事务无关的经营活动，清算结束后依法办理注销登记。
		   同时，担任因违法被吊销营业执照的企业的法定代表人并负有个人责任的，
		   自该企业被吊销营业执照之日起三年内不得担任其它企业的法定代表人或者公司董事、监事和高级管理人员。
	   </p>
	   
	   <p>特此告知。</p>
	   <p class="right blue">${midBaseInfoDto.regOrgName }</p>
	   <p class="right blue" ><fmt:formatDate value="<%=new Date()%>" pattern="yyyy年MM月dd日" /></p>
</div>
<div class="button Noprint" style="width:650px;">
    <button id="save"  class="btn btn-primary">加入管理台账并打印</button>
    <button id="cancel" type="button" class="btn btn-primary">关闭</button>
</div>
<form action="" id="params">
	<input type="hidden" name="uid" id="uid" value="${qualificationLimit.uid }">
	<input type="hidden" name="limitNO" value="${limitNo }">
	<input type="hidden" name="clientName" value="${qualificationLimit.clientName }">
    <input type="hidden" id="operator" name="operator"  value="${sysUser.realName}"/>
    <input type="hidden" id="department" name="department"  value="${sysUser.departMent.deptName }"/> 
</form>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="/js/reg/server/registmanage/qualifiedmanage/printliq_print.js"></script>
</body>
</html>