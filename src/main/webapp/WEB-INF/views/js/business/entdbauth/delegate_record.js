require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;
    var params = {};//表格查询参数

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        //var tpl = $('#tpl').html();
        //var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            showIndex: true,
            ajax: {
                type: "get",
                url: '/reg/server/entdbauth/delegate_record.json',
                data: function (d) {
                    d.params = params;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className: 'center'},
                {data: 'entName'},
                {data: 'delegateOrgName'},
                {data: 'username'},
                {data: 'appReviewOrgName'},
                {data: 'setTime'}
            ],
            columnDefs: [
                //{   targets:1,
                //    render:function(data,type,row,meta){
                //        return  '<input type="checkbox" name="_checkbox" data-uid="'+row.uid+'" data-registstate="'+row.registState+'" value='+row.priPID+'>';
                //    }
                //}
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    params = $("#entSearchForm").serializeObject();
                    table.ajax.reload();
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
        ])
    }

})
