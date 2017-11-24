<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>抽查公告页面</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/pub.css"/>"/>
</head>
<script type="text/javascript">
	function returnScTaskTitle(checkDeptName){
		var innerCode = "${innerCode}";
		if(innerCode ==null || innerCode ==""){
			return checkDeptName + "抽查任务公告";
		}
		var year = innerCode.substr(6,4);
		var index = innerCode.substr(15,3);
	    return checkDeptName +year+"年度第"+index+"号抽查任务检查结果公告";
	}
		
	function returnEntType(taskObject){
		if(taskObject !=null && taskObject != ''){
			taskObject = taskObject.replace('1','企业');
			taskObject = taskObject.replace('2','农专社');
			taskObject = taskObject.replace('3','个体户');
			taskObject = taskObject.replace('4','外企代表机构');
			return taskObject;
		}
		return "";
	}
</script>
<style type="text/css">
.table-other td {
    border: 1px solid #edeeee;
    padding: 10px 5px;
    color: #666;
}
.checkcss {
    background-color: #eae3db;
    font-weight: bold;
    text-align: right;
    color: #87550F;
    text-align: center;
    white-space: nowrap;
}
.closemarkcss{
   position:absolute;
   top:0;right:10px;
   display:block;
   width:20px;
   height:20px;
   line-height:20px;
   text-align:center;
   margin-top:-5px;
   font-size:20px;
   color: #999999
}
</style>
<body class="enterprise-info-bg">
<jsp:include page="../common/noticeheader.jsp"></jsp:include>
<div class="mb20">
    <div class="mod mod-notice-detail" style="width: 1200px">
        <div class="mod-notice-hd mod-hd mt20">
            <h3>检查结果公告</h3><br>
        </div>
        <div class="mod-notice-bd" style="margin-top: 10px;padding-bottom: 10px;">
            <h1><script>document.write(returnScTaskTitle("${scChekcInfo.taskLeadDeptName}"))</script></h1><br>
            <input id="uid" type="hidden" value="${scChekcInfo.uid}"/>
            <table class="table-other" border="0" cellspacing="0" cellpadding="0" width="100%">
                        <thead>
                        <tr>
                             
                            <th>
                              <table border="0" cellpadding="0" cellspacing="0" width="100%" class="table-other">
                                  <tbody>
                                  <tr>
                                       <td class="checkcss" style="color:#87550F;">序号</td>
                                  </tr>
                                  </tbody>
                              </table>
                            </th>
                            <td class="checkcss" style="color:#87550F;">抽查计划编号</td>
                            <td class="checkcss" style="color:#87550F;">抽查计划名称</td>
                            <td class="checkcss" style="color:#87550F;">抽查任务编号</td>
                            <td class="checkcss" style="color:#87550F;">抽查任务名称</td>
                            <td class="checkcss" style="color:#87550F;">抽查类型</td>
                            <td class="checkcss" style="color:#87550F;">检查机关</td>
                            
                         	<th>
                              <table border="0" cellpadding="0" cellspacing="0" width="100%" class="table-other">
                                  <tbody>
                                  <tr>
                                       <td width="20%" class="checkcss" style="color:#87550F;">抽查市场主体名称</td>
			                           <td width="20%" class="checkcss" style="color:#87550F;">统一社会信用代码/注册号</td>
			                           <td width="20%" class="checkcss" style="color:#87550F;">检查完成日期</td>
			                           <td width="20%" class="checkcss" style="color:#87550F;">检查结果</td>
			                           <td width="20%" class="checkcss" style="color:#87550F;">备注</td>
                                  </tr>
                                  </tbody>
                              </table>
                            </th>
                        </tr>
	                     </thead>
                        <tbody id="pageList">
                            
                        </tbody>
                     </table>
                     <div class="notice-pagination-box clearfix" style="padding-top: 20px">
                        <span class="page-total">共查询到<em id="info_total"></em>条信息，共<em id="info_pageNum"></em>页</span>
                        <div id="" class="pagination">

                        </div>
                    </div>
               </div>
         </div>
</div>
<script id="noticelist" type="text/x-handlebars-template">
    {{#each data}}
	 <tr>
         <th style="display: block;padding-top: 0px">
       	   <table border="0" cellpadding="0" cellspacing="0" width="100%" class="table-other">
        	  <tbody>{{#with pubScentResultList}} {{#each this}}
        	    <tr>
          	 	 <td height="50px" style="text-align: center;">{{xh @index}}</td>
         	   </tr>
			   {{/each}} {{/with}}
        	  </tbody>
       	   </table>
     	</th>
		<td style="text-align: center;">{{resourcePlanCode}}</td>
		<td style="text-align: center;">{{resourcePlanName}}</td>
		<td style="text-align: center;">{{innerCode}}</td>
		<td style="text-align: center;">{{taskName}}</td>
		<td style="text-align: center;">{{taskTypeDesc taskType}}</td>
		<td style="text-align: center;">{{taskLeadDeptName}}</td>
		<th>
	       <table border="0" cellpadding="0" cellspacing="0" width="100%" class="table-other">
	       <tbody> {{#with pubScentResultList}} {{#each this}}
	           <tr>
	            <td height="50px" width="25%">{{entName}}</td>
	            <td height="50px" width="34%">{{regNO}}</td>
	            <td height="50px" width="19%">{{checkDateFormat checkDate}}</td>
	            <td height="50px" width="14%" style="text-align: center;">
					<a href="#" class="resultItem" priPID ={{priPID}} taskUid ={{taskUid}}>{{auditStateForm auditState}}</a>
				</td>
				<td height="50px" width="8%" style="text-align: center;"></td>
	           </tr>
 			{{/each}} {{/with}}
	       </tbody>
	       </table>
         </th>
	 </tr>
    {{/each}}
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/pub/infobulletin/spotresult_main.js"></script>
</body>
</html>