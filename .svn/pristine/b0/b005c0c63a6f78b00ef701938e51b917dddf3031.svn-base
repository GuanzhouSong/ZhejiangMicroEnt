require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate','common/validateRules', 'jquery.serialize','laydate'], function (layer, util, http) {


    init();

    /**
     * 初始化函数集合
     */
    
    function init() {
    	formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#emailForm').validate({
            rules: {
            	taskName: {
                    required: true
                }
            },
            submitHandler: function () {
        		var formParam = $('#emailForm').serializeObject();
        		http.httpRequest({
        			url: '/reg/server/emailtask/save',
        			serializable: true,
        			data: formParam,
        			type: 'post',
        			success: function (data) {
        				layer.msg(data.msg, {time: 1000}, function () {
        					window.location.href='/reg/server/emailtask/emailtasklist';
        				});
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
            	window.location.href='/reg/server/emailtaskinfo/addemaillist';
            }
        }])
    }

})