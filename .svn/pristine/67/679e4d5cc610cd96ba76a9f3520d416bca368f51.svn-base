<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 视图适配  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器默认视图 -->
    <meta name="renderer" content="webkit">
    <title>编辑失信联合惩戒</title>
    <link rel="stylesheet" type="text/css" href="/css/reg.server.css"/>
</head>
<body>
<div class="form-box bgfff mb5">
    <div class="form-list">
        <form id="content_form">
            <input type="hidden" id="punType" name="punType"  value="${info.punType}"/>
			<input type="hidden" id="batchNo" name="batchNo"  value="${info.batchNo}"/> 
			<input type="hidden" id="isLife" name="isLife"   value="${info.isLife}"/>
			<input type="hidden" id="detailJson" name="detailJson"  value=""/>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒领域：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="punField" id="punField" disabled="disabled">
															<option value=""
                                                                <c:if test="${info.punField==''}">selected="selected"</c:if>>
                                                            请选择..
                                                        </option>
                                                        <option value="安全生产领域"
                                                                <c:if test="${info.punField=='安全生产领域'}">selected="selected"</c:if>>
                                                            安全生产领域
                                                        </option>
                                                        <option value="旅行社经营领域"
                                                                <c:if test="${info.punField=='旅行社经营领域'}">selected="selected"</c:if>>
                                                            旅行社经营领域
                                                        </option>
                                                        <option value="国有企业监督管理领域"
                                                                <c:if test="${info.punField=='国有企业监督管理领域'}">selected="selected"</c:if>>
                                                            国有企业监督管理领域
                                                        </option>
                                                        <option value="互联网上网服务及娱乐场所经营领域"
                                                                <c:if test="${info.punField=='互联网上网服务及娱乐场所经营领域'}">selected="selected"</c:if>>
                                                            互联网上网服务及娱乐场所经营领域
                                                        </option>
                                                        <option value="食品药品经营领域"
                                                                <c:if test="${info.punField=='食品药品经营领域'}">selected="selected"</c:if>>
                                                            食品药品经营领域
                                                        </option>
                                                        <option value="饲料及兽药经营领域"
                                                                <c:if test="${info.punField=='饲料及兽药经营领域'}">selected="selected"</c:if>>
                                                            饲料及兽药经营领域
                                                        </option>
                                                        <option value="出版经营领域"
                                                                <c:if test="${info.punField=='出版经营领域'}">selected="selected"</c:if>>
                                                            出版经营领域
                                                        </option>
                                                        <option value="电影经营领域"
                                                                <c:if test="${info.punField=='电影经营领域'}">selected="selected"</c:if>>
                                                            电影经营领域
                                                        </option>
                                                        <option value="营业性演出经营领域"
                                                                <c:if test="${info.punField=='营业性演出经营领域'}">selected="selected"</c:if>>
                                                            营业性演出经营领域
                                                        </option>
                                                        <option value="建筑施工领域（含施工、勘察、设计和工程监理）"
                                                                <c:if test="${info.punField=='建筑施工领域（含施工、勘察、设计和工程监理）'}">selected="selected"</c:if>>
                                                            建筑施工领域（含施工、勘察、设计和工程监理）
                                                        </option>
                                                        <option value="电子认证领域"
                                                                <c:if test="${info.punField=='电子认证领域'}">selected="selected"</c:if>>
                                                            电子认证领域
                                                        </option>
                                                        <option value="证券期货市场监督管理领域"
                                                                <c:if test="${info.punField=='证券期货市场监督管理领域'}">selected="selected"</c:if>>
                                                            证券期货市场监督管理领域
                                                        </option>
                                                        <option value="税收管理"
                                                                <c:if test="${info.punField=='税收管理'}">selected="selected"</c:if>>
                                                            税收管理
                                                        </option>
                                                        <option value="普遍性限制措施"
                                                                <c:if test="${info.punField=='普遍性限制措施'}">selected="selected"</c:if>>
                                                            普遍性限制措施
                                                        </option>
							</select>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒事由：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="punCause" id="punCause" disabled="disabled">
                               <option value="${info.punCause}"
                                                            selected="selected">${info.punCause}</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3">惩戒依据（条文）：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="legBasis" name="legBasis"  value="${info.legBasis}" class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">惩戒规则：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="punRule" name="punRule" value="${info.punRule}"  class="ipt-txt clx" readonly="readonly" style="background-color: #f4f4f4;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125">惩戒执行措施：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" id="punMea" name="punMea"  value="${info.punMea}" class="ipt-txt clx" readonly="readonly" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒执行部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-9">
                            <input type="text" name="punExeDept" id="punExeDept"  value="${info.punExeDept}" class="ipt-txt clx" readonly="readonly">
                            <input type="hidden" name="punExeDeptCode" id="punExeDeptCode" value="${info.punExeDeptCode}" /> 
                        </div> 
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 执行有效期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="exeBegin" name="exeBegin"  disabled="disabled" ${info.isLife=='1'?'disabled':''} value="<fmt:formatDate value="${info.isLife=='1'?'':info.exeBegin}" pattern="yyyy-MM-dd" />" readonly="readonly" onclick="laydate();" class="ipt-txt zxyxq-btn clx">
                            至
                            <input type="text" class="ipt-txt zxyxq-btn clx"   disabled="disabled" ${info.isLife=='1'?'disabled':''} readonly="readonly" id="exeEnd" name="exeEnd"  onclick="laydate();" value="<fmt:formatDate value="${info.isLife=='1'?'':info.exeEnd}" pattern="yyyy-MM-dd" />">
                            <input type="checkbox" id="isLife" name="isLife" value="1" class="ipt-txt zxyxq-chk clx" <c:if test="${info.isLife=='1'}">checked="checked" </c:if> disabled="disabled">终身
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span> 被惩戒当事人：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                           <!--  <input type="button" value="添加名单" id="adddetail"  class="btn-new mr20"> -->
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"></label>
                    <div class="w875">
                   		<c:if test="${info.punType == 'ent'}"> 
                        <table  border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
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
                                    	<td>${status.count}</td>
                                       <td>${obj.entName}</td>
                                       <td style="display:none">${obj.priPID}</td>
                                       <td style="display:none">${obj.regNo}</td>
                                       <td>${empty obj.uniCode?obj.regNo:obj.uniCode}</td>
                                       <td>${obj.leRep}</td>
                                       <td>${obj.cardNo}</td>
                                       <c:if test="${not empty obj.recordCount && obj.recordCount!=0 }">
                                       <td value="${obj.recordCount }">
                                           <a href='javascript:void(0);'  tag='view' priPID='${obj.priPID}'>${obj.recordCount }</a>
                                       </td>
                                       </c:if>
                                       <c:if test="${empty obj.recordCount || obj.recordCount==0}">
                                           <td value="0">0</td>
                                       </c:if>
                                       <td style="display:none">${obj.cerType}</td>
                                       <td style="display:none">${obj.uniCode}</td> 
                                   </tr>
                              	</c:forEach>
                            </tbody>
                        </table>
                        </c:if>
                        <c:if test="${info.punType == 'man'}">
                        <table id="tb_man" border="0" cellspacing="0" cellpadding="0" class="table-row perc-100  mt30 nowrap" style="width:100%;">
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
                                		<td>${status.count}</td>
                                     <td>${obj.litiName}</td>
                                     <td>${obj.cardNo}</td>
                                     <td>${obj.phone}</td>
                                     <c:if test="${not empty obj.recordCount && obj.recordCount!= 0}">
                                     <td value="${obj.recordCount }">
                                    				 <a href='javascript:void(0)'
                                                       tag='view' cardNo='${obj.cardNo}'>${obj.recordCount}</a>
                                     </td>
                                     </c:if>
                                     <c:if test="${empty obj.recordCount || obj.recordCount==0}">
                                         <td value="0">0</td>
                                     </c:if>
                                     <td style="display:none">${obj.cerType}</td>
                                 </tr>
                             </c:forEach>
						   </tbody>
                        </table>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>  法律文书编号：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="legNo" name="legNo" maxlength="50" disabled="disabled" class="ipt-txt clx" value="${info.legNo}">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>  文书出具日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="legDate" name="legDate"  disabled="disabled" onclick="laydate();" readonly="readonly" class="ipt-txt clx" value="<fmt:formatDate value="${info.legDate}" pattern="yyyy-MM-dd" />">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>  违法性质：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" name="illegalProperty" id="illegalProperty" disabled="disabled" maxlength="500" class="ipt-txt clx" value="${info.illegalProperty}" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  违法事实：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="illegalFact" id="illegalFact" disabled="disabled" style="resize: none;" maxlength="500" cols="30" rows="10">${info.illegalFact}</textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  处理结果：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="punHandleRes" id="punHandleRes" disabled="disabled" style="resize: none;" maxlength="500"  cols="30" rows="10">${info.punHandleRes}</textarea>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix mb5 pd50">
                <div class="col-12">
                    <label class="item-name w125">证据资料上传：</label>
                    <div class="w875">
                       <!--  <div class="ipt-box col-9">
                            <div class="file-box mr5">
                                <span id="fileBox"><input type="file" class="btnFile" name="btnFile"></span>
                                <input type="hidden" id="files" name="files" value=""/>
							    <input type="hidden" id="file" value=""/>
                                <iframe width="0" height="0" name="uploadframe"></iframe>
                                <input type="button" class="btn btn-sm file-btn" id="btnUpload" value="添加附件">
                                <input type="button" id="btnUpload" value="点击上传" />
								<span id="uploadState" style="color:red;display:none">上传中....</span>
                            </div>
                        </div>
                        <div class="col-3 fr file-explain">说明：支持图片、文档、照片等上传</div> -->
                    </div>
                </div>
            </div>
            
            <div id="filelabel" style="padding-left:12.5%;">
				<c:forEach items="${files}" var="obj">
                     <p><span path="${obj}" style="color:blue;cursor:pointer"
                              title="点击下载"><i
                             class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
                         &nbsp;&nbsp;</p>
                </c:forEach>
			</div>

            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>惩戒提请部门：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" type="text" class="ipt-txt clx" name="punReqDept" id="punReqDept"  value="${info.punReqDept}"  readonly="readonly">
                            <input type="hidden" name="punReqDeptCode" id="punReqDeptCode" value="${info.punReqDeptCode}" />
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-6"><span class="start">*</span>是否需要执行部门反馈处理情况：</label>
                    <div style="line-height: 27px" class="col-6">
                        <input type="radio" name="feedBack" value="1" disabled="disabled" <c:if test="${info.feedBack == '1'}">checked="checked"</c:if> > 是
                        <input type="radio" name="feedBack" value="0" disabled="disabled" <c:if test="${info.feedBack == '0'}">checked="checked"</c:if>> 否
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>提请部门联系人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="contact" id="contact" disabled="disabled" value="${info.contact}" maxlength="50">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">传真：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="fax" id="fax" disabled="disabled"  value="${info.fax}" maxlength="30" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>联系电话：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="phone" id="phone" disabled="disabled" value="${info.phone}">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">电子邮箱：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="email" id="email"  disabled="disabled" value="${info.email}" maxlength="200">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3">提请人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                       		 <input type="hidden" name="punReqUserCode"   value="${info.punReqUserCode}"  />
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx" name="punReqUser" disabled="disabled" value="${info.punReqUser}" >
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">提请日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input style="background-color: #f4f4f4;" readonly="readonly" type="text"  disabled="disabled" class="ipt-txt clx" value="<fmt:formatDate value="${info.createTime}" type="date" pattern="yyyy-MM-dd"/>">
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="examine-opinion">
                <div class="mb5">
                    <label id="auditStateSpanY"><input type="radio" name="auditRes" value="0" ${deal=='5'?'disabled':'' } 
                                  <c:if test="${info.auditRes == '0'}">checked="checked"</c:if>>同意发出</label> 
                    <label id="auditStateSpanN"><input type="radio" name="auditRes" value="2" ${deal=='5'?'disabled':'' } 
                                <c:if test="${info.auditRes == '2'}">checked="checked"</c:if>>退回修改</label>
                </div>
                <textarea class="examine-text mb5" placeholder="请输入审核意见"   ${deal=='5'?'disabled':'' } name="auditView"   id="auditView">${deal=='1'?'':info.auditView}</textarea>
                <div class="form-item clearfix mb5">
                    <div class="col-6">
                        <label class="item-name fl">审核员：</label>
                        <div class="col-6">
                            <div class="ipt-box col-6">
                                <input style="background-color: #f4f4f4;" readonly="readonly" value="${deal=='5'?info.auditor:user.realName}" ${deal=='5'?'disabled':'' }  type="text" class="ipt-txt clx" name="cidRegNO" value="">
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label class="item-name fl">审核日期：</label>
                        <div class="col-6">
                            <div class="ipt-box col-6">
                                   <c:if test="${deal=='5' }">
                                   <input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx"  value="<fmt:formatDate value="${info.auditTime}" pattern="yyyy-MM-dd"/>">
                                   </c:if>
                                   <c:if test="${deal!='5'}"> 
                                    	<input style="background-color: #f4f4f4;" readonly="readonly" type="text" class="ipt-txt clx"  value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>">
                                   </c:if> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="form-item clearfix">
                <div class="btn-box mt10">
               				<c:if test="${deal!='5' }">
							  <input type="button" value="提交" id="savebutton" class="btn mr20">
                  			  <input type="button" value="取消" id="cancel"  class="btn mr20">
							</c:if>
							<c:if test="${deal=='5' }">
							   <c:if test="${not empty printFlag}">
							     <input type="button" value="打印" id="print"  class="btn mr20">
							   </c:if>
							 <input type="button" value="返回" id="cancel"  class="btn mr20">
							</c:if>

                    
                </div>
            </div>
        </form>
    </div>
</div>
<script>
	var userType = '${sessionScope.session_sys_user.userType}';
	var url='/common/system/sysdepart/alldeptcheckboxtreeselect';
	var urlHead = '/reg/server';
	if(userType==2){
		url='/syn/system/sysdepart/alldeptcheckboxtreeselect';
		urlHead='/syn';
	}
    window._CONFIG = {
   		select_dept_url: url,
   		urlHead: urlHead
    }
</script>
<script src="/js/lib/laydate/laydate.js"></script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/nocreditPunish/info/audit_main.js"></script>
</body>
</html>
