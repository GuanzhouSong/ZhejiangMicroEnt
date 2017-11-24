require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

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
                {data: 'id', 'className': 'center'},
                {data: 'id', 'className': 'center'},
                {data: 'auditstate'},
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

                        if (row.auditstate == '0') {
                            return '<a href="javascript:void(0);" class="js-add">审核</a>';
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

    //表格之外的查询按钮事件
    $("#search").click(function () {
        searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    });

    function bind() {
        util.bindEvents([
            {
                el: '.js-add',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '审核',
                        area: ['1028px', '700px'],
                        content: '/reg/server/govguide/govguide/toAdd?fromtype=check&uid=' + data.uid + '&pripid=' + data.pripid + '&entname=' + data.entname,
                        callback: function (data) {
                            if (data.type=='save') {
                                table.ajax.reload();
                            }
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
                    var hei = '80%';
                    if (data.auditstate == '4') {
                        fromtype = 'susview';
                        hei = "93%";
                    }
                    layer.dialog({
                        title: '查看',
                        area: ['80%', hei],
                        content: '/reg/server/govguide/govguide/toAdd?fromtype=' + fromtype + '&uid=' + data.uid + '&pripid=' + data.pripid + '&entname=' + data.entname,
                        callback: function (data) {

                        }
                    })
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
