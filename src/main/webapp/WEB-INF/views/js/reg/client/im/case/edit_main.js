require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','laydate', 'jquery.placeholder',
         'jquery.icinfo'], function (layer, util, http) {
	 $('input, textarea').placeholder(); 
    init();

    /**
     * 初始化函数集合
     */

    function init() {
    	 $.extend($.validator.messages, {
      		required: "请输入文本值", 
      		number: "请输入有效的数字",
      		digits: "只能输入数字",
      	    maxlength: $.validator.format("最多可以输入 {0} 个字符"),
      		minlength: $.validator.format("最少要输入 {0} 个字符"),
      	    range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
      		 
      	});  
     	
    	
        formValid();
        bind();
        $(":checkbox[name=chose]:checked").each(function(){
        	if(this.title=="罚款"){
        		$("#penAm").show();
        	}
        	if(this.title=="没收违法所得和非法财物"){
        		$("#forfAm").show();
        	}
        });
        initTbl();
    }
    
    function initTbl(){
      	 
   	 $(".assetItem").each(function() {
	    	var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
	        if(v != "" && v != null){
	        	$(this).val(parseFloat((isNaN(v) ? "0.0000" : v) - 0).toFixed(4));
	        } 
	    }); 
	
   	
   	$(".assetItem").focus(function() {
           var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
          
       }).blur(function() {
       	var v = $.trim($(this).val());
           if(v != "" && v != null){
           	v = v.replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
           	$(this).val(parseFloat((v == "" || isNaN(v) ? "0.0000" : v) - 0).toFixed(4));
           	   var reg = /^[\-\+]?\d+(\.\d{1,4})?$/; 
           	if (!reg.test(v)) {
               	 layer.tips('请重新输入!例1.2333',$(this),{tips:3, tipsMore:true, ltype:0});
                   $(this).focus().addClass("warn");
                   return false;
               }

               $(this).val(parseFloat(v).toFixed(4));
               if (v == "") {
                   $(this).val(0.00);
               } 
           } 
       });  
   	  
   } 
   
 
    laydate.skin('molv');//初始化皮肤
    var end = {
            elem: '#penDecIssDate',
            format: 'YYYY-MM-DD',
            min: '1970-01-01',
            max: "2099-12-31", //最大日期 //最大日期
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             //结束日选好后，重置开始日的最大日期
            }
        };

        //开始时间和结束时间
        $("#penDecIssDate").click(function(){laydate(end);});

    
    $(":checkbox[name=chose]").click(function(){
    	//alert(this.title+"dd"+$(this).is(":checked"));
    	 if(this.title=="罚款"&&$(this).is(":checked")==true){
    		 $("#penAm").show();
    		 $("#penAmT").addClass("required number");
    	 }
    	 if(this.title=="罚款"&&$(this).is(":checked")==false){
    		 $("#penAm").hide();
    		 $("#penAmT").removeClass("required number");
    	 }
    	 if(this.title=="没收违法所得和非法财物"&&$(this).is(":checked")==true){
    		 $("#forfAm").show();
    		 $("#forfAmT").addClass("required number");
    	 }
    	 
    	 if(this.title=="没收违法所得和非法财物"&&$(this).is(":checked")==false){
    		 $("#forfAm").hide();
    		 $("#forfAmT").removeClass("required number")
    	 }
    	 
    	 
    	 
    	 
    	
    	
    });
    /**
     * 表单验证
     */
    function formValid() {
        $('#caseForm').validate({
        	onkeyup:false,
            rules: {
            	penDecNo: {
                    required: true,
                    maxlength:50
                },
                judAuth: {
                    required: true,
                    maxlength:100
                },
                illegActType: {
                    required: true,
                    maxlength:200
                },
                penContent: {
                    required: true
                },
                penDecIssDate: {
                    required: true
                },
                chose:{
                	required:true
                } 
            },
            messages:{ 
            	penDecIssDate:"请选择日期",
            	chose:"请选择处罚种类"
            },
            
            
            showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#caseForm input[name='+i+'],#caseForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
            
            submitHandler: function () {  
                var names=new Array();
           	   var values=new Array();
                $(":checkbox[name=chose]:checked").each(function(k,v){
                  	names[k]= this.title;
            		 values[k]=this.value;
                }); 
                $("#penTypeCN").val(names.toString());
                $("#penType").val(values.toString());
                if( $("#penType").val()==""|| $("#penType").val()==null){
                	 layer.msg("请选择处罚种类", {time: 1000}, function () {
                      
                     });
                	 return false;
                } 
                var formParam = $('#caseForm').serializeObject();
                $("#submitButton").attr("disabled", true);
				 $("#submitButton").val("提交中....");
                var _index;
               http.httpRequest({
                    url: '/reg/client/im/ent/case/save',
                    beforeSend:function(){
                    	_index=layer.load(2,{shade:0.5});
                    },
                    serializable: false,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.close(_index);
                        if(data.status=="success"){
                        layer.msg(data.msg, {time: 1000}, function () {
                        	location.href="/reg/client/im/ent/case/list";
                        });
                    }else{
                    	 layer.msg(data.msg, {time: 2000}, function () {
                         	location.href="/reg/client/im/ent/case/list";
                         });
                    }
                    }
                }) 
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
            	 location.href="/reg/client/im/ent/case/list";
            }
        }])
    }

})