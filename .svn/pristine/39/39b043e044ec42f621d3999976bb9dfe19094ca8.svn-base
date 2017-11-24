<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抄告抄送主页面</title>
    <link rel="stylesheet" href="/css/syn.css">
</head>
<body class="pd10">
<div>
    <div class="creat-copy">
        <div class="tabbale" data-component="tab">
            <div class="tab-content">
                <div class="tab-panel tab-panel-show">
                    <div class="">
                        <div class="print-nocard">
                            <h3>
                                <p id="copytitle">部门抄告单（${copySendDto.copyTypeName}）</p>
                                <span>抄告单编号：${copySendDto.copyFormNo}</span>
                            </h3>
                            <p class="right print-data">抄告发起日期：
                            <input id="copyDate" type="text" style="border: none;" name="copyDate" value="<fmt:formatDate value="${copySendDto.copyDate}" pattern="yyy年MM月dd日"/>"></p>
                          
                          <form id="content_form">
                          		<input id="copyFormNo" type="hidden" name="copyFormNo" value="${copySendDto.copyFormNo}"/>
                                <input type="hidden" name="acceptDepartCode" value="${sessionScope.session_sys_user.deptCode}"/>
                                <input id="copyTypeName" type="hidden" value="${copySendDto.copyTypeName}"/>
                          <div class="bg-gray3">
                            <table border="0" cellspacing="0" cellpadding="0" class="table-form mt30">
                                <tbody><tr>
                                    <td class="tb-form-hd" width="14%">
                                        抄告接收部门
                                    </td>
                                    <td width="52%">
                                    <div class="ipt-box">
                                    <input id="acceptDepartNames" class="ipt-txt" type="text" style="border:0;" value="${copySendDto.acceptDeptNames}" readonly/>
										</div>
                                       
                                    </td>
                                    <td class="tb-form-hd" width="15%">
                                        抄告类型
                                    </td>
                                    <td>
                                    <div class="ipt-box">
                                    	<input id="copyType" class="ipt-txt" type="text" value="${copySendDto.copyTypeName}" readonly/>
                                    	</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">涉嫌违法事项</td>
                                    <td>
                                     <div class="ipt-box">
                                    <input id="illegalItem" type="text"  class="ipt-txt" style="border:0;" value="${copySendDto.illegalItem}" readonly/>
                                    </div>
                                    </td>
                                    <td class="tb-form-hd">
                                        信息来源
                                    </td>
                                    <td>
                                      <div class="ipt-box">
                                            <input id="copyInfoFrom" type="text" class="ipt-txt" value="${copySendDto.copyInfoFromName }" readonly />
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">涉嫌违法当事人列表</td>
                                    <td colspan="3" class="pd0">
                                        <table id="illegal_table" class="inner-table center">
                                            <tbody id="tb_ent_bd"><tr>
                                                <th width="15%">当事人姓名</th>
                                                <th width="15%">证件类型</th>
                                                <th width="20%">证件号</th>
                                                <th width="35%">地址</th>
                                                <th>当事人联系电话</th>
<!--                                                 <th width="90" class="last-col">操作</th> -->
                                            </tr>
                                            <c:forEach var="copySendIllegal" varStatus="status" items="${copySendIllegalList}">
										        <tr>
										            <td>${copySendIllegal.clientName}</td>
										            <td cardcode="${copySendIllegal.certType}">${copySendIllegal.certTypeName}</td>
										            <td>${copySendIllegal.certNo}</td>
										            <td>${copySendIllegal.address}</td>
										            <td>${copySendIllegal.clientTel}</td>
										        </tr>
										       </c:forEach>
                                            </tbody></table>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">具体违法情况</td>
                                    <td colspan="3" class="pd3">
                                        <div><textarea id="illegalCase" cols=" " rows="5" readonly>${copySendDto.illegalCase}</textarea></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">证据资料上传</td>
                                    <td colspan="3" class="pd1">
                                            <div id="filelabel">
                                                <c:forEach items="${files}" var="obj">
                                                    <p><span path="${obj}" style="color:blue;cursor:pointer"
                                                             title="点击下载"><i
                                                            class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
                                                        &nbsp;&nbsp;
                                                    </p>
                                                </c:forEach>
                                            </div>
                                        </td>
                                </tr>
                                <tr>
                                    <td class="tb-form-hd">
                                        抄告发起部门
                                    </td>
                                    
                                    <td width="52%" class="pd3">
                                    <div class="ipt-box">
										<input id="copyDepartName" type="text" class="ipt-txt" style="border: 0;"  value="${copySendDto.copyDepartName}" readonly="readonly"/>
										</div>
                                    </td>
                                    <td class="tb-form-hd" >
                                        是否需要反馈处理结果
                                    </td>
                                    <td>
                                        <div class="ipt-box">
                                            <input id="feedbackNeed" type="text" class="ipt-txt" value="${copySendDto.feedbackNeed=='0'?'是':'否' }" readonly/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                        <td class="tb-form-hd">抄告发起部门联系人</td>
                                        <td >
                                        <div class="ipt-box" >
                                                <input id="copyDepartPerson" type="text" class="ipt-txt" value="${copySendDto.copyDepartPerson}" readonly>
                                            </div>
                                        </td>
                                        <td class="tb-form-hd">
                                            联系电话（必填）
                                        </td>
                                        <td>
                                            <div class="ipt-box" >
                                                <input id="copyDepartTel" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartTel }" readonly/>
                                            </div>

                                        </td>
                                    </tr>
                                        <tr>
                                            <td class="tb-form-hd">
                                                传真
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyDepartFax" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartFax }" readonly>
                                                </div>

                                            </td>
                                            <td class="tb-form-hd">
                                               电子邮件
                                            </td>
                                            <td>
                                                <div class="ipt-box">
                                                    <input id="copyDepartMail" type="text" class="ipt-txt"
                                                           value="${copySendDto.copyDepartMail}" readonly>
                                                </div>
                                            </td>
                                        </tr>
                                </tbody>
                                </table>
										<table id="fk_table" border="0" cellspacing="0" cellpadding="0"
											class="table-form mt10">
											<tr>
												<td class="tb-form-hd" width="10%">反馈人</td>
												<td>
													<div class="ipt-box">
														<input id="feedbackPerson" style="width: 15%;" name="feedbackPerson" value="${sysUser.realName}" type="text" class="ipt-txt">
													</div>
												</td>
											</tr>
											<tr>
												<td class="tb-form-hd">反馈意见</td>
												<td class="pd3">
													<div>
														<textarea name="feedback" id="feedback" cols=" " rows="5"></textarea>
													</div>
												</td>
											</tr>

										</table>
									</div>
                        </div>
                        <p class="center mt20">
                        <input id="print" type="button" class="btn mr20" value="打 印">
                        <input id="save" type="button" class="btn mr20" value="提交">
                        <input id="cancel" type="button" class="btn mr20" value="取消反馈"></p>
								</form>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
<script>
		if("${sysUser.userType}" == "1"){
			 window._CONFIG = {
		    		_urlHead:'/reg/server/copysend/',//整改项目 
		     } 
		}else{
			window._CONFIG = {
		    		_urlHead:'/syn/copysend/',//整改项目 
		     } 
		}
</script>
<script src="/js/lib/jquery/jquery-1.12.3.min.js"></script>
<script>
    $(function () {
        $("#filelabel").delegate('span', 'click', function () {
            var path = $(this).attr("path");
            window.open("/syn/copysend/download?fileName=" + path);
        });
    })
</script>


<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/copysend/cgcs_fk.js"></script>
</body>
</html>