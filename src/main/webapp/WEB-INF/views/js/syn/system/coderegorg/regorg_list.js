require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {

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
            el: '#user-table',
			showIndex: true,
			scrollX:true, //支持滚动
            ajax: {
                url:window._CONFIG.chooseUrl+'/regorg/regorgList.json',
                data:function(d){
                   d.params = searchParams;
                }
            },
            columns: [
                {data: null,defaultContent:'id',width:"50px", className: 'center'},
                {data: null,defaultContent:'priPId',width:"100px", className: 'center'},
                {data: 'code',width:"150px"}, 
                {data: 'content',width:"250px"},
                {data: 'contentShort',width:"300px"},
                {data: 'liaName',width:"150px"},
                {data: 'liaPhone',width:"80px"} 
            ],
             columnDefs : [
							{
								targets: 1,
							    render: function (data, type, row, meta) {
							    	return '<a href="javascript:void(0);" class="mod">修改</a>'+
							    	'&nbsp<a href="javascript:void(0);" class="view">查看</a>';
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
        util.bindEvents([
        {
            el: '.mod',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                    title: '修改',
                    area: ['70%', '35%'],
                    content: window._CONFIG.chooseUrl+'/regorg/regorgView?regOrgCode='+data.code+'&type=1',
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        },
        {
            el: '.view',
            event: 'click',
            handler: function () { 
            	var data = table.row($(this).closest('td')).data();
                 layer.dialog({
                    title: '查看',
                    area: ['70%', '35%'],
                    content: window._CONFIG.chooseUrl+'/regorg/regorgView?regOrgCode='+data.code+'&type=0',
                    callback: function (data) {
                    	 if (data.reload) { //close是否有传递此参数
                             table.ajax.reload();
                         }
                    }
                })
            }
        }
        ])
    }

})
