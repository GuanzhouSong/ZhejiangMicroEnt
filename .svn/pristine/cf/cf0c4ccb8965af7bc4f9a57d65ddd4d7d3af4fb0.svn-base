<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>销户页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<script type="text/javascript">
</script>
<body class="pd10">
<h5 class="h5-title">无照经营信息</h5>
<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">

    <tr>
        <td class="bg-gray" align="right" width="15%">涉及</td>
        <td width="31%">${unlicensedInfoDto.isInvolve=='0'?'无':
                unlicensedInfoDto.isInvolve=='1'?'涉及前置许可':
                        unlicensedInfoDto.isInvolve=='2'?'涉及后置许可':''
                }</td>
        <td class="bg-gray" align="right" width="15%"><span class="light">*</span>监管项目</td>
        <td>${registUnlicensed.superName}</td>

    </tr>
    <%--
    <tr>
         <td class="bg-gray" align="right" width="15%"><span class="light">*</span>类型</td>
              <td width="30%">${unlicensedInfoDto.unlicType=='1'?'无照':
              unlicensedInfoDto.unlicType=='2'?'无照无证':
              unlicensedInfoDto.unlicType=='3'?'有照无证':
              unlicensedInfoDto.unlicType=='4'?'执照过期':
              unlicensedInfoDto.unlicType=='5'?'吊销未注销':''
              }</td>
       <td class="bg-gray" align="right"><span class="light">*</span>许可证名称</td>
       <td>${ulRecord.licName}</td>
   </tr> --%>
    <tr>
        <td class="bg-gray" align="right">经营地点</td>
        <td>${unlicensedInfoDto.proLocAddress}</td>
        <td class="bg-gray" align="right">当事人姓名</td>
        <td>${unlicensedInfoDto.name}</td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">经营时所使用的名称</td>
        <td>${unlicensedInfoDto.mgrName}</td>
        <td class="bg-gray" align="right">身份证号码</td>
        <td>${unlicensedInfoDto.cerNO}</td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">统一信用代码/注册号</td>
        <td>${unlicensedInfoDto.uniCode == ''|| unlicensedInfoDto.uniCode ==null ? unlicensedInfoDto.regNO : unlicensedInfoDto.uniCode}</td>
        <td class="bg-gray" align="right">当事人联系电话</td>
        <td>${unlicensedInfoDto.mobTel}</td>
    </tr>
    <tr>
        <td class="bg-gray" align="right">登记状态</td>
        <td>${midBaseInfoDto.regState}</td>
        <td class="bg-gray" align="right">经营期限至</td>
        <td><fmt:formatDate value="${midBaseInfoDto.opTo}"/></td>
    </tr>
    <tr>
        <td class="bg-gray" align="right"><span class="light">*</span>管辖单位</td>
        <td>${unlicensedInfoDto.localAdmName}</td>
        <td class="bg-gray" align="right">片区/商圈</td>
        <td>${unlicensedInfoDto.sliceNoName}</td>
    </tr>
    <tr>
        <td class="bg-gray" align="right" width="11%"><span class="light">*</span>经营内容</td>
        <td colspan="3">${unlicensedInfoDto.mgrScope}</td>

    </tr>
    <tr>
        <td class="bg-gray" align="right">经办人</td>
        <td>${unlicensedInfoDto.setName}</td>
        <td class="bg-gray" align="right">处理日期</td>
        <td><fmt:formatDate value="${unlicensedInfoDto.setTime}"/></td>
    </tr>
</table>
<h5 class="h5-title mt5">无照库销户信息</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">企业名称</td>
        <td>${midBaseInfoDto.entName}</td>
        <td class="bg-gray right" width="15%">统一信用代码/注册号</td>
        <td>${midBaseInfoDto.uniCode}</td>
    </tr>
    <tr>
        <td class="bg-gray right">法定代表人</td>
        <td>${midBaseInfoDto.leRep}</td>
        <td class="bg-gray right">成立日期</td>
        <td><fmt:formatDate value="${midBaseInfoDto.estDate}"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">行业</td>
        <td>${midBaseInfoDto.industryCoName}</td>
        <td class="bg-gray right">注册资本(万元)</td>
        <td>${midBaseInfoDto.regCapUSD}</td>
    </tr>
    <tr>
        <td class="bg-gray right">登记机关</td>
        <td>${midBaseInfoDto.regOrgName}</td>
        <td class="bg-gray right">管辖单位</td>
        <td>${midBaseInfoDto.localAdmName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">住所（经营场所）</td>
        <td>${midBaseInfoDto.dom}</td>
        <td class="bg-gray right">邮编</td>
        <td>${midBaseInfoDto.postalCode}</td>
    </tr>
    <tr>
        <td class="bg-gray right">经营范围</td>
        <td colspan="3">${midBaseInfoDto.opScope}</td>
    </tr>
    <%--   <tr>
          <td class="bg-gray" align="right">许可类型</td>
          <td>前置许可</td>
          <td class="bg-gray" align="right">许可状态</td>
          <td>食品许可证</td>
          </tr>
          --%>
    </tbody>
</table>
<form id="registInfoForm">

    <input type="hidden" name="priPID" value="${unlicensedInfoDto.priPID}"/>
    <input type="hidden" name="uid" value="${unlicensedInfoDto.UID}"/>
    <input type="hidden" name="disposeWay" value="6"/>

    <div class="form-item clearfix">
        <label class="item-name col-2">销户原因：</label>
        <div class="col-8">
            <div class="item-name left light">
                补办执照
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-2">备注：</label>
        <div class="col-8">
            <div class="ipt-box">
                <textarea name="remark" id="" cols="30" rows="3" class="ipt-txt min-height"></textarea>
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-2"> <span class="light">*</span>经办人：</label>
        <div class="col-3">
            <div class="ipt-box">
                <input type="text" name="disposeName" required class="ipt-txt">
            </div>
        </div>
        <label class="item-name col-2"> <span class="light">*</span>处理时间：</label>
        <div class="col-3">
            <div class="ipt-box">
                <input type="text" name="disposeDate" class="ipt-txt" readonly="readonly"
                       onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            </div>
        </div>
    </div>
    <div class="form-item clearfix">
        <label class="item-name col-2"> 录入人：</label>
        <div class="col-3">
            <div class="ipt-box">
                <input type="text" name="inputName" class="ipt-txt" value="${loginrealname}">
            </div>
        </div>
        <label class="item-name col-2">记录时间：</label>
        <div class="col-3">
            <div class="ipt-box">
                <input type="text" name="createTime" class="ipt-txt" readonly="readonly"
                       value="<fmt:formatDate value="${now}"  pattern="yyyy-MM-dd HH:mm:ss"/>"
                       onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
            </div>
        </div>
    </div>

    <div class="center mt20">
        <input id="save" type="submit" class="btn mr20" value="保 存" style="margin-bottom: 50px">
        <input id="cancel" type="button" class="btn mr20" value="取 消" style="margin-bottom: 50px">
    </div>

</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/logoff_edit.js"></script>
</body>
</html>