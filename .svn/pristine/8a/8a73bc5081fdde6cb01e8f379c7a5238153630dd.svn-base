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
    <h3>市场监管领域随机抽查情况记录表</h3>
    <div class="mt10">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
              	<div class="tab-panel tab-panel-show" id="itemPanelDivId">
              	<input type="hidden" id="taskUid" value="${pubScentResultDto.taskUid }">
              	<input type="hidden" id="mainTaskUid" value="${pubScentResultDto.mainTaskUid }">
              	<input type="hidden" id="priPID" value="${pubScentResultDto.priPID }">
              	<input type="hidden" id="uid" value="${pubScentResultDto.uid }">
              	<input type="hidden" id="auditState" value="${pubScentResultDto.auditState }">
              	<input type="hidden" id="dutyDeptCode" value="${pubScentResultDto.dutyDeptCode }">
                    <div class="mt10">
                        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
                            <tbody>
                            	<tr>
	                                <td class="bg-gray right" width="15%">任务名称</td>
	                                <td width="35%">${pubScentResultDto.taskName }</td>
	                                <td class="bg-gray right" width="15%">任务编号</td>
	                                <td width="35%">${pubScentResultDto.taskCode }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">被检查对象</td>
	                                <td>${pubScentResultDto.entName }</td>
	                                <td class="bg-gray right">统一信用代码/注册号</td>
	                                <td>${!empty pubScentResultDto.uniCode?pubScentResultDto.uniCode:pubScentResultDto.regNO}</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right" rowspan="2">住所地址</td>
	                                <td rowspan="2">${pubScentResultDto.dom }</td>
	                                <td class="bg-gray right">法定代表人</td>
	                                <td>${pubEppassword.lerep } ${pubEppassword.lerepphone }</td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray right">工商联络员</td>
	                                <td>${pubEppassword.lianame } ${pubEppassword.tel }</td>
	                            </tr>
	                         </tbody>
	                       </table>
	                       <table id="table2" cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                            	<td class="bg-gray center" width="5%">序号</td>
	                                <td class="bg-gray center" width="10%">检查内容</td>
	                                <td class="bg-gray center" width="45%">操作方法与要领</td>
	                                <td class="bg-gray center" width="10%">
	                                	<span class="light">*</span>是否规范
	                                </td>
	                                <td class="bg-gray center" width="30%"><span class="light">*</span>发现问题情况</td>
	                            </tr>
	                            <tr>
	                            	<td class="center indexkey">1</td>
	                            	<td class="center" id="content_1">单位情况</td>
	                            	<td id="method_1">资质证件是否在有效期内（1）营业执照。（2）生产(经营)许可证（只针对生产或经营易制毒化学品企业）。</td>
	                            	<td class="center"><input type="radio" value="1" class="checkkey" name="check1" problem="1" id="ra_1_1" defaultinput="资质证件符合规范"/>是
	                            		<input type="radio" name="check1" class="checkkey" problem="1" value="2" id="ra_1_2" defaultinput="资质证件不符合规范"/>否
	                            	</td>
	                            	<td class="center"><input type="input" id="problem_1" class="ipt-txt" style="width: 99%"/></td>
	                            </tr>
	                            <tr>
	                            	<td class="center indexkey">2</td>
	                            	<td class="center" id="content_2">台账情况</td>
	                            	<td id="method_2">（1）是否有购销、使用和出入库品种、数量、日期等记录情况；（2）购买许可、备案证明的签注购买数量、经办人内容是否如实填写；（3）台账中反映的时间、品种、数量是否在许可、备案证明的有效范围内。（4）台账中的资金往来（要求发票复印件留档）是否有现金交易</td>
	                            	<td class="center"><input type="radio" value="1" name="check2" problem="2" class="checkkey" id="ra_2_1" defaultinput="按规定记录、保存、备案易制毒化学品交易情况">是
	                            		<input type="radio" name="check2" problem="2" class="checkkey" value="2" id="ra_2_2" defaultinput="未按规定记录、保存、备案易制毒化学品交易情况">否
                            		</td>
	                            	<td class="center"><input type="input" id="problem_2" class="ipt-txt" style="width: 99%"/></td>
	                            </tr>
	                            <tr>
	                            	<td class="center indexkey">3</td>
	                            	<td class="center" id="content_3">仓库情况</td>
	                            	<td id="method_3">（1）是否落实易制毒化学品防盗、防抢、防丢失的人防、技防措施。（2）仓储物品品种、数量与台账是否一致</td>
	                            	<td class="center"><input type="radio" value="1" name="check3" problem="3" class="checkkey" id="ra_3_1" defaultinput="易制毒化学品仓库符合相关规定">是
	                            		<input type="radio" name="check3" class="checkkey" problem="3" value="2" id="ra_3_2" defaultinput="易制毒化学品仓库不符合相关规定及存在安全隐患">否</td>
	                            	<td class="center"><input type="input" id="problem_3" class="ipt-txt" style="width: 99%"/></td>
	                            </tr>
	                            <tr>
	                            	<td class="center indexkey">4</td>
	                            	<td class="center" id="content_4">安全制度情况 </td>
	                            	<td id="method_4">（1）是否按规定建立易制毒化学品购销、运输和仓储的安全管理制度。（2）是否有管理岗位职责分工。（3）是否进行从业人员培训</td>
	                            	<td class="center"><input type="radio" value="1" name="check4" problem="4" class="checkkey" id="ra_4_1" defaultinput="安全管理制度符合相关规定">是
	                            		<input type="radio" name="check4" class="checkkey" problem="4" value="2" id="ra_4_2" defaultinput="未按规定建立安全管理制度">否</td>
	                            	<td class="center"><input type="input" id="problem_4" class="ipt-txt" style="width: 99%"/></td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       	  <tbody>
	                            <tr>
	                                <td width="15%" class="bg-gray center"><span class="light">*</span>要求提供材料</td>
	                                <td width="85%" colspan="2">
	                                	<input type="checkbox" value="1" id="materail1" name="materail">营业执照
		                                <input type="checkbox" value="2" name="materail">取得的生产经营许可证和非药品类易制毒化学品生产经营备案证明<br/>
		                                <input type="checkbox" value="3" name="materail">身份证明
		                                <input type="checkbox" value="4" name="materail">日常手工台账
		                                <input type="checkbox" value="5" name="materail">购买许可证或备案证明 
		                                <input type="checkbox" value="6" name="materail">运输许可证或备案证明<br/>
		                                <input class="disaf" type="checkbox" name="materail" value="other">其他：<input id="materailOther" type="text">
	                                 </td>
	                            </tr>
	                            
	                            <tr>
	                                <td width="15%" class="bg-gray center" rowspan="6"><span class="light">*</span>检查结果</td>
	                                <td width="40%"><input class="crt" type="checkbox" id="result1" value="1" name="checkResultTmp" width="35%" textkey="未发现问题；"><strong>未发现问题</strong></td>
	                                <td rowspan="6" width="45%">
	                                	<input class="crt re3" type="checkbox" value="A" name="checkResultTmp" textkey="发现问题待后续处理；"><strong>发现问题待后续处理</strong><br/>
	                                	<p style="text-indent: 2em;line-height:2;"><input id="reCheckBox" class="crt re1" type="checkbox" value="G" name="checkResultTmp" textkey="违反公安部门相关规定；">违反公安部门相关规定</p>
	                                	<p style="text-indent: 2em;line-height:2;"><input class="crt re1" type="checkbox" value="5" name="checkResultTmp" textkey="违反其他部门相关规定；">违反其他部门相关规定</p>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="E" name="checkResultTmp" textkey="发现问题经责令已改正；"><strong>发现问题经责令已改正</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="F" name="checkResultTmp" textkey="未发现开展本次抽查涉及的经营活动；"><strong>未发现开展本次抽查涉及的经营活动</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="7" name="checkResultTmp" textkey="已关闭停业或正在组织清算；"><strong>已关闭停业或正在组织清算</strong></td>
	                            </tr>
	                            <tr>
	                                <td><input class="crt" type="checkbox" value="8" name="checkResultTmp" textkey="不配合检查情节严重；"><strong>不配合检查情节严重</strong></td>
	                            </tr>
	                            <tr>
	                            	<td>
	                                	<input class="crt" type="checkbox" value="9" name="checkResultTmp" textkey="注销；"><strong>注销</strong>
	                                	<input class="crt" type="checkbox" value="10" name="checkResultTmp" textkey="被吊销；"><strong>被吊销</strong>
	                                	<input class="crt" type="checkbox" value="11" name="checkResultTmp" textkey="被撤销；"><strong>被撤销</strong>
	                                	<input class="crt" type="checkbox" value="12" name="checkResultTmp" textkey="迁出；"><strong>迁出</strong>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="bg-gray center"><span class="light">*</span>后续处置措施</td>
	                                <td colspan="2">
	                                	<input class="disaf" type="checkbox" id="disposeMss1" name="disposeMssTmp" value="违法处罚；">违法处罚<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="刑事立案；">刑事立案<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="违反其他部门相关规定，抄告相关部门；">违反其他部门相关规定，抄告相关部门。<br>
	                                	<input class="disaf" type="checkbox" name="disposeMssTmp" value="other">其他：<input id="other" type="text">
	                                 </td>
	                            </tr>
	                          </tbody>
	                       </table>
	                       <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal table-form">
	                       		<tr>
	                       			<td class="bg-gray right" width="15%"><span class="light">*</span>后续处置措施是否完结</td>
	                       			<td width="35%"><input type="radio" value="1" name="disposeState" id="disposeState1" class="dis" checked="checked">未完结 
	                       				<input type="radio" value="2" name="disposeState" class="dis">已完结
	                       				<span class="sp" style="display: none"><textarea  rows="2" id="disposeFinishMss" name="disposeFinishMss"></textarea></span>
	                       				</td>
	                       			<td class="bg-gray right" width="15%"><span class="sp" style="display: none"><span class="light">*</span>完结日期</span></td>
	                       			<td width="35%"><span class="sp" style="display: none"><input type="text" id="disposeFinishDate" name="disposeFinishDate" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></span></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查执行部门</td>
	                       			<td colspan="3"><input id="checkDeptName" name="checkDeptName" type="text" value="${pubScentResultDto.checkDeptName }"></td>
	                       		</tr>
	                       		<tr>
	                       			<td class="bg-gray right"><span class="light">*</span>检查人员</td>
	                       			<td><input type="text" id="checkDeptPerson" name="checkDeptPerson" value="${pubScentResultDto.checkDeptPerson }">
<!-- 	                       			<a href="javascript:void(0);" id="addAgent">添加</a> -->
	                       			</td>
	                       			<td class="bg-gray right"><span class="light">*</span>检查日期</td>
	                       			<td><input id="checkDate" name="checkDate" type="text" class="ipt-txt laydate-icon" onclick="laydate()" readonly="readonly" value=""/></td>
	                       		</tr>
	                       </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p class="center mb30 mt20">
	    <input type="button" class="btn mr20" id="save" value="提交">
	    <input type="button" class="btn" id="close" value="关闭">
    </p>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scresult/garesult_edit.js"></script>
</body>
</html>