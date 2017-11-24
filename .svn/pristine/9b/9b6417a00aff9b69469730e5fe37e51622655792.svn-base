require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize', 
         'common/ajaxfileupload'], function(layer, dataTable, util, http) {
	
	var urlHead=window._CONFIG.urlHead;
	init();
    //loading
    var load=undefined;
    
	/**初始化函数集合*/
    function init() {
        bind();
    }  
    
    
    var i=0;
    var isum=0;
    //保存
    function save(){
//    	debugger
    	var activityPlace=$.trim($("#activityPlace").val());
    	if(activityPlace==null||activityPlace == ""){
    		layer.msg("请填写活动地点", {ltype: 0,time:3000}); 
        	return false;
    	}
    	
    	//发布日期
    	var publishDate =$("#publishDate").val();
    	//要求结束时间
    	var requireEndDate =$("#requireEndDate").val();
    	
    	var activitybeginDate=$("#activitybeginDate").val();
    	var activityEndDate=$("#activityEndDate").val();
    	if(activitybeginDate == null || activitybeginDate == ""){
    		layer.msg("请选择活动开始日期", {ltype: 0,time:3000}); 
  	   	     return false; 
    	}
    	
    	if(activityEndDate == null || activityEndDate == ""){
   		 layer.msg("请选择活动结束日期", {ltype: 0,time:3000}); 
  	   	     return false; 
   	    }
    	
		 var d1 = new Date(activitybeginDate.replace(/\-/g, "\/"));  
	   	 var d2 = new Date(activityEndDate.replace(/\-/g, "\/")); 
	   	 if(d1 >d2){   
	   	  layer.msg("活动开始日期不能晚于活动结束日期", {ltype: 0,time:3000}); 
	   	  return false;  
	   	 }
	   	 var d3 = new Date(publishDate.replace(/\-/g, "\/"));  
	   	 var d4 = new Date(requireEndDate.replace(/\-/g, "\/")); 
	   	 if(d1 <d3 || d1 >d4){   
	   		 layer.msg("活动开始日期需在活动发布日期和要求活动结束日期之间", {ltype: 0,time:3000}); 
	   		 return false;  
	   	 }
	   	 if(d2 <d3 || d2 >d4){   
	   		 layer.msg("活动结束日期需在活动发布日期和要求活动结束日期之间", {ltype: 0,time:3000}); 
	   		 return false;  
	   	 }
    	
    	var originator = $.trim($("#originator").val());
    	var originatorID = $.trim($("#originatorID").val());
    	if(originator==null || originator==""){
    		layer.msg("请选择活动发起人", {ltype: 0,time:3000}); 
        	return false;
    	}
	   	 
		var joiner=$("#joiner").val();
		var joinerId=$("#joinerId").val();
		if(joinerId==null||joinerId==""||joiner==""||joiner==null){
		layer.msg("请选择活动参与人", {ltype: 0,time:3000}); 
			return false;
		}
		
    	var activitySituation = $.trim($("#activitySituation").val());
    	if(activitySituation==null || activitySituation==""){
    		layer.msg("请填写活动情况", {ltype: 0,time:3000}); 
    		return false;
    	}
    	
	   	 var files = $("#files").val();
	   	 if(files == null || files=="" || files=="|"){
	   		layer.msg("请上传结果附件", {ltype: 0,time:3000}); 
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
    if($files.val() !=""){
    	var val=$files.val().substring(0,$files.val().length-1);
        filesArr=val.split("|");
    }
    function upload(e){
        //上传
    	var inputState=$("#inputState").val()+$("#resultInputCode").val()+new Date().getTime(), file=$("#file").val();
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
	            		if(filesArr[i]!=""){
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
	
	//删除附件
	$("#filelabel").delegate('a','click',function(){
		var path=$(this).attr("path");
		var str="";
    	for(var i=0; i<filesArr.length; i++){
    		if(filesArr[i] !=path && filesArr[i] != ""){
        		str=str+filesArr[i]+"|";
    		}
    	}
    	$files.val(str);
    	var val=$files.val().substring(0,$files.val().length-1);
        filesArr=val.split("|");
    	$(this).parent().remove();
		//重置file选择
    	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile"/>');
	});
    
    $("#upfile").delegate('span', 'click', function () {
        var path = $(this).attr("path");
        window.open(urlHead+"/party/partyactivityinfo/download?fileName=" + path);
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
            el: '#chooseoriginator', //单选
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择发起人员',
                    area: ['40%', '72%'],
                    content: '/reg/server/party/partyactivityinfo/chooseMembers?partyOrgID='+$("#claimDeptUID").val()+"&operateType=1",
                    callback: function (data) {
                    	if(data.reload != false && data.uids !="" && data.memberNames !=""){
                        	$("#originatorID").val(data.uids);
                        	$("#originator").val(data.memberNames);
                    	}
                    }
            })
            }
        },
        {
            el: '#choosejoiner',//参与人员多选
            event: 'click',
            handler: function() {
                layer.dialog({
                    title: '选择参与人员',
                    area: ['40%', '72%'],
                    content: '/reg/server/party/partyactivityinfo/chooseMembers?partyOrgID='+$("#claimDeptUID").val()+"&operateType=2",
                    callback: function (data) {
                    	if(data.reload != false && data.uids !="" && data.memberNames !="" ){
                    		$("#joinerId").val(data.uids);
                        	$("#joiner").val(data.memberNames);
                        	$("#joinNum").val(data.num);
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