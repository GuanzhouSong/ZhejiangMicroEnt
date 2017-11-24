<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <div class="form-item3">
     <div class="item-name3 tindent24">如果对本责令改正通知不服，可以在收到本通知之日起六十日内向</div>
     <c:choose>
         <c:when test="${empty orderReformSet }">
             <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="">
		     </div>
         </c:when>
        <c:when test="${orderReformSet.adminGuideType=='0' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[5]}">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[6]}">
		     </div>
        </c:when>
        <c:when test="${orderReformSet.adminGuideType=='1' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[5]}">
		     </div>
		               或者
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[6]}">
		     </div>
        </c:when>
        <c:when test="${orderReformSet.adminGuideType=='2' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[5]}">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[6]}">
		     </div>
        </c:when>
        <c:when test="${orderReformSet.adminGuideType=='3' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[1]}">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[2]}">
		     </div>
        </c:when>
        <c:when test="${orderReformSet.adminGuideType=='4' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[1]}">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[2]}">
		     </div>
        </c:when>
        <c:when test="${orderReformSet.adminGuideType=='5' }">
              <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[1]}">
		     </div>
		     <div class="item-name3">或者</div>
		     <div class="ipt-box3">
		         <input type="text" class="ipt-txt3" value="${guideContentArr[2]}">
		     </div>
        </c:when>
     </c:choose>
    人民政府申请复议；
     也可以在六个月内依法向人民法院提起诉讼。
 </div>
 <div class="form-item2">
     <div class="item-name2">联系人：</div>
     <div class="ipt-box2">
         <input type="text" class="ipt-txt2" name="linkManTem" id="linkManTem" value="${orderReformSet.linkMan}" maxlength="30">
     </div>
     <div class="item-name2">联系电话：</div>
     <div class="ipt-box2">
         <input type="text" class="ipt-txt2" name="telTem" id="telTem" value="${orderReformSet.tel}" maxlength="25">
     </div>
     <div class="item-name2">出具日期：</div>
     <div class="ipt-box2">
         <c:if test="${empty orderReformSet}">
           <input type="text" class="ipt-txt2" readonly="readonly" value="${appDate}" name="assignDateTem" id="assignDateTem" onclick="laydate()">
         </c:if>
         <c:if test="${not  empty orderReformSet}">
           <input type="text" class="ipt-txt2" readonly="readonly" name="assignDateTem"  value="<fmt:formatDate value="${orderReformSet.assignDate}" pattern="yyyy-MM-dd" />" id="assignDateTem" onclick="laydate()">
         </c:if>
     </div>
 </div>
 <div class="form-item2">
     <div class="item-name2">登记机关：</div>
     <div class="ipt-box2">
         <input type="text" class="ipt-txt2"  name="regOrgNameTem" value="${empty orderReformSet? midBaseInfo.regOrgName : orderReformSet.regOrgName} " disabled="disabled" maxlength="40">
     </div>
     <div class="item-name2">管辖单位：</div>
     <div class="ipt-box2">
         <input type="text" class="ipt-txt2" name="localAdmNameTem" value="${empty orderReformSet? midBaseInfo.localAdmName :orderReformSet.localAdmName}" disabled="disabled" maxlength="40">
     </div>
 </div>
