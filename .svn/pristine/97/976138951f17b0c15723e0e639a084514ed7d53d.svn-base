<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/synzw.css">
</head>
<body>
<div class="gray-bg">
<div class="w1000 margin-auto">
    <div class="spot-check clearfix">
        <div class="crumbs">
            当前位置：首页&gt;<span class="color-black">双随机抽查</span>
        </div>
        <form id="qryForm">
        	<input type="hidden" value="A058" name="dutyDeptCode" id="dutyDeptCode"/>
        </form>
        <div class="fl sidebar">
            <ul>
                <li>
                    <a href="javascript:void(0);" class="cur">职能部门</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="cur dutycode" dutycode="A058">工商部门</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="dutycode" dutycode="A012">食药部门</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="dutycode" dutycode="A027">质监部门</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="dutycode" dutycode="A014">公安部门</a>
                </li>
            </ul>
        </div>
        <div class="fl content">
            <div class="nav common-border">
                <ul id="operateli">
                    <li><a href="javascript:void(0);" class="cur opetype" opetype="1">抽查事项清单</a></li>
                    <li><a href="javascript:void(0);" class="opetype" opetype="2">抽查计划公告</a></li>
                    <li><a href="javascript:void(0);" class="opetype" opetype="3">抽查任务公告</a></li>
                    <li><a href="javascript:void(0);" class="opetype" opetype="4">抽查结果公告</a></li>
                </ul>
            </div>
            <div id="divcontent1">
	            <table class="common-table" >
	                <tr>
	                    <td class="title text-center" width="42">序号</td>
	                    <td class="title text-center" width="102">抽查事项名称</td>
	                    <td class="title text-center" width="100">抽查依据</td>
	                    <td class="title text-center" width="74">抽查主体</td>
	                    <td class="title text-center" width="74">抽查对象</td>
	                    <td class="title text-center" width="74">抽查比例</td>
	                    <td class="title text-center" width="74">抽查次数</td>
	                    <td class="title text-center" width="74">抽查方式</td>
	                    <td class="title text-center" width="112">抽查内容及要求</td>
	                    <td class="title text-center">备注</td>
	                </tr>
	            </table>
            </div>
            
            <div id="divcontent2" style="display: none;">
	            <ul id="list2" class="check-result-list common-border">
	            
	        	</ul>
	        	<div class="notice-pagination-box clearfix">
   					<div id="pageforhide2">
	                    <span class="page-total">共查询到<em id="notice-total2"></em>条信息，共<em id="notice_pageNum2"></em>页</span>
	                    <div id="pagination2" class="pagination">
	
	                    </div>
                    </div>
                   <div id="nodata2"></div>
               </div>
                    
<!-- 	        	<div class="page"> -->
<!-- 	        		<select name="" id="" class="mr10"> -->
<!-- 	        			<option value="">10</option> -->
<!-- 	        			<option value="">20</option> -->
<!-- 	        		</select> -->
<!-- 	        		<span class="number mr10">首页</span> -->
<!-- 	        		<span class="number mr10">&lt;上一页</span> -->
<!-- 	        		<span class="mr5">第</span> -->
<!-- 	        		<span class="number">1</span> -->
<!-- 	        		<span class="mr10">页/共60页</span> -->
<!-- 	        		<span class="number mr10">下一页&gt;</span> -->
<!-- 	        		<span class="number">末页</span> -->
<!-- 	        		检索到111条记录，显示第1条-第20条记录 -->
<!-- 	        	</div> -->
        	</div>
        	
        	<div  id="divcontent3" style="display: none;">
        		<ul id="list3" class="check-result-list common-border">
        		
	        	</ul>
	        	<div class="notice-pagination-box clearfix">
   					<div id="pageforhide3">
	                    <span class="page-total">共查询到<em id="notice-total3"></em>条信息，共<em id="notice_pageNum3"></em>页</span>
	                    <div id="pagination3" class="pagination">
	
	                    </div>
                    </div>
                   <div id="nodata3"></div>
               </div>
        	</div>
        	
        	<div  id="divcontent4" style="display: none;">
        		<ul id="list4" class="check-result-list common-border">
        		
	        	</ul>
	        	<div class="notice-pagination-box clearfix">
   					<div id="pageforhide4">
	                    <span class="page-total">共查询到<em id="notice-total4"></em>条信息，共<em id="notice_pageNum4"></em>页</span>
	                    <div id="pagination4" class="pagination">
	
	                    </div>
                    </div>
                   <div id="nodata4"></div>
               </div>
        	</div>
        	
        </div>
    </div>
</div>
</div>
<script id="notice_li_list" type="text/x-handlebars-template">
    {{#each data}}
	<li><a href="javascript:void(0);"  title="{{pubTitle}}" linkUID="{{linkUID}}">{{pubTitle}}</a>
        <span class="source">{{auditDeptName}}</span>
		<span class="time">{{auditDate}}</span>
	</li>
    {{/each}}
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/scgov/governindex_main.js"></script>
</body>
</html>