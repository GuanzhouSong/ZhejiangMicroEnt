require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {
	var searchFlag="0";
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }


    var searchParams = {};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag="1";
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动

            ajax: {
                url: '/reg/server/registinfo/registinfo/againList.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'className': 'center',defaultContent:'1'},
                {data: null, 'className': 'center',defaultContent:'1'},
                {data: null, 'className': 'center',defaultContent:'1'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'dom'},
                {data: 'apprDate'},
                {data: 'localAdmName'},
                {data: 'altItem'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" name="_checkbox" value="' + row.priPID + '">';
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {

                        return '<a href="javascript:void(0);" class="js-edit">变更重建档</a>';
                    }
                },
                {
                    targets: "altItem",
                    render: function (data, type, row, meta) {
                        return '<a href="javascript:void(0);" class="js-detail">查看详情</a>';
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
                el: '.js-batchregist',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                    });
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    } else {
                        layer.dialog({
                            title: '主体户口管理-户口变更建档-批量建档',
                            area: ['100%', '500px'],
                            content: '/reg/server/registinfo/registinfo/toShow?fromtype=batch&isChangeArch=1&archState=0&priPID=' + ItemIds,
                            callback: function (data) {
                                //重新加载列表数据
                               if (data.reload) {
                                    table.ajax.reload();
                                }
                            }
                        })
                    }
                }
            }, {
                el: '.js-edit',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '主体户口管理-户口变更建档-变更重建档',
                        area: ['100%', '100%'],
                        content: '/reg/server/registinfo/registinfo/toShow?fromtype=single&isChangeArch=1&archState=1&priPID=' + data.priPID,
                        callback: function (data) {
                        /*    if (data.reload) {
                                table.ajax.reload();
                            }*/
                        }
                    })
                }
            },
            {
                el: '.js-detail',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '变更详情',
                        area: ['90%', '650px'],
                        content: '/reg/server/registinfo/registinfo/toAgainDetail?priPID=' + data.priPID,
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
                    searchParams = $("#qryForm").serializeObject();
                    if(searchFlag=="0"){
                		initDataTable();
                	}else{
                		table.ajax.reload();
                	}
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
            },
            {
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
