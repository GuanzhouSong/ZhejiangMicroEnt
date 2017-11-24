<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<form id="pubSccheckBillForm">
    <input type="hidden" id="" name="UID" value="${pubScCheckBill.UID}"/>
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="20%"><span style="color:red;">*</span>类别：</td>
                <td width="80%">
                    <div class="ipt-box pd0">
                        <select id="checkCode" name="checkCode">
                        	<option value="" ></option>
                        	<option value="A" ${pubScCheckBill.checkCode == "A"?"selected":""}>工商类</option>
                        	<option value="B" ${pubScCheckBill.checkCode == "B"?"selected":""}>食药类</option>
                        	<option value="C" ${pubScCheckBill.checkCode == "C"?"selected":""}>质监类</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查事项名称：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="checkItemDesc" name="checkItemDesc"  value="${pubScCheckBill.checkItemDesc}" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">检查子项名称：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="checkLittleItemDesc" name="checkLittleItemDesc"  value="${pubScCheckBill.checkLittleItemDesc}" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>检查依据：</td>
                <td>
                    <div class="ipt-box pd0">
                    	<textarea  id="checkReason" name="checkReason"  style="height:60px">${pubScCheckBill.checkReason}</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>检查对象：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" id="checkObject" name="checkObject"  value="${pubScCheckBill.checkObject}" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right"><span class="light">*</span>检查比例：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" class="ipt-txt" id="checkScale" name="checkScale" value="${pubScCheckBill.checkScale}"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span class="light">*</span>检查频次：</td>
                <td>
                    <div class="ipt-box pd0">
                        <input type="text" class="ipt-txt" id="checkFrequent" name="checkFrequent" value="${pubScCheckBill.checkFrequent}" required/>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right"><span class="light">*</span>检查方式：</td>
                <td>
                    <div style="font-size: 13px">
                    	<input type="hidden" id="checkWay" name="checkWay"/>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay1" class="checkWayV" value="1" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'1')!=-1?'checked':''}/>现场检查&nbsp;</label>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay2" class="checkWayV" value="2" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'2')!=-1?'checked':''}/>书式检查&nbsp;</label>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay3" class="checkWayV" value="3" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'3')!=-1?'checked':''}/>检验检测&nbsp;</label>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay4" class="checkWayV" value="4" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'4')!=-1?'checked':''}/>行政部门检查结果或专业意见&nbsp;</label>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay5" class="checkWayV" value="5" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'5')!=-1?'checked':''}/>审计、验资、评估等第三方验证&nbsp;</label>
                        <label style="cursor: pointer;"><input type="checkbox" id="checkWay6" class="checkWayV" value="6" class="ipt-txt" ${fn:indexOf(pubScCheckBill.checkWay,'6')!=-1?'checked':''}/>网络监测</label>
                    </div>
                </td>
            </tr>
             <tr>
                <td class="bg-gray right"><span class="light">*</span>检查内容及要求：</td>
                <td>
                    <div class="ipt-box pd0">
                    	<textarea  id="checkContent" name="checkContent"  style="height:60px">${pubScCheckBill.checkContent}</textarea>
                    </div>
                </td>
            </tr>
           </table>
           <div class="clearfix mb5">
			    <label><span style="color:red;">*</span>检查材料清单</label>
			    <a href="javascript:void(0);" style="float: right;margin-right: 0px;" id="toAddResult">添加</a>
			</div>
		    <table border="0" id="bill-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
		        <thead>
		        <tr>
		            <th width="10%">序号</th>
		            <th width="50%">材料名称</th>
		            <th width="40%">说明</th>
		        </tr>
		        </thead>
		    </table>
		    <div class="clearfix mb5">
			    <label><span style="color:red;">*</span>检查结果及后续处置</label>
			    <a href="javascript:void(0);" style="float: right;margin-right: 0px;" id="toAddResult">添加</a>
			</div>
		    
		    <table border="0" id="result-table" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap">
		        <thead>
		        <tr>
		            <th width="20%">检查结果</th>
		            <th width="40%">结果说明</th>
		            <th width="40%">后续处置</th>
		        </tr>
		        </thead>
		    </table>
           <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="20%"><span style="color:red;">*</span>检查人员要求：</td>
                <td width="80%" colspan="5">
                    <div class="ipt-box pd0" id="checkManFlagDiv">
                        <input type="radio" id="checkManFlag1" name="checkManFlag" style="cursor: pointer;" ${pubScCheckBill.checkManFlag == "N"?"checked":""} value="N"/>
                        <label style="cursor: pointer;" for="checkManFlag1">无需专业岗资格</label>
                        <input type="radio" id="checkManFlag2" name="checkManFlag" style="cursor: pointer;" ${pubScCheckBill.checkManFlag == "Y"?"checked":""} value="Y"/>
                        <label style="cursor: pointer;" for="checkManFlag2">需要专业岗资格</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">备注：</td>
                <td colspan="5">
                    <div class="ipt-box pd0">
                    	<textarea  id="remark" name="remark"  style="height:60px">${pubScCheckBill.remark}</textarea>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">责任处室：</td>
                <td colspan="5">
                    <div class="ipt-box pd0">
                        <input type="text" id="responsibleOffices" name="responsibleOffices"  value="${pubScCheckBill.responsibleOffices}" class="ipt-txt"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right"><span style="color:red;">*</span>状态：</td>
                <td colspan="5">
                    <div class="ipt-box pd0" id="isScVlidDiv">
                    	<input type="radio" id="isScVlid1" name="isScVlid" style="cursor: pointer;" value="Y" ${pubScCheckBill.isScVlid == "Y"?"checked":""}/>
                    	<label style="cursor: pointer;" for="isScVlid1">有效</label>
                    	<input type="radio" id="isScVlid2" name="isScVlid" style="cursor: pointer;" value="N" ${pubScCheckBill.isScVlid == "N"?"checked":""} />
                    	<label style="cursor: pointer;" for="isScVlid2">失效</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right">设置人：</td>
                <td>
                    <div class="ipt-box pd0">
                    	${empty pubScCheckBill.setUserName?sessionScope.session_sys_user.realName:pubScCheckBill.setUserName}
                    </div>
                </td>
                <td class="bg-gray right" width="15%">设置日期：</td>
                <td width="15%">
                    <div class="ipt-box pd0">
                    	<c:if test="${empty pubScCheckBill.setTime}">${sysdate}</c:if>
                    	<c:if test="${!empty pubScCheckBill.setTime}">
                    		<fmt:formatDate value='${pubScCheckBill.setTime}' pattern='yyyy-MM-dd'/>
                    	</c:if>
                    </div>
                </td>
                <td class="bg-gray right" width="15%">设置部门：</td>
                <td width="15%">
                    <div class="ipt-box pd0">
                    	${empty pubScCheckBill.setDeptName?deptName:pubScCheckBill.setDeptName}
                    </div>
                </td>
            </tr>
           </table>
           <p class="center mt10">
		       <input type="button" id="save" class="btn mr20" value="保 存"/>
		       <input type="button" class="btn" value="关 闭" id="close"/>
	       </p>
    </div>
</form>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/drcheck/sccheckbill/sccheckbill_edit.js"></script>
</body>
</html>