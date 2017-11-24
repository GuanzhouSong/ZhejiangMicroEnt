require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'jquery','laydate'
         ,'jquery.serialize','common/validateRules','common/ajaxfileupload'], function (layer, dataTable, util, http){

	var editor1;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initValue();
        bind();
    }
    
    function initValue(){
    	   editor1 = KindEditor.create('#text1', {
				cssPath : '/js/lib/kindeditor/plugins/code/prettify.css',
				uploadJson : '/js/common/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/js/common/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
			afterChange: function() {
				//字数统计
				KindEditor('#count').html(this.count("html")+" ").css('color', this.count("html")>3000?"red":"green");
			}
			});
    	   if(window._CONFIG.flag == 1){
	      		$(":radio").attr("disabled","disabled");
	    		$(":checkbox").attr("disabled","disabled");
	    		editor1.readonly(true);  //设置KindEditor不可编辑
    	   }
    }
    
	 function docheck(){
		 if ($.trim($("#title").val()) == "") {
             layer.alert("标题不能为空！");
             $("#title").focus();
             return false;
         } 
//		 if ($.trim($("input[name='bulType']:checked").val()) == "") {
//			 layer.alert("公告类型不能为空！");
//             return false;
//         }
		 if($("#bulType").val() == "1" && window._CONFIG.czflag == "insert"){//公示公告校验
			 if($("#bulScope option:selected").val() == '') {
				 layer.alert("请选择公告类型！");
	             return false; 
			 }
		 }
		 if($("#bulType").val() == "3" && window._CONFIG.czflag == "insert"){//警示公告时校验(新增时)
		 if ($.trim($("input[name='bulScope']:checked").val()) == "") {
			 layer.alert("公告范围不能为空！");
             return false;
         }
		 }
		 if(window._CONFIG.czflag == "update"){
			 if ($.trim($("input[name='isValid']:checked").val()) == "") {
				 layer.alert("请选择是否有效！");
	             return false;
	         }
		 }
		 var _html = editor1.html();

		 if ($.trim(_html) == "") {
			 layer.alert("内容不能为空！");
             return false;
         }
		 $("#text1").val(_html);
         var formParam = $('#form').serializeObject();
//         debugger
//         console.log(formParam);
		   http.httpRequest({
               url: window._CONFIG.chooseUrl+'/yr/bulletins/save',
               type: 'post',
               data: formParam,
               success: function (data) {
               	 layer.msg(data.msg, {time: 1000}, function () {
                     layer.close({reload: true});
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
	    var $files=$("#evidenceData"), filesArr=[], $upstate=$("#uploadState");
	    if($files.val() !=""){
	    	var val=$files.val().substring(0,$files.val().length-1);
	        filesArr=val.split("|");
	    }
	    function upload(e){
	    	var batchNo=$("#copyFormNo").val(), file=$("#file").val();
	    	if(file==""){
	    		layer.msg("请先选择需要上传的文件", {time: 1000}, function() {});
	    		return false;
	    	}
	    	var ext = file.substr(file.lastIndexOf("."),file.length).toLowerCase();
	    	if(!(ext.indexOf(".jpg") != -1 || ext.indexOf(".png") != -1)){
	    		layer.msg("请上传格式为jpg或png的图片！", {time: 3000}, function() {});
	    		return false;
	    	}
	    	
	    	if(contains_(filesArr, file)){
	    		layer.msg("您已经上传过此文件！", {time: 2000}, function() {});
	    		return false;
	    	}
	    	e.hide();$upstate.show();
	    	file = $("#bulType").val()+$("#setDeptCode").val()+new Date().getTime()+"-"+file;
	    	$.ajaxFileUpload({
	    		url: window._CONFIG.chooseUrl+'/yr/bulletins/upload',
	            type: 'post',
	            data: {"fileName":file},
	            secureuri: false,
	            fileElementId: 'btnFile',
	            dataType: 'text',
	            success: function(data, status){
	            	if(data == "false"){
	            		layer.msg("上传附件大小超过20M", {time: 2000}, function() {});
	            	}else if(data !="error") {
		            	//放入数组
	            		filesArr.push(data);
		            	var str="";
		            	for(var i=0; i<filesArr.length; i++){
		            		str=str+filesArr[i]+"|";
		            	}
		            	$files.val(str);
						var index = data.indexOf("-");
						var text = data.substring(index + 1, data.length);
						$("#filelabel").append("<p class='file-upload-out'><i class='xbt-icon file-icon'></i><label>"+text+"</label> &nbsp;&nbsp;<a href='javascript:void(0)' path='"+data+"'>删除</a></p>");
		            	layer.msg("上传成功", {time: 1200}, function() {});
	            	}else {
	            		layer.msg("上传失败", {time: 2000}, function() {});
	            	}
	            	$("#file").val("");
					//重置file选择
	            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile" style="width:450px;border: 1px solid #ccc;"/>');
	    			$upstate.hide();
	            	e.show();
	            },error: function(data, status){
	            	$("#file").val("");
					//重置file选择
	            	$("#fileBox").html("").append('<input type="file" id="btnFile" class="btnFile" name="btnFile" style="width:450px;border: 1px solid #ccc;"/>');
	    			$upstate.hide();
	            	e.show();
	            	layer.msg("上传失败，请检查网络及文件大小", {time: 2000}, function() {});
	            }
	        });
	    }
	    //委托事件
	    $("#fileBox").delegate('input','change',function(){
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
	    		if(filesArr[i] !=path){
	        		str=str+filesArr[i]+"|";
	    		}
	    	}
	    	$files.val(str);
	    	var val=$files.val().substring(0,$files.val().length-1);
	        filesArr=val.split("|");
	    	$(this).parent().remove();
		});
	 
	    
        $("#filelabel").delegate('span', 'click', function () {
            var path = $(this).attr("path");
            window.open(window._CONFIG.chooseUrl+"/yr/bulletins/view?fileName=" + path);
        });
	 
    function bind() {
    	  util.bindEvents([{
              el: '#submit',
              event: 'click',
              handler: function() {
            	  editor1.sync();
            	  docheck();
              }
          },
          {
               el: '#cancel',
               event: 'click',
               handler: function () {
                 layer.close();
            }
          }
    	  ]);
    }
});
