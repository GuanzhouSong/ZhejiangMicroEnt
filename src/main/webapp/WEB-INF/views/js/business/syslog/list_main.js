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
    var searchParams={};//查询参数声明!
    var clickFlag = false ;
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            el: '#syslog-table',
            showIndex: true,
            scrollX:true, //支持滚动
            ajax: {
                url:'/admin/system/syslog/list.json',
                data:function(d){
                	if(clickFlag){
                		 d.params = searchParams;
                	}else{
                		
                	}
                }
            },
            columns: [
				{data: '_idx',width: '5%',className: 'center'},
				{data: 'year',width: '5%', className: 'center'},
				{data: 'regNO',width: '10%'},
				{data: 'entName',width: '19%'},
				{data: 'logEntTypeDesc',width: '10%'},
				{data: 'logType',width: '7%'},
				{data: 'logOperationDesc',width: '14%'}, 
				{data: 'setName',width: '6%'},
				{data: 'callIp',width: '10%'},
                {data: 'setTime',width: '14%'}
            ],
            columnDefs: [{
				targets:5, 
				render:function(data,type,row,meta){
					if(row.logType=="0"){
						return "企业端";
					}else if(row.logType=="1"){
						return "工商端";
					}else{
						return "";
					}
				}
			 }]
        });
    }
    
  //表格之外的查询按钮事件
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
    	clickFlag =true;
        table.ajax.reload();
    }); 
    
    //按钮事件
    function bind() {
        util.bindEvents([{
            el: '#syslog-table tr',
            event: 'click',
            handler: function () {
                var data = table.row($(this)).data();
                layer.dialog({
                    title: '日志详情页面',
                    area: ['80%', '60%'],
                    content: '/admin/system/syslog/show?sysLogId='+encodeURIComponent(data.id),
                    scrollbar: true,
                    callback: function (data) {
                    }
                });
            }
        }]);
    }
});
