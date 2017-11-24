<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/syn.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="pd10">
<div class="print-nocard">
    <h3>抽查检查任务录入</h3>
    <h6 class="mb5 h6-title">检查任务</h6>
    <input type="hidden" id="realName" value="${sessionScope.session_sys_user.realName}">
    <form id="resulthis-form">
    <input type="hidden" id="taskNO" name="taskNO" value="${pubSctask.UID }">
    <input type="hidden" id="priPID" name="priPID" value="${pubScinfo.priPID }">
    </form>
    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
        <tbody>
            <tr>
                <td class="bg-gray right" width="14%">任务编号：</td>
                <td>
                ${pubSctask.taskCode}
                </td>
                <td colspan="2" class="left-border-none">
                    <span class="fr light-gray2">任务牵头组织机关简称+抽查+年度+序号，如：浙工商抽查[2017]1号</span>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务名称：</td>
                <td colspan="3">
                ${pubSctask.taskName}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务组织部门：</td>
                <td width="36%">
                ${pubSctask.leaderDeptDesc}
                </td>
                <td class="bg-gray right" width="14%">抽查方式：</td>
                <td width="36%">
                 ${pubSctask.speckWay=='0'?'定向':'不定向'}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查实施部门：</td>
                <td colspan="3">
                ${pubSctask.implDeptDesc}
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查主体范围：</td>
                <td>
                ${pubSctask.taskEntCatgDesc}
                </td>
                <td class="bg-gray right">任务期限：</td>
                <td>
                    <fmt:formatDate value="${pubSctask.startDate}" pattern="yyyy-MM-dd" />&nbsp;至&nbsp;<fmt:formatDate value="${pubSctask.endDate}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">任务说明（2000字内）：</td>
                <td colspan="3">
                    <div class="ipt-box">
                        <textarea id="checkContent"  class="min-h100" readonly>${pubSctask.checkContent}</textarea>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <h6 class="mb5 h6-title mt10">企业基本信息</h6>
    <input type="hidden" value="${pubScinfo.id }" id="pubScinfoId"/>
    <table cellpadding="0" cellspacing="0" border="0" class="table-horizontal">
        <tbody>
        <tr>
            <td class="bg-gray right" width="14%">统一信用代码/注册号</td>
            <td>
            	<c:if test="${!empty pubScinfo.uniCode}">
            		${pubScinfo.uniCode }
            	</c:if>
            	<c:if test="${empty pubScinfo.uniCode}">
            		${pubScinfo.regNO }
            	</c:if>
            </td>
            <td class="bg-gray right" width="12%">企业名称</td>
            <td>${pubScinfo.entName }</td>
        </tr>
        <tr>
            <td class="bg-gray right">法定代表人</td>
            <td>${pubScinfo.leRep }</td>
            <td class="bg-gray right">住所（经营场所）</td>
            <td>${pubScinfo.dom }</td>
        </tr>
        <tr>
            <td class="bg-gray right">企业联络员</td>
            <td>${pubScinfo.liaName }</td>
            <td class="bg-gray right">联络员联系电话</td>
            <td>${pubScinfo.leRepPhone }</td>
        </tr>
        </tbody>
    </table>
    <h6 class="mb5 h6-title mt10">企业警示信息</h6>
    <div class="more-brief-info bg-gray">
        <em>重点行业标识（<font class="light">${jgNum }</font>）</em>
		  <em>关注服务标识（<font class="light">${gzNum }</font>）</em>
	      <em>企业风险标识（<font class="light">${yjNum }</font>）</em>
<!-- 	      <em>直接关联企业（<font class="light">4</font>）</em> -->
    </div>
    <h6 class="mb5 h6-title mt10">历史抽查检查情况</h6>
    <table border="0" cellspacing="0" id="resulthis-table" cellpadding="0" class="table-row perc-100 mt30 nowrap">
        <thead>
        <tr>
            <th>序号</th>
            <th>任务编号</th>
            <th>组织部门</th>
            <th>检查机关</th>
            <th>抽检状态</th>
            <th>检查结果</th>
        </tr>
        </thead>
    </table>
    <h6 class="mb5 h6-title mt10">抽查检查情况</h6>
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-header type-tab tbmr1 border-bottom gray-bg">
                <ul class="clearfix" id="tab_ul_li">
                	<c:forEach items="${pubDeptSctaskDtoList}" var="pubDeptSctaskDto" varStatus="status">
	                 		<li <c:if test="${pubDeptSctaskDto.inspectDept == sessionDeptCode}">class="tab-selected" flag="Y" id="ownLi"</c:if> <c:if test="${pubDeptSctaskDto.inspectDept != sessionDeptCode}">flag="N"</c:if> lichooseid="${pubDeptSctaskDto.UID}" deptCode="${pubDeptSctaskDto.inspectDept}" deptDesc="${pubDeptSctaskDto.inspectDesc}">
		                    <span class="tab-item">
		                    	<a href="javascript:void(0);" class="min90">
		                    	<c:if test="${pubDeptSctaskDto.resultFlag == '1' }">
		                    		<i class="right-icon"></i>
	                    		</c:if>
	                    		<c:if test="${empty pubDeptSctaskDto.resultFlag  || pubDeptSctaskDto.resultFlag == '0'}">
		                    		<i class="new-icon"></i>
		                    	</c:if>
		                    	${pubDeptSctaskDto.inspectDesc}</a>
		                    </span>
	                    </li>
	                </c:forEach>
                </ul>
            </div>
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
            		<input type="hidden" value="${pubDeptSctaskDto.inspectState }" id="inspectState"/>
            		<input type="hidden" value="1" id="resultFlag"/>
            		<input type="hidden" value="${pubDeptSctaskDto.inspectType }" id="inspectType"/>
            		<input type="hidden" value="${pubDeptSctaskDto.inspectDept }" id="inspectDept"/>
            		<input type="hidden" value="${pubDeptSctaskDto.id }" class="pubDeptSctask" id="pubDeptSctaskId"/>
                    <div class="mt10">
                        <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mb10" id="checkItemTable">
                            <tr>
                                <th width="5%">序号</th>
                                <th width="20%">检查科目</th>
                                <th width="40%">检查事项</th>
                                <th width="35%">检查结果（选中代表一致和公示）</th>
                            </tr>
		            		<c:forEach items="${pubScitemResultList}" var="pubScitemResult" varStatus="vstatus">
	                            <tr>
	                                <td>${vstatus.index + 1}</td>
	                                <td class="left pd3">${pubScitemResult.scName }</td>
	                                <td class="center pd3">${pubScitemResult.itemName }</td>
	                                <td class="pd3">
	                                    <div class="ipt-box">
	                                    	<input type="hidden" value="${pubScitemResult.id }" itemindex="${vstatus.index}" class="itemindex" id="itemResultId_${vstatus.index}"/>
	                                    	<input type="hidden" value="${pubScitemResult.itemCode }" id="itemCode_${vstatus.index}"/>
	                                    	<input type="hidden" value="${pubScitemResult.itemName }" id="itemName_${vstatus.index}"/>
	                                    	<input type="hidden" value="${pubScitemResult.scType }" id="scType_${vstatus.index}"/>
	                                    	<input type="hidden" value="${pubScitemResult.scName }" id="scName_${vstatus.index}"/>
	                                    	<input type="checkbox" name="sameFlag" id="sameFlag_${vstatus.index}" value="1" <c:if test="${pubScitemResult.sameFlag == '1' }">checked="checked"</c:if>/>是否一致
	                                    	<input type="checkbox" name="pubFlag" id="pubFlag_${vstatus.index}" value="1" <c:if test="${pubScitemResult.pubFlag == '1' }">checked="checked"</c:if>/>是否公示
	                                    	<input type="text" class="ipt-txt" id="itemResult_${vstatus.index}" value="${pubScitemResult.scResult}"  style="width:170px"/>
	                                    </div>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </table>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form mb10">
                            <tbody>
                            	 <tr>
	                                <td class="bg-gray right" width="12%">其他需要说明事项
	                                </td>
	                                <td colspan="5" class="h76 pd3">
	                                    <div><textarea name="remark" id="remark" cols=" " rows="5" >${pubScresult.remark }</textarea></div>
	                                </td>
	                            </tr>
                            	<tr>
	                                <td class="bg-gray right" width="12%">检查结果</td>
	                                <td colspan="5" class="h76">
	                                	<input type="hidden" id="resultId" value="${pubScresult.id }"/>
	                                	<input type="hidden" id="resultTaskNO" value="${pubDeptSctaskDto.UID }"/>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" class="scResult" id="scResult_1" value="1" <c:if test="${fn:indexOf(pubScresult.scResult, '1')!=-1}">checked="checked"</c:if> onclick="selectNomal('1');"  itemva="正常（符合信息公示相关规定）"/>正常（符合信息公示相关规定）</label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_5" value="5" <c:if test="${fn:indexOf(pubScresult.scResult, '5')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('5');"  itemva="公示信息隐瞒真实情况、弄虚作假"/>公示信息隐瞒真实情况、弄虚作假 </label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_9" value="9" <c:if test="${fn:indexOf(pubScresult.scResult, '9')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('9');"  itemva="被撤销登记"/>被撤销登记</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" class="scResult" id="scResult_2" value="2" <c:if test="${fn:indexOf(pubScresult.scResult, '2')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('2');"  itemva="未按规定公示即时信息"/>未按规定公示即时信息</label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_3" value="3" <c:if test="${fn:indexOf(pubScresult.scResult, '3')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('3');"  itemva="未按规定公示年报信息"/>未按规定公示年报信息</label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_6" value="6" <c:if test="${fn:indexOf(pubScresult.scResult, '6')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('6');"  itemva="不予配合情节严重"/>不予配合情节严重</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" class="scResult" id="scResult_4" value="4" <c:if test="${fn:indexOf(pubScresult.scResult, '4')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('4');"  itemva="通过登记的住所（经营场所）无法联系"/>通过登记的住所（经营场所）无法联系</label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_7" value="7" <c:if test="${fn:indexOf(pubScresult.scResult, '7')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('7');"  itemva="已办理营业执照注销"/>已办理营业执照注销</label>
	                                        <label><input type="checkbox" class="scResult" id="scResult_8" value="8" <c:if test="${fn:indexOf(pubScresult.scResult, '8')!=-1}">checked="checked"</c:if> onclick="selectUnNomal('8');"  itemva="被吊销营业执照"/>被吊销营业执照</label>
	                                    </div>
	                                    <input type="hidden" id="scResult"  value="${pubScresult.scResult }"/>
	                                    <div><textarea name="scDetail" id="resultDetail" name="resultDetail" cols=" " rows="5" >${pubScresult.scDetail }</textarea></div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">后续处置</td>
	                                <td colspan="5">
	                                	<input type="hidden" id="disposeId" value="${pubScdispose.id }"/>
	                                	<input type="hidden" id="discopeTaskNO" value="${pubDeptSctaskDto.UID }"/>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_1" value="1" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '1')!=-1}">checked="checked"</c:if>  itemva="责令其公示未公示信息"/>责令其公示未公示信息</label>
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_2" value="2" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '2')!=-1}">checked="checked"</c:if>  itemva="责令其更正错误信息"/>责令其更正错误信息</label>
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_3" value="3" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '3')!=-1}">checked="checked"</c:if>  itemva="责令其改正虚假公示的信息"/>责令其改正虚假公示的信息</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_4" value="4" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '4')!=-1}">checked="checked"</c:if>  itemva="列入经营异常名录"/>列入经营异常名录</label>
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_5" value="5" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '5')!=-1}">checked="checked"</c:if>  itemva="公示其不予配合情节"/>公示其不予配合情节</label>
	                                        <label><input type="checkbox" class="scdispose" id="scdispose_6" value="6" onclick="choosedispose();" <c:if test="${fn:indexOf(pubScdispose.scResult, '6')!=-1}">checked="checked"</c:if>  itemva="依法处理违反企业登记相关违法行为"/>依法处理违反企业登记相关违法行为</label>
	                                    </div>
	                                    <input type="hidden" id="disposeScResult"  value="${pubScdispose.scResult }"/>
	                                    <div><textarea name="disposeDetail" id="disposeDetail" cols=" " rows="5" >${pubScdispose.scDetail }</textarea></div>
	                                </td>
	                            </tr>
	                         	<tr>
	                                <td class="bg-gray right"  width="12%">检查机关</td>
	                                <td width="34%">
	                                  <div class="ipt-box">
	                                    <input type="text" class="ipt-txt" id="checkDesc" value="${empty pubScresult.scDeptName?pubScinfo.regOrgDesc:pubScresult.scDeptName}" />
	                                  </div>  
	                                </td>
	                                <td class="bg-gray right" width="10%">检查人员</td>
	                                <td width="17%">${agentNames}</td>
	                                <td class="bg-gray right" width="10%">检查日期</td>
	                                <td width="17%">
	                                <div class="ipt-box">
          	                             <input type="text" class="ipt-txt ipt-txt-sm icon-date" id="inspectDate"  value="<fmt:formatDate value='${pubScresult.inspectDeptTime}' pattern='yyyy-MM-dd'/>" readonly="readonly" onclick="laydate();"/>
          	                        </div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">录入人</td>
	                                <td >${empty pubScresult.setUserName?sessionScope.session_sys_user.realName:pubScresult.setUserName }</td>
	                                <td class="bg-gray right" width="10%">录入日期</td>
	                                <td colspan="3">${currentDate }</td>
	                            </tr>
                        	</tbody>
                        </table>
                        
                        <h6 class="mb5 h6-title mt10">历史审核意见</h6>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 table-form">
                             <tbody>
                               <tr>
                                 <td class="bg-gray center" width="8%">序号</td>
                                 <td class="bg-gray center" width="15%">审核结果</td>
                                 <td class="bg-gray center" width="42%">审核意见</td>
                                 <td class="bg-gray center" width="15%">审核人</td>
                                 <td class="bg-gray center" width="20%">审核日期</td>
                               </tr>
                             <c:if test="${!empty pubScresultOpinionHisList}">
                               <c:forEach items="${pubScresultOpinionHisList}" var="pubScresultOpinionHis" varStatus="status">
                                <tr>
                                  <td class="center">${status.count}</td>
                                  <td class="center">
	                                  <c:if test="${pubScresultOpinionHis.auditFlag =='2'}">通过</c:if>
	                                  <c:if test="${pubScresultOpinionHis.auditFlag =='3'}">不通过</c:if>
	                                  <c:if test="${pubScresultOpinionHis.auditFlag =='5'}">退回修改</c:if>
                                  </td>
                                  <td class="center">${pubScresultOpinionHis.auditOpin}</td>
                                  <td class="center">${pubScresultOpinionHis.auditUserName}</td>
                                  <td class="center"><fmt:formatDate value="${pubScresultOpinionHis.auditDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
                                </tr>
                               </c:forEach>
                             </c:if>
                             <c:if test="${empty pubScresultOpinionHisList}">
                                <tr>
                                   <td colspan="5" class="center">暂无历史审核意见</td>
                                </tr>
                             </c:if>
                             </tbody>
                        </table>
                    </div>
                </div>
                
                <div class="tab-panel tab-panel-show" id="itemPanelOtherDivId" style="display: none;">
                    <div class="mt10">
                        <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 mb10" id="checkItemOtherTable">
                            <thead>
                            <tr>
                                <th width="5%">序号</th>
                                <th width="20%">检查科目</th>
                                <th width="40%">检查事项</th>
                                <th width="35%">检查结果（选中代表一致和公示）</th>
                            </tr>
                            </thead>
                            <tbody id="checkItemOtherTbody"></tbody>
                        </table>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
                            <tbody>
                            	 <tr>
	                                <td class="bg-gray right" width="12%">其他需要说明事项
	                                </td>
	                                <td colspan="5" class="h76 pd3">
	                                    <div><textarea rows="5"  id="remark_other"></textarea></div>
	                                </td>
	                            </tr>
                            	<tr>
	                                <td class="bg-gray right" width="12%">检查结果</td>
	                                <td colspan="5" class="h76">
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" id="scResult_other_1"  class="scResult_other" />正常（符合信息公示相关规定）</label>
	                                        <label><input type="checkbox" id="scResult_other_5"  class="scResult_other" />公示信息隐瞒真实情况、弄虚作假 </label>
	                                        <label><input type="checkbox" id="scResult_other_9"  class="scResult_other" />被撤销登记</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" id="scResult_other_2"  class="scResult_other"  />未按规定公示即时信息</label>
	                                        <label><input type="checkbox" id="scResult_other_3"  class="scResult_other"  />未按规定公示年报信息</label>
	                                        <label><input type="checkbox" id="scResult_other_6"  class="scResult_other"  />不予配合情节严重</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" id="scResult_other_4"  class="scResult_other"  />通过登记的住所（经营场所）无法联系</label>
	                                        <label><input type="checkbox" id="scResult_other_7"  class="scResult_other"  />已办理营业执照注销</label>
	                                        <label><input type="checkbox" id="scResult_other_8"  class="scResult_other"  />被吊销营业执照</label>
	                                    </div>
	                                    <div><textarea id="resultDetail_other" rows="5" ></textarea></div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">后续处置</td>
	                                <td colspan="5">
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" id="scdispose_other_1"   class="scdispose_other"  />责令其公示未公示信息</label>
	                                        <label><input type="checkbox" id="scdispose_other_2"   class="scdispose_other"/>责令其更正错误信息</label>
	                                        <label><input type="checkbox" id="scdispose_other_3"   class="scdispose_other"/>责令其改正虚假公示的信息</label>
	                                    </div>
	                                    <div class="radio-box w235">
	                                        <label><input type="checkbox" id="scdispose_other_4"   class="scdispose_other"/>列入经营异常名录</label>
	                                        <label><input type="checkbox" id="scdispose_other_5"   class="scdispose_other"/>公示其不予配合情节</label>
	                                        <label><input type="checkbox" id="scdispose_other_6"   class="scdispose_other"/>依法处理违反企业登记相关违法行为</label>
	                                    </div>
	                                    <div><textarea id="disposeDetail_other"  rows="5">${pubDeptSctaskDto.disposeDetail }</textarea></div>
	                                </td>
	                            </tr>
	                         	<tr>
	                                <td class="bg-gray right"  width="12%">检查机关</td>
	                                <td  width="34%" id="checkOrgDesc_other"></td>
	                                <td class="bg-gray right" width="10%">检查人员</td>
	                                <td  width="17%" id="checkAgent_other"></td>
	                                <td class="bg-gray right" width="10%">检查日期</td>
	                                <td  width="17%">
	                                	<div class="ipt-box">
	                                	<input type="text" class="ipt-txt" id="inspectDate_other" />
	                                	</div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">录入人</td>
	                                <td id="setOtherName"></td>
	                                <td class="bg-gray right" width="10%">录入日期</td>
	                                <td colspan="3"  id="setOtherTime"></td>
	                            </tr>
                        	</tbody>
                        </table>
                        
                        <h6 class="mb5 h6-title mt10">历史审核意见</h6>
                        <table  cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 table-form"  id="pubOpinionHisTable">
                             <thead>
                               <tr>
                                 <td class="bg-gray center" width="10%">序号</td>
                                 <td class="bg-gray center" width="15%">审核结果</td>
                                 <td class="bg-gray center" width="40%">审核意见</td>
                                 <td class="bg-gray center" width="15%">审核人</td>
                                 <td class="bg-gray center" width="20%">审核日期</td>
                               </tr>
                             </thead>
                             <tbody id="pubOpinionHisList"></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p class="center mb30 mt20">
	    <input type="button" class="btn mr20" id="save" value="保存">
<!-- 	    <input type="button" class="btn mr20" id="commit" value="提 交"> -->
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
</div>
<!-- <script src="/js/lib/jquery/jquery-1.12.3.min.js"></script> -->
<!-- <script src="/js/component/tab.js"></script> -->
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/pubscinforesult_edit.js"></script>
</body>
</html>