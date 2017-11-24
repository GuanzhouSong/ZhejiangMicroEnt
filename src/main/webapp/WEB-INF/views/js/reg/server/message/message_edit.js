require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'jquery','laydate','jquery.serialize','common/validateRules'], function (layer, dataTable, util, http){
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r != null) return unescape(r[2]); return null; //返回参数值
	}
	
	var checkAllEnt = getUrlParam("checkAllEnt");
	
	var editor1;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initValue();
        bind();
        queryLoginUserInfo();
        $("#sendTime").val(getNowDate());
    }
    
    function getNowDate(){
    	var date = new Date(); 
    	var mon = date.getMonth() + 1;
    	var day = date.getDate();
    	var nowDate = date.getFullYear() + "-" + (mon<10?"0"+mon:mon) + "-" +(day<10?"0"+day:day);
    	return nowDate;
    }
    
    function queryLoginUserInfo(){
    	http.httpRequest({
            url: '/reg/message/queryLoginUserInfo.json',
            type: 'post',
            success: function(data) {
	            	if(data && data.status == "success"){
	            		var userId = data.data.id;
	            		var realName = data.data.realName;
	            		var deptDID = data.data.departMent.deptDID;
	            		var deptName = data.data.departMent.deptName;
	            		
	            		$("input[id='sendId']").val(userId);
	            		$("input[id='sendDeptId']").val(deptDID);
	            		$("input[id='sendDeptName']").val(deptName);
	            		$("input[id='sendName']").val(realName);
	            		
	            	}
	            }
            })
    }
    
    function initValue(){
    	if(!checkAllEnt){
    		var priPIDs =  sessionStorage.getItem("priPIDs");
    		var entNames =  sessionStorage.getItem("entNames");
    		$("#priPIDs").val(priPIDs);
    		$("#entNames").val(entNames);
    	}else{
    		$("#checkAllEnt").val(checkAllEnt);
    	}
	   
	   editor1 = KindEditor.create('#msgContent', {
			cssPath : '/js/lib/kindeditor/plugins/code/prettify.css',
			uploadJson : '/js/common/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '/js/common/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			items:['undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
		        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
		        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
		        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', 
		        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
		        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 
		         'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
		        'anchor', 'link', 'unlink', '|', 'about']
		});
    }
    
	 function docheck(){
		 if ($.trim($("#msgTitle").val()) == "") {
             layer.alert("消息标题不能为空！");
             $("#msgTitle").focus();
             return false;
         } 
		 if ($.trim($("#msgAbstract").val()) == "") {
             layer.alert("消息摘要不能为空！");
             $("#msgAbstract").focus();
             return false;
         }
		 var _html = editor1.html();
		 var _text = editor1.text();
		 if ($.trim(_text) == "") {
			 layer.alert("消息内容不能为空！");
             return false;
         }
		 $("#msgContent").val(_html);
           var formParam = $('#webform').serializeArray();
           var queryParam = (checkAllEnt?JSON.parse(sessionStorage.getItem("searchParams")):{});
           if(queryParam){
        	   $.each(queryParam,function(k, v) {
        		   var keyName = "paramMap['"+k+"']";
        		   formParam.push({"name":keyName,"value":v})
       		   });
           }
           debugger;
		   http.httpRequest({
               url: '/reg/message/saveOrUpdate',
               type: 'post',
               data: formParam,
               success: function (data) {
               	 layer.msg(data.msg, {time: 1000}, function () {
                     layer.close({reload: true});
                 });
               }
           });
	 }
	
    
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
