require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'common/validateRules', 'jquery.serialize','ztree'], function (layer, util, http) {
	var msg = $("#msg").val();
	//执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
        if(msg!=null&&msg!=""){
        	layer.msg(msg, {time: 1200}, function() {});
        }
    }
 
    function bind() {
        util.bindEvents([{
            el: '#upload',
            event: 'click',
            handler: function() {
            	$('#compare-form').submit();
             }
        }, {
            el: '.importfile',
            event: 'change',
            handler: function() {
            	   var filePath = $(this).val();
            	    $("#filename").val(filePath);
             }
        },{
            el: '.js-ipt-btn',
            event: 'click',
            handler: function () {
               $('#js-file-btn').trigger('click')
            }
        }
        ])
    }

})