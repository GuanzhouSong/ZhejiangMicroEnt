require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http, handlebars) {
    
	var table;
    var searchParams={};
    var searchFlag = 0 ;

	
    init();
    /**
     * 初始化函数集合
     */
    function init() {
//        initDataTable();
        bind();
    }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchFlag = 1;
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            scrollX:true,
            ajax: {
                url:'/reg/server/backup/pbepasswordList.json',
                data:function(d){
                    d.params = $("#taskForm").serializeObject();
                }
            },
            columns: [
				{data: null,defaultContent:'id',width:'24px', className: 'center'},
				{data: 'regno',width: '20px'},
				{data: 'entname',width: '20px',className: 'left'},
				{data: 'lerep', width: '20px'},
				{data: 'lerepphone',width: '20px'},
				{data: 'lianame',width: '20px'},
				{data: 'tel',width: '20px'},
				{data: 'password',width: '20px'},
				{data: 'createtime',width: '20px'},
				{data: 'regOrgName',width: '20px',className: 'left'},
				{data: 'localAdmName',width: '20px',className: 'left'}
            ],
            columnDefs : [{
				targets: 1,
                render: function (data, type, row, meta) {
                	  if(row.unicode != null && row.unicode != '' ){
                		  return row.unicode;
                	  }else{
                		  return row.regno;
                	  }
                	}
               }]
        });
    }
    
    $("#search").click(function(){
    	if(searchFlag==0){
            initDataTable();
    	}else{
            table.ajax.reload();
    	}
    }); 
    
    //按钮事件
    function bind() {}
});
