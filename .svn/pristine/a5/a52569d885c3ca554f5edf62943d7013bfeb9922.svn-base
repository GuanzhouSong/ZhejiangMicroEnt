require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 
         'jquery','jquery.serialize'], function (layer, dataTable, util, http, handlebars) {

	var table;
	var params = {};//查询参数声明!
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	$("#statusSelect option[value='1']").prop("selected", 'selected');
    	
        initDataTable();
        bind();
    }


    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            scrollX:true, //支持滚动
            showIndex: true,
            el: '#user-table',
            ajax : {
                type : "get",
                url :  '/sment/server/sysuser/list.json',
                data : function(d) {
                    d.params = $.extend({}, $("#entSearchForm").serializeObject());
                }
            },
            columns: [
                {data: null,width: '25px'},//序号0
                {data: null, width: '120px', className: 'center'  },//操作1
                {data: 'username', width: '80px',cut: {length: 20,mark:'...'}},//用户名2
                {data: 'realName', width: '90px',cut: {length: 20,mark:'...'}},//姓名3
                {data: 'dept', width: '120px'},//单位4
                {data: 'post', width: '70px'},//职位5
                {data: 'telPhone', width: '80px'},//手机6
                {data: 'phone', width: '120px'},//座机7
                {data: 'status', width: '50px'},//状态8
                {data: 'createTime', width: '120px'},//创建日期9
                {data: 'lastLoginTime', width: '120px'},//最近登录日期10
                {data: 'userSetPerson', width: '120px'},//设置人11
                {data: 'setDate', width: '120px'}//设置日期12
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	if(row.status=="1"){
                            return "<a href = 'javascript:void(0);' class='js-edit'>编辑</a> <a href='javascript:void(0);' class='js-disable'>禁用</a>";
                        }
                        if(row.status=="0"){
                            return "<a href = 'javascript:void(0);' class='js-enable'>启用</a>";
                        }
                    }
                },{
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
                    area: ['90%', '90%'],
                    content: '/sment/server/sysuser/show',
                    callback: function (data) {
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
                    area: ['90%', '90%'],
                    content: '/sment/server/sysuser/show?id=' + data.id+'&',
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
                        url: '/sment/server/sysuser/disable',
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
                            url: '/sment/server/sysuser/enable',
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
                            if(data.orgCodes){
                                $("#regOrg").val(data.deptId);
                                $("#regOrgName").val(data.orgNames);
                            }

                            if(data.orgCode){
                                $("#regOrg").val(data.deptId);
                                $("#regOrgName").val(data.orgName);
                            }
                        }
                    })
                }
            } ,{
                el: '#reset',
                event: 'click',
                handler: function () {
                    $("#regOrg").val("");
                    $("#statusSelect option[value='1']").attr("selected", 'selected');
                }
            }

        ])
    }

})
