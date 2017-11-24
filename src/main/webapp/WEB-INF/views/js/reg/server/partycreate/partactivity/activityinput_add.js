require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize', 
         'common/ajaxfileupload'], function(layer, dataTable, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	init();
	//用于防止重复添加表格内容
	var contentjson={};
	var contentArr=[];
	//
	var $tb_ent=$("#tb_ent_bd"), $tb_man=$("#tb_man_bd");
	//类型（企业，自然人）
    var type=$("#punType").val();
	var $cause=$("#punCause");
	var $field=$("#punField");
    //loading
    var load=undefined;
    
	/**初始化函数集合*/
    function init() {
        bind();
    }  
    
    
    var i=0;
    var isum=0;
    //保存单据
    function save(){    	
    	var publishDeptName=$("#publishDeptName").val();
    	var publishDeptUID=$("#publishDeptUID").val();
    	if(publishDeptName==null||publishDeptName==""||publishDeptUID==""||publishDeptUID==null){
    		layer.msg("请选择活动发布部门", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var publishDate=$("#publishDate").val();
    	var requireEndDate=$("#requireEndDate").val();
    	if(publishDate == null || publishDate == ""){
    		layer.msg("请选择活动发布日期", {ltype: 0,time:3000}); 
  	   	     return false; 
    	}
    	
    	if(requireEndDate == null || requireEndDate == ""){
   		 layer.msg("请选择要求活动结束日期", {ltype: 0,time:3000}); 
  	   	     return false; 
   	    }	
		 var d1 = new Date(publishDate.replace(/\-/g, "\/"));  
	   	 var d2 = new Date(requireEndDate.replace(/\-/g, "\/")); 
	   	 if(d1 >d2){   
	   	  layer.msg("活动发布日期不能大于要求活动结束日期", {ltype: 0,time:3000}); 
	   	  return false;  
	   	 }
    	
    	var activityName = $.trim($("#activityName").val());
    	if(activityName==null || activityName==""){
    		layer.msg("请填写活动名称", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	var activityContent = $.trim($("#activityContent").val());
    	if(activityContent==null || activityContent==""){
    		layer.msg("请填写活动内容", {ltype: 0,time:3000}); 
    		return false;
    	}
	   	 
		var claimDeptName=$("#claimDeptName").val();
		var claimDeptUID=$("#claimDeptUID").val();
		if(claimDeptUID==null||claimDeptUID==""||claimDeptName==""||claimDeptName==null){
		layer.msg("请选择活动接收部门", {ltype: 0,time:3000}); 
			return false;
		}
	   	 var files = $("#files").val();
	   	 if(files == null || files=="" || files=="|"){
	   		layer.msg("请上传活动附件", {ltype: 0,time:3000}); 
		   	  return false;  
	   	 }
    	
    	$("#savebutton").attr("disabled",true);
    	load=layer.load();
    	$.ajax({
    		type : "POST",
			url : urlHead+'/party/partyactivityinfo/save',
			data : $('#content_form').serialize(),
			datatype : 'JSON',
			async : true,
			success : function(json) {
				layer.close(load);
				if(json.status=="success"){
					isum=1;
					layer.msg(json.msg, {time: 1500}, function() {
	                     layer.close({reload: true});
					});
				}else
					layer.msg(json.msg, {time: 4500}, function() {
						$("#savebutton").attr("disabled",false);
					});
			}
    	});
    }
    
    //判断附件是否已存在
    function contains_(array, str){
    	var index, text;
    	for(var i=0; i<array.length; i++){
    		index = array[i].indexOf("-");
			text = array[i].substring(index + 1, array[i].length);
    		if(text==str){
    			return true; 
    		}
    	}
    	return false;
    }
    
    //上传部分代码
    var $files=$("#files"), filesArr=[], $upstate=$("#uploadState");
    function upload(e){
//    	debugger
        //上传
    	var inputState=$("#inputState").val()+$("#inputCode").val()+new Date().getTime(), file=$("#file").val();
    	if(file==""){
    		layer.msg("请先选择需要上传的文件", {time: 3000}, function() {});
    		return false;
    	}
    	if(contains_(filesArr, file)){
    		layer.msg("您上传的文件已经在文件列表中，请先删除原文件再上传", {time: 3000}, function() {});
    		return false;
    	}
    	e.hide();$upstate.show();
    	$.ajaxFileUpload({
            url: urlHead+'/party/partyactivityinfo/uploadFile',
            type: 'post',
            data: {"fileName":inputState+"-"+file},
            secureuri: false,
            fileElementId: 'btnFile',
            dataType: 'text',
            success: function(data, status){
//            	debugger
            	if(data !="error") {
	            	//放入数组
	            	filesArr.push(data);
	            	var str="";
	            	for(var i=0; i<filesArr.length; i++){
	            		if(filesArr[i] !=""){
		            		str=str+filesArr[i]+"|";
	            		}
	            	}
	            	$files.val(str);
					var index = data.indexOf("-");
					var text = data.substring(index + 1, data.length);
					$("#filelabel").append("<p> <span path='"+data+"' style='color:blue;cursor:pointer' title='点击下载' ><i class='xbt-icon file-icon'></i>"+text
							+"</span> &nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"'>删除</a></p>");
	            	layer.msg("上传成功", {time: 1200}, function() {});
            	}else {
            		layer.msg("上传失败", {time: 2000}, function() {});
            	}
//            	debugger
            	$("#file").val("");
				//重置file选择
            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    			$upstate.hide();
            	e.show();
            },error: function(data, status){
            	$("#file").val("");
				//重置file选择
            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
    			$upstate.hide();
            	e.show();
            	layer.msg("上传失败，请检查网络及文件大小", {time: 3000}, function() {});
            }
        });
    }
    //委托事件
    $("#btnFile").delegate('input','change',function(){
//    	debugger
		var text=$(this).val();
		var index = text.lastIndexOf("\\");
		text = text.substring(index + 1, text.length);
		$("#file").val(text);
	})
    //上传
    $("#btnUpload").click(function(){
		upload($(this));
	})
	//删除附件
	$("#filelabel").delegate('a','click',function(){
		var path=$(this).attr("path");
		var str="";
    	for(var i=0; i<filesArr.length; i++){
    		if(filesArr[i] !=path && filesArr[i] != "" ){
        		str=str+filesArr[i]+"|";
    		}
    	}
    	$files.val(str);
    	var val=$files.val().substring(0,$files.val().length-1);
        filesArr=val.split("|");
    	$(this).parent().remove();
    	//重置（避免删除文件再接着上传同样的文件点击没反应的问题）
    	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
	});
    
    $("#filelabel").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.open(urlHead+"/party/partyactivityinfo/download?fileName=" + path);
    });
    
    
    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#chosePublishDept',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择活动发布部门',
                    area: ['68%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#publishDeptUID").val(data.orgCode);
                        	$("#publishDeptName").val(data.orgName);  
                    	}
                    }
            })
          }
        }, {
            el: '#choseClaimDept',
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择活动接收部门',
                    area: ['68%', '80%'],
                    content: '/reg/server/party/organize/chooseOrg',
                    callback: function (data) {
                    	if(data.returnCode == 'success'){
                        	$("#claimDeptUID").val(data.orgCode);
                        	$("#claimDeptName").val(data.orgName);
                    	}
                    }
            })
            }
        }, 
         {
            el: '#btnFile',
            event: 'change',
            handler: function() {
//            	debugger
            	var text=$(this).val();
        		var index = text.lastIndexOf("\\");
        		text = text.substring(index + 1, text.length);
        		$("#file").val(text);
            	upload($(this));
            }
        },
        {
            el: '#savebutton',
            event: 'click',
            handler: function() { 
            	save();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function() {
                layer.close();
            }
        }
        ])
    }

});