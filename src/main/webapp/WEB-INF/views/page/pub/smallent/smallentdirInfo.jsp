<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="renderer" content="webkit">
	<meta charset="utf-8">
	<title>小微企业名录</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/smallent/main.css"/>"/>
	<!--[if lte IE 6]>
	<script src="js/smallent/iepng2.js" type="text/javascript"></script>
	<![endif]-->
</head>
<body class="bg">
<div id="header">
  <h1 style="background:url(http://gsxt.saic.gov.cn/xwqy/images/logo33.png) no-repeat left center;">小微企业名录</h1>
</div>
<div id="nav">
  <dl>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home?df=33">首页</a></dt>
    <dd>|</dd>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home/mirco/info_list?channelId=2200&organId=33">扶持政策集中公示</a></dt>
    <dd>|</dd>
    <dt><a href="http://gsxt.saic.gov.cn/xwqy/home/mirco/info_list?channelId=2300&organId=33">申请扶持政策导航</a></dt>
    <dd>|</dd>
    <dt><a href="javascript:void(0)" onclick="toSmallEntEnjSp()" >企业享受扶持信息公示</a></dt>
    <dd>|</dd>
    <dt class="current"><a href="javascript:void(0)" onclick="toSmallEntDirhtml()">小微企业库</a></dt>
  </dl>
</div>
<div class="location">当前位置：首页 &gt; 小微企业库</div>
<div class="wrap clear">
  <div class="tbShadow1">
    <table cellspacing="0" cellpadding="0" class="tbEile">
      <caption>
      基本信息
      </caption>
      <c:if test="${smBaseInfo.entTypeCatg =='50'}">
           <!--个体户 -->
		    <tr>
	        <th width="20%">企业名称：</th>
	        <td width="32%">${smBaseInfo.entName}</td>
	        <th>注册号：</th>
	        <td>${smBaseInfo.regNO}</td>
	      </tr>
	      <tr>
	      	<th>企业类型：</th>
	        <td>${smBaseInfo.entTypeCatgDesc}</td>
	        <th>注册日期：</th>
	        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
	      </tr>
	      <tr>
	        <th>登记机关：</th>
	        <td>${smBaseInfo.regOrgDesc}</td>
	        <th>所属门类：</th>
	        <td>${smBaseInfo.industryMlDesc}</td>
	      </tr>
	      <tr>
	        <th>行业代码：</th>
	        <td>${smBaseInfo.industryCo}&nbsp;</td>
	        <th>资金数额：</th>
	        <td>${smBaseInfo.regCap}万元</td>
	      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='11' }">
<!--       内资公司法人 -->
	      <tr>
	        <th width="20%">企业名称：</th>
	        <td width="32%">${smBaseInfo.entName}</td>
	        <th>注册号：</th>
	        <td>${smBaseInfo.regNO}</td>
	      </tr>
	      <tr>
	      	<th>企业类型：</th>
	        <td>${smBaseInfo.entTypeCatgDesc}</td>
	        <th>成立日期：</th>
	        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
	      </tr>
	      <tr>
	        
	        <th>注册资本：</th>
	        <td>${smBaseInfo.regCap}万元</td>
	        <th>登记机关：</th>
	        <td>${smBaseInfo.regOrgDesc}</td>
	      </tr>
	      <tr>
	        <th>所属门类：</th>
	        <td>${smBaseInfo.industryMlDesc}</td>
	        <th>行业代码：</th>
	        <td>${smBaseInfo.industryCo}&nbsp;</td>
	      </tr>
      </c:if>
        <c:if test="${smBaseInfo.entTypeCatg =='14' }">
<!--       		内资非法人企业 -->
		      <tr>
		        <th width="20%">企业名称：</th>
		        <td width="32%">${smBaseInfo.entName}</td>
		        <th>注册号：</th>
		        <td>${smBaseInfo.regNO}</td>
		      </tr>
		      <tr>
		      	<th>企业类型：</th>
		        <td>${smBaseInfo.entTypeCatgDesc}</td>
		        <th>成立日期：</th>
		        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
		      </tr>
		      <tr>
		        <th>登记机关：</th>
		        <td>${smBaseInfo.regOrgDesc}</td>
		        <th>所属门类：</th>
		        <td>${smBaseInfo.industryMlDesc}</td>
		      </tr>
		      <tr>
		        <th>行业代码：</th>
		        <td>${smBaseInfo.industryCo}&nbsp;</td>
		        <th>出资额：</th>
		        <td>${smBaseInfo.regCap}万元</td>
		      </tr>
	      </c:if>
        <c:if test="${smBaseInfo.entTypeCatg =='12' }">
<!-- 	      内资分公司 -->
		      <tr>
	        <th width="20%">企业名称：</th>
	        <td width="32%">${smBaseInfo.entName}</td>
	        <th>注册号：</th>
	        <td>${smBaseInfo.regNO}</td>
	      </tr>
	      <tr>
	      	<th>企业类型：</th>
	        <td>${smBaseInfo.entTypeCatgDesc}</td>
	        <th>成立日期：</th>
	        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
	      </tr>
	      <tr>
	        <th>登记机关：</th>
	        <td>${smBaseInfo.regOrgDesc}</td>
	        <th>所属门类：</th>
	        <td>${smBaseInfo.industryMlDesc}</td>
	      </tr>
	      <tr>
	        <th>行业代码：</th>
	        <td>${smBaseInfo.industryCo}&nbsp;</td>
	      </tr>
      </c:if>
        <c:if test="${smBaseInfo.entTypeCatg =='21' }">
<!--       		外商公司法人 -->
		     <tr>
		        <th width="20%">企业名称：</th>
		        <td width="32%">${smBaseInfo.entName}</td>
		        <th>注册号：</th>
		        <td>${smBaseInfo.regNO}</td>
		      </tr>
		      <tr>
		      	<th>企业类型：</th>
		        <td>${smBaseInfo.entTypeCatgDesc}</td>
		        <th>成立日期：</th>
		        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
		      </tr>
		      <tr>
		        <th>登记机关：</th>
		        <td>${smBaseInfo.regOrgDesc}</td>
		        <th>所属门类：</th>
		        <td>${smBaseInfo.industryMlDesc}</td>
		      </tr>
		      <tr>
		        <th>行业代码：</th>
		        <td>${smBaseInfo.industryCo}&nbsp;</td>
		      </tr>
        </c:if>
        <c:if test="${smBaseInfo.entTypeCatg =='28' }">
        <!-- 外商投资合伙企业分支机构 -->
	   <tr>
        <th width="20%">企业名称：</th>
        <td width="32%">${smBaseInfo.entName}</td>
        <th>注册号：</th>
        <td>${smBaseInfo.regNO}</td>
      </tr>
      <tr>
      	<th>企业类型：</th>
        <td>${smBaseInfo.entTypeCatgDesc}</td>
        <th>成立日期：</th>
        <td><fmt:formatDate value="${smBaseInfo.estDate}" pattern="yyyy-MM-dd" /></td>
      </tr>
      <tr>
        <th>登记机关：</th>
        <td>${smBaseInfo.regOrgDesc}</td>
        <th>所属门类：</th>
        <td>${smBaseInfo.industryMlDesc}</td>
      </tr>
      <tr>
        <th>行业代码：</th>
        <td>${smBaseInfo.industryCo}&nbsp;</td>
      </tr>
      </c:if>
    </table>
  </div>
  <div class="tbShadow2">
    <table cellspacing="0" cellpadding="0" class="tbEile">
      <caption>
      企业年报信息
      </caption>
      <c:if test="${smBaseInfo.entTypeCatg == '11'}">
	       <!-- 内资公司法人--> 
	      <tr>
	        <th width="60" class="center">序号</th>
	        <th class="center">年报年度</th>
	        <th class="center">资产总额</th>
	        <th class="center">其中主营业收入</th>
	        <th class="center">从业人数</th>
	      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='50'}">
      <!-- 个体户-->
      <tr>
        <th width="60" class="center">序号</th>
        <th class="center">年报年度</th>
        <th class="center">资金数额</th>
        <th class="center">销售（营业）收入</th>
        <th class="center">从业人数</th>
      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='14'}">
      <!-- 内资非法人企业-->
      <tr>
        <th width="60" class="center">序号</th>
        <th class="center">年报年度</th>
        <th class="center">资产总额</th>
        <th class="center">其中主营业收入</th>
        <th class="center">从业人数</th>
      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='12'}">
      <!-- 内资分公司-->
      <tr>
        <th width="60" class="center">序号</th>
        <th class="center">年报年度</th>
        <th class="center">资产总额</th>
        <th class="center">其中主营业收入</th>
        <th class="center">从业人数</th>
      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='21'}">
      <!-- 外商公司法人-->
      <tr>
        <th width="60" class="center">序号</th>
        <th class="center">年报年度</th>
        <th class="center">资产总额</th>
        <th class="center">其中主营业收入</th>
        <th class="center">从业人数</th>
      </tr>
      </c:if>
      <c:if test="${smBaseInfo.entTypeCatg =='28'}">
      <!-- 外商投资合伙企业分支机构-->
      <tr>
        <th width="60" class="center">序号</th>
        <th class="center">年报年度</th>
        <th class="center">营业收入</th>
        <th class="center">从业人数</th>
      </tr>
      </c:if>   
    </table>
  </div>
  <br><br><br>
</div>
<div id="footer">
  <ul>
    <li>版权所有：浙江省工商行政管理局 &nbsp; 地址：杭州市莫干山路77号金汇大厦北门&nbsp;</li>
    <li>业务咨询电话：400-888-4636&nbsp;&nbsp; 技术支持电话：400-888-4636&nbsp;&nbsp;邮政编码：310005</li>
  </ul>
</div>
<script type="text/javascript">
function toSmallEntEnjSp(){
	 window.location.href="/pub/smallentsupport/index";
}
function toSmallEntDirhtml(){
	 window.location.href="/pub/smallentdir/index";
}
</script>
</body>
</html>