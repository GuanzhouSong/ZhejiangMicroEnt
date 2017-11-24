require(['component/iframeLayer', 'common/util', 'common/http', 'jquery.validate', 'common/validateRules', 'jquery.serialize','ztree'], function (layer, util, http) {
	var file = $("#file").val(); 
	//执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
    }

    
    function bind() {
        util.bindEvents([{
            el: '#download',
            event: 'click',
            handler: function() {
            	window.location.href = "/depsyn/comparedownload";
             }
        }, {
            el: '#upload',
            event: 'click',
            handler: function() {
            	window.open("/depsyn/doEnCompareUpload","_self");
             }
        }, {
            el: '.tabshow1',
            event: 'click',
            handler: function() {
            	$(this).parent('ul').attr('class', 'dr-step0' + ($(this).index() + 1));
            	$("#show1").show();
            	$("#show2").hide();
             }
        }, {
            el: '.tabshow2',
            event: 'click',
            handler: function() {
            	$(this).parent('ul').attr('class', 'dr-step0' + ($(this).index() + 1));
            	$("#show2").show();
            	$("#show1").hide();
             }
        }
        ])
    }

})