require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate', 'common/ajaxfileupload', 'pagination','common/hbsHelper'], function (layer, dataTable, util, http,handlebars) {
    init();

    function init() {
        _bind();
        _getList(0, 5);
    }

    function _bind() {
        util.bindEvents([{
            el: '#js-submit',
            event: 'click',
            handler: function () {
                http.httpRequest({
                    url: '/depsyn/excel/punish/addbatch',
                    type: 'post',
                    success: function () {
                        layer.alert("提交成功", {icon: 1, closeBtn: false}, function() {
                            window.location.href = '/depsyn/excel/template';
                        });
                    }
                });
            }
        }])
    }

    function _getList(pageNum, pageSize) {
        $('#js-list-content').html('');
        $('.pagination').hide();
        http.httpRequest({
            url: '/depsyn/excel/punish/list',
            type: 'post',
            data: {
                "pageNum": pageNum + 1,
                "pageSize": pageSize
            },
            success: function(data) {
                var template = handlebars.compile($('#listTemplate').html());
                $('#js-list-content').html(template(data));
                _pagination(data, pageNum, pageSize);
                $('#_total_yrinfo').html(data.recordsTotal);
                $('#_pageNum_yrinfo').html(Math.ceil(data.recordsTotal / pageSize));
                $('.pagination').show();
            },
            error: function() {
                layer.alert("数据错误, 请重新上传", {icon: 5}, function () {
                    window.location.href = "/depsyn/excel/punish/toupload";
                });
            }
        });
    }

    /**
     * 分页配置参数
     * @param data
     * @param index
     * @private
     */
    function _pagination(data, index, pageSize) {
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
    function _pageSelectCallback(pageNum, jq) {
        _getList(pageNum, 5);
    }
});
