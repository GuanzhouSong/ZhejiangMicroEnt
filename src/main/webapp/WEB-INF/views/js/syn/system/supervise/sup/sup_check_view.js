require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate'], function (layer, dataTable, util, http,handlebars) {
    
	var table;
	
	
	init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
    	bind();
    }
    
    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#hx-table',
			scrollX:true, //支持滚动
            showIndex: true,
            lengthMenu: [ 5, 10, 20, 50, 100 ],
            ajax: {
                url:'/syn/supervise/doQueryListPage',
                data:function(d){
                	d.params = $("#search-form").serializeObject();
                }
            },
            columns: [
                {data: null, className: 'center'},
                {data: 'batchNO', className: 'center'},
                {data: 'entName', className: 'center'},
                {data: 'regNO', className: 'center'},
                {data: 'uniscid', className: 'center'},
                {data: 'leRep', className: 'center'},
                {data: 'entType', className: 'center'},
                {data: 'industryCo', className: 'center'},
                {data: 'dom', className: 'center',cut:{length:20,mark:'...'}},
                {data: 'regOrgName', className: 'center'},
                {data: 'localAdmName', className: 'center'}
            ],
             columnDefs : []
        })
    }
    
    
    function bind(){
    	util.bindEvents([
    	{
    		 el: '#back',
             event: 'click',
             handler: function () {
             	layer.close();
             }
        }
    ]);
    	
    }
    
    
})
