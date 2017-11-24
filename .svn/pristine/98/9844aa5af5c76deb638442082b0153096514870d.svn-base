<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title></title>
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<style type="text/css">
.inType{width: 400px;}
.commonType{display:none}
</style>
<body>
<div class="pd20 clearfix">
    <div class="" style="margin-top: 20px;">
        <form id="pubjusticeForm">
              <input type="hidden" id="userType" value="${userType }">
            <input type="hidden" id="priPID" name="priPID" value="${pubJusticeInfo.priPID}">
            <input type="hidden" id="UID" name="UID" value="${pubJusticeInfo.UID}">
            <input type="hidden" id="auditState" name="auditState" value="${pubJusticeInfo.auditState}">
            <!--被执行人证件类型 -->
            <input type="hidden" id="hiddencerType" name="cerType"> 
            <!--上一条冻结数据的UID -->
            <input type="hidden"  id="upJusticeNO" name="upJusticeNO"/>
            <input type="hidden"  id="justiceConNO" name="justiceConNO" value="${pubJusticeInfo.justiceConNO}"/>
            <!--股权冻结状态 -->
            <input type="hidden" id="frozState" name="frozState">
			<!--公示信息类别 -->
            <input type="hidden" id="justiceType" name="justiceType" value="">
            <!--失效原因 -->
            <input type="hidden" id="loseEffRes" name="loseEffRes" value="${pubJusticeInfo.loseEffRes}">
            <!--失效日期 -->
            <input type="hidden" id="loseEffDate" name="loseEffDate" value="${pubJusticeInfo.loseEffDate}">
            
        	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10">
	            <tr>
						<td class="bg-gray right">股权所在企业统一代码/注册号</td>
						<td colspan="3">
						   <div class="ipt-box pd0">
								<input type="text" id="regNo" class="inType ipt-txt" name="uniSCID" value="${pubJusticeInfo.uniSCID}" readonly="readonly"/>
					       </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right">股权所在企业名称</td>
						<td colspan="3">
						     <div class="ipt-box pd0">
								<input type="text" readonly="readonly" id="entName" class="inType ipt-txt" name="entName" value="${pubJusticeInfo.entName}"/>
						     </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>执行法院</td>
						<td colspan="3">
						      <div class="ipt-box pd0">
								<input type="text" id="executionCourt" class="inType ipt-txt" name="executionCourt" value="${pubJusticeInfo.executionCourt}" maxlength="50" required/>
							  </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>执行事项</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<select id="executeItem" name="executeItem">
								<option value="">请选择</option>
								<option value="1" ${pubJusticeInfo.executeItem =='1'?'selected':''}>公示冻结股权、其他投资权益</option>
								<option value="2" ${pubJusticeInfo.executeItem =='2'?'selected':''}>续行冻结股权、其他投资权益</option>
								<option value="3" ${pubJusticeInfo.executeItem =='3'?'selected':''}>解除冻结股权、其他投资权益</option>
								<option value="4" ${pubJusticeInfo.executeItem =='4'?'selected':''}>强制转让被执行人股权，办理有限责任公司股东变更登记</option>
							</select>
							<p style="color:red;">提示：如果选择“续行冻结股权、其他投资权益”或者“解除冻结股权、其他投资权益”事项，请从“已有的被执行人中选取”选取相关被执行人信息！</p>
						  </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right">司法协助公示通知书文号</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<input type="text" class="inType ipt-txt" id="botRefNum" name="botRefNum" value="${pubJusticeInfo.botRefNum}" maxlength="50"/>
						  </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>执行裁定书文号</td>
						<td colspan="3">
						 <div class="ipt-box pd0">
							<input type="text" id="exeRulNum" class="inType ipt-txt" name="exeRulNum" value="${pubJusticeInfo.exeRulNum}" maxlength="25" required/>
						 </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>执行通知书文号</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<input type="text" id="executeNo" class="inType ipt-txt" name="executeNo" value="${pubJusticeInfo.executeNo}" maxlength="50" required/>
						  </div>
						</td>
					</tr>
					
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>经办人姓名</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<input type="text" id="executeNo" class="inType ipt-txt" name="operatorName" value="${pubJusticeInfo.operatorName}" maxlength="20" required/>
						  </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>经办人电话</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<input type="text" id="executeNo" class="inType ipt-txt isTel" name="operatorTel" value="${pubJusticeInfo.operatorTel}" maxlength="30" required/>
						  </div>
						</td>
					</tr>
					
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>被执行人</td>
						<td colspan="3">
						     <div class="ipt-box pd0">
								<input type="text" id="inv" name="inv" value="${pubJusticeInfo.inv}" style="width:55%;" maxlength="50" class="only ipt-txt" required/>
								<a href="javascript:void(0);" id="doEnInclude" style="text-decoration: underline;">从已有的被执行人中选取</a>
							 </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>被执行人证照(证件)种类</td>
						<td colspan="3">
						   <div class="ipt-box pd0">
								<select id="cerType" class="cer ipt-txt" >
								    <option value="">请选择</option>
								    <c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
								    <option value="${codeCertype.code}" ${pubJusticeInfo.cerType == codeCertype.code?'selected':''}>${codeCertype.content}</option>
                                    </c:forEach>
								</select>
						  </div>
						</td>
					</tr>
					<tr>
						<td class="bg-gray right"><span style="color:red">* </span>被执行人证照(证件)号码</td>
						<td colspan="3">
						   <div class="ipt-box pd0">
								<input type="text" id="cerNO" name="cerNO" class="idNo only inType ipt-txt" value="${pubJusticeInfo.cerNO}" maxlength="20" required/>
						   </div>
						</td>
					</tr>
					<tr>
						<td _width="32%" width="32%" class="bg-gray right"><span style="color:red">* </span>被执行人持有股权、其他投资权益的数额</td>
						<td _width="28%" width="28%">
						   <div class="ipt-box pd0">
								<input type="text" id="froAm" name="froAm" class="number only ipt-txt" value="${pubJusticeInfo.froAm}" maxlength="12" required/>
								<p style="color: red;">(万)</p>
						   </div>
						</td>
						<td _width="10%" width="10%" class="bg-gray right"><span style="color:red">* </span>币种</td>
						<td _width="30%" width="30%">
						   <div class="ipt-box pd0">
						      <select id="regCapCur" name="regCapCur" class="only" required>
									<option value=""></option>
									<option value="156" ${pubJusticeInfo.regCapCur =='156'?'selected':''}>人民币元</option>
									<option value="344" ${pubJusticeInfo.regCapCur =='344'?'selected':''}>香港元</option>
									<option value="124" ${pubJusticeInfo.regCapCur =='124'?'selected':''}>加元</option>
									<option value="392" ${pubJusticeInfo.regCapCur =='392'?'selected':''}>日元</option>
									<option value="826" ${pubJusticeInfo.regCapCur =='826'?'selected':''}>英镑</option>
									<option value="840" ${pubJusticeInfo.regCapCur =='840'?'selected':''}>美元</option>
									<option value="954" ${pubJusticeInfo.regCapCur =='954'?'selected':''}>欧元</option>
							  </select>
<%-- 						  <input type="text" id="froAuth" name="froAuth" class="only ipt-txt" value="${pubJusticeInfo.froAuth}" maxlength="25" required/> --%>
						   </div>
						</td>
					</tr>
					<tr class="commonType froType">
						<td _width="32%" width="32%" class="bg-gray right"><span style="color:red">* </span>冻结比例(%)</td>
						<td _width="28%" width="28%">
						   <div class="ipt-box pd0">
								<input type="text" id="frozenProp" name="frozenProp" class="number ipt-txt" value="${pubJusticeInfo.frozenProp}" maxlength="10" required/>
						   </div>
						</td>
						<td _width="10%" width="10%" class="bg-gray right"><span style="color:red">* </span>冻结类型</td>
						<td _width="30%" width="30%">
						   <div class="ipt-box pd0">
						      <select id="frozSign" name="frozSign" class="only" required>
									<option value=""></option>
									<option value="1" ${pubJusticeInfo.frozSign =='1'?'selected':''}>全部股权冻结</option>
									<option value="2" ${pubJusticeInfo.frozSign =='2'?'selected':''}>部分股权冻结</option>
									<option value="9" ${pubJusticeInfo.frozSign =='9'?'selected':''}>其他</option>
							  </select>
						   </div>
						</td>
					</tr>
					<tr class="commonType froType">
						<td class="bg-gray right"><span style="color:red">* </span>冻结期限自</td>
						<td>
						  <div class="ipt-box pd0">
						   <input type="text" class="inType ipt-txt" style="width: 200px;cursor: pointer;" id="froFrom"  onclick="laydate()" readonly="readonly"
	                       name="froFrom" value="<fmt:formatDate value="${pubJusticeInfo.froFrom}" pattern="yyyy-MM-dd" />" />
	                      </div>
						</td>
						<td class="bg-gray right"><span style="color:red">* </span>冻结期限至</td>
						<td>
						  <div class="ipt-box pd0">
						   <input type="text" style="width: 200px;cursor: pointer;" id="froTo"  onclick="laydate()" readonly="readonly"
	                       name="froTo" value="<fmt:formatDate value="${pubJusticeInfo.froTo}" pattern="yyyy-MM-dd" />" class="inType ipt-txt"/>
	                      </div>
						</td>
					</tr>
					<tr class="commonType froType">
						<td class="bg-gray right"><span style="color:red">* </span>冻结期限</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
								<input type="text" id="frozDeadline" name="frozDeadline" value="${pubJusticeInfo.frozDeadline}" class="inType  ipt-txt" maxlength="25"/>
								<p style="color: red;">指冻结时间长度，默认单位为（天）</p>
						  </div>
						</td>
					</tr>
					<tr class="commonType thawType">
						<td class="bg-gray right"><span style="color:red">* </span>解除冻结日期</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
						    <input type="text" style="width: 100px;cursor: pointer;"  onclick="laydate()" readonly="readonly"
	                       name="thawDate" value="<fmt:formatDate value="${pubJusticeInfo.thawDate}" pattern="yyyy-MM-dd" />" class="inType ipt-txt"/>
	                      </div>
						</td>
					</tr>
					<tr class="commonType thawType froType">
						<td class="bg-gray right"><span style="color:red">* </span>公示日期</td>
						<td colspan="3">
						<div class="ipt-box pd0">
							<input type="text" style="width: 100px;cursor: pointer;"  onclick="laydate()" readonly="readonly"
	                       name="publicDate" value="<fmt:formatDate value="${pubJusticeInfo.publicDate}" pattern="yyyy-MM-dd" />" class="inType ipt-txt"/>
	                     </div>
						</td>
					</tr>
					<tr class="commonType alienType">
						<td class="bg-gray right"><span style="color:red">* </span>受让人</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<input type="text" id="assInv" class="inType ipt-txt" name="assInv" value="${pubJusticeInfo.assInv}" maxlength="50"/>
						  </div>
						</td>
					</tr>
					<tr class="commonType thawType">
						<td class="bg-gray right"><span style="color:red">* </span>解冻说明</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
							<textarea id="thawComment" style="width:100%;height: 80px" class="inType ipt-txt" name="thawComment" maxlength="500">${pubJusticeInfo.thawComment}</textarea>
						  </div>
						</td>
					</tr>
					<tr class="commonType alienType">
						<td class="bg-gray right"><span style="color:red">* </span>受让人证照(证件)种类</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
								<select id="assCerType" name="assCerType" class="inType idNo ipt-txt">
									<option value="">请选择</option>
									<c:forEach var="codeCertype" items="${codeCertypeList}" varStatus="">
								    <option value="${codeCertype.code}" ${pubJusticeInfo.assCerType == codeCertype.code?'selected':''}>${codeCertype.content}</option>
                                    </c:forEach>
								</select>
						  </div>
						</td>
					</tr>
					<tr class="commonType alienType">
						<td class="bg-gray right"><span style="color:red">* </span>受让人证照(证件)号码</td>
						<td colspan="3">
						  <div class="ipt-box pd0">
						    <input type="text" id="assCerNO" name="assCerNO" class="inType ipt-txt" value="${pubJusticeInfo.assCerNO}" maxlength="20"/>
						   </div>
						</td>
					</tr>
					<tr class="commonType alienType">
						<td class="bg-gray right"><span style="color:red">* </span>协助执行日期</td>
						<td colspan="3">
						 <div class="ipt-box pd0">
						  <input type="text" style="width: 100px;cursor: pointer;"  onclick="laydate()" readonly="readonly"
	                       name="executeDate" value="<fmt:formatDate value="${pubJusticeInfo.executeDate}" pattern="yyyy-MM-dd" />" class="inType ipt-txt"/>
	                      </div>
						</td>
					</tr>
                </table>
           <div class="clearfix mt10">
            <div class="center mb10">
                <button id="save" type="submit" class="btn mr20">保存</button>
                <button id="cancel" type="button" class="btn">关闭</button>
            </div>
           </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/other/pubjusticeinfo/pubjusticeinfo_edit_main.js"></script>
</body>
</html>