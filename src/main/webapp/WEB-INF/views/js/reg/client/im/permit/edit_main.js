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
    }

    laydate.skin('molv');//初始化皮肤
    var start = {
        elem: '#start', //选择ID为START的input
        format: 'YYYY-MM-DD', //自动生成的时间格式
        min: '1970-01-01', //设定最小日期为当前日期
        max: "2099-12-31", //最大日期
        istime: true, //必须填入时间
        istoday: false,  //是否是当天
        start: laydate.now(0,"YYYY-MM-DD"),  //设置开始时间为当前时间
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD',
        min: '1970-01-01',
        max: "2099-12-31",
        istime: true,
        istoday: false,
        start: laydate.now(0,"YYYY-MM-DD"),
        choose: function(datas){
         
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    //开始时间和结束时间
    $("#start").click(function(){laydate(start);});
    $("#end").click(function(){laydate(end);});
    
    
    /**
     * 表单验证
     */
    function formValid() {
        $('#permitForm').validate({
        	onkeyup:false,
        	rules: {
            	licNO: {
                    required: true,
                    maxlength:50
                },
                valTo: {
                    required: true
                },
                valFrom: {
                    required: true
                },
                
                licItem: {
                    required: true
                },
                licNameCN: {
                    required: true,
                    maxlength:256
                },
                liCanth: {
                    required: true
                },
                licAnth:{
                	 required: true,
                	 maxlength:100
                } 
                
            },
            messages:{ 
            	valFrom:"请选择日期",
            	valTo:"请选择日期"
            },
            
            showErrors:function(errorMap,errorList){ 
                for(var i in errorMap){ 
                    layer.tips(errorMap[i],$('#permitForm input[name='+i+'],#permitForm textarea[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
               
            },
            submitHandler: function () {
                var formParam = $('#permitForm').serializeObject();
                $("#submitButton").attr("disabled", true);
				 $("#submitButton").val("提交中...."); 
                var _index;
                http.httpRequest({
                    url: '/reg/client/im/ent/permit/save',
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
                            window.location.href="/reg/client/im/ent/permit/list"; 
                          });
                        }else {
                        	 layer.msg(data.msg, {time: 2000}, function () {
                                 window.location.href="/reg/client/im/ent/permit/list"; 
                               });
                        }
                    }
                })
            }
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#licenceList', //选择许可证列表
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '许可列表',
                        area: ['500px', '600px'],
                        content: '/reg/client/yr/pb/pbbaseinfo/treeview',
                        callback: function (data) {
                            if(data.reload!=null){
                                $("#licNameCN").val(data.reload.returnName);
                            }
                        }
                    })
                }
            },
            { el: '#longTime', //无有效期或长期有效事件触发
                event: 'click',
                handler: function () {
                    if($(this).prop("checked")){
                        $("#end").val("9999-09-09");
                    }else{
                        $("#end").val("");
                    }
                }
            },
            {
            el: '#cancle',
            event: 'click',
            handler: function () {
            	  window.location.href="/reg/client/im/ent/permit/list";
            }
        }])
    }

})