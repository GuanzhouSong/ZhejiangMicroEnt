<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>知识产权出质变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>


<div class="mod pdt20 ">
    <div class="mod-cont permit-cont">
        <h4>知识产权出质登记信息</h4>
        <div class="ippldg_change">
        
             <input type="hidden" name="pleID" id="pleID" value="${imIppldg.pleID}">
            <div class="tabbale" data-component="tab" data-contain="input">
                <div class="tab-header">
                    <label>类别选择： </label>
                    <ul class="clearfix">
                        <li class="tab-selected"><label class="tab-item"><input type="radio" name="chose" value="change" checked>变更</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose" value="cancle">注销</label></li>
                        <li><label class="tab-item"><input type="radio" name="chose" value="invalidReason">其他无效信息</label></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-panel tab-panel-show">
                        <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                            <tr>
                                <th colspan="2" class="before" width="50%">变更前</th>
                                <th colspan="2" class="after" width="50%">变更后</th>
                            </tr>
                            <tr>
                                <td class="tab-c-title" width="160">出质商标注册号</td>
                                <td width="300">${imIppldg.TMRegNo}</td>
                                <td class="tab-c-title">出质商标注册号</td>
                                <td width="300">${imIppldg.TMRegNo}</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">名称</td>
                                <td>${imIppldg.TMName}</td>
                                <td class="tab-c-title">名称</td>
                                <td>${imIppldg.TMName}</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">种类</td>
                                <td id="change1T">
                                <c:choose>
                                 <c:when test="${imIppldg.kinds=='1'}"> 商标</c:when>
                                  <c:when test="${imIppldg.kinds=='2'}">版权</c:when>
                                  <c:when test="${imIppldg.kinds=='3'}">专利</c:when>
                                <c:otherwise>${imIppldg.kinds }</c:otherwise>
                                </c:choose>
                                 
                                 </td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change1"value="种类">种类</span></td>
                                <td><span>     <c:choose>
                                 <c:when test="${imIppldg.kinds=='1'}">商标</c:when>
                                  <c:when test="${imIppldg.kinds=='2'}">版权</c:when>
                                  <c:when test="${imIppldg.kinds=='3'}">专利</c:when>
                                <c:otherwise>${imIppldg.kinds}</c:otherwise>
                                </c:choose>
                                 </span>   
                                  <div class="item-txt" style="display: none">
                          <select name="kinds" id="change1" class="select-txt required">
                              
                                <c:choose>
                                <c:when test="${imIppldg.kinds=='1'}">
                                 <option value="1"  selected="selected">商标</option>
                                </c:when>
                                 <c:when test="${imIppldg.kinds=='2'}">
                                 <option value="1"  selected="selected">版权</option>
                                </c:when>
                                 <c:when test="${imIppldg.kinds=='3'}">
                                 <option value="1"  selected="selected">专利</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="">--请选择--</option>
                                </c:otherwise> 
                                </c:choose>
                                <c:forEach items="${map}" var="map">
                                <option value="${map.key}">${map.value }</option>
                                </c:forEach>
                                      
                              
                            </select>
                        </div>
                                 </td></tr>
                            <tr>
                                <td class="tab-c-title">出质人名称</td>
                                <td id="change2T">${imIppldg.pledgor}</td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change2" value="出质人名称">出质人名称</span></td>
                                <td><span>${imIppldg.pledgor }</span><input type="text" id="change2" name="pledgor" onKeyDown="if(this.value.length >= 200){ this.value=this.value.substr(0,200) }" maxlength="200" class="ipt-txt"></td></tr>
                            <tr>
                                <td class="tab-c-title">质权人名称</td>
                                <td id="change3T">${imIppldg.impOrg}</td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change3" value="质权人名称">质权人名称</span></td>
                                <td><span>${imIppldg.impOrg}</span><input type="text" name="impOrg" id="change3" onKeyDown="if(this.value.length >= 200){ this.value=this.value.substr(0,200) }" maxlength="200" class="ipt-txt"></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">质权登记开始期限</td>
                                <td id="change4T"><fmt:formatDate value="${imIppldg.pleRegPerFrom}" pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change4" value="质权登记开始期限">质权登记开始期限</span></td>
                                <td><span><fmt:formatDate value="${imIppldg.pleRegPerFrom}" pattern="yyyy-MM-dd"/></span><input id="change4" type="text" value="" name="pleRegPerFrom" class="ipt-txt laydate-icon"   readonly="readonly" ></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">质权登记结束期限</td>
                                <td id="change5T"><fmt:formatDate value="${imIppldg.pleRegPerTo}" pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change5" value="质权登记开始期限">质权登记结束期限</span></td>
                                <td><span><fmt:formatDate value="${imIppldg.pleRegPerTo}" pattern="yyyy-MM-dd"/></span><input id="change5" type="text" value="" name="pleRegPerTo" class="ipt-txt laydate-icon"   readonly="readonly"  ></td>
                            </tr>
                            <tr>
                                <td class="tab-c-title"></td>
                                <td></td>
                                <td class="tab-c-title">更变时间</td>
                                <td><input type="text" name="altDate" class="ipt-txt laydate-icon change-time" id="altDate" readonly="readonly"  ></td>
                            </tr>
                        </table>
                    </div>
                    <div class="tab-panel">
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">注销时间</div>
                     
                                    <div class="item-txt">
                                        <input type="text" id="canDate" name="canDate" class="ipt-txt   change-time ipt-txt-small laydate-icon" readonly="readonly"  >
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">注销原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="equPleCanRea" id="equPleCanRea" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">其他无效时间</div>
                                    <div class="item-txt">
                                        <input type="text" name="invAlidDate" id="invAlidDate" class="ipt-txt  change-time ipt-txt-small laydate-icon" readonly="readonly" >
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">其他无效原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="invAliDRea" id="invAliDRea" value="" class="ipt-txt">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <p class="btn"><input type="button" value="保存" id="savechange" class="btn-common"><input type="button" value="取消" id="cancle"class="btn-common"></p>
    </div>
</div>
<form id="changeForm"></form>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input').toggle();
        $(this).closest('td').next('td').find('.item-txt').toggle();
    })
</script>
 
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/ippldg/change_main.js"/>"></script> 
 


</body>
</html>