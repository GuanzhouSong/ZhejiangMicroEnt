<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="hx" uri="/WEB-INF/tld/hx.tld"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<link rel="stylesheet" href="/css/reg.server.css">
</head>
     
  
<!-- 公司基本信息 -->
<body id="printcon">
<form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${entBasicInfo.priPID }"/>
</form>
<div class="clearfix reg-company-basic reg-company-basic-yellowish">
    <div class="clearfix reg-caption">
        <div class="title clearfix">
    		<input type="hidden" id="repType" name="repType" value="${imReportType}">
            <input type="hidden" id="priPID" value="${priPID }">
            <span class="name fl mr5">${entBasicInfo.entName}</span>
            <span class="${hx:yReportStyle(entBasicInfo.regState)}">${hx:publicStatus(entBasicInfo.regState)}</span>
            <span class="icon-rectangle blue fl mr10">${entBasicInfo.isIndivid=='1'?'个转企':''}</span>

            <c:if test="${isOpanomaly=='1'}">
                <span class="icon-rectangle red fl mr10">被列入经营异常名录和严重违法失信（黑名单）</span>
            </c:if>

            <c:if test="${isOpanomaly=='2'}">
                <span class="icon-rectangle red fl mr10">被列入经营异常名录</span>
            </c:if>

            <c:if test="${isOpanomaly=='3'}">
                <span class="icon-rectangle red fl mr10">被列入严重违法失信（黑名单）</span>
            </c:if>

        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="book2-icon"></i>统一社会信用代码/注册号：<span>${!empty entBasicInfo.uniCode?entBasicInfo.uniCode:entBasicInfo.regNO}</span>
            </p>
            <p>
                <i class="local-icon"></i>登记机关：<span>${entBasicInfo.regOrgName}</span>
            </p>
        </div>
        <div class="clearfix">
            <p class="w360">
                <i class="person-icon"></i>
                <c:if test="${fn:indexOf('12,14,34,32,22,28,24,17,26', entBasicInfo.entTypeCatg)!=-1}">
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
                <span>${entBasicInfo.leRep}</span>
            </p>
            <p>
                <i class="government-icon"></i>管辖单位：<span>${entBasicInfo.localAdmName}</span>
            </p>
        </div>

        <div class="clearfix">
            <p class="w360">
                <i class="capital-icon"></i>注册资本：
                <span>
                    <c:if test="${!empty entBasicInfo.regCap}">
                        <fmt:formatNumber type="number"  value=" ${entBasicInfo.regCap }"  pattern="0.00" maxFractionDigits="2"/>(万元)
                    </c:if>
                </span>
            </p>
            <c:if test="${entBasicInfo.regState!='D'&&entBasicInfo.regState!='DX'}">
                <p><i class="date-icon"></i>成立日期：<span><fmt:formatDate value="${entBasicInfo.estDate}" dateStyle="long"/></span></p>
            </c:if>
        </div>

       <div class="clearfix">
           <c:if test="${entBasicInfo.regState=='D'}">
               <p class="w360">
                   <i class="date-icon"></i>吊销日期：<span><fmt:formatDate value="${entBasicInfo.altDate}" dateStyle="long"/></span>
               </p>
           </c:if>

           <c:if test="${entBasicInfo.regState=='DX'}">
               <p>
                   <i class="date-icon"></i> 注销日期：<span class="light"><fmt:formatDate value="${entBasicInfo.altDate}" dateStyle="long" /></span>
               </p>
           </c:if>
       </div>

       <div class="clearfix">
           <c:if test="${entBasicInfo.isIndivid=='1'}">
               <p>
                   <i class="date-icon"></i> 转企日期：<span class="light"><fmt:formatDate value="${entBasicInfo.individDate}" dateStyle="long"/></span>
               </p>
           </c:if>
           <p>
               <i></i>&nbsp;<span class="light">&nbsp;</span>
           </p>
       </div>

            <div class="btn-box">
                <div class="mb5 clearfix">
                    <a href="#" class="btn-print-box" style="width: 162px;" id="printbtn">
                        <i class="print-icon2"></i>
                        <span class="dy-report-bg">打印即时信息</span>
                    </a>
                </div>
                <div>
                    <a href="#" id="infoImport" class="btn-print-box" style="width: 162px;">
                        <i class="print-icon2"></i>
                        <span class="dy-reprot-zm">导出即时信息</span>
                    </a>
                </div>
            </div>
            
        <div class="supervise-about mt5 mb5">
            <div class="more js-fold reverse" style="cursor: pointer">展开详情<i></i></div>
        </div>
    </div>
    <c:if test="${erEscAppinfo.simplecanRea=='4'}">
        <div class="notice"><i class="notice-icon"></i>正在进行简易注销公告：公告期：<fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></div>
    </c:if>
</div>

<table cellpadding="0" cellspacing="0" border="0" class="table-horizontal  js-table-horizontal" style="display:none;">
    <tbody>
    <tr>
        <td class="bg-gray right" width="15%">类型</td>
        <td>${entBasicInfo.entTypeName}</td>
        <td class="bg-gray right">核准日期</td>
        <td><fmt:formatDate value="${entBasicInfo.apprDate}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">住所</td>
        <td>${entBasicInfo.dom}</td>
        <td class="bg-gray right">营业期限</td>
        <td><fmt:formatDate value="${entBasicInfo.opFrom}" dateStyle="long"/>至<fmt:formatDate value="${entBasicInfo.opTo}" dateStyle="long"/></td>
    </tr>
    <tr>
        <td class="bg-gray right">经营范围</td>
        <td colspan="3">${entBasicInfo.opScope}</td>
    </tr>
    </tbody>
</table>

<div class="light-info mt10">
    <div class="form-list light ">
        <div class="form-item clearfix">
            <div id="uniCode" class="col-4">
                <label class="right col-6">法定代表人（负责人）：</label>
                <div class="col-6">
                    <span id="leRep">${leRep}</span>  &nbsp;&nbsp;   <span id="tel">${tel}</span>
                </div>
            </div>
            <div class="col-4" >
                <label class="right col-6">工商联络员：</label>
                <div class="col-6">
                    <span id="liaName">${liaName}</span>  &nbsp;&nbsp;  <span id="liaTel">${liaTel}</span>
                </div>
            </div>
        </div>
    </div>
</div>
 
<c:if test="${entBasicInfo.entTypeCatg!=16&&entBasicInfo.entTypeCatg!=17&&entBasicInfo.entTypeCatg!=50}">
    <c:if test="${fn:indexOf(imReportType,'investment') != -1}">
        <!-- 股东及出资信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股东及出资信息

            </h3>
            <table class="table-common table-gudong-imme table-nest mb20" cellspacing="0" cellpadding="0">
                <thead>
                <tr>
                    <th width="8%">股东</th>
                    <th width="8%">认缴额(万元)</th>
                    <th width="8%">实缴额(万元)</th>
                    <th valign="top" width="38%">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table-common">
                            <tr>
                                <td colspan="4">认缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">认缴<br/>出资方式</td>
                                <td width="22%">认缴出资额<br/>（万元）</td>
                                <td width="32%">认缴<br/>出资日期</td>
                                <td>公示日期</td>
                            </tr>
                        </table>
                    </th>
                    <th valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table-common">
                            <tr>
                                <td colspan="4">实缴明细</td>
                            </tr>
                            <tr>
                                <td width="28%">实缴出资方式</td>
                                <td width="22%">实缴出资额<br/>（万元）</td>
                                <td width="32%">实缴<br/>出资日期</td>
                                <td>公示日期</td>
                            </tr>
                        </table>
                    </th>
                    <th>查看</th>
                </tr>
                </thead>
                <tbody id="investment">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="investmentCount">0</em> 条信息，共 <em id="investmentPageCount">0</em> 页</span>
                <div id="pageinvestment" class="pagination">
                    <a href="javascript:void(0)" class="prev disabled">首页</a><a
                        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                        href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                        class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                               class="prev disabled">末页</a>
                </div>
            </div>
            <script id="investment-template" type="text/x-handlebars-template">
                {{#each data}}
                <tr>
                    <td>{{inv}}</td>
                    <td>{{liSubConAm}}</td>
                    <td>{{liAcConAm}}</td>
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                            <tbody> {{#with imInvprodetailList}} {{#each this}}
                            <tr>
                                <td width="28%">{{conFormCN}}</td>
                                <td width="22%">{{subConAm}}</td>
                                <td width="32%">{{transDate conDate}}</td>
                                <td>{{transDate publicDate}}</td>
                            </tr>
                            {{/each}} {{/with}}
                            </tbody>
                        </table>
                    </td>
                    <td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="inner-table">
                            <tbody> {{#with imInvactdetailList}} {{#each this}}
                            <tr>
                                <td width="28%">{{acConFormCn}}</td>
                                <td width="22%">{{acConAm}}</td>
                                <td width="32%">{{transDate conDate}}</td>
                                <td>{{transDate publicDate}}</td>
                            </tr>
                            {{/each}} {{/with}}
                            </tbody>
                        </table>
                    </td>
                    <td><a id={{invID}} href="javascript:void(0)" class="showInvesment">查看</a></td>
                </tr>


                {{/each}}
            </script>
        </div>
    </c:if>
    <c:if test="${fn:indexOf(imReportType,'invsralt') != -1}">
        <!-- 股权变更信息 -->
        <div class="mod-bd-panel_company">
            <h3 class="i-title">
                <i></i>股权变更信息
            </h3>
            <table class="table-common mb20">
                <thead>
                <tr>
                    <th width="80">序号</th>
                    <th width="200">股东</th>
                    <th width="200">变更前股权比例</th>
                    <th width="170">变更后股权比例</th>
                    <th width="150">股权变更日期</th>
                    <th>公示日期</th>
                    <th>查看</th>
                </tr>
                </thead>
                <tbody id="invsral">
                </tbody>
            </table>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="invsralCount">0</em> 条信息，共 <em
                        id="invsralPageCount">0</em> 页</span>
                <div id="paginvsral" class="pagination">
                    <a href="javascript:void(0)" class="prev disabled">首页</a><a
                        href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                        href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                        class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                               class="prev disabled">末页</a>
                </div>
            </div>
            <script id="invsral-template" type="text/x-handlebars-template">
                {{#each data}}
                <tr>
                    <td>{{addOne @index}}</td>
                    <td> {{inv}}</td>
                    <td> {{beTransAmPr}}%</td>
                    <td> {{afTransAmPr}}%</td>
                    <td> {{transDate equAltDate}}</td>
                    <td> {{dataFormat publicDate}}</td>
                    <td><a id={{invAltID}} title="{{priPID}}" href="javascript:void(0)" class="showInvsral">查看</a></td>
                </tr>
                {{/each}}
            </script>
        </div>
    </c:if>
    <!-- 行政许可信息 -->
    <div class="mod-bd-panel_company">
        <h3 class="i-title">
            <i></i>行政许可信息
        </h3>
        <table class="table-common table-xuke mb20">
            <thead>
            <tr>
                <th width="40">序号</th>
                <th width="130">许可文件编号</th>
                <th width="120">许可文件名称</th>
                <th width="110">有效期自</th>
                <th width="110">有效期至</th>
                <th width="170">许可机关</th>
                <th width="140">许可内容</th>
                <th width="50">状态</th>
                <th>详情</th>
            </tr>
            </thead>
            <tbody id="permit">
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
            <span class="page-total">共查询到 <em id="permitCount">0</em>  条信息，共 <em id="permitPageCount">0</em> 页</span>
            <div id="pagepermit" class="pagination">
                <a href="javascript:void(0)" class="prev disabled">首页</a><a
                    href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                    href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                    class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                           class="prev disabled">末页</a>

            </div>
        </div>
        <script id="permit-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
                <td> {{licNO}}</td>
                <td>{{licNameCN}}</td>
                <td>{{transDate valFrom}}</td>
                <td> {{transDate valTo}}</td>
                <td>{{licAnth}}</td>
                <td>{{licItem}}</td>
                <td>{{transPubType pubFlag}}</td>
                <td><a href="javascript:void(0)" id="{{licID}}" title="{{priPID}}" class="showPermit">查看</a></td>
            </tr>
            {{/each}}
        </script>
    </div>
    <!-- 知识产权出质登记信息 -->
    <div class="mod-bd-panel_company">
        <h3 class="i-title">
            <i></i>知识产权出质登记信息
        </h3>
        <table class="table-common mb20">
            <thead>
            <tr>
                <th width="35">序号</th>
                <th width="140">知识产权登记证号</th>
                <th width="80">名称</th>
                <th width="70">种类</th>
                <th width="92">出质人名称</th>
                <th width="92">质权人名称</th>
                <th width="230">质权登记期限</th>
                <th width="35">状态</th>
                <th width="100">公示日期</th>
                <th>详情</th>
            </tr>
            </thead>
            <tbody id="ippldg">
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
            <span class="page-total">共查询到 <em id="ippldgCount">0</em> 条信息，共 <em id="ippldgPageCount">0</em> 页</span>
            <div id="pageippldg" class="pagination">
                <a href="javascript:void(0)" class="prev disabled">首页</a><a
                    href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                    href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                    class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                           class="prev disabled">末页</a>
            </div>
        </div>
        <script id="ippldg-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{addOne @index}}</td>
                <td>
                    {{tmregNo}}
                </td>
                <td>{{tmname}}</td>
                <td>{{transkinds kinds}}</td>
                <td> {{pledgor}}</td>
                <td>{{impOrg}}</td>
                <td>{{transDate pleRegPerFrom}}-{{transDate pleRegPerTo}}</td>
                <td>{{transType pubType}}</td>
                <td>{{dataFormat publicDate}}</td>
                <td><a id={{pleID}} href="javascript:void(0)" title="{{priPID}}" class="showIppldg">查看</a></td>
            </tr>
            {{/each}}
        </script>
    </div>
    <!-- 行政处罚信息 -->
    <div class="mod-bd-panel_company">
        <h3 class="i-title">
            <i></i>行政处罚信息
        </h3>
        <table class="table-common table-chufa mb20">
            <thead>
            <tr>
                <th width="35">序号</th>
                <th width="155">决定书文号</th>
                <th width="155">违法行为类型</th>
                <th width="130">行政处罚内容</th>
                <th width="155">决定机关名称</th>
                <th width="110">处罚决定日期</th>
                <th width="110">公示日期</th>
                <th>备注</th>
                <th>查看</th>
            </tr>
            </thead>
            <tbody id="case">
            </tbody>
        </table>
        <div class="notice-pagination-box clearfix">
            <span class="page-total">共查询到 <em id="caseCount">0</em> 条信息，共 <em id="casePageCount">0</em> 页</span>
            <div id="pagecase" class="pagination">
                <a href="javascript:void(0)" class="prev disabled">首页</a><a
                    href="javascript:void(0)" class="prev"><i class="icon-triangle-left"></i>上一页</a><a
                    href="javascript:void(0)">1</a><a href="javascript:void(0)" class="next">下一页<i
                    class="icon-triangle-right"></i></a><a href="javascript:void(0)"
                                                           class="prev disabled">末页</a>
            </div>
        </div>
        <script id="case-template" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td> {{addOne @index}}</td>
                <td>{{penDecNo}}</td>
                <td>{{illegActType}}</td>
                <td>{{penContent}}</td>
                <td>{{judAuth}}</td>
                <td>{{transDate penDecIssDate}}</td>
                <td>{{dataFormat publicDate}}</td>

                <td rowspan="">{{transType pubType}}</td>
                <td><a id={{caseNO}} href="javascript:void(0)" title="{{priPID}}" class="showCase">查看</a></td>
            </tr>
            <tr style="{{dataList caslatList}}">
                <td colspan="8" class="tip2">
                    <div class="fl">有变更情形：</div>
                    <div class="fl">
                        {{#with caslatList}}
                        {{#each this}}
                        <p>{{addOne @index}}.{{dataFormat altDate}}{{penAuthName}}将{{penContent}}。</p>
                        {{/each}}
                        {{/with}}
                    </div>
                </td>

            </tr>

            {{/each}}
        </script>
    </div>
</c:if>


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


<div class="report-layer" id="_report-layer" style="display: none;height: 130px;width: 320px;">

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
</body>
<script>
    //参数的传递
    window._CONFIG = {
        repType: '${imReportType}',

    }
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/iminfo/iminfo_main.js"></script>
<script src="/js/reg/server/iminfo/infoprint.js"></script>
</html>
