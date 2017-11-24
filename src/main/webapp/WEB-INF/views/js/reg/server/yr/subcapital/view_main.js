require(['component/iframeLayer', 'common/util', 'common/http','handlebars', 'common/validateRules','jquery.validate', 'jquery.serialize',
    'pagination','laydate','component/report'], function (layer, util, http,handlebars) {

    init();
    laydate.skin('molv');//初始化皮肤
    /**
     * 初始化函数集合
     */

    function init() {
        registerHelper();//出资方式初始化
        init_table_one();//初始化表1 前一年的数据
        init_table_tow();//初始化表2
        bind();
    }


    function registerHelper(){
        //出资方式(格式化为中文显示)
        var handleHelper = handlebars.registerHelper("textFormat", function(value) {
            var valueArrays = value.split(",");//每一行的数组值
            var text = [];//页面返回值数组
            var _obj = new Object();
            $("input:checkbox[name=conForm]").each(function(){
                var key = $(this).val();
                var _value = $(this).data("text");
                _obj[key] = _value;
            });
            for(var i=0;i<valueArrays.length;i++){
                text.push(_obj[valueArrays[i]]);
            }
            return text.toString();
        });
    }

    /**
     * 初始化表1 当前年份的前一年
     *
     */
    function init_table_one(){
        loadData_one(0,10);
    };

    function loadData_one(page, length, callback) {
        var params = $('#_params_one').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/server/yr/subcapital_server/list_json_one',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination_one').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_one(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("xh", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($('#table-template-none').html());
                $('#cz_page_one').html(myTemplate(data));
                $("#_total_one").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_pageNum_one").text(pageNum);//共多少页
            }
        });
    };

    /**
     * 初始化表2 当前年份
     */
    function init_table_tow(){
        loadData(0,10);
    };
    function loadData(page, length, callback) {
        var params = $('#_params').serializeObject();//查询参数
        http.httpRequest({
            url: '/reg/server/yr/subcapital_server/list_json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData(page,10);
                    }
                });
                var handleHelper = handlebars.registerHelper("num", function(index) {return index+1+(page*10);});//序号
                var myTemplate = handlebars.compile($("#table-template").html());
                $('#cz_page').html(myTemplate(data));
                $("#_total").text(itemCount);//总数
                var pageNum = itemCount%10==0?itemCount/10:Math.ceil(itemCount/10);
                $("#_pageNum").text(pageNum);//共多少页
            }
        });
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
                    loadData(0,10);//根据排序条件重新排列
                }
            }
        ])
    }
});


