require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'jquery.serialize','common/validateRules'], function (layer, util, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() { 
        initRegorg();
    	formValid();
        bind();

      } 
    
    function initRegorg(){
    	if(window._CONFIG.type == '0'){//查看
    		$("#btndiv").hide(); //保存框隐藏
  			$(".view").attr("readonly","readonly");
    	}
    };

    
    /**
     * 表单验证
     */
    function formValid() {
        $('#form').validate({ 
            rules: {
            	liaName:{
            		required:true,
            		maxlength:50
            	},
            	liaPhone: {
                    required: true,
                    telandphone:true
                }
            },
            messages:{
            	liaName:{
            		required:"请输入联络员姓名",
            		maxlength:"联络员姓名长度不超过50个字符"
            	},
            	liaPhone:{
            	   required:"联系电话不为空",
            	   telandphone:"请输入最新正确格式手机号码或者电话号码"
            	}
            },
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#form input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            onkeyup:false,
            onfocusout:function(el){
                $(el).valid();
            },
            submitHandler: function () {
                var formParam = $('#form').serializeObject();
//                console.log(formParam);
                http.httpRequest({
                    url: window._CONFIG.chooseUrl+'/regorg/doUpdate',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if(data.status == 'success'){
                            layer.msg("修改成功！", {time: 1000}, function () {
                                layer.close({reload: true});
                            });
                    	}else{
                            layer.msg("修改失败！", {time: 1000}, function () {
                                layer.close();
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
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }
        ])
    }

})
