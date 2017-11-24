<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异常类严违申请列入</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style type="text/css">
    	.yj-ipt .close-box .close-icon {
		    margin: 9px 8px 0 10px;
		}
    </style>
</head>
<body class="pd10">
<h5 class="com-info-title left pdl10">企业基本信息</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
    <tr>
        <td class="bg-gray right">企业名称</td>
        <td colspan="3" width="40%">${midBaseInfo.entName}</td>
        <td class="bg-gray right">统一代码（注册号）</td>
        <td>
<%--         ${midBaseInfo.regNO} --%>
			<c:choose>
		   		<c:when test="${midBaseInfo.uniCode != '' && midBaseInfo.uniCode != null }">
		   			${midBaseInfo.uniCode}
		   		</c:when>
		   		<c:when test="${midBaseInfo.regNO != '' && midBaseInfo.regNO != null }">
		   			${midBaseInfo.regNO}
		   		</c:when>
			    <c:otherwise>
			    </c:otherwise>
			</c:choose>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right" width="10%">法定代表人（负责人）</td>
        <td width="28%">${midBaseInfo.leRep}</td>
        <td class="bg-gray right" width="8%">联系电话</td>
        <td width="18%">${midBaseInfo.tel}</td>
        <td class="bg-gray right" width="11%">登记机关</td>
        <td>${midBaseInfo.regOrgName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">企业联络员</td>
        <td>${pubEppassword.lianame}</td>
        <td class="bg-gray right">联系电话</td>
        <td>${pubEppassword.tel}</td>
        <td class="bg-gray right">管辖单位</td>
        <td>${midBaseInfo.localAdmName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">登记状态</td>
        <td>${hx:publicStatus(midBaseInfo.regState)}</td>
        <td class="bg-gray right">注销日期</td>
        <td><c:if test="${midBaseInfo.regState=='XX'||midBaseInfo.regState=='DX'}"><fmt:formatDate value="${midBaseInfo.altDate}" pattern="yyy年MM月dd日"/></c:if></td>
        <td class="bg-gray right">片区/商圈</td>
        <td>${midBaseInfo.sliceNOName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">
            住所（经营场所）
        </td>
        <td colspan="5">${midBaseInfo.dom}</td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">异常届满信息<a class="fr mr10" href="##">异常届满历史记录</a></h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-row mb10">
    <thead>
    <th class="bg-gray" width="30%">列入异常原因</th>
    <th class="bg-gray" width="12%">列入日期</th>
    <th class="bg-gray" width="30%">列入异常机关</th>
    <th class="bg-gray" width="11%">列入异常文号</th>
    <th class="bg-gray">异常届满日期</th>
    <th class="bg-gray">届满提醒公告日期</th>
    </thead>
    <tbody>
    <tr>
        <td>${pubOpanoMaly.speCauseCN}</td>
        <td><fmt:formatDate value="${pubOpanoMaly.abnTime}" pattern="yyy-MM-dd"/></td>
        <td>${pubOpanoMaly.decorgCN}</td>
        <td>${pubOpanoMaly.penDecNo}</td>
        <td>${pubOpanoMaly.secAbnTime}</td>
        <td><fmt:formatDate value='${pubOpanoMaly.secNoticeDate }' pattern='yyy-MM-dd'/></td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">列入严违信息
    <a id="packUpOrUnFurled" href="javascript:void(0);" class="fr mr10"><span id="packUpOrUnFurled_">收起</span><i class="tran-icons"></i></a>
    <a class="fr mr10" href="##">异常类列入严违历史记录</a></h5>

<form id="content_form">
    <input id="secBasedStr" name="secBasedStr" type="hidden"/>
    <input name="deptName" value="${pubOpanoMaly.deptName}" type="hidden"/>
    <input name="deptUpName" value="${pubOpanoMaly.deptUpName}" type="hidden"/>
    <input name="deptSameCourt" value="${pubOpanoMaly.deptSameCourt}" type="hidden"/>
    <input name="deptSameGov" value="${pubOpanoMaly.deptSameGov}" type="hidden"/>
    <input name="regState" value="${midBaseInfo.regState}" type="hidden"/>
    <input name="estDate" value="<fmt:formatDate value='${midBaseInfo.estDate}' pattern='yyy-MM-dd'/>" type="hidden"/>
    
    <table id="sevBreachInforTable" cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
        <tbody>
        <tr>
            <td class="bg-gray right" width="10%">列入严违原因</td>
            <td width="66%">
                <div class="ipt-box">
                    <input type="text" class="ipt-txt" name="addSecCause" value="被列入经营异常名录届满3年仍未履行相关义务的"/>
                </div>
            </td>
            <td class="bg-gray right" width="10%">异常届满日期</td>
            <td>
                <div class="ipt-box"><input type="text" class="ipt-txt" name="expExpiredDate"
                                            value="${pubOpanoMaly.secAbnTime}" readonly="readonly"/></div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">
                列入严违说明
            </td>
            <td colspan="3">
                <div class="">
                    <div class="ipt-box">
                    <textarea name="addSecExplain" rows="5">
    经查，该企业被列入经营异常名录届满3年，仍未履行相关义务。<fmt:formatDate value="${pubOpanoMaly.abnTime}" pattern="yyy年MM月dd日"/>,该企业因${pubOpanoMaly.speCauseCN}(事由)被${pubOpanoMaly.decorgCN}列入经营异常名录。截止<fmt:formatDate value='${pubOpanoMaly.secAbnTimeDesc}' pattern='yyy年MM月dd日'/>已届满三年，仍未履行相关义务。
以上事实有：
 	1.<fmt:formatDate value='${pubOpanoMaly.secAbnTimeDesc}' pattern='yyy年MM月dd日'/>《列入经营异常名录决定书》一份；
 	2.<fmt:formatDate value='${pubOpanoMaly.secNoticeDate }' pattern='yyy年MM月dd日'/>浙江省企业信用信息公示平台《列入经营异常名录满3年提醒公告》一份；
    上述行为违反了《企业信息公示暂行条例》的相关规定。
    根据《严重违法失信企业名单管理暂行办法》第五条第一款第（一）项的规定，建议将其列入严重违法失信企业名单并予以公示。
                    </textarea>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td class="bg-gray right">
                列入严违依据
            </td>
            <td colspan="3">
                <div class="ipt-box col-3">
                    <select name="addSecBasedNum" id="secbased">
                        <option value="1">1份</option>
                        <option value="2" selected>2份</option>
                        <option value="3">3份</option>
                        <option value="4">4份</option>
                        <option value="5">5份</option>
                        <option value="6">6份</option>
                        <option value="7">7份</option>
                        <option value="8">8份</option>
                        <option value="9">9份</option>
                        <option value="10">10份</option>
                    </select>
                </div>
            </td>
        </tr>
        <tr class="tr1 tr">
            <td class="bg-gray right">依据1</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input type="text" value="${baseone}" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr2 tr">
            <td class="bg-gray right">依据2</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue clearfix">
                        <input type="text" class="ipt-txt" value="<fmt:formatDate value='${pubOpanoMaly.secNoticeDate }' pattern='yyyy年MM月dd日'/>《列入经营异常名录满3年提醒公告》（公示系统）"/>
                    </span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr3 tr" style="display: none;">
            <td class="bg-gray right">依据3</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input class="ipt-txt" type="text"/></span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr4 tr" style="display: none;">
            <td class="bg-gray right">依据4</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr5 tr" style="display: none;">
            <td class="bg-gray right">依据5</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input class="ipt-txt" type="text"/></span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr6 tr" style="display: none;">
            <td class="bg-gray right">依据6</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr7 tr" style="display: none;">
            <td class="bg-gray right">依据7</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr8 tr" style="display: none;">
            <td class="bg-gray right">依据8</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr9 tr" style="display: none;">
            <td class="bg-gray right">依据9</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr10 tr" style="display: none;">
            <td class="bg-gray right">依据10</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>

        </tbody>
    </table>
    
    <h5 id="h5" class="com-info-title left pdl10">经办人意见信息 <a style="color: red">请于<fmt:formatDate value="${pubOpanoMaly.termAbnTime}" pattern="yyy年MM月dd日"/>前列入严违失信名单</a></h5>
    <input type="hidden" name="sourceId" value="${pubOpanoMaly.busExcList}"/>
    <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
        <tbody>
        <tr>
            <input type="hidden" class="ipt-txt"  name="addSecTerm" value="<fmt:formatDate value="${pubOpanoMaly.termAbnTime}" pattern="yyy-MM-dd"/>" />
            <td class="bg-gray right" width="9%">经办人</td>
            <input type="hidden" name="applyDept" value="${sysUser.deptCode}"/>
            <input type="hidden" name="applyDeptName" value="${sysUser.dept}"/>
            <td width="20%"><div class="ipt-box"><input type="text" class="ipt-txt" name="applyMan" value="${sysUser.realName}"/></div></td>
            <td class="bg-gray right" width="9%">经办人意见</td>
            <td><div class="ipt-box"><input type="text" class="ipt-txt" name="applyCheck" value="拟将该企业列入严重违法失信企业名单，请处领导审批。" /></div></td>
            <td class="bg-gray right" width="9%">申请日期</td>
            <td><fmt:formatDate value="${now}" pattern="yyy-MM-dd"/></td>
        </tr>
        </tbody>
    </table>
</form>

<div class="center mt20">
    <input id="save" type="button" class="btn mr10" value="提交">
    <input id="cancel" type="button" class="btn" value="取消">
</div>

<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/expsecmanage/applyadd.js"></script>
</body>
</html>