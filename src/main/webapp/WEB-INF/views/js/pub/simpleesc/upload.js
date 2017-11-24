require(['component/iframeLayer', 'common/util', 'common/http','layer1','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules','common/ajaxfileupload'],
function(layer, util, http,layer1) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	layer1.open({
            shade: [0.5,'#000'],
            type: 1,
            content: $('.simConfirm'),
            title: false,
            area: ['300px','100px']
         }) 
        bind();
    }
    
    function bind() {
        util.bindEvents([
        {
        	el: '.apply-save',
        	event: 'click',
        	handler: function () {
        		var saveType = $(this).attr("state");
        		if($("#entName").val() ==""){
        			layer.msg("请先填写企业名称！", {time: 3000}, function() {});
        			return false;
        		}
            	if($("#showfile").val() == ""){
            		layer.msg("请先上传全体投资人承诺书！", {time: 3000}, function() {});
            		return false;
            	}
        		var formParam = $('#simapplyform').serializeObject();
        		formParam.saveType = saveType;
        		if(saveType == "02"){
        			http.httpRequest({
        	            url: '/reg/client/simpleesc/erescappinfo/tipInfo',
        	            serializable: false,
        	            data: formParam,
        	            type: 'get',
        	            success: function (data) {
        	               if(data.status=='success'){
                        	   $("#noticefrom").text(dateFormate(data.data.noticeFrom));
                        	   $(".noticeto").text(dateFormate(data.data.noticeTo));
                        	   $(".tipTime").text(dateFormate(data.data.endDate));
            	           	   layer1.open({
            	                   shade: [0.5,'#000'],
            	                   type: 1,
            	                   content: $('.simConfirm'),
            	                   title: false,
            	                   area: ['600px','280px']
            	               }) 
        	                }
        	             }
        	        });
        		}else{
        			//保存
        			saveSimpleInfo(formParam);
        		 }
        	  }
        }])
    }
    
    $("#uploadfile").click(function(){
    	upload($(this));
    })
    
    $("#confirm").click(function(){
    	if($("#password").val() =='' || $("#password").val() !='1qazxc'){
    		alert("请输入正确的操作密码");
    		$("#password").focus();
    		return false;
    	}
    	layer1.closeAll();
    	$(".index-cont").show();
    })
    
    // 上传
	function upload(e){
    	var file = $("#commitment_file").val();
    	var prefix = $("#entName").val();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	
    	var ext = file.substr(file.lastIndexOf("."));
    	if(!(ext.indexOf(".jpg") != -1 || ext.indexOf(".JPG") != -1)){
    		layer.msg("请上传格式为jpg的图片！", {time: 3000}, function() {});
    		return false;
    	}
    	
    	var pos=file.lastIndexOf("\\");
    	file = file.substring(pos+1);
    	e.hide();
    	$("#uploading").show();
    	$.ajaxFileUpload({
            url: "/pub/infobulletin/upload",
            type: 'post',
            data: {"prefix":prefix},
            secureuri: false,
            fileElementId: 'commitment_file',
            dataType: 'text',
            success: function(data, status){
            	if(data !="error" && data != "false") {
            		// 限制路径结构，防止失败的上传返回值存入DB
            		if(data.indexOf("simpleesc/commitment") == -1){
            			layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            		}else{
            			$("#uploadurl").val(data);
                		$("#showfile").val(file);
                		$("#commitment_file").val("");
    	            	layer.msg("上传成功", {time: 1200}, function() {});
            		}
            	}else if(data == "error"){
            		layer.msg("上传失败", {time: 2000}, function() {});
            	}else if(data == "false"){
            		layer.msg("上传的文件大小不能超过5M", {time: 2000}, function() {});
            	}
            	$("#uploading").hide();
            	e.show();
            },error: function(data, status){
            	$("#uploading").hide();
            	e.show();
            	layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            }
        });
    }
    
    function saveSimpleInfo(formParam){
		http.httpRequest({
            url: '/pub/infobulletin/save',
            serializable: false,
            data: formParam,
            type: 'get',
            success: function (data) {
           	 if(data.status == 'error'){
           		 layer.msg(data.msg, {time: 2000}); 
           	 }else{
               	 layer.msg(data.msg, {time: 2000});
                }
            }
        });
    }

})