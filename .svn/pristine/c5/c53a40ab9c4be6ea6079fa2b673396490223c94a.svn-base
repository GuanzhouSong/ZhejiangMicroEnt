     <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公示系统公告详情页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<script type="text/javascript">
   function doOptForShow(deptSameGov){
	   if(deptSameGov =="" || deptSameGov == null){
		   return "人民政府";
	   }
	   if(deptSameGov.indexOf("人民政府") != -1){
		   return deptSameGov;
	   }else{
		   return deptSameGov + "人民政府";
	   }
   }
</script>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20 mt20">
  <c:if test="${pubType == '1' || pubType == '2'}">
	<div class="mod mod-notice-detail mod-notice-detail2">
		<div class="mod-notice-hd mod-hd">
			<h3>经营异常公告</h3>
		</div>
		<div class="mod-notice-bd">
			<h1>
				<c:if test="${pubType == '1'}">
					${pubOpanoMaly.deptName}
					<p>列入经营异常名录决定书</p>
				</c:if>
				<c:if test="${pubType == '2'}">
					${pubOpaDetail.deptName}
					<p>移出经营异常名录决定书</p>
				</c:if>
			</h1>
			<p class="tr-center mb20">${pubOpanoMaly.penDecNo}${pubOpaDetail.penDecNo}</p>
			<c:if test="${pubType == '1'}">
			${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})：
			   <c:if test="${(pubOpanoMaly.batchEntType == '1' || pubOpanoMaly.batchEntType == '3') && pubOpanoMaly.speCause != '1'}">
				<p style="text-indent:2em;">经查，你单位因
					<c:if test="${pubOpanoMaly.speCause =='1'}">未按照《企业信息公示暂行条例》第八条规定的期限公示年度报告的</c:if>
					<c:if test="${pubOpanoMaly.speCause =='2'}">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息 </c:if>
					<c:if test="${pubOpanoMaly.speCause =='3'}">公示企业信息隐瞒真实情况、弄虚作假 </c:if>
					<c:if test="${pubOpanoMaly.speCause =='4'}"> 通过登记的住所或者经营场所无法联系</c:if>
					，违反了《企业信息公示暂行条例》和《企业经营异常名录管理暂行办法》的相关规定。根据 <c:if test="${pubOpanoMaly.speCause != '4' }">《企业信息公示暂行条例》第十七条第一款和</c:if>《企业经营异常名录管理暂行办法》第四条、第
					<c:if test="${pubOpanoMaly.speCause =='2'}">七</c:if>
					<c:if test="${pubOpanoMaly.speCause =='3'}">八</c:if>
					<c:if test="${pubOpanoMaly.speCause =='4'}">九</c:if>条之规定，决定将你企业列入经营异常名录并予以公示。  </p>
					<p style="text-indent:2em;">如不服本决定，可在接到本决定书之日起六十日内向
				    ${empty pubOpanoMaly.deptUpName?"":pubOpanoMaly.deptUpName}${empty pubOpanoMaly.deptUpName?"":"或者"}
				    <script>document.write(doOptForShow("${pubOpanoMaly.deptSameGov}"))</script>
				          申请行政复议；或者六个月内向${pubOpanoMaly.deptSameCourt}人民法院提起行政诉讼。
				    </p>
			   </c:if>
			   <c:if test="${(pubOpanoMaly.batchEntType == '1' || pubOpanoMaly.batchEntType == '3') && pubOpanoMaly.speCause == '1'}">
				<p style="text-indent:2em;">经查，你企业为
					${pubOpanoMaly.year } 年12月31日前成立，应当于每年6月30日前通过企业信用信息公示系统向工商部门报送上一年度年度报告。
					但截止 ${pubOpanoMaly.seqYear } 年6月30日， 你企业未按规定报送公示${pubOpanoMaly.year }年度报告，违反了《企业信息公示暂行条例》和《企业经营异常名录管理暂行办法》的相关规定。
					根据《企业信息公示暂行条例》第十七条第一款和《企业经营异常名录管理暂行办法》第四条、第六条之规定，决定将你企业列入经营异常名录并予以公示。 
				 </p>
					<p style="text-indent:2em;">如不服本决定，可在接到本决定书之日起六十日内向
				    ${empty pubOpanoMaly.deptUpName?"":pubOpanoMaly.deptUpName}${empty pubOpanoMaly.deptUpName?"":"或者"}
				    <script>document.write(doOptForShow("${pubOpanoMaly.deptSameGov}"))</script>
				          申请行政复议；或者六个月内向${pubOpanoMaly.deptSameCourt}人民法院提起行政诉讼。
				    </p>
			   </c:if>
			   
			   <c:if test="${pubOpanoMaly.batchEntType == '2' && pubOpanoMaly.speCause != '1'}">
				<p style="text-indent:2em;">经查，你单位因
					<c:if test="${pubOpanoMaly.speCause =='2'}">未按照工商行政管理部门责令的期限公示有关企业信息未按照工商行政管理部门责令的期限公示有关企业信息</c:if>
					<c:if test="${pubOpanoMaly.speCause =='3'}">年度报告公示信息隐瞒真实情况、弄虚作假 </c:if>
					<c:if test="${pubOpanoMaly.speCause =='4'}">通过登记的住所无法联系</c:if>
					，违反了《农民专业合作社年度报告公示暂行办法》的相关规定。根据《农民专业合作社年度报告公示暂行办法》第
					<c:if test="${pubOpanoMaly.speCause =='3'}">十一</c:if>
					<c:if test="${pubOpanoMaly.speCause =='4'}">十二</c:if>
					条之规定，决定将你单位列入经营异常名录并予以公示。
					</p>
					<p style="text-indent:2em;">如不服本决定，可在接到本决定书之日起六十日内向
				    ${empty pubOpanoMaly.deptUpName?"":pubOpanoMaly.deptUpName}${empty pubOpanoMaly.deptUpName?"":"或者"}
				    <script>document.write(doOptForShow("${pubOpanoMaly.deptSameGov}"))</script>
				          申请行政复议；或者六个月内向${pubOpanoMaly.deptSameCourt}人民法院提起行政诉讼。
				    </p>
			   </c:if>
			   <c:if test="${pubOpanoMaly.batchEntType == '2' && pubOpanoMaly.speCause == '1'}">
				<p style="text-indent:2em;">经查，你单位为
					${pubOpanoMaly.year } 年12月31日前成立，应当在每年6月30日前通过企业信用信息公示系统向工商部门报送上一年度年度报告。
					但截止 ${pubOpanoMaly.seqYear } 年6月30日，你单位未按规定报送公示${pubOpanoMaly.year }年度报告，年度报告，
					违反了《农民专业合作社年度报告公示暂行办法》的相关规定。根据《农民专业合作社年度报告公示暂行办法》第十条之规定，决定将你单位列入经营异常名录并予以公示。 
				 </p>
					<p style="text-indent:2em;">如不服本决定，可在接到本决定书之日起六十日内向
				    ${empty pubOpanoMaly.deptUpName?"":pubOpanoMaly.deptUpName}${empty pubOpanoMaly.deptUpName?"":"或者"}
				    <script>document.write(doOptForShow("${pubOpanoMaly.deptSameGov}"))</script>
				          申请行政复议；或者六个月内向${pubOpanoMaly.deptSameCourt}人民法院提起行政诉讼。
				    </p>
			   </c:if>
			</c:if>

			<c:if test="${pubType == '2' }">
			${pubOpaDetail.entName}(${pubOpaDetail.regNO })
			  <c:if test="${pubOpaDetail.entTypeCatg != '16' && pubOpaDetail.entTypeCatg !='17' && pubOpaDetail.isMove == '1'}">
				<p style="text-indent:2em;">经查，你单位
					<c:if test="${pubOpaDetail.remExcpres =='1'}">列入经营异常名录3年内且已补报未报年度（${pubOpanoMalyout.year}年度）的年度报告并公示</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='2'}">列入经营异常名录3年内且已履行公示义务 </c:if>
					<c:if test="${pubOpaDetail.remExcpres =='3'}">列入经营异常名录3年内且已更正其公示的信息</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='4'}">列入经营异常名录3年内且已依法办理住所或者经营场所变更登记</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='5'}">列入经营异常名录3年内且通过登记的住所或者经营场所可以重新取得联系</c:if>
					。根据<c:if test="${pubOpaDetail.remExcpres !='4' && pubOpaDetail.remExcpres !='5'}">《企业信息公示暂行条例》第十七条第二款和</c:if>《企业经营异常名录管理暂行办法》第
					<c:if test="${pubOpaDetail.remExcpres =='1'}">十一</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='2'}">十二</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='3'}">十三</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='4' || pubOpaDetail.remExcpres =='5'}">十四</c:if>
					  条之规定，决定将你企业移出经营异常名录。
					</p>
					<p style="text-indent:2em;">你单位如不服本决定，可在接到本决定书之日起六十日内向
					${empty pubOpaDetail.deptUpName?"":pubOpaDetail.deptUpName}${empty pubOpaDetail.deptUpName?"":'或者'}
					<script>document.write(doOptForShow("${pubOpaDetail.deptSameGov}"))</script>
					申请行政复议；或者六个月内向${pubOpaDetail.deptSameCourt}人民法院提起行政诉讼。
					</p>
				</c:if>
			   <c:if test="${pubOpaDetail.entTypeCatg !='16' && pubOpaDetail.entTypeCatg !='17' && pubOpaDetail.isMove =='2'}">
					<p style="text-indent:2em;">经查，你企业
				            于<fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" />因
					${pubOpaDetail.speCauseCN}被列入经营异常名录的情形有误。根据《企业经营异常名录管理暂行办法》第十六条之规定，应予更正。决定撤销
                    <fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" />由${pubOpaDetail.decorgCN}作出的
                                                            《列入经营异常名录决定书》（${pubOpanoMalyout.penDecNo }）。
					</p>
				</c:if>
			 <c:if test="${(pubOpaDetail.entTypeCatg =='16' || pubOpaDetail.entTypeCatg =='17') && pubOpaDetail.isMove =='1'}">
				<p style="text-indent:2em;">经查，你单位
					<c:if test="${pubOpaDetail.remExcpres =='1'}">列入经营异常名录3年内且已补报未报年度（${pubOpanoMalyout.year}年度）的年度报告并公示</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='2'}">列入经营异常名录3年内且已履行公示义务 </c:if>
					<c:if test="${pubOpaDetail.remExcpres =='3'}">列入经营异常名录3年内且已更正其公示的年度报告信息</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='4'}">列入经营异常名录3年内且已依法办理住所变更登记</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='5'}">列入经营异常名录3年内且通过登记的住所可以重新取得联系</c:if>
					。根据《农民专业合作社年度报告公示暂行办法》第
					<c:if test="${pubOpaDetail.remExcpres =='1'}">十三</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='2'}">十二</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='3'}">十四</c:if>
					<c:if test="${pubOpaDetail.remExcpres =='4' || pubOpaDetail.remExcpres =='5'}">十五</c:if>
					  条之规定，决定将你单位移出经营异常名录。
					</p>
					<p style="text-indent:2em;">如不服本决定，可在接到本决定书之日起六十日内向
					${empty pubOpaDetail.deptUpName?"":pubOpaDetail.deptUpName}${empty pubOpaDetail.deptUpName?"":'或者'}
					<script>document.write(doOptForShow("${pubOpaDetail.deptSameGov}"))</script>
					申请行政复议；或者六个月内向${pubOpaDetail.deptSameCourt}人民法院提起行政诉讼。
					</p>
				</c:if>
			    <c:if test="${(pubOpaDetail.entTypeCatg =='16' || pubOpaDetail.entTypeCatg =='17') && pubOpaDetail.isMove =='2'}">
				   <p style="text-indent:2em;">经查，你单位
				            于<fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" />因
					${pubOpaDetail.speCauseCN}被列入经营异常名录的情形有误。根据《农民专业合作社年度报告公示暂行办法》第十六条之规定，应予更正。决定撤销
                    <fmt:formatDate value="${pubOpaDetail.abnTime}" pattern="yyyy年MM月dd日" />由${pubOpaDetail.decorgCN}作出的
                                                            《列入经营异常名录决定书》（${pubOpanoMalyout.penDecNo}）。
					</p>
				</c:if>
			</c:if>
		</div>
		<div class="mod-notice-fd" style="padding-top: 80px">
			<p>${pubOpanoMaly.decorgCN}${pubOpaDetail.reDecOrgCN}</p>
			<p><fmt:formatDate value="${pubOpanoMaly.auditDate}" pattern="yyyy年MM月dd日"/>
				<fmt:formatDate value="${pubOpaDetail.auditDate}" pattern="yyyy年MM月dd日"/></p>
		</div>
	</div>
 </c:if>
 
 <c:if test="${pubType == '3'}">
     <div class="mod mod-notice-detail mod-notice-detail2">
		<div class="mod-notice-hd mod-hd">
			<h3>提醒公告</h3>
		</div>
		<div class="mod-notice-bd">
		  <h1>
			<p>经营异常名录期满三年提醒公告</p>
		  </h1>
		  
		  ${pubOpanoMaly.entName}(${pubOpanoMaly.regNO})：
		  <p style="text-indent:2em;">你企业于<fmt:formatDate value="${pubOpanoMaly.abnTime}" pattern="yyyy年MM月dd日"/>因
            <c:if test="${pubOpanoMaly.speCause =='1'}">未依照《企业信息公示暂行条例》第八条在规定的期限内公示年度报告</c:if>
			<c:if test="${pubOpanoMaly.speCause =='2'}">未在工商行政管理部门依照《企业信息公示暂行条例》第十条规定责令的期限内公示有关企业信息</c:if>
			<c:if test="${pubOpanoMaly.speCause =='3'}">公示企业信息隐瞒真实情况、弄虚作假</c:if>
			<c:if test="${pubOpanoMaly.speCause =='4'}">通过登记的住所或者经营场所无法联系</c:if>
			被列入经营异常名录（${pubOpanoMaly.penDecNo}），将于<fmt:formatDate value="${abnTime3}" pattern="yyyy年MM月dd日"/>
			届满三年。
		<p style="text-indent:2em;">根据《企业信息公示暂行条例》第十七条第二款的规定，被列入经营异常名录届满3年仍未履行相关义务的由工商行政管理部门列入严重违法失信企业名单，并通过国家企业信用信息公示系统向社会公示。请你企业尽快履行相关义务，并向工商部门申请移出经营异常名录。</p>
		</div>
		<div class="mod-notice-fd" style="padding-top: 80px">
			<p>${pubOpanoMaly.decorgCN}</p>
			<p><fmt:formatDate value="${pubAnnounceMent.createTime}" pattern="yyyy年MM月dd日"/></p>
		</div>
     </div>
 </c:if>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

