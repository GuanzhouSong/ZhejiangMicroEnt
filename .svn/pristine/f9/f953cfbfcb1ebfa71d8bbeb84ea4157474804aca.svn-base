<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>其它信息_司法协助详情查看页面</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<script type="text/javascript">
/* 证件种类 */
function switchCerTypeCode(val){
	if(val == "10"){
		return "居民身份证";
	}else if(val == "20"){
		 return "军官证";
	}else if(val == "30"){
		return "警官证";
	}else if(val == "40"){
		return "外国（地区）护照";
	}else if(val == "51"){
		return "香港特别行政区护照";
	}else if(val == "52"){
		return "香港（永久性）居民身份证";
	}else if(val == "53"){
		return "澳门特别行政区护照";
	}else if(val == "54"){
		return "澳门（永久性）居民身份证";
	}else if(val == "55"){
		return "港澳居民来往内地通行证";
	}else if(val == "56"){
		return "台湾居民身份证";
	}else if(val == "57"){
		return "台湾居民来往大陆通行证";
	}else if(val == "58"){
		return "台湾农民身份有关证明";
	}else if(val == "60"){
		return "户口薄";
	}else{
		return "其他有效身份证件";
	}
}
/* 执行事项 */
function switchItemCode(val){
	if(val == "1"){
		return "公示冻结股权、其他投资权益";
	}else if(val == "2"){
		return "续行冻结股权、其他投资权益";
	}else if(val == "3"){
		return "解除冻结股权、其他投资权益";
	}else if(val == "4"){
		return "强制转让被执行人股权，办理有限责任公司股东变更登记";
	}
}

/* 失效原因 */
function switchLoseEffResCode(val){
	if(val == "1"){
		return "冻结期满且未续行冻结，自动失效";
	}else if(val == "2"){
		return "2014年11月30日前未设定期限的冻结，公示满2年，未续行冻结，自动失效";
	}
}
</script>
<body>
<%--冻结、解冻、续行冻结（失效）、变更--%>
<c:if test="${pubJusticeInfo.justiceType == '1'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权冻结信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
        <tr>
            <td width="190" class="odd">执行法院</td>
            <td width="240">${pubJusticeInfo.executionCourt}</td>
            <td width="190" class="odd">执行事项</td>
            <td width="240"><script>document.write(switchItemCode("${pubJusticeInfo.executeItem}"))</script></td>
        </tr>
        <tr>
            <td class="odd">执行裁定书文号</td>
            <td>${pubJusticeInfo.exeRulNum}</td>
            <td class="odd">执行通知书文号</td>
            <td>${pubJusticeInfo.executeNo}</td>
        </tr>
        <tr>
            <td class="odd">被执行人</td>
            <td>${pubJusticeInfo.inv}</td>
            <td class="odd">被执行人持有股权、其它投资权益的数额</td>
            <td>${pubJusticeInfo.froAm}${pubJusticeInfo.froAuth}</td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${!empty pubJusticeInfo.bLicNO}">
                    <td class="odd">被执行人证照种类</td>
		            <td>营业执照</td>
		            <td class="odd">被执行人证照号码</td>
		            <td>${pubJusticeInfo.bLicNO}</td>
                </c:when>
                <c:otherwise>
                    <td class="odd">被执行人证件种类</td>
		            <td><script>document.write(switchCerTypeCode("${pubJusticeInfo.cerType}"))</script></td>
		            <td class="odd">被执行人证件号码</td>
		            <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td class="odd">冻结期限自</td>
            <td><fmt:formatDate value="${pubJusticeInfo.froFrom}" pattern="yyyy年MM月dd日"/></td>
            <td class="odd">冻结期限至</td>
            <td><fmt:formatDate value="${pubJusticeInfo.froTo}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td class="odd">冻结期限</td>
            <td>${pubJusticeInfo.frozDeadline}</td>
            <td class="odd">公示日期</td>
            <td><fmt:formatDate value="${pubJusticeInfo.publicDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        </tbody>
    </table>
</div>
<c:if test="${!empty pubJusticeConInfo && pubJusticeConInfo.frozState == '1'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权续行冻结信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
        <tr>
            <td width="190" class="odd">执行法院</td>
            <td width="240">${pubJusticeConInfo.executionCourt}</td>
            <td width="190" class="odd">执行事项</td>
            <td width="240"><script>document.write(switchItemCode("${pubJusticeConInfo.executeItem}"))</script></td>
        </tr>
        <tr>
            <td class="odd">执行裁定书文号</td>
            <td>${pubJusticeConInfo.exeRulNum}</td>
            <td class="odd">执行通知书文号</td>
            <td>${pubJusticeConInfo.executeNo}</td>
        </tr>
        <tr>
            <td class="odd">被执行人</td>
            <td>${pubJusticeConInfo.inv}</td>
            <td class="odd">被执行人持有股权、其它投资权益的数额</td>
            <td>${pubJusticeConInfo.froAm}${pubJusticeConInfo.froAuth}</td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${!empty pubJusticeInfo.bLicNO}">
                    <td class="odd">被执行人证照种类</td>
		            <td>营业执照</td>
		            <td class="odd">被执行人证照号码</td>
		            <td>${pubJusticeInfo.bLicNO}</td>
                </c:when>
                <c:otherwise>
                    <td class="odd">被执行人证件种类</td>
		            <td><script>document.write(switchCerTypeCode("${pubJusticeInfo.cerType}"))</script></td>
		            <td class="odd">被执行人证件号码</td>
		            <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td class="odd">续行冻结期限自</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.froFrom}" pattern="yyyy年MM月dd日"/></td>
            <td class="odd">续行冻结期限至</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.froTo}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <td class="odd">续行冻结期限</td>
            <td>${pubJusticeConInfo.frozDeadline}</td>
            <td class="odd">公示日期</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.publicDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${!empty pubJusticeConInfo && pubJusticeConInfo.frozState == '2'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权解冻信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
        <tr>
            <td width="190" class="odd">执行法院</td>
            <td width="240">${pubJusticeConInfo.executionCourt}</td>
            <td width="190" class="odd">执行事项</td>
            <td width="240"><script>document.write(switchItemCode("${pubJusticeConInfo.executeItem}"))</script></td>
        </tr>
        <tr>
            <td class="odd">执行裁定书文号</td>
            <td>${pubJusticeConInfo.exeRulNum}</td>
            <td class="odd">执行通知书文号</td>
            <td>${pubJusticeConInfo.executeNo}</td>
        </tr>
        <tr>
            <td class="odd">被执行人</td>
            <td>${pubJusticeConInfo.inv}</td>
            <td class="odd">被执行人持有股权、其它投资权益的数额</td>
            <td>${pubJusticeConInfo.froAm}${pubJusticeConInfo.froAuth}</td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${!empty pubJusticeInfo.bLicNO}">
                    <td class="odd">被执行人证照种类</td>
		            <td>营业执照</td>
		            <td class="odd">被执行人证照号码</td>
		            <td>${pubJusticeInfo.bLicNO}</td>
                </c:when>
                <c:otherwise>
                    <td class="odd">被执行人证件种类</td>
		            <td><script>document.write(switchCerTypeCode("${pubJusticeInfo.cerType}"))</script></td>
		            <td class="odd">被执行人证件号码</td>
		            <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td class="odd">解除冻结日期</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.thawDate}" pattern="yyyy年MM月dd日"/></td>
            <td class="odd">公示日期</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.publicDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
<c:if test="${!empty pubJusticeConInfo && pubJusticeConInfo.frozState == '3'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股权冻结失效信息
    </h3>
    <table class="table-common table-zichan table-punishdetail">
        <tbody>
        <tr>
            <td width="190" class="odd">失效原因</td>
            <td width="240"><script>document.write(switchLoseEffResCode("${pubJusticeConInfo.loseEffRes}"))</script></td>
        </tr>
        <tr>
            <td class="odd">失效时间</td>
            <td><fmt:formatDate value="${pubJusticeConInfo.loseEffDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
</c:if>
<c:if test="${pubJusticeInfo.justiceType == '2'}">
<div class="mod-bd-panel_company">
    <h3 class="i-title">
        <i></i>股东变更信息
    </h3>
    <table class="table-common table-zichan">
        <tbody>
        <tr>
            <td width="190" class="odd">执行法院</td>
            <td width="240">${pubJusticeInfo.executionCourt}</td>
            <td width="190" class="odd">执行事项</td>
            <td width="240"><script>document.write(switchItemCode("${pubJusticeInfo.executeItem}"))</script></td>
        </tr>
        <tr>
            <td class="odd">执行裁定书文号</td>
            <td>${pubJusticeInfo.exeRulNum}</td>
            <td class="odd">执行通知书文号</td>
            <td>${pubJusticeInfo.executeNo}</td>
        </tr>
        <tr>
            <td class="odd">被执行人</td>
            <td>${pubJusticeInfo.inv}</td>
            <td class="odd">被执行人持有股权数额</td>
            <td>${pubJusticeInfo.froAm}${pubJusticeInfo.froAuth}</td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${!empty pubJusticeInfo.bLicNO}">
                    <td class="odd">被执行人证照种类</td>
		            <td>营业执照</td>
		            <td class="odd">被执行人证照号码</td>
		            <td>${pubJusticeInfo.bLicNO}</td>
                </c:when>
                <c:otherwise>
                    <td class="odd">被执行人证件种类</td>
		            <td><script>document.write(switchCerTypeCode("${pubJusticeInfo.cerType}"))</script></td>
		            <td class="odd">被执行人证件号码</td>
		            <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td class="odd">受让人</td>
            <td>${pubJusticeInfo.assInv}</td>
            <td class="odd">协助执行日期</td>
            <td><fmt:formatDate value="${pubJusticeInfo.executeDate}" pattern="yyyy年MM月dd日"/></td>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${!empty pubJusticeInfo.assBLicNO}">
                    <td class="odd">受让人证照种类</td>
		            <td>营业执照</td>
		            <td class="odd">受让人证照号码</td>
		            <td>${pubJusticeInfo.assBLicNO}</td>
                </c:when>
                <c:otherwise>
                    <td class="odd">受让人证件种类</td>
		            <td><script>document.write(switchCerTypeCode("${pubJusticeInfo.assCerType}"))</script></td>
		            <td class="odd">受让人证件号码</td>
		            <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>
</c:if>
</body>
</html>
