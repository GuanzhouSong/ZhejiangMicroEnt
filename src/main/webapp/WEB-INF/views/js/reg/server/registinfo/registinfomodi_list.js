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
            scrollX: true, //支持滚动
            showIndex: true,
            ajax: {
                url: '/reg/server/registinfo/registinfo/modiList.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: 'id', 'className': 'center'},
                {data: 'id', 'className': 'center'},
                {data: 'id', 'className': 'center'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'dom'},
                {data: 'apprDate'},
                {data: 'archDate'},
                {data: 'localAdmName'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" name="_checkbox" data-uid="' + row.uid + '" data-registstate="' + row.registState + '" value=' + row.priPID + '>';
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        return '<a href="javascript:void(0);" class="js-edit">修改</a>';
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
                el: '.js-edit',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '修改',
                        area: ['100%', '100%'],
                        content: '/reg/server/registinfo/registinfo/toShow?fromtype=single&archState=1&priPID=' + data.priPID + '&UID=' + data.uid,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            }, {
                el: '.js-batchmodi',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    var trueFlag = true;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                    });
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                        layer.dialog({
                            title: '批量修改',
                            area: ['100%', '80%'],
                            content: '/reg/server/registinfo/registinfo/toShow?fromtype=batch&archState=1&priPID=' + ItemIds,
                            callback: function (data) {
                                //重新加载列表数据
                                if (data.reload) {
                                    table.ajax.reload();
                                }
                            }
                        })
                    }
                }
            },
            {
                el: '#qry',
                event: 'click',
                handler: function () {
                    searchParams = $("#qryForm").serializeObject();
                    var ItemIds = new Array();
                    var index = 0;
                    $(":checkbox[name=_blankItem]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                    });
//                    debugger;
                    searchParams._blankItem = ItemIds.toString();
                    table.ajax.reload();
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $(':input', '#qryForm')
                        .not(':button, :submit, :checkbox,:radio')
                        .val('');
                    $(':checkbox,:radio', '#qryForm')
                        .prop('checked',false);
                }
            },
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },{
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['400px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	var returnname=data.returnname;
                        	$("#regOrg").val(returncode);
                        	$("#regOrgName").val(returnname);
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
                        area: ['400px', '600px'],
                        content: '/commom/server/regunit/regunitmutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	var returnname=data.returnname;	 
                          	$("#localAdm").val(returncode);
                          	$("#localAdmName").val(returnname);
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
                        area: ['400px', '600px'],
                        content: '/commom/server/entcatg/entcatgmutiselect',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	$("#entType").val(returncode);
                        	$("#entTypeName").val(data.returnname);  
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
                        area: ['400px', '600px'],
                        content: '/commom/server/sliceno/slicenomutiselect?isPermissionCheck=true',
                        callback: function (data) { 
                        	var returncode=data.returncodes;
                        	$("#sliceNO").val(returncode);
                        	$("#sliceNoName").val(data.returnname);  
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
//                            table.ajax.reload();
                        }
                    })
                }
            }
        ])
    }

})
