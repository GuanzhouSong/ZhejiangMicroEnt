require(['component/iframeLayer', 'common/util', 'common/http', 'handlebars', 'laydate', 'common/validateRules', 'pagination', 'common/ajaxfileupload'], function (layer, util, http, handlebars) {

    // 变量定义
    var pageSize = 5;

    // 执行初始化
    init();

    /**
     * 初始化
     */
    function init() {
        _bind();
        // 执行查询
        _query();
    }

    /**
     * 事件绑定
     * @private
     */
    function _bind() {
        util.bindEvents([
            {
                el: '#js-add',
                event: 'click',
                handler: function () {
                    // 新增
                    _add();
                }
            },{
                el: '.js-ipt-btn',
                event: 'click',
                handler: function () {
                    $('#file').trigger('click');
                }
            },{
                el: '#file',
                event: 'change',
                handler: function () {
                    $('#js-pdf-file').val($('#file').val());
                }
            },{
                el: '.js-relDate-date',
                event: 'click',
                handler: function(){
                    laydate();
                }
            }
        ]);
    }

    /**
     * 搜索
     * @private
     */
    function _query() {
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
            url: '/depsyn/notice/query',
            serializable: false,
            data: {'pageNum': pageNum + 1, 'pageSize': pageSize},
            type: 'post',
            success: function (data) {
                _success(data, pageNum);
            }
        });
    }

    // 页面数据清理
    function _clearData() {
        $('#js-list-content').html('');
        $('.notice-pagination-box').hide();
    }

    // 方法返回处理
    function _success(data, pageNum) {
        if (data.recordsTotal == 0) {
            $('#js-list-content').html('<tr><td colspan="6">暂无数据</td></tr>');
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

    /**
     * 新增公告
     * @private
     */
    function _add() {
        $('#js-form').validate({
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#js-form input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0
                    });
                }
            },
            submitHandler: function () {
                // 提交之前处理
                var param = _preSubmit();
                if (!param) {
                    return false;
                }
                $.ajaxFileUpload({
                    url: '/depsyn/notice/add',
                    type: 'post',
                    data: param,
                    secureuri: false,
                    fileElementId: 'file',
                    dataType: 'text',
                    success: function (data) {
                        _addSuccess();
                    },
                    error: function (data) {
                        layer.msg("提交失败，请检查网络及上传文件大小", {time: 2000},
                            function () {
                            }
                        );
                    }
                });
            }
        });
    }

    // 提交之前预处理
    function _preSubmit() {
        var pdfName = $('#file').val();
        if (pdfName.substring(pdfName.lastIndexOf("."), pdfName.length).toLowerCase() != '.pdf') {
            layer.msg("请上传pdf格式附件", {time: 2000});
            return null;
        }

        var param = {};
        // 拼装新增参数
        $('.js-save-data').each(function () {
            param[$(this).attr('name')] = $.trim($(this).val());
        });

        return param;
    }

    /**
     * 新增成功后处理
     * @private
     */
    function _addSuccess() {
        // 清空表单
        $('#js-reset').click();
        layer.msg("保存成功", {time: 1000}, function () {
            // 重新查询数据
            _getList(0, pageSize);
        });
    }
});
