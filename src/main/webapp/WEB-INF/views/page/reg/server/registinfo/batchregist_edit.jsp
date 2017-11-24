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
    <title>主体户口建档页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">

</head>
<script type="text/javascript">
//无证无照查询的初始化条件
var leRep='${midBaseInfoDto.leRep}';
var cerNO='${midBaseInfoDto.cerNO}';
var entName='${midBaseInfoDto.entName}';
var dom='${midBaseInfoDto.dom}';
var _sliceMan='${registInfoDto.sliceMan}';
var _sliceTel='${registInfoDto.sliceTel}';
</script>
<body class="pd10">
<form id="registInfoForm">
   <input type="hidden" id="priPID" name="priPID" value="${registInfoDto.priPID}"/>
    <div class="bg-gray2">
        <h5 class="com-info-title">管理信息</h5>
        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
            <tr>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>监管项目</td>
                <td colspan="3">
                    <input type="hidden" id="superNoNames" name="superNoNames"value="<c:forEach var="p" items="${ownsuper}">${p.superName}</c:forEach>"/>
                    <input type="hidden" id="superNos"  name="superNos" value="<c:forEach var="p" items="${ownsuper}">${p.superNo}</c:forEach>"/>
                    <input type="hidden" id="superType" value=""/>
                    <div class="display-table">
                        <span class="table-cell vm" id="superNoNamesDiv"><c:forEach var="p" items="${ownsuper}">${p.superName}</c:forEach></span>
                        <span class="table-cell right vm"><input id="supAdd" type="button" class="btn btn-xs" value="添加/编辑"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray ft14 right" width="10%">分类标签</td>
                <td valign="top" colspan="3" class="pd0">
                    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="table-horizontal-nest">
                 <c:forEach var="p" items="${marks}" varStatus="s">
                        <tr>
                            <td class="bg-gray" width="150" id="typename">${
                            p.markClass=='0'?'关注':
                            p.markClass=='1'?'警示':
                            p.markClass=='2'?'限制':
                            ''}</td>
                            <td>
                                <div class="display-table">
                                    <span class="table-cell vm" id="markDiv${p.markClass}"><c:forEach var="o" items="${ownmarks}">${o.IDType==p.markClass?o.IDName:''}</c:forEach></span>
                                    <span class="table-cell right vm">
                                        <input  data-marktype="${p.markClass}" data-typename="${p.markClass=='0'?'关注':p.markClass=='1'?'警示':p.markClass=='2'?'限制':''}"
                                            type="button" class="btn btn-xs _markfocusAdd" value="添加/编辑">
                                           <input type='hidden' class="IDName${p.markClass}"
                                           value="<c:forEach var='o' items='${ownmarks}'>${o.IDType==p.markClass?o.IDName:''}</c:forEach>"/>
                                           <input type='hidden' class="IDCode${p.markClass}"
                                           value="<c:forEach var='o' items='${ownmarks}'>${o.IDType==p.markClass?o.IDCode:''}</c:forEach>"/>
                                    </span>
                                </div>
                            </td>
                        </tr>
                </c:forEach>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>乡镇/街道</td>
                <td width="50%">
                    <input type="hidden" name="street"  id="street"value="${registInfoDto.street}">
                    <div class="display-table">
                        <span class="table-cell vm" id="streetd">${registInfoDto.streetName}</span>
                        <span class="table-cell right vm"><input id="streetAdd" type="button" class="btn btn-xs" value="添加/编辑"></span>
                    </div>
                </td>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>片区/商圈</td>
                <td width="50%">
                    <input type="hidden" id="sliceNO"  name="sliceNO" value="${registInfoDto.sliceNO}">
                    <input type="hidden" id="sliceNOName" name="sliceNOName" value="${registInfoDto.sliceNOName}">
                    <input type="hidden" id="localAdm" value="${registInfoDto.localAdm}">
                    <div class="display-table">
                        <span class="table-cell vm" id="sliceNONameDiv">${registInfoDto.sliceNOName}</span>
                        <span class="table-cell right vm"><input id="sliceNOAdd" type="button" class="btn btn-xs" value="添加/编辑"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>管辖人员</td>
                <td colspan="3">
                    <input type="hidden" id="sliceMan" name="sliceMan" value="${registInfoDto.sliceMan}">
                    <input type="hidden" id="sliceTel" name="sliceTel" value="${registInfoDto.sliceTel}">
                    <div class="display-table">
                        <span class="table-cell vm" id="sliceManp"></span>
                        <span class="table-cell right vm"><input id="sliceManAdd" type="button" class="btn btn-xs" value="添加/编辑"></span>
                    </div>
                </td>
            </tr>
        </table>
    </div>

<p class="center mt20">
<input id="save" type="submit" value="确 定" class="btn mr20">
<input id="cancel" type="button" value="返 回" class="btn mr20">
<!--<input id="print" type="button" value="打 印" class="btn">-->
</p>
</form>
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/batchregist_edit.js"></script>
</body>
</html>