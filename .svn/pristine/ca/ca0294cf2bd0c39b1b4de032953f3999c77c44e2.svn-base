<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">

    <title>查看惩戒单</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body>
<div class="pd20">
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-header type-tab clear pdb10 border-bottom">
                <label class="right">惩戒单类型：</label>
                <ul class="clearfix">
                    <c:if test="${info.punType == 'ent'}">
                		<li id="ent_type" class="tab-selected"><span class="tab-item"><a href="javascript:void(0);">企业</a></span></li>
                	</c:if>
                	<c:if test="${info.punType == 'man'}">
                		<li id="man_type" class="tab-selected"><span class="tab-item"><a href="javascript:void(0);">自然人</a></span></li>
                	</c:if>
                </ul>
            </div>
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
	                            <span style="font-size:13px">惩戒单批号： ${info.batchNo}</span>
                            </h3>
                            <p class="right print-data">录入日期：<span><fmt:formatDate value="${info.createTime}" pattern="yyyy年MM月dd日" /></span></p>
                            
                            <input type="hidden" id="batchNo" name="batchNo"  value="${info.batchNo}"/>
                            <input type="hidden" id="punType" name="punType"  value="${info.punType}"/>
                            
                            <div class="bg-gray3">
                                <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                    <tbody>
                                    <tr>
                                        <td class="tb-form-hd" width="140px"><span style="color: red"> *</span>惩戒领域</td>
										<td width="40%">
											<select>
												<option value="${info.punField}" selected="selected">${info.punField}</option>
							                </select>
										</td>
                                        <td class="tb-form-hd" width="125px"><span style="color: red"> *</span>惩戒事由</td>
										<td>
											<select>
												<option value="${info.punCause}" selected="selected">${info.punCause}</option>
							                </select>
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
                                        <td class="tb-form-hd" width="140px">法律文书编号</td>
										<td>
											<div class="ipt-box"><span>${info.legNo}</span></div>
										</td>

										<td class="tb-form-hd" width="100px">文书时间</td>
										<td>
											<div class="ipt-box col-5">
												<span><fmt:formatDate value="${info.legDate}" pattern="yyyy-MM-dd" /></span>
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd"><span style="color: red"> *</span>惩戒执行部门</td>
										<td>
											<div class="ipt-box">
												<span>${info.punExeDept}</span>
											</div>
										</td>

										<td class="tb-form-hd">执行有效期</td>
										<td class="pd0"><span class="item-txt">从</span>
											<span class="item-txt">
												<fmt:formatDate value="${info.exeBegin}" pattern="yyyy-MM-dd" />
											</span> <span class="item-txt">至</span>
											<span class="item-txt">
												<fmt:formatDate value="${info.exeEnd}" pattern="yyyy-MM-dd" />
											</span>
											<div class="radio-box">
												<input type="checkbox" class="ml15" name="isLife" value="1" <c:if test="${info.isLife=='1'}">checked="checked"</c:if> disabled>终身
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td style="padding-left: 10px; padding-top: 10px" class="tb-form-hd">
											<c:if test="${info.punType == 'ent'}">惩戒企业</c:if>
											<c:if test="${info.punType == 'man'}">惩戒当事人</c:if>
										</td>
										
                                        <td colspan="3" class="pd0">
                                            <c:if test="${info.punType == 'ent'}">
											<table class="inner-table center">
												<tbody id="tb_ent_bd">
													<tr>
														<th>企业名称</th>
														<th>统一信用代码</th>
														<th>法定代表人(负责人)</th>
														<th>证件类型</th>
														<th>证件号</th>
														<!--<th>失信惩戒记录</th>-->
													</tr>
													<c:forEach items="${details}" var="obj">
														<tr>
															<td>${obj.entName}</td>
															<td style="display:none">${obj.priPID}</td>
															<td>${obj.uniCode}</td>
															<td>${obj.leRep}</td>
															<td>${obj.cerTypeDesc}</td>
															<td>${obj.cardNo}</td>
															<!--<td>${obj.record}</td>-->
														</tr>
													</c:forEach>
												</tbody>
											</table>
											</c:if>
											<c:if test="${info.punType == 'man'}">
											<table id="tb_man" class="inner-table center">
												<tbody>
													<tr>
														<th>当事人姓名</th>
														<th>证件号</th>
														<th>证件类型</th>
														<th>当事人联系电话</th>
													</tr>
													<c:forEach items="${details}" var="obj">
														<tr>
															<td>${obj.litiName}</td>
															<td>${obj.cardNo}</td>
															<td>${obj.cerTypeDesc}</td>
															<td>${obj.phone}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											</c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tb-form-hd">证据资料上传</td>
                                        <td colspan="3" class="pd1">
                                            <div id="filelabel">
                                            	<c:forEach items="${files}" var="obj">
                                                	<p><span path="${obj}" style="color:blue;cursor:pointer" title="点击下载" ><i class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span></p>
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd"><span style="color: red"> *</span>惩戒提请部门</td>
										<td>
											<div class="ipt-box">
												<span>${info.punReqDept}</span>
											</div>
										</td>
										
										<td class="tb-form-hd">是否需要执行部门反馈处理情况</td>
										<td>
											<div class="radio-box">
												<label><input type="radio" name="feedBack" value="1" <c:if test="${info.feedBack == '1'}">checked="checked"</c:if> disabled>是</label>
												<label><input type="radio" name="feedBack" value="0" <c:if test="${info.feedBack == '0'}">checked="checked"</c:if> disabled>否</label>
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd" rowspan="3">提请部门联系人</td>
										<td rowspan="3" class="pd3">
											<div>
												<span>${info.contact}</span>
											</div>
										</td>
										
										<td class="tb-form-hd">联系电话</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.phone}</span>
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="tb-form-hd">传真</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.fax}</span>
											</div>
										</td>
                                    </tr>
                                    
                                    <tr>
										<td class="tb-form-hd">电子邮箱</td>
										<td class="pd3">
											<div class="ipt-box">
												<span>${info.email}</span>
											</div>
										</td>
									</tr>
                                 </tbody>
                              </table>
                              
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
                           </div>
                        </div>
                        <div style="height:10px;width:100%"></div>
                        <input type="button" id="cancel" class="btn mr20" value="返回" style="margin-left:45%"></p>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script src="/js/lib/laydate/laydate.js"></script>
<script type="text/javascript">
	$(function(){
		var userType = '${sessionScope.session_sys_user.userType}';
		var urlHead = '/syn';
		if(userType==1){
			urlHead='/reg/server';
		}
		$("#cancel").click(function(){
			var type="${info.punType}";
			var key="${key}";
			window.location.href=urlHead+'/noCreditPunish/info/recordlist?type='+type+'&key='+key;
		})
		$("#filelabel").delegate('span','click',function(){
			var path=$(this).attr("path");
			window.location.href=urlHead+"/noCreditPunish/info/download?fileName="+path;
		});
	})
</script>
</body>
</html>