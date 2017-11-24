<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>联合惩戒单打印页</title>
    <link rel="stylesheet" href="/css/reg.server.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/print.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
<style type="text/css">
.hide{
		display: none;
}
</style>
<style media="print" type="text/css">
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
object { display: none}
.Noprint{ display:none; }
.PageNext{ page-break-after: always; clear: both; width: 100%}
	</style>
<style type="text/css">
	.height40{
		height: 40px;
	}
</style>
</head>
<body>
<div class="button Noprint" style="width:600px;">
    <a href="javascript:Print();"><strong style="font-size:16px">直接打印</strong></a>
    <a href="javascript:PrintView();"><strong style="font-size:16px">打印预览</strong></a>
    <a href="javascript:PrintSetup();"><strong style="font-size:16px">打印设置</strong></a>
    <a id="closeBtn" href="javascript:window.top.close();"><strong style="font-size:16px">关闭窗口</strong></a>
</div>
<object height="20px" id="factory" viewastext="" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" codebase="/js/common/print/ScriptX.cab#version=6，2，433，14"> </object>
<object height="20px" id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<div class="pd20">
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3 class="mt33">
                                <c:if test="${info.punType == 'ent'}">
	                            	企业失信惩戒创建单
	                            </c:if>
	                            <c:if test="${info.punType == 'man'}">
	                            	自然人失信惩戒创建单
	                            </c:if>
	                            <p style="font-size:13px">惩戒单批号： ${info.batchNo}</p>
                            </h3>
                            <p class="right print-data">录入日期：<span><fmt:formatDate value="${info.createTime}" pattern="yyyy年MM月dd日" /></span></p>
                            
                            <input type="hidden" id="batchNo" name="batchNo"  value="${info.batchNo}"/>
                            <input type="hidden" id="punType" name="punType"  value="${info.punType}"/>
                            <input type="hidden" id="tab" value="${tab}"/>
                            
                            <div class="bg-gray3">
                                <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                    <tbody>
                                    <tr>
                                        <td class="tb-form-hd" width="140px">惩戒领域</td>
										<td width="40%">
											<div class="ipt-box">${info.punField}</div>
										</td>
                                        <td class="tb-form-hd" width="125px">惩戒事由</td>
										<td>
											<div class="ipt-box">${info.punCause}</div>
										</td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">惩戒依据（条文）</td>
										<td><span>${info.legBasis}</span></td>

										<td class="tb-form-hd">惩戒规则</td>
										<td><span>${info.punRule}</span></td>
                                  </tr>
                                  
                                    <tr>
                                        <td class="tb-form-hd">惩戒执行措施</td>
										<td colspan="3"><span>${info.punMea}</span></td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">惩戒执行部门</td>
										<td>
											<div class="ipt-box">
												<span>${info.punExeDept}</span>
											</div>
										</td>

										<td class="tb-form-hd">执行有效期</td>
										<td class="pd0">
										<c:if test="${info.isLife!='1'}">
										   <span class="item-txt">从</span>
											<span class="item-txt">
												<fmt:formatDate value="${info.exeBegin}" pattern="yyyy-MM-dd" />
											</span> <span class="item-txt">至</span>
											<span class="item-txt">
												<fmt:formatDate value="${info.exeEnd}" pattern="yyyy-MM-dd" />
											</span>
										</c:if>	
										<c:if test="${info.isLife=='1'}">
											<div class="radio-box">
												<input type="checkbox" class="ml15" name="isLife" value="1" <c:if test="${info.isLife=='1'}">checked="checked"</c:if> disabled>终身
											</div>
										</c:if>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td style="padding-left: 10px; padding-top: 10px" class="tb-form-hd">
											<c:if test="${info.punType == 'ent'}">被惩戒当事人</c:if>
											<c:if test="${info.punType == 'man'}">被惩戒当事人</c:if>
										</td>
										
                                        <td colspan="3" class="pd0">
                                            <c:if test="${info.punType == 'ent'}">
											<table class="inner-table center">
												<tbody id="tb_ent_bd">
				                                <tr>
				                                    <th>序号</th>
													<th>企业名称</th>
													<th>统一信用代码/注册号</th>
													<th>惩戒时的法定代表人(负责人)</th>
													<th>身份证号</th>
													<th>失信惩戒记录</th>
												</tr>
													<c:forEach items="${details}" var="obj" varStatus="status">
					                                   <tr>
					                                       <td class="center">${status.count}</td>
					                                       <td class="center">${obj.entName}</td>
					                                       <td style="display:none" class="center">${obj.priPID}</td>
					                                       <td style="display:none" class="center">${obj.regNo}</td>
					                                       <td class="center">${empty obj.uniCode?obj.regNo:obj.uniCode}</td>
					                                       <td class="center">${obj.leRep}</td>
					                                       <td class="center">${obj.cardNo}</td>
					                                       <c:if test="${not empty obj.recordCount && obj.recordCount!=0 }">
					                                       <td value="${obj.recordCount }" class="center">
					                                           <a href='javascript:void(0);'  tag='view' priPID='${obj.priPID}'>${obj.recordCount }</a>
					                                       </td>
					                                       </c:if>
					                                       <c:if test="${empty obj.recordCount || obj.recordCount==0}">
					                                           <td value="0" class="center">0</td>
					                                       </c:if>
					                                       <td style="display:none" class="center">${obj.cerType}</td>
					                                       <td style="display:none" class="center">${obj.uniCode}</td> 
					                                   </tr>
													</c:forEach>
												</tbody>
											</table>
											</c:if>
											<c:if test="${info.punType == 'man'}">
											<table class="inner-table center">
												<tbody id="tb_man_bd">
													<tr>
														<th>序号</th>
														<th>当事人姓名</th>
														<th>身份证号</th>
														<th>联系电话</th>
														<th>失信惩戒记录</th>
													</tr>
													<c:forEach items="${details}" var="obj" varStatus="status">
						                                 <tr>
					                                	 <td class="center">${status.count}</td>
					                                     <td class="center">${obj.litiName}</td>
					                                     <td class="center">${obj.cardNo}</td>
					                                     <td class="center">${obj.phone}</td>
					                                     <c:if test="${not empty obj.recordCount && obj.recordCount!= 0}">
					                                     <td value="${obj.recordCount }" class="center">
					                                    				 <a href='javascript:void(0)'
					                                                       tag='view' cardNo='${obj.cardNo}'>${obj.recordCount}</a>
					                                     </td>
					                                     </c:if>
					                                     <c:if test="${empty obj.recordCount || obj.recordCount==0}">
					                                         <td value="0" class="center">0</td>
					                                     </c:if>
					                                     <td style="display:none" class="center">${obj.cerType}</td>
					                                   </tr>
													</c:forEach>
												</tbody>
											</table>
											</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd" width="140px">法律文书编号</td>
										<td>
											<div class="ipt-box"><span>${info.legNo}</span></div>
										</td>

										<td class="tb-form-hd" width="100px">文书出具日期</td>
										<td>
											<div class="ipt-box">
												<span><fmt:formatDate value="${info.legDate}" pattern="yyyy-MM-dd" /></span>
											</div>
										</td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">违法性质</td>
										<td colspan="3"><span>${info.illegalProperty}</span></td>
                                    </tr> 
                                    <tr>
                                        <td class="tb-form-hd">违法事实</td>
										<td colspan="3"><span>${info.illegalFact}</span></td>
                                    </tr> 
                                    <tr>
                                        <td class="tb-form-hd">处理结果</td>
										<td colspan="3"><span>${info.punHandleRes}</span></td>
                                    </tr> 
                                    <tr>
                                        <td class="tb-form-hd">证据资料上传</td>
                                        <td colspan="3" class="pd1">
                                            <div id="filelabel">
                                            	<c:forEach items="${files}" var="obj">
                                                	${fn:substringAfter(obj, '-')}<br>
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd">惩戒提请部门</td>
										<td>
											<div class="ipt-box">
												<span>${info.punReqDept}</span>
											</div>
										</td>
										
										<td class="tb-form-hd">是否需要执行部门反馈处理情况</td>
										<td>
											<div class="radio-box">
												<label><c:if test="${info.feedBack == '1'}">是</c:if></label>
												<label><c:if test="${info.feedBack == '0'}">否</c:if></label>
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd">提请部门联系人</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.contact}</span>
											</div>
										</td>
                                        <td class="tb-form-hd">传真</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.fax}</span>
											</div>
										</td>										
                                    </tr>
                                    
                                    <tr>
										<td class="tb-form-hd">联系电话</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.phone}</span>
											</div>
										</td>
										<td class="tb-form-hd">电子邮箱</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.email}</span>
											</div>
										</td>										
                                    </tr>
                                    <tr>
										<td class="tb-form-hd">提请人</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.punReqUser}</span>
											</div>
										</td>
										<td class="tb-form-hd">提请日期</td>
										<td class="pd3">
											<div class="ipt-box">
												<span><fmt:formatDate value="${info.createTime}" type="date" pattern="yyyy-MM-dd"/></span>
											</div>
										</td>										
                                    </tr>
                                 </tbody>
                              </table>
                              
                              <!-- 申请，审核模块显示 -->
                              <c:if test="${info.state==1 || info.state==2}">
                              <table border="0" cellspacing="0" cellpadding="0" class="table-form mt10">
                                    <tbody>
	                                    <tr>
	                                        <td class="tb-form-hd" width="11.7%">审核结果</td>
	                                        <td width="31.5%">
	                                            <div class="radio-box">
	                                                <label><c:if test="${info.auditRes == '0'}">同意发出</c:if></label>
	                                                <label><c:if test="${info.auditRes == '1'}">不同意发出</c:if></label>
	                                            </div>
	                                        </td>
	                                        <td class="tb-form-hd" width="8.4%">审核员</td>
	                                        <td>${info.auditor}</td>
	                                        <td class="tb-form-hd" width="10%">审核日期</td>
	                                        <td><fmt:formatDate value="${info.auditTime}" pattern="yyyy-MM-dd" /></td>
	                                    </tr>
	
	                                    <tr>
	                                        <td class="tb-form-hd">审核意见</td>
	                                        <td colspan="5" class="pd3">
	                                            <span>${info.auditView}</span>
	                                        </td>
	                                    </tr>
                                   </tbody>
                              </table>
                              </c:if>
                              
                              <c:if test="${backlist!=null}">
                              <!-- 反馈列表 -->
                              <table border="0" cellspacing="0" cellpadding="0" class="table-form mt10">
                              	  <tbody>
                                  	  <tr>
                                          <td colspan="5" class="blue-title">执行部门反馈意见</td>
                                      </tr>
	                                  <c:forEach items="${backlist}" var="obj">
		                                  <c:if test="${obj.state==1}">
			                                  <tr>
			                                      <td class="pd3" width="20%">${obj.backDept}</td>
			                                      <td class="pd3" width="20%">${obj.opName}</td>
			                                      <td class="pd3" width="40%">${obj.backContent}</td>
			                                      <td class="pd3"><fmt:formatDate value="${obj.createTime}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
			                                  </tr>
		                                  </c:if>
	                                  </c:forEach>
                                  </tbody>
                               </table>
                               </c:if>
                               <!-- 反馈填写 -->
                               <c:if test="${info.feedBack=='1'&&info.state==1&&flag=='Y'}">
                               <table border="0" cellspacing="0" cellpadding="0" class="table-form mt10">
                                    <tbody>
	                                    <tr>
	                                        <td class="tb-form-hd" width="20%">反馈人</td>
	                                        <td width="30%">${user.realName}</td>
	                                        <td class="tb-form-hd" width="20%">反馈日期</td>
	                                        <td width="30%"><fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
	                                    </tr>
	
	                                    <tr>
	                                        <td class="tb-form-hd">反馈意见</td>
	                                        <td colspan="5" class="pd3">
	                                            <div><textarea id="backContent" name="backContent" cols=" " rows="5" maxlength="200" placeholder="200字以内" ></textarea></div>
	                                        </td>
	                                    </tr>
                                   </tbody>
                               </table>
                               </c:if>
                           </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/common/print/printsetup.js"></script>
<script src="/js/common/print/print.js"></script>
</body>
</html>