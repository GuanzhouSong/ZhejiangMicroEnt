require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'jquery.validate',
    'common/validateRules',
    'laydate',
    'jquery',
    'jquery.serialize'
], function (layer, util, http) {

    //页面初始化
    init();

    function init(){
        apply_formValid()
    };

    //企业
    function apply_formValid(){
        $('#js-apply-from').validate({
            onkeyup:false,
            onfocusout:function(el){
                if(el.name!='applyDate'&&el.name!='feedbackDate'){
                    $(el).valid();
                }
            },
            rules: {
                entName:{
                    required:true
                },
                uniCode:{
                    required:true
                },
                applyPerson:{
                    required:true
                },
                applyDate:{
                    required:true
                },
                phone:{
                    required:true,
                    checkMobile:true
                },
                feedbackDate:{
                    required:true
                },
                applyContent:{
                    required:true
                },
                modifyType:{
                    required:true
                }
            },
            messages: {
                modifyType:{
                    required:'请选择'
                }
            },
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#js-apply-from input[name=' + i + '],select[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        time:4000, //4秒
                        ltype: 0
                    });
                    return;
                }
            },
            submitHandler: function (form) {


            }
        });
    };

    //提交
    $('#js-submit-btn').off('click').on('click',_submit);
    function _submit() {
        var formParam = $('#js-apply-from').serializeObject();
        var url = '/reg/server/datamodify/mid_data_save';
        //判断校验是否通过
        if($("#js-apply-from").valid()){
            $('#js-submit-btn').off('click');
            ajaxRequest(formParam,url,submit_result,'#js-submit-btn',_submit,'click');
            function submit_result(data){
                if(data.status=='success'){
                    layer.msg('保存成功!',{time:1000},function(){
                        layer.close();
                    });
                }else{
                    $('#js-submit-btn').on('click',_submit);
                }
            }
        }
    }

    //关闭
    $('#js-cancel').on('click',function(){
        layer.close();
    });





    /**
     * ajax异步请求
     * @param params 参数
     * @param url  参数路径
     * @param callback  回调行数
     * @param id
     * @param fun
     * @param event
     */
    function ajaxRequest(params,url,callback,id,fun,event){
        http.httpRequest({
            url: url,
            data:params,
            type: 'post',
            beforeSend: function () {},
            success: function (data) {
                if(callback)callback.call(this,data);
            },
            error:function(){
                if(id&&fun){$(id).on(event,fun);}
                layer.msg("系统异常,请联系管理人员处理!");
            }
        });
    }

});