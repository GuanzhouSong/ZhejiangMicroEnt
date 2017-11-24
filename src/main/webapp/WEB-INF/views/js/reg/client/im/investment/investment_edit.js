require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http',  'jquery', 'jquery.serialize', 'handlebars', 'jquery.placeholder', 'jquery.icinfo'],
    function (layer, dataTable, util, http, handlebars) {
        $('input, textarea').placeholder();
        $('.js-ipt-box').expandInput();
        init();
        /**
         * 初始化函数集合
         */
        function init() {
            initDataTable();
            initmentDataTable();
            $(".dataTables_info").hide();
            bind();
        }


        var table;
        var table1;

        function initmentDataTable() {// 初始化table
            /* var tplact = $('#tplact').html();
             var template = handlebars.compile(tplact);*/
            $("#permit-table_info").hide();
            var invID = $("#id").val();
            table1 = dataTable.load({
                // 需要初始化dataTable的dom元素
                el: '#investment-table',
                bPaginate: false,
                ajax: {
                    url: '/reg/client/im/ent/invactdetail/list.json',
                    data: {
                        "invId": invID
                    }

                },
                buttons: [],
                // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                // className不要写成class
                columns: [{
                    data: 'acConFormCn',
                    width: '100px'
                },
                    {
                        data: 'acConAm'
                    },
                    {
                        data: 'conDate'
                    },
                    {
                        data: 'pubFlag',
                        width: '250px'
                    },

                    {
                        data: null,
                        width: '120px',
                        className: 'center'
                    }],
                columnDefs: [
                    {
                        targets: 2,
                        render: function (data, type, row, meta) {
                            var date = row.conDate.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";

                        }
                    },

                    {
                        targets: 3,
                        render: function (data, type, row, meta) {
                            if (row.pubFlag == "1") {
                                return "已公示";
                            }
                            if (row.pubFlag == "2") {
                                return "未公示";
                            }

                            if (row.pubFlag == "0") {
                                return "未公示";
                            }
                        }
                    },

                    {
                        targets: 4,
                        render: function (data, type, row, meta) {
                            var del = "";
                            if (row.pubFlag != "1") {
                                del = "<a  href='javascript:void(0);' class='js-deletAct' id=" + row.paidID + " title=" + row.pubFlag + ">删除</a>";
                            }

                            return " <a   href='javascript:void(0);' class='js-editAct' id=" + row.paidID + " title=" + row.pubFlag + ">修改&nbsp;&nbsp;</a>" + del;

                        }
                    }]
            })
        }

        /**
         * 初始化dataTable
         */
        function initDataTable() {
            /*   var tpl = $('#tpl').html();
             var template = handlebars.compile(tpl);*/
            $("#permit-table_info").hide();
            var invID = $("#id").val();
            table = dataTable.load({
                // 需要初始化dataTable的dom元素
                el: '#permit-table',
                bPaginate: false,
                /*
                 * ajax: '/reg/client/im/investment/list.json', data:{invId:invID},
                 */
                ajax: {
                    url: '/reg/client/im/ent/inprodetail/list.json',
                    data: {
                        "invId": invID
                    }
                },
                buttons: [],

                // 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                // className不要写成class
                columns: [{
                    data: 'conFormCN',
                    width: '100px'
                },
                    {
                        data: 'subConAm'
                    },
                    {
                        data: 'conDate'
                    },
                    {
                        data: 'pubFlag',
                        width: '250px'
                    },
                    {
                        data: null,
                        width: '120px',
                        className: 'center'
                    }],
                columnDefs: [
                    {
                        targets: 2,
                        render: function (data, type, row, meta) {
                            var date = row.conDate.split("-");
                            return date[0] + "年" + date[1] + "月" + date[2] + "日";
                        }
                    },

                    {
                        targets: 3,
                        render: function (data, type, row, meta) {
                            if (row.pubFlag == "1") {
                                return "已公示";
                            }
                            if (row.pubFlag == "2") {
                                return "未公示";
                            }

                            if (row.pubFlag == "0") {
                                return "未公示";
                            }
                        }
                    },

                    {
                        targets: 4,
                        render: function (data, type, row, meta) {
                            /*     var context;
                             if (row.pubFlag != "1") {
                             context = {
                             func: [{
                             'text': '修改',
                             'class': 'js-edit'
                             },
                             {
                             'text': '删除',
                             'class': 'js-delete'
                             }]
                             };
                             } else {
                             context = {
                             func: [{
                             'text': '修改',
                             'class': 'js-edit'
                             }]
                             };
                             }
                             return template(context);*/

                            var del = "";
                            if (row.pubFlag != "1") {
                                del = "<a  href='javascript:void(0);' id=" + row.subID + " class='js-delete'   title=" + row.pubFlag + ">删除</a>";
                            }

                            return " <a   href='javascript:void(0);' class='js-edit' id=" + row.subID + " title=" + row.pubFlag + ">修改&nbsp;&nbsp;</a>" + del;

                        }

                    }]

            })
        }

        function bind() {
            util.bindEvents([

                {
                    el: '.js-add',
                    event: 'click',
                    handler: function () {
                        if (!$.trim($("#invr").val())) {
                            /*
                             * layer.msg("请输入股东名称", { time: 1000 }, function() { return
                             * false; });
                             */
                            layer.tips('请输入股东名称', $("#invr"), {tips: 3, tipsMore: true, ltype: 0});
                            $("#invr").foucs();
                            return false;
                        } else {
                            http.httpRequest({
                                url: '/reg/client/im/ent/investment/save',
                                serializable: false,
                                data: {
                                    invID: $("#invID").val(),
                                    inv: $("#invr").val()
                                },
                                type: 'post',
                                success: function (data) {
                                    location.href = "/reg/client/im/ent/inprodetail/show?invID=" + $("#id").val();

                                }
                            })
                        }

                    }
                },

                {
                    el: '.js-addAct',
                    event: 'click',
                    handler: function () {
                        if (!$.trim($("#invr").val())) {
                            layer.tips('请输入股东名称', $("#invr"), {tips: 3, tipsMore: true, ltype: 0});
                            $("#invr").foucs();
                            return false;
                        } else {
                            http.httpRequest({
                                url: '/reg/client/im/ent/investment/save',
                                serializable: false,
                                data: {
                                    invID: $("#invID").val(),
                                    inv: $("#invr").val()
                                },
                                type: 'post',
                                success: function (data) {
                                    location.href = '/reg/client/im/ent/invactdetail/show?invID=' + $("#id").val();
                                }
                            })
                        }

                    }
                },
                {
                    el: '#cancel',
                    event: 'click',
                    handler: function () {

                        if (!$.trim($("#invr").val())) {
                            http.httpRequest({
                                url: '/reg/client/im/ent/investment/delete',
                                data: {
                                    invId: $("#id").val()
                                },
                                success: function (data) {
                                    if (data.status == 'success') {
                                        location.href = "/reg/client/im/ent/investment/list";
                                    }
                                }
                            })
                        } else {
                            location.href = "/reg/client/im/ent/investment/list";
                        }
                    }
                },

                {
                    el: '.js-editAct',
                    event: 'click',
                    handler: function () {
                        location.href = '/reg/client/im/ent/invactdetail/show?paidID=' + this.id + "&invID=" + $("#id").val() + "&pubFlag=" + this.title;
                    }
                },
                {
                    el: '.js-inv-list',
                    event: 'click',
                    handler: function () {
                        layer.dialog({
                            title: '股东列表选择',
                            area: ['400px', '600px'],
                            content: '/reg/client/im/ent/investment/inv_select?priPID=' + $(this).attr("pripid"),
                            callback: function (data) {
                                var inv=data.inv;
                                if(inv!='undefined'&&inv!=''&&inv!=undefined){
                                    $("#invr").val(inv);
                                    $("#SensitiveName").val(inv);
                                    $("#Sensitive").val("yes");
                                }
                            }
                        })
                    }
                },
                {
                    el: '#saveForUpdate',
                    event: 'click',
                    handler: function () {

                        if (!$.trim($("#invr").val())) {
                            layer.tips('请输入股东名称', $("#invr"), {tips: 3, tipsMore: true, ltype: 0});
                            $("#invr").focus();
                            return false;
                        }
                        var invr_name = $.trim($("#invr").val());
                        var _name = $("#SensitiveName").val();
                        if(_name){
                            if(_name!=invr_name){
                                $("#Sensitive").val("no");
                            }else{
                                $("#Sensitive").val("yes");
                            }
                        }

                        var data={ invID: $("#invID").val(), inv: $("#invr").val(),sensitive:$("#Sensitive").val()};
                        http.httpRequest({
                            url: '/reg/client/im/ent/investment/save',
                            serializable: false,
                            data: data,
                            type: 'post',
                            success: function (data) {

                                if(data.status=='fail'){
                                    layer.msg(data.msg, {time: 2000});
                                    return;
                                }
                                if (data.status == "success") {
                                    layer.msg(data.msg, {
                                            time: 1000
                                        },
                                        function () {
                                            location.href = "/reg/client/im/ent/investment/list";
                                        });
                                } else {
                                    layer.msg(data.msg, {
                                            time: 2000
                                        },
                                        function () {
                                            location.href = "/reg/client/im/ent/investment/list";

                                        });

                                }
                            }
                        })
                    }
                },

                {
                    el: '.js-edit',
                    event: 'click',
                    handler: function () {
                        var data = table.row($(this).closest('td')).data();
                        location.href = '/reg/client/im/ent/inprodetail/show?subID=' + this.id + "&invID=" + $("#id").val() + "&pubFlag=" + this.title;
                    }
                },
                {
                    el: '.js-delete',
                    event: 'click',
                    handler: function () {
                        var id = this.id;
                        layer.confirm('确定要删除吗?', {
                                icon: 2,
                                title: '提示'
                            },
                            function (index) {
                                http.httpRequest({
                                    url: '/reg/client/im/ent/inprodetail/delete',
                                    data: {
                                        subID: id
                                    },
                                    success: function (data) {
                                        if (data.status == 'success') {
                                            // 重新加载列表数据
                                            if (data.msg) {
                                                layer.msg(data.msg, {
                                                        time: 500
                                                    },
                                                    function () {
                                                        table.ajax.reload();
                                                    });
                                            }
                                        } else if (data.status == "fail") {
                                            if (data.msg) {
                                                layer.msg(data.msg, {
                                                        time: 500
                                                    },
                                                    function () {
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
                    el: '.js-deletAct',
                    event: 'click',
                    handler: function () {
                        var id = this.id;
                        layer.confirm('确定要删除吗?', {
                                icon: 2,
                                title: '提示'
                            },
                            function (index) {

                                http.httpRequest({
                                    url: '/reg/client/im/ent/invactdetail/delete',
                                    data: {
                                        paidID: id
                                    },
                                    success: function (data) {
                                        if (data.status == 'success') {
                                            // 重新加载列表数据
                                            if (data.msg) {
                                                layer.msg(data.msg, {
                                                        time: 500
                                                    },
                                                    function () {
                                                        table1.ajax.reload();
                                                    });
                                            }
                                        } else if (data.status == "fail") {
                                            if (data.msg) {
                                                layer.msg(data.msg, {
                                                        time: 500
                                                    },
                                                    function () {
                                                        table1.ajax.reload();
                                                    });
                                            }
                                        }
                                    }
                                });

                            });
                    }
                }

            ])
        }

    });