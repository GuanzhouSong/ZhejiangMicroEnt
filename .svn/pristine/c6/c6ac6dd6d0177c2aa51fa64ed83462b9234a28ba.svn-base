require(['component/iframeLayer','component/dataTable', 'common/util', 'common/http','handlebars','jquery','jquery.serialize','laydate','tab'], function (layer,dataTable, util, http,handlebars) {
	var uid = $("#uid").val();
	init();
	 
	 function init(){
		 bind();
	 }
	 
	   //事件绑定 
	    function bind() {
	        util.bindEvents([ {
	            el: '#close',
	            event: 'click',
	            handler: function() {
	            	layer.msg("已关闭！", {time: 1000}, function() {});
	            	layer.close();
	            }
	        }, {
	            el: '#decide',
	            event: 'click',
	            handler: function() {
	            	window.open("/reg/server/seriouscrime/doEnExpManageDecision?uid="+uid,"_blank");
	            }
	        }, {
	            el: '#approval',
	            event: 'click',
	            handler: function() {
	            	window.open("/reg/server/seriouscrime/doEnExpManageApproval?uid="+uid,"_blank");
	            }
	        },{
	        	el:'#packUpOrUnFurled',
	        	event:'click',
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
	        		}else if(text = "展开"){
	        			$("#packUpOrUnFurled_").html("收起");
	        			$("#sevBreachInforTable").fadeIn();
	        		}
	        		
	        	}
	        },{
	        	el:'#detail_2',
	        	event:'click',
	        	handler:function(){
	        		var entNameDesc = $("#entNameDesc").val();
	        		var UID = $("#UID").val();
	        		var pubTypeDesc = $("#pubTypeDesc").val();
	        		window.open("/pub/infobulletin/showDetails?UID="+UID+"&pubType="+pubTypeDesc+"&entName="+entNameDesc);
//	        		window.open("http://zj.gsxt.gov.cn/pub/infobulletin/showDetails?UID="+UID+"&pubType="+pubTypeDesc+"&entName="+entNameDesc);
	        	}
	        },{
	        	el:'#detail_1',
	        	event:'click',
	        	handler:function(){
	        		var sourceId = $("#sourceId").val();
	        		window.open("/reg/server/opanomaly/pubopanomaly/pubOpanoPrintJDBook?busExcList="+sourceId);
	        	}
	        }
			])
	    }

})



