require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http, handlebars) {
    init();
    function init() { 
        bind();
    }
    function checkDate(strInputDate) {
	   strInputDate = strInputDate.replace(/-/g, "/");
	   var d = new Date(strInputDate);
	   if (isNaN(d)){
		   return false;
	   }
	   var arr = strInputDate.split("/");
	   if(arr[0].length>4||arr[1].length>2||arr[2].length>2){
		   return false;
	   }
	   return ((parseInt(arr[0], 10) == d.getFullYear()) && (parseInt(arr[1], 10) == (d.getMonth() + 1)) && (parseInt(arr[2], 10) == d.getDate()));
	}
    
    function save(){
    	var checkDateFromYear = $("#checkDateFromYear").val();
    	var checkDateFromMonth = $("#checkDateFromMonth").val();
    	var checkDateFromDay = $("#checkDateFromDay").val();
    	var checkDateToYear = $("#checkDateToYear").val();
    	var checkDateToMonth = $("#checkDateToMonth").val();
    	var checkDateToDay = $("#checkDateToDay").val();
    	var fillDateYear = $("#fillDateYear").val();
    	var fillDateMonth = $("#fillDateMonth").val();
    	var fillDateDay = $("#fillDateDay").val();
    	var contactTel = $("#contactTel").val();
    	var contactName = $("#contactName").val();
    	var deptment = $("#deptment").val();
    	if(checkDateFromMonth!=""){
    		checkDateFromMonth = checkDateFromMonth.replace(/\b(0+)/gi,"");
    	}
    	if(checkDateFromDay!=""){
    		checkDateFromDay = checkDateFromDay.replace(/\b(0+)/gi,"");
    	}
    	if(checkDateToMonth!=""){
    		checkDateToMonth = checkDateToMonth.replace(/\b(0+)/gi,"");
    	}
    	if(checkDateToDay!=""){
    		checkDateToDay = checkDateToDay.replace(/\b(0+)/gi,"");
    	}
    	if(fillDateMonth!=""){
    		fillDateMonth = fillDateMonth.replace(/\b(0+)/gi,"");
    	}
    	if(fillDateDay!=""){
    		fillDateDay = fillDateDay.replace(/\b(0+)/gi,"");
    	}
    	if(contactTel!=""){
    		contactTel = contactTel.replace(/\b(0+)/gi,"");
    	}
    	if(contactName!=""){
    		contactName = contactName.replace(/\b(0+)/gi,"");
    	}
    	if(deptment!=""){
    		deptment = deptment.replace(/\b(0+)/gi,"");
    	}
    	var checkDateFrom = checkDateFromYear + "-" + (checkDateFromMonth < 10 ? "0" : "") + checkDateFromMonth + "-" + (checkDateFromDay < 10 ? "0" : "") + checkDateFromDay;
    	var checkDateTo = checkDateToYear + "-" + (checkDateToMonth < 10 ? "0" : "") + checkDateToMonth + "-" + (checkDateToDay < 10 ? "0" : "") + checkDateToDay; 
    	var fillDate = fillDateYear + "-" + (fillDateMonth < 10 ? "0" : "") + fillDateMonth + "-" + (fillDateDay < 10 ? "0" : "") + fillDateDay; 
    	
    	var isCheckDateFrom = checkDate(checkDateFrom);
    	var isCheckDateTo = checkDate(checkDateTo);
    	var isFillDate = checkDate(fillDate);
    	
    	
    	if(!isCheckDateFrom||!isCheckDateTo||!isFillDate){
    		layer.msg("输入的日期不合法或者缺少必填项!", {time: 2000}, function() {});
    	}else if(contactName == ""){
    		layer.msg("联系人不能为空!", {time: 2000}, function() {});
    	}else if(contactTel == ""){
    		layer.msg("联系电话不能为空!", {time: 2000}, function() {});
    	}else if(deptment == ""){
    		layer.msg("落款不能为空!", {time: 2000}, function() {});
    	}else{
    		$("#checkDateFrom").val(checkDateFrom);
    		$("#checkDateTo").val(checkDateTo);
    		$("#fillDate").val(fillDate);
    		var searchParams = $("#taskForm").serializeObject();
    		http.httpRequest({
    			url: '/syn/sccheck/pubscentresult/doCommitNotice',
    			dataType:"json",  
    			contentType : 'application/json',
    			data: JSON.stringify(searchParams),
    			type:"post",
    			success: function (data) {
    				layer.msg(data.msg, {time: 1000}, function () {
    					if(data.status == 'success'){
    						$("#save").hide();
    						$("#print").show();
//    						$("#addColumn").removeAttr("id");
//    						$("#save").prop("disabled",true);
    					}
    				});
    			}
    		});
    	}
    	
    }
    
    function bind() {
    	var num = $("#num").val();
    	if(num==""){
    		num = 1;
    	}
        util.bindEvents([{
            el: '#save',
            event: 'click',
            handler: function () {
        		save();
            }
        },{
            el: '#print',
            event: 'click',
            handler: function () {
            	var resultUid = $("#resultUid").val();
            	var priPID = $("#priPID").val();
            	var _id = "_doPrint_"+new Date().getTime();
	            var url = "/syn/sccheck/pubscentresult/noticeprint?resultUid="+resultUid+"&priPID="+priPID;
	            try{
	                window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
	            }catch(e){
	                alert("打印错误!");
	            }
            }
        },{
            el: '#addColumn',
            event: 'click',
            handler: function () {
            	$(".ready").append("<p class='tindent24 h32'>（"+num+"）<input type='text' name='material"+num+"' class='ipt-txt2 w450'><i class='tzs-close-icon'></i> <a class='del'>删除</a></p>");
            	num++;
            }
        },{
            el: '.del',
            event: 'click',
            handler: function () {
            	$(this).parent().remove();
            }
        },{
            el: '#close',
            event: 'click',
            handler: function () {
            	layer.close({reload: true});
            }
        }]);
    }
});
