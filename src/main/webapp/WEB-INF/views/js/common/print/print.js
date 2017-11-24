require(['common/util', 'component/iframeLayer', 'common/http', 'jquery'], function (util, layer, http) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	print_init();
        bind();
    }

    //按钮事件
    function bind() {
        util.bindEvents([
		{
		    el: '#printA',       //打印
		    event: 'click',
		    handler: function () {
		      Print();
		    }
		},{
			el: '#printViewA',  //预览
		    event: 'click',
		    handler: function () {
		    	PrintView();
		    }
		},{
			el: '#printSetupA',  // 设置
		    event: 'click',
		    handler: function () {
		    	PrintSetup()
		    }
		},{
			el: '#closeBtn',    //关闭
		    event: 'click',
		    handler: function () {
		    	window.close();
		    }
		}])
    }
});
