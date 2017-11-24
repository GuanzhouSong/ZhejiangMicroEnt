require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {
	
	var isAudit = window._CONFIG.isAudit;
	if(isAudit == '1'){
		$("#savetable input").attr("readonly",true).attr("onclick","return false");
		$("#favType").attr("disabled",true);
		$("#remark").attr("readonly",true);
	}
	
    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//时间绑定
        bind();
        //提交
        formValid(); 
    }
    
    function formValid(){
    	$("#favorableForm").validate({
    		showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#favorableForm input[name='+i+'],#favorableForm select[name='+i+'],#favorableForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
    		submitHandler:function(){
    			 if($("#licZoneDiv input[type = 'radio']:checked").length == 0){
    				 layer.tips("请选择信息级别",$('#tip'),{tips:3,tipsMore:true,ltype:0});
    				 return false;
    			 }
    			 if(isAudit == '1' && $("#auditDiv input[type = 'radio']:checked").length == 0){
    				 layer.tips("请选择审核结果",$('#pass'),{tips:3,tipsMore:true,ltype:0});
    				 return false;
    			 }
    			 if (new Date($("#regFrom").val().replace(/-/g, "/")) > new Date($("#regTo").val().replace(/-/g, "/"))) {
 		        	layer.tips("有效开始日期不能晚于有效结束日期！",$('#regFrom'),{tips:3,tipsMore:true,ltype:0});
 		            return false;
 		        }
    			 layer.confirm('<span style="color:red">认定发布文号</span>一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
	                  var formParam = $('#favorableForm').serializeObject();
	                  var httpUrl = window._CONFIG.url + "/favorableinput/saveOrEdit";
	                  if(isAudit == '1'){
	                	  httpUrl = window._CONFIG.url + "/favorableaudit/commit";
	                  }
	 				  http.httpRequest({
	 	                    url: httpUrl,
	 	                    serializable: false,
	 	                    data: formParam,
	 	                    type: 'post',
	 	                    success: function (data) {
	 	                    if(data.status == 'success'){
		                		layer.msg(data.msg, {time: 1000}, function () {
		                			layer.close({reload:true});
		                	    })
	 	                    }else
	 	                    	    layer.msg(data.msg);
	 	                   }
	 	             }) 
    			 })
    		 }
    	});
    }
    
    $("#pass,#nopass").click(function(){
    	if($(this).val() == '1'){
    		$("#auditOpin").html("").val("审核通过");
    	}else{
    		$("#auditOpin").html("").val("审核不通过");
    	}
    })
     
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close();
            }
       },{
           el: '#longLic',
           event: 'click',
           handler: function() {
        	   if($(this).prop("checked")){
        		   $("#regTo").val('9999-12-31');
        	   }else{
        		   $("#regTo").val('');
        	   }
           }
      },{
           el: '#choseDept',
           event: 'click',
           handler: function () {
               layer.dialog({
                   title: '选择部门',
                   area: ['400px', '600px'],
                   content: window._CONFIG.select_detp_tree_url,
                   callback: function (data) {
                       $("#regDept").val(data.deptCode);
                       $("#regDeptCn").val(data.deptName);
                   }
               })
           }
       }])
    }

})