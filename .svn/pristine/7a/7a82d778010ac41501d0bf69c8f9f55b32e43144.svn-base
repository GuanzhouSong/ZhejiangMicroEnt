 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行政许可变更页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>

<!-- 头部  start-->
<jsp:include page="../../common/showtheader.jsp"></jsp:include>

<div class="mod pdt20 ">
    <div class="mod-cont permit-cont">
      <input type="hidden"  id="licID" name="licID" value="${mPermit.licID}"/>
        <h4>行政许可信息</h4>
        <div class="permit-change">
            <div class="tabbale" data-component="tab" data-contain="input">
                <div class="tab-header">
                    <label>类别选择： </label>
                    <ul class="clearfix">
                        <li class="tab-selected">
                            <label class="tab-item">
                                <input type="radio" value="change" name="chose" checked />变更
                            </label>
                        </li>
                        <li>
                            <label class="tab-item">
                                <input type="radio" name="chose" value="cancle"/>注销
                            </label>
                        </li>
                        <li>
                            <label class="tab-item">
                                <input type="radio" name="chose" value="beRevoked"/>被吊销
                            </label>
                        </li>
                        <li>
                            <label class="tab-item">
                                <input type="radio" name="chose"  value="invalidReason"/>其他无效信息
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-panel tab-panel-show">
                        <table border="0" cellpadding="0" cellspacing="0" class="table-special">
                               <tr>
                                <th colspan="2" class="before">变更前</th>
                                <th colspan="2" class="after">变更后</th>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可文件编号</td>
                                <td>${mPermit.licNO}</td>
                                <td class="tab-c-title">许可文件编号</td>
                                <td width="350">${mPermit.licNO}</td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>${mPermit.licNameCN}</td>
                                <td class="tab-c-title">许可文件名称</td>
                                <td>${mPermit.licNameCN}</td>
                            </tr>
                             <tr>
                                <td class="tab-c-title">许可机关</td>
                                <td id="change3T">${mPermit.licAnth}</td>
                                <td class="tab-c-title">
                                    <span>
                                        <input type="checkbox" title="change3" name="change" value="许可机关"/>许可机关
                                    </span>
                                </td>
                                <td>
                                    <span>${mPermit.licAnth}</span>
                                    <input type="text"  name="licAnth" id="change3"  onKeyDown="if(this.value.length >= 100){  this.value=this.value.substr(0,100) }" maxlength="100" class="ipt-txt" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">许可内容</td>
                                <td id="change4T">
                                <c:choose>
                                <c:when  test="${fn:length(mPermit.licItem)>'25'}">
                                ${fn:substring(mPermit.licItem,0,25)}... 
                                </c:when>
                                 <c:otherwise>  
                                    ${mPermit.licItem}
                                 </c:otherwise>
                                </c:choose>
                              </td>
                                <td class="tab-c-title">
                                    <span>
                                        <input type="checkbox" name="change" title="change4" value="许可内容"/>许可内容
                                    </span></td>
                                <td><span>  
                                 <c:choose>
                                <c:when  test="${fn:length(mPermit.licItem)>'25'}">
                                ${fn:substring(mPermit.licItem,0,25)}... 
                                </c:when>
                                 <c:otherwise>  
                                    ${mPermit.licItem}
                                 </c:otherwise>
                                </c:choose>
                                </span>
                                    <input type="text" name="licItem"    id="change4" class="ipt-txt" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期开始时间</td>
                                <td id="change1T"><fmt:formatDate value="${mPermit.valFrom}" pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title">
                                    <span>
                                        <input type="checkbox" name="change"   title="change1"value="有效期开始时间" />有效期开始时间
                                    </span>
                                </td>
                                <td>
                                    <span><fmt:formatDate value="${mPermit.valFrom}" pattern="yyyy-MM-dd"/></span>
                                    <input type="text" name="valFrom"  value="" id="change1"  class="ipt-txt ipt-txt laydate-icon"   readonly="readonly" />
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title">有效期结束时间</td>
                                <td id="change2T"><fmt:formatDate value="${mPermit.valTo}" pattern="yyyy-MM-dd"/></td>
                                <td class="tab-c-title"><span><input type="checkbox" name="change" title="change2"   value="有效期结束时间">有效期结束时间</span></td>
                                <td><span> <fmt:formatDate value="${mPermit.valTo}" pattern="yyyy-MM-dd"/></span>
                               <!--  <input type="text" name="valTo" id="change2"    class="ipt-txt icon-date"   readonly="readonly"> -->
                                <input type="text"   name="valTo"  value="" id="change2"  class="ipt-txt laydate-icon"  readonly="readonly" />
                                    <br/>
                                    <strong class="light" id="longt" style="display: none">
                                        <label >
                                            <input type="checkbox" name="longTime"  id="longTime" />无有效期或长期有效
                                        </label>
                                    </strong>
                                </td>
                            </tr>
                            <tr>
                                <td class="tab-c-title"></td>
                                <td></td>
                                <td class="tab-c-title">变更时间</td>
                                <td>
                                    <input type="text" class="ipt-txt  laydate-icon change-time" readonly="readonly" name="altDate" id="altDate"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="tab-panel">
                        <input type="hidden"  id="licID" name="licID" value="${mPermit.licID}" />
                        
                        <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">注销时间</div>
                                    <div class="item-txt">
                                        <input type="text" name="canDate" id="canDate"   readonly="readonly"    class="ipt-txt  laydate-icon" />
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">注销原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="equPleCanRea" id="equPleCanRea" value="" class="ipt-txt" />
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="tab-panel">
                         <ul class="form-common-list">
                            <li>
                                <div class="col-4">
                                    <div class="item-name">被吊销时间</div>
                                    <div class="item-txt">
                                        <input type="text" id="revDate" name="revDate"    readonly="readonly" class="ipt-txt laydate-icon" />
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">被吊销原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="sugRevReason" id="sugRevReason" value="" class="ipt-txt" />
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
                                        <input type="text" name="invAlidDate" id="invAlidDate"  readonly="readonly" class="ipt-txt laydate-icon" />
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="item-name">其他无效原因</div>
                                    <div class="item-txt">
                                        <input type="text" name="invAliDRea" id="invAliDRea" value="" class="ipt-txt" />
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>        
        </div>
        <p class="btn"><input type="button" id="savechange" value="保存" class="btn-common" />
            <input type="button"  id="cancle" value="取消" class="btn-common" />
        </p>
    </div>
</div>

<form id="changeForm"></form>


<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/tab.js"/>"></script>
<script>
    $(document).on('click','.tab-c-title input',function () {
        $(this).closest('td').next('td').find('span').toggle();
        $(this).closest('td').next('td').find('input:text').toggle();
        $(this).closest('td').next('td').find('strong').toggle();
    })
</script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/im/permit/change_main.js"/>"></script> 
 
</body>
</html>