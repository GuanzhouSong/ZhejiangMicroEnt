require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize'],
function(layer, dataTable, util, http, handlebars) {
    var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        $("#permit-table_info").hide();
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
            bPaginate: false,
            el: '#permit-table',
            ajax: {
                type : "POST",
                url:'/reg/client/im/ent/investment/list.json',
                data:function(d){
                    d.params = $("#key_parmas").serializeObject();
                }
            },
            buttons:[],
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [{
                data: 'inv',
                width: '100px'
            },
            {
                data: 'liSubConAm'
            },
            {
                data: 'liAcConAm'
            },
            {
                data: null,
                width: '180px',
                className: 'valign-top'
            },
            {
                data: null,
                width: '180px',
                className: 'valign-top'
            },
            {
                data: null,
                width: '30px',
                className: 'center'
            }],
            columnDefs: [{
                targets: 3,
                render: function(data, type, row, meta) {
                    var myTemplate = handlebars.compile($("#prv-template").html());
                    handlebars.registerHelper("trsPubFlag",
                    function(value) {
                        if (value == "1") {
                            return "公示";
                        } else {
                            return "未公示";
                        }
                    });
                   
                    handlebars.registerHelper("transDate",
                            function(value) {
                               var date=value.split("-");
                               return date[0]+"年"+date[1]+"月"+date[2]+"日";
                            });
                    
                    
                    
                    var data = row.imInvprodetailList;
                    var object = new Object();
                    object.data = data;
                    return myTemplate(object);

                }
            },

            {
                targets: 4,
                render: function(data, type, row, meta) {
                    var myTemplate = handlebars.compile($("#act-template").html());
                    var data = row.imInvactdetailList;
                    handlebars.registerHelper("transDate",
                            function(value) {
                               var date=value.split("-");
                               return date[0]+"年"+date[1]+"月"+date[2]+"日";
                            });
                    
                    var object = new Object();
                    object.data = data;
                    return myTemplate(object);
                }
            },
            {
                targets: 5,
                render: function(data, type, row, meta) {
                    var context;
                    context = {
                        func: [{
                            'text': '修改',
                            'class': 'btn btn-xs btn-primary js-edit'
                        },
                        {
                            'text': '删除',
                            'class': 'btn btn-xs btn-danger js-delete'
                        }]
                    };
                    return template(context);
                }
            }]
        })
    }

    function bind() {
        util.bindEvents([
            {
                el:'#key_btn',   //搜索
                event:'click',
                handler:function(){
                  var keyValue = $("#key_value").val();//获取输入框中的值
                  if(!keyValue){
                      $("#key_name").val('');
                  }else{
                      $("#key_name").val($.trim(keyValue));
                  }
                  table.ajax.reload();
                }
            },
            {
            el: '.js-add',
            event: 'click',
            handler: function() {
                location.href = "/reg/client/im/ent/investment/show";
                /* layer.dialog({
                    title: '新增用户',
                    area: ['828px', '500px'],
                    content: '/reg/client/im/investment/show',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })*/
            }
        },
            {
                el: '#pubAll',
                event: 'click',
                handler: function () {
                    http.httpRequest({
                        url: '/reg/client/im/ent/investment/pubAll',
                        serializable: false,
                        type: 'post',
                        success: function (data) {
                            if(data.status=="success"){
                                layer.msg("公示成功！", { time: 1000 },function () {
                                    table.ajax.reload();
                                });
                            }else if(data.errorCode=="compareFlg"){
                                layer.msg("所有股东的应缴出资总额应与公司注册资本额相等，请确认填写是否正确。公司注册资本有变动，请及时到工商部门办理变更登记。",
                                    { time: 3000 },function () {
                                    table.ajax.reload();
                                });
                            }else{
                                layer.msg(data.msg, { time: 1000 },function () {
                                    table.ajax.reload();
                                });
                            }

                        }
                    })

                }
            },

        {
            el: '.js-edit',
            event: 'click',
            handler: function() {
                var data = table.row($(this).closest('td')).data();
                location.href = "/reg/client/im/ent/investment/show?id=" + data.invID;
                /* layer.dialog({
                    title: '编辑用户',
                    area: ['628px', '500px'],
                    content: '/reg/client/im/investment/show?id=' +data.invID,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })*/
            }
        },
        {
            el: '.js-delete',
            event: 'click',
            handler: function() {

                var data = table.row($(this).closest('td')).data();
                 layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                http.httpRequest({
                    url: '/reg/client/im/ent/investment/delete',
                    data: {
                        invId: data.invID
                    },
                    success: function(data) {
                        if (data.status == 'success') {
                            //重新加载列表数据
                            if (data.msg) {
                                layer.msg(data.msg, {
                                    time: 500
                                },
                                function() {
                                    table.ajax.reload();
                                });
                            }
                        } else if (data.status == "fail") {
                            if (data.msg) {
                                layer.msg(data.msg, {
                                    time: 500
                                },
                                function() {
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
        	el:"#close",
        	event:'click',
        	handler:function(){
        		window.close();
        	}
        },
            {
                el: '#print',
                event: 'click',
                handler: function() {
                    var _id = "_doPrint_"+new Date().getTime();
                    var priPID="";
                    var url = "/reg/client/im/ent/investment/print?priPID="+priPID;
                    try{
                        window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                    }catch(e){
                        alert("打印错误!");
                    }
                }
            }
        ])
    }

});



