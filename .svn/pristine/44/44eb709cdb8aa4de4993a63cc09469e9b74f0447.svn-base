<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政处罚新增页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>


<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>


  <form id="caseForm">
   <input type="hidden" name="priPID" value=${midBaseInfoDto.priPID }>
            <input type="hidden" name="entName" value=${midBaseInfoDto.entName }>
              <input type="hidden" name="regNO" value=${midBaseInfoDto.regNO }>
               <input type="hidden" name="uniCode" value=${midBaseInfoDto.uniCode }>
            
                <input type="hidden" name="caseNO" value="${imCase.caseNO}">
<div class="mod pdt20">
    <div class="mod-cont permit-cont">
        <h4>行政处罚信息</h4>
        <div>
            <ul class="form-common-list">
                <li>
                    <div class="col-6">
                        <div class="item-name">
                            处罚决定书文号
                        </div>
                        <div class="item-txt ">
                            <input type="text"  name="penDecNo"   placeholder="请输入处罚决定书文号"
                           value="${imCase.penDecNo}"value="" class="ipt-txt">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="item-name">处罚决定书签发日期</div>
                        <div class="item-txt">
                            <input type="text"   class="ipt-txt ipt-txt-small laydate-icon"  name="penDecIssDate"  id="penDecIssDate" class="form-control"   placeholder="请输入处罚决定书签发日期"
                           value="<fmt:formatDate value="${imCase.penDecIssDate}" pattern="yyyy-MM-dd"/>" readonly="" > 
                           
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name">处罚机关 </div>
                        <div class="item-txt js-ipt-box">
                                <input type="text" name="judAuth"   class="ipt-txt ipt-lg"  placeholder="请输入处罚机关"
                          value="${imCase.judAuth}"  >
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name">违法行为类型</div>
                        <div class="item-txt">
                            <input type="text"  name="illegActType"   placeholder="请输入违法行为类型"
                        value="${imCase.illegActType}"  class="ipt-txt ipt-lg">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-name">处罚种类</div>
                    <div class="item-txt item-punish-type" >
                        
               
                       <c:forEach items="${codeList}" var="pr" varStatus="status">
					 <span><label><input  type="checkbox"  ${!empty penType[pr.code]?"checked":"" } name="chose" title="${pr.content }" value="${pr.code }" >${pr.content }</label></span>
						     
					
						</c:forEach>  
						 
                    </div>
                    <input type="hidden" name="penTypeCN" id="penTypeCN">
                       <input type="hidden" name="penType" id="penType">
                </li>
                <li >
                    <div class="col-6" id="penAm" style="display:none;">
                        <div class="item-name">罚款金额（万元）</div>
                        <div class="item-txt ">
                            <input type="text" name="penAm" maxlength="16"  id="penAmT" value="${imCase.penAm }" class="ipt-txt assetItem">
                        </div>
                    </div>
                    <div class="col-6" id="forfAm" style="display:none;">
                        <div class="item-name">没收金额（万元）</div>
                        <div class="item-txt ">
                            <input type="text" name="forfAm" maxlength="16" id="forfAmT" value="${imCase.forfAm}" class="ipt-txt assetItem">
                        </div>
                    </div>
                </li>
                <li>
                    <div class="col-12">
                        <div class="item-name">备注</div>
                        <div class="item-txt">
                            <input type="text" name="penContent" value="${imCase.penContent }" class="ipt-txt ipt-lg">
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <p class="btn"><input type="submit" value="保存" id="submitButton" class="btn-common"><input type="button" value="取消"  id="cancel" class="btn-common"></p>
    </div>
</div>
</form>
 

<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/case/edit_main.js"/>"></script>
  
 
</body>
</html>