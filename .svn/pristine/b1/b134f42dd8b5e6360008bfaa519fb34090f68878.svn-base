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
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/layout-default-latest.css">
    <link rel="stylesheet" href="/css/reg.server.css">
</head>
<body>
<form id="sysUserForm">
    <div class="pd20 clearfix">
        <h3 class="h3-title center"></h3>
        <input type="hidden" id ="formuid" name="UID" value="${organizeInfo.UID}"/>
        <input type="hidden" id ="createtime" name="createTime" value="<fmt:formatDate value="${organizeInfo.createTime}" pattern="yyyy-MM-dd" />"/>
        <input type="hidden" id ="viewFlag" value="${viewFlag}"/>
        <input type="hidden" id ="partyOrgLoc" name="partyOrgLoc" value="${organizeInfo.partyOrgLoc}"/>
        <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table-horizontal mt10 f12">
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织名称：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="partyOrgName"  name="partyOrgName" value="${organizeInfo.partyOrgName}" class="ipt-txt" required="required"/>
                        <div id="similarinfo" style="z-index: 999;position: relative;">
	                         <ul class="search-result-list js-search-result-list" id="rltMenuItem" style="display: none;width: 300px;">
	                         </ul>
                         </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织类型：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" id="partyOrgType" name="partyOrgType"  value="1" class="ipt-txt" ${organizeInfo.partyOrgType =='1'?'checked':''}>党委</label>
                        <label><input type="radio" name="partyOrgType"  value="2" class="ipt-txt" ${organizeInfo.partyOrgType =='2'?'checked':''}>党总支</label>
                        <label><input type="radio" name="partyOrgType"  value="3" class="ipt-txt" ${organizeInfo.partyOrgType =='3'?'checked':''}>党支部</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织分布类型：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <select id="partyOrgDistributed" name="partyOrgDistributed" required="required">
                          <option value="">-请选择-</option>
                          <option value="1" ${organizeInfo.partyOrgDistributed == '1'?'selected':''}>个体户党组织</option>
                          <option value="2" ${organizeInfo.partyOrgDistributed == '2'?'selected':''}>企业党组织</option>
                          <option value="3" ${organizeInfo.partyOrgDistributed == '3'?'selected':''}>农贸市场党组织</option>
                          <option value="4" ${organizeInfo.partyOrgDistributed == '4'?'selected':''}>商品交易市场党组织</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织书记姓名：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="secretaryName"  name="secretaryName" value="${organizeInfo.secretaryName}" class="ipt-txt" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织书记电话：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="secretaryTel"  name="secretaryTel" value="${organizeInfo.secretaryTel}" class="ipt-txt telandphone" required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>党组织所在地：</td>
                <td width="70%">
                    <div width="95%">
                          <div id="locChoose">  
	                            <div style="width: 18%;margin-right: 10px">
	                                <div class="ipt-box col-12">
	                                    <select name="locCity" id="locCity" required="required">
	                                        <option value="" ></option>
	                                        <option value="3301" ${(organizeInfo.locCity =='3301')?'selected':''}>杭州市</option>
											<option value="3302" ${(organizeInfo.locCity =='3302')?'selected':''}>宁波市</option>
											<option value="3303" ${(organizeInfo.locCity =='3303')?'selected':''}>温州市</option>
											<option value="3304" ${(organizeInfo.locCity =='3304')?'selected':''}>嘉兴市</option>
											<option value="3305" ${(organizeInfo.locCity =='3305')?'selected':''}>湖州市</option>
											<option value="3306" ${(organizeInfo.locCity =='3306')?'selected':''}>绍兴市</option>
											<option value="3307" ${(organizeInfo.locCity =='3307')?'selected':''}>金华市</option>
											<option value="3308" ${(organizeInfo.locCity =='3308')?'selected':''}>衢州市</option>
											<option value="3309" ${(organizeInfo.locCity =='3309')?'selected':''}>舟山市</option>
											<option value="3310" ${(organizeInfo.locCity =='3310')?'selected':''}>台州市</option>
											<option value="3311" ${(organizeInfo.locCity =='3311')?'selected':''}>丽水市</option>
	                                    </select>
	                                </div>
	                            </div>
	                            <div style="float: left;width: 30%;margin-left: 10px">
	                                <div class="ipt-box col-12">
	                                    <select name="locCounty" id="locCounty" required="required">
	                                       <option value=""></option>
											 <c:forEach var="codeAddresses" items="${codeAddresses}">
												 <option value="${codeAddresses.code}"  ${(codeAddresses.code==organizeInfo.locCounty)?'selected':''}>${codeAddresses.addressName}</option>
											 </c:forEach>
	                                    </select>
	                                </div>
	                            </div>
	                            <div style="float: left;width: 40%;margin-left: 10px">
	                                <div class="ipt-box col-12">
	                                   <select name="locStreet" id="locStreet" required="required">
	                               			<option value=""></option>
											<c:forEach var="addressStreet" items="${addressStreet}">
												 <option value="${addressStreet.code}"  ${(addressStreet.code==organizeInfo.locStreet)?'selected':''}>${addressStreet.addressName}</option>
											</c:forEach>
	                               		</select>
	                                </div>
	                            </div>
                            </div>
                        </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>管辖单位：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value="${organizeInfo.localAdm}"/>
                        <input type="text" class="ipt-txt" id="localAdmName" name="localAdmName" value="${organizeInfo.localAdmName}" readonly="readonly" placeholder="请选择管辖单位" required="required"/>
                        <span class="add-icon" id="choseregUnit">
                            <i></i>
                        </span>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>组建日期：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="partyOrgBuildDate" name="partyOrgBuildDate" onclick="laydate()" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${organizeInfo.partyOrgBuildDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" required="required"/>
                    </div>
                </td>
           </tr>
          <c:if test="${viewFlag != '0' && organizeInfo.inputState != '2'}">
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>是否有效：</td>
                <td width="70%">
                    <div style="font-size: 13px">
                        <label><input type="radio" name="inputState"  value="1" class="ipt-txt" ${organizeInfo.inputState =='1'?'checked':''}>有效</label>
                        <label><input type="radio" name="inputState"  value="0" class="ipt-txt" ${organizeInfo.inputState =='0'?'checked':''}>无效</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>建档日期：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" readonly="readonly" style="width: 150px;cursor: pointer;"
                        value="<fmt:formatDate value="${organizeInfo.createTime}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow"/>
                    </div>
                </td>
           </tr>
          </c:if>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>录入日期：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                      <c:if test="${viewFlag == '0'}">
	                        <input type="text" id="inputDate" name="inputDate" readonly="readonly" style="width: 150px;cursor: pointer;"
	                        value="<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" required="required"/>
                       </c:if>
                       <c:if test="${viewFlag != '0'}">
	                         <input type="text" id="inputDate" name="inputDate"  readonly="readonly" style="width: 150px;cursor: pointer;"
	                        value="<fmt:formatDate value="${organizeInfo.inputDate}" pattern="yyyy-MM-dd" />" class="ipt-txt isShow" required="required"/>
                       </c:if>
                    </div>
                </td>
           </tr>
            <tr>
                <td class="bg-gray right" width="30%"><span class="light">*</span>录入员：</td>
                <td width="70%">
                    <div class="ipt-box pd0">
                        <input type="text" id="inputName"  name="inputName" value="${viewFlag =='0'?sessionScope.session_sys_user.realName:organizeInfo.inputName}" class="ipt-txt" readonly="readonly" required="required"/>
                    </div>
                </td>
           </tr>
        </table>
	      <p class="center mt10">
	         <c:if test="${viewFlag != '2'}">
		        <input type="submit" id="save" class="btn mr20" value="提交"/>
		     </c:if>
		        <button id="cancel" type="button" class="btn">关闭</button>
		  </p>
    </div>
</form>
<script id="tpl" type="text/x-handlebars-template">
    {{#each menus}}
    <li data-index="{{uid}}">{{partyOrgName}}</li>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/partycreate/party_org_edit.js"></script>
</body>
</html>