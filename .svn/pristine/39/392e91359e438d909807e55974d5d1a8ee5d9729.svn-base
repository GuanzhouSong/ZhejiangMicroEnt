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
        $('#resResult').multipleSelect('setSelects',['1','2','3','4','5','6','7']);

    }


    var searchParams = {};//查询参数声明!
    var table;
    var newtable;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            //是否加索引值
            showIndex: true,
            scrollX: true, //支持滚动
            ajax: {
                url: '/reg/server/inspect/inputList.json',
                data: function (d) {
                    d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //'className'不要写成class
            columns: [
                {data: null, 'defaultContent': '11'},
                {data: null, 'defaultContent': '11'},
                {data: 'infoAuditResult'},
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
                {data: 'infoFillDate'}
            ],
            fnDrawCallback:function(nRow){
            	initTotal();
            }, 
            columnDefs: [

                {
                    targets: 1,
                    render: function (data, type, row) {
                        if (row.infoAuditResult == '5') {
                        	if(row.disposeState == '1') {
                        		return '<a href="javascript:void(0);" class="js-addAgain">续录</a>' +
                                '<a href="javascript:void(0);" class="js-detail">详情</a>';
                        	}
                        	if(row.disposeState == '2') {
                        		return '<a href="javascript:void(0);" class="js-detail">详情</a>';
                        	}
                        } else {
                        	return '<a href="javascript:void(0);" class="js-add">录入</a>';
                        }
                    }
                },
                {
                    targets: 2,
                    render: function (data, type, row, meta) {
                        if (row.infoAuditResult == '5') {
                            return '已录入';
                        }
                        return '待录入';
                    }
                },
                {
                    targets: 3,
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
                    targets: 4,
                    render: function (data, type, row, meta) {
                        if(data==null||data=='')return row.regNO;
                        else return data;
                    }
                }
            ]
        })
    }
    
  //查询结果统计
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
    


    function bind() {
        util.bindEvents([
             {
                el: '.js-add',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '年报核查录入',
                        area: ['90%', '90%'],
                        content: '/reg/server/inspect/toShow?fromtype=add&uid=' + data.uid+'&pripid='+data.priPID+'&year='+data.year,
                        callback: function (data) {
                        	table.ajax.reload();
                        }
                    })
                }
            },
            {
                el: '.js-addAgain',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    layer.dialog({
                        title: '年报核查续录',
                        area: ['90%', '90%'],
                        content: '/reg/server/inspect/toShow?fromtype=addAgain&uid=' + data.uid+'&pripid='+data.priPID+'&year='+data.year,
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
                        content: '/reg/server/inspect/toShow?fromtype=detail&uid=' + data.uid+'&pripid='+data.priPID+'&year='+data.year,
                        callback: function (data) {
                            if (data.reload) {
                                table.ajax.reload();
                            }
                        }
                    });
                }
            },
            {
                el: '.js-del',
                event: 'click',
                handler: function () {
                    var data = table.row($(this).closest('td')).data();
                    http.httpRequest({
                        url: '/reg/server/inspect/del?uid_fordelete='+data.uid,
                        serializable: true,
                        data: { },
                        type: 'post',
                        success: function (data) {
                            layer.msg(data.msg, {time: 1000}, function () {
                                table.ajax.reload();
                            })
                        }
                    })
                }
            },
            {
                el: '#js-search',
                event: 'click',
                handler: function () {
                    searchParams = $("#taskForm").serializeObject();
                    var subjectarr = [];
                    if($("input:checkbox[name='subject']:checked").length==0){
                        layer.msg('年报主体为必填项！', {time: 1000}, function () { });
                        return;
                    }
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
                    $('#resResult').multipleSelect('setSelects',['1', '2', '3', '4', '5', '6', '7']);
                    $("#regOrg").val("");
                    $("#localAdm").val("");
                    $("#sliceNO").val("");
                    $("#checkDep").val("");
                }
            }
            ,{
	            el: '#more',
	            event: 'click',
	            handler: function () { 
	            	var isHideOrShow = $("#hideorshow").is(":hidden");
	            	if(isHideOrShow){
	            		 $("#more").val("收起");
	            		 $("#hideorshow").css("display","block");
	
					}else{
						$("#more").val("更多查询条件");
	            		$("#hideorshow").css("display","none");
					}
	            }
	        }, {
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
                el: '#choseCheckDep',
                event: 'click',
                handler: function () {
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
            }, {
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
                        }
                    })
                }
            }, {
                el: '#back-history',
                event: 'click',
                handler: function () {
                    $("#div-new-history").show();
                    $("#div-new").hide();
                    table.ajax.reload();
                }
            }
        ])
    }

})
