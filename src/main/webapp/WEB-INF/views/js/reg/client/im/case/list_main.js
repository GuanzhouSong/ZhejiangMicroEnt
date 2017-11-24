require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery'], function (layer, dataTable, util, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
    	$("#permit-table_info").hide();
        bind();
    }


    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#permit-table',
            bPaginate : false, 
            ajax: '/reg/client/im/ent/case/list.json',
            buttons:[],
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: 'judAuth', width: '162px'},
                {data: 'penDecNo',width: '182px'},
                {data: 'penDecIssDate',width: '145px'},
                {data: 'illegActType'},
                {data: 'penTypeCN'},
                {data: 'pubFlag'},
                {data: null, width: '80px', className: 'center'}
            ],
            columnDefs: [
                         {
                        	targets:2,
                        	render:function(data,type,row,meta){
                        		if(row.penDecIssDate!=null&&row.penDecIssDate!=""){
                        		var date=row.penDecIssDate.split("-");
                        		return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        		}else{
                        			return "";
                        		}
                        	}
                         },
                         
                         
                         {
                        	targets:5,
                        	render:function(data,type,row,meta){ 
                        		if(row.pubFlag=="2"){
                        			return "未公示";
                        		}
                        		if(row.pubFlag=="0"){
                        			return "未公示";
                        		}
                        		if(row.pubFlag=="1"){
                        			return "已公示";
                        		}
                        		 
                        	}
                         },
                {
                    targets: 6,
                    render: function (data, type, row, meta) {
                    	 var context;
                    	if(row.pubFlag=="2"){
                    	
                         context = {
                            func: [
                                {
                                    'text': '修改',
                                    'class': 'btn btn-xs btn-primary js-edit'
                                },
                                {
                                    'text': '删除',
                                    'class': 'btn btn-xs btn-danger js-delete'
                                }
                            ]
                        };}else{
                        	 context = {
                                     func: [
                                         {
                                             'text': '修改',
                                             'class': 'btn btn-xs btn-primary js-edit'
                                         } 
                                     ]
                                 };
                        }
                        return template(context);
                    }
                }
            ]
        })
    }

    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
            	location.href="/reg/client/im/ent/case/show";
                /*layer.dialog({
                    title: '新增用户',
                    area: ['628px', '500px'],
                    content: '/reg/client/im/case/show',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })*/
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                var url=encodeURI("/reg/client/im/ent/case/show?caseNO="+data.caseNO+"&pubFlag="+data.pubFlag);
                location.href=url;
               /* layer.dialog({
                    title: '编辑用户',
                    area: ['628px', '500px'],
                    content: '/reg/client/im/case/show?caseNO=' +data.caseNO+"&pubFlag="+data.pubFlag,
                    callback: function (data) {
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }*/
            }
        },
        {
        	el:"#pubAll",
        	event:'click',
        	handler:function(){
        		http.httpRequest({
        			url:"/reg/client/im/ent/case/pubAll",
        			success:function(data){
        				layer.msg(data.msg,{time:500},function(){
        					table.ajax.reload();
        				});
        			}
        		});
        	}
        },
        
        
        {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                  layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/client/im/ent/case/delete',
                        data: {caseNO:data.caseNO},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }else if(data.status=="fail"){
                            	if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
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
            handler: function () {
                var _id = "_doPrint_"+new Date().getTime();
                var priPID="";
                var url = "/reg/client/im/ent/case/print?priPID="+priPID;
                try{
                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
                }catch(e){
                    alert("打印错误!");
                }
            }
        }
        ])
    }

})
