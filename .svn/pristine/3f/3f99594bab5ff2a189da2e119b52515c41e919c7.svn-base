require([
    'component/iframeLayer',
    'common/util',
    'common/http',
    'handlebars',
    'jquery.validate',
    'common/validateRules',
    'jquery.serialize',
    'pagination'
], function (layer, util, http,handlebars) {

    init();//初始化
    function init(){
        loadData_list(0,5);
        bind();
    }

    //加载数据列表
    function loadData_list(page, length, callback) {
        var params = {'priPID': $.trim($('#writ-pripid').val())};
        http.httpRequest({
            url: '/reg/client/yr/ent/writ/list_json',
            serializable: false,
            data: {start: page*length,length: length,params:params},
            type: 'post',
            success: function (data) {
                var itemCount = data.recordsTotal; //获取查询出来的总数
                $('#writ_tody_pagination').pagination(itemCount, {
                    prev_text: '<i class="icon-triangle-left"></i>上一页',
                    next_text: '下一页<i class="icon-triangle-right"></i>',
                    num_display_entries: 3,//主体页数
                    num_edge_entries: 2,//边缘页数
                    items_per_page: 5,
                    current_page: page,
                    link_to: 'javascript:void(0)',
                    ellipse_text: '...',
                    first_text: '首页',
                    last_text: '末页',
                    callback:function(page,jq){
                        loadData_last(page,5);
                    }
                });
                var handleHelper = handlebars.registerHelper("num", function(index) {return index+1+(page*5);});//序号
                registerHelper();//格式转换
                var myTemplate = handlebars.compile($('#tody-template').html());
                $('#writ_list').html(myTemplate(data));

                $("#wenshu_total").text(itemCount);//设置首页文书的个数
                if(itemCount<5){$("#data_total").hide(); return;};//小于5条数据不显示分页


                $("#writ_total").text(itemCount);//总数
                var pageNum = itemCount%5==0?itemCount/5:Math.ceil(itemCount/5);
                $("#writ_pageNum").text(pageNum);//共多少页*/
            }
        });
    };

    //handlebars 自定义判断
    function registerHelper(){
        handlebars.registerHelper("compare",function(v1,v2,options){
            return v1==v2?options.fn(this):options.inverse(this);
           /* if(v1==v2){  //满足添加继续执行
                return options.fn(this);
            }else{//不满足条件执行{{else}}部分
                return options.inverse(this);
            }*/
        });
    }


    //触发事件
    function bind() {
        util.bindEvents([
            {
                el: '#view_details',  //查看详情
                event: 'click',
                handler: function () {
                    var $this = $(this);
                    var url = "uuid="+$this.data('uuid')+"&priPID="+$this.data('pripid')+"&year="+$this.data('year');
                    window.open ("/reg/client/yr/ent/writ/promptly_writ?"+url, "newwindow");

                }
            },
            {
                el: '#dz_hz',  //立即回执
                event: 'click',
                handler: function () {
                    var $this = $(this);
                 /*   //查阅状态更新
                    http.httpRequest({
                        url: '/reg/client/yr/ent/writ/updateLookStatue',
                        serializable: false,
                        data: {'uuid':$this.data('uuid')},
                        type: 'post',
                        success: function (data) {
                        }
                    });*/
                    //打开新页面
                    var url = "uuid="+$this.data('uuid')+"&priPID="+$this.data('pripid')+"&year="+$this.data('year');
                    window.open ("/reg/client/yr/ent/writ/promptly_writ?"+url, "newwindow");
                    layer.alert("您当前正在操作<em style='color:red'>立即回执</em>,<br>执行结束点击【确认】",{ title: '温馨提示', icon: 7,closeBtn: 0,yes:function(index){
                        loadData_list(0,5);
                        layer.close(index);
                    }});
                }
            }

        ]);
    }
});