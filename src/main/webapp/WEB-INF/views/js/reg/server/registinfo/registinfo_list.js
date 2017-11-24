require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http',
    'handlebars', 'jquery', 'jquery.serialize', 'laydate'], function (layer, dataTable, util, http, handlebars) {
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
                url: '/reg/server/registinfo/registinfo/list.json',
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
                {data: 'claimState'},
                {data: 'claimName'},
                {data: 'claimDate'},
                {data: 'setTime'},
                {data: 'uniCode'},
                {data: 'entName'},
                {data: 'leRep'},
                {data: 'dom'},
                {data: 'estDate'},
                {data: 'localAdmName'},
                {data: 'sliceNOName'},
                {data: 'streetName'}
            ],
            columnDefs: [
                {
                    targets: 1,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" name="_checkbox"  data-claimstate="' + row.claimState + '" value=' + row.priPID + '>';
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        if (row.claimState == '1' || row.claimState == '3') {
                            return '<a href="javascript:void(0);" class="js-edit">建档录入</a>';

                        } else {
                            return '<a href="javascript:void(0);" class="js-claim">认领</a>' +
                                '<a href="javascript:void(0);" class="js-back">退回</a>';
                        }
                    }
                },
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        if (row.claimState == '0') {
                            return '未认领';
                        } else if (row.claimState == '1') {
                            return '已认领';
                        } else if (row.claimState == '2') {
                            return '超时未认领';
                        } else if (row.claimState == '3') {
                            return '超时已认领';
                        } else return '';
                    }
                },
                {
                    targets: 'claimName',
                    render: function (data, type, row) {
                        if (row.claimState == '0' || row.claimState == '2') {
                            return '';
                        } else return data;
                    }
                },
                {
                    targets: 'claimDate',
                    render: function (data, type, row) {
                        if (row.claimState == '0' || row.claimState == '2') {
                            return '';
                        } else return data;
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
                el: '.js-batchback',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    var trueFlag = true;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                        var claimstate = $(this).data("claimstate");
                        if (claimstate == '1' || claimstate == '3') {
                            trueFlag = false;
                        }
                    });
                    if (!trueFlag) {
                        layer.msg("只能选择未认领的数据进行退回！", {ltype: 0, time: 1000});
                        return false;
                    }
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                        layer.dialog({
                            title: '批量退回',
                            area: ['28%', '55%'],
                            content: '/reg/server/registinfo/registinfo/toBatchBack?priPID=' + ItemIds,
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
                el: '.js-batchregist',
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var index = 0;
                    var trueFlag = true;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                        var claimstate = $(this).data("claimstate");
                        if (claimstate == '0' || claimstate == '2') {
                            trueFlag = false;
                        }
                    });
                    if (!trueFlag) {
                        layer.msg("只能选择已认领的数据进行建档！", {ltype: 0, time: 1000});
                        return false;
                    }
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                        layer.dialog({
                            title: '批量建档',
                            area: ['100%', '400px'],
                            content: '/reg/server/registinfo/registinfo/toShow?fromtype=batch&archState=0&priPID=' + ItemIds,
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
                el: '.js-batchclaim',//批量认领
                event: 'click',
                handler: function () {
                    var ItemIds = new Array();
                    var claimstates = new Array();
                    var index = 0;
                    var claimIndex = 0;
                    var trueFlag = true;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ItemIds[index++] = $(this).val();
                        claimstates[claimIndex++] = $(this).data("claimstate");
                        var claimstate = $(this).data("claimstate");
                        if (claimstate == '1' || claimstate == '3') {
                            trueFlag = false;
                        }
                    });
                    if (!trueFlag) {
                        layer.msg("只能选择未认领的数据进行认领！", {ltype: 0, time: 1000});
                        return false;
                    }
                    if (ItemIds.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {
                    	layer.confirm('确定认领选中的<em style="color: red;">'+ItemIds.length+'</em>数据吗？', {
                            icon: 2,
                            title: '提示'
                        },
	                function(index) {
	             	   http.httpRequest({
	                        url: '/reg/server/registinfo/registinfo/batchClaim',
	                        data: {
	                        	priPIds:ItemIds.toString(),
	                        	claimStates:claimstates.toString()
	                        },
	                        type: 'post',
	                        success: function(data) { 
	                     	   if (data.status == 'success') {
	                                //重新加载列表数据
	                                if (data.msg) {
	                                    layer.msg("批量认领成功", {ltype: 0, time: 500});
                                        table.ajax.reload();
//	                                    layer.alert('您本次认领/接收到涉证企业信息<em style="color: red;">' + ItemIds.length + '</em>条,本年度累计认领/接收<em style="color: red;">' + data.data + '</em>条', {closeBtn: 0},
//	                                    function (index) {
//	                                        layer.close(index);
//	                                        table.ajax.reload();
//	                                    });
	                                }
	                            } else {
	                                if (data.msg) {
	                                    layer.msg(data.msg, {
	                                        time: 500
	                                    },function() {
	                                        table.ajax.reload();
	                                    });
	                                }
	                            }
	                        }
	                    });
	
	                });

//                    	layer.dialog({
//                            title: '批量认领',
//                            area: ['28%', '55%'],
//                            content: '/reg/server/registinfo/registinfo/toBatchBack?priPID=' + ItemIds,
//                            callback: function (data) {
//                                //重新加载列表数据
//                                if (data.reload) {
//                                    table.ajax.reload();
//                                }
//                            }
//                        })
                    }
                }
            },
            
            {
                el: '.js-edit',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '建档录入',
                        area: ['100%', '100%'],
                        content: '/reg/server/registinfo/registinfo/toShow?fromtype=single&archState=0&priPID=' + data.priPID,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    })
                }
            },
            {
                el: '.js-claim',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '户口建档认领',
                        area: ['70%', '50%'],
                        content: '/reg/server/registinfo/registinfo/toClaim?fromtype=claim&remainClaimState=' + data.remainClaimState + '&claimState=' + data.claimState + '&priPID=' + data.priPID,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    });

                }
            },
            {
                el: '.js-back',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '户口退回',
                        area: ['70%', '70%'],
                        content: '/reg/server/registinfo/registinfo/toClaim?fromtype=back&remainClaimState=' + data.remainClaimState + '&claimState=' + data.claimState + '&priPID=' + data.priPID,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    });
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
