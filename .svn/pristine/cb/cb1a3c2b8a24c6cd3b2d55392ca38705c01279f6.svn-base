require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    var searchParams = {};//查询参数声明!
    var table;
    /**
     * 初始化函数集合
     */
    function init() {
        searchParams={yrYear: $('#yrYear').val(),yrIsRep:$('#yrIsRep').val()}
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
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                url: '/reg/server/masssms/ent.json',
                data: function (d) {
                 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null, 'defaultContent': '11'},
                {data: 'spotYear', 'defaultContent': ''},
                {data: 'uniscid'},
                {data: 'entName'},
                {data: 'yrLiaConfirm2013', 'defaultContent': ''},
                {data: 'yrIsRep2013', 'defaultContent': ''},
                {data: 'yrRepState2013', 'defaultContent': ''},
                {data: 'leRep'},
                {data: 'tel'},
                {data: 'liaName'},
                {data: 'liaTel'},
                {data: 'entTypeName'},
                {data: 'regOrgName'},
                {data: 'checkDepName'},
                {data: 'localAdmName'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" name="_checkbox" data-liatel="' + row.liaTel + '" data-tel="' + row.tel + '" value=' + row.priPID + '>';
                    }
                },
                {
                    targets: "uniscid",
                    render: function (data, type, row, meta) {
                        if(data==null||data=='')return row.regNO;
                        else return data;
                    }
                }
                ,
                {
                    targets: "yrLiaConfirm",
                    render: function (data, type, row, meta) {
                        if(data=='Y')
                            return '已确认'
                                else return '未确认';
                    }
                }
                ,
                {
                    targets: "yrIsRep",
                    render: function (data, type, row, meta) {
                        if(data=='Y')
                            return '已年报'
                        else return '未年报';
                    }
                }
                ,
                {
                    targets: "yrRepState",
                    render: function (data, type, row, meta) {
                        if(data=='10')return '已公示'
                            else if(data=='12')return '敏感词待审核'
                            else if(data=='13')return '敏感词不通过'
                            else if(data=='11')return '敏感词通过'
                            else if(data=='20')return '待修改'
                            else if(data=='00')return '未公示'
                        else return '';
                    }
                }
            ]
        })
    }


    function bind() {
        util.bindEvents([
            {
                el: '.js-masssms',
                event: 'click',
                handler: function () {
                    var len = $("input[name=_checkbox]:checked").length;
                    if (len == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }

                    var priPID = new Array();
                    var tel = new Array();
                    var liatel = new Array();
                    var index = 0;
                    $("input[name=_checkbox]:checked").each(function () {

                        if($(this).val()!=null&&$(this).val()!=''){
                            priPID[index] =$(this).val();
                        }else{
                            priPID[index] = '-';
                        }

                        if($(this).data('tel')!=null&&$(this).data('tel')!=''){
                            tel[index] =$(this).data('tel');
                        }else{
                            tel[index] = '-';
                        }
                        if($(this).data('liatel')!=null&&$(this).data('liatel')!=''){
                            liatel[index]=$(this).data('liatel');
                        }else{
                            liatel[index] = '-';
                        }
                        index++;
                    });
                    layer.dialog({
                        title: '短信群发',
                        area: ['80%', '90%'],
                         content: '/reg/server/masssms/tomasssmsedit?priPID=' + priPID+'&tel='+tel+'&liatel='+liatel,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
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
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, .notReset')
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
                    $("input[name='_checkbox']").prop("checked", flag);
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
                            $("#entType").val(data.returncode);
                            var name = data.returnname;
                            $("#entTypeName").val(name);
                        }
                    })
                }
            }
        ])
    }

})
