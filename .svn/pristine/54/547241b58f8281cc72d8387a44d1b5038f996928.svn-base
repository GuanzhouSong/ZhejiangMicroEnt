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
                el: '#printbtn',
                event: 'click',
                handler: function () {
                    jqprint.jqprint($('#printcon'));
                }
            }
        ])
    }

})
