require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        // initDataTable();
        bind();
    }


    var searchParams = {};//查询参数声明!
    var table;
    var table_search;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        var url = '/reg/server/datacount/midlist.json';
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: url,
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: 'regNO'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'dom'},
                {data: 'regOrgName'},
                {data: 'localAdmName'},
                {data: 'estDate'}

            ]
        })
    }
    function initDataTable_search() {
        var  url='/reg/server/datacount/panoQueryPage';
        table_search = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table-search',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url: url,
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: 'regNO'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'dom'},
                {data: 'regOrgName'},
                {data: 'localAdmName'},
                {data: 'estDate'}

            ] ,
            columnDefs: [{
                targets: 2,
                render: function (data, type, row, meta) {
                    if(data==null||data=='null') return'';
                }
            }]
        })
    }
    function bind() {
        util.bindEvents([


            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    if (table == null || typeof table == 'undefined') {
                        initDataTable();
                    }
                    else {
                        table.ajax.reload();
                    }
                }
            },

            {
                el: '#qry-search',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm-search").serializeObject();
                    if (table_search == null || typeof table_search == 'undefined') {
                        initDataTable_search();
                    }
                    else {
                        table_search.ajax.reload();
                    }
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked');
                }
            },
            {
                el: '#cancel-search',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm-search')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked');
                }
            }
        ])
    }

})
