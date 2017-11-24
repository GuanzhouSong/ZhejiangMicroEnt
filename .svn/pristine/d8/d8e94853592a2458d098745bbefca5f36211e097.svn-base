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

    <title>涉证企业查询详情tab页</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/syn.css">      
</head>
<body>
	<!-- 查询参数 -->
	<input type="hidden" id ="priPID" value="${pubDtInfoDto.priPID}" /><!-- 内部序号 -->
	<div class=" clearfix pd20">
    <h2 class="center hd-underline border-bottom">备案企业操作详情</h2>
    <div class="tabbale" data-component="tab">
        <div class="tab-header">
            <ul class="clearfix type-tab clear">
                <li class="tab-selected" id="tab1"><span class="tab-item"><a href="javascript:void(0);" id="menu1">工商登记信息</a></span></li>
                <li id="tab2"><span class="tab-item"><a href="javascript:void(0);" id="menu2" >多证合一备案信息</a></span></li>
            <!--     <li id="tab3"><span class="tab-item" ><a href="javascript:void(0);" id="menu3" >日常监管信息</a></span></li>
                <li id="tab4"><span class="tab-item" ><a href="javascript:void(0);" id="menu4" >预警警示信息</a></span></li>
           -->  </ul>
        </div>
				
		<div class="tab-content mb20">
		 <!-- 工商登记信息 -->
		 <div class="tab-panel tab-panel-show" id="con_menu_1" >
                <div class="">
                    <h4 class="h4-title mt10">企业信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal" id="infoTable">
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
                            <td><fmt:formatNumber value="${pubDtInfoDto.regCap }" pattern="###,###,###,##0.0000"/>万元</td>
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
                            <td colspan="3" class='td-font-18'>${pubDtInfoDto.opScope }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">法定代表人</td>
                            <td>${pubDtInfoDto.leRep }</td>
                            <td class="bg-gray right">联系电话</td>
                            <td>${pubDtInfoDto.tel }</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">企业联络员</td>
                            <td></td>
                            <td class="bg-gray right">联系电话</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="bg-gray right">登记机关联络员</td>
                            <td>${codeRegorg.liaName }</td>
                            <td class="bg-gray right">联系电话</td>
                            <td>${codeRegorg.liaPhone }</td>
                        </tr>
                         <tr>
                            <td class="bg-gray right">备案部门联络员</td>
                            <td>${sysDepart.liaName}</td>
                            <td class="bg-gray right">联系电话</td>
                            <td>${sysDepart.liaPhone}</td>
                        </tr>                       
                        <tr>
                            <td class="bg-gray right light">备案机关</td>
                            <td class="light">${pubDtInfoDto.checkDepName }</td>
                            <td class="bg-gray right light">备案事项名称</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                        </tr>                                                
                        <tr>
                            <td class="bg-gray right">推送方式</td>
			                <td><c:if test="${pubDtInfoDto.checkPushType==0}">
				                                    退回待推送               
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
                       <c:if test="${pubDtInfoDto.checkPushType==3}">
                        <tr>
                            <td class="bg-gray right">推送失败原因</td>
			                <td colspan="3">${pubDtInfoDto.reassignRemark}</td>                            
                        </tr>
                        </c:if>                        
                        </tbody>
                    </table>
                    <c:choose> 
					 <c:when test="${pubDtInfoDto.checkStopState=='1'}">
                     <h4 class="h4-title mt10">终止信息</h4>
                     <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">终止人</td>
                            <td width="35%">${pubDtInfoDto.reassignName }</td>
                            <td class="bg-gray right" width="15%">终止日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.reassignDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                        <tr>
                            <td class="bg-gray right" width="15%">是否终止推送</td>
                            <td>是</td>
                            <td class="bg-gray right" width="15%">终止理由</td>
                            <td>不涉及该项备案，终止推送</td>
                        </tr>
                        <tr>
                            <td class="bg-gray right light" width="15%">备案事项</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                            <td class="bg-gray right light" width="15%">备案机关</td>
                            <td class="light">${pubDtInfoDto.reassignDeptName }</td>
                        </tr>
                    </table>
                     </c:when>
                    <c:otherwise>
                    <!--重新指派 -->
				    <c:if test="${not empty pubDtInfoDto.reassignName  && pubDtInfoDto.reassignType == '1' }">
					<h4 class="h4-title">重新指派信息</h4>					 
			        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mb5">
					<tbody>
			        <tr>
						<td class="bg-gray right"  width="15%">重新指派操作人</th>
						<td width="35%">${pubDtInfoDto.reassignName}</td>
						<td class="bg-gray right"  width="15%">联系电话</th>
					    <td >${reassignSysUser.phoneExt}</td>
					</tr> 
					<tr>
					    <td class="bg-gray right" >重新指派操作日期</th>
						<td><fmt:formatDate value="${pubDtInfoDto.reassignDate}" pattern="yyyy年MM月d日"/></td>
					    <td class="bg-gray right light">重新指派操作部门</th>
					    <td class="light">${pubDtInfoDto.reassignDeptName}</td>
					</tr>
					<tr>
						<td class="bg-gray right" >备    注</th> 
					    <td colspan="3" style="height:50px;">${pubDtInfoDto.reassignRemark}</td>
					</tr> 
					<tbody>
				    </table>
				    </c:if>	
                    <!-- 回退信息 -->
                    <c:if test="${pubDtInfoDto.reassignType=='2'}">
                    <h4 class="h4-title mt10">回退信息</h4>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal">
                        <tr>
                            <td class="bg-gray right" width="15%">退回人</td>
                            <td width="35%">${pubDtInfoDto.reassignName }</td>
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
                            <td class="bg-gray right light" width="15%">备案事项</td>
                            <td class="light">${pubDtInfoDto.exaName }</td>
                            <td class="bg-gray right" width="15%">退回理由</td>
                            <td><c:if test="${pubDtInfoDto.reassignCode==0}">
	                                                                                          经营范围内无此备案事项
				                </c:if>
				                <c:if test="${pubDtInfoDto.reassignCode==1}">
				                                                      经营范围不在备案部门的管辖范围内
				                </c:if>
				                <c:if test="${pubDtInfoDto.reassignCode==2}">
				                                                      地址不在备案部门的管辖范围内
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
                            <td width="35%">${pubDtInfoDto.acceptName }</td>
                            <td class="bg-gray right" width="15%">接收日期</td>
                            <td><fmt:formatDate value="${pubDtInfoDto.acceptDate }" pattern="yyyy年MM月dd日"/> </td>
                        </tr>
                    </table>
                    </c:if>
                    </c:otherwise>
					</c:choose>	
                </div>
		  </div>
		  
		<div class="tab-panel" id="con_menu_2" >
              <div class="mt10">
                <!-- 备案信息 -->
				<jsp:include page="pubdtinfobeian_edit.jsp" flush="true"></jsp:include> 
         		</div>
          </div>
          
         <!-- 许可备案信息 -->
        <!--  <div class="tab-panel" id="con_menu_2" >
              <div class="mt10">
                <h4 class="h4-title mt10">许可备案信息</h4>
                  <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap" width="100%" id="licTable">
                      <thead>
                      <tr>
                          <th width="5.5%">序号 </th>
                          <th width="12%">许可文件编号</th>
                          <th width="17%">许可文件名称</th>
                          <th width="10%">有效期自</th>
                          <th width="10%">有效期至</th>
                          <th width="17%">许可机关</th>
                          <th width="17%">许可内容</th>
                          <th width="10%">状态</th>
                      </tr>
                      </thead>
                  </table>
         		</div>
          </div> -->		  	
		
		 <!-- 日常监管信息 -->
         <!-- <div class="tab-panel" id="con_menu_3">
             <div class="mt10">
                <h4 class="h4-title mt10">抽查检查信息</h4>
                <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap" width="100%" id="checkInfoTable">
                     <thead>
                     <tr>
                         <th width="5.5%">序号 </th>
                         <th width="18.7%">检查实施机关</th>
                         <th width="10.5%">类型</th>
                         <th width="10.5%">日期</th>
                         <th width="18.7%">结果</th>
                     </tr>
                     </thead>           
                 </table>
             </div>
         </div>	 -->
         
         <!-- 预警提示信息 -->
         <%-- <div class="tab-panel" id="con_menu_4">
             <div class="mt10">
                 <!-- 经营异常信息 -->
                 <h4 class="h4-title mt10">经营异常信息</h4>
                 <c:if test="${pubDtInfoDto.entTypeCatg != '50'}">
                 <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap" width="100%" id="catalogTable">
                     <thead>
                     <tr>
                         <th width="5.5%">序号 </th>
                         <th width="10.7%">列入经营异常名录原因</th>
                         <th width="10.5%">列入日期</th>
                         <th width="18.7%">作出决定机关（列入）</th>
                         <th width="13.4%">移出经营异常名录原因</th>
                         <th width="10%">移出日期</th>
                         <th width="10%">作出决定机关（移出）</th>
                     </tr>
                     </thead>           
                 </table>
                 </c:if>
                 <c:if test="${pubDtInfoDto.entTypeCatg == '50'}">
                 <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap" width="100%" id="pbcatalogTable">
                     <thead>
                     <tr>
                         <th width="5.5%">序号 </th>
                         <th width="10.7%">标记经营异常状态原因</th>
                         <th width="10.5%">标记日期</th>
                         <th width="18.7%">作出决定机关（标记）</th>
                         <th width="13.4%">恢复正常记载状态原因</th>
                         <th width="10%">恢复日期</th>
                         <th width="10%">作出决定机关（恢复）</th>
                     </tr>
                     </thead>           
                 </table>
                 </c:if>                 
                 <!-- 行政处罚信息 -->
                 <h4 class="h4-title mt10">行政处罚信息</h4>
                 <table border="0" cellspacing="0" cellpadding="0" class="table-row perc-100 nowrap" width="100%" id="punishTable">
                     <thead>
                     <tr>
                         <th width="5.5%">序号 </th>
                         <th width="10.7%">决定书文号</th>
                         <th width="10.5%">违法行为类型</th>
                         <th width="18.7%">行政处罚内容</th>
                         <th width="13.4%">决定机关名称</th>
                         <th width="10%">处罚决定日期</th>
                         <th width="10%">公示日期</th>
                     </tr>
                     </thead>           
                 </table>
            </div>
         </div> --%>
		</div>
    </div>
    </div>
<script>
    //参数的传递
    window._CONFIG = {
    		entTypeCatg:'${pubDtInfoDto.entTypeCatg}',
    	    chooseUrl:'${userType == 2 ? "/syn" : "/reg/server"}'    		
    }
</script>	
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/pubdzdtinfo/pubdtinfoDetail_tab.js"></script>
</html>