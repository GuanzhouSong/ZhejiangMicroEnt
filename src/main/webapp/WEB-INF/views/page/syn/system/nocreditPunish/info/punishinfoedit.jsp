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
			<input type="hidden" id="detailJson" name="detailJson"  value=""/>
            <div class="form-item clearfix pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 惩戒领域：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <select name="punField" id="punField">
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
                            <select name="punCause" id="punCause" >
                                <option value="" >请选择..</option>
                                <c:forEach items="${causes}" var="obj">
                                     <option value="${obj.punCause}"
                                          <c:if test="${obj.punCause == info.punCause}">selected="selected"</c:if>>${obj.punCause}
                                     </option>
	                            </c:forEach>
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
                        <div class="ipt-box col-3">
                            <input type="button" id="selectPunExeDept" value="部门列表" class="btn-new ml10 mr20">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span> 执行有效期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="exeBegin" name="exeBegin"  ${info.isLife=='1'?'disabled':''} value="<fmt:formatDate value="${info.isLife=='1'?'':info.exeBegin}" pattern="yyyy-MM-dd" />" readonly="readonly" onclick="laydate();" class="ipt-txt zxyxq-btn clx">
                            至
                            <input type="text" class="ipt-txt zxyxq-btn clx"  ${info.isLife=='1'?'disabled':''} readonly="readonly" id="exeEnd" name="exeEnd"  onclick="laydate();" value="<fmt:formatDate value="${info.isLife=='1'?'':info.exeEnd}" pattern="yyyy-MM-dd" />">
                            <input type="checkbox" id="isLife" name="isLife" value="1" class="ipt-txt zxyxq-chk clx" <c:if test="${info.isLife=='1'}">checked="checked" </c:if> >终身
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span> 被惩戒当事人：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="button" value="添加名单" id="adddetail"  class="btn-new mr20">
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
									<th width="90" class="last-col">操作</th>
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
                                       <td class="last-col"><a href='javascript:void(0)'
                                                               tag='del' name="${obj.priPID}">删除</a>
                                       </td>
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
								<th width="90" class="last-col">操作</th>
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
                                     <td class="last-col"><a href='javascript:void(0)'
                                                             tag='del'
                                                             name="${obj.cardNo}">删除</a>
                                     </td>
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
                            <input type="text" id="legNo" name="legNo" maxlength="50" class="ipt-txt clx" value="${info.legNo}">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3"><span class="red">*</span>  文书出具日期：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" id="legDate" name="legDate" onclick="laydate();" readonly="readonly" class="ipt-txt clx" value="<fmt:formatDate value="${info.legDate}" pattern="yyyy-MM-dd" />">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125"><span class="red">*</span>  违法性质：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <input type="text" name="illegalProperty" id="illegalProperty" maxlength="500" class="ipt-txt clx" value="${info.illegalProperty}" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  违法事实：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="illegalFact" id="illegalFact" style="resize: none;" maxlength="500" cols="30" rows="10">${info.illegalFact}</textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix pd50">
                <div class="col-12">
                    <label class="item-name w125 wfss-lb"><span class="red">*</span>  处理结果：</label>
                    <div class="w875">
                        <div class="ipt-box col-12">
                            <textarea class="wfss-tt" name="punHandleRes" id="punHandleRes" style="resize: none;" maxlength="500"  cols="30" rows="10">${info.punHandleRes}</textarea>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-item clearfix mb5 pd50">
                <div class="col-12">
                    <label class="item-name w125">证据资料上传：</label>
                    <div class="w875">
                        <div class="ipt-box col-9">
                            <div class="file-box mr5">
                            	<input type="button" class="btn btn-sm file-btn" value="添加附件">
                                <span id=""><input type="file" class="btnFile" name="btnFile" id="btnFile"></span>
                            </div>
                            <input type="hidden" id="files" name="files" value="${info.files}"/>
                            <input type="hidden" id="file" value=""/>
                            <!-- <input style="position: absolute; left:500px;" type="button" value="上传" id="savebutton" class="btn mr20"> -->
                        </div>
                        <div class="col-3 fr file-explain">说明：支持图片、文档、照片等上传</div>
                    </div>
                </div>
            </div>
			<div id="filelabel" style="padding-left:12.5%;">
				<c:forEach items="${files}" var="obj">
                     <p><span path="${obj}" style="color:blue;cursor:pointer"
                              title="点击下载"><i
                             class="xbt-icon file-icon"></i>${fn:substringAfter(obj, '-')}</span>
                         &nbsp;&nbsp;<a href="javascript:void(0)"
                                        path="${obj}">删除</a></p>
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
                        <input type="radio" name="feedBack" value="1" <c:if test="${info.feedBack == '1'}">checked="checked"</c:if> > 是
                        <input type="radio" name="feedBack" value="0"  <c:if test="${info.feedBack == '0'}">checked="checked"</c:if>> 否
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>提请部门联系人：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="contact" id="contact"  value="${info.contact}" maxlength="50">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">传真：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="fax" id="fax"  value="${info.fax}" maxlength="30" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-item clearfix mb5 pd50">
                <div class="col-6">
                    <label class="item-name col-3"><span class="start">*</span>联系电话：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="phone" id="phone" value="${info.phone}">
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <label class="item-name col-3">电子邮箱：</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx" name="email" id="email" value="${info.email}" maxlength="200">
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
            
            <div class="form-item clearfix">
                <div class="btn-box mt10">
                    <input type="button" value="提交" id="savebutton" class="btn mr20">
                    <input type="button" value="取消" id="cancel"  class="btn mr20">
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
<script src="/js/syn/system/nocreditPunish/info/edit_main.js"></script>
</body>
</html>
