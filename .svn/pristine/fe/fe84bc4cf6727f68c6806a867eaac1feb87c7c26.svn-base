<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <title>加入培育库详细</title>
</head>
<body>
	<div> 
		<div style="margin:5px"><span class="light" >*注：如选择多家企业，企业类型信息将填写为一样。</span></div>
		<form id="webForm">
			<input type="hidden" id="priPIDs" name="priPIDs">
			<input type="hidden" id="cultivationTypeName" name="cultivationTypeName">
			<input type="hidden" id="industryName" name="industryName">
			<input type="hidden" id="entCrowdName" name="entCrowdName">
			<input type="hidden" id="tsxz" name="tsxz" >
			<input type="hidden" id="zckj" name="zckj" >
			<input type="hidden" id="kjfhy" name="kjfhy" >
			<input type="hidden" id="kjdsy" name="kjdsy" >
			<input type="hidden" id="qt" name="qt" >
			<table class="table-horizontal">
		        <tr>
	               <td rowspan="7" class="bg-gray ft14 center" width="10%">企业类型</td>
	               <td colspan="2" class="bg-gray ft14 center"  width="20%">培育库类型</td>
	               <td width="70%">
	               		<input type="radio" name="cultivationTypeCode" checked="checked" value="1"/><label class="mr20">初创型</label>
	               		<input type="radio" name="cultivationTypeCode" value="2"/><label class="mr20">成长型</label>
	               		<input type="radio" name="cultivationTypeCode" value="3"/><label class="mr20">领军型</label>
	               	</td>
		        </tr>
		        <tr>
		        	
		        	<td colspan="2" class="bg-gray ft14 center">八大重点产业</td>
		        	<td>
	        			<input type="checkbox"  name="industryType" value="1"/><label class="mr20">信息</label>
	        			<input type="checkbox"  name="industryType" value="2"/><label class="mr20" for="">环保</label>
	        			<input type="checkbox"  name="industryType" value="3"/><label class="mr20" for="">健康</label>
	        			<input type="checkbox"  name="industryType" value="4"/><label class="mr20" for="">旅游</label>
	        			<input type="checkbox"  name="industryType" value="5"/><label class="mr20" for="">时尚</label>
	        			<input type="checkbox"  name="industryType" value="6"/><label class="mr20" for="">金融</label>
	        			<input type="checkbox"  name="industryType" value="7"/><label class="mr20" for="">高端装备制造</label>
	        			<input type="checkbox"  name="industryType" value="8"/><label class="mr20" for="">文化创意产业</label>
		        	</td>
		        </tr>
		        <tr>
		        	<td rowspan="5" class="bg-gray ft14 center" width="10%">区域类型<br/><br/><input type="button" class="btn btn-info" id="btn_wh" value="维护" /></td>
		        	<td class="bg-gray2 center" width="10%"><input type="button" class="btn btn-info" id="btn_tsxz" value="特色小镇" /></td>
		        	<td><div><input class="t-fill" type="text" id="tsxzName"   value="" readonly="readonly" ></div></td>
		        </tr>
		        <tr>
		        	<td class=" bg-gray2 center"><input type="button" class="btn btn-info" id="btn_zckj" value="众创空间" /></td>
		        	<td><input class="t-fill" type="text" id="zckjName"   value="" readonly="readonly" ></td>
		        </tr>
		        <tr>
		        	<td class="bg-gray2 center"><input type="button" class="btn btn-info" id="btn_kjfhy" value="科技孵化园" /></td>
		        	<td><input class="t-fill" type="text" id="kjfhyName"   value="" readonly="readonly" ></td>
		        </tr>
		        <tr>
		        	<td class="bg-gray2 center"><input type="button" class="btn btn-info" id="btn_kjdsy" value="跨境电商园" /></td>
		        	<td><input class="t-fill" type="text" id="kjdsyName" value="" readonly="readonly" ></td>
		        </tr>
		        <tr>
		        	<td class="bg-gray2 center"><input type="button" class="btn btn-info" id="btn_qt" value="其他" /></td>
		        	<td><input class="t-fill" type="text" id="qtName"   value="" readonly="readonly" ></td>
		        </tr>
		        <tr>
	               <td class="bg-gray ft14 center" width="10%"><div>创业人群</div></td>
	               <td colspan="3"width="90%">
	               	<input class="mr20" type="checkbox" id="entCrowdCode_xs" name="entCrowdCode" value="1"/><label for="xs" class="mr20">大学生</label>
	               	<input style="margin-left:20px;" type="checkbox" id="entCrowdCode_gx" name="entCrowdCode" value="2"/><label for="gx" class="mr20">高校、科研院所科技人员</label>
	               	<input style="margin-left:20px;" type="checkbox" id="entCrowdCode_hw" name="entCrowdCode" value="3"/><label for="hw" class="mr20">海外高层次人才</label>
	               	<input style="margin-left:20px;" type="checkbox" id="entCrowdCode_qt" name="entCrowdCode" value="4"/><label for="qt" class="mr20">其他</label><input id="entCrowdText" name="entCrowdText" type="text" maxlength="100"  disabled="disabled" class="ipt-txt" >
	               </td>                     
		        </tr>
		    </table>
		    
		    <div class="center  mt10 ">
	            <input type="button" class="btn btn-info" style="margin-right:100px" id="save" value="保存" />
	            <input type="button" class="btn " id="cancel" value="关闭" />
	       </div>
       </form>
	</div>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_edit.js"></script>
</body>
</html>