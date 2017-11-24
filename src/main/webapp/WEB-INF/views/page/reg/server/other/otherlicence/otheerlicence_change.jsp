<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可变更页面</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style>
        .mod-cont > h4 {
            padding: 0 20px;
            font: normal 18px/48px "Microsoft Yahei";
            border: 1px solid #deeef7;
            background-color: #ecf7fd;
        }

        .tabbale .tab-header {
            position: relative;
            padding-left: 64px;
            top: 0px;
            padding-bottom: 15px;
            border-bottom: 1px solid #ededed;
            margin-bottom: 16px;
        }

        .tab-header > label {
            position: absolute;
            top: 2px;
            left: 0;
            font: normal 12px/13px "Microsoft Yahei";
        }

        .tab-header li {
            float: left;
            padding-right: 15px;
        }

        .tab-header .tab-item {
            cursor: pointer;
        }

        .tabbale .tab-panel.tab-panel-show {
            display: block;
        }

        .table-special {
            width: 100%;
        }

        .table-special th, .table-special td {
            border: 1px solid #e5e5e5;
            height: 40px;
            padding: 0 10px;
            color: #333;
            background-color: #fff;
        }

        .table-special th.before {
            background-color: #ccffff;
            color: #006699;
        }

        .table-special th.after {
            background-color: #ccffe6;
            color: #006633;
        }

        .table-special .tab-c-title {
            width: 130px;
            background-color: #f0efef;
            text-align: right;
            font: normal 12px/14px "Microsoft Yahei";
        }

        .tab-c-title span {
            display: inline-block;
            width: 103px;
            text-align: right;
            position: relative;
        }

        .tab-c-title input[type="checkbox"] {
            margin: 0;
            padding: 0;
            position: absolute;
            top: 2px;
            left: 0;
        }

        .table-special .ipt-txt {
            display: none;
        }

        .table-special .change-time {
            display: block;
        }

        .tab-content > .tab-panel {
            display: none;
        }

        .tab-content > .tab-panel.tab-panel-show {
            display: block;
        }
    </style>
</head>
<body class="pd10">

<div>
    <div class="mod-cont permit-cont">
        <input type="hidden" id="licID" name="licID" value="${pubOtherlicence.licID}">
        <input type="hidden" id="priPID" name="priPID" value="${pubOtherlicence.priPID}">
         <input type="hidden" id="userType" value="${userType }">
        <h4>行政许可信息</h4>
        <div class="permit-change pd10">
            <div class="tabbale" data-component="tab" data-contain="input">
                <div class="tab-header">
                    <label>类别选择： </label>
                    <ul class="clearfix">
                        <li class="tab-selected"><label class="tab-item"><input type="radio" value="change" name="chose"
                                                                                checked>变更</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose" value="cancle">注销</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose" value="beRevoked">被吊销</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose"
                                                           value="invalidReason">其他无效信息</label></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-panel tab-panel-show">
                        <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                            <tr>
                                <th colspan="2" class="before" width="50%">变更前</th>
                                <th colspan="2" class="after" width="50%">变更后</th>
                            </tr>
                            <tr>
                                <td class="tab-c-title" width="15%">许可文件编号</td>
                                <td>${pubOtherlicence.licNO}</td>
                                <td class="tab-c-title" width="15%">许可文件编号</td>
                                <td width="350">${pubOtherlicence.licNO}</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>${pubOtherlicence.licNameCN}</td>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>${pubOtherlicence.licNameCN}</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可机关</td>
                                <td id="change3T">${pubOtherlicence.licAnth}</td>
                                <td class="tab-c-title"><span><input type="checkbox" title="change3" name="change"
                                                                     value="许可机关">许可机关</span></td>
                                <td>
                                    <div class="ipt-box">
                                        <span>${pubOtherlicence.licAnth}</span>
                                        <input type="text" name="licAnth" id="change3" onKeyDown="if(this.value.length >= 100){  this.value=this.value.substr(0,100) }"
                                               maxlength="100" class="ipt-txt">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可内容</td>
                                <td id="change4T">
                                <c:choose>
                                <c:when  test="${fn:length(pubOtherlicence.licScope)>'25'}">
                                ${fn:substring(pubOtherlicence.licScope,0,25)}... 
                                </c:when>
                                 <c:otherwise>  
                                    ${pubOtherlicence.licScope}
                                 </c:otherwise>
                                </c:choose>
                                
                              </td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change4"
                                                                     value="许可内容">许可内容</span></td>
                                <td>
                                    <div class="ipt-box">
                                        <span>
                                        
                                        <c:choose>
                                <c:when  test="${fn:length(pubOtherlicence.licScope) > '25'}">
                                ${fn:substring(pubOtherlicence.licScope,0,25)}... 
                                </c:when>
                                 <c:otherwise>  
                                    ${pubOtherlicence.licScope}
                                 </c:otherwise>
                                </c:choose>
                                        
                                        </span>
                                        <input type="text" name="licScope"
                                                                                        id="change4" class="ipt-txt">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期开始时间</td>
                                <td id="change1T"><fmt:formatDate value="${pubOtherlicence.licValFrom}"
                                                                  pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change1"
                                                                     value="有效期开始时间">有效期开始时间</span></td>
                                <td>
                                    <div class="ipt-box">
                                        <span><fmt:formatDate value="${pubOtherlicence.licValFrom}"
                                                              pattern="yyyy-MM-dd"/></span>
                                        <input type="text" name="licValFrom" value="" id="change1"
                                               class="ipt-txt ipt-txt laydate-icon" readonly="readonly">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期结束时间</td>
                                <td id="change2T"><fmt:formatDate value="${pubOtherlicence.licValTo}"
                                                                  pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change2"
                                                                     value="有效期结束时间">有效期结束时间</span></td>
                                <td>
                                    <div class="ipt-box">
                                         <span> <fmt:formatDate value="${pubOtherlicence.licValTo}"
                                                                pattern="yyyy-MM-dd"/></span>
                                        <!--  <input type="text" name="valTo" id="change2"    class="ipt-txt icon-date"   readonly="readonly"> -->
                                        <input type="text" name="licValTo" value="" id="change2"
                                               class="ipt-txt    laydate-icon" readonly="readonly">
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td class="tab-c-title"></td>
                                <td></td>
                                <td class="tab-c-title">变更时间</td>
                                <td>
                                    <div class="ipt-box col-12">
                                        <input type="text" class="ipt-txt laydate-icon change-time" readonly="readonly"
                                               name="altDate" id="altDate">
                                    </div>
                                </td>
                            </tr>


                        </table>
                    </div>
                    <div class="tab-panel">
                        <input type="hidden" id="licID" name="licID" value="${pubOtherlicence.licID}">

                        <ul>
                            <li class="clearfix">
                                <div class="col-4">
                                    <div class="item-name col-4">注销时间：</div>
                                    <div class="ipt-box col-8">
                                        <input type="text" name="canDate" id="canDate" readonly="readonly"
                                               class="ipt-txt  laydate-icon">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name col-4">注销原因：</div>
                                    <div class="ipt-box col-7">
                                        <input type="text" name="equPleCanRea" id="equPleCanRea" value=""
                                               class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                        <ul>
                            <li class="clearfix">
                                <div class="col-4">
                                    <div class="item-name col-5">被吊销时间：</div>
                                    <div class="ipt-box col-7">
                                        <input type="text" id="revDate" name="revDate" readonly="readonly"
                                               class="ipt-txt laydate-icon">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name col-4">被吊销原因：</div>
                                    <div class="ipt-box col-7">
                                        <input type="text" name="sugRevReason" id="sugRevReason" value=""
                                               class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                        <ul>
                            <li class="clearfix">
                                <div class="col-4">
                                    <div class="item-name col-5">其他无效时间：</div>
                                    <div class="ipt-box col-7">
                                        <input type="text" name="invAlidDate" id="invAlidDate" readonly="readonly"
                                               class="ipt-txt laydate-icon">
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name col-4">其他无效原因：</div>
                                    <div class="ipt-box col-7">
                                        <input type="text" name="invAliDRea" id="invAliDRea" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <p class="center mt10"><input type="button" id="savechange" value="保存" class="btn mr20"><input type="button"
                                                                                                       id="cancle"
                                                                                                       value="取消"
                                                                                                       class="btn"></p>
    </div>
</div>

<form id="changeForm"></form>


<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<!-- <script>
    $(document).on('click', '.tab-c-title input', function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
    })
</script> -->
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/server/other/otherlicence/otherlicence_change_main.js"/>"></script>

</body>
</html>