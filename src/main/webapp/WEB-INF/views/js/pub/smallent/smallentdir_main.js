require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','pagination'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	bind();
    }
    
	
	 function loadDirInfoTable(page, length,callback) {
			var nameOrRegNO = ($("#nameOrRegNO").val() =='请输入企业名称或注册号')?'':$("#nameOrRegNO").val();
	    	var params = {nameOrRegNO:nameOrRegNO};
	        http.httpRequest({
	            url: '/pub/smallentdir/list.json',
	            data: {start: page*length,length: length,params:params},
	            success: function (data) {
	            	var itemCount = data.recordsTotal;
	            	 $('.pagination').pagination(itemCount, {
	                     prev_text: '<i class="icon-triangle-left"></i>上一页',
	                     next_text: '下一页<i class="icon-triangle-right"></i>',
	                     num_display_entries: 3,
	                     num_edge_entries: 2,
	                     current_page: page,
	                     link_to: 'javascript:void(0)',
	                     ellipse_text: '...',
	                     first_text: '首页',
	                     last_text: '尾页',
	                     callback:function(page,jq){
	                    	 loadDirInfoTable(page,10);
	                     }
	                 });
	                var myTemplate = handlebars.compile($("#dirinfoTemplate").html());
	                $('#smallentgrid').html(myTemplate(data));
	                $(".doView").click(function(){
	                	var uid = $(this).attr("_id");
	                	window.location.href ='/pub/smallentdir/details?UID='+uid;
	                });
	                $("#info_total").text(itemCount);
	                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
	                $("#info_pageNum").text(pageNum);
	            }
	        });
	    }
	
function bind(){
	
}
	 
//----老代码-------------------------------------------------------------------------------------------------	 
	 $("#searchSmallDir").click(function(){
		 var yzvalue=$("#yzm").val();
    	 if( $("#suanshu1").attr("style").indexOf("block")>0 ){
    		 if(yzvalue!="3" && yzvalue!="三"){
    			 alert("验证码错误！");
    			 $("#yzm").val("");
    			 changeYan(1);
    			 return false;
    		 }else{
    			 $("#alert_win").attr("style","display:none");
    			 $("#zmdid").attr("style","display:none");
    			 loadDirInfoTable(0,10);
    		 }
    	 }
    	 if( $("#souzimu1").attr("style").indexOf("block")>0 ){
    		 if(yzvalue!="clyth" && yzvalue!="CLYTH"){
    			 alert("验证码错误！");
    			 $("#yzm").val("");
    			 changeYan(2);
    			 return false;
    		 }else{
    			 $("#alert_win").attr("style","display:none");
    			 $("#zmdid").attr("style","display:none");
    			 loadDirInfoTable(0,10);
    		 }
    	 }
    	 if( $("#hanzi1").attr("style").indexOf("block")>0 ){
    		 if(yzvalue!="下工厂露"){
			     alert("验证码错误！");
			     $("#yzm").val("");
			     changeYan(3);
			     return false;
    		 }else{
    			 $("#alert_win").attr("style","display:none");
    			 $("#zmdid").attr("style","display:none");
    			 loadDirInfoTable(0,10);
    		 }
    	 }
	 });
})

function zdm(){
	alert_win.style.display='block';
	annlid.style.display='none';
	zmdid.style.display='block';
	}

function changeYan(param){
	  document.getElementById("suanshu1").style.display = "none";
	  document.getElementById("suanshu2").style.display = "none";
	  document.getElementById("souzimu1").style.display = "none";
	  document.getElementById("souzimu2").style.display = "none";
	  document.getElementById("hanzi1").style.display = "none";
	  document.getElementById("hanzi2").style.display = "none";
	  if(param == 1){
	    document.getElementById("souzimu1").style.display = "block";
	    document.getElementById("souzimu2").style.display = "block";
	  }else if(param == 2){
	    document.getElementById("hanzi1").style.display = "block";
	    document.getElementById("hanzi2").style.display = "block";
	  }else{
	    document.getElementById("suanshu1").style.display = "block";
	    document.getElementById("suanshu2").style.display = "block";
	  }
}
