require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate','jquery.placeholder','jquery.icinfo'], function (layer, dataTable, util, http, handlebars) {
	 $('input, textarea').placeholder();
    init();
    /**
     * 初始化函数集合
     */
    function init() {

        initDataTable();
        bind();
    }

    var searchParams = {};// 查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {


        var tpl = $('#tpl').html();
        var userType = $("#userType").val();
        var typeUrl = "";
        if (userType == "2") {
            typeUrl = "/syn/server/other/pubSmallSupport/listJSON";
        } else {
            typeUrl = "/reg/server/other/pubSmallSupport/listJSON";
        }
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            // 需要初始化dataTable的dom元素
            el: '#user-table',
            // 是否加索引值
            showIndex: true,
            ajax: {
                url: typeUrl,
                data: function (d) {
                    d.params = searchParams;
                }
            },
            // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            // 'className'不要写成class
            columns: [{
                data: null,
                'className': 'center'
            },  

                {
                    data: null
                }, {
                    data: 'entName'
                }, {
                    data: 'regNO'
                }, {
                    data: 'deptName'
                }, {
                    data: 'provideType', cut: {length: 20, markZ: '...'}
                }, {
                    data: 'helpContent',cut:{length:20,markZ:'...'}
                }, {
                    data: 'helpDate'
                }, {
                    data: 'errorCode'
                }, {
                    data: 'setDate'
                }, {
                    data: 'feedBackTime'
                }

            ],
            columnDefs: [

                
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        var deptCode = $("#deptCode").val();
                        var userType = $("#userType").val();
                        if (userType == "1") {//警示不判断
                            if (row.auditState == '0') {
                                return "<a class='commit js_audit'>审核/a>";
                            } else {
                                return "<a class='commit js_view'>详情</a>";
                            }
                        } else {//协同判断
                            if (deptCode == row.deptID) {
                                if (row.auditState == '0') {
                                    return "<a class='commit js_audit'>审核</a>";
                                } else {
                                    return "<a class='commit js_view'>详情</a>";
                                }
                            } else {
                                return "<a class='commit js_view'>详情</a>";
                            }

                        }
                    }
                },
                {
                    targets: 5,
                    render: function (data, type, row, meta) {
                        if (row.provideType == "1") {
                            return "在线录入";
                        } else if (row.provideType == "2") {
                            return "批量导入";
                        } else if (row.provideType == "3") {
                            return "数据结构";

                        } else if (row.provideType == "4") {
                            return "数据交换";
                        }

                    }
                }


            ]
        })
    }

    function bind() {
        util
            .bindEvents([

                {
                    el: '.js_edit',
                    event: 'click',
                    handler: function () {
                        var data = table.row(
                            $(this).closest('td')).data();
                        var licID = data.uid;
                        var userType = $("#userType").val();
                        var typeUrl = "";
                        if (userType == "2") {
                            typeUrl = '/syn/server/other/pubSmallSupport/show?uid='
                                + licID;
                        } else {
                            typeUrl = '/reg/server/other/pubSmallSupport/show?uid='
                                + licID;
                        }
                        layer.dialog({
                            title: '扶持信息',
                            area: ['1000px', '600px'],
                            content: typeUrl,
                            callback: function (data) {

                                // 重新加载列表数据
                                if (data.reload) {
                                    table.ajax.reload();
                                }
                            }
                        })

                    }
                },
                
                {
                    el: '.js_view',
                    event: 'click',
                    handler: function () {
                        var data = table.row(
                            $(this).closest('td')).data();
                        var licID = data.uid;
                        var userType = $("#userType").val();
                        var typeUrl = "";
                        if (userType == "2") {
                            typeUrl = '/syn/server/other/pubSmallSupport/showDetails?uid='
                                + licID;
                        } else {
                            typeUrl = '/reg/server/other/pubSmallSupport/showDetails?uid='
                                + licID;
                        }
                        layer.dialog({
                            title: '行政许可详情',
                            area: ['1000px', '660px'],
                            content: typeUrl,
                            callback: function (data) {
                                // 重新加载列表数据
                                if (data.reload) {

                                    /*
                                     * $("#regOrg").val(data.reload.retruncode);
                                     * $("#regOrgName").val(data.reload.returnname);
                                     */

                                }
                            }
                        })

                    }
                },
                {
                    el: '#choseorgReg',
                    event: 'click',
                    handler: function () {

                        layer
                            .dialog({
                                title: '选择登记机关',
                                area: ['328px', '600px'],
                                content: '/commom/server/regorg/regorgmutiselect',
                                callback: function (data) {
                                    // 重新加载列表数据
                                    if (data) {
                                        $("#regOrg")
                                            .val(
                                                data.returncode);
                                        $("#regOrgName")
                                            .val(
                                                data.returnname);

                                    }
                                }
                            })

                    }
                },

                {
                    el: '#choseregUnit',
                    event: 'click',
                    handler: function () {

                        layer
                            .dialog({
                                title: '选择管辖单位',
                                area: ['328px', '600px'],
                                content: '/commom/server/regunit/regunitmutiselect',
                                callback: function (data) {
                                    // 重新加载列表数据
                                    if (data) {
                                        $("#localAdm")
                                            .val(
                                                data.returncode);
                                        $("#localAdmName")
                                            .val(
                                                data.returnname);

                                    }
                                }
                            })

                    }
                },

                {
                    el: '#choseEntcatg',
                    event: 'click',
                    handler: function () {

                        layer
                            .dialog({
                                title: '选择企业类型',
                                area: ['328px', '600px'],
                                content: '/commom/server/entcatg/entcatgmutiselect',
                                callback: function (data) {
                                    // 重新加载列表数据
                                    if (data) {

                                        $("#entType")
                                            .val(
                                                data.returncode);
                                        var name = data.returnname;
                                        $("#entTypeName")
                                            .val(name);

                                    }
                                }
                            })

                    }
                },

                {
                    el: '#choseSilceno',
                    event: 'click',
                    handler: function () {

                        layer
                            .dialog({
                                title: '选择责任区',
                                area: ['328px', '600px'],
                                content: '/commom/server/sliceno/slicenomutiselect',
                                callback: function (data) {
                                    // 重新加载列表数据
                                    if (data) {

                                        $("#sliceNO")
                                            .val(
                                                data.returncode);
                                        $("#sliceNoName")
                                            .val(
                                                data.returnname);
                                        table.ajax.reload();
                                    }
                                }
                            })

                    }
                },
                {
                    el: '.js_audit',
                    event: 'click',
                    handler: function () {
                        var data = table.row($(this).closest('td')).data();
                        layer.dialog({
                            title: '审核',
                            area: ['1000px', '600px'],
                            content: '/reg/server/other/pubSmallSupport/showToAudit?uid=' + data.uid,
                            callback: function (data) {
                                if (data.reload) {
                                    table.ajax.reload();
                                }
                            }
                        })
                    }
                },
                {
                    el: '#qry',
                    event: 'click',
                    handler: function () {
                        searchParams = $("#qryForm")
                            .serializeObject();
                        table.ajax.reload();
                    }
                },
                {
                    el: '#cancel',
                    event: 'click',
                    handler: function () {
                        $('#qryForm')[0].reset();
                        $("#regOrg").val("");
                        $("#localAdm").val("");
                        $("#entType").val("");
                        $("#sliceNO").val("");
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
                    el: '.js_delete',
                    event: 'click',
                    handler: function () {
                    	   var data = table.row($(this).closest('td')).data();
                        var userType = $("#userType").val();
                        var typeUrl = "";
                        if (userType == "2") {
                            typeUrl = "/syn/server/other/pubSmallSupport/deleteBatch";
                        } else {
                            typeUrl = "/reg/server/other/pubSmallSupport/deleteBatch";
                        }
                         
                        http.httpRequest({
                            url: typeUrl,
                            data: {"uid":data.uid},
                            success: function (data) {
                                if (data.status == 'success') {
                                    layer.msg(data.msg, {time: 1000}, function () {
                                        table.ajax.reload();
                                    })

                                }

                            }
                        });

                    }

                }

            ])
    }

})
