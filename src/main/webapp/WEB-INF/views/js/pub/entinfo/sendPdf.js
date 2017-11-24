require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'qrcode',
    'common/validateRules',
    'jquery.serialize'
], function (layer, util, http,handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {

        bind();
    }

    //按钮事件
    function bind() {
        util.bindEvents([
            {
                el: '#sendPdf', //发送报告
                event: 'click',
                handler: function () {
                    $("#sendPdfInfo").show();
                    layer.dialog({
                        title: ['发送报告','background:#d5b661'],
                        shadeClose: true, //是否点击遮罩关闭
                        closeBtn: 1,      //显示小叉按钮
                        content: $('#sendPdfInfo'),
                        type: 1,         //显示页面
                        area: ['320','170'] //高度和宽度
                    });

                }
            },{
            el:'#sureSend',
            event:'click',
            handler:function(){
            	var receiver=$("#sendEmail").val();
            	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; 
            	 if(receiver==null||receiver==""){
            		layer.msg("请输入要接收的邮箱");
            		return false;
            	}
            	if(!reg.test(receiver)){
            		layer.msg("邮箱格式不正确"); 
            		return false;
            	} 
                
				  http.httpRequest({
	                    url:"/midbranch/createPdf",
	                    serializable: false, 
	                    data: { params:{ "priPID":$("#priPID").val() },"priPID":$("#priPID").val(),"receiver":receiver},
	                    type: 'post',
	                    success: function (data) {
	                    	if(data.status == 'success'){
		                		layer.msg(data.msg, {time: 1000}, function () { 
		                			$("#sendEmail").val("");
		                		 
		                	  })
	 	                    }else{
	 	                    	layer.msg(data.msg);
	 	                    }
	 	                  }
	               })  
            	$("#sendPdfInfo").hide();
       		    layer.closeAll();
            	
            	
            	
              }
            },{
            	el:"#cancelSend",
            	event:'click',
            	handler:function(){
            		 $("#sendPdfInfo").hide();
            		 layer.closeAll();
            	}
            	
            }
            
        ])
    }
});


