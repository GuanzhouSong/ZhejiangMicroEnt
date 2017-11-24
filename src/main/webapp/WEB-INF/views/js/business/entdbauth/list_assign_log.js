require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

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
                type:"get",
                url:'/reg/server/entdbauth/list_assign_log_data.json',
                data:function(d){
                    d.params = params;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className: 'center'},
                {data: 'entName'},
                {data: 'assignUserName'},
                {data: 'assignDeptName'},
                {data: 'isCancleAssign'},
                {data: 'setTime'}
            ],
            columnDefs: [
                {   targets:4,
                    render:function(data,type,row,meta){
                        if(row.isCancleAssign=="1"){
                           return "是";
                        }
                        if(row.isCancleAssign=="0"){
                            return "否";
                        }
                        return "-";
                    }
                }
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
            },
            {
                el: '#setDelegate',
                event: 'click',
                handler: function () {
                    var ids = new Array();
                    var index = 0;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ids[index++] = $(this).val();
                    });
                    if (ids.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                        http.httpRequest({
                            url: '/admin/system/entdbauth/delegate',
                            data: {priPIDs: ids.toString()},
                            success: function (data) {
                                if (data.status == 'success') {
                                    alert("委托成功！");
                                }else{
                                    alert(data.msg);
                                }
                            }
                        });
                    }
                }
            }, {
                el: '.js-edit',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '编辑用户',
                        area: ['1024px', '768px'],
                        content: '/admin/system/sysuser/show?id=' + data.id,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            }, {
                el: '.js-delete',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/admin/system/sysuser/delete',
                            data: {id: data.id},
                            success: function (data) {
                                if (data.status == 'success') {
                                    //重新加载列表数据
                                    if (data.msg) {
                                        layer.msg(data.msg, {time: 500}, function () {
                                            table.ajax.reload();
                                        });
                                    }
                                }
                            }
                        });

                    });
                }
            }])
    }

})
