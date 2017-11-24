require(['component/iframeLayer', 'component/dataTable', 'common/util',
    'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams = {};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                url: '/reg/server/govguide/govguide/list.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: "id", 'className': 'center'},
                {data: 'id', 'className': 'center'},
                {data: 'auditstate'},
                {data: 'efftstatus'},
                {data: 'uniscid'},
                {data: 'entname'},
                {data: 'adminguideitem'},
                {data: 'stadate'},
                {data: 'enddate'},
                {data: 'applyman'},
                {data: 'applydate'},
                {data: 'auditname'},
                {data: 'auditdate'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {

                        if (row.auditstate == '0' || row.auditstate == '2') {
                            return '<a href="javascript:void(0);" class="js-edit">修改</a>' +
                                '<a href="javascript:void(0);" class="js-delete">  删除</a>';
                        }
                        else if (row.auditstate == '1') {
                            return '<a href="javascript:void(0);" class="js-view">查看</a>' +
                                '<a href="javascript:void(0);" class="js-sus">  中止</a>';
                        }
                        else {
                            return '<a href="javascript:void(0);" class="js-view">查看</a>';
                        }

                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        if (row.auditstate == '' || isNaN(row.auditstate)) return '';
                        else {
                            var txt = ['未审核', '同意行政指导', '退回修改', '取消行政指导', '中止'];
                            return txt[row.auditstate];
                        }
                    }
                },
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        if (data == '') return '';
                        else if (data == '0') {
                            return "无效";
                        }
                        else if (data == '1') {
                            return '有效';
                        } else if (data == '2') {
                            return '流程中';
                        } else return '';

                    }
                },
                {
                    targets: "uniCode",
                    render: function (data, type, row, meta) {
                        if(data==null||data==''){
                            return row.regno;
                        }
                        else return data;
                    }
                },
                {
                    targets: 'adminguideitem',
                    render: function (data, type, row, meta) {
                        if (data == '') return '';
                        else if (data == '1') {
                            return '其他';
                        }
                        else if (data == '2') {
                            return '股东出资提示';
                        }
                        else if (data == '3') {
                            return '许可证即将到期';
                        }
                        else if (data == '4') {
                            return '经营期限即将到期';
                        }
                        else if (data == '5') {
                            return '长期不开展经营活动';
                        }
                        else if (data == '6') {
                            return '清算';
                        }
                        else return '';
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '.js-add',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
               // window.location.href='/reg/server/govguide/govguide/toAddList';
                    layer.dialog({
                        title: '添加',
                        area: ['85%', '98%'],
                        content: '/reg/server/govguide/govguide/toAddList',
                        callback: function (data) {
                            debugger;
                            if (data.type=='save'||data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            }, {
                el: '.js-edit',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    var fromtype = 'modi';
                    if (data.auditstate == '2') {
                        fromtype = 'backmodi';
                    }
                    layer.dialog({
                        title: '修改',
                        area: ['70%', '90%'],
                        content: '/reg/server/govguide/govguide/toAdd?fromtype=' + fromtype + '&uid=' + data.uid + '&pripid=' + data.pripid + '&entname=' + data.entname,
                        callback: function () {
                            table.ajax.reload();
                        }
                    })
                }
            },
            {
                el: '.js-sus',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '中止',
                        area: ['80%', '93%'],
                        content: '/reg/server/govguide/govguide/toAdd?fromtype=sus&uid=' + data.uid + '&pripid=' + data.pripid + '&entname=' + data.entname,
                        callback: function (data) {
                            table.ajax.reload();
                        }
                    })
                }
            },
            {
                el: '.js-view',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    var fromtype = 'checkview';
                    if (data.auditstate == '4') {
                        fromtype = 'susview';
                    }
                    var url = '/reg/server/govguide/govguide/toAdd?fromtype=' + fromtype + '&uid=' + data.uid + '&pripid=' + data.pripid + '&entname=' + data.entname;
                    layer.dialog({
                        title: '查看',
                        area: ['80%', '93%'],
                        content: url,
                        callback: function (data) {
                            table.ajax.reload();
                        }
                    })
                }
            },
            {
                el: '.js-delete',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/server/govguide/govguide/del',
                            data: {uid: data.uid},
                            type: 'post',
                            success: function (data) {
                                layer.msg(data.msg, {time: 1000}, function () {
                                    table.ajax.reload();
                                });
                            }
                        });
                    });
                }
            },

            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked')
                        .removeAttr('selected');
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            }
            , {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#regOrg").val(data.returncode);
                            $("#regOrgName").val(data.returnname);
                        }
                    })
                }
            },

            {
                el: '#choseregUnit',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['25%', '60%'],
                        content: '/commom/server/regunit/regunitmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#localAdm").val(data.returncode);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            }
        ])
    }

})
