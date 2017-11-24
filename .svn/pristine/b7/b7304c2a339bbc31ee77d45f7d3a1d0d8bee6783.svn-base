require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
	var searchFlag="0";
	var table;
    var searchParams={};
	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = "1";
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#syslog-table',
            showIndex: true,
            scrollX:true,
            ajax: {
                url:'/admin/system/syslog/list.json',
                data:function(d){
                    d.params = searchParams;
                }
            },
            columns: [
				{data: '_idx',width: '8%',className: 'center'},
				{data: 'regNO',width: '15%'},
				{data: 'entName',width: '15%'},
				{data: 'logMsg',width: '30%'}, 
                {data: 'setTime',width: '15%'}
            ],
            columnDefs : [{
				targets: 3,
                render: function (data, type, row, meta) {
                	 var data = row.logMsg;
                	 if(data && (data.length > 53)){
                            $(table.cell( meta.row, meta.col ).node()).attr('title',data);
                            return (data.substr( 0, 53 )+'....');
                      }
                	 return row.logMsg;
                	}
               }]
        });
    }
    
    $("#search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
     	if(searchFlag=="0"){
    		initDataTable();
    	}else{
    		table.ajax.reload();
    	}
    }); 
    
    //按钮事件
    function bind() {}
});
