require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'],
    function (layer, dataTable, util, http, handlebars) {

        init();
        /**
         * 初始化函数集合
         */
        function init() {
            initDataTable();
            bind();
        }

        var searchParams = {}; //查询参数声明!
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
                    url: '/reg/server/registinfo/registinfo/delegateList.json',
                    data: function (d) {
                        d.params = searchParams;
                    }
                },
                //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
                //'className'不要写成class
                columns: [{
                    data: 'id',
                    'className': 'center'
                },

                    {
                        data: 'id',
                        'className': 'center'
                    },
                    {
                        data: 'registSource'
                    },
                    {
                        data: 'regOrgName'
                    },
                    {
                        data: 'comDate'
                    },
                    {
                        data: 'delegateOrgName'
                    },
                    {
                        data: 'uniCode'
                    },
                    {
                        data: 'entName'
                    },
                    {
                        data: 'leRep'
                    },
                    {
                        data: 'dom'
                    },
                    {
                        data: 'regOrgName'
                    },
                    {
                        data: 'localAdmName'
                    }],
                columnDefs: [{
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" name="_checkbox" data-uid="' + row.uid + '" data-registsource="' + row.registSource + '" value=' + row.priPID + '>';
                    }
                },
                    {
                        targets: 2,
                        render: function (data, type, row, meta) {
                            if (data == '3') {
                                return '';
                            } else if (data == '2') {
                                return '自管';
                            } else if (data == '1') {
                                return '委托';
                            } else return '';
                        }
                    },
                    {
                        targets: "regOrgName",
                        render: function (data, type, row, meta) {
                            if (row.registSource == '3') {
                                return '';
                            } else return data;
                        }
                    },
                    {
                        targets: "comDate",
                        render: function (data, type, row, meta) {
                            if (row.registSource == '3') {
                                return '';
                            } else return data;
                        }
                    },
                    {
                        targets: "uniCode",
                        render: function (data, type, row, meta) {
                            if (data == null || data == '')return row.regNO;
                            else return data;
                        }
                    },
                    {
                        targets: "delegateOrgName",
                        render: function (data, type, row, meta) {
                            if (row.registSource == '2') {
                                return row.regOrgName;
                            } else return data;
                        }
                    }]
            })
        }

        //表格之外的查询按钮事件
        $("#search").click(function () {
            searchParams = $("#qryForm").serializeObject();
            table.ajax.reload();
        });

        function bind() {
            util.bindEvents([{
                el: '.js-batchdele',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    var trueFlag = true;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();

                        if ($(this).data('registsource') == '1' || $(this).data('registsource') == '2') {
                            trueFlag = false;
                        }
                    });
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {
                            ltype: 0,
                            time: 500
                        });
                        return false;
                    }
                    if (!trueFlag) {
                        layer.msg("只能未委托的数据进行设置！", {
                            time: 1500
                        });
                        return false;
                    }
                    layer.dialog({
                        title: '设置委托',
                        area: ['628px', '600px'],
                        content: '/reg/server/registinfo/registinfo/toBatchDele?priPID=' + ItemIds,
                        callback: function (data) {
                            //重新加载列表数据
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    });
                }
            },
                {
                    el: '.js-batchcanceldele',
                    event: 'click',
                    handler: function () {
                        var ItemIds = new Array();
                        var index = 0;
                        var trueFlag = true;
                        $(":checkbox[name=_checkbox]:checked").each(function () {
                            ItemIds[index++] = $(this).val();
                            if ($(this).data('registsource') != '1' && $(this).data('registsource') != '2') {
                                trueFlag = false;
                            }
                        });
                        if (ItemIds.length == 0) {
                            layer.msg("请选择一项进行操作", {
                                ltype: 0,
                                time: 500
                            });
                            return false;
                        }
                        if (!trueFlag) {
                            layer.msg("只能选择已经设置过委托的进行取消委托！", {
                                time: 1000
                            });
                            return false;
                        }
                        layer.confirm('确定要取消委托吗?', {
                                icon: 2,
                                title: '温馨提示'
                            },
                            function (index) {
                                http.httpRequest({
                                    url: '/reg/server/registinfo/registinfo/batchcancelDelegate',
                                    data: {
                                        priPID: ItemIds.toString()
                                    },
                                    type: "post",
                                    success: function (data) {
                                        if (data.status == 'success') {
                                            //重新加载列表数据
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
                }, {
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
                },
                {
                    el: '#choseEntType',
                    event: 'click',
                    handler: function () {
                        layer.dialog({
                            title: '选择企业类型',
                            area: ['25%', '70%'],
                            content: '/commom/server/entcatg/entcatgmutiselectnocheck',
                            callback: function (data) {
                                //重新加载列表数据
                                $("#entType").val(data.returncode);
                                var name = data.returnname;
                                $("#entTypeName").val(name);
                            }
                        })
                    }
                },
                {
                    el: '#choseSilceno',
                    event: 'click',
                    handler: function () {
                        layer.dialog({
                            title: '选择责任区',
                            area: ['25%', '60%'],
                            content: '/commom/server/sliceno/slicenomutiselectnocheck',
                            callback: function (data) {
                                //重新加载列表数据
                                $("#sliceNO").val(data.returncode);
                                $("#sliceNoName").val(data.returnname);
                                table.ajax.reload();
                            }
                        })
                    }
                }, {
                    el: '#choseStreet',
                    event: 'click',
                    handler: function () {
                        layer.dialog({
                            title: '选择街道',
                            area: ['25%', '60%'],
                            content: '/commom/server/codestreet/streetmutiselectnocheck',
                            callback: function (data) {
                                //重新加载列表数据
                                $("#street").val(data.returncode);
                                $("#streetName").val(data.returnname);
                                table.ajax.reload();
                            }
                        })
                    }
                }

            ])
        }

    })