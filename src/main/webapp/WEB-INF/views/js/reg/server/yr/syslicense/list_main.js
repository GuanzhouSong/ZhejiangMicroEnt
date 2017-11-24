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
    var clickFlag = false ;
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#syslicence-table',
            //是否加索引值
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/reg/server/yr/syslicense/list.json',
                data:function(d){
                	if(clickFlag){
	               		 d.params = searchParams;
	               	}else{
	               		
	               	}
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, width:'40px', className: 'center'},
                {data: null, width:'70px', className: 'center'},
                {data: 'licName', width:'200px', className: 'left'},
                {data: 'licNO', width:'80px', className: 'center'},
                {data: 'licDeptType', width:'100px', className: 'center'},
                {data: 'licDept', width:'200px', className: 'left'},
                {data: 'licRea', width:'500px', className: 'left'},
                {data: 'licZone', width:'100px', className: 'center'},
                {data: 'licType', width:'80px', className: 'center'},
                {data: 'setName', width:'70px', className: 'center'},
                {data: 'isValid', width:'80px', className: 'center'}
            ],
            columnDefs: [
				{
					targets:8,
					render:function(data,type,row,meta){
						if(row.licType=="1"){
							return "前置";
						}else{
							return "后置";
						}
					}
				 },
				{
					targets:10,
					render:function(data,type,row,meta){
						if(row.isValid=="0"){
							return "无效";
						}else{
							return "有效";
						}
					}
				 },
                {
                    targets: 1, 
                    render: function (data, type, row, meta) {
                    	return "<a href='#' class='mr10 js-edit'>修改</a><a href='#' class='js-delete'>删除</a>";
                    }
                }
            ]
        })
    }

    //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag =true;
        table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
            	window.location.href='/reg/server/yr/syslicense/show';
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                window.location.href='/reg/server/yr/syslicense/show?sysLicenseId=' + data.id;
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/reg/server/yr/syslicense/delete',
                        data: {sysLicenseId: data.id},
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
