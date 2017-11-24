require(['component/iframeLayer','common/util', 'common/http','laydate','common/validateRules','jquery.serialize'], function (layer,util, http) {
    // 执行初始化
    init();

    /**
     * 初始化函数定义
     */
    function init() {
        _bind();
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '#js-cancel', // 取消新增
                event: 'click',
                handler: function () {
                    layer.closeAll();
                }
            },
            {
                el: '#js-confirm', // 确定新增
                event: 'click',
                handler: function () {
                    _add();
                }
            },
            {
                el: '.js-valFrom-date,.js-valTo-date', // 有效期起/止laydate
                event: 'click',
                handler: function(){
                    laydate();
                }
            }
        ]);
    }

    /**
     * 执行新增
     * @private
     */
    function _add() {
        $('#js-form').validate({
            showErrors:function(errorMap,errorList){
                for(var i in errorMap){
                    layer.tips(errorMap[i],$('#js-form input[name='+i+']'),{
                        tips:3,
                        tipsMore:true,
                        ltype:0
                    });
                }
            },
            submitHandler: function(){
                http.httpRequest({
                    url: '/depsyn/license/add',
                    serializable: true,
                    data:$('#js-form').serializeObject(),
                    type: 'post',
                    success: function (data) {
                        if(data.status == 'success'){
                            layer.close({reload: true});
                        }else{
                            layer.msg(data.msg, {ltype: 0,time:2000});
                        }
                    }
                });
            }
        });
    }
});
