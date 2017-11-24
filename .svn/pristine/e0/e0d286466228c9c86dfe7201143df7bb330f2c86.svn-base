<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查检查对象名单抽取</title>
<!--     <link rel="stylesheet" href="/css/syn.css"> -->
     <link rel="stylesheet" href="/css/reg.server.css">
	<link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="/js/lib/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="/js/lib/jquerymultiselect/jquery.multiselect.css">
</head>
<body class="pd10">
<form id="taskForm" class="form-box">
<input type="hidden" id="userType" name="userType" value=${userType }>
<input type="hidden" id="taskUid" name="taskUid" value=${taskUid }>
<div>
    <table class="table-horizontal">
        <tr>
            <td class="bg-gray right" width="20%">专项库主体类型：</td>
            <td width="80%">
                <div class="ipt-box col-12">
                    <input type="checkbox" name="entCatg" value="11,13,31,33,12,14,32,34,21,27,24,22,28">企业
                    <input type="checkbox" name="entCatg" value="16,17">农专社
                    <input type="checkbox" name="entCatg" value="50">个体户
                    <input type="checkbox" name="entCatg" value="23">外企代表机构
               </div>
           </td>
       </tr>
       <tr>
           <td class="bg-gray right">专项库主体范围：</td>
           <td>
		        <div class="form-item clearfix">
		            <div class="col-4">
	                    <label class="item-name col-5">登记机关：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="hidden" class="ipt-txt" name="regOrg" id="regOrg" value=""/>
	                            <input type="text" class="ipt-txt" id="regOrgName" value="" readonly="readonly" placeholder="请选择登记机关"/>
		                            <span class="add-icon" id="choseorgReg">
		                                <i></i>
		                         </span>
	                        </div>
	                    </div>
	                </div>
		            <div class="col-4">
		                <label class="item-name col-5">管辖单位：</label>
	                    <div class="col-7">
	                        <div class="ipt-box col-11">
	                            <input type="hidden" class="ipt-txt" name="localAdm" id="localAdm" value=""/>
	                            <input type="text" class="ipt-txt" id="localAdmName" value="" readonly="readonly" placeholder="请选择管辖单位"/>
		                            <span class="add-icon" id="choseregUnit">
		                                <i></i>
		                            </span>
	                        </div>
	                    </div>
		            </div>
		        </div>
           </td>
       </tr>
       <tr>
           <td class="bg-gray right">专项库类别：</td>
            <td>
                <div class="ipt-box">
                	 <input type="hidden" class="ipt-txt" name="specialCode" id="specialCode" value=""/>
                    <textarea id="specialName" name="specialName" style="height:70px;width: 80%" disabled="disabled"></textarea>
                    <input type="button" value="选择" id="choseSpecial" class="btn">
                </div>
            </td>
        </tr>
        <tr>
           <td class="bg-gray right">专项库对应的监管标签：</td>
            <td>
                <div class="ipt-box">
                	<input type="hidden" class="ipt-txt" name="markCode" id="markCode" value=""/>
                    <textarea id="markName" name="markName" style="height:70px;width: 80%" disabled="disabled"></textarea>
                   	<input type="button" value="选择" id="choseMark" class="btn">
                </div>
            </td>
        </tr>
        <tr>
           <td class="bg-gray right">专项库对应的许可证：</td>
            <td>
                <div class="ipt-box">
                    <textarea id="qzName" name="licName" style="height:70px;width: 80%"  placeholder="如查询不到，可手动输入"></textarea>
                    <input type="button" value="选择" id="qzcodetree" class="btn">
                    <input type="hidden" id="qzCode" value="" class="hidden_input">
                </div>
            </td>
        </tr>
    </table>
</div>
<div class="form-group clearfix">
    <div class="center mt10">
        <input type="button" id="ok" value="确认导入条件" class="btn mr20">
        <input type="button" id="cancel" onclick="$('#taskForm')[0].reset();" value="重置" class="btn">
    </div>
</div>
<div class="clearfix mt20">
    <div class="btn-box">
<div><span>筛选结果</span>本次导入条件共筛选出<input type="text" id="countspe" style="width: 50px;line-height:20px;" disabled="disabled"/>户</div>
  </div>
</div>
</form>
<div class="clearfix mt20">
    <div class="btn-box">
        <input type="button" id="addAll" value="全部导入" class="btn mr20">
        <input type="button" value="关闭" id="close" class="btn">
    </div>
</div><br/>
</body>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/syn/system/sccheck/scentback/scentback_special.js"></script>
</html>