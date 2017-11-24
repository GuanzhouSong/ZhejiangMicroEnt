require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams = {};//查询参数声明!
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
                url:'/reg/server/orderreformset/panoQueryPage',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null, 'defaultContent': '11'},
                {data: 'uniscid'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'entTypeName'},
                {data: 'industryCoName'},
                {data: 'dom'},
                {data: 'regOrgName'},
                {data: 'localAdmName'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="radio" name="_checkbox" value=' + row.priPID + '>';
                    }
                },
                {
                    targets: 2,

                    render: function (data, type, row, meta) {
                        if (data == null || data == '')return row.regNO;
                        else return data;
                    }
                },
                {
                    targets: "uniCode",
                    render: function (data, type, row, meta) {
                        if(data==null||data=='')return row.regNO;
                        else return data;
                    }
                }
            ]
        })
    }


    function bind() {
        util.bindEvents([
            {
                el: '.js-add',
                event: 'click',
                handler: function () {
                    var len = $(":radio[name=_checkbox]:checked").length;
                    if (len == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    var pripid = '';
                    $(":radio[name=_checkbox]:checked").each(function () {
                        pripid = $(this).val();
                    });
                    layer.dialog({
                        title: '新增',
                        area: ['80%', '90%'],
                        content: '/reg/server/govguide/govguide/toAdd?fromtype=add&pripid=' + pripid,
                        callback: function (data) {

                        }
                    })
                }
            }, {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    table.ajax.reload();
                }
            },
            {
                el: '#moreqry',
                event: 'click',
                handler: function () {

                    layer.dialog({
                        title: '更多查询条件',
                        area: ['328px', '600px'],
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
                el: '#return',
                event: 'click',
                handler: function () {
                    // location.href = "/reg/server/govguide/govguide/toList";
                    layer.close({reload: true});
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:radio[name='_checkbox']").prop("checked", flag);
                }
            },
            {
                el: '.js-fold',
                event: 'click',
                handler: function () {
                    if ($(this).hasClass('fold-on')) {
                        $(this).text('展开更多查询条件');
                        $(this).removeClass("fold-on");
                    } else {
                        $(this).text('隐藏更多查询条件');
                        $(this).addClass("fold-on");
                    }

                    $(this).parent().prev('.form-item-more').toggle();
                    $('.detail-brief').toggleClass('border-bottom');
                }
            },
            {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#regOrg").val(data.returncodes);
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
                            $("#localAdm").val(data.returncodes);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            }
            ,
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
                            $("#entType").val(data.returncodes);
                            var name = data.returnname;
                            $("#entTypeName").val(name);
                        }
                    })
                }
            }
            ,
            {
                el: '#choseIndustryCo',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择行业',
                        area: ['25%', '70%'],
                        content: '/commom/server/industry/toIndustryPhyTree',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#industryCo").val(data.returncodes);
                            $("#industryCoName").val(data.returnname);
                        }
                    })
                }
            }
        ])
    }

})
