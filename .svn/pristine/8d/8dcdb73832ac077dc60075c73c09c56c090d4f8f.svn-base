require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    
    function init() {
    	//初始化
    	initData();
    	//时间绑定
        bind();
        //提交
        formValid(); 
    }
    
    
    function formValid(){
    	$("#justiceInfoForm").validate({
    		submitHandler:function(){
    			      if($("#justiceInfoForm input[name ='auditState']:checked").length == 0){
    			    	  layer.tips("请先选择审核结果","#checksuc",{tips:3,tipsMore:true,ltype:0});
    			    	  return false;
    			      }
	                  var formParam = $('#justiceInfoForm').serializeObject();
	                  var userType= $("#userType").val();
	                  var typeUrl="/reg/other/pubjusticeinfoaudit/commit";
	                  if(userType=="2"){
	                	  typeUrl="/syn/other/pubjusticeinfoaudit/commit";
	                  }  
	 				  http.httpRequest({
	 	                    url:typeUrl,
	 	                    serializable: false,
	 	                    data: formParam,
	 	                    type: 'post',
	 	                    success: function (data) {
	 	                    if(data.status == 'success'){
		                		layer.msg(data.msg, {time: 1000}, function () {
		                			layer.close({reload:true});
		                	  })
	 	                    }else{
	 	                    	layer.msg(data.msg, {time: 1500}, function () {})
	 	                    }
	 	                }
    			  })
    		 }
    	});
    }
    
    //处罚类型初始化处理
    function initData(){
    	$(".commonType").hide();
    	var obj = $("#executeItem").val();
		if(obj == "1" || obj == "2"){
			$(".froType").show();
		}else if(obj == "3"){
			$(".thawType").show();
		}else if(obj == "4"){
			$(".alienType").show();
		}
    }
    
    $("#checksuc").click(function(){
    	if($(this).prop("checked")){$("#auditOpin").val("同意");}
    })
    $("#checkfal").click(function(){
    	if($(this).prop("checked")){$("#auditOpin").val("不同意");}
    })
    
    function bind() {
        util.bindEvents([
        {
            el: '#cancel',
            event: 'click',
            handler: function() {
            	layer.close({reload:true});
             }
        }])
    }

})