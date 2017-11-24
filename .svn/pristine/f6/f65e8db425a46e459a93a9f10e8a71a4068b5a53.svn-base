require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	 init();
	    /**
	     * 初始化函数集合
	     */
	    function init() {
	    	showcheckedCheckbox();
	        bind();
	    }
	    
	    function showcheckedCheckbox(){
	    	$("input").each(function(){
	    		var code = $(this).val();
	    		var superCode = $(this).prop("superCode");
	    		var remark = $(this).attr("remark");
	    		var ownType = $(this).attr("ownType");
	    		var hireType = $(this).attr("hireType");
	    		var otherType = $(this).attr("otherType");
	    		if(code == "18.1"){
	    			code = "18_1";
	    		}
	    		if(code == "18.2"){
	    			code = "18_2";
	    		}
	    		$("#id_"+code).attr("checked","checked");
	    		if(code == "35" || code == "53"){
	    			$("#id_span_"+code).text(remark);
	    		}
	    		if(code == "51" || code == "52" || code == "53"){
	    			if(ownType == "1"){
	    				$("#id_own_"+code).attr("checked","checked");
	    			}
	    			if(hireType == "1"){
	    				$("#id_hire_"+code).attr("checked","checked");
	    			}
	    			if(otherType == "1"){
	    				$("#id_other_"+code).attr("checked","checked");
	    			}
	    		}
	    	});
	    }
	    
	    
	  //按钮事件
	    function bind() {
	        util.bindEvents([{
	        	el: '#cancel',
	            event: 'click',
	            handler: function () {
	            	 layer.close();
	            }
	        }]);
	    }
});
