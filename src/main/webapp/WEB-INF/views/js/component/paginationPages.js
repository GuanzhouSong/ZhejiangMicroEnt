/**
 *  前端分页插件
 */
define(['common/http', 'pagination', 'handlebars'], function (http, _pagination, handlebars) {


    return {
        loadData: function (options,num) {
            var defaultOptions = {
                page: 0,                                         //开始页
                length: 10,                                      //长度
                items_per_page: 10,                              //每页显示几条              默认10条
                params: '',                                      //查询参数,                 必填项
                url: '',                                         //url 访问路径              必填项
                type: 'post',                                    //请求方式
                pagination: '#pagination',                       //分页显示的位置             必填项
                myTemplate: '',                                  //script:模板路径           必填项
                html: '',                                        //需要渲染的html            必填项
                total: '',                                       //显示页面总数的位置         必填项
                pageNmber: ''                                    //显示多少页的位置           必填项
            };
            var opt = $.extend({}, defaultOptions, options);
            var params = opt.params;         //查询参数

            var _page;
            handlebars.registerHelper(num, function (index) {
                return _page ? index + 1 + ((_page) * (opt.length)) : index + 1 + ((opt.page) * (opt.length));
                //return index + 1 + ((opt.page) * (opt.length));
            });//序号
            var myTemplate = handlebars.compile($(opt.myTemplate).html());

            pageSelectedCallback();

            function pageSelectedCallback(current_page) {
                var page = current_page || opt.page;
                _page = current_page;
                http.httpRequest({
                    url: opt.url,
                    serializable: false,
                    data: {start: page * opt.length, length: (opt.length), params: params},
                    type: opt.type,
                    success: function (data) {
                        var itemCount = data.recordsTotal;              //获取查询出来的总数
                        if(typeof(data.recordsTotal) == 'undefined') itemCount=0;
                        $(opt.pagination).pagination(itemCount, {
                            prev_text: '<i class="icon-triangle-left"></i>上一页',
                            next_text: '下一页<i class="icon-triangle-right"></i>',
                            num_display_entries: 4,//主体页数
                            num_edge_entries: 2,//边缘页数
                            items_per_page: opt.items_per_page,
                            current_page: page,
                            link_to: 'javascript:void(0)',
                            ellipse_text: '...',
                            first_text: '首页',
                            last_text: '末页',
                            callback: function (page, jq) {   //current_page 当前页
                                pageSelectedCallback(page);
                            }
                        });
                        if (
                            (!(options.isUseNOdata == 'true'))
                            ||
                            (options.isUseNOdata == 'true' && itemCount > 0)
                        ){
                            $(opt.html).html(myTemplate(data));
                        }
                        $(opt.total).text(itemCount);//总数
                        var pageNum = itemCount % (opt.length) == 0 ? itemCount / (opt.length) : Math.ceil(itemCount / opt.length);
                        $(opt.pageNmber).text(pageNum);//共多少页
                    }
                });
            }

        }
    }
});



