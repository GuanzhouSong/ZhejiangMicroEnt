<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/css/reg.server.css">
</head>
<body class="pd10">
<div>
    <div class="">
        <form class="form-horizontal" id="modapplication-form">
        	<table class="table-horizontal">
	            <tr>
	                <td width="20%" class="bg-gray right">生产经营单位名称:</td>
	                <td width="35%"> ${foodstorageInfo.entName } </td>
	                <td width="15%" class="bg-gray right">营业执照:</td>
	                <td width="30%"> ${foodstorageInfo.regNO }</td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">法定代表人（负责人）:</td>
	                <td width="35%">${foodstorageInfo.linkman }</td>
	                <td width="15%" class="bg-gray right">联系电话（手机）:</td>
	                <td width="30%">${foodstorageInfo.linktel }</td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">注册地址:</td>
	                <td width="80%" colspan="3">${foodstorageInfo.addr }</td>
                </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">仓库地址:</td>
	                 <td width="80%" colspan="3">${foodstorageInfo.wareAddr }</td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">仓储从业人员数量:</td>
	                <td width="35%">${foodstorageInfo.empNum }</td>
	                <td width="15%" class="bg-gray right">仓库面积（m2）:</td>
	                <td width="30%">${foodstorageInfo.opSpace }</td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">建筑类型:</td>
	                <td width="80%" colspan="3">
	                	<input type="checkbox" disabled="disabled" id="id_31">砖木结构
	                	<input type="checkbox" disabled="disabled" id="id_32">砖混结构
	                	<input type="checkbox" disabled="disabled" id="id_33">钢结构
	                	<input type="checkbox" disabled="disabled" id="id_34">钢筋混泥土结构
	                	<input type="checkbox" disabled="disabled" id="id_35">其它(<span id="id_span_35"></span>)
	                </td>
              	</tr>
	            <tr>
	                <td width="20%" class="bg-gray right">仓库类型:</td>
	                <td width="80%" colspan="3">
	                	<input type="checkbox" disabled="disabled" id="id_41">常温仓库
	                	<input type="checkbox" disabled="disabled" id="id_42">冷藏仓库
	                	<input type="checkbox" disabled="disabled" id="id_43">冷冻仓库
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">库存食品主要种类:</td>
	                <td width="80%" colspan="3">
	                	<input type="checkbox" disabled="disabled" id="id_1">1、粮食及粮食制品
	                	<input type="checkbox" disabled="disabled" id="id_2">2、脂肪、油及乳化脂肪制品
	                	<input type="checkbox" disabled="disabled" id="id_3">3、冷冻饮品
	                	<input type="checkbox" disabled="disabled" id="id_4">4、水果<br/>
	                	<input type="checkbox" disabled="disabled" id="id_5">5、蔬菜
	                	<input type="checkbox" disabled="disabled" id="id_6">6、食用菌和藻类 
	                	<input type="checkbox" disabled="disabled" id="id_7">7、豆类制品
	                	<input type="checkbox" disabled="disabled" id="id_8">8、坚果和籽类<br/>
						<input type="checkbox" disabled="disabled" id="id_9">9、可可制品、巧克力及制品
						<input type="checkbox" disabled="disabled" id="id_10">10、糖果制品
						<input type="checkbox" disabled="disabled" id="id_11">11、乳及乳制品<br/>
						<input type="checkbox" disabled="disabled" id="id_12">12、焙烤食品
						<input type="checkbox" disabled="disabled" id="id_13">13、肉及肉制品
						<input type="checkbox" disabled="disabled" id="id_14">14、水产及其制品
						<input type="checkbox" disabled="disabled" id="id_15">15、蛋及蛋制品<br/>
						<input type="checkbox" disabled="disabled" id="id_16">16、甜味料
						<input type="checkbox" disabled="disabled" id="id_17">17、调味品
						<input type="checkbox" disabled="disabled" id="id_18">18、特殊膳食用食品
						<input type="checkbox" disabled="disabled" id="id_18_1">18.1、婴幼儿配方食品<br/>
						<input type="checkbox" disabled="disabled" id="id_18_2">18.2、婴幼儿辅助食品
						<input type="checkbox" disabled="disabled" id="id_19">19、饮料类
						<input type="checkbox" disabled="disabled" id="id_20">20、酒类
						<input type="checkbox" disabled="disabled" id="id_21">21、茶叶、咖啡<br/>
						<input type="checkbox" disabled="disabled" id="id_22">22、食品添加剂
						<input type="checkbox" disabled="disabled" id="id_23">23、保健食品
						<input type="checkbox" disabled="disabled" id="id_24">24、超市（综合类）
						<input type="checkbox" disabled="disabled" id="id_25">25、其他类食品
	                </td>
	            </tr>
	            <tr>
	                <td width="20%" class="bg-gray right">运输车辆:</td>
	                <td width="80%" colspan="3">
	                	<input type="checkbox" disabled="disabled" id="id_51">普通运输车辆 (<input type="checkbox" disabled="disabled" id="id_own_51">自有,<input type="checkbox" disabled="disabled" id="id_hire_51">租赁,<input type="checkbox" disabled="disabled" id="id_other_51">其它 )<br/>
						<input type="checkbox" disabled="disabled" id="id_52">冷冻、冷藏车 (<input type="checkbox" disabled="disabled" id="id_own_52">自有,<input type="checkbox" disabled="disabled" id="id_hire_52">租赁,<input type="checkbox" disabled="disabled" id="id_other_52">其它 )<br/>
						<input type="checkbox" disabled="disabled" id="id_53">其他运输工具 (<span id="id_span_53"></span>) (<input type="checkbox" disabled="disabled" id="id_own_53">自有,<input type="checkbox" disabled="disabled" id="id_hire_53">租赁,<input type="checkbox" disabled="disabled" id="id_other_53">其它 )
	                </td>
	            </tr>
            </table>
            <c:forEach items="${foodstorageAuxList}" var="foodstorageAux" varStatus="status">
           		<input type="hidden" value="${foodstorageAux.code }" superCode="${foodstorageAux.supCode}" remark="${foodstorageAux.remark}" ownType="${foodstorageAux.ownType}" hireType="${foodstorageAux.hireType}" otherType="${foodstorageAux.otherType}" >
           	</c:forEach>
            <div class="center mt10">
                <button id="cancel" type="button" class="btn btn-primary">关闭</button>
            </div>
        </form>
    </div>
</div>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/foodstorageinfo/foodstorageinfo_edit_main.js"></script>
</body>
</html>