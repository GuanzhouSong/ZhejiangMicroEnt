require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','laydate','jquery.placeholder','jquery.icinfo'], function (layer, util, http) {
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
        if($("#invAltID").val()!=""&&$("#invAltID").val()!=null){
        var be=$("#beTransAmPr").val();
        $("#beTransAmPr").val(parseFloat(be));
        
        var af=$("#afTransAmPr").val();
        $("#afTransAmPr").val(parseFloat(af));
        }   
    }
    
    laydate.skin('molv');//初始化皮肤
    var end = {
        elem: '#equAlDate', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: "2099-12-31", //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
            
        }
    };
    $("#equAlDate").click(function(){
    	
    	 
    	laydate(end);});

    /**
     * 表单验证
     */
    function formValid() {
        $('#invsraltForm').validate({
            rules: {
            	inv: {
                    required: true,
                    maxlength:200
                },
                beTransAmPr: {
                    required: true,
                    number:true,
                    range:[0,100]
                },
                equAltDate: {
                    required: true
                },
                afTransAmPr: {
                    required: true,
                    number:true,
                    range:[0,100]
                } 
                 
            },
            showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#invsraltForm input[name='+i+'],#invsraltForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
            submitHandler: function () {
                var formParam = $('#invsraltForm').serializeObject();
                 $("#saveButton").attr("disabled", true);
          		 $("#saveButton").val("提交中...."); 
                var _index;
                http.httpRequest({
                    url: '/reg/client/im/ent/invsralt/save',
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
                           location.href="/reg/client/im/ent/invsralt/list";
                        });
                    }else{
                    	   layer.msg(data.msg, {time: 2000}, function () {
                               location.href="/reg/client/im/ent/invsralt/list";
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
            	  location.href="/reg/client/im/ent/invsralt/list";
            }
        },
            {
                el: '.js-inv-list',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '股东列表选择',
                        area: ['400px', '600px'],
                        content: '/reg/client/im/ent/investment/inv_select?priPID=' + $(this).attr("pripid"),
                        callback: function (data) {
                            var inv=data.inv;
                            if(inv!='undefined'&&inv!=''&&inv!=undefined){
                                $("#invr").val(inv);
                            }
                        }
                    })
                }
            }
        ])
    }

})