require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var searchParams={};//查询参数声明!
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#sysforbid-table',
            //是否加索引值
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/yr/sysforbidword/list.json',
                data:function(d){
                	searchParams = $("#taskForm").serializeObject();
               		 d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className: 'center'},
                {data: null, className: 'center'},
                {data: 'banLetter', className: 'center'},
                {data: 'banExp', className: 'left'},
                {data: 'isValid', className: 'center'},
                {data: 'setName', className: 'center'},
                {data: 'setTime', className: 'center'}
            ],
            columnDefs: [
				{
					targets:4,
					render:function(data,type,row,meta){
						if(row.isValid=="0"){
							return "无效";
						}else{
							return "有效";
						}
					}
				 },{
						targets:3,
						render:function(data,type,row,meta){
							if(row.banExp){
								if(row.banExp.length>35){
									var newBanExp=row.banExp.substring(0,35)+"...";
									return "<span title='"+row.banExp+"'>"+newBanExp+"</span>";
								}else{
									return row.banExp;
								}
							}else{
								return row.banExp;
							}
						}
				},{
					targets:2,
					render:function(data,type,row,meta){
						if(row.banLetter){
							if(row.banLetter.length>15){
								var newBanLetter=row.banLetter.substring(0,15)+"...";
								return "<span title='"+row.banLetter+"'>"+newBanLetter+"</span>";
							}else{
								return row.banLetter;
							}
						}else{
							return row.banLetter;
						}
					}
			},{
                    targets: 1,
                    render: function (data, type, row, meta) {
                    	//<a href='#' class='js-delete'>删除</a>
                    	var str;
                    	if(row.isValid=='1'){
                    		str = "<a href='#' class='js-isAbled'>禁用</a> <a href='#' class='mr10 js-edit'>修改</a>";
                    	}else{
                    		str = "<a href='#' class='js-isAbled'>启用</a> <a href='#' class='mr10 js-edit'>修改</a>";
                    	}
                    	
                    	return str;
                    }
                }
            ]
        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/yr/sysforbidword/show';
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                window.location.href='/reg/server/yr/sysforbidword/show?sysForbidwordId=' + data.id;
            }
        }, {
            el: '.js-isAbled',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                http.httpRequest({
                    url: '/reg/server/yr/sysforbidword/doAbled?isValid=' + data.isValid+"&sysForbidwordId="+data.id,
                    success: function (data) {
                        if (data.status == 'success') {
                            //重新加载列表数据
                            if (data.msg) {
                                layer.msg(data.msg, {time: 500}, function () {
                                    table.ajax.reload();
                                });
                            }
                        }
                    }
                });
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/yr/sysforbidword/delete',
                        data: {sysForbidwordId: data.id},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
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
