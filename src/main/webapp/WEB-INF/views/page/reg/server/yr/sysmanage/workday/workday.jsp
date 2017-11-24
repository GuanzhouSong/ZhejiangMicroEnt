<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <title>节假日管理</title>
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/vendor/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="/css/workday.css">
	<script src="/js/lib/jquery/jquery-1.6.4.min.js"></script>
	<script src="/js/lib/jquery/jquery.tip-min.js"></script>
	<script src="/js/reg/server/yr/workday/workday.js"></script>
 <script type="text/javascript">
		 var url = location.href;
		 
		 var urlObj = $.icinfo.url.get(location.href);
		 if(!urlObj.year){
		 	location.href = '?year='+new Date().getFullYear()+'&_t='+(new Date()-0);
		 }
		 
		 $(function(){
		     $("#select").val(("${year}") == "" ? new Date().getFullYear() : "${year}")
		     .change(function(){
		         location.href = '?year='+$(this).val()+'&_t='+(new Date()-0);
		     });
		
		     choseYear1();
		
		     $("#select").after($("<span />",{
		         id: "yearDesc",
		         html: " ${year}已载入"
		     }));
		
		     $("#yearDesc").fadeOut(500);
		
		     try{parent.dhxLayout.cells("c").progressOff();}catch(e){}
		 });
</script>
</head>
<body>
<div style="position:relative;margin-left: 20px;margin-top: 10px;margin-bottom: 10px">
	请选择年份：<select id="select" name="year" style="width: 80px;height: 25px">
	            <script type="text/javascript">
	                //自动生成年度 
	                var _thisYear = parseInt('<fmt:formatDate value="${curDate}" pattern="yyyy-MM-dd"/>', 10);
	                for(; 2014 <= _thisYear; _thisYear--){
	                    document.writeln('<option value="'+_thisYear+'">'+_thisYear+'</option>');
	                };
	            </script>
	        </select>
</div>
       
        <form id='theForm' name='theForm' style="margin-bottom: 100px"></form>
        <script language="javascript">
            
            //单击事件
            function chaSta(checkId) {
                var chb = $("#"+checkId);
                chb.prop("checked", chb.val() == 1 ? true : false);
                chb.val(chb.prop("checked")?0:1).prop("checked", chb.val() == 1 ? true : false);

                if(chb.val() == 1){
                    $("#dayLabel_"+checkId).addClass("dayLabel-checked");
                    //作为添加的标志
                    $("#"+checkId).addClass("_addClass");
                    //作为取消的标志
                    $("#"+checkId).removeClass("_cancelClass");
                }else{
                    $("#dayLabel_"+checkId).removeClass("dayLabel-checked");
                    $("#"+checkId).removeClass("_addClass");
                    $("#"+checkId).addClass("_cancelClass");
                }
            }
            
            //初始化节日样式
            function chk(){
            	var length = ${fn:length(workdayList)};
                yearhtml = $("#select").val();
                <c:forEach var="workday" items="${workdayList}" varStatus="status">
                   var newDate = new Date("${workday.calendar}".replace(/-/g, "/"));
                   var checkId = newDate.getFullYear() + "-" + (newDate.getMonth() + 1) + "-" + newDate.getDate();
               	   if("${workday.isHoliday}"=="1" && checkId.substr(0,4) == yearhtml){
		              $("#"+checkId).val("1").prop("checked", true);
		              $("#dayLabel_"+checkId).addClass("dayLabel-checked");
		          }
                </c:forEach>
               }

        </script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>
<script src="/js/reg/server/yr/workday/workday_main.js"></script>
</body>
</html>