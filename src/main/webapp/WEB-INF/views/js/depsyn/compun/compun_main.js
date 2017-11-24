require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery.serialize', 'laydate', 'jquery.validate', 'pagination'], function (layer, dataTable, util, http, handlebars) {

    // 变量定义
    var pageSize = 5,
        searchParams = {};

    // 执行初始化
    init();

    /**
     * 初始化
     */
    function init() {
        _bind();
        _query();
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '#js-search',
                event: 'click',
                handler: function () {
                    // 执行查询
                    _query();
                }
            },
            {
                el: '#js-add',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: false,
                        closeBtn: 0,
                        area: ['512px', '400px'],
                        content: '/depsyn/compun/toadd',
                        shadeClose: true,
                        callback: function (data) {
                            if (data.reload) {
                                layer.msg("保存成功", {time: 1000}, function () {
                                    _getList(0, 5);
                                });
                            }
                        }
                    });
                }
            }
        ]);
    }

    /**
     * 搜索
     * @private
     */
    function _query() {
        searchParams = $('#searchForm').serializeObject();
        // 查询参数前后空格去除
        for(var i in searchParams){
            searchParams[i] = $.trim(searchParams[i]);
        }
        _getList(0, pageSize);
    }

    /**
     * 获取信息列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @private
     */
    function _getList(pageNum, pageSize) {
        _clearData();
        http.httpRequest({
            url: '/depsyn/compun/query',
            serializable: false,
            data: $.extend({}, searchParams, {'pageNum': pageNum + 1, 'pageSize': pageSize}),
            type: 'post',
            success: function (data) {
                _success(data, pageNum);
            }
        });
    }

    /**
     * 请求之前页面数据清理
     * @private
     */
    function _clearData() {
        $('#js-list-content').html('');
        $('.notice-pagination-box').hide();
    }

    /**
     * 请求方法返回处理
     * @param data 返回数据
     * @param pageNum 当前页
     * @private
     */
    function _success(data, pageNum) {
        if (data.recordsTotal == 0) {
            $('#js-list-content').html('<tr><td colspan="10">暂无数据</td></tr>');
            $('.notice-pagination-box').hide();
        } else {
            var template = handlebars.compile($('#listTemplate').html());
            // 序号处理
            _idProcess(data.data, pageNum);
            $('#js-list-content').html(template(data));
            _pagination(data, pageNum, pageSize);
            $('.notice-pagination-box').show();
        }
    }

    /**
     * 序号处理
     * @param data
     * @param pageNum
     * @private
     */
    function _idProcess(data, pageNum) {
        var base = pageNum * pageSize + 1;
        for (var i in data) {
            data[i].id = base++;
        }
    }

    /**
     * 分页配置参数
     * @param data
     * @param index
     * @private
     */
    function _pagination(data, index, pageSize) {
        $('#js-total').html(data.recordsTotal);
        $('#js-pageTotal').html(Math.ceil(data.recordsTotal / pageSize));
        $('.pagination').pagination(data.recordsTotal, {
            callback: _pageSelectCallback,
            prev_text: '&lt上一页',
            next_text: '下一页&gt',
            num_display_entries: 6,
            num_edge_entries: 2,
            current_page: index,
            link_to: 'javascript:void(0)',
            ellipse_text: '...',
            items_per_page: pageSize
        });
    }

    /**
     * 点击分页的回调函数
     * @param pageNum   当前点击的那个分页的页数索引值
     * @param jq        装载容器
     * @private
     */
    function _pageSelectCallback(pageNum) {
        _getList(pageNum, pageSize);
    }
});
