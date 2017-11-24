<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>重点监管标识信息</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div>
    <div class="bg-gray pd10 mb5">
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb10">
            <tr>
                <td width="12%" align="right" class="bg-gray">批次编号：</td>
                <td width="14%">${dto.batchNO}</td>
                <td width="16%" align="right" class="bg-gray">重点监管标识适用地区：</td>
                <td width="8%">${dto.markUseArea }</td>
                <td width="12%" align="right" class="bg-gray">重点监管标识级别：</td>
                <td width="8%">
                    <c:if test="${dto.markClass=='0'}">关注</c:if>
                    <c:if test="${dto.markClass=='1'}">警示</c:if>
                    <c:if test="${dto.markClass=='2'}">限制</c:if>
                </td>
                <td width="16%" align="right" class="bg-gray">重点监管标识状态：</td>
                <td>
                    <c:if test="${dto.markState=='0'}">无效</c:if>
                    <c:if test="${dto.markState=='1'}">有效</c:if>
                </td>
            </tr>
            <tr>
                <td align="right" class="bg-gray">重点监管标识名称：</td>
                <td colspan="5">
                    <div class="ipt-box">
                        ${dto.markName}
                    </div>
                </td>
                <td align="right" class="bg-gray">重点监管标识创建日期：</td>
                <td>
                    <div class="ipt-box">
                        <fmt:formatDate value="${dto.markCreateTime}" pattern="yyyy-MM-dd"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right" class="bg-gray">重点监管标识内容：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        ${dto.markName}
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right" colspan="" class="bg-gray">录入人：</td>
                <td>${dto.inputPer}</td>
                <td align="right" class="bg-gray">录入日期：</td>
                <td><fmt:formatDate value="${dto.inputDate}" pattern="yyyy-MM-dd"/></td>
                <td align="right" class="bg-gray">审核人：</td>
                <td>${dto.checkPer}</td>
                <td align="right" class="bg-gray">审核日期：</td>
                <td><fmt:formatDate value="${dto.checkDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td align="right" class="bg-gray">审核结果：</td>
                <td colspan="7">
                    ${dto.supCheckState =='1'? '同意列为重点监管申请':''}
                    ${dto.supCheckState =='3'? '退回修改本次重点监管申请':''}
                    ${dto.supCheckState =='0'? '不同意本次列入重点监管申请':''}
                </td>
            </tr>
            <tr>
                <td align="right" class="bg-gray"> 审核意见：</td>
                <td colspan="7">
                    <div class="ipt-box">
                        <textarea rows="4" name="checkAdv"> ${dto.checkAdv==''?'无': dto.checkAdv}</textarea>
                    </div>
                </td>
            </tr>
        </table>
        <div class="form-item clearfix">
            <div class="btn-box">
                <input type="button" id="back" value="关闭" class="btn">
            </div>
        </div>
    </div>

    <div>
        <form action="" id="search-form">
            <input type="hidden" name="batchNO" value="${batchNO}">
        </form>
        <table id="hx-table" border="0" cellspacing="0" cellpadding="0" class="table-row nowrap perc-100 mt30"
               width="100%">
            <thead>
            <tr>
                <th width="7%">序号</th>
                <th>批次号</th>
                <th>企业名称</th>
                <th>注册号</th>
                <th>统一信用代码</th>
                <th>法定代表人</th>
                <th>企业类型</th>
                <th>行业</th>
                <th>住所</th>
                <th>登记机关</th>
                <th>管辖单位</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/supervise/sup/sup_check_view.js"></script>
</body>
</html>