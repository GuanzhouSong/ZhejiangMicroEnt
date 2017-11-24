<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>公告详情</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/> 
</head>
<body> 
<div class="mod info-title">
    <h5 class="pdt20 center">${erEscAppinfo.entName }</h5>
    <a href="objectionApply?encryPriPID=${erEscAppinfo.encryPriPID }" class="wycomplain" target="_blank">我要异议</a>
    <br>
</div>
<div class="mod">
    <form id="params">
        <input type="hidden" name="priPID" id="priPID" value="${erEscAppinfo.priPID }"/>
    </form>
    <div class="mod-bd">
        <div class="title title-inner">
            <h3>企业公告信息</h3>
        </div>
        <div class="content">
            <table class="table-public">
                <tbody>
                <tr>
                    <td width="480">
                        <div class="item-name w160"><em>• </em>企业名称：</div>
                        <div class="item-txt">
	                        ${erEscAppinfo.entName }
                        </div>
                    </td>
                    <td width="480">
                        <div class="item-name"><em>• </em>统一社会信用代码/注册号：</div>
                        <div class="item-txt">${(!empty erEscAppinfo.uniSCID)?erEscAppinfo.uniSCID:erEscAppinfo.regNO}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w160"><em>• </em>登记机关：</div>
                        <div class="item-txt">${erEscAppinfo.regOrgName }</div>
                    </td>
                    <td>
                        <div class="item-name"><em>• </em>公告期：</div>
                        <div class="item-txt"><fmt:formatDate value="${erEscAppinfo.noticeFrom}" pattern="yyyy年MM月dd日"/>-<fmt:formatDate value="${erEscAppinfo.noticeTo}" pattern="yyyy年MM月dd日"/></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="item-name w160"><em>• </em>全体投资人承诺书：</div>
                        <div class="item-txt"><a href="findLetter?encryPriPID=${erEscAppinfo.encryPriPID}" class="light-yellow" target="_blank">查看详情</a></div>
                    </td>
                    <td>
                        <div class="item-name w160"><em></em></div>
                        <div class="item-txt"></div>
                    </td>
                </tr>  
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>异议信息</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table id="erescobjinfo-table" class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                     <thead>
                     <tr>
                        <th width="90">序号</th>
                        <th>异议申请人</th>
                        <th>异议内容</th>
                        <th>异议时间</th>
                     </tr>
                     </thead>
                     <tbody id="table-objection">
                      	 
                	 </tbody>
                </table>
                <div class="notice-pagination-box clearfix">
	                <span class="page-total">共查询到 <em id="_total_objection"></em> 条信息，共 <em id="_pageNum_objection"></em> 页</span>
	                <div id="pagination_objection" class="pagination">
	                </div>
                </div>
            </div>
            <script id="table-template-objection" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{name}}</td>
                <td>{{{transCN objection}}}</td>
                <td>{{objapptime}}</td>
            </tr>
            {{/each}}
        </script>
        </div> 
    </div>
</div>
  

<div class="mod">
    <div class="mod-bd">
        <div class="title">
            <h3>简易注销结果</h3>
        </div>
        <div class="content">
            <div style="overflow-y: auto;overflow-x: hidden;">
                <table class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th width="118">序号</th>
                        <th width="150">简易注销结果</th>
                        <th width="80">公告申请日期</th> 
                    </tr>
                    </thead>
                    <tbody id="table-scrinfo">
	                      
                	</tbody>
                </table>
                <div class="notice-pagination-box clearfix">
	                <span class="page-total">共查询到 <em id="_total_scrinfo"></em> 条信息，共 <em id="_pageNum_scrinfo"></em> 页</span>
	                <div id="pagination_scrinfo" class="pagination">
	                </div>
	            </div>
            </div>
              <script id="table-template-scrinfo" type="text/x-handlebars-template">
            {{#each data}}
            <tr>
                <td>{{xh @index}}</td>
                <td>{{simplecanReaName}}</td>
                <td>{{apprDate}}</td>
            </tr>
            {{/each}}
            </script>
        </div>
    </div>
</div>
  
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/syn/system/simpleesc/objection_detail_main.js"/>"></script>
<script>
    window._CONFIG = {
    		 _sysUrl:'${sysUrl}'
     }
</script>
</body>
</html>
