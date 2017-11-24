require(['component/iframeLayer', 'common/util', 'common/http','jquery', 'jquery.validate', 'jquery.serialize', 'laydate','common/validateRules'],
function(layer, util, http) {

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
    
    $("#licenceDetable td").bind("mouseover",function(){
		if($(this).find(".show").html()!=null 
				&& $(this).find(".show").html() != ""){
			$(this).find(".show").show();  
		}
    }).bind("mouseout",function(){
    	$(this).find(".show").hide();
    });
    
    
    function formValid(){
    	$("#auditForm").validate({
    		showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#auditForm input[name='+i+'],#auditForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
    		submitHandler:function(){
    			 layer.confirm('<span style="color:red">处罚决定书文号</span>信息一经公示后将不能修改与删除，请确认信息无误？', {icon: 2, title: '提示'}, function () {
	                  var formParam = $('#auditForm').serializeObject();
	                  var userType= $("#userType").val(); 
	                  var typeUrl="";
	                  if(userType=="2"){
	                	  typeUrl="/syn/server/other/pubohterlicence/auditOtherLinence";
	                  }else{
	                	  typeUrl="/reg/server/other/pubohterlicence/auditOtherLinence";
	                  }

	 				  http.httpRequest({
	 	                    url: typeUrl,
	 	                    serializable: false,
	 	                    data: formParam,
	 	                    type: 'post',
	 	                    success: function (data) {
	 	                    	 layer.msg(data.msg, function () {
	                                 layer.close({reload: true});
	                             }); 
	 	                  }
	 	               }) 
    			  })
    		 }
    	});
    } 
   
    
    function bind() {
        util.bindEvents([
        {
            el: '.js_detail',
            event: 'click',
            handler: function() {
            	var hisNO=this.id; 
            	layer.dialog({
                    title: '许可信息详情',
                    area: ['1000px', '660px'],
                    content:'/reg/server/other/pubohterlicenceHis/show?hisNO='+hisNO,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) { 
                        	  
                        }
                    }
                })
             }
        },{
        	el:'#cancel',
        	event:'click',
        	handler:function(){
        		layer.close({reload:true});
        	}
        	
        }])
    }

})