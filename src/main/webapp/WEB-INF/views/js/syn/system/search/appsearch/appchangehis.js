require(['component/iframeLayer', 'component/dataTable', 'common/util', 'common/http', 'handlebars', 'jquery','jquery.serialize','laydate','jquery.validate','pagination'], function (layer, dataTable, util, http,handlebars) {

	var params = $("#hx-form").serializeObject();
	var table;
    init();
    /**
     * 初始化函数集合
     */
    function init() {
    	initDataTable();
    	bind();
    }
    
    
    //高管人员信息
    function initDataTable() {
    	table = dataTable.load({
		el : '#hx-table',
		showIndex: true,
		lengthMenu: [ 5, 10, 20, 50],
		ajax : {
			url : '/midaltitem/list.json' ,
			data :function(d){
				d.params = params;
			}
		},
		columns : [
			{data: '_idx', className: 'center'},
			{data: 'altContent', className: 'center'},
			{data: 'altDate', className: 'center'},
			{data: 'altBeContent', className: 'center'},
			{data: 'altAfContent', className: 'center'}
		],
		columnDefs : []
	  });
    
    	table.on('xhr.dt',function(e,settings,json,xhr){
    		if(json.recordsTotal <= 5){$('.dataTables_wrapper .bottom').hide();}else{$('.dataTables_wrapper .bottom').show();}
        })
        
	}


    
    function bind(){
    	util.bindEvents([
    	{//tab页面加载
            el: '#cancel',
            event: 'click',
            handler: function () {
            	layer.close();
            }
        }
    	])
    }
    
    
    

})
