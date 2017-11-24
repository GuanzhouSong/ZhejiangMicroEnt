require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars', 'jquery.validate', 'common/validateRules', 'jquery.serialize','ztree'], function (layer, util, http,handlebars) {
	
	var urlHead=window._CONFIG.urlHead;
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
        $('#ruleForm').validate({
            rules: {
            },
            messages:{
            },
            submitHandler: function () {
            	//表单验证成功后
            	var formParam = $('#ruleForm').serializeObject();
                http.httpRequest({
                    url: urlHead+'/noCreditPunish/rule/save',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                    	if (data.status=="fail") {
                    		layer.msg(data.msg, {time: 5000}, function () {
	                        });
                    	} else {
	                        layer.msg(data.msg, {time: 1500}, function () {
	                        	window.location.href=urlHead+'/noCreditPunish/rule/list';
	                        });
                    	}
                    }
                })
            }
        })
    }

    //事件绑定
    function bind() {
        util.bindEvents([{
            el: '#selectPunReqDept',
            event: 'click',
            handler: function () {
            	doSelectReqDeptCode();
            }
        }, {
            el: '#selectPunExeDept',
            event: 'click',
            handler: function () {
            	doSelectExeDeptCode();
            }
        }, {
            el: '#cancel',
            event: 'click',
            handler: function () {
            	window.location.href=urlHead+'/noCreditPunish/rule/list';
            }
        }])
    }
    
})