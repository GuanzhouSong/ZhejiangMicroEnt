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
                	$("#moreInfo").show();
                    jqprint.jqprint($('#printcon'));
                }
            },
            {
                el: '.js-fold',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('reverse')) {
                        $(this).html('收起详情<i></i>');
                        $(this).removeClass("reverse");
                        $(this).addClass("more");
                        $(".js-table-horizontal").show();
                    } else {
                        $(this).html('展开详情<i></i>');
                        $(this).addClass("reverse");
                        $(this).addClass("more");
                        $(".js-table-horizontal").hide();
                    }
                }
            }
        ])
    }

})
