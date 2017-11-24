<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>知识产权出质新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<form  id="ippldgForm"> 
  <input type="hidden" name="priPID" value=${midBaseInfoDto.priPID }>
            <input type="hidden" name="entName" value=${midBaseInfoDto.entName }>
              <input type="hidden" name="regNO" value=${midBaseInfoDto.regNO }>
               <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }> 
                <input type="hidden" name="pleID" value="${imIppldg.pleID}">

<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>知识产权出质登记信息</h4>
        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name item-name-lg">
                     出质商标注册号
                        </div>
                        <div class="item-txt item-txt-lg">
                            <input type="text" name="TMRegNo" value="${imIppldg.TMRegNo}" placeholder="请输入出质商标注册号" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name item-name-lg">名称</div>
                        <div class="item-txt item-txt-lg">
                            <input type="text" name="TMName"   placeholder="请输入名称"
                           value="${imIppldg.TMName}" class="ipt-txt"  >
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name item-name-lg">种类</div>
                       <%--  <div class="item-txt item-txt-lg">
                            <input type="text" name="kinds" class="ipt-txt" placeholder="请输入种类" value="${imIppldg.kinds }">
                        </div> --%>
                        <div class="item-txt item-txt-lg">
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
                        
                    </div>
                    <div class="col-6">
                        <div class="item-name item-name-lg">出质人名称</div>
                        <div class="item-txt item-txt-lg">
                          <input type="text" name="pledgor"   placeholder="请输入出质人名称"
                           value="${imIppldg.pledgor}" class="ipt-txt">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-6">
                        <div class="item-name item-name-lg">质权人名称</div>
                        <div class="item-txt item-txt-lg">
                           <input type="text" name="impOrg"  placeholder="请输入质权人名称"
                           value="${imIppldg.impOrg}" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name item-name-lg">质权登记期限</div>
                        <div class="item-txt item-txt-lg">
                            <input type="text" class="ipt-txt ipt-txt-xs laydate-icon pos127"  placeholder="请输入开始时间" id="pleRegPerFrom" name="pleRegPerFrom"
                         value="<fmt:formatDate value="${imIppldg.pleRegPerFrom}" pattern="yyyy-MM-dd"/>"  readonly=""  > —
                            <input type="text"  class="ipt-txt ipt-txt-xs laydate-icon pos127"  name="pleRegPerTo" id="pleRegPerTo"  placeholder="请输入结束时间"
                             value="<fmt:formatDate value="${imIppldg.pleRegPerTo}" pattern="yyyy-MM-dd"/>" readonly=""   >

                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <p class="btn"><input type="submit" id="submitButton" value="保存" class="btn-common"><input type="button" id="cancle" value="取消"  class="btn-common"></p>
    </div>
</div>
</form>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/ippldg/edit_main.js"/>"></script>
</body>
</html>