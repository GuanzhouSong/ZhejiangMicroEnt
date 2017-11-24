require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http', 'jquery','laydate','jquery.serialize','common/validateRules'], function (layer, dataTable, util, http){

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
		 if ($.trim($("input[name='bulType']:checked").val()) == "") {
			 layer.alert("公告类型不能为空！");
             return false;
         } 
		 if ($.trim($("input[name='bulScope']:checked").val()) == "") {
			 layer.alert("公告范围不能为空！");
             return false;
         } 
		 if ($.trim($("input[name='isValid']:checked").val()) == "") {
			 layer.alert("请选择是否有效！");
             return false;
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
               url: '/sment/bulletins/save',
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
