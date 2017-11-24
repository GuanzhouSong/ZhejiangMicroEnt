require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http',
    'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#hx-table',
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/sment/log/list.json',
                data:function(d){
                    d.params = $("#searchForm").serializeObject();
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, width: '100px', className: 'center'},
                {data: 'logUser', width: '120px',className: 'center'},
                {data: 'logType', width: '120px',className: 'center'},
                {data: 'logRemark', width: '150px'},
                {data: 'logTime', width: '120px',className: 'center'}
            ],
            columnDefs: [
               
            ]
        });

    }


    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#searchForm").serializeObject();
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([])
    }

})
