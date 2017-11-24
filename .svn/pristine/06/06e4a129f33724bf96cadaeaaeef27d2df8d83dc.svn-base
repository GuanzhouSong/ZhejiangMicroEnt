<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>更多主要人员信息</title>
    <link rel="stylesheet" href="/css/pub.css">
</head>
<body class="enterprise-info-bg">
<!-- 头部 -->
<jsp:include page="../../common/enterprise.jsp"></jsp:include>
<div class="mt20 mb20 clearfix">
    <div class="contact-mod mod">
        <div class="contact-mod-hd">
            <div class="mod-bd-panel_company">
                <h3 class="i-title">
                    <i></i>主要人员信息
                    <span class="number" id="number"></span>
                </h3>
                <div class="renyuan-list clearfix">
                	
         		</div>
         		<div class="load-more">
                    <span>加载更多</span>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../common/footer.jsp"></jsp:include>
<script src="../../../../js/lib/jquery/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
$(function(){

	/*初始化*/
	var counter = 0; /*计数器*/
	var pageStart = 0; /*offset*/
	var pageSize = 32; /*size*/
	
	/*首次加载*/
	getData(pageStart, pageSize);
	
	/*监听加载更多*/
	$(document).on('click', '.load-more', function(){
		$('.renyuan-list').removeClass('h-320');
        $(this).hide();
		
		counter ++;
		pageStart = counter * pageSize;
		
		getData(pageStart, pageSize);
	});
    
	
	function getData(offset,size){
		$.ajax({
			type: 'GET',
			url: '../../midmember/list.json?priPID=${priPID}',
			dataType: 'json',
			success: function(reponse){
				var data = reponse;
				var sum = reponse.length;
				$("#number").text("共计"+sum+"条信息");

				var result = '';
				if(sum - offset < size ){
					size = sum - offset;
				}
				
				/*使用for循环模拟SQL里的limit(offset,size)*/
				for(var i=offset; i< (offset+size); i++){
					var name = data[i].name;
					var posiContent = data[i].posiContent;
					if(name==null||name==undefined){
            			name="";
            		}
					if(posiContent==null||posiContent==undefined){
            			posiContent="";
            		}
					result +="<div class='item'><span>"+name+"</span><span class='manager'>"+posiContent+"</span></div> ";
				}

				$('.renyuan-list').append(result);
				
				/*******************************************/
	
				/*隐藏more*/
				if ( (offset + size) >= sum){
					$(".load-more").hide();
				}else{
					$(".load-more").show();
				}
			},
			error: function(xhr, type){
				alert('Ajax error!');
			}
		});
	}
});
</script>
</body>
</html>