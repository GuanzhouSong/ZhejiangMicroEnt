require(['jquery', 'common/util','common/jqprint'
], function (jquery,util,jqprint) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    function bind() {
        util.bindEvents([ 
            //点击打印进行打印
            {
                el: '#printbtncon',
                event: 'click',
                handler: function () {
                	//$("#moreInfo").show();
                    jqprint.jqprint($('#printcon'));
                	
                	
                }
            }
        ])
    }

})
