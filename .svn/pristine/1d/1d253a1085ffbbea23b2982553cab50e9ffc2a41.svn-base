require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;
    var params = {};//查询参数声明!
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        $("#statusSelect option[value='1']").prop("selected", 'selected');
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            scrollX:true, //支持滚动
            showIndex: true,
            //需要初始化dataTable的dom元素
            el: '#user-table',
            ajax : {
                type : "get",
                url :  '/reg/server/sysuser/list.json',
                data : function(d) {
                    d.params = $.extend({}, $("#entSearchForm").serializeObject());
                }
            },

            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null,width: '25px'},//序号0
                {data: null, width: '120px', className: 'center'  },//操作1
                {data: 'username', width: '80px',cut: {length: 20,mark:'...'}},//用户名2
                {data: 'realName', width: '90px',cut: {length: 20,mark:'...'}},//姓名3
                {data: 'dept', width: '120px'},//单位4
                {data: 'post', width: '70px'},//职位5
                {data: 'telPhone', width: '80px'},//手机6
                {data: 'phone', width: '120px'},//座机7
                {data: 'status', width: '50px'},//状态9
                {data: 'createTime', width: '120px'},//创建日期10
                {data: 'lastLoginTime', width: '120px'},//最近登录日期11
                {data: 'userSetPerson', width: '120px'},//设置人12
                {data: 'setDate', width: '120px'}//设置日期13
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        if(row.status=="1"){
                            return "<a href = 'javascript:void(0);' class='js-edit'>编辑</a> <a href='#' class='js-disable'>禁用</a>";
                        }
                        if(row.status=="0"){
                            return "<a href = 'javascript:void(0);' class='js-enable'>启用</a>";
                        }
                    }
                },
                {
                    targets: 8,
                    render: function (data, type, row, meta) {
                        if(row.status=='1')return "有效";
                        if(row.status=='0')return "无效";
                        return "未知状态";
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
            el: '.js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '新增用户',
                    area: ['98%', '90%'],
                    content: '/reg/server/sysuser/show',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
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
                layer.dialog({
                    title: '编辑用户',
                    area: ['98%', '90%'],
                    content: '/reg/server/sysuser/show?id=' + data.id+'&',
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-disable',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要禁用该用户吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/sysuser/disable',
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
        }, {
                el: '.js-enable',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.confirm('确定要启用该用户吗?', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/reg/server/sysuser/enable',
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
            }
            ,{
                el: '#choseDept',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择部门',
                        area: ['400px', '600px'],
                        content: window._CONFIG.select_detp_tree_url,
                        callback: function (data) {
                            $("#regOrg").val(data.deptId);
                            $("#regOrgName").val(data.deptName);
                        }
                    })
                }
            }
            ,{
                el: '#reset',
                event: 'click',
                handler: function () {
                    $("#regOrg").val("");
                    $("#extNetAuthSelect option:first").prop("selected", 'selected');
                    $("#statusSelect option[value='1']").prop("selected", 'selected');
                }
            }
        ])
    }

})
