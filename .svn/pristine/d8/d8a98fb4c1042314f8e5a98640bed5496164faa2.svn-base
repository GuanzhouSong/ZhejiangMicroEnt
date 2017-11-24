require(['component/iframeLayer', 'common/util',  'common/http', 'jquery.validate', 'jquery.serialize','laydate','jquery.placeholder','jquery.icinfo','laydate'], function (layer, util, http) {
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
        initTbl();
    }
    
    function initTbl(){
      	 
    	 $(".assetItem").each(function() {
 	    	var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
 	        if(v != "" && v != null){
 	        	$(this).val(parseFloat((isNaN(v) ? "0.00" : v) - 0).toFixed(4));
 	        } 
 	    }); 
 	
    	
    	$(".assetItem").focus(function() {
            var v = $.trim($(this).val()).replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
           
        }).blur(function() {
        	var v = $.trim($(this).val());
            if(v != "" && v != null){
            	v = v.replace(/\s+|[a-z]|[A-Z]|[\u4e00-\u9fa5]|,|。|,|，/g, "");
            	$(this).val(parseFloat((v == "" || isNaN(v) ? "0.00" : v) - 0).toFixed(4));
            	   var reg = /^[\-\+]?\d+(\.\d{1,4})?$/; 
            	if (!reg.test(v)) {
                	 layer.tips('请重新输入!例1.23',$(this),{tips:3, tipsMore:true, ltype:0});
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
            elem: '#conDate',
            format: 'YYYY-MM-DD',
            min: '1900-01-01',
            max: "2299-12-31",
            istime: true,
            istoday: false,
            start: laydate.now(0,"YYYY-MM-DD"),
            choose: function(datas){
             //结束日选好后，重置开始日的最大日期
            }
        };

        //开始时间和结束时间
        $("#conDate").click(function(){laydate(end);});

    /**
     * 表单验证
     */
    function formValid() {
        $('#invprodetailForm').validate({
        	onkeyup:false,
            rules: {
            	acConForm: {
                    required: true,
                    maxlength:128
                },
                acConAm: {
                	  required: true,
                      number:true,
                      maxlength:16
                },
                conDate: {
                    required: true
                }  
            },
            messages:{ 
            	conDate:"请选择日期",
            	 
            },
            showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#invprodetailForm input[name='+i+'],#invprodetailForm select[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
            
            
            submitHandler: function () {

                //如果货币中没有中文值 则重新赋值
                if(!$("#acConFormCn").val()){
                    $("#acConFormCn").val($('#acConForm').find('option:selected').text())
                }
                var formParam = $('#invprodetailForm').serializeObject();
                $("#submitButton").attr("disabled", true);
				 $("#submitButton").val("提交中...."); 
                var _index;
                http.httpRequest({
                    url: '/reg/client/im/ent/invactdetail/save',
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
                            location.href="/reg/client/im/ent/investment/show?id="+$("#invID").val();
                        	 
                        });
                    }else{
                    	layer.msg(data.msg, {time: 2000}, function () {
                            location.href="/reg/client/im/ent/investment/show?id="+$("#invID").val();
                        	 
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
            	  location.href="/reg/client/im/ent/investment/show?id="+$("#invID").val();
            }
        },
        { 
        	el:'#acConForm',
        	event:'change',
        	handler:function(){
                $("#acConFormCn").val($(this).find('option:selected').text());
        	} 
        }
        ])
    }

})