require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;

    var params = {};//表格查询参数

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#entTable',
            scrollX:true, //支持滚动
            showIndex: true,
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
                {data: null, className: 'center',width:"50px"},
                {data: null, 'className': 'center',width:"60px"},
                {data: 'regNO',width:"100px"},
                {data: 'entName',width:"200px"},
                {data: 'leRep',width:"100px"},
                {data: 'tel',width:"100px"},
                {data: 'estDate',width:"100px"},
                {data: 'entTypeName',width:"150px"},
                {data: 'dom',width:"300px"},
                {data: 'regOrgName',width:"200px"},
                {data: 'localAdmName',width:"100px"},
                {data: 'checkDepName',width:"100px"}

            ],
            columnDefs: [
                {   targets:1,
                    render:function(data,type,row,meta){
                        return  '<input type="checkbox" name="_checkbox" data-uid="'+row.uid+'" data-registstate="'+row.registState+'" value='+row.priPID+'>';
                    }
                }
            ]
        })
    }
    function bind() {
        util.bindEvents([
            {
                el: '#checkAll',
                event: 'click',
                handler: function () {
                    var flag = $(this).prop("checked");
                    $("input:checkbox[name='_checkbox']").prop("checked", flag);
                }
            },
            {
                el: '#assign',
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

                        layer.dialog({
                            title: '指定分配',
                            area: ['688px', '777px'],
                            content: '/reg/server/entdbauth/select_dept_user?priPIDs=' + ids,
                            callback: function (data) {
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }
                        })
                    }
                }
            }
            ,
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
