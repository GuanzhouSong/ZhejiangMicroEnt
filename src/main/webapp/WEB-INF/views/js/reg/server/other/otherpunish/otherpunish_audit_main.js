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
    	$("#punishform").validate({
    		submitHandler:function(){
    			if($("#punishform input[name ='auditState']:checked").length == 0){
 			    	  layer.tips("请先选择审核结果","#checksuc",{tips:3,tipsMore:true,ltype:0});
 			    	  return false;
 			     }
    			 layer.confirm('<span style="color:red">处罚决定书文号</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
	                  var formParam = $('#punishform').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl="/syn/server/pubotherpunish/commit";
	                  }else{
	                	  typeUrl="/pub/server/pubotherpunish/commit"
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
	 	                    	layer.msg(data.msg);
	 	                    }
	 	                  }
	 	               }) 
    			  })
    		 }
    	});
    }
    
    //处罚类型初始化处理
    function initData(){
    	$(":checkbox").attr("onclick","return false;");
    	var val = $("#penType").val();
    	if(val != ""){
			var punFormVal = [];
			punFormVal = val.split(",");
			for(var i = 0; i < punFormVal.length; i++){
				$(":checkbox").each(function(k,n){
					if(punFormVal[i] == $(n).val()){
						$(n).prop("checked",true);
						if(punFormVal[i] == 2){
							$(".penAm").show();//显示罚款金额
						}
						if(punFormVal[i] == 3){
							$(".forfAm").show();//显示没收金额
						}
					}
				});
			}
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
            	layer.close();
             }
        }])
    }

})