require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http',
    'handlebars', 'jquery', 'jquery.serialize', 'laydate', 'jquery.multiselect'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
        $("#resResult").multipleSelect({
            selectAllText: '全部',
            allSelected: '全部',
            selectAllDelimiter: '',
            minimumCountSelected: 10
        });
        $('#resResult').multipleSelect('setSelects', [ '1', '2', '3', '4', '5', '6', '7']);

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
                url: '/reg/server/inspect/checkList.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null, 'defaultContent': '11'},
                {data: 'disposeState'},
                {data: 'uniCode'},
                {data: 'entName','className': 'left'},
                {data: 'estDate'},
                {data: 'year'},
                {data: 'infoCheckDate'},
                {data: 'resResult',cut:{length:20,mark:'...'}},
                {data: 'infoCheckMan'},
                {data: 'departName'},
                {data: 'regOrgName','className': 'left'},
                {data: 'localAdmName','className': 'left'},
                {data: 'sliceNOName','className': 'left'},
                {data: 'infoFillMan'},
                {data: 'infoFillDate'},
                {data: 'modName'},
                {data: 'modTime'}
            ],
            columnDefs: [

                {
                    targets: 1,
                    render: function (data, type, row) {
                        if (row.infoAuditResult == '5') {
                            return '<a href="javascript:void(0);" class="js-edit">修改</a>'+
                            '<a href="javascript:void(0);" class="js-detail">详情</a>';
                        }
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                    	if (row.infoAuditResult == '5') {
                    		if (row.disposeState == '1') {
                                return '未完结';
                            } else if (row.disposeState == '2') {
                                return '已完结';
                            }
                    	}else{
                    		return '-';
                    	}
                    }
                },
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        if(data==null||data=='')return row.regNO;
                        else return data;
                    }
                }
            ],
            "drawCallback": function (settings) {
                initTotal();
            }
        })
    }
    
  //draw事件，查询结果统计
    function initTotal(){
    	var totalParams = $("#taskForm").serializeObject();
        var subjectarr = [];
        $("input:checkbox[name='subject']:checked").each(function () {
            subjectarr.push($(this).val());
        });
        totalParams.subject = subjectarr.toString();
        totalParams.resResult = $("#resResult").multipleSelect('getSelects').toString();
        //检查结果全选，置为空，全选效果与不选一样，但影响到后台逻辑判断。
        if(totalParams.resResult=='1,2,3,4,5,6,7'){
            totalParams.resResult='';
        }
        http.httpRequest({
            url: "/reg/server/inspect/total.json",
            serializable: true,
            data: totalParams,
            type: 'post',
            success: function (data) {
            	$("#infoAuditResult5Total,#disposeState1Total,#disposeState2Total").html("").text("0");
            	$("#disposeState1Total").html("").text(data.disposeState1);
            	$("#disposeState2Total").html("").text(data.disposeState2);
            	$("#infoAuditResult5Total").html("").text(data.disposeState1 + data.disposeState2);
            }
        });
    }
    
 // 部门单选
    function doSelectDept() {
        var select_dept_url = window._CONFIG.select_dept_url;
        layer.dialog({
            title: '选择部门',
            area: ['350px', '666px'],
            content: select_dept_url,
            callback: function (data) {
                if (data.deptCode != null && data.deptName != null) {
                    $("#checkDepName").val(data.deptName);
                    $("#checkDep").val(data.deptId);
                }
            }
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
                        title: '年报核查修改',
                        area: ['90%', '90%'],
                        content: '/reg/server/inspect/toShow?fromtype=edit&uid=' + data.uid + '&pripid=' + data.priPID + '&year=' + data.year,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    });

                }
            },
            {
                el: '.js-detail',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '年报核查详情',
                        area: ['90%', '90%'],
                        content: '/reg/server/inspect/toShow?fromtype=detail&uid=' + data.uid + '&pripid=' + data.priPID + '&year=' + data.year,
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
                    searchParams = $("#taskForm").serializeObject();
                    var subjectarr = [];
                    var resresultarr = [];
                    $("input:checkbox[name='subject']:checked").each(function () {
                        subjectarr.push($(this).val());
                    });
                    searchParams.subject = subjectarr.toString();
                    searchParams.resResult = $("#resResult").multipleSelect('getSelects').toString();
                    //检查结果全选，置为空，全选效果与不选一样，但影响到后台逻辑判断。
                    if(searchParams.resResult=='1,2,3,4,5,6,7'){
                        searchParams.resResult='';
                    }
                    table.ajax.reload();
                }
            },
            {
                el: '#cancel',
                event: 'click',
                handler: function () {
                    $('#taskForm')[0].reset();
                    $('#resResult').multipleSelect('setSelects', ['1', '2', '3', '4', '5', '6','7']);
                    $("#regOrg").val("");
                    $("#localAdm").val("");
                    $("#sliceNO").val("");
                    $("#checkDep").val("");
                }
            },{
                el: '.js-more-query',
                event: 'click',
                handler: function () {
                	if($('.more-show').css("display")=="none"){
                		$('.js-more-query').attr('value','收起');
                		$('.more-show').css("display","block");
                	}else{
                		$('.js-more-query').attr('value','更多查询');
                		$('.more-show').css("display","none");
                	}
                }
            }
            , {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['25%', '60%'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck?isPermissionCheck=true',
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
                        content: '/commom/server/regunit/regunitmutiselectnocheck?isPermissionCheck=true',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#localAdm").val(data.returncode);
                            $("#localAdmName").val(data.returnname);
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
                        content: '/commom/server/sliceno/slicenomutiselectnocheck?isPermissionCheck=true',
                        callback: function (data) {
                            //重新加载列表数据
                            $("#sliceNO").val(data.returncode);
                            $("#sliceNoName").val(data.returnname);
                            table.ajax.reload();
                        }
                    })
                }
            },

            {
                el: '#choseCheckDep',
                event: 'click',
                handler: function () {
                    if ($('#fromtype').val() != 'detail')
                        doSelectDept();
                }
            }
        ])
    }

})
