require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','common/validateRules','common/ajaxfileupload'], function(layer, dataTable, util, http, handlebars) {
	var data = new Object(); 
	init();
	 
	 function init(){
		 bind();
		 formValid();
	 }
	 
	 function formValid(){
	    	$('#content_form').validate({
	            rules: {
	            	firstName: { 
	                    required: true
	                },
	                firstOpin: { 
	                    required: true
	                }
	            },
	            messages: {},
	            onkeyup:false,
	            onfocusout:function(el){
	                $(el).valid();
	            },
	            showErrors:function(errorMap,errorList){
	                for(var i in errorMap){
	                    layer.tips(errorMap[i],$('#content_form input[name='+i+'],textarea[name='+i+']'),{
	                        tips:3,
	                        tipsMore:true,
	                        ltype:0
	                    });
	                }
	            },
	            submitHandler: function () {
	                	var formParam = $('#content_form').serializeObject();
	                    http.httpRequest({
	                        url: '/reg/server/seriouscrime/doSaveInFirstReview',
	                        serializable: false,
	                        data: formParam,
	                        type: 'post',
	                        success: function (json) {
	                        	if(json.status=="success"){
	                        		data.reload = true;
	        						layer.msg(json.msg, {time: 800}, function() {});
	        						layer.close(data);
	        					}else{
	        						layer.msg(json.msg, {time: 800}, function() {});
	        					}
	                        }
	                    });
	            }
	        })
	    	
	    }
	 
	   //事件绑定 
	    function bind() {
	        util.bindEvents([ {
	            el: '#cancel',
	            event: 'click',
	            handler: function() {
	            	layer.msg("您取消了编辑！", {time: 1000}, function() {});
	            	layer.close();
	            }
	        }, {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	$("#content_form").submit();
	            }
	        }, {
	            el: '.firstCheck',
	            event: 'click',
	            handler: function() {
	            	var check = $(this).val(); 
	            	if(check == '0')
	            		$("#firstOpin").val("不同意经办人意见，拟不予列入严重违法失信企业名单。");
	            	if(check == '1')
	            		$("#firstOpin").val("同意经办人意见，拟将其列入严重违法失信企业名单，请局领导审批。");
	            }
	        },{
	        	el:'#packUpOrUnFurled',
	        	event:"click",
	        	handler:function(){
	        		//展开收起箭头
					var $i=$(this).find('i');
					if($i.hasClass('tran-icons')){
						$i.removeClass('tran-icons').addClass('downarrow');
					}else{
						$i.removeClass('downarrow').addClass('tran-icons');
					}
	        		
	        		var text = $("#packUpOrUnFurled_").html();
	        		if(text=="收起"){
	        			$("#packUpOrUnFurled_").html("展开");
	        			$("#sevBreachInforTable").fadeOut();
	        			$("#h5").before("<br id='br'/>");
	        		}else if(text = "展开"){
	        			$("#packUpOrUnFurled_").html("收起");
	        			$("#sevBreachInforTable").fadeIn();
	        			$("#br").remove();
	        		}
	        	}
	        }
			])
	    }

})



