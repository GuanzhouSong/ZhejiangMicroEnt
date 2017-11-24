<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>企业认领/接收信息查询详情（主体信息）</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/syn.css">      
</head>
<body>
            <div class="tab-panel">
                <div class="">
                    <h4 class="h4-title mt10">企业信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tbody>
                        <tr>
                            <td class="bg-gray right" width="15%">统一代码</td>
                            <td width="35%">${pubDtInfoDto.uniSCID }</td>
                            <td class="bg-gray right" width="15%">注册号</td>
                            <td>${pubDtInfoDto.regNO }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">企业名称</td>
                            <td>${pubDtInfoDto.entName }</td>
                            <td class="bg-gray right">注册资本</td>
                            <td>${pubDtInfoDto.regCap }万元</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">是否个转企</td>
                            <td><c:if test="${pubDtInfoDto.isIndivid==1}"> 是</c:if>
	                        <c:if test="${pubDtInfoDto.isIndivid==0}">否</c:if></td>
                            <td class="bg-gray right">住所</td>
                            <td>${pubDtInfoDto.dom }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">企业类型</td>
                            <td>${pubDtInfoDto.entCatgName }</td>
                            <td class="bg-gray right">行业类型</td>
                            <td>${pubDtInfoDto.industryName }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">成立日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.estDate }" pattern="yyyy年MM月d日"/> </td>
                            <td class="bg-gray right">核准日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.apprDate }" pattern="yyyy年MM月d日"/> </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">经营范围</td>
                            <td colspan="3">${pubDtInfoDto.opScope }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">推送方式</td>
			                <td><c:if test="${pubDtInfoDto.checkPushType==0}">
				                                     未推送               
				            </c:if>
				            <c:if test="${pubDtInfoDto.checkPushType==1}">
				                                     自动推送               
				            </c:if>
				            <c:if test="${pubDtInfoDto.checkPushType==2}">
				                                    手动推送            
				            </c:if>
				            <c:if test="${pubDtInfoDto.checkPushType==3}">
				                                     推送失败               
				            </c:if></td>                            
				            <td class="bg-gray right">推送日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.checkPushDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">审批机关</td>
                            <td>${pubDtInfoDto.checkDepName }</td>
                            <td class="bg-gray right light">后置审批事项名称</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">法定代表人</td>
                            <td>${pubDtInfoDto.leRep }</td>
                            <td class="bg-gray right">联系电话</td>
                            <td>${pubDtInfoDto.tel }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">企业联络员</td>
                            <td>${pubDtInfoDto.leRep }</td>
<%--                             <td>${codeRegorg.pasRecordName }</td> --%>
                            <td class="bg-gray right">联系电话</td>
                            <td>${pubDtInfoDto.tel }</td>
<%--                             <td>${codeRegorg.pasRecordTel }</td> --%> 
                        </tr>
                        <tr>
                            <td class="bg-gray right">登录机关联络员</td>
                            <td>${pubDtInfoDto.leRep }</td>
<%--                             <td>${codeRegorg.pasRecordName }</td> --%>
                            <td class="bg-gray right">联系电话</td>
                            <td>${pubDtInfoDto.tel }</td>
<%--                             <td>${codeRegorg.pasRecordTel }</td> --%>
                        </tr>
                        </tbody>
                    </table>
                    <c:choose> 
					 <c:when test="${pubDtInfoDto.checkStopState=='1'}">
                     <h4 class="h4-title mt10">终止信息</h4>
                     <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">终止人</td>
                            <td>${pubDtInfoDto.reassignName }</td>
                            <td class="bg-gray right" width="15%">终止日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.reassignDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" width="15%">是否终止推送</td>
                            <td>是</td>
                            <td class="bg-gray right" width="15%">终止理由</td>
                            <td>不涉及该项后置审批，终止推送</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right light" width="15%">后置审批事项</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                            <td class="bg-gray right light" width="15%">审批机关</td>
                            <td class="light">${pubDtInfoDto.reassignDeptName }</td>
                        </tr>
                    </table>
                     </c:when>
                    <c:otherwise>
                    <!-- 认领信息 -->
                    <c:if test="${pubDtInfoDto.claimState=='1'}">
                    <h4 class="h4-title mt10">认领信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">认领人</td>
                            <td width="35%">${pubDtInfoDto.claimName }</td>
                            <td class="bg-gray right" width="15%">认领日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.claimDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                    </table>
                    </c:if>
                    <!-- 接收信息 -->
                    <c:if test="${pubDtInfoDto.receiveState=='1'}">
                    <h4 class="h4-title mt10">接收信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">接收人</td>
                            <td>${pubDtInfoDto.acceptName }</td>
                            <td class="bg-gray right" width="15%">接收日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.acceptDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                    </table>
                    </c:if>
                    <!-- 回退信息 -->
                    <c:if test="${pubDtInfoDto.reassignType=='2'}">
                    <h4 class="h4-title mt10">回退信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">退回人</td>
                            <td>${pubDtInfoDto.reassignName }</td>
                            <td class="bg-gray right" width="15%">联系电话</td>
                            <td>${sysUser.telPhone }</td>
                        </tr>
                         <tr>
                            <td class="bg-gray right" width="15%">推送机关类型</td>
                            <td><c:if test="${pubDtInfoDto.checkDeptType==1}">
			                                                                 审批机关
			                    </c:if>
			                    <c:if test="${pubDtInfoDto.checkDeptType==2}">
			                                                               属地机关
			                    </c:if>
			                    <c:if test="${pubDtInfoDto.checkDeptType==3}">
			                                                                审批机关
			                    </c:if> </td>
                            <td class="bg-gray right" width="15%">审批机关</td>
                            <td>${pubDtInfoDto.reassignDeptName }</td>
                        </tr>
                         <tr>
                            <td class="bg-gray right light" width="15%">后置审批事项</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                            <td class="bg-gray right" width="15%">退回理由</td>
                            <td><c:if test="${pubDtInfoDto.reassignCode==1}">
	                                                                                          经营范围内无此审批事项
				                </c:if>
				                <c:if test="${pubDtInfoDto.reassignCode==2}">
				                                                      经营范围不在审批部门的管辖范围内
				                </c:if>
				                <c:if test="${pubDtInfoDto.reassignCode==3}">
				                                                      地址不在审批部门的管辖范围内
				                </c:if></td>
                         </tr>
                         <tr>
                            <td class="bg-gray right" width="15%">退回日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.reassignDate }" pattern="yyyy年MM月dd日"/> </td>
                            <td class="bg-gray right" width="15%">备 注</td>
                            <td>${pubDtInfoDto.reassignRemark }</td>
                        </tr>
                    </table>
                    </c:if>
                    </c:otherwise>
					</c:choose>	
                </div>
            </div>
        </div>
    </div>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<!-- <script src="/js/syn/system/pubdtinfo/pubdtinfoDetail_info.js"></script> -->
</html>