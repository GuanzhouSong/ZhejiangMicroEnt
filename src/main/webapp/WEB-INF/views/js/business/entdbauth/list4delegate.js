require(['common/util','component/iframeLayer', 'component/dataTable',  'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (util,layer, dataTable, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }

    var table;
    var params = {'isNeedDelagate':'1'};//表格查询参数

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX:true, //支持滚动
            ajax: {
                type:"get",
                url:'/reg/server/entdbauth/list.json',
                data:function(d){
                    d.params = params;

                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: "_idx",width:'60px',className:'center'},
                {data: null, width:'60px','className': 'center'},
                {data: 'regNO',width:'140px',className:'center'},
                {data: 'entName',width:'200px',className:'center'},
                {data: 'delegateOrgName',width:"100px"},
                {data: 'regOrgName',width:'170px'},
                {data: 'localAdmName',width:'120px'},
                {data: 'leRep',width:'100px',className:'center'},
                {data: 'estDate',width:'140px',className:'center'},
                {data: 'entTypeName',width:'140px'},
                {data: 'dom',width:'200px'}

            ],
            columnDefs: [
                {   targets:1,
                    render:function(data,type,row,meta){
                        return  '<input type="checkbox" delegateOrg="'+row.delegateOrg+'" name="_checkbox" data-uid="'+row.uid+'" data-registstate="'+row.registState+'" value='+row.priPID+'>';
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el: '#search',
                event: 'click',
                handler: function () {
                    params = $("#taskForm").serializeObject();
                    table.ajax.reload();
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
            //设置委托
            {
                el: '#setDelegate',
                event: 'click',
                handler: function () {
                    var ids = new Array();
                    var index = 0;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ids[index++] = $(this).val();
                    });
                    if (ids.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 500});
                        return false;
                    }
                    else {

                        layer.confirm('确定要为选中的企业设置委托吗?（委托机关为企业管辖单位所在登记机关）', {icon: 2, title: '提示'}, function (index) {
                            http.httpRequest({
                                url: '/reg/server/entdbauth/delegate',
                                data: {priPIDs: ids.toString()},
                                success: function (data) {
                                    layer.msg(data.msg, {time: 1000}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            });
                        });
                    }
                }
            },
            //取消委托
            {
                el: '#cancleDelegate',
                event: 'click',
                handler: function () {
                    var ids = new Array();
                    var delegateOrgArr=new Array();
                    var index = 0;
                    $(":checkbox[name=_checkbox]:checked").each(function () {
                        ids[index++] = $(this).val();
                        if($(this).attr("delegateOrg")!="null"&&$(this).attr("delegateOrg")!=""&&$(this).attr("delegateOrg")!=undefined&&$(this).attr("delegateOrg")!="undefined"){
                            delegateOrgArr.push($(this).attr("delegateOrg"));
                        }
                    });
                    if (ids.length == 0) {
                        layer.msg("请选择一项进行操作", {ltype: 0, time: 5000});
                        return false;
                    }
                    if (ids.length > delegateOrgArr.length) {
                        layer.msg("勾选的企业中存在没有委托的企业", {ltype: 0, time: 5000});
                        return false;
                    }
                    if (delegateOrgArr.length==0) {
                        layer.msg("勾选的企业中不存在已委托的企业", {ltype: 0, time: 5000});
                        return false;
                    }

                    else {
                        layer.confirm('确定要取消选中的企业委托信息吗?（委托机关为企业管辖单位所在登记机关）', {icon: 2, title: '提示'}, function (index){
                            http.httpRequest({
                                url: '/reg/server/entdbauth/cancle_delegate',
                                data: {priPIDs: ids.toString()},
                                success: function (data) {
                                    layer.msg(data.msg, {time: 1000}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            });
                        });

                    }
                }
            },
            {
                el: '#choseregUnit',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择管辖单位',
                        area: ['400px', '600px'],
                        content: '/commom/server/regunit/regunitmutiselectnocheck',
                        callback: function (data) {
                            var returncode=data.returncode;
                            if(returncode!=null&&returncode!=""){
                                returncode=returncode.substr(0,returncode.length-1);
                            }
                            $("#localAdm").val(returncode);
                            $("#localAdmName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#choseorgReg',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择登记机关',
                        area: ['400px', '600px'],
                        content: '/commom/server/regorg/regorgmutiselectnocheck',
                        callback: function (data) {
                            var returncode=data.returncode;
                            if(returncode!=null&&returncode!=""){
                                returncode=returncode.substr(0,returncode.length-1);
                            }
                            $("#regOrg").val(returncode);
                            $("#regOrgName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#chooseEntType',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择企业类型',
                        area: ['400px', '600px'],
                        content: '/commom/server/entcatg/entcatgmutiselect',
                        callback: function (data) {
                            var returncode=data.returncode;
                            if(returncode!=null&&returncode!=""){
                                returncode=returncode.substr(0,returncode.length-1);
                            }
                            $("#entType").val(returncode);
                            $("#entTypeName").val(data.returnname);
                        }
                    })
                }
            }, {
                el: '#chooseSliceNo',
                event: 'click',
                handler: function () {
                    layer.dialog({
                        title: '选择片区',
                        area: ['400px', '600px'],
                        content: '/commom/server/sliceno/slicenomutiselectnocheck',
                        callback: function (data) {
                            var returncode=data.returncode;
                            if(returncode!=null&&returncode!=""){
                                returncode=returncode.substr(0,returncode.length-1);
                            }
                            $("#sliceNo").val(returncode);
                            $("#sliceNoName").val(data.returnname);
                        }
                    })
                }
            }
        ])
    }

})
