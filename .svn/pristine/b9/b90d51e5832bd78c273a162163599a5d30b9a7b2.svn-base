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
    <style type="text/css">
		   .t-f{
		   	width:100%;
		   	height:100%;
		   }
    </style>
    <title>加入培育库详细</title>
</head>
<body>
	<div> 
		<form id="webForm">
			<input type="hidden" id="uid" name="UID">
			<input type="hidden" id="priPID" name="priPID">
			<input type="hidden" id="priPIDs" name="priPIDs">
			<input type="hidden" id="cultivationTypeName" name="cultivationTypeName">
			<input type="hidden" id="industryName" name="industryName">
			<input type="hidden" id="entCrowdName" name="entCrowdName">
			<input type="hidden" id="createTime" name="createTime">
			<input type="hidden" id="entarchivesOperate.priPID" name="entarchivesOperate.priPID" >
			<input type="hidden" id="entarchivesOperate.year" name="entarchivesOperate.year" value="2016">
			
			<input type="hidden" id="entarchivesAdjust.priPID" name="entarchivesAdjust.priPID">
			<input type="hidden" id="entarchivesAdjust.adjustUserId" name="entarchivesAdjust.adjustUserId">
			<input type="hidden" id="entarchivesAdjust.adjustDeptId" name="entarchivesAdjust.adjustDeptId">
			<input type="hidden" id="entarchivesAdjust.adjustDeptName" name="entarchivesAdjust.adjustDeptName">
			<input type="hidden" id="entarchivesAdjust.adjustState" name="entarchivesAdjust.adjustState" value="1">
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
	               <td width="12%"><input type="text" id="entPrincipal" name="entPrincipal" class="t-f"  ></td>
	               <td class="bg-gray ft14 center" width="12%">联系电话</td>
	               <td width="12%"><input type="text" id="entPrincipalTel" name="entPrincipalTel" class="t-f"  ></td>
	               <td class="bg-gray ft14 center" width="12%">企业联络人</td>
	               <td width="12%"><input type="text" id="entContact" name="entContact" class="t-f"  ></td>
	               <td class="bg-gray ft14 center" width="12%">联系电话</td>
	               <td width="12%"><input type="text" id="entContactTel" name="entContactTel" class="t-f"  ></td>
		        </tr>
		    </table>
	      
	        <table class="table-horizontal mb20" cellpadding="0" cellspacing="0" border="0">
		        <tr>
	               <td class="bg-gray ft14 center" rowspan="4" width="10%">企业类型</td>
	               <td class="bg-gray ft14 center" colspan="2" width="20%"><span class="light">*</span>培育库类型</td>
	               <td width="70%">
	               		<input type="radio" name="cultivationTypeCode" value="1"/><label style="margin-right:30px;">初创型</label>
	               		<input type="radio" name="cultivationTypeCode" value="2"/><label style="margin-right:30px;">成长型</label>
	               		<input type="radio" name="cultivationTypeCode" value="3"/><label style="margin-right:30px;">领军型</label>
	               	</td>
		        </tr>
		        <tr>
		        	
		        	<td colspan="2" class="bg-gray ft14 center"><span class="light">*</span>八大重点产业</td>
		        	<td>
	        			<input type="checkbox"  name="industryType" value="1"/><label for="">信息经济产业</label>
	        			<input type="checkbox"  name="industryType" value="2"/><label for="">环保产业</label>
	        			<input type="checkbox"  name="industryType" value="3"/><label for="">旅游产业</label>
	        			<input type="checkbox"  name="industryType" value="4"/><label for="">金融产业</label>
	        			<input type="checkbox"  name="industryType" value="5"/><label for="">健康产业</label>
	        			<input type="checkbox"  name="industryType" value="6"/><label for="">时尚产业</label>
	        			<input type="checkbox"  name="industryType" value="7"/><label for="">高端装备制造产业</label>
	        			<input type="checkbox"  name="industryType" value="8"/><label for="">文化创意产业</label>
	        			<input type="checkbox"  name="industryType" value="9"/><label for="">其他</label>
		        	</td>
		        </tr>
		        <tr>
		        	<td rowspan="2" class="bg-gray ft14 center" width="10%"><span class="light">*</span>区域类型</td>
		        	<td colspan="2" class="bg-gray2 ft14 center" width="10%">
		        	<div class="col-4">
	                    <label class="item-name col-3"><input type="radio" id="chk_tsxzName" name="qylx" />特色小镇：</label>
	                    <div class="col-9">
								<div class="ipt-box">
									<input id="tsxzName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled" />
									<input type="hidden" id="tsxz" name="tsxz" class="treeCode">
									<a id="a_tsxzName" class="link a_tsxzName" data-id="tsxzName" data-pcode="TSXZ">
										<span class="add-icon-new">新增小镇</span>
									</a>
								</div>
								<div class="ztree" id="ztree_tsxzName" style="display: none; position: absolute;">
									<ul id="ztree_ul_tsxzName" class="ztree_ul ztree-list" style="height: 150px" ></ul>
								</div>
	                    </div>
	                </div>

	                <div class="col-4">
							<label class="item-name col-3"><input type="radio" id="chk_zckjName" name="qylx"/>众创空间：</label>
							<div class="col-9">
									<div class="ipt-box">
										<input  id="zckjName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled" />
										<input type="hidden" id="zckj" name="zckj" class="treeCode">
										<a id="a_zckjName" class="link a_zckjName" data-id="zckjName" data-pcode="ZCKJ">
											<%--<span class="add-icon"><i></i></span>--%>
											<span class="add-icon-new">新增空间</span>
										</a>
									</div>
									<div class="ztree" id="ztree_zckjName" style="display: none; position: absolute;">
										<ul id="ztree_ul_zckjName" class="ztree_ul ztree-list" style="height: 150px"></ul>
									</div>
								</div>
						</div>

						<div class="col-4">
							<label class="item-name col-3"><input type="radio" id="chk_kjfhyName" name="qylx"/>科技孵化园：</label>
							<div class="col-9">
									<div class="ipt-box">
										<input id="kjfhyName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled"/>
										<input type="hidden" id="kjfhy" name="kjfhy" class="treeCode" >
										<a id="a_kjfhyName" class="link a_kjfhyName" data-id="kjfhyName" data-pcode="KJFHY">
											<%--<span class="add-icon"><i></i></span>--%>
												<span class="add-icon-new">新增孵化园</span>
										</a>
									</div>
									<div class="ztree" id="ztree_kjfhyName" style="display: none; position: absolute;">
										<ul id="ztree_ul_kjfhyName" class="ztree_ul ztree-list" style="height: 150px" ></ul>
									</div>
								</div>
						</div>
					</td>
		        </tr>
		        <tr>
					<td colspan="2" class="bg-gray2 ft14 center" width="10%">
						<div class="col-4">
							<label class="item-name col-3"><input type="radio" id="chk_kjdsyName" name="qylx"/>电子商务园：</label>
							<div class="col-9">
									<div class="ipt-box">
										<input id="kjdsyName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled"/>
										<input type="hidden" id="kjdsy" name="kjdsy" class="treeCode" >
										<a id="a_kjdsyName" class="link a_kjdsyName" data-id="kjdsyName" data-pcode="KJDSY">
											<%--<span class="add-icon"><i></i></span>--%>
											<span class="add-icon-new">新增商务园</span>
										</a>
									</div>
									<div class="ztree" id="ztree_kjdsyName" style="display: none; position: absolute;">
										<ul id="ztree_ul_kjdsyName" class="ztree_ul ztree-list" style="height: 150px" ></ul>
									</div>
								</div>
						</div>
						<div class="col-4">
							<label class="item-name col-3"><input type="radio" id="chk_xwqyyName" name="qylx"/>小微企业园：</label>
							<div class="col-9">
									<div class="ipt-box">
										<input id="xwqyyName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled"/>
										<input type="hidden" id="xwqyy" name="xwqyy" class="treeCode" >
										<a id="a_xwqyyName" class="link a_xwqyyName" data-id="xwqyyName" data-pcode="XWQYY">
											<%--<span class="add-icon"><i></i></span>--%>
											<span class="add-icon-new">新增企业园</span>
										</a>
									</div>
									<div class="ztree" id="ztree_xwqyyName" style="display: none; position: absolute;">
										<ul id="ztree_ul_xwqyyName" class="ztree_ul ztree-list" style="height: 150px" ></ul>
									</div>
								</div>
						</div>
						<div class="col-4">
							<label class="item-name col-3"><input type="radio" id="chk_qtName" name="qylx"/>其他：</label>
							<div class="col-9">
									<div class="ipt-box">
										<input id="qtName" value="" type="text" class="ipt-txt clx treeName qylx width70" disabled="disabled"/>
										<input type="hidden" id="qt" name="qt" class="treeCode" >
										<a id="a_qtName" class="link a_qtName" data-id="qtName" data-pcode="QT">
											<%--<span class="add-icon"><i></i></span>--%>
												<span class="add-icon-new">新增其他</span>
										</a>
									</div>
									<div class="ztree" id="ztree_qtName" style="display: none; position: absolute;">
										<ul id="ztree_ul_qtName" class="ztree_ul ztree-list" style="height: 150px" ></ul>
									</div>
								</div>
						</div>

						<!-- <div class="col-4">
							<label class="item-name col-5"><input type="checkbox" id="chk_kjfhyName"/>科技孵化园：</label>
							<div class="col-6">
								<div class="ipt-box col-12">
									<div class="ipt-box">
										<input id="kjfhyName" value="" type="text" class="ipt-txt clx treeName" disabled="disabled" /><input type="hidden" id="kjfhy" name="kjfhy" class="treeCode"> <a id="a_kjfhyName" class="link a_kjfhyName" data-id="kjfhyName" data-pcode="KJFHY"> <span class="add-icon"><i></i></span>
										</a>
									</div>
									<div class="ztree" id="ztree_kjfhyName" style="display: none; position: absolute;">
										<ul id="ztree_ul_kjfhyName" class="ztree_ul ztree-list" style="height: 150px"></ul>
									</div>
								</div>
							</div>
						</div> -->
					</td>
				</tr>
		        <tr>
	               <td class="bg-gray ft14 center" width="10%"><div><span class="light">*</span>创业人群</div></td>
	               <td colspan="3" width="90%">
	               	<input type="checkbox" id="entCrowdCode_xs" name="entCrowdCode" value="1"/><label >毕业三年内大学生</label>
	               	<input type="checkbox" id="entCrowdCode_gx" name="entCrowdCode" value="2"/><label >高校科研院所专业技术人才</label>
	               	<input type="checkbox" id="entCrowdCode_hw" name="entCrowdCode" value="3"/><label >海外归国人才</label>
	               	<input type="checkbox" id="entCrowdCode_fx" name="entCrowdCode" value="5"/><label >返乡农民工</label>
	               	<input type="checkbox" id="entCrowdCode_qy" name="entCrowdCode" value="6"/><label >企业员工辞职创业</label>
	               	<input type="checkbox" id="entCrowdCode_ty" name="entCrowdCode" value="7"/><label >退役士兵</label>
	               	<input type="checkbox" id="entCrowdCode_qt" name="entCrowdCode" value="4"/><label >其他</label><input id="entCrowdText" name="entCrowdText" type="text" maxlength="100"  disabled="disabled" class="ipt-txt" >
	               </td>                     
		        </tr>
		    </table>
	        <table class="table-horizontal mb20" cellpadding="0" cellspacing="0" border="0">
		        <tr >
	               <td rowspan="2" class="bg-gray ft14 center" width="8%"><div id="div_entarchivesOperate">经营状况（2016年度）</div></td>
	               <td colspan="3" width="92%">
						营业总收入<span id="vendInc" ></span>万元，利润总额<span id="proGro" ></span>万元，纳税总额<span id="ratGro" ></span>万元。<span id="span_errorText" style="color: red;display: none">数据异常，请核实</span>
	               </td>   
		        </tr>
		         <tr >
	               <td colspan="3" style="text-align: left;">
	               <label for="qt" >备注</label><input style="width:97%;height:100%" id="entarchivesOperate.remark" name="entarchivesOperate.remark" type="text" maxlength="100"  class="ipt-txt" >
	               </td>   
		        </tr>
		        <tr >
	               <td class="bg-gray ft14 center" ><input type="button" class="btn btn-info"  id="add_help" value="添加需求及帮扶记录（2017年度）" /></td>
	               <td colspan="3" style="text-align: center;padding:0px" >
						<table>
							<tr>
								<td class="bg-gray ft14 center" style="border-top:none;border-left:none">需求类型</td>
								<td class="bg-gray ft14 center" style="border-top:none">需求内容（其他备注）</td>
								<td class="bg-gray ft14 center" style="border-top:none">帮扶时间</td>
								<td class="bg-gray ft14 center" style="border-top:none">服务内容</td>
								<td class="bg-gray ft14 center" style="border-top:none">操作</td>
							</tr>
							<tbody id="tbody_entarchivesHelpList">
								<!-- <tr data-index="{{tableNum @index}}">
									<td style="border-left: none" class="center" id="td_entarchivesHelpList[{{tableNum @index}}].treeName">

										<div class="ipt-box">
											<input type="text"  class="ipt-txt clx treeName" readonly /> <input type="hidden" class="clx helpTypeCode" /> <a class="link a_entarchivesHelpList" data-index="{{tableNum @index}}"> <span class="add-icon"><i></i></span>
											</a>
										</div>
										<div class="ztree" id="ztree_1" style="display: none; position: absolute;">
											<ul id="ztree_ul_1" class="ztree_ul" style="margin-top: 0; width: 160px;"></ul>
										</div>
									</td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpText"><div class="ipt-box">
											<input id="helpText" name="helpText" class="ipt-txt">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTime"><div class="ipt-box">
											<input id="helpTime" name="helpTime" class="ipt-txt" onclick="laydate();" readonly="readonly">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpContent"><div class="ipt-box">
											<input id="helpContent" name="helpContent" class="ipt-txt">
										</div></td>
									<td class="center"><a href="javascript:void(0);" class="list-edit" data-index="{{tableNum @index}}">修改</a>&nbsp;&nbsp;<a href="javascript:void(0);" class="list-delete">删除</a></td>
								</tr>
								<tr data-index="{{tableNum @index}}">
									<td style="border-left: none" class="center" id="td_entarchivesHelpList[{{tableNum @index}}].treeName">
									
										<div class="ipt-box" >
											<input type="text" id="treeName" name="treeName" class="ipt-txt clx" readonly /> 
											<input type="hidden" id="helpTypeCode" name="helpTypeCode" class="clx" />
											<a class="link a_entarchivesHelpList" data-index="{{tableNum @index}}">
												<span class="add-icon"><i></i></span>
											</a>
										</div>
										<div class="ztree" id="ztree_2" style="display:none; position: absolute;">
											<ul id="ztree_ul_2" class="ztree_ul" style="margin-top:0; width:160px;"></ul>
										</div>
									</td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpText"><div class="ipt-box">
											<input id="helpText" name="helpText" class="ipt-txt">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTime"><div class="ipt-box">
											<input id="helpTime" name="helpTime" class="ipt-txt" onclick="laydate();" readonly="readonly">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpContent"><div class="ipt-box">
											<input id="helpContent" name="helpContent" class="ipt-txt">
										</div></td>
									<td class="center"><a href="javascript:void(0);" class="list-edit" data-index="{{tableNum @index}}">修改</a>&nbsp;&nbsp;<a href="javascript:void(0);" class="list-delete">删除</a></td>
								</tr> -->
							</tbody>
						</table>
	               </td>   
		        </tr>
		    </table>
	        <table class="table-horizontal" cellpadding="0" cellspacing="0" border="0">
		        <tbody id="tbody_entarchivesAdjust" style="display: none">
		        
		        <tr >
	               <td class="bg-gray ft14 center"><div ><span class="light">*</span>调整原因</div></td>
	               <td colspan="3" >
						<textarea rows="4" id="entarchivesAdjust.adjustReason" name="entarchivesAdjust.adjustReason" style="width: 98%;"></textarea>
	               </td>   
		        </tr>
		        <tr >
	               <td class="bg-gray ft14 center"><div ><span class="light">*</span>调整人</div></td>
	               <td ><input class="t-f" type="text" id="entarchivesAdjust.adjustUserName" name="entarchivesAdjust.adjustUserName"   value="" readonly="readonly">
	               </td>   
	               <td class="bg-gray ft14 center"><div ><span class="light">*</span>更新时间</div></td>
	               <td >
	               	<input class="t-f" type="text" id="entarchivesAdjust.adjustTime" name="entarchivesAdjust.adjustTime"   value="" readonly="readonly" onclick="laydate();">
	               </td>   
		        </tr>
		        </tbody>
		    </table>
		    <br>
		   <div class="center  mt10 ">
	            <input type="button" class="btn btn-info" style="margin-right:100px" id="save" value="保存" />
	            <input type="button" class="btn " id="cancel" value="关闭" />
	       </div>
	        <br>
			<h3 style="font-size: 18px;margin-bottom: 12px;height: 18px;line-height: 18px;"><img class="mr10" src="/img/sment/icon_edit.png">修改记录</h3>
			<div style="height:153px; overflow: scroll; margin: 0 auto; border: 1px solid #ccc;">
				<table class="table-hor"  width="100%">
					<tbody id="tbody_entarchivesAdjustList">
	
					</tbody>
				</table>
			</div>
		</div>

       </form>
	</div>
	<script id="tpl_entarchivesHelpList" type="text/x-handlebars-template">
		{{#each this}}
								<tr data-index="{{tableNum @index}}">
									<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].priPID" name="entarchivesHelpList[{{tableNum @index}}].priPID" value="{{priPID}}"/>
									<input  type="hidden" id="entarchivesHelpList[{{tableNum @index}}].year" name="entarchivesHelpList[{{tableNum @index}}].year" value="{{year}}"/>
									<td style="border-left: none" class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTypeName">

										<div class="ipt-box">
											<input id="entarchivesHelpList[{{tableNum @index}}].helpTypeName" name="entarchivesHelpList[{{tableNum @index}}].helpTypeName" value="{{helpTypeName}}" type="text"  class="ipt-txt clx treeName helpTypeName" readonly /> <input id="entarchivesHelpList[{{tableNum @index}}].helpTypeCode" name="entarchivesHelpList[{{tableNum @index}}].helpTypeCode" type="hidden" class="clx treeCode" value="{{helpTypeCode}}" /> <a class="link a_entarchivesHelpList" > <span class="add-icon"><i></i></span>
											</a>
										</div>
										<div class="ztree" id="ztree_{{tableNum @index}}" style="display: none; position: absolute;">
											<ul id="ztree_ul_{{tableNum @index}}" class="ztree_ul ztree-list" ></ul>
										</div>
									</td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpText"><div class="ipt-box">
											<input id="entarchivesHelpList[{{tableNum @index}}].helpText"  name="entarchivesHelpList[{{tableNum @index}}].helpText" value="{{helpText}}" class="ipt-txt">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpTime"><div class="ipt-box">
											<input id="entarchivesHelpList[{{tableNum @index}}].helpTime"  name="entarchivesHelpList[{{tableNum @index}}].helpTime" value="{{helpTime}}" class="ipt-txt" onclick="laydate();" readonly="readonly">
										</div></td>
									<td class="center" id="td_entarchivesHelpList[{{tableNum @index}}].helpContent"><div class="ipt-box">
											<input id="entarchivesHelpList[{{tableNum @index}}].helpContent" name="entarchivesHelpList[{{tableNum @index}}].helpContent" value="{{helpContent}}" class="ipt-txt">
										</div></td>
									<td class="center"><a href="javascript:void(0);" class="list-delete">删除</a></td>
								</tr>
		{{/each}}
	</script>

	<script id="tpl_entarchivesAdjustList" type="text/x-handlebars-template">
		{{#each this}}
			<tr>
				<td><span class="table-sp"></span>{{adjustDeptName}}</td>
				<td>{{adjustUserName}}</td>
				<td>{{adjustReason}}</td>
				<td>{{adjustTime}}</td>
			</tr>
		{{/each}}
	</script>
	<script>
   	 	var flg = '1';
	</script>	
	<script src="/js/lib/laydate/laydate.js"></script>
	<script src="/js/lib/require.js"></script>
	<script src="/js/config.js"></script>
	<script src="/js/sment/entarchives/entarchives_edit.js"></script>
</body>
</html>