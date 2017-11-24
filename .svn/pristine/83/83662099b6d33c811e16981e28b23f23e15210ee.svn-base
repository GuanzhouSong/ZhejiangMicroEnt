

require(['component/iframeLayer', 'component/dataTable','common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	init();
    /**
	 * 初始化函数集合
	 */
    function init() {
        bind();
    }
    var step = 1;
    var timer;
    function bind() {
        util.bindEvents([{
        	 el: '#random',
             event: 'click',
             handler: function () {
            	 $("#random").hide();
            	 $("#cancel").show();
            	var num = $("#num").val();
            	$("#i5").html("0");
        		$("#i4").html("0");
        		$("#i3").html("0");
        		$("#i2").html("0");
        		$("#i1").html("0");
        		step = 1;
             	if(num <= 99999){
             		timer = window.setInterval(function(){
             			if(step <= num){
             				var strStep = ""+step;
             				var html = "";
             				if(strStep.length == 1){
             					html = "0000"+strStep;
             				}else if(strStep.length == 2){
             					html = "000"+strStep;
             				}else if(strStep.length == 3){
             					html = "00"+strStep;
             				}else if(strStep.length == 4){
             					html = "0"+strStep;
             				}else if(strStep.length == 5){
             					html = strStep;
             				}
             				$("#i5").html(html.substring(0,1));
             				$("#i4").html(html.substring(1,2));
             				$("#i3").html(html.substring(2,3));
             				$("#i2").html(html.substring(3,4));
             				$("#i1").html(html.substring(4,5));
             				step ++;
             			}else{
             				window.clearInterval(timer);
             				$("#next").show();
             				$("#random").hide();
             				$("#cancel").hide();
             			}
             		},10); 
             	}
             	
             }
        },{
       	 el: '#cancel',
         event: 'click',
         handler: function () {
        	 window.clearInterval(timer);
        	 $("#random").show();
        	 $("#cancel").hide();
         }
        },{
	      	 el: '#next',
	         event: 'click',
	         handler: function () {
	        	 var userType = $("#userType").val();
	        		var url = '/reg/pub/server/sccheck/entback/lock';
	        		if(userType == '2'){
	        			url = '/syn/pub/server/sccheck/entback/lock';
	        		}
        		 var taskUid = $("#taskUid").val();
	        	 layer.dialog({
	                    title: '锁定名单',
	                    area: ['100%', '100%'],
	                    content: url+'?taskUid='+taskUid,
	                    callback: function (data) {
	                    	if(data.flag){
	                    		$("#i5").html("0");
	                    		$("#i4").html("0");
	                    		$("#i3").html("0");
	                    		$("#i2").html("0");
	                    		$("#i1").html("0");
	                    		step = 1;
	                    		$("#random").show();
	                    		$("#cancel").hide();
	                    		$("#next").hide();
	    					}else{
	    						layer.close({reload:true});
	    					}
	                    }
	                });
	         }
        }]);
    }
});
