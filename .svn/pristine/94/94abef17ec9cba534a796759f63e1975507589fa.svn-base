<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>认领页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<body  class="pd20">
<form id="registInfoForm">
<input id="priPID" type="hidden" name="priPID" value="${midBaseInfoDto.priPID}"/>
<input id="claimState" type="hidden" name="claimState" value="${registInfoDto.claimState}"/>
<input id="fromtype" type="hidden" value="${fromtype}"/>
<div>
        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
            <tbody>
            <tr>
               <td class="bg-gray right col-2">企业名称</td>
                <td class="col-3">${midBaseInfoDto.entName}</td>
                <td class="bg-gray right">行业</td>
                <td>${midBaseInfoDto.industryCoName}</td>
            </tr>
            <tr>
                <td class="bg-gray right">法定代表人</td>
                <td>${midBaseInfoDto.leRep}</td>
                <td class="bg-gray right">成立日期</td>
                <td><fmt:formatDate value="${midBaseInfoDto.estDate}"/></td>
            </tr>
            <tr>

                <td class="bg-gray right">注册资本(万元)</td>
                <td>${midBaseInfoDto.regCapUSD}</td>
                 <td class="bg-gray right">住所（经营场所）</td>
                 <td>${midBaseInfoDto.dom}</td>
            </tr>
            <tr>
                <td class="bg-gray right">登记机关</td>
                <td>${midBaseInfoDto.regOrgName}</td>
                <td class="bg-gray right">管辖单位</td>
                <td>${midBaseInfoDto.localAdmName}</td>
            </tr>
            <tr>
                <td class="bg-gray right">经营范围</td>
                <td colspan="3">${midBaseInfoDto.opScope}</td>
            </tr>

            </tbody>
        </table>
    </div>
       <div class="center" ${fromtype=='back'?'style="display:none"':''}>
            <p class="ft20 mt20" ${registInfoDto.claimState=='0'?'':'style="display:none"'}>认领时间还剩：<span class="light">${registInfoDto.remainClaimState==null||registInfoDto.remainClaimState=='null'||registInfoDto.remainClaimState==''?'15':registInfoDto.remainClaimState}</span>个工作日</p>
            <p class="ft20 mt20" ${registInfoDto.claimState=='2'?'':'style="display:none"'}><span class="light">提醒：此次户口认领已超过规定期限</span></p>
           <p class="center mt20">
            <input id="save" type="submit" class="btn mr20" value="确认认领">
            <input  id="cancel" type="button" class="btn" value="取消">
           </p>
        </div>
      <div class="center" ${fromtype=='back'?'':'style="display:none"'}>
      <table class="table-horizontal table-noborder" cellpadding="0" cellspacing="0" border="0" width="100%">
          <tr>
          <td align="left" width="8%">退回人：</td>
          <td align="left" >${registInfoDto.backName}</td>
           <input type="hidden" name="backName" value="${registInfoDto.backName}">
          <td align="left" width="8%">退回日期：</td>
          <td align="left" ><fmt:formatDate value="${registInfoDto.backTime }"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <input type="hidden" name="backTime"
          value="<fmt:formatDate value="${registInfoDto.backTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>">
          </tr>
          <tr>
          <td align="left">退回说明：</td>
          <td colspan="3"></td>
          </tr>
          <tr>
          <td colspan="4">
          <div class="ipt-box">
              <textarea name="backReason" required id="backReason"  maxlength="200"  cols="30" rows="6" placeholder="请输入退回说明"></textarea>
          </div>
          </td>
          </tr>
      </table>
             <p class="center mt20">
              <input id="save" type="submit" class="btn mr20" value="退回">
              <input  id="cancel" type="button" class="btn" value="取消">
             </p>
      </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/claim_edit.js"></script>
</body>
</html>