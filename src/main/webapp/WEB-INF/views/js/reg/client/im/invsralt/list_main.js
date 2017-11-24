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
            ajax: '/reg/client/im/ent/invsralt/list.json',
            buttons:[],
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: 'inv', width: '100px'},
                {data: 'beTransAmPr'},
                {data: 'afTransAmPr'},
                {data: 'equAltDate'},
              
                {data: 'pubFlag', width: '150px'},
                {data: null, width: '120px', className: 'center'}
            ],
            columnDefs: [
                         {
                        	targets:1,
                        	render:function(data,type,row,meta){
                        		return row.beTransAmPr+"%";
                        	}
                        	
                         },
                         {
                        	targets:2,
                        	render:function(data,type,row,meta){
                        		return row.afTransAmPr+"%";
                        	}
                         },
                         {
                        	targets:3,
                        	render:function(data,type,row,meta){
                        		if(row.equAltDate!=null&&row.equAltDate!=""){
                        		  var date=row.equAltDate.split("-");
                        		return date[0]+"年"+date[1]+"月"+date[2]+"日";
                        	}
                        	}
                         },
                         
                         {
                        	targets:4,
                        	render:function(data,type,row,meta){
                        		if(row.pubFlag=="0"){
                        			return "未公示";
                        		}else{
                        			return "已公示";
                        		}
                        	}
                         },
                {
                    targets: 5,
                    render: function (data, type, row, meta) {
                    	 var context;
                    	if(row.pubFlag=="0"){
                    	
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
                  location.href="/reg/client/im/ent/invsralt/show";
             
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                   location.href="/reg/client/im/ent/invsralt/show?invAltID="+data.invAltID+"&pubFlag="+data.pubFlag;
                  }
        }, 
         {
        	el:"#pubAll",
        	event:'click',
        	handler:function(){
        		http.httpRequest({
        			url:"/reg/client/im/ent/invsralt/pubAll",
        			success:function(data){
        				layer.msg(data.msg,{time:500},function(){
        					table.ajax.reload();
        				});
        			}
        		});
        	}
         },
         {
			 el:'#close',
			 event:'click',
			 handler:function(){ 
				 javascript:window.opener=null;window.close();
			 }
		 },
		 {
	            el: '#print',
	            event: 'click',
	            handler: function () {
	                var _id = "_doPrint_"+new Date().getTime();
	                var priPID="";
	                var url = "/reg/client/im/ent/invsralt/print?priPID="+priPID;
	                try{
	                    window.open(url, _id, "menubar=no,location=no,resizable=no,scrollbars=yes,status=no");
	                }catch(e){
	                    alert("打印错误!");
	                }
	            }
	        },
		 
        {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/client/im/ent/invsralt/delete',
                        data: {invAltID:data.invAltID},
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
        }])
    }

})
