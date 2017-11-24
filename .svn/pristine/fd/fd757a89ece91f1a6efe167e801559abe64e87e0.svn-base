require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'component/paginationPages',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize'
], function (layer, util, http,handlebars,paginationPages) {
    init();

    function init() {
        init_table_tody();//初始化表当前年份的数据
        bind();
    }

    //初始化表当前年份的数据
    function init_table_tody(){
        var options = {
            page:0,                                                              //开始页
            length:5,                                                           //长度
            items_per_page:5,                                                   //每页显示几条               默认10条
            params:$('#tody_params').serializeObject(),                          //查询参数,                  必填项
            url:'/reg/server/yr/alterstock_server/list_json_tody',             //url 访问路径               必填项
            type:'post',                                                         //请求方式
            pagination:'#tody_pagination',                                       //分页显示的位置              必填项
            myTemplate:'#tody-table-template',                                   //script:模板路径            必填项
            html:'#tody_list',                                                   //需要渲染的html             必填项
            total:'#tody_total',                                                 //显示页面总数的位置          必填项
            pageNmber:'#tody_pageNum'                                             //显示多少页的位置           必填项
        };
        paginationPages.loadData(options,"num1");
    };



    //按钮事件
    function bind() {
        util.bindEvents([
        /**点击三角形排序**/
            {
                el: '.order_by',  // 升序降序排序方式
                event: 'click',
                handler: function () {
                    $(".order_by").removeClass("cur");
                    $(this).addClass('cur');//添加样式并且去掉兄弟节点样式
                    var orderStr = $(this).data("order");
                    $("#_orderStr").val(orderStr);
                }
            },
            {
                el: '.js-ui-show',  // 收起 展开
                event: 'click',
                handler: function () {
                    var $span = $(this).find("span");
                    $span.text($span.text() == '收起' ? '展开' : '收起');
                    $(this).toggleClass('drop-on');
                    $(".js-table").slideToggle("slow");
                }

            }
        ])
    }
});


