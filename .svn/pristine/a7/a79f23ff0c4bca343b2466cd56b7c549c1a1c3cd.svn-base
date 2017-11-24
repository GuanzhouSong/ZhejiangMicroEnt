require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate'], function (layer, dataTable, util, http,handlebars) {
	var searchParams;//查询参数声明!
    init();
    /**
     * 初始化函数集合
     */
    function init() {
        bind();
        initDataTable();
    }
    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	searchParams = $("#taskForm").serializeObject();
        table = dataTable.load({
            el: '#user-table',
            showIndex: true,
            aLengthMenu: [10, 25, 50, 100,1000,2000],
            scrollX:true, //支持滚动
			bScrollInfinite:true,
            ajax: {
            	type : "POST",
                url:'/reg/server/emailtaskinfo/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            columns: [
	            	{data: "_idx",width:'60px'},
	                {data: 'regNO'},
	                {data: 'entName',width:'200px',className: 'left'},
	                {data: 'estDate',width:'80px'},
	                {data: "entTypeCatgName",width:'150px',className: 'left'},
	                {data: 'email',width:'80px'},
	                {data: 'regOrgName',width:'180px',className: 'left'},
	                {data: 'localAdmName',width:'180px',className: 'left'}
            ],
            columnDefs: [
            	{
 					targets:1,
 					render:function(data,type,row,meta){
 						if(row.uniscid){
 							return row.uniscid;
 						}else{
 							return row.regNO;
 						}
 					}
 				 }
             ]
        })
    }

    //表格之外的查询按钮事件
    $("#js-search").click(function(){
    	searchParams = $("#taskForm").serializeObject();
		table.ajax.reload();
    });
    
    function bind() {
        util.bindEvents([
        ])
    }
})
