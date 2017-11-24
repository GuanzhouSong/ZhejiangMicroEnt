<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!-- 公司基本信息 -->
<div class="mod company-basic clearfix">
    <div class="caption">
        <div class="title clearfix">
            <span class="fl mr5">${entBasicInfo.entName }</span>
            <span class="icon-rectangle ${hx:publicStatusStyle(entBasicInfo.regState)} fl">${hx:publicStatus(entBasicInfo.regState)}</span>
            <div class="pos-rel fl ml5">
                <c:if test="${classflag==1||classflag==2||classflag==3 }">
                    <c:if test="${entBasicInfo.isOpanomaly==1}">
                        <span class="tip">（该企业被列入经营异常名录）</span>
                    </c:if>

                </c:if>
                <c:if test="${classflag==4 }">
	        	<span class="tip">
		        	<c:if test="${entBasicInfo.isOpanomaly==1}">
                        （该企业被列入经营异常名录，点击查看详情）
                    </c:if>
                </span>
                </c:if>
                <c:if test="${classflag==5 }">
                    <span class="tip">
                    	<c:if test="${entBasicInfo.isOpanomaly==2}">
                            （该企业被列入严重违法失信企业名单）
                        </c:if>
                    	<c:if test="${entBasicInfo.isOpanomaly==1}">
                            （该企业被列入经营异常名录）
                        </c:if>
                    </span>
                </c:if>
                <div class="exceptionlist-layer">
                    <span class="close">×</span>
                    <h3>经营异常名录：</h3>
                    <p>该企业被列入工商部门经营异常名录</p>
                    <!--
	                    <span class="line"></span>
	                    <h3>黑名单：</h3>
	                    <p>该企业被列入失信被执行人名单</p>
	                    <p>该企业被列入重大税收违法案件名单</p>
	                    <p>该企业被列入严重违法失信企业名单</p>
                     -->
                </div>
            </div>
        </div>
        <p>
            <i class="book2-icon"></i>统一社会信用代码/注册号：
            <span>
            <c:choose>
                <c:when test="${!empty entBasicInfo.UNICODE}">
                    ${entBasicInfo.UNICODE }
                </c:when>
                <c:otherwise>
                    ${entBasicInfo.regNO }
                </c:otherwise>
            </c:choose>
			</span>
        </p>
        <p>
            <c:if test="${fn:indexOf('12,14,34,32,22,28,24,17', entBasicInfo.entTypeCatg)!=-1}">
                <i class="person2-icon"></i>负责人：
            </c:if>
            <c:if test="${fn:indexOf('11,21,13,16', entBasicInfo.entTypeCatg)!=-1}">
                <i class="person2-icon"></i>法定代表人：
            </c:if>
            <c:if test="${fn:indexOf('33,27', entBasicInfo.entTypeCatg)!=-1}">
                <i class="person2-icon"></i>执行事务合伙人：
            </c:if>
            <c:if test="${fn:indexOf('31', entBasicInfo.entTypeCatg)!=-1}">
               <i class="person2-icon"></i>投资人：
            </c:if>
            <c:if test="${fn:indexOf('50', entBasicInfo.entTypeCatg)!=-1}">
                <i class="person2-icon"></i>经营者：
            </c:if>
            <span>${entBasicInfo.leRep }</span>
        </p>
        <p>
            <i class="local-icon"></i>登记机关：<span>${entBasicInfo.regOrgName }</span>
        </p>
        <p>
        <c:choose>
        	<c:when test="${entBasicInfo.regState=='D'}">
        		<i class="date-icon"></i>吊销日期：<span>${entBasicInfo.punishDateStr }</span>
        	</c:when>
        	<c:when test="${entBasicInfo.regState=='XX'||entBasicInfo.regState=='DX'}">
        		<i class="date-icon"></i>注销日期：<span>${entBasicInfo.altDateStr }</span>
        	</c:when>
        	<c:otherwise>
        		<i class="date-icon"></i>成立日期：<span>${entBasicInfo.estDateStr }</span>
        	</c:otherwise>
        </c:choose>
        </p>
        
        <p>
            <i class='book2-icon'></i>电子营业执照：
            <a href="../../client/entsearch/bussinessLic?encryPriPID=${entBasicInfo.encryPriPID }" id="businessLic" target="_blank" class="ml5">点击查看</a>
        </p>
        
        <c:if test="${entBasicInfo.isSimpleCancle=='1'&& objectionFlag=='1'}">
        <p>
            <i class="broadcast-icon"></i><span class="light">正在进行简易注销公告，公告期：<fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></span>
            <a href="../../pub/simpleesc/erescobjinfo/objectionDetail?encryPriPID=${entBasicInfo.encryPriPID }" class="btn-objection ml10">我要异议</a>
        </p>
        </c:if>
    </div>
    <div class="btn-box">
        <a href="javascript:void(0)" id="sendPdf"><i class="send-icon"></i>发送报告</a>
        <a href="#" class="light-blue-bg js-share-info"><i class="share-icon" ></i>信息分享</a>
        <a href="#"  class="green-bg" id="print-icon" ><i class="print-icon"></i>信息打印</a>
    </div>
</div>
<div class="mod tab-header-outer">
    <div class="tab-header tab-detail tab-detail01">
        <ul class="clearfix">
            <li
                    <c:if test="${classflag==1 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/baseinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">基础信息</a>
            </li>
            <li>|</li>
            <li
                    <c:if test="${classflag==2 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/licenseinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">行政许可信息</a>
            </li>
            <li>|</li>
            <li
                    <c:if test="${classflag==3 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/punishinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">行政处罚信息</a>
            </li>
            <li>|</li>
            <li
                    <c:if test="${classflag==4 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/anomalyinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">列入经营异常名录信息</a>
            </li>
            <!-- 农专、个体没有严重违法 -->
            <c:if test="${entBasicInfo.entTypeCatg != '16' && entBasicInfo.entTypeCatg != '17' && entBasicInfo.entTypeCatg != '50'}">
                <li>|</li>
                <li
                        <c:if test="${classflag==5 }"> class="tab-selected"</c:if>
                ><a class="tab-item"
                    href="../../entinfo/illegalinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">列入严重违法失信企业名单信息</a>
                </li>
            </c:if>
            <li>|</li>
            <li
                    <c:if test="${classflag==6 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/nocreditpunishinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">失信联合惩戒信息</a>
            </li>
            <li>|</li>
            <li
                    <c:if test="${classflag==7 }"> class="tab-selected"</c:if>
            ><a class="tab-item"
                href="../../entinfo/favorableinfo?encryPriPID=${entBasicInfo.encryPriPID }&classFlag=${classFlag}">良好荣誉信息</a>
            </li>
        </ul>
    </div>
</div>
<div class="report-layer" id="sendPdfInfo" style="display: none;">
  <!--   <h3>发送报告</h3> -->
    <div class="content">
        <div class="title">请输入您的邮箱:</div>
        <div class="ipt-box">
            <input type="text" id="sendEmail" class="ipt-txt"/>
        </div>
        <div class="btn-box">
            <input type="button" value="确认" id="sureSend" class="btn mr20"/>
            <input type="button" value="取消" id="cancelSend" class="btn"/>
        </div>
    </div>
</div>

 


 
<div class="report-layer" id="_report-layer" style="display: none;height: 130px;width: 320px;" >
 
  <%-- <h3>
        信息分享
        <div class="close"></div>
    </h3>--%>
    <div class="jiathis_style_32x32" style="padding-left: 90px;padding-top: 36px;">
        <a class="jiathis_button_tsina"></a>
        <a class="jiathis_button_qzone"></a>
        <a class="jiathis_button_weixin"></a>
        <a class="jiathis_button_cqq"></a>
    </div>
</div>

