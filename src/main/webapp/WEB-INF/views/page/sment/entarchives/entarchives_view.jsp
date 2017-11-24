<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <link rel="stylesheet" href="/css/sment/ystep.css">
    <link rel="stylesheet" href="/css/sment/sment.server.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
    
    <title>加入培育库详细</title>
</head>
<body>
	<div >
		<form id="webForm">
			<input type="hidden" id="uid" name="UID">
			<input type="hidden" id="priPID" name="priPID">
			<input type="hidden" id="priPIDs" name="priPIDs">
			<input type="hidden" id="cultivationTypeName" name="cultivationTypeName">
			<input type="hidden" id="industryName" name="industryName">
			<input type="hidden" id="entCrowdName" name="entCrowdName">
			<input type="hidden" id="tsxz" name="tsxz" >
			<input type="hidden" id="zckj" name="zckj" >
			<input type="hidden" id="kjfhy" name="kjfhy" >
			<input type="hidden" id="kjdsy" name="kjdsy" >
			<input type="hidden" id="qt" name="qt" >
			<input type="hidden" id="createTime" name="createTime">
			<input type="hidden" id="entarchivesOperate.priPID" name="entarchivesOperate.priPID" >
			<input type="hidden" id="entarchivesOperate.year" name="entarchivesOperate.year" value="2016">
			
			<input type="hidden" id="entarchivesAdjust.priPID" name="entarchivesAdjust.priPID">
			<input type="hidden" id="entarchivesAdjust.adjustUserId" name="entarchivesAdjust.adjustUserId">
			<input type="hidden" id="entarchivesAdjust.adjustDeptId" name="entarchivesAdjust.adjustDeptId">
			<input type="hidden" id="entarchivesAdjust.adjustDeptName" name="entarchivesAdjust.adjustDeptName">
			<input type="hidden" id="entarchivesAdjust.adjustState" name="entarchivesAdjust.adjustState" value="1">
			<div class="mb20 mt10"><h1 style="margin:0 auto; width:300px">小微企业成长培育档案</h1></div>
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
	       
	        <table class="table-horizontal mb20" cellpadding="0" cellspacing="0" border="0">
		        <tr>
	               <td rowspan="5" class="bg-gray ft14 center" width="10%">企业类型</td>
	               <td colspan="2" class="bg-gray ft14 center" width="20%">培育库类型</td>
	               <td width="70%">
	               		<span id="cultivationTypeName"></span>
	               	</td>
		        </tr>
		        <tr>
		        	
		        	<td colspan="2" class="bg-gray ft14 center">八大重点产业</td>
		        	<td>
		        		<span id="industryName"></span>
		        	</td>
		        </tr>
		    
				<tr>
		        	<td rowspan="2"  class="bg-gray ft14 center">区域类型</td>
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
								小微企业园： <span id="xwqyyName"></span>
							</div>
						</div>
						
						<div class="col-4">
							<div class="col-6">
								其他： <span id="qtName"></span>
							</div>
						</div>
					</td>
				</tr>
				<tr>
	               <td class="bg-gray ft14 center"><div >创业人群</div></td>
	               <td colspan="2">
	               	<span id="entCrowdName" ></span>
	               	<span id="entCrowdText" ></span>
	               </td>                     
		        </tr>
		    </table>
	       
	         <table class="table-horizontal mb20"  cellpadding="0" cellspacing="0" border="0">	
		         <tr >

	               <td colspan="4"  class="pos-rel">
					    <div class="ystep-progress-border" style=""><span class="ystep-progress-Dot" style=""></span></div>
						<div class="ystep4 mb10 mt50" >
						</div>
	               </td>                     
		        </tr>
		  
		        <tr >
	               <td rowspan="2" class="bg-gray ft14 center" width="20%"><div id="div_entarchivesOperate">经营状况（2016年度）</div></td>
	               <td colspan="3" class="left" width="80%">
						营业总收入<span id="vendInc" class="yearReport" ></span>万元，利润总额<span id="proGro" class="yearReport"></span>万元，纳税总额<span id="ratGro" class="yearReport"></span>万元。
	               </td>   
		        </tr>
		         <tr >
	               <td colspan="3" class="left">
	               <label for="qt">备注</label>	<span id="entarchivesOperate.remark" ></span>
	               </td>   
		        </tr>
		        <tr >
	               <td rowspan="2" class="bg-gray ft14 center"><div id="add_help"></div></td>
	               <td colspan="3" style="text-align: left;padding:0px">
						<table style="border-bottom: 1px solid #ccc;">
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
		    <br>

			<h3 style="font-size: 18px;margin-bottom: 12px;height: 18px;line-height: 18px;"><img class="mr10" src="/img/sment/icon_edit.png">修改记录</h3>
			<div style="height:153px; overflow: scroll; margin: 0 auto; border: 1px solid #ccc;">
				<table class="table-hor"  width="100%">
					<tbody id="tbody_entarchivesAdjustList">

					</tbody>
				</table>
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

<script id="tpl_entarchivesAdjustList" type="text/x-handlebars-template">

{{#each this}}

	
					<tr class="pdl5 pdr5">
						<td class="center"><span class="table-sp"></span>{{adjustDeptName}}</td>
						<td class="center">{{adjustUserName}}</td>
						<td class="center">{{adjustReason}}</td>
						<td class="center">{{adjustTime}}</td>
					</tr>
{{/each}}
</script>
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_view.js"></script>
</body>
</html>