<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>异议申请</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reg.client.css"/>"/>
</head>
<body>
<jsp:include page="../../common/header.jsp"></jsp:include>
<div class="banner-bg">
    <div class="mod banner">
        <h4>欢迎您！${midBaseInfoDto.entName}</h4>
        <p>
        	<em class="register-office">登记机关：${midBaseInfoDto.regOrgName}</em>
        	<c:if test="${!empty midBaseInfoDto.uniCode}"><em>统一社会信用代码：${midBaseInfoDto.uniCode}</em></c:if>
            <em>注册号：${midBaseInfoDto.regNO}</em>
        </p>
        <p>
            <em class="register-office">法定代表人/负责人：${midBaseInfoDto.leRep}</em>
            <em>成立日期：<fmt:formatDate value="${midBaseInfoDto.estDate}" dateStyle="long"/></em>
            <c:if test="${!empty midBaseInfoDto.regCap}">
                <em>注册资本：<fmt:formatNumber type="number"  value=" ${midBaseInfoDto.regCap }"  pattern="0.00" maxFractionDigits="2"/>万${midBaseInfoDto.currencyCn}</em>
            </c:if>
        </p>
    </div>
</div>
<div class="mod">
 <input type="hidden" name="pageyear" id="pageyear" value="${year}">
 <input type="hidden" name="page" id="page">
    <div class="mod-hd">
        <div class="title">
            <h3>异议申请列表</h3>
        </div>
    </div>
     <div class="mod-hd">
        <div class="title">
            <a href="javascript:void(0)"  class="btn-common btn-add addConsult" >新增</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         	   反馈状态:
            <select name="state" id="state" class="ipt-txt ipt-txt-lg pbReport">
                            <option value="" selected="">全部</option>
                            <option value="0">未反馈</option>
                            <option value="1">已反馈</option>
             </select>
             &nbsp;&nbsp;&nbsp;&nbsp;
           	 异议内容/标题:
            <input type="text" name="title_content" id="title_content" value="" class="ipt-txt ipt-txt-lg pbReport" placeholder="请输入异议内容/标题">
        	 <a href="javascript:void(0)"  class="btn-common btn-add searchConsult" >查询</a>
        </div> 
    </div>
    <div class="mod-bd"> 
        <div class="content content-contact">
            <div class="content-sm-height">
                <table id="hisreport_table" class="table-public table-web" border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <tr>
                        <th class="bg" >序号</th>
                        <th class="bg" >反馈状态</th>
                        <th class="bg" >标题</th>
                        <th class="bg">异议内容</th>
                        <th class="bg" >申请日期</th>
                        <!-- <th class="bg">咨询人</th>
                        <th class="bg">咨询人联系电话</th> --> 
                        <th class="bg" >反馈人</th>
                        <th class="bg" >反馈内容</th>
                        <th class="bg" >反馈日期</th>
                        <th class="bg">反馈部门</th>
                        <th class="bg">操作</th>
                    </tr>
                    </thead>
                     <tbody id="tplPage">
                 
                
                     </tbody>
                </table>
            </div>
            <div class="notice-pagination-box clearfix">
                <span class="page-total">共查询到 <em id="itemCount">0</em> 条信息，共<em id="pageCount">0</em>页</span>
                <div id="pagination_one" class="pagination">

                </div>
            </div>
        </div>
    </div>
</div>
<script id="table-template" type="text/x-handlebars-template">
    {{#each data}}  
            <tr>
                    <td>{{xh @index}}</td>
                    <td>{{stateFormat  state}}</td>
                    <td>{{{consultTitleFormat this}}}</td> 
					<td>{{{consultContentFormat this}}}</td>
					<td>{{consultTime}}</td> 
					<td>{{backName}}</td>
					<td>{{{backContentFormat this}}}</td> 
					<td>{{backTime}}</td>
					<td>{{{backDeptFormat this}}}</td>
					<td>{{{stateXDEFormat this}}}</td> 
            </tr> 
    {{/each}} 
</script>
<script src="<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>"></script>
<script src="<c:url value="/js/component/dropDown.js"/>"></script>
<script src="<c:url value="/js/lib/require.js"/>"></script>
<script src="<c:url value="/js/config.js"/>"></script>
<script src="<c:url value="/js/reg/client/yr/consult/consult_list_main.js"/>"></script>
 <script>
    window._CONFIG = {
       _year:'${year}', //年报年度
       _pripid:'${pripid}'  //主体代码  
    }
</script>
</body>
</html>