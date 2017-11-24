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
                url :  '/syn/system/sysuser/list.json',
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
                        if (window._CONFIG.isAdmin == "2"||window._CONFIG.isAdmin == "1") {//如果是汇信维护人员
                            if (row.status == "1") {
                                var opt = "<a href = 'javascript:void(0);' class='js-edit'>编辑</a> <a href='javascript:void(0);' class='js-disable'>禁用</a>";
                                if (row.isCheck == "1") {
                                    opt = opt + " <a href='javascript:void(0);' class='js-revalid'>重新验证</a>";
                                }
                                return opt;
                            }
                            if (row.status == "0") {
                                return "<a href = 'javascript:void(0);' class='js-enable'>启用</a>";
                            }
                        }else {
                            if (row.status == "1") {
                                return "<a href = 'javascript:void(0);' class='js-edit'>编辑</a> <a href='javascript:void(0);' class='js-disable'>禁用</a>";
                            }
                            if (row.status == "0") {
                                return "<a href = 'javascript:void(0);' class='js-enable'>启用</a>";
                            }
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
                    area: ['90%', '90%'],
                    content: '/syn/system/sysuser/show',
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
                    area: ['90%', '90%'],
                    content: '/syn/system/sysuser/show?id=' + data.id+'&',
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
                        url: '/syn/system/sysuser/disable',
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
                            url: '/syn/system/sysuser/enable',
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
                                $("#regOrg").val(data.orgCodes);
                                $("#regOrgName").val(data.orgNames);
                            }

                            if(data.orgCode){
                                $("#regOrg").val(data.orgCode);
                                $("#regOrgName").val(data.orgName);
                            }
                        }
                    })
                }
            }
            ,{
                el: '#reset',
                event: 'click',
                handler: function () {
                    $("#regOrg").val("");
                    $("#areaCode").val("");
                    $("#dutyCodes").val("");
                    $("#statusSelect option[value='1']").prop("selected", 'selected');
                }
            },{
                el: '.js-revalid',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.confirm('确定要让该用户重新校验吗?', {icon: 2, title: '提示'}, function (index) {
                        http.httpRequest({
                            url: '/syn/system/sysuser/revalid',
                            data: {id: data.id},
                            success: function (data) {
                                if (data.status == 'success') {
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
            },
            {
                el: '#selectDutyCodes',
                event: 'click',
                handler: function () {
                        layer.dialog({
                            title: '选择职能部门',
                            area: ['440px', '80%'],
                            content: '/common/system/code_duty_dept/duty_dept_select',
                            callback: function (data) {
                            	
                                $("#dutyCodes").val(data.deptCodes);
                                $("#dutyCodeNames").val(data.deptNames);
                            }
                        })
                }
            },
            {
                el: '#selectArea',
                event: 'click',
                handler: function () {
                   /* layer.dialog({
                        title: '选择区域',
                        area: ['440px', '80%'],
                        content: '/commom/server/regunit/selectArea',
                        callback: function (data) {
                            $("#areaCode").val(data.returncodes);
                            $("#areaName").val(data.returnname);
                        }
                    })*/
	                    layer.dialog({
	                    title: '选择区域',
	                    area: ['25%', '65%'],
	                    content: '/common/system/sysdepart/deptSelectCtity?treeType=checkbox&isUserMange=1',
	                    callback: function (data) {
	                    	if(typeof data.adCodes!="undefined"&&data.adCodes!=""&&data.adCodes!=null){
	                    		$("#areaCode").val(data.adCodes); 
	                     		$("#areaName").val(data.orgNames); 
	                     	}
	                   }
	                })
                }
            }

        ])
    }

})
