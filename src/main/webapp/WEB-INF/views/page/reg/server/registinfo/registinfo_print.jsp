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

     <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
            <style media="print" type="text/css">
                .Noprint{ display:none; }
            </style>
            <style type="text/css">
                .height40{
                    height: 40px;
                }
            </style>
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
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6,2,433,14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>

<div class="comp-detail-info" ${fromtype=='batch'?'style="display:none"':''}>
    <h4 class="h2-title company-lab">${midBaseInfoDto.entName}
        <span class="bg-green">开业</span>
        ${pubopanoy_num>0?' <span class="bg-red">列入经营异常</span>':''}
        ${supervise_num>0?' <span class="bg-blue">列入重点监管</span>':''}
        ${check_num>0?'<span class="bg-yellow">列入抽查检查</span>':''}
        <!-- <span class="bg-yellow">列入严重违法</span>
        -->

    </h4>
    <p class="detail-brief">
        <span>统一信用代码/注册号：${midBaseInfoDto.uniCode == ''|| midBaseInfoDto.uniCode ==null ? midBaseInfoDto.regNO : midBaseInfoDto.uniCode}</span>
    </p>
    <div>
        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
            <tbody>
            <tr>
                <td class="bg-gray right" width="15%">企业类型</td>
                <td>${midBaseInfoDto.entTypeName}</td>
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
                <td>${registInfoDto.localAdmName}</td>
            </tr>
            <tr>
                <td class="bg-gray right">经营范围</td>
                <td colspan="3">${midBaseInfoDto.opScope}</td>
            </tr>
            </tbody>
        </table>

    </div>
    <div class="more-brief-info bg-gray mt10 mb10">
        <em>预警提示（<font class="light">${warn_num}</font>）</em><em>
        行政指导（<font class="light">${govguide_num}</font>）</em><em>
        责令整改（<font class="light">${correct_num}</font>）</em><em>
        列入抽查检查（<font class="light">${check_num}</font>）</em><em>
        列入案源管理（<font class="light">-</font>）</em><em>
        列入重点监管对象（<font class="light">${supervise_num}</font>）</em><em>
        部门抄告抄送（<font class="light">${copysend_num}</font>）</em><em>
        信息修正申请（<font class="light">-</font>）</em><em>
        列入经营异常（<font class="light">${pubopanoy_num}</font>）</em><em>
        列入关注服务对象（<font class="light">${concern_num}</font>）</em>
    </div>

    <div class="bg-gray2">
        <h5 class="com-info-title">许可证信息</h5>
        <div class="">
            <table border="0" cellspacing="0" cellpadding="0" class="table-row mt30 nowrap" width="100%">
                <tbody>
                <tr>
                    <th width="7.5%">序号</th>
                    <th width="22.7%">许可类型</th>
                    <th>许可证编号</th>
                    <th>许可证名称</th>
                    <th>许可内容</th>
                    <th>许可机关</th>
                    <th>起始日期</th>
                    <th>到期日期</th>
                    <th>许可状态</th>
                </tr>

                <c:if test="${pubOtherlicences.size()==0}">
                    <tr>
                        <td valign="top" colspan="9" class="dataTables_empty">无</td>
                    </tr>
                </c:if>
                <c:if test="${pubOtherlicences.size()>0}">
                    <c:forEach var="p" items="${pubOtherlicences}" varStatus="s">
                        <tr>
                            <td>${s.index+1}</td>
                            <td>${p.licType=='1'?'变更':
                                    p.licType=='2'?'注销':
                                            p.licType=='3'?'被吊销':
                                                    p.licType=='4'?'撤销失效':
                                                            ''}</td>
                            <td>${p.licNO}</td>
                            <td>${p.licNameCN}</td>
                            <td>${p.licScope}</td>
                            <td>${p.licAnth}</td>
                            <td><fmt:formatDate value="${p.licValFrom}"/></td>
                            <td><fmt:formatDate value="${p.licValTo}"/></td>
                            <td>${p.licState=='0'?'无效':'有效'}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div >
<form id="registInfoForm">
    <input type="hidden" id="uid" name="uid" value="${registInfoDto.UID}"/>
    <input type="hidden" id="priPID" name="priPID" value="${registInfoDto.priPID}"/>
    <input type="hidden" id="archState" name="archState" value="${registInfoDto.archState}"/>
    <div class="form-box" ${fromtype=='batch'?'style="display:none"':''}>
        <div class="form-list">
            <div class="form-item clearfix ">
                <div class="col-12">
                    <label class="item-name col-3">是否进行实地勘察：</label>
                    <div class="col-9">
                        <div class="radio-box">
                            <div class="col-2">
                                <label><input type="radio" value="1" onclick="return false"
                                              name="" ${registInfoDto.isInvestigate  == '1' ? 'checked':''} />是</label>
                                <label><input type="radio" value="0" onclick="return false"
                                              name="" ${registInfoDto.isInvestigate == '0' ?  'checked':''} />否</label>
                            </div>
                            <div class="col-10 isInvestigateDiv" ${registInfoDto.isInvestigate == '1' ? '':'style="display:none"'}>
                                <label class="mr20"><span class="light">*</span>勘察时间：</label>
                                <input type="text" class="ipt-txt inline-txt " readonly="readonly"

                                       name="investigateDate"
                                       value="<fmt:formatDate type='both' value="${registInfoDto.investigateDate}"/>">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-12 isInvestigateDiv"  ${registInfoDto.isInvestigate == '1' ? '':'style="display:none"'}>
                    <label class="item-name col-3">经营场所地址与实地是否一致：</label>
                    <div class="col-9">
                        <div class="radio-box col-12">
                            <label class="mr20"><input type="radio" value="1" onclick="return false"
                                                       name="" ${registInfoDto.isSameAddr== '1' ? 'checked':''}>
                                一致 </label>
                            <label class="mr20"><input type="radio" value="0" onclick="return false"
                                                       name="" ${registInfoDto.isSameAddr== '0' ? 'checked':''}>不一致</label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix isInvestigateDiv" ${registInfoDto.isInvestigate == '1' ? '':'style="display:none"'}>
                <div class="col-12 ">
                    <label class="item-name col-3"></label>
                    <div class="col-9">
                        <div class="radio-box col-12 pd0">
                                     <span class="isSameAddrDiv" ${registInfoDto.isSameAddr == '0' ? '':'style="visibility:hidden"'}>
                                       <label class="mr20 "><input type="radio" value="0" onclick="return false"
                                                                   ${registInfoDto.diffAddrReason== '0' ? 'checked':''}> 查无下落 </label>
                                       <label class="mr20 "><input type="radio" value="1" onclick="return false"
                                                                   ${registInfoDto.diffAddrReason== '1' ? 'checked':''}>商务秘书公司代理</label>
                                       <label class="mr20 "><input type="radio" value="2" onclick="return false"
                                                                    ${registInfoDto.diffAddrReason== '2' ? 'checked':''}>异址经营</label>
                                       <input type="text" id="opLoc"
                                              class="ipt-txt inline-txt" ${registInfoDto.diffAddrReason == '2' ? 'style="width:350px;"':'style="visibility:hidden"'}
                                              name="opLoc" value="${registInfoDto.opLoc}" placeholder="请输入实际经营地址">
                                      </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bg-gray2">
        <h5 class="com-info-title">管理信息</h5>
        <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
            <tr class="bg-gray" ${registInfoDto.isChangeArch=='1' && (fromtype=='single' || fromtype=='print')?'':'style="display:none"'}>
                <th class="right"><label class="item-name">建档变更类型：</label></th>
                <th colspan="3" class="left">
                    <div class="radio-box col-12 pd0">
                        <input type="hidden" name="isChangeArch" value="${registInfoDto.isChangeArch}" >
                        <label class="mr20"><input type="radio" onclick="return false"
                                                   value="1" ${registInfoDto.changeArchState=='1'?'checked':''}
                                                   > 内外资转型 </label>
                        <label class="mr20"><input type="radio" onclick="return false"
                                                   value="2" ${registInfoDto.changeArchState=='2'?'checked':''}
                                                   >被撤消（吊销）恢复</label>
                        <label class="mr20"><input type="radio" onclick="return false"
                                                   value="3" ${(registInfoDto.changeArchState=='3')||(registInfoDto.changeArchState==null&&midBaseInfoDto.isIndivid=='1')?'checked':''}
                                                   >个转企 </label>
                        <label class="mr40"><input type="radio" onclick="return false"
                                                   value="4" ${registInfoDto.changeArchState=='4'?'checked':''}
                                                   >个转企&新迁入</label>
                        <span id="changeArchState_span" ${registInfoDto.changeArchState=='3'||registInfoDto.changeArchState=='4'||(registInfoDto.changeArchState==null&&midBaseInfoDto.isIndivid=='1')?'':'style="display:none"'}>
                            <label><span class="light">*</span>转企时间：</label>
                            <input type="text" class="ipt-txt" readonly="readonly" 
                                   name="individDate"
                                   value="<fmt:formatDate value="${registInfoDto.individDate==null?midBaseInfoDto.individDate:registInfoDto.individDate}"/>">
                            </span>
                    </div>
                </th>
            </tr>
            <tr>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>监管项目</td>
                <td colspan="3">
                    <input type="hidden" id="superNoNames" name="superNoNames"
                           value="<c:forEach var="p" items="${ownsuper}">${p.superName}</c:forEach>"/>
                    <input type="hidden" id="superNos" name="superNos"
                           value="<c:forEach var="p" items="${ownsuper}">${p.superNo}</c:forEach>"/>
                    <input type="hidden" id="superType" value=""/>
                    <div class="display-table">
                            <span class="table-cell vm" id="superNoNamesDiv"><c:forEach var="p"
                                                                                        items="${ownsuper}">${p.superName}</c:forEach></span>
                        <span class="table-cell right vm"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray ft14 right" width="10%">分类标签</td>
                <td valign="top" colspan="3" class="pd0">
                    <table cellspacing="0" cellpadding="0" border="0" width="100%" class="table-horizontal-nest">
                        <c:forEach var="p" items="${marks}" varStatus="s">
                            <tr>
                                <td class="bg-gray" width="150" id="typename">${p.markFuncName}</td>
                                <td>
                                    <div class="display-table">
                                            <span class="table-cell vm" id="markDiv${p.markFunc}"><c:forEach var="o"
                                                                                                             items="${ownmarks}">${o.IDType==p.markFunc?o.IDName:''}</c:forEach></span>
                                        <span class="table-cell right vm">

                                           <input type='hidden' class="IDName${p.markFunc}"
                                                  value="<c:forEach var='o' items='${ownmarks}'>${o.IDType==p.markFunc?o.IDName:''}</c:forEach>"/>
                                           <input type='hidden' class="IDCode${p.markFunc}"
                                                  value="<c:forEach var='o' items='${ownmarks}'>${o.IDType==p.markFunc?o.IDCode:''}</c:forEach>"/>
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
                    <input type="hidden" name="street" id="street" value="${registInfoDto.street}">
                    <div class="display-table">
                        <span class="table-cell vm" id="streetd">${registInfoDto.streetName}</span>
                        <span class="table-cell right vm"></span>
                    </div>
                </td>
                <td class="bg-gray ft14 right" width="10%"><span class="light">*</span>片区/商圈</td>
                <td width="50%">
                    <input type="hidden" id="sliceNO" name="sliceNO" value="${registInfoDto.sliceNO}">
                    <input type="hidden" id="sliceNOName" name="sliceNOName" value="${registInfoDto.sliceNOName}">
                    <input type="hidden" id="localAdm" value="${registInfoDto.localAdm}">
                    <div class="display-table">
                        <span class="table-cell vm" id="sliceNONameDiv">${registInfoDto.sliceNOName}</span>
                        <span class="table-cell right vm"></span>
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
                        <span class="table-cell right vm"></span>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="bg-gray2 mt10" ${fromtype=='batch'?'style="display:none"':''}>
        <h5 class="com-info-title">联系信息</h5>
        <div class="form-list pd20">
            <div class="form-item clearfix">
                <label class="item-name col-2">企业联系电话：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input type="text"  readonly="readonly" class="ipt-txt" name="unitTel" value="${registInfoDto.unitTel}">
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2"> 企业网站/网址：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input readonly="readonly" type="text" class="ipt-txt" name="webSite" value="${registInfoDto.webSite}">
                    </div>
                </div>
                <label class="item-name col-2">企业邮箱：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input type="text"  readonly="readonly" class="ipt-txt" id="unitEmail" name="unitEmail"
                               value="${registInfoDto.unitEmail}">
                    </div>

                </div>
            </div>

            <div class="form-item clearfix">
                <label class="item-name col-2"> 法定代表人联系信息：</label>
                <div class="col-3">
                    <div class="ipt-box col-4 mr-col-05">
                        <input type="text" class="ipt-txt" readonly="true" value="${midBaseInfoDto.leRep }"/>
                    </div>
                    <div class="ipt-box col-75">
                        <input type="text" class="ipt-txt" readonly="true" value="${midBaseInfoDto.tel}"/>
                    </div>
                </div>
                <label class="item-name col-2">证件号码：</label>
                <div class="col-5">
                    <div class="ipt-box col-5">
                        <input type="text" class="ipt-txt" readonly="true" value="${midBaseInfoDto.cerNO}">
                    </div>
                    <label class="item-name col-3">最新有效电话：</label>
                    <div class="col-4">
                        <div class="ipt-box">
                            <input type="text" class="ipt-txt"  readonly="readonly" name="tel" value="${registInfoDto.tel }">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">企业联络员联系信息：</label>
                <div class="col-3">
                    <div class="ipt-box col-4 mr-col-05">
                        <input type="text" class="ipt-txt" readonly="true" value="${registInfoDto.entEppa}"/>
                    </div>
                    <div class="ipt-box col-75">
                        <input type="text" class="ipt-txt" readonly="true" value="${registInfoDto.entEppaPhone}"/>
                    </div>
                </div>
                <label class="item-name col-2">财务负责人联系信息：</label>
                <div class="col-3">
                    <div class="ipt-box col-4 mr-col-05">
                        <input type="text" class="ipt-txt" readonly="true" name="finance"
                               value="${registInfoDto.finance}"/>
                    </div>
                    <div class="ipt-box col-75">
                        <input type="text" class="ipt-txt" readonly="true" name="financeTel"
                               value="${registInfoDto.financeTel}"/>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix">
                <label class="item-name col-2">户口录入联系人：</label>
                <div class="col-3">
                    <div class="ipt-box col-4 mr-col-05">
                        <input type="text" class="ipt-txt" readonly="readonly"  name="linkman" value="${registInfoDto.linkman}"/>
                    </div>
                </div>
                <label class="item-name col-2">联系电话：</label>
                <div class="col-3">
                    <div class="ipt-box">
                        <input type="text" class="ipt-txt" readonly="readonly"  name="linktel" value="${registInfoDto.linktel}">
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/registinfo/registinfo_edit.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>