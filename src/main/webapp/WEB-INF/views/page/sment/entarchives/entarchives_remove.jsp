<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
    <title>加入培育库详细</title>
</head>
<body>
	<div> 
		<form id="webForm">
			<input type="hidden" id="uid" name="UID">
			<input type="hidden" id="priPID" name="priPID">
			<input type="hidden" id="priPIDs" name="priPIDs">
			<input type="hidden" id="adjustTypeName" name="adjustTypeName">
			<input type="hidden" id="adjustUserId" name="adjustUserId">
			<input type="hidden" id="adjustDeptId" name="adjustDeptId">
			<input type="hidden" id="adjustDeptName" name="adjustDeptName">
			<div class="mb20 mt10"><h1 style="margin:0 auto; width:300px"">小微企业成长培育档案</h1></div>
			<table class="table-horizontal mb20" >
				 <tr>
	               <td class="bg-gray ft14 center" width="12%">企业名称</td>
	               <td colspan="3" width="40%"><span id="entName" ></span> </td>
	               <td class="bg-gray ft14 center" width="12%">所属行业</td>
	               <td ><span id="industryCoName" width="12%"></span></td>
	               <td class="bg-gray ft14 center" width="12%">成立日期</td>
	               <td width="12%"><span id="estDate" ></span></td>
		        </tr>
		        <tr>
	              <td class="bg-gray ft14 center">邮编</td>
	               <td colspan="2"><span id="postalCode" ></span></td>
	               <td class="bg-gray ft14 center">企业地址</td>
	               <td colspan="4"><span id="dom" ></span></td>
		        </tr>
		         <tr>
	               <td class="bg-gray ft14 center" width="12%">企业负责人</td>
	               <td width="12%"><span id="entPrincipal" ></span></td>
	               <td class="bg-gray ft14 center" width="12%">联系电话</td>
	               <td width="12%"><span id="entPrincipalTel"></span></td>
	               <td class="bg-gray ft14 center" width="12%">企业联络人</td>
	               <td width="12%"><span id="entContact"></span></td>
	               <td class="bg-gray ft14 center" width="12%">联系电话</td>
	               <td width="12%"><span id="entContactTel" ></span></td>
		        </tr>
		    </table>
			<div class="gold">
				<i id="i_pykjbxx" class="flex-icon dib2 va-3 flexed-icon"></i>
				<h6 class="add-title dib2">培育库信息</h6>
			</div>
			<table class="table-horizontal mb20 pykjbxx" style="display: none" cellpadding="0" cellspacing="0" border="0">
		        <tr>
	               <td class="bg-gray ft14 center" rowspan="4" width="10%">企业类型</td>
	               <td class="bg-gray ft14 center" colspan="2" width="20%">培育库类型</td>
	               <td width="70%">
	               		<span id="cultivationTypeName"></span>
	               	</td>
		        </tr>
		        <tr>
		        	
		        	<td class="bg-gray ft14 center" colspan="2">八大重点产业</td>
		        	<td>
		        		<span id="industryName"></span>
		        	</td>
		        </tr>
		       <tr>
		        	<td rowspan="2" class="bg-gray ft14 center">区域类型</td>
		        	<td colspan="2" class="bg-gray2 ft14 center">
		        	
		        	<div class="col-4">
						<div class="col-6">特色小镇：
								<span id="tsxzName" ></span>
						</div>
					</div>
					<div class="col-4">
						<div class="col-6">众创空间：
								<span id="zckjName" ></span>
						</div>
					</div>
					<div class="col-4">
						<div class="col-6">科技孵化园：
								<span id="kjfhyName" ></span>
						</div>
					</div>
		        	</td>
		        </tr>
		        <tr>
					<td colspan="2" class="bg-gray2 ft14 center">

						<div class="col-4">
							<div class="col-6">
								跨境电商园： <span id="kjdsyName"></span>
							</div>
						</div>
						<div class="col-4">
							<div class="col-6">
								其他： <span id="qtName"></span>
							</div>
						</div>
					</td>
				</tr>
		   <!--      <tr>
		        	<td class="bg-gray2 ft14 center">科技孵化园</td>
		        	<td><span id="kjfhyName" ></span></td>
		        </tr>
		        <tr>
		        	<td class="bg-gray2 ft14 center">跨境电商园</td>
		        	<td><span id="kjdsyName" ></span></td>
		        </tr>
		        <tr>
		        	<td class="bg-gray2 ft14 center">其他</td>
		        	<td><span id="qtName" ></span></td>
		        </tr> -->
		        <tr>
	               <td class="bg-gray ft14 center"><div >创业人群</div></td>
	               <td colspan="3">
	               	<span id="entCrowdName" ></span>
	               	<span id="entCrowdText" ></span>
	               </td>                     
		        </tr>
		    </table>
	        <table class="table-horizontal mb20 pykjbxx" style="display: none" cellpadding="0" cellspacing="0" border="0">
		        <tr >
	               <td rowspan="2" class="bg-gray ft14 center" width="20%"><div id="div_entarchivesOperate">经营状况（2016年度）</div></td>
	               <td colspan="3" style="text-align: left;" width="80%">
						营业总收入<span id="vendInc" ></span>万元，利润总额<span id="proGro" ></span>万元，纳税总额<span id="ratGro" ></span>万元。
	               </td>   
		        </tr>
		         <tr >
	               <td colspan="3">
	               <label for="qt">备注</label>	<span id="entarchivesOperate.remark" ></span>
	               </td>   
		        </tr>
		        <tr >
	               <td class="bg-gray ft14 center"><div id="add_help"></div></td>
	               <td colspan="3" style="text-align: left;padding:0px">
						<table >
							<tr>
								<td class="bg-gray ft14 center" style="border-top:none;border-left:none">需求类型</td>
								<td class="bg-gray ft14 center" style="border-top:none">需求内容</td>
								<td class="bg-gray ft14 center" style="border-top:none">帮扶时间</td>
								<td class="bg-gray ft14 center" style="border-top:none">服务内容</td>
							</tr>
							<tbody id="tbody_entarchivesHelpList">

							</tbody>
						</table>
	               </td>   
		        </tr>
		    </table>
	        <table class="table-horizontal mb20" cellpadding="0" cellspacing="0" border="0">
		         <tbody id="tbody_entarchivesAdjust" style="display: none">
		         <tr>
	               <td class="bg-gray ft14 center"><div>移除类型</div></td>
	               <td colspan="3" >
	              	 <div class="ipt-box" style="width:130px"> 
						<select id="adjustTypeCode" name="adjustTypeCode">
							<option value="1">企业注销</option>
							<option value="2">升规</option>
							<option value="3">经营异常</option>
							<option value="4">严重违法违规</option>
							<option value="5">其他</option>
						</select>
						</div>
	               </td>   
		        </tr>
		        <tr >
	               <td class="bg-gray ft14 center"><div >移除原因</div></td>
	               <td colspan="3" >
						<textarea rows="4" id="adjustReason" name="adjustReason" style="width: 98%;"></textarea>
	               </td>   
		        </tr>
		        <tr >
	               <td class="bg-gray ft14 center"><div><span class="light">*</span>移除人</div></td>
	               <td ><input type="text" id="adjustUserName" name="adjustUserName" class="t-fill"  value="" readonly="readonly">
	               </td>   
	               <td class="bg-gray ft14 center"><div><span class="light">*</span>移除时间</div></td>
	               <td >
	               	<input type="text" id="adjustTime" name="adjustTime" class="t-f"  value="" readonly="readonly" onclick="laydate();">
	               </td>   
		        </tr>
		        </tbody>
		    </table>
		    <br>
		    <table class="table-common"  width="100%">
					<tbody id="tbody_entarchivesAdjustList">
			
					</tbody>
				</table>
				
				 <div class="center  mt10 ">
	            <input type="button" class="btn btn-info" style="margin-right:100px" id="save" value="保存" />
	            <input type="button" class="btn " id="cancel" value="关闭" />
	       </div>
	
       </form>
	</div>
	<script id="tpl_entarchivesHelpList" type="text/x-handlebars-template">

{{#each this}}
	
	<tr data-index="{{tableNum @index}}">
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].priPID" name="entarchivesHelpList[{{tableNum @index}}].priPID" value="{{priPID}}"/>
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].year" name="entarchivesHelpList[{{tableNum @index}}].year" value="{{year}}"/>
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].helpTypeName" name="entarchivesHelpList[{{tableNum @index}}].helpTypeName"  class="t-fill" value="{{helpTypeName}}" readonly/>
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].helpTypeCode" name="entarchivesHelpList[{{tableNum @index}}].helpTypeCode" class="t-fill" value="{{helpTypeCode}}" />
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].helpText"  name="entarchivesHelpList[{{tableNum @index}}].helpText" class="t-fill"  value="{{helpText}}" readonly>
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].helpTime"  name="entarchivesHelpList[{{tableNum @index}}].helpTime" class="t-fill"  value="{{helpTime}}"  readonly>
	<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].helpContent" name="entarchivesHelpList[{{tableNum @index}}].helpContent"  class="t-fill"  value="{{helpContent}}" readonly/>
		<td style="border-left:none" class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTypeName">{{helpTypeName}}</td>
			<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpText">{{helpText}}</td>
			<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTime">{{helpTime}}</td>
			<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpContent">{{helpContent}}</td>
	</tr>
{{/each}}
</script>

	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_remove.js"></script>
</body>
</html>