require(['component/iframeLayer', 'common/util',  'common/http', 'jquery.validate', 'jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, util, http) {

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
    }

    laydate.skin('molv');//初始化皮肤
    var start = {
        elem: '#pleRegPerFrom', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1900-01-01', //设定最小日期为当前日期
        max: "2299-12-31", //最大日期 //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#pleRegPerTo',
        format: 'YYYY-MM-DD',
        min: '1900-01-01',
        max: "2299-12-31", //最大日期 //最大日期
        istime: true,
        istoday: false,
        start: laydate.now(0,"YYYY-MM-DD"),
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    //开始时间和结束时间
    $("#pleRegPerFrom").click(function(){laydate(start);});
    $("#pleRegPerTo").click(function(){laydate(end);}); 
    
    /**
     * 表单验证
     */
    function formValid() {
        $('#ippldgForm').validate({
        	onkeyup:false,
        	rules: {
            	TMName: {
                    required: true,
                    maxlength:100
                },
                TMRegNo:{
                	required: true,
                	maxlength:30
                },
                kinds: {
                    required: true,
                    maxlength:20
                },
                impOrg: {
                    required: true,
                    maxlength:200
                },
                pledgor: {
                    required: true,
                    maxlength:200
                },
                pleRegPerFrom: {
                    required: true
                },
                pleRegPerTo: {
                    required: true
                } 
            },
            messages:{ 
            	pleRegPerFrom:"请选择日期",
            	pleRegPerTo:"请选择日期",
            	kinds:"请选择种类"
            },
            
            showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#ippldgForm input[name='+i+'],#ippldgForm textarea[name='+i+'],#ippldgForm select[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
            submitHandler: function () {
                var formParam = $('#ippldgForm').serializeObject();
                $("#submitButton").attr("disabled", true);
				 $("#submitButton").val("提交中...."); 
                var _index;
                http.httpRequest({
                    url: '/reg/client/im/ent/ippldg/save',
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
                           location.href="/reg/client/im/ent/ippldg/list";
                        });
                    }else{
                    	 layer.msg(data.msg, {time: 2000}, function () {
                             location.href="/reg/client/im/ent/ippldg/list";
                          });
                     }
                    }
                })
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancle',
            event: 'click',
            handler: function () {
            	  location.href="/reg/client/im/ent/ippldg/list";
            }
        }])
    }

})