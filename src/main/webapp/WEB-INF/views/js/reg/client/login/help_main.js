require(['component/iframeLayer', 'common/util'], function (layer, util) {

    //执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        bind();
    }
    
    /**
     * 事件绑定
     */
    function bind() {
        util.bindEvents([{
        	// 提示框：企业年度报告申报内容
        	el: '.annual',
            event: 'click',
            handler: function () {
                layer.dialog({
                    content: $('.annual-box'),
                    type: 1,
                    area: ['700px','400px']
                });
            }
        },{
        	// 提示框：企业即时信息申报内容
        	el: '.timely',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     content: $('.timely-box'),
                     type: 1,
                     area: ['700px','400px']
                 });
            }
        },{
        	// 提示框：企业信息公示暂行条例
        	el: '.rule',
            event: 'click',
            handler: function () {
            	 layer.dialog({
                     content: $('.rule-box'),
                     type: 1,
                     area: ['720px','400px']
                 });
            }
        }
        ])
    }
    
})