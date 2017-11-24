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
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <style type="text/css">
    	.yj-ipt .close-box .close-icon {
		    margin: 9px 8px 0 10px;
		}
    </style>
</head>
<body class="pd10">
<h5 class="com-info-title left pdl10">处罚类严违列入申请页面</h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
    <tbody>
     <tr>
        <td class="bg-gray right">企业名称</td>
        <td colspan="3" width="40%">${baseInfo.entName}</td>
        <td class="bg-gray right">统一代码（注册号）</td>
        <td>
	        <c:choose>
		   		<c:when test="${baseInfo.uniCode != '' && baseInfo.uniCode != null }">
		   			${baseInfo.uniCode}
		   		</c:when>
		   		<c:when test="${baseInfo.regNO != '' && baseInfo.regNO != null }">
		   			${baseInfo.regNO}
		   		</c:when>
			    <c:otherwise>
			    </c:otherwise>
			</c:choose>
        </td>
    </tr>
    <tr>
        <td class="bg-gray right" width="10%">法定代表人（负责人）</td>
        <td width="28%">${baseInfo.leRep}</td>
        <td class="bg-gray right" width="8%">联系电话</td>
        <td width="18%">${baseInfo.tel}</td>
        <td class="bg-gray right" width="11%">登记机关</td>
        <td>${baseInfo.regOrgName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">企业联络员</td>
        <td>${pubEppassword.lianame}</td>
        <td class="bg-gray right">联系电话</td>
        <td>${pubEppassword.tel}</td>
        <td class="bg-gray right">管辖单位</td>
        <td>${baseInfo.localAdmName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">登记状态</td>
        <td>${hx:publicStatus(baseInfo.regState)}</td>
        <td class="bg-gray right">注销日期</td>
        <td><c:if test="${midBaseInfo.regState=='XX'||midBaseInfo.regState=='DX'}"><fmt:formatDate value="${midBaseInfo.altDate}" pattern="yyy年MM月dd日"/></c:if></td>
        <td class="bg-gray right">片区/商圈</td>
        <td>${baseInfo.sliceNOName}</td>
    </tr>
    <tr>
        <td class="bg-gray right">
            住所（经营场所）
        </td>
        <td colspan="5">${baseInfo.dom}</td>
    </tr>
    </tbody>
</table>
<h5 class="com-info-title left pdl10">严违失信信息<a class="fr mr10" href="##">严违失信历史记录</a></h5>
<table cellpadding="0" cellspacing="0" border="0" class="table-row mb10">
    <thead>
    <th class="bg-gray" width="5%">序号</th>
    <th class="bg-gray" width="5%">操作</th>
	<th class="bg-gray" width="10%">处罚类别</th>
    <th class="bg-gray" width="30%">行政处罚文号</th>
    <th class="bg-gray" width="20%">处罚决定日期</th>
    <th class="bg-gray" width="30%">处罚决定机关</th>
    </thead>
    <tbody id="srcList"></tbody>
</table>

<form id="applyForm">

	<input type="hidden" id="caseID" name="caseID" value="${caseID}" >
	<input type="hidden" id="priPID" name="priPID" value="${priPID}" >
	<input id="secBasedStr" name="secBasedStr" type="hidden"/>
	
	<h5 class="com-info-title left pdl10">列入严违信息
	    <a id="packUpOrUnFurled" href="javascript:void(0);" class="fr mr10"><span id="packUpOrUnFurled_">收起</span><i class="tran-icons"></i></a>
	    <a class="fr mr10" href="##">列入严违历史记录</a></h5>
	<table id="sevBreachInforTable" cellpadding="0" cellspacing="0" border="0" class="table-horizontal mb10">
	    <tbody>
	    <tr>
	        <td class="bg-gray right" width="8%" ><span style="color:red">*</span>列入严违原因</td>
	        <td width="66%">
                <div class="ipt-box">
                    <select name="addSecCause" id="addSecCause" style="width:100%">
                        <option value="">请选择..</option>
                        <option value="提交虚假材料或者采取其他欺诈手段隐瞒重要事实，取得公司变更或者注销登记，被撤销登记的">
                            提交虚假材料或者采取其他欺诈手段隐瞒重要事实，取得公司变更或者注销登记，被撤销登记的</option>
                        <option value="组织策划传销的，或者因为传销行为提供便利条件两年内受到三次以上行政处罚的">
                            组织策划传销的，或者因为传销行为提供便利条件两年内受到三次以上行政处罚的</option>
                        <option value="因直销违法行为两年内受到三次以上行政处罚的">因直销违法行为两年内受到三次以上行政处罚的</option>
                        <option value="因不正当竞争行为两年内受到三次以上行政处罚的">因不正当竞争行为两年内受到三次以上行政处罚的</option>
                        <option value="因提供的商品或者服务不符合保障人身、财产安全要求，造成人身伤害等严重侵害消费者权益的违法行为，两年内受到三次以上行政处罚的">
                            因提供的商品或者服务不符合保障人身、财产安全要求，造成人身伤害等严重侵害消费者权益的违法行为，两年内受到三次以上行政处罚的</option>
                        <option value="因发布虚假广告两年内受到三次以上行政处罚的，或者发布关系消费者生命健康的商品或者服务的虚假广告，造成人身伤害的或者其他严重社会不良影响的">
                            因发布虚假广告两年内受到三次以上行政处罚的，或者发布关系消费者生命健康的商品或者服务的虚假广告，造成人身伤害的或者其他严重社会不良影响的</option>
                        <option value="因商标侵权行为五年内受到两次以上行政处罚的">
                            因商标侵权行为五年内受到两次以上行政处罚的</option>
                        <option value="企业违反工商行政管理法律、行政法规，有第2项至第8项行为之一，两年内累计受到三次以上行政处罚的">
                            企业违反工商行政管理法律、行政法规，有第2项至第8项行为之一，两年内累计受到三次以上行政处罚的</option>
                    </select>
                </div>
	        </td>
	        <td class="bg-gray right" width="8%">最近处罚日期</td>
	        <td id="lastPunDate"></td>
	    </tr>
	    <tr>
	        <td class="bg-gray right"><span style="color:red">*</span>列入严违说明</td>
	        <td colspan="3">
	            <div class="max-height90">
	                <textarea name="addSecExplain" cols=" " rows="5" style="width:100%;box-sizing:border-box;resize:none" maxlength="200" placeholder="200字以内" ></textarea>
	            </div>
	        </td>
	    </tr>
	    <tr>
	        <td class="bg-gray right"><span style="color:red">*</span>列入严违依据</td>
	        <td colspan="3">
                <div class="ipt-box col-3">
                    <select name="addSecBasedNum" id="secbased">
                        <option value="1">1份</option>
                        <option value="2">2份</option>
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
                    <span class="light-dark-blue"><input type="text" class="ipt-txt"/></span>
                     <span class="close-box" idx="1"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr2 tr" style="display: none;">
            <td class="bg-gray right">依据2</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input class="ipt-txt" type="text"/></span>
                    <span class="close-box" idx="2"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr3 tr" style="display: none;">
            <td class="bg-gray right">依据3</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input class="ipt-txt" type="text"/></span>
                    <span class="close-box" idx="3"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr4 tr" style="display: none;">
            <td class="bg-gray right">依据4</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="4"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr5 tr" style="display: none;">
            <td class="bg-gray right">依据5</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue"><input class="ipt-txt" type="text"/></span>
                    <span class="close-box" idx="5"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
        <tr class="tr6 tr" style="display: none;">
            <td class="bg-gray right">依据6</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="6"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr7 tr" style="display: none;">
            <td class="bg-gray right">依据7</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="7"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr8 tr" style="display: none;">
            <td class="bg-gray right">依据8</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="8"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr9 tr" style="display: none;">
            <td class="bg-gray right">依据9</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="9"><i class="close-icon"></i></span></div>
            </td>
        </tr>
        <tr class="tr10 tr" style="display: none;">
            <td class="bg-gray right">依据10</td>
            <td colspan="3">
                <div class="ipt-box yj-ipt clearfix">
                    <span class="light-dark-blue mr10"><input type="text" class="ipt-txt"/></span>
                    <span class="close-box" idx="10"><i class="close-icon"></i></span>
                </div>
            </td>
        </tr>
	    </tbody>
	</table>
	<h5 id="h5" class="com-info-title left pdl10">审批意见信息<a style="color: red">&emsp;请于<fmt:formatDate value="${addSecTerm}" pattern="yyy年MM月dd日"/>前列入严违失信名单</a></h5>
	<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
	    <tbody>
		    <tr>
		        <td class="bg-gray right" width="9%">经办人</td>
		        <input type="hidden" name="applyDept" value="${sysUser.deptCode}"/>
           		<input type="hidden" name="applyDeptName" value="${sysUser.dept}"/>
		        <td width="20%"><div class="ipt-box"><input type="text" class="ipt-txt" name="applyMan" value="${sysUser.realName}" /></div></td>
		        <td class="bg-gray right" width="9%">经办人意见</td>
            	<td><div class="ipt-box"><input type="text" class="ipt-txt" name="applyCheck" value="拟将该企业列入严重违法失信企业名单，请处领导审批。" /></div></td>
	        	<td class="bg-gray right" width="9%">申请日期</td>
	        	<td><fmt:formatDate value="${now}" pattern="yyy-MM-dd"/></td>
		    </tr>
	    </tbody>
	</table>
</form>


<div class="center mt20">
    <input type="button" id="save" class="btn mr10" value="提交">
    <input type="button" id="cancel" class="btn" value="取消">
</div>

<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/secnocreditmanage/exppunmanage/apply.js"></script>
</body>
</html>