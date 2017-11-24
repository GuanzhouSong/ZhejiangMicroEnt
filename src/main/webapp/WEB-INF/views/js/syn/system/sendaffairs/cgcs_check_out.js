require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'jquery','jquery.serialize', 'common/validateRules','jquery.icinfo'], function(layer, dataTable, util, http) {
	var infojson={};  
	var _urlHead = window._CONFIG._urlHead;
	var state = $("#state").val();
	if(state == "illegal"){
		$("#check").show();
		$("#cardtype").attr("disabled",true);
	}
	
	if(state == "other"){
		$("#check").show();
		
		$("#cardtype").bind("change",function(){
			var cardno = $("#cardtype option:selected").attr("code");
			if(cardno=="0"){
				$("#check").show();
			}else{
				$("#check").hide();
			}
			
			if(cardno=="1"){
				 $("#cardno").rules("add", "idCard");		
			}else{
				 $("#cardno").rules("remove", "idCard");
			}
			
		});
		
		
	}
	
	
	init();
	
	   function init() {
		   formValid();
	        bind();
	    }
	   
	   
	   function formValid(){
	    	$('#content_form').validate({
	            rules: {
	            	entName: { 
	                    required: true
	                },
	                cardno: { 
	                    required: true
	                },
	                address: { 
	                    required: true
	                },
	                tel: { 
	                    required: true
	                }
	            },
	            messages: {
	            	entName: {
	                    required: '当事人名称不能为空'
	                },
	                cardno: {
	                    required: '证件号不能为空',
	                    idCard:'身份证号格式错误'
	                },
	                address: {
	                    required: '当事人地址不能为空'
	                },
	                tel: {
	                    required: '当事人联系电话不能为空'
	                }
	            },
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

	            }
	        })
	    	
	    }
		
	   
	   function selectEntInfo(){
		   var name=$("#entName").val();
	    	if (name.replace(/(^\s*)|(\s*$)/g, "") != "") {
	    		$.ajax({
		    		type : "POST",
					url : _urlHead+'getEnt',
					datatype : 'JSON',
					data:{'entName':name},
					async : true,
					success : function(json) {
						if(json != ""&&json != null){
							$("#cardtype option").removeAttr("selected");
							$("#cardtype option[code='0']").attr("selected",true);
							$("#cardno").val(json.regNO);
						}else
							layer.msg("没有查询到结果", {time: 1500}, function() {});
					}
	    		});
	    	}else{
	    		layer.msg("当事人名称不能为空！", {time: 1500}, function() {});
	    	}
	   }

	   
	   //事件绑定
	    function bind() {
	        util.bindEvents([ {
	            el: '#check',
	            event: 'click',
	            handler: function() {
	                	selectEntInfo();
	            }
	        }, {
	            el: '#save',
	            event: 'click',
	            handler: function() {
	            	// $("#content_form").submit();
					if($('#content_form').valid()){
						infojson={"entName":$("#entName").val(),"cardtype":$("#cardtype").val(),"cardcode":$("#cardtype>option:selected").attr("code"),"cardno":$("#cardno").val(),"address":$("#address").val(),"tel":$("#tel").val()};
						layer.close(infojson);
					}
	            }
	        }, {
	            el: '#close',
	            event: 'click',
	            handler: function() {
	            	layer.close();
	            }
	        }, {
	            el: '#have_card',
	            event: 'change',
	            handler: function() {
	            	var card = $("#have_card>option:selected").val();
	            	if(card!=1&&card!=2){
	            		$("#check").show();
	            	}else{
	            		$("#check").hide();
	            	}
	            }
	        }])
	    }
})
